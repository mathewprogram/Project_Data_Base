package csv_to_mysql;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.*;

public class VentanaTableArchivoCsv extends javax.swing.JFrame {
    
    
    String[] header = {"Id","Name","Sex","Birth"};
    String[][] body = {};
    DefaultTableModel dtm = new DefaultTableModel(body, header);
    
    private DatabaseManager dbManager;
    
    static ConexionMySQL cm = new ConexionMySQL("COLLEGE");
    static Connection conexion = cm.getConexion();
    
    public VentanaTableArchivoCsv() {
        initComponents();
        personalizarVentana();
        personalizarTable();
        String[] sortOptions = {"  Sort by", "Id", "Name", "Sex", "Birth Date"};
        cmbList.setModel(new javax.swing.DefaultComboBoxModel<>(sortOptions));
        cmbList.setSelectedItem("Sort by");  // Set the default selected item
        
        btnClean.setEnabled(false);
        
        // Configuración del combo box para bases de datos
        populateDatabaseDropdown();
        handleDatabaseSelection();
        
    }
    
    private void connectToDatabase(String dbName) {
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        String user = "root"; // Cambia esto por tu usuario de MySQL
        String password = "12345678"; // Cambia esto por tu contraseña de MySQL

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database: " + dbName);
            // Aquí puedes realizar operaciones con la base de datos seleccionada
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
    
    
    public void personalizarTable(){
        tblMostrar.setModel(dtm);
        
        //Obtener el TableColumnModel del JTable
        TableColumnModel columnModel = tblMostrar.getColumnModel();
        TableColumn column = columnModel.getColumn(1);
        
        //Establecer el ancho preferido, minimo y maximo para la columna
        column.setPreferredWidth(200);
        column.setMinWidth(70);
        column.setMaxWidth(200);
    }
    
    public void personalizarVentana() {
        ImageIcon icono = new ImageIcon("image/icono.icns");
        Image image = icono.getImage();
        this.setIconImage(image);//Cambiar el icono de la ventana

        this.setTitle("College");
        this.setResizable(false); //No se redimensione
        this.setLocationRelativeTo(null);//Colocar la ventana en el centro de la pantalla
        
    }
    
    private List<String> getAllDatabaseNames() {
        List<String> databases = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root"; // Cambia esto por tu usuario de MySQL
        String password = "12345678"; // Cambia esto por tu contraseña de MySQL

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");
            while (resultSet.next()) {
                databases.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving database names: " + e.getMessage());
        }

        return databases;
    }

    
    private void handleDatabaseSelection() {
        cmbDataBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDb = (String) cmbDataBase.getSelectedItem();
                if (selectedDb != null) {
                    connectToDatabase(selectedDb);
                }
            }
        });
    }


    
    private void populateDatabaseDropdown() {
        List<String> databases = getAllDatabaseNames(); // Asegúrate de implementar este método
        cmbDataBase.removeAllItems(); // Limpiar elementos existentes
        for (String dbName : databases) {
            cmbDataBase.addItem(dbName);
        }
    }
    
    
    //Personalizar las caracteristicas de la ventana fin   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        btnCargar = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnAddRow = new javax.swing.JButton();
        btnAddStudent = new javax.swing.JButton();
        btnDeleteStudent = new javax.swing.JButton();
        btnUpdateStudent = new javax.swing.JButton();
        cmbList = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnDataBase = new javax.swing.JButton();
        cmbDataBase = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMostrar.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMostrar);

        btnCargar.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnClean.setText("Clean");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblTitulo.setBackground(new java.awt.Color(115, 125, 125));
        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("College Students");
        lblTitulo.setOpaque(true);

        btnAddRow.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAddRow.setText("Add Row");
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

        btnAddStudent.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAddStudent.setText("Add Student");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        btnDeleteStudent.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnDeleteStudent.setText("Delete Student");
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });

        btnUpdateStudent.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnUpdateStudent.setText("Update Student");
        btnUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentActionPerformed(evt);
            }
        });

        cmbList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        cmbList.setToolTipText("");
        cmbList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDataBase.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnDataBase.setText("Create");
        btnDataBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataBaseActionPerformed(evt);
            }
        });

        cmbDataBase.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        cmbDataBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDataBaseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setText("Chose a Data Base");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAddStudent)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cmbList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(34, 34, 34)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDeleteStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btnAddRow, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(btnDataBase)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDataBase)
                    .addComponent(btnAddRow)
                    .addComponent(btnUpdateStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddStudent)
                        .addComponent(btnDeleteStudent))
                    .addComponent(btnCargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClean)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(cmbDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        clean();
        obtenerTodosLosRegistros();
        btnCargar.setEnabled(false);
        btnClean.setEnabled(true);
        /*
        Otra forma de cargar los datos es:
        List<Student> student_al = obtenerTodosLosRegistros();
        String blankRow = {"", "", "", ""};
        
        for(int i = 0; i< student_al.size(); i++){
            dtm.addRow(blankRow);
        Student student = student_al.get(i);
        dtm.setValueAt(student.getidStudent(), i, 0);
        dtm.setValueAt(student.getNombre_apellido(), i, 1);
        dtm.setValueAt(student.getSexo(), i, 2).charAt(0);
        dtm.setValueAt(student.getFecha_nacimiento(), i, 3);
        }
        */
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
        dispose();        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clean();
        btnCargar.setEnabled(true);
        btnClean.setEnabled(false);
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        Connection conexion = cm.getConexion();
        MetodoCrud mc = new MetodoCrud(conexion);
        
        int nextId = mc.obtainLastStudentId(); // Get the next ID
        if (nextId == -1) {
        JOptionPane.showMessageDialog(this, "Failed to obtain the next student ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        String[] blankRow = {String.valueOf(nextId), "", "", ""};
        dtm.addRow(blankRow);
    
        btnClean.setEnabled(true);
        
    
    }//GEN-LAST:event_btnAddRowActionPerformed

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
        MetodoCrud mc = new MetodoCrud(conexion);
    boolean allAdded = true;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust format if needed

    for (int i = 0; i < dtm.getRowCount(); i++) {
        try {
            // Extract values from table cells
            Object idStudentObj = dtm.getValueAt(i, 0);
            Object nombreObj = dtm.getValueAt(i, 1);
            Object sexoObj = dtm.getValueAt(i, 2);
            Object fechaObj = dtm.getValueAt(i, 3);

            // Validate and convert idStudent
            int idStudent;
            if (idStudentObj instanceof Integer) {
                idStudent = (Integer) idStudentObj;
            } else if (idStudentObj instanceof String) {
                try {
                    idStudent = Integer.parseInt((String) idStudentObj);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid idStudent format: " + e.getMessage());
                    allAdded = false;
                    continue;
                }
            } else {
                System.out.println("Invalid idStudent type");
                allAdded = false;
                continue;
            }

            // Validate and convert nombre
            if (nombreObj == null || !(nombreObj instanceof String)) {
                System.out.println("Invalid nombre");
                allAdded = false;
                continue;
            }
            String nombre = (String) nombreObj;

            // Validate and convert sexo
            if (sexoObj == null || !(sexoObj instanceof String) || ((String) sexoObj).length() != 1) {
                System.out.println("Invalid sexo");
                allAdded = false;
                continue;
            }
            char sexo = ((String) sexoObj).charAt(0);

            // Validate and convert fecha
            java.sql.Date fecha = null;
            if (fechaObj instanceof String) {
                try {
                    java.util.Date utilDate = dateFormat.parse((String) fechaObj);
                    fecha = new java.sql.Date(utilDate.getTime());
                } catch (ParseException e) {
                    System.out.println("Date format error: " + e.getMessage());
                    allAdded = false;
                    continue;
                }
            } else if (fechaObj instanceof java.sql.Date) {
                fecha = (java.sql.Date) fechaObj;
            } else if (fechaObj instanceof java.util.Date) {
                fecha = new java.sql.Date(((java.util.Date) fechaObj).getTime());
            } else {
                System.out.println("Invalid fecha");
                allAdded = false;
                continue;
            }

            // Create Student object and add to database
            Student student = new Student(idStudent, nombre, sexo, fecha);
            if (!mc.insertStudent(student)) {
                System.out.println("Failed to add student: " + idStudent);
                allAdded = false;
            }
        } catch (Exception e) {
            System.out.println("Error processing row: " + e.getMessage());
            allAdded = false;
        }
    }

    if (allAdded) {
        System.out.println("Added successfully.");
        JOptionPane.showMessageDialog(this, "Added successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
    } else {
        System.out.println("Failed to be added.");
    }
    }//GEN-LAST:event_btnAddStudentActionPerformed

    private void btnUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentActionPerformed
           int selectedRow = tblMostrar.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "No row selected. Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object idStudentObj = dtm.getValueAt(selectedRow, 0);
        Object nombreObj = dtm.getValueAt(selectedRow, 1);
        Object sexoObj = dtm.getValueAt(selectedRow, 2);
        Object fechaObj = dtm.getValueAt(selectedRow, 3);

        int idStudent;
        try {
            idStudent = Integer.parseInt(idStudentObj.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid student ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = nombreObj instanceof String ? (String) nombreObj : "";
        char sexo = (sexoObj instanceof String && ((String) sexoObj).length() == 1) ? ((String) sexoObj).charAt(0) : ' ';
        java.sql.Date fecha = null;

        try {
            if (fechaObj instanceof String) {
                java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) fechaObj);
                fecha = new java.sql.Date(utilDate.getTime());
            } else if (fechaObj instanceof java.util.Date) {
                fecha = new java.sql.Date(((java.util.Date) fechaObj).getTime());
            } else if (fechaObj instanceof java.sql.Date) {
                fecha = (java.sql.Date) fechaObj;
            } else {
                throw new IllegalArgumentException("Invalid date format");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Date format error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = new Student(idStudent, nombre, sexo, fecha);
        MetodoCrud mc = new MetodoCrud(conexion);

        if (mc.updateStudent(student)) {
            JOptionPane.showMessageDialog(this, "Student updated successfully: " + idStudent, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update student: " + idStudent, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateStudentActionPerformed

    public boolean updateStudent(Student student) {
        String sql = "UPDATE Student SET nombre_apellido = ?, sexo = ?, fecha_nacimiento = ? WHERE idStudent = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, student.getNombre_apellido());
            ps.setString(2, String.valueOf(student.getSexo()));
            ps.setDate(3, student.getFecha_nacimiento());
            ps.setInt(4, student.getidStudent());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }
    
    
    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
        // Get the selected row from the table
    int selectedRow = tblMostrar.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a student to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Assuming the first column in the table contains the student ID
    String idStudentStr = tblMostrar.getValueAt(selectedRow, 0).toString();
    try {
        int idStudent = Integer.parseInt(idStudentStr);

        // Initialize the MetodoCrud class
        MetodoCrud mc = new MetodoCrud(conexion); // Assuming you have a Connection object named 'conexion'

        // Attempt to delete the student
        boolean success = mc.deleteStudent(idStudent);
        if (success) {
            JOptionPane.showMessageDialog(this, "Student deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Remove the deleted row from the table
            ((DefaultTableModel) tblMostrar.getModel()).removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete the student.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid Student ID format.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_btnDeleteStudentActionPerformed

    private void cmbListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListActionPerformed
        String selectedOption = (String) cmbList.getSelectedItem();
        switch (selectedOption) {
            case "Id":
                sortById();
                break;
            case "Name":
                sortByName();
                break;
            case "Sex":
                sortBySex();
                break;
            case "Birth Date":
                sortByBirthDate();
                break;
            default:
                // Handle default case if necessary
                break;
        }
    }//GEN-LAST:event_cmbListActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchTerm = txtSearch.getText().trim();
    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        int idStudent = Integer.parseInt(searchTerm);
        searchById(idStudent);
    } catch (NumberFormatException e) {
        searchByName(searchTerm);
    }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDataBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBaseActionPerformed
       createDataBaseAndTable();
    }//GEN-LAST:event_btnDataBaseActionPerformed

    private void cmbDataBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDataBaseActionPerformed
        // Obtener la base de datos seleccionada
    String selectedDb = (String) cmbDataBase.getSelectedItem();
    if (selectedDb != null) {
        // Conectar a la base de datos seleccionada
        connectToDatabase(selectedDb);
    }
    }//GEN-LAST:event_cmbDataBaseActionPerformed
    
    public class DatabaseManager {

    private String user = "root"; // Your MySQL user
    private String password = "12345678"; // Your MySQL password

    public List<String> getAllDatabaseNames() {
        List<String> databases = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");
            while (resultSet.next()) {
                databases.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving database names: " + e.getMessage());
        }

        return databases;
    }
}
    
     private void createDataBaseAndTable() {
        // Obtener el nombre de la base de datos desde txtSearch
        String dbName = txtSearch.getText(); // Asegúrate de validar y sanitizar este valor
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root"; // Cambia esto por tu usuario de MySQL
        String password = "12345678"; // Cambia esto por tu contraseña de MySQL

        Connection connection = null;
        Statement statement = null;

        try {
            // Crear la base de datos si no existe
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            
            // Crear la base de datos
            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.executeUpdate(createDBQuery);
            System.out.println("Base de datos " + dbName + " creada o ya existe");

            // Conectar a la base de datos recién creada
            String dbUrl = url + dbName;
            try (Connection dbConnection = DriverManager.getConnection(dbUrl, user, password)) {
                // Crear la tabla si no existe
                String createTableQuery = "CREATE TABLE IF NOT EXISTS CasaDeCampo ("
                    + "idPublicador INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre_apellido VARCHAR(100), "
                    + "sexo CHAR(1),"
                    + "direccion VARCHAR(255),"
                    + "telefono VARCHAR(20))";
                
                try (PreparedStatement ps = dbConnection.prepareStatement(createTableQuery)) {
                    ps.executeUpdate();
                    System.out.println("Tabla CasaDeCampo creada o ya existe en la base de datos " + dbName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos o la tabla: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la declaración: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    
    private void searchById(int idStudent) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE idStudent = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idStudent);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("idStudent");
                    String nombre = rs.getString("nombre_apellido");
                    char sexo = rs.getString("sexo").charAt(0);
                    Date fecha = rs.getDate("fecha_nacimiento");
                    students.add(new Student(id, nombre, sexo, fecha));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching by ID: " + e.getMessage());
        }

        updateTableWithStudents(students);
    }
    
    private void searchByName(String name) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE nombre_apellido LIKE ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("idStudent");
                    String nombre = rs.getString("nombre_apellido");
                    char sexo = rs.getString("sexo").charAt(0);
                    Date fecha = rs.getDate("fecha_nacimiento");
                    students.add(new Student(id, nombre, sexo, fecha));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching by name: " + e.getMessage());
        }

        updateTableWithStudents(students);
    }


    
    private void sortById() {
        List<Student> student = fetchStudents();
        student.sort((s1, s2) -> Integer.compare(s1.getidStudent(), s2.getidStudent()));
        updateTableWithStudents(student);
    }

    private void sortByName() {
        List<Student> student = fetchStudents();
        student.sort((s1, s2) -> s1.getNombre_apellido().compareTo(s2.getNombre_apellido()));
        updateTableWithStudents(student);
    }

    private void sortBySex() {
        List<Student> student = fetchStudents();
        student.sort((s1, s2) -> Character.compare(s1.getSexo(), s2.getSexo()));
        updateTableWithStudents(student);
    }

    private void sortByBirthDate() {
        List<Student> student = fetchStudents();
        student.sort((s1, s2) -> s1.getFecha_nacimiento().compareTo(s2.getFecha_nacimiento()));
        updateTableWithStudents(student);
    }
    
    private List<Student> fetchStudents() {
        List<Student> student = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement("SELECT * FROM Student");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idStudent = rs.getInt("idStudent");
                String nombre = rs.getString("nombre_apellido");
                char sexo = rs.getString("sexo").charAt(0);
                Date fecha = rs.getDate("fecha_nacimiento");
                student.add(new Student(idStudent, nombre, sexo, fecha));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return student;
    }

    private void updateTableWithStudents(List<Student> students) {
        dtm.setRowCount(0);
        for (Student student : students) {
            dtm.addRow(new Object[]{student.getidStudent(), student.getNombre_apellido(), student.getSexo(), student.getFecha_nacimiento()});
        }
    }
    
    
     public void clean(){
        int numeroFilas = dtm.getRowCount();
        for(int i=0; i<numeroFilas; i++){
            dtm.removeRow(0);
        }
    }
     
    private void refreshTable() {
        clean();
        List<Student> students = obtenerTodosLosRegistros();
        updateTableWithStudents(students);
    } 
     
    public boolean addStudent(Student student) {
    boolean correcto = true;
    String sql = "INSERT INTO Student (idStudent, nombre_apellido, sexo, fecha_nacimiento) VALUES (?, ?, ?, ?)"; // Query Paramétrica

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, student.getidStudent());
        ps.setString(2, student.getNombre_apellido());
        ps.setString(3, String.valueOf(student.getSexo())); // Convertir char a String
        ps.setDate(4, student.getFecha_nacimiento());
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error inserting student: " + e.getMessage()); // Logging error message
        correcto = false;
    }
    return correcto;
}
    
public boolean existeStudent(int idStudent) {
    boolean existe = false;
    String sql = "SELECT 1 FROM Student WHERE idStudent = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idStudent);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            existe = true;
        }
    } catch (SQLException e) {
        System.out.println("Error checking if student exists: " + e.getMessage());
    }
    return existe;
}
    

public boolean actualizarStudent(Student student) {
    boolean correcto = true;
    String sql = "UPDATE Student SET nombre_apellido = ?, sexo = ?, fecha_nacimiento = ? WHERE idStudent = ?"; //Query Paramétrica
    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, student.getNombre_apellido());
        ps.setString(2, String.valueOf(student.getSexo()));
        ps.setDate(3, student.getFecha_nacimiento());
        ps.setInt(4, student.getidStudent());
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected == 0) {
            correcto = false;
            System.out.println("No rows updated. Student ID may not exist: " + student.getidStudent());
        }
    } catch (SQLException e) {
        correcto = false;
        System.out.println("Error updating student: " + e.getMessage());
    }
    return correcto;
}
    

    public List<Student> obtenerTodosLosRegistros(){
        List<Student> student_al = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idStudent = rs.getInt("idStudent");
                String nombre = rs.getString("nombre_apellido");
                char sexo = rs.getString("sexo").charAt(0);
                Date fecha = rs.getDate("fecha_nacimiento");
                Student student = new Student(idStudent, nombre, sexo, fecha);
                student_al.add(student);
                
                dtm.addRow(new Object[]{idStudent, nombre, String.valueOf(sexo), fecha});/*
                yo pinto los datos utilizando esta linea pero puedo tambien con 
                la que esta comentada en el btnCargar
                */
            }
        }catch(SQLException e) {
                    student_al = null;
        }
        return student_al;
    }
    
    public boolean existeStudent(Student student) {
        boolean existe = false;
        String sql = "SELECT 1 FROM Student WHERE idStudent = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, student.getidStudent());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return existe;
    }     

    
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(VentanaTableArchivoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTableArchivoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTableArchivoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTableArchivoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaTableArchivoCsv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRow;
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDataBase;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateStudent;
    private javax.swing.JComboBox<String> cmbDataBase;
    private javax.swing.JComboBox<String> cmbList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
