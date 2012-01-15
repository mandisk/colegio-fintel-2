package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.PreparedStatement;
import es.uma.masterinftel.colegio_inftel.modelo.dto.*;
import es.uma.masterinftel.colegio_inftel.utilidades.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 * RolProfesoresDAO es la clase DAO (Data Access Object) del modelo para el acceso  
 * a objetos RolProfesorDTO.
 * 
 * @author Jesus Barriga
 * @version 1.0, Diciembre-2011
 * 
 */
public class RolProfesorDAO extends GenericDAO {

    /**
     * Sentencia SQL para recuperar de la BD el rol de un profesor.
     */
    public static final String SQL_ROLES_BY_ID =
            "SELECT * FROM ROL_PROFESOR WHERE id_profesor_fk = ?";
   
    /**
     * Consulta del rol de un profesor a partir de su identificador
     * 
     * @param idProfesor Identificador del profesor cuyo rol se desea recuperar
     * @return objeto RolProfesorDTO con el rol del profesor
     * @throws java.sql.SQLException
     */
    public RolProfesorDTO findRolByProfesorId(Integer idProfesor) throws SQLException {

        Connection conn = Conexion.conectar();

        PreparedStatement ps = null;
        ResultSet rs = null;
        RolProfesorDTO rolProfesor = new RolProfesorDTO();

        try {
            if (conn != null) {
                ps = (PreparedStatement) conn.prepareStatement(SQL_ROLES_BY_ID);
                ps.setInt(1, idProfesor);
                rs = ps.executeQuery();

                while (rs.next()) {
                    rolProfesor.setId_profesor_fk(rs.getInt("id_profesor_fk"));
                    rolProfesor.setId_rol_fk(rs.getInt("id_rol_fk"));
                }
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
        return rolProfesor;
    }
}
