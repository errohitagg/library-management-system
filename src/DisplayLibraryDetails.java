/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.JOptionPane;

/*
 * DisplayLibraryDetails.java
 *
 * Created on Mar 14, 2010, 9:20:32 AM
 */

/**
 *
 * @author Rohit Aggarwal
 */
public class DisplayLibraryDetails extends javax.swing.JFrame {

    DisplayLibraryDetailsQuery query_class;

    /** Creates new form DisplayLibraryDetails */
    public DisplayLibraryDetails() {
        initComponents();
        jLabel1.setSize(jLabel1.getPreferredSize());
        jLabel2.setSize(jLabel2.getPreferredSize());
        jLabel3.setSize(jLabel3.getPreferredSize());
        jLabel4.setSize(jLabel4.getPreferredSize());
        jLabel5.setSize(jLabel5.getPreferredSize());
        jLabel6.setSize(jLabel6.getPreferredSize());
        jButton2.setSize(jButton2.getPreferredSize());
        if(ServerDetails.database == Database.MSACCESS)
        {
           //query_class = new DisplayBookMSSQL();
        }
        else if(ServerDetails.database == Database.SQLSERVER)
        {
           query_class = new DisplayLibraryDetailsMSSQL();
        }
        else if(ServerDetails.database == Database.MYSQL)
        {
            query_class = new DisplayLibraryDetailsMYSQL();
        }
        else if(ServerDetails.database == Database.POSTGRESQL)
        {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Details");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel1.setText("Library Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 105, 20);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel2.setText("<html>Library Name<br><center>(Abbr.)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 105, 40);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel3.setText("Address");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 110, 59, 20);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel4.setText("Website");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 180, 61, 20);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel5.setText("E-Mail ID");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(370, 180, 74, 20);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel6.setText("Phone Number");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 145, 112, 20);

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(325, 225, 83, 29);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel7.setText("Library Name");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(175, 20, 105, 20);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel8.setText("Library Name");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(175, 65, 105, 20);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel9.setText("Address");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(175, 110, 59, 20);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel10.setText("Phone Number");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(175, 145, 112, 20);

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel11.setText("Website");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(175, 180, 61, 20);

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel12.setText("EMail ID");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(500, 180, 69, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-750)/2, (screenSize.height-300)/2, 750, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        if(ServerDetails.invoker == Invoker.ADMINISTRATOR)
        {
            AdministratorPage admin_page = new AdministratorPage();
            admin_page.show();
        }
        else if(ServerDetails.invoker == Invoker.LIBRARIAN)
        {
            LibrarianPage librarian_page = new LibrarianPage();
            librarian_page.show();
        }
        else if(ServerDetails.invoker == Invoker.EMPLOYEE)
        {
            EmployeePage employee_page = new EmployeePage();
            employee_page.show();
        }
        else if(ServerDetails.invoker == Invoker.MEMBER)
        {
            MemberPage member_page = new MemberPage();
            member_page.show();
        }
        else
            System.exit(0);
}//GEN-LAST:event_jButton2MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try
        {
            ResultSet result_set = query_class.retrieve_values();

            if(result_set.next())
            {
                jLabel7.setText(result_set.getString("Name"));
                jLabel8.setText(result_set.getString("SName"));
                jLabel9.setText(result_set.getString("Address"));
                jLabel10.setText(result_set.getString("ContactNo"));
                jLabel11.setText(result_set.getString("Website"));
                jLabel12.setText(result_set.getString("EMailID"));
                jLabel7.setSize(jLabel7.getPreferredSize());
                jLabel8.setSize(jLabel8.getPreferredSize());
                jLabel9.setSize(jLabel9.getPreferredSize());
                jLabel10.setSize(jLabel10.getPreferredSize());
                jLabel11.setSize(jLabel11.getPreferredSize());
                jLabel12.setSize(jLabel12.getPreferredSize());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayLibraryDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}