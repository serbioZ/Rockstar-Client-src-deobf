// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.nbt.NBTTagCompound;

public class ServerData
{
    public /* synthetic */ String gameVersion;
    public /* synthetic */ int version;
    public /* synthetic */ String serverName;
    public /* synthetic */ String serverIP;
    private /* synthetic */ ServerResourceMode resourceMode;
    private /* synthetic */ String serverIcon;
    private /* synthetic */ boolean lanServer;
    
    public void setResourceMode(final ServerResourceMode llllllllllllIIIllIlllIIIIlllllll) {
        this.resourceMode = llllllllllllIIIllIlllIIIIlllllll;
    }
    
    public static ServerData getServerDataFromNBTCompound(final NBTTagCompound llllllllllllIIIllIlllIIIIllllIlI) {
        final ServerData llllllllllllIIIllIlllIIIIllllIll = new ServerData(llllllllllllIIIllIlllIIIIllllIlI.getString("name"), llllllllllllIIIllIlllIIIIllllIlI.getString("ip"), false);
        if (llllllllllllIIIllIlllIIIIllllIlI.hasKey("icon", 8)) {
            llllllllllllIIIllIlllIIIIllllIll.setBase64EncodedIconData(llllllllllllIIIllIlllIIIIllllIlI.getString("icon"));
        }
        if (llllllllllllIIIllIlllIIIIllllIlI.hasKey("acceptTextures", 1)) {
            if (llllllllllllIIIllIlllIIIIllllIlI.getBoolean("acceptTextures")) {
                llllllllllllIIIllIlllIIIIllllIll.setResourceMode(ServerResourceMode.ENABLED);
            }
            else {
                llllllllllllIIIllIlllIIIIllllIll.setResourceMode(ServerResourceMode.DISABLED);
            }
        }
        else {
            llllllllllllIIIllIlllIIIIllllIll.setResourceMode(ServerResourceMode.PROMPT);
        }
        return llllllllllllIIIllIlllIIIIllllIll;
    }
    
    public boolean isOnLAN() {
        return this.lanServer;
    }
    
    public void copyFrom(final ServerData llllllllllllIIIllIlllIIIIllIIlll) {
        this.serverIP = llllllllllllIIIllIlllIIIIllIIlll.serverIP;
        this.serverName = llllllllllllIIIllIlllIIIIllIIlll.serverName;
        this.setResourceMode(llllllllllllIIIllIlllIIIIllIIlll.getResourceMode());
        this.serverIcon = llllllllllllIIIllIlllIIIIllIIlll.serverIcon;
        this.lanServer = llllllllllllIIIllIlllIIIIllIIlll.lanServer;
    }
    
    public NBTTagCompound getNBTCompound() {
        final NBTTagCompound llllllllllllIIIllIlllIIIlIIIlIlI = new NBTTagCompound();
        llllllllllllIIIllIlllIIIlIIIlIlI.setString("name", this.serverName);
        llllllllllllIIIllIlllIIIlIIIlIlI.setString("ip", this.serverIP);
        if (this.serverIcon != null) {
            llllllllllllIIIllIlllIIIlIIIlIlI.setString("icon", this.serverIcon);
        }
        if (this.resourceMode == ServerResourceMode.ENABLED) {
            llllllllllllIIIllIlllIIIlIIIlIlI.setBoolean("acceptTextures", true);
        }
        else if (this.resourceMode == ServerResourceMode.DISABLED) {
            llllllllllllIIIllIlllIIIlIIIlIlI.setBoolean("acceptTextures", false);
        }
        return llllllllllllIIIllIlllIIIlIIIlIlI;
    }
    
    public ServerResourceMode getResourceMode() {
        return this.resourceMode;
    }
    
    public ServerData(final String llllllllllllIIIllIlllIIIlIIlIIII, final String llllllllllllIIIllIlllIIIlIIIllll, final boolean llllllllllllIIIllIlllIIIlIIlIIlI) {
        this.version = 340;
        this.gameVersion = "1.12.2";
        this.resourceMode = ServerResourceMode.PROMPT;
        this.serverName = llllllllllllIIIllIlllIIIlIIlIIII;
        this.serverIP = llllllllllllIIIllIlllIIIlIIIllll;
        this.lanServer = llllllllllllIIIllIlllIIIlIIlIIlI;
    }
    
    public void setBase64EncodedIconData(final String llllllllllllIIIllIlllIIIIlllIIlI) {
        this.serverIcon = llllllllllllIIIllIlllIIIIlllIIlI;
    }
    
    public String getBase64EncodedIconData() {
        return this.serverIcon;
    }
    
    public enum ServerResourceMode
    {
        DISABLED("DISABLED", 1, "disabled");
        
        private final /* synthetic */ ITextComponent motd;
        
        PROMPT("PROMPT", 2, "prompt"), 
        ENABLED("ENABLED", 0, "enabled");
        
        private ServerResourceMode(final String llllllllllllllIllIllIIllllllIlIl, final int llllllllllllllIllIllIIllllllIlII, final String llllllllllllllIllIllIIllllllIlll) {
            this.motd = new TextComponentTranslation("addServer.resourcePack." + llllllllllllllIllIllIIllllllIlll, new Object[0]);
        }
        
        public ITextComponent getMotd() {
            return this.motd;
        }
    }
}
