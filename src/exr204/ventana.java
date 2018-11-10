
package exr204;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.JComboBox;
import exr204.Exr204;


public class ventana extends JFrame{
    
    public ventana(){
        Administrador admi = new Administrador();
       
        
    }
    
    public class VentanaPrincipal extends JFrame{
    JComboBox<String> combo1;
        public VentanaPrincipal(){
            setTitle("Sistema de Estudiantes de Ciencias y Sistemas (SECY)");
            setSize(300, 200);
            setVisible(true);
            setLocationRelativeTo(null);//Centrar ventana
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar ventana
            panel();  
            Boton1();    
        }
        
        JPanel panel = new JPanel();
         private void panel(){
            panel.setLayout(null);
            this.getContentPane().add(panel);//agregar panel a la ventana
    }
         
         
         private void Boton1(){
            JButton b1 = new JButton("Login");
            b1.setBounds(100, 30, 100, 35);
            panel.add(b1);
            
            
            /* Asignar una Accion al JButton */
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
               Login login = new Login();
                
            }
        });   
         }
         
    }     
   
    public class Login extends JFrame{
        JTextField cj1 = new JTextField();
        JTextField cj2 = new JTextField();
        
        public Login(){
            setTitle("LOGIN");
            setSize(300, 200);
            setVisible(true);
            setLocationRelativeTo(null);//Centrar ventana
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//cerrar ventana
            
            Etiqueta("Usuario",15,20,65,30);
            Etiqueta2("Contraseña",15,60,85,30);
            CajasDeTexto(130, 25, 110, 23, cj1);
            CajasDeTexto(130, 25, 110, 63, cj2);
            panel(); 
            Boton1();
            Boton2();
        }
        
        JPanel panel = new JPanel();
         private void panel(){
            panel.setLayout(null);
            this.getContentPane().add(panel);//agregar panel a la ventana
    }
         
         JLabel etiqueta = new JLabel();
    public void Etiqueta(String nombre, int posx, int posy, int Ancho, int Alto){
      etiqueta.setText(nombre);
      etiqueta.setBounds(posx, posy, Ancho, Alto);
      panel.add(etiqueta); 
     }
    
    JLabel etiqueta2 = new JLabel();
    public void Etiqueta2(String nombre, int posx, int posy, int Ancho, int Alto){
      etiqueta2.setText(nombre);
      etiqueta2.setBounds(posx, posy, Ancho, Alto);
      panel.add(etiqueta2); 
     }
    
     private void CajasDeTexto(int Ancho, int Alto, int posx, int posy, JTextField cajaTexto){
        cajaTexto.setBounds(posx, posy, Ancho, Alto);
        panel.add(cajaTexto);
    }
     
     private void Boton1(){
            JButton b1 = new JButton("Ingresar");
            b1.setBounds(25, 110, 100, 30);
            panel.add(b1);
            
            
            /* Asignar una Accion al JButton */
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });    
        }
     
     private void Boton2(){
            JButton b2 = new JButton("Cancelar");
            b2.setBounds(155, 110, 100, 30);
            panel.add(b2);
            
            
            /* Asignar una Accion al JButton */
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cj1.setText("");
                cj2.setText("");
                
            }
        });    
        }
        
    }
     
     public class Administrador extends JFrame{
        
        public Administrador(){
            setTitle("Administrador");
            setSize(400, 300);
            setVisible(true);
            setLocationRelativeTo(null);//Centrar ventana
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar ventana
            
            
            panel(); 
            Boton1();
            Boton2();
            Boton3();
            Boton4();
            Boton5();
        }
        
        JPanel panel = new JPanel();
         private void panel(){
            panel.setLayout(null);
            this.getContentPane().add(panel);//agregar panel a la ventana
    }
         
        
     
     private void Boton1(){
            JButton b1 = new JButton("Cargar Cursos");
            b1.setBounds(50, 20, 130, 30);
            panel.add(b1);
            
            
            /* Asignar una Accion al JButton */
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            CargadeDatosCursos();
            
            
            }
        });    
        }
     
     private void Boton2(){
            JButton b2 = new JButton("Cargar Estudiantes");
            b2.setBounds(200, 20, 150, 30);
            panel.add(b2);
            
            
            /* Asignar una Accion al JButton */
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                CargadeDatosEstudiantes();
               
            }
        });    
        }
     
      private void Boton3(){
            JButton b1 = new JButton("Administrar Estudiantes");
            b1.setBounds(100, 80, 180, 30);
            panel.add(b1);
            
            
            /* Asignar una Accion al JButton */
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                AdmiEstudiantes admiEs = new AdmiEstudiantes();
                admiEs.show();
            
            }
        });    
        }
       private void Boton4(){
            JButton b1 = new JButton("Administrar Cursos");
            b1.setBounds(115, 130, 150, 30);
            panel.add(b1);
            
            
            /* Asignar una Accion al JButton */
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                AdmiCursos admicurso = new AdmiCursos();
                admicurso.show();
            
            }
        });    
        }
        private void Boton5(){
            JButton b1 = new JButton("Reportes");
            b1.setBounds(125, 180, 130, 30);
            panel.add(b1);
            
            
            /* Asignar una Accion al JButton */
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                admiReportes admirep = new admiReportes();
                admirep.show();
                
            }
        });    
        }
        
    }
   
    
    public static void CargadeDatosCursos()
    {
        BufferedReader archivo = null;
        String linea = "";
        String separador = ";";
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);
        
        try {
            
            String patch = buscador.getSelectedFile().getAbsolutePath();
            
            archivo = new BufferedReader(new FileReader(patch));
            while((linea = archivo.readLine()) != null)
            {
                String[] datos = linea.split(separador);
                try { 
                for(int i = 0; i<datos.length; i++)
                {
                   
                }
                //objeto.Agregar(id, nombre, ingeniero, creditos, lab, seccion, pre, post);
                //objeto.Agregar(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], datos[8]);
                
                Exr204.curso.Agregar(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                Exr204.curso.Imprimir();
                  
               
                } catch (Exception e) {}
                
            }
            archivo.close();
        } catch (Exception e) {
        }
    }     
    
     public static void CargadeDatosEstudiantes()
    {
        BufferedReader archivo = null;
        String linea = "";
        String separador = ";";
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);
        
        try {
            
            String patch = buscador.getSelectedFile().getAbsolutePath();
            
            archivo = new BufferedReader(new FileReader(patch));
            while((linea = archivo.readLine()) != null)
            {
                String[] datos = linea.split(separador);
                try { 
                for(int i = 0; i<datos.length; i++)
                {
                   
                }
                
                Exr204.estudiante.Agregar(datos[0], datos[1],datos[2], datos[3], datos[4], datos[5]);
                Exr204.estudiante.Imprimir();
                
                } catch (Exception e) {}
                
            }
            archivo.close();
        } catch (Exception e) {
        }
    }   
   
}

