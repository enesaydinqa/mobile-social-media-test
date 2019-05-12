package com.appium.utils;

public enum ADBCommands
{
    ADB_DEVICES("adb devices"),
    ADB_GSM_SIM_OPERATOR_ALPHA("adb -s %s shell getprop gsm.sim.operator.alpha"),
    ADB_RO_BUILD_VERSION_RELEASE("adb -s %s shell getprop ro.build.version.release"),
    ADB_IPHONE_SUB_INFO("adb -s %s shell service call iphonesubinfo 1");

    private String adbCommand;

    ADBCommands(String adbCommand)
    {
        this.adbCommand = adbCommand;
    }

    public String getAdbCommand()
    {
        return adbCommand;
    }
}
