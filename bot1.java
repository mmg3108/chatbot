import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class bot1 extends JFrame implements ActionListener {
    static JTextArea chatArea;
    static JTextField inputField;
    static JButton sendButton;
    static JScrollPane scrollPane;
    static boolean getName = true;

    public bot1() {
        setTitle("Chatbot");
        setLayout(null);
        setSize(600, 400);
        setLocation(750, 50);
        getContentPane().setBackground(Color.black);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        chatArea.setBackground(Color.black);
        chatArea.setForeground(Color.white);

        scrollPane = new JScrollPane(chatArea); // Create a scroll pane for the chat area
        scrollPane.setBounds(10, 10, 570, 300); // Adjusted size
        add(scrollPane);

        chatArea.append("Chatbot: Hi there! What is your name?\n");

        inputField = new JTextField();
        inputField.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        inputField.setBackground(Color.white);
        inputField.setForeground(Color.black);
        inputField.setBounds(10, 320, 470, 30);
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });
        add(inputField);

        sendButton = new JButton("Send");
        sendButton.setForeground(Color.white);
        sendButton.setBounds(490, 320, 90, 30); // Adjusted size
        sendButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        sendButton.addActionListener(this);
        sendButton.setBackground(Color.blue);
        add(sendButton);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }
        });

        setVisible(true);
    }

    public void sendMessage() {
        String userMessage = inputField.getText().toLowerCase();
        chatArea.append("You: " + userMessage + "\n");
        inputField.setText("");

        if (getName) {
            chatArea.append("Chatbot: pleasure talking to you, " + userMessage + "!\n");
            chatArea.append("             I m here to help" + "\n" + "what is your complaint? \n");
            getName = false;
        } else {
            String response = getResponse(userMessage);
            chatArea.append("Chatbot: " + response + "\n");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            sendMessage();
        }
    }

    public String getResponse(String message) {

        String response;

        if (message.contains("hello") || message.contains("hi") || message.contains("hy")) {
            response = "Hi there! How can I assist you?";
        } else if (message.contains("how are you")) {
            response = "I'm just a chatbot, but I'm here to help!";
        } else if (message.contains("thank you")) {
            response = "You're welcome!";
        } else if (message.contains("what is your name? ")) {
            response = "Hello! I am just a chatbot";
        } else if (message.contains("date today") || message.contains("date") || message.contains("today")) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            String formattedDate = date.format(dateFormatter);
            response = formattedDate;
        } else if (message.contains("what is the current time?") || message.contains("time")) {
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
            String formattedTime = time.format(formatter);
            response = "The current time is: " + formattedTime;
        } else if (message.contains("bye") || message.contains("tata")) {
            response = "Goodbye! \nHave a great day";
        } else if (message.contains("good morning")) {
            response = "Good morning! Hope you have a great day!";
        } else if (message.contains("can you share your dealership id")) {
            response = "I'm sorry, I'm a virtual assistant and don't have a dealership ID.";
        } else if (message.contains("can i call you") || message.contains("mention your contact details")) {
            response = "You cannot call me but, \nYou can contact our customer care team at 9109979500 or email us at customercare@mechaniconclick.com.";
        } else if (message.contains("what kind of services you provide")) {
            response = "we are car dealer \n and recently coming into the automation sector.";
        } else if (message.contains("i have a complain to make") || message.contains("complain")) {
            response = "yes please tell me\nOtherwise you can contact our customer correspondant";
        } else if (message.contains("enquiry about moc product and service")) {
            response = "To enquire about MOC product and service,\nenter your product or service code " +
                    "\nif still find issue contact our customer care team at 9109979500 \nor email us at customercare@mechaniconclick.com.";
        } else if (message.contains("issue resolved") || message.contains("query resolved")) {
            response = "its honor serving you";
        } else if (message.contains("thank you")) {
            response = "its honor serving you";
        } else if (message.contains("i want to talk to your customer executive") || message.contains("i want to talk to your customer care")) {
            response = "Yes, you can talk to our customer care executive. Please call 9109979500.";
        } else if (message.contains("can you please add tell me your email and phone number")) {
            response = "You can reach us at 9109979500 or email us at customercare@mechaniconclick.com for further details.";
        } else if (message.contains("never mind") || message.contains("no problem")) {
            response = "sure no issue";
        } else {
            response = "I'm sorry, I don't understand that.";
        }

        return response;
    }


    private void showExitConfirmation() {
        int result = JOptionPane.showConfirmDialog(this, "Do you have any more queries?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {

        } else if (result == JOptionPane.NO_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new bot1();
    }
}
