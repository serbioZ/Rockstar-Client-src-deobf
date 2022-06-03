// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.Logger;
import java.net.DatagramSocket;

public class ThreadLanServerPing extends Thread
{
    private final /* synthetic */ String address;
    private final /* synthetic */ DatagramSocket socket;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean isStopping;
    private final /* synthetic */ String motd;
    private static final /* synthetic */ AtomicInteger UNIQUE_THREAD_ID;
    
    public static String getPingResponse(final String lllllllllllIlIlIIIlllIlIIlIIlIII, final String lllllllllllIlIlIIIlllIlIIlIIlIIl) {
        return "[MOTD]" + lllllllllllIlIlIIIlllIlIIlIIlIII + "[/MOTD][AD]" + lllllllllllIlIlIIIlllIlIIlIIlIIl + "[/AD]";
    }
    
    static {
        UNIQUE_THREAD_ID = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void interrupt() {
        super.interrupt();
        this.isStopping = false;
    }
    
    public static String getAdFromPingResponse(final String lllllllllllIlIlIIIlllIlIIIllIIll) {
        final int lllllllllllIlIlIIIlllIlIIIllIlll = lllllllllllIlIlIIIlllIlIIIllIIll.indexOf("[/MOTD]");
        if (lllllllllllIlIlIIIlllIlIIIllIlll < 0) {
            return null;
        }
        final int lllllllllllIlIlIIIlllIlIIIllIllI = lllllllllllIlIlIIIlllIlIIIllIIll.indexOf("[/MOTD]", lllllllllllIlIlIIIlllIlIIIllIlll + "[/MOTD]".length());
        if (lllllllllllIlIlIIIlllIlIIIllIllI >= 0) {
            return null;
        }
        final int lllllllllllIlIlIIIlllIlIIIllIlIl = lllllllllllIlIlIIIlllIlIIIllIIll.indexOf("[AD]", lllllllllllIlIlIIIlllIlIIIllIlll + "[/MOTD]".length());
        if (lllllllllllIlIlIIIlllIlIIIllIlIl < 0) {
            return null;
        }
        final int lllllllllllIlIlIIIlllIlIIIllIlII = lllllllllllIlIlIIIlllIlIIIllIIll.indexOf("[/AD]", lllllllllllIlIlIIIlllIlIIIllIlIl + "[AD]".length());
        return (lllllllllllIlIlIIIlllIlIIIllIlII < lllllllllllIlIlIIIlllIlIIIllIlIl) ? null : lllllllllllIlIlIIIlllIlIIIllIIll.substring(lllllllllllIlIlIIIlllIlIIIllIlIl + "[AD]".length(), lllllllllllIlIlIIIlllIlIIIllIlII);
    }
    
    public ThreadLanServerPing(final String lllllllllllIlIlIIIlllIlIIllIIIIl, final String lllllllllllIlIlIIIlllIlIIllIIIll) throws IOException {
        super("LanServerPinger #" + ThreadLanServerPing.UNIQUE_THREAD_ID.incrementAndGet());
        this.isStopping = true;
        this.motd = lllllllllllIlIlIIIlllIlIIllIIIIl;
        this.address = lllllllllllIlIlIIIlllIlIIllIIIll;
        this.setDaemon(true);
        this.socket = new DatagramSocket();
    }
    
    public static String getMotdFromPingResponse(final String lllllllllllIlIlIIIlllIlIIlIIIIll) {
        final int lllllllllllIlIlIIIlllIlIIlIIIIlI = lllllllllllIlIlIIIlllIlIIlIIIIll.indexOf("[MOTD]");
        if (lllllllllllIlIlIIIlllIlIIlIIIIlI < 0) {
            return "missing no";
        }
        final int lllllllllllIlIlIIIlllIlIIlIIIIIl = lllllllllllIlIlIIIlllIlIIlIIIIll.indexOf("[/MOTD]", lllllllllllIlIlIIIlllIlIIlIIIIlI + "[MOTD]".length());
        return (lllllllllllIlIlIIIlllIlIIlIIIIIl < lllllllllllIlIlIIIlllIlIIlIIIIlI) ? "missing no" : lllllllllllIlIlIIIlllIlIIlIIIIll.substring(lllllllllllIlIlIIIlllIlIIlIIIIlI + "[MOTD]".length(), lllllllllllIlIlIIIlllIlIIlIIIIIl);
    }
    
    @Override
    public void run() {
        final String lllllllllllIlIlIIIlllIlIIlIllIIl = getPingResponse(this.motd, this.address);
        final byte[] lllllllllllIlIlIIIlllIlIIlIllIII = lllllllllllIlIlIIIlllIlIIlIllIIl.getBytes(StandardCharsets.UTF_8);
        while (!this.isInterrupted() && this.isStopping) {
            try {
                final InetAddress lllllllllllIlIlIIIlllIlIIlIlIlll = InetAddress.getByName("224.0.2.60");
                final DatagramPacket lllllllllllIlIlIIIlllIlIIlIlIllI = new DatagramPacket(lllllllllllIlIlIIIlllIlIIlIllIII, lllllllllllIlIlIIIlllIlIIlIllIII.length, lllllllllllIlIlIIIlllIlIIlIlIlll, 4445);
                this.socket.send(lllllllllllIlIlIIIlllIlIIlIlIllI);
            }
            catch (IOException lllllllllllIlIlIIIlllIlIIlIlIlIl) {
                ThreadLanServerPing.LOGGER.warn("LanServerPinger: {}", (Object)lllllllllllIlIlIIIlllIlIIlIlIlIl.getMessage());
                break;
            }
            try {
                Thread.sleep(1500L);
            }
            catch (InterruptedException ex) {}
        }
    }
}
