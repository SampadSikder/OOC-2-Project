package Client.FileOperations;

import Client.Employee.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileSave implements Runnable{
    private String write;
    private boolean append;
    public FileSave(Employee employee, boolean append){
        this.write=employee.toString();
        this.append=append;
    }
    public void run(){
        try{
            if(append) {
                FileWriter fw = new FileWriter("Employee.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(write);
                pw.flush();
                pw.close();
            }else{
                FileWriter fw = new FileWriter("Employee.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(write);
                pw.flush();
                pw.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
