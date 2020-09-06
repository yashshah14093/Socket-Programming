
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        
        if(args.length != 1){
            System.err.println("Pass only server ip as arguments");
            return;
        }
        
        Socket socket = new Socket(args[0],60000);
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("Server returns: "+in.nextLine());
        
    }
}
