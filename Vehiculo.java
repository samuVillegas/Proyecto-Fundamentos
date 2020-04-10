public class Vehiculo{
    
    public static Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    
    public Vehiculo(){
        
    }
    
    public Vehiculo(int mo, String ma, double va){
        this(mo,ma,va,"Verde");
    }
    
    public Vehiculo(int mo, String ma, double va, String co){
        //this.modelo=mo;
        //this.marca=ma;
        //this.valorComercial=va;
        //this.color=co;
        vehiculos[posAnadir].setModelo(mo);
        vehiculos[posAnadir].setMarca(ma);
        vehiculos[posAnadir].setValorComercial(va);
        vehiculos[posAnadir].setColor(co);
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
        return "Informacion Vehiculo: (Modelo: "+this.modelo+". Marca: "+
                this.marca+". Valor Comercial: "+this.valorComercial+
                ". Color: "+this.color+")";
    }
    
    public static String toStringVehiculos(Vehiculo[] v){
        String res="";
        for(int i=0; i<tamano; i++){
            res=v[i].toString()+"n/";
        }
        return res;
    }
    
    public static Vehiculo[] seleccionColor(Vehiculo[] v, String c){
        int cont = 0;
        Vehiculo [] seleccion;
        for(int i = 0; i < v.length; i++){
            if(v[i].getColor().equalsIgnoreCase(c)){
                cont++;
            }
        }
        seleccion = new Vehiculo [cont];
        cont = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i].getColor().equalsIgnoreCase(c)){
                seleccion[cont]=v[i];
                cont++; 
            }
        }        
        return seleccion;
    }
    
    public static int cantidadVehiculos(){
        return posAnadir;
    }
}
