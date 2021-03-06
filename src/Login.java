/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on Dec 26, 2009, 12:53:46 AM
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Rohit Aggarwal
 */
public class Login extends javax.swing.JFrame {

    LoginQuery query_class;
    static String category, user_name, password;

    /** Creates new form Login */
    public Login() {
        initComponents();
        jLabel1.setText(ServerDetails.library_name);
        jLabel1.setSize(jLabel1.getPreferredSize());
        jLabel2.setSize(jLabel2.getPreferredSize());
        jLabel3.setSize(jLabel3.getPreferredSize());
        jLabel4.setSize(jLabel4.getPreferredSize());
        jButton1.setSize(jButton1.getPreferredSize());
        jButton2.setSize(jButton2.getPreferredSize());
        if(ServerDetails.database == Database.MSACCESS)
        {
           //query_class = new LoginMSSQL();
        }
        else if(ServerDetails.database == Database.SQLSERVER)
        {
           query_class = new LoginMSSQL();
        }
        else if(ServerDetails.database == Database.MYSQL)
        {
            query_class = new LoginMYSQL();
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
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel1.setText("Library Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 20, 161, 29);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel2.setText("User Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 80, 83, 20);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 120, 69, 20);

        jButton1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton1.setText("Login >>");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 225, 99, 29);

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton2.setText("!! Cancel !!");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(225, 225, 111, 29);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel4.setText("<html><u>New User, Register Here");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 170, 181, 20);

        jPasswordField1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(150, 115, 210, 26);

        jTextField1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 75, 210, 26);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(check_data() == true)
        {
            user_name=jTextField1.getText();
            password = jPasswordField1.getText();
            if(query_class.check_user_name() == true)
            {
                if(query_class.check_password() == true)
                {
                    category = query_class.get_category();
                    ServerDetails.login_user = jTextField1.getText();
                    if(category.compareTo("Librarian") == 0)
                    {
                        ServerDetails.invoker = Invoker.LIBRARIAN;
                        this.dispose();
                        LibrarianPage librarian_login = new LibrarianPage();
                        librarian_login.show();
                    }
                    else if(category.compareTo("Administrator") == 0)
                    {
                        ServerDetails.invoker = Invoker.ADMINISTRATOR;
                        this.dispose();
                        AdministratorPage admin_login = new AdministratorPage();
                        admin_login.show();
                    }
                    else if(category.compareTo("Employee") == 0)
                    {
                        ServerDetails.invoker = Invoker.EMPLOYEE;
                        this.dispose();
                        EmployeePage employee_login = new EmployeePage();
                        employee_login.show();
                    }
                    else
                    {
                        ServerDetails.invoker = Invoker.MEMBER;
                        this.dispose();
                        MemberPage member_page = new MemberPage();
                        member_page.show();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Incorrect Password, Try Again or Abort", "Incorrect Password", JOptionPane.WARNING_MESSAGE);
                    jTextField1.setText(null);
                    jPasswordField1.setText(null);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "User Name:" + user_name + " doesn't exist in the database", "Incorrect User Name", JOptionPane.WARNING_MESSAGE);
                jTextField1.setText(null);
                jPasswordField1.setText(null);
            }
        }
        else
         JOptionPane.showMessageDialog(this, "Correct the highlighted items before proceeding", "Incorrect Data", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.dispose();
        NewUser new_user = new NewUser();
        new_user.show();
    }//GEN-LAST:event_jLabel4MouseClicked

    private boolean check_data()
    {
        boolean return_value=true;

        if(jTextField1.getText() == null || jTextField1.getText().compareTo("") == 0)
        {
            jLabel2.setText("<html><font color='red'>User Name");
            return_value = false;
        }
        else
            jLabel2.setText("User Name");

        if(jPasswordField1.getText() == null || jPasswordField1.getText().compareTo("") == 0)
        {
            jLabel3.setText("<html><font color='red'>Password");
            return_value = false;
        }
        else
            jLabel3.setText("<html>Password");

        return(return_value);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
