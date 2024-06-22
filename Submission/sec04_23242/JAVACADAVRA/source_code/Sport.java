class Sport {
    private String sportName, category;

    public Sport(String sportName, String category) {
        this.sportName = sportName;
        this.category = category;
    }

    public String getSportName() {
        return sportName;
    }

    public String getCategory() {
        return category;
    }

    public String toString() {
        return "Sport Name: " + sportName + "\nCategory: " + category;
    }

}

