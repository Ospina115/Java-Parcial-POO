/*
la caja de la entidad Dx dedicada a realizar examenes de diagnosticos a los afiliados de tres EPS requiere calcular el valor a pagar por un examen teniendo en cuenta:
- el afiliado a la EPS "HASTA MORIR" de nivel 1 cancela el 50% del precio del examen y los de nivel 2 el 70%
- el afiliado a la EPS "PIOR ES NA" de categoria "A" cancela el 55% del precio del examen y los de categoria "B" el 60%
- el afiliado a la EPS "DE GUATEMALA PA' GUATEPIOR" con salario hasta 2 smlv (smlv=1300000) cancela el 40% del precio del examen y los demas afiliados el 65%.

los afiliados a las EPS pueden ser de tipo COTIZANTE o BENEFICIARIO. todos los afiliados del tipo COTIZANTE tienen un 5% de descuento adicional que se calcula sobre el precio inicial del examen

Afiliado = nombre, tipoAfiliado, neeto, smls, valorPagar(), descuento(), presentarPagar() 
 */
package model;

import javax.swing.JOptionPane;
import parcial1corte.Parcial1Corte;

/**
 *
 * @author aula9
 */
public class Afiliado {
    private String nombre;
    private String tipoAfiliado;
    private int neto;
    private int smls;
    private double valorPagar;
    private double descuento;

    public Afiliado(String nombre, String tipoAfiliado, int neto, int smls) {
        this.nombre = nombre;
        this.tipoAfiliado = tipoAfiliado;
        this.neto = neto;
        this.smls = smls;
        this.valorPagar = calcularValorPagar();
        this.descuento = calcularDescuento();
    }

    private double calcularValorPagar() {
        double valorPagar = neto;
        if (tipoAfiliado.equals("HASTA MORIR")) {
            if (neto == 1) {
                valorPagar *= 0.5;
            } else if (neto == 2) {
                valorPagar *= 0.3;
            }
        } else if (tipoAfiliado.equals("PIOR ES NA")) {
            if (neto == 1) {
                valorPagar *= 0.45;
            } else if (neto == 2) {
                valorPagar *= 0.4;
            }
        } else if (tipoAfiliado.equals("DE GUATEMALA PA' GUATEPIOR")) {
            if (smls <= 2 * 1300000) {
                valorPagar *= 0.6;
            } else {
                valorPagar *= 0.35;
            }
        }
        return valorPagar;
    }

    private double calcularDescuento() {
        if (tipoAfiliado.equals("COTIZANTE")) {
            return neto * 0.05;
        } else {
            return 0;
        }
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public double getDescuento() {
        return descuento;
    }

    public void presentarPagar() {
        JOptionPane.showMessageDialog(null, "El valor a pagar es: " + valorPagar + "\nCon un descuento de: " + descuento);
    }
}
