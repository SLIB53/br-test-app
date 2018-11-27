package brtestapp.logic.container;

import brtestapp.lib.data.AdAssetMeta;
import brtestapp.lib.data.ImageAssetMeta;
import brtestapp.lib.data.VideoAssetMeta;

/**
 * ContainerUtil
 */
public class ContainerUtil {
    public static String toFormattedString(ContainerReader container) {
        var show = container.GetShow();
        var assets = container.GetAssets();
        
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
}