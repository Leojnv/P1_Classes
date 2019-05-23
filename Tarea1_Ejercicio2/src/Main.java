
public class Main {

	public static void main(String[] args) {

		int[] bestTimes = new int[5];
		int Record = 7;
		for (int i = 0; i < 5; i++) {
			bestTimes[i] = 10;
		}

		Deportista Jugador = new Deportista("Fulano", 24, "Pelota");
		Jugador.setMejTemp(bestTimes);

		
		System.out.println("El mejor tiempo del jugador es: " + Jugador.MejReg(Jugador.getMejTemp()) );
		Jugador.VerifProm( Jugador.getMejTemp() , Record);
	}

}
