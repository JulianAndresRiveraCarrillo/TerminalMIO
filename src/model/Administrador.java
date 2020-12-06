package model;

import java.util.*;
import data_structures.*;
import excepciones.EstacionRepetidaException;

public class Administrador {
	private Map<String, Integer> estaciones;
	private AdjListGraph<Estacion> AdjListEstaciones;
	private AdjMatrixGraph<Estacion> AdjMatEstaciones;
	
	public Administrador() {
		estaciones = new HashMap<>();
		AdjListEstaciones = new AdjListGraph<Estacion>(false);
		AdjMatEstaciones = new AdjMatrixGraph<Estacion>(false);
	}
	
	public boolean a�adirEstacion(String n, int cap) {
		boolean aux = false;
		Estacion temp = new Estacion(n, cap);
		if (AdjListEstaciones.addVertex(temp)) {
			aux = true;
		}
		if (AdjMatEstaciones.addVertex(temp)) {
			aux = true;
		}
		if(aux) {
			estaciones.put(n, AdjListEstaciones.getVertex()-1);
		}
		return aux;
	}
	/*
	public void a�adirEstacion(String n, int cap, String r) {
		Estacion temp = new Estacion(n, cap, r);
		estaciones.add(temp);
		AdjListEstaciones.addVertex(temp);
		AdjMatEstaciones.addVertex(temp);
	}
	*/
	
	public boolean a�adirConexion(String estacion1, String estacion2, double distancia) {
		boolean con = false;
		Integer i1 = estaciones.get(estacion1);
		Integer i2 = estaciones.get(estacion2);
		if(i1!=null && i2!=null) {
			Estacion e1 = AdjListEstaciones.search(i1);
			Estacion e2 = AdjListEstaciones.search(i2);
			AdjListEstaciones.addEdge(e1, e2, distancia);
			AdjMatEstaciones.addEdge(e1, e2, distancia);
			con = true;
		}
		return con;
	}
	
	public Estacion buscar(String estacion) {
		Estacion aux = null;
		Integer i = estaciones.get(estacion);
		
		if (i != null) {
			Estacion temp = AdjMatEstaciones.search(i);
			if (temp != null) {
				aux = temp;
			}
		}
		
		return aux;
	}
}
