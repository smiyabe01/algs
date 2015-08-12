//import java.util.Arrays;

public class ThreeSumBinary
{

   public static int search(int[] a, int x, int lo)
   {
       int hi = a.length-1;

       while( lo <= hi )
       {
          int mid = lo+(hi-lo)/2;
          if(x < a[mid]) hi = mid-1;
          else if(x > a[mid]) lo = mid+1;
          else return mid;
       }
       return -1;
    }

    public static int Sum(int[] a)
    {
       int N = a.length;
       int count = 0;
       for(int i=0; i<N; i++){
          for(int j=i+1; j<N; j++){
             int x = -( a[i] + a[j] );
             int y = search(a,x,j+1);
             if( y != -1) count++;
       }}
       return count;
    }

    public static void main(String[] args)
    {
      int N = StdIn.readInt();
      int[] a;
      a = new int[N];
      for(int i=0; i<N; i++)
        a[i] = StdIn.readInt();

//        Arrays.sort(a);

       int count = ThreeSumBinary.Sum(a);
       StdOut.println("Three sum count = " + count);

    }
    

}
