package Day4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class part1 {
  
  public static void main (String[]args){
    String filePath = "Day4\\input.txt";
    String line;
    int total = 0;

    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      while ((line = reader.readLine()) != null) {
        int winningPoints = 0;
        String[] game = line.split(":");
        String partedGame = game[1].toString();
        partedGame = partedGame.replaceAll("\\s+", " ");
        String[] partedGameArray = partedGame.trim().split(" ");

        System.out.println(partedGame);


        for (int i = 0; i < 10; i++){
          for (int j = 11; j < partedGameArray.length; j++) {
            if (partedGameArray[i].equals(partedGameArray[j])) {
              if (winningPoints > 0) {
                winningPoints *= 2;
                System.out.println(partedGameArray[i] + "wp" +  winningPoints);
              } else {
                winningPoints = 1;
                System.out.println("first" + partedGameArray[i]);
              }
            }
          }
        }
        System.out.println(winningPoints);
        total += winningPoints;
      }

      System.out.println("Answer: " + total);

    }catch (IOException e) {
      e.printStackTrace();
    }
  }
}
