package logica;

public class Fraccion {
	int num;
	int den;
	//Constructor
	public Fraccion(int num, int den) {
		super();
		this.num = num;
		this.den = den;
	}
	//Sets y Gets
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDen() {
		return den;
	}
	public void setDen(int den) {
		this.den = den;
	}
	//Metodos
	public int mcd (Fraccion fracc) {
		 int num = Math.abs(fracc.num);
	     int den = Math.abs(fracc.den);
	     if(den==0){
	          return num;
	     }
	     int aux;
	     while(den != 0){
	          aux = num % den;
	          num = den;
	          den = aux;
	     }
	     return num;
	}
	public Fraccion simplificar(Fraccion x) {
			int div = mcd(x);
			x.num = x.num/div;
			x.den = x.den/div;
		return x;
	}
	public Fraccion Suma (Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num*b.den + a.den*b.num;
		aux.den = a.den*b.den;
		aux = simplificar(aux);
		return aux;
	}
	public Fraccion Resta (Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num*b.den - a.den*b.num;
		aux.den = a.den*b.den;
		aux = simplificar(aux);
		return aux;
	}
	public Fraccion Multiplicacion (Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num*b.num;
		aux.den = a.den*b.den;
		aux = simplificar(aux);
		return aux;
	}
	public Fraccion Divison (Fraccion a, Fraccion b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num*b.den;
		aux.den = a.den*b.num;
		aux = simplificar(aux);
		return aux;
	}
	public Fraccion SumaE (Fraccion a, int b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num + b*a.den;
		aux.den = a.den;
		aux = simplificar(aux);
		return aux;
	}
	public Fraccion RestaE (Fraccion a, int b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num - b*a.den;
		aux.den = a.den;
		aux = simplificar(aux);
		return aux;
	}
	public Fraccion MultiplicacionE (Fraccion a, int b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num*b;
		aux.den = a.den;
		aux = simplificar(aux);
		return aux;
	}
	public Fraccion DivisonE (Fraccion a, int b) {
		Fraccion aux = new Fraccion(0, 0);
		aux.num = a.num;
		aux.den = a.den*b;
		aux = simplificar(aux);
		return aux;
	}
}
