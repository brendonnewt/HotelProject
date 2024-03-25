package edu.baylor.GroupFive.ui.utils;

import javax.swing.*;

import edu.baylor.GroupFive.model.Privilege;
import edu.baylor.GroupFive.ui.reservations.ReservationsPanel;
import edu.baylor.GroupFive.ui.reserveRoom.NewReserveRoomPanel;
import edu.baylor.GroupFive.ui.reserveRoom.ReserveRoomPanel;
import edu.baylor.GroupFive.ui.utils.dashboard.Dashboard;
import edu.baylor.GroupFive.ui.utils.interfaces.InputDelegate;

import java.awt.*;

public class Page extends JFrame implements InputDelegate {

    private Dashboard dashboard;
    private GridBagConstraints constraints = new GridBagConstraints();
    private String acctNum;
    private Privilege privilege;
    
    
    public JPanel currentPanel;
    public Page(String acctNum) {
        super();
        //Init new frame
        createFrame();

        //privilege = getAccountPrivilege(acctNum);

        //Create constraints to add dashboard to the frame
        dashboard = new Dashboard(this, acctNum);
        addDashboard();

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        currentPanel = new ReservationsPanel();
        add(currentPanel, constraints);
    }

    public void createFrame() {
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0xe6f7ff));
        setLayout(new GridBagLayout());
        setVisible(true);
    }

    public void addDashboard() {
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        add(dashboard, constraints);
    }

    public void onPageSwitch(String option) {
        //todo: add logic for switching pages on dashboard button press
        remove(currentPanel);
        switch (option) {
            case "home":
                currentPanel = new ReservationsPanel();
                break;
            case "reservation":
                currentPanel = new NewReserveRoomPanel();
                break;
                /*
            case "view":
                currentPanel = new ReserveRoomPanel();
                break;
            case "cancel":
                currentPanel = new ReserveRoomPanel();
                break;
            case "admin":
                currentPanel = new ReserveRoomPanel();
                break;
            default:
                currentPanel = new ReserveRoomPanel();
                break;  */
        }
        add(currentPanel, constraints);
        revalidate();
        repaint();
    }


}
