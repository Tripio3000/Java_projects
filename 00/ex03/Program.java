import java.util.Scanner;

public class Program{
    public static void main (String[] args)
    {
        String str;
        int week;
        int count;
        int i;
        long min;
        int grade;
        long num, deg;

        Scanner scan = new Scanner(System.in);
        count = 1;
        num = 0;
        deg = 1;
        while (true)
        {
            str = scan.next();
            if (!(str.equals("Week")) && !(str.equals("42")))
                System.exit(-1);
            if (str.equals("42"))
                break ;
            week = scan.nextInt();
            if (week != count)
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            i = 0;
            min = 10;
            while (i < 5)
            {
                grade = scan.nextInt();
                if (min > grade)
                    min = grade;
                i++;
            }
            num += (min * deg);
            deg *= 10;

            count++;
        }
        i = 1;
        while (i < count)
        {
            System.out.print("Week " + i + " ");
            min = num % 10;
            num /= 10;
            while (min > 0)
            {
                System.out.print("=");
                min--;
            }
            System.out.println(">");
            i++;
        }
    }
}