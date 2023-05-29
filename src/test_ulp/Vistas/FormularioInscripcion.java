package test_ulp.Vistas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import test_ulp.AccesoADatos.AlumnoData;
import test_ulp.AccesoADatos.InscripcionData;
import test_ulp.Entidades.Alumno;
import test_ulp.Entidades.Materia;

public class FormularioInscripcion extends javax.swing.JInternalFrame {
    private AlumnoData aData = new AlumnoData();
    private InscripcionData iData = new InscripcionData();
    private DefaultTableModel tabla = new DefaultTableModel();

    public FormularioInscripcion() {
        initComponents();
        
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
        btnInscribir = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();
        cmbAlumnos = new javax.swing.JComboBox<>();
        lblMaterias = new javax.swing.JLabel();
        rbtnInscriptos = new javax.swing.JRadioButton();
        rbtnNoInscriptos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        btnAnularInscripcion = new javax.swing.JButton();

        setClosable(true);

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setText("Formulario de Inscripcion");

        lblAlumno.setText("Elija un alumno:");

        lblMaterias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMaterias.setText("Listado de Materias");

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

        btnAnularInscripcion.setText("Anular Inscripcion");
        btnAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularInscripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInscribir)
                .addGap(18, 18, 18)
                .addComponent(btnAnularInscripcion)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMaterias)
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblAlumno)
                        .addGap(18, 18, 18)
                        .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(rbtnInscriptos)
                        .addGap(31, 31, 31)
                        .addComponent(rbtnNoInscriptos)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlumno)
                    .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMaterias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnInscriptos)
                    .addComponent(rbtnNoInscriptos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInscribir)
                    .addComponent(btnAnularInscripcion))
                .addContainerGap(23, Short.MAX_VALUE))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularInscripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnularInscripcionActionPerformed

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
    private javax.swing.JComboBox<Alumno> cmbAlumnos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblMaterias;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rbtnInscriptos;
    private javax.swing.JRadioButton rbtnNoInscriptos;
    private javax.swing.JTable tablaMaterias;
    // End of variables declaration//GEN-END:variables
}
