package sample;

import org.nfunk.jep.JEP;

public class Funciones {
    private String funcion = "";
    private double resultado = 0;
    private double valorx = 0;
    private String error = "";
    public int cont = 0;
    JEP jep;

    public Funciones(){ }
    public void setFuncion(String funcion){this.funcion = funcion;}
    public void setValorx(double valorx){this.valorx = valorx;}
    public double getResultadoFuncion(){return this.resultado;}
    public String getError(){ cont++; return this.error;}

    public void evaluar(){
        jep = new JEP();
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorx);
        this.jep.parseExpression(this.funcion);
        this.resultado = this.jep.getValue();

        this.error = (this.jep.hasError())? "Existe un error." : "No hay error";
    }
}
