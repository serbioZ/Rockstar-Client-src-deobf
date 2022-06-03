// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.network;

import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.Collections;
import com.google.common.collect.Lists;
import net.minecraft.client.multiplayer.ThreadLanServerPing;
import java.net.InetAddress;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.Logger;

public class LanServerDetector
{
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ AtomicInteger ATOMIC_COUNTER;
    
    static {
        ATOMIC_COUNTER = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
    }
    
    public static class LanServerList
    {
        private final /* synthetic */ List<LanServerInfo> listOfLanServers;
        /* synthetic */ boolean wasUpdated;
        
        public synchronized void addServer(final String llllllllllllllIIlIIIlIlIIIIIIlll, final InetAddress llllllllllllllIIlIIIlIlIIIIIIllI) {
            final String llllllllllllllIIlIIIlIlIIIIIllII = ThreadLanServerPing.getMotdFromPingResponse(llllllllllllllIIlIIIlIlIIIIIIlll);
            String llllllllllllllIIlIIIlIlIIIIIlIll = ThreadLanServerPing.getAdFromPingResponse(llllllllllllllIIlIIIlIlIIIIIIlll);
            if (llllllllllllllIIlIIIlIlIIIIIlIll != null) {
                llllllllllllllIIlIIIlIlIIIIIlIll = String.valueOf(llllllllllllllIIlIIIlIlIIIIIIllI.getHostAddress()) + ":" + llllllllllllllIIlIIIlIlIIIIIlIll;
                boolean llllllllllllllIIlIIIlIlIIIIIlIlI = false;
                for (final LanServerInfo llllllllllllllIIlIIIlIlIIIIIlIIl : this.listOfLanServers) {
                    if (llllllllllllllIIlIIIlIlIIIIIlIIl.getServerIpPort().equals(llllllllllllllIIlIIIlIlIIIIIlIll)) {
                        llllllllllllllIIlIIIlIlIIIIIlIIl.updateLastSeen();
                        llllllllllllllIIlIIIlIlIIIIIlIlI = true;
                        break;
                    }
                }
                if (!llllllllllllllIIlIIIlIlIIIIIlIlI) {
                    this.listOfLanServers.add(new LanServerInfo(llllllllllllllIIlIIIlIlIIIIIllII, llllllllllllllIIlIIIlIlIIIIIlIll));
                    this.wasUpdated = true;
                }
            }
        }
        
        public LanServerList() {
            this.listOfLanServers = (List<LanServerInfo>)Lists.newArrayList();
        }
        
        public synchronized void setWasNotUpdated() {
            this.wasUpdated = false;
        }
        
        public synchronized boolean getWasUpdated() {
            return this.wasUpdated;
        }
        
        public synchronized List<LanServerInfo> getLanServers() {
            return Collections.unmodifiableList((List<? extends LanServerInfo>)this.listOfLanServers);
        }
    }
    
    public static class ThreadLanServerFind extends Thread
    {
        private final /* synthetic */ InetAddress broadcastAddress;
        private final /* synthetic */ MulticastSocket socket;
        private final /* synthetic */ LanServerList localServerList;
        
        @Override
        public void run() {
            final byte[] llllllllllllIIllllIlIlIIIIlIIIIl = new byte[1024];
            while (!this.isInterrupted()) {
                final DatagramPacket llllllllllllIIllllIlIlIIIIlIIIII = new DatagramPacket(llllllllllllIIllllIlIlIIIIlIIIIl, llllllllllllIIllllIlIlIIIIlIIIIl.length);
                try {
                    this.socket.receive(llllllllllllIIllllIlIlIIIIlIIIII);
                }
                catch (SocketTimeoutException llllllllllllIIllllIlIlIIIIIlllll) {
                    continue;
                }
                catch (IOException llllllllllllIIllllIlIlIIIIIllllI) {
                    LanServerDetector.LOGGER.error("Couldn't ping server", (Throwable)llllllllllllIIllllIlIlIIIIIllllI);
                    break;
                }
                final String llllllllllllIIllllIlIlIIIIIlllIl = new String(llllllllllllIIllllIlIlIIIIlIIIII.getData(), llllllllllllIIllllIlIlIIIIlIIIII.getOffset(), llllllllllllIIllllIlIlIIIIlIIIII.getLength(), StandardCharsets.UTF_8);
                LanServerDetector.LOGGER.debug("{}: {}", (Object)llllllllllllIIllllIlIlIIIIlIIIII.getAddress(), (Object)llllllllllllIIllllIlIlIIIIIlllIl);
                this.localServerList.addServer(llllllllllllIIllllIlIlIIIIIlllIl, llllllllllllIIllllIlIlIIIIlIIIII.getAddress());
            }
            try {
                this.socket.leaveGroup(this.broadcastAddress);
            }
            catch (IOException ex) {}
            this.socket.close();
        }
        
        public ThreadLanServerFind(final LanServerList llllllllllllIIllllIlIlIIIIlIIlll) throws IOException {
            super("LanServerDetector #" + LanServerDetector.ATOMIC_COUNTER.incrementAndGet());
            this.localServerList = llllllllllllIIllllIlIlIIIIlIIlll;
            this.setDaemon(true);
            this.socket = new MulticastSocket(4445);
            this.broadcastAddress = InetAddress.getByName("224.0.2.60");
            this.socket.setSoTimeout(5000);
            this.socket.joinGroup(this.broadcastAddress);
        }
    }
}
