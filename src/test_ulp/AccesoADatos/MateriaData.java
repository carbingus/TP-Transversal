package test_ulp.AccesoADatos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import test_ulp.Entidades.Materia;

public class MateriaData {
    private Connection conexion = null;

    public MateriaData() {
        conexion = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia) {
        try {
            String sql = "INSERT INTO materias(nombre_materia,anio,estado) VALUES (?,?,?);";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, materia.getNombre_materia());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Materia agregada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
        }
    }

    public Materia buscarMateria(int id) {
        Materia materia = null;
        try {
            String sql = "SELECT * FROM materias WHERE id_materia = ? AND estado = 1";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia(id, rs.getString("nombre_materia"), rs.getInt("anio"), rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return materia;
    }

    public void modificarMateria(Materia materia) {
        try {
            String sql = "UPDATE materias SET nombre_materia = ?, anio = ? WHERE id_materia = ? AND estado = 1;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, materia.getNombre_materia());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getId_materia());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Materia actualizada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }

    public void eliminarMateria(int id) {
        try {
            String sql = "UPDATE materias SET estado = 0 WHERE id_materia = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Materia eliminada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }

    public List<Materia> listarMaterias() {
        List<Materia> listaMaterias = new ArrayList();
        try {
            String sql = "SELECT * FROM materias WHERE estado = 1;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                listaMaterias.add(new Materia(rs.getInt("id_materia"), rs.getString("nombre_materia"), rs.getInt("anio"), rs.getBoolean("estado")));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return listaMaterias;
    }
    
    /*
    public void activarMateria(int id) {
        try {
            String sql = "UPDATE materias SET estado = 1 WHERE id_materia = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Materia activada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    */
    
}
