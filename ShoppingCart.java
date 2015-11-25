/*
Name:  Joseph Waite, Joel Straatman, Cassandra Nicolak
MacID: waitejg, straatjc, nicolace
Student Number:  001403712, 001314676, 0971847
Description: Homework 4 Java final
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class ShoppingCart extends User {

	private static String user;

//content(array) will have the current list of items in the shopping cart.
	private static ArrayList<String> content;

//Create a file and store content(array) information
	//This is never called, not sure why its here
	
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("Cart_" + user + ".txt");
		ArrayList<String> strs = getContent();
		for (int i = 0; i < strs.size(); i++) {
			fw.write(strs.get(i) + "\n");
		}
		fw.close();
	}

//Returns the content of the shopping cart
	public static ArrayList<String> getContent() {
		return content;
	}

//Add items into content(array)        ArrayList<String>
	public static int addItem(String[] newItem, int quantity) {
		//content.add(e)
		//Call addItem() to add more items into content(array)
		//Readable  ArrayList<String[]> list
		//.addItem(Readables.getItem(input), quantity);
		return 1 ; 
	}

	public static String confirmationID() {
		return "1000"; //it's 4am
	}


//Print Contents of Cart_[username].txt
	public static void showContent() {
		try {
			FileReader reader = new FileReader("Cart_" + user + ".txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch ( FileNotFoundException fnfe ) {
			System.out.println( "Error: Unable to find shopping cart file." );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} //end


// Notes:
//
// The shopping cart is supposed to store data about what it contains internally
// in a private variable name "content".
// This is meant to be inaccessible to others except through the getContent method.
//
// The method "public String getUsername(...) { // stores the username".
// This method must hold the details of the user who has logged in currently.
// This method is useful when we choose to View the Shopping Cart. Each user might
// have a different list of items in the Shopping Cart.
