/**
 * 
 */
package com.salvation.matrix;

import java.util.Arrays;

/**
 * @author sayanroy
 *
 */
public class MatrixTraversal {

	public static void traverseSpiral(int[][] mat) {
		int startingRowIndex = 0;
		int startingColumnIndex = 0;
		int endingRowIndex = mat.length;
		int endingColumnIndex = mat[0].length;
		int i; // iterator index

		while (startingRowIndex < endingRowIndex
				&& startingColumnIndex < endingColumnIndex) {
			// for the 1st row of square -->--
			for (i = startingColumnIndex; i < endingColumnIndex; i++) {
				System.out.print(mat[startingRowIndex][i] + ", ");
			}
			startingRowIndex++;
			// for the last column of square
			// |
			// ^
			// |
			for (i = startingRowIndex; i < endingRowIndex; i++) {
				System.out.print(mat[i][endingColumnIndex - 1] + ", ");
			}
			endingColumnIndex--;

			if (startingRowIndex < endingRowIndex) {
				// for the last row of square --<--
				for (i = endingColumnIndex - 1; i >= startingColumnIndex; i--) {
					System.out.print(mat[endingRowIndex - 1][i] + ", ");
				}
				endingRowIndex--;
			}

			if (startingColumnIndex < endingColumnIndex) {
				// for the 1st column of square
				for (i = endingRowIndex - 1; i >= startingRowIndex; i--) {
					System.out.print(mat[i][startingColumnIndex] + ", ");
				}
				startingColumnIndex++;
			}
		}
	}

	/**
	 * traverse the matrix row wise.
	 * 
	 * @param mat
	 */
	public static void print(int [][] mat) {
		System.out.println("");
		int rowLength = mat.length;
		int colsLength = mat[0].length;
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colsLength; j++) {
				System.out.print(mat[i][j] + " ");
			}
		}
		System.out.println("");
	}
	
	public static void print(boolean [][] mat) {
		System.out.println("");
		int rowLength = mat.length;
		int colsLength = mat[0].length;
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colsLength; j++) {
				System.out.print(mat[i][j] + " ");
			}
		}
		System.out.println("");
	}

	public static void printColumnWise(int[][] mat) {
		System.out.println("");
		int rowLength = mat.length;
		int colsLength = mat[0].length;
		for (int i = 0; i < colsLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				System.out.print(mat[j][i] + " ");
			}
		}
		System.out.println("");
	}

	public static void modifyMatrix(boolean[][] mat) {
		int rowLength = mat.length;
		int columnLength = mat[0].length;
		boolean[] rows = new boolean[rowLength];
		boolean[] cols = new boolean[columnLength];

		// 1st iteration to detect the true co-ordinates
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columnLength; j++) {
				if (mat[i][j]) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		System.out.println("Printing the rows and cols arr index: "
				+ Arrays.toString(rows) + " || " + Arrays.toString(cols));
		// 2nd iteration to change the original matrix elements based on the
		// co-ordinate values of rows and cols
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columnLength; j++) {
				if (rows[i] || cols[j]) {
					mat[i][j] = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 } };
		System.out.println(Arrays.deepToString(mat));
		System.out.println("Matrix row wise : ");
		print(mat);
		System.out.println("Matrix column wise : ");
		printColumnWise(mat);
		traverseSpiral(mat);

		boolean[][] matrix = { { true, false, false, true },
				{ false, false, true, false }, { false, false, false, false } };
		modifyMatrix(matrix);
		System.out.println("Printing after modification : ");
		print(matrix);
	}

}
