package Client.Sort;

import Client.Employee.Employee;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
