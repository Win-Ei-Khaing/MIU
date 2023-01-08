package lab11_undirected;

import java.util.ArrayList;
import java.util.List;

public class UnreachableVertices extends BreadthFirstSearch {
	int componentCount = 0;
	List<Vertex> unreachable = new ArrayList<Vertex>();
 	public UnreachableVertices(Graph graph) {
		super(graph);
	}
	
	@Override
	protected void additionalProcessing() {
		componentCount++;
	}
	@Override
	protected void processVertex(Vertex v) {
		if(componentCount>0)
			unreachable.add(v);
	}
	
	//TO-DO
	public List<Vertex> unreachables(Vertex v) {
		start(v);
		return unreachable;
	}

}
