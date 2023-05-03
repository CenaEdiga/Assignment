package sdbms;

import java.util.Scanner;

import customexception.Invalidchoiceexception;


public class Solution {
	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);

		System.out.println("Welcome to student database ");
		System.out.println("-----------------------------------------------");

		StudentManagementSystem sms=new StudentManagementSystemImpl();


		while(true) {
			System.out.println(" 1: Add Student \n 2:Display Student\n 3:Display all Student\n 4:Remove Student\n  5: Remove all Student \n 6: Update Student\n 7:count Student\n8 : Sort Student\n9:Get Student With highest Marks\n10:Get Student with lowest Marks\n11:EXIT\n");

			System.out.println("Enter your choice");


			int choice = scn.nextInt();

			switch(choice) {

			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();;
				break;
			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeallStudents();
				break;

			case 6:
				sms.updateStudents();
				break;
			case 7:
				sms.countStudents();
				break;
			case 8:
				sms.sortStudents();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Database is Ended");	
				System.exit(0);
				
			default:
				try {
					
				
				String message="Invalid choice ,Enter valid choice !";
				throw new Invalidchoiceexception(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}//end of switch



		}//end of while



	}//end of main


}//end of class
