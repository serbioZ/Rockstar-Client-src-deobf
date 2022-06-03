// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import ru.rockstar.api.utils.render.ClientHelper;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.Main;
import net.minecraft.client.Minecraft;
import ru.rockstar.security.CFontUser;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class Watermark extends Feature
{
    public static /* synthetic */ BooleanSetting time;
    public static /* synthetic */ ListSetting waterMarkMode;
    public static /* synthetic */ BooleanSetting rect;
    public static /* synthetic */ Boolean a;
    public static /* synthetic */ BooleanSetting cords;
    public static /* synthetic */ BooleanSetting fps;
    public static /* synthetic */ ListSetting bgMode;
    public static /* synthetic */ BooleanSetting logo;
    public static /* synthetic */ BooleanSetting server;
    public static /* synthetic */ BooleanSetting username;
    
    static {
        Watermark.username = new BooleanSetting("Username", false, () -> true);
        Watermark.server = new BooleanSetting("Server", false, () -> true);
        Watermark.fps = new BooleanSetting("Fps", false, () -> true);
        Watermark.time = new BooleanSetting("Time", false, () -> true);
        Watermark.a = false;
    }
    
    @EventTarget
    public void ebatkopat(final Event2D llllllllllllIIlllllllIIllIIlIlII) {
        if (Watermark.waterMarkMode.getOptions().equalsIgnoreCase("Rockstar")) {
            Watermark.a = true;
        }
        String llllllllllllIIlllllllIIllIIlIIlI = null;
        if (Watermark.mc.isSingleplayer()) {
            final String llllllllllllIIlllllllIIllIIlIIll = "localhost";
        }
        else {
            llllllllllllIIlllllllIIllIIlIIlI = Watermark.mc.getCurrentServerData().serverIP.toLowerCase();
        }
        boolean llllllllllllIIlllllllIIllIIlIIIl = false;
        if (Watermark.username.getBoolValue()) {
            llllllllllllIIlllllllIIllIIlIIIl = true;
        }
        boolean llllllllllllIIlllllllIIllIIlIIII = false;
        if (Watermark.server.getBoolValue()) {
            llllllllllllIIlllllllIIllIIlIIII = true;
        }
        boolean llllllllllllIIlllllllIIllIIIllll = false;
        if (Watermark.fps.getBoolValue()) {
            llllllllllllIIlllllllIIllIIIllll = true;
        }
        boolean llllllllllllIIlllllllIIllIIIlllI = false;
        if (Watermark.time.getBoolValue()) {
            llllllllllllIIlllllllIIllIIIlllI = true;
        }
        final String llllllllllllIIlllllllIIllIIIllIl = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        final String llllllllllllIIlllllllIIllIIIllII = "rockclient.xyz" + (llllllllllllIIlllllllIIllIIlIIIl ? ("§8 | §f" + CFontUser.username) : "") + (llllllllllllIIlllllllIIllIIlIIII ? ("§8 | §f" + llllllllllllIIlllllllIIllIIlIIlI) : "") + (llllllllllllIIlllllllIIllIIIllll ? (" §8 | §f fps: §a" + Minecraft.getDebugFPS()) : "") + (llllllllllllIIlllllllIIllIIIlllI ? (" §8 | §f " + llllllllllllIIlllllllIIllIIIllIl) : "");
        int llllllllllllIIlllllllIIllIIIlIll = 0;
        for (int llllllllllllIIlllllllIIllIIIlIlI = 0; llllllllllllIIlllllllIIllIIIlIlI < Main.featureDirector.getFeatureList().size(); ++llllllllllllIIlllllllIIllIIIlIlI) {
            llllllllllllIIlllllllIIllIIIlIll += Minecraft.getMinecraft().sfui16.getFontHeight() + 5;
        }
        final String llllllllllllIIlllllllIIllIIIlIIl = Watermark.waterMarkMode.getOptions();
        final String llllllllllllIIlllllllIIllIIIlIII = Watermark.mc.player.getName();
        this.setModuleName("Watermark §7" + llllllllllllIIlllllllIIllIIIlIIl);
        if (llllllllllllIIlllllllIIllIIIlIIl.equalsIgnoreCase("NoRender")) {
            Minecraft.getMinecraft().sfui18.drawStringWithShadow(String.valueOf(Main.instance.name) + ChatFormatting.GRAY + " (" + ChatFormatting.WHITE + llllllllllllIIlllllllIIllIIIllIl + ChatFormatting.GRAY + ")", 3.0, 4.0, ClientHelper.getClientColor().getRGB());
        }
        else if (llllllllllllIIlllllllIIllIIIlIIl.equalsIgnoreCase("OnetapV2")) {
            Gui.drawRect(5.0, 6.0, Minecraft.getMinecraft().neverlose500_15.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 9, 18.0, new Color(31, 31, 31, 255).getRGB());
            for (float llllllllllllIIlllllllIIllIIIIlll = 0.0f; llllllllllllIIlllllllIIllIIIIlll < Minecraft.getMinecraft().neverlose500_15.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 4; ++llllllllllllIIlllllllIIllIIIIlll) {
                Gui.drawRect(5.0f + llllllllllllIIlllllllIIllIIIIlll, 5.0, llllllllllllIIlllllllIIllIIIIlll + 6.0f, 6.0, ClientHelper.getClientColor(5.0f, llllllllllllIIlllllllIIllIIIIlll, 5).getRGB());
            }
            Gui.drawRect(5.0, 6.0, Minecraft.getMinecraft().neverlose500_15.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 9, 6.5, new Color(20, 20, 20, 100).getRGB());
            Minecraft.getMinecraft().neverlose500_15.drawStringWithShadow(llllllllllllIIlllllllIIllIIIllII, 7.0, 10.5, -1);
        }
        else if (llllllllllllIIlllllllIIllIIIlIIl.equalsIgnoreCase("Neverlose")) {
            final String llllllllllllIIlllllllIIllIIIIllI = String.valueOf(llllllllllllIIlllllllIIllIIIlIII) + " | " + Minecraft.getDebugFPS() + " fps" + " | " + llllllllllllIIlllllllIIllIIlIIlI;
            final String llllllllllllIIlllllllIIllIIIIlIl = "ROCKSTAR PREMIUM | " + llllllllllllIIlllllllIIllIIIlIII + " | " + Minecraft.getDebugFPS() + " fps" + " | " + llllllllllllIIlllllllIIllIIlIIlI;
            DrawHelper.drawGlowRoundedRect(2.0f, 4.0f, (float)(Minecraft.getMinecraft().neverlose500_15.getStringWidth(llllllllllllIIlllllllIIllIIIIlIl) + 15), 20.0f, new Color(10, 10, 10, 200).getRGB(), 5.0f, 5.0f);
            DrawHelper.drawSmoothRect(5.0f, 6.0f, (float)(Minecraft.getMinecraft().neverlose500_15.getStringWidth(llllllllllllIIlllllllIIllIIIIlIl) + 12), 18.0f, new Color(10, 10, 10, 255).getRGB());
            Minecraft.getMinecraft().lato15.drawStringWithShadow("ROCKSTAR PREMIUM", 7.5, 10.0, ClientHelper.getClientColor().getRGB());
            Minecraft.getMinecraft().lato15.drawStringWithShadow("ROCKSTAR PREMIUM", 8.0, 10.5, -1);
            Minecraft.getMinecraft().neverlose500_15.drawStringWithShadow("| " + llllllllllllIIlllllllIIllIIIIllI, 7 + Minecraft.getMinecraft().neverlose500_15.getStringWidth("ROCKSTAR PREMIUM | "), 10.5, -1);
        }
        else if (llllllllllllIIlllllllIIllIIIlIIl.equalsIgnoreCase("Rockstar")) {
            final String llllllllllllIIlllllllIIllIIIIlII = "XYZ: " + (int)Minecraft.getMinecraft().player.posX + " " + (int)Minecraft.getMinecraft().player.posY + " " + (int)Minecraft.getMinecraft().player.posZ;
            if (Watermark.bgMode.getOptions().equalsIgnoreCase("Glow")) {
                if (Watermark.logo.getBoolValue()) {
                    DrawHelper.drawRectWithGlow(7.0, 7.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 25, 22.0, 5.0, 10.0, new Color(1, 1, 1, 255));
                    if (Watermark.cords.getBoolValue()) {
                        DrawHelper.drawRectWithGlow(7.0, 30.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIIlII) + 15, 45.0, 5.0, 10.0, new Color(1, 1, 1, 255));
                        Minecraft.getMinecraft().neverlose500_20.drawStringWithShadow(llllllllllllIIlllllllIIllIIIIlII, 12.0, 35.0, -1);
                    }
                }
                else {
                    DrawHelper.drawRectWithGlow(7.0, 7.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 15, 22.0, 5.0, 10.0, new Color(1, 1, 1, 255));
                    if (Watermark.cords.getBoolValue()) {
                        DrawHelper.drawRectWithGlow(7.0, 30.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIIlII) + 15, 45.0, 5.0, 10.0, new Color(1, 1, 1, 255));
                        Minecraft.getMinecraft().neverlose500_19.drawStringWithShadow(llllllllllllIIlllllllIIllIIIIlII, 12.0, 35.0, -1);
                    }
                }
                if (Watermark.rect.getBoolValue()) {
                    DrawHelper.drawRectWithGlow(7.0, 23.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 15 + 10, 24.0, 5.0, 15.0, new Color(255, 255, 255, 255));
                    if (Watermark.cords.getBoolValue()) {
                        DrawHelper.drawRectWithGlow(7.0, 46.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIIlII) + 15, 47.0, 5.0, 15.0, new Color(255, 255, 255, 255));
                    }
                }
            }
            else if (Watermark.bgMode.getOptions().equalsIgnoreCase("Rect")) {
                if (Watermark.logo.getBoolValue()) {
                    DrawHelper.drawNewRect(7.0, 7.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 25, 22.0, new Color(1, 1, 1, 150).getRGB());
                    DrawHelper.drawGradientRect(5.0, 6.5, 7.0, 22.5, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    if (Watermark.cords.getBoolValue()) {
                        DrawHelper.drawNewRect(7.0, 25.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIIlII) + 15, 39.0, new Color(1, 1, 1, 150).getRGB());
                        DrawHelper.drawGradientRect(5.0, 24.5, 7.0, 39.5, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                        Minecraft.getMinecraft().neverlose500_20.drawStringWithShadow(llllllllllllIIlllllllIIllIIIIlII, 12.0, 29.0, -1);
                    }
                }
                else {
                    DrawHelper.drawNewRect(7.0, 7.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 15, 22.0, new Color(1, 1, 1, 150).getRGB());
                    DrawHelper.drawGradientRect(5.0, 6.5, 7.0, 22.5, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                    if (Watermark.cords.getBoolValue()) {
                        DrawHelper.drawNewRect(7.0, 25.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIIlII) + 15, 39.0, new Color(1, 1, 1, 150).getRGB());
                        DrawHelper.drawGradientRect(5.0, 24.5, 7.0, 39.5, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                        Minecraft.getMinecraft().neverlose500_20.drawStringWithShadow(llllllllllllIIlllllllIIllIIIIlII, 12.0, 29.0, -1);
                    }
                }
                if (Watermark.rect.getBoolValue()) {
                    DrawHelper.drawNewRect(7.0, 21.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 25, 23.0, new Color(255, 255, 255, 255).getRGB());
                    if (Watermark.cords.getBoolValue()) {
                        DrawHelper.drawNewRect(7.0, 38.0, Minecraft.getMinecraft().neverlose500_20.getStringWidth(llllllllllllIIlllllllIIllIIIIlII) + 15, 40.0, new Color(255, 255, 255, 255).getRGB());
                    }
                }
            }
            else if (Watermark.cords.getBoolValue()) {
                Minecraft.getMinecraft().neverlose500_20.drawStringWithShadow("XYZ: " + (int)Minecraft.getMinecraft().player.posX + " " + (int)Minecraft.getMinecraft().player.posY + " " + (int)Minecraft.getMinecraft().player.posZ, 12.0, 32.0, -1);
            }
            if (Watermark.logo.getBoolValue()) {
                Minecraft.getMinecraft().neverlose500_20.drawStringWithShadow(llllllllllllIIlllllllIIllIIIllII, 22.0, 11.0, -1);
                DrawHelper.drawImage(new ResourceLocation("rockstar/logo.png"), 7.0f, 7.0f, 15.0f, 15.0f, Color.WHITE);
            }
            else {
                Minecraft.getMinecraft().neverlose500_20.drawStringWithShadow(llllllllllllIIlllllllIIllIIIllII, 12.0, 11.0, -1);
            }
        }
        else if (llllllllllllIIlllllllIIllIIIlIIl.equalsIgnoreCase("WexSide")) {
            GlStateManager.enableBlend();
            DrawHelper.drawGlowRoundedRect(5.0f, 5.0f, (float)(Minecraft.getMinecraft().mntsb.getStringWidth(llllllllllllIIlllllllIIllIIIllII) + 26 + 3), 24.0f, new Color(1, 1, 1, 255).getRGB(), 10.0f, 9.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            Minecraft.getMinecraft().icons2_30.drawString("g", 9.8f, 9.8f, new Color(0, 255, 255, 255).getRGB());
            Minecraft.getMinecraft().icons2_30.drawString("g", 10.0f, 10.0f, -1);
            Minecraft.getMinecraft().mntsb.drawStringWithShadow(llllllllllllIIlllllllIIllIIIllII, 23.0, 12.5, new Color(240, 240, 240, 255).getRGB());
        }
    }
    
    public Watermark() {
        super("Watermark", "Client logo.", 0, Category.DISPLAY);
        Watermark.waterMarkMode = new ListSetting("WaterMark Mode", "NoRender", () -> true, new String[] { "NoRender", "OnetapV2", "Neverlose", "Rockstar", "WexSide" });
        Watermark.bgMode = new ListSetting("BackGround Mode", "None", () -> Watermark.waterMarkMode.getOptions().equalsIgnoreCase("Rockstar"), new String[] { "Rect", "Glow", "None" });
        Watermark.cords = new BooleanSetting("Cords", false, () -> Watermark.waterMarkMode.getOptions().equalsIgnoreCase("Rockstar"));
        Watermark.rect = new BooleanSetting("Rect", false, () -> Watermark.waterMarkMode.getOptions().equalsIgnoreCase("Rockstar"));
        Watermark.logo = new BooleanSetting("Logo", false, () -> Watermark.waterMarkMode.getOptions().equalsIgnoreCase("Rockstar"));
        this.addSettings(Watermark.waterMarkMode, Watermark.bgMode, Watermark.logo, Watermark.rect, Watermark.cords, Watermark.username, Watermark.server, Watermark.fps, Watermark.time);
    }
}
