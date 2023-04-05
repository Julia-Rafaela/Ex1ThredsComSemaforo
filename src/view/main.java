package view;

import java.util.concurrent.Semaphore;

import controller.calculos;

public class main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for  ( int i = 1; i <= 21; i++) {
		Thread c = new calculos (i, semaforo);
			c.start();
		}
	}

}
