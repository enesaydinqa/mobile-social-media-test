package com.appium.utils;

import com.appium.client.objects.DeviceInfo;
import com.appium.client.objects.InstagramReport;
import com.appium.client.objects.SnapchatReport;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.runner.Description;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReportInformation
{
    private static final String fileSeparator = System.getProperty("file.separator");
    private static final String reportFilePath = System.getProperty("user.home").concat(System.getProperty("test.result.path").concat(fileSeparator).concat("SocialMediaTestReports"));
    private static BufferedWriter writer;

    public static void instagram(Description description, DeviceInfo deviceInfo, InstagramReport report, boolean isTestPassed)
    {
        String testData = getInstagramTestData(deviceInfo, report);

        writeReport("INSTAGRAM APP TEST", "InstagramTestResultsReport.html", testData, description, isTestPassed);
    }

    public static void snapchat(Description description, DeviceInfo deviceInfo, SnapchatReport report, boolean isTestPassed)
    {
        String testData = getSnapchatTestData(deviceInfo, report);

        writeReport("SNAPCHAT APP TEST", "SnapchatTestResultsReport.html", testData, description, isTestPassed);
    }

    private static void writeReport(String appName, String reportName, String testData, Description description, boolean isTestPassed)
    {
        ifNotExistCreateTestResultFolder();

        String mapId = RandomStringUtils.randomAlphabetic(20);

        String template = getReportTemplateHtml().replace("{APP_NAME}", appName);

        try
        {
            String file = reportFilePath.concat(fileSeparator).concat(reportName);

            File f = new File(file);

            /**
             * Eğer dosya oluşturulmuşsa if bloğuna girer.
             */

            if (f.exists() && !f.isDirectory())
            {
                FileWriter fr = new FileWriter(file, true);
                writer = new BufferedWriter(fr);
            }
            else
            {
                FileWriter fr = new FileWriter(file, false);

                writer = new BufferedWriter(fr);
                writer.write(template);
            }


            writer.append("<table style=\"height: 4%; width: 100%; margin-top: 5px; border: 1px dotted black; background-color: #dedbbe;\">\n" +
                    "    <tbody>\n" +
                    "    <tr style=\"height: 21px;\">\n" +
                    "        <td style=\"width: 380px; text-align: center; height: 21px;\"><strong>" + description.getMethodName() + "</strong></td>\n" +
                    "        <td style=\"width: 380px; text-align: center; height: 21px;\"><strong>" + isTestPassed + "</strong></td>\n" +
                    "        <td style=\"width: 385px; text-align: center; height: 21px;\">" + testData + "</td>\n " +
                    "        <td style=\"width: 385px; text-align: center; height: 21px;\">\n" +
                    "            <body>\n" +
                    "            <div id=\"" + mapId + "\" style=\"width: 95%; height: 300px; background: #31806d\"></div>\n" +
                    "            <div id=\"panel\" style=\"width: 100%; height: 0px; float: right\"></div>\n" +
                    "            <script type=\"text/javascript\" charset=\"UTF-8\">\n" +
                    "\n" +
                    "                var platform = new H.service.Platform({\n" +
                    "                    app_id: 'QHwxW8FKWFWrMty0eeHF',\n" +
                    "                    app_code: 'unlYw22AgQdIQLLtIov1Eg',\n" +
                    "                    useCIT: true,\n" +
                    "                    useHTTPS: true\n" +
                    "                });\n" +
                    "                var defaultLayers = platform.createDefaultLayers();\n" +
                    "\n" +
                    "                var map = new H.Map(document.getElementById(\'" + mapId + "\'),\n" +
                    "                    defaultLayers.normal.map, {\n" +
                    "                        center: {lat: 40.920005, lng: 29.152288},\n" +
                    "                        zoom: 17\n" +
                    "                    });\n" +
                    "\n" +
                    "                var behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(map));\n" +
                    "                var ui = H.ui.UI.createDefault(map, defaultLayers);\n" +
                    "\n" +
                    "                var eskimarker = new H.map.Marker({lat: 40.920005, lng: 29.152288});\n" +
                    "                map.addObject(eskimarker);\n" +
                    "\n" +
                    "                function error_geo() {\n" +
                    "                    console.log(\"Hata oluştu\");\n" +
                    "                }\n" +
                    "\n" +
                    "                function updatePosition(position) {\n" +
                    "                    map.removeObject(eskimarker);\n" +
                    "                    var HEREHQcoordinates = {lat: position.coords.latitude, lng: position.coords.longitude};\n" +
                    "\n" +
                    "                    console.log(position.coords.latitude + \"  \" + position.coords.longitude);\n" +
                    "                    var marker = new H.map.Marker(HEREHQcoordinates);\n" +
                    "                    eskimarker = marker;\n" +
                    "                    map.addObject(marker);\n" +
                    "                    var x = document.getElementById(\"panel\");\n" +
                    "                    x.innerHTML = position.coords.latitude + \"  \" + position.coords.longitude;\n" +
                    "                }\n" +
                    "\n" +
                    "                //map.setCenter(HEREHQcoordinates);\n" +
                    "\n" +
                    "                var opti = {enableHighAccuracy: false, timeout: 160000, maximumAge: 160000};\n" +
                    "                setInterval(function () {\n" +
                    "                    navigator.geolocation.watchPosition(updatePosition, error_geo, opti)\n" +
                    "                }, 1000);\n" +
                    "            </script>\n" +
                    "            </body>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>");

            writer.close();
        }
        catch (IOException ex)
        {
        }
    }

    private static String getReportTemplateHtml()
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("ReportTemplate.html").getPath()), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    private static String getInstagramTestData(DeviceInfo deviceInfo, InstagramReport report)
    {
        StringBuilder str = new StringBuilder();

        if (StringUtils.isNotBlank(deviceInfo.getMobileOneDeviceIMEI()))
            str.append("<p style='text-align: left;'>First Mobile Device IMEI : " + deviceInfo.getMobileOneDeviceIMEI() + "</p>");

        if (StringUtils.isNotBlank(deviceInfo.getMobileSecondDeviceIMEI()))
            str.append("<p style='text-align: left;'>Second Mobile Device IMEI : " + deviceInfo.getMobileSecondDeviceIMEI() + "</p>");

        if (StringUtils.isNotBlank(report.getInstagramPostShareButtonClickTime()))
            str.append("<p style='text-align: left;'>Instagram Post Share Button Click Time : " + report.getInstagramPostShareButtonClickTime() + "</p>");

        if (StringUtils.isNotBlank(report.getInstagramSharedImagePostTime()))
            str.append("<p style='text-align: left;'>Instagram Shared Image Post Time : " + report.getInstagramSharedImagePostTime() + "</p>");

        if (StringUtils.isNotBlank(report.getInstagramSharedVideoPostTime()))
            str.append("<p style='text-align: left;'>Instagram Shared Video Post Time : " + report.getInstagramSharedVideoPostTime() + "</p>");

        if (StringUtils.isNotBlank(report.getClickSendMessageTime()))
            str.append("<p style='text-align: left;'>Click Send Message Time : " + report.getClickSendMessageTime() + "</p>");

        if (StringUtils.isNotBlank(report.getSendMessageTime()))
            str.append("<p style='text-align: left;'>Send Message Time : " + report.getSendMessageTime() + "</p>");

        if (StringUtils.isNotBlank(report.getReceiveMessageTime()))
            str.append("<p style='text-align: left;'>Receive Message Time : " + report.getReceiveMessageTime() + "</p>");

        return String.valueOf(str);
    }

    private static String getSnapchatTestData(DeviceInfo deviceInfo, SnapchatReport report)
    {
        StringBuilder str = new StringBuilder();

        if (StringUtils.isNotBlank(deviceInfo.getMobileOneDeviceIMEI()))
            str.append("<p style='text-align: left;'>First Mobile Device IMEI : " + deviceInfo.getMobileOneDeviceIMEI() + "</p>");

        if (StringUtils.isNotBlank(deviceInfo.getMobileSecondDeviceIMEI()))
            str.append("<p style='text-align: left;'>Second Mobile Device IMEI : " + deviceInfo.getMobileSecondDeviceIMEI() + "</p>");

        if (StringUtils.isNotBlank(report.getSnapchatStoryShareButtonClick()))
            str.append("<p style='text-align: left;'>Snapchat Story Share Button Click : " + report.getSnapchatStoryShareButtonClick() + "</p>");

        if (StringUtils.isNotBlank(report.getSharedStoryTime()))
            str.append("<p style='text-align: left;'>Shared Story Time : " + report.getSharedStoryTime() + "</p>");

        if (StringUtils.isNotBlank(report.getReceivedMessage()))
            str.append("<p style='text-align: left;'>Received Message : " + report.getReceivedMessage() + "</p>");

        return String.valueOf(str);
    }

    private static void ifNotExistCreateTestResultFolder()
    {
        File theDir = new File(reportFilePath);

        if (!theDir.exists())
        {
            System.out.println("creating directory: " + theDir.getName());

            boolean result = false;

            try
            {
                theDir.mkdir();
                result = true;
            }
            catch (SecurityException se)
            {
                //handle it
            }
            if (result)
            {
                System.out.println("DIR created");
            }
        }
    }
}
