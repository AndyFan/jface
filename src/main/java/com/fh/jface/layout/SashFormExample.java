package com.fh.jface.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SashFormExample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SashFormExample");
		shell.setMaximized(true);
		shell.setLayout(new FillLayout());
		//垂直
		SashForm  sashForm= new SashForm(shell, SWT.HORIZONTAL);
		Composite com1 = new Composite(sashForm, SWT.NONE);
		Color color1 = new Color(display, 255, 0, 0);
		com1.setBackground(color1);
		
		Composite com2 = new Composite(sashForm, SWT.NONE);
		Color color2 = new Color(display, 0, 255, 0);
		com2.setBackground(color2);
		sashForm.setWeights(new int[] {1,4});
		
		com2.setLayout(new FillLayout());
		SashForm  sashForm2= new SashForm(com2, SWT.VERTICAL);
		Composite com3 = new Composite(sashForm2, SWT.NONE);
		
		com3.setLayout(new FillLayout());
		SashForm  sashForm3= new SashForm(com3, SWT.HORIZONTAL);
		Composite com5 = new Composite(sashForm3, SWT.NONE);
		Color color5 = new Color(display, 0, 255, 0);
		com5.setBackground(color5);
		Composite com6 = new Composite(sashForm3, SWT.NONE);
		Color color6 = new Color(display, 255,0 , 0);
		com6.setBackground(color6);
		sashForm3.setWeights(new int[] {5,2});
		
		
		Color color3 = new Color(display, 0, 0, 255);
		com3.setBackground(color3);
		Composite com4 = new Composite(sashForm2, SWT.NONE);
		Color color4 = new Color(display, 0, 0, 255);
		com4.setBackground(color4);
		sashForm2.setWeights(new int[] {5,2});
		
		shell.open();
		// 当shell没有销毁的时候就循环
		while (!shell.isDisposed()) {
			// 当没有事件派发时候就睡眠
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
		
	}
	
}
