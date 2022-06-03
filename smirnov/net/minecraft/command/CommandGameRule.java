// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameRules;
import net.minecraft.server.MinecraftServer;

public class CommandGameRule extends CommandBase
{
    @Override
    public String getCommandName() {
        return "gamerule";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    private GameRules getOverWorldGameRules(final MinecraftServer lllllllllllIlIlllIlIIlIIIlIllIlI) {
        return lllllllllllIlIlllIlIIlIIIlIllIlI.worldServerForDimension(0).getGameRules();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIlIlllIlIIlIIlIIIIIll, final ICommandSender lllllllllllIlIlllIlIIlIIlIIIlIlI, final String[] lllllllllllIlIlllIlIIlIIlIIIlIIl) throws CommandException {
        final GameRules lllllllllllIlIlllIlIIlIIlIIIlIII = this.getOverWorldGameRules(lllllllllllIlIlllIlIIlIIlIIIIIll);
        final String lllllllllllIlIlllIlIIlIIlIIIIlll = (lllllllllllIlIlllIlIIlIIlIIIlIIl.length > 0) ? lllllllllllIlIlllIlIIlIIlIIIlIIl[0] : "";
        final String lllllllllllIlIlllIlIIlIIlIIIIllI = (lllllllllllIlIlllIlIIlIIlIIIlIIl.length > 1) ? CommandBase.buildString(lllllllllllIlIlllIlIIlIIlIIIlIIl, 1) : "";
        switch (lllllllllllIlIlllIlIIlIIlIIIlIIl.length) {
            case 0: {
                lllllllllllIlIlllIlIIlIIlIIIlIlI.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllIlIlllIlIIlIIlIIIlIII.getRules())));
                break;
            }
            case 1: {
                if (!lllllllllllIlIlllIlIIlIIlIIIlIII.hasRule(lllllllllllIlIlllIlIIlIIlIIIIlll)) {
                    throw new CommandException("commands.gamerule.norule", new Object[] { lllllllllllIlIlllIlIIlIIlIIIIlll });
                }
                final String lllllllllllIlIlllIlIIlIIlIIIIlIl = lllllllllllIlIlllIlIIlIIlIIIlIII.getString(lllllllllllIlIlllIlIIlIIlIIIIlll);
                lllllllllllIlIlllIlIIlIIlIIIlIlI.addChatMessage(new TextComponentString(lllllllllllIlIlllIlIIlIIlIIIIlll).appendText(" = ").appendText(lllllllllllIlIlllIlIIlIIlIIIIlIl));
                lllllllllllIlIlllIlIIlIIlIIIlIlI.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllIlIlllIlIIlIIlIIIlIII.getInt(lllllllllllIlIlllIlIIlIIlIIIIlll));
                break;
            }
            default: {
                if (lllllllllllIlIlllIlIIlIIlIIIlIII.areSameType(lllllllllllIlIlllIlIIlIIlIIIIlll, GameRules.ValueType.BOOLEAN_VALUE) && !"true".equals(lllllllllllIlIlllIlIIlIIlIIIIllI) && !"false".equals(lllllllllllIlIlllIlIIlIIlIIIIllI)) {
                    throw new CommandException("commands.generic.boolean.invalid", new Object[] { lllllllllllIlIlllIlIIlIIlIIIIllI });
                }
                lllllllllllIlIlllIlIIlIIlIIIlIII.setOrCreateGameRule(lllllllllllIlIlllIlIIlIIlIIIIlll, lllllllllllIlIlllIlIIlIIlIIIIllI);
                notifyGameRuleChange(lllllllllllIlIlllIlIIlIIlIIIlIII, lllllllllllIlIlllIlIIlIIlIIIIlll, lllllllllllIlIlllIlIIlIIlIIIIIll);
                CommandBase.notifyCommandListener(lllllllllllIlIlllIlIIlIIlIIIlIlI, this, "commands.gamerule.success", lllllllllllIlIlllIlIIlIIlIIIIlll, lllllllllllIlIlllIlIIlIIlIIIIllI);
                break;
            }
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIlIlllIlIIlIIlIIlIlIl) {
        return "commands.gamerule.usage";
    }
    
    public static void notifyGameRuleChange(final GameRules lllllllllllIlIlllIlIIlIIIlllIIIl, final String lllllllllllIlIlllIlIIlIIIlllIIII, final MinecraftServer lllllllllllIlIlllIlIIlIIIllIllll) {
        if ("reducedDebugInfo".equals(lllllllllllIlIlllIlIIlIIIlllIIII)) {
            final byte lllllllllllIlIlllIlIIlIIIlllIIll = (byte)(lllllllllllIlIlllIlIIlIIIlllIIIl.getBoolean(lllllllllllIlIlllIlIIlIIIlllIIII) ? 22 : 23);
            for (final EntityPlayerMP lllllllllllIlIlllIlIIlIIIlllIIlI : lllllllllllIlIlllIlIIlIIIllIllll.getPlayerList().getPlayerList()) {
                lllllllllllIlIlllIlIIlIIIlllIIlI.connection.sendPacket(new SPacketEntityStatus(lllllllllllIlIlllIlIIlIIIlllIIlI, lllllllllllIlIlllIlIIlIIIlllIIll));
            }
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIlIlllIlIIlIIIllIIIII, final ICommandSender lllllllllllIlIlllIlIIlIIIllIIlIl, final String[] lllllllllllIlIlllIlIIlIIIllIIlII, @Nullable final BlockPos lllllllllllIlIlllIlIIlIIIllIIIll) {
        if (lllllllllllIlIlllIlIIlIIIllIIlII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIlllIlIIlIIIllIIlII, this.getOverWorldGameRules(lllllllllllIlIlllIlIIlIIIllIIIII).getRules());
        }
        if (lllllllllllIlIlllIlIIlIIIllIIlII.length == 2) {
            final GameRules lllllllllllIlIlllIlIIlIIIllIIIlI = this.getOverWorldGameRules(lllllllllllIlIlllIlIIlIIIllIIIII);
            if (lllllllllllIlIlllIlIIlIIIllIIIlI.areSameType(lllllllllllIlIlllIlIIlIIIllIIlII[0], GameRules.ValueType.BOOLEAN_VALUE)) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIlllIlIIlIIIllIIlII, "true", "false");
            }
            if (lllllllllllIlIlllIlIIlIIIllIIIlI.areSameType(lllllllllllIlIlllIlIIlIIIllIIlII[0], GameRules.ValueType.FUNCTION)) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIlllIlIIlIIIllIIlII, lllllllllllIlIlllIlIIlIIIllIIIII.func_193030_aL().func_193066_d().keySet());
            }
        }
        return Collections.emptyList();
    }
}
