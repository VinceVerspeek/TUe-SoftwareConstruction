import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Main frame (window) of the application.
 *
 * @author Tom Verhoeff (TU/e)
 *         <!--//# BEGIN TODO Name, group id, and date-->
 *         <p><font color="red"><b>Ilya Trofimov, 272, Nov 20</b></font></p>
 *         <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MainFrame extends javax.swing.JFrame {


    //# BEGIN TODO Implementation of jButtonGenerateActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        generatedCombinations.clear(); // Clear already generated list
        int sum;
        int length;
        KakuroCombinationGenerator gen = new KakuroCombinationGenerator();
        Counter count = new Counter();
        Intersector intersection = new Intersector(gen.getMaxNumber(), false);
        Intersector elimination = new Intersector(gen.getMaxNumber(), true);

        CompositeGeneratorObserver<Set<Integer>> compositeGeneratorObserver =
                new CompositeGeneratorObserver<Set<Integer>>();

        compositeGeneratorObserver.add(new PushPullAdapter(new Lister(), true));
        compositeGeneratorObserver.add(new PushPullAdapter(intersection, true));
        compositeGeneratorObserver.add(new PushPullAdapter(elimination, true));
        compositeGeneratorObserver.add(new PushPullAdapter(count, true));

        try {
            sum = Integer.parseInt(jTextField1.getText());
            length = Integer.parseInt(jTextField2.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cant cast a string into " +
                    "integer number.");
            return;
        }

        if (sum < 0) {
            JOptionPane.showMessageDialog(this, "Wrong sum input.");
            return;
        }

        if (length < 0) {
            JOptionPane.showMessageDialog(this, "Wrong length input.");
            return;
        }

        gen.setObserver(compositeGeneratorObserver);
        gen.generate(sum, length);

        String printedText = "";

        if (jCheckBox1.isSelected()) {
            for (Set<Integer> set : generatedCombinations) {
                printedText += set.toString() + '\n';
            }
        }

        if (jCheckBox2.isSelected()) {
            printedText += "Count of generated combinations: " +
                    count.getCount() + '\n';
        }

        if (count.getCount() > 0 && jCheckBox4.isSelected()) {
            printedText += "Elimination: " + elimination.getIntersection() +
                    '\n';
        }

        if (jCheckBox3.isSelected()) {
            printedText += "Intersection: " + intersection.getIntersection() +
                    '\n';
        }

        jTextArea1.setText(printedText);
    }
//# END TODO


    ArrayList<Set<Integer>> generatedCombinations = new ArrayList<Set<Integer>>();


    /**
     * Listener that appends generated combinations to the text area.
     */
    private class Lister implements GeneratorListener {
        //# BEGIN TODO Implementation of Appender
        @Override
        public void combinationGenerated(Set<Integer> combination) {
            generatedCombinations.add(new HashSet<Integer>(combination));
        }
//# END TODO
    }

    // Dear students of HSE SE, everything after this comment was generated by
    // NetBeans Studio. And if you have peach review task, you should know that
    // it shouldn't be formatted for convenient reading.
    // Thanks for your attention :3

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Kakuro Helper 2");
        setResizable(false);

        jLabel1.setText("Sum");

        jLabel2.setText("Length");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("List");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Count");

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Intersection");

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Elimination");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel1))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jCheckBox2)
                                                .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jCheckBox3)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jCheckBox1))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(5, 5, 5)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(45, 45, 45)
                                                .addComponent(jCheckBox1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration
}