
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class CinemaBookingSystem extends JFrame {

    private JButton btnResOrCan;
    private ButtonGroup buttonGroup1;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
    private JPanel jPanel1, jPanel2, jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JRadioButton rbCancel, rbReserve;
    private JTextField txtName, txtNoOfReserved, txtNoOfSeats, txtNoOfVacant, txtPrice, txtTotalRevenue;
    private ImageIcon icon;


    private int i = 0;
    private final int NUMBER_OF_SEATS = 240;
    private int vacant = 0;


    MainForm mainForm = new MainForm();


    public CinemaBookingSystem() {
        initComponents();
        getTotalNumberOfSeats();
        getTotalNumberOfSeatsAvailable();
        getTotalNumberOfSeatsReserved();
        getTotalRevenue();
        nonEditableTextField();
    }

    //just shorting elements of constract
    private void initComponents() {
        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        rbReserve = new JRadioButton();
        rbCancel = new JRadioButton();
        jLabel1 = new JLabel();
        txtName = new JTextField();
        jLabel2 = new JLabel();
        txtPrice = new JTextField();
        btnResOrCan = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel3 = new JPanel();
        jLabel3 = new JLabel();
        txtNoOfSeats = new JTextField();
        jLabel4 = new JLabel();
        txtNoOfReserved = new JTextField();
        jLabel5 = new JLabel();
        txtNoOfVacant = new JTextField();
        jLabel6 = new JLabel();
        txtTotalRevenue = new JTextField();
        icon = new ImageIcon();
//icon
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "   Booking Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        buttonGroup1.add(rbReserve);
        rbReserve.setFont(new java.awt.Font("Tahoma", 1, 14));
        rbReserve.setText("Reserve");
        rbReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReserveActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCancel);
        rbCancel.setFont(new java.awt.Font("Tahoma", 1, 14));
        rbCancel.setText("Cancel Resev.");
        rbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Name");

        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("Price");

        txtPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnResOrCan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResOrCan.setText("Reserve/Cancel");
        btnResOrCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResOrCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(btnResOrCan, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                                                        .addComponent(jLabel1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(rbReserve)
                                                                .addGap(63, 63, 63)
                                                                .addComponent(rbCancel)))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbReserve)
                                        .addComponent(rbCancel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName))
                                .addGap(18, 18, 18)
                                .addComponent(btnResOrCan)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reservations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Seat No.", "Status", "Name", "Price"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "   Output Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setText("Number of Seats:");

        txtNoOfSeats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setText("Number of Reserved:");

        txtNoOfReserved.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel5.setText("Number of Vacant:");

        txtNoOfVacant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("Total Revenue");

        txtTotalRevenue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNoOfSeats)
                                        .addComponent(txtNoOfReserved)
                                        .addComponent(txtNoOfVacant)
                                        .addComponent(txtTotalRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtNoOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtNoOfReserved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(txtNoOfVacant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(txtTotalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    void checkMaxMinLimit() {
        if (i <= 0) {
            //JOptionPane.showMessageDialog(null, "Seats Available", "ERROR !!!", JOptionPane.ERROR_MESSAGE);

        } else if (i >= 240) {
            JOptionPane.showMessageDialog(null, ".....HOUSE FULL....", "ERROR !!!", JOptionPane.ERROR_MESSAGE);


        } else {
            --i;
            --vacant;

        }
    }

    void nonEditableTextField() {

        txtName.setEnabled(false);
        txtNoOfReserved.setEnabled(false);
        txtNoOfSeats.setEnabled(false);
        txtNoOfVacant.setEnabled(false);
        txtPrice.setEnabled(false);
        txtTotalRevenue.setEnabled(false);


        JTextField hide = null;
        for (Component c : jPanel3.getComponents()) {

            if (c.getClass().toString().contains("javax.swing.JTextField")) {
                hide = (JTextField) c;
                hide.setEnabled(false);
            }
        }
    }

    //Total Revenue
    public void getTotalRevenue() {
        double total;
        double totalRevenue = 0.0;
        for (int l = 0; l < jTable1.getRowCount(); l++) {
            total = Double.parseDouble(jTable1.getValueAt(l, 3).toString());
            totalRevenue += total;
        }

        txtTotalRevenue.setText(Double.toString(totalRevenue));
        nonEditableTextField();
    }

    private void rbReserveActionPerformed(java.awt.event.ActionEvent evt) {
        txtName.setEnabled(true);
        txtPrice.setEnabled(true);
    }

    private void rbCancelActionPerformed(java.awt.event.ActionEvent evt) {
        txtName.setEnabled(false);
        txtPrice.setEnabled(false);
    }

    private void getTotalNumberOfSeats() {
        String nOS;
        nOS = String.format("%d", NUMBER_OF_SEATS);
        txtNoOfSeats.setText(nOS);
    }

    private void getTotalNumberOfSeatsAvailable() {
        String nO;
        nO = String.format("%d", NUMBER_OF_SEATS - i);
        txtNoOfVacant.setText(nO);
        nonEditableTextField();
    }


    private void getTotalNumberOfSeatsReserved() {
        String nOfSeatsReserved;
        nOfSeatsReserved = String.format("%d", i);
        txtNoOfReserved.setText(nOfSeatsReserved);
        nonEditableTextField();
    }


    private void btnResOrCanActionPerformed(java.awt.event.ActionEvent evt) {
        if (!(rbReserve.isSelected()) && !(rbCancel.isSelected())) {
            JOptionPane.showMessageDialog(null, "Select a Radio Button! ", "ERROR !!!", JOptionPane.WARNING_MESSAGE);
        } else {
            mainForm.setName(txtName.getText());
            mainForm.setPrice(txtPrice.getText());

            if (rbReserve.isSelected()) {

                if (mainForm.isAll_OK()) {

                    if (i >= 240) {
                        JOptionPane.showMessageDialog(null, "!!....HOUSE FULL....!!", "OH !!!", JOptionPane.WARNING_MESSAGE);


                    } else {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.addRow(new Object[]{++i, "Reserved", txtName.getText(), txtPrice.getText()});


                        getTotalNumberOfSeatsReserved();
                        getTotalNumberOfSeatsAvailable();
                        getTotalRevenue();

                        txtName.setEnabled(true);
                        txtPrice.setEnabled(true);


                        txtName.setText(null);
                        txtPrice.setText(null);
                    }
                }
            }


            if (rbCancel.isSelected()) {

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (jTable1.getSelectedRow() == -1) {
                    if (jTable1.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Table is Empty ", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Select a Row to Cancel", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (model.getValueAt(jTable1.getSelectedRow(), 1) == "Cancelled") {
                        JOptionPane.showMessageDialog(null, "Alredy Cancelled", "ERROR !!!", JOptionPane.WARNING_MESSAGE);


                    } else {

                        model.setValueAt("Cancelled", jTable1.getSelectedRow(), 1);
                        model.setValueAt(0, jTable1.getSelectedRow(), 3);
                        getTotalRevenue();
                        checkMaxMinLimit();
                        getTotalNumberOfSeatsReserved();
                        getTotalNumberOfSeatsAvailable();
                    }
                }
            }
        }
    }
}