package brtestapp.logic;

import brtestapp.logic.container.Container;
import brtestapp.logic.container.ContainerReader;
import brtestapp.storage.BRTestAppStorage;

/**
 * BRTestAppLogic
 */
public class BRTestAppLogic {
    public ContainerReader MakeContainer(BRTestAppStorage storage, long showId) {
        var container = new Container();
        container.show = storage.getShow(showId);
        container.assets = storage.listAssetsByShow(showId);

        return new ContainerReader(container);
    }
}
