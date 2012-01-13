/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EscuelaVistaPrincipal.java
 *
 * Created on 02-ene-2012, 1:38:51
 */
//package colegio_inftel;
package es.uma.masterinftel.colegio_inftel.vistas;
/************************************************************************/
import es.uma.masterinftel.colegio_inftel.modelo.dao.EscuelaModeloDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.EscuelaModeloDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.Constantes;
import es.uma.masterinftel.colegio_inftel.modelo.dao.AsignaturasDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.AsignaturasDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.Conexion;
import es.uma.masterinftel.colegio_inftel.utilidades.*;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.event.DocumentListener;
import javax.swing.event.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import es.uma.masterinftel.colegio_inftel.utilidades.Curso;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Iterator;
/*************************************************************************/

/**
 *
 * @author Proyectos
 */
public class EscuelaVistaPrincipal extends javax.swing.JFrame {
  /*****************************************************/
    private EscuelaModeloDAO m_modelo;
    EscuelaModeloDTO dto = new EscuelaModeloDTO();
     DefaultComboBoxModel comboModelo = new DefaultComboBoxModel();
     DefaultComboBoxModel comboModeloGrupo = new DefaultComboBoxModel();
     DefaultComboBoxModel comboModeloAsignatura = new DefaultComboBoxModel();
     //Mirar el customize code de los combos
    public boolean bJefeDeEstudios;
    //public int rol=0;
/**************************************************************/
    
