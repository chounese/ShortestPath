import java.util.*;

public class ShortestPathsMain{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int width=sc.nextInt();
		int height=sc.nextInt();
		int vertexCount=sc.nextInt();
		while (sc.hasNext()){
			String v1 = sc.next();
			if (v1.equals("queries")){
				System.out.println(v1);
				while(sc.hasNext()){
					String sourceV=sc.next();
					String targetV=sc.next();
					System.out.println(sourceV+" "+targetV);
				}
			}
			else{
				String v2 = sc.next();
				int weight = sc.nextInt();
				System.out.println(v1+" "+v2+" "+weight);
			}
		}
	}
}
