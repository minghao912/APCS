public class Circle {
    public Circle(double r) 
    {
        radius = r;
    }    

    public double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    public double circuference()
    {
        return 2 * Math.PI * radius;
    }

    public double diameter() 
    {
        return 2 * radius;
    }

    public double radius;
}

class Program {
    public static void main(String[] args) 
    {
        Circle koolCircle = new Circle(35.5);
        System.out.println("The circle's diameter is " + koolCircle.diameter());
    }
}