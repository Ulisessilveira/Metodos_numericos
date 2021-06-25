package sample.lineal;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tabla {
    SimpleStringProperty n;
    SimpleDoubleProperty x;
    SimpleDoubleProperty y;
    SimpleDoubleProperty xy;
    SimpleDoubleProperty xx;

    public Tabla(String n, double x, double y, double xy, double xx) {
        this.n = new SimpleStringProperty(n);
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.xy = new SimpleDoubleProperty(xy);
        this.xx = new SimpleDoubleProperty(xx);
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
}
