# Email-Password-Manager
A simple command-line application to manage email-password pairs. Users can add new entries, retrieve passwords by email, and display all stored credentials. Data is stored in a text file for persistence. Built with Java, this project emphasizes ease of use and basic error handling. Perfect for securely managing your passwords!

---

## 📋 Features

- ✅ Add new password
- 🔍 Find password by email
- ❌ Delete password (not implemented yet)
- 📋 Show all passwords (not implemented yet)

Passwords are stored in the `vault.txt` file using the following format:

```
#example@email.com
YourPassword123
```

---

## 🚀 How to Run

1. **Clone the repository** or copy the code to your local machine.
2. **Move all `.java` files into a folder named** `passportvalult`.
3. Open your terminal and compile the project:
   ```bash
   javac passportvalult/*.java
   ```
4.Run the program:
  ```bash
  java passportvalult.Main
  ```

##📁 Project Structure
```
project-root/
│
├── vault.txt                  # The file where passwords are stored
└── passportvalult/
    ├── Main.java              # Entry point of the program
    ├── VaultEntry.java        # Handles user input and menu
    └── VaultManager.java      # Handles data reading/writing logic
```
##🔧 Improvements You Can Make
•🔐 Encrypt the passwords before storing them. Add a simple encryption algorithm like Base64 or AES.

•🗑️ Implement delete functionality in the switch-case block.

•📋 Show all saved credentials by looping through the file and printing each entry.

## ✅ Notes
• This project was made for learning purposes.
• It uses basic file I/O, string parsing, input validation, and object-oriented principles.
• Feel free to fork and enhance it!

##💻 Example Output
```
=== PASSWORD VAULT ===
1. Add new password
2. Find password
3. Delete password
4. Show all
5. Exit
Choose: 1
Write an email: test@email.com
Write new password: myStrongPass123
Successfully saved!

=== PASSWORD VAULT ===
1. Add new password
2. Find password
3. Delete password
4. Show all
5. Exit
Choose: 2
Write an email: test@email.com
Password: myStrongPass123
```


