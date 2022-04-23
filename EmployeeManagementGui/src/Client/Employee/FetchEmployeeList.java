package Client.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FetchEmployeeList implements EmployeeInterface {
    public FetchEmployeeList(){
        try {
            FileReader fr = new FileReader("Employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                String[] line = str.split(",");
                String name = line[0];
                int id = Integer.parseInt(line[1]);
                String post = line[2];
                double salary = Double.parseDouble(line[3]);
                Employee emp = new Employee(name, id, post, salary);
                employeeList.add(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printList(){
        for(Employee employee:employeeList){
            System.out.println(employee.toString());
        }
    }
}
