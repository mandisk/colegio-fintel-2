/*
 * AsignaturasDTO.java
 */

package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la tabla asignaturas
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class AsignaturasDTO {

    private Integer codasignatura;
    private String  desc;
    private Integer profesor_id_fk;
    private Integer imparte_cursos_id_fk;

    /**
     * Método Get
     * @return código de asignatura
     */
    public Integer getCodasignatura() {
        return codasignatura;
    }

    /**
     * Método Get
     * @return Descripción de la asignatura
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Método Get
     * @return Identificador del curso donde se imparte
     */
    public Integer getImparte_cursos_id_fk() {
        return imparte_cursos_id_fk;
    }

    /**
     * Método Get
     * @return identificador del profesor
     */
    public Integer getProfesor_id_fk() {
        return profesor_id_fk;
    }

    /**
     * Método Set
     * @param codasignatura código de la asignatura
     */
    public void setCodasignatura(Integer codasignatura) {
        this.codasignatura = codasignatura;
    }

    /**
     * Método Set
     * @param desc Descripción de la Asignatura
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Método Set
     * @param imparte_cursos_id_fk Identificador del curso donde se imparte
     */
    public void setImparte_cursos_id_fk(Integer imparte_cursos_id_fk) {
        this.imparte_cursos_id_fk = imparte_cursos_id_fk;
    }

    /**
     * Método Set
     * @param profesor_id_fk Identificador del profesor
     */
    public void setProfesor_id_fk(Integer profesor_id_fk) {
        this.profesor_id_fk = profesor_id_fk;
    }



}
