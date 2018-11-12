
package exr204;

//Lista Circular simple
public class ListaCurso {
    public NodoCurso inicio, ultimo;
    int contadorCurso = 0;
    public ListaCurso(){
        this.inicio = null;
        this.ultimo = null;
    }
    
    public void Agregar(String Id, String curso, String catedratico,String creditos,  String laboratorio,String pre_requisito,String post_requisito){
        NodoCurso nuevo = new NodoCurso();
        
        nuevo.Id = Id;
        nuevo.curso = curso;
        nuevo.catedratico = catedratico;
        nuevo.creditos = creditos;
        nuevo.laboratorio = laboratorio;
        nuevo.pre_requisito = pre_requisito;
        nuevo.post_requisito = post_requisito;
        
        if(inicio == null){
           inicio = ultimo = nuevo;
           ultimo.siguiente = inicio;
        }else{
            if(contadorCurso <= 3)
            {
                ultimo.siguiente = nuevo;
                nuevo.siguiente = inicio;
                ultimo = nuevo;
            }
            else
            {
                System.out.println("ERROR: No pueden haber mas de 3 cursos por semestre");
            }
            
        }
        contadorCurso++;
    }
    
    public void Eliminar(String Id){
        NodoCurso temporal;
        temporal = inicio;
        if(inicio == null)
        {
            //la lista esta vacia
        }
        else
        {
            NodoCurso anterior = inicio;
            do{
                
                if(temporal.Id.equals(Id)){
                   
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
        contadorCurso--;
    }
    
    public void AgregarEstudiante(String codigoCurso, String carnet, String nombre, int nota)
    {
        NodoCurso temporal = inicio;
        do {
            if(temporal.Id.equals(codigoCurso))
            {
                break;
            }
            temporal = temporal.siguiente;
        } while (temporal != inicio);
        //codigo
        if(temporal.estudianteAsignado.BuscarEstudiante(carnet))
        {
            System.out.println("Error!! el estudiante ya esta asignado a este curso");
        }
        else
        {
            temporal.estudianteAsignado.Agregar(carnet, " ", nombre, " ", " ", " ");
        }
        
    }
    
    public void Imprimir(){
        NodoCurso temporal;
        temporal = inicio;
        do{
            System.out.println(temporal.Id+" "+temporal.curso+" "+temporal.catedratico+" "+temporal.creditos+" "+temporal.laboratorio+" "+temporal.pre_requisito+" "+temporal.post_requisito);
            temporal = temporal.siguiente;
        }while(temporal != inicio);
    }
    
    public NodoCurso EncontrarCurso(String nombre)
    {
        NodoCurso temporal;
        temporal = inicio;
        do{
            if(temporal.curso.equals(nombre))
            {
                return temporal;
            }
            temporal = temporal.siguiente;
        }while(temporal != inicio);
        return null;
    }
}
