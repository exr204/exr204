
package exr204;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Exr204 {

    public static ListaSemestre semestre = new ListaSemestre();
    public static ListaCurso curso = new ListaCurso();
    public static ListaEstudiante estudiante = new ListaEstudiante();
    public static ListaCatedratico catedratico = new ListaCatedratico();
    
    public static void main(String[] args) {
       semestre.Agregar("Primer Semestre 2018");
       semestre.Agregar("Segundo Semestre 2018");
       semestre.Agregar("Primer Semestre 2019");
       semestre.Agregar("Segundo Semestre 2019");
       semestre.Agregar("Primer Semestre 2020");
       semestre.Agregar("Segundo Semestre 2020");
       semestre.Agregar("Primer Semestre 2021");
       semestre.Agregar("Segundo Semestre 2021");
       semestre.Agregar("Primer Semestre 2022");
       semestre.Agregar("Segundo Semestre 2022");
       
       ventana v = new ventana();
       
    }
    
   
    
}
