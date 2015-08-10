import java.util.Comparator;

public class InsertionComp
{
   public static void sort(Object[] a, Comparator comparator)
   {
      int N = a.length;
      for (int i=0; i<N; i++)
         for(int j=i; j>0; j--)
            if(less(comparator,a[j],a[j-1]))
               exch(a, j, j-1);
            else break; 
   }

  private static boolean less(Comparator c, Object v, Object w)
  { return c.compare(v,w) < 0; }

  private static void exch(Object[] a, int i, int j)
  {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
 
  public static void main(String[] args)
  {
//     int N = Integer.parseInt(args[0]);
     int N = Integer.parseInt("10");
     Double[] a = new Double[N];
     for (int i = 0; i<N; i++)
        a[i] = StdRandom.uniform();
     InsertionComp.sort(a);
     for (int i=0; i<N; i++)
        StdOut.println(a[i]);
  }

}
