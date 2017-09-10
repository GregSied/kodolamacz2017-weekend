package pl.kodolamacz;

import java.util.Optional;

public class ArrayUtils {

    // min, max, mean,
    // cor, concatenate (sklejanie tablic)
    // append - dokleja wartość do tablicy (int[] tab, int value)

    public static Double mean(double[] array){
        return 0.0;
    }

    public static Optional<Double> max(double[] array){
        if(array.length == 0){
            return Optional.empty();
        }
        double max = array[0];
        for (double v : array) {
            max = Math.max(max, v);
        }
        return Optional.of(max);
    }



}
