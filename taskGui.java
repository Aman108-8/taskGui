import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class taskGui {

	private JFrame frame;
	private JList<String> taskList;
	private JTextField textField;
	private JButton add,delete;
	private DefaultListModel<String> taskListModel;
	private JScrollPane scroll ;
	private JPanel inputpane, buttonPane1;
	
	taskGui() {
        frame = new JFrame("Task");
        
        add = new JButton("Add");
        delete = new JButton("Delete");
        
        textField = new JTextField();
        
        taskListModel = new DefaultListModel<String>();
        taskList = new JList<String>(taskListModel);
        scroll = new JScrollPane(taskList);
        
        inputpane = new JPanel(new BorderLayout());
        buttonPane1 = new JPanel(new FlowLayout());
        
        set();
    }
	
	void set() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
		inputpane.add(textField, BorderLayout.CENTER);
        inputpane.add(add, BorderLayout.EAST);
        
        buttonPane1.add(delete);
        
        frame.setLayout(new BorderLayout());
        frame.add(inputpane, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(buttonPane1, BorderLayout.SOUTH);
        
        backend();
        
        frame.setVisible(true);
	}
	
	void backend() {
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String task = textField.getText().trim();
				if(!task.isEmpty()) {
					taskListModel.addElement(task);
					textField.setText("");
				}
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectBox = taskList.getSelectedIndex();
				if(selectBox != -1) {
					taskListModel.remove(selectBox);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		System.out.println("hii");
		taskGui tg= new taskGui();
	}

}
