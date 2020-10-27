package librarianlogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ReturnBook implements ActionListener
{
    JFrame f5;
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b5,b6;
    ImageIcon img1;
    
    public ReturnBook()
    {
        f5=new JFrame("RETURN BOOK");
        l1=new JLabel("STUDENT ID");
        l2=new JLabel("BOOK ID");
        t1=new JTextField();
        t2=new JTextField();
        b5=new JButton("RETURN");
        b6=new JButton("BACK");
        
        f5.getContentPane().setLayout(null);
        f5.getContentPane().setBackground(Color.PINK);
        
        l1.setBounds(500,200,200,20);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(Color.RED);
        f5.add(l1);
        t1.setBounds(650,200,300,25);
        f5.add(t1);
        l2.setBounds(500,300,200,20);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.RED);
        f5.add(l2);
        t2.setBounds(650,300,300,25);
        f5.add(t2);
        b5.setBounds(450,400,300,30);
        b5.setFont(new Font("Arial",Font.BOLD,30));
        b5.setForeground(Color.RED);
        f5.add(b5);
        b6.setBounds(850,400,300,30);
        b6.setFont(new Font("Arial",Font.BOLD,30));
        b6.setForeground(Color.RED);
        f5.add(b6);
        
        img1=new ImageIcon("C:\\Users\\Neha Ankur\\Desktop\\java programme\\Home-Office-Library-Ideas-15-1-Kindesign.jpg");
        l3=new JLabel("",img1,JLabel.CENTER);
        l3.setBounds(0,0,1335,700);
        f5.add(l3);
        
        f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f5.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f5.setVisible(true);
        
        b5.addActionListener(this);
        b6.addActionListener(this);
    }    
    public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b5)
        {
            if(t1.getText().isEmpty()&&t2.getText().isEmpty())
            {
             JOptionPane.showMessageDialog(null,"Field is empty");   
            }
            else
            {
            String s1=t1.getText();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");//step 1:-loading the drive;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem","root","root");
                PreparedStatement ps=con.prepareStatement("delete from IssueBook where Studentid=?");
                ps.setString(1, s1);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(null,"SUCESSFULLY RETURNED");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"NO RECORD FOUND ");
                }
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        }
        else if(ee.getSource()==b6)
            {
                f5.setVisible(false);
                Menu m=new Menu();
                m.f1.setVisible(true);
            }
    }
    
    
}
class ReturnBook1 
{
    public static void main(String[] args) 
    {
       ReturnBook r=new ReturnBook();   
    }
}
