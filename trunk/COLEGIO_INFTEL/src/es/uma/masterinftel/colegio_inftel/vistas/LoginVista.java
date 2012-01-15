/*
 * LoginVista.java
 *
 */

package es.uma.masterinftel.colegio_inftel.vistas;

import es.uma.masterinftel.colegio_inftel.modelo.dao.*;
import es.uma.masterinftel.colegio_inftel.control.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Vista para la validación de usuarios de la aplicación y su acceso a la misma
 *
 * @author Jesús Barriga
 * @version v1.0 Diciembre-2011
 */
public class LoginVista extends javax.swing.JFrame {
    
    /**
     * Constructor de la clase, especificando el modelo y la vista.
     *
     * @param modelo El modelo utilizado con los datos del usuario
     */
    public LoginVista(ProfesoresDAO modelo) {
        
        initComponents();
        
        //Centramos la ventana en pantalla
        this.setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAC - Login");
        setAlwaysOnTop(true);

        lblUsuario.setText("Usuario");
        lblUsuario.setName("usernameLabel"); // NOI18N

        lblPassword.setText("Contraseña");
        lblPassword.setName("passwordLabel"); // NOI18N

        txtUsuario.setToolTipText("Introduzca nombre de usuario");
        txtUsuario.setName("usernameText"); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtPassword.setToolTipText("introduzca contraseña");
        txtPassword.setName("passwordText"); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setName("introButton"); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        lblTitulo.setText("SISTEMA ASISTIDO DE CALIFICACIONES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblTitulo)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword)
                            .addComponent(lblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * Acción para validar el usuario/password introducidos
     *
     * @param a Acción
     */
    public void addAceptarListener(ActionListener a){
        btnAceptar.addActionListener(a);
    }

    /**
     * Acción para cancelar el acceso a la aplicación
     *
     * @param a Acción
     */
    public void addCancelarListener(ActionListener a){
        btnCancelar.addActionListener(a);
    }
    
     /**
     * Devuelve en un string el usuario introducido
     *
     * @return Cadena con el usuario
     */
    public String getUsuario() {
        return txtUsuario.getText();
    }

    /**
     * Devuelve en un array de caracteres la contraseña introducida
     *
     * @return Array de caracteres con el contraseña
     */
    public char[] getClave() {
        return txtPassword.getPassword();
    }

    /**
     * Muestra en pantalla un mensaje indicando que el usuario o la password
     * introducidas no son válidas.
     */
    public void printMensajeUserPassIncorrectos() {
        JOptionPane.showMessageDialog(this,
                "Usuario / Password incorrectos");
    }

    /**
     * Muestra en pantalla un mensaje indicando que no se han intoruducido el
     * usuario o la contraseña.
     */
    public void printMensajeUserPassVacios() {
        JOptionPane.showMessageDialog(this,
                "Debe introducir usuario y password");
    }
  
    /**
     * Muestra en pantalla un mensaje informativo indicando que se ha producido
     * un error validando el usuario / password introducidos.
     */
    public void printMensajeErrorValidacion() {
        JOptionPane.showMessageDialog(this,
                "Se ha producido un error validando usuario y password");
    }
    
    /**
     * Provoca la salida de la aplicación. Este método es invocado desde el 
     * controlador para finalizar la apliación al pulsar éste el botón Cancelar.
     */
    public void salir() {
        System.exit(0);
    }
    
    /**
     * Mediante este método se consigue que al mostrarse la vista, el foco 
     * esté asignado al campo correspondiente a la introducción del usuario.
     */
    public void focoInicial() {
        txtUsuario.grabFocus();
    }
    
    /**
     * Método main que posibilita que esta vista lance la aplicación como
     * ventana inicial de la misma.
     *
     * @param args Array de cadenas con posibles parámeros de entrada
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ProfesoresDAO modelo = new ProfesoresDAO();
                LoginVista vista = new LoginVista(modelo);
                LoginControlador control = new LoginControlador(modelo,vista);
  
                vista.setVisible(true);
            }
        });
    }
}