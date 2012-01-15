package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la tabla Rol_Profesor
 *
 * @author Jesús Barriga
 * @version 1.0, Diciembre-2011
 */
public class RolProfesorDTO {

    private Integer id_rol_fk;
    private Integer id_profesor_fk;

    /**
     * Método Get
     * @return Identificador de profesor
     */
    public Integer getId_profesor_fk() {
        return id_profesor_fk;
    }

    /**
     * Método Get
     * @return Identificador de rol
     */
    public Integer getId_rol_fk() {
        return id_rol_fk;
    }

    /**
     * Método Set
     * @param id_profesor_fk identificdor de profesor
     */
    public void setId_profesor_fk(Integer id_profesor_fk) {
        this.id_profesor_fk = id_profesor_fk;
    }

    /**
     * Método Set
     * @param id_rol_fk identificdor de rol
     */
    public void setId_rol_fk(Integer id_rol_fk) {
        this.id_rol_fk = id_rol_fk;
    }
}
