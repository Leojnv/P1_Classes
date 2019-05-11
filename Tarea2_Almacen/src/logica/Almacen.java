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
	public boolean hacerPedido(int codigo) {
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
	private Vino buscarByCode(int codigo) {
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
	}
	public void insertarSuministrador(Suministrador sumi) {
		ListSum[cantSum] = sumi;
		cantSum++;
	}
}
