package logica;

public class Almacen {
	
	//Atributos
	private Suministrador[] ListSum;
	private Vino[] ListVin;
	private int cantVinos;
	private int cantSum;
	
	//Constructor
	public Almacen() {
		ListSum = new Suministrador[50];
		ListVin = new Vino[50];
		this.cantVinos = 0;
		this.cantSum = 0;
	}
	
	//Sets y Gets
	public Suministrador[] getListSum() {
		return ListSum;
	}
	public void setListSum(Suministrador[] listSum) {
		ListSum = listSum;
	}
	public Vino[] getListVin() {
		return ListVin;
	}
	public void setListVin(Vino[] listVin) {
		ListVin = listVin;
	}
	public int getCantVinos() {
		return cantVinos;
	}
	public void setCantVinos(int cantVinos) {
		this.cantVinos = cantVinos;
	}
	public int getCantSum() {
		return cantSum;
	}
	public void setCantSum(int cantSum) {
		this.cantSum = cantSum;
	}
	
	//Metodos 
	public boolean hacerPedido(String codigo) {
		boolean hacer = false;
		Vino aux = null;
		aux = buscarByCode(codigo); //Esta funcion busca un vino dado su codigo
		if (aux != null) {
			if (aux.getCantReal()<aux.getCantMin() && aux.getMiSum().getTiempo()<30 && aux.promedio()) {
				hacer = true;
			}
		}
		return hacer;
	}
	private Vino buscarByCode(String codigo) {
		Vino aux = null;
		boolean encontrado = false;
		int i = 0;

		while (!encontrado &&  i < cantVinos) { //Mientras no se haya encontrado e i sea menor a la cantidad de vinos
			if(ListVin[i].getCodigo()==codigo) {
				encontrado = true;
				aux = ListVin[i];
			}
			i++;
		}
		return aux;
	}
	public void insertarVino(Vino vino) {
		ListVin[cantVinos] = vino;
		cantVinos++;
		Vino.generatedCode++;
	}
	public void insertarSuministrador(Suministrador sumi) {
		ListSum[cantSum] = sumi;
		cantSum++;
	}

	public void EliminarSuministrador(String nombreSumi) {
		int aux = buscarSuministrador(nombreSumi);
		if (aux > -1) {
			while(aux < cantSum - 1) {
				ListSum[aux] = ListSum[aux+1];
				aux++;
			}
			cantSum--;
		}
	}

	public int buscarSuministrador(String nombreSumi) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado &&  i < cantSum) { //Mientras no se haya encontrado e i sea menor a la cantidad de vinos
			if(ListSum[i].getNombre().equalsIgnoreCase(nombreSumi)) {
				encontrado = true;
				aux = i;
			}
			i++;
		}
		return aux;
	}

	public Suministrador buscarSuministradorByName(String nombreSumi) {
		Suministrador aux = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado &&  i < cantSum) { //Mientras no se haya encontrado e i sea menor a la cantidad de vinos
			if(ListSum[i].getNombre().equalsIgnoreCase(nombreSumi)) {
				encontrado = true;
				aux = ListSum[i];
			}
			i++;
		}
		return aux;
	}

	public void modAdministrador(Suministrador miSumi) {
		int index = buscarSuministrador(miSumi.getNombre());
		ListSum[index] = miSumi;
	}

	public Vino buscarVinoByCod(String codVino) {
		Vino aux = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado &&  i < cantSum) { //Mientras no se haya encontrado e i sea menor a la cantidad de vinos
			if(ListVin[i].getCodigo().equalsIgnoreCase(codVino)) {
				encontrado = true;
				aux = ListVin[i];
			}
			i++;
		}
		return aux;
	}

	public int buscarVino(String codigo) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado &&  i < cantVinos) { //Mientras no se haya encontrado e i sea menor a la cantidad de vinos
			if(ListVin[i].getCodigo().equalsIgnoreCase(codigo)) {
				encontrado = true;
				aux = i;
			}
			i++;
		}
		return aux;
	}
	public Vino returnVinoByName(String nombre) {
		Vino aux = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado &&  i < cantVinos) { //Mientras no se haya encontrado e i sea menor a la cantidad de vinos
			if(ListVin[i].getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
				aux = ListVin[i];
			}
			i++;
		}
		return aux;
	}
	
	public void modVino(Vino miVino) {
		int index = buscarVino(miVino.getCodigo());
		ListVin[index] = miVino;
		
	}

	public void eliminarVino(String codVino) {
		int aux = buscarVino(codVino);
		if (aux > -1) {
			while(aux < cantVinos - 1) {
				ListVin[aux] = ListVin[aux+1];
				aux++;
			}
			cantVinos--;
		}		
	}
}
