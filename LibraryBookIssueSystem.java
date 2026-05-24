/*Respectfully submitted. Mam I did not have any group member left to collaborate with me, 
I have worked on this assignment independently.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class EmptyFieldException extends Exception {
    EmptyFieldException(String msg) {
        super(msg);
    }
}
class InvalidRollNumberException extends Exception {
    InvalidRollNumberException(String msg) {
        super(msg);
    }
}
class InvalidDateException extends Exception {
    InvalidDateException(String msg) {
        super(msg);
    }
}
class NullSelectionException extends Exception {
    NullSelectionException(String msg) {
        super(msg);
    }
}
public class LibraryBookIssueSystem extends JFrame implements ActionListener {
    JTextField txtName, txtRoll, txtBook, txtIssueDate, txtReturnDate;
    JTextArea txtRemarks;
    JComboBox<String> cmbCategory;
    JRadioButton rbNew, rbOld;
    ButtonGroup grpEdition;
    JButton btnIssue, btnReset, btnExit;
    public LibraryBookIssueSystem() {
        setTitle("Library Book Issue System");
        setSize(560, 740);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(79, 70, 229));
        headerPanel.setPreferredSize(new Dimension(560, 85));
        headerPanel.setLayout(null);
        JLabel titleLbl = new JLabel("Library Book Issue System");
        titleLbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setBounds(30, 25, 400, 32);
        headerPanel.add(titleLbl);
        add(headerPanel, BorderLayout.NORTH);
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBackground(new Color(15, 23, 42));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 20, 20));
        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(30, 41, 59));
        formPanel.setLayout(null);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(51, 65, 85)));
        JLabel l1 = new JLabel("Student Name");
        l1.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l1.setForeground(new Color(148, 163, 184));
        l1.setBounds(30, 30, 140, 30);
        formPanel.add(l1);
        txtName = new JTextField();
        txtName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtName.setBackground(new Color(15, 23, 42));
        txtName.setForeground(new Color(241, 245, 249));
        txtName.setBounds(170, 30, 320, 32);
        txtName.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(51, 65, 85)),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        formPanel.add(txtName);
        JLabel l2 = new JLabel("Roll Number");
        l2.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l2.setForeground(new Color(148, 163, 184));
        l2.setBounds(30, 78, 140, 30);
        formPanel.add(l2);
        txtRoll = new JTextField();
        txtRoll.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtRoll.setBackground(new Color(15, 23, 42));
        txtRoll.setForeground(new Color(241, 245, 249));
        txtRoll.setBounds(170, 78, 320, 32);
        txtRoll.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(51, 65, 85)),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        formPanel.add(txtRoll);
        JLabel l3 = new JLabel("Book Title");
        l3.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l3.setForeground(new Color(148, 163, 184));
        l3.setBounds(30, 126, 140, 30);
        formPanel.add(l3);
        txtBook = new JTextField();
        txtBook.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtBook.setBackground(new Color(15, 23, 42));
        txtBook.setForeground(new Color(241, 245, 249));
        txtBook.setBounds(170, 126, 320, 32);
        txtBook.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(51, 65, 85)),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        formPanel.add(txtBook);
        JLabel l4 = new JLabel("Book Category");
        l4.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l4.setForeground(new Color(148, 163, 184));
        l4.setBounds(30, 174, 140, 30);
        formPanel.add(l4);
        String[] cats = {"-- Select Category --", "Programming", "AI", "Databases",
                "Networking"};
        cmbCategory = new JComboBox<>(cats);
        cmbCategory.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cmbCategory.setBackground(new Color(15, 23, 42));
        cmbCategory.setForeground(new Color(241, 245, 249));
        cmbCategory.setBounds(170, 174, 320, 32);
        cmbCategory.setBorder(BorderFactory.createLineBorder(new Color(51, 65, 85)));
        formPanel.add(cmbCategory);
        JLabel l5 = new JLabel("Book Type");
        l5.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l5.setForeground(new Color(148, 163, 184));
        l5.setBounds(30, 222, 140, 30);
        formPanel.add(l5);
        rbNew = new JRadioButton("New Edition");
        rbOld = new JRadioButton("Old Edition");
        rbNew.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbOld.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbNew.setForeground(new Color(241, 245, 249));
        rbOld.setForeground(new Color(241, 245, 249));
        rbNew.setOpaque(false);
        rbOld.setOpaque(false);
        rbNew.setSelected(true);
        rbNew.setBounds(170, 222, 110, 30);
        rbOld.setBounds(290, 222, 110, 30);
        grpEdition = new ButtonGroup();
        grpEdition.add(rbNew);
        grpEdition.add(rbOld);
        formPanel.add(rbNew);
        formPanel.add(rbOld);
        JLabel l6 = new JLabel("Issue Date");
        l6.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l6.setForeground(new Color(148, 163, 184));
        l6.setBounds(30, 270, 140, 30);
        formPanel.add(l6);
        txtIssueDate = new JTextField();
        txtIssueDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtIssueDate.setBackground(new Color(15, 23, 42));
        txtIssueDate.setForeground(new Color(241, 245, 249));
        txtIssueDate.setBounds(170, 270, 320, 32);
        txtIssueDate.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(51, 65, 85)),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        formPanel.add(txtIssueDate);
        JLabel l7 = new JLabel("Return Date");
        l7.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l7.setForeground(new Color(148, 163, 184));
        l7.setBounds(30, 318, 140, 30);
        formPanel.add(l7);
        txtReturnDate = new JTextField();
        txtReturnDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtReturnDate.setBackground(new Color(15, 23, 42));
        txtReturnDate.setForeground(new Color(241, 245, 249));
        txtReturnDate.setBounds(170, 318, 320, 32);
        txtReturnDate.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(51, 65, 85)),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        formPanel.add(txtReturnDate);
        JLabel l8 = new JLabel("Remarks");
        l8.setFont(new Font("Segoe UI", Font.BOLD, 13));
        l8.setForeground(new Color(148, 163, 184));
        l8.setBounds(30, 366, 140, 30);
        formPanel.add(l8);
        txtRemarks = new JTextArea();
        txtRemarks.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtRemarks.setBackground(new Color(15, 23, 42));
        txtRemarks.setForeground(new Color(241, 245, 249));
        txtRemarks.setLineWrap(true);
        JScrollPane sp = new JScrollPane(txtRemarks);
        sp.setBounds(170, 366, 320, 60);
        sp.setBorder(BorderFactory.createLineBorder(new Color(51, 65, 85)));
        formPanel.add(sp);
        btnIssue = new JButton("Issue Book") {
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        btnIssue.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIssue.setBackground(new Color(16, 185, 129));
        btnIssue.setForeground(Color.WHITE);
        btnIssue.setFocusPainted(false);
        btnIssue.setBorderPainted(false);
        btnIssue.setContentAreaFilled(false);
        btnIssue.setBounds(40, 451, 145, 38);
        btnIssue.addActionListener(this);
        formPanel.add(btnIssue);
        btnReset = new JButton("Reset") {
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnReset.setBackground(new Color(245, 158, 11));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setBorderPainted(false);
        btnReset.setContentAreaFilled(false);
        btnReset.setBounds(200, 451, 145, 38);
        btnReset.addActionListener(this);
        formPanel.add(btnReset);
        btnExit = new JButton("Exit") {
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnExit.setBackground(new Color(244, 63, 94));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBounds(360, 451, 145, 38);
        btnExit.addActionListener(this);
        formPanel.add(btnExit);
        outerPanel.add(formPanel, BorderLayout.CENTER);
        add(outerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIssue) {
            try {
                String name = txtName.getText().trim();
                String roll = txtRoll.getText().trim();
                String book = txtBook.getText().trim();
                String cat = (String) cmbCategory.getSelectedItem();
                String issueDate = txtIssueDate.getText().trim();
                String returnDate = txtReturnDate.getText().trim();
                String remarks = txtRemarks.getText().trim();
                String type = rbNew.isSelected() ? "New Edition" : "Old Edition";
                if(name.isEmpty() || roll.isEmpty() || book.isEmpty() || issueDate.isEmpty() || returnDate.isEmpty()) {
                    throw new EmptyFieldException("Please fill all required fields!");
                }
                for(int i = 0; i < roll.length(); i++) {
                    char ch = roll.charAt(i);
                    if(!Character.isDigit(ch)) {
                        throw new InvalidRollNumberException("Roll Number should contain only digits!");
                    }
                }
                int rollNumber = Integer.parseInt(roll);
                if(cat.equals("-- Select Category --")) {
                    throw new NullSelectionException("Please select a Book Category!");
                }
                if(!rbNew.isSelected() && !rbOld.isSelected()) {
                    throw new NullSelectionException("Please select a Book Type!");
                }
                String[] issueParts = issueDate.split("/");
                String[] returnParts = returnDate.split("/");
                if(issueParts.length != 3 || returnParts.length != 3) {
                    throw new InvalidDateException("Date format should be dd/MM/yyyy!");
                }
                int issueDay = Integer.parseInt(issueParts[0]);
                int issueMonth = Integer.parseInt(issueParts[1]);
                int issueYear = Integer.parseInt(issueParts[2]);
                int returnDay = Integer.parseInt(returnParts[0]);
                int returnMonth = Integer.parseInt(returnParts[1]);
                int returnYear = Integer.parseInt(returnParts[2]);
                if(returnYear < issueYear) {
                    throw new InvalidDateException("Return Date cannot be before Issue Date!");
                }
                if(returnYear == issueYear && returnMonth < issueMonth) {
                    throw new InvalidDateException("Return Date cannot be before Issue Date!");
                }
                if(returnYear == issueYear && returnMonth == issueMonth && returnDay < issueDay) {
                    throw new InvalidDateException("Return Date cannot be before Issue Date!");
                }
                String msg = "=====Book Issued Successfully!=====\n\n"
                        + "Student Name: " + name + "\n"
                        + "Roll Number: " + roll + "\n"
                        + "Book Title: " + book + "\n"
                        + "Category: " + cat + "\n"
                        + "Book Type: " + type + "\n"
                        + "Issue Date: " + issueDate + "\n"
                        + "Return Date: " + returnDate + "\n"
                        + "Remarks: " + remarks;
                JOptionPane.showMessageDialog(this, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(msg);
            } catch(EmptyFieldException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            } catch(InvalidRollNumberException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format in input!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(NullSelectionException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            } catch(InvalidDateException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                System.out.println("Operation Completed");
                JOptionPane.showMessageDialog(this, "Operation Completed", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(e.getSource() == btnReset) {
            txtName.setText(""); txtRoll.setText(""); txtBook.setText("");
            txtIssueDate.setText(""); txtReturnDate.setText("");
            txtRemarks.setText("");
            cmbCategory.setSelectedIndex(0);
            rbNew.setSelected(true);
        }
        else if(e.getSource() == btnExit) {
            int ch = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if(ch == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
    public static void main(String[] args) {
        new LibraryBookIssueSystem();
    }
}