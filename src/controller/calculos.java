package controller;

import java.util.concurrent.Semaphore;

public class calculos extends Thread{

	private int Idthread;
	private Semaphore semaforo;

	public calculos (int Idthread, Semaphore semaforo) {
		this.Idthread = Idthread;
		this.semaforo = semaforo;
		
	}
 @Override
public void run() {

	 try {
		 semaforo.acquire();
		
		 TransacaoBD();
	 }catch (Exception e) {
		 e.printStackTrace();
	 }finally {
		 //obriga a rodar
		 semaforo.release();
		//fim da seção critica
	 } 
	
}
private void TransacaoBD() {
	for (int i=0;i<2;i++) {
	if(Idthread % 3 ==1 ) {
		calculos();
			
		int tempo =  aleatorio(1500,501);
		
		System.out.println("Thread = "+getId()+ " Transacao de BD ");
	}
	}if(Idthread % 3 ==2) {
		for (int i=0;i<3;i++) {
			calculos();
		int tempo =  aleatorio(1500,501);;
		System.out.println("Thread = "+getId()+ " Transacao de BD ");
		}
	}else if(Idthread % 3 ==0){
		for (int i=0;i<2;i++) {
			calculos();
		int tempo =  aleatorio(1500,501);;
		System.out.println("Thread = "+getId()+ " Transacao de BD ");
		}
}
}

private void calculos() {
	
	if(Idthread % 3 ==1 ) {
		
		int tempo = aleatorio(0002,101);
		System.out.println("Thread = "+getId()+ " Calculos ");
	
	}if(Idthread % 3 ==2) {
		
		int tempo =  aleatorio(0002,101);
		System.out.println("Thread = "+getId()+ " Calculos ");
		
	}else if(Idthread % 3 ==0) {
		
		int tempo =  aleatorio(0002,101);
		System.out.println("Thread = "+getId()+ " Calculos ");
}
	}
private int aleatorio(int min, int max) {
	int aleatorio = min + (int)(Math.random()*(max -min));
	return aleatorio;
 }
}
