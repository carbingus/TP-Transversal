package test_ulp.Entidades;

public class Inscripcion {
    
    private int id_inscripto;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion(int id_inscripto, Alumno alumno, Materia materia, double nota){
        this.id_inscripto = id_inscripto;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    
    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
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
    
    public Inscripcion(){
    }
    
    public Inscripcion(double nota){
        this.nota = nota;
    }
    
    public int getIdInscripto(){
        return id_inscripto;
    }
    
    public void setIdInscripto(int id_inscripto){
        this.id_inscripto = id_inscripto;
    }
    
    public int getIdAlumno(){
        return alumno.getId_alumno();
    }
    
    public void setIdAlumno(int id_alumno){
        this.alumno.setId_alumno(id_alumno);
    }
    
    public int getIdMateria(){
        return materia.getId_materia();
    }
    
    public void setIdMateria(int id_materia){
        this.materia.setId_materia(id_materia);    
    }
    
    public double getNota(){
        return nota;
    }
    
    public void setNota(double nota){
        this.nota = nota;
    }
}