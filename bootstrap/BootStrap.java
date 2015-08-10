import java.util.Random;

public class BootStrap
{
  private Double[] s;
  private int N = 0;
  private double eps = 0.0001;
  private int MM = 0;
  private double ave = 0.;
  private double std_dev = 0.;

  public BootStrap()
  {  s = new Double[1];  }

  public void push(Double num)
  {
     if( N == s.length) resize(2 * s.length);
     s[N++] = num;
  }

  private void resize(int capacity)
  {
     Double[] copy = new Double[capacity];
     for (int i=0; i<N; i++)
        copy[i] = s[i];
     s = copy;
  }

  public void boot()
  {
    int N2 = N/2;
    double old  = 0.;
    double diff = 1.;
    Random randomGenerator = new Random();

    // compute average
    int i=0;
    while(diff > eps)
    {
       i = i+1;
       int m = (int)Math.pow(2.0,i);
       double s0 = 0.;
       for(int j=0; j<m; j++){
          double s1 = 0.;
          for(int k=0; k<N2; k++){
            int ir = randomGenerator.nextInt(N);
            s1  = s1+s[ir];
          }
          s1 = s1/N2;
          s0 = s0+s1;
       }
       ave = s0/m;
       diff = Math.abs(ave-old);
       old  = ave;
       MM = m;
    }

    // compute std. deviation
    double s0 = 0.;
    for(int j=0; j<MM; j++){
       double s1 = 0.;
       for(int k=0; k<N2; k++){
          int ir = randomGenerator.nextInt(N);
          s1 = s1+s[ir];
       }
       s1 = s1/N2;
       double x = Math.pow(s1-ave,2.);
       s0 = s0+x;
    }
    std_dev = Math.sqrt(s0/MM);

    // print
    StdOut.println("Number of points: " + MM);
    StdOut.println("Average:          " + ave );
    StdOut.println("Std. Deviation:   " + std_dev);
  }

  public static void main(String[] args)
  {
     BootStrap s = new BootStrap();
     while(!StdIn.isEmpty())
     {
        Double x = StdIn.readDouble();
        s.push(x);
     }
//     Double y = s.average();
     s.boot();

  }

}
