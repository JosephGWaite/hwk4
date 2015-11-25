/*
Name:  Joseph Waite, Joel Straatman, Cassandra Nicolak
MacID: waitejg, straatjc, nicolace
Student Number:  001403712, 001314676, 0971847
Description: Homework 4 Java final
*/
public class MP3 extends Audio
{
	
	public MP3(String fileName, String type){
		super(fileName, type);
	}

	public int getPrice(int sNo)
	{
		int result = -1;
		for (int i=0; i<list.size(); i++){
			if (list.get(i)[0] == String.valueOf(sNo)){
				result =  Integer.parseInt(list.get(i)[3]);
			}
		}
		return result;
	}
}