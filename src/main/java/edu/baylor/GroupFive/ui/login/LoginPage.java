package edu.baylor.GroupFive.ui.login;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.*;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.baylor.GroupFive.ui.utils.Page;
import edu.baylor.GroupFive.ui.utils.interfaces.InputDelegate;

public class LoginPage extends JFrame implements InputDelegate {

    private JPanel background;
    private JPanel surface;
    private String username;
    private String password;

    public LoginPage() {
        super();

        // Init new frame
        createFrame();

        // Set the frame to be visible
        setVisible(true);

        // Create the surface panel
        surface = new LandingPanel(this);

        // Add the surface panel to the frame
        add(surface);
    }

    public void createFrame() {
        try {
            // Load the background image
            final BufferedImage img = ImageIO.read(getClass().getResource("/landing-background.png"));

            // Create a panel that will display the image
            background = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the image scaled to fit the panel
                    g.drawImage(img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
                }
            };

            // Set the layout manager of the panel
            background.setLayout(new BorderLayout());

            // Set the panel as the content pane of the frame
            setContentPane(background);

        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    public void onPageSwitch(String option) {
        
        // Switch to the login page
        if (option.equals("login")) {

            //Replace surface panel with login panel
            remove(surface);
            surface = new LoginPanel(this);
            add(surface);
            revalidate();
            repaint();

        } else if (option.equals("createAccount")) {
            // TODO: Switch to the create account panel
        
        } else if (option.equals("success")) {
            dispose();

            @SuppressWarnings("unused")
            Page page = new Page(username);

        } else {
            System.out.println("Invalid option");
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
