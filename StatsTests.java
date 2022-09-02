import java.lang.Math;
import java.util.Scanner;
public class StatsTests {
    public static void main(String [] args) {
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Proportion test(1), z Mean test(2), t Mean test(3), Two-pop proportion test(4), Two-pop z Mean test(5), Two-pop t Mean test(6): ");
        int DECISION = input.nextInt();
        System.out.println();
        if (DECISION == 1) {
            System.out.print("x = ");
            double x = input.nextDouble();
            System.out.print("n = ");
            double n = input.nextDouble();
            System.out.print("p = ");
            double p = input.nextDouble();
            System.out.print("tails = ");
            int tails = input.nextInt();
            System.out.print("significance level = ");
            double alpha = input.nextDouble();   
            System.out.println();     
            zTestProportion(x, n, p, tails, alpha);
            System.out.println();
        }
        else if (DECISION == 2) {
            System.out.print("x̅ = ");
            double xBar = input.nextDouble();
            System.out.print("μ = ");
            double mu = input.nextDouble();
            System.out.print("σ = ");
            double sigma = input.nextDouble();
            System.out.print("n = ");
            double n = input.nextDouble();
            System.out.print("tails = ");
            int tails = input.nextInt();
            System.out.print("significance level = ");
            double alpha = input.nextDouble();      
            System.out.println();  
            zTestMean(xBar, mu, sigma, n, tails, alpha);
            System.out.println();
        }
        else if (DECISION == 3) {
            System.out.print("x̅ = ");
            double xBar = input.nextDouble();
            System.out.print("μ = ");
            double mu = input.nextDouble();
            System.out.print("s = ");
            double s = input.nextDouble();
            System.out.print("n = ");
            double n = input.nextDouble();
            System.out.print("tails = ");
            int tails = input.nextInt();
            System.out.print("significance level = ");
            double alpha = input.nextDouble();      
            System.out.println();  
            tTestMean(xBar, mu, s, n, tails, alpha);
            System.out.println();
        }
        else if (DECISION == 4) {
            System.out.print("x1 = ");
            double x1 = input.nextDouble();
            System.out.print("n1 = ");
            double n1 = input.nextDouble();
            System.out.print("x2 = ");
            double x2 = input.nextDouble();
            System.out.print("n2 = ");
            double n2 = input.nextDouble();
            System.out.print("Difference in proportion = ");
            double pDiff = input.nextDouble();
            System.out.print("tails = ");
            int tails = input.nextInt();
            System.out.print("significance level = ");
            double alpha = input.nextDouble();      
            System.out.println();  
            zTestProportionTwoPop(x1, n1, x2, n2, pDiff, tails, alpha);
            System.out.println();
        }
        else if (DECISION == 5) {
            System.out.print("x̅1 = ");
            double xBar1 = input.nextDouble();
            System.out.print("x̅2 = ");
            double xBar2 = input.nextDouble();
            System.out.print("σ1 = ");
            double sigma1 = input.nextDouble();
            System.out.print("σ2 = ");
            double sigma2 = input.nextDouble();
            System.out.print("n1 = ");
            double n1 = input.nextDouble();
            System.out.print("n2 = ");
            double n2 = input.nextDouble();
            System.out.print("Difference in mean = ");
            double meanDiff = input.nextDouble();
            System.out.print("tails = ");
            int tails = input.nextInt();
            System.out.print("significance level = ");
            double alpha = input.nextDouble();      
            System.out.println();  
            zTestMeanTwoPop(xBar1, xBar2, meanDiff, sigma1, sigma2, n1, n2, tails, alpha);
            System.out.println();
        }
    }

