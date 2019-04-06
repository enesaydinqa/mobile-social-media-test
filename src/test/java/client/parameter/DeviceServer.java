package client.parameter;

public enum DeviceServer
{
    SERVER_LOCAL("0.0.0.0"),
    SERVER_LOCAL_LOOPBACK("127.0.0.1");

    public final String ip;

    DeviceServer(String ip)
    {
        this.ip = ip;
    }
}
