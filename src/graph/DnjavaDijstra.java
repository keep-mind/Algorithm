/**
 * 利用Dijkstra来求解单源最短路径
 */
package graph;

public class DnjavaDijstra
{
	private final static int MAXVEX = 9; // 最大顶点数
	private final static int MAXWEIGHT = 65535;  // 最大的权重
	private int shortTablePath[] = new int[MAXVEX];  // 用于存储v0到各点最短路径的权值和
	
	/**
	 * 获取一个图的最短路径
	 */
	public void shortestPathDijstra(Graph graph)
	{
		int min;
		int k = 0; // 记录下标
		boolean isgetPath[] = new boolean[MAXVEX]; // v0到某个顶点的最短路径,默认是false，表示还没有确定
		for (int v=0; v<graph.getVertexSize(); v++)
		{
			shortTablePath[v] = graph.getMatrix()[0][v];
		}
		shortTablePath[0] = 0;  // 到自己的距离为0（对角线为0）
		isgetPath[0] = true; // 拿到了到顶点0的最短距离
		
		for (int v=1; v<graph.getVertexSize(); v++)
		{
			min = MAXWEIGHT;
			// 遍历每一行的权值，找到其中最小的，记录下来
			for (int w=0; w<graph.getVertexSize(); w++)
			{
				// 没有找到到顶点w的最短距离且v与w之间有边
				if (!isgetPath[w] && shortTablePath[w] < min) // 获取有交点的顶点的下标
				{
					k = w;
					min = shortTablePath[w];
				}
			}
			// 找到到第k个顶点的最短路径
			isgetPath[k] = true;
			
			for (int j=0; j<graph.getVertexSize(); j++)
			{
				if (!isgetPath[j] && (min+graph.getMatrix()[k][j] < shortTablePath[j]))
				{
					shortTablePath[j] = min + graph.getMatrix()[k][j];
				}
			}
		}
		
		for (int i=0; i<shortTablePath.length; i++)
		{
			System.out.println("V0到V"+i+"的最短路径为:"+shortTablePath[i]);
		}
	}
	
	public static void main(String[] args)
	{
		Graph graph = new Graph(MAXVEX);
		graph.createGraph();
		int[][] matrix = {};
		new DnjavaDijstra().shortestPathDijstra(graph);
	}
}
