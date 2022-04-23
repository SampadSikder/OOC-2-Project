package Server;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppend {
    public FileAppend(){
        try {
            FileReader fr = new FileReader("Buffer.txt");
            FileWriter fw = new FileWriter("Uploads.txt", true);
            String str = " ";
            int i;

            while ((i = fr.read()) != -1) {
                str += (char) i;
            }
            fw.write(str);
            fr.close();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
