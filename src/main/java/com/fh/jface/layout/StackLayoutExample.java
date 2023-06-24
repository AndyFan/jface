package com.fh.jface.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class StackLayoutExample {

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMaximized(true);
		shell.setText("StackLayout Example");

		shell.setLayout(new GridLayout(2, true));
		final Composite com = new Composite(shell, SWT.NONE);
		com.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite btnCom = new Composite(shell, SWT.NONE);
		btnCom.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button btn = new Button(btnCom, SWT.BORDER);
		btnCom.setLayout(new FillLayout());
		btn.setText("修改那个容器可见");

		final StackLayout sl = new StackLayout();
		com.setLayout(sl);

		final Composite com1 = new Composite(com, SWT.NONE);
		Color color1 = new Color(display, 255, 0, 0);
		com1.setBackground(color1);

		final Composite com2 = new Composite(com, SWT.NONE);
		Color color2 = new Color(display, 0, 255, 0);
		com2.setBackground(color2);

		final Composite com3 = new Composite(com, SWT.NONE);
		Color color3 = new Color(display, 0, 0, 255);
		com3.setBackground(color3);
		// 这个必须设计
		sl.topControl = com1;

		btn.addMouseListener(new MouseListener() {

			int i = 1;

			public void mouseUp(MouseEvent arg0) {
				if (i > 3) {
					i = 1;
				}else{
					i = i+1;
				}

				if (("com" + i).equals("com1")) {
					sl.topControl = com1;
				}

				if (("com" + i).equals("com2")) {
					sl.topControl = com2;
				}

				if (("com" + i).equals("com3")) {
					sl.topControl = com3;
					
				}
				com.layout();
			}

			public void mouseDown(MouseEvent arg0) {

			}

			public void mouseDoubleClick(MouseEvent arg0) {

			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
