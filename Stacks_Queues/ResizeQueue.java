public class ResizeQueue
{
   private String[] s;
   private int N = 0;

   public ResizeQueue()
   {  s = new String[1]; }

   public void enqueue(String item)
   {
      if( N == s.length ) resize(s.length*2);
      s[N++] = item;
   }

   public String dequeue()
   {
      String item = s[0];
      for(int i=0; i<N-1; i++)
      {
         String shift = s[i+1];
         s[i] = shift;
      }
      s[N] = null;
      N--;
      if( N > 0 && N == s.length/4) resize(s.length/2);
      return item;
   }

   private void resize(int capacity)
   {
      String[] copy = new String[capacity];
      for(int i=0; i<N; i++)
         copy[i] = s[i];
      s = copy;
   }

   public static void main(String[] args)
   {
       ResizeQueue q = new ResizeQueue();
       while( !StdIn.isEmpty() )
       {
           String s = StdIn.readString();
           if( s.equals("-") ) StdOut.print( q.dequeue() + " " );
           else                q.enqueue(s);
       }
       StdOut.println("");
   }

}
