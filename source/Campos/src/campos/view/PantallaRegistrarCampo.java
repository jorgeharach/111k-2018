/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.view;

import campos.controller.GestorCampos;
import campos.controller.GestorException;
import java.awt.Color;
import campos.model.*;
import campos.utils.FrameUtils;
import campos.utils.HibernateUtils;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Representa la vista con la cuál se puede implementar la interfaz gráfica del
 * caso de uso <strong>Registrar Campo</strong>
 *
 * Esta clase es observadora de la clase Campo, para reaccionar ante los cambios
 * del modelo.
 *
 * Tiene una referencia al GestorCampos, para notificar las distintas acciones
 * del usuario.
 *
 * @author George
 */
public class PantallaRegistrarCampo
        extends javax.swing.JFrame
        implements Observer {

    // Referencia a GestorCampos
    private final GestorCampos gestorCampos;
    // Modelo para la Grilla de Lotes
    private LotesTableModel lotesTableModel;

    /**
     * Crea un form PantallaRegistrarCampo Inicializa los distintos componentes,
     * además de la posición de la ventana y otros detalles gráficos, como el
     * color de fondo.
     *
     * @param gc El GestorCampos con el que se comunicará esta vista
     */
    public PantallaRegistrarCampo(GestorCampos gc) {
        this.gestorCampos = gc;
        initComponents();
        postInit();
    }

    /**
     * Inicializaciones posteriores a las generadas por Netbeans
     */
    private void postInit() {
        this.getContentPane().setBackground(Color.WHITE);
        FrameUtils.centrarComponent(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblSuperficie = new javax.swing.JLabel();
        txtNombreCampo = new javax.swing.JTextField();
        lblNombreEnUso = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spnSuperficieLote = new javax.swing.JSpinner();
        spnNroLote = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoSuelo = new javax.swing.JComboBox<>();
        lblLoteEnUso = new javax.swing.JLabel();
        btnAgregarLote = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnQuitarLote = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLotes = new javax.swing.JTable();
        btnEditarLote = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnRegistrarCampo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        spnSuperficieCampo = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Campo");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblNombre.setLabelFor(txtNombreCampo);
        lblNombre.setText("Nombre:");

        lblSuperficie.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblSuperficie.setText("Superficie:");

        txtNombreCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreCampoFocusLost(evt);
            }
        });

        lblNombreEnUso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombreEnUso.setForeground(new java.awt.Color(255, 0, 0));
        lblNombreEnUso.setText("El nombre ya está en uso");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Usuario:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Invitado");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("ha.");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lotes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("<html>Tenga en cuenta que debe ingresar al menos 1 lote</html>");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nro.:");

        spnSuperficieLote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        spnSuperficieLote.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        spnNroLote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        spnNroLote.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnNroLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spnNroLoteFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Superficie:");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Tipo de Suelo:");

        cmbTipoSuelo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lblLoteEnUso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblLoteEnUso.setForeground(new java.awt.Color(204, 0, 0));
        lblLoteEnUso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoteEnUso.setText("Este nro. de Lote ya está en uso");

        btnAgregarLote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAgregarLote.setText("Agregar Lote");
        btnAgregarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLoteClick(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spnNroLote, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(spnSuperficieLote)
                                    .addComponent(cmbTipoSuelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnAgregarLote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoteEnUso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spnNroLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(spnSuperficieLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addComponent(lblLoteEnUso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarLote)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnQuitarLote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnQuitarLote.setText("Quitar");
        btnQuitarLote.setEnabled(false);
        btnQuitarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarLoteClick(evt);
            }
        });

        tblLotes.setAutoCreateRowSorter(true);
        tblLotes.setModel(new LotesTableModel());
        tblLotes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblLotes);

        btnEditarLote.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEditarLote.setText("Editar");
        btnEditarLote.setEnabled(false);
        btnEditarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarLoteClick(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarLote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitarLote)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarLote)
                    .addComponent(btnEditarLote))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        btnRegistrarCampo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegistrarCampo.setText("Registrar Campo");
        btnRegistrarCampo.setEnabled(false);
        btnRegistrarCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCampoClick(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");

        spnSuperficieCampo.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSuperficie, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spnSuperficieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreEnUso, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarCampo)))
                .addContainerGap())
            .addComponent(jSeparator3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEnUso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSuperficie)
                    .addComponent(jLabel6)
                    .addComponent(spnSuperficieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCampo)
                    .addComponent(btnCancelar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreCampoFocusLost
        this.controlarNombreCampo();
    }//GEN-LAST:event_txtNombreCampoFocusLost

    private void btnRegistrarCampoClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCampoClick

        if (this.controlarValores()) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Confirma el registro del Campo?", "Registrar Campo", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    this.gestorCampos.registrarCampo(this.txtNombreCampo.getText().trim());
                } catch (GestorException ge) {
                    JOptionPane.showMessageDialog(
                            rootPane,
                            ge.getMessage(),
                            "Registrar Campo",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarCampoClick

    private void spnNroLoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spnNroLoteFocusLost
        this.controlarNroLote();
    }//GEN-LAST:event_spnNroLoteFocusLost

    private void btnAgregarLoteClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLoteClick
        // Se controla que el número de lote esté disponible para la utilización
        if (!this.controlarNroLote()) {
            return;
        }
        // Se controla que la superficie no sea cero
        if (!this.controlarSuperficie()) {
            return;
        }
        /* Si las validaciones se realizan exitosamente, se avisa al gestor que
        se va a agregar un Lote */
        this.gestorCampos.agregarLote(
                (Integer) this.spnNroLote.getValue(),
                (Double) this.spnSuperficieLote.getValue(),
                (TipoSuelo) this.cmbTipoSuelo.getSelectedItem()
        );

    }//GEN-LAST:event_btnAgregarLoteClick

    private void btnQuitarLoteClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarLoteClick
        // Se obtiene la selección de la grilla
        Optional<Lote> seleccionado = this.obtenerLoteSeleccionado();
        if (!seleccionado.isPresent()) { // Si no se seleccionó un lote...
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un lote", "Quitar Lote", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Se quita el lote del campo
        this.gestorCampos.quitarLote(seleccionado.get());
    }//GEN-LAST:event_btnQuitarLoteClick

    private void btnEditarLoteClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLoteClick
        // Se obtiene el lote seleccionado de la grilla
        Optional<Lote> seleccionado = this.obtenerLoteSeleccionado();
        if (!seleccionado.isPresent()) { // Si no se seleccionó un lote...
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un lote", "Editar Lote", JOptionPane.WARNING_MESSAGE);
            return;
        }
        /* Para editar, se obtiene el lote seleccionado, luego se lo quita
        del campo actual, y se copian sus datos a los campos de edición */
        Lote aEditar = seleccionado.get();
        this.gestorCampos.quitarLote(aEditar);
        this.spnNroLote.setValue(aEditar.getNumero());
        this.spnSuperficieLote.setValue(aEditar.getSuperficie());
        this.cmbTipoSuelo.setSelectedItem(aEditar.getTipoSuelo());

    }//GEN-LAST:event_btnEditarLoteClick

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        HibernateUtils.finalizeHibernate();
    }//GEN-LAST:event_formWindowClosing

    private Optional<Lote> obtenerLoteSeleccionado() {
        // Se obtiene el índice seleccionado
        int indice = this.tblLotes.getSelectedRow();
        if (indice == -1) { // Si no hay una selección...
            return Optional.empty();
        }
        indice = this.tblLotes.convertRowIndexToModel(indice);
        
        // Se devuelve el lote en ese índice
        return this.lotesTableModel.getLoteEn(indice);
    }

    /**
     * Controla si el número de lote está disponible, en caso de no ser así,
     * habilita el mensaje que indica de la situación
     *
     * @return true si el Nro. de lote está disponible, false en caso contrario
     */
    private boolean controlarNroLote() {
        boolean nroLoteDisponible
                = this.gestorCampos.nroLoteDisponible(
                        (Integer) this.spnNroLote.getValue()
                );
        this.lblLoteEnUso.setVisible(!nroLoteDisponible);
        return nroLoteDisponible;
    }

    /**
     * Controla si la superficie del lote que se está por agregar contiene un
     * valor válido
     *
     * @return true si el valor es correcto, false en caso contrario
     */
    private boolean controlarSuperficie() {
        Double superficie = (Double) this.spnSuperficieLote.getValue();
        if (superficie.equals(0.0)) { // Si la superficie es cero...
            JOptionPane.showMessageDialog(
                    rootPane,
                    "La superficie no puede ser 0",
                    "Registrar Campo",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        return true;
    }

    /**
     * Controla los valores de los distintos campos, antes del registro de un
     * nuevo campo. Verifica que:
     * <ul>
     * <li>el nombre del campo no esté vacío</li>
     * <li>que la superficie del campo coincida con el total de superficie de
     * los lotes (A3 CU) </li>
     * <li>Nombre de campo esté disponible</li>
     * <li>Se haya cargado al menos un lote</li>
     * </ul>
     *
     * @return
     */
    private boolean controlarValores() {
        if ("".equalsIgnoreCase(this.txtNombreCampo.getText().trim())) {
            JOptionPane.showMessageDialog(
                    rootPane,
                    "El nombre del Campo no puede estar vacío",
                    "Registrar Campo",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        Double superficieCampo
                = this.gestorCampos.getCampoActual().getSuperficie();
        if (!this.spnSuperficieCampo.getValue().equals(superficieCampo)) {
            JOptionPane.showMessageDialog(
                    rootPane,
                    String.format(
                            "La superficie del campo (%6.2f ha.), no coincide con la suma de la superficie de los lotes (%6.2f ha.)",
                            (Double) this.spnSuperficieCampo.getValue(),
                            superficieCampo
                    ),
                    "Registrar Campo",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        if (!this.controlarNombreCampo()) {
            return false;
        }
        if (this.gestorCampos.getCampoActual().getLotes().isEmpty()) {
            JOptionPane.showMessageDialog(
                    rootPane,
                    "Debe agregar al menos un Lote",
                    "Registrar Campo",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        return true;
    }

    /**
     * Controla que el nombre de campo esté disponible, en caso contrario
     * habilita el mensaje que indica de la situación
     *
     * @return true si el nombre está disponible, false en caso contrario
     */
    private boolean controlarNombreCampo() {

        try {
            boolean nombreDisponible
                    = this.gestorCampos.nombreDisponible(
                            this.txtNombreCampo.getText().trim()
                    );
            this.lblNombreEnUso.setVisible(!nombreDisponible);
            this.btnRegistrarCampo.setEnabled(nombreDisponible);
            return nombreDisponible;
        } catch (GestorException ge) {
            JOptionPane.showMessageDialog(
                    rootPane,
                    "No se puede controlar el nombre del campo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    /**
     * Método de observación para el caso de que el modelo (la clase Campo, en
     * este caso), sufra una variación en su estado. Esto permite reaccionar al
     * cambio y actualizar los componentes visuales
     *
     * @param o El objeto observado
     * @param arg Argumento que envía el objeto observado
     */
    @Override
    public void update(Observable o, Object arg) {
        Campo campoActual = this.gestorCampos.getCampoActual();
        // Se actualizan los datos en el modelo de la tabla de lotes
        this.lotesTableModel.setData(campoActual.getLotes());
        // Se setea, como sugerencia, el próximo número de lote
        this.spnNroLote.setValue(campoActual.getProximoNroLote());
        // Si hay lotes, se habilita la edición y la quita 
        boolean habilitarBotones = !campoActual.getLotes().isEmpty();
        this.btnEditarLote.setEnabled(habilitarBotones);
        this.btnQuitarLote.setEnabled(habilitarBotones);
        this.btnRegistrarCampo.setEnabled(habilitarBotones);
    }

    /**
     * Inicializa la vista para la creación de un campo nuevo. A partir de este
     * método, los campos están con sus valores por defecto y las distintas
     * listas desplegables se encuentran cargadas con los valores obtendidos
     * mediante el GestorCampos
     */
    public void iniciar() {
        try {
            // Se genera un nuevo campo
            this.gestorCampos.nuevoCampo();
            // Se crea un modelo de la tabla lotes(lista vacía)
            this.lotesTableModel = new LotesTableModel(
                    this.gestorCampos.getCampoActual().getLotes()
            );
            // Se setea el modelo a la tabla
            this.tblLotes.setModel(lotesTableModel);
            // Se pasan los campos a sus valores por defecto
            this.txtNombreCampo.setText("");
            this.btnRegistrarCampo.setEnabled(false);
            this.btnQuitarLote.setEnabled(false);
            this.btnEditarLote.setEnabled(false);
            this.lblNombreEnUso.setVisible(false);
            this.lblLoteEnUso.setVisible(false);
            this.spnNroLote.setValue(1);
            this.spnSuperficieLote.setValue(0.0);
            this.spnSuperficieCampo.setValue(0.0);
            this.cmbTipoSuelo.setModel(
                    new DefaultComboBoxModel(
                            this.gestorCampos.buscarTiposDeSuelo().toArray(new TipoSuelo[0])
                    )
            );
        } catch (GestorException ex) {
            JOptionPane.showMessageDialog(
                    rootPane,
                    ex.getLocalizedMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            /* 
            Si existe una excepción en este punto, la aplicación no puede
            continuar, porque significa que no se han podido levantar los tipos
            de suelo, o los estados del campo
             */
            System.exit(-1);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLote;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarLote;
    private javax.swing.JButton btnQuitarLote;
    private javax.swing.JButton btnRegistrarCampo;
    private javax.swing.JComboBox<TipoSuelo> cmbTipoSuelo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblLoteEnUso;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEnUso;
    private javax.swing.JLabel lblSuperficie;
    private javax.swing.JSpinner spnNroLote;
    private javax.swing.JSpinner spnSuperficieCampo;
    private javax.swing.JSpinner spnSuperficieLote;
    private javax.swing.JTable tblLotes;
    private javax.swing.JTextField txtNombreCampo;
    // End of variables declaration//GEN-END:variables
}
