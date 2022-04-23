package Client.Employee;

import Client.FileOperations.FileSave;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeleteList implements EmployeeInterface{
    public void delete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Who do you want to delete");

        printList();

        System.out.println("Enter id");
        int deleted_id=sc.nextInt();

        searchAndDelete(deleted_id);
        saveList();

        System.out.println("Entry deleted");
    }

    public void searchAndDelete(int toDelete){
        Iterator<Employee> it = employeeList.iterator();
        while(it.hasNext()){
            if(it.next().getID()==toDelete){
                it.remove();
            }
        }
    }
    public void saveList(){
        int count=0;
        for(Employee employee:employeeList){
            if(count==0){
                saveNewRecord(employee);
            }
            else{
                addRecords(employee);
            }
            count++;
        }
    }

    public void saveNewRecord(Employee employee){
        FileSave save=new FileSave(employee,false);
        ExecutorService threadExecutor= Executors.newCachedThreadPool();
        threadExecutor.execute(save);
        threadExecutor.shutdown();
    }

    public void addRecords(Employee employee){
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
