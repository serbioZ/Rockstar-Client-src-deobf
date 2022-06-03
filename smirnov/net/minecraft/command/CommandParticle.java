// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldServer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.server.MinecraftServer;

public class CommandParticle extends CommandBase
{
    @Override
    public String getCommandName() {
        return "particle";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIlIlIIIIllIIllIIIII, final ICommandSender llllllllllllIIlIlIIIIllIIlllIlll, final String[] llllllllllllIIlIlIIIIllIIlllIllI) throws CommandException {
        if (llllllllllllIIlIlIIIIllIIlllIllI.length < 8) {
            throw new WrongUsageException("commands.particle.usage", new Object[0]);
        }
        final boolean llllllllllllIIlIlIIIIllIIlllIlIl = false;
        final EnumParticleTypes llllllllllllIIlIlIIIIllIIlllIlII = EnumParticleTypes.getByName(llllllllllllIIlIlIIIIllIIlllIllI[0]);
        if (llllllllllllIIlIlIIIIllIIlllIlII == null) {
            throw new CommandException("commands.particle.notFound", new Object[] { llllllllllllIIlIlIIIIllIIlllIllI[0] });
        }
        final String llllllllllllIIlIlIIIIllIIlllIIll = llllllllllllIIlIlIIIIllIIlllIllI[0];
        final Vec3d llllllllllllIIlIlIIIIllIIlllIIlI = llllllllllllIIlIlIIIIllIIlllIlll.getPositionVector();
        final double llllllllllllIIlIlIIIIllIIlllIIIl = (float)CommandBase.parseDouble(llllllllllllIIlIlIIIIllIIlllIIlI.xCoord, llllllllllllIIlIlIIIIllIIlllIllI[1], true);
        final double llllllllllllIIlIlIIIIllIIlllIIII = (float)CommandBase.parseDouble(llllllllllllIIlIlIIIIllIIlllIIlI.yCoord, llllllllllllIIlIlIIIIllIIlllIllI[2], true);
        final double llllllllllllIIlIlIIIIllIIllIllll = (float)CommandBase.parseDouble(llllllllllllIIlIlIIIIllIIlllIIlI.zCoord, llllllllllllIIlIlIIIIllIIlllIllI[3], true);
        final double llllllllllllIIlIlIIIIllIIllIlllI = (float)CommandBase.parseDouble(llllllllllllIIlIlIIIIllIIlllIllI[4]);
        final double llllllllllllIIlIlIIIIllIIllIllIl = (float)CommandBase.parseDouble(llllllllllllIIlIlIIIIllIIlllIllI[5]);
        final double llllllllllllIIlIlIIIIllIIllIllII = (float)CommandBase.parseDouble(llllllllllllIIlIlIIIIllIIlllIllI[6]);
        final double llllllllllllIIlIlIIIIllIIllIlIll = (float)CommandBase.parseDouble(llllllllllllIIlIlIIIIllIIlllIllI[7]);
        int llllllllllllIIlIlIIIIllIIllIlIlI = 0;
        if (llllllllllllIIlIlIIIIllIIlllIllI.length > 8) {
            llllllllllllIIlIlIIIIllIIllIlIlI = CommandBase.parseInt(llllllllllllIIlIlIIIIllIIlllIllI[8], 0);
        }
        boolean llllllllllllIIlIlIIIIllIIllIlIIl = false;
        if (llllllllllllIIlIlIIIIllIIlllIllI.length > 9 && "force".equals(llllllllllllIIlIlIIIIllIIlllIllI[9])) {
            llllllllllllIIlIlIIIIllIIllIlIIl = true;
        }
        EntityPlayerMP llllllllllllIIlIlIIIIllIIllIIlll = null;
        if (llllllllllllIIlIlIIIIllIIlllIllI.length > 10) {
            final EntityPlayerMP llllllllllllIIlIlIIIIllIIllIlIII = CommandBase.getPlayer(llllllllllllIIlIlIIIIllIIllIIIII, llllllllllllIIlIlIIIIllIIlllIlll, llllllllllllIIlIlIIIIllIIlllIllI[10]);
        }
        else {
            llllllllllllIIlIlIIIIllIIllIIlll = null;
        }
        final int[] llllllllllllIIlIlIIIIllIIllIIllI = new int[llllllllllllIIlIlIIIIllIIlllIlII.getArgumentCount()];
        for (int llllllllllllIIlIlIIIIllIIllIIlIl = 0; llllllllllllIIlIlIIIIllIIllIIlIl < llllllllllllIIlIlIIIIllIIllIIllI.length; ++llllllllllllIIlIlIIIIllIIllIIlIl) {
            if (llllllllllllIIlIlIIIIllIIlllIllI.length > 11 + llllllllllllIIlIlIIIIllIIllIIlIl) {
                try {
                    llllllllllllIIlIlIIIIllIIllIIllI[llllllllllllIIlIlIIIIllIIllIIlIl] = Integer.parseInt(llllllllllllIIlIlIIIIllIIlllIllI[11 + llllllllllllIIlIlIIIIllIIllIIlIl]);
                }
                catch (NumberFormatException llllllllllllIIlIlIIIIllIIllIIlII) {
                    throw new CommandException("commands.particle.invalidParam", new Object[] { llllllllllllIIlIlIIIIllIIlllIllI[11 + llllllllllllIIlIlIIIIllIIllIIlIl] });
                }
            }
        }
        final World llllllllllllIIlIlIIIIllIIllIIIll = llllllllllllIIlIlIIIIllIIlllIlll.getEntityWorld();
        if (llllllllllllIIlIlIIIIllIIllIIIll instanceof WorldServer) {
            final WorldServer llllllllllllIIlIlIIIIllIIllIIIlI = (WorldServer)llllllllllllIIlIlIIIIllIIllIIIll;
            if (llllllllllllIIlIlIIIIllIIllIIlll == null) {
                llllllllllllIIlIlIIIIllIIllIIIlI.spawnParticle(llllllllllllIIlIlIIIIllIIlllIlII, llllllllllllIIlIlIIIIllIIllIlIIl, llllllllllllIIlIlIIIIllIIlllIIIl, llllllllllllIIlIlIIIIllIIlllIIII, llllllllllllIIlIlIIIIllIIllIllll, llllllllllllIIlIlIIIIllIIllIlIlI, llllllllllllIIlIlIIIIllIIllIlllI, llllllllllllIIlIlIIIIllIIllIllIl, llllllllllllIIlIlIIIIllIIllIllII, llllllllllllIIlIlIIIIllIIllIlIll, llllllllllllIIlIlIIIIllIIllIIllI);
            }
            else {
                llllllllllllIIlIlIIIIllIIllIIIlI.spawnParticle(llllllllllllIIlIlIIIIllIIllIIlll, llllllllllllIIlIlIIIIllIIlllIlII, llllllllllllIIlIlIIIIllIIllIlIIl, llllllllllllIIlIlIIIIllIIlllIIIl, llllllllllllIIlIlIIIIllIIlllIIII, llllllllllllIIlIlIIIIllIIllIllll, llllllllllllIIlIlIIIIllIIllIlIlI, llllllllllllIIlIlIIIIllIIllIlllI, llllllllllllIIlIlIIIIllIIllIllIl, llllllllllllIIlIlIIIIllIIllIllII, llllllllllllIIlIlIIIIllIIllIlIll, llllllllllllIIlIlIIIIllIIllIIllI);
            }
            CommandBase.notifyCommandListener(llllllllllllIIlIlIIIIllIIlllIlll, this, "commands.particle.success", llllllllllllIIlIlIIIIllIIlllIIll, Math.max(llllllllllllIIlIlIIIIllIIllIlIlI, 1));
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIlIlIIIIllIIlIIIlII, final ICommandSender llllllllllllIIlIlIIIIllIIlIIIlll, final String[] llllllllllllIIlIlIIIIllIIlIIIllI, @Nullable final BlockPos llllllllllllIIlIlIIIIllIIlIIIlIl) {
        if (llllllllllllIIlIlIIIIllIIlIIIllI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIlIlIIIIllIIlIIIllI, EnumParticleTypes.getParticleNames());
        }
        if (llllllllllllIIlIlIIIIllIIlIIIllI.length > 1 && llllllllllllIIlIlIIIIllIIlIIIllI.length <= 4) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllIIlIlIIIIllIIlIIIllI, 1, llllllllllllIIlIlIIIIllIIlIIIlIl);
        }
        if (llllllllllllIIlIlIIIIllIIlIIIllI.length == 10) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIlIlIIIIllIIlIIIllI, "normal", "force");
        }
        return (llllllllllllIIlIlIIIIllIIlIIIllI.length == 11) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIlIlIIIIllIIlIIIllI, llllllllllllIIlIlIIIIllIIlIIIlII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIIlIlIIIIllIIIllllll, final int llllllllllllIIlIlIIIIllIIIlllllI) {
        return llllllllllllIIlIlIIIIllIIIlllllI == 10;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIlIlIIIIllIlIIIllll) {
        return "commands.particle.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
