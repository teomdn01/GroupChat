package group.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class SetupClient extends JFrame implements ActionListener {
    private final JTextField usernameField;
    private final JButton chooseUsernameButton;
    private final JPanel panel;

    /**
     * Chooses the username for the new client that wants to join the chat.
     */
    SetupClient() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 70);
        add(panel);

        usernameField = new JTextField();
        usernameField.setBounds(10, 10, 300, 40);
        usernameField.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        panel.add(usernameField);

        chooseUsernameButton = new JButton("Enter chat");
        chooseUsernameButton.setBounds(320, 10, 123, 40);

        chooseUsernameButton.addActionListener(this);
        panel.add(chooseUsernameButton);


        setSize(460, 100);
        this.setLocation(450, 70);
        this.setVisible(true);
    }

    /**
     * After choosing the username, creates a new Client entity and closes the current window
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (usernameField.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Username field cannot be empty!");
        else {
            try {
                Socket socket = new Socket("localhost", 1234);
                this.pause();
                Client client = new Client(socket, usernameField.getText());
                client.setWindowTitle(usernameField.getText());
                client.setVisible(true);
                dispose();
                client.listenToMessage(); //blocking method, works on a separate thread
                client.sendUsername();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void pause() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
