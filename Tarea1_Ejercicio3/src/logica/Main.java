package logica;

public class Main {

	public static void main(String[] args) {
		Fraccion f1 = new Fraccion(2, 4);
		Fraccion f2 = new Fraccion(2, 3);
		
		System.out.println(f1.Resta(f1, f2).num + "/" + f1.Resta(f1, f2).den + "\n");
		System.out.println(f1.simplificar(f1).num + "/" + f1.simplificar(f1).den + "\n");
		System.out.println(f1.mcd(f1)+"\n");
		System.out.println(f1.SumaE(f1, 2).num + "/" + f1.SumaE(f1, 2).den + "\n");
	}

}
