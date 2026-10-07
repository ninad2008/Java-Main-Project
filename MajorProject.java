
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MajorProject extends JFrame {

    JTextField idField, nameField, salaryField, yearsField;
    JComboBox<Integer> ratingBox;
    JTextArea reportArea;

    public MajorProject() {
        setTitle("Employee Bonus System");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Heading
        JLabel heading = new JLabel("EMPLOYEE BONUS SYSTEM");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);

        JPanel header = new JPanel();
        header.setBackground(new Color(41, 128, 185));
        header.add(heading);
        add(header, BorderLayout.NORTH);

        // Employee details form
        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        form.setBorder(new EmptyBorder(15, 20, 15, 20));

        idField = new JTextField();
        nameField = new JTextField();
        salaryField = new JTextField();
        yearsField = new JTextField();

        ratingBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        ratingBox.setSelectedIndex(4);

        form.add(new JLabel("Employee ID:"));
        form.add(idField);

        form.add(new JLabel("Employee Name:"));
        form.add(nameField);

        form.add(new JLabel("Salary (Rs.):"));
        form.add(salaryField);

        form.add(new JLabel("Years of Service:"));
        form.add(yearsField);

        form.add(new JLabel("Performance Rating:"));
        form.add(ratingBox);

        JButton calculateButton = new JButton("Calculate Bonus Report");
        JButton resetButton = new JButton("Reset Fields");

        form.add(calculateButton);
        form.add(resetButton);

        add(form, BorderLayout.CENTER);

        // Report area
        reportArea = new JTextArea(12, 40);
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JPanel output = new JPanel(new BorderLayout());
        output.setBorder(new EmptyBorder(0, 20, 20, 20));
        output.add(new JLabel("Bonus Report Output:"), BorderLayout.NORTH);
        output.add(new JScrollPane(reportArea), BorderLayout.CENTER);

        add(output, BorderLayout.SOUTH);

        // Button actions
        calculateButton.addActionListener(e -> calculateReport());
        resetButton.addActionListener(e -> resetFields());
    }

    // Returns bonus percentage based on rating
    static double getBonusPercentage(int rating) {
        switch (rating) {
            case 5: return 20;
            case 4: return 15;
            case 3: return 10;
            case 2: return 5;
            case 1: return 0;
            default: return -1;
        }
    }

    // Calculates bonus amount
    static double calculateBonus(double salary, double percentage) {
        return salary * percentage / 100;
    }

    // Checks employee eligibility
    static boolean checkEligibility(int years, int rating) {
        return years >= 2 && rating >= 3;
    }

    // Generates the bonus report
    private void calculateReport() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            double salary = Double.parseDouble(salaryField.getText().trim());
            int years = Integer.parseInt(yearsField.getText().trim());
            int rating = (Integer) ratingBox.getSelectedItem();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter employee name.");
                return;
            }

            double percentage = getBonusPercentage(rating);
            boolean eligible = checkEligibility(years, rating);

            double bonus = 0;

            if (eligible) {
                bonus = calculateBonus(salary, percentage);
            }

            double finalSalary = salary + bonus;

            reportArea.setText(
                    "========== BONUS REPORT ==========\n" +
                    "Employee ID        : " + id + "\n" +
                    "Employee Name      : " + name + "\n" +
                    String.format("Salary             : Rs. %.2f%n", salary) +
                    "Years of Service   : " + years + "\n" +
                    "Performance Rating : " + rating + "\n" +
                    String.format("Bonus Percentage   : %.1f%%%n",
                            eligible ? percentage : 0) +
                    String.format("Bonus Amount       : Rs. %.2f%n", bonus) +
                    String.format("Final Salary       : Rs. %.2f%n", finalSalary) +
                    "Eligibility        : " +
                    (eligible ? "Eligible" : "Not Eligible") + "\n" +
                    "=================================="
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for ID, Salary and Years of Service.");
        }
    }

    // Clears all fields
    private void resetFields() {
        idField.setText("");
        nameField.setText("");
        salaryField.setText("");
        yearsField.setText("");
        ratingBox.setSelectedIndex(4);
        reportArea.setText("");
    }

    public static void main(String[] args) {
        new MajorProject().setVisible(true);
    }
}

