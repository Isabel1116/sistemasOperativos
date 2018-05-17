package pc.hilo;

import java.util.Scanner;

import pc.inter.Buffer;

public class Productor extends Thread {

    Buffer b;

    public Productor(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {

        Scanner reader = new Scanner(System.in);
        int n = 0;

        while (n != -1 ) {

            try {            
                
                System.out.println("[Productor] Ingrese numero: ");
                n = reader.nextInt();
                b.setValor(n);
                
                Thread.sleep(80);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("[Productor] Fin");
    }
}
