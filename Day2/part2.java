package Day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class part2 {
  
  public static void main(String[] args) {
    String filePath = "Day2\\input.txt";

    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      int total = 0;

      while ((line = reader.readLine()) != null) {
        String[] splitLine = line.split(":");
        String split = splitLine[1].toString();
        String[] games = split.split(";");
        String[][][] gameParted = new String[games.length][][];

        for (int i = 0; i < games.length; i++) {
          String[] pairs = games[i].trim().split(",");
          gameParted[i] = new String[pairs.length][];
          for (int j = 0; j < pairs.length; j++) {
            String[] parts = pairs[j].trim().split("\\s+");
            gameParted[i][j] = new String[]{parts[0], parts[1]};
          }
        }

        String[] gamePresetColors = {"green","red","blue"};
        int[] gamePresetCount = {0,0,0};

        outerloop:
        for (String[][] game : gameParted) {
          for (String[] pair : game) {
            for (int i = 0 ; i < gamePresetColors.length; i++) {
              if(pair[1].equals(gamePresetColors[i])) {
                int numCol = Integer.parseInt(pair[0]);
                if(numCol > gamePresetCount[i]){
                  gamePresetCount[i] = numCol;
                }
              }
            }  
          }
        }

          System.out.println("Game");


        //print games
        /*for (String[][] game: gameParted) {
          for (String[] pair : game) {
            System.out.println(Arrays.toString(pair));
          }
        }
        */


        int sum = gamePresetCount[0] * gamePresetCount[1] * gamePresetCount[2];
        System.out.println("Green: " + gamePresetCount[0] + " Red: " + gamePresetCount[1] + " Blue:" + gamePresetCount[2] + " SUM: " + sum);
        total += sum;
      }

      System.out.println("Total: " + total);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
