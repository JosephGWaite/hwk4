/*
Name:  Joseph Waite, Joel Straatman, Cassandra Nicolak
MacID: waitejg, straatjc, nicolace
Student Number:  001403712, 001314676, 0971847
Description: Homework 4 Java final
*/
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import java.io.Console;


//getItem is different from viewContents

public class UserInterface {

	Book ourBooks = new Book("Books.txt", "Book");
	MP3 ourMP3s = new MP3("MP3.txt", "MP3");
	CD ourCDs = new CD("CDs.txt", "CD"); 
	eBook ourEBooks = new eBook("Ebooks.txt", "eBook");
	User ourUser = new User();
	ShoppingCart ourCart = new ShoppingCart();
	//Hold our values to be formatted.
	private ArrayList<String[]> readables = new ArrayList<String[]>(); //Piazza says we can change these types
	private ArrayList<String[]> audioProducts = new ArrayList<String[]>();

	private int currentPage = 1;
	private String username;

	Console cnsl = System.console();

	public void start() {
		//Called by main
		//
		//def not a constructor
		changeCurrentPage(1);
	}
	public void getCurrentPage() {
		//method is for page navigation
		//call a different page depending on the state variables
		//Should be a getter, but w/e

		refresh();
		switch (currentPage) {
		case 1:
			page1();
			break;
		case 2:
			page2();
			break;
		case 3:
			page3and4();
			break;
		case 4:
			page3and4();
			break;
		case 5:
			page5();
			break;
		case 6:
			page6();
			break;
		case 7:
			page7();
			break;
		case 8:
			page8();
			break;
		case 9:
			page9();
			break;
		case 10:
			page10();
			break;
		}
	}
	public void changeCurrentPage(int nextPage) {
		//method is for page navigation
		//It should change to current page and show the content
		//Brutal way of doing this
		currentPage = nextPage; //Change the state variable. IDK why we have one. FSM
		getCurrentPage();
	}
	public void refresh() {
		//nice
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	public void getReadables() {
		readables = ourBooks.getInfo();
		readables.addAll(ourEBooks.getInfo());
	}
	public void getAudioProducts() {
		//fetches all audio products from the files and places them in
		//the audioProducts array
		audioProducts = ourCDs.getInfo();
		audioProducts.addAll(ourMP3s.getInfo());
	}
	public void showReadables() {
		//displays all readables for browsing
		getReadables();

		System.out.println("sNo\tName of Book\tAuthor\tPrice ($)\tQuantity In Store\tType");
		for (int i = 0; i < readables.size(); i++) {
			for (int k = 0; k < readables.get(i).length; k++ ) {
				System.out.print(readables.get(i)[k] + "\t");
			}
		}
	}
	public void showAudioProducts() {
		getAudioProducts();
		//Displays all audio products for browsing
		System.out.println("sNo | Name | Artist | Price ($) | Quantity In Store | Type");

		String output = ""; 
		for (int i = 0; i < audioProducts.size(); i++) {
			System.out.println(audioProducts.size());
			for (String j: audioProducts.get(i)) {
				output += j + "\t";
			}
			output += ("\n");
		}
		System.out.println(output);
	}
	public void page1() {
		//PAGE ONE
		//	1. Sign in --> Page 3
		//	2. Sign up --> Page 2
		System.out.println("1. Sign in");
		System.out.println("2. Sign up");

		while (true) {
			String input = cnsl.readLine(); //User select 1 or 2
			if (input.equals("2")) {
				changeCurrentPage(2);
				break;
			} else if (input.equals("1")) {
				changeCurrentPage(3);
				break;
			}
		}
	}
	public void page2() {
		//PAGE TWO
		//	Choose your username: {user input}
		//	Username added successfully to Users.txt
		//	Redirect to page 1

		System.out.println("choose your username:");
		String name = cnsl.readLine();

		ourUser.addUser(name); 
		changeCurrentPage(1);
	}
	public void page3and4() {
		//pages 3 and 4 are the same. No reason for them to be seperated.

		//List<String> lines = Files.readAllLines(Paths.get("Users.txt");

		System.out.println("Enter your username");
		String input = cnsl.readLine();

		if (ourUser.checkExists(input)) { //lines.contains(input)
			System.out.println("Hello " + input);
			ourUser.setUsername(input);
			changeCurrentPage(5);
		} else if (ourUser.checkExists(input) == false) {
			System.out.println("NO ACCESS");
			//Pause, wait for keyboard input then proceed.
			cnsl.readLine();
			changeCurrentPage(1); 
		}
	}

	public void page5() {
		//PAGE 5
		//	1. View Items By Category --> Page 6
		//	2. View Shopping Cart  	  --> Page 7
		//	3. Sign out 			  --> Page 2

		System.out.println("1. View Items By Category");
		System.out.println("2. View Shopping Cart");
		System.out.println("3. Sign Out");
		System.out.println("");

		while (true) {
			String input = cnsl.readLine();

			if (input.equals("1")) {
				changeCurrentPage(6);
				break;
			} else if (input.equals("2")) {
				changeCurrentPage(7);
				break;
			} else if (input.equals("3")) {
				changeCurrentPage(1);
				break;
			}
		}
	}

	public void page6() {
		//PAGE 6
		//	1. Readables --> Page 8
		//	2. Audio 	 --> Page 9
		// -1            --> Page 5
		System.out.println("1. Readables");
		System.out.println("2. Audio ");
		System.out.println("-1 To go back");
		System.out.println("");

		while (true) {
			String input = cnsl.readLine();

			if (input.equals("1")) {
				changeCurrentPage(8);
			} else if (input.equals("2")) {
				changeCurrentPage(9);
			} else if (input.equals("-1")) {
				changeCurrentPage(5);
			}
		}
	}

	public void page7() {
		//Display Contents of shoppingcart.txt
		//-1 to go back
		ShoppingCart.showContent();
		System.out.println("Press -1 to return to previous menu");

		while (true) {
			String input = cnsl.readLine();
			if (input.equals("-1")) {
				changeCurrentPage(6);
			}
		}
	}

	public void page8() {
		//Display Contents Of Readables
		// Select S.No, then select quantity.
		// -1 to go back

		showReadables();

		System.out.println("Enter the S.No: ");
		System.out.println("Or press -1 to return to previous menu: ");

		while (true) {
			String input = cnsl.readLine();
			if (input.equals("-1")) {
				changeCurrentPage(6);
			} else if (ourBooks.isValid(Integer.parseInt(input))) {
				System.out.println("Enter quantity: ");
				String quantity = cnsl.readLine();
				ourCart.addItem(ourBooks.getItem(Integer.parseInt(input)), Integer.parseInt(quantity)); //TODO: who decrements the value in the item.txt
			}
		}
	}

	public void page9() {
		//Display Contents Of Audio
		// -1 to go back

		showAudioProducts();

		System.out.println("Press -1 to return to preovious menu");

		while (true) {
			String input = cnsl.readLine();
			if (input.equals("-1")) {
				changeCurrentPage(6);
				break;
			} else if (ourCDs.isValid(Integer.parseInt(input))) {
				System.out.println("Enter quantity: ");
				String quantity = cnsl.readLine();
				ourCart.addItem(ourCDs.getItem(Integer.parseInt(input)), Integer.parseInt(quantity)); //TODO: who decrements the value in the item.txt
			} else if (input.equals("-2")) {
				changeCurrentPage(6);
				break;
			} else if (input.equals("0")) {
				changeCurrentPage(10);
				break;
			}
		}
	}

	public void page10() {
		//Show check out screen here.
		//TODO: Ask group best way to do this.
		System.out.print("Are you sure you want to pay? ");

		while (true) {
			String confirm = cnsl.readLine();
			if (confirm.equalsIgnoreCase("yes")) {
				//generate a confirmation ID, how?
				System.out.println("confirmation ID: " + ourCart.confirmationID());
				System.out.println("Items shipped to Mr. " + ourUser.getUsername() );
			} else if (confirm.equalsIgnoreCase("no")) {
				//TODO: What now?
				//loop
			}
		}
	}
}
