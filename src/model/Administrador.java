package model;

import java.io.Serializable;
import java.util.*;
import data_structures.*;

public class Administrador implements Serializable{
	private static final long serialVersionUID = 1L;
	private Map<String, Integer> estaciones;
	private AdjListGraph<Estacion> AdjListEstaciones;
	private AdjMatrixGraph<Estacion> AdjMatEstaciones;
	//private GraphAlgorithms<Estacion> alg;
	
	public Administrador() {
		estaciones = new HashMap<>();
		AdjListEstaciones = new AdjListGraph<Estacion>(false);
		AdjMatEstaciones = new AdjMatrixGraph<Estacion>(false);
	}
	
	public boolean añadirEstacion(String n, int cap) {
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
	public void añadirEstacion(String n, int cap, String r) {
		Estacion temp = new Estacion(n, cap, r);
		estaciones.add(temp);
		AdjListEstaciones.addVertex(temp);
		AdjMatEstaciones.addVertex(temp);
	}
	*/
	
	public boolean añadirConexion(String estacion1, String estacion2, double distancia) {
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
	
	public boolean eliminarConexion(String estacion1, String estacion2) {
		boolean con = false;
		Integer i1 = estaciones.get(estacion1);
		Integer i2 = estaciones.get(estacion2);
		if(i1!=null && i2!=null) {
			Estacion e1 = AdjListEstaciones.search(i1);
			Estacion e2 = AdjListEstaciones.search(i2);
			AdjListEstaciones.removeEdge(e1, e2);
			AdjMatEstaciones.removeEdge(e1, e2);
			con = true;
		}
		return con;
	}
	
	public boolean eliminarEstacion(String estacion) {
		boolean elim = false;
		Integer i = estaciones.get(estacion);
		if(i!=null) {
			Estacion e = AdjListEstaciones.search(i);
			AdjListEstaciones.removeVertex(e);
			AdjMatEstaciones.removeVertex(e);
			elim = true;
		}
		return elim;
	}
	
	public String rutaEntreDosEstaciones(String estacion1, String estacion2) {
		String route = "ESTACIONES:" + "\n";
		Integer i1 = estaciones.get(estacion1);
		Integer i2 = estaciones.get(estacion2);
		if(i1!=null && i2!=null) {
			Estacion e1 = AdjListEstaciones.search(i1);
			Estacion e2 = AdjListEstaciones.search(i2);
			
			ArrayList<Integer> list = GraphAlgorithms.dijkstra2(AdjListEstaciones, e1, e2);
			
			for (int i = 0; i < list.size(); i++) {
				Estacion temp = AdjListEstaciones.search(list.get(i));
				route += temp.getNombre().toUpperCase() + "\n";
			}
		}
		return route;
	}
	
	public String rutaCompleta(String estacion) {
		String route = "ESTACIONES:" + "\n";
		Integer i = estaciones.get(estacion);
		if(i!=null) {
			Estacion e = AdjListEstaciones.search(i);

			ArrayList<Integer> list = GraphAlgorithms.dijkstra(AdjListEstaciones, e);

			for (int j = 0; j < list.size(); j++) {
				Estacion temp = AdjListEstaciones.search(list.get(j));
				route += temp.getNombre().toUpperCase() + "\n";
			}
			
		}
		return route;
	}
}
