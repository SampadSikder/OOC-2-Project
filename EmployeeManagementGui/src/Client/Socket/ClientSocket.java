package Client.Socket;

public class ClientSocket {
    public ClientSocket(String type) {
        if (type.equals("Upload")) {
            UploadFile upload = new UploadFile("127.0.0.1", 5000);
        } else if (type.equals("Download")) {
            DownloadFile downloadFile = new DownloadFile("127.0.0.1", 5000);
        }
    }
}

