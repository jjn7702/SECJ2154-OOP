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
