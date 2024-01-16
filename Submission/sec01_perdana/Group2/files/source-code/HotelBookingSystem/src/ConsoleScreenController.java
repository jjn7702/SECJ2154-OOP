// Inheritance: The class implements the UserInterface interface, indicating that it provides the functionality specified by the interface.
public class ConsoleScreenController implements UserInterface {

    // Encapsulation: The method encapsulates the logic to clear the console screen.
    public void clearScreen() { 
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Encapsulation: The method encapsulates a simple loading animation logic.
    public void loadingAnimation(){
        for (int i = 0; i < 3; i++) {
            try {
                System.out.print(".");
                Thread.sleep(1700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Encapsulation: The method encapsulates the logic to print a centered header.
    public void printCenteredHeader(String header) {
        // Encapsulation: Calculates the padding dynamically based on the length of the header.
        int headerPadding = (80 - header.length()) / 2;  // Assuming console width is 80 characters
        System.out.printf("%" + headerPadding + "s%s%" + headerPadding + "s%n%n", "", header, "");
    }
}
