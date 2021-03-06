import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner numIn = new Scanner(System.in);
        int requestCount = 0;
        int num;
        int sum;

        while(true) {
            num = numIn.nextInt();
            if(num == 42)
                break ;
            sum = sumOfDigit(num);
            if(isPrime(sum))
                requestCount++;
        }
        System.out.println("Count of coffee-request – " + requestCount);
        numIn.close();
    }

    public static boolean isPrime(int num) {
        int numDel = 2;

        if(num < 2)
            return (false);
        if(num == 2)
            return (true);
        while(numDel * numDel <= num) {
            if(num % numDel == 0)
                return (false);
            numDel++;
        }
        return (true);
    }

    public static int sumOfDigit(int num){
        int sum = 0;

        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return (sum);
    }
}