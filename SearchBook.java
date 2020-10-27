package librarianlogin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

class SearchBook implements ActionListener
{
    JFrame f3;
    JLabel l1,l2;
    JTextField t1;
    JButton b15,b16;
    ImageIcon img4;
    
    public SearchBook()
    {
        f3=new JFrame();
        l1=new JLabel("SEARCH BOOK");
        t1=new JTextField();
        b15=new JButton("SEARCH");
        b16=new JButton("BACK");
        
        f3.getContentPane().setLayout(null);
        
        l1.setBounds(500,300,300,30);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(Color.RED);
        f3.add(l1);
        t1.setBounds(750,300,300,30);
        f3.add(t1);
        b15.setBounds(450,400,300,30);
        b15.setFont(new Font("Arial",Font.BOLD,30));
        b15.setForeground(Color.RED);
        f3.add(b15);
        b16.setBounds(800,400,300,30);
        b16.setFont(new Font("Arial",Font.BOLD,30));
        b16.setForeground(Color.RED);
        f3.add(b16);
        
        img4=new ImageIcon("C:\\Users\\Neha Ankur\\Desktop\\java programme\\Holy_Bible4KXI.jpg");
        l2=new JLabel("",img4,JLabel.CENTER);
        l2.setBounds(0,0,1335,700);
        f3.add(l2);
        
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f3.setVisible(true);
        
        b15.addActionListener(this);
        b16.addActionListener(this);
    }
    
     public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b15)
        {
            String s1=t1.getText();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");//step 1:-loading the drive;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem","root","root");
                PreparedStatement ps=con.prepareStatement("select * from Book where Bookname=?");
                ps.setString(1, s1);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                  
                  String s2=rs.getString("BookName");
                  String s3=rs.getString("BookAuthor");
  
                  JOptionPane.showMessageDialog(null,s2+"   "+s3);
                 
                  }
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            if(t1.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Field is empty");
            }
        }
        else if(ee.getSource()==b16)
            {
                f3.setVisible(false);
                Menu m=new Menu();
                m.f1.setVisible(true);
            }

    }

    private Object JOptionPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class SearchBook1 
{
    public static void  main(String[] arg)
    {
        SearchBook sb=new SearchBook();
    }
}
