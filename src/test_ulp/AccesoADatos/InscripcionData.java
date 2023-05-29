/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_ulp.AccesoADatos;

import test_ulp.Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class InscripcionData {

    private Connection con = null;
    private MateriaData matData = new MateriaData(); //generamos un objeto MateriaData
    private AlumnoData alumData = new AlumnoData(); //generamos un objeto AlumnoData
//    private Conexion conexion;
    
    public InscripcionData(){
        //aca proveemos el metodo para que podamos conectar la clase a la base de datos
        this.con = Conexion.getConexion();
    }
    
    public void InscribirAlumno(Inscripcion insc){
        // aca AGREGAMOS (insert into) en la tabla inscripcion, un alumno dentro de una materia, con una nota
        String sql = "INSERT INTO inscripcion(id_alumno, id_materia, nota) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getIdAlumno());
            ps.setInt(2, insc.getIdMateria());
            ps.setDouble(3, insc.getNota());
            
           ps.executeUpdate();
           ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()){
                insc.setIdInscripto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "La inscripcion se ha realizado correctamente.");
            }
        } catch (SQLException ex){
            
        
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Inscripcion "+ex.getLocalizedMessage());
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        //aca obtenemos la lista de alumnos inscriptos y en que materia se encuentran inscritos
        //ademas de recibir la nota que cada uno posee respectivamente en cada materia
        List<Inscripcion> cursadas = new ArrayList<>();
        try{
            //nuestro string PIDE toda la informacion de todas las tablas (select * from)
            //dentro de la tabla inscripcion
            String sql = "SELECT * FROM inscripcion;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Inscripcion insc;
            
            while(rs.next()){
                insc = new Inscripcion();
                insc.setIdInscripto(rs.getInt("id_inscripto"));
                
                Alumno a = alumData.buscarAlumno(rs.getInt("id_alumno"));
                insc.setIdAlumno(a.getId_alumno());
                
                Materia m = matData.buscarMateria(rs.getInt("id_materia"));
                insc.setIdMateria(m.getId_materia());
                insc.setNota(rs.getDouble("nota"));

                cursadas.add(insc);
            }      
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Error al realizar la inscripcion: " +ex.getLocalizedMessage());
        }
        return cursadas;
    }
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
        List<Inscripcion> cursadas = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM inscripcion WHERE id_alumno = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            Inscripcion insc;
            
             while(rs.next()){

                Inscripcion inscript = new Inscripcion();
                inscript.setIdInscripto(rs.getInt("id_inscripto"));

                Alumno a = alumData.buscarAlumno(rs.getInt("id_alumno"));
                inscript.setAlumno(a);

                Materia m = matData.buscarMateria(rs.getInt("id_materia"));
                inscript.setMateria(m);
                
                inscript.setNota(rs.getDouble("nota"));
               
                cursadas.add(inscript);
            }      
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a Inscripcion. Codigo: "+ex.getLocalizedMessage());
        }
        return cursadas;
    }
    
    public List<Materia> obtenerMateriasCursadas(int id){
        List<Materia> materias = new ArrayList<>();
        
        try{
            String sql = "SELECT inscripcion.id_materia, nombre_materia, anio FROM inscripcion, materias "
                    + "WHERE inscripcion.id_materia = materias.id_materia AND materias.estado AND inscripcion.id_alumno = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while(rs.next()){
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre_materia(rs.getString("nombre_materia"));
                materia.setAnio(rs.getInt("anio"));
                materias.add(materia);
            }      
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones. Codigo de error: "+ex.getLocalizedMessage());
        }
        return materias;
        }

    
    public List<Materia> obtenerMateriasNOCursadas(int id){
        List<Materia> materias = new ArrayList<>();
          
        try {
            String sql = "SELECT * FROM materias WHERE estado = 1 AND id_materia not in "
                    + "(SELECT id_materia FROM inscripcion WHERE id_alumno = ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            Materia materia;
            
            while(resultSet.next()){
                materia = new Materia();
                materia.setId_materia(resultSet.getInt("id_materia"));
                materia.setNombre_materia(resultSet.getString("nombre_materia"));
                materia.setAnio(resultSet.getInt("anio"));
                materias.add(materia);
            }      
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripcion. Codigo: "+ex.getLocalizedMessage());
        }
        
        return materias;  
    }
    
    public void borrarInscripcionMateriaAlumno(int id_alumno,int id_materia){
                try {
            
            String sql = "DELETE FROM inscripcion WHERE id_alumno = ? and id_materia = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_alumno);
            ps.setInt(2, id_materia);
               
            int filas=ps.executeUpdate();
            if(filas > 0){
                JOptionPane.showMessageDialog(null, "Inscripcion Eliminada");
            }else {
                JOptionPane.showMessageDialog(null, "La inscripcion indicada no existe.");
            }
             
            ps.close();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion. Codigo: "+ex.getLocalizedMessage());
        }
        
    }
    
    public void actualizarNota(int id_alumno,int id_materia, double nota){
         try {
            
            String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1,nota);
            ps.setInt(2, id_alumno);
            ps.setInt(3, id_materia);
           
            int filas=ps.executeUpdate(); 
            if(filas > 0){
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }else {
                JOptionPane.showMessageDialog(null, "El alumno o la materia que fue indicado no existe");
            }
            ps.close();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar nota. Codigo: "+ex.getLocalizedMessage());
        }
    }
    
    
        public List<Alumno> obtenerAlumnosPorMateria(int idMateria){
                List<Alumno> alumnosMateria = new ArrayList<>();  

        try {
            String sql = "SELECT a.id_alumno, dni_alumno, nombre_alumno, apellido_alumno ,fechaNacimiento, estado_alumno "
                    + "FROM inscripcion i,alumno a WHERE i.id_alumno = a.id_alumno AND id_materia = ? AND a.estado_alumno = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMateria);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Alumno alum = new Alumno();
                alum.setId_alumno(rs.getInt("id_alumno"));
                alum.setDni_alumno(rs.getInt("dni_alumno"));
                alum.setNombre_alumno(rs.getString("nombre_alumno"));
                alum.setApellido_alumno(rs.getString("apellido_alumno"));
                alum.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alum.setEstado_alumno(true);
                
                alumnosMateria.add(alum);
     
            }      
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias. Codigo: " + ex.getLocalizedMessage());
        }
        return alumnosMateria;
    }
}