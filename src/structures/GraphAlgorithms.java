package structures;

import java.util.*;

public class GraphAlgorithms<T> {
	
	private static double[] cost;
	private static boolean[] F;
	private static int[] path;
	public static List<Integer> choice;

	
	public List<T> bfs(IGraph<T> graph, T source){
		List<T> bfs = new ArrayList<>();
		Queue<T> queue = new LinkedList<T>();
		
		T vertex = source;
		queue.add(vertex);
		boolean[] visited = new boolean[graph.getVertex()];
		
		while(!queue.isEmpty()) {
			
			vertex = queue.poll();
			int indexV = graph.getIndexV(vertex);
			
			if(!visited[indexV]) {
				
				bfs.add(vertex);
				visited[indexV] = true;
				List<T> adjacents = graph.adjVertex(vertex);
				queue.addAll(adjacents);
				
			}
		}
		
		return bfs;
	}
	
	public List<T> dfs(IGraph<T> graph, T source){
		List<T> dfs = new ArrayList<>();
		Stack<T> stack = new Stack<T>();
		
		T vertex = source;
		stack.add(vertex);
		boolean[] visited = new boolean[graph.getVertex()];

		while(!stack.isEmpty()) {

			vertex = stack.pop();
			int indexV = graph.getIndexV(vertex);
			
			if(!visited[indexV]) {
				
				dfs.add(vertex);
				visited[indexV] = true;
				List<T> adjacents = graph.adjVertex(vertex);
				stack.addAll(adjacents);
				
			}
		}
		
		return dfs;
	}
	
	public static <T> void dijkstra(T origin, IGraph<T> g, int c) {
		double[][] weights = g.weightMatrix(); 
		
		int index = g.getIndexV(origin); 
		int n = g.getVertex();
		
		cost = new double[n];
		F = new boolean[n];
		path = new int[n];
		choice = new ArrayList<Integer>();
		choice.add(g.getIndexV(origin));
		
		for (int i = 0; i < n; i++) {
			F[i] = false;
			cost[i] = weights[index][i];
			path[i] = index;
		}
		
		F[index] = true;
		cost[index] = 0;
		
		for (int k = 0; k < n; k++) {
			int v = minimum(n);
			F[v] = true;
			for (int i = 0; i < n; i++) {
				if(!F[i]) {
					if (cost[v] + weights[v][i] < cost[i]) {
						cost[i] = (cost[v] + weights[v][i]);
						path[i] = v;
						if (i == c) {
							choice.add(v);
						}
					}
				}
			}
		}
	}
	
	private static int minimum(int n) {
		double max = Integer.MAX_VALUE;
		int v = 1;
		for (int j = 0; j < n; j++) {
			if (!F[j] && (cost[j] <= max)) {
				max = cost[j];
				v = j;
			}
		}
		return v;
	}

	public static <T> double[][] floydWarshall(IGraph<T> graph){
		double[][] matrix = graph.weightMatrix();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix.length; k++) {
					
					if ((matrix[j][i] + matrix[i][k]) < matrix[j][k]) {
						matrix[j][k] = matrix[j][i] + matrix[i][k];
					}
					
				}
			}
		}
		return matrix;
	}
	
	public static <T> int prim(T node, IGraph<T> graph){
		double[][] matrix = graph.weightMatrix();
		
		int size = graph.getVertex();
		int index = graph.getIndexV(node);
		int minLength = 0;
		int aux;
		double min;
		double[] cost = new double[size];
		int[] closer = new int[size];
		boolean[] B = new boolean[size];
		
		for (int i = 0; i < size; i++) {
			B[i] = false;
		}
		
		B[index] = true;
		
		for (int i = 0; i < size; i++) {
			if (i != index) {
				cost[i] = matrix[index][i];
				closer[i] = 0;
			}
		}
		
		for (int i = 0; i < size; i++) {
			if (i != index) {
				min = cost[1];
				aux = 1;
				for (int j = 0; j < size; j++) {
					if (j != index) {
						if (cost[j] < min) {
							min = cost[j];
							aux = j;
						}
					}
				}
				minLength += min;
				B[aux] = true;
				cost[aux] = Integer.MAX_VALUE;
				
				for (int j = 0; j < size; j++) {
					if (j != index) {
						if (matrix[aux][j] < cost[j] && !B[j]) {
							cost[j] = matrix[aux][j];
							closer[j] = aux;
						}
					}
				}
			}
		}
		
		return minLength;
	
	}
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	
	public static <T> ArrayList<Edge<T>> kruskal(IGraph<T> graph){
		
		List<Edge<T>> result = new ArrayList<Edge<T>>(); 
		int res = 0;
		int edg = 0; 

		List<Edge<T>> edges = (ArrayList<Edge<T>>) graph.getEdges();

		Collections.sort(edges);

		DisjointSet ds = new DisjointSet(graph.getVertex());

		edg = 0;

		while (res < graph.getVertex() - 1 && edg < edges.size()) {
			
			Edge<T> edge = edges.get(edg);
			edg++;

			int x = ds.find(graph.getIndexV(edge.getSource()));
			int y = ds.find(graph.getIndexV(edge.getEnd()));

			if (x != y) {
				result.add(edge);
				res++;
				ds.union(x, y);
			}
			
		}
		return (ArrayList<Edge<T>>) result;
	}

	

=======

	public static double[] getCost() {
		return cost;
	}

	public static boolean[] getF() {
		return F;
	}

	public static int[] getPath() {
		return path;
	}

	public static List<Integer> getChoice() {
		return choice;
	}
>>>>>>> main
>>>>>>> Stashed changes
}
