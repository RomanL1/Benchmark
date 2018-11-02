/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchmarkform;

import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author u20186
 */
public class BenchForm extends javax.swing.JFrame {

    protected static String labelSeconds_sav;
    protected static String labelScore_sav;
    protected static String labelOperations_sav;
    protected static String labelThreadsCount_sav;

    private static int runningThreads;

    /**
     * Creates new form BenchForm
     */
    public BenchForm() {
        try {
            String laf = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(laf);
            initComponents();
            setSpecText();
            saveDefaultText();
            runningThreads = 0;
        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        labelCPUIdentifier = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelArch = new javax.swing.JLabel();
        labelNumOfCores = new javax.swing.JLabel();
        labelSeconds = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonRunBenchmark = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textFieldOperations = new javax.swing.JTextField();
        labelOperations = new javax.swing.JLabel();
        labelThreadsCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Benchmark V1.0 by Roman Lysser (1.11.2018) ©");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 250, -1));

        labelCPUIdentifier.setText("CPU Identifier: ");
        getContentPane().add(labelCPUIdentifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 64, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Your CPU Specifications:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, -1, -1));

        labelArch.setText("Architecture:");
        getContentPane().add(labelArch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 84, -1, -1));

        labelNumOfCores.setText("Number of Cores:");
        getContentPane().add(labelNumOfCores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, -1, -1));

        labelSeconds.setText("Total Seconds:");
        getContentPane().add(labelSeconds, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 280, -1, -1));

        labelScore.setText("Your Score:");
        getContentPane().add(labelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        jLabel3.setText("------------------------------------------------------------------------------------------------");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 136, 390, -1));

        buttonRunBenchmark.setText("Run Benchmark");
        buttonRunBenchmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRunBenchmarkActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRunBenchmark, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jLabel4.setText("Operations:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 205, -1, -1));

        textFieldOperations.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldOperationsFocusLost(evt);
            }
        });
        textFieldOperations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldOperationsActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldOperations, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 107, -1));

        labelOperations.setText("Operations:");
        getContentPane().add(labelOperations, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        labelThreadsCount.setText("Running Threads:");
        getContentPane().add(labelThreadsCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRunBenchmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRunBenchmarkActionPerformed
        new Benchmark().start();
        runningThreads++;
        setDefaultText();
        setRunningThreads();
    }//GEN-LAST:event_buttonRunBenchmarkActionPerformed

    private void textFieldOperationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldOperationsActionPerformed
        long setOperations = Long.parseLong(textFieldOperations.getText());
        if (setOperations < 10000000) {
            setOperations = 10000000;
            textFieldOperations.setText("" + setOperations);
        }
        if (setOperations != Benchmark.getOperations()) {
            Benchmark.setOperations(setOperations);
        }
        labelOperations.setText(labelOperations_sav + " " + setOperations);

    }//GEN-LAST:event_textFieldOperationsActionPerformed

    private void textFieldOperationsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldOperationsFocusLost
        long setOperations = Long.parseLong(textFieldOperations.getText());
        if (setOperations < 10000000) {
            setOperations = 10000000;
            textFieldOperations.setText("" + setOperations);
        }
        if (setOperations != Benchmark.getOperations()) {
            Benchmark.setOperations(setOperations);
        }
        labelOperations.setText(labelOperations_sav + " " + setOperations);

    }//GEN-LAST:event_textFieldOperationsFocusLost

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BenchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            BenchForm GUI = new BenchForm();
            GUI.setTitle("Benchmark V1.0");
            GUI.setVisible(true);
            GUI.setResizable(false);
            GUI.getContentPane().setBackground(Color.lightGray);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRunBenchmark;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelArch;
    private javax.swing.JLabel labelCPUIdentifier;
    private javax.swing.JLabel labelNumOfCores;
    private javax.swing.JLabel labelOperations;
    private static javax.swing.JLabel labelScore;
    private static javax.swing.JLabel labelSeconds;
    private static javax.swing.JLabel labelThreadsCount;
    private javax.swing.JTextField textFieldOperations;
    // End of variables declaration//GEN-END:variables

    private void setSpecText() {
        String cpuIdentifier = labelCPUIdentifier.getText();
        String arch = labelArch.getText();
        String numOfCores = labelNumOfCores.getText();

        labelCPUIdentifier.setText(cpuIdentifier + "  " + System.getenv("PROCESSOR_IDENTIFIER"));
        labelArch.setText(arch + "  " + System.getenv("PROCESSOR_ARCHITECTURE"));
        labelNumOfCores.setText(numOfCores + "  " + System.getenv("NUMBER_OF_PROCESSORS"));
        textFieldOperations.setText("" + Benchmark.getOperations());
    }

    private void saveDefaultText() {
        labelSeconds_sav = labelSeconds.getText();
        labelScore_sav = labelScore.getText();
        labelOperations_sav = labelOperations.getText();
        labelThreadsCount_sav = labelThreadsCount.getText();
    }

    private void setDefaultText() {
        labelSeconds.setText(labelSeconds_sav);
        labelScore.setText(labelScore_sav);
    }

    private static void setScoreText(double MFLOPS, double elapsedSeconds) {
        labelScore.setText(labelScore_sav + " " + round(MFLOPS, 3) + " MFLOPS");
        labelSeconds.setText(labelSeconds_sav + " " + elapsedSeconds + "s");
    }

    private static void setRunningThreads() {
        labelThreadsCount.setText(labelThreadsCount_sav + " " + runningThreads);
    }

    public static void finishedRun() {
        runningThreads--;
        setScoreText(Benchmark.getMFLOPS(), Benchmark.getElapsedSeconds());
        setRunningThreads();
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
