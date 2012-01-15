
/*
 * AnotarNotasVista.java
 *
 */

package es.uma.masterinftel.colegio_inftel.vistas;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Vista para la Modificación de notas de Alumnos y visualizaciónd de nota final
 *
 * @author Agustín Pereña
 * @version v1.0 Diciembre-2011
 */
public class AnotarNotasVista extends javax.swing.JDialog {

    private Integer anio_mat;
    private Integer id_alumno;
    private Integer codasignatura;


    /**
     * Constructor de clase
     * @param parent ventana padre de Anotar Vista
     * @param modal si true se visualiza de forma Modal
     */
    public AnotarNotasVista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //centramos la ventana en pantalla
        this.setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCabecera = new javax.swing.JPanel();
        lbAlumno = new javax.swing.JLabel();
        lbAsignatura = new javax.swing.JLabel();
        lbAlumnoValue = new javax.swing.JLabel();
        lbAsignaturaValue = new javax.swing.JLabel();
        lbCurso = new javax.swing.JLabel();
        lbGrupo = new javax.swing.JLabel();
        lbCursoValue = new javax.swing.JLabel();
        lbGrupoValue = new javax.swing.JLabel();
        pCuerpo = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbPrimera = new javax.swing.JLabel();
        nota1 = new javax.swing.JTextField();
        lbSegunda = new javax.swing.JLabel();
        nota2 = new javax.swing.JTextField();
        lbTercera = new javax.swing.JLabel();
        nota3 = new javax.swing.JTextField();
        notaFinalValue = new javax.swing.JTextField();
        notaFinal = new javax.swing.JTextField();
        lbCalificacionFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calificaciones");
        setResizable(false);

        pCabecera.setBackground(new java.awt.Color(255, 254, 254));

        lbAlumno.setText("Alumno:");

        lbAsignatura.setText("Asignatura:");

