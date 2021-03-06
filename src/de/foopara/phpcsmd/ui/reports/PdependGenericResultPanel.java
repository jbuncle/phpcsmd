package de.foopara.phpcsmd.ui.reports;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.lang.reflect.Field;
import java.util.HashMap;

import javax.swing.*;

import org.openide.util.Exceptions;
import org.openide.util.Lookup;

import de.foopara.phpcsmd.debug.Logger;
import de.foopara.phpcsmd.exec.pdepend.PdependResult;
import de.foopara.phpcsmd.option.PdependOptions;

/**
 *
 * @author nspecht
 */
public class PdependGenericResultPanel extends JPanel
{

    JTabbedPane tabContainer;

    HashMap<String, JPanel> tabs = new HashMap<String, JPanel>();

    HashMap<String, JComponent> elements = new HashMap<String, JComponent>();

    PdependTabbedPaneUI btpui = null;

    protected EditFileButton editorButton = null;

    protected PdependResult pdependResult;

    protected Lookup lkp;

    public PdependGenericResultPanel(Lookup lkp) {
        super();
        this.lkp = lkp;

        this.btpui = new PdependTabbedPaneUI(this.lkp);
        this.tabContainer = new JTabbedPane();
        this.tabContainer.setUI(this.btpui);

        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        super.setLayout(new GridBagLayout());

        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        this.add(this.tabContainer, gridBagConstraints);
    }

    public void setLookup(Lookup lkp) {
        this.lkp = lkp;
        this.btpui.setLookup(lkp);
    }

    public void setPdependResult(PdependResult res) {
        this.pdependResult = res;
    }

    @Override
    public void setLayout(LayoutManager lm) {
        //overwrite set Layout-Method
    }

    protected void setFields(Object o) {
        for (Field f : o.getClass().getFields()) {
            try {
                this.setComponent(f.getName(), f.get(o));
            } catch (IllegalArgumentException ex) {
                Logger.getInstance().log(ex);
                Exceptions.printStackTrace(ex);
            } catch (IllegalAccessException ex) {
                Logger.getInstance().log(ex);
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private boolean setComponent(String name, Object value) {
        if (name != null && name.compareTo("serialVersionUID") == 0) {
            return false;
        }
        
        if (name != null && this.elements.containsKey(name)) {
            JComponent comp = this.elements.get(name);
            if (comp.getClass().getCanonicalName().endsWith("JProgressBar")) {
                JProgressBar tmp = ((JProgressBar)comp);

                int v = 0;
                if (value.getClass().getCanonicalName().compareTo("java.lang.Integer") == 0) {
                    v = (Integer)value;
                } else if (value.getClass().getCanonicalName().compareTo("java.lang.Float") == 0) {
                    Float f = (Float)value;
                    v = Math.round(f);
                }

                tmp.setValue(v);
                tmp.setStringPainted(true);
                tmp.setString(tmp.getValue() + "/" + tmp.getMaximum());
            } else {
                ((JLabel)comp).setText("" + value);
            }

        } else {
            if (!this.elements.containsKey("OTHERSEP")) {
                this.addSeparator("OTHERSEP", "Other", "Other");
            }
            this.addLabel(name, "", "Other");
            JLabel comp = (JLabel)this.elements.get(name);
            comp.setText("" + value);
        }
        return false;
    }

    public void setEditorButton(String filename) {
        if (this.editorButton == null) {
            java.awt.GridBagConstraints gridBagConstraints;
            this.editorButton = new EditFileButton(this.lkp);
            gridBagConstraints = new java.awt.GridBagConstraints();
//            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
//            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
            this.add(this.editorButton, gridBagConstraints);
        }
        if (filename == null) {
            this.editorButton.setVisible(false);
            return;
        }
        this.editorButton.setFilename(filename);
        this.editorButton.setVisible(true);
    }

    private void addToTab(JComponent comp, GridBagConstraints constraints, String name) {
        if (!this.tabs.containsKey(name)) {
            JPanel tab = new JPanel();
            tab.setLayout(new GridBagLayout());
            JScrollPane scroll = new JScrollPane(tab);

            this.tabs.put(name, tab);
            this.tabContainer.add(name, scroll);
        }
        JPanel tab = this.tabs.get(name);
        tab.add(comp, constraints);
    }

    protected void addSeparator(String name, String caption, String tab) {
        if ((Boolean)PdependOptions.load(PdependOptions.Settings.USETABS, this.lkp) == false) {
            tab = "---";
        }
        int row = this.elements.size() + 20;
        if (name == null) {
            name = "" + Math.random();
        }
        java.awt.GridBagConstraints gridBagConstraints;
        int compwith = 3;
        int x = 0;
        if (caption != null) {
            compwith = 2;
            x = 1;
            JLabel cap = new JLabel("<html><body><b>" + caption + "</b></body></html>");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = row;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
            this.addToTab(cap, gridBagConstraints, tab);
        }
        JSeparator ret = new JSeparator();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = row;
        gridBagConstraints.gridwidth = compwith;
        this.addToTab(ret, gridBagConstraints, tab);

        this.elements.put(name, ret);
    }

    protected void addLabel(String name, String caption, String tab) {
        if ((Boolean)PdependOptions.load(PdependOptions.Settings.USETABS, this.lkp) == false) {
            tab = "---";
        }
        int row = this.elements.size() + 20;

        java.awt.GridBagConstraints gridBagConstraints;
        if (caption != null) {
            JLabel cap = new JLabel(caption + " (" + name + ")" + ": ");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(0, 30, 2, 2);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = row;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
            this.addToTab(cap, gridBagConstraints, tab);
        }

        JLabel ret = new JLabel("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = row;
        this.addToTab(ret, gridBagConstraints, tab);

        this.elements.put(name, ret);
    }

    protected void addProgressbar(String name, String caption, String tab) {
        if ((Boolean)PdependOptions.load(PdependOptions.Settings.USETABS, this.lkp) == false) {
            tab = "---";
        }
        int row = this.elements.size() + 20;

        java.awt.GridBagConstraints gridBagConstraints;
        if (caption != null) {
            JLabel cap = new JLabel(caption + " (" + name + ")" + ": ");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(0, 30, 2, 2);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = row;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
            this.addToTab(cap, gridBagConstraints, tab);
        }

        JProgressBar ret = new JProgressBar();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = row;
        this.addToTab(ret, gridBagConstraints, tab);

        this.elements.put(name, ret);
    }

    protected void addComponent(JComponent ret, String name, String caption, String tab) {
        int row = this.elements.size() + 20;

        java.awt.GridBagConstraints gridBagConstraints;
        if (caption != null) {
            JLabel cap = new JLabel(caption + ": ");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(0, 30, 2, 2);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = row;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
            this.addToTab(cap, gridBagConstraints, tab);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = row;
        this.addToTab(ret, gridBagConstraints, tab);

        this.elements.put(name, ret);
    }

}
