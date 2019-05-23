
public class Deportista {
	private String nombre;
	private int edad;
	private String deporte;
	private int[] MejTemp;
	
	public Deportista(String nombre, int edad, String deporte) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.deporte = deporte;
		MejTemp = new int[5];
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public int[] getMejTemp() {
		return MejTemp;
	}

	public void setMejTemp(int[] mejTemp) {
		MejTemp = mejTemp;
	}
	public void VerifProm(int[] arr, int x) {
		float avg = 0;
		int sum = 0;
		for(int i = 0; i < 5; i++){
			sum += arr[i];
		}
		avg = sum/5;
		
		if (avg < x) {
			System.out.println("Sus tiempos anuales estan por debajo del tiempo digitado");
		}else { System.out.println("Sus tiempos anuales estan por encima del tiempo digitado"); };
		
	}
	public int MejReg(int[] arr) {
		int mayor = 0;
		mayor = arr[0];
		for (int i = 1; i < 5; i++) {
			if (arr[i] > mayor) {
				mayor = arr[i];
			}
		}
		return mayor;
	}

}
