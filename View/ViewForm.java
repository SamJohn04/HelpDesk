package HelpDesk.View;

import HelpDesk.Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.Color;
//import javax.swing.border.Border;

public class ViewForm {
    Request req;
    public ViewForm(Request req) {
        this.req = req;
        JFrame frame = new JFrame("HelpDesk Form");
        JLabel message = new JLabel("Help Desk Request: " + req.randId);       //heading
        message.setFont(new Font("Helvetica", Font.BOLD, 20));
        message.setBounds(150, 7, 300, 30);
        JButton back = new JButton("<");
        back.setBounds(50, 7, 50, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DashBoard();
            }
        });
        frame.add(back);
        JLabel nameLabel = new JLabel("Name");                       //Name
        nameLabel.setBounds(150, 60, 100, 30);
        JLabel nameField = new JLabel(req.userName);
        nameField.setBounds(240, 60, 200, 30);
        JLabel roll=new JLabel("Roll Number");                     //Roll number
        roll.setBounds(150, 110, 100, 30);
        JLabel rollField = new JLabel(req.userRollNum);
        rollField.setBounds(240, 110, 200, 30);
        JLabel branch=new JLabel("Branch");                      //Branch
        branch.setBounds(150, 160, 100, 30);
        JLabel branchf = new JLabel(req.userBranch);
        branchf.setBounds(240,160,200,30);
        JLabel batch=new JLabel("Batch");                         //Batch
        batch.setBounds(150, 210, 100, 30);
        JLabel batchField = new JLabel(""+req.userBatch);
        batchField.setBounds(240, 210, 200, 30);
        JLabel sem=new JLabel("Semester");                        //Sem
        sem.setBounds(150, 260, 100, 30);
        JLabel semField = new JLabel(req.userSem);
        semField.setBounds(240, 260, 200, 30);
        JLabel email=new JLabel("Email");                       // email
        email.setBounds(150, 310, 100, 30);
        JLabel emailField = new JLabel(req.userEmail);
        emailField.setBounds(240,310,200,30);
        JLabel subject=new JLabel("Request Title");            //Subject line
        subject.setBounds(150, 360, 100, 30);
        JLabel subjectField = new JLabel(req.requestTitle);
        subjectField.setBounds(240,360,200,30);
        JLabel describe=new JLabel("Description");              //Description
        describe.setBounds(150, 410, 100, 30);
        JTextArea desField = new JTextArea(req.requestDescription);
        desField.setBounds(240, 410, 200, 70);
        desField.enableInputMethods(false);
        /*Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        desField.setBorder(border);*/
        desField.setEditable(false);

        frame.add(message);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(roll);
        frame.add(rollField);
        frame.add(branch);
        frame.add(branchf);
        frame.add(batch);
        frame.add(batchField);
        frame.add(sem);
        frame.add(semField);
        frame.add(email);
        frame.add(emailField);
        frame.add(subject);
        frame.add(subjectField);
        frame.add(describe);
        frame.add(desField);
              

        frame.setBounds(500, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
