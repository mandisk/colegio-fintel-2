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

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboCurso = new javax.swing.JComboBox();
        comboGrupo = new javax.swing.JComboBox();
        comboAsignatura = new javax.swing.JComboBox();
        curso = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btEstadisticas = new javax.swing.JButton();
        btCalificaciones = new javax.swing.JButton();
        btIncidencias = new javax.swing.JButton();
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
        jLabel4.setText("2011");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 48));
        jLabel5.setForeground(new java.awt.Color(152, 151, 151));
        jLabel5.setText("COLEGIO INFTEL");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        curso.setText("Curso");

        jLabel6.setText("Grupo");

        jLabel7.setText("Asignatura");

        jLabel8.setText("Buscar alumno:");

        btBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(curso)
                            .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(comboAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(467, 467, 467))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(curso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(126, 126, 126))
        );

        comboCurso.setModel(comboModelo);
        comboGrupo.setModel(comboModeloGrupo);
        comboAsignatura.setModel(comboModeloAsignatura);

        btEstadisticas.setText("Ver Estadísticas");

        btCalificaciones.setText("Editar calificaciones");

        btIncidencias.setText("Editar Incidencias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEstadisticas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
                .addComponent(btCalificaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIncidencias)
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEstadisticas)
                    .addComponent(btCalificaciones)
                    .addComponent(btIncidencias))
                .addContainerGap())
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
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
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
    public void addVerEstadisticasListener(ActionListener a){
    btEstadisticas.addActionListener(a);
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
