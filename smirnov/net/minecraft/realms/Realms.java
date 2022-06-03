// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import java.net.Proxy;
import com.google.common.util.concurrent.ListenableFuture;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.world.GameType;
import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.nbt.NBTTagCompound;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import net.minecraft.nbt.CompressedStreamTools;
import java.io.FileInputStream;
import java.io.File;
import net.minecraft.util.Session;
import net.minecraft.client.Minecraft;

public class Realms
{
    public static String userName() {
        final Session lllllllllllIllIllllllllIlIIllIIl = Minecraft.getMinecraft().getSession();
        return (lllllllllllIllIllllllllIlIIllIIl == null) ? null : lllllllllllIllIllllllllIlIIllIIl.getUsername();
    }
    
    public static void deletePlayerTag(final File lllllllllllIllIllllllllIlIIIIIIl) {
        if (lllllllllllIllIllllllllIlIIIIIIl.exists()) {
            try {
                final NBTTagCompound lllllllllllIllIllllllllIlIIIIlII = CompressedStreamTools.readCompressed(new FileInputStream(lllllllllllIllIllllllllIlIIIIIIl));
                final NBTTagCompound lllllllllllIllIllllllllIlIIIIIll = lllllllllllIllIllllllllIlIIIIlII.getCompoundTag("Data");
                lllllllllllIllIllllllllIlIIIIIll.removeTag("Player");
                CompressedStreamTools.writeCompressed(lllllllllllIllIllllllllIlIIIIlII, new FileOutputStream(lllllllllllIllIllllllllIlIIIIIIl));
            }
            catch (Exception lllllllllllIllIllllllllIlIIIIIlI) {
                lllllllllllIllIllllllllIlIIIIIlI.printStackTrace();
            }
        }
    }
    
    public static String uuidToName(final String lllllllllllIllIllllllllIlIIlIllI) {
        return Minecraft.getMinecraft().getSessionService().fillProfileProperties(new GameProfile(UUIDTypeAdapter.fromString(lllllllllllIllIllllllllIlIIlIllI), (String)null), false).getName();
    }
    
    public static int creativeId() {
        return GameType.CREATIVE.getID();
    }
    
    public static String getUUID() {
        return Minecraft.getMinecraft().getSession().getPlayerID();
    }
    
    public static void setScreen(final RealmsScreen lllllllllllIllIllllllllIlIIlIIlI) {
        Minecraft.getMinecraft().displayGuiScreen(lllllllllllIllIllllllllIlIIlIIlI.getProxy());
    }
    
    public static void clearResourcePack() {
        Minecraft.getMinecraft().getResourcePackRepository().clearResourcePack();
    }
    
    public static int spectatorId() {
        return GameType.SPECTATOR.getID();
    }
    
    public static String getGameDirectoryPath() {
        return Minecraft.getMinecraft().mcDataDir.getAbsolutePath();
    }
    
    public static long currentTimeMillis() {
        return Minecraft.getSystemTime();
    }
    
    public static String getName() {
        return Minecraft.getMinecraft().getSession().getUsername();
    }
    
    public static String getSessionId() {
        return Minecraft.getMinecraft().getSession().getSessionID();
    }
    
    public static String sessionId() {
        final Session lllllllllllIllIllllllllIlIIlllII = Minecraft.getMinecraft().getSession();
        return (lllllllllllIllIllllllllIlIIlllII == null) ? null : lllllllllllIllIllllllllIlIIlllII.getSessionID();
    }
    
    public static boolean inTitleScreen() {
        return Minecraft.getMinecraft().currentScreen != null && Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu;
    }
    
    public static int survivalId() {
        return GameType.SURVIVAL.getID();
    }
    
    public static int adventureId() {
        return GameType.ADVENTURE.getID();
    }
    
    public static void setConnectedToRealms(final boolean lllllllllllIllIllllllllIlIIIllll) {
        Minecraft.getMinecraft().setConnectedToRealms(lllllllllllIllIllllllllIlIIIllll);
    }
    
    public static boolean isTouchScreen() {
        return Minecraft.getMinecraft().gameSettings.touchscreen;
    }
    
    public static boolean getRealmsNotificationsEnabled() {
        return Minecraft.getMinecraft().gameSettings.getOptionOrdinalValue(GameSettings.Options.REALMS_NOTIFICATIONS);
    }
    
    public static ListenableFuture<Object> downloadResourcePack(final String lllllllllllIllIllllllllIlIIIllII, final String lllllllllllIllIllllllllIlIIIlIIl) {
        return Minecraft.getMinecraft().getResourcePackRepository().downloadResourcePack(lllllllllllIllIllllllllIlIIIllII, lllllllllllIllIllllllllIlIIIlIIl);
    }
    
    public static Proxy getProxy() {
        return Minecraft.getMinecraft().getProxy();
    }
}
