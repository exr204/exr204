
package exr204;


public class ListaCatedratico {
    NodoCatedratico inicio, ultimo;
    
    public ListaCatedratico(){
        this.inicio = null;
        this.ultimo = null;
    }
    
    public void Agregar(String nombre){
        NodoCatedratico nuevo = new NodoCatedratico();
        
        nuevo.nombre = nombre;
        
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
            System.out.println(temporal.nombre);
            temporal = temporal.siguiente;
        }
    }
            
}
