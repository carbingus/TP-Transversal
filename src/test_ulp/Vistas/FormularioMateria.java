package test_ulp.Vistas;

import java.awt.Color;
import javax.swing.JOptionPane;
import test_ulp.AccesoADatos.MateriaData;
import test_ulp.Entidades.Materia;

public class FormularioMateria extends javax.swing.JInternalFrame {
    MateriaData md = new MateriaData();
    Materia materia = null;

    public FormularioMateria() {
        initComponents();
        limpiar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        lblEstadoValor = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setClosable(true);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setText("Formulario de Materias");

        lblCodigo.setText("Codigo:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        lblAnio.setText("Año:");

        lblEstado.setText("Estado:");

        lblEstadoValor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEstadoValor.setText("-/-");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblAnio)
                                    .addComponent(lblEstado)
                                    .addComponent(lblCodigo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblEstadoValor))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtAnio, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblTitulo)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoValor)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        btnNuevo.setEnabled(true);
        if (txtCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El campo 'Codigo' esta vacio!");
        } else {
            Integer id = Integer.parseInt(txtCodigo.getText());
            materia = md.buscarMateria(id);
        
            if (materia != null) {
                txtNombre.setText(materia.getNombre_materia());
                txtAnio.setText(materia.getAnio()+"");
                if (materia.isEstado()) {
                    lblEstadoValor.setText("Activa");
                    lblEstadoValor.setForeground(new Color(0, 200,0));
                    btnEliminar.setEnabled(true);
                } else {
                    lblEstadoValor.setText("Eliminada");
                    lblEstadoValor.setForeground(Color.red);
                    btnEliminar.setEnabled(false);
                }
                btnModificar.setEnabled(true);
                btnGuardar.setEnabled(false);
            } else {
                limpiar();
                txtCodigo.requestFocus();
                JOptionPane.showMessageDialog(this, "No existe una materia asociada con el codigo.");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().equals("") || txtAnio.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El campo Nombre y/o Año estan vacios!");
        } else {
            materia = new Materia(txtNombre.getText(), Integer.parseInt(txtAnio.getText()), true);
            md.guardarMateria(materia);
            limpiar();
            JOptionPane.showMessageDialog(this, "Materia guardada! [ID:"+materia.getId_materia()+"] [ESTADO:Activa]");
        }
        if (btnGuardar.getText() == "Modificar") {
            JOptionPane.showMessageDialog(this, "se puede moficad");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        md.eliminarMateria(Integer.parseInt(txtCodigo.getText()));
        limpiar();
        JOptionPane.showMessageDialog(this, "Materia eliminada!");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        materia.setNombre_materia(txtNombre.getText());
        materia.setAnio(Integer.parseInt(txtAnio.getText()));
        md.modificarMateria(materia);
        limpiar();
        JOptionPane.showMessageDialog(this, "Materia modificada!");
    }//GEN-LAST:event_btnModificarActionPerformed

    public void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtAnio.setText("");
        lblEstadoValor.setText("-/-");
        lblEstadoValor.setForeground(Color.black);
        txtCodigo.requestFocus();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoValor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
