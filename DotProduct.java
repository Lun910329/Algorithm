package goldman;

public class DotProduct {
    public int dotprod(int[] a, int[] b){
        if(a.length != b.length){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return  result;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 3}, b ={3, 2, 1};
        DotProduct dotProduct = new DotProduct();
        System.out.println(dotProduct.dotprod(a, b));
    }
}
