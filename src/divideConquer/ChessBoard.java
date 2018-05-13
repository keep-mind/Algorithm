/**
 * 解决棋盘覆盖问题
 */
package divideConquer;

import javax.swing.JPopupMenu.Separator;

public class ChessBoard
{
	private int[][] board; // 棋盘
	private int specialRow; // 特殊点的行下标
	private int specialCol; // 特殊点的列下标
	private int size;     // 棋盘大小
	private int type = 0; // 骨牌的类型
	
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
	 * @param leftRow 矩阵的左边起点行下标
	 * @param leftCol 矩阵的左边起点列下标
	 * @param size
	 */
	private void ChessBoard(int specialRow, int specialCol, int leftRow, int leftCol, int size)
	{
		if (size == 1)
		{
			return;
		}
		
		int subSize = size / 2;
		type = type % 4 + 1; // L型骨牌填充的区域（依次用1、2、3、4填充）
		int n = type;
		
		// 如果特殊点在左上方区域
		if (specialRow < leftRow+subSize && specialCol < leftCol+subSize)
		{
			ChessBoard(specialRow, specialCol, leftRow, leftCol, subSize);
		}
		else
		{
			// 特殊点不在左上角区域，左上角矩阵的右下角就是特殊点
			board[leftRow+subSize-1][leftCol+subSize-1] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize-1, leftRow, leftCol, subSize);
		}
		
		// 如果特殊点在右上方 
		if (specialRow < leftRow+subSize && specialCol >= leftCol + subSize)
		{
			ChessBoard(specialRow, specialCol, leftRow, leftCol+subSize, subSize);
		}
		else
		{
			board[leftRow+subSize-1][leftCol+subSize] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize, leftRow, leftCol+subSize, subSize);
		}
		
		// 如果特殊点在左下方
		if (specialRow >= leftRow + subSize && specialCol < leftCol + subSize)
		{
			ChessBoard(specialRow, specialCol, leftRow+subSize, leftCol, subSize);
		}
		else
		{
			board[leftRow+subSize][leftCol + subSize -1] = n;
			ChessBoard(leftRow+subSize, leftCol+subSize-1, leftRow+subSize, leftCol, subSize);
		}
		
		// 如果特殊点在右下方
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
