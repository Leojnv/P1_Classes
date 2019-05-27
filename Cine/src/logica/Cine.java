package logica;

public class Cine {
	private String codigo;
	private String nombre;
	private int cantSalas;
	private String provincia;
	private Boleta[] boletasVendidas;
	private Pelicula[] misPelis;
	private double[] recaudacion;
	private int cantBoletas;

	public Cine(){
		boletasVendidas = new Boleta[100];
		misPelis = new Pelicula[100];
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantSalas() {
		return cantSalas;
	}

	public void setCantSalas(int cantSalas) {
		this.cantSalas = cantSalas;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Boleta[] getBoletasVendidas() {
		return boletasVendidas;
	}

	public void setBoletasVendidas(Boleta[] boletasVendidas) {
		this.boletasVendidas = boletasVendidas;
	}

	public Pelicula[] getMisPelis() {
		return misPelis;
	}

	public void setMisPelis(Pelicula[] misPelis) {
		this.misPelis = misPelis;
	}

	public double[] getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(double[] recaudacion) {
		this.recaudacion = recaudacion;
	}

	public int getCantBoletas() {
		return cantBoletas;
	}

	public void setCantBoletas(int cantBoletas) {
		this.cantBoletas = cantBoletas;
	}

	public int diaMayorRecaudacion() {
		int dia = 0;
		double actual = recaudacion[0];
		for (int i = 1; i < 30; i++) {
			if (actual > recaudacion[i]) {
				dia = i+1;
				actual = recaudacion[i];
			}
		}
		return dia;
	}
	public double recaudacionTotal() {
		double total = 0;
		for (int i = 0; i < 30; i++) {
				total += recaudacion[i];
		}
		return total;
	}
	public int[] ConteoGeneroMasVisto() {
		int[] vistasGeneros = new int[3];
		// 0 = accion
		// 1 = terror
		// 2 = comedia
		for (int i = 0; i < cantBoletas; i++) {
			if (boletasVendidas[i].getMiPeli().getNombre().equalsIgnoreCase("accion")) {
				vistasGeneros[0]++;
			} else if (boletasVendidas[i].getMiPeli().getNombre().equalsIgnoreCase("terror")){
				vistasGeneros[1]++;
			} else if ((boletasVendidas[i].getMiPeli().getNombre().equalsIgnoreCase("comedia"))) {
				vistasGeneros[2]++;
			}
		}
		return vistasGeneros;
	}
	public String generoMasVisto() {
		int[] vistasGeneros = ConteoGeneroMasVisto();
		int masVistas = 0;
		String genero = new String();

		for (int i = 0; i < 3; i++) {
			masVistas = Math.max(masVistas, vistasGeneros[i]);
		}
		if (masVistas == vistasGeneros[0]) {
			genero = "accion";
		} else if (masVistas == vistasGeneros[1]){
			genero = "terror";
		} else if (masVistas == vistasGeneros[2]) {
			genero = "comedia";
		}
		return genero;
	}
	public int funcionesPeliByNombre(String nombre) {
		int funciones = 0;
		for (int j = 0; j < cantBoletas; j++) {
			if (boletasVendidas[j].getMiPeli().getNombre().equalsIgnoreCase(nombre)){
				funciones++;
			}
		}
		return funciones;
	}
}
