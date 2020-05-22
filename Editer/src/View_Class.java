import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class View_Class {
	EditerClass editer;
	Font Arial, TNR, Comic, Consolas;
	String chosen, type;
	int size;
	
	public View_Class(EditerClass editer) {
		this.editer = editer;
	}
	public void wordWrap() {
		if(editer.wrap==false) {
			editer.wrap=true;
			editer.scribble_pad.setLineWrap(true);
			editer.scribble_pad.setWrapStyleWord(true);
			editer.iWrap.setText("Word Wrap: On");
		}
		else if(editer.wrap == true) {
			editer.wrap=true;
			editer.scribble_pad.setLineWrap(false);
			editer.scribble_pad.setWrapStyleWord(false);
			editer.iWrap.setText("Word Wrap: Off");
		}
	}
	public void MakeFont(int size1, String type1) {
		size = size1;
		type =type1;
		if(type== null) {
			Arial = new Font("Arial", Font.PLAIN, size);
			TNR = new Font("Times New Roman", Font.PLAIN, size);
			Comic = new Font("Comic Sans MS", Font.PLAIN, size);
			Consolas = new Font("Consolas", Font.PLAIN, size);
			ChangeFont(chosen);
		}
		else if(type == "Bold") {
			Arial = new Font("Arial", Font.BOLD, size);
			TNR = new Font("Times New Roman", Font.BOLD, size);
			Comic = new Font("Comic Sans MS", Font.BOLD, size);
			Consolas = new Font("Consolas", Font.BOLD, size);
			ChangeFont(chosen);
		}
		else if(type=="Itallics"){
			Arial = new Font("Arial", Font.ITALIC, size);
			TNR = new Font("Times New Roman", Font.ITALIC, size);
			Comic = new Font("Comic Sans MS", Font.ITALIC, size);
			Consolas = new Font("Consolas", Font.ITALIC, size);
			ChangeFont(chosen);
		}
		

	}
	public void ChangeFont(String font) {
		chosen = font;
		if(chosen == "Arial")
			editer.scribble_pad.setFont(Arial);
		else if(chosen == "Times New Roman")
			editer.scribble_pad.setFont(TNR);
		else if(chosen == "Comic Sans MS")
			editer.scribble_pad.setFont(Comic);
		else if(chosen == "Consolas")
			editer.scribble_pad.setFont(Consolas);
	}
	
	public void help() {
		JFrame help = new JFrame("Help");
		JLabel hep = new JLabel("Scribble is a basic text editer. Images cannot be inserted");
		help.add(hep);
		help.setVisible(true);
		help.setDefaultCloseOperation(help.EXIT_ON_CLOSE);
		help.setSize(200,200);
	}
	
}
