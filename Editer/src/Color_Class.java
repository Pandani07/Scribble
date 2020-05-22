import java.awt.*;
public class Color_Class {
	EditerClass editer;
	String color;
	
	public Color_Class(EditerClass editer) {
		this.editer = editer;
	}
	
	public void ChangeColor(String color1) {
		color = color1;
		switch(color) {
			case "White": 	editer.mainframe.getContentPane().setBackground(Color.white);
					editer.scribble_pad.setBackground(Color.white);
					editer.scribble_pad.setForeground(Color.black);
						break;
			case "Black":	editer.mainframe.getContentPane().setBackground(Color.black);
					editer.scribble_pad.setBackground(Color.black);
					editer.scribble_pad.setForeground(Color.white);
						break;
			case "Blue":	editer.mainframe.getContentPane().setBackground(Color.blue);
					editer.scribble_pad.setBackground(Color.blue);
					editer.scribble_pad.setForeground(Color.white);
						break;
			case "Yellow":	editer.mainframe.getContentPane().setBackground(Color.yellow);
					editer.scribble_pad.setBackground(Color.yellow);
					editer.scribble_pad.setForeground(Color.black);
						break;
			case "Green":	editer.mainframe.getContentPane().setBackground(Color.green);
					editer.scribble_pad.setBackground(Color.green);
					editer.scribble_pad.setForeground(Color.black);
						break;
		}	
	}
}
