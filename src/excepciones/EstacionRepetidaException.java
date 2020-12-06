package excepciones;

@SuppressWarnings("serial")
public class EstacionRepetidaException extends Exception{

	public EstacionRepetidaException() {
		super("La estacion ya se encuentra en el sistema");
	}
}
