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
public class UDPServer {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("���ն˷����С�������");
			//1.ʹ��DatagramSocket���Ϸ��Ͷ˿�
			DatagramSocket socket = new DatagramSocket(9999); 
			//3����װDatagramPacg���ݱ���
			byte[] container = new byte[1024*8];
			DatagramPacket pack = new DatagramPacket(container, 0, container.length);
			//4���˿����ý��н���
			socket.receive(pack);
			//��ȡ���ݱ����е����� (z�ֽ��� ȫ������)
			byte[] mes = pack.getData();
//			for (byte b : mes) {
//				System.err.print(b+",");
//			}
			//��ȡ���ݵĴ�С  
			int len = pack.getLength();
			//����ȡ������ ת�� �ַ��� 
			String msg = new String(mes,0,len);
			System.out.println("���ն˷��ͽ�����������"+msg);
			//5.�رն˿�
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
