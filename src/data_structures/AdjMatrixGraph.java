package data_structures;

import java.util.*;

public class AdjMatrixGraph<T> implements IGraph<T> {
	private static final int DEF_CAP = 20;
	private static final double GROWTH = 1.5;
	private int size;
	private boolean isDirected;
	private double[][] adjMatrix;
	private double[][] adjMatrixWeight;
	private Map<Integer, T> IndexedVertices;
	private Map<T, Integer> VerticesIndex;
	private NavigableSet<Integer> freePositions;
	
	public void initialize(int size) {
        this.size = 0;
        adjMatrix = new double[size][size];
        IndexedVertices = new HashMap<>();
        VerticesIndex = new HashMap<>();
        adjMatrixWeight = new double[size][size];
        freePositions = new TreeSet<>();
	}
	
	public AdjMatrixGraph(boolean dir) {
		initialize(DEF_CAP);
		isDirected = dir;
	}
	
	public AdjMatrixGraph(boolean dir, int size) {
		initialize(size);
		isDirected = dir;
	}
	
	@Override
	public boolean addVertex(T u) {
		int index;
		boolean added = false;
		if(VerticesIndex.get(u)==null) {
			if(freePositions.isEmpty()) {
				if(size==adjMatrix.length) {
					double[][] temp = adjMatrix;
					int newSize = (int) (adjMatrix.length*GROWTH);
					adjMatrix = new double[newSize][newSize];
					for(int i = 0; i < temp.length; i++) {
						System.arraycopy(temp[i], 0, adjMatrix[i], 0, temp.length);
					}
				}
				size++;
				index = size-1;
			}else {
				index = freePositions.pollFirst();
			}
			IndexedVertices.put(index, u);
			VerticesIndex.put(u, index);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void addEdge(T u, T v) {
		Integer source = VerticesIndex.get(u);
		Integer end = VerticesIndex.get(v);
		if(source!=null && end!=null) {
			int s = source;
			int e = end;
			if(!isDirected) {
				adjMatrix[s][e] = 1;
				adjMatrix[e][s] = 1;
				adjMatrixWeight[s][e] = 1;
				adjMatrixWeight[e][s] = 1;
			}else {
				adjMatrix[s][e] = 1;
				adjMatrixWeight[s][e] = 1;
			}
		}
	}

	@Override
	public void addEdge(T u, T v, double w) {
		Integer source = VerticesIndex.get(u);
		Integer end = VerticesIndex.get(v);
		if(source!=null && end!=null) {
			int s = source;
			int e = end;
			if(!isDirected) {
				adjMatrix[s][e] = 1;
				adjMatrix[e][s] = 1;
				adjMatrixWeight[s][e] = w;
				adjMatrixWeight[e][s] = w;
			}else {
				adjMatrix[s][e] = 1;
				adjMatrixWeight[s][e] = w;
			}
		}
	}

	@Override
	public void removeVertex(T u) {
		Integer pos = VerticesIndex.get(u);
		if(pos!=null) {
			IndexedVertices.remove(pos);
			VerticesIndex.remove(u);
			freePositions.add(pos);
			for(int i = 0; i < size; i++) {
				adjMatrix[pos][i] = 0;
				adjMatrix[i][pos] = 0;
			}
		}
	}

	@Override
	public void removeEdge(T u, T v) {
		Integer source = VerticesIndex.get(u);
		Integer end = VerticesIndex.get(v);
		if(source!=null && end!=null) {
			if(!isDirected) {
				adjMatrix[source][end] = 0;
				adjMatrix[end][source] = 0;
				adjMatrixWeight[source][end] = 0;
				adjMatrixWeight[end][source] = 0;
			}else {
				adjMatrix[source][end] = 0;
				adjMatrixWeight[source][end] = 0;
			}
		}
	}

	@Override
	public List<T> adjVertex(T u) {
		Integer pos = VerticesIndex.get(u);
		List<T> adjVertices = null;
		if(pos!=null) {
			Set<Integer> adjVertexPos = new HashSet<>();
			for(int i = 0; i < size; i++) {
				if(adjMatrix[i][pos] != 0) {
					adjVertexPos.add(i);
				}
			}
			adjVertices = new ArrayList<>();
			for(Integer adjVerP : adjVertexPos) {
				adjVertices.add(IndexedVertices.get(adjVerP));
			}
		}
		return adjVertices;
	}

	@Override
	public boolean areConnected(T u, T v) {
		int source = VerticesIndex.get(u);
		int end = VerticesIndex.get(v);
		if(!isDirected) {
			return adjMatrix[source][end] != 0 && adjMatrix[end][source] != 0;
		}else {
			return adjMatrix[source][end] != 0;
		}
	}

	@Override
	public double[][] weightMatrix() {
		for(int i = 0; i < adjMatrix.length; i++) {
			for(int j = 0; j < adjMatrix.length; j++) {
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
		List<Edge<T>> edges = new ArrayList<>();
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if(adjMatrix[i][j] == 1) {
					edges.add(new Edge<T>(weightMatrix()[i][j], IndexedVertices.get(i), IndexedVertices.get(j)));
				}
			}
		}
		return edges;
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
