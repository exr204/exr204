
package exr204;

//Lista doble Circular
public class ListaEstudiante {
    NodoEstudiante inicio, ultimo;
    
    public ListaEstudiante(){
        this.inicio = null;
        this.ultimo = null;
    }
    
    public void Agregar(String carnet,String dpi, String nombre, String correo, String direccion, String creditos){
        NodoEstudiante nuevo = new NodoEstudiante();
        
        nuevo.carnet = carnet;
        nuevo.dpi = dpi;
        nuevo.nombre = nombre;
        nuevo.correo = correo;
        nuevo.direccion = direccion;
        nuevo.creditos = creditos;
        
        if(inicio == null){
            inicio = ultimo = nuevo;
            inicio.siguiente = inicio;
            inicio.anterior = ultimo;
        }else{
             ultimo.siguiente = nuevo;
             nuevo.siguiente = inicio;
             nuevo.anterior = ultimo;
             ultimo = nuevo;
             inicio.anterior = ultimo;
        }
        
    }
    
    public void Imprimir (){
        NodoEstudiante temporal; 
        temporal = inicio;
        do{
             System.out.println(temporal.carnet+" "+temporal.dpi+" "+temporal.nombre+" "+temporal.correo+" "
            +temporal.direccion+" "+temporal.creditos);
        temporal = temporal.siguiente;
        }
        while(temporal != inicio);
    }
    
}
