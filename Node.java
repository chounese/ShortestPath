import java.util.*;

public class Node{
	private ArrayList<Edge> adjList = new ArrayList<Edge>();
	private boolean isCorner=False;
	private int distance;
	private Node parent;

	public void setCorner(boolean b){
		isCorner=b;
	}
	public void addEdge(Edge e){
		adjList.add(e)
	}
	public void setDistance(int d){
		distance=d;
	}
	public void setParent(Node p){
		parent=p;
	}

	public boolean getCorner(){
		return isCorner;
	}
	public ArrayList<Edge> getAdjList(){
		return adjList;
	}
	public int getDistance(){
		return distance;
	}
	public Node getParent(){
		return parent;
	}

	
}