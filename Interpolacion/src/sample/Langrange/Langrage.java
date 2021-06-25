package sample.Langrange;

import sample.principal.Controller;

import java.text.DecimalFormat;

public class Langrage {
    double x0,x1,x2,y0,y1,y2;
    double iteXX1, iteXX2, iteXX3;
    double iteX1, iteX2, iteX3;
    double iteVind1, iteVind2, iteVind3;
    double divisor1, divisor2, divisor3;
    double multiplicador1, multiplicador2, multiplicador3;
    double iteXX1new, iteXX2new, iteXX3new;
    double iteX1new, iteX2new, iteX3new;
    double iteVind1new, iteVind2new, iteVind3new;
    double pxXX, pxX, pxVind;
    public Langrage(double x0, double x1, double x2, double y0, double y1, double y2) {
        DecimalFormat format = new DecimalFormat("####");
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.y0 = y0;
        this.y1 = y1;
        this.y2 = y2;
        Controller controller = new Controller();
        /*Formula sin algebra ------------------------------------------------------------------------------------------
        ite1 = ((x-x1)*(x-x2)) / ((x0*x1)*(x0-x2));
        ite2 = ((x-x0)*(x-x2)) / ((x1*x0)*(x1-x2));
        ite3 = ((x-x0)*(x-x1)) / ((x2-x0)*(x2-x1));
        px = (ite1*y0)+(ite2*y1)+(ite3*y2);
        controller.yLangrange = px;*/
        //Intento de formu2la con algebra jeje---------------------------------------------------------------------------

        //Iteracion1
        System.out.println("iteracion 1");
        iteXX1 = 1;
        System.out.print(iteXX1 + " + ");
        iteX1 = ((-1*x2) + (-1 *x1));
        System.out.print(iteX1 + " + ");
        iteVind1 = (x1 * x2);
        System.out.print(iteVind1 + " / ");
        divisor1 = (x0 - x1) * (x0 - x2);
        System.out.println(divisor1);
        multiplicador1 = y0 / divisor1;
        iteXX1new = multiplicador1 * iteXX1;
        iteX1new  = multiplicador1 * iteX1;
        iteVind1new = multiplicador1 * iteVind1;

        //Iteracion2
        System.out.println("iteracion 2");
        iteXX2 = 1;
        System.out.print(iteXX2 + " + ");
        iteX2 = (-x2 + -x0);
        System.out.print(iteX2 + " + ");
        iteVind2 = (x0 * x2);
        System.out.print(iteVind2 + " / ");
        divisor2 = (x1 - x0) * (x1 - x2);
        System.out.println(divisor2);
        multiplicador2 = y1 / divisor2;
        iteXX2new = multiplicador2 * iteXX2;
        iteX2new  = multiplicador2 * iteX2;
        iteVind2new = multiplicador2 * iteVind2;

        //Iteracion3
        System.out.println("iteracion 3");
        iteXX3 = 1;
        System.out.print(iteXX3 + " + ");
        iteX3 = (-x1 + -x0);
        System.out.print(iteX3 + " + ");
        iteVind3 = (x0 * x1);
        System.out.print(iteVind3 + " / ");
        divisor3 = (x2 - x0) * (x2 - x1);
        System.out.print(divisor3);
        multiplicador3 = y2 / divisor3;
        iteXX3new = multiplicador3 * iteXX3;
        iteX3new  = multiplicador3 * iteX3;
        iteVind3new = multiplicador3 * iteVind3;

        //Suma de x^2, x y valores independientes
        pxXX = iteXX1new + iteXX2new + iteXX3new;
        pxX = iteX1new + iteX2new + iteX3new;
        pxVind = iteVind1new + iteVind2new + iteVind3new;

        //Formula escrita :D
        controller.lbE.setText("(" + format.format(pxXX) + ") * (X^2) + (" + format.format(pxX) + ") * (X) + (" + format.format(pxVind)+")");
    }
}
