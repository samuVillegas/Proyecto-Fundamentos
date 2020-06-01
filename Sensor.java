  // ***** Clase Sensor *****
public class Sensor{
    private String tipo;
    private double valor;
  
    public Sensor(){
        this("",0);
    }
  
    public Sensor(String t, double v){
        this.tipo = t;
        this.valor = v;
    }
  
    public String toString(){
        return String.format("_________________________\n"+
                             "| Tipo: %-16s|\n"+
                             "| Valor: %-15s|\n"+
                             "'———————————————————————'",tipo,valor);
    }
  
    public void setTipo(String t){
        this.tipo = t;
    }
  
    public void setValor(double v){
        this.valor = v;
    }
  
    public String getTipo(){
        return tipo;
    }
  
    public double getValor(){
        return valor;
    }
}