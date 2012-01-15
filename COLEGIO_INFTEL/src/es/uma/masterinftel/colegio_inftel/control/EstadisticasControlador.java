/**
 * EstadisticasControlador.java
 *
 */
package es.uma.masterinftel.colegio_inftel.control;

import com.mysql.jdbc.Connection;
import es.uma.masterinftel.colegio_inftel.control.EscuelaControlador.ObjCombo;
import es.uma.masterinftel.colegio_inftel.modelo.dao.AsignaturasDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.CalificacionesDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.CursosDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.MatriculacionesDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.ProfesoresDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.AsignaturasDTO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.CursosDTO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.ProfesoresDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.Conexion;
import es.uma.masterinftel.colegio_inftel.utilidades.MatriculadosAsignaturas;
import es.uma.masterinftel.colegio_inftel.vistas.EstadisticasVista;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Controlador para Estadisticas
 *
 * @author Luis Jarén
 * @version v1.0 Diciembre-2011
 */
public class EstadisticasControlador {
     
    private EstadisticasVista m_vista;
    
    /**
     * Constructor de la clase
     *
     * @param vista clase formulario para visualización
     */

    public EstadisticasControlador( EstadisticasVista vista) {
        try{
        
        m_vista = vista;

        //Aquí se localizan los métodos de escucha
        m_vista.addEstadistica1Listener(new Estadistica1Listener());
        m_vista.addEstadistica2Listener(new Estadistica2Listener());
        m_vista.addEstadistica3Listener(new Estadistica3Listener());

        cargarCombos();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Realiza la carga de los JComboBox de la vista Estadisticas
     *
     */


    private void cargarCombos() throws SQLException{
        ArrayList anios = new ArrayList();
        ArrayList profesores = new ArrayList();
        ArrayList asignaturas = new ArrayList();
        ArrayList cursos = new ArrayList();
        Connection cnn = (Connection) Conexion.conectar();
        cargarCombosAnio(anios);
        cargarComboProfesores(profesores);
        cargarComboAsignaturas(cnn,asignaturas);
        cargarComboCursos(cnn,cursos);
    }
     //método para cargar combos

    /**
     * Realiza la carga de los items de los JComboBox años de matriculación
     *
     * @param anios array de años de matriculación
     */
    public void cargarCombosAnio( ArrayList anios) throws SQLException{
        //CARGA DEL COMBO AÑOS MATRICULACION
        System.out.println("Cargando combo años");
        MatriculacionesDAO matriculacionesDAO = new MatriculacionesDAO();
        Connection cnn = (Connection) Conexion.conectar();
        anios = (ArrayList) matriculacionesDAO.obtener_anios_matriculaciones(cnn);

        Iterator i = anios.iterator();
        while (i.hasNext()) {

            Integer x = (Integer) i.next();
            m_vista.anioMatriculadosComboBox.addItem(new Integer(x));
        }

        //Seleccionamos por defecto el año en curso
        m_vista.anioMatriculadosComboBox.setSelectedIndex(anios.size() - 1);

    }
    /**
     * Realiza la carga de los items de los JComboBox de nombres de profesores
     *
     * @param profesores array con los nombres de los profesores
     */
    public void cargarComboProfesores(ArrayList profesores) throws SQLException{

        System.out.println("Cargando combo profesores");
         // CARGA DEL COMBO PROFESORES
        ProfesoresDAO profesoresDAO = new ProfesoresDAO();
        profesores = profesoresDAO.obtenerProfesores();
        Iterator j = profesores.iterator();
        ProfesoresDTO profesoresDTO = new ProfesoresDTO();

        while (j.hasNext()) {
            profesoresDTO = (ProfesoresDTO) j.next();
            String nombre = profesoresDTO.getNombre() + " " + profesoresDTO.getApellido1() + " " + profesoresDTO.getApellido2();
            Integer id = profesoresDTO.getId();
            ObjCombo profesor = null ;
            profesor.id = id;
            profesor.nombre=nombre;
            m_vista.profesorComboBox.addItem(profesor);
        }

        ObjCombo profesor = (ObjCombo) m_vista.profesorComboBox.getSelectedItem();
        System.out.println("ID: " + profesor.id);
    }
    //método para cargar combo asignaturas
    /**
     * Realiza la carga de los items de los JComboBox de asignaturas
     *
     * @param cnn conexion a la BD
     * @param asignaturas array de asignaturas
     */
    public void cargarComboAsignaturas(Connection cnn, ArrayList asignaturas) throws SQLException{
        System.out.println("Cargando combo asignaturas");
        AsignaturasDAO asignaturasDAO = new AsignaturasDAO();
        asignaturas = asignaturasDAO.obtenerAsignaturas(cnn);
        Iterator j = asignaturas.iterator();
        AsignaturasDTO asignaturasDTO = new AsignaturasDTO();

        while (j.hasNext()) {
            
            asignaturasDTO = (AsignaturasDTO) j.next();
            ObjCombo asignatura = null;
            asignatura.nombre = asignaturasDTO.getDesc();
            asignatura.id= asignaturasDTO.getCodasignatura();
            m_vista.asignaturaComboBox.addItem(asignatura);
        }
        ObjCombo asignatura = (ObjCombo) m_vista.asignaturaComboBox.getSelectedItem();
        System.out.println("ID: " + asignatura.getId());

    }
    //método para cargar combo cursos
    /**
     * Realiza la carga de los items de los JComboBox de cursos
     *
     * @param cnn conexion a BD
     * @param cursos array de cursos
     * 
     */
    public void cargarComboCursos(Connection cnn, ArrayList cursos) throws SQLException{
        System.out.println("Cargando combo cursos");
        CursosDAO cursoDAO = new CursosDAO();
        cursos = cursoDAO.obtenerCursos(cnn);
        Iterator j = cursos.iterator();
        CursosDTO cursosDTO = new CursosDTO();

        while (j.hasNext()) {

            cursosDTO = (CursosDTO) j.next();
            ObjCombo curso = null;
            curso.nombre = cursosDTO.getDesc();
            curso.id = cursosDTO.getId();
            m_vista.cursoComboBox.addItem(curso);
        }
        ObjCombo curso = (ObjCombo) m_vista.cursoComboBox.getSelectedItem();
        System.out.println("ID: " + curso.getId());

    }

     /**
     * Listener para el botón MOSTRAR ESTADISTICA 1
     */

    public class Estadistica1Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Pulsado boton1");
            m_vista.setVisible(false);
            Connection cnn = (Connection) Conexion.conectar();
            CalificacionesDAO calificacion = new CalificacionesDAO();

            try {

                ObjCombo asignatura = (ObjCombo) m_vista.asignaturaComboBox.getSelectedItem();
                ObjCombo curso = (ObjCombo) m_vista.cursoComboBox.getSelectedItem();
                Integer numAprobados = null;
                try {
                    numAprobados = calificacion.numAprobados(cnn, (Integer) asignatura.getId(),
                            (Integer) m_vista.anioMatriculadosComboBox.getSelectedItem(),
                            curso.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(EstadisticasControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                Integer numMatriculados = calificacion.numMatriculados(cnn, asignatura.getId(),
                        (Integer) m_vista.anioMatriculadosComboBox.getSelectedItem(),
                        curso.getId());
                if (numMatriculados == 0) {
                    m_vista.printMensajeSinDatos();
                } else {
                    float porcAprobados = ((float) numAprobados / (float) numMatriculados) * 100;
                    float porcSuspensos = (((float) numMatriculados - (float) numAprobados) / (float) numMatriculados) * 100;

                    //Crear un dataset
                    DefaultPieDataset data = new DefaultPieDataset();
                    data.setValue("Aprobados", porcAprobados);
                    data.setValue("Suspensos", porcSuspensos);

                    //Creamos un Chart
                    JFreeChart chart = ChartFactory.createPieChart(
                            "(%) Aprobados y Suspensos en "
                            + m_vista.asignaturaComboBox.getSelectedItem()
                            + " de " + m_vista.cursoComboBox.getSelectedItem() + " ("
                            + m_vista.anioMatriculadosComboBox.getSelectedItem() + ")", //Títrulo del gráfico
                            data,
                            true,//Leyenda
                            true,//ToolTips
                            true);
                    //Creamos una especie de frame y mostramos el JFreeChart en él
                    //Este constructor nos pide el título del Chart y el chart creado
                    ChartFrame frame = new ChartFrame("Estadística--Aprobados/Suspensos por Asignatura y Curso", chart);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                    //Listener para cerrar estadistica
                    frame.addWindowListener(new java.awt.event.WindowAdapter(){
                        public void windowClosing(WindowEvent e){
                            m_vista.setVisible(true);
                        }
                    });
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null,
                        "Se ha producido un error de Base de Datos");
            }
        }
    }
    /**
     * Listener para el botón MOSTRAR ESTADISTICA 2
     */
    public class Estadistica2Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Pulsado boton2");
            m_vista.setVisible(false);
            Connection cnn = (Connection) Conexion.conectar();
            CalificacionesDAO calificacion = new CalificacionesDAO();

            try {

                ObjCombo profesor = (ObjCombo) m_vista.profesorComboBox.getSelectedItem();

                Integer numAprobados = null;
                try {
                    numAprobados = calificacion.numAprobados(cnn, profesor.id, (Integer) m_vista.anioMatriculadosComboBox.getSelectedItem());
                } catch (SQLException ex) {
                    Logger.getLogger(EstadisticasControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                Integer numMatriculados = calificacion.numMatriculados(cnn, profesor.id, (Integer) m_vista.anioMatriculadosComboBox.getSelectedItem());

                if (numMatriculados == 0) {
                    m_vista.printMensajeSinDatos();
                } else {
                    float porcAprobados = ((float) numAprobados / (float) numMatriculados) * 100;
                    float porcSuspensos = (((float) numMatriculados - (float) numAprobados) / (float) numMatriculados) * 100;

                    //Crear un dataset
                    DefaultPieDataset data = new DefaultPieDataset();
                    data.setValue("Aprobados", porcAprobados);
                    data.setValue("Suspensos", porcSuspensos);

                    //Creamos un Chart
                    JFreeChart chart = ChartFactory.createPieChart(
                            "(%) Aprobados y Suspensos de "
                            + m_vista.profesorComboBox.getSelectedItem() + " ("
                            + m_vista.anioMatriculadosComboBox.getSelectedItem() + ")", //Títrulo del gráfico
                            data,
                            true,//Leyenda
                            true,//ToolTips
                            true);
                    //Creamos una especie de frame y mostramos el JFreeChart en él
                    //Este constructor nos pide el título del Chart y el chart creado
                    ChartFrame frame = new ChartFrame("Estadística--Aprobados/Suspensos por Profesor y Año", chart);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    //Listener para cerrar estadistica
                    frame.addWindowListener(new java.awt.event.WindowAdapter(){
                        public void windowClosing(WindowEvent e){
                            m_vista.setVisible(true);
                        }
                    });
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null,
                        "Se ha producido un error de Base de Datos");
            }
        }
    }
    /**
     * Listener para el botón MOSTRAR ESTADISTICA 3
     */
    public class Estadistica3Listener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.out.println("Pulsado botonf3");
            m_vista.setVisible(false);
            Connection cnn = (Connection) Conexion.conectar();
            MatriculacionesDAO matriculacion = new MatriculacionesDAO();
            AsignaturasDAO asignatura= new AsignaturasDAO();
        try {

            ArrayList<MatriculadosAsignaturas> matriculados = new ArrayList<MatriculadosAsignaturas>();
                try {
                    matriculados = matriculacion.obtenerNumMatriculadosAsignatura(cnn,(Integer)m_vista.anioMatriculadosComboBox.getSelectedItem());
                } catch (SQLException ex) {
                    Logger.getLogger(EstadisticasControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            //Crear un dataset
            DefaultPieDataset data = new DefaultPieDataset();
            for(int i=0; i < matriculados.size();i++){
                MatriculadosAsignaturas matriculadosAsignatura = matriculados.get(i);
                data.setValue(asignatura.obtenerAsignaturas(cnn).get(i).getDesc(), matriculadosAsignatura.getAlumnosMatricualdos());
            }
            //Creamos un Chart
            JFreeChart chart = ChartFactory.createPieChart(
                    "Nº de Alumnos Matriculados por Asignatura ", //Títrulo del gráfico
                    data,
                    true,//Leyenda
                    true,//ToolTips
                    true);
            //Creamos una especie de frame y mostramos el JFreeChart en él
            //Este constructor nos pide el título del Chart y el chart creado
            ChartFrame frame = new ChartFrame("Estadística--Alumnos Matriculados por Asignatura", chart);
            frame.setPreferredSize(new Dimension(1000,750));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            //Listener para cerrar estadistica
            frame.addWindowListener(new java.awt.event.WindowAdapter(){
                        public void windowClosing(WindowEvent e){
                            m_vista.setVisible(true);
                        }
                    });
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error de Base de Datos");
        }

        }

    }
    
}
