// 
//ÑÌÈÐÍÎÂ ÒÂÎÉ ÂËÀÄÛÊÀ ÍÀÕÓÉ 

package ru.rockstar;

import ru.rockstar.api.event.EventTarget;
import org.lwjgl.input.Keyboard;
import ru.rockstar.api.command.macro.Macro;
import ru.rockstar.client.features.Feature;
import ru.rockstar.api.event.event.EventKey;
import ru.rockstar.client.ui.HudConfig;
import ru.rockstar.client.ui.settings.impls.MacroConfig;
import ru.rockstar.client.ui.altmanager.alt.AltConfig;
import ru.rockstar.client.ui.settings.impls.FriendConfig;
import org.lwjgl.opengl.Display;
import ru.rockstar.api.utils.shader.ShaderShell;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.command.macro.MacroManager;
import ru.rockstar.client.features.FeatureDirector;
import ru.rockstar.client.ui.draggable.DraggableManager;
import ru.rockstar.api.utils.friend.FriendManager;
import ru.rockstar.client.ui.settings.config.ConfigManager;
import ru.rockstar.api.event.EventManager;
import ru.rockstar.client.ui.settings.FileManager;
import ru.rockstar.api.command.CommandManager;
import ru.rockstar.api.changelogs.ChangeManager;
import ru.rockstar.client.ui.clickgui.ClickGuiScreen;

public class Main
{
    public /* synthetic */ ClickGuiScreen clickGui;
    public /* synthetic */ String name;
    public /* synthetic */ ChangeManager changeManager;
    public /* synthetic */ CommandManager commandManager;
    public /* synthetic */ FileManager fileManager;
    public /* synthetic */ EventManager eventManager;
    public /* synthetic */ ConfigManager configManager;
    public static /* synthetic */ Main instance;
    public /* synthetic */ String version;
    public /* synthetic */ ru.rockstar.client.ui.csgui.ClickGuiScreen csgui;
    public /* synthetic */ FriendManager friendManager;
    public static /* synthetic */ String holo;
    public /* synthetic */ DraggableManager draggableManager;
    public static /* synthetic */ FeatureDirector featureDirector;
    public /* synthetic */ MacroManager macroManager;
    
    public static void msg(String lllllllllllIIlIIIIllIIlIIlllIIII, final boolean lllllllllllIIlIIIIllIIlIIlllIIIl) {
        lllllllllllIIlIIIIllIIlIIlllIIII = (boolean)(String.valueOf(lllllllllllIIlIIIIllIIlIIlllIIIl ? new StringBuilder().append(TextFormatting.GRAY).append("[").append(TextFormatting.RED).append("Rockstar").append(TextFormatting.GRAY).append("]").append(": ").toString() : "") + (String)lllllllllllIIlIIIIllIIlIIlllIIII);
        Minecraft.getMinecraft().player.addChatMessage(new TextComponentTranslation(((String)lllllllllllIIlIIIIllIIlIIlllIIII).replace("&", "??"), new Object[0]));
    }
    
    public void startClient() {
        SplashProgress.setProgress(1);
        ShaderShell.init();
        this.eventManager = new EventManager();
        Main.featureDirector = new FeatureDirector();
        this.configManager = new ConfigManager();
        this.commandManager = new CommandManager();
        this.draggableManager = new DraggableManager();
        this.macroManager = new MacroManager();
        this.changeManager = new ChangeManager();
        this.clickGui = new ClickGuiScreen();
        this.csgui = new ru.rockstar.client.ui.csgui.ClickGuiScreen();
        this.friendManager = new FriendManager();
        Display.setTitle(this.name);
        try {
            this.fileManager.getFile(FriendConfig.class).loadFile();
        }
        catch (Exception ex) {}
        try {
            this.fileManager.getFile(AltConfig.class).loadFile();
        }
        catch (Exception ex2) {}
        try {
            this.fileManager.getFile(MacroConfig.class).loadFile();
        }
        catch (Exception ex3) {}
        try {
            this.fileManager.getFile(HudConfig.class).loadFile();
        }
        catch (Exception ex4) {}
        EventManager.register(this);
    }
    
    public void stopClient() {
        EventManager.unregister(Main.instance);
        final FileManager fileManager = new FileManager();
        this.fileManager = fileManager;
        fileManager.saveFiles();
    }
    
    @EventTarget
    public void onKey(final EventKey lllllllllllIIlIIIIllIIlIIllIIIll) {
        for (final Feature lllllllllllIIlIIIIllIIlIIllIIllI : Main.featureDirector.getFeatureList()) {
            if (lllllllllllIIlIIIIllIIlIIllIIllI.getKey() == lllllllllllIIlIIIIllIIlIIllIIIll.getKey()) {
                lllllllllllIIlIIIIllIIlIIllIIllI.toggle();
            }
            for (final Macro lllllllllllIIlIIIIllIIlIIllIIlIl : this.macroManager.getMacros()) {
                if (lllllllllllIIlIIIIllIIlIIllIIlIl.getKey() == Keyboard.getEventKey() && Minecraft.getMinecraft().player.getHealth() > 0.0f && Minecraft.getMinecraft().player != null) {
                    Minecraft.getMinecraft().player.sendChatMessage(lllllllllllIIlIIIIllIIlIIllIIlIl.getValue());
                }
            }
        }
    }
    
    static {
        Main.holo = "Holo";
        Main.instance = new Main();
    }
    
    public Main() {
        this.name = "Rockstar Premium";
        this.version = "2.2";
    }
}