        lbAlumnoValue.setForeground(new java.awt.Color(33, 94, 186));
        lbAlumnoValue.setText("Agustín Pereña García");

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
                .addContainerGap(56, Short.MAX_VALUE))
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

        btnGuardar.setText("Guardar");

        btnCerrar.setText("Cerrar");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbPrimera.setText("Primera Evaluación:");

        nota1.setForeground(new java.awt.Color(54, 98, 209));
        nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nota1.setText("0.0");

        lbSegunda.setText("Segunda Evaluación:");

        nota2.setForeground(new java.awt.Color(54, 98, 209));
        nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nota2.setText("0.0");

        lbTercera.setText("Tercera Evaluación:");

        nota3.setForeground(new java.awt.Color(54, 98, 209));
        nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nota3.setText("0.0");

        notaFinalValue.setEditable(false);
        notaFinalValue.setForeground(new java.awt.Color(145, 145, 145));
        notaFinalValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        notaFinalValue.setText("0.0");

        notaFinal.setEditable(false);
        notaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbCalificacionFinal.setText("Calificación Final:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(notaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notaFinalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTercera, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(nota3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbSegunda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(nota2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbPrimera, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(nota1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbCalificacionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrimera)
                    .addComponent(nota1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSegunda)
                    .addComponent(nota2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTercera)
                    .addComponent(nota3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(notaFinalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCalificacionFinal))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout pCuerpoLayout = new javax.swing.GroupLayout(pCuerpo);
        pCuerpo.setLayout(pCuerpoLayout);
        pCuerpoLayout.setHorizontalGroup(
            pCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCuerpoLayout.createSequentialGroup()
                .addGroup(pCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCuerpoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pCuerpoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pCuerpoLayout.setVerticalGroup(
            pCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pCabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlumno;
    private javax.swing.JLabel lbAlumnoValue;
    private javax.swing.JLabel lbAsignatura;
    private javax.swing.JLabel lbAsignaturaValue;
    private javax.swing.JLabel lbCalificacionFinal;
    private javax.swing.JLabel lbCurso;
    private javax.swing.JLabel lbCursoValue;
    private javax.swing.JLabel lbGrupo;
    private javax.swing.JLabel lbGrupoValue;
    private javax.swing.JLabel lbPrimera;
    private javax.swing.JLabel lbSegunda;
    private javax.swing.JLabel lbTercera;
    public javax.swing.JTextField nota1;
    public javax.swing.JTextField nota2;
    public javax.swing.JTextField nota3;
    public javax.swing.JTextField notaFinal;
    public javax.swing.JTextField notaFinalValue;
    private javax.swing.JPanel pCabecera;
    private javax.swing.JPanel pCuerpo;
    // End of variables declaration//GEN-END:variables


    /**
     * Acción para guardar Notas (asociado al botón GUARDAR)
     * @param a Acción
     */
    public void addGuardarListener(ActionListener a){
        btnGuardar.addActionListener(a);
    }

    /**
     * Acción para Ocultar el formulario
     * @param a Acción
     */
    public void addCerrarListener(ActionListener a){
        btnCerrar.addActionListener(a);
    }

    /**
     * Listener para verificar si los caracteres introducidos en los jTextField
     * de las notas son válidos
     * @param evt evento de teclado
     */
    public void addValidarNotasKeyTyped(KeyListener evt){
        nota1.addKeyListener(evt);
        nota2.addKeyListener(evt);
        nota3.addKeyListener(evt);
    }

    /**
     * Formatear nota introducida (2 decimales max)
     * @param evt evento salir de focus del jTextField
     */
    public void addFormatearNota(FocusListener evt  ){
        nota1.addFocusListener(evt);
        nota2.addFocusListener(evt);
        nota3.addFocusListener(evt);
    }



    /**
     * Obtiene las notas introducidas por el usuario
     * @return Lista con las notas introducidas en el formulario
     */
    public ArrayList<Double> getNotas(){
        ArrayList<Double> notas = new ArrayList<Double>();

        notas.add(getN1());
        notas.add(getN2());
        notas.add(getN3());

        return notas;
    }


    /**
     * Devuelve la nota introducida como un Double o 0.0 si es vacio
     * @return nota del primer parcial
     */
    public Double getN1(){
        Double n;
        try{
            n=Double.parseDouble(nota1.getText());
        } catch (NumberFormatException e) {
            n=new Double(0.0);
        }

        return n;
    }

    /**
     * Devuelve la nota introducida como un Double o 0.0 si es vacio
     * @return nota del segundo parcial
     */
    public Double getN2(){
        Double n;
        try{
            n=Double.parseDouble(nota2.getText());
        } catch (NumberFormatException e) {
            n=new Double(0.0);
        }

        return n;
    }

    /**
     * Devuelve la nota introducida como un Double o 0.0 si es vacio
     * @return nota del tercer parcial
     */
    public Double getN3(){
        Double n;
        try{
            n=Double.parseDouble(nota3.getText());
        } catch (NumberFormatException e) {
            n=new Double(0.0);
        }

        return n;
    }


    /**
     * Devuelve la nota introducida como un Double o 0.0 si es vacio
     * @return nota final
     */
    public Double getNFinal(){
        Double n;
        try{
            n=Double.parseDouble(notaFinalValue.getText());
        } catch (NumberFormatException e) {
            n=new Double(0.0);
        }

        return n;
    }


    /**
     * Devuelve el contenido de la nota del primer parcial
     * @return nota del primer parcial
     */
    public String getNota1(){
        return nota1.getText();
    }


    /**
     * Devuelve el contenido de la nota del segundo parcial
     * @return nota del segundo parcial
     */
    public String getNota2(){
        return nota2.getText();
    }

    /**
     * Devuelve el contenido de la nota del tercer parcial
     * @return nota del tercer parcial
     */
    public String getNota3(){
        return nota3.getText();
    }

    /**
     * Devuelve el contenido de la nota final calculada
     * @return nota final
     */
    public String getNotaFinal(){
        return notaFinal.getText();
    }

    /**
     * Escribe la nota final calculada
     * @param nota final
     */
    public void setNotaFinal(String nota){
        notaFinal.setText(nota);

        notaFinalValue.setText(nota);

        if (Double.parseDouble(nota) < 5){
            notaFinal.setText("SUSPENSO");
        } else if (Double.parseDouble(nota)>=5 && Double.parseDouble(nota)<7) {
            notaFinal.setText("APROBADO");
        } else if (Double.parseDouble(nota)>=7 && Double.parseDouble(nota)<9) {
            notaFinal.setText("NOTABLE");
        } else {
            notaFinal.setText("SOBRESALIENTE");
        }

    }

    /**
     * Escribe en el jTextField correspondiente la nota del primer parcial
     * @param nota primer parcial
     */
    public void setNota1(String nota){
        nota1.setText(nota);
    }

    /**
     * Escribe en el jTextField correspondiente la nota del segundo parcial
     * @param nota segundo parcial
     */
    public void setNota2(String nota){
        nota2.setText(nota);
    }

    /**
     * Escribe en el jTextField correspondiente la nota del tercer parcial
     * @param nota tercer parcial
     */
    public void setNota3(String nota){
        nota3.setText(nota);
    }


    /**
     * Escribe en el label correspondiente el nombre del Alumno
     * @param alumno
     */
    public void setAlumno(String alumno) {
        lbAlumnoValue.setText(alumno);
    }

    /**
     * Escribe en el label correspondiente el nombre de la Asignatura
     * @param asignatura
     */
    public void setAsignatura(String asignatura) {
        lbAsignaturaValue.setText(asignatura);
    }

    /**
     * Escribe en el label correspondiente el Curso correspondiente
     * @param curso
     */
    public void setCurso(String curso) {
        lbCursoValue.setText(curso);
    }

    /**
     * Escribe en el label correspondiente el Grupo
     * @param grupo
     */
    public void setGrupo(String grupo) {
        lbGrupoValue.setText(grupo);
    }

    /**
     * Devuelve el contenido del label correspondiente
     * @return nombre del Alumno
     */
    public String getAlumno() {
        return lbAlumnoValue.getText();
    }

    /**
     * Devuelve el contenido del label correspondiente
     * @return nombre de la Asignatura
     */
    public String getAsignatura() {
        return lbAsignaturaValue.getText();
    }

    /**
     * Devuelve el contenido del label correspondiente
     * @return Curso
     */
    public String getCurso() {
        return lbCursoValue.getText();
    }

    /**
     * Devuelve el contenido del label correspondiente
     * @return Grupo
     */
    public String getGrupo() {
        return lbGrupoValue.getText();
    }




    /**
     * Métodos Getters y Setters
     */


    /**
     * Método Get
     * @return Año de Matriculación
     */
    public Integer getAnio_mat() {
        return anio_mat;
    }

    /**
     * Método Get
     * @return Código de asignatura
     */
    public Integer getCodasignatura() {
        return codasignatura;
    }

    /**
     * Método Get
     * @return Identificador del Alumno
     */
    public Integer getId_alumno() {
        return id_alumno;
    }

    /**
     * Método Set
     * @param anio_mat Año de Matriculación
     */
    public void setAnio_mat(Integer anio_mat) {
        this.anio_mat = anio_mat;
    }

    /**
     * Método Set
     * @param codasignatura Código de asignatura
     */
    public void setCodasignatura(Integer codasignatura) {
        this.codasignatura = codasignatura;
    }

    /**
     * Método Set
     * @param id_alumno Identificador del Alumno
     */
    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }


}
