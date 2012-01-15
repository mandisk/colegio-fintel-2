package es.uma.masterinftel.colegio_inftel.control;

import es.uma.masterinftel.colegio_inftel.modelo.dao.*;
import es.uma.masterinftel.colegio_inftel.modelo.dto.*;
import es.uma.masterinftel.colegio_inftel.vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.SQLException;

/**
 * LoginControlador es la clase controladora para la vista LoginVista, la cual
 * se ocupa de gestionar la validaciónd del usuario de cara al acceso al 
 * sistema.
 * 
 * @author Jesus Barriga
 * @version 1.0, Diciembre-2011
 * 
 */

public class LoginControlador {
    
    /** El modeo utilizado para el Login. */
    private ProfesoresDAO  m_modelo;
    
    /** La vista utilizada para el Login. */
    private LoginVista  m_vista;
    
    /** Recuperación del rol del profesor. */
    private RolProfesorDAO rol = new RolProfesorDAO();
    
    /**
     * Constructor de la clase, especificando el modelo y la vista.
     *
     * @param modelo El modelo utilizado con los datos del usuario que accede
     * @param vista La vista con la pantalla de acceso
     */
    public LoginControlador(ProfesoresDAO modelo, LoginVista vista){

        m_modelo = modelo;
        m_vista  = vista;

        m_vista.addAceptarListener(new AceptarListener());
        m_vista.addCancelarListener(new CancelarListener());
        
        m_vista.focoInicial();

    }
   
    /**
     * Devuelve en un string la codificación en md5 de la cadena de entrada.
     *
     * @param clear Cadena a codidifcar
     * @return Cadena con la coficación en md5 de la cadena de entrada.
     */
     private static String md5(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());

        int size = b.length;
        StringBuilder h = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0").append(Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }
    
    /**
     * Carga y hace visible la venta principal tras la validaciónd el usuario
     *
     * @param rol Rol del usuario (profesor o jefe de estudios)
     * @param idProfesor Id del usuario
     */
    private void navegacion(Integer rol,Integer idProfesor) throws SQLException {
        EscuelaModeloDAO next_modelo = new EscuelaModeloDAO();
        EscuelaVistaPrincipal next_vista = new EscuelaVistaPrincipal(next_modelo);
        next_vista.setRolJefeDeEstudios(rol,idProfesor);
        EscuelaControlador next_controlador = new EscuelaControlador(next_modelo,next_vista);
        
        m_vista.setVisible(false);
        
        next_vista.setVisible(true);
    }
    
    /**
     * Clase encargada de gestionar los evento asociados al botón de Aceptar
     * en la vista de Login. 
     */
    class AceptarListener implements ActionListener {

    /**
     * Se lanza cuando el usuario pulsa Aceptar en la vista de Login
     *
     * @param e Un objeto ActionEvent con el evento disparado en la vista
     */
        @Override
        public void actionPerformed(ActionEvent e) {

            Runnable miRunnable = new Runnable() {

                @Override
                public void run() {

                    // Obtenemos el usuario
                    String user = m_vista.getUsuario();

                    // Obtener el password
                    char passArray[] = m_vista.getClave();

                    // Se inician las validaciones:

                    // Revisar que sean letras y numeros
                    boolean clave_correcta = true;
                    boolean bTest;

                    for (int i = 0; i < passArray.length; i++) {
                        char c = passArray[i];
                        // Si no es letra o numero entonces no es valido
                        if (!Character.isLetterOrDigit(c)) {
                            clave_correcta = false;
                        }
                    }

                    // Convertir el password a String
                    String pass = new String(passArray);

                    if (!clave_correcta) {
                        m_vista.printMensajeUserPassIncorrectos();
                    } else if (user.isEmpty() || pass.isEmpty()) {
                        m_vista.printMensajeUserPassVacios();
                    } else {  // Las validaciones de formato son correctas
                        try {
                            ProfesoresDTO profesor = m_modelo.findProfesorByUsuario(user);
                            if (profesor != null) {
                                bTest = md5(pass).equals(profesor.getPassword());
                                if (bTest) {
                                    // El usuario es válido
                                    
                                    RolProfesorDTO rolProfesor = rol.findRolByProfesorId(profesor.getId());
                                    navegacion(rolProfesor.getId_rol_fk(),profesor.getId());
                                }
                                else
                                    m_vista.printMensajeUserPassIncorrectos();
                            } else {
                                m_vista.printMensajeUserPassIncorrectos();
                            }
                        } catch (Exception e) {
                            m_vista.printMensajeErrorValidacion();
                            e.printStackTrace();
                        }

                    }
                }
            };

            Thread hilo = new Thread(miRunnable);
            hilo.start();
        }
    }

    /**
     * Clase encargada de gestionar los evento asociados al botón de Cancelar
     * en la vista de Login. 
     */
    class CancelarListener implements ActionListener {

    /**
     * Se lanza cuando el usuario pulsa Cancelar en la vista de Login
     *
     * @param e Un objeto ActionEvent con el evento disparado en la vista
     */
        @Override
        public void actionPerformed(ActionEvent e) {
            m_vista.salir();
        }
    }

    /**
     * Método main que permite realizar pruebas de ejecución de diversos 
     * métodos de la clase.
     *
     * @param args Array de argumentos de ejecución
     */
    public static void main(String[] args) throws IOException, Exception {

      BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
      System.out.println("Palabra a codificar: \n");
      String palabra = entrada.readLine();
      System.out.println("Calculando código ...\n");
      String clave = LoginControlador.md5(palabra); 
      System.out.println("Código md5: " + clave + "\n");

    }
}