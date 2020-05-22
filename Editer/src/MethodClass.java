import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MethodClass {
	
	EditerClass editer;
	String fname,fpath;
	
	public MethodClass(EditerClass editer) {
		this.editer = editer;
	}
	
	public void NewFile() {
		editer.scribble_pad.setText("");
		editer.mainframe.setTitle("New File");
		fname = "";
		fpath = "";
	}
	
	public void OpenFile() {
		FileDialog fdig = new FileDialog(editer.mainframe, "Open", FileDialog.LOAD);
		fdig.setVisible(true);
		
		if(fdig.getFile()!=null) {
			fname = fdig.getFile();
			fpath = fdig.getDirectory();
			editer.mainframe.setTitle(fname);
		}
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(fpath + fname));
			editer.scribble_pad.setText("");
			String content = null;
			while((content = buffer.readLine())!=null) {
				editer.scribble_pad.append(content+"\n");
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
	
	public void Undo() {
		editer.und.undo();
	}
	public void Redo() {
		editer.und.redo();
	}
	
}
