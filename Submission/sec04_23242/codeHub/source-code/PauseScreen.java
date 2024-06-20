import java.util.Scanner;

class PauseScreen {

    public void ClearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
    public void pauseScreen(Scanner scanner) {

        System.out.println("Press Enter to continue...");
        scanner.nextLine();  // Waits for the user to press Enter
    }
}
