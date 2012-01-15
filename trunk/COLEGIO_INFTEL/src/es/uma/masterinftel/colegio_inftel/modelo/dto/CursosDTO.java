/*
 * CursosDTO.java
 */

package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la tabla Cursos
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class CursosDTO {

    private Integer id;
    private String  desc;

    /**
     * Método Get
     * @return descripción del curso
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Método Get
     * @return Identificador del curso
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método Set
     * @param desc Descripción del curso
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Método Set
     * @param id Identificador del curso
     */
    public void setId(Integer id) {
        this.id = id;
    }

    

}
