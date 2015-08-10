public class FixedCapacityStackOfStrings
{
  private String[] s;
  private int N = 0;

  public FixedCapacityStackOfStrings(int capacity)
  { s = new String[capacity]; }

  public boolean isEmpty()
  { return N == 0; }

  public void push(String item)
  { s[N++] = item; }

  public String pop()
  { 
    String item = s[--N]; 
    s[N] = null;
    return item;
  }

  public static void main(String[] args)
  {
     FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(20);
     while(!StdIn.isEmpty())
     {
        String s = StdIn.readString();
        if (s.equals("-")) StdOut.print(stack.pop());
        else               stack.push(s);
     }
  }

}
