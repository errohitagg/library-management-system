/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DisplayMember.java
 *
 * Created on Mar 14, 2010, 11:33:14 AM
 */

import javax.swing.*;
import java.sql.*;
import java.awt.Image;
import java.text.DateFormat;

/**
 *
 * @author Rohit Aggarwal
 */
public class DisplayMember extends javax.swing.JFrame {

    DisplayMemberQuery query_class;
    static String member_id;

    /** Creates new form DisplayMember */
    public DisplayMember() {
        initComponents();
        jLabel1.setText(ServerDetails.library_name);
        jLabel1.setSize(jLabel1.getPreferredSize());
        jLabel2.setSize(jLabel2.getPreferredSize());
        jLabel3.setSize(jLabel3.getPreferredSize());
        jLabel4.setSize(jLabel4.getPreferredSize());
        jLabel5.setSize(jLabel5.getPreferredSize());
        jLabel6.setSize(jLabel6.getPreferredSize());
        jLabel7.setSize(jLabel7.getPreferredSize());
        jLabel8.setSize(jLabel8.getPreferredSize());
        jLabel9.setSize(jLabel9.getPreferredSize());
        jLabel10.setSize(jLabel10.getPreferredSize());
        jButton2.setSize(jButton2.getPreferredSize());
        if(ServerDetails.database == Database.MSACCESS)
        {
           //query_class = new DisplayMemberMSSQL();
        }
        else if(ServerDetails.database == Database.SQLSERVER)
        {
           query_class = new DisplayMemberMSSQL();
        }
        else if(ServerDetails.database == Database.MYSQL)
        {
            query_class = new DisplayMemberMYSQL();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display Member");
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
        jLabel1.setBounds(225, 20, 161, 29);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 44, 20);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel5.setText("Address");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 250, 59, 20);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel6.setText("Date of Birth");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 145, 96, 20);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel7.setText("Gender");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 180, 54, 20);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel8.setText("Contact No.");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 285, 87, 20);

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton2.setText("!! Cancel !!");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(275, 365, 111, 29);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel9.setText("EMail ID");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(375, 285, 69, 20);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel10.setText("Member ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 75, 84, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(1, 1, 0, 0);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(425, 70, 150, 150);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel3.setText("Membership");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 215, 92, 20);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel4.setText("Vaild Upto");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 320, 80, 20);

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel12.setText("Member ID");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(150, 75, 84, 20);

        jLabel13.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel13.setText("Name");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(150, 110, 44, 20);

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel14.setText("Date Of Birth");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(150, 145, 100, 20);

        jLabel15.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel15.setText("Gender");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(150, 180, 54, 20);

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel16.setText("Membership");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(150, 215, 92, 20);

        jLabel17.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel17.setText("Address");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(150, 250, 59, 20);

        jLabel18.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel18.setText("Contact No.");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(150, 285, 87, 20);

        jLabel19.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel19.setText("EMail ID");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(475, 285, 69, 20);

        jLabel20.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel20.setText("Validity");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(150, 320, 60, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-650)/2, (screenSize.height-440)/2, 650, 440);
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
            ResultSet result_set = query_class.retrieve_data();
            ResultSet result_set_ = query_class.retrieve_membership();
            ResultSet _result_set_ = query_class.retrieve_validity();

            if(result_set.next())
            {
                jLabel12.setText(result_set.getString("MemberID"));
                jLabel13.setText(result_set.getString("Name"));
                DateFormat date_of_birth = DateFormat.getDateInstance(DateFormat.LONG);
                jLabel14.setText(date_of_birth.format(result_set.getDate("DateOfBirth")));
                jLabel15.setText(result_set.getString("Gender"));
                jLabel17.setText(result_set.getString("Address"));
                jLabel18.setText(result_set.getString("ContactNo"));
                jLabel19.setText(result_set.getString("EMailID"));
                jLabel12.setSize(jLabel12.getPreferredSize());
                jLabel13.setSize(jLabel13.getPreferredSize());
                jLabel14.setSize(jLabel14.getPreferredSize());
                jLabel15.setSize(jLabel15.getPreferredSize());
                jLabel16.setSize(jLabel16.getPreferredSize());
                jLabel17.setSize(jLabel17.getPreferredSize());
                jLabel18.setSize(jLabel18.getPreferredSize());
                jLabel19.setSize(jLabel19.getPreferredSize());

                result_set.getBlob("Photo");
                if(result_set.wasNull() == false)
                {
                    Blob image_value = result_set.getBlob("Photo");
                    ImageIcon image = new ImageIcon(image_value.getBytes(1, (int)image_value.length()));
                    jLabel11 = new JLabel(new ImageIcon(image.getImage().getScaledInstance(148, 148, Image.SCALE_DEFAULT)));
                    jPanel1.add(jLabel11);
                    jLabel11.setBounds(1, 1, 148, 148);
                }
                else
                {
                    jPanel1.setVisible(false);
                }
            }
            result_set.close();

            if(result_set_.next())
            {
                jLabel16.setText(result_set_.getString("TypeName"));
                jLabel16.setSize(jLabel16.getPreferredSize());
            }
            else
            {
                jLabel16.setText(null);
                jLabel16.setSize(jLabel16.getPreferredSize());
            }
            result_set_.close();

            if(_result_set_.next())
            {
                DateFormat valid_upto = DateFormat.getDateInstance(DateFormat.LONG);
                jLabel20.setText(valid_upto.format(_result_set_.getDate("ValidUpto")));
                jLabel20.setSize(jLabel20.getPreferredSize());
            }
            else
            {
                jLabel20.setText(null);
                jLabel20.setSize(jLabel20.getPreferredSize());
            }
            _result_set_.close();           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" +e , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
