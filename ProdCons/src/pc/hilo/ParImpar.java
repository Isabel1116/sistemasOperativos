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
public class ParImpar extends Thread {

    Buffer b;
    int n;

    public ParImpar(Buffer b, int n) {
        // TODO Auto-generated constructor stub
        this.b = b;
        this.n = n;
    }

    @Override
    public void run() {

        if (n % 2 == 0) {
            System.out.println("El número " + this.n + " es par");
        } else {
            System.out.println("El número " + this.n + " es impar");
        }

    }

}
