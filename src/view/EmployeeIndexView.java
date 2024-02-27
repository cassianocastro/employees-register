package view;

import controller.EmployeesController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class EmployeeIndexView extends JFrame
{

    private final EmployeesController controller;

    public EmployeeIndexView(EmployeesController controller)
    {
        super("Employees");

        this.controller = controller;
        this.initComponents();
        this.initListeners();

        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void initListeners()
    {
        this.insertButton.addActionListener((ActionEvent e) ->
        {
            this.controller.addEmployee();
        });

        this.listButton.addActionListener((ActionEvent e) ->
        {
            this.controller.listEmployees();
        });

        this.updateButton.addActionListener((ActionEvent e) ->
        {
            this.controller.updateEmployee();
        });

        this.searchButton.addActionListener((ActionEvent e) ->
        {
            this.controller.findEmployee();
        });

        this.deleteButton.addActionListener((ActionEvent e) ->
        {
            this.controller.deleteEmployee();
        });

        this.closeButton.addActionListener((ActionEvent e) ->
        {
            super.dispose();
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        insertButton = new JButton();
        updateButton = new JButton();
        searchButton = new JButton();
        listButton = new JButton();
        deleteButton = new JButton();
        closeButton = new JButton();
        titlePanel = new JLabel();
        scrollPane = new JScrollPane();
        employeesTable = new JTable();
        employeesLabel = new JLabel();
        titleLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 255));

        jPanel2.setBackground(new Color(204, 0, 51));

        insertButton.setText("Insert");

        updateButton.setText("Update");

        searchButton.setText("Search");

        listButton.setText("Show");

        deleteButton.setText("Delete");

        closeButton.setText("Exit");

        titlePanel.setForeground(new Color(0, 0, 0));
        titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.setText("Choose an option");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                    .addComponent(listButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(closeButton)
                        .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(closeButton)
                .addContainerGap())
        );

        scrollPane.setBackground(new Color(255, 51, 51));

        employeesTable.setBackground(new Color(204, 0, 51));
        employeesTable.setForeground(new Color(255, 255, 102));
        employeesTable.setModel(new DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Name", "Sex", "CPF", "Birth Date"
            }
        )
        {
            Class[] types = new Class []
            {
                String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        employeesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        employeesTable.setGridColor(new Color(255, 0, 0));
        scrollPane.setViewportView(employeesTable);
        if (employeesTable.getColumnModel().getColumnCount() > 0)
        {
            employeesTable.getColumnModel().getColumn(0).setMinWidth(300);
            employeesTable.getColumnModel().getColumn(1).setMinWidth(20);
            employeesTable.getColumnModel().getColumn(2).setMinWidth(150);
            employeesTable.getColumnModel().getColumn(3).setMinWidth(150);
        }

        employeesLabel.setFont(new Font("Liberation Sans", 1, 16)); // NOI18N
        employeesLabel.setForeground(new Color(204, 0, 0));
        employeesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        employeesLabel.setText("Employees");

        titleLabel.setFont(new Font("Liberation Sans", 1, 24)); // NOI18N
        titleLabel.setForeground(new Color(204, 0, 51));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Employees");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employeesLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(employeesLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton closeButton;
    private JButton deleteButton;
    private JLabel employeesLabel;
    private JTable employeesTable;
    private JButton insertButton;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JButton listButton;
    private JScrollPane scrollPane;
    private JButton searchButton;
    private JLabel titleLabel;
    private JLabel titlePanel;
    private JButton updateButton;
    // End of variables declaration//GEN-END:variables
}