package sdbms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import coustom_sorting.SortStudentByAge;
import coustom_sorting.SortStudentById;
import coustom_sorting.SortStudentByMarks;
import coustom_sorting.SortStudentByName;
import customexception.Invalidchoiceexception;
import customexception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Scanner scn = new Scanner(System.in);
	Map<String, Student> db = new LinkedHashMap<String, Student>();

	// --------------------------------------------------------------------------------------------------
	@Override
	public void addStudent() {

		System.out.println("enter Student age:");
		int age = scn.nextInt();
		System.out.println("enter Student name:");
		String name = scn.next();
		System.out.println("Enter student marks :");
		int marks = scn.nextInt();

		Student std = new Student(age, name, marks);
		db.put(std.getId(), std);
		System.out.println("Student record added Sucessfully");
		System.out.println("Student id is:" + std.getId());
	}

	// ---------------------------------------------------------------------------------------------------------

	@Override
	public void displayStudent() {

		System.out.println("enter the student id : ");
		String id = scn.next();
		id = id.toUpperCase();

		if (db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("id:" + std.getId());
			System.out.println("Age:" + std.getAge());
			System.out.println("name:" + std.getName());
			System.out.println("marks:" + std.getMarks());

		} else {
			try {
				String message = "Student with the Id" + id + "is not found";
				throw new StudentNotFoundException(message);
			} catch (StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	// -----------------------------------------------------------------------------------------------------------------
	@Override
	public void displayAllStudents() {
		if (db.size() != 0) {
			System.out.println("Student records are as follows:");
			System.out.println("---------------------------------------");
			Set<String> keys = db.keySet();
			for (String key : keys) {
				Student std = db.get(key);
				System.out.println(std);
			}
		} else {
			try {
				String message = "Student database is empty ntg to display";
				throw new StudentNotFoundException(message);
			} catch (StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	// ---------------------------------------------------------------------------------------------------------------
	@Override
	public void removeStudent() {

		System.out.println("enter student id:");
		String id = scn.next().toUpperCase();

		if (db.containsKey(id)) {
			System.out.println("Student record created sucessfully");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record deleted sucessfully");

		} else {
			try {

				String message = "Student with the id " + id + " is not found";
				throw new StudentNotFoundException(message);
			} catch (StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	// -----------------------------------------------------------------------------------------------------------------
	@Override
	public void removeallStudents() {

		if (db.size() != 0) {
			System.out.println("Available Student records:" + db.size());
			db.clear();
			System.out.println("all students records deleted sucessfully");
		} else {
			try {

				String message = "Student database is empty ntg to delete";
				throw new StudentNotFoundException(message);
			} catch (StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	// ------------------------------------------------------------------------------------------------------------------
	@Override
	public void updateStudents() {
		System.out.println("enter Student id:");
		String id = scn.next().toUpperCase();
		if (db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("enter 1:To update Age\n 2:update name");
			System.out.println("enter your choice:");
			int choice = scn.nextInt();

			switch (choice) {

			case 1:
				System.out.println("enter age:");
				int age = scn.nextInt();
				std.setAge(age);
				System.out.println("Age updated Sucessfully");
				break;

			case 2:
				System.out.println("enter name:");
				String name = scn.next();
				std.setName(name);
				System.out.println("name updated Sucessfully");
				break;

			case 3:
				System.out.println("enter marks:");
				int marks = scn.nextInt();
				std.setMarks(marks);
				System.out.println("marks updated Sucessfully");
				break;

			default:
				try {

					String message = "Invalid credentials";
					throw new Invalidchoiceexception(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}

		else {
			try {

				String message = "Student with the id" + id + "is not found";
				throw new StudentNotFoundException(message);
			} catch (StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}
	// ------------------------------------------------------------------------------------------------

	@Override
	public void countStudents() {

	}

	// --------------------------------------------------------------------------------------------------------
	@Override
	public void sortStudents() {
		
if(db.size()>=2) {
	
	
	Set<String>keys=db.keySet();
	
	List<Student> list=new ArrayList<Student>();
	for(String key:keys) {
		list.add(db.get(key));
		
	}
	System.out.println("1: Sort student by id\n 2: Sort student by Age");
	System.out.println("3:Sort student by name\n  4:Sort student by marks");
	
	System.out.println("enter choice:");
	int choice=scn.nextInt();
	
	
	switch(choice) {
	case 1:
		Collections.sort(list,new SortStudentById());
		
		display(list);
		
		break;
	case 2:
		Collections.sort(list,new SortStudentByAge());
		display(list);
		break;
	
	case 3:
		Collections.sort(list,new SortStudentByName());
		display(list);
		break;
		
	case 4:
		Collections.sort(list,new SortStudentByMarks());
		display(list);
		break;
		
	default:
		try {

			String message = "invalid choice";
			throw new Invalidchoiceexception(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		break;
	}
}

		else
		{
			try {

				String message = "no sufficient records to sort";
				throw new StudentNotFoundException(message);
			} catch (StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
			
			private static void display(List<Student>list){
				for(Student s:list) {
					System.out.println(s);
				}
			
		
	}

	// --------------------------------------------------------------------------------------------------------
	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
	
		Set<String>keys=db.keySet();
		
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
			
	}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(db.size()-1);
		
		}
	else {
		try {

			String message = "no sufficient records to sort";
			throw new StudentNotFoundException(message);
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}	
	}
				

	// ------------------------------------------------------------------------------------------------------
	@Override
	public void getStudentWithLowestMarks() {
		
		if(db.size()>=2) {
			
			Set<String>keys=db.keySet();
			
			List<Student> list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
				
		}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));
			
			}
		else {
			try {

				String message = "no sufficient records to sort";
				throw new StudentNotFoundException(message);
			} catch (StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}
	// -------------------------------------------------------------------------------------------------------
}
