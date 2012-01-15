/*
 * CalificacionesDAO.java
 *
 */

package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import es.uma.masterinftel.colegio_inftel.modelo.dto.CalificacionesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Object) para el acceso al modelo (calificaciones)
 *
 * @author Agustín Pereña
 * @author Jesús Barriga
 * @version v1.0 
 */
public class CalificacionesDAO extends GenericDAO {

    /**
     * Sentencia SQL para actualizar las calificaciones del alumno
     */
    public static final String SQL_UPDATE_CALIFICACIONES =
           "UPDATE CALIFICACIONES SET " +
           "nota_p1 = ?, nota_p2 = ?, nota_p3 = ?, nota_final = ? " +
           "WHERE " +
           "anio_mat_fk = ? AND " +
           "id_alumno_fk = ? AND " +
           "codasignatura_fk = ?";

    /**
     * Sentencia SQL que devuelve el número de aprobados
     */
    public static final String SQL_APROBADOS =
            "SELECT COUNT(DISTINCT A.ID_ALUMNO_FK) AS APROBADOS "+
            "FROM  MATRICULACIONES A, CALIFICACIONES D "+
            "WHERE A.ID_ALUMNO_FK = D.ID_ALUMNO_FK "+
            "AND   A.ID_CURSOS_FK = ? "+
            "AND   D.CODASIGNATURA_FK = ? "+
            "AND   D.NOTA_FINAL >= 5 "+
            "AND   D.ANIO_MAT_FK = ? "+
            "ORDER BY A.ID_ALUMNO_FK; ";

    /**
     * Sentencia SQL que devuelve el número de matriculados en una asignatura
     */
    public static final String SQL_MATRICULADOS =
            "SELECT COUNT(DISTINCT A.ID_ALUMNO_FK) AS APROBADOS "+
            "FROM  MATRICULACIONES A, CALIFICACIONES D "+
            "WHERE A.ID_ALUMNO_FK = D.ID_ALUMNO_FK "+
            "AND   A.ID_CURSOS_FK = ? "+
            "AND   D.CODASIGNATURA_FK = ? "+
            "AND   D.ANIO_MAT_FK = ? "+
            "ORDER BY A.ID_ALUMNO_FK;";


    /**
     * Sentencia SQL que devuelve el número de aprobados de un profesor
     */
    public static final String SQL_APROBADOS_PROFESOR =
            "SELECT COUNT(B.ID_ALUMNO_FK) AS APROBADOS " +
            "FROM ASIGNATURAS A, CALIFICACIONES B "+
            "WHERE A.CODASIGNATURA = B.CODASIGNATURA_FK "+
            "AND A.PROFESOR_ID_FK = ? "+
            "AND B.ANIO_MAT_FK = ? "+
            "AND B.NOTA_FINAL >= 5 "+
            "ORDER BY B.ID_ALUMNO_FK; ";

    /**
     * Sentencia SQL el numero de matriculados en las asignaturas de un profesor
     */
    public static final String SQL_MATRICULADOS_ASIG_PROFESOR =
            "SELECT COUNT(B.ID_ALUMNO_FK) AS APROBADOS " +
            "FROM ASIGNATURAS A, CALIFICACIONES B "+
            "WHERE A.CODASIGNATURA = B.CODASIGNATURA_FK "+
            "AND A.PROFESOR_ID_FK = ? "+
            "AND B.ANIO_MAT_FK = ? "+
            "ORDER BY B.ID_ALUMNO_FK; ";


    /**
     * Consulta del número de aprobados
     * @param cnn           Conexión a la BD
     * @param codasignatura Código de la Asignatura
     * @param anio_mat      Año de Matriculación
     * @param id_curso      Identificador del Curso
     * @return número de aprobados
     * @throws java.sql.SQLException
     */
    public Integer numAprobados(Connection cnn, Integer codasignatura, Integer anio_mat, Integer id_curso)
                                throws SQLException{

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer aprobados = 0;

        try {
            ps = (PreparedStatement) cnn.prepareStatement(SQL_APROBADOS);
            ps.setInt(1, id_curso);
            ps.setInt(2, codasignatura);
            ps.setInt(3, anio_mat);
            rs = ps.executeQuery();

            if( rs.next() ){
                aprobados = rs.getInt(1);
            }
        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return aprobados;
    }


    /**
     * Consulta del número de aprobados
     * @param cnn           Conexión a la BD
     * @param id_profesor   Identificador del profesor
     * @param anio_mat      Año de Matriculación
     * @return número de aprobados
     * @throws java.sql.SQLException
     */
    public Integer numAprobados(Connection cnn, Integer id_profesor, Integer anio_mat)
                                throws SQLException{

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer aprobados = 0;

        try {
            ps = (PreparedStatement) cnn.prepareStatement(SQL_APROBADOS_PROFESOR);
            ps.setInt(1, id_profesor);
            ps.setInt(2, anio_mat);
            rs = ps.executeQuery();

            if( rs.next() ){
                aprobados = rs.getInt(1);
            }
        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return aprobados;
    }


    /**
     * Consuta del número de Alumnos matriculados
     * @param cnn               Conexión a la BD
     * @param codasignatura     Código de Asignatura
     * @param anio_mat          Año de Matriculación
     * @param id_curso          Identificador del curso
     * @return número de matriculados
     * @throws java.sql.SQLException
     */
    public Integer numMatriculados(Connection cnn, Integer codasignatura, Integer anio_mat, Integer id_curso)
                                throws SQLException{

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer aprobados = 0;

        try {
            ps = (PreparedStatement) cnn.prepareStatement(SQL_MATRICULADOS);
            ps.setInt(1, id_curso);
            ps.setInt(2, codasignatura);
            ps.setInt(3, anio_mat);
            rs = ps.executeQuery();

            if( rs.next() ){
                aprobados = rs.getInt(1);
            }
        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return aprobados;
    }



    /**
     * Consulta del número de Alumnos matriculados
     * @param cnn           Conexión a la BD
     * @param id_profesor   Identificador del profesor
     * @param anio_mat      Año de Matriculación
     * @return número de alumnos matriculados
     * @throws java.sql.SQLException
     */
    public Integer numMatriculados(Connection cnn, Integer id_profesor, Integer anio_mat)
                                throws SQLException{

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer aprobados = 0;

        try {
            ps = (PreparedStatement) cnn.prepareStatement(SQL_MATRICULADOS_ASIG_PROFESOR);
            ps.setInt(1, id_profesor);
            ps.setInt(2, anio_mat);
            rs = ps.executeQuery();

            if( rs.next() ){
                aprobados = rs.getInt(1);
            }
        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return aprobados;
    }


    /**
     * Actualización en BD de las calificaciones del alumno
     * @param dto       DTO de calificaciones
     * @param conexion  Conexión a la BD
     * @throws java.sql.SQLException
     */
    public void update(CalificacionesDTO dto, Connection conexion) throws SQLException{
        PreparedStatement ps = null;
        try {
            if (conexion!=null){
                ps = (PreparedStatement) conexion.prepareStatement(SQL_UPDATE_CALIFICACIONES);
                ps.setDouble(1, dto.getNota_p1());
                ps.setDouble(2, dto.getNota_p2());
                ps.setDouble(3, dto.getNota_p3());
                ps.setDouble(4, dto.getNota_final());
                ps.setInt(5, dto.getAnio_mat_fk());
                ps.setInt(6, dto.getId_alumno_fk());
                ps.setInt(7, dto.getCodasignatura_fk());
                ps.executeUpdate();
            }
        } finally {
            cerrar(ps);
        }

    }

}
