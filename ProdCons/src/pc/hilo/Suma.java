/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.hilo;

import pc.inter.Buffer;

/**
 *
 * @author Ale
 */
public class Suma extends Thread {

    Buffer b;
    int n;

    public Suma(Buffer b, int n) {
        // TODO Auto-generated constructor stub
        this.b = b;
        this.n = n;
    }

    @Override
    public void run() {

        int a = 0, suma = 0;

        for (a = n; a > 0; a--) {//determinar sumatoria de 1 hasta n
            suma += a;
        }

        System.out.println("La sumatoria de 1 hasta " + n + " es " + suma);

    }
}
