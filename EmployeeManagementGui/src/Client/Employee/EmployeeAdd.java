package Client.Employee;

import Client.FileOperations.FileSave;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeAdd implements EmployeeInterface{
    Scanner sc= new Scanner(System.in);
    public void checkEmployee(){

        while(true) {
            System.out.println("Are you a registered stuff?(Y/N)");
            String registered = sc.nextLine();
            if (registered.compareTo("N") == 0) {

                EmployeeInput employeeInput=new EmployeeInput();

                String name=employeeInput.getName();

                int id=employeeInput.getID();

                String post=employeeInput.getPost();

                double salary=employeeInput.getSalary();

                Employee employee=new Employee(name, id, post, salary);

                employeeList.add(employee);

                saveEmployeeRecords(employee);
            } else {
                System.out.println("Returning...");
                break;
            }
        }
    }

    public void saveEmployeeRecords(Employee employee){
        FileSave save=new FileSave(employee,true);
        ExecutorService threadExecutor= Executors.newCachedThreadPool();
        threadExecutor.execute(save);
        threadExecutor.shutdown();
    }
    public void printList(){
        for(Employee emp:employeeList){
            System.out.println(emp.toString());
        }
    }
}
