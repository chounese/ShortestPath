import java.util.*;

public class ShortestPathsMain{
	public static void main(String[] args){
		ShortestPathsMain start=new ShortestPathsMain();
		start.go(args);
	}
	public void go(String[] args){
		Scanner sc= new Scanner(System.in);
		int width=sc.nextInt();
		int height=sc.nextInt();
		int vertexCount=sc.nextInt();
		Graph graph = new Graph(width, height, vertexCount);
		ArrayList<Node> vList=graph.getVList();
		while (sc.hasNext()){
			String v1 = sc.next();
			if (v1.equals("queries")){
				// System.out.println(v1);
				while(sc.hasNext()){
					String sourceVname=sc.next();
					String targetVname=sc.next();
					Node sourceV;
					Node targetV;
					String[] splitSourceVname=sourceVname.split("\\.");
					String[] splitTargetVname=targetVname.split("\\.");
					splitSourceVname[0]=splitSourceVname[0].substring(1,splitSourceVname[0].length());
					splitTargetVname[0]=splitTargetVname[0].substring(1,splitTargetVname[0].length());
					// System.out.println("Source split "+splitSourceVname[0]+" "+splitSourceVname[1]+" "+splitSourceVname[2]);
					// System.out.println("Target split "+splitTargetVname[0]+" "+splitTargetVname[1]+" "+splitTargetVname[2]);
					if (sourceVname.charAt(0)=='g'){
						//FIX SUBSTRINGS
						// System.out.println(((Integer.parseInt(sourceVname.substring(1,2)))*(width*width))+(Integer.parseInt(sourceVname.substring(3,4))));
						sourceV=vList.get(((Integer.parseInt(splitSourceVname[0]))*(width+1))+(Integer.parseInt(splitSourceVname[1])));
					}
					else{
						sourceV=vList.get(((Integer.parseInt(splitSourceVname[0]))*(width*width*width))+((Integer.parseInt(splitSourceVname[1]))*(width*width))+((Integer.parseInt(splitSourceVname[2])))+((width+1)*(width+1)));
					}
					// System.out.println("Source V is "+ sourceV.getName() + " and its name is "+sourceVname);
					if (targetVname.charAt(0)=='g'){
						// System.out.println(((Integer.parseInt(sourceVname.substring(1,2)))*(width*width))+(Integer.parseInt(sourceVname.substring(3,4))));
						targetV=vList.get(((Integer.parseInt(splitTargetVname[0]))*(width+1))+(Integer.parseInt(splitTargetVname[1])));
					}
					else{
						targetV=vList.get(((Integer.parseInt(splitTargetVname[0]))*(width*width*width))+((Integer.parseInt(splitTargetVname[1]))*(width*width))+((Integer.parseInt(splitTargetVname[2])))+((width+1)*(width+1)));
					}
					// System.out.println("Target V is "+ targetV.getName() + " and its name is "+targetVname);
					ArrayList<Node> dijkstra = danceStras(graph, sourceV);
					ArrayList<Node> path = new ArrayList<Node>();
					int x=0;
					// for (int z=0; z<dijkstra.size(); z++){
					// 	System.out.print(dijkstra.get(z).getName()+" ");
					// }
					Node temp=targetV;
					// System.out.println();
					while (temp.getParent()!=null){
					// for (int x = 0; x<dijkstra.size(); x++){
						path.add(temp);
						temp=temp.getParent();
						//System.out.println(path.get(x).getName());
					}
					path.add(temp);
					System.out.print(targetV.getDistance()+" ");
					for (int y=path.size()-1; y>=0; y--){
						System.out.print(path.get(y).getName()+" ");
					//GET WEIGHTS AND FINAL VERTEX//PATH
					// System.out.println(sourceV+" "+targetV);
					}
					System.out.println();
					System.out.println();
				}
			}
			else{
				String v2 = sc.next();
				int weight = sc.nextInt();
				// Edge newEdge = new Edge(v1, v2, weight);
				Node v1Node;
				Node v2Node;
				String[] v1List=v1.split("\\.");
				String[] v2List=v2.split("\\.");
				v1List[0]=v1List[0].substring(1,v1List[0].length());
				v2List[0]=v2List[0].substring(1,v2List[0].length());

				if (v1.charAt(0)=='g'){
					// System.out.println(((Integer.parseInt(v1.substring(1,2)))*(width*width))+(Integer.parseInt(v1.substring(3,4))));
					v1Node=vList.get(((Integer.parseInt(v1List[0]))*(width+1))+(Integer.parseInt(v1List[1])));
				}
				else{
					v1Node=vList.get(((Integer.parseInt(v1List[0]))*(width*width*width))+((Integer.parseInt(v1List[1]))*(width*width))+((Integer.parseInt(v1List[2])))+((width+1)*(width+1)));
				}
				if (v2.charAt(0)=='g'){
					v2Node=vList.get(((Integer.parseInt(v2List[0]))*(width+1))+(Integer.parseInt(v2List[1])));
				}
				else{
					// System.out.println((Integer.parseInt(v2.substring(5,6))));
					v2Node=vList.get(((Integer.parseInt(v2List[0]))*(width*width*width))+((Integer.parseInt(v2List[1]))*(width*width))+((Integer.parseInt(v2List[2])))+((width+1)*(width+1)));
				}
				Edge newEdge = new Edge(v1Node, v2Node, weight);
				v1Node.addEdge(newEdge);
				v2Node.addEdge(newEdge);

				// int gSize = graph.ge
				// for (int i=0; i<gSize; i++){
				// 	if ((vList.get(i).getName().equals(v1))||(vList.get(i).getName().equals(v2))){
				// 		vList.get(i).addEdge(newEdge);
				// 	}
				// }
				// System.out.println(v1+" "+v2+" "+weight);
			}
		// for (int a=0; a<vList.size(); a++){
		// 	System.out.print(vList.get(a).getName()+" [");
		// 	for (int b=0; b<vList.get(a).getAdjList().size(); b++){
		// 		System.out.print(vList.get(a).getAdjList().get(b).getPair(vList.get(a)).getName()+", ");				
		// 	}
		// 	System.out.print("]");
		// 	System.out.println();
		// }
		}
	}
	// public void initVertices(Graph g, Node s, ArrayList<Node> vList){
	// 	vGraph=vList;
	// 	for (int i=0; i<vGraph.length-1; i++){
	// 		vGraph.get(i).setDistance(Integer.MAX_VALUE);
	// 		vGraph.get(i).setParent(null);
	// 	}
	// 	s.get(i).setDistance(0);
	// }
	
