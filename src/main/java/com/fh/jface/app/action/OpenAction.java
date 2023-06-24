package com.fh.jface.app.action;
//OpenAction.java

import com.fh.jface.app.FileManager;
import com.fh.jface.app.MainWindow;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import java.lang.reflect.InvocationTargetException;

public class OpenAction extends Action {
    public OpenAction() {
        super();
        setText("打开(&O)");
        setToolTipText("打开文件");
    }

    @Override
    public void run() {
        FileDialog dialog = new FileDialog(MainWindow.getApp().getShell(), SWT.OPEN);
        dialog.setFilterExtensions(new String[]{"*.zip", "*.*"});
        final String name = dialog.open();
        if ((name == null) || (name.length() == 0)) {
            return;
        }
        final FileManager fileManager = MainWindow.getApp().getManager();
        try {
            ModalContext.run(new IRunnableWithProgress() {
                @Override
                public void run(IProgressMonitor progressMonitor) {
                    progressMonitor.beginTask("打开文件", IProgressMonitor.UNKNOWN);
                    fileManager.load(name);
                    progressMonitor.done();
                }
            }, true, MainWindow.getApp().getStatusLineManager().getProgressMonitor(), MainWindow.getApp().getShell().getDisplay());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainWindow.getApp().getContent().setText(fileManager.getContent());
        MainWindow.getApp().getStatusLineManager().setMessage("当前打开的文件是: " + name);
    }
}