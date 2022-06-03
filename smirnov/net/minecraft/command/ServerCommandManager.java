// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.network.rcon.RConConsoleSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.command.server.CommandPublishLocalServer;
import net.minecraft.command.server.CommandWhitelist;
import net.minecraft.command.server.CommandListPlayers;
import net.minecraft.command.server.CommandPardonPlayer;
import net.minecraft.command.server.CommandListBans;
import net.minecraft.command.server.CommandBanPlayer;
import net.minecraft.command.server.CommandPardonIp;
import net.minecraft.command.server.CommandBanIp;
import net.minecraft.command.server.CommandSaveOn;
import net.minecraft.command.server.CommandSaveOff;
import net.minecraft.command.server.CommandSaveAll;
import net.minecraft.command.server.CommandStop;
import net.minecraft.command.server.CommandDeOp;
import net.minecraft.command.server.CommandOp;
import net.minecraft.command.server.CommandMessageRaw;
import net.minecraft.command.server.CommandTestForBlock;
import net.minecraft.command.server.CommandSetBlock;
import net.minecraft.command.server.CommandSummon;
import net.minecraft.command.server.CommandScoreboard;
import net.minecraft.command.server.CommandTestFor;
import net.minecraft.command.server.CommandSetDefaultSpawnpoint;
import net.minecraft.command.server.CommandBroadcast;
import net.minecraft.command.server.CommandMessage;
import net.minecraft.command.server.CommandEmote;
import net.minecraft.command.server.CommandTeleport;
import net.minecraft.server.MinecraftServer;

public class ServerCommandManager extends CommandHandler implements ICommandListener
{
    private final /* synthetic */ MinecraftServer server;
    
    @Override
    protected MinecraftServer getServer() {
        return this.server;
    }
    
    public ServerCommandManager(final MinecraftServer lIIllIlIlllIlIl) {
        this.server = lIIllIlIlllIlIl;
        this.registerCommand(new CommandTime());
        this.registerCommand(new CommandGameMode());
        this.registerCommand(new CommandDifficulty());
        this.registerCommand(new CommandDefaultGameMode());
        this.registerCommand(new CommandKill());
        this.registerCommand(new CommandToggleDownfall());
        this.registerCommand(new CommandWeather());
        this.registerCommand(new CommandXP());
        this.registerCommand(new CommandTP());
        this.registerCommand(new CommandTeleport());
        this.registerCommand(new CommandGive());
        this.registerCommand(new CommandReplaceItem());
        this.registerCommand(new CommandStats());
        this.registerCommand(new CommandEffect());
        this.registerCommand(new CommandEnchant());
        this.registerCommand(new CommandParticle());
        this.registerCommand(new CommandEmote());
        this.registerCommand(new CommandShowSeed());
        this.registerCommand(new CommandHelp());
        this.registerCommand(new CommandDebug());
        this.registerCommand(new CommandMessage());
        this.registerCommand(new CommandBroadcast());
        this.registerCommand(new CommandSetSpawnpoint());
        this.registerCommand(new CommandSetDefaultSpawnpoint());
        this.registerCommand(new CommandGameRule());
        this.registerCommand(new CommandClearInventory());
        this.registerCommand(new CommandTestFor());
        this.registerCommand(new CommandSpreadPlayers());
        this.registerCommand(new CommandPlaySound());
        this.registerCommand(new CommandScoreboard());
        this.registerCommand(new CommandExecuteAt());
        this.registerCommand(new CommandTrigger());
        this.registerCommand(new AdvancementCommand());
        this.registerCommand(new RecipeCommand());
        this.registerCommand(new CommandSummon());
        this.registerCommand(new CommandSetBlock());
        this.registerCommand(new CommandFill());
        this.registerCommand(new CommandClone());
        this.registerCommand(new CommandCompare());
        this.registerCommand(new CommandBlockData());
        this.registerCommand(new CommandTestForBlock());
        this.registerCommand(new CommandMessageRaw());
        this.registerCommand(new CommandWorldBorder());
        this.registerCommand(new CommandTitle());
        this.registerCommand(new CommandEntityData());
        this.registerCommand(new CommandStopSound());
        this.registerCommand(new CommandLocate());
        this.registerCommand(new CommandReload());
        this.registerCommand(new CommandFunction());
        if (lIIllIlIlllIlIl.isDedicatedServer()) {
            this.registerCommand(new CommandOp());
            this.registerCommand(new CommandDeOp());
            this.registerCommand(new CommandStop());
            this.registerCommand(new CommandSaveAll());
            this.registerCommand(new CommandSaveOff());
            this.registerCommand(new CommandSaveOn());
            this.registerCommand(new CommandBanIp());
            this.registerCommand(new CommandPardonIp());
            this.registerCommand(new CommandBanPlayer());
            this.registerCommand(new CommandListBans());
            this.registerCommand(new CommandPardonPlayer());
            this.registerCommand(new CommandServerKick());
            this.registerCommand(new CommandListPlayers());
            this.registerCommand(new CommandWhitelist());
            this.registerCommand(new CommandSetPlayerTimeout());
        }
        else {
            this.registerCommand(new CommandPublishLocalServer());
        }
        CommandBase.setCommandListener(this);
    }
    
