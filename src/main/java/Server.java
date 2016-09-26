import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;


public class Server {

	public static int ID = 0;
	
	static ServerSocket serverSocket;
	
	public static void main(String[] args) throws Exception{
		serverSocket = new ServerSocket (4245);
		new StartServer(serverSocket).start();
		
		
		
	}
	
}
class StartServer extends Thread {
	ServerSocket server;
	Connection connection;
	String log ="...";
	String pass = "...";
	String url = "jdbc:mysql://....";
	PreparedStatement st;
	
	
	
	public StartServer(ServerSocket s) throws Exception {
		server = s;
		System.out.println("Server start ...");
		
		Class.forName("com.mysql.jdbc.Driver");
//		connection = DriverManager.getConnection(url, log, pass);
//		
//		st = connection.prepareStatement("insert into connexion values (?, ?, ?)");
	
	}
	@Override
	public void run() {
		while (true){
			try {
				Socket client = server.accept();
				System.out.println("=================");
				System.out.println("Client acceped ... " + client.getInetAddress());
				System.out.println("=================");
				OutputStream os = client.getOutputStream();
				os.write(("Hello User ").getBytes());
				
				try {
					st.setInt(1, Server.ID);
					st.setInt(2, 1);
					st.setString(3, client.getInetAddress().toString());
				
					st.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
