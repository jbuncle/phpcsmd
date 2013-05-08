package de.foopara.phpcsmd.ui.reports;

import javax.swing.JProgressBar;

import org.openide.util.Lookup;

import de.foopara.phpcsmd.exec.pdepend.PdependTypes;
import de.foopara.phpcsmd.option.PdependOptions;

public class PdependMetricsPanel extends PdependGenericResultPanel
{

    private boolean jDependActive = false;

    /**
     * Creates new form PdependMetricsPanel
     */
    public PdependMetricsPanel(Lookup lkp) {
        super(lkp);
        initComponents();
        this.addLabel("pdepend", "Pdepend Version", "Metrics");
        this.addLabel("generated", "Generated", "Metrics");

        this.addSeparator(null, "Codelines", "Metrics");
        this.addLabel("loc", "Lines of Code", "Metrics");
        this.addProgressbar("ncloc", "Non Comment Lines of Code", "Metrics");
        this.addProgressbar("cloc", "Comment Lines of Code", "Metrics");
        this.addProgressbar("eloc", "Executable Lines of Code", "Metrics");
        this.addProgressbar("lloc", "Logical Lines Of Code", "Metrics");

        if ((Boolean)PdependOptions.load(PdependOptions.Settings.USETABS, this.lkp) == false) {
            this.addSeparator(null, "Counts", "Counts");
        }
        this.addLabel("nop", "Number of Packages", "Counts");
        this.addLabel("noc", "Number of Classes", "Counts");
        this.addLabel("noi", "Number of Interfaces", "Counts");
        this.addLabel("nom", "Number of Methods", "Counts");
        this.addLabel("nof", "Number of Functions", "Counts");

        if ((Boolean)PdependOptions.load(PdependOptions.Settings.USETABS, this.lkp) == false) {
            this.addSeparator(null, "Classes", "Classes");
        }
        this.addProgressbar("roots", "Number of Root Classes", "Classes");
        this.addProgressbar("leafs", "Number of Leaf (final) Classes", "Classes");
        this.addProgressbar("clsc", "Number of Concrete Classes", "Classes");
        this.addProgressbar("clsa", "Number of Abstract Classes", "Classes");

        this.addLabel("ahh", "Average Hierarchy Height", "Classes");
        this.addLabel("andc", "Average Number of Derived Classes", "Classes");

        this.addSeparator(null, "Complexity", "Different Metrics");
        this.addLabel("ccn", "Cyclomatic Complexity", "Different Metrics");
        this.addLabel("ccn2", "Cyclomatic Complexity Number", "Different Metrics");

        this.addSeparator(null, null, "Different Metrics");
        this.addLabel("calls", "Number of Method or Function Calls", "Different Metrics");
        this.addLabel("fanout", "Number of Fanouts", "Different Metrics");

        this.jDependActive = (Boolean)PdependOptions.load(PdependOptions.Settings.JDEPEND, this.lkp);
        if (this.jDependActive) {
            this.addSeparator(null, "JDepend Graph", "JDepend Graph");
            this.addComponent(new JdependGraph(), "JDependGraph", null, "JDepend Graph");
        }
    }

    public void setMetrics(PdependTypes.PdependMetrics metrics) {
        ((JProgressBar)this.elements.get("ncloc")).setMaximum(metrics.loc);
        ((JProgressBar)this.elements.get("cloc")).setMaximum(metrics.loc);
        ((JProgressBar)this.elements.get("eloc")).setMaximum(metrics.loc);
        ((JProgressBar)this.elements.get("lloc")).setMaximum(metrics.loc);

        ((JProgressBar)this.elements.get("roots")).setMaximum(metrics.noc);
        ((JProgressBar)this.elements.get("leafs")).setMaximum(metrics.noc);
        ((JProgressBar)this.elements.get("clsc")).setMaximum(metrics.noc);
        ((JProgressBar)this.elements.get("clsa")).setMaximum(metrics.noc);

        this.setFields(metrics);
        if (this.jDependActive) {
            ((JdependGraph)this.elements.get("JDependGraph")).setPackages(this.pdependResult.getPackages());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
