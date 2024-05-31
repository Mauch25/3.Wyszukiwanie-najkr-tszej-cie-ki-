import java.util.*;

public class Main {

    public static void main(String[] args) {

        int board_height;
        int board_width;
        Scanner in = new Scanner(System.in);

        System.out.println("Provide board height: ");
        board_height = in.nextInt();
        System.out.println("Provide board width: ");
        board_width = in.nextInt();

        int[][] board = new int[board_height][board_width];

        for (int i = 0; i < board_height; i++) {
            for (int j = 0; j < board_width; j++) {
                System.out.println("Enter the value for element at [" + i + "][" + j + "]: ");
                board[i][j] = in.nextInt();
            }
        }

        System.out.println(Arrays.deepToString(board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        PathHolder pathHolder = new PathHolder();
        pathHolder.setBestValue(-1);

        for(int i=0; i<board_height; i++){
            processPath(i, 0, board, pathHolder, board_height, board_width);
        }

        System.out.println("Best value");
        System.out.println(pathHolder.getBestValue());
        System.out.println("Best path");
        System.out.println(Arrays.toString(pathHolder.getBestPath().toArray()));
    }

    static void processPath(int currentRow, int currentColumn, int[][] board, PathHolder pathHolder, int board_height, int board_width){
        int state = 0;
        int rowToProcess = currentRow;

        pathHolder.setCurrentValue(pathHolder.getCurrentValue() + board[currentRow][currentColumn]);
        pathHolder.getCurrentPath().add(board[currentRow][currentColumn]);

        if(currentColumn + 1 < board_width) {
            while(state != 3) {
                if (state == 0) {
                    if (currentRow - 1 < 0) {
                        rowToProcess = board_height - 1;
                    } else {
                        rowToProcess = currentRow - 1;
                    }
                    state = 1;
                } else if (state == 1) {
                    rowToProcess = currentRow;
                    state = 2;
                } else if (state == 2) {
                    if (currentRow + 1 >= board_height) {
                        rowToProcess = 0;
                    } else {
                        rowToProcess = currentRow + 1;
                    }
                    state = 3;
                }
                processPath(rowToProcess,  currentColumn + 1, board, pathHolder, board_height, board_width);
            }
        } else {
            if(pathHolder.getBestValue() == -1 || pathHolder.getCurrentValue() < pathHolder.getBestValue()){
                pathHolder.setBestValue(pathHolder.getCurrentValue());
                pathHolder.setBestPath(new ArrayList<>());
                for(int i=0; i<pathHolder.getCurrentPath().size(); i++){
                    pathHolder.getBestPath().add(pathHolder.getCurrentPath().get(i));
                }
            }
        }
        pathHolder.setCurrentValue(pathHolder.getCurrentValue()-board[currentRow][currentColumn]);
        pathHolder.getCurrentPath().remove(pathHolder.getCurrentPath().size()-1);
    }
}

class PathHolder {
    private int bestValue;
    private List<Integer> bestPath = new ArrayList<Integer>();

    private int currentValue;
    private List<Integer> currentPath = new ArrayList<Integer>();

    int getBestValue() {
        return bestValue;
    }

    List<Integer> getBestPath() {
        return bestPath;
    }

    int getCurrentValue(){
        return currentValue;
    }

    List<Integer> getCurrentPath() {
        return currentPath;
    }

    void setBestValue(int bestValue) {
        this.bestValue = bestValue;
    }

    void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    void setBestPath(List<Integer> bestPath) {
        this.bestPath = bestPath;
    }

    void setCurrentPath(List<Integer> currentPath) {
        this.currentPath = currentPath;
    }
}