package solution;

import java.io.*;
import java.util.Objects;


public class AreaRaceReader {
    private final char[][] areaMatrix;
    private String race;
    private final File areaFile;

    public AreaRaceReader(String areaFilePath) {
        this.areaFile = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource(areaFilePath)).getFile());
        this.areaMatrix = new char[4][4];
        this.race = "";
        this.readFile();
    }

    private void readFile() {
        FileReader reader;
        try {
            reader = new FileReader(this.areaFile);
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + this.areaFile.getName() + "\"  not found or does not exist!");
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(reader);

        String firstString;
        try {
            firstString = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if( 16 != firstString.length() ) {
            System.out.println("First string of file\"" + this.areaFile.getName() +"\" does not contain 16 characters");
            throw new RuntimeException("First string of file\"" + this.areaFile.getName() +"\" does not contain 16 characters");
        }
        if (!firstString.matches("[STWP]*")) {
            System.out.println("First line contains invalid characters");
            throw new RuntimeException("First line contains invalid characters");
        }

        for( int i = 0 ; i < 4 ; i++)
            for( int j = 0 ; j < 4 ; j++ )
                this.areaMatrix[i][j] = firstString.charAt(4*i +j);

        String secondString;
        try {
            secondString = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(secondString.length() == 0){
            System.out.println("Second line is empty");
            throw new RuntimeException("Second line is empty");
        }
        if (!Main.raceId.containsKey(secondString)) {
            System.out.println("Second line contains invalid race");
            throw new RuntimeException("Second line contains invalid race");
        }
        this.race = secondString;

        try {
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printMatrix(){
        for(int i = 0 ; i < 4 ; i++ ) {
            for (int j = 0; j < 4; j++ )
                System.out.print(this.areaMatrix[i][j] + " ");
            System.out.println();
        }
    }

    private void printRace(){
        System.out.println("race: " + this.race);
    }
    public char[][] getMatrix() {
        return this.areaMatrix;
    }
    public String getRace() {
        return this.race;
    }
}
