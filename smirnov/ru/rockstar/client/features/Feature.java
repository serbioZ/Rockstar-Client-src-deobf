// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features;

import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import ru.rockstar.client.features.impl.display.Notifications;
import ru.rockstar.api.event.EventManager;
import ru.rockstar.api.utils.other.SoundHelper;
import net.minecraft.init.SoundEvents;
import ru.rockstar.Main;
import ru.rockstar.client.features.impl.misc.ModuleSoundAlert;
import com.google.gson.JsonElement;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.Setting;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.clickgui.ScreenHelper;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.api.utils.render.Translate;
import ru.rockstar.client.ui.settings.Configurable;

public class Feature extends Configurable
{
    private /* synthetic */ String suffix;
    private final /* synthetic */ Translate translate;
    public /* synthetic */ boolean visible;
    private final /* synthetic */ AnimationHelper animation;
    public static /* synthetic */ TimerHelper timerHelper;
    public /* synthetic */ double slidex;
    public /* synthetic */ ScreenHelper screenHelper;
    protected /* synthetic */ String desc;
    private /* synthetic */ int key;
    private /* synthetic */ String moduleName;
    private /* synthetic */ Category category;
    protected /* synthetic */ String label;
    private /* synthetic */ boolean toggled;
    public /* synthetic */ double slidey;
    protected static /* synthetic */ Minecraft mc;
    
    public boolean isVisible() {
        return this.visible;
    }
    
    static {
        Feature.mc = Minecraft.getMinecraft();
        Feature.timerHelper = new TimerHelper();
    }
    
    public boolean isHidden() {
        return !this.visible;
    }
    
    public void setCategory(final Category llllllllllIlllIIIlIIIIlIIIlIllII) {
        this.category = llllllllllIlllIIIlIIIIlIIIlIllII;
    }
    
    public Feature(final String llllllllllIlllIIIlIIIIlIlIIlllIl, final String llllllllllIlllIIIlIIIIlIlIIlIlll, final int llllllllllIlllIIIlIIIIlIlIIlIllI, final Category llllllllllIlllIIIlIIIIlIlIIlIlIl) {
        this.translate = new Translate(0.0f, 0.0f);
        this.slidex = 0.0;
        this.slidey = 0.0;
        this.visible = true;
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
        this.label = llllllllllIlllIIIlIIIIlIlIIlllIl;
        this.desc = llllllllllIlllIIIlIIIIlIlIIlIlll;
        this.key = llllllllllIlllIIIlIIIIlIlIIlIllI;
        this.category = llllllllllIlllIIIlIIIIlIlIIlIlIl;
        this.toggled = false;
        this.animation = new AnimationHelper(150, this.isToggled());
        this.setup();
    }
    
    public void setDesc(final String llllllllllIlllIIIlIIIIlIIIlllllI) {
        this.desc = llllllllllIlllIIIlIIIIlIIIlllllI;
    }
    
    public AnimationHelper getAnimation() {
        return this.animation;
    }
    
