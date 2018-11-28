package brtestapp.lib.data;

public final class AdAssetMeta extends AssetMeta {
    private final String productDescription;

    public AdAssetMeta(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
