package brtestapp.storage.store;

import brtestapp.lib.data.Show;

public final class ShowStore extends ItemStore<Show> {
    public Show createShow(String name, String description) {
        Show s;

        synchronized (items) {
            s = new Show(generateId(), name, description);

            items.put(s.getId(), s);
        }

        return s;
    }

    public Show getShow(long showId) {
        return items.get(showId);
    }
}
