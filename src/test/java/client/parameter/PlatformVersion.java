package client.parameter;

public enum  PlatformVersion
{
    //Android Platform Version
    ANDROID_4_4_4("4.4.4"),
    ANDROID_6_0_1("6.0.1"),
    ANDROID_7_1_1("7.1.1"),
    ANDROID_8_1_0("8.1.0");

    public final String version;

    PlatformVersion(String version)
    {
        this.version = version;
    }

}
