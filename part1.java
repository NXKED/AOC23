import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class part1 {
  
  public static void main(String[] args) {
    String filePath = "input.txt";

    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean error = false;
      int idCounter = 0;
      int sumImpossibleIDs = 0;
      int sumPossibleIDs = 0;

      //String[][][] gameSet = {{{"3","blue"},{"4","red"}},{{"1","red"},{"2","green"},{"6","blue"}},{{"2","green"}}};
      String[] gamePresetColors = {"red","green","blue"};
      int[] gamePresetCount = {12,13,14};

      while ((line = reader.readLine()) != null) {
        error = false;
        idCounter+=1;
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

        outerloop:
        for (String[][] game : gameParted) {
          for (String[] pair : game) {
            for (int i = 0 ; i < gamePresetColors.length; i++) {
              if(pair[1].equals(gamePresetColors[i])) {
                int numCol = Integer.parseInt(pair[0]);
                if(numCol > gamePresetCount[i]){
                  error = true;
                  System.out.println("Error! " + "IS:(" + numCol + ") Preset:(" + gamePresetCount[i] + ") |id:" + idCounter + "| Game: " + Arrays.toString(pair));
                  sumImpossibleIDs += idCounter;
                  break outerloop;
                } else {
                  System.out.println("Correct! " + "IS:(" + numCol + ") Preset:(" + gamePresetCount[i] + ") |id:" + idCounter + "| Game: " + Arrays.toString(pair));
                }
              }
            }  
          }
        }

        if (!error) {
          System.out.println("Possible game");
          sumPossibleIDs += idCounter;

        }

        //print games
        /*for (String[][] game: gameParted) {
          for (String[] pair : game) {
            System.out.println(Arrays.toString(pair));
          }
        }
        */


      }
      System.out.println("Sum Impossible IDs: " + sumImpossibleIDs);
      System.out.println("Sum Possible IDs: " + sumPossibleIDs);


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
