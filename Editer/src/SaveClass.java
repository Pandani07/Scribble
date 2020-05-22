import java.awt.FileDialog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
public class SaveClass {
	EditerClass editer;
	String fname,fpath;
	
	public SaveClass(EditerClass editer) {
		this.editer = editer;
	}
	
	public void Save_File() {
		FileDialog fdig = new FileDialog(editer.mainframe, "Save", FileDialog.SAVE);
		fdig.setVisible(true);
		
		if(fdig.getFile()!=null) {
			fname = fdig.getFile();
			fpath = fdig.getDirectory();
			editer.mainframe.setTitle(fname);
		}
		try {
			FileWriter writer = new FileWriter(fpath + fname);
			writer.write(editer.scribble_pad.getText());
			editer.mainframe.setTitle(fname);
			writer.close();
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
	
	public void Save() {
		if(fname==null) {
			Save_File();
		}
		else {
			try {
				FileWriter writer = new FileWriter(fpath + fname);
				writer.write(editer.scribble_pad.getText());
				writer.close();
			}
			catch(Exception e) {
				System.out.println("Error");
			}
		}
	}
}
