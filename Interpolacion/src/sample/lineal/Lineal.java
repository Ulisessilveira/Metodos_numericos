package sample.lineal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.principal.Controller;

import java.text.DecimalFormat;


public class Lineal {
    @FXML TableView table;
    @FXML Label lbEcuacion;
    public static Label lbEcu;
    int n = 0;
    int dn = 1;
    double dx,dy,dxy,dxx;
    double sumatoriaX,sumatoriaY,sumatoriaXY,sumatoriaXX;
    TextField[] lArrayTxtX = null;
    TextField[] lArrayTxtY = null;
    Controller controller;
    TableColumn cn = new TableColumn("n");
    TableColumn cx = new TableColumn("x");
    TableColumn cy = new TableColumn("y");
    TableColumn cxy = new TableColumn("xy");
    TableColumn cxx= new TableColumn("x^2");
    ObservableList<Tabla> list = FXCollections.observableArrayList();
    @FXML protected void initialize(){
        DecimalFormat format = new DecimalFormat("####.##");
        controller = new Controller();
        cn.setMinWidth(80);
        cx.setMinWidth(80 );
        cy.setMinWidth(80);
        cxy.setMinWidth(80);
        cxx.setMinWidth(80);
        cn.setCellValueFactory(new PropertyValueFactory<Tabla,String>("n"));
        cx.setCellValueFactory(new PropertyValueFactory<Tabla,String>("x"));
        cy.setCellValueFactory(new PropertyValueFactory<Tabla,String>("y"));
        cxy.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xy"));
        cxx.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xx"));
        table.getColumns().addAll(cn,cx,cy,cxy,cxx);
        table.setItems(list);
        lArrayTxtX = controller.arrayTxtX;
        lArrayTxtY = controller.arrayTxtY;
        n = controller.datos;
        System.out.println(n);
        for (int i=0; i<n; i++){
            System.out.println(lArrayTxtX[i].getId() + "    " + lArrayTxtX[i].getText());
            System.out.println(lArrayTxtY[i].getId()+ "    " + lArrayTxtY[i].getText());
            dx= Double.parseDouble(lArrayTxtX[i].getText());
            sumatoriaX+=dx;
            dy = Double.parseDouble(lArrayTxtY[i].getText());
            sumatoriaY+=dy;
            dxy = dx * dy;
            sumatoriaXY+=dxy;;
            dxx = dx * dx;
            sumatoriaXX+=dxx;
            list.addAll(new Tabla(dn+"",dx,dy,dxy,dxx));
            dn++;
        }
        list.addAll(new Tabla("",sumatoriaX,sumatoriaY,sumatoriaXY,sumatoriaXX));
        //Partes y realizacion de formula a
        double nXsumxy = n*sumatoriaXY;
        double sumxXsumy = sumatoriaX * sumatoriaY;
        double nXsumxx = n*sumatoriaXX;
        double sumxCua = sumatoriaX * sumatoriaX;
        double aArriba = nXsumxy - sumxXsumy;
        double aAbajo = nXsumxx - sumxCua;
        double a = aArriba / aAbajo;
        //Partes y realizacion de la formula b
        double aXsumatoriaX = a*sumatoriaX;
        double bArriba = sumatoriaY - aXsumatoriaX;
        double bAbajo = n;
        double b = bArriba/bAbajo;
        lbEcuacion.setText("("+ format.format(a) + ") * (X) + (" +  format.format(b) + ")");
        lbEcu = lbEcuacion;
        controller.lbE.setText(lbEcu.getText());
    }
}
