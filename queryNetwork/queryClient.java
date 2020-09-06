import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class queryClient {
    
    public static void main(String[] args) throws IOException{
        
        if(args.length != 1){
            System.err.println("Server IP as the sole command line arguement");
            return;
        }
        
        try(Socket socket = new Socket(args[0],60000)){
            Scanner sc = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println(sc.nextLine());
            String string = in.nextLine();
            System.out.println(string);
            socket.close();
        }
        
    }

}
