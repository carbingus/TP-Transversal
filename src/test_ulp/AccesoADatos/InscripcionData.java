/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import test_ulp.Entidades.*;


public class InscripcionData {

    private Connection con;

    private Conexion conexion;

    public InscripcionData(Conexion conexion) {
    }

    public void inscribir(Inscripcion insc) {
    }

    public Alumno buscarAlumno(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Materia buscarMateria(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
