// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import net.minecraft.util.SoundEvent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.util.SoundCategory;
import net.minecraft.server.MinecraftServer;

public class CommandPlaySound extends CommandBase
{
    @Override
    public String getCommandName() {
        return "playsound";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlllIIIIIIlIllIlllIl) {
        return "commands.playsound.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIlllIIIIIIlIllIIIlIl, final ICommandSender llllllllllllIlllIIIIIIlIllIIIlII, final String[] llllllllllllIlllIIIIIIlIllIIIIll) throws CommandException {
        if (llllllllllllIlllIIIIIIlIllIIIIll.length < 2) {
            throw new WrongUsageException(this.getCommandUsage(llllllllllllIlllIIIIIIlIllIIIlII), new Object[0]);
        }
        int llllllllllllIlllIIIIIIlIllIIIIlI = 0;
        final String llllllllllllIlllIIIIIIlIllIIIIIl = llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++];
        final String llllllllllllIlllIIIIIIlIllIIIIII = llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++];
        final SoundCategory llllllllllllIlllIIIIIIlIlIllllll = SoundCategory.getByName(llllllllllllIlllIIIIIIlIllIIIIII);
        if (llllllllllllIlllIIIIIIlIlIllllll == null) {
            throw new CommandException("commands.playsound.unknownSoundSource", new Object[] { llllllllllllIlllIIIIIIlIllIIIIII });
        }
        final EntityPlayerMP llllllllllllIlllIIIIIIlIlIlllllI = CommandBase.getPlayer(llllllllllllIlllIIIIIIlIllIIIlIl, llllllllllllIlllIIIIIIlIllIIIlII, llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++]);
        final Vec3d llllllllllllIlllIIIIIIlIlIllllIl = llllllllllllIlllIIIIIIlIllIIIlII.getPositionVector();
        double llllllllllllIlllIIIIIIlIlIllllII = (llllllllllllIlllIIIIIIlIllIIIIll.length > llllllllllllIlllIIIIIIlIllIIIIlI) ? CommandBase.parseDouble(llllllllllllIlllIIIIIIlIlIllllIl.xCoord, llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++], true) : llllllllllllIlllIIIIIIlIlIllllIl.xCoord;
        double llllllllllllIlllIIIIIIlIlIlllIll = (llllllllllllIlllIIIIIIlIllIIIIll.length > llllllllllllIlllIIIIIIlIllIIIIlI) ? CommandBase.parseDouble(llllllllllllIlllIIIIIIlIlIllllIl.yCoord, llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++], 0, 0, false) : llllllllllllIlllIIIIIIlIlIllllIl.yCoord;
        double llllllllllllIlllIIIIIIlIlIlllIlI = (llllllllllllIlllIIIIIIlIllIIIIll.length > llllllllllllIlllIIIIIIlIllIIIIlI) ? CommandBase.parseDouble(llllllllllllIlllIIIIIIlIlIllllIl.zCoord, llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++], true) : llllllllllllIlllIIIIIIlIlIllllIl.zCoord;
        double llllllllllllIlllIIIIIIlIlIlllIIl = (llllllllllllIlllIIIIIIlIllIIIIll.length > llllllllllllIlllIIIIIIlIllIIIIlI) ? CommandBase.parseDouble(llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++], 0.0, 3.4028234663852886E38) : 1.0;
        final double llllllllllllIlllIIIIIIlIlIlllIII = (llllllllllllIlllIIIIIIlIllIIIIll.length > llllllllllllIlllIIIIIIlIllIIIIlI) ? CommandBase.parseDouble(llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI++], 0.0, 2.0) : 1.0;
        final double llllllllllllIlllIIIIIIlIlIllIlll = (llllllllllllIlllIIIIIIlIllIIIIll.length > llllllllllllIlllIIIIIIlIllIIIIlI) ? CommandBase.parseDouble(llllllllllllIlllIIIIIIlIllIIIIll[llllllllllllIlllIIIIIIlIllIIIIlI], 0.0, 1.0) : 0.0;
        final double llllllllllllIlllIIIIIIlIlIllIllI = (llllllllllllIlllIIIIIIlIlIlllIIl > 1.0) ? (llllllllllllIlllIIIIIIlIlIlllIIl * 16.0) : 16.0;
        final double llllllllllllIlllIIIIIIlIlIllIlIl = llllllllllllIlllIIIIIIlIlIlllllI.getDistance(llllllllllllIlllIIIIIIlIlIllllII, llllllllllllIlllIIIIIIlIlIlllIll, llllllllllllIlllIIIIIIlIlIlllIlI);
        if (llllllllllllIlllIIIIIIlIlIllIlIl > llllllllllllIlllIIIIIIlIlIllIllI) {
            if (llllllllllllIlllIIIIIIlIlIllIlll <= 0.0) {
                throw new CommandException("commands.playsound.playerTooFar", new Object[] { llllllllllllIlllIIIIIIlIlIlllllI.getName() });
            }
            final double llllllllllllIlllIIIIIIlIlIllIlII = llllllllllllIlllIIIIIIlIlIllllII - llllllllllllIlllIIIIIIlIlIlllllI.posX;
            final double llllllllllllIlllIIIIIIlIlIllIIll = llllllllllllIlllIIIIIIlIlIlllIll - llllllllllllIlllIIIIIIlIlIlllllI.posY;
            final double llllllllllllIlllIIIIIIlIlIllIIlI = llllllllllllIlllIIIIIIlIlIlllIlI - llllllllllllIlllIIIIIIlIlIlllllI.posZ;
            final double llllllllllllIlllIIIIIIlIlIllIIIl = Math.sqrt(llllllllllllIlllIIIIIIlIlIllIlII * llllllllllllIlllIIIIIIlIlIllIlII + llllllllllllIlllIIIIIIlIlIllIIll * llllllllllllIlllIIIIIIlIlIllIIll + llllllllllllIlllIIIIIIlIlIllIIlI * llllllllllllIlllIIIIIIlIlIllIIlI);
            if (llllllllllllIlllIIIIIIlIlIllIIIl > 0.0) {
                llllllllllllIlllIIIIIIlIlIllllII = llllllllllllIlllIIIIIIlIlIlllllI.posX + llllllllllllIlllIIIIIIlIlIllIlII / llllllllllllIlllIIIIIIlIlIllIIIl * 2.0;
                llllllllllllIlllIIIIIIlIlIlllIll = llllllllllllIlllIIIIIIlIlIlllllI.posY + llllllllllllIlllIIIIIIlIlIllIIll / llllllllllllIlllIIIIIIlIlIllIIIl * 2.0;
                llllllllllllIlllIIIIIIlIlIlllIlI = llllllllllllIlllIIIIIIlIlIlllllI.posZ + llllllllllllIlllIIIIIIlIlIllIIlI / llllllllllllIlllIIIIIIlIlIllIIIl * 2.0;
            }
            llllllllllllIlllIIIIIIlIlIlllIIl = llllllllllllIlllIIIIIIlIlIllIlll;
        }
        llllllllllllIlllIIIIIIlIlIlllllI.connection.sendPacket(new SPacketCustomSound(llllllllllllIlllIIIIIIlIllIIIIIl, llllllllllllIlllIIIIIIlIlIllllll, llllllllllllIlllIIIIIIlIlIllllII, llllllllllllIlllIIIIIIlIlIlllIll, llllllllllllIlllIIIIIIlIlIlllIlI, (float)llllllllllllIlllIIIIIIlIlIlllIIl, (float)llllllllllllIlllIIIIIIlIlIlllIII));
        CommandBase.notifyCommandListener(llllllllllllIlllIIIIIIlIllIIIlII, this, "commands.playsound.success", llllllllllllIlllIIIIIIlIllIIIIIl, llllllllllllIlllIIIIIIlIlIlllllI.getName());
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIlllIIIIIIlIlIIIllIl, final int llllllllllllIlllIIIIIIlIlIIIlIll) {
        return llllllllllllIlllIIIIIIlIlIIIlIll == 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIlllIIIIIIlIlIIlIllI, final ICommandSender llllllllllllIlllIIIIIIlIlIIlIlIl, final String[] llllllllllllIlllIIIIIIlIlIIlIlII, @Nullable final BlockPos llllllllllllIlllIIIIIIlIlIIlIIll) {
        if (llllllllllllIlllIIIIIIlIlIIlIlII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlllIIIIIIlIlIIlIlII, SoundEvent.REGISTRY.getKeys());
        }
        if (llllllllllllIlllIIIIIIlIlIIlIlII.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlllIIIIIIlIlIIlIlII, SoundCategory.getSoundCategoryNames());
        }
        if (llllllllllllIlllIIIIIIlIlIIlIlII.length == 3) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlllIIIIIIlIlIIlIlII, llllllllllllIlllIIIIIIlIlIIlIllI.getAllUsernames());
        }
        return (llllllllllllIlllIIIIIIlIlIIlIlII.length > 3 && llllllllllllIlllIIIIIIlIlIIlIlII.length <= 6) ? CommandBase.getTabCompletionCoordinate(llllllllllllIlllIIIIIIlIlIIlIlII, 3, llllllllllllIlllIIIIIIlIlIIlIIll) : Collections.emptyList();
    }
}
