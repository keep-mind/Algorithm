package test;

public class Test
{
	int age = 20; // ����
	int weight = 50;  // ����
	String name = "zhang"; // ����
	String color = "blue"; // ��ɫ

	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(t.hashCode());
	}
	
	@Override
	public int hashCode()
	{
		return 7 * name.hashCode() + 11 * new Integer(age).hashCode() + 13 * new Double(weight).hashCode() + 17 * color.hashCode();
	}
}
