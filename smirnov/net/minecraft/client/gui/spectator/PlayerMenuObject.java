// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.spectator;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketSpectate;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import com.mojang.authlib.GameProfile;

public class PlayerMenuObject implements ISpectatorMenuObject
{
    private final /* synthetic */ GameProfile profile;
    private final /* synthetic */ ResourceLocation resourceLocation;
    
    @Override
    public ITextComponent getSpectatorName() {
        return new TextComponentString(this.profile.getName());
    }
    
    @Override
    public void renderIcon(final float lllllllllllIllllllIIIlIIllIIlIII, final int lllllllllllIllllllIIIlIIllIIIlll) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.resourceLocation);
        GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllIllllllIIIlIIllIIIlll / 255.0f);
        Gui.drawScaledCustomSizeModalRect(2, 2, 8.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
        Gui.drawScaledCustomSizeModalRect(2, 2, 40.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
    }
    
    public PlayerMenuObject(final GameProfile lllllllllllIllllllIIIlIIllIlIlIl) {
        this.profile = lllllllllllIllllllIIIlIIllIlIlIl;
        this.resourceLocation = AbstractClientPlayer.getLocationSkin(lllllllllllIllllllIIIlIIllIlIlIl.getName());
        AbstractClientPlayer.getDownloadImageSkin(this.resourceLocation, lllllllllllIllllllIIIlIIllIlIlIl.getName());
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public void selectItem(final SpectatorMenu lllllllllllIllllllIIIlIIllIlIIII) {
        Minecraft.getMinecraft().getConnection().sendPacket(new CPacketSpectate(this.profile.getId()));
    }
}
