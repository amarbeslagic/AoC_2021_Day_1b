import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_1b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Integer> listOfNumbers = new ArrayList<>();

        String s;
        //put numbers in array
        while((s = br.readLine()) != null) {
            if (s.isBlank()) continue;

            int current = Integer.parseInt(s);
            listOfNumbers.add(current);
        }

        List<Integer> listOfNumbersSum = new ArrayList<>();

        //make a list of sums of 3 adjacent numbers
        for(int i=0; i<listOfNumbers.size()-2; i++){
            int number = listOfNumbers.get(i) + listOfNumbers.get(i+1) + listOfNumbers.get(i+2);
            listOfNumbersSum.add(number);
        }

        int countNumberOfIncrease = 0;
        int lastNumber = -1;

        for(int current : listOfNumbersSum){

            if(current > lastNumber && lastNumber != -1) {
                countNumberOfIncrease++;
                lastNumber = current;
            }
            else {
                lastNumber = current;
            }
        }

        System.out.println(countNumberOfIncrease);
    }
}