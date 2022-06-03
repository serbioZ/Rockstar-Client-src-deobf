// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.other;

import ru.rockstar.Main;
import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRichPresence;
import club.minnced.discord.rpc.DiscordRPC;
import ru.rockstar.api.utils.Helper;

public class DiscordUtils implements Helper
{
    private static final /* synthetic */ DiscordRPC discordRPC;
    private static final /* synthetic */ DiscordRichPresence discordRichPresence;
    
    public static void startRPC() {
        final DiscordEventHandlers lllllllllllIlllIlIlIIlllIIIIlIII = new DiscordEventHandlers();
        DiscordUtils.discordRPC.Discord_Initialize("959854399608463370", lllllllllllIlllIlIlIIlllIIIIlIII, true, (String)null);
        DiscordUtils.discordRichPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        DiscordUtils.discordRichPresence.largeImageKey = "large";
        DiscordUtils.discordRichPresence.largeImageText = "vk.com/rockstarclient";
        DiscordUtils.discordRichPresence.details = "Owning The Game";
        DiscordUtils.discordRichPresence.state = "Build: " + Main.instance.version;
        DiscordUtils.discordRPC.Discord_UpdatePresence(DiscordUtils.discordRichPresence);
    }
    
    static {
        discordID = "959854399608463370";
        discordRichPresence = new DiscordRichPresence();
        discordRPC = DiscordRPC.INSTANCE;
    }
    
    public static void stopRPC() {
        DiscordUtils.discordRPC.Discord_Shutdown();
        DiscordUtils.discordRPC.Discord_ClearPresence();
    }
}
