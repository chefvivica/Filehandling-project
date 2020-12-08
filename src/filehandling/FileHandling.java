package filehandling;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//step 1 create a file
//step 2 read data from the file
//step 3 append data to the file 


public class FileHandling {
	public static List<Drinks> drinkList = new ArrayList<Drinks>();
	public static List<Drinks> drinkReadFile = new ArrayList<Drinks>();
	static String fileName = "drinks.txt";
	public static void main(String[] args) throws IOException {
		
		FileHandling file = new FileHandling();
		file.createFile(fileName);	
		file.getDataFromFile(fileName);
		Drinks drink1 = new Drinks("milk","Farm",3);
		Drinks drink2 = new Drinks("wala","Farm",4);
		drinkList.add(drink1);
		drinkList.add(drink2);
		file.writeToFile(drink1, fileName);
		file.writeToFile(drink2, fileName);	

		drinkReadFile.forEach(d->System.out.println(d));
	}
	
	// create file method to create a new file
	private void createFile(String fileName) {
		try {
			File file = new File(fileName);
			if(file.createNewFile()) {
				System.out.println("file created");		
			}else {
				System.out.println("File already exists");
			}
		}catch(IOException e){
				e.printStackTrace();
			}
		finally {
			System.out.println("finished creating " + fileName );
		}
	}
	
	//read the data from the file
	private void getDataFromFile(String fileName) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			String line ;
			String [] strList;
			
			while((line = bufferedReader.readLine())!= null) {
	
				strList = line.split(",");
				try {
					Drinks drink = new Drinks(strList[0],strList[1],Integer.parseInt(strList[2]));
					drinkReadFile.add(drink);
				} catch (Exception ignore) {
					
				} 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//write data to file 
	private void writeToFile(Drinks drink, String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.append(drink.toString()+"\n");
			drinkList.add(drink);
			writer.close();
 			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	

}