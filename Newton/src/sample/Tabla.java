package sample;

import javafx.beans.property.SimpleDoubleProperty;

public class Tabla {
    SimpleDoubleProperty xi;
    SimpleDoubleProperty yi;
    SimpleDoubleProperty f1;
    SimpleDoubleProperty f2;
    SimpleDoubleProperty A;
    SimpleDoubleProperty B;
    SimpleDoubleProperty C;
    SimpleDoubleProperty D;
    SimpleDoubleProperty J;

    public Tabla(double xi, double yi, double f1, double f2, double A, double B, double C, double D, double J){
        this.xi = new SimpleDoubleProperty(xi);
        this.yi = new SimpleDoubleProperty(yi);
        this.f1 = new SimpleDoubleProperty(f1);
        this.f2 = new SimpleDoubleProperty(f2);
        this.A = new SimpleDoubleProperty(A);
        this.B = new SimpleDoubleProperty(B);
        this.C = new SimpleDoubleProperty(C);
        this.D = new SimpleDoubleProperty(D);
        this.J = new SimpleDoubleProperty(J);
    }

    public double getXi() {
        return xi.get();
    }

    public SimpleDoubleProperty xiProperty() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi.set(xi);
    }

    public double getYi() {
        return yi.get();
    }

    public SimpleDoubleProperty yiProperty() {
        return yi;
    }

    public void setYi(double yi) {
        this.yi.set(yi);
    }

    public double getF1() {
        return f1.get();
    }

    public SimpleDoubleProperty f1Property() {
        return f1;
    }

    public void setF1(double f1) {
        this.f1.set(f1);
    }

    public double getF2() {
        return f2.get();
    }

    public SimpleDoubleProperty f2Property() {
        return f2;
    }

    public void setF2(double f2) {
        this.f2.set(f2);
    }

    public double getA() {
        return A.get();
    }

    public SimpleDoubleProperty aProperty() {
        return A;
    }

    public void setA(double a) {
        this.A.set(a);
    }

    public double getB() {
        return B.get();
    }

    public SimpleDoubleProperty bProperty() {
        return B;
    }

    public void setB(double b) {
        this.B.set(b);
    }

    public double getC() {
        return C.get();
    }

    public SimpleDoubleProperty cProperty() {
        return C;
    }

    public void setC(double c) {
        this.C.set(c);
    }

    public double getD() {
        return D.get();
    }

    public SimpleDoubleProperty dProperty() {
        return D;
    }

    public void setD(double d) {
        this.D.set(d);
    }

    public double getJ() {
        return J.get();
    }

    public SimpleDoubleProperty jProperty() {
        return J;
    }

    public void setJ(double j) {
        this.J.set(j);
    }
}
