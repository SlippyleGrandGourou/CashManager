import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{


    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9879;
    private static Parser parser = new Parser();
    public static void main(String args[])
    {

        try {
            server = new ServerSocket(port);
            
            while (true) {
            	System.out.println("Waiting for the client request");
                //creating socket and waiting for client connection
                Socket socket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputLine = "";
                String inputTotal = "";
                inputLine = in.readLine();
                while (inputLine != null && !(inputLine).equals("")) {
                	inputTotal += inputLine;
                	inputLine = in.readLine();
                }
                Controler controler = new Controler(socket);
                controler.doAction(parser.getActionFromResquest(inputTotal));
                
                in.close();
            }
        } catch (Exception e) {
        	System.out.println("error : " + e);
        }
    }
}