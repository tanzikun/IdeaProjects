public class Test2 {

    static int result = 0;

    public static void main(String[] args) {
        sum(4);
        System.out.println(result);
    }

    /**
     * 递归求n+(n-1)+(n-2)+...+1的和
     * @param n
     * @return
     */
    public static int sum(int n) {
        if( n > 0 ) {
            result = result + n;
            sum(n - 1);
        }
        return result;
    }

}
