package librarianlogin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class AddBook implements ActionListener
{
    JFrame f4;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3;
    JButton b17,b18;
    ImageIcon img2;
    
    public AddBook()
    {
        f4=new JFrame("ADD BOOK");
        l1=new JLabel("BOOK ID");
        l2=new JLabel("BOOK NAME");
        l3=new JLabel("BOOK AUTHOR");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        b17=new JButton("ADD");
        b18=new JButton("BACK");
        
        f4.getContentPane().setLayout(null);
       
        
        l1.setBounds(500,200,300,20);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(Color.RED);
        f4.add(l1);
        t1.setBounds(750,200,300,25);
        f4.add(t1);
        l2.setBounds(500,300,300,20);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.RED);
        f4.add(l2);
        t2.setBounds(750,300,300,25);
        f4.add(t2);
        l3.setBounds(500,400,300,20);
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l3.setForeground(Color.RED); 
        f4.add(l3);
        t3.setBounds(750,400,300,25);
        f4.add(t3);
        b17.setBounds(400,500,300,30);
        b17.setFont(new Font("Arial",Font.BOLD,30));
        b17.setForeground(Color.RED); 
        f4.add(b17);
        b18.setBounds(850,500,300,30);
        b18.setFont(new Font("Arial",Font.BOLD,30));
        b18.setForeground(Color.RED); 
        f4.add(b18);
        
        img2=new ImageIcon("C:\\Users\\Neha Ankur\\Desktop\\java programme\\Libraries-Reading-Wallpapers-books-to-read-28317155-2560-1600.jpg");
        l4=new JLabel("",img2,JLabel.CENTER);
        l4.setBounds(0,0,1335,700);
        f4.add(l4);
        
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f4.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f4.setVisible(true);
         
        b17.addActionListener(this);
        b18.addActionListener(this);   
    }
    
    public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b17)
        {
            if(t1.getText().isEmpty()&&t2.getText().isEmpty()&&t3.getText().isEmpty())
            {
             JOptionPane.showMessageDialog(null,"Field is empty");   
            }
            else
            {
            int s1=Integer.parseInt(t1.getText());
            String s2=t2.getText();
            String s3=t3.getText();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");//step 1:-loading the drive;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem","root","root");
                PreparedStatement ps=con.prepareStatement("insert into Book values(?,?,?)");
                ps.setInt(1,s1);
                ps.setString(2,s2);
                ps.setString(3,s3);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(null,"BOOK RECORD ADDED SUCCESSFULLY");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"NO RECORD ADDED");
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
        else if(ee.getSource()==b18)
            {
                f4.setVisible(false);
                Menu m=new Menu();
                m.f1.setVisible(true);
            }
    }
           
}

class AddBook1 
{
    public static void  main(String[] arg)
    {
        AddBook ab=new AddBook();
    }
}
