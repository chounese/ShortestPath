public class Graph{
	public int[][] weightGraph;
	private ArrayList<Node> vertexList = new ArrayList();

	public void addNode(Node n){
		vertexList.add(n)
	}
	public ArrayList<Node> getVList(){
		return vertexList;
	}
	public Graph(int width, int height){
		weightGraph=new int[width][height];
		for (int i = 0; i<width-1; i++){
			for (int j = 0; i<height-1; i++){
				weightGraph[i][j]=Integer.MAX_VALUE;
			}
		}
	}
}