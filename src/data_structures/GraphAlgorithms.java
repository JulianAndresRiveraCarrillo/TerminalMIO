package data_structures;

import java.util.*;

public class GraphAlgorithms<T> {
	private static double[] dist;
	private static Integer[] prev;
	
	private static double[] cost;
	private static boolean[] F;
	private static int[] path;
	public static List<Integer> choice;

	public static class Node{
		int id;
		double value;

		public Node(int id, double value) {
			this.id = id;
			this.value = value;
		}
	}
	
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
	
	/*
	public static <T> double dijkstra0(IGraph<T> g, T origin, T termination) {
		int start = g.getIndexV(origin);
		int end = g.getIndexV(termination);
		int n = g.getVertex();

		dist = new double[n];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(2 * n, new Comparator<Node>() {
			@Override
			public int compare(Node node1, Node node2) {
				if (Math.abs(node1.value - node2.value) < (1e-6)) 
					return 0;
				return (node1.value - node2.value) > 0 ? +1 : -1;
			}});
		pq.offer(new Node(start, 0));
		

		boolean[] visited = new boolean[n];
		prev = new Integer[n];

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			visited[node.id] = true;

			if (dist[node.id] < node.value) continue;

			List<Edge<T>> edges = g.getEdges();
			
			for (int i = 0; i < edges.size(); i++) {
				
				Edge<T> edge = edges.get(i);
				if (visited[g.getIndexV(edge.getEnd())]) continue;

				//double newDist = dist[g.getIndexV(edge.getSource())] + 1;
				double newDist = dist[g.getIndexV(edge.getSource())] + edge.getWeight();
				if (newDist < dist[g.getIndexV(edge.getEnd())]) {
					prev[g.getIndexV(edge.getEnd())] = g.getIndexV(edge.getSource());
					dist[g.getIndexV(edge.getEnd())] = newDist;
					pq.offer(new Node(g.getIndexV(edge.getEnd()), dist[g.getIndexV(edge.getEnd())]));
				}
			}
			if (node.id == end) return dist[end];
		}
		return Double.POSITIVE_INFINITY;
	}

*/
	public static <T> ArrayList<Integer> dijkstra(IGraph<T> g, T origin) {
		int start = g.getIndexV(origin);
		int n = g.getVertex();
		
		
		ArrayList<Integer> list = new ArrayList<>();
		
		dist = new double[n];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(2 * n, new Comparator<Node>() {
			@Override
			public int compare(Node node1, Node node2) {
				if (Math.abs(node1.value - node2.value) < (1e-6)) 
					return 0;
				return (node1.value - node2.value) > 0 ? +1 : -1;
			}});
		pq.offer(new Node(start, 0));
		

		boolean[] visited = new boolean[n];
		prev = new Integer[n];
		
		int j = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			list.add(node.id);
			
			visited[node.id] = true;

			if (dist[node.id] < node.value) continue;

			List<Edge<T>> edges = g.getEdges();
			
			for (int i = 0; i < edges.size(); i++) {
				
				Edge<T> edge = edges.get(i);
				if (visited[g.getIndexV(edge.getEnd())]) continue;

				double newDist = dist[g.getIndexV(edge.getSource())] + 1;
				//double newDist = dist[g.getIndexV(edge.getSource())] + edge.getWeight();
				if (newDist < dist[g.getIndexV(edge.getEnd())]) {
					prev[g.getIndexV(edge.getEnd())] = g.getIndexV(edge.getSource());
					dist[g.getIndexV(edge.getEnd())] = newDist;
					pq.offer(new Node(g.getIndexV(edge.getEnd()), dist[g.getIndexV(edge.getEnd())]));
				}
			}
			j++;
		}
		return list;
	}
	
	public static <T> ArrayList<Integer> dijkstra2(IGraph<T> g, T origin, T termination) {
		int start = g.getIndexV(origin);
		int end = g.getIndexV(termination);
		int n = g.getVertex();
		
		
		ArrayList<Integer> list = new ArrayList<>();
		
		dist = new double[n];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(2 * n, new Comparator<Node>() {
			@Override
			public int compare(Node node1, Node node2) {
				if (Math.abs(node1.value - node2.value) < (1e-6)) 
					return 0;
				return (node1.value - node2.value) > 0 ? +1 : -1;
			}});
		pq.offer(new Node(start, 0));
		

		boolean[] visited = new boolean[n];
		prev = new Integer[n];
		
		int j = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			list.add(node.id);
			
			visited[node.id] = true;

			if (dist[node.id] < node.value) continue;

			List<Edge<T>> edges = g.getEdges();
			
			for (int i = 0; i < edges.size(); i++) {
				
				Edge<T> edge = edges.get(i);
				if (visited[g.getIndexV(edge.getEnd())]) continue;

				double newDist = dist[g.getIndexV(edge.getSource())] + 1;
				//double newDist = dist[g.getIndexV(edge.getSource())] + edge.getWeight();
				if (newDist < dist[g.getIndexV(edge.getEnd())]) {
					prev[g.getIndexV(edge.getEnd())] = g.getIndexV(edge.getSource());
					dist[g.getIndexV(edge.getEnd())] = newDist;
					pq.offer(new Node(g.getIndexV(edge.getEnd()), dist[g.getIndexV(edge.getEnd())]));
				}
			}
			if (node.id == end) {
				ArrayList<Integer> aux = modifyArray(end, list);
				list.removeAll(list);
				list.addAll(aux);
			}
			j++;
		}
		return list;
	}
	
	private static ArrayList<Integer> modifyArray(int end, ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		boolean exit = false;
		
		for (int i = 0; i < temp.size() && !exit; i++) {
			if (end == list.get(i)) {
				temp.add(end);
				exit = true;
			}else {
				temp.add(list.get(i));
			}
		}
		
		return temp;
	}

	public static <T> double[][] floydWarshall(IGraph<T> graph){
		double[][] matrix = graph.weightMatrix();
		int size = graph.getVertex();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					
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
	
	public static double[] getDistance() {
		return dist;
	}
}
