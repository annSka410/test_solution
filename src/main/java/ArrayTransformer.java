import java.util.Arrays;
import java.util.Random;

public class ArrayTransformer {
    StringBuilder numbers = new StringBuilder();

    public int[] transformToSequence(String[] array) {

        Arrays.stream(array).forEach(string -> {
            if (string.contains(",")) {
                String[] arrayOfString = string.split(",");
                for (int a = 0; a <= arrayOfString.length - 1; a++) {
                    transform(arrayOfString[a]);
                }
            } else if (string.contains("-")) {
                transform(string);
            } else {
                numbers.append(string).append(",");
            }
        });

        numbers.delete(numbers.length() - 1, numbers.length());
        String[] newArray = numbers.toString().split(",");
        newArray = Arrays.stream(newArray).distinct().toArray(String[]::new);
        int[] arrayOfNumder = new int[newArray.length];
        for (int k = 0; k <= newArray.length - 1; k++) {
            arrayOfNumder[k] = Integer.parseInt(newArray[k]);
        }
        Arrays.sort(arrayOfNumder);

        return arrayOfNumder;
    }

    public int[][] grouping(String[] array) {
        int[] arrayOfNumders = transformToSequence(array);
        int min = arrayOfNumders[0];
        int max = arrayOfNumders[arrayOfNumders.length - 1];

        int[][] twoDimArray = new int[8][3];

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                twoDimArray[i][j] = new Random().nextInt(max - min) + min;
            }
        }
        twoDimArray = Arrays.stream(twoDimArray).distinct().toArray(int[][]::new);
        return twoDimArray;
    }

    private void transform(String element) {
        if (element.contains("-")) {
            String[] newArray = element.split("-");
            int firstNumber = Integer.parseInt(newArray[0]);
            int secondNumber = Integer.parseInt(newArray[1]);
            numbers.append(firstNumber).append(",");
            for (int j = firstNumber + 1; j <= secondNumber; j++) {
                numbers.append(j).append(",");
            }
        } else {
            numbers.append(element).append(",");
        }
    }
}
