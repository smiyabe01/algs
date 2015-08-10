public class FixedCapacityStackOfStrings<Item>
{
  private Item[] s;
  private int N = 0;

  public FixedCapacityStackOfStrings(int capacity)
  { s = (Item[]) new Object[capacity]; }

  public boolean isEmpty()
  { return N == 0; }

  public void push(Item item)
  { s[N++] = item; }

  public Item pop()
  { 
    Item item = s[--N]; 
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
