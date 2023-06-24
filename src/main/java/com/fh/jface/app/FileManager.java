package com.fh.jface.app;

import java.io.File;

public class FileManager {
    private String fileName;

    private boolean dirty = false;

    private String content;

    public FileManager() {
    }

    public void load(String name) {
        final String path;
        try {
            File file = new File(name);
            path = file.getAbsolutePath();
            content = path;
            fileName = name;

            // 遍历
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}