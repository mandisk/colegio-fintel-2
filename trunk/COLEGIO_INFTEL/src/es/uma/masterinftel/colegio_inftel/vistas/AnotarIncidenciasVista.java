package es.uma.masterinftel.colegio_inftel.vistas;

import es.uma.masterinftel.colegio_inftel.modelo.dao.MatriculacionesDAO;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AnotarIncidenciasVista.java
 *
 * Created on 9/01/2012, 11:29:48 AM
 */

/**
 *
 * @author BlackCrystal™
 */
public class AnotarIncidenciasVista extends javax.swing.JDialog {

    private MatriculacionesDAO modelo;
    private Integer anio_mat;
    private Integer id_alumno;

    /** Creates new form AnotarIncidenciasVista */
    public AnotarIncidenciasVista(MatriculacionesDAO modelo,java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.modelo= modelo;
        initComponents();
        this.setLocationRelativeTo(null); //centramos la ventana en pantalla
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        faltasLabel = new javax.swing.JLabel();
        faltasText = new javax.swing.JTextField();
        retrasosLabel = new javax.swing.JLabel();
        sancionesLabel = new javax.swing.JLabel();
        retrasosText = new javax.swing.JTextField();
        sancionesText = new javax.swing.JTextField();
        apellido1NotasLabel4 = new javax.swing.JLabel();
        comentariosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comentariosTextArea = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        pCabecera = new javax.swing.JPanel();
        lbAlumno = new javax.swing.JLabel();
        lbAsignatura = new javax.swing.JLabel();
        lbAlumnoValue = new javax.swing.JLabel();
        lbAsignaturaValue = new javax.swing.JLabel();
        lbCurso = new javax.swing.JLabel();
        lbGrupo = new javax.swing.JLabel();
        lbCursoValue = new javax.swing.JLabel();
        lbGrupoValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escuela2.0 -- Incidencias");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        faltasLabel.setText("Faltas");
        faltasLabel.setName("faltasLabel"); // NOI18N

        faltasText.setText("0");
        faltasText.setName("faltasText"); // NOI18N

        retrasosLabel.setText("Retrasos");
        retrasosLabel.setName("retrasosLabel"); // NOI18N

        sancionesLabel.setText("Sanciones");
        sancionesLabel.setName("sancionesLabel"); // NOI18N

        retrasosText.setText("0");
        retrasosText.setName("retrasosText"); // NOI18N

        sancionesText.setText("0");
        sancionesText.setName("sancionesText"); // NOI18N

        apellido1NotasLabel4.setName("apellido1Label"); // NOI18N

        comentariosLabel.setText("Comentarios");
        comentariosLabel.setName("comentariosLabel"); // NOI18N

        comentariosTextArea.setColumns(20);
        comentariosTextArea.setRows(5);
        comentariosTextArea.setName("comentariosTextArea"); // NOI18N
        jScrollPane1.setViewportView(comentariosTextArea);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(apellido1NotasLabel4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(faltasText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(faltasLabel))
                                .addGap(134, 134, 134)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(retrasosText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(retrasosLabel))
                                .addGap(118, 118, 118)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sancionesLabel)
                                    .addComponent(sancionesText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(comentariosLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faltasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retrasosLabel)
                    .addComponent(sancionesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faltasText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retrasosText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sancionesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apellido1NotasLabel4)
                    .addComponent(comentariosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");

        btnCerrar.setText("Cerrar");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pCabecera.setBackground(new java.awt.Color(255, 254, 254));

        lbAlumno.setText("Alumno:");

        lbAsignatura.setText("Asignatura:");

        lbAlumnoValue.setForeground(new java.awt.Color(33, 94, 186));
        lbAlumnoValue.setText("Alfonso Pérez Sánchez");

        lbAsignaturaValue.setForeground(new java.awt.Color(140, 140, 140));
        lbAsignaturaValue.setText("Informática");

        lbCurso.setText("Curso:");

        lbGrupo.setText("Grupo:");

        lbCursoValue.setForeground(new java.awt.Color(140, 140, 140));
        lbCursoValue.setText("1º de E.S.0");

        lbGrupoValue.setForeground(new java.awt.Color(140, 140, 140));
        lbGrupoValue.setText("A");

        javax.swing.GroupLayout pCabeceraLayout = new javax.swing.GroupLayout(pCabecera);
        pCabecera.setLayout(pCabeceraLayout);
        pCabeceraLayout.setHorizontalGroup(
            pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCabeceraLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbAsignatura)
                    .addComponent(lbAlumno))
                .addGap(18, 18, 18)
                .addGroup(pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlumnoValue)
                    .addComponent(lbAsignaturaValue))
                .addGap(90, 90, 90)
                .addGroup(pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbGrupo)
                    .addComponent(lbCurso))
                .addGap(18, 18, 18)
                .addGroup(pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCursoValue)
                    .addComponent(lbGrupoValue))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        pCabeceraLayout.setVerticalGroup(
            pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCabeceraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlumno)
                    .addComponent(lbCursoValue)
                    .addComponent(lbCurso)
                    .addComponent(lbAlumnoValue))
                .addGap(18, 18, 18)
                .addGroup(pCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAsignatura)
                    .addComponent(lbGrupoValue)
                    .addComponent(lbGrupo)
                    .addComponent(lbAsignaturaValue))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnotarIncidenciasVista dialog = new AnotarIncidenciasVista(new MatriculacionesDAO(),new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido1NotasLabel4;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel comentariosLabel;
    private javax.swing.JTextArea comentariosTextArea;
    private javax.swing.JLabel faltasLabel;
    private javax.swing.JTextField faltasText;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAlumno;
    private javax.swing.JLabel lbAlumnoValue;
    private javax.swing.JLabel lbAsignatura;
    private javax.swing.JLabel lbAsignaturaValue;
    private javax.swing.JLabel lbCurso;
    private javax.swing.JLabel lbCursoValue;
    private javax.swing.JLabel lbGrupo;
    private javax.swing.JLabel lbGrupoValue;
    private javax.swing.JPanel pCabecera;
    private javax.swing.JLabel retrasosLabel;
    private javax.swing.JTextField retrasosText;
    private javax.swing.JLabel sancionesLabel;
    private javax.swing.JTextField sancionesText;
    // End of variables declaration//GEN-END:variables

    //metodos de acceso a los elementos de la  vista
     public void setNombreAlumno(String alumno){
        lbAlumnoValue.setText(alumno);
    }
    public void setAsignatura(String asignatura){
        lbAsignaturaValue.setText(asignatura);
    }
    public void setCurso(String curso){
        lbCursoValue.setText(curso);
    }
    public void setGrupo(String grupo){
        lbGrupoValue.setText(grupo);
    }
    public int getFaltas(){
        return new Integer(faltasText.getText());
    }
    public int getRetrasos(){
        return new Integer(retrasosText.getText());
    }
    public int getSanciones(){
        return new Integer(sancionesText.getText());
    }
    public String getComentarios(){
        return new String(comentariosTextArea.getText());
    }
    public void setFaltas(String faltas){
        faltasText.setText(faltas);
    }
    public void setRetrasos(String retrasos){
        retrasosText.setText(retrasos);
    }
    public void setSanciones(String sanciones){
        sancionesText.setText(sanciones);
    }
    public void setComentarios(String comentario){
        comentariosTextArea.setText(comentario);
    }
    public void addConfirmarListener(ActionListener a){
        btnGuardar.addActionListener(a);

    }
    public void addCancelarListener(ActionListener a){
        btnCerrar.addActionListener(a);
    }
        public Integer getAnio_mat() {
        return anio_mat;
    }

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setAnio_mat(Integer anio_mat) {
        this.anio_mat = anio_mat;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

}