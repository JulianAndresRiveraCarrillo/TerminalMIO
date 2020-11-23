package structures;

import java.util.*;

public class AdjListGraph<T> implements IGraph<T> {
	private static final int DEF_CAP = 20;
	private boolean isDirected;
	private Map<T, Integer> VerticesIndex;
	private Map<Integer, T> IndexedVertices;
	private List<List<T>> adjLists;
	private double[][] adjMatrixWeight;
	
	
	public void initialize(int size) {
        adjLists = new ArrayList<List<T>>();
        IndexedVertices = new HashMap<>();
        VerticesIndex = new HashMap<>();
        adjMatrixWeight = new double[size][size];
	}
	
	public AdjListGraph(boolean dir) {
		initialize(DEF_CAP);
		isDirected = dir;
	}
	
	public AdjListGraph(boolean dir, int size) {
		initialize(size);
		isDirected = dir;
	}

	@Override
	public void addVertex(T u) {
		if(!search(u)) {
			List<T> vertexList = new ArrayList<T>();
			int index = adjLists.size();
			IndexedVertices.put(index, u);
			VerticesIndex.put(u, index);
			adjLists.add(vertexList);
		}
	}

	@Override
	public void addEdge(T u, T v) {
		Integer source = VerticesIndex.get(u);
		Integer end = VerticesIndex.get(v);
		if(source!=null && end!=null) {
			if(!isDirected) {
				adjLists.get(source).add(v);
				adjLists.get(end).add(u);
				adjMatrixWeight[source][end] = 1;
				adjMatrixWeight[end][source] = 1;
			}else {
				adjLists.get(source).add(v);
				adjMatrixWeight[source][end] = 1;
			}
		}
	}

	@Override
	public void addEdge(T u, T v, double w) {
		Integer source = VerticesIndex.get(u);
		Integer end = VerticesIndex.get(v);
		if(source!=null && end!=null) {
			if(!isDirected) {
				adjLists.get(source).add(v);
				adjLists.get(end).add(u);
				adjMatrixWeight[source][end] = w;
				adjMatrixWeight[end][source] = w;
			}else {
				adjLists.get(source).add(v);
				adjMatrixWeight[source][end] = w;
			}
		}
	}

	@Override
	public void removeVertex(T u) {
		if(search(u)) {
			adjLists.remove((int) VerticesIndex.get(u));
			for(int i = 0; i < adjLists.size(); i++) {
				List<T> current = adjLists.get(i);
				if(current.contains(u)) {
					current.remove(i);
				}
			}
			Integer toRemove = VerticesIndex.remove(u);
			IndexedVertices.remove(toRemove);
		}
	}

	@Override
	public void removeEdge(T u, T v) {
		Integer source = VerticesIndex.get(u);
		Integer end = VerticesIndex.get(v);
		if(source!=null && end!=null) {
			if(!isDirected) {
				adjLists.get(source).remove(v);
				adjLists.get(end).remove(u);
				adjMatrixWeight[source][end] = Double.POSITIVE_INFINITY;
				adjMatrixWeight[end][source] = Double.POSITIVE_INFINITY;
			}else {
				adjLists.get(source).remove(v);
				adjMatrixWeight[source][end] = Double.POSITIVE_INFINITY;
			}
		}
	}

	@Override
	public List<T> adjVertex(T u) {
		return adjLists.get(VerticesIndex.get(u));
	}

	@Override
	public boolean areConnected(T u, T v) {
		int source = VerticesIndex.get(u);
		int end = VerticesIndex.get(v);
		if(!isDirected) {
			return adjLists.get(source).contains(v) && adjLists.get(end).contains(u);
		}else {
			return adjLists.get(source).contains(v);
		}
	}

	@Override
	public double[][] weightMatrix() {
		for(int i = 0; i < adjLists.size(); i++) {
			for(int j = 0; j < adjLists.get(i).size(); j++) {
				if(i!=j) {
					if(adjMatrixWeight[i][j] == 0) {
						adjMatrixWeight[i][j] = Double.POSITIVE_INFINITY;
					}
				}
			}
		}
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
		return null;
	}
	
	public boolean search(T value) {
		return IndexedVertices.containsValue(value);
	}
	
	public T search(int index) {
		return IndexedVertices.get(index);
	}

	@Override
	public int getVertex() {
		return VerticesIndex.size();
	}

	@Override
	public int getIndexV(T vertex) {
		return VerticesIndex.get(vertex);
	}	
	
}
