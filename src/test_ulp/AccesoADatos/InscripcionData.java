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
    private MateriaData matData = new MateriaData();
    private AlumnoData alumData = new AlumnoData();
//    private Conexion conexion;
    
    public InscripcionData(Conexion conexion){
        this.con = Conexion.getConexion();
    }
    
    private void InscribirAlumno(Inscripcion insc){
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
            
        
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Inscripcion "+ex.getMessage());
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        List<Inscripcion> cursadas = new ArrayList<>();
        try{
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
            JOptionPane.showInternalMessageDialog(null, "Error al realizar la inscripcion: " +ex.getMessage());
        }
        return cursadas;
    }
}