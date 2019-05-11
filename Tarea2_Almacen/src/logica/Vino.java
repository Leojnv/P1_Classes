package logica;

public class Vino {
	
	//Atributos
	private int codigo;
	private Suministrador miSum;
	private String nombre;
	private String tipo;
	private int cantMax;
	private int cantMin;
	private int cantReal;
	private int[] ventas;
	
	//Constructor
	public Vino(int codigo, Suministrador miSum, String nombre, String tipo, int cantMax, int cantMin, int cantReal) {
		this.codigo = codigo;
		this.miSum = miSum;
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantMax = cantMax;
		this.cantMin = cantMin;
		this.cantReal = cantReal;
		this.ventas = new int[10];
	}
	
	//Sets y Gets
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Suministrador getMiSum() {
		return miSum;
	}
	public void setMiSum(Suministrador miSum) {
		this.miSum = miSum;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
	public int getCantMin() {
		return cantMin;
	}
	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}
	public int getCantReal() {
		return cantReal;
	}
	public void setCantReal(int cantReal) {
		this.cantReal = cantReal;
	}
	public int[] getVentas() {
		return ventas;
	}
	public void setVentas(int[] ventas) {
		this.ventas = ventas;
	}
	
	//Metodos
	public boolean promedio() {
		int sum = 0;
		//Promedio de los ultimos 3 años
		for (int i = 6; i < 9; i++) { 
			sum += ventas[i];
		}
		float promedio = (float) sum/3;
		if (promedio < ventas[9]) {
			return true;
		}else {
			return false;
		}
	}
}
