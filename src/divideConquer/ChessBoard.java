/**
 * ������̸�������
 */
package divideConquer;

import javax.swing.JPopupMenu.Separator;

public class ChessBoard
{
	private int[][] board; // ����
	private int specialRow; // ���������±�
	private int specialCol; // ���������±�
	private int size;     // ���̴�С
	private int type = 0; // ���Ƶ�����
	
	public ChessBoard(int specialRow, int specialCol, int size, int type)
	{
		super();
		this.specialRow = specialRow;
		this.specialCol = specialCol;
		this.size = size;
		this.type = type;
		board = new int[size][size];
	}
	/**
	 * 
	 * @param specialRow
	 * @param specialCol
	 * @param leftRow ��������������±�
	 * @param leftCol ��������������±�
	 * @param size
	 */
	private void ChessBoard(int specialRow, int specialCol, int leftRow, int leftCol, int size)
	{
		if (size == 1)
		{
			return;
		}
		
		int subSize = size / 2;
		type = type % 4 + 1; // L�͹�����������������1��2��3��4��䣩
		int n = type;
		
		// �������������Ϸ�����
		if (specialRow < leftRow+subSize && specialCol < leftCol+subSize)
		{
			ChessBoard(specialRow, specialCol, leftRow, leftCol, subSize);
		}
		else
		{
			// ����㲻�����Ͻ��������ϽǾ�������½Ǿ��������
			board[leftRow+subSize-1][leftCol+subSize-1] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize-1, leftRow, leftCol, subSize);
		}
		
		// �������������Ϸ� 
		if (specialRow < leftRow+subSize && specialCol >= leftCol + subSize)
		{
			ChessBoard(specialRow, specialCol, leftRow, leftCol+subSize, subSize);
		}
		else
		{
			board[leftRow+subSize-1][leftCol+subSize] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize, leftRow, leftCol+subSize, subSize);
		}
		
		// �������������·�
		if (specialRow >= leftRow + subSize && specialCol < leftCol + subSize)
		{
			ChessBoard(specialRow, specialCol, leftRow+subSize, leftCol, subSize);
		}
		else
		{
			board[leftRow+subSize][leftCol + subSize -1] = n;
			ChessBoard(leftRow+subSize, leftCol+subSize-1, leftRow+subSize, leftCol, subSize);
		}
		
		// �������������·�
		if (specialRow >= leftRow + subSize && specialCol> leftCol + subSize)
		{
			ChessBoard(specialRow, specialCol, leftRow+subSize, leftCol+subSize, subSize);
		}
		else
		{
			board[leftRow+subSize][leftCol+subSize]= n;
			ChessBoard(leftRow+subSize, leftCol+subSize, leftRow+subSize, leftCol+subSize, subSize);
		}		
	}
	
	public static void main(String[] args)
	{
		int leftRow = 0;
		int leftCol = 0;
		int specialRow = 0;
		int specialCol = 1;
		int size = 4;
		
		ChessBoard c = new ChessBoard(specialRow, specialCol, size, 1);
		c.ChessBoard(specialRow, specialCol, leftRow, leftCol, size);
		
		for (int[] row: c.board)
		{
			for(int col: row)
			{
				System.out.print(col + "     ");
			}
			System.out.println();
		}
	}
}
