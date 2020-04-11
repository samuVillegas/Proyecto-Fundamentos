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
            //sensores[posAnadir].setTipo(t);
            //sensores[posAnadir].setValor(v);
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
            return "Informacion Sensor: (Tipo: "+this.tipo+". Valor: "+
                    this.valor+")";
        }
        
        public static String toStringSensores(Sensor[] s){
            String res="";
            for(int i=0; i<tamano; i++){
                res=s[i].toString()+"n/";
            }
            return res;
        }
        
        public static Sensor[] seleccionTipo(Sensor[] s, String t){
            int cont = 0;
            int j = 0;
            Sensor [] seleccion;
            for(int i = 0; i < s.length; i++){
                if(s[i].getTipo().equalsIgnoreCase(t)){
                    cont++;
                }
            }
            seleccion = new Sensor [cont];
            for(int i = 0; i < s.length; i++){
                if(s[i].getTipo().equalsIgnoreCase(t)){
                    seleccion[j]=s[i];
                    j++; 
                }
            }        
            return seleccion;
        }
        
        public static Sensor[] ordenar(Sensor[] s){
            Sensor [] ans = s;
            int n = s.length;
            Sensor temp;
            for(int i = 1; i < n; i++){
                for(int j = 0; j<n-i;j++){
                    if(ans[j].getValor()>ans[j+1].getValor()){
                        temp = ans[j];
                        ans[j]=ans[j+1];
                        ans[j+1]=temp;
                    }
                }
            }
            return ans;
        }
        
        public static int cantidadSensores(){
            return posAnadir;
        }
}
