package com.fh.jface.app.action;
//HelpAction.java

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

public class HelpAction extends Action {
    public HelpAction() {
        super();
        setText("帮助内容(&H)");
        setToolTipText("帮助");
    }

    @Override
    public void run() {
        MessageDialog.openInformation(null, "帮助", "谢谢使用！");
    }
}