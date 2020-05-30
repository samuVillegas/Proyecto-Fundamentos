// ***** Clase Principal *****
import java.util.Scanner;
import java.util.ArrayList;
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
                               "|   5) Registrar sensor.                                            |\n"+
                               "|   6) Mostrar información de sensores almacenados.                 |\n"+
                               "|   7) Mostrar la información de la cantitad de sensores creados.   |\n"+
                               "|   8) Mostrar por pantalla la información de todos los sesores de  |\n"+
                               "|      tipo temperatura.                                            |\n"+
                               "|   9) Mostrar por pantalla la información del vehiculo con mas     |\n"+
                               "|      sensores.                                                    |\n"+
                               "|  10) Cargar 5 vehiculos del archivo .txt.                         |\n"+                           
                               "| 666) Mostrar por pantalla la información de todos los sensores de |\n"+
                               "|      tipo temperatura ordenados por valor.                        |\n"+
                               "| 777) Añadir los vehiculos enlistados en carroya.com.              |\n"+
                               "|*******************************************************************|\n"+
                               "¿Que deseas hacer?: ");
            int ans = scan.nextInt();
            System.out.println();
            switch(ans){ 
                case 1:              
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

                break;
                case 6:
                
                    //Por alguna razon no entra al catch cuando ocurre el error.
                     try {
                      Vehiculo veh = Principal.ObtenerVehiculoPorId();
                      System.out.print("Ingrese el tipo de sensor: ");
                      String tipo = scan.next();
                      System.out.print("\nIngrese el valor del sensor: ");
                      double valor = scan.nextDouble();
                      veh.anadirSensor(new Sensor(tipo,valor));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("ERROR, id no valido");
                    }
                break;
                case 7:
                    //Saca error cuando no hay vehiculos, lo mismo con el caso 6.
                    ArrayList<Sensor> sensores = ObtenerVehiculoPorId().getSensores();
                    for (int i = 0; i < sensores.size(); i++) {
                        System.out.println(sensores.get(i).toString());
                    }
                break;
                case 8:
                     if(Vehiculo.cantidadVehiculos()!=0){
                        System.out.print(Principal.SensoresTemperatura(false));
                    }else{
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
                
                break;
                case 666:
                    
                   System.out.println(Principal.SensoresTemperatura(true));
                break;
                case 777:
                
                        carroYa();
                        System.out.println("Se han añadido los vehiculos enlisatados en la pagina web.");
                break;
                case 0:
                    System.out.println("\n_________________ Gracias __________________\n"+
                                         "|   Hecho por:                             |\n"+
                                         "| - Dixon Andres Calderon Ortega           |\n"+
                                         "| - Kevin Alejandro Sossa Chaverria        |\n"+
                                         "| - Samuel David Villegas Bedoya           |\n"+
                                         "'——————————————————————————————————————————'");
                    flag = false;   
                break;
                default:
                    System.out.print("Por favor ingresa un numero valido.");
                break;
            }
        }
  }
  public static Vehiculo ObtenerVehiculoPorId(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Ingrese el id del vehiculo a buscar");
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
  
  public static void carroYa(){
   /* String ruta= "https://www.carroya.com/buscar/vehiculos/medellin/t4c239.do";
        URL url = new URL (ruta);
        BufferedReader reader = new BufferedReader (new InputStreamReader(url.openStream()));
        String codigoFuente = "";
        String linea;
        while((linea = reader.readLine()) != null){
            codigoFuente = codigoFuente + linea;
        }
        reader.close();
    		
    
    		String keyMarca0 = "<h2 class=\"new-vehicle-heading-title\" itemprop=\"name\">";
				String keyMarca1 = " "; 
    
    		String keyModelo0 = "<span class=\"new-vehicle-model text-primary\">";
        String keyModelo1 = "</span>";

    		String keyValorComercial0 = "<div class=\"new-vehicle-price text-primary\" itemprop=\"price\">";
        String keyValorComercial1 = "</div>";
        
    		int i = 1;
    		while(codigoFuente.length()>0|| i == 0){
        i = codigoFuente.indexOf(keyValorComercial0)	
          if(i>0){
          i = i +keyMarca0.length();
          int j = codigoFuente.indexOf(keyMarca1, i);
          String marca = codigoFuente.substring(i, j);
          codigoFuente = codigoFuente.substring(j + keyMarca1.length());
            
          i = i +keyModelo0.length();
          int j = codigoFuente.indexOf(keyModelo1, i);
          String modelo = codigoFuente.substring(i, j);
          codigoFuente = codigoFuente.substring(j + keyModelo1.length());
            
          i = i +keyValorComercial0.length();
          int j = codigoFuente.indexOf(keyMarca1, i);
          String valorComercial = codigoFuente.substring(i, j);
          codigoFuente = codigoFuente.substring(j + keyValorComercial1.length());
          
            
          Vehiculo v = new Vehiculo(narca, modelo, valorComercial);
          
          }else{
          	break;
          }
          
        }*/
  }
  
  
 }  