package Task5b;

public class PI
{
    public static void main(String[] args) {
        int numberOfMembers = 1;
        double pi = 0;
        while(true)
        {
            pi += 4.0 / (numberOfMembers * 2 - 1) * ((numberOfMembers % 2 == 0) ? -1 : 1);
            System.out.printf("%d-th sum is %.5f\n", numberOfMembers, pi);
            if(pi > 3.14159 && numberOfMembers >= 100)
            {
                break;
            }
            numberOfMembers++;
        }
    }
}
