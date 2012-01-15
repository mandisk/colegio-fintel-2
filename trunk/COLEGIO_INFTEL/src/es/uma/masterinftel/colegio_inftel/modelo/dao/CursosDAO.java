/*
 * CursosDAO.java
 */

package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import es.uma.masterinftel.colegio_inftel.modelo.dto.CursosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase DAO (Data Access Object) para el acceso al modelo (Cursos)
 *
 * @author Agustín Pereña
 * @author Jesús Barriga
 * @version v1.0
 */
public class CursosDAO extends GenericDAO {

    /**
     * Sentencia SQL para obtener todos los cursos impartidos en el colegio
     */
    public static final String SQL_SELECT_CURSOS =
           "SELECT * FROM CURSOS;";

    /**
     * Sentencia SQL para obtener los cursos en los que imparte clase un profesor.
     */
    public static final String SQL_SELECT_CURSOS_PROFESOR =
            "SELECT A.ID, A.DESC FROM CURSOS A, ASIGNATURAS B " +
            "WHERE A.ID = B.IMPARTE_CURSOS_ID_FK AND B.PROFESOR_ID_FK = ?;";

    
    /**
     * Obtiene los cursos del colegio
     * @param conn  Conexión a la BD
     * @return (CursosDTO) Lista de Cursos
     * @throws java.sql.SQLException
     */
    public ArrayList<CursosDTO> obtenerCursos(Connection conn) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList cursos = new ArrayList();
        
        try {
            if (conn!=null){
                ps = (PreparedStatement) conn.prepareStatement(SQL_SELECT_CURSOS);
                rs = ps.executeQuery();

                //Creamos la lista con todos los objetos cursos
                while (rs.next()){

                    CursosDTO dto = new CursosDTO();
                    dto.setId(rs.getInt("id"));
                    dto.setDesc(rs.getString("desc"));
                    cursos.add(dto);
                }
            }

        } finally {
            cerrar(rs);
            cerrar(ps);
        }

        if (cursos.size() > 0) {
            return cursos;
        } else {
            return null;
        }
        
    }


    /**
     * Obtiene los cursos impartidos por un profesor
     * @param conn Conexión a la BD
     * @param id_profesor Identificador del Profesor
     * @return Lista de cursos (CursosDTO)
     * @throws java.sql.SQLException
     */
    public ArrayList<CursosDTO> obtenerCursosByProfesor(Connection conn, Integer id_profesor) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList cursos = new ArrayList();

        try {
            if (conn!=null){
                ps = (PreparedStatement) conn.prepareStatement(SQL_SELECT_CURSOS_PROFESOR);
                ps.setInt(1, id_profesor);

                rs = ps.executeQuery();

                //Creamos la lista con todos los objetos cursos
                while (rs.next()){

                    CursosDTO dto = new CursosDTO();
                    dto.setId(rs.getInt("id"));
                    dto.setDesc(rs.getString("desc"));
                    cursos.add(dto);

                }

            }

        } finally {
            cerrar(rs);
            cerrar(ps);
        }

        if (cursos.size() > 0) {
            return cursos;
        } else {
            return null;
        }

    }

}
