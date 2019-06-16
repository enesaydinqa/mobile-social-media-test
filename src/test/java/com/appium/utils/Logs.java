package com.appium.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Logs
{
    public static void testLogFill(Configuration configuration, String content)
    {
        String folderName = "SocialMediaTestLogs";
        String fileSeparator = System.getProperty("file.separator");

        File folder = new File(System.getProperty("user.home").concat(fileSeparator)
                .concat(configuration.getTestResultPath().concat(fileSeparator)).concat(folderName));

        if (!folder.exists())
        {
            if (folder.mkdir())
            {
                System.out.println("Directory is created!");
            }
            else
            {
                System.out.println("Failed to create directory!");
            }
        }

        String reportName = System.getProperty("user.home").concat(configuration.getTestResultPath().concat(fileSeparator))
                .concat(folderName).concat(fileSeparator).concat(String.valueOf(configuration.getOperator()).concat("-"))
                .concat("Social-Media-Test-Logs.json");

        File file = new File(reportName);

        try
        {
            if (file.exists())
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

                writer.append("\n");
                writer.append(content);
                writer.close();
            }
            else if (!file.exists())
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                file.createNewFile();
                System.out.println("File is created!");
                writer.write(content);
                writer.close();
            }
            else
            {
                System.out.println("File already exists.");
            }

        }
        catch (Exception ex)
        {
            // no action
        }
    }
}
