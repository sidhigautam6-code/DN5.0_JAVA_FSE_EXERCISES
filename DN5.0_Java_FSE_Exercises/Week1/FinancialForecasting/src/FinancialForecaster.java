package Week1.FinancialForecasting.src;
// src/FinancialForecaster.java
public class FinancialForecaster {
    
    // Recursive Future Value Calculation
    public static double calculateFutureValueRecursive(double presentValue, 
                                                      double growthRate, 
                                                      int periods) {
        // Base case: no more periods
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive case: calculate future value for one period
        // and recursively calculate for remaining periods
        double futureValue = presentValue * (1 + growthRate);
        return calculateFutureValueRecursive(futureValue, growthRate, periods - 1);
    }
    
    // Optimized Recursive with Memoization
    public static double calculateFutureValueMemo(double presentValue, 
                                                  double growthRate, 
                                                  int periods) {
        // Create memoization array
        double[] memo = new double[periods + 1];
        return calculateFutureValueMemoHelper(presentValue, growthRate, 
                                              periods, memo);
    }
    
    private static double calculateFutureValueMemoHelper(double presentValue, 
                                                         double growthRate, 
                                                         int periods,
                                                         double[] memo) {
        if (periods == 0) {
            return presentValue;
        }
        
        if (memo[periods] != 0) {
            return memo[periods];
        }
        
        double result = calculateFutureValueMemoHelper(presentValue, 
                                                       growthRate, 
                                                       periods - 1, 
                                                       memo) * (1 + growthRate);
        memo[periods] = result;
        return result;
    }
    
    // Iterative method for comparison
    public static double calculateFutureValueIterative(double presentValue, 
                                                       double growthRate, 
                                                       int periods) {
        double result = presentValue;
        for (int i = 0; i < periods; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }
    
    // Formula method (most efficient)
    public static double calculateFutureValueFormula(double presentValue, 
                                                     double growthRate, 
                                                     int periods) {
        return presentValue * Math.pow(1 + growthRate, periods);
    }
    
    // Demonstrate recursive approach with different scenarios
    public static void demonstrateForecasting() {
        System.out.println("=== FINANCIAL FORECASTING DEMONSTRATION ===\n");
        
        // Test different scenarios
        double[][] scenarios = {
            {1000, 0.05, 5},   // $1000 at 5% growth for 5 periods
            {5000, 0.03, 10},  // $5000 at 3% growth for 10 periods
            {10000, 0.07, 20}, // $10000 at 7% growth for 20 periods
            {2000, 0.15, 8}    // $2000 at 15% growth for 8 periods
        };
        
        System.out.println("Scenario\t\tRecursive\tMemo\t\tIterative\tFormula");
        System.out.println("--------------------------------------------------------------");
        
        for (double[] scenario : scenarios) {
            double pv = scenario[0];
            double rate = scenario[1];
            int periods = (int) scenario[2];
            
            // Measure recursive time
            long start = System.nanoTime();
            double recursive = calculateFutureValueRecursive(pv, rate, periods);
            long recursiveTime = System.nanoTime() - start;
            
            // Measure memoized recursive time
            start = System.nanoTime();
            double memo = calculateFutureValueMemo(pv, rate, periods);
            long memoTime = System.nanoTime() - start;
            
            // Measure iterative time
            start = System.nanoTime();
            double iterative = calculateFutureValueIterative(pv, rate, periods);
            long iterativeTime = System.nanoTime() - start;
            
            // Measure formula time
            start = System.nanoTime();
            double formula = calculateFutureValueFormula(pv, rate, periods);
            long formulaTime = System.nanoTime() - start;
            
            System.out.printf("$%.0f at %.0f%% for %d yrs\t", pv, rate * 100, periods);
            System.out.printf("$%.2f\t$%.2f\t$%.2f\t$%.2f%n", 
                            recursive, memo, iterative, formula);
            System.out.printf("\t\t\t(%d ns)\t(%d ns)\t(%d ns)\t(%d ns)%n",
                            recursiveTime, memoTime, iterativeTime, formulaTime);
        }
    }
    
    // Complex recursive forecasting with variable growth rates
    public static double[] forecastVariableGrowth(double startValue, 
                                                  double[] growthRates) {
        double[] results = new double[growthRates.length + 1];
        results[0] = startValue;
        
        for (int i = 0; i < growthRates.length; i++) {
            results[i + 1] = results[i] * (1 + growthRates[i]);
        }
        
        return results;
    }
    
    // Recursive method with variable growth rates
    public static double calculateVariableGrowthRecursive(double currentValue, 
                                                          double[] growthRates,
                                                          int index) {
        if (index >= growthRates.length) {
            return currentValue;
        }
        
        double newValue = currentValue * (1 + growthRates[index]);
        return calculateVariableGrowthRecursive(newValue, growthRates, index + 1);
    }
    
    // Analysis of recursive vs iterative approaches
    public static void analyzePerformance() {
        System.out.println("\n=== PERFORMANCE ANALYSIS ===\n");
        System.out.printf("%-12s %-15s %-15s %-15s%n", 
                         "Periods", "Recursive", "Memoized", "Iterative");
        System.out.println("----------------------------------------------");
        
        double pv = 1000;
        double rate = 0.05;
        
        for (int periods = 5; periods <= 100; periods += 10) {
            // Recursive
            long start = System.nanoTime();
            calculateFutureValueRecursive(pv, rate, periods);
            long recursiveTime = System.nanoTime() - start;
            
            // Memoized recursive
            start = System.nanoTime();
            calculateFutureValueMemo(pv, rate, periods);
            long memoTime = System.nanoTime() - start;
            
            // Iterative
            start = System.nanoTime();
            calculateFutureValueIterative(pv, rate, periods);
            long iterativeTime = System.nanoTime() - start;
            
            System.out.printf("%-12d %-15d %-15d %-15d%n", 
                            periods, recursiveTime, memoTime, iterativeTime);
        }
    }
}