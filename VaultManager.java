package passportvalult;

import java.io.*;

// a class, which manages the password functions.
class VaultManager {
    static String line, currentEmail, password;

    // add new email and password.
    static void addEmail(String email, String password) {
        // let the character stream write new data from end.
        try (BufferedWriter out = new BufferedWriter(new FileWriter("vault.txt", true))) {

            // if the email is not taken, add the password.
            if (!exmailExists(email)) {
                out.write("\n" + "#" + email + "\n");
                out.write(password + "\n");
                System.out.println("Succsessfully saved!");
                return;
            }
        } catch (IOException exc) {
            System.out.println("An error occured while writing the password" + exc);
        }

        System.out.println("The email is in out database.Please write another email.");
    }

    // check if the email is taken
    private static boolean exmailExists(String email) {
        try (BufferedReader in = new BufferedReader(new FileReader("vault.txt"))) {

            // read through a file till the end.
            while ((line = in.readLine()) != null) {

                // check if there are any marked emails.
                if (line.startsWith("#")) {
                    currentEmail = line.substring(1); // read after "#".

                    // check if the email equals to marked email.
                    if (email.equals(currentEmail)) {
                        return true;
                    }
                }
            }
        } catch (IOException exc) {
            System.out.println("Exception has occured while checking for duplicate");
        }
        return false;
    }

    // a method, which reads the password with a given email.
    static void readPassword(String email) {
        try (BufferedReader in = new BufferedReader(new FileReader("vault.txt"))) {
            // read through a file till the end.
            while ((line = in.readLine()) != null) {

                // check if there are any marked emails.
                if (line.startsWith("#")) {
                    currentEmail = line.substring(1);

                    // check if the email equals to marked email.
                    if (email.equals(currentEmail)) {
                        password = in.readLine();
                        System.out.println("Password: " + password);
                        return;
                    }
                }
            }
        } catch (IOException exc) {
            System.out.println("An error occured while reading the password: " + exc);
        }

        System.out.println("Can't find an email in oue database.");

    }
}
