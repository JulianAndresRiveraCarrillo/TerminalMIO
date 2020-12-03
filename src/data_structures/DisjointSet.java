package data_structures;

public class DisjointSet {

	private int[] pairs;
	private int[] rank;
	
	public DisjointSet(int size) {
		pairs = new int[size];
		rank = new int[size];
		
		initPairs();
	}
	
	public void initPairs() {
		for (int i = 0; i < pairs.length; i++) {
			pairs[i] = i;
		}
	}
	
	public int find(int i) {
		int v = pairs[i];
		
		if (i == v) {
			return i;
		}
		
		return pairs[i] = find(v);
	}

	public void union(int i, int j) {
		int v1 = find(i);
		int v2 = find(j);
		
		if (v2 == v1) {
			return;
		}
			
		if (rank[v1] > rank[v2]) {
			pairs[v2] = v1;
		} else if (rank[v2] > rank[v1]) {
			pairs[v1] = v2;
		} else {
			pairs[v2] = v1;
			rank[v1]++;
		}
	}

}
