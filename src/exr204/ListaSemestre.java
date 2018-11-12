
package exr204;

//lista doble enlazada
public class ListaSemestre {
     public NodoSemestre inicio, ultimo;
    
    public ListaSemestre(){
        this.inicio = null;
        this.ultimo= null;   
    }
    
    public void Agregar(String nombre){
        NodoSemestre nuevo = new NodoSemestre();
        
        nuevo.nombre = nombre;
        
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
                System.out.println(temporal.nombre);
                 temporal = temporal.siguiente;
        }
    }
    
    
    public boolean BuscarSemestre(String nombreSemestre)
    {
        NodoSemestre temporal = inicio;
        while(temporal != null){
             if(temporal.nombre.equals(nombreSemestre))
             {
                 return true;
             }
             temporal = temporal.siguiente;
        }
        return false;
    }
    
     public boolean AgregarCursoenSemestre(String nombreSemestre, String Id,String curso, String catedratico,String creditos, String laboratorio, String pre_requisito, String post_requisito)
    {
        //Agregar un semestre nuevo a la lista con su primer curso
        if(BuscarSemestre(nombreSemestre) == false)
        {
            NodoSemestre nuevo = new NodoSemestre();
            nuevo.nombre = nombreSemestre;
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
        
        //Este metodo nos ayuda si el semestre ya existe
        NodoSemestre temporal = inicio;
        while(temporal != null)
        {
            if(nombreSemestre.equals(temporal.nombre))
            {
               temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
               return true; 
            }
            temporal = temporal.siguiente;
        }
        return false;
    }
    
    
     
      public boolean AgregarEstudianteenCursoenSemestre(String nombreSemestre, String Id,String curso, String catedratico,String creditos, String laboratorio, String pre_requisito, String post_requisito, String carnetEstudiante, String nombreEstudiante)
    {
        //Agregar un semestre nuevo a la lista con su primer curso
        if(BuscarSemestre(nombreSemestre) == false)
        {
            NodoSemestre nuevo = new NodoSemestre();
            nuevo.nombre = nombreSemestre;
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
        
        //Este metodo nos ayuda si el semestre ya existe
        NodoSemestre temporal = inicio;
        while(temporal != null)
        {
            if(nombreSemestre.equals(temporal.nombre))
            {
               temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
               temporal.cursos.AgregarEstudiante(Id,carnetEstudiante, nombreEstudiante, 0);
               return true; 
            }
            temporal = temporal.siguiente;
        }
        return false;
    }
    
    
    
    
    
    
    /*
    public boolean AgregarCursoenSemestre(String Id,String curso, String catedratico,String creditos, String laboratorio, String pre_requisito, String post_requisito)
    {
        NodoSemestre temporal = inicio;
        int contador = 1;
        int codigo = Integer.parseInt(Id);
        while(temporal != null)
        {
            switch(contador)
            {
                case 1: //Primer semestre
                    if(codigo == 17 || codigo == 101 || codigo == 69 || codigo == 39 ||codigo == 348 || codigo == 6)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 2://Segundo semestre
                    if(codigo == 19 || codigo == 103 || codigo == 5 || codigo == 147 ||codigo == 040 || codigo == 8)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 3://Tercer semestre
                    if(codigo == 795 || codigo == 960 || codigo == 770 || codigo == 107 ||codigo == 150 || codigo == 9)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    
                    break;
                case 4://Cuarto semestre
                    if(codigo == 732 || codigo == 796 || codigo == 962 || codigo == 771 ||codigo == 10 || codigo == 112 || codigo == 114|| codigo == 152|| codigo == 11|| codigo == 2025)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 5://Quinto semestre
                    if(codigo == 736 || codigo == 777 || codigo == 964 || codigo == 772 ||codigo == 18 || codigo == 116 || codigo == 118 || codigo == 368|| codigo == 650|| codigo == 28)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 6://Sexto semestre
                    if(codigo == 722 || codigo == 601 || codigo == 14 || codigo == 781 ||codigo == 778 || codigo == 773 || codigo == 122|| codigo == 120|| codigo == 200|| codigo == 652|| codigo == 335|| codigo == 786|| codigo == 3662|| codigo == 3022)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 7://Septimo semestre
                    if(codigo == 724 || codigo == 603 || codigo == 734 || codigo == 281 ||codigo == 779 || codigo == 970 || codigo == 774|| codigo == 656|| codigo == 654|| codigo == 2036|| codigo == 787|| codigo == 3664|| codigo == 3658|| codigo == 700)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 8://Octavo semestre
                     if(codigo == 285 || codigo == 975 || codigo == 775 || codigo == 283 ||codigo == 797 || codigo == 700 || codigo == 706|| codigo == 1)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 9://Noveno semestre
                    if(codigo == 729 || codigo == 786 || codigo == 972 || codigo == 966 ||codigo == 785 || codigo == 788 || codigo == 738|| codigo == 798|| codigo == 288|| codigo == 702|| codigo == 1|| codigo == 2009)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
                case 10://Decime semestre
                    if(codigo == 787 || codigo == 790 || codigo == 720 || codigo == 968 ||codigo == 974 || codigo == 780 || codigo == 789|| codigo == 735|| codigo == 7990|| codigo == 710|| codigo == 706|| codigo == 799)
                    {
                        temporal.cursos.Agregar(Id, curso, catedratico, creditos, laboratorio, pre_requisito, post_requisito);
                        return true;
                    }
                    break;
            }
            temporal = temporal.siguiente;
            contador++;
        }
        System.out.println("ERROR: el curso no pertenece a ningun semestre.");
        return false;
    }
    */
    
}
