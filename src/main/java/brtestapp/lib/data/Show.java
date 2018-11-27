package brtestapp.lib.data;

public final class Show {
    private final long id;
    private String name;
    private String description;

    public Show(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
