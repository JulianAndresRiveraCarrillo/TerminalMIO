package structures;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import data_structures.AdjListGraph;

class AdjListGraphTest {
	AdjListGraph<String> alg;
	/** STAGES **/	
	public void setUpStage1() {
		alg = new AdjListGraph<String>(false);
	}
	
	public void setUpStage2() {
		alg = new AdjListGraph<String>(false);
		alg.addVertex("Pueblo Paleta");
		alg.addVertex("Ciudad Verde");
		alg.addVertex("Ciudad Plateada");
	}
	
	public void setUpStage3() {
		alg = new AdjListGraph<String>(false);
		alg.addVertex("Pueblo Paleta");
		alg.addVertex("Ciudad Verde");
		alg.addVertex("Ciudad Plateada");
		alg.addEdge("Pueblo Paleta", "Ciudad Verde", 8);
		alg.addEdge("Ciudad Verde", "Ciudad Plateada", 15);
	}
	
	/** TESTS **/
	@Test
	void addVertexTest() {
		setUpStage1();
		alg.addVertex("Pueblo Paleta");
		assertEquals("Pueblo Paleta", alg.search(0));
	}
	
	@Test
	void addEdgeTest1() {
		setUpStage2();
		alg.addEdge("Pueblo Paleta", "Ciudad Verde", 8);
		alg.addEdge("Ciudad Verde", "Ciudad Plateada", 15);
		assertTrue(alg.areConnected("Pueblo Paleta", "Ciudad Verde"));
		assertTrue(alg.areConnected("Ciudad Verde", "Ciudad Plateada"));
	}
	
	@Test
	void addEdgeTest2() {
		setUpStage2();
		alg.addEdge("Pueblo Paleta", "Ciudad Verde", 8);
		assertTrue(alg.areConnected("Pueblo Paleta", "Ciudad Verde"));
		assertFalse(alg.areConnected("Ciudad Verde", "Ciudad Plateada"));
	}
	
	@Test
	void removeVertexTest() {
		setUpStage2();
		alg.removeVertex("Pueblo Paleta");
		assertFalse(alg.search("Pueblo Paleta"));
	}
	
	@Test
	void removeEdgeTest() {
		setUpStage3();
		alg.removeEdge("Pueblo Paleta", "Ciudad Verde");
		double [][] wm = alg.weightMatrix();
		assertFalse(alg.areConnected("Pueblo Paleta", "Ciudad Verde"));
		assertEquals(Double.POSITIVE_INFINITY, wm[0][1]);
		assertEquals(Double.POSITIVE_INFINITY, wm[1][0]);
	}
	
	@Test
	void searchTest1() {
		setUpStage1();
		assertNull(alg.search(0));
	}
	
	@Test
	void searchTest2() {
		setUpStage2();
		assertEquals("Pueblo Paleta", alg.search(0));
		assertTrue(alg.search("Ciudad Plateada"));
		assertFalse(alg.search("Hola"));
	}
	
	@Test
	void weightMatrixTest() {
		setUpStage3();
		double[][] matrix = alg.weightMatrix();
		assertEquals(8, matrix[0][1]);
		assertEquals(8, matrix[1][0]);
		assertEquals(15, matrix[1][2]);
		assertEquals(15, matrix[2][1]);
		assertEquals(Double.POSITIVE_INFINITY, matrix[0][2]);
		assertEquals(Double.POSITIVE_INFINITY, matrix[2][0]);
	}
	
	@Test
	void getIndexVTest() {
		setUpStage2();
		assertEquals(0, alg.getIndexV("Pueblo Paleta"));
		assertNotEquals(1, alg.getIndexV("Ciudad Plateada"));
	}
	
	@Test
	void getVertexTest() {
		setUpStage2();
		assertEquals(3, alg.getVertex());
		alg.addVertex("Ciudad Celeste");
		assertEquals(4, alg.getVertex());
	}
}
