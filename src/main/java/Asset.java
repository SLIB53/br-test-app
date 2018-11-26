package brtestapp;

public final class Asset {
    private long id;
    private long ownerShowId;
    private String name;
    private String type;
    private String url;
    private long expiration;
    private AssetMeta metadata;

    public Asset(long id, long ownerShowId, String name, String type, String url, long expiration, AssetMeta metadata) {
        this.id = id;
        this.ownerShowId = ownerShowId;
        this.name = name;
        this.type = type;
        this.url = url;
        this.expiration = expiration;
        this.metadata = metadata;
    }

    public long getId() {
        return id;
    }

    public long getOwnerShowId() {
        return ownerShowId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public long getExpiration() {
        return expiration;
    }

    public AssetMeta getMeta() {
        return metadata;
    }
}
