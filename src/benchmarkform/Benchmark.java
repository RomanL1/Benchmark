/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchmarkform;

/**
 *
 * @author u20186
 */
public class Benchmark extends Thread {

    private static double elapsedSeconds;
    private static double FLOPS;
    private static double MFLOPS;
    private static long operations = 250000000;

    public static boolean finished = false;

    @Override
    public void run() {

        System.out.println("Benchmark::runBenchmark::Begin");

        double random;
        double result;
        long timerStart = System.currentTimeMillis();

        for (long j = 0; j < operations; j++) {
            random = Math.random();
            result = 58576575.234 * random;
        }

        long timerEnd = System.currentTimeMillis();
        long timerDiff = timerEnd - timerStart;
        elapsedSeconds = timerDiff / 1000.0;

        FLOPS = Math.round(100 * (operations / elapsedSeconds));
        FLOPS /= 100;
        MFLOPS = FLOPS / 1000000;

        BenchForm.finishedRun();
        
        System.out.println("Benchmark::runBenchmark::End");
    }

    public static double getElapsedSeconds() {
        return elapsedSeconds;
    }

    public static double getMFLOPS() {
        return MFLOPS;
    }

    public static long getOperations() {
        return operations;
    }

    public static void setOperations(long pOperations) {
        operations = pOperations;
    }
}
