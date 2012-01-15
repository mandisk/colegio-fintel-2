/*
 * EscuelaControlador.java
 * 
 */

package es.uma.masterinftel.colegio_inftel.control;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import es.uma.masterinftel.colegio_inftel.modelo.dao.AsignaturasDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.CalificacionesDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.CursosDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.EscuelaModeloDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.GruposDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dao.MatriculacionesDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.AsignaturasDTO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.CursosDTO;
import es.uma.masterinftel.colegio_inftel.vistas.*;
import es.uma.masterinftel.colegio_inftel.utilidades.*;
import java.awt.event.*;
import javax.swing.table.TableModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import es.uma.masterinftel.colegio_inftel.modelo.dto.EscuelaModeloDTO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.GruposDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.Conexion;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *Controlador para la Vista Principal
 * 
 * @author Manuel Valls
 * @version v1.0 Diciembre-2011
 */
public class EscuelaControlador {
  
    //Necesitamos que el controlador interactue con el Modelo y la vista
    private EscuelaModeloDAO m_modelo;
    private EscuelaVistaPrincipal m_vista;
    
    //Variables inicializadas
    int curso=1;
    int grupo=1;

    //Formulario Anotar Calificaciones
    
    /**
     * modelo DAO de Calificaciones
     */
    protected CalificacionesDAO        m_calificaciones;
    /**
     * Vista de Anotar Notas
     */
    protected AnotarNotasVista         v_calificaciones;
    /**
     * Controlador para Anotar Notas
     */
    protected AnotarNotasControlador   c_calificaciones;
    
    //Formulario Anotar Incidencias
    /**
     *  modelo DAO de Incidencias
     */
    protected MatriculacionesDAO        m_incidencias;
    /**
     *  Vista de Anotar Incidencias
     */
    protected AnotarIncidenciasVista         v_incidencias;
    /**
     *  Controlador para Anotar Incidencias
     */
    protected AnotarIncidenciasControlador   c_incidencias;
    
    //Formulario Ver Estadisticas
    /**
     * Vista de las Estadísticas
     */
    protected EstadisticasVista         v_estadisticas;
    /**
     * Controlador para las Estadísticas
     */
    protected EstadisticasControlador   c_estadisticas;

    
    /**
     * Constructor de la clase
     * @param modelo clase DAO de acceso a datos
     * @param vista clase formulario para visualización
     * @throws java.sql.SQLException
     */
    public EscuelaControlador(EscuelaModeloDAO modelo, EscuelaVistaPrincipal vista) throws SQLException{
        m_modelo = modelo;
        m_vista = vista;

        //Creación del formulario Anotar Calificaciones
        m_calificaciones = new CalificacionesDAO();
        v_calificaciones = new AnotarNotasVista(m_vista, true);
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
        vista.addComboListener(new ComboListener());

        initComponent_Vista();
      
    }


    /**
     * Clase para almacenar objetos en los combos con (ID, Descripción)
     *
     */
    class ObjCombo {

        public Integer  id;
        public String   nombre;

