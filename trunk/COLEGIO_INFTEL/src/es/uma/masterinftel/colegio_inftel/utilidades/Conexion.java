package es.uma.masterinftel.colegio_inftel.utilidades;

import java.sql.*;

/**
 * Conexion es la clase que implementa el patrón Singleton para la conexión
 * a la BD de forma que solo haya una conexión activa en la aplicación.
 * 
 * @author Jesus Barriga
 * @version 1.0, Diciembre-2011
 * 
 */
public class Conexion {

    /** Objeto conexión */
    private static Connection conn = null;

    /** 
     * Constructor privado que evita que se creen objetos Conexion desde fuera 
     */
    private Conexion() {
    }

    ; 
    
    /**
     * Devuelve el objeto Conexion existente o crea uno nuevo si no existe.
     *
     * @return Objeto conexión
     */
    public static Connection conectar() {

        if (conn == null) {
            try {

                Class.forName("org.gjt.mm.mysql.Driver");

                ConfigBD.Configurar(Constantes.FICHERO_CONFIGURACION_DB);
                conn = DriverManager.getConnection(ConfigBD.uri, ConfigBD.usuario, ConfigBD.clave);

                if (conn != null) {
                    System.out.println("Conexión a base de datos " + ConfigBD.uri + " ... Ok");
                }
            } catch (SQLException ex) {
                System.out.println("Hubo un problema al intentar conectarse con la base de datos " + ConfigBD.uri);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
        return conn;
    }
}