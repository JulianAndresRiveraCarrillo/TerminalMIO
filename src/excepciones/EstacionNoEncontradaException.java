package excepciones;

@SuppressWarnings("serial")
public class EstacionNoEncontradaException extends Exception {

	public EstacionNoEncontradaException() {
		super("La Estacion no se encuentra en el sistema" + "\n" + "POr favor agreguela al sistema");
	}
}
