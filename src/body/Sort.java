package body;

public enum Sort {
    RADIO_ASC(1),
    RADIO_DESC(2);

    private int id;

    Sort(int id) {
        setId(id);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
