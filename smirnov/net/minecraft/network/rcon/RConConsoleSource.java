// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.rcon;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;

public class RConConsoleSource implements ICommandSender
{
    private final /* synthetic */ MinecraftServer server;
    private final /* synthetic */ StringBuffer buffer;
    
    @Override
    public boolean sendCommandFeedback() {
        return true;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllIllllIIllIlIlIIllIlllI, final String llllllllllIllllIIllIlIlIIllIllIl) {
        return true;
    }
    
    @Override
    public void addChatMessage(final ITextComponent llllllllllIllllIIllIlIlIIlllIIII) {
        this.buffer.append(llllllllllIllllIIllIlIlIIlllIIII.getUnformattedText());
    }
    
    @Override
    public World getEntityWorld() {
        return this.server.getEntityWorld();
    }
    
    @Override
    public String getName() {
        return "Rcon";
    }
    
    public RConConsoleSource(final MinecraftServer llllllllllIllllIIllIlIlIIllllIIl) {
        this.buffer = new StringBuffer();
        this.server = llllllllllIllllIIllIlIlIIllllIIl;
    }
    
    @Override
    public MinecraftServer getServer() {
        return this.server;
    }
}
