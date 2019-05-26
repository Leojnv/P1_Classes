package logica;


public class Main {

	public static void main(String[] args) {
		Almacen alma = new Almacen();
		Suministrador s1 = new Suministrador("Pedro", "RD", 29);
		Vino v1 = new Vino("1", s1, "Carlos Rosi", "Tinto", 50, 10, 9,3);

		int[] ven = new int[10];
		for (int i = 0; i < 10; i++) {
			ven[i] = i+1*10;
		}

		// Guardando datos en el almacen y vino
		v1.setVentas(ven);
		alma.insertarSuministrador(s1);
		alma.insertarVino(v1);

		System.out.println(alma.hacerPedido("1"));
	}

}
