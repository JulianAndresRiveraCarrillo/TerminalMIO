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
	
	public static<T> void dijkstra(T origin, IGraph<T> g, int c) {
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

}
