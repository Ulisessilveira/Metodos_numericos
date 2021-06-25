package sample.cuadratica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.lineal.Tabla;
import sample.principal.Controller;

import java.text.DecimalFormat;

public class Cuadratica {
    @FXML TableView table;
    @FXML Label lbEcuacion;
    public static Label lbEcu;
    int n = 0;
    int dn = 1;
    double dx,dy,dxy,dxx,dxxx,dxxxx,dxxy;
    double sumatoriaX,sumatoriaY,sumatoriaXY,sumatoriaXX,sumatoriaXXX,sumatoriaXXXX,sumatoriaXXY;
    double mattriz[][] = new double[3][4];
    TextField[] lArrayTxtX = null;
    TextField[] lArrayTxtY = null;
    Controller controller;
    DecimalFormat format;
    TableColumn cn = new TableColumn("n");
    TableColumn cx = new TableColumn("x");
    TableColumn cy = new TableColumn("y");
    TableColumn cxy = new TableColumn("xy");
    TableColumn cxx= new TableColumn("x^2");
    TableColumn cxxx = new TableColumn("x^3");
    TableColumn cxxxx = new TableColumn("x^4");
    TableColumn cxxy = new TableColumn("x^2 y");
    ObservableList<Tabla2> list = FXCollections.observableArrayList();
    @FXML protected void initialize(){
        format = new DecimalFormat("####.##");
        controller = new Controller();
        tabla();
    }
    public void tabla(){
        cn.setMaxWidth(40);
        cx.setMaxWidth(70);
        cy.setMaxWidth(70);
        cxy.setMaxWidth(70);
        cxx.setMaxWidth(70);
        cxxx.setMaxWidth(70);
        cxxxx.setMaxWidth(70);
        cxxy.setMaxWidth(70);
        cn.setCellValueFactory(new PropertyValueFactory<Tabla,String>("n"));
        cx.setCellValueFactory(new PropertyValueFactory<Tabla,String>("x"));
        cy.setCellValueFactory(new PropertyValueFactory<Tabla,String>("y"));
        cxy.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xy"));
        cxx.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xx"));
        cxxx.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xxx"));
        cxxxx.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xxxx"));
        cxxy.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xxy"));
        table.getColumns().addAll(cn,cx,cy,cxy,cxx,cxxx,cxxxx,cxxy);
        table.setItems(list);
        lArrayTxtX = controller.arrayTxtX;
        lArrayTxtY = controller.arrayTxtY;
        n = controller.datos;
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
            dxxx = dx * dx *dx;
            sumatoriaXXX+=dxxx;
            dxxxx = dx * dx * dx * dx;
            sumatoriaXXXX+=dxxxx;
            dxxy = dxx * dy;
            sumatoriaXXY+= dxxy;
            list.addAll(new Tabla2(dn+"",dx,dy,dxy,dxx,dxxx,dxxxx,dxxy));
            dn++;
        }
        list.addAll(new Tabla2("",sumatoriaX,sumatoriaY,sumatoriaXY,sumatoriaXX,sumatoriaXXX,sumatoriaXXXX,sumatoriaXXY));
        gaussJordan(n,sumatoriaX,sumatoriaXX,sumatoriaY,sumatoriaX,sumatoriaXX,sumatoriaXXX,sumatoriaXY,sumatoriaXX,sumatoriaXXX,sumatoriaXXXX,sumatoriaXXY);
    }
    public void gaussJordan(double c1, double b1, double a1, double r1,
            double c2, double b2, double a2, double r2,
            double c3, double b3, double a3, double r3){
        //Primera matriz
        //Fila uno -----------------------------------------------------------------------------
        mattriz[0][0] = c1;
        mattriz[0][1] = b1;
        mattriz[0][2] = a1;
        mattriz[0][3] = r1;
        //Fila dos -----------------------------------------------------------------------------
        mattriz[1][0] = c2;
        mattriz[1][1] = b2;
        mattriz[1][2] = a2;
        mattriz[1][3] = r2;
        //Fila tres -----------------------------------------------------------------------------
        mattriz[2][0] = c3;
        mattriz[2][1] = b3;
        mattriz[2][2] = a3;
        mattriz[2][3] = r3;
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                System.out.print("["+mattriz[i][j]+"]    ");
            }
            System.out.println("");
        }
        System.out.println("");
        //Segunda matriz
        //Fila uno -----------------------------------------------------------------------------
        double valor00 = mattriz[0][0];
        mattriz[0][0] = mattriz[0][0] / valor00;
        mattriz[0][1] = mattriz[0][1] / valor00;
        mattriz[0][2] = mattriz[0][2] / valor00;
        mattriz[0][3] = mattriz[0][3] / valor00;
        //Fila dos -----------------------------------------------------------------------------
        double valot10 = mattriz[1][0] * -1;
        mattriz[1][0] = (valot10 * mattriz[0][0]) + mattriz[1][0];
        mattriz[1][1] = (valot10 * mattriz[0][1]) + mattriz[1][1];
        mattriz[1][2] = (valot10 * mattriz[0][2]) + mattriz[1][2];
        mattriz[1][3] = (valot10 * mattriz[0][3]) + mattriz[1][3];
        //Fila tres -----------------------------------------------------------------------------
        double valor20 = mattriz[2][0] * -1;
        mattriz[2][0] = (valor20 * mattriz[0][0]) + mattriz[2][0];
        mattriz[2][1] = (valor20 * mattriz[0][1]) + mattriz[2][1];
        mattriz[2][2] = (valor20  * mattriz[0][2]) + mattriz[2][2];
        mattriz[2][3] = (valor20 * mattriz[0][3]) + mattriz[2][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                System.out.print("["+mattriz[i][j]+"]    ");
            }
            System.out.println("");
        }
        System.out.println("");
        //Tercera matriz
        //Fila dos -----------------------------------------------------------------------------
        double valor11 = mattriz[1][1];
        mattriz[1][0] = mattriz[1][0] / valor11;
        mattriz[1][1] = mattriz[1][1] / valor11;
        mattriz[1][2] = mattriz[1][2] / valor11;
        mattriz[1][3] = mattriz[1][3] / valor11;
        //Fila uno -----------------------------------------------------------------------------
        double valor01 = mattriz[0][1] * -1;
        mattriz[0][0] = (valor01 * mattriz[1][0]) + mattriz[0][0];
        mattriz[0][1] = (valor01 * mattriz[1][1]) + mattriz[0][1];
        mattriz[0][2] = (valor01 * mattriz[1][2]) + mattriz[0][2];
        mattriz[0][3] = (valor01 * mattriz[1][3]) + mattriz[0][3];
        //Fila tres -----------------------------------------------------------------------------
        double valor21 = mattriz[2][1] * -1;
        mattriz[2][0] = (valor21 * mattriz[1][0]) + mattriz[2][0];
        mattriz[2][1] = (valor21 * mattriz[1][1]) + mattriz[2][1];
        mattriz[2][2] = (valor21 * mattriz[1][2]) + mattriz[2][2];
        mattriz[2][3] = (valor21 * mattriz[1][3]) + mattriz[2][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                System.out.print("["+mattriz[i][j]+"]    ");
            }
            System.out.println("");
        }
        System.out.println("");
        //Cuarta matriz
        //Fila tres -----------------------------------------------------------------------------
        double valor22 = mattriz[2][2];
        mattriz[2][0] = mattriz[2][0] / valor22;
        mattriz[2][1] = mattriz[2][1] / valor22;
        mattriz[2][2] = mattriz[2][2] / valor22;
        mattriz[2][3] = mattriz[2][3] / valor22;
        //Fila uno -----------------------------------------------------------------------------
        double valor02 = mattriz[0][2] * -1;
        mattriz[0][0] = (valor02 * mattriz[2][0]) + mattriz[0][0];
        mattriz[0][1] = (valor02 * mattriz[2][1]) + mattriz[0][1];
        mattriz[0][2] = (valor02 * mattriz[2][2]) + mattriz[0][2];
        mattriz[0][3] = (valor02 * mattriz[2][3]) + mattriz[0][3];
        //Fila dos -----------------------------------------------------------------------------
        double valot12 = mattriz[1][2] * -1;
        mattriz[1][0] = (valot12 * mattriz[2][0]) + mattriz[1][0];
        mattriz[1][1] = (valot12 * mattriz[2][1]) + mattriz[1][1];
        mattriz[1][2] = (valot12 * mattriz[2][2]) + mattriz[1][2];
        mattriz[1][3] = (valot12 * mattriz[2][3]) + mattriz[1][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                System.out.print("["+mattriz[i][j]+"]    ");
            }
            System.out.println("");
        }
        System.out.println("");
        lbEcuacion.setText("(" + format.format(mattriz[2][3]) + ") * (X^2) + (" + format.format(mattriz[1][3]) + ") * (X) + (" + format.format(mattriz[0][3])+ ")");
        lbEcu = lbEcuacion;
        controller.lbE.setText(lbEcu.getText());
    }
}
