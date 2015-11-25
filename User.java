/*
Name:  Joseph Waite, Joel Straatman, Cassandra Nicolak
MacID: waitejg, straatjc, nicolace
Student Number:  001403712, 001314676, 0971847
Description: Homework 4 Java final
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class User {

    private static String user;

// Register Username
    public static void addUser(String input) {
        if (checkExists(user) == false) {
            try {
                FileWriter writer = new FileWriter("Users.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                bufferedWriter.newLine();
                bufferedWriter.write(input);

                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("User already exisits.");
        //End of user registration (write to file).
    }


// Search for User
    public static boolean checkExists(String input) {
        File file = new File("Users.txt");

        try {
            Scanner scanner = new Scanner(file);
            //now read the file line by line...
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if (line.equals(input)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e ) {
            System.out.println("Users.txt not found");
            return false;
        }
        return false;
    }



//Stores Username
    public static void setUsername(String userp) {
        //Ask the user to enter a user, then pass the user to
        //the methods to search for or add that user.
        user = userp;
    }
    public static String getUsername() {
        return user;
    }


// Login Function
    public static void username(String user) {
        if (checkExists(user) == true)
            System.out.println("Hello " + user + "! You are now"
                               + " signed in.");
        // (Display P5)
        else
            System.out.println("No Access.");
        // (Bring back to sign-in UI page to register.)
    }
}
