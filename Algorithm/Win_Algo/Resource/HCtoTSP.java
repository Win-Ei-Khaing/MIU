public class HCtoTSP {
	public static int[][] polyTransform(int[][] HC){
		int n = HC.length;
		int[][] TSP = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (HC[i][j] == 0)
					TSP[i][j] = TSP[j][i] = 1;
				else
					TSP[i][j] = TSP[j][i] = 0;
			}
			TSP[i][i] = 0;
		}
		return TSP;		
	}
	
	public static void printGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++)
				System.out.print(graph[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
	   int [][] hc = new int[][] {{0, 0, 0, 1},{0, 0, 0, 1}, {0, 0, 0, 1}, {1, 1, 1, 0}};
       int [][] tsp = polyTransform(hc);
       System.out.println("HC instance");
       printGraph(hc);
       System.out.println("TSP instance");
       printGraph(tsp);
	}

}
