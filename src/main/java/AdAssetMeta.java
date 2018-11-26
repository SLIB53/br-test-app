package brtestapp;

public final class AdAssetMeta extends AssetMeta {
    private String productDescription;

    public AdAssetMeta(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
