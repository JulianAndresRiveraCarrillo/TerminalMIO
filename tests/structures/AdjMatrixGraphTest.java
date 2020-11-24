package structures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AdjMatrixGraphTest {
	AdjMatrixGraph<String> amg;
	/** STAGES **/	
	public void setUpStage1() {
		amg = new AdjMatrixGraph<String>(false);
	}
	
	public void setUpStage2() {
		amg = new AdjMatrixGraph<String>(false);
		amg.addVertex("Pueblo Paleta");
		amg.addVertex("Ciudad Verde");
		amg.addVertex("Ciudad Plateada");
	}
	
	public void setUpStage3() {
		amg = new AdjMatrixGraph<String>(false);
		amg.addVertex("Pueblo Paleta");
		amg.addVertex("Ciudad Verde");
		amg.addVertex("Ciudad Plateada");
		amg.addEdge("Pueblo Paleta", "Ciudad Verde", 8);
		amg.addEdge("Ciudad Verde", "Ciudad Plateada", 15);
	}
	
	/** TESTS **/
	@Test
	void addVertexTest() {
		setUpStage1();
		amg.addVertex("Pueblo Paleta");
		assertEquals("Pueblo Paleta", amg.searchVertex(0));
	}
	
	@Test
	void addEdgeTest1() {
		setUpStage2();
		amg.addEdge("Pueblo Paleta", "Ciudad Verde", 8);
		amg.addEdge("Ciudad Verde", "Ciudad Plateada", 15);
		assertTrue(amg.areConnected("Pueblo Paleta", "Ciudad Verde"));
		assertTrue(amg.areConnected("Ciudad Verde", "Ciudad Plateada"));
	}
	
	@Test
	void addEdgeTest2() {
		setUpStage2();
		amg.addEdge("Pueblo Paleta", "Ciudad Verde", 8);
		assertTrue(amg.areConnected("Pueblo Paleta", "Ciudad Verde"));
		assertFalse(amg.areConnected("Ciudad Verde", "Ciudad Plateada"));
	}
	
	@Test
	void searchTest1() {
		setUpStage1();
		assertNull(amg.searchVertex(0));
	}
	
	@Test
	void searchTest2() {
		setUpStage2();
		assertEquals("Pueblo Paleta", amg.searchVertex(0));
		assertEquals("Ciudad Plateada", amg.searchVertex(2));
		assertNull(amg.searchVertex(3));
	}
	
	@Test
	void weightMatrixTest() {
		setUpStage3();
		double[][] matrix = amg.weightMatrix();
		assertEquals(8, matrix[0][1]);
		assertEquals(8, matrix[1][0]);
		assertEquals(15, matrix[1][2]);
		assertEquals(15, matrix[2][1]);
		assertEquals(Double.POSITIVE_INFINITY, matrix[0][2]);
		assertEquals(Double.POSITIVE_INFINITY, matrix[2][0]);
	}
	
	@Test
	void getIndexTest() {
		setUpStage2();
		assertEquals(0, amg.getIndexV("Pueblo Paleta"));
		assertNotEquals(1, amg.getIndexV("Ciudad Plateada"));
	}
	
	@Test
	void getVertexTest() {
		setUpStage2();
		assertEquals(3, amg.getVertex());
		amg.addVertex("Ciudad Celeste");
		assertEquals(4, amg.getVertex());
	}
}