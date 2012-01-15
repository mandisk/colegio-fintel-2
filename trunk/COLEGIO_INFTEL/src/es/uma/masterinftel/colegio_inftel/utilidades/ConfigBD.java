/**
 * ConfigDB.java
 *
 */

package es.uma.masterinftel.colegio_inftel.utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Utilidad para obtener los datos de configuración de la Base de Datos
 * a partir de un fichero de propiedades
 *
 * @author Agustín Pereña
 * @version v1.0 Diciembre-2011
 */
public class ConfigBD {

    /**
     * uri de conexion a la BD, por ejemplo:
     * jdbc:mysql://174.132.76.188:3306/coolfm_java
     */
    public static String uri;
    /**
     * Atributo de clase: usuario de conexion a la BD
     */
    public static String usuario;
    /**
     * Atritubo de clase: clave de usuario para conexion a BD
     */
    public static String clave;

    /**
     * Método de clase para la lectura del fichero de propiedades
     * @param fileName nombre del fichero properties con los datos de conexión
     *                 a la Base de Datos
     */
    public static void Configurar(String fileName) {

        Properties p = new Properties();
        try {
            FileInputStream config = new FileInputStream(fileName);
            //InputStream config = ClassLoader.getSystemResourceAsStream(ConfigBD.class.getPackage().getName() + "/" + fileName);
            
            p.load(config);
            config.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero de configuración NO ENCONTRADO: "+fileName);
        } catch (IOException ex){
            System.out.println("Error leyendo fichero configuración: "+ ex.getMessage());
        }

        uri     =p.getProperty("uri");
        usuario =p.getProperty("user");
        clave   =p.getProperty("password");

    }

}
