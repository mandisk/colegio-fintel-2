/*
 * ObjCombo.java
 */

package es.uma.masterinftel.colegio_inftel.utilidades;

/**
 * Clase para almacenar objetos en los combos guardando su identificador y
 * la descripción del mismo.
 *
 * @author  Agustín Pereña
 * @version v1.0
 */
public class ObjCombo {

        /**
         * identificador del elemento
         */
        private Integer  id;
         /**
         * descripción del elemento
         */
        private String   nombre;

        /**
         * Constructor de la clase
         * @param id        identificador
         * @param nombre    descripción
         */
        public ObjCombo(Integer id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        /**
         * Necesario para la ordenación en combos
         * @param p objeto de combo
         * @return true si son el mismo element dentro del combo
         */
        public boolean equals(ObjCombo p) {
            if (p.nombre.compareTo(this.nombre) == 0) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Imrpresión del objeto
         * @return descripción del elemento
         */
        @Override
        public String toString() {
            return nombre;
        }

        /**
         * Método Get
         * @return identificador elemento
         */
        public Integer getId() {
            return id;
        }

        /**
         * Método Set
         * @return descripción del elemento
         */
        public String getNombre() {
            return nombre;
        }


}
