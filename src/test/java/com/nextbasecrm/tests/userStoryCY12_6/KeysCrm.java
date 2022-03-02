package com.nextbasecrm.tests.userStoryCY12_6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KeysCrm {

    //setUp Properties
        public static Properties properties = new Properties();

        static {
            try {
                FileInputStream file = new FileInputStream("keys.properties");
                properties.load(file);
            } catch (IOException e) {
                System.out.println("Keys Fail");
                e.printStackTrace();
            }
        }

        // call getKey without obj
    public static String getKey(String keyName) {
            return properties.getProperty(keyName);
    }

}
