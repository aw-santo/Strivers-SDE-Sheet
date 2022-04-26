package Day3;

public class PowXn_ {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    static double myPow(double x, int n) {
        double ans = 1.0;
        long n_ = n;
        if (n_ < 0) {
            n_ = n_ * (-1);
        }

        while (n_ > 0) {
            if ((n_ & 1) != 0) {
                ans = ans * x;
                n_--;
            }
            else {
                x = x * x;
                n_/=2;
            }
        }
        if (n < 0) {
            ans = (double)(1.0)/(double)(ans);
        }
        return ans;
    }
}
