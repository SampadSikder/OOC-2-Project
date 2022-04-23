package Client.Employee;

import Client.Socket.ClientSocket;

import java.util.Scanner;

public class EmployeeManager implements EmployeeInterface{
    protected Scanner sc= new Scanner(System.in);
    public EmployeeManager(){
        System.out.println("1.Register 2.Search 3.Sort 4.Delete: 5.Upload 6.Download from Cloud");
        int choice=sc.nextInt();
        if(choice==1){
            EmployeeAdd add=new EmployeeAdd();
            add.checkEmployee();
        }
        else if(choice==2){
            SearchList sr=new SearchList();
            sr.search();
        }
        else if(choice==3){
            SortList s=new SortList();
            s.sort();
        }
        else if(choice==4){
            DeleteList d= new DeleteList();
            d.delete();
        }else if(choice==5){
            ClientSocket c=new ClientSocket("Upload");
        }
        else if(choice==6){
            ClientSocket c=new ClientSocket("Download");
        }
        else{
            System.out.println("Enter correct choice");
        }

    }

    public void printList(){
        for(Employee employee:employeeList){
            System.out.println(employee.toString());
        }
    }
}
