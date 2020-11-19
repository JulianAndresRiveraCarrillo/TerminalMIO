package structures;

import java.util.List;

public class AdjMatrixGraph<T> implements IGraph<T> {
	private static final int DEF_CAP = 15;
	private static final double GROWTH = 1.5;
	private boolean isDirected;
	private double[][] adjMatrixWeight;
	
	@Override
	public void addVertex(T u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(T u, T v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(T u, T v, double w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVertex(T u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(T u, T v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> adjVertex(T u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areConnected(T u, T v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double[][] weightMatrix() {
		return adjMatrixWeight;
	}

	@Override
	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public boolean isWeighted() {
		return false;
	}

	@Override
	public List<Edge<T>> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

}
