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
public class Serie extends Thread {

    Buffer b;
    int n;

    public Serie(Buffer b, int n) {
        // TODO Auto-generated constructor stub
        this.b = b;
        this.n = n;
    }

    @Override
    public void run() {

        int x = 1, y = 1, c = 0;

        if (n == 1 || n == 0) {
            System.out.println("El " + n + " ésimo de la serie de fibonacci es " + n);
        } else {
            
            c = n - 1;

            for (int i = 1; i < c; i++) {
                y = x + y;
                x = y - x;
            }
            System.out.println("El " + n + " ésimo de la serie de fibonacci es " + x);
        }

    }

}
