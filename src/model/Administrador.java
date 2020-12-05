package model;

import java.util.*;
import data_structures.*;

public class Administrador {
	private ArrayList<Estacion> estaciones;
	private AdjListGraph<Estacion> AdjListEstaciones;
	private AdjMatrixGraph<Estacion> AdjMatEstaciones;
	
	public Administrador() {
		estaciones = new ArrayList<Estacion>();
		AdjListEstaciones = new AdjListGraph<Estacion>(false);
		AdjMatEstaciones = new AdjMatrixGraph<Estacion>(false);
	}
	
	public void a�adirEstacion(String n, int cap) {
		Estacion temp = new Estacion(n, cap);
		estaciones.add(temp);
		AdjListEstaciones.addVertex(temp);
		AdjMatEstaciones.addVertex(temp);
	}
	/*
	public void a�adirEstacion(String n, int cap, String r) {
		Estacion temp = new Estacion(n, cap, r);
		estaciones.add(temp);
		AdjListEstaciones.addVertex(temp);
		AdjMatEstaciones.addVertex(temp);
	}
	*/
	
	public void a�adirConexion(String estacion1, String estacion2) {
		
	}
}