package Day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.math.BigInteger;

public class part2 {
  public static void main(String[] args) throws FileNotFoundException {

    String filePath = "Day6\\input.txt";

    Scanner sc = new Scanner(new FileReader(filePath));
      String[] time = sc.nextLine().trim().split(":");
      String pTime = time[1].replaceAll("\\s+", "");
      String[] times = pTime.trim().split(" ");
      String[] distance = sc.nextLine().trim().split(":");
      String pDistance = distance[1].replaceAll("\\s+", "");
      String[] distances = pDistance.trim().split(" ");

      //System.out.println(times[0]);

      for (int i = 0; i < times.length; i++) {
        BigInteger w = getOptions(times[i], distances[i]);
        System.out.println("Part 2: " + w);
        
      }
  };



  private static BigInteger getOptions(String t, String d) {
    BigInteger g = new BigInteger(t);
    BigInteger f = new BigInteger(d);
    BigInteger counter = BigInteger.ZERO;
    for (BigInteger i = BigInteger.ZERO; i.compareTo(g) < 0; i = i.add(BigInteger.ONE)) {
      if (i.multiply(g.subtract(i)).compareTo(f) > 0) {
        counter = counter.add(BigInteger.ONE);
      }
    }
    return counter;
  }
}

