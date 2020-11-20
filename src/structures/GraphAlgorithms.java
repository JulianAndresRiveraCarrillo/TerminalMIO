package structures;

import java.util.*;

public class GraphAlgorithms<T> {
	
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
	
	public String Dijkstra(IGraph<T> graph, T source) {
		return null;
	}
}
