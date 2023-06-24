package com.fh.jface.app.action;
//ExitAction.java

import com.fh.jface.app.MainWindow;
import org.eclipse.jface.action.Action;

public class ExitAction extends Action {
    public ExitAction() {
        super();
        setText("退出(&E)");
        setToolTipText("退出系统");
    }

    @Override
    public void run() {
        MainWindow.getApp().close();
    }
}