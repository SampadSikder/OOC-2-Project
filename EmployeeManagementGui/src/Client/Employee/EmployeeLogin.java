package Client.Employee;

public class EmployeeLogin {
    public EmployeeLogin(){
        FetchEmployeeList fetch=new FetchEmployeeList();
        //fetch.printList();
    }
    public void Login(String name,int id, String post){
        SearchList s=new SearchList();
        if(s.search(name,id,post)){
            System.out.println("Logged in successfully");
            new EmployeeManager();
        }
        else{
            System.out.println("Cannot login!");
        }
    }
}
