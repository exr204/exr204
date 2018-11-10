
package exr204;

//lista doble enlazada
public class ListaSemestre {
     private NodoSemestre inicio, ultimo;
    
    public ListaSemestre(){
        this.inicio = null;
        this.ultimo= null;   
    }
    
    public void Agregar(String semestre){
        NodoSemestre nuevo = new NodoSemestre();
        
        nuevo.semestre = semestre;
        
        if(inicio == null){
           inicio = ultimo = nuevo;  
           inicio.siguiente = null;
           inicio.anterior = null; 
        }else{
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            nuevo.siguiente = null;
            ultimo = nuevo;
        }
    }
    
    public void Imprimir(){
        NodoSemestre temporal = inicio;
        while(temporal != null){
                System.out.println(temporal.semestre);
                 temporal = temporal.siguiente;
        }
    }
    
}
