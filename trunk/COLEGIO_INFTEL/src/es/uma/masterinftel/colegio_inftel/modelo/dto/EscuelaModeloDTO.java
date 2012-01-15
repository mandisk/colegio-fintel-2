/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.masterinftel.colegio_inftel.modelo.dto;

/**
 * Clase DTO (TransferObject) para la el modelo principal
 * 
 * @author Manuel Valls
 * @version v1.0
 */
public class EscuelaModeloDTO {
    
    private Integer codasignatura_fk;
    private Integer id_cursos_fk;
    private Integer id_grupo_fk;
    
    /**
     * Método get
     * @return Código de asignatura
     */
     public Integer getCodasignatura_fk() {
        return codasignatura_fk;
    }
     /**
      * Método get
      * @return Id del curso
      */
     public Integer getId_cursos_fk(){
        return id_cursos_fk;
     }
     /**
      * Método get
      * @return Id del Grupo
      */
     public Integer getId_grupo_fk(){
     return id_grupo_fk;
     }
     /**
      * Método set
      * @param codasignatura_fk Código de la asignatura 
      */
     public void setCodasignatura_fk(Integer codasignatura_fk) {
        this.codasignatura_fk = codasignatura_fk;
    }
     /**
      * Método set
      * @param id_cursos_fk Id del Curso 
      */
     public void setId_cursos_fk(Integer id_cursos_fk){
     this.id_cursos_fk = id_cursos_fk;
     }
     /**
      * Método set
      * @param id_grupo_fk Id del grupo
      */
     public void setId_grupo_kf(Integer id_grupo_fk){
     this.id_grupo_fk = id_grupo_fk;
     }

}
