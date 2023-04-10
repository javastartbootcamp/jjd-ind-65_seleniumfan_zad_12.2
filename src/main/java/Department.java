public enum Department {
    IT("It"),
    SUPPORT("Support"),
    MANAGEMENT("Management");

    private String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
