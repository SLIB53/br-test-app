package brtestapp.storage;

import brtestapp.lib.data.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class BRTestAppStore {
    private ConcurrentMap<Long, Show> Shows;
    private ConcurrentMap<Long, Asset> Assets;

    public BRTestAppStore() {
        Shows = new ConcurrentHashMap<Long, Show>();
        Assets = new ConcurrentHashMap<Long, Asset>();
    }

    public Show createShow(String name, String description) {
        Show s;

        synchronized (Shows) {
            s = new Show(GenShowId(), name, description);

            Shows.put(s.GetId(), s);
        }

        return s;
    }

    public Show getShow(long showId) {
        return Shows.get(showId);
    }

    public Asset createVideoAsset(
            long ownerShowId,
            String name,
            String url,
            long expiration,
            String videoType
    ) {
        return createAsset(ownerShowId, name, "video", url, expiration, new VideoAssetMeta(videoType));
    }

    public Asset createImageAsset(
            long ownerShowId,
            String name,
            String url,
            long expiration,
            Long baseImageAssetId
    ) {
        return createAsset(ownerShowId, name, "image", url, expiration, new ImageAssetMeta(baseImageAssetId));
    }

    public Asset createAdAsset(
            long ownerShowId,
            String name,
            String url,
            long expiration,
            String productDescription
    ) {
        return createAsset(ownerShowId, name, "ad", url, expiration, new AdAssetMeta(productDescription));
    }

    private Asset createAsset(
            long ownerShowId,
            String name,
            String type,
            String url,
            long expiration,
            AssetMeta metadata
    ) {
        Asset a;

        synchronized (Assets) {
            a = new Asset(GenAssetId(), ownerShowId, name, type, url, expiration, metadata);

            Assets.put(a.getId(), a);
        }

        return a;
    }

    public List<Asset> listAssetsByShow(long showId) {
        return Assets.values().stream()
                .filter(asset -> showId == asset.getOwnerShowId())
                .collect(Collectors.toList());
    }

    private long GenShowId() throws RuntimeException {
        return GenRecordId(Shows.keySet());
    }

    private long GenAssetId() throws RuntimeException {
        return GenRecordId(Assets.keySet());
    }

    private static long GenRecordId(Set<Long> m) throws RuntimeException {
        long newIdCandidate;

        for (int i = 1; ; i++) {
            newIdCandidate = UUID.randomUUID().getLeastSignificantBits();
            if (!m.contains(newIdCandidate))
                break;
            else if (i == 5)
                throw new RuntimeException();
        }

        return newIdCandidate;
    }
}
