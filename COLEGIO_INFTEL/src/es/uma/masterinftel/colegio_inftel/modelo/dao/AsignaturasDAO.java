/*
 * AsignaturasDAO.java
 */

package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import es.uma.masterinftel.colegio_inftel.modelo.dto.AsignaturasDTO;
import es.uma.masterinftel.colegio_inftel.utilidades.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase DAO (Data Access Object) para el acceso al modelo (Asignaturas)
 *
 * @author Agustín Pereña
 * @version v1.0 
 */
public class AsignaturasDAO extends GenericDAO {

    /**
     * Sentencia SQL para obtener el listado de asignaturas
     */
    private static final String SQL_SELECT_ASIGNATURAS =
           "SELECT * FROM ASIGNATURAS;";

    /**
     * Sentencia SQL para obtener las asignaturas de un profesor
     */
    private static final String SQL_SELECT_ASIGNATURAS_PROFESOR =
           "SELECT * FROM ASIGNATURAS WHERE profesor_id_fk=?;";

    /**
     * Sentencia SQL para obtener la descripción de una asignatura por código
     */
    private static final String SQL_SELECT_ASIGNATURAS_POR_CODIGO =
           "SELECT desc FROM ASIGNATURAS WHERE codasignatura=?;";


    /**
     * Obtiene el nombre de una asignatura dado su código
     * @param cnn       Conexión a la BD
     * @param codigo    Código de la asignatura
     * @return nombre del asignatura
     * @throws java.sql.SQLException
     */
    public String obtenerNombreAsignatura(Connection cnn, Integer codigo) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String descAsignatura = " ";

        try {
            ps = (PreparedStatement) cnn.prepareStatement(SQL_SELECT_ASIGNATURAS_POR_CODIGO );
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if( rs.next() ){
                descAsignatura = rs.getString(1);
            }
        } finally {
            cerrar(ps);
            cerrar(rs);
        }

        return descAsignatura;

    }
    /**
     * Obtiene todas las asignaturas impartidas en el colegio
     * @param conn Conexión a la BD
     * @return Lista de Asignaturas
     * @throws java.sql.SQLException
     */
    public ArrayList<AsignaturasDTO> obtenerAsignaturas(Connection conn) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList asignaturas = new ArrayList();

        try {
            if (conn!=null){
                ps = (PreparedStatement) conn.prepareStatement(SQL_SELECT_ASIGNATURAS);
                rs = ps.executeQuery();

                //Creamos la lista con todos los objetos asignaturas
                while (rs.next()){

                    //Creación del DTO Asignatura
                    AsignaturasDTO dto = new AsignaturasDTO();

                    //Seteamos las propiedades del DTO
                    dto.setCodasignatura(rs.getInt("codasignatura"));
                    dto.setDesc(rs.getString("desc"));
                    dto.setProfesor_id_fk(rs.getInt("profesor_id_fk"));
                    dto.setImparte_cursos_id_fk(rs.getInt("imparte_cursos_id_fk"));

                    //Lo añadimos a la lista
                    asignaturas.add(dto);
                }

            }

        } finally {
            cerrar(rs);
            cerrar(ps);
        }

        if (asignaturas.size() > 0) {
            return asignaturas;
        } else {
            return null;
        }

    }



    /**
     * Obtiene las asignaturas que imparte un profesor
     * @param conn          Conexión a la BD
     * @param id_profesor   Identificador del profesor
     * @return Lista de asignaturas de un profesor dado
     * @throws java.sql.SQLException
     */
    public ArrayList<AsignaturasDTO> obtenerAsignaturasByProfesor(Connection conn, Integer id_profesor) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList asignaturas = new ArrayList();

        try {
            if (conn!=null){
                ps = (PreparedStatement) conn.prepareStatement(SQL_SELECT_ASIGNATURAS_PROFESOR);
                ps.setInt(1, id_profesor);
                rs = ps.executeQuery();

                //Creamos la lista con todos los objetos asignaturas
                while (rs.next()){
                    AsignaturasDTO dto = new AsignaturasDTO();

                    dto.setCodasignatura(rs.getInt("codasignatura"));
                    dto.setDesc(rs.getString("desc"));
                    dto.setProfesor_id_fk(rs.getInt("profesor_id_fk"));
                    dto.setImparte_cursos_id_fk(rs.getInt("imparte_cursos_id_fk"));

                    asignaturas.add(dto);
                }

            }

        } finally {
            cerrar(rs);
            cerrar(ps);
        }

        if (asignaturas.size() > 0) {
            return asignaturas;
        } else {
            return null;
        }

    }


}
