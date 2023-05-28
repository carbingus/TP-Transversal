package test_ulp.Vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import test_ulp.Entidades.*;
import test_ulp.AccesoADatos.*;

public class FormularioAlumno extends javax.swing.JInternalFrame {
    private AlumnoData alumData=new AlumnoData();
    private Alumno alumnoActual=null;

    public FormularioAlumno() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlblDocum = new javax.swing.JLabel();
        jbtBuscar = new javax.swing.JButton();
        jlblApell = new javax.swing.JLabel();
        jlblNomb = new javax.swing.JLabel();
        jlblStado = new javax.swing.JLabel();
        jtxtDNI = new javax.swing.JTextField();
        jtxtApell = new javax.swing.JTextField();
        jtxtNomb = new javax.swing.JTextField();
        jlblFechaNac = new javax.swing.JLabel();
        jbtAgregar = new javax.swing.JButton();
        jbtEliminar = new javax.swing.JButton();
        jbtSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jcFechaNac = new com.toedter.calendar.JDateChooser();
        jrbtStado = new javax.swing.JRadioButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Alumnos");

        jlblDocum.setText("Documento:");

        jbtBuscar.setText("Buscar");
        jbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscarActionPerformed(evt);
            }
        });

        jlblApell.setText("Apellido:");

        jlblNomb.setText("Nombre:");

        jlblStado.setText("Estado:");

        jlblFechaNac.setText("Fecha de nacimiento:");

        jbtAgregar.setText("Agregar");
        jbtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAgregarActionPerformed(evt);
            }
        });

        jbtEliminar.setText("Eliminar");
        jbtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEliminarActionPerformed(evt);
            }
        });

        jbtSalir.setText("Salir");
        jbtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblFechaNac)
                                    .addComponent(jlblStado)
                                    .addComponent(jbtAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtApell, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtEliminar))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbtBuscar)
                                            .addComponent(jbtSalir, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrbtStado)))
                            .addComponent(jlblApell)
                            .addComponent(jlblNomb)
                            .addComponent(jlblDocum, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDocum)
                    .addComponent(jtxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblApell)
                    .addComponent(jtxtApell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomb)
                    .addComponent(jtxtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbtStado)
                    .addComponent(jlblStado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblFechaNac)
                    .addComponent(jcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAgregar)
                    .addComponent(jbtEliminar)
                    .addComponent(jbtSalir))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAgregarActionPerformed
        try {
            int dni = Integer.parseInt(jtxtDNI.getText());
            String nombre = jtxtNomb.getText();
            String apellido = jtxtApell.getText();
            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos");
                return;

            }
            Date sfecha = jcFechaNac.getDate();
            LocalDate fechaNac = sfecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            boolean estado = jrbtStado.isSelected();

            if (alumnoActual == null) {
                alumnoActual = new Alumno(dni, apellido, nombre, fechaNac, estado);

                alumData.guardarAlumno(alumnoActual);

            } else {
                alumnoActual.setDni_alumno(dni);
                alumnoActual.setApellido_alumno(apellido);
                alumnoActual.setNombre_alumno(nombre);
                alumnoActual.setFechaNacimiento(fechaNac);
                alumData.modificarAlumno(alumnoActual);
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, "Usted debe ingresar un dni valido.");
        }
        limpiarFormulario();
        alumnoActual = null;
    }//GEN-LAST:event_jbtAgregarActionPerformed

    private void jbtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbtSalirActionPerformed

    private void jbtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEliminarActionPerformed
        // TODO add your handling code here:
            
        if(alumnoActual!=null){
        
            alumData.eliminarAlumno(alumnoActual.getId_alumno());
            alumnoActual=null;
            limpiarFormulario();
        }else {
        
            JOptionPane.showMessageDialog(this, "No hay un alumno seleccionado");
        }
    }//GEN-LAST:event_jbtEliminarActionPerformed

    private void jbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscarActionPerformed
        // TODO add your handling code here:
               try{ 
        Integer dni = Integer.parseInt(jtxtDNI.getText());
        alumnoActual = alumData.buscarAlumnoPorDni(dni);

        if (alumnoActual != null) {
            //Cambiar int a string
            jtxtApell.setText(alumnoActual.getApellido_alumno());
            jtxtNomb.setText(alumnoActual.getNombre_alumno());
            //Hacer Localdate to Date
            jrbtStado.setSelected(alumnoActual.isEstado_alumno());
            LocalDate lc = alumnoActual.getFechaNacimiento();
            Date date = Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
            jcFechaNac.setDate(date);

        }
        
        
        
       }catch(NumberFormatException nf){
           JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
           return;
       }
    }//GEN-LAST:event_jbtBuscarActionPerformed

        private void limpiarFormulario() {
     
        jtxtDNI.setText("");
        jtxtApell.setText("");
        jtxtNomb.setText("");
        jrbtStado.setSelected(true);
        jcFechaNac.setDate(new Date());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtEliminar;
    private javax.swing.JButton jbtSalir;
    private com.toedter.calendar.JDateChooser jcFechaNac;
    private javax.swing.JLabel jlblApell;
    private javax.swing.JLabel jlblDocum;
    private javax.swing.JLabel jlblFechaNac;
    private javax.swing.JLabel jlblNomb;
    private javax.swing.JLabel jlblStado;
    private javax.swing.JRadioButton jrbtStado;
    private javax.swing.JTextField jtxtApell;
    private javax.swing.JTextField jtxtDNI;
    private javax.swing.JTextField jtxtNomb;
    // End of variables declaration//GEN-END:variables
}
