import java.util.Scanner;

public class Program{
    public static void main (String[] args){
        int num;
        int count;
        int i;
        boolean a;

        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        if (num <= 1)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        i = 2;
        a = true;
        count = 1;
        while (i * i <= num)
        {
            if (num % i == 0)
            {
                a = false;
                break ;
            }
            i++;
            count++;
        }
        System.out.print(a + " ");
        System.out.print(count);
    }
}
