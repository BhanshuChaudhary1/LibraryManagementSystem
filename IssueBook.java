package librarianlogin;

import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class IssueBook  implements ActionListener
        
{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    JButton b3,b4;
    JMenuBar mb;
    JMenu m1;
    LocalDate d;
    ImageIcon img;
   
    
    public IssueBook()
    {
        f=new JFrame("ISSUE BOOKS");
        
        l1=new JLabel("STUDENT ID");
        l2=new JLabel("BOOK ID");
        l3=new JLabel("BOOK NAME");
        l4=new JLabel("ISSUE DATE");
        l5=new JLabel("RETURN DATE");
        l6=new JLabel();
          
          t1=new JTextField(10);
          t2=new JTextField(10);
          t3=new JTextField(50);
          t4=new JTextField(20);
          
          b3=new JButton("ISSUE");
          b4=new JButton("BACK");
          
          mb=new JMenuBar();
          
          m1=new JMenu();
          
          f.getContentPane().setLayout(null);
          f.getContentPane().setBackground(Color.LIGHT_GRAY);
          
          f.setJMenuBar(mb);
          
          l1.setBounds(500,100,200,20);
          l1.setFont(new Font("Arial",Font.BOLD,20));
          l1.setForeground(Color.RED);
          f.add(l1);
          t1.setBounds(670,100,200,25);
          f.add(t1);
          l2.setBounds(500,200,200,40);
          l2.setFont(new Font("Arial",Font.BOLD,20));
          l2.setForeground(Color.RED);
          f.add(l2);
          t2.setBounds(670,200,200,25);
          f.add(t2);
          l3.setBounds(500,300,200,40);
          l3.setFont(new Font("Arial",Font.BOLD,20));
          l3.setForeground(Color.RED);
          f.add(l3);
          t3.setBounds(670,300,200,25);
          f.add(t3);
          l4.setBounds(500,400,200,30);
          l4.setFont(new Font("Arial",Font.BOLD,20));
          l4.setForeground(Color.RED);
          f.add(l4);
          t4.setBounds(670,400,200,25);
          f.add(t4);
          b3.setBounds(550,500,200,40);
          b3.setFont(new Font("Arial",Font.BOLD,20));
          b3.setForeground(Color.RED);
          f.add(b3);
          b4.setBounds(800,500,200,40);
          b4.setFont(new Font("Arial",Font.BOLD,20));
          b4.setForeground(Color.RED);
          f.add(b4);
          
          img=new ImageIcon("C:\\Users\\Neha Ankur\\Desktop\\library.jpg");
          l6=new JLabel("",img,JLabel.CENTER);//adding image on label;
          l6.setBounds(0,0,1325,700);
          f.add(l6);
          
          f.setExtendedState(JFrame.MAXIMIZED_BOTH);
          f.setVisible(true);
          
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
          b3.addActionListener(this);
          b4.addActionListener(this);
          
    }
     public void actionPerformed(ActionEvent e)
          {
                if(e.getSource()==b3)
                {
                if(t1.getText().isEmpty()&&t2.getText().isEmpty()&&t3.getText().isEmpty()&&t4.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Field is empty");   
                }
                else
                {
                int s1=Integer.parseInt(t1.getText());
                int s2=Integer.parseInt(t2.getText());
                String s3=t3.getText();
                String s4=t4.getText();
                
                try
                {
                Class.forName("com.mysql.jdbc.Driver");//step 1:-loading the drive;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem","root","root");
                PreparedStatement ps=con.prepareStatement("insert into IssueBook  values(?,?,?,?)");
                ps.setInt(1,s1);
                ps.setInt(2,s2);
                ps.setString(3,s3);
                ps.setString(4,s4);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    d=LocalDate.now();
                    Calendar cal=new GregorianCalendar(2018,07,15);
                    cal.add(Calendar.DAY_OF_MONTH, 15);
                    JOptionPane.showMessageDialog(null,"BOOK ISSUED SUCCESSFULLY ON  "+d);
                    JOptionPane.showMessageDialog(null,"RETURN DATE IS  "+cal.getTime());
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"NO BOOK ISSUED");
                }
                ps.close();
                con.close();
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            }
            }
            else if(e.getSource()==b4)
            {
              f.setVisible(false);
              Menu m=new Menu();
              m.f1.setVisible(true);
            }
          }
}

class Book 
{
    public static void main(String[] args) throws Exception 
    {
        IssueBook b=new IssueBook();
    }
}
