
package exr204;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ventana extends JFrame{
    
    public ventana(){
        
        VentanaPrincipal v = new VentanaPrincipal();
        
    }
    
    public class VentanaPrincipal extends JFrame{
    
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
         
    
}

