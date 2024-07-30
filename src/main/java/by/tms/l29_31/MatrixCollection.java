package by.tms.l29_31;

import java.util.Arrays;
import java.util.Iterator;

public class MatrixCollection implements Iterable<Integer> {
    private final int[][] matrix = new int[5][5];

    public void add(int value, int row, int col) {
        this.matrix[row][col] = value;
    }

    public int get(int row, int col) {
        return this.matrix[row][col];
    }

    public void remove(int row, int col) {
        this.matrix[row][col] = 0;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MatrixIterator();
    }

    private class MatrixIterator implements Iterator<Integer> {

        int row = 0;
        int col = 0;

        @Override
        public boolean hasNext() {
            return row != matrix[col].length;
        }

        @Override
        public Integer next() {
            int element = matrix[row][col];

            if (matrix[row].length - 1 == col) {
                col = 0;
                row++;
            } else {
                col++;
            }
            return element;
        }
    }
}