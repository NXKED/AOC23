package Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class part2 {

    public static void main(String[] args) {
        String filePath = "Day9\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            BigInteger count = BigInteger.ZERO;

            for (String line : reader.lines().toList()) {
                count = count.add(calculateNextSequence(line));
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BigInteger calculateNextSequence(String line) {
        Deque<BigInteger[]> series = new ArrayDeque<>();
        BigInteger[] currentNumbers = initializeArray(line);

        boolean working = true;
        while (working) {
            series.push(currentNumbers);
            currentNumbers = calculateDifference(currentNumbers);
            working = Arrays.stream(currentNumbers).anyMatch(num -> !num.equals(BigInteger.ZERO));
        }

        return calculatePart2(series);
    }

    private static BigInteger[] initializeArray(String line) {
        String[] lineArray = line.split(" ");
        BigInteger[] numbers = new BigInteger[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            numbers[i] = new BigInteger(lineArray[i]);
        }
        return numbers;
    }

    private static BigInteger[] calculateDifference(BigInteger[] numbers) {
        BigInteger[] newArray = new BigInteger[numbers.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = numbers[i + 1].subtract(numbers[i]);
        }
        return newArray;
    }

    private static BigInteger calculatePart2(Deque<BigInteger[]> series) {
        BigInteger diff = BigInteger.ZERO;
        while (!series.isEmpty()) {
            BigInteger[] arr = series.pop();
            diff = arr[0].subtract(diff);
        }
        return diff;
    }
    
}
