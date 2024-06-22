class Athlete extends Person {
    private String sportName, category;
    private ArrayList<Sport> sports; // composition
    private Manager manager; // aggregation
    private Team team; // association
    private ArrayList<Event> events; // association
    private ArrayList<TrainingSession> training; // association

    public Athlete(String name, String gender, int age, String sName, String cat, Manager m) {
        super(name, gender, age);
        sportName = sName;
        category = cat;
        sports = new ArrayList<>();
        sports.add(new Sport(sName, cat));
        manager = m;
        events = new ArrayList<>();
        training = new ArrayList<>();
    }

    public Manager getManager() {
        return manager;
    }

    public void joinTeam(Team t) {
        team = t;
        t.newMember1(super.getName(), super.getGender(), super.getAge(), sportName, category, manager);
    }

    public void joinTeam2(String teamName) {
        team = new Team(teamName, sportName, category, manager);
    }

    public void removeTeam1() {
        team = null;
        team.removeMember1(super.getName());
    }

    public void removeTeam2() {
        team = null;
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    public void addTraining(TrainingSession t) {
        training.add(t);
    }

    public void cancelEvent(Event e) {
        events.remove(e);
    }

    public void cancelTraining(TrainingSession t) {
        training.remove(t);
    }

    public String getInfo() {
        String info = super.getInfo();

        if (manager != null) {
            info += manager.getInfo();
        }

        if (team != null) {
            info += "\nTeam: " + team.getName();
        }

        if (events.size() != 0 || events.size() == 0) {
            info += "\nEvents:";

            for (Event ev : events) {
                info += " " + ev.getEventName();
            }
        }

        if (training.size() != 0 || training.size() == 0) {
            info += "\nTraining Session:";

            for (TrainingSession t : training) {
                info += "\n" + t.displayDetails();
            }
        }
        return info;
    }

    public void athleteMenu() {
        System.out.println("\n-----Athlete Management Menu-----");
        System.out.println("[1] Recruit Athlete into a Team");
        System.out.println("[2] Remove Athlete from an Assigned Team");
        System.out.println("[3] Add a Training Session");
        System.out.println("[4] Remove a Training Session");
        System.out.println("[5] Add a Sports Event");
        System.out.println("[6] Cancel a Sports Event");
        System.out.println("[7] Display Athlete Details");
        System.out.println("[8] Return to Main Menu");
        System.out.print("Your Choice: ");

    }

    public void displayTraining() {
        if (training.size() == 0)
            System.out.println("No Training Session is Set.");
        else {
            for (int i = 0; i < training.size(); i++) {
                System.out.println(super.getName() + "'s Training Session #" + (i + 1));
                training.get(i).displayDetails();
                System.out.println();
            }
        }
    }

    public void displayEvents() {
        if (events.size() == 0)
            System.out.println("No Sports Event is Set.");
        else {
            for (int i = 0; i < events.size(); i++) {
                System.out.println(super.getName() + "'s Sports Event #" + (i + 1));
                System.out.println(events.get(i).toString());
                System.out.println();
            }
        }
    }

    public TrainingSession getSession(int n) {
        return training.get(n);
    }

    public void displayTeam() {
        if (team == null)
            System.out.println("");
    }

    public void displaySports() {
        for (int i = 0; i < sports.size(); i++)
            System.out.println((i + 1) + ") " + sports.get(i).toString());
    }

    public Sport getSport(int n) {
        return sports.get(n);
    }

    public int getSportsNum() {
        return sports.size();
    }
}
