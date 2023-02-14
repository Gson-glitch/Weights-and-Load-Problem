import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class WeightsAndLoadProblem {
    private String solution;
    public WeightsAndLoadProblem(int n) {
        solution = RandomBinaryString(n);
    }

    private static String RandomBinaryString(int n) {
        StringBuilder binaryString = new StringBuilder();
        for(int i=0; i<n; i++) {
            if (Math.random()>0.5) {
                binaryString.append("1");
            } else {
                binaryString.append("0");
            }
        }
        return binaryString.toString();
    }

    public double fitnessFunction(ArrayList<Double> weights) {
        int n = solution.length();                // Assigns the length of solution to n
        double lorryA = 0.0;                       //  Initializes the weight of bricks on lorry A to 0.0
        double lorryB = 0.0;                       //  Initializes the weight of bricks on lorry B to 0.0
        if (n > weights.size())                 // If statement, compares n and weight size
            return (-1);                        // Returns -1 if the length of solution > size of the weights ArrayList

        for (int i = 0; i < n; i++) {           // For loop which increments the weights of lorry A and lorry B accordingly
            if (solution.charAt(i) == '0') {      // if the current character is 0, add the weight at position i in the weights ArrayList to lorry A
                lorryA += weights.get(i);
            } else {                            // if the current character is 1, add the weight at position i in the weights ArrayList to lorry B
                lorryB += weights.get(i);
            }
        }
        return Math.abs(lorryA - lorryB);           // Calculates the absolute value of the difference between the weights of the two lorries
    }

        public void SmallChange() {
            int length = solution.length();
            int randomNumber = ThreadLocalRandom.current().nextInt(0, length);
            String res = "";
            res = solution.substring(0,randomNumber);

            char characterAtp = solution.charAt(randomNumber);
            if (characterAtp == '0') {
                characterAtp = '1';
            }
            else {
                characterAtp = '0';
            }
            res += characterAtp;

            res += solution.substring(randomNumber+1);

            solution = res;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String oldsol) {
        solution = oldsol;
    }

    public void printSolution() {
        System.out.println(solution);
    }
}