    public JsonObject save() {
        final JsonObject llllllllllIlllIIIlIIIIlIlIIIlllI = new JsonObject();
        llllllllllIlllIIIlIIIIlIlIIIlllI.addProperty("state", Boolean.valueOf(this.isToggled()));
        llllllllllIlllIIIlIIIIlIlIIIlllI.addProperty("keyIndex", (Number)this.getKey());
        llllllllllIlllIIIlIIIIlIlIIIlllI.addProperty("visible", Boolean.valueOf(this.isVisible()));
        final JsonObject llllllllllIlllIIIlIIIIlIlIIIllIl = new JsonObject();
        for (final Setting llllllllllIlllIIIlIIIIlIlIIIllII : this.getSettings()) {
            if (this.getSettings() != null) {
                if (llllllllllIlllIIIlIIIIlIlIIIllII instanceof BooleanSetting) {
                    llllllllllIlllIIIlIIIIlIlIIIllIl.addProperty(llllllllllIlllIIIlIIIIlIlIIIllII.getName(), Boolean.valueOf(((BooleanSetting)llllllllllIlllIIIlIIIIlIlIIIllII).getBoolValue()));
                }
                else if (llllllllllIlllIIIlIIIIlIlIIIllII instanceof ListSetting) {
                    llllllllllIlllIIIlIIIIlIlIIIllIl.addProperty(llllllllllIlllIIIlIIIIlIlIIIllII.getName(), ((ListSetting)llllllllllIlllIIIlIIIIlIlIIIllII).getCurrentMode());
                }
                else if (llllllllllIlllIIIlIIIIlIlIIIllII instanceof NumberSetting) {
                    llllllllllIlllIIIlIIIIlIlIIIllIl.addProperty(llllllllllIlllIIIlIIIIlIlIIIllII.getName(), (Number)((NumberSetting)llllllllllIlllIIIlIIIIlIlIIIllII).getNumberValue());
                }
                else if (llllllllllIlllIIIlIIIIlIlIIIllII instanceof ColorSetting) {
                    llllllllllIlllIIIlIIIIlIlIIIllIl.addProperty(llllllllllIlllIIIlIIIIlIlIIIllII.getName(), (Number)((ColorSetting)llllllllllIlllIIIlIIIIlIlIIIllII).getColorValue());
                }
            }
            llllllllllIlllIIIlIIIIlIlIIIlllI.add("Settings", (JsonElement)llllllllllIlllIIIlIIIIlIlIIIllIl);
        }
        return llllllllllIlllIIIlIIIIlIlIIIlllI;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void onDisable() {
        final String llllllllllIlllIIIlIIIIlIIllIllll = ModuleSoundAlert.soundMode.getOptions();
        if (Main.featureDirector.getFeatureByClass(ModuleSoundAlert.class).isToggled()) {
            if (llllllllllIlllIIIlIIIIlIIllIllll.equalsIgnoreCase("Minecraft")) {
                Feature.mc.player.playSound(SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, 1.8f, 0.71999997f);
            }
            if (llllllllllIlllIIIlIIIIlIIllIllll.equalsIgnoreCase("Cosmo")) {
                SoundHelper.playSound("disable.wav");
            }
            if (llllllllllIlllIIIlIIIIlIIllIllll.equalsIgnoreCase("Default")) {
                SoundHelper.playSound("disable2.wav");
            }
        }
        EventManager.unregister(this);
        if (!this.getLabel().contains("ClickGui") && !this.getLabel().contains("Client Font") && !this.getLabel().contains("Rockstar") && Notifications.notifMode.currentMode.equalsIgnoreCase("Rect") && Notifications.state.getBoolValue()) {
            NotificationPublisher.queue(this.getLabel(), "was disabled!", NotificationType.INFO);
        }
        else if (!this.getLabel().contains("ClickGui") && !this.getLabel().contains("Client Font") && !this.getLabel().contains("Rockstar") && Notifications.notifMode.currentMode.equalsIgnoreCase("Chat") && Notifications.state.getBoolValue()) {
            Main.msg(TextFormatting.GRAY + "[Rockstar] " + TextFormatting.WHITE + this.getLabel() + " was" + TextFormatting.RED + " disabled!", false);
        }
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public static double deltaTime() {
        return (Minecraft.getDebugFPS() > 0) ? (1.0 / Minecraft.getDebugFPS()) : 1.0;
    }
    
    public String getSuffix() {
        return (this.suffix == null) ? this.label : this.suffix;
    }
    
    public void setHidden(final boolean llllllllllIlllIIIlIIIIlIIlIllIII) {
        this.visible = !llllllllllIlllIIIlIIIIlIIlIllIII;
    }
    
    public void toggle() {
        this.toggled = !this.toggled;
        this.onToggle();
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public void setup() {
    }
    
    public ScreenHelper getScreenHelper() {
        return this.screenHelper;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public Translate getTranslate() {
        return this.translate;
    }
    
    public String getModuleName() {
        return (this.moduleName == null) ? this.label : this.moduleName;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public void setVisible(final boolean llllllllllIlllIIIlIIIIlIIllIIIll) {
        this.visible = llllllllllIlllIIIlIIIIlIIllIIIll;
    }
    
    public void setModuleName(final String llllllllllIlllIIIlIIIIlIIIIlIlII) {
        this.moduleName = llllllllllIlllIIIlIIIIlIIIIlIlII;
    }
    
    public void setSuffix(final String llllllllllIlllIIIlIIIIlIIIIlllll, final boolean llllllllllIlllIIIlIIIIlIIIIllIll) {
        if (llllllllllIlllIIIlIIIIlIIIIllIll) {
            this.suffix = llllllllllIlllIIIlIIIIlIIIIlllll;
            this.suffix = String.valueOf(this.getLabel()) + " - " + llllllllllIlllIIIlIIIIlIIIIlllll;
        }
    }
    
    public boolean isToggled() {
        return this.toggled;
    }
    
    public void setLabel(final String llllllllllIlllIIIlIIIIlIIlIIIlIl) {
        this.label = llllllllllIlllIIIlIIIIlIIlIIIlIl;
    }
    
    public void onEnable() {
        final String llllllllllIlllIIIlIIIIlIIlllIlIl = ModuleSoundAlert.soundMode.getOptions();
        if (Main.featureDirector.getFeatureByClass(ModuleSoundAlert.class).isToggled()) {
            if (llllllllllIlllIIIlIIIIlIIlllIlIl.equalsIgnoreCase("Minecraft")) {
                Feature.mc.player.playSound(SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, 1.8f, 0.71999997f);
            }
            if (llllllllllIlllIIIlIIIIlIIlllIlIl.equalsIgnoreCase("Cosmo")) {
                SoundHelper.playSound("enable.wav");
            }
            if (llllllllllIlllIIIlIIIIlIIlllIlIl.equalsIgnoreCase("Default")) {
                SoundHelper.playSound("enable2.wav");
            }
        }
        EventManager.register(this);
        if (!this.getLabel().contains("ClickGui") && !this.getLabel().contains("Client Font") && !this.getLabel().contains("Rockstar") && Notifications.notifMode.currentMode.equalsIgnoreCase("Rect") && Notifications.state.getBoolValue()) {
            NotificationPublisher.queue(this.getLabel(), "was enabled!", NotificationType.INFO);
        }
        else if (!this.getLabel().contains("ClickGui") && !this.getLabel().contains("Client Font") && !this.getLabel().contains("Rockstar") && Notifications.notifMode.currentMode.equalsIgnoreCase("Chat") && Notifications.state.getBoolValue()) {
            Main.msg(TextFormatting.GRAY + "[Rockstar] " + TextFormatting.WHITE + this.getLabel() + " was" + TextFormatting.GREEN + " enabled!", false);
        }
    }
    
    public void onToggle() {
    }
    
    public void setEnabled(final boolean llllllllllIlllIIIlIIIIlIIlIlIlII) {
        if (llllllllllIlllIIIlIIIIlIIlIlIlII) {
            EventManager.register(this);
        }
        else {
            EventManager.unregister(this);
        }
        this.toggled = llllllllllIlllIIIlIIIIlIIlIlIlII;
    }
    
    public void setKey(final int llllllllllIlllIIIlIIIIlIIIllIIll) {
        this.key = llllllllllIlllIIIlIIIIlIIIllIIll;
    }
    
    public void load(final JsonObject llllllllllIlllIIIlIIIIlIIlllllII) {
        if (llllllllllIlllIIIlIIIIlIIlllllII != null) {
            if (llllllllllIlllIIIlIIIIlIIlllllII.has("state")) {
                this.setEnabled(llllllllllIlllIIIlIIIIlIIlllllII.get("state").getAsBoolean());
            }
            if (llllllllllIlllIIIlIIIIlIIlllllII.has("visible")) {
                this.setVisible(llllllllllIlllIIIlIIIIlIIlllllII.get("visible").getAsBoolean());
            }
            if (llllllllllIlllIIIlIIIIlIIlllllII.has("keyIndex")) {
                this.setKey(llllllllllIlllIIIlIIIIlIIlllllII.get("keyIndex").getAsInt());
            }
            for (final Setting llllllllllIlllIIIlIIIIlIIlllllll : this.getSettings()) {
                final JsonObject llllllllllIlllIIIlIIIIlIIllllllI = llllllllllIlllIIIlIIIIlIIlllllII.getAsJsonObject("Settings");
                if (llllllllllIlllIIIlIIIIlIIlllllll == null) {
                    continue;
                }
                if (llllllllllIlllIIIlIIIIlIIllllllI == null) {
                    continue;
                }
                if (!llllllllllIlllIIIlIIIIlIIllllllI.has(llllllllllIlllIIIlIIIIlIIlllllll.getName())) {
                    continue;
                }
                if (llllllllllIlllIIIlIIIIlIIlllllll instanceof BooleanSetting) {
                    ((BooleanSetting)llllllllllIlllIIIlIIIIlIIlllllll).setBoolValue(llllllllllIlllIIIlIIIIlIIllllllI.get(llllllllllIlllIIIlIIIIlIIlllllll.getName()).getAsBoolean());
                }
                else if (llllllllllIlllIIIlIIIIlIIlllllll instanceof ListSetting) {
                    ((ListSetting)llllllllllIlllIIIlIIIIlIIlllllll).setListMode(llllllllllIlllIIIlIIIIlIIllllllI.get(llllllllllIlllIIIlIIIIlIIlllllll.getName()).getAsString());
                }
                else if (llllllllllIlllIIIlIIIIlIIlllllll instanceof NumberSetting) {
                    ((NumberSetting)llllllllllIlllIIIlIIIIlIIlllllll).setValueNumber(llllllllllIlllIIIlIIIIlIIllllllI.get(llllllllllIlllIIIlIIIIlIIlllllll.getName()).getAsFloat());
                }
                else {
                    if (!(llllllllllIlllIIIlIIIIlIIlllllll instanceof ColorSetting)) {
                        continue;
                    }
                    ((ColorSetting)llllllllllIlllIIIlIIIIlIIlllllll).setColorValue(llllllllllIlllIIIlIIIIlIIllllllI.get(llllllllllIlllIIIlIIIIlIIlllllll.getName()).getAsInt());
                }
            }
        }
    }
}
