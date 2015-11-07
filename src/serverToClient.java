import java.io.*;
import java.net.*;

public class serverToClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String clientSentence; //client에서 날라온 문장
		String capitalizedSentence; //client로 보낼 문장(대문자황 시킨거)
		
		//create welcoming socket at port 8080
		ServerSocket welcomeSocket = new ServerSocket(3737);
		while(true){
		//wait, on welcoming socket for contact by client
		Socket connectionSocket = welcomeSocket.accept();
		//create input stream, attached to socket
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		//create output stream, attached to socket
		DataOutputStream outToClient = new DataOutputStream(connectionSocket .getOutputStream());
		
		//read in line from socket
		clientSentence = inFromClient.readLine();
		//읽어온거 대문자로 바꿔
		capitalizedSentence =clientSentence.toUpperCase() +'\n';
		
		//write out line to socket 
		outToClient.writeBytes(capitalizedSentence);
		}

	}

}
