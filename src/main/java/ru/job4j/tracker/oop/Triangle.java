package ru.job4j.tracker.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point up, Point bp, Point cp) {
        this.first = up;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimetr(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double bc, double ac) {
        return ab + bc > ac && ab + ac > bc && bc + ac > ab;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ac = first.distance(third);
        if (this.exist(ab, bc, ac)) {
            double p = semiPerimetr(ab, ac, bc);
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
