package test_ulp.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import test_ulp.Entidades.Alumno;

public class AlumnoData {

    private Connection con = null;
    

  public AlumnoData() {
            con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) { //creacion de nuevo alumno

        String sql = "INSERT INTO alumnos (dni_alumno, nombre_alumno, apellido_alumno, fechaNacimiento, estado_alumno) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni_alumno());
            ps.setString(2, alumno.getApellido_alumno());
            ps.setString(3, alumno.getNombre_alumno());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));//localDate a Date
            ps.setBoolean(5, alumno.isEstado_alumno()); // if reducido
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no fue añadido.");
            }

            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex);
        }

    }

    public Alumno buscarAlumno(int id) { //buscar alumno activo (estado_alumno = 1)
        Alumno alumno = new Alumno();
        String sql = "SELECT dni_alumno, apellido_alumno, nombre_alumno, fechaNacimiento FROM alumnos WHERE id_alumno=? AND estado_alumno = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno.setId_alumno(id);
                alumno.setDni_alumno(rs.getInt("dni_alumno"));
                alumno.setApellido_alumno(rs.getString("apellido_alumno"));
                alumno.setNombre_alumno(rs.getString("nombre_alumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }

        return alumno;
    }

    public Alumno modificarAlumno(Alumno alumno) { //modificar alumno pidiendo id para referenciar

        String sql = "UPDATE alumnos SET dni_alumno = ? , apellido_alumno = ?, nombre_alumno = ?, fechaNacimiento = ? WHERE  id_alumno = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni_alumno());
            ps.setString(2, alumno.getApellido_alumno());
            ps.setString(3, alumno.getNombre_alumno());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getId_alumno());
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
        return alumno;
    }

    public List<Alumno> listarAlumnos() { //mostrar todos los alumnos que esten activos (estado_alumno = 1)

        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumnos WHERE estado_alumno = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni_alumno(rs.getInt("dni_alumno"));
                alumno.setApellido_alumno(rs.getString("apellido_alumno"));
                alumno.setNombre_alumno(rs.getString("nombre_alumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado_alumno(rs.getBoolean("estado_alumno"));
                alumnos.add(alumno);
            }
            ps.close();
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
        return alumnos;
    }

    public void eliminarAlumno(int id) { //eliminar/desactivar alumno (estado_alumno = 0) usando id_alumno por referencia

        try {
            String sql = "UPDATE alumnos SET estado_alumno = 0 WHERE id_alumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();
            ps.close();
            if(fila==1){
                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
    }

    public void activarAlumno(int id) { //activar alumno (estado_alumno = 1) usando id_alumno por referencia

        try {
            String sql = "UPDATE alumnos SET estado_alumno = 1 WHERE id_alumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();
            ps.close();
            if(fila==1){
                JOptionPane.showMessageDialog(null, " Se activo el alumno.");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
    }

}