    /** Creates new form EscuelaVistaPrincipal */
    public EscuelaVistaPrincipal(EscuelaModeloDAO modelo) {
        m_modelo = modelo;
        dto.setId_cursos_fk(1);
            dto.setId_grupo_kf(1);
            dto.setCodasignatura_fk(1);
           
    
        //DefaultTableModel model = new DefaultTableModel();
        //m_modelo.obtenerDatos(tablaNotas);
       // jTable1 = m_modelo.obtenerDatos();
        // Se mete todo en un try por los posibles errores de MySQL
     //   m_modelo.rellenaTabla(1,1,1);
            
              
            m_modelo.rellenaTabla(dto);
      // copiarDatos(m_modelo.tabla,jTable1);
        
        //Indica si el usuario tiene rol de jefe de estudios
       
        initComponents();
        //Iniciamos combo
     
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboCurso = new javax.swing.JComboBox();
        comboGrupo = new javax.swing.JComboBox();
        comboAsignatura = new javax.swing.JComboBox();
        curso = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btEstadisticas = new javax.swing.JButton();
        btCalificaciones = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btIncidencias = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 255, 254));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel1.setText("Profesor:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel2.setText("Año Escolar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 13));
        jLabel3.setForeground(new java.awt.Color(140, 140, 140));
        jLabel3.setText("Mónica Trella");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 13));
        jLabel4.setForeground(new java.awt.Color(140, 140, 140));
        jLabel4.setText("2011");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(918, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(29, 29, 29))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        comboCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1º ESO", "2º ESO", "3º ESO", "4º ESO","1º BACHILLERATO","2º BACHILLERATO" }));

        comboGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" ,"CIENTIFICO-TECNOLOGICO" , "LETRAS" , "HUMANIDADES" }));

        comboAsignatura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matemáticas", "Lengua", "Historia", "Inglés", "Informática" }));

        curso.setText("Curso");

        jLabel6.setText("Grupo");

        jLabel7.setText("Asignatura");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(curso)
                    .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(572, 572, 572))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(curso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(170, 170, 170))
        );

        btEstadisticas.setText("Ver Estadísticas");

        btCalificaciones.setText("Editar calificaciones");

        jLabel5.setText("Aprobados: ");

        jLabel9.setText("Suspensos:");

        jLabel10.setText("Nota media:");

        jLabel11.setText("Nota mínima:");

        jLabel12.setText("Nota máxima:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addGap(56, 56, 56)
                .addComponent(jLabel11)
                .addGap(55, 55, 55)
                .addComponent(jLabel12)
                .addContainerGap(403, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        btIncidencias.setText("Editar Incidencias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btEstadisticas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 599, Short.MAX_VALUE)
                        .addComponent(btCalificaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIncidencias)
                        .addGap(81, 81, 81)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEstadisticas)
                    .addComponent(btCalificaciones)
                    .addComponent(btIncidencias))
                .addContainerGap())
        );

        jLabel8.setText("Buscar alumno:");

        btBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBuscar)
                .addContainerGap(518, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTable1.setModel(m_modelo.modelo);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(10).setMinWidth(0);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(11).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(11).setMinWidth(0);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCalificaciones;
    private javax.swing.JButton btEstadisticas;
    private javax.swing.JButton btIncidencias;
    private javax.swing.JComboBox comboAsignatura;
    private javax.swing.JComboBox comboCurso;
    private javax.swing.JComboBox comboGrupo;
    private javax.swing.JLabel curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
 
   
  public int getCurso() {
       return comboCurso.getSelectedIndex()+1;
    }
   public int getGrupo(){
   return comboGrupo.getSelectedIndex()+1;
   }
   public int getAsignatura(){
   return comboAsignatura.getSelectedIndex()+1;
   }
   public Object getCursoItem(){
   return comboCurso.getSelectedItem();
   }
   public Object getGrupoItem(){
   return comboGrupo.getSelectedItem();
   }
   public Object getAsignaturaItem(){
   return comboAsignatura.getSelectedItem();
   }
   public String getNombre(){
   return textNombre.getText();
   }
   public int getFila(){
   return jTable1.getSelectedRow();
   }
    public Object getTableData(int rowIndex, int colIndex){
  return jTable1.getModel().getValueAt(rowIndex, colIndex);
  }  
   // public void addTableListener(TableModelListener tab){
 //  jTable1.getModel().addTableModelListener(tab);
 //  }
   
    public void addSearchListener(ActionListener bus) {
        btBuscar.addActionListener(bus);
    }
    public void addFilterName(DocumentListener name){
        textNombre.getDocument().addDocumentListener(name);
    }

    public void addAnotarNotasListener(ActionListener a){
        btCalificaciones.addActionListener(a);
    }
    public void addAnotarIncidenciasListener(ActionListener a){
        btIncidencias.addActionListener(a);
    }
/*********************************************************/
    public void setRolJefeDeEstudios(Integer rolUsuario,Integer idProfesor) {
      
        bJefeDeEstudios = (rolUsuario == Constantes.ROL_JEFE_DE_ESTUDIOS);
        iniciaComboCurso(bJefeDeEstudios,idProfesor);
    }
/*****************************************************/

/**************************************************************************/
    public void iniciaComboCurso(boolean jefe,Integer idProfesor) {
     ArrayList res,res2;
     String cursos[] = {"1º ESO","2º ESO","3º ESO","4º ESO","1º BACHILLERATO","2º BACHILLERATO"};
     String grupos[] = {"A","LETRAS","HUMANIDADES"};
     String asignaturas[] = {"MATEMATICAS","LENGUA","HISTORIA","INGLES","INFORMATICA"};
     Connection cnn = (Connection) Conexion.conectar();
     AsignaturasDAO dao = new AsignaturasDAO();
     try{
     if(jefe){
//Inicializar comboCurso
         comboModelo.addElement(new Curso("1º ESO", "1"));
comboModelo.addElement(new Curso("2º ESO", "2"));
comboModelo.addElement(new Curso("3º ESO", "3"));
comboModelo.addElement(new Curso("4º ESO", "4"));
comboModelo.addElement(new Curso("1º BACHILLERATO", "5"));
comboModelo.addElement(new Curso("2º BACHILLERATO", "6"));
//Inicializar comboGrupo
comboModeloGrupo.addElement(new Grupo("A", "1"));
comboModeloGrupo.addElement(new Grupo("LETRAS", "2"));
comboModeloGrupo.addElement(new Grupo("HUMANIDADES", "3"));
//Inicializar comboAsignatura
comboModeloAsignatura.addElement(new Asignatura("MATEMATICAS", 1));
comboModeloAsignatura.addElement(new Asignatura("LENGUA", 2));
comboModeloAsignatura.addElement(new Asignatura("HISTORIA", 3));
comboModeloAsignatura.addElement(new Asignatura("INGLES", 4));
comboModeloAsignatura.addElement(new Asignatura("INFORMATICA", 5));


        // res2 = dao.obtenerAsignaturas(cnn);
       //  Iterator j = res2.listIterator();
       //   while(j.hasNext()){
       //     AsignaturasDTO b = (AsignaturasDTO) j.next();
       //  comboModelo.addElement(new Curso(cursos[b.getImparte_cursos_id_fk()-1], (b.getImparte_cursos_id_fk()).toString()));
         // if((b.getImparte_cursos_id_fk()-1)<4){
        //  comboModeloGrupo.addElement(new Grupo(grupos[0], (b.getImparte_cursos_id_fk()).toString()));
        //  }
       //   else{
       //   comboModeloGrupo.addElement(new Curso(grupos[b.getImparte_cursos_id_fk()-4], (b.getImparte_cursos_id_fk()).toString()));
       //   }
       //   }
}
else{
        comboModeloAsignatura.addElement(new Asignatura(asignaturas[idProfesor-1],idProfesor));
         res = dao.obtenerAsignaturasByProfesor(cnn, idProfesor);
         
        Iterator i = res.listIterator();
        while(i.hasNext()){
            AsignaturasDTO a = (AsignaturasDTO) i.next();

           // System.out.println(a.getCodasignatura()+","+a.getDesc()+","+a.getProfesor_id_fk()+","+a.getImparte_cursos_id_fk());
comboModelo.addElement(new Curso(cursos[a.getImparte_cursos_id_fk()-1], (a.getImparte_cursos_id_fk()).toString()));
        
        if(a.getImparte_cursos_id_fk()<4){
        comboModeloGrupo.addElement(new Grupo(grupos[a.getImparte_cursos_id_fk()-1], (a.getImparte_cursos_id_fk()).toString()));
        
        
        
        }
        }
     }
 } catch (Exception e)
        {
            e.printStackTrace();
        }

}
    public void setNotas(double dato,int columna){
    int fila = getFila();
    //Notas n;
    //setTableData(dato,fila,columna);
    setTableData(2,1,6);
    } 
    public void setTableData(double dato,int rowIndex, int colIndex){
  //jTable1.getModel().setValueAt(dato, rowIndex, colIndex);
        //jTable1.setValueAt(dato, rowIndex, colIndex);
        m_modelo.modelo.setValueAt(dato, rowIndex, colIndex);
  }
    
 /**************************************************************************/       
}