package sample;

import animatefx.animation.Tada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML TableView tableView;
    @FXML Button button1, button2;
    @FXML TextField txtf1,txtf2,txtxi,txtyi,txtTolerancia,txtA,txtB,txtC,txtD;
    double xi,yi,f1,f2,A,B,C,D,J,tolerancia;
    TableColumn columnxi = new TableColumn("Xi");
    TableColumn columnyi = new TableColumn("Yi");
    TableColumn columnf1 = new TableColumn("f1(Xi, Yi)");
    TableColumn columnf2 = new TableColumn("f2(Xi, Yi)");
    TableColumn columnA = new TableColumn("A");
    TableColumn columnB = new TableColumn("B");
    TableColumn columnC = new TableColumn("C");
    TableColumn columnD = new TableColumn("D");
    TableColumn columnJ = new TableColumn("J(det)");
    ObservableList<Tabla> list = FXCollections.observableArrayList();
    @FXML protected void initialize(){
        columnxi.setCellValueFactory(new PropertyValueFactory<Tabla,String>("xi"));
        columnyi.setCellValueFactory(new PropertyValueFactory<Tabla,String>("yi"));
        columnf1.setCellValueFactory(new PropertyValueFactory<Tabla,String>("f1"));
        columnf2.setCellValueFactory(new PropertyValueFactory<Tabla,String>("f2"));
        columnA.setCellValueFactory(new PropertyValueFactory<Tabla,String>("A"));
        columnB.setCellValueFactory(new PropertyValueFactory<Tabla,String>("B"));
        columnC.setCellValueFactory(new PropertyValueFactory<Tabla,String>("C"));
        columnD.setCellValueFactory(new PropertyValueFactory<Tabla,String>("D"));
        columnJ.setCellValueFactory(new PropertyValueFactory<Tabla,String>("J"));
        tableView.getColumns().addAll(columnxi,columnyi,columnf1,columnf2,columnA,columnB,columnC,columnD,columnJ);
        tableView.setItems(list);
    }
    public void insertarDatos(ActionEvent event){
        try {
            Funciones funciones = new Funciones();
            xi = Double.parseDouble(txtxi.getText());
            yi = Double.parseDouble(txtyi.getText());
            tolerancia = Double.parseDouble(txtTolerancia.getText());
            //f1-------------------------------------------------------------------------------
            String funcion1 = txtf1.getText();
            funciones.setFuncion(funcion1);
            funciones.setValorX(Double.parseDouble(txtxi.getText()));
            funciones.setValorY(Double.parseDouble(txtyi.getText()));
            funciones.evaluar();
            f1 = funciones.getResultadoFuncion();
            //f2-------------------------------------------------------------------------------
            String funcion2 = txtf2.getText();
            funciones.setFuncion(funcion2);
            funciones.setValorX(Double.parseDouble(txtxi.getText()));
            funciones.setValorY(Double.parseDouble(txtyi.getText()));
            funciones.evaluar();
            f2 = funciones.getResultadoFuncion();
            //A--------------------------------------------------------------------------------
            String funcionA = txtA.getText();
            funciones.setFuncion(funcionA);
            funciones.setValorX(Double.parseDouble(txtxi.getText()));
            funciones.setValorY(Double.parseDouble(txtyi.getText()));
            funciones.evaluar();
            A = funciones.getResultadoFuncion();
            //B--------------------------------------------------------------------------------
            String funcionB = txtB.getText();
            funciones.setFuncion(funcionB);
            funciones.setValorX(Double.parseDouble(txtxi.getText()));
            funciones.setValorY(Double.parseDouble(txtyi.getText()));
            funciones.evaluar();
            B = funciones.getResultadoFuncion();
            //C--------------------------------------------------------------------------------
            String funcionC = txtC.getText();
            funciones.setFuncion(funcionC);
            funciones.setValorX(Double.parseDouble(txtxi.getText()));
            funciones.setValorY(Double.parseDouble(txtyi.getText()));
            funciones.evaluar();
            C = funciones.getResultadoFuncion();
            //D--------------------------------------------------------------------------------
            String funcionD = txtD.getText();
            funciones.setFuncion(funcionD);
            funciones.setValorX(Double.parseDouble(txtxi.getText()));
            funciones.setValorY(Double.parseDouble(txtyi.getText()));
            funciones.evaluar();
            D = funciones.getResultadoFuncion();
            //J--------------------------------------------------------------------------------
            J = (A*D)-(B*C);
            if (D == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ulises Silveira te dice: ");
                alert.setContentText("Escribe bien las funciones y derivadas");
                alert.show();
            }else {
                list.addAll(new Tabla(xi,yi,f1,f2,A,B,C,D,J));
                button1.setDisable(true);
                button2.setDisable(false);
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ulises Silveira te dice: ");
            alert.setContentText("Algun campo esta vacio o estan mal escritos");
            alert.show();
        }
    }
    public void siguiente(ActionEvent event){
        if (Math.abs(f1) > tolerancia || Math.abs(f2) > tolerancia){
            Funciones funciones = new Funciones();
            double xis = (xi-(((f1*D)-(f2*B))/J));
            double yis = (yi-(((f2*A)-(f1*C))/J));
            //f1-------------------------------------------------------------------------------
            String funcion1 = txtf1.getText();
            funciones.setFuncion(funcion1);
            funciones.setValorX(xis);
            funciones.setValorY(yis);
            funciones.evaluar();
            f1 = funciones.getResultadoFuncion();
            //f2-------------------------------------------------------------------------------
            String funcion2 = txtf2.getText();
            funciones.setFuncion(funcion2);
            funciones.setValorX(xis);
            funciones.setValorY(yis);
            funciones.evaluar();
            f2 = funciones.getResultadoFuncion();
            //A--------------------------------------------------------------------------------
            String funcionA = txtA.getText();
            funciones.setFuncion(funcionA);
            funciones.setValorX(xis);
            funciones.setValorY(yis);
            funciones.evaluar();
            A = funciones.getResultadoFuncion();
            //B--------------------------------------------------------------------------------
            String funcionB = txtB.getText();
            funciones.setFuncion(funcionB);
            funciones.setValorX(xis);
            funciones.setValorY(yis);
            funciones.evaluar();
            B = funciones.getResultadoFuncion();
            //C--------------------------------------------------------------------------------
            String funcionC = txtC.getText();
            funciones.setFuncion(funcionC);
            funciones.setValorX(xis);
            funciones.setValorY(yis);
            funciones.evaluar();
            C = funciones.getResultadoFuncion();
            //D--------------------------------------------------------------------------------
            String funcionD = txtD.getText();
            funciones.setFuncion(funcionD);
            funciones.setValorX(xis);
            funciones.setValorY(yis);
            funciones.evaluar();
            D = funciones.getResultadoFuncion();
            //J--------------------------------------------------------------------------------
            J = (A*D)-(B*C);
            xi=xis; yi=yis;
            list.addAll(new Tabla(xis,yis,f1,f2,A,B,C,D,J));
        }else {
            new Tada(tableView).play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ulises Silveira te dice: ");
            alert.setContentText("La Xi = " + xi + " la Yi = " + yi );
            alert.show();
        }
    }
    public void limpiar(ActionEvent event){
        txtxi.setText("");
        txtyi.setText("");
        txtf1.setText("");
        txtf2.setText("");
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtD.setText("");
        txtTolerancia.setText("");
        button1.setDisable(false);
        button2.setDisable(true);
        list.clear();
    }
}
