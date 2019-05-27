package logica;

import java.util.Date;

public class Boleta {
	private String codigo;
	private double precio;
	private int sala;
	private String asiento;
	private int hora;
	private Pelicula miPeli;
	private Date fecha;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public String getAsiento() {
		return asiento;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public Pelicula getMiPeli() {
		return miPeli;
	}
	public void setMiPeli(Pelicula miPeli) {
		this.miPeli = miPeli;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@SuppressWarnings("deprecation")
	public int getDiaEmision(){
		if (fecha.getDate() > 30) {
			return fecha.getDate()-1;
		}else{
			return fecha.getDate();
		}
	}
	
}
