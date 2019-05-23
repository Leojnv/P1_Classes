
public class Principal {

	public static void main(String[] args) {
		Circulo myCir;
		Rectangulo myRec;
		
		myCir = new Circulo(0, 0, 0);
		myRec = new Rectangulo();
		
		myRec.setB(10);
		myRec.setH(2);
		myCir.setRadio(2);
		
		System.out.printf("Rectangulo:\n\tb = "+myRec.getB()+"\t h = "+myRec.getH()+"\n");
		System.out.printf("\tArea = %.2f\n",myRec.Area(myRec.getB(), myRec.getH()));
		
		myRec.setB((int) myCir.Lon(myCir.getRadio()));
		myRec.setH((int) myCir.Lon(myCir.getRadio()));
		
		System.out.printf("Nuevo Rectangulo:\n\tb = "+myRec.getB()+"\t h = "+myRec.getH()+"\n");
		System.out.printf("\tArea = %.2f\n", myRec.Area(myRec.getB(), myRec.getH()));
	}

}
