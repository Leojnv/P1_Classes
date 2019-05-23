
public class Circulo {
	private int corX;
	private int corY;
	private int radio;
	
	public Circulo(int corX, int corY, int radio) {
		super();
		this.corX = corX;
		this.corY = corY;
		this.radio = radio;
	}
	public int getCorX() {
		return corX;
	}
	public void setCorX(int corX) {
		this.corX = corX;
	}
	public int getCorY() {
		return corY;
	}
	public void setCorY(int corY) {
		this.corY = corY;
	}
	public int getRadio() {
		return radio;
	}
	public void setRadio(int radio) {
		this.radio = radio;
	}
	public float Lon(int rad) {
		float per;
		per = (float) (2*Math.PI*rad);
		return per;
	}
	public float Area(int rad) {
		float ar;
		ar = (float) (Math.PI*Math.pow(rad, 2));
		return ar;
	}
	
}
