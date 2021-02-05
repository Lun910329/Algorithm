

public class Pow {
	
    // Pow(x, n)
    public double power(int x, int n) {
        
        double X;
        if (n < 0) {
            X = (double) 1 / x;
            n = -n;
        } else {
            X = (double) x;
        }
        
        
        double ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * X;
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
