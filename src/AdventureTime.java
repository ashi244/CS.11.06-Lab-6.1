import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filename = "inputOneTwo.txt";
        int answerOne = challengeOne(filename);
        int answerTwo = challengeTwo(filename);
        String filename2 = "inputThreeFour.txt";
        int answerThree = challengeThree(filename2);
        int answerFour = challengeFour(filename2);
        String outputFile = "Adventure Time.txt";
        writeFileAllAnswers(outputFile, answerOne, answerTwo, answerThree, answerFour);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int [] measurements  = readFile(fileName);
        int counter = 0;
        for (int i = 1; i < measurements.length; i++){
            if (measurements[i] > measurements[i - 1]){
                counter++;
            }
        }
        return counter;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int [] measurements  = readFile(fileName);
        int prevSum = 0;
        int counter = 0;
        for (int i = 0; i < measurements.length - 2; i++){
            if (i == 0){
                prevSum = measurements[i] + measurements[i + 1] + measurements[i + 2];
            }
            else{
                if ((measurements[i] + measurements[i + 1] + measurements[i + 2]) > prevSum){
                    counter++;
                }
                prevSum = measurements[i] + measurements[i + 1] + measurements[i + 2];
            }
        }
        return counter;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String [] instructions  = readFileTwo(fileName);
        String [] directions = readString(instructions);
        int [] values = readInt(instructions);
        int x = 0;
        int y = 0;
        for (int i = 0; i < directions.length; i++){
            if (directions[i].equals("forward")){
                x += values[i];
            }
            else if (directions[i].equals("up")){
                y -= values[i];
            }
            else{
                y += values[i];
            }
        }
        return x * y;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String [] instructions  = readFileTwo(filename);
        String [] directions = readString(instructions);
        int [] values = readInt(instructions);
        int x = 0;
        int y = 0;
        int aim = 0;
        for (int i = 0; i < directions.length; i++){
            if (directions[i].equals("forward")){
                y += values[i] * aim;
                x += values[i];
            }
            else if (directions[i].equals("down")){
                aim += values[i];
            }
            else{
                aim -= values[i];
            }
        }
        return x * y;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }


    private static String[] readString(String [] array){
        String [] directions = new String [array.length / 2];
        int index = 0;
        for (int i = 0; i < array.length; i += 2){
            directions[index] = array[i];
            index++;
        }
        return directions;
    }
    private static String[] readFileTwo(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String [] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        String[] separatedArray = new String[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            String[] parts = data[i].split(" ");
            separatedArray[2 * i] = parts[0];  // Store the first part
            separatedArray[2 * i + 1] = parts[1];  // Store the second part
        }
        return separatedArray;
    }
    private static int[] readInt(String[] array){
        int [] values = new int [array.length / 2];
        int index = 0;
        for (int i = 1; i < array.length; i += 2){
            values[index++] = Integer.parseInt(array[i]);
        }
        return values;
    }
    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}