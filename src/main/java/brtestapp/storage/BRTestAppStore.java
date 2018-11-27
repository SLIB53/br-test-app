package brtestapp.storage;

import brtestapp.lib.data.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * A mock thread-safe database.
 */
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
            s = new Show(generateShowId(), name, description);

            Shows.put(s.getId(), s);
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
            a = new Asset(generateAssetId(), ownerShowId, name, type, url, expiration, metadata);

            Assets.put(a.getId(), a);
        }

        return a;
    }

    public List<Asset> listAssetsByShow(long showId) {
        return Assets.values().stream()
                .filter(asset -> showId == asset.getOwnerShowId())
                .collect(Collectors.toList());
    }

    private long generateShowId() throws RuntimeException {
        return generateIdFromSet(Shows.keySet());
    }

    private long generateAssetId() throws RuntimeException {
        return generateIdFromSet(Assets.keySet());
    }

    private static long generateIdFromSet(Set<Long> m) throws RuntimeException {
        var uuid = UUID.randomUUID();

        if (!m.contains(uuid.getLeastSignificantBits()))
            return uuid.getLeastSignificantBits();
        else if (!m.contains(uuid.getMostSignificantBits()))
            return uuid.getLeastSignificantBits();
        else
            throw new RuntimeException("Collision detected when generating a new id. Try again.");
    }
}
