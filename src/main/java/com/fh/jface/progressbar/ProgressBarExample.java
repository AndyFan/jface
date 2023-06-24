package com.fh.jface.progressbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class ProgressBarExample {

	public static void main(String[] args) {
		
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMaximized(true);
		shell.setText("ProgressBar Example");
		GridLayout gl = new GridLayout(1, true);
		shell.setLayout(gl);
	
		
		final ProgressBar progressBar= new ProgressBar(shell, SWT.HORIZONTAL | SWT.SMOOTH);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	
		
		new Thread(new Runnable() {
			
			public void run() {
				for(int i=0; i<100; i++){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
//					display.syncExec(new Runnable() {
//						
//						public void run() {
//							if(progressBar.isDisposed()){
//								return;
//							}
//							progressBar.setSelection(progressBar.getSelection()+1);
//						}
//					});
					
					if(!display.isDisposed()){
					display.asyncExec(new Runnable() {
						
						public void run() {
							if(progressBar.isDisposed()){
								return;
							}
							progressBar.setSelection(progressBar.getSelection()+1);
						}
					});
					}else{
						return;
					}
				}
			}
		}).start();
		
		
		//ԶĽ
		ProgressBar pb2 = new ProgressBar(shell, SWT.HORIZONTAL| SWT.INDETERMINATE);
		pb2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		
		
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
		
	}
	
}
