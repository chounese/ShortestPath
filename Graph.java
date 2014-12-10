import java.util.*;

public class Graph{
	// public int[][] weightGraph;
	private ArrayList<Node> vertexList = new ArrayList();

	public void addNode(Node n){
		vertexList.add(n);
	}
	public ArrayList<Node> getVList(){
		return vertexList;
	}
	public Graph(int width, int height, int v){
		for (int i=0; i<width+1; i++){
			for (int j=0; j<height+1; j++){
				String name=("g"+i+"."+j);
				Node newNode = new Node(name);
				addNode(newNode);
			}
		}
		for (int k=0; k<width; k++){
			for (int l=0; l<height; l++){
				for (int m=0; m<v; m++){
					String name=("v"+k+"."+l+"."+m);
					Node newNode = new Node(name);
					addNode(newNode);
				}
			}
		}
		// for (int z=0; z<vertexList.size(); z++){
		// 	System.out.print(vertexList.get(z).getName()+" ");
		// }
		// System.out.println();
	}
	// public Graph(int width, int height){
	// 	weightGraph=new int[width][height];
	// 	for (int i = 0; i<width-1; i++){
	// 		for (int j = 0; i<height-1; i++){
	// 			weightGraph[i][j]=Integer.MAX_VALUE;
	// 		}
	// 	}
	// }
}