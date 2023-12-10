import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Day9Part2 {
    public static void main(String[] args) throws IOException {
     /*   String input = "0 3 6 9 12 15\n" +
                "1 3 6 10 15 21\n" +
                "10 13 16 21 30 45";


        BigInteger sum = Arrays.stream(input.split("\n")).map(line -> (calcValue(line))).reduce(BigInteger.ZERO, BigInteger::add);*/

        String filePath = "src/Day9inputPart1.txt";
        Stream<String> lines = Files.lines(Paths.get(filePath));

        BigInteger sum = lines.map(line -> (calcValue(line))).reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println(sum);
    }

    public static BigInteger calcValue(String line){
        Deque<BigInteger[]> queue = new ArrayDeque<>();
        String[] nums = line.split(" ");
        BigInteger[] bigArr = new BigInteger[nums.length];
        int i = 0;
        for(String c: nums){
            bigArr[i] = new BigInteger(c);
            i++;
        }

        boolean processing = true;
        while (processing){
            queue.push(bigArr);
            BigInteger[] newArr = new BigInteger[bigArr.length-1];
            for(int j =0; j < newArr.length; j++){
                newArr[j] = bigArr[j+1].subtract(bigArr[j]);
            }
            bigArr = newArr;
            processing = false;
            for (int k =0; k<bigArr.length;k++){
                if(!bigArr[k].equals(BigInteger.ZERO)){
                    processing = true;
                }
            }
        }

        BigInteger diff = BigInteger.ZERO;
        while(!queue.isEmpty()) {
            BigInteger[] arr = queue.pop();
            diff = arr[0].subtract(diff);
        }

        return diff;

    }
}
