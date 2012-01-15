/*
 * MatriculadosAsignaturas.java
 */

package es.uma.masterinftel.colegio_inftel.utilidades;

/**
 * Clase para almacenar las asignaturas por codigo y el
 * numero de alumnos matriculados en dicha asignatura.
 * Util para la representacion de graficas estadisticas.
 *
 * @author Luis Jarén
 * @version v1.0
 */
public class MatriculadosAsignaturas {

    /**
    * identificador de una asignatura
    */
    private int codasignatura;
    /**
    * numero de alumnos matriculados en la asignatura
    * cuyo codigo esta representado arriba
    */
    private int alumnosMatriculados;

        /**
         * Método Get
         * @return codasignatura
         */
    public int getCodasignatura(){
        return codasignatura;
    }
        /**
         * Método Get
         * @return  alumnosMatriculados
         */
    public int getAlumnosMatricualdos(){
        return alumnosMatriculados;
    }
        /**
         * Método Set
         * Coloca el valor de codasignatura
         * @param codigo valor a colocar
         **/
    public void setCodasignatura(int codigo){
        codasignatura = codigo;
    }
        /**
         * Método Set
         * Coloca el valor de alumnosMatriculados
         * @param mat valor a colocar
         **/
    public void setAlumnosMatriculados(int mat){
        alumnosMatriculados = mat;
    }
}
