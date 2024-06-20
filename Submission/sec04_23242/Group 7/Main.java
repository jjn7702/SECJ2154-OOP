import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vector<Volunteer> volunteers = new Vector<>();
        Vector<Organizer> organizers = new Vector<>();
        Vector<Opportunity> opportunitiesLong = new Vector<>();
        Vector<Opportunity> opportunitiesShort = new Vector<>();
        Vector<Review> reviewsLong = new Vector<>();
        Vector<Review> reviewsShort = new Vector<>();

        int choice, option;
        String name;

        System.out.println("Hello and welcome to our Volunteer Opportunity System.\n");

        Scanner inp = new Scanner(System.in);
        try {
        do {
            System.out.println("Options: ");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.print("Choice: ");
            option = inp.nextInt();
            System.out.println();

            if (option == 1) {
                do {
                    System.out.print("Are you an organizer or volunteer? Organizer = 1 // Volunteer = 2 \nChoice: ");
                    choice = inp.nextInt();
                } while (choice != 1 && choice != 2);

                System.out.println();
                inp.nextLine();

                if (choice == 1) {
                    System.out.print("Enter your name: ");
                    String n = inp.nextLine();
                    System.out.print("Enter your email: ");
                    String e = inp.nextLine().toLowerCase();
                    System.out.print("Enter your password: ");
                    String p = inp.nextLine();
                    System.out.print("Enter your organization name: ");
                    String o = inp.nextLine();
                    organizers.add(new Organizer(n, e, p, o));
                }

                else if (choice == 2) {
                    System.out.print("Enter your name: ");
                    String n = inp.nextLine();
                    System.out.print("Enter your email: ");
                    String e = inp.nextLine().toLowerCase();
                    System.out.print("Enter your password: ");
                    String p = inp.nextLine();
                    System.out.print("Enter your skills: ");
                    String s = inp.nextLine();
                    System.out.print("Enter your availability time: ");
                    String a = inp.nextLine();
                    volunteers.add(new Volunteer(n, e, p, s, a));
                }
                System.out.println();
            }

            else if (option == 2) {
                do {
                    System.out.print(
                            "Login: Are you an organizer or volunteer? Organizer = 1 // Volunteer = 2 \nChoice: ");
                    choice = inp.nextInt();
                } while (choice != 1 && choice != 2);

                inp.nextLine();
                System.out.println();
                if (choice == 1) {
                    System.out.print("Email: ");
                    String e = inp.nextLine().toLowerCase();
                    System.out.print("Password: ");
                    String p = inp.nextLine();

                    for (int i = 0; i < organizers.size(); i++) {
                        if (organizers.get(i).login(e, p) == true) {
                            System.out.println("Login successful. Welcome, " + organizers.get(i).getName() + "!");
                            do {
                                System.out.print(
                                        "1. Add Short Term Opportunity\n2. Add Long Term Opportunity\n3. Review Application \n4. View All Available Long Term Opportunities\n5. View All Available Short Term Opportunities\n6. Logout\nChoice: ");
                                choice = inp.nextInt();

                                inp.nextLine();

                                if (choice == 1) {
                                    System.out.print("Enter Title: ");
                                    String t = inp.nextLine();
                                    System.out.print("Enter Description: ");
                                    String d = inp.nextLine();
                                    System.out.print("Enter Date and Time: ");
                                    String dt = inp.nextLine();
                                    System.out.print("Enter Location: ");
                                    String l = inp.nextLine();
                                    organizers.get(i).createShortTermOpportunity(t, d, dt, l);
                                    opportunitiesShort.add(new Opportunity(t, d, dt, l,organizers.get(i).getOrganizationName()));
                                    System.out.println();
                                } else if (choice == 2) {
                                    System.out.print("Enter Title: ");
                                    String t = inp.nextLine();
                                    System.out.print("Enter Description: ");
                                    String d = inp.nextLine();
                                    System.out.print("Enter Schedule: ");
                                    String s = inp.nextLine();
                                    System.out.print("Enter Location: ");
                                    String l = inp.nextLine();
                                    organizers.get(i).createLongTermOpportunity(t, d, s, l);
                                    opportunitiesLong.add(new Opportunity(t, d, s, l,organizers.get(i).getOrganizationName()));
                                    System.out.println();
                                } 
                                
                                else if (choice == 3) {

                                    System.out.print(
                                            "which Applications you will review : (1-Long-term / 2-Short-term)\nChoice: ");
                                    choice = inp.nextInt();
                                    inp.nextLine();
                                    System.out.println();

                                    if (choice == 1) {
                                        System.out.println("Choose Application (based on volunteer name):\n");

                                        for (int j = 0; j < opportunitiesLong.size(); j++) {

                                            System.out.println((j + 1) +". "+ volunteers.get(j).toString());

                                        }
                                        name = inp.nextLine();

                                        for (int j = 0; j < opportunitiesLong.size(); j++) {

                                            if (opportunitiesLong.get(j).getApplications().get(j).getVolunteer()
                                                    .getName().equals(name)) {

                                                String feedback;
                                                System.out.print("Enter your feedback : ");
                                                feedback = inp.nextLine();

                                                reviewsLong.add(new Review(opportunitiesLong.get(j).getApplications().get(j), feedback));

                                                reviewsLong.get(j).printFeedback();
                                                System.out.println();

                                            }

                                        }
                                    } else if (choice == 2) {

                                        System.out.println("Choose Application (based on volunteer name):\n");

                                        for (int j = 0; j < opportunitiesShort.size(); j++) {

                                            System.out.println((j + 1) +". "+ volunteers.get(j).toString());

                                        }
                                        name = inp.nextLine();

                                        for (int j = 0; j < opportunitiesShort.size(); j++) {

                                            if (opportunitiesShort.get(j).getApplications().get(j).getVolunteer()
                                                    .getName().equals(name)) {

                                                String feedbackshort;
                                                System.out.print("Enter your feedback : ");
                                                feedbackshort = inp.nextLine();

                                                reviewsShort.add(new Review(opportunitiesShort.get(j).getApplications().get(j),feedbackshort));

                                                reviewsShort.get(j).printFeedback();
                                                System.out.println();
                                            }

                                        }

                                    }

                                } else if (choice == 4) {
                                    for (int j = 0; j < opportunitiesLong.size(); j++) {
                                        System.out.print("Long Term Opportunity #" + (j + 1) + ": ");
                                        System.out.println(opportunitiesLong.get(j).toString());
                                        System.out.println();
                                    }
                                } else if (choice == 5) {
                                    for (int j = 0; j < opportunitiesShort.size(); j++) {
                                        System.out.print("Short Term Opportunity #" + (j + 1) + ": ");
                                        System.out.println(opportunitiesShort.get(j).toString());
                                        System.out.println();
                                    }
                                } else if (choice == 6) {
                                    organizers.get(i).logout();
                                    System.out.println();
                                    break;
                                }
                            } while (true);

                        } 
                    }

                }

                else if (choice == 2) {
                    System.out.print("Email: ");
                    String e = inp.nextLine().toLowerCase();
                    System.out.print("Password: ");
                    String p = inp.nextLine();

                    for (int i = 0; i < volunteers.size(); i++) {

                        if (volunteers.get(i).login(e, p) == true) {
                            System.out.println("Login successful. Welcome, " + volunteers.get(i).getName() + "!");
                            System.out.println();
                            System.out.println("Available Options: ");
                            do {
                                System.out.print(
                                        "1. Join Long Term Opportunity\n2. Join Short Term Opportunity\n3. View Long-term Opportunities\n4. View Short-term Opportunities\n5. show review\n6. logout \nChoice: ");
                                choice = inp.nextInt();
                                System.out.println();

                                if (choice == 1) {
                                    System.out.println("choose the Opportuninity : (based on number)");

                                    for (int j = 0; j < opportunitiesLong.size(); j++) {
                                        System.out.print("Long Term Opportunity #" + (j + 1) + ": ");
                                        System.out.println(opportunitiesLong.get(j).toString());
                                        System.out.println();
                                    }

                                    choice = inp.nextInt();

                                    if(choice-1 == i){

                                    volunteers.get(i).applyForOpportunity(opportunitiesLong.get(choice-1));
                                    }
                                }

                                else if (choice == 2) {
                                     System.out.println("choose the Opportuninity : (based on number)");

                                    for (int j = 0; j < opportunitiesShort.size(); j++) {
                                        System.out.print("Short Term Opportunity #" + (j + 1) + ": ");
                                        System.out.println(opportunitiesShort.get(j).toString());
                                        System.out.println();
                                    }

                                    choice = inp.nextInt();

                                    if(choice-1 == i){

                                    volunteers.get(i).applyForOpportunity(opportunitiesShort.get(choice-1));

                                    }
                                }

                                else if (choice == 3) {
                                    for (int j = 0; j < opportunitiesLong.size(); j++) {
                                        System.out.print("Long Term Opportunity #" + (j + 1) + ": ");
                                        System.out.println(opportunitiesLong.get(j).toString());
                                        System.out.println();
                                    }
                                }

                                else if (choice == 4) {
                                    for (int j = 0; j < opportunitiesShort.size(); j++) {
                                        System.out.print("Short Term Opportunity #" + (j + 1) + ": ");
                                        System.out.println(opportunitiesShort.get(j).toString());
                                        System.out.println();
                                    }
                                }

                                else if (choice == 5){

                                System.out.println("Which review to print : (1-Long / 2-short)");

                                System.out.print("choice: ");
                                int ans = inp.nextInt();

                                if(ans == 1){
                                      reviewsLong.get(i).printFeedback();
                                      System.out.println();
                                }
                              else if(ans == 2){
                                    reviewsShort.get(i).printFeedback();
                                    System.out.println();
                               }
                               else{
                                System.out.println("Invalid Reply!");
                                System.out.println();
                               }


                                }

                                else if (choice == 6) {
                                    volunteers.get(i).logout();
                                    break;
                                }

                            } while (true);
                            

                        }
                    }
                }

            }

        } while (true);

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please enter a number.");
            inp.next();

        } catch (IndexOutOfBoundsException e) {

            System.out.println("Array is empty. Please try again.");

        }
    }
}
