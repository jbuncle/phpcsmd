package de.foopara.phpcsmd.ui.reports;

import java.io.File;

import org.netbeans.api.actions.Openable;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

import de.foopara.phpcsmd.exec.pdepend.PdependResult;
import de.foopara.phpcsmd.exec.pdepend.PdependTypes;
import de.foopara.phpcsmd.generics.GenericHelper;
import de.foopara.phpcsmd.generics.GenericTopComponent;
import de.foopara.phpcsmd.threads.PdependThread;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//de.foopara.phpcsmd.ui.reports//PdependReport//EN",
        autostore = false)
@TopComponent.Description(preferredID = "PdependReportTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "de.foopara.phpcsmd.ui.reports.PdependReportTopComponent")
@ActionReference(path = "Menu/Window" /*
         * , position = 333
         */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_PdependReportAction",
        preferredID = "PdependReportTopComponent")
@Messages({
    "CTL_PdependReportAction=PdependReport",
    "CTL_PdependReportTopComponent=Pdepend",
    "HINT_PdependReportTopComponent=This is a PdependReport window"
})
public final class PdependReportTopComponent extends GenericTopComponent
{

    private FileObject fileObject;

    public PdependReportTopComponent() {
        setName(Bundle.CTL_PdependReportTopComponent());
        setToolTipText(Bundle.HINT_PdependReportTopComponent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pdependTree1 = new de.foopara.phpcsmd.ui.reports.PdependTree();
        jPanel1 = new javax.swing.JPanel();
        metricsPanel = new de.foopara.phpcsmd.ui.reports.PdependMetricsPanel(this.lkp);
        filePanel = new de.foopara.phpcsmd.ui.reports.PdependFilePanel(this.lkp);
        packagePanel = new de.foopara.phpcsmd.ui.reports.PdependPackagePanel(this.lkp);
        classPanel = new de.foopara.phpcsmd.ui.reports.PdependClassPanel(this.lkp);
        methodPanel = new de.foopara.phpcsmd.ui.reports.PdependMethodPanel(this.lkp);
        functionPanel = new de.foopara.phpcsmd.ui.reports.PdependFunctionPanel(this.lkp);
        jButton1 = new javax.swing.JButton();
        lPdependStep = new javax.swing.JLabel();
        lPdependProgress = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PdependReportTopComponent.class, "PdependReportTopComponent.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(jLabel1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PdependReportTopComponent.class, "PdependReportTopComponent.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jLabel2, gridBagConstraints);

        jSplitPane1.setDividerLocation(200);

        pdependTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdependTree1MouseClicked(evt);
            }
        });
        pdependTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                pdependTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(pdependTree1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(metricsPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(filePanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(packagePanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(classPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(methodPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(functionPanel, gridBagConstraints);

        jSplitPane1.setRightComponent(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jSplitPane1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(PdependReportTopComponent.class, "PdependReportTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(lPdependStep, org.openide.util.NbBundle.getMessage(PdependReportTopComponent.class, "PdependReportTopComponent.lPdependStep.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(lPdependStep, gridBagConstraints);

        lPdependProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(lPdependProgress, org.openide.util.NbBundle.getMessage(PdependReportTopComponent.class, "PdependReportTopComponent.lPdependProgress.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(lPdependProgress, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jButton1.setEnabled(false);

        PdependThread t = new PdependThread();
        t.setFileObject(this.fileObject);
        t.setTopComponent(this);
        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pdependTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_pdependTree1ValueChanged
        Object o = this.pdependTree1.getSelectedItem();
        if (o == null) {
            return;
        }
        if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependMetrics")) {
            this.metricsPanel.setMetrics((PdependTypes.PdependMetrics)o);
            this.hideAllPdependPanels();
            this.metricsPanel.setVisible(true);
        } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependFile")) {
            this.filePanel.setFile((PdependTypes.PdependFile)o);
            this.hideAllPdependPanels();
            this.filePanel.setVisible(true);
        } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependPackage")) {
            this.packagePanel.setPackage((PdependTypes.PdependPackage)o);
            this.hideAllPdependPanels();
            this.packagePanel.setVisible(true);
        } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependClass")) {
            this.classPanel.setClass((PdependTypes.PdependClass)o);
            this.hideAllPdependPanels();
            this.classPanel.setVisible(true);
        } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependMethod")) {
            this.methodPanel.setMethod((PdependTypes.PdependMethod)o);
            this.hideAllPdependPanels();
            this.methodPanel.setVisible(true);
        } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependFunction")) {
            this.functionPanel.setFunction((PdependTypes.PdependFunction)o);
            this.hideAllPdependPanels();
            this.functionPanel.setVisible(true);
        }
    }//GEN-LAST:event_pdependTree1ValueChanged

    private void pdependTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdependTree1MouseClicked
        if (evt.getClickCount() > 1) {
            Object o = this.pdependTree1.getSelectedItem();
            if (o == null) {
                return;
            }
            if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependFile")) {
                this.openFile(((PdependTypes.PdependFile)o).name);
            } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependClass")) {
                this.openFile(((PdependTypes.PdependClass)o).getFilename());
            } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependMethod")) {
                this.openFile(((PdependTypes.PdependMethod)o).getFilename());
            } else if (o.getClass().getCanonicalName().endsWith("PdependTypes.PdependFunction")) {
                this.openFile(((PdependTypes.PdependFunction)o).getFilename());
            }
        }
    }//GEN-LAST:event_pdependTree1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private de.foopara.phpcsmd.ui.reports.PdependClassPanel classPanel;
    private de.foopara.phpcsmd.ui.reports.PdependFilePanel filePanel;
    private de.foopara.phpcsmd.ui.reports.PdependFunctionPanel functionPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lPdependProgress;
    private javax.swing.JLabel lPdependStep;
    private de.foopara.phpcsmd.ui.reports.PdependMethodPanel methodPanel;
    private de.foopara.phpcsmd.ui.reports.PdependMetricsPanel metricsPanel;
    private de.foopara.phpcsmd.ui.reports.PdependPackagePanel packagePanel;
    private de.foopara.phpcsmd.ui.reports.PdependTree pdependTree1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        if (this.fileObject == null) {
            this.close();
            return;
        }
        this.jButton1.setEnabled(true);
        this.lPdependProgress.setVisible(false);
        this.lPdependStep.setVisible(false);
        this.hideAllPdependPanels();
        //add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // store your settings
    }

    void readProperties(java.util.Properties p) {
//        String version = p.getProperty("version");
        // read your settings according to their version
    }

    public void setFileObject(FileObject fo) {
        this.fileObject = fo;
        this.setDisplayName("Pdepend: " + fo.getName());
        this.jLabel2.setText(fo.getPath());
        this.pdependTree1.setFilter(fo.getPath());
    }

    public void setPdependResult(PdependResult res) {
        this.jButton1.setEnabled(true);
        this.lPdependProgress.setVisible(false);
        this.lPdependStep.setVisible(false);
        this.pdependTree1.setResult(res);

        this.metricsPanel.setPdependResult(res);
        this.metricsPanel.setMetrics(res.getMetrics());
        this.hideAllPdependPanels();
        this.metricsPanel.setVisible(true);
    }

    @Override
    public void setCommandOutput(String output) {
        this.lPdependProgress.setVisible(true);
        this.lPdependStep.setVisible(true);

        String progress = "";
        String step = "";

        int count = 0;
        String[] split = output.split("\n");
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].contains(".")) {
                if (count < 2) {
                    progress = split[i].trim() + "<br>" + progress;
                    count++;
                }
                if (!split[i].trim().startsWith(".") && split[i].trim().length() > 0 && step.length() == 0) {
                    progress = split[i];
                    count = 300;
                    step = "finished ... ";
                }
            } else {
                if (step.trim().length() == 0) {
                    step = split[i].trim();
                    count = 300;
                }
            }
        }

        this.lPdependProgress.setText("<html><body>" + progress + "</body></html>");
        this.lPdependStep.setText(step);
    }

    private void hideAllPdependPanels() {
        this.metricsPanel.setVisible(false);
        this.filePanel.setVisible(false);
        this.packagePanel.setVisible(false);
        this.classPanel.setVisible(false);
        this.methodPanel.setVisible(false);
        this.functionPanel.setVisible(false);
    }

    private void openFile(String filename) {
        if (filename == null) {
            return;
        }
        FileObject fo = FileUtil.toFileObject(new File(filename));
        if (!GenericHelper.isDesirableFile(fo)) {
            return;
        }

        Openable oc = GenericHelper.getFileLookup(fo).lookup(Openable.class);
        if (oc != null) {
            oc.open();
        }
    }

    @Override
    public void setLookup(Lookup lkp) {
        if (this.lkp == null) {
            super.setLookup(lkp);
            initComponents();
        }
    }

}
