import java.io.*;
import java.net.*;

public class clientToServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sentence; //client단에서 입력할 문자
		String modifiedSentence; //server에서 바꿔서 보내줄 문자
		
		//create input stream(client단에서 keyboard로 읽어들일 문자)
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		//create client socket, connect to server
		Socket clientSocket = new Socket("127.0.0.1",3737);
		
		//create output stream attached to socket
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		//create input stream attached to socket
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		//notice to input
		System.out.print("문장을 입력하세요 : ");
		//입력한거 받아오기 
		sentence = inFromUser.readLine();
		//send line to server
		outToServer.writeBytes(sentence+'\n');
		//read line from server
		modifiedSentence=inFromServer.readLine();
		
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
	}

}
