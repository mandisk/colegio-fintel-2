/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package colegio_inftel;

package es.uma.masterinftel.colegio_inftel.control;

import es.uma.masterinftel.colegio_inftel.modelo.dao.MatriculacionesDAO;
//import java.sql.Connection;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import es.uma.masterinftel.colegio_inftel.modelo.dao.CalificacionesDAO;
import es.uma.masterinftel.colegio_inftel.vistas.AnotarNotasVista;
import es.uma.masterinftel.colegio_inftel.modelo.dao.EscuelaModeloDAO;
//import es.uma.masterinftel.colegio_inftel.modelo.dao.IncidenciasDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.MatriculacionesDAO;
import es.uma.masterinftel.colegio_inftel.vistas.EscuelaVistaPrincipal;
import es.uma.masterinftel.colegio_inftel.vistas.*;
import es.uma.masterinftel.colegio_inftel.utilidades.*;
import java.awt.event.*;
import javax.swing.table.TableModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import es.uma.masterinftel.colegio_inftel.modelo.dto.EscuelaModeloDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.Conexion;
//import es.uma.masterinftel.colegio_inftel.modelo.dao.NotasDAO;
/**
 *
 * @author Proyectos
 */
public class EscuelaControlador {
  
    //Necesitamos que el controlador interactue con el Modelo y la vista
    private EscuelaModeloDAO m_modelo;
    private EscuelaVistaPrincipal m_vista;
    
    //Variables inicializadas
    int curso=1;
    int grupo=1;
    //int asignatura=1;

    //Formulario Anotar Calificaciones
    protected CalificacionesDAO        m_calificaciones;
    protected AnotarNotasVista         v_calificaciones;
    protected AnotarNotasControlador   c_calificaciones;
    
    //Formulario Anotar Incidencias
    protected MatriculacionesDAO        m_incidencias;
    protected AnotarIncidenciasVista         v_incidencias;
    protected AnotarIncidenciasControlador   c_incidencias;
    
