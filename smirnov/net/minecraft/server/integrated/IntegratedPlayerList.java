// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.integrated;

import net.minecraft.server.MinecraftServer;
import com.mojang.authlib.GameProfile;
import java.net.SocketAddress;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.management.PlayerList;

public class IntegratedPlayerList extends PlayerList
{
    private /* synthetic */ NBTTagCompound hostPlayerData;
    
    @Override
    protected void writePlayerData(final EntityPlayerMP llllllllllllIIIlIIIlIlIllIIlllIl) {
        if (llllllllllllIIIlIIIlIlIllIIlllIl.getName().equals(this.getServerInstance().getServerOwner())) {
            this.hostPlayerData = llllllllllllIIIlIIIlIlIllIIlllIl.writeToNBT(new NBTTagCompound());
        }
        super.writePlayerData(llllllllllllIIIlIIIlIlIllIIlllIl);
    }
    
    @Override
    public String allowUserToConnect(final SocketAddress llllllllllllIIIlIIIlIlIllIIlIlIl, final GameProfile llllllllllllIIIlIIIlIlIllIIlIlll) {
        return (llllllllllllIIIlIIIlIlIllIIlIlll.getName().equalsIgnoreCase(this.getServerInstance().getServerOwner()) && this.getPlayerByUsername(llllllllllllIIIlIIIlIlIllIIlIlll.getName()) != null) ? "That name is already taken." : super.allowUserToConnect(llllllllllllIIIlIIIlIlIllIIlIlIl, llllllllllllIIIlIIIlIlIllIIlIlll);
    }
    
    @Override
    public NBTTagCompound getHostPlayerData() {
        return this.hostPlayerData;
    }
    
    @Override
    public IntegratedServer getServerInstance() {
        return (IntegratedServer)super.getServerInstance();
    }
    
    public IntegratedPlayerList(final IntegratedServer llllllllllllIIIlIIIlIlIllIlIIlIl) {
        super(llllllllllllIIIlIIIlIlIllIlIIlIl);
        this.setViewDistance(10);
    }
}
