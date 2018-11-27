package brtestapp.storage.store;

import brtestapp.lib.data.Asset;
import brtestapp.lib.data.AssetMeta;

import java.util.List;
import java.util.stream.Collectors;

public final class AssetStore extends ItemStore<Asset> {
    public Asset createAsset(
            long ownerShowId,
            String name,
            String type,
            String url,
            long expiration,
            AssetMeta metadata
    ) {
        Asset a;

        synchronized (items) {
            a = new Asset(generateId(), ownerShowId, name, type, url, expiration, metadata);

            items.put(a.getId(), a);
        }

        return a;
    }

    public List<Asset> listAssetsByShow(long showId) {
        return items.values().stream()
                .filter(asset -> showId == asset.getOwnerShowId())
                .collect(Collectors.toList());
    }
}
