import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueueOfStrings
{
  private Node first, last;
  private int N;

  public LinkedQueueOfStrings()
  {
    first = null;
    last  = null;
    N     = 0;
  }

  private class Node
  {
     String item;
     Node next;
  }

  public boolean isEmpty()
  { return first == null; }

  public int size(){
     return N;
  }

  public void enqueue(String item)
  {
    Node oldlast = last;
    last         = new Node();
    last.item    = item;
    last.next    = null;
    if (isEmpty()) first = last;
    else           oldlast.next = last;
    N++;
  }

  public String dequeue()
  {
    String item = first.item;
    first = first.next;
    N--;
    if (isEmpty()) last = null;
    return item;
  }

  public static void main(String[] args)
  {
    LinkedQueueOfStrings q = new LinkedQueueOfStrings();
    while(!StdIn.isEmpty())
    {
       String s = StdIn.readString();
       if (!s.equals("-")) q.enqueue(s);
       else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
    }
    StdOut.println( "(" + q.size() + " left on queue) " );
  }

}
