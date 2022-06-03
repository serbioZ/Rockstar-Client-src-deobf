// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class CommandShowSeed extends CommandBase
{
    @Override
    public String getCommandName() {
        return "seed";
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllIIIlIIlIIlllllIllIIll, final ICommandSender lllllllllllIIIlIIlIIlllllIllIIlI) {
        return lllllllllllIIIlIIlIIlllllIllIIll.isSinglePlayer() || super.checkPermission(lllllllllllIIIlIIlIIlllllIllIIll, lllllllllllIIIlIIlIIlllllIllIIlI);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIIlIIlIIlllllIlIIlIl, final ICommandSender lllllllllllIIIlIIlIIlllllIlIIlII, final String[] lllllllllllIIIlIIlIIlllllIlIIlll) throws CommandException {
        final World lllllllllllIIIlIIlIIlllllIlIIllI = (lllllllllllIIIlIIlIIlllllIlIIlII instanceof EntityPlayer) ? ((EntityPlayer)lllllllllllIIIlIIlIIlllllIlIIlII).world : lllllllllllIIIlIIlIIlllllIlIIlIl.worldServerForDimension(0);
        lllllllllllIIIlIIlIIlllllIlIIlII.addChatMessage(new TextComponentTranslation("commands.seed.success", new Object[] { lllllllllllIIIlIIlIIlllllIlIIllI.getSeed() }));
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIIlIIlIIlllllIlIlllI) {
        return "commands.seed.usage";
    }
}
