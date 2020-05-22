import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class EditerClass implements ActionListener{
	
	JFrame mainframe;
	JTextArea scribble_pad;
	JScrollPane scrollableScribble;
	
	boolean wrap=false;
	
	JMenuBar topnav;
	JMenu Mfile, Medit, Mcolor, Mview, Mhelp, mFontSize, mFont, mFontType;
	
	JMenuItem iNew, iOpen, iExit, iSave, iSaveas;
	JMenuItem iRedo,iUndo,iDelete, InsertImage;
	JMenuItem iWrap, ComicSans, TimesNR, Consolas, Arial;
	JMenuItem size4,size8,size16,size20,size24,size10,size32,size64;
	JMenuItem iBold,Itallic;
	JMenuItem iColor1, iColor2, iColor3, iColor4, iColor5;
	
	MethodClass method = new MethodClass(this);
	SaveClass sav = new SaveClass(this);
	View_Class view = new View_Class(this);
	Color_Class colors = new Color_Class(this);
	
	UndoManager und =  new UndoManager();
	
	public static void main(String args[]) {
		new EditerClass();

	}
	
	public EditerClass() {
		createMainFrame();
		createScribbleArea();
		createNavBar();
		view.chosen="Arial";
		view.MakeFont(16,null);
		CreateView();
		colors.ChangeColor("White");
		ChangeColor();
		mainframe.setVisible(true);

	}
	
	public void createMainFrame() {
		mainframe = new JFrame("Scribble");
		mainframe.setSize(400, 400);
		mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
	}
	public void createScribbleArea() {
		scribble_pad = new JTextArea();
		scribble_pad.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				und.addEdit(e.getEdit());
			}
		});
		scrollableScribble = new JScrollPane(scribble_pad, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollableScribble.setBorder(BorderFactory.createEmptyBorder());
		mainframe.add(scrollableScribble);
	}
	public void createNavBar() {
		
		topnav = new JMenuBar();
		
		Mfile = new JMenu("File");
		topnav.add(Mfile);
		
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		
		iSaveas = new JMenuItem("Save As..");
		iSaveas.addActionListener(this);
		iSaveas.setActionCommand("Save As");
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		
		
		Mfile.add(iNew);
		Mfile.add(iOpen);
		Mfile.add(iSave);
		Mfile.add(iSaveas);
		Mfile.add(iExit);

		
		Medit = new JMenu("Edit");
		topnav.add(Medit);
		
		iUndo= new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		
		iDelete= new JMenuItem("Delete");
		iDelete.addActionListener(this);
		iDelete.setActionCommand("Delete");
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		
		
		Medit.add(iUndo);
		Medit.add(iRedo);
		Medit.add(iDelete);
		
		Mview = new JMenu("View");
		topnav.add(Mview);
				
		Mcolor = new JMenu("Color");
		topnav.add(Mcolor);
		
		Mhelp = new JMenu("Help");
		Mhelp.addActionListener(this);
		Mhelp.setActionCommand("Help");
		topnav.add(Mhelp);
		
		mainframe.setJMenuBar(topnav);
	}
	
	public void CreateView() {
		
		mFontType = new JMenu("Type");
		
		iBold = new JMenuItem("Bold");
		iBold.addActionListener(this);
		iBold.setActionCommand("Bold");
		mFontType.add(iBold);
		
		Itallic = new JMenuItem("Itallics");
		Itallic.addActionListener(this);
		Itallic.setActionCommand("Itallics");
		mFontType.add(Itallic);
		
		
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Wrap");
		Mview.add(iWrap);
		
		mFontSize = new JMenu("Font Size");
		mFont = new JMenu("Font");
		Mview.add(mFont);
		Mview.add(mFontSize);
		Mview.add(iBold);
		Mview.add(Itallic);
		
		ComicSans = new JMenuItem("Comic Sans Ms");
		ComicSans.addActionListener(this);
		ComicSans.setActionCommand("ComicSans");
		mFont.add(ComicSans);
		
		TimesNR  = new JMenuItem("Times New Roman");
		TimesNR.addActionListener(this);
		TimesNR.setActionCommand("TimesNR");
		mFont.add(TimesNR);
		
		Consolas = new JMenuItem("Consolas");
		Consolas.addActionListener(this);
		Consolas.setActionCommand("Consolas");
		mFont.add(Consolas);
		
		Arial    = new JMenuItem("Arial");
		Arial.addActionListener(this);
		Arial.setActionCommand("Arial");
		mFont.add(Arial);
		        
		size4    = new JMenuItem("4");
		size4.addActionListener(this);
		size4.setActionCommand("Size4");
		mFontSize.add(size4);
		
		size8    = new JMenuItem("8");
		size8.addActionListener(this);
		size8.setActionCommand("Size8");
		mFontSize.add(size8);
		
		size10   = new JMenuItem("10");
		size10.addActionListener(this);
		size10.setActionCommand("Size10");
		mFontSize.add(size10);
		
		size16   = new JMenuItem("16");
		size16.addActionListener(this);
		size16.setActionCommand("Size16");
		mFontSize.add(size16);
		
		size20   = new JMenuItem("20");
		size20.addActionListener(this);
		size20.setActionCommand("Size20");
		mFontSize.add(size20);
		
		size24   = new JMenuItem("24");
		size24.addActionListener(this);
		size24.setActionCommand("Size24");
		mFontSize.add(size24);
		
		size32   = new JMenuItem("32");
		size32.addActionListener(this);
		size32.setActionCommand("Size32");
		mFontSize.add(size32);
		
		size64   = new JMenuItem("64");
		size64.addActionListener(this);
		size64.setActionCommand("Size64");
		mFontSize.add(size64);
	}
	
	public void ChangeColor() {
		
		 iColor1 = new JMenuItem("White");
		 iColor1.addActionListener(this);
		 iColor1.setActionCommand("White");
		 
		 iColor2 = new JMenuItem("Black");
		 iColor2.addActionListener(this);
		 iColor2.setActionCommand("Black");
		 
		 iColor3 = new JMenuItem("Blue");
		 iColor3.addActionListener(this);
		 iColor3.setActionCommand("Blue");
		 
		 iColor4 = new JMenuItem("Yellow");
		 iColor4.addActionListener(this);
		 iColor4.setActionCommand("Yellow");
		 
		 iColor5 = new JMenuItem("Green");
		 iColor5.addActionListener(this);
		 iColor5.setActionCommand("Green");
		 
		 Mcolor.add(iColor1);
		 Mcolor.add(iColor2);
		 Mcolor.add(iColor3);
		 Mcolor.add(iColor4);
		 Mcolor.add(iColor5);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		switch(command) {
			
			case "New": method.NewFile();break;
			
			case "Open": method.OpenFile();break;
			
			case "Save": sav.Save();break;
			
			case "Save As": sav.Save_File();break;
			
			case "Exit": System.exit(0);break;
			
			case "Wrap": view.wordWrap();break;
			
			case "Undo":method.Undo();break;
			case "Redo":method.Redo();break;
			case "Delete": scribble_pad.setText("");break;
			
			case "Size4": view.MakeFont(4,view.type);  break;
			case "Size8": view.MakeFont(8,view.type);  break;
			case "Size10": view.MakeFont(10,view.type);  break;
			case "Size16": view.MakeFont(16,view.type);  break;
			case "Size20": view.MakeFont(20,view.type);  break;
			case "Size24": view.MakeFont(24,view.type);  break;
			case "Size32": view.MakeFont(32,view.type);  break;
			case "Size64": view.MakeFont(64,view.type);  break;
			
			case "Arial": view.ChangeFont("Arial");break;
			case "ComicSans": view.ChangeFont("Comic Sans MS");break;
			case "TimesNR": view.ChangeFont("Times New Roman");break;
			case "Consolas": view.ChangeFont("Consolas");break;
			
			case "Bold":view.MakeFont(view.size, "Bold");break;
			case "Itallics":view.MakeFont(view.size, "Itallics");break;
			
			case "White" : colors.ChangeColor(command);break;
			case "Black" : colors.ChangeColor(command);break;
			case "Blue" : colors.ChangeColor(command);break;
			case "Yellow" : colors.ChangeColor(command);break;
			case "Green" : colors.ChangeColor(command);break;
			
			case "Help": view.help();break;
		}
	}
	
}
