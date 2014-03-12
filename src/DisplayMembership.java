/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.JOptionPane;

/*
 * DisplayMembership.java
 *
 * Created on Mar 14, 2010, 9:19:53 AM
 */

/**
 *
 * @author Rohit Aggarwal
 */
public class DisplayMembership extends javax.swing.JFrame {

    private int incr_value;
    DisplayMembershipQuery query_class;

    /** Creates new form DisplayMembership */
    public DisplayMembership() {
        initComponents();
        incr_value = -35;
        jLabel1.setText(ServerDetails.library_name);
        jLabel1.setSize(jLabel1.getPreferredSize());
        jLabel2.setSize(jLabel2.getPreferredSize());
        jLabel3.setSize(jLabel3.getPreferredSize());
        jButton1.setSize(jButton1.getPreferredSize());
        if(ServerDetails.database == Database.MSACCESS)
        {
           //query_class = new DisplayMembershipMSSQL();
        }
        else if(ServerDetails.database == Database.SQLSERVER)
        {
           query_class = new DisplayMembershipMSSQL();
        }
        else if(ServerDetails.database == Database.MYSQL)
        {
            query_class = new DisplayMembershipMYSQL();
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
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display Membership");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24));
        jLabel1.setText("Library Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(125, 20, 161, 29);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 16));
        jLabel2.setText("Membership");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 75, 103, 20);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 16));
        jLabel3.setText("Book Limit");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 75, 94, 20);

        jButton1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton1.setText("Cancel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 160, 83, 29);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 110, 0, 0);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 110, 0, 0);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-235)/2, 400, 235);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try
        {
            ResultSet result_set = query_class.retrieve_values();

            while(result_set.next())
            {
                incr_value += 35;

                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();

                jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
                jLabel4.setText(result_set.getString("TypeName"));
                getContentPane().add(jLabel4);
                jLabel4.setBounds(50, 110 + incr_value, 192, 20);
                jLabel4.setSize(jLabel4.getPreferredSize());

                jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
                jLabel5.setText(String.valueOf(result_set.getInt("BookLimit")));
                getContentPane().add(jLabel5);
                jLabel5.setBounds(250, 110 + incr_value, 82, 20);
                jLabel5.setSize(jLabel5.getPreferredSize());

                jButton1.setLocation(160, 160 + incr_value);

                java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                setBounds((screenSize.width-400)/2, (screenSize.height-(235 + incr_value))/2, 400, (235 + incr_value));
            }
            this.validate();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
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
    }//GEN-LAST:event_jButton1MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayMembership().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}
