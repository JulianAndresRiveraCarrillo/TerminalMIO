package structures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import data_structures.AdjListGraph;
import data_structures.Edge;
import data_structures.GraphAlgorithms;
import data_structures.IGraph;

class GraphAlgorithmsAdjListTest {
	GraphAlgorithms<String> g = new GraphAlgorithms<String>();
	IGraph<String> graph;
	/** STAGES **/	
	public void setUpStage1() {
		graph = new AdjListGraph<String>(false);
		graph.addVertex("Pueblo Paleta");
		graph.addVertex("Ciudad Verde");
		graph.addVertex("Ciudad Plateada");
		graph.addVertex("Ciudad Celeste");
		graph.addEdge("Pueblo Paleta", "Ciudad Verde", 8);
		graph.addEdge("Ciudad Verde", "Ciudad Plateada", 15);
		graph.addEdge("Pueblo Paleta", "Ciudad Celeste", 5);
		graph.addEdge("Ciudad Celeste", "Ciudad Plateada", 6);
	}
	
	public void setUpStage2() {
		graph = new AdjListGraph<String>(false);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B", 8);
		graph.addEdge("A", "C", 5);
		graph.addEdge("A", "D", 3);
		graph.addEdge("B", "D", 6);
		graph.addEdge("C", "D", 1);
	}
	
	/** TESTS **/
	@Test
	void bfsTest1() {
		setUpStage1();
		List<String> b = g.bfs(graph, "Pueblo Paleta");
		assertEquals("Pueblo Paleta", b.get(0));
		assertEquals("Ciudad Verde", b.get(1));
		assertEquals("Ciudad Celeste", b.get(2));
		assertEquals("Ciudad Plateada", b.get(3));
		
		b = g.bfs(graph, "Ciudad Plateada");
		assertEquals("Ciudad Plateada", b.get(0));
		assertEquals("Ciudad Verde", b.get(1));
		assertEquals("Ciudad Celeste", b.get(2));
		assertEquals("Pueblo Paleta", b.get(3));
	}
	
	@Test
	void bfsTest2() {
		setUpStage2();
		List<String> b = g.bfs(graph, "A");
		assertEquals("A", b.get(0));
		assertEquals("B", b.get(1));
		assertEquals("C", b.get(2));
		assertEquals("D", b.get(3));
		
		b = g.bfs(graph, "D");
		assertEquals("D", b.get(0));
		assertEquals("A", b.get(1));
		assertEquals("B", b.get(2));
		assertEquals("C", b.get(3));
	}
	
	@Test
	void dfsTest1() {
		setUpStage1();
		List<String> d = g.dfs(graph, "Pueblo Paleta");
		assertEquals("Pueblo Paleta", d.get(0));
		assertEquals("Ciudad Celeste", d.get(1));
		assertEquals("Ciudad Plateada", d.get(2));
		assertEquals("Ciudad Verde", d.get(3));
		
		d = g.dfs(graph, "Ciudad Celeste");
		assertEquals("Ciudad Celeste", d.get(0));
		assertEquals("Ciudad Plateada", d.get(1));
		assertEquals("Ciudad Verde", d.get(2));
		assertEquals("Pueblo Paleta", d.get(3));
	}
	
	@Test
	void dfsTest2() {
		setUpStage2();
		List<String> d = g.bfs(graph, "A");
		assertEquals("A", d.get(0));
		assertEquals("B", d.get(1));
		assertEquals("C", d.get(2));
		assertEquals("D", d.get(3));
		
		d = g.bfs(graph, "D");
		assertEquals("D", d.get(0));
		assertEquals("A", d.get(1));
		assertEquals("B", d.get(2));
		assertEquals("C", d.get(3));
	}
	
	@Test
	void dijkstraTest1() {
		setUpStage1();
		GraphAlgorithms.dijkstra("Pueblo Paleta", graph, 0);
		double[] cost = GraphAlgorithms.getCost();
		assertEquals(0, cost[0]);
		assertEquals(8, cost[1]);
		assertEquals(11, cost[2]);
		assertEquals(5, cost[3]);
		
		assertEquals(3, GraphAlgorithms.getPath()[2]);
		
		GraphAlgorithms.dijkstra("Ciudad Celeste", graph, 0);
		cost = GraphAlgorithms.getCost();
		assertEquals(5, cost[0]);
		assertEquals(13, cost[1]);
		assertEquals(6, cost[2]);
		assertEquals(0, cost[3]);
		
		assertEquals(3, GraphAlgorithms.getPath()[2]);
	}
	
