package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import es.uma.masterinftel.colegio_inftel.modelo.dto.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * GruposDAO es la clase DAO (Data Access Object) del modelo para el acceso  
 * a objetos GruposDTO.
 * 
 * @author Jesus Barriga
 * @version 1.0, Diciembre-2011
 * 
 */
public class GruposDAO extends GenericDAO {
    
    /**
     * Sentencia SQL para recuperar los grupos pertenecientes a un curso.
     */
    public static final String SQL_SELECT_GRUPOS_CURSO =
        "SELECT A.ID, A.DESC FROM " +
        "GRUPOS A, CURSOS_GRUPOS B " +
        "WHERE A.ID = B.ID_GRUPO_FK " +
        "AND B.ID_CURSO_FK=?;";
    
    /**
     * Consulta de los grupos pertenecientes al curso que se pasa como parámetro
     * 
     * @param cnn       Conexión a la BD
     * @param idCurso   Identificador del curso cuyos grupos se desea recuperar
     * @return ArrayList de GruposDTO con los grupos recuperados
     * @throws java.sql.SQLException
     */
    public ArrayList<GruposDTO> obtenerGruposByCurso(Connection conn, Integer idCurso) 
            throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList grupos = new ArrayList();
        
        try {
            if (conn!=null){
                ps = (PreparedStatement) conn.prepareStatement(SQL_SELECT_GRUPOS_CURSO);
                ps.setInt(1, idCurso);
                rs = ps.executeQuery();

                //Creamos la lista con todos los objetos cursos
                while (rs.next()){
                    GruposDTO dto = new GruposDTO();
                    dto.setId(rs.getInt("id"));
                    dto.setDesc(rs.getString("desc"));
                    grupos.add(dto);
                }
            }

        } finally {
            cerrar(rs);
            cerrar(ps);
        }

        if (grupos.size() > 0) {
            return grupos;
        } else {
            return null;
        }
    }
}