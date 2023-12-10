import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class Day6Part2 {
    public static void main(String[] args) throws IOException {
        /*String inputLineOne = "Time:      7  15   30";
        String inputLineTwo = "Distance:  9  40  200";*/

        String filePath = "src/Day6inputPart1.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String inputLineOne = reader.readLine();
        String inputLineTwo = reader.readLine();



        inputLineOne = inputLineOne.substring(inputLineOne.indexOf(":") + 1).trim().replaceAll("\\s+", "");
        inputLineTwo = inputLineTwo.substring(inputLineTwo.indexOf(":") + 1).trim().replaceAll("\\s+", "");



        System.out.println(numOfTimes(new BigInteger(inputLineOne), new BigInteger(inputLineTwo)));

    }

    public static BigInteger numOfTimes(BigInteger time, BigInteger record) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(time) < 0; i = i.add(BigInteger.ONE)) {
            if (i.multiply(time.subtract(i)).compareTo(record) > 0) {
                sum = sum.add(BigInteger.ONE);
            }
        }
        return sum;
    }
}