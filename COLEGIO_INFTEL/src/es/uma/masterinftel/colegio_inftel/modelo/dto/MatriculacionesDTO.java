/*
 * MatriculacionesDTO.java
 * 
 */

package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la tabla Grupos
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class MatriculacionesDTO {

    private Integer anio_mat;
    private Integer id_alumno_fk;
    private Integer id_grupo_fk;
    private Integer id_cursos_fk;
    private String  repetidor;
    private Integer faltas_acumuladas;
    private Integer retardos;
    private Integer sanciones;
    private String  observaciones;

    /**
     * Método Get
     * @return Año de matriculación
     */
    public Integer getAnio_mat() {
        return anio_mat;
    }

    /**
     * Método Get
     * @return Faltas acumuladas
     */
    public Integer getFaltas_acumuladas() {
        return faltas_acumuladas;
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
     * @return Identificador del curso
     */
    public Integer getId_cursos_fk() {
        return id_cursos_fk;
    }

    /**
     * Método Get
     * @return Identificador del grupo
     */
    public Integer getId_grupo_fk() {
        return id_grupo_fk;
    }

    /**
     * Método Get
     * @return Observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Método Get
     * @return Indica si el alumno es repetido
     */
    public String getRepetidor() {
        return repetidor;
    }

    /**
     * Método Get
     * @return Número de veces que ha llegado tarde
     */
    public Integer getRetardos() {
        return retardos;
    }

    /**
     * Método Get
     * @return Número de sanciones impuestas al alumno
     */
    public Integer getSanciones() {
        return sanciones;
    }

    /**
     * Método Set
     * @param anio_mat Año de matriculación
     */
    public void setAnio_mat(Integer anio_mat) {
        this.anio_mat = anio_mat;
    }

    /**
     * Método Set
     * @param faltas_acumuladas Número de faltas acumuladas por el alumno
     */
    public void setFaltas_acumuladas(Integer faltas_acumuladas) {
        this.faltas_acumuladas = faltas_acumuladas;
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
     * @param id_cursos_fk Identificador del curso asociado
     */
    public void setId_cursos_fk(Integer id_cursos_fk) {
        this.id_cursos_fk = id_cursos_fk;
    }

    /**
     * Método Set
     * @param id_grupo_fk Identificador del grupo
     */
    public void setId_grupo_fk(Integer id_grupo_fk) {
        this.id_grupo_fk = id_grupo_fk;
    }

    /**
     * Método Set
     * @param observaciones Observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Método Set
     * @param repetidor Indica si es repetidor
     */
    public void setRepetidor(String repetidor) {
        this.repetidor = repetidor;
    }

    /**
     * Método Set
     * @param retardos Número de retardos del alumno
     */
    public void setRetardos(Integer retardos) {
        this.retardos = retardos;
    }

    /**
     * Método Set
     * @param sanciones Número de sanciones impuestas al alumno
     */
    public void setSanciones(Integer sanciones) {
        this.sanciones = sanciones;
    }

    




}
