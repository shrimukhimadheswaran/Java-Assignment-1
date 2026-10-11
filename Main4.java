class A
{
    public static void main(String arg[])
    {
        double sum=0.0, j=1.0, i=2.0;

        while(i/j > 0.0625)
        {
            j=j+j;
            sum=sum+i/j;
            System.out.println("sum = "+sum);
        }
    }
}