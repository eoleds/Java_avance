package chatsys.packet.reception;

import java.io.DataInputStream;
import java.io.IOException;
import  java.net.InetAddress;
import java.util.UUID;

import chatsys.controller.PacketController;

public class PacketRcLogin implements PacketReception {
    private UUID uuid;
    private InetAddress ip;
    private String name;

    @Override
    public void initStream(DataInputStream stream) throws IOException{
        this.uuid = UUID.fromString(stream.readUTF());
        this.ip = InetAddress.getByName(stream.readUTF());
        this.name = stream.readUTF();
    }
    @Override
    //Faire void processPacket une fois qu'on a fait le ListenerManager

    @Override
    public String toString(){
        return String.format("PacketRCLogin[uuid=%s, name=%s, ip=%s]", uuid, name, ip.getHostAddress());
    }
}
