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
                    while (!(ch2 == 1 || ch2 == 2)) {
                        System.out.print(
                                "Do you wish to manage an existing athlete or add a new athlete?: \n [1] Manage an Existing Athlete\n[2] Add a New Athlete\n\nYour Choice: ");
                        ch2 = sc.nextInt();
                    }
                    if (ch2 == 1) {
                        System.out.print("Choose an Athlete to Manage: ");
                        int ch3 = sc.nextInt();
                        while (!(ch3 > 0 && ch3 < (athletes.size()))) {
                            System.out.print("Choose an Athlete to Manage: ");
                            ch3 = sc.nextInt();
                        }
                        Athlete at = athletes.get(--ch3);
                        System.out.println(at.getInfo());
                        int ch4 = 0;
                        do {
                            at.athleteMenu();
                            ch4 = sc.nextInt();

                            while (!(ch4 > 0 && ch4 < 9)) {
                                System.out.println(at.getInfo());
                                at.athleteMenu();
                                ch4 = sc.nextInt();
                            }
                            switch (ch4) {
                                case 1:
                                    Manager m3 = null;
                                    for (int i = 0; i < teams.size(); i++) {
                                        teams.get(i).displayDetails();
                                    }
                                    System.out.print(
                                            "Do you wish to add an existing team or add a new Team?\n[1] Add an Existing Team\n[2] Add a New Team\n\nYour Choice: ");
                                    int ch11 = sc.nextInt();
                                    while (!(ch11 == 1 || ch11 == 2)) {
                                        System.out.print(
                                                "Do you wish to add an existing team or add a new Team?\n[1] Add an Existing Team\n[2] Add a New Team\n\nYour Choice: ");
                                        ch11 = sc.nextInt();
                                    }
                                    if (ch11 == 1) {
                                        System.out.print("Your Choice of Team to be Added: ");
                                        int ch12 = sc.nextInt();
                                        while (!(ch12 > 0 && ch12 < teams.size())) {
                                            System.out.print("Your Choice of Team to be Added: ");
                                            ch12 = sc.nextInt();
                                        }
                                        at.joinTeam(teams.get(--ch12));
                                    } else {
                                        sc.nextLine();
                                        System.out.print("Enter team's name: ");
                                        String tName = sc.nextLine();
                                        at.displaySports();
                                        System.out.print("Which sport is this team under? ");
                                        int ch15 = sc.nextInt();
                                        while (!(ch15 > 0 && ch15 < at.getSportsNum())) {
                                            System.out.print("Which sport is this team under? ");
                                            ch15 = sc.nextInt();
                                        }
                                        Sport sp = at.getSport(--ch15);
                                        System.out.println("Does the team have a manager? (Y/N): ");
                                        String ans = sc.nextLine();
                                        while (!(ans.equals("Y") || ans.equals("N"))) {
                                            System.out.println("Does the team have a manager? (Y/N): ");
                                            ans = sc.nextLine();
                                        }
                                        if (ans.equals("Y")) {
                                            for (int i = 0; i < managers.size(); i++)
                                                System.out.println((i + 1) + ") " + managers.get(i).getInfo());
                                            System.out.print(
                                                    "Do you wish to add an manager or add a new manager?\n[1] Add an Existing Manager\n[2] Add a New Manager\n\nYour Choice: ");
                                            int ch13 = sc.nextInt();
                                            while (ch13 != 1 || ch13 != 2) {
                                                System.out.print(
                                                        "Do you wish to add an manager or add a new manager?\n[1] Add an Existing Manager\n[2] Add a New Manager\n\nYour Choice: ");
                                                ch13 = sc.nextInt();
                                            }
                                            if (ch13 == 1) {
                                                System.out.print("Your Choice of Manager to be Added: ");
                                                int ch14 = sc.nextInt();
                                                while (!(ch14 > 0 && ch14 < managers.size())) {
                                                    System.out.print("Your Choice of Manager to be Added: ");
                                                    ch14 = sc.nextInt();
                                                }
                                                m3 = managers.get(--ch14);
                                            } else {
                                                System.out.print("Enter team's manager name: ");
                                                String tMName = sc.nextLine();
                                                System.out.print("Enter team's manager age: ");
                                                int tMAge = sc.nextInt();
                                                System.out.print("Enter team's manager gender: ");
                                                String tMGender = sc.nextLine();
                                                m3 = new Manager(tMName, tMGender, tMAge);
                                            }
                                        } else {
                                            m3 = null;
                                        }
                                        managers.add(m3);
                                        at.joinTeam(new Team(tName, sp.getSportName(), sp.getCategory(), m3));

                                    }
                                    System.out.println("The Team is Succesfully Assigned.");
                                    break;
                                case 2: 
                                    at.removeTeam1();
                                    System.out.println("The Team is Succesfully Removed.");
                                    break;
                                case 3: 
                                    //at.displayEvents();
                                    System.out.println("\n*** List of Training Sessions ***");
                                    for(int i = 0; i < training.size(); i++) {
                                        System.out.println( (i+1) + ") " + training.get(i).displayDetails());
                                    }
                                    System.out.print("Do you wish to add an existing training session or add a new training session? \n[1] Add an Existing Training Session\n[2] Add a New Training Session\n\nYour Choice: ");
                                    int ch20 = sc.nextInt();
                                    while (ch20!= 1 && ch20 != 2) {
                                        System.out.print("Do you wish to add an existing training session or add a new training session? \n[1] Add an Existing training session\n[2] Add a New  training session\n\nYour Choice: ");
                                        ch20 = sc.nextInt();
                                    }
                                    if (ch20 == 1) {
                                        System.out.print("Your Choice of training session to be Added: ");
                                        int ch21 = sc.nextInt();
                                        while(!(ch21 > 0 && ch21 < (training.size()+1))) {
                                            System.out.print("Your Choice of training session to be Added: ");
                                            ch21= sc.nextInt();
                                        }
                                        TrainingSession t = training.get(--ch21);
                                        at.addTraining(t);
                                        System.out.println("The training session is Succesfully Added.");
                                    }
                                    else {
                                        sc.nextLine();
                                        System.out.print("Enter Training Session Date:");
                                                String sessionDate = sc.nextLine();

                                                System.out.print("Enter Training Session Time in Hour:");
                                                int sessionHour = sc.nextInt();

                                                System.out.print("Enter Training Session Time in Minutes:");
                                                int sessionMinutes = sc.nextInt();

                                                System.out.print("Enter Training Session Duration Time:");
                                                double sessionDuration = sc.nextDouble();
                                                sc.nextLine(); // Consume newline character left by nextDouble()

                                                System.out.println("Enter Training Session Description:");
                                                String sessionDesc = sc.nextLine();

                                                System.out.println("Enter Training Session Venue:");
                                                String sessionVenue = sc.nextLine();

                                                TrainingSession tTrain = new TrainingSession(sessionDate, sessionHour,
                                                        sessionMinutes, sessionDuration, sessionDesc, sessionVenue);
                                                at.addTraining(tTrain);
                                                System.out.println("The Straining session is Succesfully Added.");
                                    }
                                    break;
                                    case 4: 
                                    at.displayTraining();
                                    int ch5 = sc.nextInt();
                                    at.cancelTraining(at.getSession(--ch5));
                                    System.out.print("Your Choice of Training Session to be Removed.");
                                    break;
                                case 5:
                                    //at.displayEvents();
                                    System.out.println("\n*** List of Events ***");
                                    for(int i = 0; i < events.size(); i++) {
                                        System.out.println( (i+1) + ") " +events.get(i).toString());
                                    }
                                    System.out.print("Do you wish to add an existing event or add a new event? \n[1] Add an Existing Event\n[2] Add a New Event\n\nYour Choice: ");
                                    int ch10 = sc.nextInt();
                                    while (ch10 != 1 && ch10 != 2) {
                                        System.out.print("Do you wish to add an existing event or add a new event? \n[1] Add an Existing Event\n[2] Add a New Event\n\nYour Choice: ");
                                        ch10 = sc.nextInt();
                                    }
                                    if (ch10 == 1) {
                                        System.out.print("Your Choice of Sports Event to be Added: ");
                                        int ch6 = sc.nextInt();
                                        while(!(ch6 > 0 && ch6 < (events.size()+1))) {
                                            System.out.print("Your Choice of Sports Event to be Added: ");
                                            ch6 = sc.nextInt();
                                        }
                                        Event e = events.get(--ch6);
                                        at.addEvent(e);
                                        System.out.println("The Sports Event is Succesfully Added.");
                                    }
                                    else {
                                        System.out.print("Enter the event's name: ");
                                        String evName = sc.nextLine();
                                        System.out.print("Enter the event's venue: ");
                                        String evVenue = sc.nextLine();
                                        System.out.print("Enter the date that the event takes place (DD-MM-YYYY): ");
                                        String evDate = sc.nextLine();
                                        System.out.print("Enter the time that the event begins in military time format  (HH.MM): ");
                                        double evTime = sc.nextDouble();
                                        System.out.println("Enter Event's Sport Name: ");
                                        String esName = sc.nextLine();
                                        System.out.println("Enter Event's Sport Category: ");
                                        String esCat = sc.nextLine();
                                        Event e = new Event(evName, evVenue, evDate, evTime, esName, esCat);
                                        at.addEvent(e);
                                        System.out.println("The Sports Event is Succesfully Added.");
                                    }
                                    break;
                                case 6:
                                    //at.displayEvents();
                                    System.out.print("Your Choice of Sports Event to be Removed: ");
                                    int ch7 = sc.nextInt();
                                    Event ev = events.get(--ch7);
                                    at.cancelEvent(ev);
                                    System.out.println("The Sports Event is Succesfully Removed.");
                                    break;
                                case 7:
                                    System.out.println(at.getInfo());
                                    break;
                                case 8:
                                    break;
                                default:
                                    break;
                            }
                        } while (ch4 < 8);
                         } else {
                        sc.nextLine();
                        System.out.print("Enter Athlete's Name: "); 
                        String athName = sc.nextLine();

                        System.out.print("Enter Athlete's Gender: ");
                        String athGender = sc.nextLine();

                        System.out.print("Enter Athlete's Age: ");
                        int athAge = sc.nextInt();

                        Person p8 = new Person(athName, athGender, athAge);
                        System.out.print("Does the athlete have a manager? (Y/N): ");
                        String opt = sc.next();
                        while (!opt.equals("Y") && !opt.equals("N")) {
                            System.out.print("Does the athlete have a manager? (Y/N): ");
                            opt = sc.next();
                        }
                        if (opt.equals("Y")) {
                            System.out.println("\n** Managers List **");
                            for (int i = 0; i < managers.size(); i++) {
                                System.out.println((i + 1) + ") " + managers.get(i).getInfo());
                                System.out.println();
                            }
                            System.out.print(
                                    "Do you wish to add an existing manager or add a new manager?: \n[1] Add an Existing Manager\n[2] Add a New Manager\n\nYour Choice: ");
                            int ch8 = sc.nextInt();
                            if (ch8 == 1) {
                                System.out.print("Your Choice of Manager to be Added: ");
                                int ch9 = sc.nextInt();
                                mChoice = managers.get(--ch9);
                            } else {
                                System.out.print("Enter Manager's Name: ");
                                String mgName = sc.nextLine();

                                System.out.print("Enter Manager's Gender: ");
                                String mgGender = sc.nextLine();

                                System.out.print("Enter Manager's Age: ");
                                int mgAge = sc.nextInt();

                                Person p9 = new Person(mgName, mgGender, mgAge);
                                mChoice = new Manager(mgName, mgGender, mgAge);
                            }
                                    
