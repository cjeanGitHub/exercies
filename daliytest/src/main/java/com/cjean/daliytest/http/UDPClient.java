package com.cjean.daliytest.http;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP接受发送信息
 * 使用DatagramSocket进行udp的发送接受
 * @author Cjean
 *
 */
public class UDPClient {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("发送端发送中、、、、");
			//1.使用DatagramSocket创建端口
			DatagramSocket socket = new DatagramSocket(8877);
			//2.创建字节流信息
			String msg = "UDP客户端发送的信息";
			byte[] msgArr = msg.getBytes();
			//3、封装DatagramPacg数据报包
			DatagramPacket pack = new DatagramPacket(msgArr, 0, msgArr.length,
					new InetSocketAddress("localhost",9999));
			//4。端口引用进行发送
			socket.send(pack);
			//5.关闭端口
			socket.close();
			System.out.println("发送端发送结束、、、、");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
