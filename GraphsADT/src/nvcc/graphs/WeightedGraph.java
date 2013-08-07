// Incomplete version

//----------------------------------------------------------------------------
// WeightedGraph.java            by Dale/Joyce/Weems                 Chapter 9
//
// Implements a directed graph with weighted edges.
// Vertices are objects of class T and can be marked as having been visited.
// Edge weights are integers.
// Equivalence of vertices is determined by the vertices' equals method.
//
// General precondition: Except for the addVertex and hasVertex methods, 
// any vertex passed as an argument to a method is in this graph.
//----------------------------------------------------------------------------

package nvcc.graphs;

import java.util.Arrays;
import java.util.concurrent.LinkedTransferQueue;




public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
  public static final int NULL_EDGE = 0;
  private static final int DEFCAP = 50;  // default capacity
  private int numVertices;
  private int maxVertices;
  private T[] vertices;
  private int[][] edges;
  private boolean[] marks;  // marks[i] is mark for vertices[i]

  public WeightedGraph()
  // Instantiates a graph with capacity DEFCAP vertices.
  {
    numVertices = 0;
    maxVertices = DEFCAP;
    vertices = (T[]) new Object[DEFCAP];
    marks = new boolean[DEFCAP];
    edges = new int[DEFCAP][DEFCAP];
  }
 
  public WeightedGraph(int maxV)
  // Instantiates a graph with capacity maxV.
  {
    numVertices = 0;
    maxVertices = maxV;
    vertices = (T[]) new Object[maxV];
    marks = new boolean[maxV];
    edges = new int[maxV][maxV];
  }

  public boolean isEmpty()
  // Returns true if this graph is empty; otherwise, returns false.
  {
	  return(numVertices==0);
  }

  public boolean isFull()
  // Returns true if this graph is full; otherwise, returns false.
  {
	  return(numVertices==maxVertices);
  }

  public void addVertex(T vertex)
  // Preconditions:   This graph is not full.
  //                  Vertex is not already in this graph.
  //                  Vertex is not null.
  //
  // Adds vertex to this graph.
  {
    vertices[numVertices] = vertex;
    for (int index = 0; index < numVertices; index++)
    {
      edges[numVertices][index] = NULL_EDGE;
      edges[index][numVertices] = NULL_EDGE;
    }
    numVertices++;
  }

  public boolean hasVertex(T vertex)
  // Returns true if this graph contains vertex; otherwise, returns false.
  {
	  boolean found = false;
	  for(int i=0; i<numVertices;i++) {
		  if(vertices[i]==vertex) {
			  found = true;
		  }
	  }
	  return found;
  }
  
  private int indexIs(T vertex)
  // Returns the index of vertex in vertices.
  {
    int index = 0;
    while (!vertex.equals(vertices[index]))
      index++;
    return index;
  }

  public void addEdge(T fromVertex, T toVertex, int weight)
  // Adds an edge with the specified weight from fromVertex to toVertex.
  {
    int row;
    int column;
 
    row = indexIs(fromVertex);
    column = indexIs(toVertex);
    edges[row][column] = weight;
  }

  public int weightIs(T fromVertex, T toVertex)
  // If edge from fromVertex to toVertex exists, returns the weight of edge;
  // otherwise, returns a special “null-edge” value.
  {
    int row;
    int column;
 
    row = indexIs(fromVertex);
    column = indexIs(toVertex);
    return edges[row][column];
  }

  public  LinkedTransferQueue<T> getToVertices(T vertex)
  // Returns a queue of the vertices that are adjacent from vertex.
  {
	  LinkedTransferQueue<T> adjVertices = new  LinkedTransferQueue<T>();
    int fromIndex;
    int toIndex;
    fromIndex = indexIs(vertex);
    for (toIndex = 0; toIndex < numVertices; toIndex++)
      if (edges[fromIndex][toIndex] != NULL_EDGE)
        adjVertices.add(vertices[toIndex]);
    return adjVertices;
  }

  public void clearMarks()
  // Sets marks for all vertices to false.
  {
	  for(int i=0; i<this.numVertices;i++) {
		marks[i] = false;
	  }
  }

  public void markVertex(T vertex)
  // Sets mark for vertex to true.
  {
	  int index;
	  index = indexIs(vertex);
	  marks[index] = true;
  }

  public boolean isMarked(T vertex)
  // Returns true if vertex is marked; otherwise, returns false.
  {
	  int index;
	  index = indexIs(vertex);
	  return(marks[index]);
  }
  
  public  LinkedTransferQueue<T> getUnmarked()
  // Returns an unmarked vertex if any exist; otherwise, returns null.
  {
	  LinkedTransferQueue<T> unmarkedVertices = new  LinkedTransferQueue<T>();
	  for(int i=0; i<this.numVertices;i++) {
		if (marks[i] == true) {
			unmarkedVertices.add(vertices[i]);
		}
	  }
	  return unmarkedVertices;
  }
public String displayEdges() {
	String edgesList="";  
	
	for(int i=0; i<this.numVertices;i++) {
		edgesList += "["+i+"]\t";
		for(int j=0; j<this.numVertices; j++) {
		  edgesList += edges[i][j] +"\t";
		}
			edgesList+="\n";
	}
	edgesList+="\t";
	for(int i=0; i<this.numVertices;i++) {	
		  edgesList += "["+i+"]\t";
	}
	return edgesList;
}
@Override
public String toString() {
	return "WeightedGraph [vertices=" + Arrays.toString(vertices) + "\nedges=\n"
			+ displayEdges() + "\nmarks=" + Arrays.toString(marks)
			+ "]";
}
  
  
}
