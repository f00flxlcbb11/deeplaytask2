package solution;



public class AreaPricesCalculator {
    private final int[][] pricesMatrixForCurrentRace;


    public AreaPricesCalculator(String race, int[][] pricesMatrix, char[][] areaMatrix) {
        this.pricesMatrixForCurrentRace = new int[4][4];
        this.calculate(race, pricesMatrix, areaMatrix);
    }

    private void calculate(String race, int[][] pricesMatrix, char[][] areaMatrix){
        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++)
                this.pricesMatrixForCurrentRace[i][j] = pricesMatrix[Main.raceId.get(race)][Main.areaId.get(areaMatrix[i][j])];
        }
    }

    public int[][] getMatrix(){
        return this.pricesMatrixForCurrentRace;
    }

    public void printMatrix(){
        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++) {
                System.out.print(this.pricesMatrixForCurrentRace[i][j] + " ");
            }
            System.out.println();
        }
    }
}
