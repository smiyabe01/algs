import java.util.Arrays;

public class  BinarySearch
{

   public static int search(int[] a, int x)
   {

     int lo = 0;
      int hi = a.length - 1;
     while( lo <= hi)
     {
        int mid = lo+(hi-lo)/2;
        if(x < a[mid]) hi = mid-1;
        else if( x > a[mid]) lo = mid+1;
        else return mid;
     }
     return -1;
   }

   public static void main(String[] args) 
   {

       In in = new In(args[0]);
       int [] array1 = in.readAllInts();
       Arrays.sort(array1);

       // input integer
       StdOut.println("integer?");
       int p = StdIn.readInt();

       // find the integer in the list
       int index = search(array1,p);
       if(index == -1) {StdOut.println("integer not in the list");}
       else { StdOut.println("The element index is " + index); }

   }

}
 
