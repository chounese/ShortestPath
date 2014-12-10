import java.util.*;

public class Node{
	private ArrayList<Edge> adjList = new ArrayList<Edge>();
	private boolean isCorner=false;
	private int distance;
	private Node parent;
	private String name;

	public void setCorner(boolean b){
		isCorner=b;
	}
	public void addEdge(Edge e){
		adjList.add(e);
	}
	public void setDistance(int d){
		distance=d;
	}
	public void setParent(Node p){
		parent=p;
	}
	public void setName(String n){
		name=n;
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
	public String getName(){
		return name;
	}

	public Node(){}

	public Node(String n){
		setName(n);
	}
	public Node(String n, boolean b){
		setName(n);
		setCorner(b);
	}
	
}