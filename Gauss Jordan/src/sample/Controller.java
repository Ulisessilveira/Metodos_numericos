package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML TextField txta1;
    @FXML TextField txtb1;
    @FXML  TextField txtc1;
    @FXML  TextField txtr1;
    @FXML  TextField txta2;
    @FXML  TextField txtb2;
    @FXML  TextField txtc2;
    @FXML  TextField txtr2;
    @FXML  TextField txta3;
    @FXML TextField txtb3;
    @FXML TextField txtc3;
    @FXML TextField txtr3;
    @FXML Label lbA;
    @FXML Label lbB;
    @FXML Label lbC;
    double mattriz[][] = new double[3][4];

    public void calcular(ActionEvent event){
        //Primera matriz
        //Fila uno -----------------------------------------------------------------------------
        mattriz[0][0] = Double.parseDouble(txta1.getText());
        mattriz[0][1] = Double.parseDouble(txtb1.getText());
        mattriz[0][2] = Double.parseDouble(txtc1.getText());
        mattriz[0][3] = Double.parseDouble(txtr1.getText());
        //Fila dos -----------------------------------------------------------------------------
        mattriz[1][0] = Double.parseDouble(txta2.getText());
        mattriz[1][1] = Double.parseDouble(txtb2.getText());
        mattriz[1][2] = Double.parseDouble(txtc2.getText());
        mattriz[1][3] = Double.parseDouble(txtr2.getText());
        //Fila tres -----------------------------------------------------------------------------
        mattriz[2][0] = Double.parseDouble(txta3.getText());
        mattriz[2][1] = Double.parseDouble(txtb3.getText());
        mattriz[2][2] = Double.parseDouble(txtc3.getText());
        mattriz[2][3] = Double.parseDouble(txtr3.getText());
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
        lbA.setText("A = " + mattriz[0][3]);
        lbB.setText("B = " + mattriz[1][3]);
        lbC.setText("C = " + mattriz[2][3]);
    }
}
