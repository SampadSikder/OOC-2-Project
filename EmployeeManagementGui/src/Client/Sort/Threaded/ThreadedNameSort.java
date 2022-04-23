package Client.Sort.Threaded;

import Client.Employee.Employee;
import Client.Employee.EmployeeInterface;
import Client.Sort.NameComparator;

public class ThreadedNameSort implements Runnable, EmployeeInterface {
    public synchronized void run(){
        employeeList.sort(new NameComparator());
    }

    @Override
    public void printList(){
        for(Employee emp:employeeList){
            System.out.println(emp.toString());
        }
    }
}