	@Test
	void dijkstraTest2() {
		setUpStage2();
		GraphAlgorithms.dijkstra("A", graph, 0);
		double[] cost = GraphAlgorithms.getCost();
		assertEquals(0, cost[0]);
		assertEquals(8, cost[1]);
		assertEquals(4, cost[2]);
		assertEquals(3, cost[3]);
		
		assertEquals(3, GraphAlgorithms.getPath()[2]);
		
		GraphAlgorithms.dijkstra("D", graph, 0);
		cost = GraphAlgorithms.getCost();
		assertEquals(3, cost[0]);
		assertEquals(6, cost[1]);
		assertEquals(1, cost[2]);
		assertEquals(0, cost[3]);
		
		assertEquals(3, GraphAlgorithms.getPath()[2]);
	}
	
	@Test
	void primTest1() {
		setUpStage1();
		assertEquals(19, GraphAlgorithms.prim("Pueblo Paleta", graph));
		assertEquals(13, GraphAlgorithms.prim("Ciudad Verde", graph));
		assertEquals(19, GraphAlgorithms.prim("Ciudad Celeste", graph));
		assertEquals(19, GraphAlgorithms.prim("Ciudad Plateada", graph));
	}
	
	@Test
	void primTest2() {
		setUpStage2();
		assertEquals(10, GraphAlgorithms.prim("A", graph));
		assertEquals(7, GraphAlgorithms.prim("B", graph));
		assertEquals(10, GraphAlgorithms.prim("C", graph));
		assertEquals(10, GraphAlgorithms.prim("D", graph));
	}
	
	@Test
	void floydTest() {
		setUpStage2();
		double[][] m = GraphAlgorithms.floydWarshall(graph);
		assertEquals(8, m[1][0]);
		assertEquals(8, m[0][1]);
		assertEquals(4, m[2][0]);
		assertEquals(4, m[0][2]);
		assertEquals(3, m[3][0]);
		assertEquals(3, m[0][3]);
		assertEquals(8, m[1][0]);
		assertEquals(8, m[0][1]);
		assertEquals(4, m[2][0]);
		assertEquals(4, m[0][2]);
		assertEquals(3, m[3][0]);
		assertEquals(3, m[0][3]);
	}
	
	@Test
	void kruskalTest1() {
		setUpStage1();
		ArrayList<Edge<String>> a = GraphAlgorithms.kruskal(graph);
		double totalW = 0;
		Edge<String> e = a.get(0);
		assertEquals(e.getSource(), graph.search(graph.getIndexV("Pueblo Paleta")));
		assertEquals(e.getEnd(), graph.search(graph.getIndexV("Ciudad Verde")));
		assertEquals(0, e.getWeight());
		totalW = e.getWeight();
		
		e = a.get(1);
		assertEquals(e.getSource(), graph.search(graph.getIndexV("Ciudad Verde")));
		assertEquals(e.getEnd(), graph.search(graph.getIndexV("Ciudad Plateada")));
		assertEquals(0, e.getWeight());
		totalW += e.getWeight();
		
		e = a.get(2);
		assertEquals(e.getSource(), graph.search(graph.getIndexV("Ciudad Celeste")));
		assertEquals(e.getEnd(), graph.search(graph.getIndexV("Pueblo Paleta")));
		assertEquals(5, e.getWeight());
		totalW += e.getWeight();
		
		assertEquals(5, totalW);
	}
	
	@Test
	void kruskalTest2() {
		setUpStage2();
		ArrayList<Edge<String>> a = GraphAlgorithms.kruskal(graph);
		double totalW = 0;
		Edge<String> e = a.get(0);
		assertEquals(e.getSource(), graph.search(graph.getIndexV("A")));
		assertEquals(e.getEnd(), graph.search(graph.getIndexV("B")));
		assertEquals(0, e.getWeight());
		totalW = e.getWeight();
		
		e = a.get(1);
		assertEquals(e.getSource(), graph.search(graph.getIndexV("B")));
		assertEquals(e.getEnd(), graph.search(graph.getIndexV("D")));
		assertEquals(0, e.getWeight());
		totalW += e.getWeight();
		
		e = a.get(2);
		assertEquals(e.getSource(), graph.search(graph.getIndexV("D")));
		assertEquals(e.getEnd(), graph.search(graph.getIndexV("C")));
		assertEquals(1, e.getWeight());
		totalW += e.getWeight();
		
		assertEquals(1, totalW);
	}
}
