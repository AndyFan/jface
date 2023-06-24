package com.fh.jface.menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

/**
 * Tray任务栏菜单
 */
public class TrayExample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Tray Example");
		Tray tray = display.getSystemTray();
		TrayItem ti = new TrayItem(tray, SWT.NONE);
		ti.setToolTipText("swt tray");
		Image image = new Image(display,
				TrayExample.class.getResourceAsStream("/img/1.png"));
		ti.setImage(image);

		// TrayItem ti1 = new TrayItem(tray, SWT.NONE);
		// ti1.setImage(image);
		final Menu trayMenu = createTrayMenu(display, shell);
		ti.addMenuDetectListener(new MenuDetectListener() {

			public void menuDetected(MenuDetectEvent event) {
				trayMenu.setVisible(true);
			}
		});

		shell.setLocation(300, 100);
		shell.setSize(500, 400);
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

	public static Menu createTrayMenu(Display display, final Shell shell) {
		// 定义一个弹出式菜单
		final Menu trayMenu = new Menu(shell, SWT.POP_UP);
		// 定义菜单中的选项
		MenuItem welcomeItem = new MenuItem(trayMenu, SWT.PUSH);
		welcomeItem.setText("欢迎");

		welcomeItem.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				MessageBox box = new MessageBox(shell);
				box.setText("欢迎");
				box.setMessage("welcome");
				box.open();
			}

			public void widgetDefaultSelected(SelectionEvent event) {

			}
		});

		// 分隔符
		MenuItem separator = new MenuItem(trayMenu, SWT.SEPARATOR);
		MenuItem updateItem = new MenuItem(trayMenu, SWT.PUSH);
		updateItem.setText("在线更新");
		MenuItem aboutItem = new MenuItem(trayMenu, SWT.PUSH);
		aboutItem.setText("关于");
		MenuItem exit = new MenuItem(trayMenu, SWT.PUSH);
		exit.setText("退出");

		exit.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				shell.close();
			}

			public void widgetDefaultSelected(SelectionEvent event) {

			}
		});
		return trayMenu;
	}

}
