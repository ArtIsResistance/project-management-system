package com.mpt.pms;

import com.mpt.pms.domain.Project;

import java.io.*;

public class DomainContext {
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private Project project = null;

    public void Load(String path) {
        try {
            FileInputStream fileIn =
                    new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.project = (Project) in.readObject();
            in.close();
            fileIn.close();
            System.out.printf("Serialized data loaded from %s\n", path);
        } catch(Exception i) {
            i.printStackTrace();
        }
    }

    public void Save(String path) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.project);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in %s\n", path);
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
}
