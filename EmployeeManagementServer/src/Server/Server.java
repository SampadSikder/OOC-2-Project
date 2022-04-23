package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        /*Server server=new Server();
        server.ServerUpload(5000);*/
        ServerSocket server=null;

        try{
            server=new ServerSocket(5000);
            server.setReuseAddress(true);

            while(true){
                Socket client=server.accept();
                System.out.println("New client accepted!");
                ThreadedServer threadedServer=new ThreadedServer(client);

                Thread t=new Thread(threadedServer);
                t.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(server!=null){
                try{
                    server.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
