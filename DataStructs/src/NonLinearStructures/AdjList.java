package NonLinearStructures;

public class AdjList implements Graph
{
	private Edge[] graph;
	
	private int[] nodeValues;;
	
	public AdjList(int size) 
	{
		graph = new Edge[size];
		nodeValues = new int[size];
		initGraph();
	}
	
	private void initGraph() 
	{
		for(int i = 0; i < graph.length; i++) 
		{
			graph[i] = new Edge();
		}
	}
	
	private Edge getEdgeBefore(int vertex) 
	{
		Edge curr = graph[vertex];
		while(curr.next != null && curr.next.adjVertex < vertex) 
		{
			curr = curr.next;
		}
		return curr;
	}

	@Override
	public int nodeCount()
	{
		return graph.length;
	}

	@Override
	public void addEdge(int vertex, int adjVertex, int weight)
	{
		if(weight == 0) return;
		Edge edgeBefore = getEdgeBefore(vertex);
		if(edgeBefore.next != null && edgeBefore.next.adjVertex == adjVertex) 
		{
			edgeBefore.next.weight = weight;
		}
		else
		{
			edgeBefore.next = new Edge(adjVertex,weight,edgeBefore.next);
		}
	}

	@Override
	public void removeEdge(int vertex, int adjVertex)
	{
		Edge edgeBefore = getEdgeBefore(vertex);
		if(edgeBefore.next != null && edgeBefore.next.adjVertex == adjVertex) 
		{
			edgeBefore.next = edgeBefore.next.next;
		}
	}

	@Override
	public boolean hasEdge(int vertex, int adjVertex)
	{
		Edge edgeBefore = getEdgeBefore(vertex);
		return edgeBefore != null && edgeBefore.next.adjVertex == adjVertex;
	}

	@Override
	public int weight(int vertex, int adjVertex)
	{
		Edge edgeBefore = getEdgeBefore(vertex);
		if(edgeBefore.next == null || edgeBefore.next.adjVertex != adjVertex) 
		{
			return 0;
		}
		return edgeBefore.next.weight;
	}

	@Override
	public void setValue(int vertex, int value)
	{
		nodeValues[vertex] = value;
	}

	@Override
	public int getValue(int vertex)
	{
		return nodeValues[vertex];
	}

	@Override
	public void fillValues(int value)
	{
		for(int i = 0; i < nodeValues.length; i++) 
		{
			nodeValues[i] = value;
		}
	}

	@Override
	public int[] neighbors(int vertex)
	{
		int size = 0;
		Edge curr = graph[vertex].next;
		while(curr != null) 
		{
			size++;
			curr = curr.next;
		}
		
		int[] adjVertexes = new int[size];
		curr = graph[vertex].next;
		int index = 0;
		while(curr != null) 
		{
			adjVertexes[index++] = curr.adjVertex;
			curr = curr.next;
		}
		return adjVertexes;
	}
	
	
	
}
