import java.io.*;
import java.net.*;

public class udpclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		//create client Socket
		DatagramSocket clientSocket = new DatagramSocket();
		
		//Translate hostname to IP address using DNS
		InetAddress IPAddress = InetAddress.getByName("127.0.0.1");   // hostname - 받는놈 ip 주소  (SERVER IP ADDRESS)
		//서버한테 보내는 데이터
		byte[] sendData = new byte[1024];
		//서버로 부터 받는 데이터
		byte[] receiveData = new byte[1024];
		//출력해주자
		System.out.print("문장을 입력하세요 : ");
		//user로 부터 읽어들여
		String sentence = inFromUser.readLine();
		//읽어들인걸 sendData에 넣어줘야지
		sendData = sentence.getBytes();
		
		//create datagram with data- to -send,  length, SERVER IP address ,SERVER port NUMBER
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876 );
		
		//send datagram to server
		clientSocket.send(sendPacket);
		
		//create datagram with data -to -receive 
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length );
		
		//read datagram from server
		clientSocket.receive(receivePacket);
		
		//받아온 datagram을 modifiedSentence에 저장
		String modifiedSentence = new String(receivePacket.getData());
		
		System.out.println("From server : " + modifiedSentence );
		
		//닫아줘
		clientSocket.close();
	}

}
