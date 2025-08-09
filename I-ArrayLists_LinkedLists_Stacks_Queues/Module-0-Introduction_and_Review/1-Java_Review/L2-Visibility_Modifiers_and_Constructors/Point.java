public class Point {
    private double x;  //private can be seen only by the class and inner classes
    private double y;
    private String var1;
    private String var2; 

    //define constructors
    public Point(double x, double y){
        this.x=x;
        this.y=y;
        this.var1= "this shuold not be modified";
        this.var2 = "this should not be accessed or modified";
    }

    public Point(double x){
        this(x, 0); //access the more specific cosntructor with constructor chaining
    }

    public static Point fromPolar(double r, double theta){
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);
        return new Point(x, y);
    } //usage Point polar = Point.fromPolar(5, Math.PI / 3);

    //best practice to set variables as private and use get/set methods to allow outsid e modification
    public double getX(){
        return this.x;
    }
    public void setX(double newX){
        this.x = newX;
    }

    public double getY(){
        return this.y;
    }
    public void setY(double newY){
        this.y=newY;
    }

    //we dont include a set/get methods if we want to (partially or fully) restrict outside access to these private variables
    public String getVar1(){
        return this.var1; 
    }
    //no set for var1 since we dont want to modify it

    //no set or get for var2 since we dont want to modify it or access it
    public void func(){
        //we can still access private variables for which we have restricted access
        System.out.println(this.var2);
    }
}

