/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.masterinftel.colegio_inftel.control;

import colegio_inftel.*;
import com.mysql.jdbc.Connection;
import es.uma.masterinftel.colegio_inftel.modelo.dao.AsignaturasDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.CalificacionesDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.CursosDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.MatriculacionesDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.ProfesoresDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.AsignaturasDTO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.CursosDTO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.ProfesoresDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.Asignatura;
import es.uma.masterinftel.colegio_inftel.utilidades.Conexion;
import es.uma.masterinftel.colegio_inftel.utilidades.Curso;
import es.uma.masterinftel.colegio_inftel.utilidades.MatriculadosAsignaturas;
import es.uma.masterinftel.colegio_inftel.utilidades.Profesor;
import es.uma.masterinftel.colegio_inftel.vistas.EstadisticasVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 *
 * @author Proyectos
 */
public class EstadisticasControlador {
     //Necesitamos que el controlador interactue con el Modelo y la vista
    //private EstadisticasModelo m_modelo;
    private EstadisticasVista m_vista;
    
    /** Constructor */
    public EstadisticasControlador( EstadisticasVista vista) throws SQLException{
        //m_modelo = modelo;
        m_vista = vista;

        //Aquí se localizan los métodos de escucha
        m_vista.addEstadistica1Listener(new Estadistica1Listener());
        m_vista.addEstadistica2Listener(new Estadistica2Listener());
        m_vista.addEstadistica3Listener(new Estadistica3Listener());
        cargarCombos();
    }


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

    //método para cargar combo años matriculacion
    public void cargarCombosAnio( ArrayList anios) throws SQLException, SQLException{
        //CARGA DEL COMBO AÑOS MATRICULACION
        System.out.println("Cargando combo años");
        MatriculacionesDAO matriculacionesDAO = new MatriculacionesDAO();
        Connection cnn = (Connection) Conexion.conectar();
        anios = (ArrayList) matriculacionesDAO.obtener_anios_matriculaciones(cnn);

        Iterator i = anios.iterator();
        while (i.hasNext()) {

            Integer x = (Integer) i.next();
            m_vista.getAnioMatriculadosComboBox().addItem(new Integer(x));
        }

        //Seleccionamos por defecto el año en curso
        m_vista.getAnioMatriculadosComboBox().setSelectedIndex(anios.size() - 1);

    }
    //método para cargar combo profesores
    public void cargarComboProfesores(ArrayList profesores) throws SQLException{

        System.out.println("Cargando combo profesores");
         // CARGA DEL COMBO PROFESORES
        ProfesoresDAO profesoresDAO = new ProfesoresDAO();
        profesores = profesoresDAO.obtenerProfesores();
        Iterator j = profesores.iterator();
        ProfesoresDTO profesoresDTO = new ProfesoresDTO();

        while (j.hasNext()) {
            Profesor profesor = new Profesor();
            profesoresDTO = (ProfesoresDTO) j.next();
            profesor.nombre = profesoresDTO.getNombre() + " " + profesoresDTO.getApellido1() + " " + profesoresDTO.getApellido2();
            profesor.id = profesoresDTO.getId();
            m_vista.getProfesorComboBox().addItem(profesor);
        }

        Profesor profesor = (Profesor) m_vista.getProfesorComboBox().getSelectedItem();
        System.out.println("ID: " + profesor.id);
    }
    //método para cargar combo asignaturas
    public void cargarComboAsignaturas(Connection cnn, ArrayList asignaturas) throws SQLException{
        System.out.println("Cargando combo asignaturas");
        AsignaturasDAO asignaturasDAO = new AsignaturasDAO();
        asignaturas = asignaturasDAO.obtenerAsignaturas(cnn);
        Iterator j = asignaturas.iterator();
        AsignaturasDTO asignaturasDTO = new AsignaturasDTO();

        while (j.hasNext()) {
            
            asignaturasDTO = (AsignaturasDTO) j.next();
            Asignatura asignatura = new Asignatura(asignaturasDTO.getDesc(),asignaturasDTO.getCodasignatura());
            m_vista.asignaturaComboBox.addItem(asignatura);
        }
        Asignatura asignatura = (Asignatura) m_vista.asignaturaComboBox.getSelectedItem();
        System.out.println("ID: " + asignatura.getId());

    }
    //método para cargar combo cursos
    public void cargarComboCursos(Connection cnn, ArrayList cursos) throws SQLException{
        System.out.println("Cargando combo cursos");
        CursosDAO cursoDAO = new CursosDAO();
        cursos = cursoDAO.obtenerCursos(cnn);
        Iterator j = cursos.iterator();
        CursosDTO cursosDTO = new CursosDTO();

        while (j.hasNext()) {

            cursosDTO = (CursosDTO) j.next();
            Curso curso = new Curso(cursosDTO.getDesc(),Integer.toString(cursosDTO.getId()));
            m_vista.cursoComboBox.addItem(curso);
        }
        Curso curso = (Curso) m_vista.cursoComboBox.getSelectedItem();
        System.out.println("ID: " + curso.getId());

    }

