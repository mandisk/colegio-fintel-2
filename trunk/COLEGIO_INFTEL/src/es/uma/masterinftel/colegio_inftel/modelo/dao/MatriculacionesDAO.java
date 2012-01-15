/**
 * MatriculacionesDAO.java
 *
 */

package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import es.uma.masterinftel.colegio_inftel.modelo.dto.MatriculacionesDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.MatriculadosAsignaturas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para el acceso al modelo (Cursos)
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class MatriculacionesDAO extends GenericDAO {

    /**
     * Sentencia SQL para obtener el año actual del curso escolar
     */
    private static final String SQL_SELECT_ANIO_MATRICULACION =
           "SELECT MAX(anio_mat) FROM MATRICULACIONES;";

    /**
     * Sentencia SQL para actualizar las incidecias de un alumno
     */
    private static final String SQL_UPDATE_INCIDENCIAS =
           "UPDATE MATRICULACIONES SET " +
           "faltas_acumuladas = ?, retardos = ?, saciones = ?, observaciones = ? " +
           "WHERE " +
           "anio_mat = ? AND " +
           "id_alumno_fk = ?";

    /**
     * Sentencia SQL para obtener los distintos años escolares
     */
    private static final String SQL_ANIOS_MATRICULACIONES =
            "SELECT DISTINCT(anio_mat) FROM MATRICULACIONES;";

    /**
     * Sentencia SQL para obtener las matriculaciones de una asignatura
     */
    private static final String SQL_MATRICULADOS_ASIGNATURAS =
            "SELECT B.CODASIGNATURA AS 'ASIGNATURA', COUNT(A.ID_ALUMNO_FK) AS 'ALUMNOS' "+
            "FROM MATRICULACIONES A, ASIGNATURAS B "+
            "WHERE A.ID_CURSOS_FK = B.IMPARTE_CURSOS_ID_FK "+
            "AND A.ANIO_MAT = ? "+
            "GROUP BY B.CODASIGNATURA;";


    /**
     * Obtiene las matriculaciones de una asignatura
     * @param cnn       Conexión a la BD
     * @param anio_mat  Año de matriculación
     * @return Lista de Matriculaciones
     * @throws java.sql.SQLException
     */
    public ArrayList<MatriculadosAsignaturas> obtenerNumMatriculadosAsignatura(Connection cnn, Integer anio_mat)
                                throws SQLException{

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<MatriculadosAsignaturas> listaMatriculados = new ArrayList<MatriculadosAsignaturas>();

        try {
            ps = (PreparedStatement) cnn.prepareStatement(SQL_MATRICULADOS_ASIGNATURAS);
            ps.setInt(1, anio_mat);
            rs = ps.executeQuery();

            while( rs.next() ){
                MatriculadosAsignaturas matriculados = new MatriculadosAsignaturas();
                matriculados.setCodasignatura(rs.getInt(1));
                matriculados.setAlumnosMatriculados(rs.getInt(2));
                listaMatriculados.add(matriculados);
            }
        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return listaMatriculados;
    }

    /**
     *
     * @param dto       DTO Matriculaciones
     * @param conexion  Conexión a la BD
     * @throws java.sql.SQLException
     */
    public void update(MatriculacionesDTO dto, Connection conexion) throws SQLException{
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(SQL_UPDATE_INCIDENCIAS);
            ps.setInt(1,dto.getFaltas_acumuladas());
            ps.setInt(2, dto.getRetardos());
            ps.setInt(3, dto.getSanciones());
            ps.setString(4, dto.getObservaciones());
            ps.setInt(5, dto.getAnio_mat());
            ps.setInt(6, dto.getId_alumno_fk());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
        }

    }




    /**
     * Devuelve el año escolar actual
     * @param conexion Conexión a la BD
     * @return Año escolar en curso
     * @throws java.sql.SQLException
     */
    public Integer obtener_anio_matricula(Connection conexion) throws SQLException {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer anio = 0;

        try {
            ps = (PreparedStatement) conexion.prepareStatement(SQL_SELECT_ANIO_MATRICULACION);

            rs = ps.executeQuery();

            if( rs.next() ){
                anio = rs.getInt(1);
            }

        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return anio;
    }


    /**
     * Obtiene los distintos años escolar impartidos en el colegio
     * @param conexion Conexión a la BD
     * @return Lista de años escolares
     * @throws java.sql.SQLException
     */
    public List<Integer> obtener_anios_matriculaciones(Connection conexion) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> anios = new ArrayList<Integer>();

        try {
            ps = (PreparedStatement) conexion.prepareStatement(SQL_ANIOS_MATRICULACIONES);

            rs = ps.executeQuery();

            while(rs.next()){
                anios.add(rs.getInt(1));
            }

  
        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return anios;
        
    }

}
