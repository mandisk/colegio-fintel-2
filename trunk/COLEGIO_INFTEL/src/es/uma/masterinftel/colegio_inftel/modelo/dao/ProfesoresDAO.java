package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.PreparedStatement;
import es.uma.masterinftel.colegio_inftel.modelo.dto.*;
import es.uma.masterinftel.colegio_inftel.utilidades.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * ProfesoresDAO es la clase DAO (Data Access Object) para el acceso al 
 * modelo (profesores). 
 * 
 * @author Jesus Barriga
 * @version 1.0, Diciembre-2011
 * 
 */
public class ProfesoresDAO extends GenericDAO {

    /**
     * Sentencia SQL para recuperar todos los profesores de la BD.
     */
    public static final String SQL_PROFESORES =
            "SELECT * FROM PROFESORES;";
    
    /**
     * Sentencia SQL para recuperar el profesor cuyo campo usuario se le pasa
     * como parámetro.
     */
    public static final String SQL_PROFESORES_POR_USUARIO =
            "SELECT * FROM PROFESORES WHERE " +
            "usuario = ?";

    /**
     * Consulta de todos los profesores
     * 
     * @return ArrayList de ProfesoresDTO con los profesores recuperados
     * @throws java.sql.SQLException
     */
    public ArrayList<ProfesoresDTO> obtenerProfesores() throws SQLException {

        Connection conn = Conexion.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList profesores = new ArrayList();

        try {
            if (conn != null) {
                ps = (PreparedStatement) conn.prepareStatement(SQL_PROFESORES);
                rs = ps.executeQuery();

                //Creamos la lista con todos los objetos cursos
                while (rs.next()) {

                    ProfesoresDTO dto = new ProfesoresDTO();
                    dto.setId(rs.getInt("Id"));
                    dto.setDni_doc(rs.getString("dni_doc"));
                    dto.setNombre(rs.getString("nombre"));
                    dto.setApellido1(rs.getString("apellido1"));
                    dto.setApellido2(rs.getString("apellido2"));
                    dto.setTelfcontacto(rs.getString("telfcontacto"));
                    dto.setObservaciones(rs.getString("observaciones"));
                    dto.setUsuario(rs.getString("usuario"));
                    dto.setPassword(rs.getString("password"));
                    dto.setEmail(rs.getString("email"));
                    profesores.add(dto);
                }
            }

        } finally {
            cerrar(rs);
            cerrar(ps);
        }

        if (profesores.size() > 0) {
            return profesores;
        } else {
            return null;
        }

    }

    /**
     * Consulta de los datos de un profesor a partir de su campo usuario
     * 
     * @return objeto ProfesoresDTO con los datos del profesor recuperado
     * @throws java.sql.SQLException
     */
    public ProfesoresDTO findProfesorByUsuario(String usuario) throws SQLException {

        Connection conn = Conexion.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;
        ProfesoresDTO profesor = new ProfesoresDTO();

        try {
            if (conn != null) {
                ps = (PreparedStatement) conn.prepareStatement(SQL_PROFESORES_POR_USUARIO);
                ps.setString(1, usuario);
                rs = ps.executeQuery();

                while (rs.next()) {
                    profesor.setId(rs.getInt("Id"));
                    profesor.setDni_doc(rs.getString("dni_doc"));
                    profesor.setNombre(rs.getString("nombre"));
                    profesor.setApellido1(rs.getString("apellido1"));
                    profesor.setApellido2(rs.getString("apellido2"));
                    profesor.setTelfcontacto(rs.getString("telfcontacto"));
                    profesor.setObservaciones(rs.getString("observaciones"));
                    profesor.setUsuario(rs.getString("usuario"));
                    profesor.setPassword(rs.getString("password"));
                    profesor.setEmail(rs.getString("email"));
                }
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
        return profesor;
    }
}
