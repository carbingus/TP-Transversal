package test_ulp.Entidades;

public class Inscripcion {
    private int id_inscripto;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion() {
    }

    public Inscripcion(double nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }
    
    public Inscripcion(int id_inscripto, double nota, Alumno alumno, Materia materia){
        this.id_inscripto = id_inscripto;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getId_inscripto() {
        return id_inscripto;
    }

    public void setId_inscripto(int id_inscripto) {
        this.id_inscripto = id_inscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
}
