package hw8.matrix;

public class MatrixUtils {

    public static int[][] transpose(int[][] matrix) {
        int column = matrix.length;
        int row = matrix[0].length;
        int[][] transposedMatrix = new int[row][column];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static String toString(int[][] matrix) {
        int maxLength = maxLengthOfMatrixElement(matrix);

        StringBuilder stringMatrix = new StringBuilder();
        StringBuilder stringElement;

        int spaceBetween = 1;
        int stringElementLength;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                stringElement = new StringBuilder(String.valueOf(matrix[i][j]));

                if (j + 1 < matrix[i].length) {
                    stringElementLength = maxLength - stringElement.length() + spaceBetween;

                    stringElement.append(" ".repeat(Math.max(0, stringElementLength)));
                }

                stringMatrix.append(stringElement);
            }
            if (i + 1 < matrix.length) {
                stringMatrix.append("\n");
            }
        }

        return stringMatrix.toString();
    }

    private static int maxLengthOfMatrixElement(int[][] matrix) {
        int maxLength = String.valueOf(matrix[0][0]).length();
        int currLength;

        for (int[] row : matrix) {
            for (int column : row) {
                currLength = String.valueOf(column).length();
                if (currLength > maxLength) {
                    maxLength = currLength;
                }
            }
        }

        return maxLength;
    }
}
