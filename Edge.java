import java.util.*;

public class Edge{
	private Node v1;
	private Node v2;
	private int weight;

	public Edge(Node v1, Node v2, int weight){
		setV1(v1);
		setV2(v2);
		setWeight(weight);
	}

	public Node getV1(){
		return v1;
	}
	public Node getV2(){
		return v2;
	}
	public int getWeight(){
		return weight;
	}

	public void setV1(Node v){
		v1=v;
	}
	public void setV2(Node v){
		v2=v;
	}
	public void setWeight(int w){
		weight=w;
	}

	public Node getPair(Node v){
		if (v.getName().equals(v1.getName())){
			return v2;
		}
		else{
			return v1;
		}
	}

}