package package2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner; 

public class Lab1 {
	
	private static String opendirectory = "C:\\phase1\\";
	private static Scanner sc;
	
	public static void main(String[] args) {
	
	Lab1.welcomescreen();
	Lab1.mainmenu();
		
	}
	        
	
	private static void welcomescreen() {
		System.out.println("**************************************************");	
		System.out.println("	       Lockers.com");
		System.out.println("	  Application Prototype");
		System.out.println("         Client: Lockers Pvt. Ltd");
		System.out.println(" Full Stack Java Developer: Suruthi Suresh\n");
		System.out.println("**************************************************");		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}
	
	private static void mainmenu() { // start of MAIN MENU method
				
		System.out.println("**************************************************");
		System.out.println("            	MAIN MENU                     ");
		System.out.println("**************************************************");
		System.out.println("1. Display the available files in Ascending order ");
		System.out.println("2. Perform Business level operations");
		System.out.println("3. Close the application");
		System.out.println("**************************************************");
		System.out.println("");
		System.out.println("Please enter your choice");
		
		try (Scanner xyz = new Scanner(System.in)) {
			int mainmenuchoice = xyz.nextInt();
			
				
				try {
					
				switch(mainmenuchoice)
				{
				case 1:
					System.out.println("Displaying all files from "+ opendirectory);
					displayallfiles();
					break;
				case 2:
					displayoperationsmenu();
					break;
				case 3:
					System.out.println("Closing the Application");
					System.out.println("See you next time");
					break;
				
				}//end of switch
				
				}catch(Exception e) {
					System.out.println("Please enter a valid response");
					e.printStackTrace();
				}
		}		
	}// end of main menu method
	
	//Displaying files in Ascending order (Option 1)
	public static void displayallfiles(){
		
		File directory = new File(opendirectory);
		String files[] = directory.list();
		
		Arrays.sort(files);
		int numberoffiles = files.length;
		
		for(int k=0;k<files.length;k++) {
			System.out.println(files[k]);
			
		}
		
		System.out.println("There are " +numberoffiles+ " files in the directory.");
			
	}//end of display all files method	
	
	
	//Displaying operations menu (Option 2)
	public static void displayoperationsmenu() {
		
		System.out.println("**************************************************");
		System.out.println("            BUSINESS OPERATIONS MENU                    ");
		System.out.println("**************************************************");
		System.out.println("1. Add a file ");
		System.out.println("2. Delete a file");
		System.out.println("3. Search a file");
		System.out.println("4. Go back to Main Menu");
		System.out.println("**************************************************");
		System.out.println("");
		System.out.println("Please enter your choice");
		
		try (Scanner jkl = new Scanner(System.in)) {
			int businessoption= jkl.nextInt();			
		try {
			switch(businessoption) {
			case 1:
				System.out.println("Enter the name of the file to be added");
				addfile();
				break;
			case 2:
				System.out.println("Enter the name of the file to be deleted");
				deletefile();
				break;
			case 3:
				System.out.println("Enter the name of the file to be searched");
				searchfile();
				break;
			case 4:
				mainmenu();
				break;
			default:
				System.out.println("Please enter a valid response");
				break;
				}	// end of switch
		}catch(Exception e) {
			e.printStackTrace();
		} // end of catch
	}
	
	} // end of operations menu
	
	private static void addfile() {
		
		try (Scanner abc = new Scanner(System.in)) {
			String name = abc.nextLine();
			File addfile = new File(opendirectory+name);
			try {
				boolean isnewfilecreated = addfile.createNewFile();
				if(isnewfilecreated) {
					System.out.println("The new file is added");
				}
				else {
					System.out.println("The file already exists");
				}
			} catch (IOException e) {
				
				e.printStackTrace();
				System.out.println("That is an ivalid file name");
			}
		}
	} //end of add file method
		
	
	private static void deletefile() {
		
		try (Scanner def = new Scanner(System.in)) {
			String name1 = def.nextLine();
			File deletefile = new File(opendirectory+name1);
			
				if(deletefile.exists()) {
					deletefile.delete();
					System.out.println("The file "+name1+" has been deleted");
				}
				else {
					System.out.println("This file does not exist");
				}
		     }
		 } //end of delete file method
			 
	private static void searchfile() {
		
		try (Scanner ghi = new Scanner(System.in)) {
			String name2 = ghi.nextLine();
			File searchfile = new File(opendirectory+name2);
				
					if(searchfile.exists()) {
						System.out.println("The file "+name2+" is found");
					}
					else {
						System.out.println("The file does not exist");
					}
				}
			}// end of search file method
				
	}
	
	
