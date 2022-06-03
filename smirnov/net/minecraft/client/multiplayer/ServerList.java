// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.CompressedStreamTools;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;

public class ServerList
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ List<ServerData> servers;
    
    public int countServers() {
        return this.servers.size();
    }
    
    public ServerList(final Minecraft llllllllllllIIIIIIlIlIIIIIlIIIII) {
        this.servers = (List<ServerData>)Lists.newArrayList();
        this.mc = llllllllllllIIIIIIlIlIIIIIlIIIII;
        this.loadServerList();
    }
    
    public void set(final int llllllllllllIIIIIIlIIlllllIlllIl, final ServerData llllllllllllIIIIIIlIIlllllIlllII) {
        this.servers.set(llllllllllllIIIIIIlIIlllllIlllIl, llllllllllllIIIIIIlIIlllllIlllII);
    }
    
    public void addServerData(final ServerData llllllllllllIIIIIIlIIlllllllIllI) {
        this.servers.add(llllllllllllIIIIIIlIIlllllllIllI);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void loadServerList() {
        try {
            this.servers.clear();
            final NBTTagCompound llllllllllllIIIIIIlIlIIIIIIllIlI = CompressedStreamTools.read(new File(this.mc.mcDataDir, "servers.dat"));
            if (llllllllllllIIIIIIlIlIIIIIIllIlI == null) {
                return;
            }
            final NBTTagList llllllllllllIIIIIIlIlIIIIIIllIIl = llllllllllllIIIIIIlIlIIIIIIllIlI.getTagList("servers", 10);
            for (int llllllllllllIIIIIIlIlIIIIIIllIII = 0; llllllllllllIIIIIIlIlIIIIIIllIII < llllllllllllIIIIIIlIlIIIIIIllIIl.tagCount(); ++llllllllllllIIIIIIlIlIIIIIIllIII) {
                this.servers.add(ServerData.getServerDataFromNBTCompound(llllllllllllIIIIIIlIlIIIIIIllIIl.getCompoundTagAt(llllllllllllIIIIIIlIlIIIIIIllIII)));
            }
        }
        catch (Exception llllllllllllIIIIIIlIlIIIIIIlIlll) {
            ServerList.LOGGER.error("Couldn't load server list", (Throwable)llllllllllllIIIIIIlIlIIIIIIlIlll);
        }
    }
    
    public void swapServers(final int llllllllllllIIIIIIlIIllllllIIlll, final int llllllllllllIIIIIIlIIllllllIlIlI) {
        final ServerData llllllllllllIIIIIIlIIllllllIlIIl = this.getServerData(llllllllllllIIIIIIlIIllllllIIlll);
        this.servers.set(llllllllllllIIIIIIlIIllllllIIlll, this.getServerData(llllllllllllIIIIIIlIIllllllIlIlI));
        this.servers.set(llllllllllllIIIIIIlIIllllllIlIlI, llllllllllllIIIIIIlIIllllllIlIIl);
        this.saveServerList();
    }
    
    public static void saveSingleServer(final ServerData llllllllllllIIIIIIlIIlllllIlIIll) {
        final ServerList llllllllllllIIIIIIlIIlllllIlIllI = new ServerList(Minecraft.getMinecraft());
        llllllllllllIIIIIIlIIlllllIlIllI.loadServerList();
        for (int llllllllllllIIIIIIlIIlllllIlIlIl = 0; llllllllllllIIIIIIlIIlllllIlIlIl < llllllllllllIIIIIIlIIlllllIlIllI.countServers(); ++llllllllllllIIIIIIlIIlllllIlIlIl) {
            final ServerData llllllllllllIIIIIIlIIlllllIlIlII = llllllllllllIIIIIIlIIlllllIlIllI.getServerData(llllllllllllIIIIIIlIIlllllIlIlIl);
            if (llllllllllllIIIIIIlIIlllllIlIlII.serverName.equals(llllllllllllIIIIIIlIIlllllIlIIll.serverName) && llllllllllllIIIIIIlIIlllllIlIlII.serverIP.equals(llllllllllllIIIIIIlIIlllllIlIIll.serverIP)) {
                llllllllllllIIIIIIlIIlllllIlIllI.set(llllllllllllIIIIIIlIIlllllIlIlIl, llllllllllllIIIIIIlIIlllllIlIIll);
                break;
            }
        }
        llllllllllllIIIIIIlIIlllllIlIllI.saveServerList();
    }
    
    public ServerData getServerData(final int llllllllllllIIIIIIlIlIIIIIIIIIlI) {
        return this.servers.get(llllllllllllIIIIIIlIlIIIIIIIIIlI);
    }
    
    public void saveServerList() {
        try {
            final NBTTagList llllllllllllIIIIIIlIlIIIIIIIllIl = new NBTTagList();
            for (final ServerData llllllllllllIIIIIIlIlIIIIIIIllII : this.servers) {
                llllllllllllIIIIIIlIlIIIIIIIllIl.appendTag(llllllllllllIIIIIIlIlIIIIIIIllII.getNBTCompound());
            }
            final NBTTagCompound llllllllllllIIIIIIlIlIIIIIIIlIll = new NBTTagCompound();
            llllllllllllIIIIIIlIlIIIIIIIlIll.setTag("servers", llllllllllllIIIIIIlIlIIIIIIIllIl);
            CompressedStreamTools.safeWrite(llllllllllllIIIIIIlIlIIIIIIIlIll, new File(this.mc.mcDataDir, "servers.dat"));
        }
        catch (Exception llllllllllllIIIIIIlIlIIIIIIIlIlI) {
            ServerList.LOGGER.error("Couldn't save server list", (Throwable)llllllllllllIIIIIIlIlIIIIIIIlIlI);
        }
    }
    
    public void removeServerData(final int llllllllllllIIIIIIlIIlllllllllII) {
        this.servers.remove(llllllllllllIIIIIIlIIlllllllllII);
    }
}
