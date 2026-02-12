package week03.geometry;

public class Segment {


    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1); 
        this.p2 = new Point(p2);
    }

    public Segment(float x1, float y1, float x2, float y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    // Getters & Setters
    public Point getP1() {
        return p1;
    }

    public void setP1(Point p) {
        this.p1 = new Point(p);
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p) {
        this.p2 = new Point(p);
    }

    public void translate(float dX, float dY) {
        p1.translate(dX, dY);
        p2.translate(dX, dY);
    }

    public float length() {
        return p1.distance(p2);
    }

    public boolean equals(Segment s) {
        if (s == null) return false;

        boolean direct = this.p1.equals(s.p1) && this.p2.equals(s.p2);
        boolean reverse = this.p1.equals(s.p2) && this.p2.equals(s.p1);

        return direct || reverse;
    }

    public float getSlope() {
        float dx = p2.getX() - p1.getX();
        if (dx == 0) {
            throw new ArithmeticException("Vertical line - slope is undefined");
        }
        return (p2.getY() - p1.getY()) / dx;
    }

    public float getIntercept() {
        float k = getSlope();
        return p1.getY() - k * p1.getX();
    }

    public boolean isOnLine(Point p) {
        float k = getSlope();
        float b = getIntercept();
        float yCalc = k * p.getX() + b;

        return Math.abs(p.getY() - yCalc) < 0.0001; // float precision tolerance
    }

    public boolean isOnSegment(Point p) {
        if (!isOnLine(p)) return false;

        float minX = Math.min(p1.getX(), p2.getX());
        float maxX = Math.max(p1.getX(), p2.getX());
        float minY = Math.min(p1.getY(), p2.getY());
        float maxY = Math.max(p1.getY(), p2.getY());

        return (p.getX() >= minX && p.getX() <= maxX &&
                p.getY() >= minY && p.getY() <= maxY);
    }

    @Override
    public String toString() {
        return "Segment[" + p1 + " -> " + p2 + "]";
    }
}
