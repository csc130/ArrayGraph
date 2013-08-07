package nvcc.graphs;

public class WeightedGaphDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 4;
		WeightedGraph <String> aGraph = new WeightedGraph<String>(size);
		for(int i=0; i<size; i++) {
			aGraph.addVertex("City " +i);
		}


		aGraph.addEdge("City 1", "City 2", 100);
		aGraph.addEdge("City 1", "City 3", 100);
		//System.out.println("City 1 Adjancents" + aGraph.getToVertices("City 1"));
		aGraph.addEdge("City 2", "City 3", 100);
		//System.out.println("City 2 Adjancents" + aGraph.getToVertices("City 2"));
		aGraph.addEdge("City 0", "City 1", 100);
		/*System.out.println("City 3 Adjancents" + aGraph.getToVertices("City 3"));
		System.out.println("City 4 Adjancents" + aGraph.getToVertices("City 4"));
		*/
		System.out.println(aGraph);
		System.out.println("City 0 Adjancents" + aGraph.getToVertices("City 0"));
		System.out.println("City 1 Adjancents" + aGraph.getToVertices("City 1"));
		System.out.println("City 2 Adjancents" + aGraph.getToVertices("City 2"));
		System.out.println("City 3 Adjancents" + aGraph.getToVertices("City 3"));
		
	}

}
