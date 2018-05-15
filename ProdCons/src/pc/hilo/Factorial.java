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
public class Factorial extends Thread {

    Buffer b;
    int n;

    public Factorial(Buffer b, int n) {
        // TODO Auto-generated constructor stub
        this.b = b;
        this.n = n;
    }

    @Override
    public void run() {

        int a = 0,f = 1;
        
        for (a = n; a > 1; a--) {//determinar factorial
            f = f * a;
        }
        
        System.out.println("El factorial de " + n + " es " + f);
    }
}
