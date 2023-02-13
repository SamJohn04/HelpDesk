package HelpDesk.View;

import HelpDesk.Controller.HelpDeskController;
import HelpDesk.Model.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.Border;

public class Form {
    public Form()
    {
        JFrame frame = new JFrame("HelpDesk Form");
        JLabel message = new JLabel("Help Desk Request Form");       //heading
        message.setFont(new Font("Helvetica", Font.BOLD, 20));
        message.setBounds(150, 20, 300, 30);
        JLabel nameLabel = new JLabel("Name");                       //Name
        nameLabel.setBounds(150, 70, 100, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(240, 70, 200, 30);
        JLabel roll=new JLabel("Roll Number");                     //Roll number
        roll.setBounds(150, 120, 100, 30);
        JTextField rollField = new JTextField();
        rollField.setBounds(240, 120, 200, 30);
        JLabel branch=new JLabel("Branch");                      //Branch
        branch.setBounds(150, 170, 100, 30);
        JTextField branchf = new JTextField();
        branchf.setBounds(240,170,200,30);
        JLabel batch=new JLabel("Batch");                         //Batch
        batch.setBounds(150, 220, 100, 30);
        JTextField batchField = new JTextField();
        batchField.setBounds(240, 220, 200, 30);
        JLabel sem=new JLabel("Semester");                        //Sem
        sem.setBounds(150, 270, 100, 30);
        JTextField semField = new JTextField();
        semField.setBounds(240, 270, 200, 30);
        JLabel email=new JLabel("Email");                       // email
        email.setBounds(150, 320, 100, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(240,320,200,30);
        JLabel subject=new JLabel("Request Title");            //Subject line
        subject.setBounds(150, 370, 100, 30);
        JTextField subjectField = new JTextField();
        subjectField.setBounds(240,370,200,30);
        JLabel describe=new JLabel("Description");              //Description
        describe.setBounds(150, 420, 100, 30);
        JTextArea desField = new JTextArea();
        desField.setBounds(240, 420, 200, 70);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        desField.setBorder(border);
        JButton submit= new JButton("Submit");
        submit.setBounds(250,500,100,30);
        submit.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e)
           {
                try{
                    String userName = nameField.getText().trim();
                    String userRollNum = rollField.getText().trim();
                    String userBranch = branchf.getText().trim();
                    String userSem = semField.getText().trim();
                    String requestTitle = subjectField.getText().trim();
                    String requestDescrption = desField.getText().trim();
                    String userEmail = emailField.getText().trim();
                    int userBatch = Integer.parseInt(batchField.getText().trim());
                    if(userName.length() == 0 || userRollNum.length() == 0 || userBranch.length() == 0 || userSem.length() == 0 || userEmail.length() == 0 || requestTitle.length() == 0 || requestDescrption.length() == 0) {
                        throw new Exception("Please fill all the parameters");
                    }
                    Request obj = new Request(userName, userRollNum, userBranch, userSem, requestTitle, requestDescrption, userEmail, userBatch);
                    nameField.setText("");
                    rollField.setText("");
                    batchField.setText("");
                    branchf.setText("");
                    semField.setText("");
                    emailField.setText("");
                    subjectField.setText("");
                    desField.setText("");
                    HelpDeskController.helpDeskController.postRequest(obj);
                    frame.dispose();
                    new ViewForm(obj);
                }
                catch(Exception exception) {
                    System.out.println(exception);
                }
           }
        });
        JButton back = new JButton("<");
        back.setBounds(50, 7, 50, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DashBoard();
            }
        });
        frame.add(back);
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
        frame.add(submit);
              

        frame.setBounds(500, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Form();
    }
}