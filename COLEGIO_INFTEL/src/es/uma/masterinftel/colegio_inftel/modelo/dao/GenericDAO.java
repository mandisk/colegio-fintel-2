/*
 * GenericDAO.java
 */

package es.uma.masterinftel.colegio_inftel.modelo.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase Genérica que implementa métodos comunes para el resto de clases DAO
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class GenericDAO {


    /**
     * Cierre del PreparedStatement
     * @param ps PreparedStatement
     */
    protected void cerrar(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
            }
        }
    }

    /**
     * Cierre del ResultSet
     * @param rs ResultSet
     */
    protected void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar ResultSet: "+e.getMessage());
            }
        }
    }



}
