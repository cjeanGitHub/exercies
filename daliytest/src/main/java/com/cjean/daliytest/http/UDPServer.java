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
public class UDPServer {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("接收端发送中、、、、");
			//1.使用DatagramSocket附上发送端口
			DatagramSocket socket = new DatagramSocket(9999); 
			//3、封装DatagramPacg数据报包
			byte[] container = new byte[1024*8];
			DatagramPacket pack = new DatagramPacket(container, 0, container.length);
			//4。端口引用进行接收
			socket.receive(pack);
			//获取数据报包中的数据 (z字节流 全是数字)
			byte[] mes = pack.getData();
//			for (byte b : mes) {
//				System.err.print(b+",");
//			}
			//获取数据的大小  
			int len = pack.getLength();
			//将获取的数据 转成 字符串 
			String msg = new String(mes,0,len);
			System.out.println("接收端发送结束、、、、"+msg);
			//5.关闭端口
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
