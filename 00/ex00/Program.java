public class Program{
    public static void main (String[] args){
        int number = 479598;
        int sum = 0;
        int i = 0;

        i = number % 10;
        number /= 10;
        sum = sum + i;
        i = number % 10;
        number /= 10;
        sum = sum + i;
        i = number % 10;
        number /= 10;
        sum = sum + i;
        i = number % 10;
        number /= 10;
        sum = sum + i;
        i = number % 10;
        number /= 10;
        sum = sum + i;
        i = number % 10;
        number /= 10;
        sum = sum + i;
        System.out.println(sum);
    }
}