package logica;

public class Suministrador {
	
	//Atributos
	private String nombre;
	private String pais;
	private int tiempo;
	
	//Constructor
	public Suministrador(String nombre, String pais, int tiempo) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.tiempo = tiempo;
	}
	
	//Sets y Gets
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
