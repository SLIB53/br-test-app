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

        storage.createVideoAsset(mrBean.GetId(), "mr-bean-s1e1", "https://youtube.com", 0,
                VideoAssetMeta.VideoTypes.EPISODE);

        // Add Default Thumbnail

        var mrBeanThumbDefault = storage.createImageAsset(mrBean.GetId(), "mr-bean-thumb-default",
                "https://images.google.com", 0, null);

        // Add Poster

        storage.createImageAsset(mrBean.GetId(), "mr-bean-poster-1", "https://images.google.com", 0,
                mrBeanThumbDefault.getId());

        // Add Advert

        storage.createAdAsset(mrBean.GetId(), "mr-bean-ad", "https://gov.uk", 0, "The best show.");

        // Generate Container

        var container = new Object() {
            Show show = storage.getShow(mrBean.GetId());
            List<Asset> assets = storage.listAssetsByShow(mrBean.GetId());
        };

        // Print Container

        System.out.println("Show:");

        System.out.println("\tId: " + container.show.GetId());
        System.out.println("\tName: " + container.show.GetName());
        System.out.println("\tDescription: " + container.show.GetDescription());

        System.out.println();

        System.out.println("Assets:");

        for (Asset a : container.assets) {
            System.out.println("\tId: " + a.getId());
            System.out.println("\tOwnerShowId: " + a.getOwnerShowId());
            System.out.println("\tName: " + a.getName());
            System.out.println("\tType: " + a.getType());
            System.out.println("\tUrl: " + a.getUrl());
            System.out.println("\tExpiration: " + a.getExpiration());

            if (a.getMeta() instanceof VideoAssetMeta) {
                var aAsV = (VideoAssetMeta) a.getMeta();

                System.out.println("\tVideo Type: " + aAsV.getVideoType());
            }

            if (a.getMeta() instanceof ImageAssetMeta) {
                var aAsI = (ImageAssetMeta) a.getMeta();

                if (aAsI.getBaseImageAssetId() != null)
                    System.out.println("\tBase Image Asset Id: " + aAsI.getBaseImageAssetId());
            }

            if (a.getMeta() instanceof AdAssetMeta) {
                var aAsA = (AdAssetMeta) a.getMeta();

                System.out.println("\tProduct Description: " + aAsA.getProductDescription());
            }

            System.out.println();
        }
    }
}
