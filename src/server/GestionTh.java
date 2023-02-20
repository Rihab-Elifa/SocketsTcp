package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import model.Compte;


public class GestionTh extends Thread {
	private Socket s;
	public GestionTh (Socket s) {
	   this.s=s;
	}
	public void run() {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
			while(true) {
				String msg=bf.readLine();
				if(msg.startsWith("CREATION")) {
					String nom=msg.substring(9);
					
					
					boolean b=false;
		
					for(Compte c:Serv.liste) {
						if(c.getNom().equals(nom)) {
							b=true;
						}
						
						
					}if(b==true) {
						out.println("le compte existe deja");
						
					}else {
						int i=Integer.parseInt(bf.readLine());
						Compte c=new Compte(i,nom);
						Serv.liste.add(c);
						out.println("Le compte est cree avec succes");
						String msg2=bf.readLine();
						
						if(msg2.startsWith("CREDIT")) {
							float montant=Float.parseFloat(msg2.substring(7));
							Float m=montant+c.getSolde();
							c.setSolde(m);
							out.println("Compte crédite avec succes");
							
					    }
					    
						else if(msg2.startsWith("SOLDE")) {
							Float solde =c.getSolde();
							out.println(solde);
							
					    }
						
						
						
												
					
				}
					
					
				}
			}
			
			
		}catch(Exception e) {
			
		}
	}
	
	
	
	
	

}
