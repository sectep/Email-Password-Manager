package passportvalult;

import java.util.Scanner;

// a class, which manages the user data.it can't be extended.
public class VaultEntry {
    private int number;
    private String password, email;
    private Scanner scanner = new Scanner(System.in);

    // ask the user for a password.
    private String askPassword() {

        System.out.print("Write new password: ");
        password = scanner.nextLine();
        return password;
    }

    // ask the user for email.
    private String askEmail() {
        System.out.print("Write an email: ");
        email = scanner.nextLine();
        return email;
    }

    // launch the app, based on the number.
    void startApp() {
        display();
        System.out.print("Choose: ");

        // get the integer value.
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Please, write an integer number" +
                    "for further access of our functions!");
            return;
        }

        // make an action, based on chosen option.
        switch (number) {
            case 1:
                email = askEmail();
                password = askPassword();
                VaultManager.addEmail(email, password);
                break;
            case 2:
                email = askEmail();
                VaultManager.readPassword(email);
                break;
            case 3:
                System.out.println("The function is not avaible yet.");
                break;
            case 4:
                System.out.println();
                startApp();
                break;
            case 5:
                System.out.println("The program is terminated.");
                break;
            default:
                System.out.println("We only have 5 options(1-5)");
                break;
        }
    }

    private void display() {
        System.out.println("=== PASSWORD VAULT ===");
        System.out.println("1. Add new password");
        System.out.println("2. Find password");
        System.out.println("3. Delete password");
        System.out.println("4. Show all");
        System.out.println("5. Exit");
    }
}
