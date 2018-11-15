
package exr204;

//Lista doble Circular

import javax.swing.JOptionPane;

public class ListaEstudiante {
    NodoEstudiante inicio, ultimo;
    
    public ListaEstudiante(){
        this.inicio = null;
        this.ultimo = null;
    }
    
    public void Agregar(String carnet,String dpi, String nombre, String correo, String direccion, String creditos){
        NodoEstudiante nuevo = new NodoEstudiante();
        
        
       
        int random =(int) (Math.random()*(150-50+1)+5);
        
        nuevo.carnet = carnet;
        nuevo.dpi = dpi;
        nuevo.nombre = nombre;
        nuevo.correo = correo;
        nuevo.direccion = direccion;
        nuevo.creditos = creditos;
        nuevo.contrasenia = carnet + Integer.toString(random);
        
        if(inicio == null){
            inicio = ultimo = nuevo;
            inicio.siguiente = inicio;
            inicio.anterior = ultimo;
        }else{
            if(!BuscarEstudiante(carnet))
            {
                ultimo.siguiente = nuevo;
                nuevo.siguiente = inicio;
                nuevo.anterior = ultimo;
                ultimo = nuevo;
                inicio.anterior = ultimo;
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Error!! el estudiante ya Existe");
            }
        }
        
    }
    
    public void Imprimir (){
        NodoEstudiante temporal; 
        temporal = inicio;
        if(inicio != null)
        {
            do{
            System.out.println(temporal.carnet+" "+temporal.dpi+" "+temporal.nombre+" "+temporal.correo+" "
            +temporal.direccion+" "+temporal.creditos+" "+temporal.contrasenia);
            temporal = temporal.siguiente;
            }while(temporal != inicio);
        }
        
    }
    
    public boolean BuscarEstudiante(String carnet)
    {
        NodoEstudiante temporal; 
        temporal = inicio;
        if(inicio != null)
        {
            do{
            if(temporal.carnet.equals(carnet))
            {
                return true;
            }
            temporal = temporal.siguiente;
            }while(temporal != inicio);
        }
        return false;
    }
    
    public NodoEstudiante LoginEstudiante(String carnet, String contrasenia)
    {
        NodoEstudiante temporal; 
        temporal = inicio;
        if(inicio != null)
        {
            do{
            
            if(Integer.parseInt(temporal.carnet.trim()) == Integer.parseInt(carnet.trim()) && Integer.parseInt(temporal.contrasenia.trim()) == Integer.parseInt(contrasenia.trim()))
            {
                return temporal;
            }
            temporal = temporal.siguiente;
            }while(temporal != inicio);
        }
        return null;
    }
    
    public void Eliminar(String Id){
        NodoEstudiante temporal;
        temporal = inicio;
        if(inicio == null)
        {
            //la lista esta vacia
        }
        else
        {
            NodoEstudiante anterior = inicio;
            do{
                
                if(temporal.carnet.equals(Id)){
                   
                   if(temporal == inicio)
                   {
                       inicio = temporal.siguiente;
                       ultimo = inicio;
                   }
                   else if(temporal == ultimo)
                   {
                       ultimo = anterior;
                       ultimo.siguiente = inicio;
                   }
                   else
                   {
                       anterior.siguiente = temporal.siguiente;
                   }
                }
                
                anterior = temporal;
                temporal = temporal.siguiente;
            }while(temporal != inicio);
        }
       
    } 
}
