package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import client.ClientTCP;
import model.Compte;

public class Serv{
	public static List<Compte> liste;
	public static List<ClientTCP> listeClt;
	public static void main(String [] args) {
		liste=new ArrayList<Compte>();
		listeClt=new ArrayList<ClientTCP>();
		try {
			ServerSocket sc=new ServerSocket(3000);
			while(true) {
				Socket s=sc.accept();
				GestionTh t=new GestionTh(s);
				t.start();
			}
			
			
		}catch(Exception e){
			System.out.println("error");
			
			
		}
	}
	
	
	

}
