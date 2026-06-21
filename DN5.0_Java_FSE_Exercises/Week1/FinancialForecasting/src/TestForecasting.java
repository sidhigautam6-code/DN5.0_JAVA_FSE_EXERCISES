package Week1.FinancialForecasting.src;
// src/TestForecasting.java
import java.util.Arrays;

public class TestForecasting {
    public static void main(String[] args) {
        // Demonstrate basic forecasting
        FinancialForecaster.demonstrateForecasting();
        
        // Test variable growth rates
        System.out.println("\n=== VARIABLE GROWTH RATE FORECASTING ===\n");
        double startValue = 1000;
        double[] growthRates = {0.05, 0.03, 0.07, 0.04, 0.06};
        
        System.out.println("Starting Value: $" + startValue);
        System.out.println("Growth Rates: " + Arrays.toString(growthRates));
        
        // Calculate using iterative method
        double[] results = FinancialForecaster.forecastVariableGrowth(startValue, growthRates);
        System.out.println("\nYear-by-Year Values (Iterative):");
        for (int i = 0; i < results.length; i++) {
            System.out.printf("Year %d: $%.2f%n", i, results[i]);
        }
        
        // Calculate using recursive method
        double finalValue = FinancialForecaster.calculateVariableGrowthRecursive(
            startValue, growthRates, 0);
        System.out.printf("\nFinal Value (Recursive): $%.2f%n", finalValue);
        
        // Performance analysis
        FinancialForecaster.analyzePerformance();
        
        // Real-world example: Investment planning
        System.out.println("\n=== INVESTMENT PLANNING EXAMPLE ===\n");
        investmentPlanning();
    }
    
    private static void investmentPlanning() {
        double initialInvestment = 10000;
        double annualReturn = 0.08;
        int years = 30;
        
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Annual Return Rate: " + (annualReturn * 100) + "%");
        System.out.println("Investment Period: " + years + " years");
        System.out.println();
        
        System.out.println("Year\tValue\t\tGrowth");
        System.out.println("----------------------------------------");
        
        double currentValue = initialInvestment;
        for (int year = 1; year <= years; year++) {
            double growth = currentValue * annualReturn;
            currentValue += growth;
            
            if (year % 5 == 0 || year == 1 || year == years) {
                System.out.printf("%d\t$%.2f\t$%.2f%n", 
                                year, currentValue, growth);
            }
        }
        
        System.out.println("\nFinal Value: $" + String.format("%.2f", currentValue));
        System.out.println("Total Growth: $" + 
                          String.format("%.2f", currentValue - initialInvestment));
        System.out.println("Return on Investment: " + 
                          String.format("%.1f%%", 
                          ((currentValue / initialInvestment - 1) * 100)));
    }
}
