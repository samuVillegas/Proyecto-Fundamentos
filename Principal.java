import java.util.Scanner;
public class Principal{
    public static void main(String [] Args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
      	boolean flag = true;
        while (flag){
            System.out.println("\n|******************************* MENÚ ******************************|\n"+
                               "¿Qué deseas hacer?\n"+
                               "Ingrese el numero de la opción a realizar\n"+
                               "  1) Registrar vehículo\n"+
                               "  2) Mostrar información de vehículos almacenados\n"+
                               "  3) Mostrar la información de la cantitad vehículos creadas\n"+
                               "  4) Mostrar por pantalla la información de todos los vehículos\n"+
                               "     de color Verde\n"+
                               "  5) Registrar sensor\n"+
                               "  6) Mostrar información de sensores almacenados\n"+
                               "  7) Mostrar la información de la cantitad de sensores creados\n"+
                               "  8) Mostrar por pantalla la información de todos los sesores de \n"+
                               "     tipo temperatura\n"+
                               "666) Mostrar por pantalla la información de todos los sesores de\n"+
                               "     tipo temperatura ordenados por valor\n"+
                               "  0) Salir del programa\n"+
                               "|********************************************************************|\n");
            int ans = scan.nextInt();
          	switch(ans){ 
                case 1:
                    if(Vehiculo.posAnadir<Vehiculo.tamano){
                        System.out.println("Ingrese las caracteristicas de su vehiculo:");
                        System.out.println("Modelo:");
                        int mo = scan.nextInt();
                        System.out.println("Marca:");
                        String ma = scan.next();
                        System.out.println("Valor Comercial: ");
                        double va = scan.nextDouble();
                        System.out.println("Color: ");
                        String co = scan.next();
                      	Vehiculo v = new Vehiculo(mo,ma,va,co);
                    }else{
                        System.out.println("SYSTEM ERROR: Base de datos llena");
                    }
                break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos(Vehiculo.vehiculos));
                break;
                case 3:
                    System.out.println(Vehiculo.cantidadVehiculos());
                break;
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos(Vehiculo.seleccionColor(Vehiculo.vehiculos,"Verde")));
                break;
                case 5:
                    if(Sensor.posAnadir<Sensor.tamano){
                        System.out.println("Ingrese las caracteristicas de su sensor:");
                        System.out.println("Tipo:");
                        String t = scan.next();
                        System.out.println("Valor: ");
                        double v = scan.nextDouble();
                        Sensor s = new Sensor(t,v);
                    }else{
                        System.out.println("SYSTEM ERROR: Base de datos llena");
                    }
                break;
                case 6:
                    System.out.println(Sensor.toStringSensores(Sensor.sensores));
                break;
                case 7:
                    System.out.println(Sensor.cantidadSensores());
                break;
              	case 8:
                     System.out.println(Sensor.toStringSensores(Sensor.seleccionTipo(Sensor.sensores,"Temperatura")));
                break;
                case 666:
                    System.out.println(Sensor.toStringSensores(Sensor.ordenar(Sensor.seleccionTipo(Sensor.sensores,"Temperatura"))));
                break;
                case 0:
                    flag = false;	
                break;
              	default:
                System.out.print("Por favor ingresa un numero valido");
                break;
            }
         	
        }
    }
}