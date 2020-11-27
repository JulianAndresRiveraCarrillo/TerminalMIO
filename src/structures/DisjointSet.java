package structures;

public class DisjointSet {

	private int[] pairs;
	private int[] ranks;
	
	public DisjointSet(int size) {
		pairs = new int[size];
		ranks = new int[size];
		
		initPairs(size);
	}
	
	public void initPairs(int size) {
		for (int i = 0; i < pairs.length; i++) {
			pairs[i] = i;
		}
	}
	
	public int find(int index) {
		int v = pairs[index];
		
		if (index == v) {
			return index;
		}
		
		return pairs[index]= find(v);
	}
	
	public void union(int i, int j) {
		int v1 = find(i);
		int v2 = find(j);
		
		if (v2 == v1)
			return;
		if (ranks[v1] > ranks[v2]) {
			pairs[v2] = v1;
		} else if (ranks[v2] > ranks[v1]) {
			pairs[v1] = v2;
		} else {
			pairs[v2] = v1;
			ranks[v1]++;
		}
	}

}
