package Client.Sort.Threaded;

import Client.Employee.Employee;
import Client.Employee.EmployeeInterface;
import Client.Sort.IDComparator;


public class ThreadedIDSort implements Runnable, EmployeeInterface {
    public synchronized void run(){
        employeeList.sort(new IDComparator());
    }

    @Override
    public void printList(){
        for(Employee emp:employeeList){
            System.out.println(emp.toString());
        }
    }
}
