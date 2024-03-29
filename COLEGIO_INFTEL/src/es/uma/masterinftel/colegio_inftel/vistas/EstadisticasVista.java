/*
 * EstadisticasVista.java
 */

package es.uma.masterinftel.colegio_inftel.vistas;
import es.uma.masterinftel.colegio_inftel.control.EstadisticasControlador;
import es.uma.masterinftel.colegio_inftel.utilidades.ObjCombo;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Vista para la eleccion de graficas estadisticas
 * 
 * @author Luis Jarén
 * @version v1.0 Diciembre-2011
 */
public class EstadisticasVista extends javax.swing.JDialog {

    /**
     * Constructor de clase
     * @param parent ventana padre de Anotar Incidencia Vista
     * @param modal si true se visualiza de forma Modal
     * @throws java.sql.SQLException
     */

    public EstadisticasVista(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        //Centramos la ventana en pantalla
        this.setLocationRelativeTo(null); 
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
                
            }
         });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        asignaturaComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnEstadistica1 = new javax.swing.JButton();
        cursoComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        profesorComboBox = new javax.swing.JComboBox();
        btnEstadistica2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnEstadistica3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        anioMatriculadosComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadisticas");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setText("ESTADISTICAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Aprobados/suspensos por asignatura y curso");

        asignaturaComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                asignaturaComboBoxItemStateChanged(evt);
            }
        });

        jLabel3.setText("Asignatura");

        btnEstadistica1.setText("Mostrar estadística");
        btnEstadistica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadistica1ActionPerformed(evt);
            }
        });

        cursoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cursoComboBoxItemStateChanged(evt);
            }
        });

        jLabel4.setText("Curso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(asignaturaComboBox, 0, 150, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btnEstadistica1)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asignaturaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEstadistica1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Aprobados/suspensos por profesor y año");

        jLabel6.setText("Profesor");

        profesorComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                profesorComboBoxItemStateChanged(evt);
            }
        });

        btnEstadistica2.setText("Mostrar estadística");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addComponent(profesorComboBox, 0, 326, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnEstadistica2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profesorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadistica2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Número de alumnos matriculados por asignatura");

        btnEstadistica3.setText("Mostrar estadística");
        btnEstadistica3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadistica3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnEstadistica3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addComponent(btnEstadistica3)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel7.setText("Año Escolar");

        anioMatriculadosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioMatriculadosComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(anioMatriculadosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(anioMatriculadosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEstadistica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadistica1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnEstadistica1ActionPerformed

    private void btnEstadistica3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadistica3ActionPerformed
        
    }//GEN-LAST:event_btnEstadistica3ActionPerformed
    /**
     * Acción para cambios en el combo profesor
     * @param evt Evento
     */
    private void profesorComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_profesorComboBoxItemStateChanged
        
        //ObjCombo profesor = (ObjCombo) profesorComboBox.getSelectedItem();
        //System.out.println("ID: " + profesor.getId());
    }//GEN-LAST:event_profesorComboBoxItemStateChanged
    /**
     * Acción para cambios en el combo asignatura
     * @param evt Evento
     */
    private void asignaturaComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_asignaturaComboBoxItemStateChanged
        
        //ObjCombo asignatura = (ObjCombo) asignaturaComboBox.getSelectedItem();
        //System.out.println("ID: " + asignatura.getId());
    }//GEN-LAST:event_asignaturaComboBoxItemStateChanged
    /**
     * Acción para cambios en el combo curso
     * @param evt Evento
     */
    private void cursoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cursoComboBoxItemStateChanged
        
        //ObjCombo curso = (ObjCombo) cursoComboBox.getSelectedItem();
        //System.out.println("ID: " + curso.getId());
    }//GEN-LAST:event_cursoComboBoxItemStateChanged

    private void anioMatriculadosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioMatriculadosComboBoxActionPerformed
        
    }//GEN-LAST:event_anioMatriculadosComboBoxActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox anioMatriculadosComboBox;
    public javax.swing.JComboBox asignaturaComboBox;
    private javax.swing.JButton btnEstadistica1;
    private javax.swing.JButton btnEstadistica2;
    private javax.swing.JButton btnEstadistica3;
    public javax.swing.JComboBox cursoComboBox;
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JComboBox profesorComboBox;
    // End of variables declaration//GEN-END:variables

      /**
     * Devuelve la asignatura seleccionada en el combo
     * @return Asignatura seleccionada
     */

    public String getAsignatura(){
        return asignaturaComboBox.getSelectedItem().toString();
    }
      /**
     * Devuelve el curso seleccionado en el combo
     * @return Curso seleccionado
     */

    public String getCurso(){
        return cursoComboBox.getSelectedItem().toString();
    }

      /**
     * Devuelve el profesor seleccionado
     * @return Profesor seleccionado
     */

    public String getProfesor(){
        return profesorComboBox.getSelectedItem().toString();
    }

      /**
     * Devuelve el año de matriculacion seleccionado en el combo
     * @return año de matriculacion seleccionado
     */

    public int getAnioMatriculados(){
        return new Integer (anioMatriculadosComboBox.getSelectedItem().toString());
    }
    
    /**
     * Acción para crear y dibujar estadistica1 (asociado al botón MOSTRAR ESTADISTICA 1)
     * @param a Acción
     */
    public void addEstadistica1Listener(ActionListener a){
        btnEstadistica1.addActionListener(a);
    }
    /**
     * Acción para crear y dibujar estadistica2 (asociado al botón MOSTRAR ESTADISTICA 2)
     * @param a Acción
     */
    public void addEstadistica2Listener(ActionListener a){
        btnEstadistica2.addActionListener(a);
    }
    /**
     * Acción para crear y dibujar estadistica3 (asociado al botón MOSTRAR ESTADISTICA 3)
     * @param a Acción
     */
    public void addEstadistica3Listener(ActionListener a){
        btnEstadistica3.addActionListener(a);
    }
    /**
     * Muestra Dialogod de Error, al no haber datos
     * para realizar la grafica de la estadistica
     */
    public void printMensajeSinDatos() {
        JOptionPane.showMessageDialog(this,
                "No hay datos para mostrar");
    }
}
