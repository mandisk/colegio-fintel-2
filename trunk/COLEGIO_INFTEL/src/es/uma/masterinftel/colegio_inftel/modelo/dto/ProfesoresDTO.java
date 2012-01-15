package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la tabla Profesores
 *
 * @author Jesús Barriga
 * @version 1.0, Diciembre-2011
 */
public class ProfesoresDTO {

    private Integer id;
    private String dni_doc;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telfcontacto;
    private String observaciones;
    private String usuario;
    private String password;
    private String email;

    /**
     * Método Get
     * @return Primer apellido
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Método Get
     * @return Segundo apellido
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Método Get
     * @return Dni
     */
    public String getDni_doc() {
        return dni_doc;
    }

    /**
     * Método Get
     * @return Dirección de eMail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método Get
     * @return Identificador
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método Get
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método Get
     * @return Campo observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Método Get
     * @return Contraseña
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método Get
     * @return Teléfono de contacto
     */
    public String getTelfcontacto() {
        return telfcontacto;
    }

    /**
     * Método Get
     * @return Identificador como usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método Set
     * @param apellido1 primer apellido
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Método Set
     * @param apellido2 segundo apellido
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Método Set
     * @param dni_doc dni
     */
    public void setDni_doc(String dni_doc) {
        this.dni_doc = dni_doc;
    }

    /**
     * Método Set
     * @param email dirección de email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método Set
     * @param id identificador
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método Set
     * @param id nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método Set
     * @param observaciones campo observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Método Set
     * @param id password contraseña
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método Set
     * @param telfcontacto teléfono de contacdto
     */
    public void setTelfcontacto(String telfcontacto) {
        this.telfcontacto = telfcontacto;
    }

    /**
     * Método Set
     * @param usuario identificador como usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
