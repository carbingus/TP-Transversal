package test_ulp.Vistas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import test_ulp.AccesoADatos.InscripcionData;
import test_ulp.AccesoADatos.MateriaData;
import test_ulp.Entidades.Alumno;
import test_ulp.Entidades.Materia;

public class VistaAlumnosPorMateria extends javax.swing.JInternalFrame {
    private MateriaData mData = new MateriaData();
    private InscripcionData iData = new InscripcionData();
    private DefaultTableModel tabla = new DefaultTableModel();

    public VistaAlumnosPorMateria() {
        initComponents();
        setTitle("Formulario de Alumnos por Materia");
        setResizable(false);
        
        List<Materia> listaMaterias = mData.listarMaterias();
        for (Materia m : listaMaterias) {
            cmbMaterias.addItem(m);
        }
        
        tablaAlumnos.setModel(tabla);
        tabla.addColumn("ID");
        tabla.addColumn("DNI");
        tabla.addColumn("APELLIDO");
        tabla.addColumn("NOMBRE");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblMateria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        cmbMaterias = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();

        setClosable(true);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setText("Listado de Alumnos por Materia");

        lblMateria.setText("Seleccione una Materia:");

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaAlumnos);

        cmbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMateriasActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(lblTitulo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(lblMateria)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMateria)
                    .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMateriasActionPerformed
        limpiarTabla();
        
        Materia m = (Materia)cmbMaterias.getSelectedItem();
        List<Alumno> listaAlumnos = iData.obtenerAlumnosPorMateria(m.getId_materia());
        
        for (Alumno a : listaAlumnos) {
            tabla.addRow(new Object[] {a.getId_alumno(), a.getDni_alumno(), a.getApellido_alumno(), a.getNombre_alumno()});
        }
    }//GEN-LAST:event_cmbMateriasActionPerformed

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
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Materia> cmbMaterias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMateria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
