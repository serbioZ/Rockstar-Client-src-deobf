// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import java.lang.reflect.Constructor;
import net.minecraft.client.gui.GuiScreenRealmsProxy;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.gui.GuiScreen;

public class RealmsBridge extends RealmsScreen
{
    private /* synthetic */ GuiScreen previousScreen;
    private static final /* synthetic */ Logger LOGGER;
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void init() {
        Minecraft.getMinecraft().displayGuiScreen(this.previousScreen);
    }
    
    public GuiScreenRealmsProxy getNotificationScreen(final GuiScreen llllllllllllIIllIlIllIlIlIIllIll) {
        try {
            this.previousScreen = llllllllllllIIllIlIllIlIlIIllIll;
            final Class<?> llllllllllllIIllIlIllIlIlIlIIIIl = Class.forName("com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen");
            final Constructor<?> llllllllllllIIllIlIllIlIlIlIIIII = llllllllllllIIllIlIllIlIlIlIIIIl.getDeclaredConstructor(RealmsScreen.class);
            llllllllllllIIllIlIllIlIlIlIIIII.setAccessible(true);
            final Object llllllllllllIIllIlIllIlIlIIlllll = llllllllllllIIllIlIllIlIlIlIIIII.newInstance(this);
            return ((RealmsScreen)llllllllllllIIllIlIllIlIlIIlllll).getProxy();
        }
        catch (ClassNotFoundException llllllllllllIIllIlIllIlIlIIllllI) {
            RealmsBridge.LOGGER.error("Realms module missing");
        }
        catch (Exception llllllllllllIIllIlIllIlIlIIlllIl) {
            RealmsBridge.LOGGER.error("Failed to load Realms module", (Throwable)llllllllllllIIllIlIllIlIlIIlllIl);
        }
        return null;
    }
    
    public void switchToRealms(final GuiScreen llllllllllllIIllIlIllIlIlIllIIll) {
        this.previousScreen = llllllllllllIIllIlIllIlIlIllIIll;
        try {
            final Class<?> llllllllllllIIllIlIllIlIlIllIIlI = Class.forName("com.mojang.realmsclient.RealmsMainScreen");
            final Constructor<?> llllllllllllIIllIlIllIlIlIllIIIl = llllllllllllIIllIlIllIlIlIllIIlI.getDeclaredConstructor(RealmsScreen.class);
            llllllllllllIIllIlIllIlIlIllIIIl.setAccessible(true);
            final Object llllllllllllIIllIlIllIlIlIllIIII = llllllllllllIIllIlIllIlIlIllIIIl.newInstance(this);
            Minecraft.getMinecraft().displayGuiScreen(((RealmsScreen)llllllllllllIIllIlIllIlIlIllIIII).getProxy());
        }
        catch (ClassNotFoundException llllllllllllIIllIlIllIlIlIlIllll) {
            RealmsBridge.LOGGER.error("Realms module missing");
        }
        catch (Exception llllllllllllIIllIlIllIlIlIlIlllI) {
            RealmsBridge.LOGGER.error("Failed to load Realms module", (Throwable)llllllllllllIIllIlIllIlIlIlIlllI);
        }
    }
}
