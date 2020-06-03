import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.InputMismatchException;


public class Principal{
    public static void main(String[] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        
        while (flag){
            System.out.print("\n________________________________ MENÚ ______________________________\n"+
                               "| Ingrese el numero de la opción a realizar:                        |\n"+
                               "|   0) Salir del programa.                                          |\n"+
                               "|   1) Registrar vehículo.                                          |\n"+
                               "|   2) Mostrar información de los vehículos almacenados.            |\n"+
                               "|   3) Mostrar la información de la cantitad vehículos creados.     |\n"+
                               "|   4) Mostrar por pantalla la información de todos los vehículos   |\n"+
                               "|      de color Verde.                                              |\n"+
                               "|   5) Mostrar informacion de vehiculo segun su Id.                 |\n"+
                               "|   6) Añadir sensor a vehiculo especifico.                         |\n"+
                               "|   7) Mostrar sensores de un vehiculo especifico.                  |\n"+
                               "|   8) Mostrar por pantalla la información de todos los sesores de  |\n"+
                               "|      tipo temperatura.                                            |\n"+
                               "|   9) Mostrar por pantalla la información del vehiculo con mas     |\n"+
                               "|      sensores.                                                    |\n"+
                               "|  10) Cargar 5 vehiculos del archivo .txt.                         |\n"+                           
                               "| 666) Mostrar por pantalla la información de todos los sensores de |\n"+
                               "|      tipo temperatura ordenados por valor.                        |\n"+
                               "| 777) Añadir los vehiculos enlistados en carroya.com.              |\n"+
                               "'———————————————————————————————————————————————————————————————————'\n"+
                               "¿Que deseas hacer?: ");
            try{
            int ans = scan.nextInt();
            System.out.println();
            switch(ans){
                case 0:
                    System.out.println("\n_________________ Gracias __________________\n"+
                                         "|   Hecho por:                             |\n"+
                                         "| - Dixon Andres Calderon Ortega           |\n"+
                                         "| - Kevin Alejandro Sossa Chaverria        |\n"+
                                         "| - Samuel David Villegas Bedoya           |\n"+
                                         "'——————————————————————————————————————————'");
                    flag = false;   
                break;
                case 1: 
                    try{
                        System.out.println("Ingrese las caracteristicas de su vehiculo");
                        System.out.print("Modelo: ");
                        int mo = scan.nextInt();
                        System.out.print("Marca: ");
                        String ma = scan.next();
                        System.out.print("Valor Comercial: ");
                        double va = scan.nextDouble();
                        System.out.print("Color: ");
                        String co = scan.next();
                        Vehiculo v = new Vehiculo(mo,ma,va,co);
                    }catch (Exception e ){
                    
                    
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
                    try {
                        System.out.println(ObtenerVehiculoPorId().toString());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("ERROR, id no valido");
                    }
                break;
                case 6:
                    try {
                        Vehiculo veh = Principal.ObtenerVehiculoPorId();
                        System.out.print("Ingrese el tipo de sensor: ");
                        String tipo = scan.next();
                        System.out.print("Ingrese el valor del sensor: ");
                        double valor = scan.nextDouble();
                        veh.anadirSensor(new Sensor(tipo,valor));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("ERROR, id no valido");
                    }
                break;
                case 7:
                    try {
                        ArrayList<Sensor> sensores = ObtenerVehiculoPorId().getSensores();
                        if (sensores.size() > 0) {
                            for (int i = 0; i < sensores.size(); i++) {
                                System.out.println(sensores.get(i).toString());
                            }
                        }else {
                            System.out.println( "\n|***** No hay sensores agregados. *****|\n"); 
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("ERROR, id no valido");
                    }
                break;
                case 8:
                    if(Vehiculo.cantidadVehiculos()!=0){
                        System.out.print(Principal.SensoresTemperatura(false));
                    }else {
                        System.out.println( "\n|*****No hay vehiculos agregados. *****|\n"); 
                    }
                break;
                case 9:
                    if(Vehiculo.cantidadVehiculos()!=0){
                        System.out.print(Principal.MasSensores());
                    }else{
                        System.out.println( "\n|*****No hay vehiculos agregados. *****|\n"); 
                    }
                break;
                case 10:
                    leerTxt();
                break;
                case 666:
                   System.out.println(Principal.SensoresTemperatura(true));
                break;
                case 777:
                    carroYa();
                    System.out.println("Se han añadido los vehiculos enlisatados en la pagina web.");
                break;
                default:
                    System.out.print("Por favor ingresa un numero valido.");
                break;
            }
          }catch(InputMismatchException e){
                System.out.println("ERROR, Ingresaste un dato invalido");
                scan.nextLine();
          }
        }
    }
    public static Vehiculo ObtenerVehiculoPorId(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el id del vehiculo: ");
        int id = scan.nextInt();
        return Vehiculo.vehiculos.get(id-1);
    }


    public static String SensoresTemperatura(boolean val ){
        String text = "";
        ArrayList<Sensor> sensores = new ArrayList<>();
        
        for (Vehiculo vehiculo: Vehiculo.vehiculos){
            int cant = vehiculo.cantidadSensores(); 
            if(cant != 0){
                for (Sensor sensor: vehiculo.getSensores()){
                    if(sensor.getTipo().equalsIgnoreCase("temperatura")){
                        sensores.add(sensor);
                    } 
                }      
            }             
        } 
        if(!sensores.isEmpty()){
            if(val){
                Sensor temp;
                int n = sensores.size();
                
                for(int i=1; i<n;i++){
                    for(int j =0; j<n-1;j++){
                        if(sensores.get(j).getValor()>sensores.get(j+1).getValor()){
                            temp = sensores.get(j);
                            sensores.set(j,sensores.get(j+1));
                            sensores.set(j+1,temp);     
                        }
                    }   
                }
            }
            for(Sensor sensor: sensores){
                text+=sensor.toString()+"\n";
            }
        }else{
            text="\n|*****No hay sensores por mostrar. *****|\n";
        }      
        return text;
    }
    
    public static String MasSensores(){
        String text = "\n|*****Los vehiculos no tienen sensores. *****|\n";
        int mas = -1;
        for(Vehiculo vehiculo: Vehiculo.vehiculos ){
            if(vehiculo.cantidadSensores()>mas){
                mas = vehiculo.cantidadSensores();
                text = vehiculo.toString();
            } 
        }   
        return text;
    }
    
    public static void leerTxt(){
        File file = new File("vehiculos.txt");
        try {
            Scanner txt = new Scanner(file);
            while (txt.hasNextLine()) {
                String line[] = txt.nextLine().split(",");
                new Vehiculo(Integer.parseInt(line[0]),line[1],Double.parseDouble(line[2]),line[3]);
            }
            System.out.println("Vehiculos cargados correctamente");
        } catch (Exception e) {
            System.out.println("No pude leer el txt");
        }
    }

    public static void carroYa(){
           try {
           String ruta= "https://www.carroya.com/buscar/vehiculos/t4d2c239.do";
           URL url = new URL (ruta);
           BufferedReader reader = new BufferedReader (new InputStreamReader(url.openStream()));
           String codigoFuente = "";
           String linea;
           String cad="";
           while((linea = reader.readLine()) != null){
               codigoFuente += linea;
           }         
           reader.close();
           
            //Busqueda
            int com,fin,modelo;
            String marca;
            double valor;
            int key = codigoFuente.indexOf("div class=\"imagenconten\"");      
            String KEY0 ="data-price=\"";
            String KEY1 ="data-brand=\"";
            String KEY2 ="data-ano=\"";
            String KEYFINAL="\"";
            while(true){
                com =codigoFuente.indexOf(KEY0,key)+KEY0.length();
                fin =codigoFuente.indexOf(KEYFINAL,com);
                valor = Double.parseDouble(codigoFuente.substring(com,fin));
               
                com = codigoFuente.indexOf(KEY1,key)+KEY1.length();
                fin = codigoFuente.indexOf(KEYFINAL,com);       
                marca = codigoFuente.substring(com,fin); 
                
                com =codigoFuente.indexOf(KEY2,key)+KEY2.length();
                fin =codigoFuente.indexOf(KEYFINAL,com);       
                modelo = Integer.parseInt(codigoFuente.substring(com, fin));
                
                Vehiculo v = new Vehiculo(modelo,marca,valor);
                
                key = codigoFuente.indexOf("div class=\"imagenconten\"",fin);
            
           if(key==-1){
                break;
           }
       } 
           
           
           
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}  