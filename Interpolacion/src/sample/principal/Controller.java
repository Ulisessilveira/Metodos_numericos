package sample.principal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Langrange.Langrage;
import sample.funciones.Funciones;
import sample.login.Login;

import java.io.IOException;
import java.text.DecimalFormat;

public class Controller {
    @FXML Label lbEcuacion;
    public static Label lbE;
    @FXML Label lbNombre,lbX,lbY,lbGrafica,lbA1,lbA2;
    @FXML TextField txtProyeccion,txtdatos,txteX,txteY;
    @FXML TextField txtX,txtY;
    @FXML LineChart<Number,Number> lineChart;
    @FXML VBox contenedorX, contenedorY;
    @FXML Button btnC, btnLangrange;
    public static int datos=0;
    double x,xGrafica,yGrafica,f;
    Double xOffset,yOffset;
    XYChart.Series<Number,Number> series;
    public static TextField[] arrayTxtX = null;
    public static TextField[] arrayTxtY = null;
    Langrage langrage;
    DecimalFormat format;
    @FXML protected void initialize(){
        format = new DecimalFormat("####");
        lbE = lbEcuacion;
        Login login = new Login();
        lbNombre.setText(login.nombre);
    }

    public void capturar(ActionEvent event){
        try{
            if(txtProyeccion.getText().equals("") || txteX.getText().equals("") || txteY.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Algun campo esta vacio");
                alert.show();
            }else {
                //Nombre proyeccion ----------------------------------------------------------------------------------
                lbGrafica.setText("Grafica: "+ txtProyeccion.getText());
                //Numero de datos -------------------------------------------------------------------------------------
                datos = Integer.parseInt(txtdatos.getText());
                if (datos <= 0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Escribel un numero de datos validos");
                    alert.show();
                }else {
                    craertxtTabla();
                }
                //Etiqueta de x ---------------------------------------------------------------------------------------
                lbX.setText(txteX.getText());
                //Etiqueta de Y----------------------------------------------------------------------------------------
                lbY.setText(txteY.getText());
            }
            if (datos == 3){
                btnLangrange.setDisable(false);
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Escribe los datos correctamente");
            alert.show();
        }
    }

    public void nuevoDato(ActionEvent event){
        try {
            Funciones funciones = new Funciones();
            x = Double.parseDouble(txtX.getText());
            String funcion = lbE.getText();
            funciones.setFuncion(funcion);
            funciones.setValorX(x);
            funciones.evaluar();
            f = funciones.getResultadoFuncion();
            txtY.setText(format.format(f)+"");
            lineCharEvent(Double.parseDouble(txtX.getText()),f);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Escribe el valor de " + txteX.getText());
            alert.show();
        }
    }

    public void lineCharEvent(Number xValue, Number yValue){
        series = new XYChart.Series<Number, Number>();
        series.getData().add(new XYChart.Data(xValue+"",yValue));
        lineChart.getData().addAll(series);
    }

    public void graficarDatos(ActionEvent event){
        try{
            if (arrayTxtX == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Aun no se crea la tabla");
                alert.show();
            }else {
                lineChart.getData().clear();
                series = new XYChart.Series<Number, Number>();
                for (int i=0; i<datos; i++){
                    xGrafica = Double.parseDouble(arrayTxtX[i].getText());
                    yGrafica = Double.parseDouble(arrayTxtY[i].getText());
                    System.out.println(arrayTxtX[i].getId() + "    " + arrayTxtX[i].getText());
                    System.out.println(arrayTxtY[i].getId()+ "    " + arrayTxtY[i].getText());
                    System.out.println("");
                    series.getData().add(new XYChart.Data(xGrafica+"",yGrafica));
                }
                lineChart.getData().addAll(series);
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Inserte un valor valido en el campo de texto");
            alert.show();
        }
    }
    public void limpiar(ActionEvent event){
        txtProyeccion.setText("");
        txtdatos.setText("");
        txteX.setText("");
        txteY.setText("");
        contenedorX.getChildren().clear();
        contenedorY.getChildren().clear();
        lineChart.getData().clear();
        lbEcuacion.setText("");
        lbGrafica.setText("Grafica: ");
        lbX.setText("X");
        lbY.setText("Y");
        txtX.setText("");
        txtY.setText("");
        txtX.setEditable(true);
        btnC.setDisable(true);
        arrayTxtX = null;
        arrayTxtY = null;
        lbA1.setVisible(false);
        lbA2.setVisible(false);

    }
    public void limpiarGrafica(ActionEvent event){
        lineChart.getData().clear();
    }
    public void cerrar(ActionEvent event){
        System.exit(0);
    }

    public void craertxtTabla(){
        contenedorX.getChildren().clear();
        contenedorY.getChildren().clear();
        arrayTxtX = new TextField[datos];
        arrayTxtY = new TextField[datos];
        for(int i=0; i<datos; i++){
            arrayTxtX[i] = new TextField();
            arrayTxtX[i].setPrefWidth(50);
            arrayTxtX[i].setPrefHeight(50);
            arrayTxtX[i].setId("txtTablaX-" + i);
            arrayTxtX[i].setStyle("-fx-background-color: #004d7a; " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-color: white; " +
                    "-fx-border-radius: 10; " +
                    "-fx-text-fill: white; " +
                    "-fx-alignment: center; " +
                    "-fx-padding: 5px;" +
                    "-fx-border-insets: 5px;" +
                    "-fx-background-insets: 5px;" +
                    "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.2), 10.0, 0.0, 0.0, 10.0);");
            arrayTxtY[i] = new TextField();
            arrayTxtY[i].setPrefWidth(50);
            arrayTxtY[i].setPrefHeight(50);
            arrayTxtY[i].setId("txtTablaY-" + i);
            arrayTxtY[i].setStyle("-fx-background-color: #004d7a; " +
                    "-fx-background-radius: 10; " +
                    "-fx-border-color: white; " +
                    "-fx-border-radius: 10; " +
                    "-fx-text-fill: white; " +
                    "-fx-alignment: center; " +
                    "-fx-padding: 5px;" +
                    "-fx-border-insets: 5px;" +
                    "-fx-background-insets: 5px;" +
                    "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.2), 10.0, 0.0, 0.0, 10.0);");
            contenedorX.getChildren().add(arrayTxtX[i]);
            contenedorY.getChildren().add(arrayTxtY[i]);
        }
    }
    public void mensaje(MouseEvent event){
        if (datos == 3 || datos == 0){
            System.out.println("Siga su camino");
        }else {
            lbA1.setVisible(true);
            lbA2.setVisible(true);
        }
    }
    public void btnLangrage(ActionEvent event){
        if (datos == 3) {
            txtX.setEditable(true);
            btnC.setDisable(false);
            langrage = new Langrage(
                    Double.parseDouble(arrayTxtX[0].getText()),
                    Double.parseDouble(arrayTxtX[1].getText()),
                    Double.parseDouble(arrayTxtX[2].getText()),
                    Double.parseDouble(arrayTxtY[0].getText()),
                    Double.parseDouble(arrayTxtY[1].getText()),
                    Double.parseDouble(arrayTxtY[2].getText()));
        }
    }
    public void elineal(ActionEvent event){
        try {
            if (datos>0){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../lineal/lineal.fxml"));
                Parent root = null;
                root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                txtX.setEditable(true);
                btnC.setDisable(false);
                root.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    }
                });
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        stage.setX(event.getScreenX() - xOffset);
                        stage.setY(event.getScreenY() - yOffset);
                    }
                });
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No se encuentran datos para realizar el metodo");
                alert.show();
            }
        }catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Algun dato de la tabla esta vacio, llenalo porfavor");
            alert.show();
        }

    }
    public void btnCuadratico(ActionEvent event) throws IOException {
        try {
            if (datos>0){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../cuadratica/cuadratica.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                txtX.setEditable(true);
                btnC.setDisable(false);
                root.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    }
                });
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        stage.setX(event.getScreenX() - xOffset);
                        stage.setY(event.getScreenY() - yOffset);
                    }
                });
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No se encuentran datos para realizar el metodo");
                alert.show();
            }
        }catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Algun dato de la tabla esta vacio, llenalo porfavor");
            alert.show();
        }
    }
}
