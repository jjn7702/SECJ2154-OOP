public class SportsTeamManagement {
    public static void displayMenu() {
        System.out.println("\n-----Main Menu-----");
        System.out.println("[1] Manage Athlete(s)");
        System.out.println("[2] Manage Team(s)");
        System.out.println("[3] Exit\n");
        System.out.print("Your Choice: ");

    }

    public static void teamMenu() {
        System.out.println("\n-----Team Management Menu-----");
        System.out.println("[1] Recruit an Athlete into the Team");
        System.out.println("[2] Remove an Athlete from the Team");
        System.out.println("[3] Add a Training Session");
        System.out.println("[4] Remove a Training Session");
        System.out.println("[5] Add a Sports Event");
        System.out.println("[6] Cancel a Sports Event");
        System.out.println("[7] Display Team Details");
        System.out.println("[8] Return to Main Menu");
        System.out.print("Your Choice: ");
    }

    public static void displayAtheletes(ArrayList<Athlete> a) {
        if (a.size() == 0)
            System.out.println("There is currently no athletes in the system");
        else {
            for (int i = 0; i < a.size(); i++) {
                System.out.println((i + 1) + ") " + a.get(i).getInfo());
                System.out.println();
            }
        }
    }

    public static void displayTeams(ArrayList<Team> t) {
        for (int i = 0; i < t.size(); i++) {
            if (t.size() == 0)
                System.out.println("There is currently no teams in the system");
            else
                System.out.print((i + 1) + ") ");
            t.get(i).displayDetails();
            System.out.println();
        }
        // System.out.print("Choose a Team to Manage: ");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Athlete> athletes = new ArrayList<>();
        ArrayList<Coach> coaches = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Sport> sports = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<TrainingSession> training = new ArrayList<>();

    Person p1 = new Person("Arif Aiman", "Man", 21);
        Person p2 = new Person("Abu Bakar", "Man", 23);
        Person p3 = new Person("Aliyah Shafikah", "Woman", 19);
        Person p4 = new Person("Ainaa Amira", "Woman", 21);

        // coach
        Person p5 = new Person("Jamilludin", "Man", 35);
        Person p6 = new Person("Kamarudin", "Man", 40);
        // Coach c1 = new Coach(p5.getName(), p5.getGender(), p5.getAge(), 5, "football");
        // Coach c2 = new Coach(p6.getName(), p6.getGender(), p6.getAge(), 15, "football, netball, hockey");

        // manager
        Person p7 = new Person("En. Abduallah Samad", "Man", 45);
        Manager m1 = new Manager(p7.getName(), p7.getGender(), p7.getAge());
        Manager mChoice;

        managers.add(m1);
        Athlete a1 = new Athlete(p1.getName(), p1.getGender(), p1.getAge(), "Football", "U23", m1);
        Athlete a2 = new Athlete(p2.getName(), p2.getGender(), p2.getAge(), "Football", "U23", m1);
        Athlete a3 = new Athlete(p3.getName(), p3.getGender(), p3.getAge(), "Netball", "U18", null);
        Athlete a4 = new Athlete(p4.getName(), p4.getGender(), p4.getAge(), "Netball", "U18", null);

        athletes.add(a1);
        athletes.add(a2);
        athletes.add(a3);
        athletes.add(a4);

        // Sport
        Sport s1 = new Sport("Football", "U23");
        Sport s2 = new Sport("Netball", "U21");
        Sport s3 = new Sport("Half-Marathon", "OPEN");

        sports.add(s1);
        sports.add(s2);
        sports.add(s3);

        // Event
        Event e1 = new Event("SUKIPT", "Stadium Azman Hashim", "12-07-2024", 8.00, s1.getSportName(), s1.getCategory());
        Event e2 = new Event("INTER-NETBALL", "Sports Hall 2", "15-08-2024", 10.00, s2.getSportName(),
                s2.getCategory());
        Event e3 = new Event("Run For Unity", "Stadium Azman Hashim", "10-08-2024", 8.00, s3.getSportName(),
                s3.getCategory());

        events.add(e1);
        events.add(e2);
        events.add(e3);

        a1.addEvent(e1);
        a2.addEvent(e1);
        a3.addEvent(e2);
        a4.addEvent(e2);

        // Team
        Team t1 = new Team("Team A", "Football", "U23", m1);
        Team t2 = new Team("Team B", "Netball", "U18", null);
        teams.add(t1);
        teams.add(t2);

        // Training Sessions
        TrainingSession ts1 = new TrainingSession("28-06-2024", 10, 0, 90.0, "Morning Training", "Padang Kilat UTM");
        TrainingSession ts2 = new TrainingSession("29-06-2024", 16, 30, 120.0, "Afternoon Training", "Padang Ragbi UTM");
        training.add(ts1);
        training.add(ts2);

        System.out.println("Welcome to Our Sports Team Management System");
        int ch1;
        do {
            displayMenu();
            ch1 = sc.nextInt();

            while (ch1 < 1 || ch1 > 3) {
                System.out.println("Invalid choice. Please select an option between 1 and 3.");
                displayMenu();
                ch1 = sc.nextInt();
            }

            switch (ch1) {
                case 1:
                    displayAtheletes(athletes);
                    System.out.print(
                            "Do you wish to manage an existing athlete or add a new athlete?: \n[1] Manage an Existing Athlete\n[2] Add a New Athlete\n\nYour Choice: ");
                    int ch2 = sc.nextInt();
