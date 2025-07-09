public class SLList {
    Node sentinel;

    public SLList() {
        this.sentinel = new Node();
    }

    private static class Node {
        int item;
        Node next;
    }

    public int[][] gridify(int rows, int cols) {
        int[][] grid = new int[rows][cols];
        gridifyHelper(grid, sentinel.next, 0);
        return grid;
    }
    private void gridifyHelper(int[][] grid, Node curr, int numFilled) {
        if (curr == sentinel || numFilled >= grid.length * grid[0].length ) {
            return;
        }
        int row = numFilled / grid[0].length;
        int col = numFilled % grid[0].length;
        grid[row][col] = curr.item;
        gridifyHelper(grid, curr.next, numFilled+1);
    }
}