import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainTest {
	
	private static EditorWriter r = new EditorWriter();

	public static void main(String[] args) {
		JFrame window = new JFrame("ReaderTestMain");
		window.setSize(400,400);
		window.setDefaultCloseOperation(3);
		window.setLayout(null);
		
		JTextArea t = new JTextArea();
		window.getContentPane().add(t);
		t.setBounds(0, 100, 400, 300);
		t.setEditable(true);
		
		JButton btn1 = new JButton("Console");
		JButton btn2 = new JButton("GUI");
		
		btn1.setBounds(0, 0, 150, 50);
		btn2.setBounds(234, 0, 150, 50);
		
		window.getContentPane().add(btn1);
		window.getContentPane().add(btn2);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				r.hiddenWriter("C:\\test\\test3.txt", t.getText()); // DONE - hiddenWriter
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				r.guiWriter(t.getText());
				
			}
			
		});
		
		window.setVisible(true);
	}
}
