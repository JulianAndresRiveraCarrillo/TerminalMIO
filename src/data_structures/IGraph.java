package data_structures;

import java.util.List;

public interface IGraph<T> {
	public boolean addVertex(T u);
	
	public void addEdge(T u, T v);
	
	public void addEdge(T u, T v, double w);
	
	public void removeVertex(T u);
	
	public void removeEdge(T u, T v);
	
	public List<T> adjVertex(T u);
	
	public boolean areConnected(T u, T v);
	
	public double[][] weightMatrix();
	
	public boolean isDirected();
	
	public boolean isWeighted();
	
	public boolean search(T value);
	
	public T search(int index);
	
	public List<Edge<T>> getEdges();
	
	public int getVertex();
	
	public int getIndexV(T vertex);
}
