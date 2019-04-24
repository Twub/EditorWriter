import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author hampu
 *
 */
public class EditorWriter {

	private JFileChooser jChooser = new JFileChooser();
	private String guiText = "", docTitle = "";
	
	public void hiddenWriter(String destination, String text) {
		writeToFile(new File(destination), text);
	}
	
	public void guiWriter(String text) {
		guiText = text;
		saveToFile();
	}
	
	private void saveToFile() {
	    JFileChooser fileChooser = new JFileChooser();
	    int retval = fileChooser.showSaveDialog(null);
	    if (retval == JFileChooser.APPROVE_OPTION) {
	      File file = fileChooser.getSelectedFile();
	      if (file == null) {
	        return;
	      }
	      if (!file.getName().toLowerCase().endsWith(".txt")) {
	        file = new File(file.getParentFile(), file.getName() + ".txt");
	      }
	      writeToFile(file, guiText);
	    }
	  }
	
	/*
	 * Denna metod skriver till filen.
	 */
	private void writeToFile(File destination, String data) {
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter pw;
		try {
			fw = new FileWriter(destination);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(data);
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			fw = null;
			bw = null;
			pw = null;
			System.out.println("Write Finished Succesfully");
		}
	}
}
