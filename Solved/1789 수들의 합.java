import java.util.*;
public class Main {
    static Scanner scan = new Scanner(System.in);
    @FunctionalInterface interface Func {
      long calc(long  a , long   b);}
      public static void main(String[] args) {
        long  s =scan.nextLong();
        long n=0,sum= 0;
        Func add = (long  a, long  b) -> a + b;
        Func comp = (long   a, long  b) -> a > b ? 1 : 0;
        while (true) {
            sum= add.calc(sum,n);
            if(comp.calc(sum,s)==1){
                System.out.println(n-1);
                break;
            }
            n++;
        }
    }
}