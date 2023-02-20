package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTCP{
	public static void main (String[] args ) throws Exception {
		try (Socket sc = new Socket ("127.0.0.1",9870)) {
			BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())),true);
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
			
			
			
			//entrer une commande 
			System.out.println("donner votre commande");
			String ligne=clavier.readLine();
			out.println(ligne);
		}
	
	
	
	
	}

}
