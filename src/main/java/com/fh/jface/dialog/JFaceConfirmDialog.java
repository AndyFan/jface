package com.fh.jface.dialog;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class JFaceConfirmDialog {

	public static void main(String[] args) {
		
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLocation(300, 200);
		shell.setSize(500, 350);
		shell.setLayout(null);
		Button btn1 = new Button(shell, SWT.BORDER);
		btn1.setSize(100, 50);
		btn1.setLocation(100, 20);
		btn1.setText("确认对话框");
		//模式和非模式
		btn1.addMouseListener(new MouseListener() {
			
			public void mouseUp(MouseEvent arg0) {
				boolean flag = MessageDialog.openConfirm(shell, "提示", "你是否想喝了一杯三鹿氰胺？");
				System.out.println(flag);
			}
			
			public void mouseDown(MouseEvent arg0) {
				
			}
			
			public void mouseDoubleClick(MouseEvent arg0) {
				
			}
		});
		
		
		
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}
	
}