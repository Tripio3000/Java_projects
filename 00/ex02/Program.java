import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        int num = 0;
        int tmp = 0;
        int count = 0;
        int i = 0;
        int sum;
        boolean a;

        Scanner scan = new Scanner(System.in);
        while (tmp != 42)
        {
            num = scan.nextInt();
            tmp = num;
            sum = 0;
            while (num / 10 != 0)
            {
                i = num % 10;
                num /= 10;
                sum += i;
            }
            i = num % 10;
            sum += i;
            i = 2;
            a = true;
            while (i * i <= sum)
            {
                if (sum % i == 0)
                {
                    a = false;
                    break ;
                }
                i++;
            }
            if (a == true)
            {
                count++;
            }
        }
        System.out.println("Count of coffee-request - " + count);
    }
}