package com.telran.utils;

import com.telran.data.StudentData;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> usingFile() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/data.csv")
        ));
        List<Object[]> studentData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            studentData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return studentData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> usingNewGuestFile() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/Data1.csv")
        ));
        List<Object[]> guestData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            guestData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return guestData.iterator();
    }
}