        public ObjCombo(Integer id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public boolean equals(Profesor p) {
            if (p.nombre.compareTo(this.nombre) == 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return nombre;
        }
    
        public Integer getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

    }


    /**
     * Carga de combos.
     * Si el usuario es jefe de estudio carga todas los cursos,
     * en caso contrario carga únicamente las del profesor correspondiente.
     *
     * @throws java.sql.SQLException
     */
    private void initComponent_Vista() throws SQLException{

            ArrayList listaCur;
            Connection cnn = (Connection) Conexion.conectar();
            CursosDAO cursosDAO = new CursosDAO();
            CursosDTO cursosDTO = new CursosDTO();

            System.out.println("id profesor:"+m_vista.getIdProfesor());

            if (m_vista.bJefeDeEstudios) {
                //es jefe de estudios
                listaCur = cursosDAO.obtenerCursos(cnn);

         } else {
                //no es jefe de estudios
                listaCur = cursosDAO.obtenerCursosByProfesor(cnn, m_vista.getIdProfesor());
            }

            //Carga del combo Cursos
            Iterator itCur = listaCur.iterator();
            while( itCur.hasNext()){
                cursosDTO = (CursosDTO) itCur.next();
                ObjCombo obj = new ObjCombo(cursosDTO.getId(),
                                            cursosDTO.getDesc());
                m_vista.comboCurso.addItem(obj);
            }
    }


     /**
     * Carga de combos.
     * Si el usuario es jefe de estudio carga todas las asignaturas y cursos,
     * en caso contrario carga únicamente las del profesor correspondiente.
     *
     */

    class ComboListener implements ActionListener  {
    public void actionPerformed(ActionEvent e) {
        //Limpiamos Combos
        m_vista.comboAsignatura.removeAllItems();
        m_vista.comboGrupo.removeAllItems();
        //Obtenemos curso seleccionado
        int curso = m_vista.getCurso();
        ArrayList listaAsig, listaCur, listaGru;

            try{
            Connection cnn = (Connection) Conexion.conectar();
            AsignaturasDAO asignaturasDAO = new AsignaturasDAO();
            AsignaturasDTO asignaturasDTO = new AsignaturasDTO();
            CursosDAO cursosDAO = new CursosDAO();
            CursosDTO cursosDTO = new CursosDTO();

            System.out.println("id profesor:"+m_vista.getIdProfesor());

            if (m_vista.bJefeDeEstudios) {
                //es jefe de estudios
                listaAsig = asignaturasDAO.obtenerAsignaturas(cnn);
                listaCur = cursosDAO.obtenerCursos(cnn);

            } else {
                //no es jefe de estudios
                listaAsig = asignaturasDAO.obtenerAsignaturasByProfesor(cnn, m_vista.getIdProfesor());
                listaCur = cursosDAO.obtenerCursosByProfesor(cnn, m_vista.getIdProfesor());
            }

            //Carga del combo Asignaturas
            Iterator itAsig = listaAsig.iterator();
            while( itAsig.hasNext()){
                asignaturasDTO = (AsignaturasDTO) itAsig.next();
               int asignatura = asignaturasDTO.getCodasignatura();
                switch(curso) {
                    case 1: 
                        if(asignatura>0 && asignatura<6){
                        ObjCombo obj = new ObjCombo(asignaturasDTO.getCodasignatura(),
                                            asignaturasDTO.getDesc());
                        m_vista.comboAsignatura.addItem(obj);
                        }
                        break;
                    case 2: 
                        if(asignatura>5 && asignatura<11){
                        ObjCombo obj = new ObjCombo(asignaturasDTO.getCodasignatura(),
                                            asignaturasDTO.getDesc());
                        m_vista.comboAsignatura.addItem(obj);
                        }
                        break;
                    case 3: 
                        if(asignatura>10 && asignatura<16){
                        ObjCombo obj = new ObjCombo(asignaturasDTO.getCodasignatura(),
                                            asignaturasDTO.getDesc());
                        m_vista.comboAsignatura.addItem(obj);
                        }
                        break;
                    case 4: 
                        if(asignatura>15 && asignatura<21){
                        ObjCombo obj = new ObjCombo(asignaturasDTO.getCodasignatura(),
                                            asignaturasDTO.getDesc());
                        m_vista.comboAsignatura.addItem(obj);
                        }
                        break;
                    case 5: 
                        if(asignatura>20 && asignatura<26){
                        ObjCombo obj = new ObjCombo(asignaturasDTO.getCodasignatura(),
                                            asignaturasDTO.getDesc());
                        m_vista.comboAsignatura.addItem(obj);
                        }
                        break;
                    case 6: 
                        if(asignatura>25 && asignatura<31){
                        ObjCombo obj = new ObjCombo(asignaturasDTO.getCodasignatura(),
                                            asignaturasDTO.getDesc());
                        m_vista.comboAsignatura.addItem(obj);
                        }
                        break;
              }

                
               
            }

            //Carga del combo Grupos correspondiente al primer curso
            GruposDAO gruposDAO = new GruposDAO();
            GruposDTO gruposDTO = new GruposDTO();

            listaGru = gruposDAO.obtenerGruposByCurso(cnn,((ObjCombo) m_vista.comboCurso.getItemAt(curso-1)).getId());


            Iterator itGru = listaGru.iterator();
            while( itGru.hasNext()){
                gruposDTO = (GruposDTO) itGru.next();
                ObjCombo obj = new ObjCombo(gruposDTO.getId(),
                                            gruposDTO.getDesc());
                m_vista.comboGrupo.addItem(obj);
            }
            } catch (Exception ev)
                                {
                          ev.printStackTrace();
                  }
    
    }
    }
    
     /**
     * Búsqueda de alumnos
     * Con esta clase se muestran en el JTable los alumnos de un curso,grupo y
     * asignatura seleccionados. Para ello hay que pulsar sobre el botón buscar 
     * del formulario.
     *
     */
    class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EscuelaModeloDTO dto = new EscuelaModeloDTO();
            curso = m_vista.getCurso();
            grupo = m_vista.getGrupo();


            ObjCombo objCurso = (ObjCombo) m_vista.getCursoItem();
            ObjCombo objGrupo = (ObjCombo) m_vista.getGrupoItem();
            ObjCombo objAsignatura = (ObjCombo) m_vista.getAsignaturaItem();

            dto.setId_cursos_fk(objCurso.getId());
            dto.setId_grupo_kf(objGrupo.getId());
            dto.setCodasignatura_fk(objAsignatura.getId());



            m_modelo.rellenaTabla(dto);
            //Ocultamos columna id y comentarios
            m_vista.jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(10).setMinWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(11).setMaxWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(11).setMinWidth(0);
            m_vista.jTable1.getColumnModel().getColumn(11).setPreferredWidth(0);
        }
    }
    /**
     * Búsqueda de alumnos
     * Con esta clase se filtra los alumnos por nombre, apellido1 o apellido2.
     * Para realizar el filtro se lee el texto que hay en el campo de texto.
     *
     */ 
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
                
