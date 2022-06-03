// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.world.border.WorldBorder;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.math.MathHelper;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandWorldBorder extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIllllllllIIlIlIllllI, final ICommandSender llllllllllllIllllllllIIlIlIlllIl, final String[] llllllllllllIllllllllIIlIlIllIlI, @Nullable final BlockPos llllllllllllIllllllllIIlIlIllIll) {
        if (llllllllllllIllllllllIIlIlIllIlI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllllllllIIlIlIllIlI, "set", "center", "damage", "warning", "add", "get");
        }
        if (llllllllllllIllllllllIIlIlIllIlI.length == 2 && "damage".equals(llllllllllllIllllllllIIlIlIllIlI[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllllllllIIlIlIllIlI, "buffer", "amount");
        }
        if (llllllllllllIllllllllIIlIlIllIlI.length >= 2 && llllllllllllIllllllllIIlIlIllIlI.length <= 3 && "center".equals(llllllllllllIllllllllIIlIlIllIlI[0])) {
            return CommandBase.getTabCompletionCoordinateXZ(llllllllllllIllllllllIIlIlIllIlI, 1, llllllllllllIllllllllIIlIlIllIll);
        }
        return (llllllllllllIllllllllIIlIlIllIlI.length == 2 && "warning".equals(llllllllllllIllllllllIIlIlIllIlI[0])) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllllllllIIlIlIllIlI, "time", "distance") : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIllllllllIIllIIIIlIl, final ICommandSender llllllllllllIllllllllIIllIIIIlII, final String[] llllllllllllIllllllllIIllIIIIIll) throws CommandException {
        if (llllllllllllIllllllllIIllIIIIIll.length < 1) {
            throw new WrongUsageException("commands.worldborder.usage", new Object[0]);
        }
        final WorldBorder llllllllllllIllllllllIIllIIIIIlI = this.getWorldBorder(llllllllllllIllllllllIIllIIIIlIl);
        if ("set".equals(llllllllllllIllllllllIIllIIIIIll[0])) {
            if (llllllllllllIllllllllIIllIIIIIll.length != 2 && llllllllllllIllllllllIIllIIIIIll.length != 3) {
                throw new WrongUsageException("commands.worldborder.set.usage", new Object[0]);
            }
            final double llllllllllllIllllllllIIllIIIIIIl = llllllllllllIllllllllIIllIIIIIlI.getTargetSize();
            final double llllllllllllIllllllllIIllIIIIIII = CommandBase.parseDouble(llllllllllllIllllllllIIllIIIIIll[1], 1.0, 6.0E7);
            final long llllllllllllIllllllllIIlIlllllll = (llllllllllllIllllllllIIllIIIIIll.length > 2) ? (CommandBase.parseLong(llllllllllllIllllllllIIllIIIIIll[2], 0L, 9223372036854775L) * 1000L) : 0L;
            if (llllllllllllIllllllllIIlIlllllll > 0L) {
                llllllllllllIllllllllIIllIIIIIlI.setTransition(llllllllllllIllllllllIIllIIIIIIl, llllllllllllIllllllllIIllIIIIIII, llllllllllllIllllllllIIlIlllllll);
                if (llllllllllllIllllllllIIllIIIIIIl > llllllllllllIllllllllIIllIIIIIII) {
                    CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.setSlowly.shrink.success", String.format("%.1f", llllllllllllIllllllllIIllIIIIIII), String.format("%.1f", llllllllllllIllllllllIIllIIIIIIl), Long.toString(llllllllllllIllllllllIIlIlllllll / 1000L));
                }
                else {
                    CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.setSlowly.grow.success", String.format("%.1f", llllllllllllIllllllllIIllIIIIIII), String.format("%.1f", llllllllllllIllllllllIIllIIIIIIl), Long.toString(llllllllllllIllllllllIIlIlllllll / 1000L));
                }
            }
            else {
                llllllllllllIllllllllIIllIIIIIlI.setTransition(llllllllllllIllllllllIIllIIIIIII);
                CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.set.success", String.format("%.1f", llllllllllllIllllllllIIllIIIIIII), String.format("%.1f", llllllllllllIllllllllIIllIIIIIIl));
            }
        }
        else if ("add".equals(llllllllllllIllllllllIIllIIIIIll[0])) {
            if (llllllllllllIllllllllIIllIIIIIll.length != 2 && llllllllllllIllllllllIIllIIIIIll.length != 3) {
                throw new WrongUsageException("commands.worldborder.add.usage", new Object[0]);
            }
            final double llllllllllllIllllllllIIlIllllllI = llllllllllllIllllllllIIllIIIIIlI.getDiameter();
            final double llllllllllllIllllllllIIlIlllllIl = llllllllllllIllllllllIIlIllllllI + CommandBase.parseDouble(llllllllllllIllllllllIIllIIIIIll[1], -llllllllllllIllllllllIIlIllllllI, 6.0E7 - llllllllllllIllllllllIIlIllllllI);
            final long llllllllllllIllllllllIIlIlllllII = llllllllllllIllllllllIIllIIIIIlI.getTimeUntilTarget() + ((llllllllllllIllllllllIIllIIIIIll.length > 2) ? (CommandBase.parseLong(llllllllllllIllllllllIIllIIIIIll[2], 0L, 9223372036854775L) * 1000L) : 0L);
            if (llllllllllllIllllllllIIlIlllllII > 0L) {
                llllllllllllIllllllllIIllIIIIIlI.setTransition(llllllllllllIllllllllIIlIllllllI, llllllllllllIllllllllIIlIlllllIl, llllllllllllIllllllllIIlIlllllII);
                if (llllllllllllIllllllllIIlIllllllI > llllllllllllIllllllllIIlIlllllIl) {
                    CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.setSlowly.shrink.success", String.format("%.1f", llllllllllllIllllllllIIlIlllllIl), String.format("%.1f", llllllllllllIllllllllIIlIllllllI), Long.toString(llllllllllllIllllllllIIlIlllllII / 1000L));
                }
                else {
                    CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.setSlowly.grow.success", String.format("%.1f", llllllllllllIllllllllIIlIlllllIl), String.format("%.1f", llllllllllllIllllllllIIlIllllllI), Long.toString(llllllllllllIllllllllIIlIlllllII / 1000L));
                }
            }
            else {
                llllllllllllIllllllllIIllIIIIIlI.setTransition(llllllllllllIllllllllIIlIlllllIl);
                CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.set.success", String.format("%.1f", llllllllllllIllllllllIIlIlllllIl), String.format("%.1f", llllllllllllIllllllllIIlIllllllI));
            }
        }
        else if ("center".equals(llllllllllllIllllllllIIllIIIIIll[0])) {
            if (llllllllllllIllllllllIIllIIIIIll.length != 3) {
                throw new WrongUsageException("commands.worldborder.center.usage", new Object[0]);
            }
            final BlockPos llllllllllllIllllllllIIlIllllIll = llllllllllllIllllllllIIllIIIIlII.getPosition();
            final double llllllllllllIllllllllIIlIllllIlI = CommandBase.parseDouble(llllllllllllIllllllllIIlIllllIll.getX() + 0.5, llllllllllllIllllllllIIllIIIIIll[1], true);
            final double llllllllllllIllllllllIIlIllllIIl = CommandBase.parseDouble(llllllllllllIllllllllIIlIllllIll.getZ() + 0.5, llllllllllllIllllllllIIllIIIIIll[2], true);
            llllllllllllIllllllllIIllIIIIIlI.setCenter(llllllllllllIllllllllIIlIllllIlI, llllllllllllIllllllllIIlIllllIIl);
            CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.center.success", llllllllllllIllllllllIIlIllllIlI, llllllllllllIllllllllIIlIllllIIl);
        }
        else if ("damage".equals(llllllllllllIllllllllIIllIIIIIll[0])) {
            if (llllllllllllIllllllllIIllIIIIIll.length < 2) {
                throw new WrongUsageException("commands.worldborder.damage.usage", new Object[0]);
            }
            if ("buffer".equals(llllllllllllIllllllllIIllIIIIIll[1])) {
                if (llllllllllllIllllllllIIllIIIIIll.length != 3) {
                    throw new WrongUsageException("commands.worldborder.damage.buffer.usage", new Object[0]);
                }
                final double llllllllllllIllllllllIIlIllllIII = CommandBase.parseDouble(llllllllllllIllllllllIIllIIIIIll[2], 0.0);
                final double llllllllllllIllllllllIIlIlllIlll = llllllllllllIllllllllIIllIIIIIlI.getDamageBuffer();
                llllllllllllIllllllllIIllIIIIIlI.setDamageBuffer(llllllllllllIllllllllIIlIllllIII);
                CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.damage.buffer.success", String.format("%.1f", llllllllllllIllllllllIIlIllllIII), String.format("%.1f", llllllllllllIllllllllIIlIlllIlll));
            }
            else if ("amount".equals(llllllllllllIllllllllIIllIIIIIll[1])) {
                if (llllllllllllIllllllllIIllIIIIIll.length != 3) {
                    throw new WrongUsageException("commands.worldborder.damage.amount.usage", new Object[0]);
                }
                final double llllllllllllIllllllllIIlIlllIllI = CommandBase.parseDouble(llllllllllllIllllllllIIllIIIIIll[2], 0.0);
                final double llllllllllllIllllllllIIlIlllIlIl = llllllllllllIllllllllIIllIIIIIlI.getDamageAmount();
                llllllllllllIllllllllIIllIIIIIlI.setDamageAmount(llllllllllllIllllllllIIlIlllIllI);
                CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.damage.amount.success", String.format("%.2f", llllllllllllIllllllllIIlIlllIllI), String.format("%.2f", llllllllllllIllllllllIIlIlllIlIl));
            }
        }
        else if ("warning".equals(llllllllllllIllllllllIIllIIIIIll[0])) {
            if (llllllllllllIllllllllIIllIIIIIll.length < 2) {
                throw new WrongUsageException("commands.worldborder.warning.usage", new Object[0]);
            }
            if ("time".equals(llllllllllllIllllllllIIllIIIIIll[1])) {
                if (llllllllllllIllllllllIIllIIIIIll.length != 3) {
                    throw new WrongUsageException("commands.worldborder.warning.time.usage", new Object[0]);
                }
                final int llllllllllllIllllllllIIlIlllIlII = CommandBase.parseInt(llllllllllllIllllllllIIllIIIIIll[2], 0);
                final int llllllllllllIllllllllIIlIlllIIll = llllllllllllIllllllllIIllIIIIIlI.getWarningTime();
                llllllllllllIllllllllIIllIIIIIlI.setWarningTime(llllllllllllIllllllllIIlIlllIlII);
                CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.warning.time.success", llllllllllllIllllllllIIlIlllIlII, llllllllllllIllllllllIIlIlllIIll);
            }
            else if ("distance".equals(llllllllllllIllllllllIIllIIIIIll[1])) {
                if (llllllllllllIllllllllIIllIIIIIll.length != 3) {
                    throw new WrongUsageException("commands.worldborder.warning.distance.usage", new Object[0]);
                }
                final int llllllllllllIllllllllIIlIlllIIlI = CommandBase.parseInt(llllllllllllIllllllllIIllIIIIIll[2], 0);
                final int llllllllllllIllllllllIIlIlllIIIl = llllllllllllIllllllllIIllIIIIIlI.getWarningDistance();
                llllllllllllIllllllllIIllIIIIIlI.setWarningDistance(llllllllllllIllllllllIIlIlllIIlI);
                CommandBase.notifyCommandListener(llllllllllllIllllllllIIllIIIIlII, this, "commands.worldborder.warning.distance.success", llllllllllllIllllllllIIlIlllIIlI, llllllllllllIllllllllIIlIlllIIIl);
            }
        }
        else {
            if (!"get".equals(llllllllllllIllllllllIIllIIIIIll[0])) {
                throw new WrongUsageException("commands.worldborder.usage", new Object[0]);
            }
            final double llllllllllllIllllllllIIlIlllIIII = llllllllllllIllllllllIIllIIIIIlI.getDiameter();
            llllllllllllIllllllllIIllIIIIlII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, MathHelper.floor(llllllllllllIllllllllIIlIlllIIII + 0.5));
            llllllllllllIllllllllIIllIIIIlII.addChatMessage(new TextComponentTranslation("commands.worldborder.get.success", new Object[] { String.format("%.0f", llllllllllllIllllllllIIlIlllIIII) }));
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIllllllllIIllIIlIIIl) {
        return "commands.worldborder.usage";
    }
    
    @Override
    public String getCommandName() {
        return "worldborder";
    }
    
    protected WorldBorder getWorldBorder(final MinecraftServer llllllllllllIllllllllIIlIllIIIll) {
        return llllllllllllIllllllllIIlIllIIIll.worldServers[0].getWorldBorder();
    }
}
