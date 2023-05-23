package test_ulp.Entidades;

import java.time.LocalDate;

public class Alumno {
    private int id_alumno;
    private int dni_alumno;
    private String apellido_alumno;
    private String nombre_alumno;
    private LocalDate fechaNacimiento;
    private boolean estado_alumno;

    public Alumno() {
    }

    public Alumno(int dni_alumno, String apellido_alumno, String nombre_alumno, LocalDate fechaNacimiento, boolean estado_alumno) {
        this.dni_alumno = dni_alumno;
        this.apellido_alumno = apellido_alumno;
        this.nombre_alumno = nombre_alumno;
        this.fechaNacimiento = fechaNacimiento;
        this.estado_alumno = estado_alumno;
    }

    public Alumno(int id_alumno, int dni_alumno, String apellido_alumno, String nombre_alumno, LocalDate fechaNacimiento, boolean estado_alumno) {
        this.id_alumno = id_alumno;
        this.dni_alumno = dni_alumno;
        this.apellido_alumno = apellido_alumno;
        this.nombre_alumno = nombre_alumno;
        this.fechaNacimiento = fechaNacimiento;
        this.estado_alumno = estado_alumno;
    }
    
    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getDni_alumno() {
        return dni_alumno;
    }

    public void setDni_alumno(int dni_alumno) {
        this.dni_alumno = dni_alumno;
    }

    public String getApellido_alumno() {
        return apellido_alumno;
    }

    public void setApellido_alumno(String apellido_alumno) {
        this.apellido_alumno = apellido_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstado_alumno() {
        return estado_alumno;
    }

    public void setEstado_alumno(boolean estado_alumno) {
        this.estado_alumno = estado_alumno;
    }
    
}
