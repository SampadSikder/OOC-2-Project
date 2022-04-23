package Client.Employee;

import java.util.Scanner;

public class EmployeeInput {
    Scanner sc= new Scanner(System.in);
    public String getName(){
        System.out.println("Enter name:");
        String name=sc.nextLine();
        return name;
    }
    public int getID(){
        System.out.println("Enter id:");
        int id=sc.nextInt();
        sc.nextLine();
        return id;
    }
    public String getPost(){
        System.out.println("Enter post:");
        String post=sc.nextLine();
        return post;
    }
    public double getSalary(){
        System.out.println("Enter salary:");
        double salary=sc.nextDouble();
        sc.nextLine();
        return salary;
    }
}
