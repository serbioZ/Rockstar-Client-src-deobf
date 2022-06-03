// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import java.util.Collections;
import net.minecraft.util.SoundEvent;
import java.util.Collection;
import net.minecraft.util.SoundCategory;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandStopSound extends CommandBase
{
    @Override
    public String getCommandName() {
        return "stopsound";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIllllIIllIIlllIllI, final ICommandSender llllllllllllllIllllIIllIIllllIIl, final String[] llllllllllllllIllllIIllIIllllIII, @Nullable final BlockPos llllllllllllllIllllIIllIIlllIlll) {
        if (llllllllllllllIllllIIllIIllllIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllIIllIIllllIII, llllllllllllllIllllIIllIIlllIllI.getAllUsernames());
        }
        if (llllllllllllllIllllIIllIIllllIII.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllIIllIIllllIII, SoundCategory.getSoundCategoryNames());
        }
        return (llllllllllllllIllllIIllIIllllIII.length == 3) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllIIllIIllllIII, SoundEvent.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIllllIIllIlIIlllIl) {
        return "commands.stopsound.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIllllIIllIlIIIIllI, final ICommandSender llllllllllllllIllllIIllIlIIIIlIl, final String[] llllllllllllllIllllIIllIlIIIIlII) throws CommandException {
        if (llllllllllllllIllllIIllIlIIIIlII.length >= 1 && llllllllllllllIllllIIllIlIIIIlII.length <= 3) {
            int llllllllllllllIllllIIllIlIIIlllI = 0;
            final EntityPlayerMP llllllllllllllIllllIIllIlIIIllIl = CommandBase.getPlayer(llllllllllllllIllllIIllIlIIIIllI, llllllllllllllIllllIIllIlIIIIlIl, llllllllllllllIllllIIllIlIIIIlII[llllllllllllllIllllIIllIlIIIlllI++]);
            String llllllllllllllIllllIIllIlIIIllII = "";
            String llllllllllllllIllllIIllIlIIIlIll = "";
            if (llllllllllllllIllllIIllIlIIIIlII.length >= 2) {
                final String llllllllllllllIllllIIllIlIIIlIlI = llllllllllllllIllllIIllIlIIIIlII[llllllllllllllIllllIIllIlIIIlllI++];
                final SoundCategory llllllllllllllIllllIIllIlIIIlIIl = SoundCategory.getByName(llllllllllllllIllllIIllIlIIIlIlI);
                if (llllllllllllllIllllIIllIlIIIlIIl == null) {
                    throw new CommandException("commands.stopsound.unknownSoundSource", new Object[] { llllllllllllllIllllIIllIlIIIlIlI });
                }
                llllllllllllllIllllIIllIlIIIllII = llllllllllllllIllllIIllIlIIIlIIl.getName();
            }
            if (llllllllllllllIllllIIllIlIIIIlII.length == 3) {
                llllllllllllllIllllIIllIlIIIlIll = llllllllllllllIllllIIllIlIIIIlII[llllllllllllllIllllIIllIlIIIlllI++];
            }
            final PacketBuffer llllllllllllllIllllIIllIlIIIlIII = new PacketBuffer(Unpooled.buffer());
            llllllllllllllIllllIIllIlIIIlIII.writeString(llllllllllllllIllllIIllIlIIIllII);
            llllllllllllllIllllIIllIlIIIlIII.writeString(llllllllllllllIllllIIllIlIIIlIll);
            llllllllllllllIllllIIllIlIIIllIl.connection.sendPacket(new SPacketCustomPayload("MC|StopSound", llllllllllllllIllllIIllIlIIIlIII));
            if (llllllllllllllIllllIIllIlIIIllII.isEmpty() && llllllllllllllIllllIIllIlIIIlIll.isEmpty()) {
                CommandBase.notifyCommandListener(llllllllllllllIllllIIllIlIIIIlIl, this, "commands.stopsound.success.all", llllllllllllllIllllIIllIlIIIllIl.getName());
            }
            else if (llllllllllllllIllllIIllIlIIIlIll.isEmpty()) {
                CommandBase.notifyCommandListener(llllllllllllllIllllIIllIlIIIIlIl, this, "commands.stopsound.success.soundSource", llllllllllllllIllllIIllIlIIIllII, llllllllllllllIllllIIllIlIIIllIl.getName());
            }
            else {
                CommandBase.notifyCommandListener(llllllllllllllIllllIIllIlIIIIlIl, this, "commands.stopsound.success.individualSound", llllllllllllllIllllIIllIlIIIlIll, llllllllllllllIllllIIllIlIIIllII, llllllllllllllIllllIIllIlIIIllIl.getName());
            }
            return;
        }
        throw new WrongUsageException(this.getCommandUsage(llllllllllllllIllllIIllIlIIIIlIl), new Object[0]);
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIllllIIllIIlllIIlI, final int llllllllllllllIllllIIllIIlllIIII) {
        return llllllllllllllIllllIIllIIlllIIII == 0;
    }
}
