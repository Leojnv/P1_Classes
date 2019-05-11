
public class Rectangulo {
	private int base;
	private int altura;
	
	public void setB(int bNew) {
		if (bNew < 1) {
			bNew = 1;
		}else {	base = bNew; }
	}

	public void setH(int hNew) {
		if (hNew < 1) {
			hNew = 1;
		} else { altura = hNew;	}
	}

	public int getB() {
		return base;
	}

	public int getH() {
		return altura;
	}
	public float Area(int base, int altura) {
		float ar;
		ar = base*altura;
		return ar;
	}
	public float Perimetro(int base, int altura) {
		float per;
		per = (float)(2*base + 2*altura);
		return per;
	}
}
