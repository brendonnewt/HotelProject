package edu.baylor.GroupFive.ui.generateBill;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.baylor.GroupFive.ui.reservations.ReservationModel;
import edu.baylor.GroupFive.ui.utils.Page;

import edu.baylor.GroupFive.ui.utils.interfaces.PagePanel;
import edu.baylor.GroupFive.ui.utils.table.HotelTable;

import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GenerateBillPanel extends JPanel implements PagePanel {

    /*
     * What does this need to have?
     * 
     * A table that shows a list of current guests
     * A button to generate a bill for a guest
     * 
     */

    private JTable table;
    private Page page;
    private JPanel buttonPanel;

    // Define column names
    private String[] columnNames = {
            "First Name",
            "Last Name",
            "Start Date",
            "End Date",
            "Guest ID",
            "Room Number"};

    // Define data types for the columns
    final Class<?>[] columnClass = new Class[] {
            String.class, String.class, String.class, String.class, String.class, String.class
    };
    
    public GenerateBillPanel(Page page) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.page = page;

        // Create a model of the data.
        DefaultTableModel model = new GenerateBillModel(columnNames, columnClass);

        // Create a table with a sorter.
        table = new HotelTable(model);

        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        // Add some glue
        add(Box.createVerticalGlue());

        // Add the title
        JLabel titleLabel = new JLabel("Current Guests");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel);

        // Add some glue
        add(Box.createVerticalGlue());

        // Add the scroll pane to this panel.
        
        add(scrollPane);

        // Add the button panel
        buttonPanel = new JPanel();
        addGenerateSelectedGuestBillButton(buttonPanel);
        add(buttonPanel);

    }

    public void addGenerateSelectedGuestBillButton(JPanel panel) {
        JButton generateButton = new JButton("Generate Selected Guests Bill");
        generateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateButton.setPreferredSize(new Dimension(350, 50));
        generateButton.setFont(new Font("Arial", Font.PLAIN, 22));
        generateButton.setOpaque(true);
        generateButton.setBorderPainted(false);
        generateButton.setBackground(new Color(0, 0, 153));
        generateButton.setForeground(new Color(255, 255, 255));

        panel.add(generateButton);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
    }

}
