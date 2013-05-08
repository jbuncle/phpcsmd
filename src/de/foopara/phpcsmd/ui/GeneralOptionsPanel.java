package de.foopara.phpcsmd.ui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;

import de.foopara.phpcsmd.debug.Logger;
import de.foopara.phpcsmd.generics.GenericOptionsPanel;
import de.foopara.phpcsmd.option.GeneralOptions;

public class GeneralOptionsPanel extends GenericOptionsPanel
{

    /**
     * Creates new form GeneralOptionsPanel
     */
    public GeneralOptionsPanel() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(this.optRegexInclude);
        group.add(this.optRegexExclude);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        optThread = new javax.swing.JCheckBox();
        optUpdateOnSave = new javax.swing.JCheckBox();
        optNotify = new javax.swing.JCheckBox();
        optIgnorePattern = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        optTimeout = new javax.swing.JSpinner();
        optDebug = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        optErrorStripe = new javax.swing.JCheckBox();
        optSeverity = new javax.swing.JComboBox();
        optCheckOpen = new javax.swing.JCheckBox();
        optIncludePattern = new javax.swing.JTextField();
        optRegexInclude = new javax.swing.JRadioButton();
        optRegexExclude = new javax.swing.JRadioButton();
        optScanNonPhp = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(jSeparator1, gridBagConstraints);

