/*
la caja de la entidad Dx dedicada a realizar examenes de diagnosticos a los afiliados de tres EPS requiere calcular el valor a pagar por un examen teniendo en cuenta:
- el afiliado a la EPS "HASTA MORIR" de nivel 1 cancela el 50% del precio del examen y los de nivel 2 el 70%
- el afiliado a la EPS "PIOR ES NA" de categoria "A" cancela el 55% del precio del examen y los de categoria "B" el 60%
- el afiliado a la EPS "DE GUATEMALA PA' GUATEPIOR" con salario hasta 2 smlv (smlv=1300000) cancela el 40% del precio del examen y los demas afiliados el 65%.

los afiliados a las EPS pueden ser de tipo COTIZANTE o BENEFICIARIO. todos los afiliados del tipo COTIZANTE tienen un 5% de descuento adicional que se calcula sobre el precio inicial del examen

Afiliado = nombre, tipoAfiliado, neeto, smls, valorPagar(), descuento(), presentarPagar() 
 */
package parcial1corte;

import javax.swing.JOptionPane;
import model.Afiliado;
/**
 *
 * @author aula9
 */
public class Parcial1Corte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String nombre = JOptionPane.showInputDialog("Bienvenido", "Ingresa tu Nombre");
        int neto = Integer.parseInt(JOptionPane.showInputDialog(nombre + " ¿Cual es el valor de tu examen? ", "Ingrese un valor"));

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Cual es tu eps?\n 1) HASTA MORIR\n 2) PIOR ES NA\n 3) DE GUATEMALA PA` GUATEPIOR", "Ingrese un numero"));
        } while (opcion != 1 && opcion != 2 && opcion != 3);

        String tipoAfiliado;
        int smls = 0;
        
        if (opcion == 1) {
            int nivel;
            do {
                nivel = Integer.parseInt(JOptionPane.showInputDialog("*HASTA MORIR*\n ¿Que nivel eres?\n 1) Nivel Uno\n 2) Nivel Dos", "Ingrese un numero"));
            } while (nivel != 1 && nivel != 2);
            tipoAfiliado = "HASTA MORIR";
            neto = nivel;
        } else if (opcion == 2) {
            int categoria;
            do {
                categoria = Integer.parseInt(JOptionPane.showInputDialog("*PIOR ES NA*\n ¿Que categoria eres?\n 1) Categoria A\n 2) Categoria B", "Ingrese un numero"));
            } while (categoria != 1 && categoria != 2);
            tipoAfiliado = "PIOR ES NA";
            neto = categoria;
        } else {
            smls = Integer.parseInt(JOptionPane.showInputDialog("*DE GUATEMALA PA' GUATEPIOR*\n ¿Cual es tu salario?", "Ingrese un Valor"));
            tipoAfiliado = "DE GUATEMALA PA' GUATEPIOR";
        }

        String tipo;
        do {
            tipo = JOptionPane.showInputDialog("¿Cual es tu tipo de afiliado?\n 1) COTIZANTE\n 2) BENEFICIARIO", "Ingrese un numero");
        } while (!tipo.equals("1") && !tipo.equals("2"));
        tipoAfiliado += " " + (tipo.equals("1") ? "COTIZANTE" : "BENEFICIARIO");
        
        Afiliado afiliado = new Afiliado(nombre, tipoAfiliado, neto, smls);
        afiliado.presentarPagar();     
    }
}
    
