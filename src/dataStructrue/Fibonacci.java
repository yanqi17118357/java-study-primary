package dataStructrue;

public class Fibonacci {
    public static void main(String[] args) {
        int target = 10, result; // target是要获取第几个数, result是结果

        int a = 1, b = 1, tmp;
        for (int i = 1; i < target; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        result = a;

        System.out.println(result);
    }
}
