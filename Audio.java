/*
Name:  Joseph Waite, Joel Straatman, Cassandra Nicolak
MacID: waitejg, straatjc, nicolace
Student Number:  001403712, 001314676, 0971847
Description: Homework 4 Java final
*/
import java.io.*;
import java.util.*;
public class Audio extends Item {
	public Audio(String fileName, String type) {
		try {
			ArrayList<String[]> list = new ArrayList<String[]>();
			FileReader fileReader = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fileReader);
			while (in.readLine() != null) {
				// String str = in.readLine();
				// List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
				// items.add(type);
				// String[] strings = items.toArray(new String[items.size()]);
				// list.add(strings);
				String str = in.readLine();
				if (str != null){
					String[] strings = str.split("\\s*,\\s*");
					list.add(strings);
				}
			}
			in.close();
			this.list = list;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file. @ audio " + ex);
		} catch (IOException ex) {
			System.out.println("Error reading file.");
		}
	}

	public ArrayList<String[]> getInfo() {
		return list;
	}

	public boolean isValid(int sNo) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0] == String.valueOf(sNo)) {
				result = true;
			}
		}
		return result;
	}

	public String[] getItem(int sNo) {
		String[] result = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0] == String.valueOf(sNo)) {
				result = list.get(i);
			}
		}
		return result;
	}
	public int getPrice(int sNo) {
		int result = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0] == String.valueOf(sNo)) {
				result = Integer.parseInt(list.get(i)[3]);
			}
		}
		return result;
	}
}