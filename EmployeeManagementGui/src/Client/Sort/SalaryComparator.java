package Client.Sort;

import Client.Employee.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return (int)(b.getSalary()-a.getSalary());
    }
}
