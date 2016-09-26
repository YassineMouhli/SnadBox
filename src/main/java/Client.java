import java.io.InputStream;
import java.net.Socket;


public class Client {

	
	public static void main(String[] args) throws Exception{
		Socket client = new Socket ("10.75.32.106", 4245);
		
		InputStream is = client.getInputStream();
		byte b [] = new byte [1024];
		int i = is.read(b);
		System.out.println(new String (b,0,i));
		
	}
	
	
}
