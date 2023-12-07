package Day7;

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
    String filePath = "Day7\\input.txt";
    String line; 
    
    Map<String, Integer> map = new HashMap();

    List<String> R6 = new ArrayList<String>();
    List<String> R5 = new ArrayList<String>();
    List<String> R4 = new ArrayList<String>();
    List<String> R3 = new ArrayList<String>();
    List<String> R2 = new ArrayList<String>();
    List<String> R1 = new ArrayList<String>();
    List<String> R0 = new ArrayList<String>();
  
    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

      while((line = reader.readLine()) != null) {
        String[] game = line.trim().split(" ");
        String cards = game[0].trim();
        String bid = game[1].trim();
        String[] numbers = cards.split("");
        int bidNum = Integer.parseInt(bid);
        
        
        char[] numbersChar = new char[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
          if (numbers[i].equals("T")) {
            numbersChar[i] = 'A';
          } else if (numbers[i].equals("J")) {
            numbersChar[i] = 'B';
          } else if (numbers[i].equals("Q")) {
            numbersChar[i] = 'C';
          } else if (numbers[i].equals("K")) {
            numbersChar[i] = 'D';
          } else if (numbers[i].equals("A")) {
            numbersChar[i] = 'E';
          } else {
            numbersChar[i] = numbers[i].charAt(0);
          }
        }
        
        String convertedCards = new String(numbersChar);
        map.put(convertedCards,bidNum);
        
        if (nOfAKind(numbersChar, 5)) {
          //System.out.println("5 of a kind | ");
          R6.add(convertedCards);
        } else if (nOfAKind(numbersChar, 4)) {
          //System.out.println("4 of a kind | " );
          R5.add(convertedCards);
        } else if(fullHouse(numbersChar)){
          //System.out.println("Full house");
          R4.add(convertedCards);
        } else if (nOfAKind(numbersChar, 3)) {
          //System.out.println("3 of a kind | ");
          R3.add(convertedCards);
        } else if (twoPairs(numbersChar)) {
          //System.out.println("two pair | ");
          R2.add(convertedCards);
        } else if (onePair(numbersChar)) {
          //System.out.println("one pair");
          R1.add(convertedCards);
        } else if (highCard(numbersChar)) {
          //System.out.println("high card | ");
          R0.add(convertedCards);
        }


      
      }

      Collections.sort(R6);
      Collections.sort(R5);
      Collections.sort(R4);
      Collections.sort(R3);
      Collections.sort(R2);
      Collections.sort(R1);
      Collections.sort(R0);
      Collections.reverse(R6);
      Collections.reverse(R5);
      Collections.reverse(R4);
      Collections.reverse(R3);
      Collections.reverse(R2);
      Collections.reverse(R1);
      Collections.reverse(R0);
      
      List<String> rankEY = new ArrayList<String>();

      rankEY.addAll(R6);
      rankEY.addAll(R5);
      rankEY.addAll(R4);
      rankEY.addAll(R3);
      rankEY.addAll(R2);
      rankEY.addAll(R1);
      rankEY.addAll(R0);

      Collections.reverse(rankEY);
      int result = 0;
      int count = 1;
      for (String r : rankEY) {
          result += (count * map.get(r));
          //System.out.println(map.get(r));
          count++;
      }
      System.out.println(result);

    } catch (IOException e) {
    e.printStackTrace();
  }
  }

  
  private static boolean fullHouse(char[] numbersChar) {
    Map<Character, Integer> charCount = new HashMap<>();

    for (Character c : numbersChar) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    boolean has3 = false;
    boolean has2 = false;

    for (Integer count: charCount.values()) {
      if (count == 3) {
        has3 = true;
      } else if (count == 2) {
        has2 = true;
      }
    }
    return has3 && has2;
  }


  private static boolean highCard(char[] numbersChar) {
    Map<Character, Integer> charCount = new HashMap<>();
    
    for (Character c : numbersChar) {
      charCount.put(c, charCount.getOrDefault(c, 0) +1);
      if (charCount.get(c)>1) {
        return false;
      }
    }
    return true;
  }
  private static boolean onePair(char[] numbersChar) {
    Map<Character, Integer> charCount = new HashMap<>();
    for (Character c : numbersChar) {
      charCount.put(c, charCount.getOrDefault(c, 0) +1);
    }
    int pairCount = 0;
    for (Integer count: charCount.values()) {
      if (count == 2) {
        pairCount++;
      }
    }
    return pairCount == 1;
  }
  
  private static boolean twoPairs(char[] numbersChar) {
    Map<Character, Integer> charCount = new HashMap<>();

    for(Character c : numbersChar) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    int pairCount = 0;
    for (Integer count : charCount.values()) {
      if (count == 2) {
        pairCount++;
      }
    }
    return pairCount == 2;
  }

  private static boolean nOfAKind(char[] charArray, int n) {
    Map<Character, Integer> charCount = new HashMap<>();

    for (Character c : charArray) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    return charCount.values().stream().anyMatch(count -> count == n);
  }
}
