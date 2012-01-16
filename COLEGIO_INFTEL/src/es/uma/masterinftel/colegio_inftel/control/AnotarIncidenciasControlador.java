/**
 * AnotarIncidenciasControlador.java
 *
 */
package es.uma.masterinftel.colegio_inftel.control;

import com.mysql.jdbc.Connection;
import es.uma.masterinftel.colegio_inftel.utilidades.Conexion;
import es.uma.masterinftel.colegio_inftel.vistas.AnotarIncidenciasVista;
import es.uma.masterinftel.colegio_inftel.modelo.dao.MatriculacionesDAO;
import es.uma.masterinftel.colegio_inftel.modelo.dto.MatriculacionesDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador para Anotar Incidencias
 *
 * @author Luis Jarén
 * @version v1.0 Diciembre-2011
 */
public class AnotarIncidenciasControlador {

    private MatriculacionesDAO modelo;
    private AnotarIncidenciasVista vista;

    /**
     * Constructor de la clase
     * @param modelo clase DAO de acceso a datos
     * @param vista clase formulario para visualización
     */

    public AnotarIncidenciasControlador(MatriculacionesDAO modelo, AnotarIncidenciasVista vista){

        this.modelo=modelo;
        this.vista=vista;

        vista.addCancelarListener(new CerrarListener());
        vista.addConfirmarListener(new ConfirmarListener());
    }

     /**
     * Listener para el botón GUARDAR
     */
        public class ConfirmarListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
             Runnable miRunnable = new Runnable(){

                public void run() {

                    try{

                        MatriculacionesDTO dto = new MatriculacionesDTO();
                        Connection cnn = (Connection) Conexion.conectar();

                        dto.setAnio_mat(vista.getAnio_mat());
                        dto.setId_alumno_fk(vista.getId_alumno());

                        dto.setFaltas_acumuladas(vista.getFaltas());
                        dto.setRetardos(vista.getRetrasos());
                        dto.setSanciones(vista.getSanciones());
                        dto.setObservaciones(vista.getComentarios());
        
                        try {
                             //Actualización de notas en el modelo
                            modelo.update(dto,cnn);
                        } catch (SQLException ex) {
                            Logger.getLogger(AnotarIncidenciasControlador.class.
                                        getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            //Creación de hebra para evitar bloqueo interfaz
            Thread hilo = new Thread(miRunnable);
            hilo.start();
            //Cerramos la vista
            vista.setVisible(false);
        }

    }
     /**
     * Listener para ocutar la vista al pulsar botón CERRAR
     */
    public class CerrarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           vista.setVisible(false);
        }

    }

}
