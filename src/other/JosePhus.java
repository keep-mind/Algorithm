/**
 * ���Լɪ��
 */
package other;

public class JosePhus
{
	public static int N = 20; // һ����20��
	public static int M = 5; // ÿ������M
	class Node
	{
		int val; // �±�
		Node next; 
		public Node(int val)
		{
			this.val = val;
		}
	}
	
	
	public void killNode()
	{
		/**
		 * ���������б�
		 */
		Node header = new Node(1);
		Node x = header;
		for (int i=2; i<=N; i++)
		{
			x.next = new Node(i);
			x = x.next;
		}
		x.next = header; // ͷβ���,��ʱx�����һ����
		System.out.println("˳�������ǣ�");
		
		while (x!=x.next) // ����������ʱ������ѭ��
		{
			for (int i=1; i<M; i++)
			{
				x = x.next;
			}
			// ѭ�����xָ����ĸ���
			Node kill = x.next;
			x.next = kill.next;
			System.out.println("��"+kill.val+"���߳�");
			kill.val = 0; // ���Ϊ0����ʾ�Ѿ���kill
		}
		System.out.println("���һ���������ǣ�" + x.val);
	}
	
	public static void main(String[] args)
	{
		JosePhus josePhus = new JosePhus();
		josePhus.killNode();
	}
}
