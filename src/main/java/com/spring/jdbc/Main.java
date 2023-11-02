package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc  = null;
    public static void main(String[] args) {

        sc = new Scanner(System.in);
        int choice;
        //spring jdbc require jdbcTemplate
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);


        System.out.println("----STUDENT MANAGEMENT SYSTEM----");
        while (true){
            System.out.println();
            System.out.println("OPTIONS: ");
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Get Student");
            System.out.println("5. Get all Students");
            System.out.println("6. Exit");
            System.out.println();

            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice){
                case  1:
                    Student insertObj = getStudentDetails();
                    System.out.println(
                            "Student Added Successfully. Number of row affected "
                                    + studentDao.insertStudent(insertObj));
                    System.out.println();

                    break;

                case 2:
                    Student updateObj = getStudentDetails();
                    System.out.println(
                            "Student Updated Successfully. Number of row affected "
                                    + studentDao.updateStudent(updateObj));
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Enter the student Id: ");
                    int stdDeleteId = sc.nextInt();
                    System.out.println(
                            "Student Deleted Successfully with Id : "+ stdDeleteId+ " , Number of row affected "
                                    + studentDao.deleteStudent(stdDeleteId));
                    System.out.println();
                    break;

                case  4:
                    System.out.println("Enter the student Id: ");
                    int stdGetId = sc.nextInt();
                    System.out.println(studentDao.getStudent(stdGetId));
                    System.out.println();
                    break;

                case 5:
                    List<Student> list = studentDao.getAllStudent();
                    for(Student st: list){
                        System.out.println(st);
                    }
                    System.out.println();
                    break;

                case 6:
                     System.exit(0);
                default:
                    System.out.println("Enter a valid option.");
            }
        }



    }

    public static Student getStudentDetails(){
        int stdId; String stdName; String stdCity;

        System.out.println("Enter the Student Details:");
        System.out.println("Id:");
        stdId = sc.nextInt();
        sc.nextLine();
        System.out.println("Name:");
        stdName = sc.nextLine();
        System.out.println("City:");
        stdCity = sc.nextLine();

        return new Student(stdId,stdName,stdCity);
    }
}
