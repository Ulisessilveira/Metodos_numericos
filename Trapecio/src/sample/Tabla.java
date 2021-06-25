package sample;

import javafx.beans.property.SimpleDoubleProperty;

public class Tabla {
    SimpleDoubleProperty columna1;
    SimpleDoubleProperty columna2;
    SimpleDoubleProperty columna3;
    SimpleDoubleProperty columna4;
    SimpleDoubleProperty columna5;

    public Tabla(double columna1, double columna2, double columna3, double columna4, double columna5){
        this.columna1 = new SimpleDoubleProperty(columna1);
        this.columna2 = new SimpleDoubleProperty(columna2);
        this.columna3 = new SimpleDoubleProperty(columna3);
        this.columna4 = new SimpleDoubleProperty(columna4);
        this.columna5 = new SimpleDoubleProperty(columna5);
    }

    public double getColumna1() {
        return columna1.get();
    }

    public SimpleDoubleProperty columna1Property() {
        return columna1;
    }

    public void setColumna1(double columna1) {
        this.columna1.set(columna1);
    }

    public double getColumna2() {
        return columna2.get();
    }

    public SimpleDoubleProperty columna2Property() {
        return columna2;
    }

    public void setColumna2(double columna2) {
        this.columna2.set(columna2);
    }

    public double getColumna3() {
        return columna3.get();
    }

    public SimpleDoubleProperty columna3Property() {
        return columna3;
    }

    public void setColumna3(double columna3) {
        this.columna3.set(columna3);
    }

    public double getColumna4() {
        return columna4.get();
    }

    public SimpleDoubleProperty columna4Property() {
        return columna4;
    }

    public void setColumna4(double columna4) {
        this.columna4.set(columna4);
    }

    public double getColumna5() {
        return columna5.get();
    }

    public SimpleDoubleProperty columna5Property() {
        return columna5;
    }

    public void setColumna5(double columna5) {
        this.columna5.set(columna5);
    }
}
