import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ButtonListener extends ListTableActionListener {


    public void actionPerformed(ActionEvent e) {



        JTextField firstnameTextField = (JTextField) SpringApplicationContext.getBean("firstnameTextField");
        JTextField lastnameTextField = (JTextField) SpringApplicationContext.getBean("lastnameTextField");
        JTextField phoneTextField = (JTextField) SpringApplicationContext.getBean("phoneTextField");
        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String phone = phoneTextField.getText();


        Controller c = (Controller) SpringApplicationContext.getBean("controller");
        c.addBuddy(firstname,lastname,phone);
    }
}