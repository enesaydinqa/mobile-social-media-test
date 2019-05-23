package com.appium.context.devices;

import com.appium.client.objects.DeviceCapabilities;
import com.appium.utils.ADBCommands;
import com.appium.utils.Operator;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NotFoundException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceManager
{
    private List<DeviceCapabilities> deviceInformation = new ArrayList<>();

    public DeviceManager()
    {
        boolean multipleDeviceTest = Boolean.parseBoolean(System.getProperties().getProperty("multiple.device.test"));
        Operator operator = readOperatorParam("operator");

        DeviceCapabilities firstDeviceCap = readFirstDeviceCapabilities("first.device.uid", operator);
        deviceInformation.add(firstDeviceCap);

        if (multipleDeviceTest)
        {
            DeviceCapabilities secondDeviceCap = readFirstDeviceCapabilities("second.device.uid", operator);
            deviceInformation.add(secondDeviceCap);
        }
    }

    public DeviceCapabilities getDeviceCapabilities(int index)
    {
        Devices devices = new Devices(deviceInformation);

        try
        {
            return devices.getDeviceCapabilities().get(index);
        }
        catch (Exception ex)
        {
            throw new NotFoundException("Device Not Found !!!");
        }
    }

    private DeviceCapabilities readFirstDeviceCapabilities(String uidPropertyKey, Operator simCardPropertyKey)
    {
        String firstDeviceUID = System.getProperty(uidPropertyKey);
        String firstDeviceSimCard = System.getProperty(simCardPropertyKey.toString());

        String androidVersion = getDevicesInformation(ADBCommands.ADB_RO_BUILD_VERSION_RELEASE.getAdbCommand(), firstDeviceUID);
        String uiAutomationName = uiautomatorCondition(androidVersion);
        String IMEINumber = getDeviceIMEI(firstDeviceUID);

        DeviceCapabilities firstDeviceCap = new DeviceCapabilities();
        firstDeviceCap.setUid(firstDeviceUID);
        firstDeviceCap.setSimCard(firstDeviceSimCard);
        firstDeviceCap.setPlatformVersion(androidVersion);
        firstDeviceCap.setAutomationName(uiAutomationName);
        firstDeviceCap.setIMEINumber(IMEINumber);

        return firstDeviceCap;
    }

    private Operator readOperatorParam(String propertyKey)
    {
        Operator operator = null;
        String operatorName = System.getProperty(propertyKey);

        if (StringUtils.isNotBlank(operatorName))
        {
            try
            {
                operator = Operator.valueOf(operatorName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return operator;
    }

    private static List<String> getDevicesUID() throws IOException, InterruptedException
    {
        List<String> devicesUID = new ArrayList<>();

        String command = ADBCommands.ADB_DEVICES.getAdbCommand();

        Process procGetDeviceUID = Runtime.getRuntime().exec(command);

        try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(procGetDeviceUID.getInputStream())))
        {
            String readLine;

            while ((readLine = processOutputReader.readLine()) != null)
            {
                if (!readLine.contains("List") & readLine.contains("device"))
                {
                    String result = readLine.split("device")[0].trim();

                    devicesUID.add(result);
                }
            }
            procGetDeviceUID.waitFor();
        }
        return devicesUID;
    }

    private static String getDevicesInformation(String adbCommand, String devicesUid)
    {
        String result = null;

        String command = String.format(adbCommand, devicesUid);

        try
        {
            Process procGetDeviceOperator = Runtime.getRuntime().exec(command);

            try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(procGetDeviceOperator.getInputStream())))
            {
                result = processOutputReader.readLine();

                procGetDeviceOperator.waitFor();
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    private static String getDeviceIMEI(String deviceUid)
    {
        String IMEINumber = "";

        String command = String.format(ADBCommands.ADB_IPHONE_SUB_INFO.getAdbCommand(), deviceUid);

        Process procGetDeviceUID = null;
        try
        {
            procGetDeviceUID = Runtime.getRuntime().exec(command);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(procGetDeviceUID.getInputStream())))
        {
            String readLine;
            String result;

            while ((readLine = processOutputReader.readLine()) != null)
            {
                if (readLine.contains("'"))
                {
                    result = readLine.split("'")[1].replace(".", "").trim();
                    IMEINumber += result;
                }
            }

            procGetDeviceUID.waitFor();
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return IMEINumber;
    }

    private static String uiautomatorCondition(String androidVersion)
    {
        Integer version;

        try
        {
            version = Integer.valueOf(androidVersion.substring(0, 1));
        }
        catch (Exception ex)
        {
            return "NULL";
        }

        if (version <= 6)
        {
            return "UiAutomator1";
        }
        else
        {
            return "UiAutomator2";
        }
    }
}
