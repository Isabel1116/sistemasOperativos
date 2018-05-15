package pc.main;

import java.util.Scanner;
import pc.bean.Memoria;
import pc.hilo.Factorial;
import pc.hilo.ParImpar;
import pc.hilo.Primo;
import pc.hilo.Serie;
import pc.hilo.Suma;
import pc.inter.Buffer;

public class Main {

    public static void main(String[] args) {

        Buffer b = new Memoria();
        Scanner reader = new Scanner(System.in);
        int n = 0;

        System.out.println("Ingrese un número: ");
        n = reader.nextInt();

        ParImpar u = new ParImpar(b, n);
        Primo v = new Primo(b, n);
        Suma w = new Suma(b, n);
        Factorial x = new Factorial(b, n);
        Serie y = new Serie(b, n);

        u.start();
        v.start();
        w.start();
        x.start();
        y.start();
    }

}
