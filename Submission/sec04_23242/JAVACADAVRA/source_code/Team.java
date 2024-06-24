class Team {
    private String teamName;
    private ArrayList<Athlete> athletes = new ArrayList<>();
    private Manager manager;
    private Sport sport;
    private ArrayList<TrainingSession> t = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();

    public Team(String teamName, String sportname, String category, Manager manager) {
        this.teamName = teamName;
        sport = new Sport(sportname, category);
        this.manager = manager;
    }

    public String getName() {
        return teamName;
    }

    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    public ArrayList<Event> getEvent() {
        return events;
    }

    public ArrayList<TrainingSession> getTrain() {
        return t;
    }

    public void newMember1(String name, String gender, int age, String sportName, String category, Manager m) {
        athletes.add(new Athlete(name, gender, age, sportName, category, m));
    }

    public void newMember2(Athlete ath) {
        athletes.add(ath);
        ath.joinTeam2(teamName);
    }

    public void removeMember1(String n) {
        for (int i = 0; i < athletes.size(); i++) {
            String name = athletes.get(i).getName();
            if (name.equals(n))
                athletes.remove(athletes.get(i));
        }
    }

    public void removeMember2(Athlete ath) {
        ath.removeTeam2();
        athletes.remove(ath);
    }

    public void displayTraining() {
        if (t.isEmpty())
            System.out.println("No Training Session is Set.");
        else {
            for (int i = 0; i < t.size(); i++) {
                System.out.println(teamName + "'s Training Session #" + (i + 1));
                t.get(i).displayDetails();
                System.out.println();
            }
        }
    }

    public void addTraining(TrainingSession tr) {
        t.add(tr);
    }

    public void cancelTraining(TrainingSession tr) {
        t.remove(tr);
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    public void cancelEvent(Event e) {
        events.remove(e);
    }

    public void displayDetails() {
        System.out.println("Team Name: " + teamName);
        System.out.println("Number of Team Members: " + athletes.size());

        if (athletes.size() != 0) {
            System.out.println("* List of Team Members * \n");
            for (int i = 0; i < athletes.size(); i++) {
                System.out.println("Member #" + (i + 1));
                System.out.println("Name: " + athletes.get(i).getName());
                System.out.println("Age: " + athletes.get(i).getAge());
                System.out.println();
            }
        }

        if (events.size() != 0) {
            System.out.println("* List of Team's Events * \n");
            for (int i = 0; i < events.size(); i++) {
                System.out.println("Event #" + (i + 1));
                System.out.println(events.get(i).toString());
                System.out.println();
            }
        }

        if (t.size() != 0) {
            System.out.println("* List of Team's Training Session * \n");
            for (int i = 0; i < t.size(); i++) {
                System.out.println("Training #" + (i + 1));
                System.out.println(t.get(i).displayDetails());
                System.out.println();
            }
        }
    }

    public TrainingSession getSession(int n) {
        return t.get(n);
    }
}