	// public void relax(Node u, Node v, int w){
	// 	if (v.getDistance()>(u.getDistance()+w)){
	// 		v.setDistance((u.getDistance()+w));
	// 		v.setParent(u);
	// 	}
	// }

	public ArrayList<Node> danceStras(Graph g, Node s){
		ArrayList<Node> vGraph=g.getVList();
		// initVertices(g,s, vGraph);
		ArrayList<Node> verticesList = new ArrayList();
		PriorityQueue<Node, Integer> pq=new PriorityQueue<Node, Integer>();
		for (int i=0; i<vGraph.size(); i++){
			vGraph.get(i).setDistance(Integer.MAX_VALUE);
			vGraph.get(i).setParent(null);
			pq.addItem(vGraph.get(i),vGraph.get(i).getDistance());
		}
		s.setDistance(0);
		pq.addItem(s,s.getDistance());
		while (pq.getSize()!=0){
			// System.out.println("Beginning"+pq.getSize());
			//Casting the object from pq as a Node
			Node min = pq.removeItem();
			verticesList.add(min);
			ArrayList<Edge> minAdj=min.getAdjList();

			for (int j=0; j<minAdj.size(); j++){
				// System.out.println(minAdj.size());
				// System.out.println(j);
				// System.out.println(pq.getSize());
				Node v = minAdj.get(j).getPair(min);
				int edgeWeight = minAdj.get(j).getWeight();
				if (v.getDistance()>(min.getDistance()+edgeWeight)){
					v.setDistance((min.getDistance()+edgeWeight));
					v.setParent(min);
					pq.decreasePriority(v,v.getDistance());
				}
			}			
		}
		return verticesList;
	}
}