    @Override
    public void notifyListener(final ICommandSender lIIllIlIllIIlII, final ICommand lIIllIlIllIIIll, final int lIIllIlIlIlIlIl, final String lIIllIlIlIlIlII, final Object... lIIllIlIlIlIIll) {
        boolean lIIllIlIlIlllll = true;
        final MinecraftServer lIIllIlIlIllllI = this.server;
        if (!lIIllIlIllIIlII.sendCommandFeedback()) {
            lIIllIlIlIlllll = false;
        }
        final ITextComponent lIIllIlIlIlllIl = new TextComponentTranslation("chat.type.admin", new Object[] { lIIllIlIllIIlII.getName(), new TextComponentTranslation(lIIllIlIlIlIlII, lIIllIlIlIlIIll) });
        lIIllIlIlIlllIl.getStyle().setColor(TextFormatting.GRAY);
        lIIllIlIlIlllIl.getStyle().setItalic(true);
        if (lIIllIlIlIlllll) {
            for (final EntityPlayer lIIllIlIlIlllII : lIIllIlIlIllllI.getPlayerList().getPlayerList()) {
                if (lIIllIlIlIlllII != lIIllIlIllIIlII && lIIllIlIlIllllI.getPlayerList().canSendCommands(lIIllIlIlIlllII.getGameProfile()) && lIIllIlIllIIIll.checkPermission(this.server, lIIllIlIllIIlII)) {
                    final boolean lIIllIlIlIllIll = lIIllIlIllIIlII instanceof MinecraftServer && this.server.shouldBroadcastConsoleToOps();
                    final boolean lIIllIlIlIllIlI = lIIllIlIllIIlII instanceof RConConsoleSource && this.server.shouldBroadcastRconToOps();
                    if (!lIIllIlIlIllIll && !lIIllIlIlIllIlI && (lIIllIlIllIIlII instanceof RConConsoleSource || lIIllIlIllIIlII instanceof MinecraftServer)) {
                        continue;
                    }
                    lIIllIlIlIlllII.addChatMessage(lIIllIlIlIlllIl);
                }
            }
        }
        if (lIIllIlIllIIlII != lIIllIlIlIllllI && lIIllIlIlIllllI.worldServers[0].getGameRules().getBoolean("logAdminCommands")) {
            lIIllIlIlIllllI.addChatMessage(lIIllIlIlIlllIl);
        }
        boolean lIIllIlIlIllIIl = lIIllIlIlIllllI.worldServers[0].getGameRules().getBoolean("sendCommandFeedback");
        if (lIIllIlIllIIlII instanceof CommandBlockBaseLogic) {
            lIIllIlIlIllIIl = ((CommandBlockBaseLogic)lIIllIlIllIIlII).shouldTrackOutput();
        }
        if (((lIIllIlIlIlIlIl & 0x1) != 0x1 && lIIllIlIlIllIIl) || lIIllIlIllIIlII instanceof MinecraftServer) {
            lIIllIlIllIIlII.addChatMessage(new TextComponentTranslation(lIIllIlIlIlIlII, lIIllIlIlIlIIll));
        }
    }
}