    //Formulario Ver Estadisticas
   // protected MatriculacionesDAO        m_incidencias;
    protected EstadisticasVista         v_estadisticas;
    protected EstadisticasControlador   c_estadisticas;

    
    /** Constructor */
    public EscuelaControlador(EscuelaModeloDAO modelo, EscuelaVistaPrincipal vista){
        m_modelo = modelo;
        m_vista = vista;

        //Creación del formulario Anotar Calificaciones
        m_calificaciones = new CalificacionesDAO();
        v_calificaciones = new AnotarNotasVista(m_calificaciones, m_vista, true);
        c_calificaciones = new AnotarNotasControlador(m_calificaciones,v_calificaciones);
        
        //Creación del formulario Anotar Incidencias
        m_incidencias = new MatriculacionesDAO();
        v_incidencias = new AnotarIncidenciasVista(m_incidencias, m_vista, true);
        c_incidencias = new AnotarIncidenciasControlador(m_incidencias,v_incidencias);
        
        //Creación del formulario Ver Estadisticas
        try{
        v_estadisticas = new EstadisticasVista(m_vista,true);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        c_estadisticas = new EstadisticasControlador(v_estadisticas);


        //Aquí se localizan los métodos de escucha
        vista.addSearchListener(new SearchListener());
        vista.addFilterName(new FilterListener());
        vista.addAnotarNotasListener(new CalificacionesListener());
        vista.addAnotarIncidenciasListener(new IncidenciasListener());
        vista.addVerEstadisticasListener(new EstadisticasListener());
      
    }
    
    class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int[] valasig = {0,5,10,15,20,25};
            int[] valgrupo ={1,6,7};
            EscuelaModeloDTO dto = new EscuelaModeloDTO();
           //Hay que utilizar getItem()
            curso = m_vista.getCurso();
            grupo = m_vista.getGrupo();
           // asignatura = m_vista.getAsignatura();
            Asignatura as = (Asignatura)m_vista.getAsignaturaItem();
           // JOptionPane.showMessageDialog(v_calificaciones, curso); 
            dto.setId_cursos_fk(curso);
            dto.setId_grupo_kf(valgrupo[grupo-1]);
            dto.setCodasignatura_fk(valasig[curso-1]+as.getId());
            m_modelo.rellenaTabla(dto);
            //Ocultamos columna id y comentarios
            m_vista.jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(10).setMinWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(11).setMaxWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(11).setMinWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(11).setPreferredWidth(0);
            //Hay que activar rellenaTabla
            // m_modelo.rellenaTabla(curso, grupo,valasig[curso-1]+asignatura);     
        }
    }
     class FilterListener implements DocumentListener {
         public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
     private void newFilter() {
       m_vista.jTable1.setRowSorter(m_modelo.sorter);
         RowFilter<TableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(m_vista.getNombre(),0,1,2);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        m_modelo.sorter.setRowFilter(rf);
    }
      
  }
    
    /**
     * Clase listener para ejecutar la acción del botón Editar Calificaiones
     * 
     */

    class CalificacionesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(m_vista.jTable1.getSelectedRow()!=-1){

                Connection cnn = (Connection) Conexion.conectar();
                int filaselect = m_vista.getFila();
                int idAlumno = (Integer)m_vista.getTableData(filaselect, 10);
                String nombre = (String)m_vista.getTableData(filaselect, 0);
                String apellido1 = (String)m_vista.getTableData(filaselect, 1) ;
                String apellido2 = (String)m_vista.getTableData(filaselect, 2);
                String nota1 = (m_vista.getTableData(filaselect, 6)).toString();
                String nota2 = (m_vista.getTableData(filaselect, 7)).toString();
                String nota3 = (m_vista.getTableData(filaselect, 8)).toString();
                String notaFinal = (m_vista.getTableData(filaselect, 9)).toString();
               // int[] valgrupo ={1,6,7};
              //  EscuelaModeloDTO dto = new EscuelaModeloDTO();
               //Hay que utilizar getItem()
             //   curso = m_vista.getCurso();
             //   grupo = m_vista.getGrupo();
                Asignatura as = (Asignatura)m_vista.getAsignaturaItem();
                Curso cur = (Curso)m_vista.getCursoItem();
                Grupo gru = (Grupo)m_vista.getGrupoItem();
                MatriculacionesDAO objMatricula = new MatriculacionesDAO();
                int[] valasig = {0,5,10,15,20,25};
                curso = m_vista.getCurso();
                int anioMatricula;
                try{
                anioMatricula = objMatricula.obtener_anio_matricula(cnn);
                System.out.println("Pulsado");

                v_calificaciones.setAnio_mat(anioMatricula);
                v_calificaciones.setId_alumno(idAlumno);
                v_calificaciones.setCodasignatura(valasig[curso-1]+as.getId());

                v_calificaciones.setAlumno(nombre+" "+apellido1);
                v_calificaciones.setGrupo(gru.toString());
                v_calificaciones.setAsignatura(as.toString());
                v_calificaciones.setCurso(cur.toString());
                v_calificaciones.setNota1(nota1);
                v_calificaciones.setNota2(nota2);
                v_calificaciones.setNota3(nota3);
                v_calificaciones.setNotaFinal(notaFinal);

                v_calificaciones.setVisible(true);


                 } catch (Exception ev)
                                {
                          ev.printStackTrace();
                  }

        
             }else{
                JOptionPane.showMessageDialog(m_vista,"Por favor, seleccione un alumno.");               
             } 
        
        
        }//actionPerformed

    }
  class IncidenciasListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
            if(m_vista.jTable1.getSelectedRow()!=-1){
            Connection cnn = (Connection) Conexion.conectar();
            int filaselect = m_vista.getFila();
            int idAlumno = (Integer)m_vista.getTableData(filaselect, 10);
            String comentarios = (String)m_vista.getTableData(filaselect,11);
            String nombre = (String)m_vista.getTableData(filaselect, 0);
            String apellido1 = (String)m_vista.getTableData(filaselect, 1) ;
            Object faltas = m_vista.getTableData(filaselect, 3);
            Object retrasos = m_vista.getTableData(filaselect, 4);
            Object sanciones = m_vista.getTableData(filaselect, 5);
         //   String apellido2 = (String)m_vista.getTableData(filaselect, 2);
        //    String nota1 = (m_vista.getTableData(filaselect, 6)).toString();
        //    String nota2 = (m_vista.getTableData(filaselect, 7)).toString();
        //    String nota3 = (m_vista.getTableData(filaselect, 8)).toString();
        //    String notaFinal = (m_vista.getTableData(filaselect, 9)).toString();
           // int[] valgrupo ={1,6,7};
          //  EscuelaModeloDTO dto = new EscuelaModeloDTO();
           //Hay que utilizar getItem()
         //   curso = m_vista.getCurso();
         //   grupo = m_vista.getGrupo();
            Asignatura as = (Asignatura)m_vista.getAsignaturaItem();
            Curso cur = (Curso)m_vista.getCursoItem();
            Grupo gru = (Grupo)m_vista.getGrupoItem();
            MatriculacionesDAO objMatricula = new MatriculacionesDAO();
           // int[] valasig = {0,5,10,15,20,25};
            curso = m_vista.getCurso();
            int anioMatricula;
            try{
            anioMatricula = objMatricula.obtener_anio_matricula(cnn);
            System.out.println("Pulsado");
            
            v_incidencias.setAnio_mat(anioMatricula);
            v_incidencias.setId_alumno(idAlumno);
       //     v_incidencias.setCodasignatura(valasig[curso-1]+as.getId());

            v_incidencias.setNombreAlumno(nombre+" "+apellido1);
            v_incidencias.setGrupo(gru.toString());
            v_incidencias.setAsignatura(as.toString());
            v_incidencias.setCurso(cur.toString());
            v_incidencias.setFaltas(faltas.toString());
            v_incidencias.setRetrasos(retrasos.toString());
            v_incidencias.setSanciones(sanciones.toString());
            v_incidencias.setComentarios(comentarios);

              v_incidencias.setVisible(true);

                } catch (Exception ev)
                    {
                        ev.printStackTrace();
                    }
            }else{
                JOptionPane.showMessageDialog(m_vista,"Por favor, seleccione un alumno.");                
            }
            }
  }

 class EstadisticasListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
  v_estadisticas.setVisible(true);
      }
 }
}