        optThread.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optThread.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optThread, gridBagConstraints);

        optUpdateOnSave.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optUpdateOnSave.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optUpdateOnSave, gridBagConstraints);

        optNotify.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optNotify.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optNotify, gridBagConstraints);

        optIgnorePattern.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optIgnorePattern.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 81;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optIgnorePattern, gridBagConstraints);

        jLabel3.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.jLabel3.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 100;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(jLabel3, gridBagConstraints);

        optTimeout.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 100;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optTimeout, gridBagConstraints);

        optDebug.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optDebug.text")); // NOI18N
        optDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDebugActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 90;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(optDebug, gridBagConstraints);

        jButton1.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 90;
        add(jButton1, gridBagConstraints);

        jButton2.setLabel(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.jButton2.label")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 90;
        add(jButton2, gridBagConstraints);

        optErrorStripe.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optErrorStripe.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(optErrorStripe, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 90;
        add(optSeverity, gridBagConstraints);

        optCheckOpen.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optCheckOpen.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(optCheckOpen, gridBagConstraints);

        optIncludePattern.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optIncludePattern.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 80;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optIncludePattern, gridBagConstraints);

        optRegexInclude.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optRegexInclude.text")); // NOI18N
        optRegexInclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRegexActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 80;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optRegexInclude, gridBagConstraints);

        optRegexExclude.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optRegexExclude.text")); // NOI18N
        optRegexExclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRegexActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 81;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        add(optRegexExclude, gridBagConstraints);

        optScanNonPhp.setText(org.openide.util.NbBundle.getMessage(GeneralOptionsPanel.class, "GeneralOptionsPanel.optScanNonPhp.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(optScanNonPhp, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane();
        final javax.swing.JTextPane area = new javax.swing.JTextPane();

        scroll.setViewportView(area);
        scroll.setPreferredSize(new java.awt.Dimension(800, 300));
//        scroll.setMaximumSize(new java.awt.Dimension(800, 300));

        area.setEditable(false);
        area.setBackground(Color.white);
        area.setSelectedTextColor(Color.white);
        area.setSelectionColor(Color.blue);
        area.setEditorKit(new javax.swing.text.html.HTMLEditorKit());
        area.setText(Logger.getInstance().toString());
        area.addHierarchyListener(new HierarchyListener() {
            @Override
            public void hierarchyChanged(HierarchyEvent e) {
                Window w = SwingUtilities.getWindowAncestor(area);
                if (w instanceof Dialog) {
                    Dialog d = (Dialog)w;
                    if (!d.isResizable()) {
                        d.setResizable(true);
                    }
                }
            }
        });

        javax.swing.JOptionPane.showMessageDialog(
                this,
                scroll, "phpcsmd debug log",
                javax.swing.JOptionPane.ERROR_MESSAGE + javax.swing.JOptionPane.OK_OPTION);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Logger.getInstance().clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void optDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDebugActionPerformed
        this.optSeverity.setEnabled(this.optDebug.isSelected());
    }//GEN-LAST:event_optDebugActionPerformed

    private void optRegexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRegexActionPerformed
        if (this.optRegexInclude.isSelected()) {
            this.optIncludePattern.setEnabled(true);
            this.optIgnorePattern.setEnabled(false);
        } else {
            this.optIncludePattern.setEnabled(false);
            this.optIgnorePattern.setEnabled(true);
        }
    }//GEN-LAST:event_optRegexActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox optCheckOpen;
    private javax.swing.JCheckBox optDebug;
    private javax.swing.JCheckBox optErrorStripe;
    private javax.swing.JTextField optIgnorePattern;
    private javax.swing.JTextField optIncludePattern;
    private javax.swing.JCheckBox optNotify;
    private javax.swing.JRadioButton optRegexExclude;
    private javax.swing.JRadioButton optRegexInclude;
    private javax.swing.JCheckBox optScanNonPhp;
    private javax.swing.JComboBox optSeverity;
    private javax.swing.JCheckBox optThread;
    private javax.swing.JSpinner optTimeout;
    private javax.swing.JCheckBox optUpdateOnSave;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load() {
        this.optSeverity.removeAllItems();
        for(Logger.Severity s : Logger.Severity.values()) {
            this.optSeverity.addItem(s.ordinal() + " - " + s.toString());
        }

        this.optTimeout.setVisible(false);
        this.jLabel3.setVisible(false);
        this.optThread.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.THREADED));
        this.optCheckOpen.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.CHECKONOPEN));
        this.optUpdateOnSave.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.UPDATEONSAVE));
        this.optNotify.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.NOTIFY));
        this.optErrorStripe.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.ERRORSTRIPE));
        this.optScanNonPhp.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.SCANINNONPHP));
        this.optRegexInclude.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.INCLUDESTRATEGY));
        this.optRegexExclude.setSelected(!(Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.INCLUDESTRATEGY));
        this.optIncludePattern.setText((String)GeneralOptions.loadOriginal(GeneralOptions.Settings.INCLUDE));
        this.optIgnorePattern.setText((String)GeneralOptions.loadOriginal(GeneralOptions.Settings.IGNORE));
        this.optDebug.setSelected((Boolean)GeneralOptions.loadOriginal(GeneralOptions.Settings.DEBUGLOG));
        this.optSeverity.setSelectedIndex((Integer)GeneralOptions.loadOriginal(GeneralOptions.Settings.MINSEVERITY));
        this.optTimeout.setValue((Integer)GeneralOptions.loadOriginal(GeneralOptions.Settings.TIMEOUT));
        this.optDebugActionPerformed(null);
        this.optRegexActionPerformed(null);
    }

    @Override
    public void save() {
        GeneralOptions.set(GeneralOptions.Settings.THREADED, this.optThread.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.CHECKONOPEN, this.optCheckOpen.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.UPDATEONSAVE, this.optUpdateOnSave.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.NOTIFY, this.optNotify.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.ERRORSTRIPE, this.optErrorStripe.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.SCANINNONPHP, this.optScanNonPhp.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.INCLUDESTRATEGY, this.optRegexInclude.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.INCLUDE, this.optIncludePattern.getText());
        GeneralOptions.set(GeneralOptions.Settings.IGNORE, this.optIgnorePattern.getText());
        GeneralOptions.set(GeneralOptions.Settings.DEBUGLOG, this.optDebug.isSelected());
        GeneralOptions.set(GeneralOptions.Settings.MINSEVERITY, this.optSeverity.getSelectedIndex());
        GeneralOptions.set(GeneralOptions.Settings.TIMEOUT, (Integer)this.optTimeout.getValue());
    }

    @Override
    public boolean hasValidValues() {
        return true;
    }

}
