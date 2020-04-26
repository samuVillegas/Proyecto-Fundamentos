public class Vehiculo{
    
    public static Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    
    public Vehiculo(){
        Vehiculo.vehiculos[posAnadir] = this;
        posAnadir++;
    }
    
    public Vehiculo(int mo, String ma, double va){
        this(mo,ma,va,"Verde");
    }
    
    public Vehiculo(int mo, String ma, double va, String co){
        this.modelo=mo;
        this.marca=ma;
        this.valorComercial=va;
        this.color=co;
        Vehiculo.vehiculos[posAnadir] = this;
        posAnadir++;
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
        return color;
    }
    
    public String toString(){
        return "|*****Informacion Vehiculo *****|\n"+
               " Modelo: "+this.modelo+
               "\n Marca: "+this.marca+
               "\n Valor Comercial: "+this.valorComercial+
               "\n Color: "+this.color;
    }
    
    public static String toStringVehiculos(String c){
        String res="";
        if(posAnadir == 0){
                res = "\n|*****No hay vehículos por mostrar. *****|\n";
        }else if(c.equalsIgnoreCase("all")){
            for(int i = 0; i < Vehiculo.vehiculos.length; i++){
                if (Vehiculo.vehiculos[i]!=null) {
                    res += Vehiculo.vehiculos[i].toString()+"\n";
                }else{
                    break;
                }
            }
        }else{
            for(int i = 0; i < Vehiculo.vehiculos.length; i++){
                if (Vehiculo.vehiculos[i]!=null) {
                    if(Vehiculo.vehiculos[i].getColor().equalsIgnoreCase(c)){
                        res += Vehiculo.vehiculos[i].toString()+"\n";
                    }
                }else{
                    break;
                }
            }
        }
        return res;
    }
    
    public static int cantidadVehiculos(){
        return posAnadir;
    }
}
