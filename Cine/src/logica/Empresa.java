package logica;

public class Empresa {
	private Pelicula[] misPelis;
	private Cine[] misCines;
	private int cantCines;
	private int cantPelis;

	public Empresa(){
		misCines = new Cine[31];
		misPelis = new Pelicula[100];
	}
	
	public Pelicula[] getMisPelis() {
		return misPelis;
	}

	public void setMisPelis(Pelicula[] misPelis) {
		this.misPelis = misPelis;
	}

	public Cine[] getMisCines() {
		return misCines;
	}

	public void setMisCines(Cine[] misCines) {
		this.misCines = misCines;
	}

	public int getCantCines() {
		return cantCines;
	}

	public void setCantCines(int cantCines) {
		this.cantCines = cantCines;
	}

	public int getCantPelis() {
		return cantPelis;
	}

	public void setCantPelis(int cantPelis) {
		this.cantPelis = cantPelis;
	}

	public Cine buscarCineByCode(String codigo) {
		boolean encontrado = false;
		Cine aux = null;
		int i = 0;
		while (!encontrado && i < cantCines) {
			if (codigo.equalsIgnoreCase(misCines[i].getCodigo())) {
				encontrado = true;
				aux = misCines[i];
			}
			i++;
		}
		return aux;
	}
	public int diaMayorRecByCine(String codigo) {
		Cine aux = buscarCineByCode(codigo);
		if (aux != null) {
			return aux.diaMayorRecaudacion();
		} else {
			return -1;
		}
	}
	public double estimacionVentas() {
		double total = 0;
		for (int i = 0; i < cantCines; i++) {
			total += misCines[i].recaudacionTotal();
		}
		return total;
	}
	public String generoMasPopular(String codigo) {
		String genero = new String();
		Cine aux = buscarCineByCode(codigo);
		if (aux == null) {
			genero = " ";
		} else {
			genero = aux.generoMasVisto();
		}
		return genero;
	}
	public Cine peliculaMasProyectadaByCine(String nombre) {
		int cantBoletasPeli = 0;
		int mayor = 0;
		Cine aux = new Cine();
		for (int i = 0; i < cantCines; i++) {
			cantBoletasPeli = misCines[i].funcionesPeliByNombre(nombre);
			if (cantBoletasPeli > mayor) {
				mayor = cantBoletasPeli;
				cantBoletasPeli = 0;
				aux = misCines[i];
			}
		}
		return aux;
	}

}
