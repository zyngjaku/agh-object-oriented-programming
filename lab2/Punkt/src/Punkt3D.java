public class Punkt3D extends Punkt2D {
    protected double z;

    public Punkt3D(double _x, double _y, double z) {
        super(_x, _y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double distance(Punkt3D punkt3D) {
        return Math.sqrt(Math.pow(getX() - punkt3D.getX(), 2) + Math.pow(getY() - punkt3D.getY(), 2) + Math.pow(z - punkt3D.getZ(), 2));
    }
}
