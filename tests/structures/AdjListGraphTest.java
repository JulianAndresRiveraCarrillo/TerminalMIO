package structures;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import structures.AdjListGraph;

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
	}
}
