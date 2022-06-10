package solution;

import java.io.*;
import java.util.Objects;

public class TableReader {
    private final int[][] pricesMatrix;
    private final File tableFile;

    public TableReader(String tableFilePath){
        this.tableFile = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource(tableFilePath)).getFile());
        this.pricesMatrix = new int[4][4];
        this.readFile();
    }

    private void readFile() {
        try {
            FileReader reader;
            try {
            reader = new FileReader(this.tableFile);
            } catch (FileNotFoundException e) {
                System.out.println("File \"" + this.tableFile.getName() + "\"  not found or does not exist!");
                throw new RuntimeException(e);
            }

            BufferedReader bufferedReader = new BufferedReader(reader);
            String[] line;
            for( int i = 0 ; i < 3 ; i++) {
                line = bufferedReader.readLine().split(" ");
                if(line.length != 4){
                    System.out.println("String " + i + " does not contain 4 numbers");
                    throw new RuntimeException("String " + i + " does not contain 4 numbers");
                }
                for( int j = 0 ; j < 4 ; j++)
                    this.pricesMatrix[i][j] = Integer.parseInt(line[j]);
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] getMatrix(){
        return this.pricesMatrix;
    }

    public void printMatrix(){
        for (int[] matrix : this.pricesMatrix) {
            for (int i : matrix) System.out.print(i + " ");
            System.out.println();
        }
    }
}
