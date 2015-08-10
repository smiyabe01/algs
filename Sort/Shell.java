public class Shell
{
  public static void sort(Comparable[] a)
  {
      int N = a.length;
      int h = 1;
      while( h<N/3 ) h=3*h+1;

      while( h>= 1 )
      {
         for(int i=h; i<N; i++)
         {
            for(int j=i; j >= h && less(a[j],a[j-h]); j -= h){
               exch(a,j,j-h);
            }
         }
         assert isHsorted(a,h);
         h /= 3;
      }
  }

  private static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }

  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static boolean isHsorted(Comparable[] a, int h){
    for(int i=h; i<a.length; i++)
       if (less(a[i],a[i-h])) return false;
    return true;
  }
 
  public static void main(String[] args)
  {
//     int N = Integer.parseInt(args[0]);
     int N = Integer.parseInt("100");
     Double[] a = new Double[N];
     for (int i = 0; i<N; i++)
        a[i] = StdRandom.uniform();
     Shell.sort(a);
     for (int i=0; i<N; i++)
        StdOut.println(a[i]);
  }

}
