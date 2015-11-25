/*
Name:  Joseph Waite, Joel Straatman, Cassandra Nicolak
MacID: waitejg, straatjc, nicolace
Student Number:  001403712, 001314676, 0971847
Description: Homework 4 Java final
*/
import java.util.*;
import java.io.*;
public abstract class Item
{
	public abstract ArrayList<String[]> getInfo();
	public abstract int getPrice(int sNo);

	public ArrayList<String[]> list;
}
