package brtestapp.storage;

import brtestapp.lib.data.*;
import brtestapp.storage.store.AssetStore;
import brtestapp.storage.store.ShowStore;

import java.util.List;

/**
 * A mock thread-safe database.
 */
public class BRTestAppStore {
    private final ShowStore showStore;
    private final AssetStore assetStore;

    public BRTestAppStore() {
        showStore = new ShowStore();
        assetStore = new AssetStore();
    }

    public Show createShow(String name, String description) {
        return showStore.createShow(name, description);
    }

    public Show getShow(long showId) {
        return showStore.getShow(showId);
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
        return assetStore.createAsset(ownerShowId, name, type, url, expiration, metadata);
    }

    public List<Asset> listAssetsByShow(long showId) {
        return assetStore.listAssetsByShow(showId);
    }
}
