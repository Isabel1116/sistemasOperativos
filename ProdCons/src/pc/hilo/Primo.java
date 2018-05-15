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
public class Primo extends Thread {

    Buffer b;
    int n;

    public Primo(Buffer b, int n) {
        // TODO Auto-generated constructor stub
        this.b = b;
        this.n = n;
    }

    @Override
    public void run() {

        int i = 2, primo = 0;

        while (i <= n / 2 && primo == 0) {
            if (n % i == 0) {
                primo = 1;
            }
            i++;
        }

        if (primo == 0 && n != 1) {
            System.out.println("El número " + this.n + " es primo");
        } else {
            System.out.println("El número " + this.n + " no es primo");
        }

    }
}
