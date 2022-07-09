import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner numIn = new Scanner(System.in);
        int requestCount = 0;
        int num = 0;
        int sum;

        while(num != 42) {
            if(numIn.hasNextInt())
                num = numIn.nextInt();
            else {
                System.err.println("Error: input is not valid");
                return ;
            }
            sum = sumOfDigit(num);
            if(isPrime(sum))
                requestCount++;
        }
        System.out.println("Count of coffee-request – " + requestCount);
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