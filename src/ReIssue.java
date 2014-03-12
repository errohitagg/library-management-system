/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FacultyReIssue.java
 *
 * Created on Mar 9, 2010, 6:00:50 PM
 */

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

/**
 *
 * @author Rohit Aggarwal
 */
public class ReIssue extends javax.swing.JFrame {

    public static String reference_no, member_id;
    static Calendar date_of_issue_new = Calendar.getInstance(), date_of_return_new = Calendar.getInstance();
    static Calendar date_of_return = Calendar.getInstance(), date_of_issue = Calendar.getInstance();
    ReIssueQuery query_class;

    /** Creates new form FacultyReIssue */
    public ReIssue() {
        initComponents();
        jLabel1.setText(ServerDetails.library_name);
        jLabel1.setSize(jLabel1.getPreferredSize());
        jLabel2.setSize(jLabel2.getPreferredSize());
        jLabel4.setSize(jLabel4.getPreferredSize());
        jLabel5.setSize(jLabel5.getPreferredSize());
        jLabel6.setSize(jLabel6.getPreferredSize());
        jLabel9.setSize(jLabel9.getPreferredSize());
        jButton1.setSize(jButton1.getPreferredSize());
        jButton2.setSize(jButton2.getPreferredSize());
        if(ServerDetails.database == Database.MSACCESS)
        {
           //query_class = new ReIssueMSSQL();
        }
        else if(ServerDetails.database == Database.SQLSERVER)
        {
           query_class = new ReIssueMSSQL();
        }
        else if(ServerDetails.database == Database.MYSQL)
        {
            query_class = new ReIssueMYSQL();
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
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book ReIssue");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel1.setText("Library Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(125, 20, 161, 29);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel2.setText("Member ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 75, 84, 20);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel3.setText("Member ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(185, 75, 84, 20);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel4.setText("Reference No.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 115, 102, 20);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel5.setText("Date of Issue");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 155, 95, 20);

        jButton1.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jButton1.setText("ReIssue");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(75, 290, 91, 29);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel7.setText("Reference No.");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(185, 115, 102, 20);

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(275, 290, 83, 29);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel6.setText("New Date of Issue");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 195, 131, 20);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel8.setText("Date of Issue");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(185, 155, 95, 20);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jLabel9.setText("New Date of Return");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 235, 145, 20);

        jComboBox1.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(185, 195, 49, 26);

        jComboBox2.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(240, 195, 110, 26);

        jComboBox3.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(360, 195, 35, 26);

        jComboBox4.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(jComboBox4);
        jComboBox4.setBounds(185, 235, 49, 26);

        jComboBox5.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        getContentPane().add(jComboBox5);
        jComboBox5.setBounds(240, 235, 110, 26);

        jComboBox6.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        getContentPane().add(jComboBox6);
        jComboBox6.setBounds(360, 235, 35, 26);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-450)/2, (screenSize.height-375)/2, 450, 375);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Calendar now = Calendar.getInstance();
        now.setTime(new java.util.Date());
        jComboBox1.setSelectedItem(now.get(Calendar.DATE));
        jComboBox2.setSelectedIndex(now.get(Calendar.MONTH) - 1);
        jComboBox3.addItem(now.get(Calendar.YEAR));
        jComboBox3.setSize(jComboBox3.getPreferredSize());
        jComboBox1.setFocusable(false);
        jComboBox2.setFocusable(false);
        jComboBox3.setFocusable(false);
        for(int i = now.get(Calendar.YEAR); i <= now.get(Calendar.YEAR)+1; i++)
            jComboBox6.addItem(i);
        jComboBox6.setSize(jComboBox6.getPreferredSize());
        jComboBox4.setSelectedItem(now.get(Calendar.DATE));
        jComboBox5.setSelectedIndex(now.get(Calendar.MONTH) - 1);
        jComboBox6.addItem(now.get(Calendar.YEAR));

        ResultSet result_set = query_class.retrieve_values();
        try
        {
            result_set.next();
            jLabel3.setText(member_id);
            jLabel7.setText(reference_no);
            DateFormat date_of_issue_format = DateFormat.getDateInstance(DateFormat.LONG);
            jLabel8.setText(date_of_issue_format.format(result_set.getDate("DateOfIssue")));
            date_of_issue.clear();
            date_of_issue.set(result_set.getDate("DateOfIssue").getYear(), result_set.getDate("DateOfIssue").getMonth(), result_set.getDate("DateOfIssue").getDate());
            date_of_return.clear();
            date_of_return.set(result_set.getDate("DateOfReturn").getYear(), result_set.getDate("DateOfReturn").getMonth(), result_set.getDate("DateOfReturn").getDate());
            jLabel3.setSize(jLabel3.getPreferredSize());
            jLabel7.setSize(jLabel7.getPreferredSize());
            jLabel8.setSize(jLabel8.getPreferredSize());
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" + e, "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(check_data() == true)
        {
            date_of_issue_new.clear();
            date_of_issue_new.set(Integer.parseInt(jComboBox3.getSelectedItem().toString()), jComboBox2.getSelectedIndex(), Integer.parseInt(jComboBox1.getSelectedItem().toString()));
            date_of_return_new.clear();
            date_of_return_new.set(Integer.parseInt(jComboBox6.getSelectedItem().toString()), jComboBox5.getSelectedIndex(), Integer.parseInt(jComboBox4.getSelectedItem().toString()));
            query_class.insert_values();
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
            else
                System.exit(0);
        }
        else
            JOptionPane.showMessageDialog(this, "Correct the highlighted items before proceeding", "Invalid Data", JOptionPane.WARNING_MESSAGE);
}//GEN-LAST:event_jButton1MouseClicked

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
        else
            System.exit(0);
}//GEN-LAST:event_jButton2MouseClicked

    private boolean check_data()
    {        
        boolean return_value = true;
        if(check_return_date() == false)
        {
            jLabel5.setText("<html><font color='red'>Date of Return");
            return_value = false;
        }
        else
            jLabel5.setText("Date of Return");
        return(return_value);
    }

    private boolean check_return_date()
    {
        boolean return_value = true;
        String date = (jComboBox5.getSelectedIndex()+1) + "/" + jComboBox4.getSelectedItem().toString() + "/" + jComboBox6.getSelectedItem().toString();

        try
        {
            DateFormat date_format = DateFormat.getDateInstance(DateFormat.SHORT);
            date_format.setLenient(false);
            Date temp_date = date_format.parse(date);
        }
        catch(ParseException e)
        {
            return_value = false;
        }

        return(return_value);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReIssue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
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