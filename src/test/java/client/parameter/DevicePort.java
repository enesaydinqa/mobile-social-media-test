package client.parameter;

public enum DevicePort
{
    //Android Platform Version

    PORT_4723("4723"),
    PORT_5050("5050"),
    PORT_5555("5555");


    public final String port;

    DevicePort(String port)
    {
        this.port = port;
    }
}
