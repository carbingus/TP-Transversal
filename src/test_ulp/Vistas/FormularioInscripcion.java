package test_ulp.Vistas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import test_ulp.AccesoADatos.AlumnoData;
import test_ulp.AccesoADatos.InscripcionData;
import test_ulp.Entidades.Alumno;
import test_ulp.Entidades.Inscripcion;
import test_ulp.Entidades.Materia;

public class FormularioInscripcion extends javax.swing.JInternalFrame {
    private AlumnoData aData = new AlumnoData();
    private InscripcionData iData = new InscripcionData();
    private DefaultTableModel tabla = new DefaultTableModel();

    public FormularioInscripcion() {
        initComponents();
        
        setTitle("Formulario de inscripcion");
        setResizable(false);
        
        tablaMaterias.setModel(tabla);
        tabla.addColumn("ID");
        tabla.addColumn("NOMBRE");
        tabla.addColumn("AÑO");
        
        btnInscribir.setEnabled(false);
        btnAnularInscripcion.setEnabled(false);
        
        btnGrupo.add(rbtnInscriptos);
        btnGrupo.add(rbtnNoInscriptos);
        
        List<Alumno> listaAlumnos = aData.listarAlumnos();
        for (Alumno a : listaAlumnos) {
            cmbAlumnos.addItem(a);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAnularInscripcion = new javax.swing.JButton();
        btnInscribir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cmbAlumnos = new javax.swing.JComboBox<>();
        lblAlumno = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbtnInscriptos = new javax.swing.JRadioButton();
        rbtnNoInscriptos = new javax.swing.JRadioButton();
        lblMaterias = new javax.swing.JLabel();

        setClosable(true);

        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "AÑO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMaterias);
        if (tablaMaterias.getColumnModel().getColumnCount() > 0) {
            tablaMaterias.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaMaterias.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setText("Formulario de Inscripcion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addGap(12, 12, 12))
        );

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAnularInscripcion.setText("Anular Inscripcion");
        btnAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularInscripcionActionPerformed(evt);
            }
        });

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInscribir)
                .addGap(79, 79, 79)
                .addComponent(btnAnularInscripcion)
                .addGap(75, 75, 75)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAnularInscripcion)
                    .addComponent(btnInscribir))
                .addGap(24, 24, 24))
        );

        lblAlumno.setText("Elija un alumno:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlumno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rbtnInscriptos.setText("Inscriptas");
        rbtnInscriptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInscriptosActionPerformed(evt);
            }
        });

        rbtnNoInscriptos.setText("No Inscriptas");
        rbtnNoInscriptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoInscriptosActionPerformed(evt);
            }
        });

        lblMaterias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMaterias.setText("Listado de Materias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbtnInscriptos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnNoInscriptos)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addComponent(lblMaterias)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblMaterias)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnInscriptos)
                    .addComponent(rbtnNoInscriptos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnInscriptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInscriptosActionPerformed
        limpiarTabla();
        
        btnInscribir.setEnabled(false);
        btnAnularInscripcion.setEnabled(true);
        
        Alumno alumno = (Alumno)cmbAlumnos.getSelectedItem();
        List<Materia> listaMaterias = iData.obtenerMateriasCursadas(alumno.getId_alumno());
        
        for(Materia m : listaMaterias){
            tabla.addRow(new Object[] {m.getId_materia(), m.getNombre_materia(), m.getAnio()});
        }
    }//GEN-LAST:event_rbtnInscriptosActionPerformed

    private void rbtnNoInscriptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoInscriptosActionPerformed
        limpiarTabla();
        
        btnInscribir.setEnabled(true);
        btnAnularInscripcion.setEnabled(false);
        
        Alumno alumno = (Alumno)cmbAlumnos.getSelectedItem();
        List<Materia> listaMaterias = iData.obtenerMateriasNOCursadas(alumno.getId_alumno());
        
        for(Materia m : listaMaterias){
            tabla.addRow(new Object[] {m.getId_materia(), m.getNombre_materia(), m.getAnio()});
        }
    }//GEN-LAST:event_rbtnNoInscriptosActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        int fila = tablaMaterias.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "No seleccionaste una Materia!");
        } else {
            Alumno alumno = (Alumno)cmbAlumnos.getSelectedItem();
            Materia materia = new Materia((Integer)tabla.getValueAt(fila, 0), (String)tabla.getValueAt(fila, 1), (Integer)tabla.getValueAt(fila, 2), true);
            Inscripcion inscripcion = new Inscripcion(alumno, materia, 0);
            
            iData.guardarInscripcion(inscripcion);
            
            JOptionPane.showMessageDialog(this, "Inscripcion exitosa!");
            tabla.removeRow(fila);
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularInscripcionActionPerformed
        int fila = tablaMaterias.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "No seleccionaste una Materia!");
        } else {
            Alumno alumno = (Alumno)cmbAlumnos.getSelectedItem();
            Integer id_materia = (Integer)tabla.getValueAt(fila, 0);
            iData.borrarInscripcionMateriaAlumno(alumno.getId_alumno(), id_materia);
            
            JOptionPane.showMessageDialog(this, "Hecho!");
            tabla.removeRow(fila);
        }
    }//GEN-LAST:event_btnAnularInscripcionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    public void limpiarTabla() {
        int nroFilas = tabla.getRowCount()-1;
        while (nroFilas >= 0) {
            tabla.removeRow(nroFilas);
            nroFilas--;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnularInscripcion;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Alumno> cmbAlumnos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblMaterias;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rbtnInscriptos;
    private javax.swing.JRadioButton rbtnNoInscriptos;
    private javax.swing.JTable tablaMaterias;
    // End of variables declaration//GEN-END:variables
}
