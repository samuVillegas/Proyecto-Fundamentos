import java.util.Scanner;
public class Principal{
    public static void main(String [] Args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        do{
            switch(i){
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
                        Vehiculo.vehiculos[Vehiculo.posAnadir]=new Vehiculo(mo,ma,va,co);
                    }else{
                        System.out.println("ERROR: Base de datos llena");
                    }
                break;
                      
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos(Vehiculo.vehiculos));
                    
                break;
                
                case 3:
                    for(int j=0; i<Vehiculo.posAnadir; i++){
                        System.out.println(Vehiculo.vehiculos[j].toString()+"\n");
                    }
                break;
                
                case 4:
                    Vehiculo[] res4 = Vehiculo.seleccionColor(Vehiculo.vehiculos, "Verde");
                    for(int j=0; i<res4.length; i++){
                        System.out.println(res4[j].toString()+"\n");
                    }
                break;
                
                case 5:
                    if(Sensor.posAnadir<Sensor.tamano){
                        System.out.println("Ingrese las caracteristicas de su sensor:");
                        
                        System.out.println("Tipo:");
                        String t = scan.next();
                        System.out.println("Valor: ");
                        double v = scan.nextDouble();
                        Sensor s= new Sensor(t,v); //No se como hacer para que
                                                   //cada vez se le cambie el 
                                                   //nombre x2
                        Sensor.sensores[Sensor.posAnadir]=new Sensor(t,v);
                    }else{
                        System.out.println("ERROR: Base de datos llena");
                    }
                break;
                
                case 6:
                    System.out.println(Sensor.toStringSensores(Sensor.sensores));
                break;
                
                case 7:
                    for(int j=0; i<Sensor.posAnadir; i++){
                        System.out.println(Sensor.sensores[j].toString()+"\n");
                    }
                break;
                
                case 8:
                    Sensor[] res8 = Sensor.seleccionTipo(Sensor.sensores, "Temperatura");
                    for(int j=0; i<res8.length; i++){
                        System.out.println(res8[j].toString()+"\n");
                    }
                break;
                
                case 666:
                    Sensor[] res666 = Sensor.ordenar(Sensor.seleccionTipo(Sensor.sensores, "Temperatura"));
                    for(int j=0; i<res666.length; i++){
                        System.out.println(res666[j].toString()+"\n");
                    }
                break;
                
                default:
                    System.out.println("Ingrese un numero valido");
                break;
            }
            i = scan.nextInt();
        }while(i!=0);
    }

}