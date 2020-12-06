package model;

import java.util.*;
import data_structures.*;
import excepciones.EstacionRepetidaException;

public class Administrador {
	private ArrayList<Estacion> estaciones;
	private AdjListGraph<Estacion> AdjListEstaciones;
	private AdjMatrixGraph<Estacion> AdjMatEstaciones;
	
	public Administrador() {
		estaciones = new ArrayList<Estacion>();
		AdjListEstaciones = new AdjListGraph<Estacion>(false);
		AdjMatEstaciones = new AdjMatrixGraph<Estacion>(false);
	}
	
	public boolean añadirEstacion(String n, int cap) {
		boolean aux = false;
		Estacion temp = new Estacion(n, cap);
		estaciones.add(temp);
		if (AdjListEstaciones.addVertex(temp)) {
			aux = true;
		}
		if (AdjMatEstaciones.addVertex(temp)) {
			aux = true;
		}
		return aux;
	}
	/*
	public void añadirEstacion(String n, int cap, String r) {
		Estacion temp = new Estacion(n, cap, r);
		estaciones.add(temp);
		AdjListEstaciones.addVertex(temp);
		AdjMatEstaciones.addVertex(temp);
	}
	*/
	
	public void añadirConexion(String estacion1, String estacion2, double distancia) {
	}
}
