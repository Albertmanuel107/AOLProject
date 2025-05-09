package id.ac.binus.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Members {
	
	private String regNo;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
    private int date;
    private int month;
    private int year;
    private int count;
    
	public Members(String regNo, String firstName, String lastName, String dateOfBirth, int date, int month, int year,
			int count) {
		super();
		this.regNo = regNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.date = date;
		this.month = month;
		this.year = year;
		this.count = count;
	}

	public String getRegNo() {
		return regNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public int getDate() {
		return date;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getCount() {
		return count;
	}

	protected static ArrayList<Members> getMembersData() throws IOException {
		
		ArrayList<Members> membersList = new ArrayList<>();
		
		try {
            File membersFile = new File("Members.txt");
            Scanner input = new Scanner(membersFile);
            
            while (input.hasNextLine()) {
            	
              String membersData = input.nextLine();
              String[] data = membersData.split("#");
              
              Members member = new Members(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), 
            		  		   Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]));
              membersList.add(member);
            }
            
        } catch (FileNotFoundException e) {
            createMembersFile();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n\t\tIndex out of bound exception...Sorry we are Closing Program\n");
            System.exit(1);
        }
		
		return membersList;
	}
	
	private static void createMembersFile() throws FileNotFoundException {
		
		System.out.println("\n\t\tNo Previous File Exists.So a New 'Members' File is Created\n");
        OutputStream os = new FileOutputStream("Members.txt");
        PrintWriter put = new PrintWriter(os);
        for (int i = 0 ; i < 200 ; i++){
            for (int j = 0; j < 12; j++){
                put.print("null#");
            }
            put.println();
        }
        put.close();
	}
}
