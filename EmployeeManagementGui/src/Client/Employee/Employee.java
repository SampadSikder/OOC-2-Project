package Client.Employee;

public class Employee {
    private int ID;
    private double salary;
    private String name;
    private String personType;
    public Employee(String name, int ID, String personType,double salary){
        this.name=name;
        this.ID=ID;
        this.personType=personType;
        this.salary=salary;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public String getType(){
        return personType;
    }
    public double getSalary(){
        return salary;
    }



    public String toString(){
        return String.format("%s,%d,%s,%.2f",getName(),getID(),getType(),getSalary());
    }
}
