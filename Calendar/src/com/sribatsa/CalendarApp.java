package com.sribatsa;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;
import java.awt.image.*;
import java.awt.Toolkit;

public class CalendarApp {

    private static String[] quotes = {
            "The future belongs to those who believe",
            "in the beauty of their dreams.",
            "It does not matter how slowly you go as long",
            "as you do not stop.",
            "Success is not final, failure is not fatal:",
            "It is the courage to continue that counts.",
            "Don’t watch the clock; do what it does.",
            "Keep going.",
            "The only way to do great work is to love what you do.",
            "Believe in yourself and all that you are.",
            "Opportunities don't happen, you create them.",
            "Everything you can imagine is real.",
            "The best way to predict the future is to create it.",
            "The only limit to our realization of tomorrow",
            "is our doubts of today.",
            "You are never too old to set another goal",
            "or to dream a new dream.",
            "You don’t have to be great to start, but you",
            "have to start to be great.",
            "Dream big and dare to fail.",
            "Act as if what you do makes a difference. It does.",
            "Keep your face always toward the sunshine,",
            "and shadows will fall behind you.",
            "The harder you work for something, the greater",
            "you’ll feel when you achieve it.",
            "Do something today that your future self will thank you for.",
            "Little things make big days.",
            "The key to success is to focus on goals, not obstacles.",
            "Push yourself, because no one else is going to do it for you.",
            "Your limitation—it’s only your imagination.",
            "Great things never come from comfort zones.",
            "Dream it. Wish it. Do it.",
            "Sometimes later becomes never. Do it now.",
            "Success doesn’t just find you. You have to go out",
            "and get it.",
            "The way to get started is to quit talking and begin doing.",
            "Don't wait. The time will never be just right.",
            "Life is 10% what happens to us and 90% how we",
            "react to it.",
            "Happiness is not something ready-made. It comes",
            "from your own actions.",
            "If you want to achieve greatness stop asking for permission.",
            "Work hard in silence, let your success be your noise.",
            "Go as far as you can see; when you get there, you’ll",
            "be able to see farther.",
            "Success is what comes after you stop making excuses.",
            "Don’t wait for opportunity. Create it.",
            "Do what you can with all you have, wherever you are.",
            "Don’t be pushed around by the fears in your mind.",
            "Be led by the dreams in your heart.",
            "What lies behind us and what lies before us",
            "are tiny matters compared to what lies within us.",
            "It’s not about being the best. It’s about being",
            "better than you were yesterday.",
            "Don’t let what you cannot do interfere with",
            "what you can do.",
            "Success usually comes to those who are too busy",
            "to be looking for it.",
            "The secret of getting ahead is getting started.",
            "With the new day comes new strength and new thoughts.",
            "Life is short. Do stuff that matters.",
            "Perseverance is not a long race; it is many",
            "short races one after the other.",
            "Fall seven times, stand up eight.",
            "Don’t limit your challenges; challenge your limits.",
            "The journey of a thousand miles begins with",
            "a single step.",
            "Hardships often prepare ordinary people for",
            "an extraordinary destiny.",
            "You can’t cross the sea merely by standing",
            "and staring at the water.",
            "Don’t let yesterday take up too much of today.",
            "It always seems impossible until it’s done.",
            "What you get by achieving your goals is not",
            "as important as what you become by achieving",
            "your goals.",
            "Stay hungry, stay foolish.",
            "Do not wait to strike till the iron is hot, but",
            "make it hot by striking.",
            "I am not a product of my circumstances. I am",
            "a product of my decisions.",
            "When you have a dream, you’ve got to grab it",
            "and never let go.",
            "You don’t have to see the whole staircase,",
            "just take the first step.",
            "The only place where success comes before work",
            "is in the dictionary.",
            "Success is walking from failure to failure",
            "with no loss of enthusiasm.",
            "Don’t count the days. Make the days count.",
            "If you want to lift yourself up, lift up someone else.",
            "Opportunities don’t happen. You create them.",
            "Setting goals is the first step in turning",
            "the invisible into the visible.",
            "The only way to achieve the impossible is",
            "to believe it is possible.",
            "Your passion is waiting for your courage to catch up.",
            "Go confidently in the direction of your dreams.",
            "Live the life you have imagined.",
            "A goal without a plan is just a wish.",
            "In the middle of every difficulty lies opportunity.",
            "Failure will never overtake me if my determination",
            "to succeed is strong enough.",
            "Keep going. Everything you need will come to you",
            "at the perfect time.",
            "Believe you can and you’re halfway there.",
            "Doubt kills more dreams than failure ever will.",
            "Hustle until you no longer need to introduce yourself.",
            "Don’t stop when you’re tired. Stop when you’re done.",
            "The best view comes after the hardest climb.",
            "Learn as if you will live forever, live like",
            "you will die tomorrow.",
            "You define your own life. Don’t let other",
            "people write your script.",
            "You are enough just as you are.",
            "Success is the sum of small efforts, repeated",
            "day in and day out.",
            "Don’t be afraid to give up the good to go for the great.",
            "You are capable of amazing things.",
            "Limitations live only in our minds. But if we",
            "use our imaginations, our possibilities become",
            "limitless.",
            "Your time is limited, so don’t waste it living",
            "someone else’s life.",
            "Do the hard things until the hard things become easy."
    };



    public static void main(String[] args) {
        // Create main frame using JFrame (Swing)
        JFrame frame = new JFrame("Calendar Application");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for full screen display
        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);

        // Set the application icon (logo)
        ImageIcon icon = new ImageIcon("src/images/logo.png"); // Adjust path if necessary
        frame.setIconImage(icon.getImage()); // Set the icon for the application

        // Set background color of the frame
        frame.getContentPane().setBackground(new Color(0x3E, 0x58, 0x79)); // Set background color to #213555

        // Create Welcome Message with User Name
        JLabel welcomeLabel = new JLabel("Welcome back, Sribatsa !!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 40));
        welcomeLabel.setForeground(Color.WHITE);

        // Create Quote Label
        JLabel quoteLabel = new JLabel(getRandomQuote(), SwingConstants.CENTER);
        quoteLabel.setFont(new Font("Arial", Font.ITALIC, 20));  // Italics and smaller font
        quoteLabel.setForeground(Color.WHITE);

        // Create a JPanel to hold the welcome message and quote
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setOpaque(false); // Transparent panel
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomePanel.add(quoteLabel, BorderLayout.AFTER_LAST_LINE);

        // Create Progress Bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setString("Hang on please I am loading the Calendar...");
        progressBar.setStringPainted(true);

        // Add the welcome panel and progress bar to the frame
        frame.add(welcomePanel, BorderLayout.CENTER); // Center the welcome message and quote
        frame.add(progressBar, BorderLayout.SOUTH); // Progress bar at the bottom

        // Show the frame
        frame.setVisible(true);

        // Simulate a 4-second delay to display the calendar
        try {
            Thread.sleep(5000);  // 4-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Remove the welcome message, quote, and progress bar after 4 seconds
        frame.remove(welcomePanel);
        frame.remove(progressBar);

        // Create Calendar Panel and add it to the frame
        CalendarPanel calendarPanel = new CalendarPanel();
        frame.add(calendarPanel, BorderLayout.CENTER);  // Add calendar to the full screen

        // Revalidate and repaint the frame to update the UI
        frame.revalidate();
        frame.repaint();
    }

    // Get a random quote
    private static String getRandomQuote() {
        Random random = new Random();
        int index = random.nextInt(quotes.length);
        return quotes[index];
    }
}
