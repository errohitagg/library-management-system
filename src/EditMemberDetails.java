/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditMemberDetails.java
 *
 * Created on Mar 14, 2010, 2:25:37 AM
 */

import java.io.File;
import javax.swing.*;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.*;
import java.awt.Image;

/**
 *
 * @author Rohit Aggarwal
 */
public class EditMemberDetails extends javax.swing.JFrame {

    static String member_id, name, address, gender, contact_no, email_id, photo = null, membership;
    static Calendar date_of_birth = Calendar.getInstance(), validity = Calendar.getInstance();
    static File image_file;
    static ImageIcon image;
    static Blob image_value;
    EditMemberDetailsQuery query_class;

    /** Creates new form EditMemberDetails */
    public EditMemberDetails() {
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
        jButton1.setSize(jButton1.getPreferredSize());
        jButton2.setSize(jButton2.getPreferredSize());
        jButton3.setSize(jButton3.getPreferredSize());
        if(ServerDetails.database == Database.SQLSERVER)
        {
           query_class = new EditMemberDetailsMSSQL();
        }
        else if(ServerDetails.database == Database.MYSQL)
        {
            query_class = new EditMemberDetailsMYSQL();
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Member Details");
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
        jLabel1.setBounds(250, 20, 161, 29);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 44, 20);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel5.setText("Address");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 145, 59, 20);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel6.setText("Date of Birth");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 255, 96, 20);

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel7.setText("Gender");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 290, 54, 20);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel8.setText("Contact No.");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 325, 87, 20);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 105, 200, 26);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(150, 320, 200, 26);

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(150, 355, 200, 26);

        jTextArea1.setColumns(10);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jTextArea1.setRows(4);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 140, 200, 100);

        jRadioButton1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jRadioButton1.setText("Male");
        jRadioButton1.setEnabled(false);
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRadioButton1FocusLost(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(150, 285, 63, 29);

        jRadioButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jRadioButton2.setText("Female");
        jRadioButton2.setEnabled(false);
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jRadioButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRadioButton2FocusLost(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(250, 285, 81, 29);

        jButton1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton1.setText("Proceed >>");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(125, 400, 115, 29);

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton2.setText("!! Cancel !!");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(450, 400, 111, 29);

        jButton3.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton3.setText("Select Photo");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(490, 230, 123, 29);

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel9.setText("EMail ID");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 360, 69, 20);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel10.setText("Member ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 75, 84, 20);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(150, 70, 200, 26);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(null);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(1, 1, 0, 0);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(475, 70, 150, 150);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel3.setText("Membership");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(375, 325, 92, 20);

        jComboBox1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jComboBox1.setFocusable(false);
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(485, 320, 150, 26);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel4.setText("Vaild Upto");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(375, 360, 80, 20);

        jComboBox2.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox2.setFocusable(false);
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox2FocusLost(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(150, 250, 49, 26);

        jComboBox3.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox3.setFocusable(false);
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox3MouseClicked(evt);
            }
        });
        jComboBox3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox3FocusLost(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(205, 250, 110, 26);

        jComboBox4.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox4.setFocusable(false);
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
        });
        jComboBox4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox4FocusLost(evt);
            }
        });
        getContentPane().add(jComboBox4);
        jComboBox4.setBounds(320, 250, 35, 26);

        jComboBox5.setFont(new java.awt.Font("Century Schoolbook", 0, 16)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox5.setFocusable(false);
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox5MouseClicked(evt);
            }
        });
        jComboBox5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox5FocusLost(evt);
            }
        });
        getContentPane().add(jComboBox5);
        jComboBox5.setBounds(485, 355, 49, 26);

        jComboBox6.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox6.setFocusable(false);
        jComboBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox6MouseClicked(evt);
            }
        });
        jComboBox6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox6FocusLost(evt);
            }
        });
        getContentPane().add(jComboBox6);
        jComboBox6.setBounds(540, 355, 110, 26);

        jComboBox7.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jComboBox7.setFocusable(false);
        jComboBox7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox7MouseClicked(evt);
            }
        });
        jComboBox7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox7FocusLost(evt);
            }
        });
        getContentPane().add(jComboBox7);
        jComboBox7.setBounds(655, 355, 35, 26);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-735)/2, (screenSize.height-475)/2, 735, 475);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
        if(!(evt.getKeyChar() == '-' || evt.getKeyChar() == '+' || evt.getKeyChar() == '(' || evt.getKeyChar() == ')' || Character.isDigit(evt.getKeyChar())))
            evt.consume();
}//GEN-LAST:event_jTextField4KeyPressed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
        jRadioButton1.enable();
        jRadioButton2.setSelected(false);
        jRadioButton1.setSelected(true);
}//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
        jRadioButton2.enable();
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
}//GEN-LAST:event_jRadioButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(check_data() == true)
        {
            name = jTextField1.getText();
            address = jTextArea1.getText();
            date_of_birth.clear();
            date_of_birth.set(Integer.parseInt(jComboBox4.getSelectedItem().toString()), jComboBox3.getSelectedIndex(), Integer.parseInt(jComboBox2.getSelectedItem().toString()));
            if(jRadioButton1.isSelected())
                gender = jRadioButton1.getText();
            else
                gender = jRadioButton2.getText();
            contact_no = jTextField4.getText();
            email_id = jTextField5.getText();
            member_id = jTextField6.getText();
            membership = jComboBox1.getSelectedItem().toString();
            validity.clear();
            validity.set(Integer.parseInt(jComboBox7.getSelectedItem().toString()), jComboBox6.getSelectedIndex(), Integer.parseInt(jComboBox5.getSelectedItem().toString()));
            if(query_class.check_member_id() == false)
            {
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
                else
                    System.exit(0);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Employee already exists in the database.", "Duplicate Employee", JOptionPane.WARNING_MESSAGE);
                jTextField1.setText(null);
                jTextField4.setText(null);
                jTextField5.setText(null);
                jTextField6.setText(null);
                jTextArea1.setText(null);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Correct the highlighted items before proceeding", "Incorrect Data", JOptionPane.WARNING_MESSAGE);
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
        else
            System.exit(0);
}//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        int answer = jFileChooser1.showOpenDialog(this);
        if(answer == jFileChooser1.APPROVE_OPTION)
        {
            jPanel1.removeAll();
            image_file = jFileChooser1.getSelectedFile();
            photo = image_file.getAbsolutePath();
            image = new ImageIcon(image_file.getAbsolutePath());
            jLabel11 = new JLabel(new ImageIcon(image.getImage().getScaledInstance(148, 148, Image.SCALE_DEFAULT)));            
            jPanel1.add(jLabel11);
            jLabel11.setBounds(1, 1, 148, 148);
            jPanel1.validate();
        }
}//GEN-LAST:event_jButton3MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Calendar now = Calendar.getInstance();
        now.setTime(new java.util.Date());
        for(int i = now.get(Calendar.YEAR); i >= now.get(Calendar.YEAR)-75; i--)
            jComboBox4.addItem(i);
        jComboBox4.setSize(jComboBox4.getPreferredSize());
        for(int i = now.get(Calendar.YEAR); i <= now.get(Calendar.YEAR)+25; i++)
            jComboBox7.addItem(i);
        jComboBox7.setSize(jComboBox7.getPreferredSize());

        ResultSet membership_list = query_class.retrieve_memberships();
        try
        {
            if(membership_list != null)
            {
                while(membership_list.next())
                {
                    jComboBox1.addItem((Object)(membership_list.getString("TypeName")).toString());
                }
            }
            membership_list.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application" , "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        try
        {
            ResultSet result_set = query_class.retrieve_values();
            if(result_set.next())
            {
                jTextField6.setText(result_set.getString("MemberID"));
                jTextField1.setText(result_set.getString("Name"));
                Calendar c = Calendar.getInstance();
                c.clear();
                c.set(result_set.getDate("DateOfBirth").getYear(), result_set.getDate("DateOfBirth").getMonth(), result_set.getDate("DateOfBirth").getDate());
                jComboBox2.setSelectedIndex(c.get(Calendar.DATE) - 1);
                jComboBox3.setSelectedIndex(c.get(Calendar.MONTH));
                jComboBox4.setSelectedItem(c.get(Calendar.YEAR) + 1900);
                jComboBox2.setFocusable(false);
                jComboBox3.setFocusable(false);
                jComboBox4.setFocusable(false);
            
                if(result_set.getString("Gender").trim().compareTo("Male") == 0)
                    jRadioButton1.setSelected(true);
                else
                    jRadioButton2.setSelected(true);
                jTextField4.setText(result_set.getString("ContactNo"));
                jTextArea1.setText(result_set.getString("Address"));
                jTextField5.setText(result_set.getString("EMailID"));

                result_set.getBlob("Photo");
                if(result_set.wasNull() == false)
                {             
                    image_value = result_set.getBlob("Photo");
                    ImageIcon temp_image = new ImageIcon(image_value.getBytes(1, (int)image_value.length()));
                    jLabel11 = new JLabel(new ImageIcon(temp_image.getImage().getScaledInstance(148, 148, Image.SCALE_DEFAULT)));
                    jPanel1.add(jLabel11);
                    jLabel11.setBounds(1, 1, 148, 148);
                    jPanel1.validate();
                }
            }
            result_set.close();

            ResultSet result_set_ = query_class.retrieve_values_();
            if(result_set_.next())
            {
                jComboBox1.setSelectedItem(result_set_.getString("TypeName"));
            }
            result_set_.close();

            ResultSet _result_set_ = query_class._retrieve_values_();
            if(_result_set_.next())
            {
                Calendar c = Calendar.getInstance();
                c.clear();
                c.set(_result_set_.getDate("ValidUpto").getYear(), _result_set_.getDate("ValidUpto").getMonth(), _result_set_.getDate("ValidUpto").getDate());
                jComboBox5.setSelectedIndex(c.get(Calendar.DATE) - 1);
                jComboBox6.setSelectedIndex(c.get(Calendar.MONTH));
                jComboBox7.setSelectedItem(c.get(Calendar.YEAR) + 1900);
                jComboBox5.setFocusable(false);
                jComboBox6.setFocusable(false);
                jComboBox7.setFocusable(false);
            }        
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null ,"Couldn't connect to the server.\nCheck the server and restart the Application", "Server Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        jTextField1.setEditable(true);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        jTextField1.setEditable(false);
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        // TODO add your handling code here:
        jTextArea1.setEditable(true);
    }//GEN-LAST:event_jTextArea1MouseClicked

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost
        // TODO add your handling code here:
        jTextArea1.setEditable(false);
    }//GEN-LAST:event_jTextArea1FocusLost

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        // TODO add your handling code here:
        jTextField4.setEditable(true);
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        // TODO add your handling code here:
        jTextField4.setEditable(false);
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        // TODO add your handling code here:
        jTextField5.setEditable(true);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        // TODO add your handling code here:
        jTextField5.setEditable(false);
    }//GEN-LAST:event_jTextField5FocusLost

    private void jRadioButton2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButton2FocusLost
        // TODO add your handling code here:
        jRadioButton2.disable();
    }//GEN-LAST:event_jRadioButton2FocusLost

    private void jRadioButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButton1FocusLost
        // TODO add your handling code here:
        jRadioButton1.disable();
    }//GEN-LAST:event_jRadioButton1FocusLost

    private void jComboBox2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox2FocusLost
        // TODO add your handling code here:
        jComboBox2.setFocusable(false);
    }//GEN-LAST:event_jComboBox2FocusLost

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
        jComboBox2.setFocusable(true);
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox3FocusLost
        // TODO add your handling code here:
        jComboBox3.setFocusable(false);
    }//GEN-LAST:event_jComboBox3FocusLost

    private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseClicked
        // TODO add your handling code here:
        jComboBox3.setFocusable(true);
    }//GEN-LAST:event_jComboBox3MouseClicked

    private void jComboBox4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox4FocusLost
        // TODO add your handling code here:
        jComboBox4.setFocusable(false);
    }//GEN-LAST:event_jComboBox4FocusLost

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked
        // TODO add your handling code here:
        jComboBox4.setFocusable(true);
    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        // TODO add your handling code here:
        jComboBox1.setFocusable(false);
    }//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        jComboBox1.setFocusable(true);
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox5FocusLost
        // TODO add your handling code here:
        jComboBox5.setFocusable(false);
    }//GEN-LAST:event_jComboBox5FocusLost

    private void jComboBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseClicked
        // TODO add your handling code here:
        jComboBox5.setFocusable(true);
    }//GEN-LAST:event_jComboBox5MouseClicked

    private void jComboBox6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox6FocusLost
        // TODO add your handling code here:
        jComboBox6.setFocusable(false);
    }//GEN-LAST:event_jComboBox6FocusLost

    private void jComboBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseClicked
        // TODO add your handling code here:
        jComboBox6.setFocusable(true);
    }//GEN-LAST:event_jComboBox6MouseClicked

    private void jComboBox7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox7FocusLost
        // TODO add your handling code here:
        jComboBox7.setFocusable(false);
    }//GEN-LAST:event_jComboBox7FocusLost

    private void jComboBox7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox7MouseClicked
        // TODO add your handling code here:
        jComboBox7.setFocusable(true);
    }//GEN-LAST:event_jComboBox7MouseClicked

    private boolean check_data()
    {
        boolean return_value=true;

        if(jTextField1.getText() == null || jTextField1.getText().compareTo("") == 0)
        {
            jLabel2.setText("<html><font color='red'>Name");
            return_value = false;
        }
        else
            jLabel2.setText("Name");

        if(jTextArea1.getText() == null || jTextArea1.getText().compareTo("") == 0)
        {
            jLabel5.setText("<html><font color='red'>Address");
            return_value = false;
        }
        else
            jLabel5.setText("Address");

        if(jTextField4.getText() == null || jTextField4.getText().compareTo("") == 0)
        {
            jLabel8.setText("<html><font color='red'>Contact No.");
            return_value = false;
        }
        else
            jLabel8.setText("Contact No.");

        if(jTextField5.getText() == null || jTextField5.getText().compareTo("") == 0)
        {
            jLabel9.setText("<html><font color='red'>EMail ID");
            return_value = false;
        }
        else
            jLabel9.setText("EMail ID");

        if(jTextField6.getText() == null || jTextField6.getText().compareTo("") == 0)
        {
            jLabel10.setText("<html><font color='red'>Member ID");
            return_value = false;
        }
        else
            jLabel10.setText("Member ID");
        
        if(jRadioButton1.isSelected() == false && jRadioButton2.isSelected() == false)
        {
            jLabel7.setText("<html><font color='red'>Gender");
            return_value = false;
        }
        else
            jLabel7.setText("Gender");

        if(check_birth_date() == false)
        {
            jLabel6.setText("<html><font color='red'>Date of Birth");
            return_value = false;
        }
        else
            jLabel6.setText("Date of Birth");

        if(check_valid_date() == false)
        {
            jLabel4.setText("<html><font color='red'>Valid Upto");
            return_value = false;
        }
        else
            jLabel4.setText("Valid Upto");

        return(return_value);
    }

    private boolean check_birth_date()
    {
        boolean return_value = true;
        String date = (jComboBox3.getSelectedIndex()+1) + "/" + jComboBox2.getSelectedItem().toString() + "/" + jComboBox4.getSelectedItem().toString();

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

    private boolean check_valid_date()
    {
        boolean return_value = true;
        String date = (jComboBox6.getSelectedIndex()+1) + "/" + jComboBox5.getSelectedItem().toString() + "/" + jComboBox7.getSelectedItem().toString();

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
                new EditMemberDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

}
