package librarianlogin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

class LostBook implements ActionListener
{
    JFrame f2;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4;
    JButton b13,b14;
    ImageIcon img3;
    
    public LostBook()
    {
        f2=new JFrame();
        
        l1=new JLabel("BOOK NAME");
        l2=new JLabel("BOOK ID");
        l3=new JLabel("STUDENT ID");
        l4=new JLabel("LOST DATE");
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        
        b13=new JButton("DELETE");
        b14=new JButton("BACK");
        
        f2.getContentPane().setLayout(null);
       
        
        l1.setBounds(500,100,300,30);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(Color.RED);
        f2.add(l1);
        t1.setBounds(750,100,300,30);
        f2.add(t1);
        l2.setBounds(500,200,300,30);
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(Color.RED);
        f2.add(l2);
        t2.setBounds(750,200,300,30);
        f2.add(t2);
        l3.setBounds(500,300,300,30);
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l3.setForeground(Color.RED);
        f2.add(l3);
        t3.setBounds(750,300,300,30);
        f2.add(t3);
        l4.setBounds(500,400,300,30);
        l4.setFont(new Font("Arial",Font.BOLD,30));
        l4.setForeground(Color.RED);
        f2.add(l4);
        t4.setBounds(750,400,300,30);
        f2.add(t4);
        b13.setBounds(450,500,300,30);
        b13.setFont(new Font("Arial",Font.BOLD,30));
        b13.setForeground(Color.RED);
        f2.add(b13);
        b14.setBounds(800,500,300,30);
        b14.setFont(new Font("Arial",Font.BOLD,30));
        b14.setForeground(Color.RED);
        f2.add(b14);
       
        img3=new ImageIcon("C:\\Users\\Neha Ankur\\Desktop\\java programme\\sxKcXz.jpg");
        l5=new JLabel("",img3,JLabel.CENTER);
        l5.setBounds(0,0,1335,700);
        f2.add(l5);
        
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f2.setVisible(true);
        
        b13.addActionListener(this);
        b14.addActionListener(this);
    }
    
     public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b13)
        {
            if(t1.getText().isEmpty()&&t2.getText().isEmpty()&&t3.getText().isEmpty()&&t4.getText().isEmpty())
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
                PreparedStatement ps=con.prepareStatement("delete from Book where Bookname=?");
                ps.setString(1, s1);
                int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(null,"SUCESSFULLY DELETED");
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
        else if(ee.getSource()==b14)
            {
                f2.setVisible(false);
                Menu m=new Menu();
                m.f1.setVisible(true);
            }
    }
}

class LostBook1 
{
    public static void  main(String[] arg)
    {
        LostBook lb=new LostBook();
    }
}
