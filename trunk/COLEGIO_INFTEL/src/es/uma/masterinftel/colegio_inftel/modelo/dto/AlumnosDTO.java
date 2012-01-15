/*
 * AlumnosDTO.java
 * 
 */

package es.uma.masterinftel.colegio_inftel.modelo.dto;

import java.util.Date;

/**
 * Clase DTO (TransferObject) para la tabla Alumnos
 *
 * @author Agustín Pereña
 * @version v1.0
 */
public class AlumnosDTO {

    private Integer id;
    private String  nombre;
    private String  apellido1;
    private String  apellido2;
    private String  direccion;
    private String  poblacion;
    private String  provincia;
    private String  codpostal;
    private String  telfcontacto;
    private Date    fecnacimiento;
    private String  observaciones;

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
     * @return Código postal
     */
    public String getCodpostal() {
        return codpostal;
    }

    /**
     * Método Get
     * @return Dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método Get
     * @return Fecha de Nacimiento
     */
    public Date getFecnacimiento() {
        return fecnacimiento;
    }

    /**
     * Método Get
     * @return Identificador del alumno
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método Get 
     * @return Nombre del alumno
     */
    public String getNombre() {
        return nombre;
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
     * @return Población de residencia
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Método Get
     * @return Provincia de residencia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Método Get
     * @return Teléfono de contacto
     */
    public String getTelfcontacto() {
        return telfcontacto;
    }

    /**
     * Método Set
     * @param apellido1 Primer apellido
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Método Set
     * @param apellido2 Segundo apellido
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Método Set
     * @param codpostal Código posal
     */
    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    /**
     * Método Set
     * @param direccion Dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método Set
     * @param fecnacimiento Fecha de nacimiento
     */
    public void setFecnacimiento(Date fecnacimiento) {
        this.fecnacimiento = fecnacimiento;
    }

    /**
     * Método Set
     * @param id Identificador del alumno
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método Set
     * @param nombre Nombre del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método Set
     * @param observaciones Campo observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Método Set
     * @param poblacion Población de residencia
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Método Set
     * @param provincia Provincia de residencia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Método Set
     * @param telfcontacto Teléfono de contacto
     */
    public void setTelfcontacto(String telfcontacto) {
        this.telfcontacto = telfcontacto;
    }

    

}
