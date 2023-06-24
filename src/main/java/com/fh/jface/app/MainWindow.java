package com.fh.jface.app;

import com.fh.jface.app.action.ExitAction;
import com.fh.jface.app.action.HelpAction;
import com.fh.jface.app.action.OpenAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

public class MainWindow extends ApplicationWindow {

    private OpenAction openAction;

    private ExitAction exitAction;

    private HelpAction helpAction;

    private FileManager manager;

    private Text content;

    private static MainWindow app;

    private MainWindow() {
        super(null);
        app = this;
        manager = new FileManager();
        openAction = new OpenAction();
        exitAction = new ExitAction();
        helpAction = new HelpAction();

        this.addMenuBar();
        this.addToolBar(SWT.FLAT);
        this.addStatusLine();
    }

    public static MainWindow getApp() {
        return app;
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText("插件解析");
        shell.setMaximized(true);
    }

    @Override
    protected Control createContents(Composite parent) {
        content = new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
        content.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                manager.setDirty(true);
            }
        });
        return parent;
    }

    @Override
    protected MenuManager createMenuManager() {
        MenuManager menuBar = new MenuManager();
        MenuManager fileMenu = new MenuManager("文件(&F)");
        MenuManager helpMenu = new MenuManager("帮助(&H)");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(openAction);
        fileMenu.add(new Separator());
        fileMenu.add(new Separator());
        fileMenu.add(exitAction);
        helpMenu.add(helpAction);
        return menuBar;
    }

    public static void main(String[] args) {
        MainWindow main = new MainWindow();
        main.setBlockOnOpen(true);
        main.open();
        Display.getCurrent().dispose();
    }

    public Text getContent() {
        return content;
    }

    public FileManager getManager() {
        return manager;
    }

    public void setManager(FileManager manager) {
        this.manager = manager;
    }

    @Override
    public StatusLineManager getStatusLineManager() {
        return super.getStatusLineManager();
    }

    /**
     * Return the initial size of the window.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(800, 600);
    }
}