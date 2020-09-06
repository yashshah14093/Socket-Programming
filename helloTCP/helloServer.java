import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class helloServer {
    
    public static void main(String[] args) throws IOException{
        
        try(ServerSocket listener = new ServerSocket(60000)){
            System.out.println("Server running...");
            Socket socket = listener.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            String input = in.nextLine();
            String reverse = removeSpaces(input);
            out.println("From Server: "+reverse);
        }
    }
    
    
 
    public static String removeSpaces(String string){
        return string.replaceAll("\\s", "");
    }

}
