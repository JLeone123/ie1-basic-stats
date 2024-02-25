import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MinMaxCalculation {
    // Given Set collection of numbers to find the minimum and maximum of
    private static Set<Double> sampleDataSet = Set.of(1.0, 2.0, 5.0, 105.40, 109.0, -123.0, -2.05);
    
    // Setting sampleDataSet to an arrayList makes finding the min and max easier to
    // loop over since the Iterator is not needed in this case.
    private static ArrayList<Double> sampleDataList = new ArrayList<Double>(sampleDataSet);

    // findMinimum (d: Set<Double>): double
    // d: The given set of numbers to find the minimum of
    // findMinimum takes a Java Set collection with
    // that contains double values, and returns the
    // minimum value of that collection
    public static double findMinimum(Set<Double> d) {
        // In the case of an empty set, we define the minimum value to be negative
        // infinity.
        // so we return the smallest positive nonzero value of type double
        if (d == null || d.size() == 0) {
            return Double.MIN_VALUE;
        }

        Iterator<Double> iterator = d.iterator();
        double currentNum = iterator.next();
        double min = currentNum;

        while (iterator.hasNext()) {
            currentNum = iterator.next();
            if (min > currentNum) {
                min = currentNum;
            }
        }

        return min;
    }

    // findMaximum (d: Set<Double>): double
    // d: The given set of numbers to find the maximum of
    // findMaximum takes a Java Set collection with
    // that contains double values, and returns the
    // maximum value of that collection
    public static double findMaximum(Set<Double> d) {
        // In the case of an empty set, we define the maximum value to be positive
        // infinity.
        // so we return the largest positive nonzero value of type double
        if (d == null || d.size() == 0) {
            return Double.MAX_VALUE;
        }

        Iterator<Double> iterator = d.iterator();
        double currentNum = iterator.next();
        double max = currentNum;

        while (iterator.hasNext()) {
            currentNum = iterator.next();
            if (max < currentNum) {
                max = currentNum;
            }
        }

        return max;
    }

    public static void main(String... args) {
        // Find the minimum and maximum value of a
        // provided set of numbers from the console

        // The user will provide a set of numbers that may contain duplicates that
        // will be stored in an instance of the Java Scanner class
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("\nEx: for a three-element set {-12, 9.5, 144}, type: -12 9.5 144");
        System.out.print("\nEnter a set of numbers (above is an example): ");

        // The data Set<Double> variable will store these values from
        // the user input from an array containing each String value
        // of the user input - using a set will eliminate any duplicate numbers
        // and follows the provided instructions for the assignment.
        String input = scannerObj.nextLine();
        String[] inputArray = input.split(" ");
        Set<Double> data = new HashSet<>();

        // Check to see if the provided input string is empty
        // in this case, the set is the empty set and is
        // a valid set!
        if (input.trim().length() == 0) {
            // In the case of an empty set, the minimum and maximum values
            // of the empty set approach negative infinity and
            // positive infinity respectively
            double minEmptySet = Double.MIN_VALUE;
            double maxEmptySet = Double.MAX_VALUE;

            System.out.println(
                    "\nFor the empty set, the minimum and maximum values of the provided set of numbers are...");
            System.out.println("\nMin: " + minEmptySet);
            System.out.println("\nMax: " + maxEmptySet);

            scannerObj.close();
            return;
        }

        // Add values to the created data set.
        for (int i = 0; i < inputArray.length; ++i) {
            // Check if the current number is a number
            try {
                double n = Double.parseDouble(inputArray[i]);
                data.add(n);
            } catch (Exception e) {
                System.out.println(inputArray[i] + " is not a number.");
                scannerObj.close();
                return;
            }
        }

        // Use an Iterator object to iterate
        // over the Java data set collection
        Iterator<Double> iterator = data.iterator();
        double currentNum = iterator.next();
        double min = currentNum;
        double max = currentNum;

        while (iterator.hasNext()) {
            currentNum = iterator.next();

            if (min > currentNum) {
                min = currentNum;
            }

            if (max < currentNum) {
                max = currentNum;
            }
        }

        // Print out the found minimum and maximum values
        // of the set of numbers given as input by the user
        System.out.println("The minimum and maximum values of the provided set of numbers are...");
        System.out.println("\nMin: " + min);
        System.out.println("\nMax: " + max);

        // Find the minimum and maximum of the sample data set
        // and print the answers to the console.
        System.out.println("\nFinding the minimum and maximum of a sample data set, named 'sampleDataSet'");
        System.out.print("The sampleDataSet contains the values: {");

        for (int i = 0; i < sampleDataList.size(); ++i) {
            if (i == sampleDataList.size() - 1) {
                System.out.println(sampleDataList.get(i) + "}");
            } else {
                System.out.print(sampleDataList.get(i) + ", ");
            }
        }

        double sampleMin = findMinimum(sampleDataSet);
        double sampleMax = findMaximum(sampleDataSet);

        System.out.println("The minimum and maximum values of the provided sample data set are...");
        System.out.println("\nsampleMin: " + sampleMin);
        System.out.println("\nsampleMax: " + sampleMax);

        scannerObj.close();
        return;
    }
}