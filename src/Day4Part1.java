import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day4Part1{
    public static void main(String[] args) throws Exception {
        /*String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53\n" +
        "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19\n" +
        "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1\n" +
        "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83\n" +
        "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36\n" +
        "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11";*/

        String filePath = ("src/day4InputPart1.txt");

        String input = readFileToString(filePath);

        int sum = 0;

        for( String line: input.split("\n")){
            String cleanedLine = line.substring(line.indexOf(":") + 2);
            String[] parts = cleanedLine.split("\\|");
            String[] leftSideNumbers = parts[0].trim().split("\\s+");
            String[] rightSideNumbers = parts[1].trim().split("\\s+");
            int numCards = -1;
            for(String number: rightSideNumbers){
                if(containsNumber(leftSideNumbers, number)){
                    numCards += 1;
                }
            }
            //System.out.println("Number of winning cards for this line is " + numCards);
            sum += Math.pow(2, numCards);
        }

        System.out.println(sum);
    }

    private static String readFileToString(String filePath) throws Exception {
        Path path = Paths.get(filePath);
        byte[] fileBytes = Files.readAllBytes(path);
        return new String(fileBytes);
    }

    private static boolean containsNumber(String[] array, String target) {
        for (String element : array) {
            if (element.equals(target)) {
                return true;
            }
        }
        return false;
    }
}