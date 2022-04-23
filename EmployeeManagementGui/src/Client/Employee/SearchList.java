package Client.Employee;

import Client.LinearSearch.LinearSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchList implements EmployeeInterface {
    Scanner sc=new Scanner(System.in);
    LinearSearch<String> stringLinearSearch=new LinearSearch<String>();
    LinearSearch<Integer> integerLinearSearch=new LinearSearch<Integer>();
    List<String> nameList=new ArrayList<>();
    List<Integer>idList=new ArrayList<>();
    List<String>postList=new ArrayList<>();
    public void search(){
        System.out.println("What do you want to search? 1. Name 2. ID 3. Post");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice ==1){
            makeNameList();

            EmployeeInput employeeInput=new EmployeeInput();
            String toSearch=employeeInput.getName();

            int index=stringLinearSearch.Search(nameList,toSearch);
            System.out.printf("Found at index %d\n",index);
        }
        else if(choice==2){
            makeIDList();

            EmployeeInput employeeInput=new EmployeeInput();
            int toSearch=employeeInput.getID();

            int index=integerLinearSearch.Search(idList,toSearch);
            System.out.printf("Found at index %d\n",index);

        }
        else if(choice==3){
            makePostList();

            EmployeeInput employeeInput=new EmployeeInput();
            String toSearch=employeeInput.getPost();

            int index=stringLinearSearch.Search(postList,toSearch);
            System.out.printf("Found at index %d\n",index);

        }

    }
    //Overloaded method
    public boolean search(String name, int id, String post){
        //Checking name
        makeNameList();
        int nameIndex=stringLinearSearch.Search(nameList,name);
        //Checking id
        makeIDList();
        int idIndex=integerLinearSearch.Search(idList,id);
        //Checking post
        makePostList();
        int postIndex=stringLinearSearch.Search(postList,post);


        if(nameIndex!=-1 && idIndex!=-1 && postIndex!=-1){
            if(post.equals("Manager")) {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public void makeNameList(){
        for(Employee employee:employeeList){
            nameList.add(employee.getName());
        }
    }
    public void makeIDList(){
        for(Employee employee:employeeList){
            idList.add(employee.getID());
        }
    }
    public void makePostList(){
        for(Employee employee:employeeList){
            postList.add(employee.getType());
        }
    }

    public void printList(){
        for(Employee emp:employeeList){
            System.out.println(emp.toString());
        }
    }
}
