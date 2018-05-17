package pc.main;

import pc.bean.Memoria;
import pc.hilo.Consumidor;
import pc.hilo.Productor;
import pc.inter.Buffer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer b = new Memoria();
		
		Productor p = new Productor(b);
		Consumidor c = new Consumidor(b);
		
		p.start();
		c.start();

		
	}

}
