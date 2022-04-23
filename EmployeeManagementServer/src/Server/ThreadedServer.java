package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServer implements Runnable{
    private Socket clientSocket=null;
    private DataInputStream in=null;
    private FileOutputStream fos=null;
    private BufferedOutputStream bos=null;
    private FileInputStream fis=null;
    private DataOutputStream out=null;
    public ThreadedServer(Socket socket){
        this.clientSocket=socket;
    }
    public void run(){
        try{

            fos=new FileOutputStream("Buffer.txt");
            bos=new BufferedOutputStream(fos);
            in=new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            out=new DataOutputStream(clientSocket.getOutputStream());
            String line="";
            line=in.readUTF();

            if(line.equals("Upload")) {
                System.out.println("Client Uploading...");
                byte[] buffer=new byte[16*1024];
                int byteRead=0;
                while((byteRead=in.read(buffer))!=-1){
                    bos.write(buffer,0,byteRead);
                }
                bos.flush();
                bos.close();
                in.close();
                //Adding to existing file
                clientSocket.close();
                new FileAppend();
                System.out.println("File saved successfully");
            }
            if(line.equals("Download")){
                System.out.println("Client downloading...");

                fis=new FileInputStream("Uploads.txt");

                byte b[]=new byte[16*1024];

                fis.read(b,0,b.length);

                out.write(b,0,b.length);


                fis.close();
                out.close();
                in.close();
                clientSocket.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void socketClose(){
        try {
            clientSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
