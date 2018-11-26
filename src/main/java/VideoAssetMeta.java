package brtestapp;

public final class VideoAssetMeta extends AssetMeta {
    public static class VideoTypes {
        public static final String MOVIE = "movie";
        public static final String EPISODE = "episode";
        public static final String CLIP = "clip";
    }

    private String videoType;

    public VideoAssetMeta(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoType() {
        return videoType;
    }
}
