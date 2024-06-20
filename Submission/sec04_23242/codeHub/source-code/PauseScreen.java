import java.util.Scanner;

public class PauseScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is some initial content.");
        
        // Pause and wait for the user to press Enter
        pauseScreen(scanner);
        
        System.out.println("This is new content displayed after pressing Enter.");
    }

    public static void pauseScreen(Scanner scanner) {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();  // Waits for the user to press Enter
    }
}
