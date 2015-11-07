import java.io.*;
import java.net.*;

public class udpserver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//create datagram socket at port 9876(9876에서 기다리고 있겠다 라는 뜻임)
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		while(true){
			//create space for received datagram
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			//receive datagram
			serverSocket.receive(receivePacket);
			//받은 datagratm을 sentence에 할당
			String sentence = new String(receivePacket.getData());
			
			//get IP addr , port number of sender
			InetAddress IPAddress = receivePacket.getAddress(); 
			int port = receivePacket.getPort();
			
			//받아온 문장 대문자로 바꿔주기
			String capitalizedSentence = sentence.toUpperCase();
			//대문자로 바꾼거 sendData에 넣어주기 
			sendData = capitalizedSentence.getBytes();
			
			//create datagram to send to client
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
			//write out datagram to socket
			serverSocket.send(sendPacket);
			
		}
	}

}
