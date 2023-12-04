package Day4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class part2 {
  
  public static void main(String[] args) {
    String filePath = "Day4\\input.txt";
    String line;
    int result = 0;
    int[] instances = new int[186];
    for (int i = 0; i < 186; i++) {
      instances[i] = 1;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      int counter = 0;

      while ((line = reader.readLine()) != null) {
        String[] game = line.split(":");
        String partedGame = game[1].toString();
        partedGame = partedGame.replaceAll("\\s+", " ");
        String[] partedGameArray = partedGame.trim().split(" ");

        int winningPoints = 0;
        
        for (int i = 0; i < 10; i++) {
          boolean foundMatch = false;
          for (int j = 11; j < partedGameArray.length; j++) {
            if (partedGameArray[i].equals(partedGameArray[j])) {
              foundMatch = true;
              break;
            }
          }
          if(foundMatch) {
            winningPoints++;
          }
        }

        for (int k = 0; k < winningPoints; k++) {
          int cardCopy = counter + k + 1;
          if (cardCopy < instances.length) {
            instances[cardCopy] += instances[counter];
          }
        }
        counter++;
      }

      for (int instance : instances) {
        result += instance;
      }

      System.out.println("Answer: " + result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
