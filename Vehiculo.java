import java.util.ArrayList;
public class Vehiculo {
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>(); 
    private ArrayList<Sensor> sensores = new ArrayList<>(); 
    public static int idActual = 1;
    private int id;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    
    public Vehiculo(){
        this.id=idActual;
        vehiculos.add(this);
        idActual++;
    }
      
    public Vehiculo(int mo, String ma, double va){
        this(mo,ma,va,"Verde");
    }
    
    public Vehiculo(int mo, String ma, double va, String co){
        this.modelo=mo;
        this.marca=ma;
        this.valorComercial=va;
        this.color=co;
        this.id=idActual;
        idActual++;
        vehiculos.add(this);
    }
    
    public void setModelo(int mo){
        this.modelo=mo;
    }
        
    public int getModelo(){
        return modelo;
    }
        
    public void setMarca(String ma){
        this.marca=ma;
    }
        
    public String getMarca(){
        return marca;
    }
        
    public void setValorComercial(double va){
        this.valorComercial=va;
    }
        
    public double getValorComercial(){
        return valorComercial;
    }
        
    public void setColor(String co){
        this.color=co;
    }
        
    public String getColor(){
        return this.color;
    }
      
    public void setId(int id){
        this.id=id;
    }
        
    public int getId(){
        return this.id;
    }
      
    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }
      
    public void setSensores(ArrayList sen){
        this.sensores=sen;
    }
     
    public String toString(){
        String text = "";
        text = String.format("__________ Informacion Vehiculo __________ \n"+
                             "| Modelo: %-32s|\n"+
                                     "| Marca: %-33s|\n"+
                                     "| Valor Comercial: %-23s|\n"+
                                     "| Color: %-33s|\n"+
                             "'—————————————————————————————————————————'\n",this.modelo,this.marca,this.valorComercial,this.color)+
                             " *********** Lista de sensores *********** \n";
        for (Sensor sensor: this.sensores){
            text+= sensor.toString()+"\n";
        }
        return text;
    }
      
    public static String toStringVehiculos(String c){
        String text = "";
        if(Vehiculo.vehiculos.size()==0){
            text = "\n|*****No hay vehiculos por mostrar. *****|\n";   
        }else if(c.equalsIgnoreCase("all")){
            for (Vehiculo vehiculo: Vehiculo.vehiculos){
                text += vehiculo.toString()+"\n";
            }   
        }else{
            for (Vehiculo vehiculo: Vehiculo.vehiculos){
                if(vehiculo.getColor().equalsIgnoreCase(c)){
                    text += vehiculo.toString()+"\n";
                }
            }       
        }
        if (text.equalsIgnoreCase("")) {
            return "\n|*****No hay vehiculos por mostrar. *****|\n";
        }else {
            return text;
        }
    }
    
    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }
  
    public int cantidadSensores(){
        return this.sensores.size();
    }
  
    public void anadirSensor(Sensor sensor){
        this.sensores.add(sensor);
    }
}