package context;

import client.parameter.DevicePort;
import client.parameter.DeviceServer;
import client.parameter.PlatformName;
import client.parameter.PlatformVersion;

public enum MobileDevice
{
    /**
     * ------------------------------------------------------------------
     * Android Device List
     * ------------------------------------------------------------------
     */

    ANDROID_SIMULATOR
            (
                    PlatformName.ANDROID,
                    PlatformVersion.ANDROID_8_1_0,
                    "Test Device",
                    null,
                    DeviceServer.SERVER_LOCAL_LOOPBACK,
                    DevicePort.PORT_4723
            ),

    SONY_XZ_PREMIUM
            (
                    PlatformName.ANDROID,
                    PlatformVersion.ANDROID_7_1_1,
                    "Sony XZ Premium",
                    "CB512FN695",
                    DeviceServer.SERVER_LOCAL_LOOPBACK,
                    DevicePort.PORT_5555
            ),

    SAMSUNG_NOTE_4
            (
                    PlatformName.ANDROID,
                    PlatformVersion.ANDROID_4_4_4,
                    "Samsung Note 4",
                    "39830042",
                    DeviceServer.SERVER_LOCAL_LOOPBACK,
                    DevicePort.PORT_5555
            ),

    SAMSUNG_S6
            (
                    PlatformName.ANDROID,
                    PlatformVersion.ANDROID_6_0_1,
                    "Samsung Galaxy S6",
                    "031603a436923b01",
                    DeviceServer.SERVER_LOCAL_LOOPBACK,
                    DevicePort.PORT_5050
            );

    public final String platformName;
    public final String platformVersion;
    public final String name;
    public final String uid;
    public final String port;
    public final String serverIp;

    MobileDevice
            (
                    PlatformName platformName,
                    PlatformVersion platformVersion,
                    String name,
                    String uid,
                    DeviceServer deviceServer,
                    DevicePort devicePort
            )
    {
        this.platformName = platformName.platformName;
        this.platformVersion = platformVersion.version;
        this.name = name;
        this.uid = uid;
        this.port = devicePort.port;
        this.serverIp = deviceServer.ip;
    }
}
