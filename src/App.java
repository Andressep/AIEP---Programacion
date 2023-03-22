import java.util.Scanner;
/**
 * @author Andres Sepulveda
 **/

public class App {

    private static int sueldoBruto(int horasNormales, int horasExtras) {
        int sueldoBruto = horasNormales*5000 + horasExtras*7000;
        return sueldoBruto;
    }
    private static int bonoMarzo(int sueldoBruto) {
        if ( sueldoBruto >= 200.000 ) {
            return (int) (sueldoBruto*0.20);
        }
        else {
            return (int) (sueldoBruto*0.15);
        } 
    }
    private static int descuentosAFP(int sueldoBruto, int afp) {
        int descuentos = 0;
        if( afp == 1) {
            return descuentos = (int) (sueldoBruto*0.07);
        }
        if (afp == 2) { 
            return descuentos = (int) (sueldoBruto*0.09);
        }
        if (afp == 3) { 
            return descuentos = (int) (sueldoBruto*0.12);
        }
        if (afp == 4) { 
            return descuentos = (int) (sueldoBruto*0.13);
        }
        else {
            System.out.println("Ingrese un valor valido.");
        }
        return descuentos;
    }
    private static int descuentosMedicos(int sueldoBruto, int medico) {
        int descuentos = 0;
        if( medico == 1) {
            return descuentos = (int) (sueldoBruto*0.12);
        }
        if (medico == 2) { 
            return descuentos = (int) (sueldoBruto*0.13);
        }
        if (medico == 3) { 
            return descuentos = (int) (sueldoBruto*0.14);
        }
        if (medico == 4) { 
            return descuentos = (int) (sueldoBruto*0.15);
        }
        else {
            System.out.println("Ingrese un valor valido.");
        }
        return descuentos;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isFuncionando = false;
        boolean isValido = false;
        int descuentosAFP = 0;
        int descuentosMedicos = 0;

        while(!isFuncionando) {
            System.out.println("Ingrese el numero de horas trabajadas este mes: ");
            int normales = scanner.nextInt();
            System.out.println("Ingrese cuantas horas extras realizo este mes:");
            int extras = scanner.nextInt();

            System.out.println("Usted trabajo: " + normales + " horas y realizo: " + extras + " horas extras.");
            System.out.println("El sueldo bruto de este mes es de: " + sueldoBruto(normales, extras));
            System.out.println("El bono de marzo es de: " + bonoMarzo(sueldoBruto(normales, extras)));

            while(!isValido) {
                System.out.println("""
                    Seleccione la AFP en la cual usted se encuentre inscrito:

                        1. CUPRUM 7%
                        2. MODELO 9%
                        3. CAPITAL 12%
                        4. PROVIDA 13%
                    """);
                int afp = scanner.nextInt();
                System.out.println("""
                    Seleccione el sistema de salud en el cual usted se encuentre inscrito:
        
                        1. FONASA 12%
                        2. CONSALUD 13%
                        3. MASVIDA 14%
                        4. BANMEDICA 15%
                    """);
                    int medico = scanner.nextInt();
                if ( afp >= 1 && afp <= 4 && medico >= 0 && medico <= 4 ) {
                        isValido = true;
                        descuentosAFP = descuentosAFP(sueldoBruto(normales, extras), afp);
                        descuentosMedicos = descuentosMedicos(sueldoBruto(normales, extras), medico);
                        break;
                }
                else {
                    System.out.println("Escriba la opcion dentro del rango de 1 - 4.");
                }
            }
            scanner.close();
            System.out.println("Descuentos de afp: " + descuentosAFP);
            System.out.println("Descuentos de medico: " + descuentosMedicos);
            int descuentos = descuentosAFP + descuentosMedicos;
            int sueldoRecibido = (sueldoBruto(normales, extras) + bonoMarzo(sueldoBruto(normales, extras))) - descuentos ;

            System.out.println("El pago total de sus servicios este mes es de: " + sueldoRecibido);
            isFuncionando = true;
        }
    }
}
