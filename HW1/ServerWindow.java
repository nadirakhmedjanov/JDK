package HW1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    private static final int POS_X = 300;
    private static final int POS_Y = 400;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    private final JButton btnStart = createButton("Пуск", this::startServer);
    private final JButton btnStop = createButton("Стоп", this::stopServer);
    private final JTextArea logArea = new JTextArea();
    private final JLabel statusLabel = new JLabel("Сервер не запущен", SwingConstants.CENTER);
    private boolean isServerRunning;
    private final List<ClientGUI> clients = new ArrayList<>();
    private final List<String> chatHistory = new ArrayList<>();

    public ServerWindow() {
        WindowSet();
        setupComponents();
        setVisible(true);
    }

    private void WindowSet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Сервер");
        setLayout(new BorderLayout());
    }

    private void setupComponents() {
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setForeground(Color.BLUE);
        updateStatusLabel();

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);
    }

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }

    private void startServer(ActionEvent e) {
        if (isServerRunning) {
            showMessage("Сервер уже запущен", "Information");
        } else {
            isServerRunning = true;
            logMessage("Сервер запущен!" + isServerRunning);
            loadChatHistory();
            updateStatusLabel();
        }
    }

    private void stopServer(ActionEvent e) {
        if (!isServerRunning) {
            showMessage("Сервер не запущен!", "Error");
        } else {
            isServerRunning = false;
            logMessage("Сервер остановлен" + isServerRunning);
            updateStatusLabel();
        }
    }

    private void logMessage(String message) {
        logArea.append(message + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    private void updateStatusLabel() {
        statusLabel.setText(isServerRunning ? "Сервер запущен!" : "Сервер не запущен!");
    }

    public void addClient(ClientGUI client) {
        clients.add(client);
        sendChatHistory(client);
    }

    public void receiveMessage(String login, String message) {
        if (isServerRunning) {
            logMessage(login + ": " + message);
            chatHistory.add(login + ": " + message);
            clients.forEach(client -> client.appendLog(login + ": " + message));
            saveMessageToFile(login + ": " + message);
        }
    }

    private void sendChatHistory(ClientGUI client) {
        chatHistory.forEach(client::appendLog);
    }

    private void saveMessageToFile(String message) {
        try (FileWriter writer = new FileWriter("chat_log.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChatHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("chat_history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                chatHistory.add(line);
                logMessage(line);
            }
            clients.forEach(this::sendChatHistory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}