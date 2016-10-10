package com.sionach.ux.accessibility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by webownia on 10.10.16.
 */
public class DeprecatedTagsList {

    public List<String> createDeprecatedTagsList(String filepath) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filepath));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }

}
