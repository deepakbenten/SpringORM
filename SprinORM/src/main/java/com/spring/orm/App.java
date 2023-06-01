package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		/*
		 * Student student=new Student(2355,"deepak kumar","Ramgarh"); int r =
		 * studentDao.insert(student); System.out.println("done "+r);
		 */
       System.out.println("-------------My spring orm project--------------");
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
       while(go)
       {
    	   System.out.println("PRESS 1 : for add new student");
    	   System.out.println("PRESS 2 : for display all student");
    	   System.out.println("PRESS 3 : for get details of single student");
    	   System.out.println("PRESS 4 : for delete student");
    	   System.out.println("PRESS 5 : for update student");
    	   System.out.println("PRESS 6 : for Exit");
    	   try {
			int input = Integer.parseInt(br.readLine());
			/*
			 * if(input==1) { //add a new student } else if(input==2) { //display }
			 */
			switch(input)
			{
			case 1:
				//add new student
				//insert data
				System.out.println("Enter the userId :");
				int uId=Integer.parseInt(br.readLine());
				
				System.out.println("Enter the userName :");
				String uName=br.readLine();
				
				System.out.println("Enter the userCity :");
				String uCity=br.readLine();
				
				//create a object
				Student st=new Student();
				st.setStudentId(uId);
				st.setStudentName(uName);
				st.setStudentCity(uCity);
				
				//store database
				int r = studentDao.insert(st);
				System.out.println(r + " : student added");
				System.out.println("**********************************************");
				System.out.println();
				break;
			case 2:
				//display all student
				System.out.println("**********************************************");
				List<Student> allStudent = studentDao.getAllStudent();
				for(Student s : allStudent)
				{
					System.out.println("Id : "+s.getStudentId());
					System.out.println("Name :"+s.getStudentName());
					System.out.println("City :"+s.getStudentCity());
					System.out.println("-------------------------------------------");
					
				}
				System.out.println("********************************************");
				break;
			case 3:
				//get details of single student
				System.out.println("Enter the userId : ");
				int userId=Integer.parseInt(br.readLine());
				Student student = studentDao.getStudent(userId);
				System.out.println("Id :"+student.getStudentId());
				System.out.println("uName :"+student.getStudentName());
				System.out.println("uCity :"+student.getStudentCity());
				System.out.println("------------------------------------------");
				break;
			case 4:
				//delete a student
				System.out.println("Enter the userId : ");
				int id=Integer.parseInt(br.readLine());
				studentDao.deleteStudent(id);
				System.out.println("Student delete......");
				break;
			case 5:
				//update of student
				break;
			case 6:
				//exit
				go=false;
				break;
			}
			
		} catch (Exception e) {
			System.out.println("Invallid Number Input a vaid number !!");
			System.out.println(e.getMessage());
		}
       }
       System.out.println("**********************Thank you*********************");
       
    }
}
