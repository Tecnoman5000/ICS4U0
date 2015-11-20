
package theelection;
public class TheElectionFrame extends javax.swing.JFrame {
    public TheElectionFrame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cName1 = new javax.swing.JLabel();
        cVotes1 = new javax.swing.JLabel();
        cName2 = new javax.swing.JLabel();
        cVotes2 = new javax.swing.JLabel();
        cName3 = new javax.swing.JLabel();
        cVotes3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        cName1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cName1.setText("Candidate");
        getContentPane().add(cName1);
        cName1.setBounds(30, 250, 110, 20);

        cVotes1.setBackground(new java.awt.Color(204, 0, 51));
        cVotes1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cVotes1.setForeground(new java.awt.Color(255, 255, 255));
        cVotes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cVotes1.setText("100%");
        cVotes1.setOpaque(true);
        getContentPane().add(cVotes1);
        cVotes1.setBounds(40, 40, 90, 200);

        cName2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cName2.setText("Candidate");
        getContentPane().add(cName2);
        cName2.setBounds(140, 250, 110, 20);

        cVotes2.setBackground(new java.awt.Color(255, 0, 255));
        cVotes2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cVotes2.setForeground(new java.awt.Color(255, 255, 255));
        cVotes2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cVotes2.setText("100%");
        cVotes2.setOpaque(true);
        getContentPane().add(cVotes2);
        cVotes2.setBounds(150, 40, 90, 200);

        cName3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cName3.setText("Candidate");
        getContentPane().add(cName3);
        cName3.setBounds(250, 250, 110, 20);

        cVotes3.setBackground(new java.awt.Color(0, 51, 255));
        cVotes3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cVotes3.setForeground(new java.awt.Color(255, 255, 255));
        cVotes3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cVotes3.setText("100%");
        cVotes3.setOpaque(true);
        getContentPane().add(cVotes3);
        cVotes3.setBounds(260, 40, 90, 200);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Process File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessButtonClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 290, 210, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProcessButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessButtonClicked
        
        // Add the election file processing and reporting here!
        try{
            // Import file processor
            FileProcessor pFile = new FileProcessor("votes.txt");
            String[] names = new String[3];
            names = pFile.getNames();
            
            this.cName1.setText(names[0]);
            this.cName2.setText(names[1]);
            this.cName3.setText(names[2]);
            
            pFile.tallyVotes();
            
            String[] percents = new String[3];
            percents = pFile.getPercents();
            
            this.cVotes1.setText(percents[0]);
            this.cVotes2.setText(percents[1]);
            this.cVotes3.setText(percents[2]);
            
            int[] heights = new int[3];
            heights = pFile.getBarSizes(this.cVotes1.getHeight());
            
            this.cVotes1.setBounds(this.cVotes1.getX(), 
                    this.cVotes1.getY(), this.cVotes1.getWidth(),
                    heights[0]);
            this.cVotes2.setBounds(this.cVotes2.getX(), 
                    this.cVotes2.getY(), this.cVotes2.getWidth(),
                    heights[1]);
            this.cVotes3.setBounds(this.cVotes3.getX(), 
                    this.cVotes3.getY(), this.cVotes3.getWidth(),
                    heights[2]);
        }
        catch(Exception e){
            e.printStackTrace();
        }  
    }//GEN-LAST:event_ProcessButtonClicked

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
            java.util.logging.Logger.getLogger(TheElectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TheElectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TheElectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TheElectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TheElectionFrame().setVisible(true);
            }
        });;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cName1;
    private javax.swing.JLabel cName2;
    private javax.swing.JLabel cName3;
    private javax.swing.JLabel cVotes1;
    private javax.swing.JLabel cVotes2;
    private javax.swing.JLabel cVotes3;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
