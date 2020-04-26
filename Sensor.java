    public class Sensor{
        
        public static Sensor[] sensores = new Sensor[8];
        public static int tamano = 8;
        public static int posAnadir = 0;
        private String tipo;
        private double valor;
        
        public Sensor(){
            
        }
        
        public Sensor(String t, double v){
            this.tipo=t;
            this.valor=v;
            sensores[posAnadir]=this;
            posAnadir++;
        }
        
        public void setTipo(String t){
            this.tipo=t;
        }
        
        public String getTipo(){
            return tipo;
        }
        
        public void setValor(double v){
            this.valor=v;
        }
        
        public double getValor(){
            return valor;
        }
        
        public String toString(){
            return "|***** Informacion Sensor *****|\n"+
                   " Tipo: "+this.tipo+
                   " \n Valor: "+this.valor;
        }
        
        public static String toStringSensores(String t){
            String res="";
            if(posAnadir==0){
                res = "\n|*****No hay sensores por mostrar. *****|\n";
            }else if(t.equalsIgnoreCase("all")){
                for(int i=0; i<Sensor.sensores.length; i++){
                    if (Sensor.sensores[i]!=null) {
                        res+=Sensor.sensores[i].toString()+"\n";
                    }else{
                        break;
                    }
                }
            }else if(t.equalsIgnoreCase("ord")){
                Sensor SensoresOrd[] = Sensor.ordenar();
                for(int i = 0; i < Sensor.posAnadir; i++){
                    if (Sensor.sensores[i]!=null) {
                        if(Sensor.sensores[i].getTipo().equalsIgnoreCase("temperatura")){
                            res += Sensor.sensores[i].toString()+"\n";
                        }
                    }else{
                        break;
                    }
                }
            }else{
                for(int i = 0; i < Sensor.sensores.length; i++){
                    if (Sensor.sensores[i]!=null) {
                        if(Sensor.sensores[i].getTipo().equalsIgnoreCase(t)){
                            res += Sensor.sensores[i].toString()+"\n";
                        }
                    }else{
                        break;
                    }
                }
            }
            return res;
        }
        
        public static Sensor[] ordenar(){
            Sensor [] SensoresOrd = Sensor.sensores;
            int n = Sensor.posAnadir;
            for (int i = 0; i < n - 1; i++){
                Sensor temp;
                for (int j = 0; j < n - 1 - i; j++){
                    if (SensoresOrd[j].getValor() > SensoresOrd[j+1].getValor()) {
                        temp = SensoresOrd[j+1];
                        SensoresOrd[j+1] = SensoresOrd[j];
                        SensoresOrd[j] = temp;
                    }
                }
            }
            return SensoresOrd;
        }
        
        public static int cantidadSensores(){
            return posAnadir;
        }
}
