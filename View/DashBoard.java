package HelpDesk.View;
import javax.swing.*;
import HelpDesk.Controller.HelpDeskController;
import java.awt.*;
import java.awt.event.*;
import HelpDesk.Model.*;
public class DashBoard {
    public DashBoard(){
        JFrame f=new JFrame("Dashboard");
        JLabel heading = new JLabel("MAR BASELIOS SCHOOL OF ENGINEERING");       //heading
        heading.setFont(new Font("Helvetica", Font.BOLD, 20));
        heading.setBounds(85, 20, 500, 30);
        JLabel err = new JLabel();
        err.setBounds(150, 270, 300, 50);
        JButton view=new JButton("NEW REQUEST");
        
        JTextField vt = new JTextField();
        f.add(vt);
        
        JButton neww=new JButton("VIEW REQUEST");
        // vt.setBounds(150,100,300,40);
        // view.setBounds(150,150,140,50);
        // neww.setBounds(310,150,140,50);
        //f.setSize(600,350);
        //f.setBounds(500, 100, 600, 350);
       
        vt.setBounds(150,100,300,40);                  //one type of ui
        view.setBounds(150,210,300,50);
        neww.setBounds(150,150,300,50);
        f.setBounds(500, 100, 600, 370);
        f.setSize(600,370);
        
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.dispose();
                new Form();
            }
        });

        neww.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String id = vt.getText().trim();
                    Request r = HelpDeskController.helpDeskController.getRequestById(id);
                    if(r == null)
                        throw new Exception();
                    f.dispose();
                    new ViewForm(r);
                }
                catch(Exception ex) {
                    err.setText("NOT FOUND");
                };
            }
        });

        f.add(err);
        f.add(heading);
        f.add(view);
        f.add(neww);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
