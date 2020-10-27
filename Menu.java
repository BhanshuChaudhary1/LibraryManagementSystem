package librarianlogin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends IssueBook  implements ActionListener
{
    JFrame f1;
    JLabel l6;
    JButton b8,b9,b10,b11,b12,b19;
    
    public Menu()
    {
        f1=new JFrame();
        
        b8=new JButton("ISSUE BOOK");
        b9=new JButton("RETURN BOOK");
        b10=new JButton("ADD BOOK");
        b11=new JButton("LOST/DESTROYED BOOK");
        b12=new JButton("SEARCH BOOK");
        b19=new JButton("LOG OUT");
        
        f1.getContentPane().setLayout(null);
        
        b8.setBounds(570,100,300,50);
        b8.setFont(new Font("Arial",Font.PLAIN,20));
        b8.setForeground(Color.RED);
        f1.add(b8);
        b9.setBounds(570,200,300,50);
        b9.setForeground(Color.RED);
        b9.setFont(new Font("Arial",Font.PLAIN,20));
        f1.add(b9);
        b10.setBounds(570,300,300,50);
        b10.setFont(new Font("Arial",Font.PLAIN,20));
        b10.setForeground(Color.RED);
        f1.add(b10);
        b11.setBounds(570,400,300,50);
        b11.setFont(new Font("Arial",Font.PLAIN,20));
        b11.setForeground(Color.RED);
        f1.add(b11);
        b12.setBounds(570,500,300,50);
        b12.setFont(new Font("Arial",Font.PLAIN,20));
        b12.setForeground(Color.RED);
        f1.add(b12);
        b19.setBounds(570,600,300,50);
        b19.setForeground(Color.RED);
        b19.setFont(new Font("Arial",Font.PLAIN,20));
        f1.add(b19);

        ImageIcon img=new ImageIcon("C:\\Users\\Neha Ankur\\Desktop\\Duke_Humfrey's_Library_Interior_5,_Bodleian_Library,_Oxford,_UK_-_Diliff.jpg");
        l6=new JLabel("",img,JLabel.CENTER);//adding image on label;
        l6.setBounds(0,0,1325,700);
        f1.add(l6);
        
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        
        
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b19.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b8)
        {
            f1.setVisible(false);
            f.setVisible(true);
            IssueBook b=new IssueBook();
            
            
        }
        else if(e.getSource()==b9)
                {
                    f1.setVisible(false);
                    ReturnBook rb=new ReturnBook();
                    rb.f5.setVisible(true);
                    
                }  
        else if(e.getSource()==b10)
        {
            f1.setVisible(false);
            AddBook ab=new AddBook();
            ab.f4.setVisible(true);
        }
        else if(e.getSource()==b11)
        {
            f1.setVisible(false);
            LostBook ab=new LostBook();
            ab.f2.setVisible(true); 
        }
        else if(e.getSource()==b12)
        {
            f1.setVisible(false);
            SearchBook sb=new SearchBook();
            sb.f3.setVisible(true); 
        }
        else if(e.getSource()==b19)
        {
            f1.setVisible(false);
            LibrarianLogin lb=new LibrarianLogin();
            lb.f6.setVisible(true); 
        }
    }
}

class Menu1 
{
    public static void main(String[] args)
    {
         Menu m=new Menu();
         
    }
}
