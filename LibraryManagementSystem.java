package librarymanagementsystem;

import java.awt.event;
import java.awt.*;
import javax.swing.*;

class LibraryManagementSystem1
{
    JFrame f;
    JLabel l1;
    JButton b1,b2;
    JMenuBar mb;
    JMenu m1;
    ImageIcon img;//image needs to be set on a label;
    
    public LibraryManagementSystem1()
    {
        f=new JFrame("LIBRARY MANAGEMENT SYSTEM");
  
        b1=new JButton("ADMIN");
        b2=new JButton("STUDENT");
        
        mb=new JMenuBar();
        
        m1=new JMenu();
                
        f.getContentPane().setLayout(null);
        
        b1.setBounds(550,250,250,80);
        b1.setFont(new Font("Arial",Font.PLAIN,40));
        f.add(b1);
        b2.setBounds(550,400,250,80);
        b2.setFont(new Font("Arial",Font.PLAIN,40));
        f.add(b2);
        
        
        img=new ImageIcon("Nipomo-Elementary-School-Library.jpg");
        l1=new JLabel("",img,JLabel.CENTER);//adding image on label;
        l1.setBounds(10,10,620,700);
        f.add(l1);
        
        mb.add(m1);
        
        f.getContentPane().setBackground(Color.PINK);
   
        
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
    }
    
    
}


public class LibraryManagementSystem 
{
    public static void main(String[] args) 
    {
               LibraryManagementSystem1 lms=new LibraryManagementSystem1();
    }
    
}
