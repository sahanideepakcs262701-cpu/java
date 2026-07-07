package question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

interface Shape {
    void area();
    void perimeter();
}

class Rectangle implements Shape {
    int length, width;
    String result = "";

    Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    public void area() {
        result += "Area of Rectangle = " + (length * width) + "\n";
    }

    public void perimeter() {
        result += "Perimeter of Rectangle = " + (2 * (length + width)) + "\n";
    }

    public String getResult() {
        return result;
    }
}


class Circle implements Shape {
    int radius;
    String result = "";

    Circle(int r) {
        radius = r;
    }

    public void area() {
        result += "Area of Circle = " + (3.14 * radius * radius) + "\n";
    }

    public void perimeter() {
        result += "Circumference of Circle = " + (2 * 3.14 * radius) + "\n";
    }

    public String getResult() {
        return result;
    }
}


class Square implements Shape {
    int side;
    String result = "";

    Square(int s) {
        side = s;
    }

    public void area() {
        result += "Area of Square = " + (side * side) + "\n";
    }

    public void perimeter() {
        result += "Perimeter of Square = " + (4 * side) + "\n";
    }

    public String getResult() {
        return result;
    }
}


public class Question2 extends JFrame {

    JComboBox<String> shapeBox;
    JTextField first, second;
    JLabel label1, label2;
    JButton calculate;
    JTextArea output;


    Question2() {

        setTitle("Shape Calculator");
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        shapeBox = new JComboBox<>(
                new String[]{"Rectangle","Circle","Square"}
        );

        add(new JLabel("Select Shape:"));
        add(shapeBox);


        label1 = new JLabel("Length:");
        first = new JTextField(10);

        label2 = new JLabel("Width:");
        second = new JTextField(10);


        add(label1);
        add(first);
        add(label2);
        add(second);


        calculate = new JButton("Calculate");
        add(calculate);


        output = new JTextArea(10,30);
        add(new JScrollPane(output));


        // Shape change hone par fields change
        shapeBox.addActionListener(e -> {

            String shape = (String)shapeBox.getSelectedItem();

            if(shape.equals("Rectangle")) {

                label1.setText("Length:");
                label2.setText("Width:");
                label2.setVisible(true);
                second.setVisible(true);

            }
            else if(shape.equals("Circle")) {

                label1.setText("Radius:");
                label2.setVisible(false);
                second.setVisible(false);

            }
            else {

                label1.setText("Side:");
                label2.setVisible(false);
                second.setVisible(false);
            }

        });


        calculate.addActionListener(e -> {

            String shape = (String)shapeBox.getSelectedItem();

            if(shape.equals("Rectangle")) {

                int l = Integer.parseInt(first.getText());
                int w = Integer.parseInt(second.getText());

                Rectangle r = new Rectangle(l,w);
                r.area();
                r.perimeter();

                output.setText(r.getResult());

            }


            else if(shape.equals("Circle")) {

                int r = Integer.parseInt(first.getText());

                Circle c = new Circle(r);
                c.area();
                c.perimeter();

                output.setText(c.getResult());

            }


            else {

                int s = Integer.parseInt(first.getText());

                Square sq = new Square(s);
                sq.area();
                sq.perimeter();

                output.setText(sq.getResult());

            }

        });


        setVisible(true);
    }


    public static void main(String args[]) {
        new Question2();
    }
}