import java.util.Arrays;

public class ThreeSum_BruteForce
{

   public static int count(int[] a)
   {

     int count = 0;
     int n     = a.length;
     for( int i=0; i<n; i++){
        for( int j=i+1; j<n; j++){
           for( int k=j+1; k<n; k++){
              if( a[i]+a[j]+a[k] == 0) count++;
           }
        }
      }
      return count;
   }

   public static void main(String[] args) 
   {

       In in = new In(args[0]);
       int [] array1 = in.readAllInts();
       int cnt = count(array1);
       StdOut.println(cnt);


   }

}
 
