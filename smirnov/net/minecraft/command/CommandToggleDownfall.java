// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.world.storage.WorldInfo;
import net.minecraft.server.MinecraftServer;

public class CommandToggleDownfall extends CommandBase
{
    @Override
    public String getCommandName() {
        return "toggledownfall";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIlIlIIlllllllIIIIll, final ICommandSender llllllllllllIIlIlIIlllllllIIIIlI, final String[] llllllllllllIIlIlIIlllllllIIIIIl) throws CommandException {
        this.toggleRainfall(llllllllllllIIlIlIIlllllllIIIIll);
        CommandBase.notifyCommandListener(llllllllllllIIlIlIIlllllllIIIIlI, this, "commands.downfall.success", new Object[0]);
    }
    
    protected void toggleRainfall(final MinecraftServer llllllllllllIIlIlIIllllllIlllIII) {
        final WorldInfo llllllllllllIIlIlIIllllllIlllIIl = llllllllllllIIlIlIIllllllIlllIII.worldServers[0].getWorldInfo();
        llllllllllllIIlIlIIllllllIlllIIl.setRaining(!llllllllllllIIlIlIIllllllIlllIIl.isRaining());
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIlIlIIlllllllIIlIII) {
        return "commands.downfall.usage";
    }
}
