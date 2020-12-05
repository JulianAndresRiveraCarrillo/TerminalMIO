package model;

public class Estacion {

    private String nombre;
    private int capacidad_de_usuarios;
    //private String rutas;

    public Estacion( String nombre, int capacidad_de_usuarios){
        this.nombre = nombre;
        this.capacidad_de_usuarios = capacidad_de_usuarios;
    }
    /*
    public Estacion( String nombre, int capacidad_de_usuarios, String rutas){
        this.nombre = nombre;
        this.capacidad_de_usuarios = capacidad_de_usuarios;
        this.rutas = rutas;
    }
	*/
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad_de_usuarios() {
        return capacidad_de_usuarios;
    }

    public void setCapacidad_de_usuarios(int capacidad_de_usuarios) {
        this.capacidad_de_usuarios = capacidad_de_usuarios;
    }
    
    /*
    public String getRutas() {
		return rutas;
	}

	public void setRutas(String rutas) {
		this.rutas = rutas;
	}
	*/
}
