package ru.antongrutsin;

import com.sun.tools.javac.comp.Enter;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));

    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("Anton");
    private final JPasswordField tfPassword = new JPasswordField("12345");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final JList<String> userList = new JList<>();
    private final Logger logger = new Logger();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { // Event Dispatching Thread
                new ClientGUI();
            }
        });
    }

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUser = new JScrollPane(userList);
        String[] users = {"user1", "user2", "user3", "user4", "user5",
                "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users);
        log.setEditable(false);
        scrollUser.setPreferredSize(new Dimension(150, 0));
        cbAlwaysOnTop.addActionListener(this);
        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextToLog();
            }
        });
        btnSend.addActionListener(this);

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(scrollLog, BorderLayout.CENTER);
        add(scrollUser, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        }
        if (src == btnSend){
            addTextToLog();
        } else {
            throw new RuntimeException("Not found: " + e);
        }
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "Exception in " + t.getName() + " " +
                e.getClass().getCanonicalName() + ": " +
                e.getMessage() + "\n\t at " + ste[0];
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    public void addTextToLog(){
        if (isNotEmptyMessage()) {
            log.append(tfMessage.getText() + "\n");
            //логируем запись
            logger.writeLog(tfMessage.getText());
            tfMessage.setText("");
        }
    }

    public boolean isNotEmptyMessage(){
        return !tfMessage.getText().replaceAll(" ","").equals("");
    }
}
