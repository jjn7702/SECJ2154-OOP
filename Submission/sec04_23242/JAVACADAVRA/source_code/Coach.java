class Coach extends Person {// inheritance
    private int experience;
    private String expertise;
    private ArrayList<TrainingSession> training = new ArrayList<>();

    public Coach(String name, String gender, int age, int ex, String expert) {
        super(name, gender, age);
        experience = ex;
        expertise = expert;
    }

    public int getExperience() {
        return experience;
    }

    public String getExpertise() {
        return expertise;
    }

    public void addTrainingSession(TrainingSession t) {
        training.add(t);
    }

    public String getInfo() {
        return "\nCoach's Details" + super.getInfo() + "\nExperience: " + experience + " years\nExpertise: "
                + expertise;
    }
}

