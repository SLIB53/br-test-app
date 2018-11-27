package brtestapp;

import brtestapp.lib.data.*;
import brtestapp.storage.*;

import java.util.List;

public class BRTestApp {
    public static void main(String[] args) {
        var storage = new BRTestAppStore();

        // Add "Mr. Bean"

        var mrBean = storage.createShow("Mr. Bean", "A British sitcom starring Rowan Atkinson.");

        // Add Season 1 Episode 1

        storage.createVideoAsset(mrBean.getId(), "mr-bean-s1e1", "https://youtube.com", 0,
                VideoAssetMeta.VideoTypes.EPISODE);

        // Add Default Thumbnail

        var mrBeanThumbDefault = storage.createImageAsset(mrBean.getId(), "mr-bean-thumb-default",
                "https://images.google.com", 0, null);

        // Add Poster

        storage.createImageAsset(mrBean.getId(), "mr-bean-poster-1", "https://images.google.com", 0,
                mrBeanThumbDefault.getId());

        // Add Ad

        storage.createAdAsset(mrBean.getId(), "mr-bean-ad", "https://gov.uk", 0, "The best show.");

        // Generate Container

        var container = new Object() {
            final Show show = storage.getShow(mrBean.getId());
            final List<Asset> assets = storage.listAssetsByShow(mrBean.getId());
        };

        // Print Container

        System.out.println("Show:");

        System.out.println("\tId: " + container.show.getId());
        System.out.println("\tName: " + container.show.getName());
        System.out.println("\tDescription: " + container.show.getDescription());

        System.out.println();

        System.out.println("Assets:");

        for (var a : container.assets) {
            System.out.println("\tId: " + a.getId());
            System.out.println("\tOwnerShowId: " + a.getOwnerShowId());
            System.out.println("\tName: " + a.getName());
            System.out.println("\tType: " + a.getType());
            System.out.println("\tUrl: " + a.getUrl());
            System.out.println("\tExpiration: " + a.getExpiration());

            if (a.getMeta() instanceof VideoAssetMeta) {
                var m = (VideoAssetMeta) a.getMeta();

                System.out.println("\tVideo Type: " + m.getVideoType());
            }

            if (a.getMeta() instanceof ImageAssetMeta) {
                var m = (ImageAssetMeta) a.getMeta();

                if (m.getBaseImageAssetId() != null)
                    System.out.println("\tBase Image Asset Id: " + m.getBaseImageAssetId());
            }

            if (a.getMeta() instanceof AdAssetMeta) {
                var m = (AdAssetMeta) a.getMeta();

                System.out.println("\tProduct Description: " + m.getProductDescription());
            }

            System.out.println();
        }
    }
}
