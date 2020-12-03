package structures;

public class Edge<T> implements Comparable<Edge<T>> {
	private double weight;
	private T source;
	private T end;
	
	/**
	 * @param source: the source vertex
	 * @param end: the end vertex
	 */
	public Edge(T source, T end) {
		weight = 1;
		this.source = source;
		this.end = end;
	}
	
	/**
	 * @param weight: the weight of the edge
	 * @param source: the source vertex
	 * @param end: the end vertex
	 */
	public Edge(double weight, T source, T end) {
		this.weight = weight;
		this.source = source;
		this.end = end;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public T getSource() {
		return source;
	}

	public void setSource(T source) {
		this.source = source;
	}

	public T getEnd() {
		return end;
	}

	public void setEnd(T end) {
		this.end = end;
	}

	@Override
	public int compareTo(Edge<T> e) {
		return Double.compare(weight, e.weight);
	}

}
