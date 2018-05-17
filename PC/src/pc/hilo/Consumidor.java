package pc.hilo;

import java.util.logging.Level;
import java.util.logging.Logger;
import pc.inter.Buffer;

public class Consumidor extends Thread {

    Buffer b;

    public Consumidor(Buffer b) {
        // TODO Auto-generated constructor stub
        this.b = b;

    }

    @Override
    public void run() {
        int n = 0;
        while (n != -1) {
            n = b.getValor();

            if (n > 0) {

                try {

                    Thread.sleep(40);

                    int a = 0, f = 1;

                    for (a = n; a > 1; a--) {//determinar factorial
                        f = f * a;
                    }

                    System.out.println("[Consumidor] El factorial de " + n + " es " + f);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                try {
                    if (n != -1) {
                        Thread.sleep(40);
                        System.out.println("El factorial es solo para numeros enteros mayores a 0");
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        System.out.println("[Consumidor] Fin");
    }

}
