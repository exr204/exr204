/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exr204;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class CursosAprobados extends javax.swing.JFrame {

    /**
     * Creates new form CursosAprobados
     */
    DefaultTableModel tabla = new DefaultTableModel();
    
    NodoEstudiante estudent;
    public CursosAprobados(NodoEstudiante estudent) {
        this.estudent= estudent;
        initComponents();
        
         String [] cabezera = new String[]{"Id","Curso","Catedratico","Creditos","Laboratorio","Sección","Pre-requisitos","Post-requisitos","Nota"};
        tabla.setColumnIdentifiers(cabezera);
        jTable1.setModel(tabla);
        
        semestre.removeAllItems();
        NodoSemestre temporal = Exr204.semestre.inicio;
        while(temporal != null){
                semestre.addItem(temporal.nombre);
     
           temporal = temporal.siguiente;
        }
    }
    
     void agregar(){
       
       //String nombreSemestre = semestre.getSelectedItem().toString();
       NodoSemestre inicioSEM = estudent.semestre.inicio; //obtengo el inicio de la lista semestre de lado del estudiante
       
       while(inicioSEM != null)
       {
           
           NodoCurso inicio = estudent.semestre.BuscarSemestreAsignado(inicioSEM.nombre);
           NodoCurso temporal = inicio;
       if(temporal != null)
       {    //recorre la lista de cursos de lado del estudiante
           do{
               int nota = 0; //crea una variable nota que se modificara mas adelante
                //encontrar nota del curso correspoendiente
                NodoCatedratico cat1 = Exr204.catedratico.DevolverCatedratico(temporal.catedratico);//encuentra al catedratic
                NodoCurso inicioCurso1 = cat1.semestre.BuscarSemestreAsignado(inicioSEM.nombre);//encuentra el curso correspondiente de lado del catedratico
                NodoCurso temp1 = inicioCurso1;
                if(temp1 != null) //verifica que hay un curso en la lista de lado del catedratico
                {
                    // recorrer la lista de cursos de lado del catedratico
                    do
                    {
                        if(temporal.curso.equals(temp1.curso))
                        {
                            break; //encuentra el curso correspondiente
                        }
                        temp1 = temp1.siguiente;
                    }while(temp1 != inicioCurso1); 
                    
                    //codigo
                    NodoEstudiante inicioStudent = temp1.estudianteAsignado.inicio; //devuelve el inicio de la lista estudiante de lado del catedratico
                    NodoEstudiante temp2 = inicioStudent;
                    if(temp2 != null)
                    {   //recorre la lista estudiante buscando al estudiante correspondiente
                        do
                        {
                            if(estudent.carnet.equals(temp2.carnet))
                            {
                                nota = temp2.nota; //obtiene la nota del curso
                            }
                            temp2 = temp2.siguiente;
                        }while(temp2 != inicioStudent);
                    }
                    
                }
           
                //Ahora comprobaremos si el curso esta o no esta aprobado
                boolean bandera = true;
                if(nota >= 61)
                {
                    for(int i = 0; i < jTable1.getRowCount(); i++) {
                        if(temporal.Id.equals(jTable1.getValueAt(i, 0)))
                        {
                            if(Integer.parseInt(jTable1.getValueAt(i, 8).toString()) <= nota)
                            {
                                jTable1.setValueAt(nota, i, 8);
                            }
                            bandera = false;
                        }
                    }
                    
                    if(bandera)
                    {
                        tabla.addRow(new Object[]{
                            temporal.Id.toString(), temporal.curso.toString(), temporal.catedratico.toString(), temporal.creditos.toString(), temporal.laboratorio.toString(), temporal.seccion.toString(), temporal.pre_requisito.toString(), temporal.post_requisito.toString(), nota
                        });
                    }   
                }
                temporal = temporal.siguiente;
            }while(temporal != inicio );
       }
           
           
           
           
           inicioSEM = inicioSEM.siguiente;
       }
    }
    
    public CursosAprobados() {
       
        initComponents();
        
        
         semestre.removeAllItems();
        NodoSemestre temporal = Exr204.semestre.inicio;
        while(temporal != null){
                semestre.addItem(temporal.nombre);
     
           temporal = temporal.siguiente;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        semestre = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        semestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Mostrar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cursos Aprobados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(139, 139, 139))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       tabla = new DefaultTableModel();
        String [] cabezera = new String[]{"Id","Curso","Catedratico","Creditos","Laboratorio","Sección","Pre-requisitos","Post-requisitos","Nota"};
        tabla.setColumnIdentifiers(cabezera);
        jTable1.setModel(tabla);
        agregar();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CursosAprobados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CursosAprobados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CursosAprobados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CursosAprobados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursosAprobados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> semestre;
    // End of variables declaration//GEN-END:variables
}
