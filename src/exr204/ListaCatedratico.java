
package exr204;


public class ListaCatedratico {
    NodoCatedratico inicio, ultimo;
    
    public ListaCatedratico(){
        this.inicio = null;
        this.ultimo = null;
    }
    
    public void Agregar(String id, String nombre){
        NodoCatedratico nuevo = new NodoCatedratico();
        
        int random= 0; //(int) (Math.random() * (150-50+1)+5) ;
        
        nuevo.id = id;
        nuevo.nombre = nombre;
        nuevo.contrasenia = id + random;
        
        if(inicio == null){
           inicio = ultimo = nuevo;
           inicio.siguiente = null;
        }else{
            ultimo.siguiente = nuevo;
            nuevo.siguiente = null;
            ultimo = nuevo;
        }
    }
    
    public void Imprimir(){
        NodoCatedratico temporal;
        temporal = inicio;
        while(temporal != null){
            System.out.println(temporal.id+" "+temporal.nombre+" "+temporal.contrasenia);
            temporal = temporal.siguiente;
        }
    }
    
    public boolean LoginCatedratico(String usuario, String contrasenia)
    {
        NodoCatedratico temporal;
        temporal = inicio;
        while(temporal != null){
            if(temporal.nombre.equals(usuario) && temporal.contrasenia.equals(contrasenia))
            {
                return true;
            }
            temporal = temporal.siguiente;
        }
        return false;
    }
            
}
