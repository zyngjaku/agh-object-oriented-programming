public abstract class Punkt2D {
    private double x;
    private double y;

    public Punkt2D(double _x, double _y){
        x = _x;
        y = _y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double _x){
        x = _x;
    }

    public void setY(double _y){
        y = _y;
    }

    public double distance(Punkt2D punkt2D){
        return Math.hypot(x- punkt2D.getX(), y- punkt2D.getY());
    }

    public abstract double distance(Punkt3D punkt3D);
}
