package brtestapp.lib.data;

public final class Asset {
    private final long id;
    private final long ownerShowId;
    private final String name;
    private final String type;
    private final String url;
    private final long expiration;
    private final AssetMeta metadata;

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
