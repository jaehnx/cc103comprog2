package jinjiriin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.print.PrinterJob;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import org.w3c.dom.events.MouseEvent;

public class notepad extends JFrame{
    JTextArea textArea = new JTextArea();
    

    JMenuBar menuBar = new JMenuBar();
    



    JMenu menufile = new JMenu("File");
    JMenuItem itemfile = new JMenuItem("New file");
    JMenuItem itemfile2 = new JMenuItem("New Window");
    JMenuItem itemfile3 = new JMenuItem("New Open");
   
    JMenuItem itemfile4 = new JMenuItem("Save");
    JMenuItem itemfile5 = new JMenuItem("Save as");
    JMenuItem itemfile6 = new JMenuItem("Save all");
    JMenuItem itemfile7 = new JMenuItem("Page setup");
    JMenuItem itemfile8 = new JMenuItem("Print");
    JMenuItem itemfile9 = new JMenuItem("Cloes file");
    JMenuItem itemfile10 = new JMenuItem("Close Window");
    JMenuItem itemExit = new JMenuItem("Exit");




    JMenu menuEdit = new JMenu("Edit");
    JMenuItem menuEdit1 = new JMenuItem("Undo");
    JMenuItem menuEdit2 = new JMenuItem("Cut");
    JMenuItem menuEdit3  = new JMenuItem("Copy");
    JMenuItem menuEdit4  = new JMenuItem("Paste");
    JMenuItem menuEdit5 = new JMenuItem("Delete");

    JMenuItem menuEdit7 = new JMenuItem("Find");
    JMenuItem menuEdit8 = new JMenuItem("Find Next");
    JMenuItem menuEdit9 = new JMenuItem("Fuind Previous");
    JMenuItem menuEdit10 = new JMenuItem("Go to");
    JMenuItem menuEdit11 = new JMenuItem("Select all");
    JMenuItem menuEdit12 = new JMenuItem("Time/Date");
    JMenuItem menuEdit13 = new JMenuItem("Font");



   
    JMenu menuView = new JMenu("View");
    JMenu veiw = new JMenu("Zoom");
    JMenuItem veiw2 = new JMenuItem("Zoom in");
    JMenuItem veiw3 = new JMenuItem("Zoom out");
    JMenuItem veiw4 = new JMenuItem("Restore defult Zoom");
    JMenu veiw5 = new JMenu("Status bar");
    JMenuItem veiw6 = new JMenuItem("Word wrap");


    
    JLabel lavel1 = new JLabel("Lxt1");
    JLabel lavel2 = new JLabel("Made by: NJP");
    JLabel lavel3 = new JLabel("100%");
    JLabel lavel4 = new JLabel("Window");
    JLabel lavel5 = new JLabel("UTF-6");
    JPanel footerplanel = new JPanel();


 
 public notepad(){
    setTitle("Notepad");  
    setSize(500,400);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  



    itemfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); //
       
    itemfile.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to save changes?",
                    "Create New File",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );


            if (response == JOptionPane.YES_OPTION) {
                textArea.setText("");
            }
        }
    });

        menufile.add(itemfile);
        itemfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File myObj = new File("filename.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        textArea.append(data + "\n");
                    }
                    myReader.close();
                } catch (FileNotFoundException fnfe) {
                    System.out.println("An error occurred.");
                    fnfe.printStackTrace();
                }
            }
        });
        menufile.add(itemfile2);
        itemfile2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK)); //
        itemfile2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notepad newNotepad = new notepad();
                newNotepad.setVisible(true);
            }
        });
        menufile.add(itemfile3);
          
        itemfile3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        itemfile3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        Scanner myReader = new Scanner(selectedFile);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            textArea.append(data + "\n");
                        }
                        myReader.close();
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("An error occurred.");
                        fnfe.printStackTrace();
                    }
                }
            }
        });

        
        menufile.add(itemfile4);
        itemfile4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        itemfile4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                          
                        FileWriter writer = new FileWriter(fileToSave);
                        writer.write(textArea.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(null, "File saved successfully");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        menufile.add(itemfile5);
        itemfile5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        itemfile5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(fileToSave);
                        writer.write(textArea.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(null, "File saved successfully");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        menufile.add(itemfile6); 
        itemfile6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK));
        itemfile6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(fileToSave);
                        writer.write(textArea.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(null, "All files saved successfully");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        menufile.addSeparator();

        menufile.add(itemfile7);
         
        menufile.add(itemfile8);
        itemfile8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        itemfile8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                if (job.printDialog()) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        System.err.println("Error printing: " + ex.getMessage());
                    }
                }
            }
        });

        menufile.addSeparator();
        menufile.add(itemfile9);
        itemfile9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        menufile.add(itemfile10);
        itemfile10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        menufile.add(itemExit);
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exit();
            }
              

            private void Exit() {
                int response = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        menuBar.add(menufile);



      
        menuBar.add(menuEdit);
        menuEdit.add(menuEdit1);
        menuEdit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((UndoableEdit) textArea).undo();
            }
        });
     
        menuEdit.add(menuEdit2);
        menuEdit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.cut();

            }
        });
        menuEdit.add(menuEdit3);
        menuEdit3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
              
            }
        });
        menuEdit.add(menuEdit4);
        menuEdit4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
              
            }
        });
        menuEdit.add(menuEdit5);
        menuEdit.addSeparator();
        menuEdit.add(menuEdit7);
        menuEdit.add(menuEdit8);
        menuEdit.add(menuEdit9);
        menuEdit.add(menuEdit10);
        menuEdit.addSeparator();
        menuEdit.add(menuEdit11);
        menuEdit.add(menuEdit12);
        menuEdit.add(menuEdit13);
        
        menuView.add(veiw);
        veiw.add(veiw2);
        veiw2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
        veiw2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea.getFont().getSize()+1)); 
            }
        });
        veiw.add(veiw3);
        veiw3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
        veiw3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea.getFont().getSize()-1));
            }
        });
         

        textArea.addMouseWheelListener(new MouseWheelListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getModifiers() == MouseEvent.AT_TARGET) {
                    if (e.getWheelRotation() < 0) {
                        textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea.getFont().getSize()+1)); 
                    } else {
                        textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea.getFont().getSize()-1));
                    }
                }
            }
        });
        veiw4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), 12));
            }
        });
        veiw.add(veiw4);
        menuView.add(veiw5);
          

        menuView.add(veiw6);
    
       
        menuBar.add(menuView);
       
        setJMenuBar(menuBar);




        footerplanel.add(lavel1);
        footerplanel.add(lavel2);
        footerplanel.add(lavel3);
        footerplanel.add(lavel4);
         

        getContentPane().add(textArea);
        getContentPane().add(footerplanel, BorderLayout.PAGE_END);
    }
   
    
   
}
