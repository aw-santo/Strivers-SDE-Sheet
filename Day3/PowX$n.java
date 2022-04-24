package Day3;

public class PowX$n {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    static double myPow(double x, int n) {
        double ans = 1.0;
        int nn = n;
        if (nn < 0) {
            nn = nn * -1;
        }

        while (nn > 0) {
            if ((nn & 1) != 0) {
                ans = ans * x;
                nn--;
            }
            else {
                x = x * x;
                nn/=2;
            }
        }
        if (n < 0) {
            ans = (double)(1.0)/(double)(ans);
        }
        return ans;
    }
}
