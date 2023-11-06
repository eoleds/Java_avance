package chatsys.packet.envoie;

import chatsys.packet.Packet;
import java.io.IOException;
import java.io.DataOutputStream;
public interface PacketEmission extends Packet {
    void sendPacket(DataOutputStream stream) throws IOException;
}
