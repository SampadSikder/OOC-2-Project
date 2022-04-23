package Client.Sort;

import Client.Employee.Employee;

import java.util.Comparator;

public class IDComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee a, Employee b) {
        return a.getID()-b.getID();
    }

}
