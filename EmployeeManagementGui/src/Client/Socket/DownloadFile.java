package Client.Socket;

import java.io.*;
import java.net.Socket;

public class DownloadFile {
    private Socket socket = null;
    private DataInputStream in = null;
    private FileOutputStream fos = null;
    private DataOutputStream out = null;
    private BufferedOutputStream bos = null;

    public DownloadFile(String address, int port) {
        try {
            socket = new Socket(address, port);
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Download");

            fos = new FileOutputStream("Download.txt");
            bos = new BufferedOutputStream(fos);
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            byte[] buffer = new byte[16*1024];
            int byteRead = 0;
            while ((byteRead = in.read(buffer)) != -1) {
                bos.write(buffer, 0, byteRead);

            }
            bos.flush();
            out.close();
            socket.close();
            System.out.println("File saved successfully");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
