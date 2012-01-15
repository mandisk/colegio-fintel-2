/**
 * CalificacionesDTO.java
 *
 */

package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la tabla calificaciones
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class CalificacionesDTO {

    private Integer anio_mat_fk;
    private Integer id_alumno_fk;
    private Integer codasignatura_fk;
    private Double  nota_p1;
    private Double  nota_p2;
    private Double  nota_p3;
    private Double  nota_final;

    /**
     * Método Get
     * @return Año de matriculación
     */
    public Integer getAnio_mat_fk() {
        return anio_mat_fk;
    }

    /**
     * Método Get
     * @return Código de la asignatura
     */
    public Integer getCodasignatura_fk() {
        return codasignatura_fk;
    }

    /**
     * Método Get
     * @return Identificador del alumno
     */
    public Integer getId_alumno_fk() {
        return id_alumno_fk;
    }

    /**
     * Método Get
     * @return Nota final
     */
    public Double getNota_final() {
        return nota_final;
    }

    /**
     * Método Get
     * @return Nota del primer parcial
     */
    public Double getNota_p1() {
        return nota_p1;
    }

    /**
     * Método Get
     * @return Nota del segundo parcial
     */
    public Double getNota_p2() {
        return nota_p2;
    }

    /**
     * Método Get nota del tercer parcial
     * @return Nota del tercer parcial
     */
    public Double getNota_p3() {
        return nota_p3;
    }

    /**
     * Método Set
     * @param anio_mat_fk Año de matriculación
     */
    public void setAnio_mat_fk(Integer anio_mat_fk) {
        this.anio_mat_fk = anio_mat_fk;
    }

    /**
     * Método Set
     * @param codasignatura_fk código de asignatura
     */
    public void setCodasignatura_fk(Integer codasignatura_fk) {
        this.codasignatura_fk = codasignatura_fk;
    }

    /**
     * Método Set
     * @param id_alumno_fk Identificador del alumno
     */
    public void setId_alumno_fk(Integer id_alumno_fk) {
        this.id_alumno_fk = id_alumno_fk;
    }

    /**
     * Método Set
     * @param nota_final Nota final
     */
    public void setNota_final(Double nota_final) {
        this.nota_final = nota_final;
    }

    /**
     * Método Set
     * @param nota_p1 Nota del primer parcial
     */
    public void setNota_p1(Double nota_p1) {
        this.nota_p1 = nota_p1;
    }

    /**
     * Método Set
     * @param nota_p2 Nota del segundo parcial
     */
    public void setNota_p2(Double nota_p2) {
        this.nota_p2 = nota_p2;
    }

    /**
     * Método Set
     * @param nota_p3 Nota del tercer parcial
     */
    public void setNota_p3(Double nota_p3) {
        this.nota_p3 = nota_p3;
    }


    

}
