package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class part1 {


  public static void main(String[] args) {
    String filePath = "Day8\\input.txt";
    String wayPath = "Day8\\way.txt";
    String line; 
    String left; 
    String right;
    String temp;
    String way = "LLRLRRLLRLRRLLRLRRLRRRLRLRLRRRLLRLRRRLRLRRRLRLRLLLRRLRLRLLRLRRLRRRLRRRLLRRLRLRRRLRRLRRRLRLLRRLRRRLRRRLRRLRLRRLLLRLRLLRRRLRRLLRLRLRRLLRLRRLLRLRRLRRLLRRRLRLRLRRRLLRRRLRRLRRRLRRRLRLRRRLRRLLLRRRLRLLLRRRLRLLRLLRRRLLRRLRRRLRRRLRLLRLRLRRRLLRRLRRRLRRLRLLRRRLRRLRRRLRRRLRRRLRLRRRLRRRLRLRRRR";
    String[] toGo = way.split("");

    Map<String, String> mapLeft = new HashMap<>();
    Map<String, String> mapRight = new HashMap<>();

    
    
    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

      while((line = reader.readLine()) != null) {
        String[] lines = line.split("=");
        String leftRight = lines[1].trim();
        String[] lr = leftRight.split(",");
        String lpre = lr[0].trim();
        String rpre = lr[1].trim();
        left = lpre.substring(1, lpre.length());
        right = rpre.substring(0, rpre.length() - 1);
        String ind = lines[0].trim();

        mapLeft.put(ind,left);
        mapRight.put(ind,right);

        System.out.print("(" + ind + ")");
        System.out.print("(" + left + ")");
        System.out.println("(" + right + ")");


      }

      String start = "AAA";
      int counter = 0;
      for (int i = 0; i < toGo.length; i++) {
        if (toGo[i].equals("L")) {
          System.out.println(mapLeft.get(start));
          temp = mapLeft.get(start);
          start = temp;
          counter++;
        } else if (toGo[i].equals("R")) {
          temp = mapRight.get(start);
          start = temp;
          counter++;
          System.out.println(start);
        }
        if (start.equals("ZZZ")) {
          break;
        }
        if (i == toGo.length - 1) {
          i = -1;
        }
        
      }
      System.out.println(counter);

    } catch (IOException e) {
    e.printStackTrace();
  }
  }
}