import java.util.Scanner;
public class Principal{
    public static void main(String [] Args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.print("\n|******************************* MENÚ ******************************|\n"+
                               "| Ingrese el numero de la opción a realizar:                        |\n"+
                               "|   1) Registrar vehículo.                                          |\n"+
                               "|   2) Mostrar información de los vehículos almacenados.            |\n"+
                               "|   3) Mostrar la información de la cantitad vehículos creados.     |\n"+
                               "|   4) Mostrar por pantalla la información de todos los vehículos   |\n"+
                               "|      de color Verde.                                              |\n"+
                               "|   5) Registrar sensor.                                            |\n"+
                               "|   6) Mostrar información de sensores almacenados.                 |\n"+
                               "|   7) Mostrar la información de la cantitad de sensores creados.   |\n"+
                               "|   8) Mostrar por pantalla la información de todos los sesores de  |\n"+
                               "|      tipo temperatura.                                            |\n"+
                               "| 666) Mostrar por pantalla la información de todos los sensores de |\n"+
                               "|      tipo temperatura ordenados por valor.                        |\n"+
                               "|   0) Salir del programa.                                          |\n"+
                               "|*******************************************************************|\n"+
                               "¿Que deseas hacer?: ");
            int ans = scan.nextInt();
            System.out.println();
            switch(ans){ 
                case 1:
                    if(Vehiculo.posAnadir<Vehiculo.tamano){
                        System.out.println("Ingrese las caracteristicas de su vehiculo");
                        System.out.print("Modelo:");
                        int mo = scan.nextInt();
                        System.out.print("\nMarca:");
                        String ma = scan.next();
                        System.out.print("\nValor Comercial: ");
                        double va = scan.nextDouble();
                        System.out.println("Color: ");
                        String co = scan.next();
                        Vehiculo v = new Vehiculo(mo,ma,va,co);
                    }else{
                        System.out.println("SYSTEM ERROR: Base de datos llena.");
                    }
                break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos("all"));
                break;
                case 3:
                    System.out.println("Cantidad vehiculos: "+Vehiculo.cantidadVehiculos());
                break;
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos("verde"));
                break;
                case 5:
                    if(Sensor.posAnadir<Sensor.tamano){
                        System.out.println("Ingrese las caracteristicas de su sensor.");
                        System.out.println("Tipo:");
                        String t = scan.next();
                        System.out.println("Valor: ");
                        double v = scan.nextDouble();
                        Sensor s = new Sensor(t,v);
                    }else{
                        System.out.println("SYSTEM ERROR: Base de datos llena.");
                    }
                break;
                case 6:
                    System.out.println(Sensor.toStringSensores("all"));
                break;
                case 7:
                    System.out.println("Cantidad sensores: "+Sensor.cantidadSensores());
                break;
                case 8:
                     System.out.println(Sensor.toStringSensores("Temperatura"));
                break;
                case 666:
                    System.out.println(Sensor.toStringSensores("ord"));
                break;
                case 0:
                    System.out.println("\n|**************** Gracias *****************|\n"+
                                         "|   Hecho por:                             |\n"+
                                         "| - Dixon Andres Calderon Ortega           |\n"+
                                         "| - Kevin Alejandro Sossa Chaverria        |\n"+
                                         "| - Samuel David Villegas Bedoya           |\n"+
                                         "|******************************************|");
                    flag = false;   
                break;
                default:
                    System.out.print("Por favor ingresa un numero valido.");
                break;
            }
        }
    }
}