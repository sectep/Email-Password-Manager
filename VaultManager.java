package passportvalult;

import java.io.*;

// a class, which manages the password functions.
public class VaultManager {
    static char info;
    static String emailReader;
    static String password;
    static boolean emailFound;

    static void addPassword(String email, String pass) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("Vault.txt"))) {

            out.write("#" + email + "\n");
            out.write(pass + "\n");

        } catch (IOException exc) {
            System.out.println("An error occured while reading the password" + exc);
        }
    }

    // a method, which reads the password with a given email.
    static void readPassword(String email) {
        try (BufferedReader in = new BufferedReader(new FileReader("Vault.txt"))) {

            // read to the next file.
            while (info != -1) {
                info = (char) in.read();

                // check if there are any marked emails.
                if (info == '#') {
                    emailReader = in.readLine();

                    // check if the email equals to marked email.
                    if (email.compareTo(emailReader) == 0) {
                        emailFound = true;
                        password = in.readLine();
                        System.out.println(email + ": " + password);
                    }
                }
            }
            if (!emailFound) {
                System.out.println("None email matches in our database.");
                return;
            }
        } catch (IOException exc) {
            System.out.println("An error occured while reading the password" + exc);
        }
    }
}
