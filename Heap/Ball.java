import java.awt.Color;

public class Ball
{
    private double rx, ry;
    private double vx, vy;
    private final double radius;
    private double mass;
    private Color color;

    public Ball()
    {
       rx = Math.random();
       ry = Math.random();
       vx = 0.01 *(Math.random() - 0.5 );
       vy = 0.01 *(Math.random() - 0.5 );
       radius = 0.01;
       mass = 0.5;
       color = color.BLACK;
    }

    public void move(double dt)
    {
       if ((rx+vx*dt < radius) || (rx+vx*dt > 1.0 - radius)) { vx = -vx; }
       if ((ry+vy*dt < radius) || (ry+vy*dt > 1.0 - radius)) { vy = -vy; }
       rx = rx+vx*dt;
       ry = ry+vy*dt;
    }

   public void draw()
   { StdDraw.filledCircle(rx,ry,radius);}

}
