package Client.Sort.Threaded;

import Client.Employee.Employee;
import Client.Employee.EmployeeInterface;
import Client.Sort.SalaryComparator;

public class ThreadedSalarySort implements Runnable, EmployeeInterface {
    public synchronized void run(){
        employeeList.sort(new SalaryComparator());
    }

    @Override
    public void printList(){
        for(Employee emp:employeeList){
            System.out.println(emp.toString());
        }
    }
}
