package com.sribatsa;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

class CalendarPanel extends JPanel {
    private int currentMonth;
    private int currentYear;
    private String[][] daysGrid;
    private JComboBox<String> monthDropdown;
    private JComboBox<String> yearDropdown;
    private JLabel timeLabel;

    public CalendarPanel() {
        // Initialize current date
        Calendar now = Calendar.getInstance();
        currentMonth = now.get(Calendar.MONTH);
        currentYear = now.get(Calendar.YEAR);

        // Create dropdowns for month and year
        createDropdowns();

        // Generate the initial calendar grid
        generateCalendar();

        // Set layout for the calendar panel
        setLayout(new BorderLayout());

        // Add the dropdown panel at the top
        JPanel dropdownPanel = new JPanel();
        dropdownPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        dropdownPanel.add(monthDropdown);
        dropdownPanel.add(yearDropdown);

        add(dropdownPanel, BorderLayout.NORTH);

        // Create and add the calendar grid panel
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 7, 10, 10)); // Increase horizontal and vertical gap between cells
        add(gridPanel, BorderLayout.CENTER);

        // Create a time panel for the bottom-right corner
        JPanel timePanel = new JPanel(new BorderLayout());
        timeLabel = new JLabel("", JLabel.RIGHT);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        timeLabel.setForeground(new Color(62, 88, 121));
        timeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        updateTime(); // Initial time update
        timePanel.add(timeLabel, BorderLayout.EAST);
        add(timePanel, BorderLayout.SOUTH);

        // Start the timer to update the time dynamically
        startClock();

        displayCalendar();
    }

    // Create the dropdown menus
    private void createDropdowns() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        // Month dropdown
        monthDropdown = new JComboBox<>(months);
        monthDropdown.setSelectedIndex(currentMonth);
        styleDropdown(monthDropdown);
        monthDropdown.addActionListener(e -> updateCalendar(monthDropdown.getSelectedIndex(), currentYear));

        // Year dropdown
        int startYear = currentYear - 200;
        int endYear = currentYear + 200;
        String[] years = new String[endYear - startYear + 1];
        for (int i = 0; i < years.length; i++) {
            years[i] = Integer.toString(startYear + i);
        }
        yearDropdown = new JComboBox<>(years);
        yearDropdown.setSelectedItem(Integer.toString(currentYear));
        styleDropdown(yearDropdown);
        yearDropdown.addActionListener(e -> updateCalendar(currentMonth, Integer.parseInt((String) yearDropdown.getSelectedItem())));
    }

    // Style the dropdown to look like plain text
    private void styleDropdown(JComboBox<String> dropdown) {
        dropdown.setFont(new Font("Arial", Font.BOLD, 16));
        dropdown.setBackground(Color.WHITE);
        dropdown.setForeground(Color.BLACK);
        dropdown.setBorder(null);
        dropdown.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setFont(new Font("Arial", Font.BOLD, 16));
                if (isSelected) {
                    label.setBackground(new Color(62, 88, 121));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(Color.WHITE);
                    label.setForeground(Color.BLACK);
                }
                return label;
            }
        });
    }

    // Update the calendar when month or year is changed
    public void updateCalendar(int selectedMonth, int selectedYear) {
        currentMonth = selectedMonth;
        currentYear = selectedYear;
        generateCalendar();
        displayCalendar();
    }

    // Generate the calendar grid for the current month
    private void generateCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, currentMonth, 1);
        int firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0, Monday = 1, ..., Saturday = 6
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Create a 2D array to store the days of the month (week x day)
        daysGrid = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                daysGrid[i][j] = "";
            }
        }

        // Fill in the grid with actual day numbers
        int dayOfMonth = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = firstDayOfMonth; j < 7; j++) {
                if (dayOfMonth <= daysInMonth) {
                    daysGrid[i][j] = Integer.toString(dayOfMonth);
                    dayOfMonth++;
                    firstDayOfMonth = 0;
                }
            }
        }
    }

    // Display the calendar grid
    private void displayCalendar() {
        JPanel gridPanel = (JPanel) getComponent(1); // Get the grid panel
        gridPanel.removeAll();

        // Display the days of the week with larger font size and bold text
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setFont(new Font("Arial", Font.BOLD, 20));
            if (day.equals("Sun")) {
                dayLabel.setForeground(Color.RED);
            } else {
                dayLabel.setForeground(new Color(62, 88, 121));
            }
            gridPanel.add(dayLabel);
        }

        // Add the days grid with updated styles
        Calendar now = Calendar.getInstance();
        int today = now.get(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                JLabel dayLabel = new JLabel(daysGrid[i][j], JLabel.CENTER);
                dayLabel.setFont(new Font("Arial", Font.BOLD, 16));
                if (!daysGrid[i][j].isEmpty()) {
                    if (Integer.parseInt(daysGrid[i][j]) == today &&
                            currentMonth == now.get(Calendar.MONTH) &&
                            currentYear == now.get(Calendar.YEAR)) {
                        dayLabel.setBackground(new Color(62, 88, 121));
                        dayLabel.setOpaque(true);
                        dayLabel.setForeground(Color.WHITE);
                        dayLabel.setFont(new Font("Arial", Font.BOLD, 30));
                    } else {
                        dayLabel.setForeground(Color.BLACK);
                    }
                }
                gridPanel.add(dayLabel);
            }
        }

        // Revalidate and repaint to reflect changes
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    // Start a timer to update the time label every second
    private void startClock() {
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    // Update the time label with the current time
    private void updateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        timeLabel.setText(formatter.format(Calendar.getInstance().getTime()));
    }
}
