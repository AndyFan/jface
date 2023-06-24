package com.fh.jface.window;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import java.io.File;
import java.io.IOException;

@Slf4j
public class HelloSwtJFace extends ApplicationWindow {
    public HelloSwtJFace() {
        super(null);
        this.setBlockOnOpen(true);
        this.open();
        Display.getCurrent().dispose();
    }

    @Override
    protected Control createContents(Composite parent) {
        Text helloText = new Text(parent, SWT.CENTER);
        helloText.setText("Hello SWT and JFace!");
        parent.setSize(600, 400);
        Rectangle shellRec = getShell().getBounds();
        Rectangle screeRec = Display.getCurrent().getBounds();
        parent.setLocation((screeRec.width - shellRec.width) / 2, (screeRec.height - shellRec.height) / 2);
        // parent.pack();
        return parent;
    }

    public static void main(String[] args)
            throws IOException {
        log.info("###### start ApplicationWindow ######");
        new HelloSwtJFace();
        FileUtils.forceDeleteOnExit(new File("logs"));
    }

}
