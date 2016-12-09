package com.mpt.pms;

import com.mpt.pms.domain.Company;
import com.mpt.pms.domain.Project;

import java.io.*;

public class DomainContext {
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    private Company company = null;

    public void load(String path) {
        try {
            FileInputStream fileIn =
                    new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.company = (Company) in.readObject();
            in.close();
            fileIn.close();
            System.out.printf("Serialized data loaded from %s\n", path);
        } catch(Exception i) {
            i.printStackTrace();
        }
    }

    public void save(String path) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.company);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in %s\n", path);
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
}
