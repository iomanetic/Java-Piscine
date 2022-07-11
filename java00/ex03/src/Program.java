import java.util.Scanner;

public class Program {
    private static final String STOP_WORD = "42";
    public static void main(String[] args) {
        byte numOfWeek = 1;
        long allGrades = 0;
        Scanner input = new Scanner(System.in);
        String inputWeek = input.nextLine();

        while(!inputWeek.equals(STOP_WORD)) {
            if(!inputWeek.equals("Week " + numOfWeek))
                System.exit(isError());
            allGrades = packGrade(getMinGrade(input), numOfWeek, allGrades);
            numOfWeek++;
            if(numOfWeek == 19)
                break ;
            inputWeek = input.nextLine();
        }
        for(byte countOfWeek = 1; countOfWeek < numOfWeek; countOfWeek++)
            printStat(unpackGrade(allGrades, countOfWeek), countOfWeek);
    }

    private static long packGrade(int minGrade, byte numOfWeek, long allGrades) {
        long pack = 1;
        byte countWeeks = 1;
        long result;

        while (countWeeks < numOfWeek)
        {
            pack *= 10;
            countWeeks++;
        }
        result = pack * minGrade + allGrades;
        return (result);
    }

    private static int unpackGrade(long allGrades, byte numOfWeek) {
        byte countDevile = 1;
        long result;

        while(countDevile < numOfWeek) {
            allGrades /= 10;
            countDevile++;
        }
        result = allGrades % 10;
        return ((int)result);
    }

    private static int getMinGrade(Scanner input) {
        int countGrades = 1;
        int numOfInput;
        int minNumOfInput = input.nextInt();

        if(minNumOfInput < 1 || minNumOfInput > 9)
            System.exit(isError());
        while(countGrades < 5) {
            numOfInput = input.nextInt();
            if(numOfInput < 1 || numOfInput > 9)
                System.exit(isError());
            if(minNumOfInput > numOfInput)
                minNumOfInput = numOfInput;
            countGrades++;
        }
        input.nextLine();
        return (minNumOfInput);
    }

    private static void printStat(int minGrade, byte numOfWeek) {
        int printCount = 0;

        System.out.print("Week " + numOfWeek + ' ');
        while(printCount < minGrade)
        {
            System.out.print('=');
            printCount++;
        }
        System.out.print('>');
        System.out.println();
    }

    private static int isError() {
        System.out.println("Illegal Argument");
        return (-1);
    }
}