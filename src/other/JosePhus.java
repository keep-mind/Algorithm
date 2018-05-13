/**
 * 求解约瑟夫环
 */
package other;

public class JosePhus
{
	public static int N = 20; // 一共有20人
	public static int M = 5; // 每次数到M
	class Node
	{
		int val; // 下标
		Node next; 
		public Node(int val)
		{
			this.val = val;
		}
	}
	
	
	public void killNode()
	{
		/**
		 * 创建环形列表
		 */
		Node header = new Node(1);
		Node x = header;
		for (int i=2; i<=N; i++)
		{
			x.next = new Node(i);
			x = x.next;
		}
		x.next = header; // 头尾相接,此时x是最后一个人
		System.out.println("顺序依次是：");
		
		while (x!=x.next) // 至少有两人时，继续循环
		{
			for (int i=1; i<M; i++)
			{
				x = x.next;
			}
			// 循环完后x指向第四个人
			Node kill = x.next;
			x.next = kill.next;
			System.out.println("第"+kill.val+"被踢出");
			kill.val = 0; // 标记为0，表示已经被kill
		}
		System.out.println("最后一个生还者是：" + x.val);
	}
	
	public static void main(String[] args)
	{
		JosePhus josePhus = new JosePhus();
		josePhus.killNode();
	}
}
