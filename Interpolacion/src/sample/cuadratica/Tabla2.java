package sample.cuadratica;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tabla2 {
    SimpleStringProperty n;
    SimpleDoubleProperty x;
    SimpleDoubleProperty y;
    SimpleDoubleProperty xy;
    SimpleDoubleProperty xx;
    SimpleDoubleProperty xxx;
    SimpleDoubleProperty xxxx;
    SimpleDoubleProperty xxy;

    public Tabla2(String n, Double x, Double y, Double xy, Double xx, Double xxx, Double xxxx, Double xxy) {
        this.n = new SimpleStringProperty(n);
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.xy = new SimpleDoubleProperty(xy);
        this.xx = new SimpleDoubleProperty(xx);
        this.xxx = new SimpleDoubleProperty(xxx);
        this.xxxx = new SimpleDoubleProperty(xxxx);
        this.xxy = new SimpleDoubleProperty(xxy);
    }

    public String getN() {
        return n.get();
    }

    public SimpleStringProperty nProperty() {
        return n;
    }

    public void setN(String n) {
        this.n.set(n);
    }

    public double getX() {
        return x.get();
    }

    public SimpleDoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public SimpleDoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getXy() {
        return xy.get();
    }

    public SimpleDoubleProperty xyProperty() {
        return xy;
    }

    public void setXy(double xy) {
        this.xy.set(xy);
    }

    public double getXx() {
        return xx.get();
    }

    public SimpleDoubleProperty xxProperty() {
        return xx;
    }

    public void setXx(double xx) {
        this.xx.set(xx);
    }

    public double getXxx() {
        return xxx.get();
    }

    public SimpleDoubleProperty xxxProperty() {
        return xxx;
    }

    public void setXxx(double xxx) {
        this.xxx.set(xxx);
    }

    public double getXxxx() {
        return xxxx.get();
    }

    public SimpleDoubleProperty xxxxProperty() {
        return xxxx;
    }

    public void setXxxx(double xxxx) {
        this.xxxx.set(xxxx);
    }

    public double getXxy() {
        return xxy.get();
    }

    public SimpleDoubleProperty xxyProperty() {
        return xxy;
    }

    public void setXxy(double xxy) {
        this.xxy.set(xxy);
    }
}
