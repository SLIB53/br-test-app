package brtestapp;

import brtestapp.lib.data.VideoAssetMeta;
import brtestapp.logic.BRTestAppLogic;
import brtestapp.logic.container.ContainerUtil;
import brtestapp.storage.BRTestAppStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BRTestApp {
    private static final Logger logger = Logger.getLogger(BRTestApp.class.getName());
    private static final BRTestAppStorage storageLayer = new BRTestAppStorage();
    private static final BRTestAppLogic logicLayer = new BRTestAppLogic();

    public static void main(String[] args) {

        //
        // Populate Storage Layer
        //

        // add "Mr. Bean"

        final var mrBean = storageLayer.createShow(
                "Mr. Bean",
                "A British sitcom starring Rowan Atkinson."
        );

        // add episode 1

        final var mrBeanEpisode1 = storageLayer.createVideoAsset(
                mrBean.getId(),
                "mr-bean-s1e1",
                "https://youtu.be/iIaMLosX_kQ",
                2147385600,
                VideoAssetMeta.VideoTypes.EPISODE
        );

        // add default image

        final var mrBeanDefaultImage = storageLayer.createImageAsset(
                mrBean.getId(),
                "mr-bean-default-image",
                "https://via.placeholder.com/150",
                2147385600,
                null
        );

        // add poster (missing url)

        final var mrBeanPoster1 = storageLayer.createImageAsset(
                mrBean.getId(),
                "mr-bean-poster-1",
                null,
                2147385600,
                mrBeanDefaultImage.getId()
        );

        // add ad

        final var mrBeanAd = storageLayer.createAdAsset(
                mrBean.getId(),
                "mr-bean-ad",
                "https://youtu.be/XUSpZ9IKdFg",
                2147385600,
                "The best show."
        );

        //
        // Demo
        //

        var container = logicLayer.MakeContainer(storageLayer, mrBean.getId());

        logger.log(Level.INFO, ContainerUtil.toFormattedString(container));
    }
}
