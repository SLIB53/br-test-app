package brtestapp;

import brtestapp.lib.data.*;
import brtestapp.storage.BRTestAppStore;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BRTestApp {
    private static final Logger logger = Logger.getLogger(BRTestApp.class.getName());
    private static final BRTestAppStore storage = new BRTestAppStore();

    public static void main(String[] args) {

        //
        // Populate Storage Layer
        //

        // add "Mr. Bean"

        final var mrBean = storage.createShow(
                "Mr. Bean",
                "A British sitcom starring Rowan Atkinson."
        );

        // add episode 1

        final var mrBeanEpisode1 = storage.createVideoAsset(
                mrBean.getId(),
                "mr-bean-s1e1",
                "https://youtu.be/iIaMLosX_kQ",
                2147385600,
                VideoAssetMeta.VideoTypes.EPISODE
        );

        // add default image

        final var mrBeanDefaultImage = storage.createImageAsset(
                mrBean.getId(),
                "mr-bean-default-image",
                "https://via.placeholder.com/150",
                2147385600,
                null
        );

        // add poster (missing url)

        final var mrBeanPoster1 = storage.createImageAsset(
                mrBean.getId(),
                "mr-bean-poster-1",
                null,
                2147385600,
                mrBeanDefaultImage.getId()
        );

        // add ad

        final var mrBeanAd = storage.createAdAsset(
                mrBean.getId(),
                "mr-bean-ad",
                "https://youtu.be/XUSpZ9IKdFg",
                2147385600,
                "The best show."
        );

        //
        // Container Demo
        //

        var container = new Object() {
            final Show show = storage.getShow(mrBean.getId());
            final List<Asset> assets = storage.listAssetsByShow(mrBean.getId());

            public String toFormattedString() {
                var formatter = new Object() {
                    private StringBuilder builder = new StringBuilder();

                    public void appendHeading(String label) {
                        builder.append(String.format("%s:\n", label));
                    }

                    public void appendRow(String label, Object value) {
                        builder.append(String.format("\t%s: %s\n", label, value));
                    }

                    public void appendEmptyLine() {
                        builder.append('\n');
                    }

                    @Override
                    public String toString() {
                        return builder.toString();
                    }
                };

                formatter.appendEmptyLine();

                formatter.appendHeading("Show");

                formatter.appendRow("Id", show.getId());
                formatter.appendRow("Name", show.getName());
                formatter.appendRow("Description", show.getDescription());

                formatter.appendEmptyLine();

                formatter.appendHeading("Asset");

                for (var a : assets) {
                    formatter.appendRow("Id", a.getId());
                    formatter.appendRow("OwnerShowId", a.getOwnerShowId());
                    formatter.appendRow("Name", a.getName());
                    formatter.appendRow("Type", a.getType());

                    if (a.getUrl() != null)
                        formatter.appendRow("Url", a.getUrl());

                    formatter.appendRow("Expiration", a.getExpiration());

                    if (a.getType() == "video") {
                        var m = (VideoAssetMeta) a.getMeta();

                        formatter.appendRow("Video Type", m.getVideoType());
                    }

                    if (a.getType() == "image") {
                        var m = (ImageAssetMeta) a.getMeta();

                        if (m.getBaseImageAssetId() != null)
                            formatter.appendRow("Base Image Asset Id", m.getBaseImageAssetId());
                    }

                    if (a.getType() == "ad") {
                        var m = (AdAssetMeta) a.getMeta();

                        formatter.appendRow("Product Description", m.getProductDescription());
                    }

                    formatter.appendEmptyLine();
                }

                return formatter.toString();
            }
        };

        logger.log(Level.INFO, container.toFormattedString());
    }
}
