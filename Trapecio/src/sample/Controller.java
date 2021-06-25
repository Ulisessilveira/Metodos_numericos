package sample;

import animatefx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML TextField lba,lbb,lbFuncion,txtn;
    @FXML Label  lbh,lbResultado;
    @FXML TableView tabla;
    @FXML Button btnCalcular, btnSiguiente;
    double a,b,n,h,sumatoria;
    double columnan, columnaah, columnaFah, columnaCoef, columnaFahCoef;
    TableColumn c1 = new TableColumn("n");
    TableColumn c2 = new TableColumn("a+h");
    TableColumn c3 = new TableColumn("f(a+h)");
    TableColumn c4 = new TableColumn("Coeficiente");
    TableColumn c5 = new TableColumn("f(a+h)*Coef");
    ObservableList<Tabla> list = FXCollections.observableArrayList();
    @FXML protected void initialize(){
        c1.setCellValueFactory(new PropertyValueFactory<Tabla,String>("columna1"));
        c2.setCellValueFactory(new PropertyValueFactory<Tabla,String>("columna2"));
        c3.setCellValueFactory(new PropertyValueFactory<Tabla,String>("columna3"));
        c4.setCellValueFactory(new PropertyValueFactory<Tabla,String>("columna4"));
        c5.setCellValueFactory(new PropertyValueFactory<Tabla,String>("columna5"));
        c1.setMaxWidth(30);
        c2.setMaxWidth(75);
        tabla.getColumns().addAll(c1,c2,c3,c4,c5);
        tabla.setItems(list);
    }

    public void calcular(ActionEvent event){
        if(!txtn.getText().equals("0") && Integer.parseInt(txtn.getText())>0){
            //calcular h
            a = Double.parseDouble(lba.getText());
            b = Double.parseDouble(lbb.getText());
            n = Double.parseDouble(txtn.getText());
            h= (b-a)/n;
            lbh.setText("h= " + h);
            //n
            columnan = 0;
            //a+h
            columnaah = a;
            //f(a+h)
            Funciones funciones = new Funciones();
            String funcion = lbFuncion.getText();
            funciones.setFuncion(funcion);
            funciones.setValorx(Math.abs(columnaah));
            funciones.evaluar();
            if (columnaah<0){
                columnaFah = -1 * funciones.getResultadoFuncion();
            }else {
                columnaFah = funciones.getResultadoFuncion();
            }
            //coeficiente
            columnaCoef = 1.0;
            //f(a+h) * coef
            columnaFahCoef = columnaFah * columnaCoef;
            sumatoria+=columnaFahCoef;
            list.add(new Tabla(columnan, columnaah, columnaFah,columnaCoef,columnaFahCoef));
            System.out.println(columnan + " " + columnaah + " " + columnaFah + " " +columnaCoef + " " +columnaFahCoef );
            btnSiguiente.setVisible(true);
            btnCalcular.setDisable(true);
            n=0;
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Escribe un numero diferente a 0 porfavor ");
            alert.show();
        }


    }
    public void siguiente(ActionEvent event){
        if(btnSiguiente.getText().equals("Siguiente")){
            if (n<Double.parseDouble(txtn.getText())){
                //n
                if(n<=Double.parseDouble(txtn.getText())){
                    n++;
                    columnan = n;
                }
                //a+h
                columnaah+=h;
                //f(a+h)
                Funciones funciones = new Funciones();
                String funcion = lbFuncion.getText();
                funciones.setFuncion(funcion);
                funciones.setValorx(Math.abs(columnaah));
                funciones.evaluar();
                if (columnaah<0){
                    columnaFah = -1 * funciones.getResultadoFuncion();
                }else {
                    columnaFah = funciones.getResultadoFuncion();
                }
                //Coeficiente
                if(n<Double.parseDouble(txtn.getText())){
                    columnaCoef = 2;
                }else {
                    columnaCoef = 1;
                }
                //f(a+h)*coef
                columnaFahCoef = columnaFah * columnaCoef;
                sumatoria+=columnaFahCoef;
                list.add(new Tabla(columnan, columnaah, columnaFah,columnaCoef,columnaFahCoef));
                System.out.println(columnan + " " + columnaah + " " + columnaFah + " " +columnaCoef + " " +columnaFahCoef );
            }else {
                lbResultado.setVisible(true);
                double resultado;
                resultado = sumatoria * (h/2);
                System.out.println("El resultado es: " + resultado + "u^2");
                btnSiguiente.setText("Limpiar");
                lbResultado.setText("El resultado es: " + resultado + "u^2");
                sumatoria=0;
                new BounceInDown(lbResultado).play();
            }
        }else if(btnSiguiente.getText().equals("Limpiar")){
            btnSiguiente.setVisible(false);
            btnCalcular.setDisable(false);
            btnSiguiente.setText("Siguiente");
            lbResultado.setVisible(false);
            list.clear();
        }
    }
}
