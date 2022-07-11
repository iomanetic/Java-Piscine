import java.util.Scanner;

public class Program {
    public static int main(String[] args) {
        Scanner numIn = new Scanner(System.in);
        int numDel = 2;
        int num = numIn.nextInt();
        int iterCount = 0;

        if(num < 2) {
            System.err.println("Illegal Argument");
            return (-1);
        }
        if(num == 2) {
            System.out.println("true 1");
            return (0);
        }
        while(numDel * numDel <= num) {
            iterCount++;
            if(num % numDel == 0) {
                System.out.println("false " + iterCount);
                return (0);
            }
            numDel++;
        }
        System.out.println("true " + iterCount);
        return (0);

    }
}