package tib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import tib.ChatProtocol;
import tib.ChatServer.CThread;

public class ChatServer {

	Vector<CThread> vc;
	ServerSocket server;
	int port = 8000;

	public ChatServer() {
		try {
			server = new ServerSocket(port);
			vc = new Vector<CThread>();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);// ���������� ����
		}
		System.out.println("****************************");
		System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�.");
		System.out.println("****************************");
		try {
			while (true) {
				Socket sock = server.accept();
				CThread ct = new CThread(sock);
				ct.start();
				vc.add(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}

	public void removeClient(CThread ct) {
		vc.remove(ct);
	}

	class CThread extends Thread {
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "�͸�";

		///////////////// Socket �ִ� ������/////////////////////
		public CThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				System.out.println(sock + " ���ӵ�....");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void routine(String line) {
			int idx = line.indexOf(':');
			String cmd = line.substring(0, idx);
			String data = line.substring(idx + 1);
			CThread ct = findClient(cmd);
			if (ct != null) {
				// bbb���� ������ ������.
				ct.sendMessage(ChatProtocol.MESSAGE + ":" + id + ";" + data);
			}
		}

		public CThread findClient(String id) {
			CThread ct = null;
			for (int i = 0; i < vc.size(); i++) {
				ct = vc.get(i);
				if (ct.id.equals(id))
					break;
			}
			return ct;
		}

		public void sendMessage(String msg) {
			out.println(msg);
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
