package brtestapp.lib.data;

public final class ImageAssetMeta extends AssetMeta {
    private final Long baseImageAssetId;

    public ImageAssetMeta(Long baseImageAssetId) {
        this.baseImageAssetId = baseImageAssetId;
    }

    public Long getBaseImageAssetId() {
        return baseImageAssetId;
    }
}
