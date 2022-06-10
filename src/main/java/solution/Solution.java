package solution;

public class Solution {
	
    public static int getResult(int[][] matrix) {
        return simpleDijkstra(matrix);
    }

    public static int simpleDijkstra(int[][] matrix) {
        int rightPrice;
        int downPrice;
        int[][] wayLength = new int[4][4];
        for(int i = 0 ; i < 4 ; i++)
            for(int j = 0 ; j < 4 ; j++)
                wayLength[i][j] = Integer.MAX_VALUE;
        wayLength[0][0] = 0;
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(j < 3) {
                    rightPrice = matrix[i][j + 1];
                    wayLength[i][j+1] = Integer.min(wayLength[i][j] + rightPrice , wayLength[i][j+1]);
                }

                if(i < 3) {
                    downPrice = matrix[i + 1][j];
                    wayLength[i+1][j] = Integer.min(wayLength[i][j] + downPrice , wayLength[i+1][j]);
                }
            }
        }
        return wayLength[3][3];
    }
}
