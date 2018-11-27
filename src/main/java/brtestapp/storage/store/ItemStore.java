package brtestapp.storage.store;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class ItemStore<T> {
    protected ConcurrentMap<Long, T> items;

    protected ItemStore() {
        items = new ConcurrentHashMap<Long, T>();
    }

    protected long generateId() throws RuntimeException {
        var uuid = UUID.randomUUID();

        if (!items.containsKey(uuid.getLeastSignificantBits()))
            return uuid.getLeastSignificantBits();
        else if (!items.containsKey(uuid.getMostSignificantBits()))
            return uuid.getLeastSignificantBits();
        else
            throw new RuntimeException("Collision detected when generating a new id. Try again.");
    }
}