                ObjCombo obj = (ObjCombo) m_vista.comboAsignatura.getSelectedItem();
                ObjCombo cursoObj = (ObjCombo) m_vista.comboCurso.getSelectedItem();
                ObjCombo grupoObj = (ObjCombo) m_vista.comboGrupo.getSelectedItem();

                MatriculacionesDAO objMatricula = new MatriculacionesDAO();
                int anioMatricula;
                try{
                    anioMatricula = objMatricula.obtener_anio_matricula(cnn);
                    System.out.println("Pulsado");

                    v_calificaciones.setAnio_mat(anioMatricula);
                    v_calificaciones.setId_alumno(idAlumno);
                    v_calificaciones.setCodasignatura(obj.getId());
                    v_calificaciones.setAlumno(nombre+" "+apellido1);
                    v_calificaciones.setGrupo(grupoObj.getNombre());
                    v_calificaciones.setAsignatura(obj.getNombre());
                    v_calificaciones.setCurso(cursoObj.getNombre());
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
    /**
     * Clase listener para ejecutar la acción del botón Editar Incidencias
     * 
     */
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
            
            ObjCombo obj      = (ObjCombo) m_vista.comboAsignatura.getSelectedItem();
            ObjCombo cursoObj = (ObjCombo) m_vista.comboCurso.getSelectedItem();
            ObjCombo grupoObj = (ObjCombo) m_vista.comboGrupo.getSelectedItem();


            MatriculacionesDAO objMatricula = new MatriculacionesDAO();

            int anioMatricula;
            try{
                    anioMatricula = objMatricula.obtener_anio_matricula(cnn);
                    System.out.println("Pulsado");

                    v_incidencias.setAnio_mat(anioMatricula);
                    v_incidencias.setId_alumno(idAlumno);
                    v_incidencias.setNombreAlumno(nombre+" "+apellido1);
                    v_incidencias.setGrupo(grupoObj.getNombre());
                    v_incidencias.setAsignatura(obj.getNombre());
                    v_incidencias.setCurso(cursoObj.getNombre());
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
     /**
     * Clase listener para ejecutar la acción del botón Ver Estadísticas
     * 
     */
 class EstadisticasListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
  v_estadisticas.setVisible(true);
      }
 }
}
