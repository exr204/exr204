
package exr204;


public class ListaCatedratico {
    NodoCatedratico inicio, ultimo;
    
    public ListaCatedratico(){
        this.inicio = null;
        this.ultimo = null;
    }
    
    public void Agregar(String id, String nombre){
        NodoCatedratico nuevo = new NodoCatedratico();
        
        int random =(int) (Math.random()*(150-50+1)+5);
        
        nuevo.id = id;
        nuevo.nombre = nombre;
        nuevo.contrasenia = id +Integer.toString(random);
        
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
    
   public NodoCatedratico LoginCatedratico(String usuario, String contrasenia)
    {
        NodoCatedratico temporal = inicio;
        while(temporal != null)
        {
            if(temporal.id.trim().equals(usuario.trim()) && temporal.contrasenia.trim().equals(contrasenia.trim()) )
            {
                return temporal;
            }
            temporal = temporal.siguiente;
        }
        return null;
    }

    public NodoCatedratico DevolverCatedratico(String nombreCatedratico)
    {
        NodoCatedratico temporal = inicio;
        while(temporal != null)
        {
            if(temporal.nombre.equals(nombreCatedratico))
            {
                return temporal;
            }
            temporal = temporal.siguiente;
        }
        return null;
    }
    
    public void Eliminar(String Id){
    
    if(inicio.id == Id){
        inicio = inicio.siguiente;
    }else{
        NodoCatedratico temporal = inicio;
        while(temporal.siguiente != null){
            if(temporal.siguiente.id == Id){
                temporal.siguiente = temporal.siguiente.siguiente;
            }if(temporal.siguiente != null){
                temporal = temporal.siguiente;
                }
        }
    }
            
}
}
