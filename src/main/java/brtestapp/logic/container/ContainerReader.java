package brtestapp.logic.container;

import brtestapp.lib.data.Asset;
import brtestapp.lib.data.Show;

import java.util.Collection;
import java.util.Collections;

/**
 * ContainerReader
 * Readonly logical view object.
 */
public class ContainerReader {
    private final Container container;

    public ContainerReader(Container container) {
        this.container = container;
    }

    public Show GetShow() {
        return container.show;
    }

    public Collection<Asset> GetAssets() {
        return Collections.unmodifiableCollection(container.assets);
    }
}