    public class Estadistica1Listener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.out.println("Pulsado boton1");
            Connection cnn = (Connection) Conexion.conectar();
            CalificacionesDAO calificacion = new CalificacionesDAO();

        try {

            Asignatura asignatura = (Asignatura) m_vista.asignaturaComboBox.getSelectedItem();
            Curso curso = (Curso) m_vista.cursoComboBox.getSelectedItem();
            Integer numAprobados = null;
                try {
                    numAprobados = calificacion.numAprobados(cnn, (Integer) asignatura.getId(),
                                                            (Integer) m_vista.getAnioMatriculadosComboBox().getSelectedItem(),
                                                            Integer.parseInt(curso.getId()));
                } catch (SQLException ex) {
                    Logger.getLogger(EstadisticasControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            Integer numMatriculados = calificacion.numMatriculados(cnn,asignatura.getId(),
                                                                  (Integer) m_vista.getAnioMatriculadosComboBox().getSelectedItem(),
                                                                  Integer.parseInt(curso.getId()));

            System.out.println("asignatura.id: " + asignatura.getId());
            System.out.println("curso.id: " + curso.getId());
            System.out.println("Año: " + m_vista.getAnioMatriculadosComboBox().getSelectedItem());
            System.out.println("numAprobados: " + numAprobados);
            System.out.println("numMatriculados: " + numMatriculados);
            
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
                    + " de "+ m_vista.cursoComboBox.getSelectedItem()+" ("
                    + m_vista.getAnioMatriculadosComboBox().getSelectedItem() + ")", //Títrulo del gráfico
                    data,
                    true,//Leyenda
                    true,//ToolTips
                    true);
            //Creamos una especie de frame y mostramos el JFreeChart en él
            //Este constructor nos pide el título del Chart y el chart creado
            ChartFrame frame = new ChartFrame("Estadística--Aprobados/Suspensos por Asignatura y Curso", chart);
            frame.pack();
            frame.setVisible(true);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error de Base de Datos");
        }
     }

    }
    public class Estadistica2Listener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.out.println("Pulsado boton2");
            Connection cnn = (Connection) Conexion.conectar();
            CalificacionesDAO calificacion = new CalificacionesDAO();

        try {

            Profesor profesor = (Profesor) m_vista.getProfesorComboBox().getSelectedItem();

            Integer numAprobados = null;
                try {
                    numAprobados = calificacion.numAprobados(cnn, profesor.id, (Integer) m_vista.getAnioMatriculadosComboBox().getSelectedItem());
                } catch (SQLException ex) {
                    Logger.getLogger(EstadisticasControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            Integer numMatriculados = calificacion.numMatriculados(cnn, profesor.id, (Integer) m_vista.getAnioMatriculadosComboBox().getSelectedItem());

            System.out.println("profesor.id: " + profesor.id);
            System.out.println("Año: " + m_vista.getAnioMatriculadosComboBox().getSelectedItem());
            System.out.println("numAprobados: " + numAprobados);
            System.out.println("numAprobados: " + numMatriculados);
            
            float porcAprobados = ((float) numAprobados / (float) numMatriculados) * 100;
            float porcSuspensos = (((float) numMatriculados - (float) numAprobados) / (float) numMatriculados) * 100;

            //Crear un dataset
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Aprobados", porcAprobados);
            data.setValue("Suspensos", porcSuspensos);

            //Creamos un Chart
            JFreeChart chart = ChartFactory.createPieChart(
                    "(%) Aprobados y Suspensos de "
                    + m_vista.getProfesorComboBox().getSelectedItem() + " ("
                    + m_vista.getAnioMatriculadosComboBox().getSelectedItem() + ")", //Títrulo del gráfico
                    data,
                    true,//Leyenda
                    true,//ToolTips
                    true);
            //Creamos una especie de frame y mostramos el JFreeChart en él
            //Este constructor nos pide el título del Chart y el chart creado
            ChartFrame frame = new ChartFrame("Estadística--Aprobados/Suspensos por Profesor y Año", chart);
            frame.pack();
            frame.setVisible(true);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error de Base de Datos");
        }
     }

    }
    public class Estadistica3Listener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.out.println("Pulsado boton3");
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
            frame.pack();
            frame.setVisible(true);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error de Base de Datos");
        }

        }

    }
    
}
