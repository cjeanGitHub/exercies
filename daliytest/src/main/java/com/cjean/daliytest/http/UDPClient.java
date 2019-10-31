package com.cjean.daliytest.http;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP���ܷ�����Ϣ
 * ʹ��DatagramSocket����udp�ķ��ͽ���
 * @author Cjean
 *
 */
public class UDPClient {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("���Ͷ˷����С�������");
			//1.ʹ��DatagramSocket�����˿�
			DatagramSocket socket = new DatagramSocket(8877);
			//2.�����ֽ�����Ϣ
			String msg = "UDP�ͻ��˷��͵���Ϣ";
			byte[] msgArr = msg.getBytes();
			//3����װDatagramPacg���ݱ���
			DatagramPacket pack = new DatagramPacket(msgArr, 0, msgArr.length,
					new InetSocketAddress("localhost",9999));
			//4���˿����ý��з���
			socket.send(pack);
			//5.�رն˿�
			socket.close();
			System.out.println("���Ͷ˷��ͽ�����������");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