    //           Here are the possible tests:
    public static double[] zTestProportion(double x, double n, double p, int tails, double alpha) {
        double [] result = new double[6];
        double pHat = x/n;
        double qHat = 1 - pHat;
        System.out.print("p̂ and q̂ calculated...    ");
        double z = (pHat - p)/Math.sqrt(pHat*qHat/n);
        System.out.print("z Statistic calculated...    ");
        double pValue = pValue('z', z, tails, 0);
        System.out.print("p-Value calculated...     ");
        result[0] = pHat;
        result[1] = qHat;
        result[2] = n - 1;
        result[3] = z;
        result[4] = pValue;
        if (pValue < alpha) {
            result[5] = 0;
        }
        else {
            result[5] = 1;
        }
        System.out.println();
        System.out.println();
        System.out.println("p̂: " + result[0]);
        System.out.println("q̂: " + result[1]);
        System.out.println("Degrees of Freedom: " + result[2]);
        System.out.println("z = " + result[3]);
        System.out.println("p-Value = " + result[4]);
        System.out.println();
        if (result[5] == 0) {
            System.out.println("Since the p-Value = " + pValue + " is less than the signifance level, " + alpha + ", reject null hypothesis.");
        }
        else if (result[5] == 1) {
            System.out.println("Since the p-Value = " + pValue + " is greater than the signifance level, " + alpha + ", fail to reject null hypothesis.");
        }
        return result;
    }
    public static double[] zTestMean(double xBar, double mu, double sigma, double n, int tails, double alpha) {
        double [] result = new double[5];
        double stError = sigma/Math.sqrt(n);
        System.out.print("Mean standard error calculated...     ");
        double z = (xBar - mu)/stError;
        System.out.print("z Statistic calculated...      ");
        double pValue = pValue('z', z, tails, 0);
        System.out.print("p-Value calculated...      ");
        result[0] = stError;
        result[1] = n - 1;
        result[2] = z;
        result[3] = pValue;
        if (pValue < alpha) {
            result[4] = 0;
        }
        else {
            result[4] = 1;
        }
        System.out.println();
        System.out.println();
        System.out.println("Mean standard error: " + result[0]);
        System.out.println("Degrees of Freedom: " + result[1]);
        System.out.println("z = " + result[2]);
        System.out.println("p-Value = " + result[3]);
        System.out.println();
        if (result[4] == 0) {
            System.out.println("Since the p-Value = " + pValue + " is less than the signifance level, " + alpha + ", reject null hypothesis.");
        }
        else if (result[4] == 1) {
            System.out.println("Since the p-Value = " + pValue + " is greater than the signifance level, " + alpha + ", fail to reject null hypothesis.");
        }
        return result;
    }
    public static double[] tTestMean(double xBar, double mu, double s, double n, int tails, double alpha) {
        double [] result = new double[5];
        double stError = s/Math.sqrt(n);
        System.out.print("Mean standard error calculated...     ");
        double t = (xBar - mu)/stError;
        System.out.print("t Statistic calculated...      ");
        double pValue = pValue('t', t, tails, n - 1);
        System.out.print("p-Value calculated...      ");
        result[0] = stError;
        result[1] = n - 1;
        result[2] = t;
        result[3] = pValue;
        if (pValue < alpha) {
            result[4] = 0;
        }
        else {
            result[4] = 1;
        }
        System.out.println();
        System.out.println();
        System.out.println("Mean standard error: " + result[0]);
        System.out.println("Degrees of Freedom: " + result[1]);
        System.out.println("t = " + result[2]);
        System.out.println("p-Value = " + result[3]);
        System.out.println();
        if (result[4] == 0) {
            System.out.println("Since the p-Value = " + pValue + " is less than the signifance level, " + alpha + ", reject null hypothesis.");
        }
        else if (result[4] == 1) {
            System.out.println("Since the p-Value = " + pValue + " is greater than the signifance level, " + alpha + ", fail to reject null hypothesis.");
        }
        return result;
    }
    public static double[] zTestProportionTwoPop(double x1, double n1, double x2, double n2, double pDiff, int tails, double alpha) {
        double [] result = new double[10];
        double pHat1 = x1/n1;
        double qHat1 = 1 - pHat1;
        System.out.print("p̂1 and q̂1 calculated...     ");
        double pHat2 = x2/n2;
        double qHat2 = 1 - pHat2;
        System.out.print("p̂2 and q̂2 calculated...     ");
        double pBar = (x1 + x2)/(n1 + n2);
        double qBar = 1 - pBar;
        System.out.print("ƥ and Ɋ calculated...     ");
        double z = (pHat1 - pHat2 - pDiff)/Math.sqrt(pBar*qBar/n1 + pBar*qBar/n2);
        System.out.print("z Statistic calculated...    ");
        double pValue = pValue('z', z, tails, 0);
        System.out.print("p-Value calculated...     ");
        result[0] = pHat1;
        result[1] = qHat1;
        result[2] = pHat2;
        result[3] = qHat2;
        result[4] = pBar;
        result[5] = qBar;
        result[6] = Math.min(n1 - 1, n2 - 1);
        result[7] = z;
        result[8] = pValue;
        result[9] = (pValue < alpha) ? 0 : 1;
        System.out.println();
        System.out.println();
        System.out.println("p̂1: " + result[0]);
        System.out.println("q̂1: " + result[1]);
        System.out.println("p̂2: " + result[2]);
        System.out.println("q̂2: " + result[3]);
        System.out.println("ƥ: " + result[4]);
        System.out.println("Ɋ: " + result[5]);
        System.out.println("Degrees of freedom: " + result[6]);
        System.out.println("z = " + result[7]);
        System.out.println("p-Value = " + result[8]);
        System.out.println();
        if (result[9] == 0) {
            System.out.println("Since the p-Value = " + pValue + " is less than the signifance level, " + alpha + ", reject null hypothesis.");
        }
        else if (result[9] == 1) {
            System.out.println("Since the p-Value = " + pValue + " is greater than the signifance level, " + alpha + ", fail to reject null hypothesis.");
        }
        return result;
    }
    public static double[] zTestMeanTwoPop(double xBar1, double xBar2, double meanDiff, double sigma1, double sigma2, double n1, double n2, int tails, double alpha) {
        double [] result = new double[4];
        double numerator = (xBar1 - xBar2) - meanDiff;
        double denominator = Math.sqrt(sigma1*sigma1/n1 + sigma2*sigma2/n2);
        double z = numerator/denominator;
        System.out.print("z Statistic calculated...     ");
        double pValue = pValue('z', z, tails, 0);
        System.out.print("p-Value calculated...      ");
        result[0] = Math.min(n1 - 1, n2 - 1);
        result[1] = z;
        result[2] = pValue;
        if (pValue < alpha) {
            result[3] = 0;
        }
        else {
            result[3] = 1;
        }
        System.out.println();
        System.out.println();
        System.out.println("Degrees of freedom: " + result[0]);
        System.out.println("z = " + result[1]);
        System.out.println("p-Value = " + result[2]);
        if (result[3] == 0) {
            System.out.println("Since the p-Value = " + pValue + " is less than the signifance level, " + alpha + ", reject null hypothesis.");
        }
        else if (result[3] == 1) {
            System.out.println("Since the p-Value = " + pValue + " is greater than the signifance level, " + alpha + ", fail to reject null hypothesis.");
        }
        return result;
    }







