import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Controler{
	private Socket Socketclient;
	private PrintWriter out;
	private static final String OUTPUT = "<html><head><title>Example</title></head><body><p>Worked!!!</p></body></html>";
	private static final String OUTPUT_HEADERS = "HTTP/1.1 200 OK\r\n" +
	    "Content-Type: application/json\r\n" + 
	    "Content-Length: ";
	private static final String OUTPUT_HEADERS_FAIL = "HTTP/1.1 404 KO\r\n" +
		    "Content-Type: text/html\r\n" + 
		    "Content-Length: ";
		
	private static final String OUTPUT_END_OF_HEADERS = "\r\n\r\n";
	
	public Controler(Socket _Socketclient) throws IOException {
		Socketclient = _Socketclient;
		out = new PrintWriter(Socketclient.getOutputStream(), true);
        //out.println(parser.getActionFromResquest(inputTotal));
	}
	
	private void sendListProducts() {
		out.println(OUTPUT_HEADERS+OUTPUT_END_OF_HEADERS+"[{\n" + 
				"	\"name\": \"hero Product\",\n" + 
				"	\"detail\": \"Lorem ipsum dolor sit amet\",\n" + 
				"	\"price\": \"99\",\n" + 
				"	\"hero\": \"OMG This just came out today!\",\n" + 
				"	\"image\": \"http://placehold.it/940x300/999/CCC\"\n" + 
				"},{\n" + 
				"	\"name\": \"Product 1\",\n" + 
				"	\"detail\": \"Lorem ipsum dolor sit amet\",\n" + 
				"	\"price\": \"99\",\n" + 
				"	\"info\": \"This is the latest and greatest product from Derp corp.\",\n" + 
				"	\"image\": \"http://placehold.it/300x300/999/CCC\"\n" + 
				"},{\n" + 
				"	\"name\": \"Product 2\",\n" + 
				"	\"detail\": \"Lorem ipsum dolor sit amet\",\n" + 
				"	\"price\": \"99\",\n" + 
				"	\"offer\": \"BOGOF\",\n" + 
				"	\"image\": \"http://placehold.it/300x300/999/CCC\"\n" + 
				"},{\n" + 
				"	\"name\": \"Product 3\",\n" + 
				"	\"detail\": \"Lorem ipsum dolor sit amet\",\n" + 
				"	\"price\": \"99\",\n" + 
				"	\"image\": \"http://placehold.it/300x300/999/CCC\"\n" + 
				"},{\n" + 
				"	\"name\": \"Product 4\",\n" + 
				"	\"detail\": \"Lorem ipsum dolor sit amet\",\n" + 
				"	\"price\": \"99\",\n" + 
				"	\"offer\": \"No srsly GTFO\",\n" + 
				"	\"image\": \"http://placehold.it/300x300/999/CCC\"\n" + 
				"},{\n" + 
				"	\"name\": \"Product 5\",\n" + 
				"	\"detail\": \"Lorem ipsum dolor sit amet\",\n" + 
				"	\"price\": \"99\",\n" + 
				"	\"image\": \"http://placehold.it/300x300/999/CCC\"\n" + 
				"},{\n" + 
				"	\"name\": \"Product 6\",\n" + 
				"	\"detail\": \"Lorem ipsum dolor sit amet\",\n" + 
				"	\"price\": \"99\",\n" + 
				"	\"info\": \"This is the latest and greatest product from Derp corp.\",\n" + 
				"	\"offer\": \"info with offer\",\n" + 
				"	\"image\": \"http://placehold.it/300x300/999/CCC\"\n" + 
				"}]");
	}
	
	private void sendError(String param) {
		out.println(OUTPUT_HEADERS_FAIL+OUTPUT_END_OF_HEADERS+"error : " + param + "aaa");
	}
	
	public void doAction(String param) {
		System.out.println(param);
		if (param.equals("products "))
			sendListProducts();
		else
			sendError(param);
	}
}