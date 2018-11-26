package brtestapp;

public final class Show {
    private final long id;
    private String name;
    private String description;

    public Show(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long GetId() {
        return id;
    }

    public String GetName() {
        return name;
    }

    public String GetDescription() {
        return description;
    }
}
