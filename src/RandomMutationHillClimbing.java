import java.util.ArrayList;
import java.util.HashMap;

public class RandomMutationHillClimbing {
    private WeightsAndLoadProblem solutionCopy;
    double weightDifferenceCopy;
    public HashMap<String, Double> HillClimbing(ArrayList<Double> weights, int iter) {
        double weightDifference = 0;
        int n = weights.size();

        WeightsAndLoadProblem solution = new WeightsAndLoadProblem(n);

        for (int i=0; i<iter; i++) {
            double oldFitness = solution.fitnessFunction(weights);
            String oldSolution = solution.getSolution();
            solution.SmallChange();
            double newFitness = solution.fitnessFunction(weights);
            if (newFitness > oldFitness) {
                solution.setSolution(oldSolution);
            }
            weightDifference = oldFitness;
        }
        weightDifferenceCopy = weightDifference;
        solutionCopy = solution;
//        System.out.println("--------------------------------------------------");
//        System.out.println("Optimum Input");
//        solution.printSolution();
//        System.out.println("--------------------------------------------------");
//        System.out.println("Final Fitness Input");
//        System.out.println(weightDifference);
//        System.out.println("--------------------------------------------------");
        HashMap<String, Double> soln = new HashMap<>();
        soln.put(solution.getSolution(), weightDifference);
        return soln;
    }

    public void display() {
        System.out.println("--------------------------------------------------");
        System.out.println("Optimum Input");
        solutionCopy.printSolution();
        System.out.println("--------------------------------------------------");
        System.out.println("Final Fitness Input");
        System.out.println(weightDifferenceCopy);
        System.out.println("--------------------------------------------------");
    }
}
