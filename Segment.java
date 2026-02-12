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

    
}

