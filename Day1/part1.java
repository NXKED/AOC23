package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class part1 {
    public static void main(String[] args) {
        String filePath = "Day1\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            while ((line = reader.readLine()) != null) {
                char[] chars = line.toCharArray();
                StringBuilder nums = new StringBuilder();

                for(char c : chars) {
                    if (Character.isDigit(c)) {
                    nums.append(c);
                    }
                }
                if (nums.length() > 0) {
                    sum += Integer.parseInt("" + nums.charAt(0) + nums.charAt(nums.length() - 1));
                }
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
