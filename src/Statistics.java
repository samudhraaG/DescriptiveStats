import java.util.Random;

import static java.lang.StrictMath.sqrt;

public class Statistics {
    private static double[] anArray;
    private static double max = Double.MIN_VALUE;
    private static double min = Double.MAX_VALUE;
    private static double stdDeviation = 0;
    private static double mean = 0;
    private static double median = 0;
    private static int mode = 0;


    public static double[] list(){
        anArray = new double[100];
        return anArray;
    }

    public static void print(){
        for(double n: anArray){
            System.out.println(n+" ");
        }
    }

    public static double randomFill(){
        Random rand = new Random();
        double randomNum = rand.nextDouble();
        return randomNum;
    }

    public static void setStatisticsValue(){
        double sum = 0;
        int maxValue = 0, maxCount = 0;
        double sq_sum = 0;
        int n = anArray.length;
        for(int i = 0; i < anArray.length; i++){
            int count = 0;
            // Compute sum of array used to calculate mean
                sum += anArray[i];
            //Compute sum of square of array used to calcuate variance
                 sq_sum += anArray[i] * anArray[i];
            // Calculate min value of array
                if(anArray[i] < min){
                    min = anArray[i];
                }
            // Calculate max value of array
                if(anArray[i] > max){
                    max = anArray[i];
                }
            //Calculate Mode
                for (int j = 0; j < anArray.length; ++j) {
                    if (anArray[j] == anArray[i]) ++count;
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxValue = ((int) anArray[i]);
                }
        }

        mean = sum/anArray.length;
        double variance = sq_sum / n - mean * mean;
        stdDeviation = sqrt(variance);
        mode = maxValue;
    }

    public static double median() {
        int middle = anArray.length/2;
        if (anArray.length%2 == 1) {
            return anArray[middle];
        } else {
            return (anArray[middle-1] + anArray[middle]) / 2.0;
        }
    }

    // Individual methods for calculating mode, mean, std deviation -which are combined in setStatisticsValue
    /*public static int mode() {
        int maxValue = 0, maxCount = 0;

        for (int i = 0; i < anArray.length; ++i) {
            int count = 0;
            for (int j = 0; j < anArray.length; ++j) {
                if (anArray[j] == anArray[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = ((int) anArray[i]);
            }
        }

        return maxValue;
    }

    public static double mean() {
        double sum = 0;
        for (int i = 0; i < anArray.length; i++) {
            sum += anArray[i];
        }
        return sum / anArray.length;
    }

     public static double stdDeviation(double a[], int n) {
        if(n == 0)
            return 0.0;
        double sum = 0;
        double sq_sum = 0;
        for(int i = 0; i < n; ++i) {
            sum += a[i];
            sq_sum += a[i] * a[i];
        }
        double mean = sum / n;
        double variance = sq_sum / n - mean * mean;
        return sqrt(variance);
    }

    public static void setMinMaxValue(){
        double sum = 0;
        for(int i = 0; i < anArray.length; i++){
            if(anArray[i] < min)
                min = anArray[i];
            if(anArray[i] > max)
                max = anArray[i];
        }
    }*/
    
    public static void main(String args[]) {
        list();
        for(int i = 0; i < anArray.length; i++){
            anArray[i] = randomFill();
        }
        System.out.println(":::::::::: The random array generated is :::::::");
        print();
        setStatisticsValue();

        System.out.println("minimum value :"+min);
        System.out.println("maximum value :"+max);
        System.out.println("mean" + mean);
        System.out.println("median" + median());
        System.out.println("mode" + mode);
        System.out.println("standard deviation" + stdDeviation);


    }
}
