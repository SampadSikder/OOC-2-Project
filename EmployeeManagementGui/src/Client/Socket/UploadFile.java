package Client.Socket;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class UploadFile {
    private Socket socket=null;
    private FileInputStream fis=null;
    private DataOutputStream out=null;
    public UploadFile(String address, int port){
        try{
            socket=new Socket(address,port);
            out=new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Upload");

            fis=new FileInputStream("Employee.txt");

            byte b[]=new byte[16*1024];

            fis.read(b,0,b.length);

            out.write(b,0,b.length);

            fis.close();
            out.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
