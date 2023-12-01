package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class part2 {
    public static void main(String[] args) {
        String filePath = "Day1\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            Map<String, Integer> map = new HashMap<>();
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
            map.put("four", 4);
            map.put("five", 5);
            map.put("six", 6);
            map.put("seven", 7);
            map.put("eight", 8);
            map.put("nine", 9);

            while ((line = reader.readLine()) != null) {
                int num1 = 0;
                int num2 = 0;

                for (int i = 0; i < line.length(); i++) {
                    num1 = findNum(line, i, map);
                    if (num1 != 0) break;
                }

                for (int i = line.length() - 1; i >= 0; i--) {
                    num2 = findNum(line, i, map);
                    if (num2 != 0) break;
                }

                sum += Integer.parseInt(String.valueOf(num1) + num2);
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findNum(String line, int index, Map<String, Integer> map) {
        if (Character.isDigit(line.charAt(index))) {
            return Character.getNumericValue(line.charAt(index));
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String num = entry.getKey();
            if (line.startsWith(num, index)) {
                return entry.getValue();
            }
        }

        return 0;
    }
}
