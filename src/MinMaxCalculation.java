import java.util.ArrayList;

public class MinMaxCalculation {
    private static ArrayList<Double> data = new ArrayList<Double>();   

    public static void main(String ... args) {
        // do we need to make this work with any variable set of numbers?
        // this is a starting point for now I guess.
        data.add(1.0);
        data.add(2.0);
        data.add(5.0);
        data.add(105.40);
        data.add(109.0);
        data.add(-123.0);
        data.add(-2.05);

        double min = data.get(0);
        double max = data.get(0);

        for (int i = 0; i < data.size(); ++i) {
            if (min > data.get(i)) {
                min = data.get(i);
            }

            if (max < data.get(i)) {
                max = data.get(i);
            }
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        return;
    }
}