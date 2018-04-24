import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Automata a = new Automata("C:\\Users\\Ale\\eclipse-workspace\\Afd\\PaginaWeb.txt");
		Scanner sc = new Scanner(System.in);
		String s;
				
		
		System.out.print("Introduzca texto: ");
		s = sc.nextLine();
		System.out.println("You typed: "+s);
		
		//a.validacion(a.getMatrix(), s);
		
	}
}