    // Here are the calculations modules:
    public static double f(double x) {
        double F = (1/Math.sqrt(2 * Math.PI)) * Math.pow(Math.E, -(Math.pow(x, 2)/2));
        return F;
    }
    public static double g(double x, double df) {
        double G = 0;
        if (df % 2 == 1) {
            G = factorial((df - 1)/2)/(factorial((df - 2)/2) * Math.PI * Math.sqrt(df)) * Math.pow(1 + x*x/df, -(df + 1)/2);
        }
        else if (df % 2 == 0) {
            G = factorial((df - 1)/2)/(factorial((df - 2)/2) * Math.sqrt(df)) * Math.pow(1 + x*x/df, -(df + 1)/2);
        }
        return G;
    }
    public static double factorial(double num) {
        double result = 1;
        while (num > 0) {
            result *= num;
            num -= 1;
        }
        return result;
    }
    public static double pValue(char test, double stat, int tails, double df) {
        double E = 1E-6;
        double INF = 51;
        double p = 0;
        double highLimit;
        double lowLimit;
        if (stat > 0) {
            highLimit = INF;
            lowLimit = stat;
        }
        else {
            lowLimit = -INF;
            highLimit = stat;
        }
        if (test == 'z') {
            double multiplier = E/3;
            p += f(lowLimit) * multiplier;
            for (double x = lowLimit + E; x <= highLimit; x += E) {
                p += (4 * f(x - E) + 2 * f(x)) * multiplier;
            }
            p -= f(highLimit) * multiplier;
        }
        else if (test == 't') {
            double multiplier = E/3;
            p += g(lowLimit, df) * multiplier;
            for (double x = lowLimit + E; x <= highLimit; x += E) {
                p += (4 * g(x - E, df) + 2 * g(x, df)) * multiplier;
            }
            p -= g(highLimit, df) * multiplier;
        }
        if (tails == 1) {
            p = p / 2;
        }
        return p;
    }
}