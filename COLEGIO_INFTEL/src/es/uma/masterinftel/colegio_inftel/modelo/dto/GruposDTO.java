/*
 * GruposDTO.java
 */

package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la tabla Grupos
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class GruposDTO {

    private Integer id;
    private String  desc;

    /**
     * Método Get
     * @return Descripción del grupo
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Método Get
     * @return Identificador del grupo
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método Set
     * @param desc Descripción del grupo
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Método Get
     * @param id Identificador del grupo
     */
    public void setId(Integer id) {
        this.id = id;
    }



}
