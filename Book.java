/*
Name:  Joseph Waite, Joel Straatman, Cassandra Nicolak
MacID: waitejg, straatjc, nicolace
Student Number:  001403712, 001314676, 0971847
Description: Homework 4 Java final
*/
import java.io.*;
import java.util.*;
public class Book extends Readable
{
	
	public Book(String fileName, String type){	
		super(fileName, type);}

	public ArrayList<String[]> getInfo(){
		return list;
	}
	public int getPrice(int sNo)
	{
		int result = -1;
		for (int i=0; i<list.size(); i++){
			if (list.get(i)[0] == String.valueOf(sNo)){
				String foo = list.get(i)[3];
				result = (Integer.parseInt(foo)*100)*102/100;
			}
		}
		return result;
	}
}