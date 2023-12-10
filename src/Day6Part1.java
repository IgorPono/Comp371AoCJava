import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day6Part1 {
    public static void main(String[] args) throws IOException {
        /*String inputLineOne = "Time:      7  15   30";
        String inputLineTwo = "Distance:  9  40  200";*/

        String filePath = "src/Day6inputPart1.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String inputLineOne = reader.readLine();
        String inputLineTwo = reader.readLine();



        inputLineOne = inputLineOne.substring(inputLineOne.indexOf(":") + 1).trim();
        inputLineTwo = inputLineTwo.substring(inputLineTwo.indexOf(":") + 1).trim();

        String[] timeValues = inputLineOne.split("\\s+");
        String[] distanceValues = inputLineTwo.split("\\s+");

        //System.out.println(Arrays.toString(timeValues));
        //System.out.println(Arrays.toString(distanceValues));

        int sum = 1;

        for (int i = 0; i < timeValues.length; i++) {
            sum *= numOfTimes(Integer.parseInt(timeValues[i]), Integer.parseInt(distanceValues[i]));
        }

        System.out.println(sum);

    }

    public static int numOfTimes(int time, int record){
        int sum = 0;
        for (int i =0; i < time; i++){
            if((i * (time - i)) > record) {
                sum++;
            }
        }
        return sum;
    }
}