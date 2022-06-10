package solution;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static  Map<String, Integer> raceId;
    public static Map<Character, Integer> areaId;
    public static void main(String[] args) {

        Main.raceId = new HashMap<>();
        Main.raceId.put("Human", 0);
        Main.raceId.put("Swamper", 1);
        Main.raceId.put("Woodman", 2);

        Main.areaId = new HashMap<>();
        Main.areaId.put('S', 0);
        Main.areaId.put('W', 1);
        Main.areaId.put('T', 2);
        Main.areaId.put('P', 3);

        AreaRaceReader areaRaceReader = new AreaRaceReader("areas/1.txt");
        char[][] areaMatrix = areaRaceReader.getMatrix();
        String race = areaRaceReader.getRace();

        TableReader tableReader = new TableReader("tables/1.txt");

        int[][] pricesMatrix = tableReader.getMatrix();

        // Все прочитано из файлов

        AreaPricesCalculator areaPricesCalculator = new AreaPricesCalculator(race, pricesMatrix, areaMatrix);

        int[][] pricesMatrixForCurrentRace = areaPricesCalculator.getMatrix();

        System.out.println(Solution.getResult(pricesMatrixForCurrentRace));

    }
}
