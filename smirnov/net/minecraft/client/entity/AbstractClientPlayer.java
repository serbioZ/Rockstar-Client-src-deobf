// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.entity;

import optifine.Config;
import net.minecraft.world.GameType;
import optifine.PlayerConfigurations;
import optifine.CapeUtils;
import com.mojang.authlib.GameProfile;
import net.minecraft.world.World;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import ru.rockstar.Main;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.IImageBuffer;
import java.io.File;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.util.StringUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import optifine.Reflector;
import net.minecraft.init.Items;
import net.minecraft.entity.SharedMonsterAttributes;
import javax.annotation.Nullable;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;

public abstract class AbstractClientPlayer extends EntityPlayer
{
    private /* synthetic */ String nameClear;
    private /* synthetic */ NetworkPlayerInfo playerInfo;
    private /* synthetic */ ResourceLocation locationOfCape;
    
    public String getSkinType() {
        final NetworkPlayerInfo llllllllllllIIllIlllIlIIIlIlllIl = this.getPlayerInfo();
        return (llllllllllllIIllIlllIlIIIlIlllIl == null) ? DefaultPlayerSkin.getSkinType(this.getUniqueID()) : llllllllllllIIllIlllIlIIIlIlllIl.getSkinType();
    }
    
    @Nullable
    public ResourceLocation getLocationElytra() {
        final NetworkPlayerInfo llllllllllllIIllIlllIlIIIlllIIlI = this.getPlayerInfo();
        return (llllllllllllIIllIlllIlIIIlllIIlI == null) ? null : llllllllllllIIllIlllIlIIIlllIIlI.getLocationElytra();
    }
    
    public float getFovModifier() {
        float llllllllllllIIllIlllIlIIIlIlIlII = 1.0f;
        if (this.capabilities.isFlying) {
            llllllllllllIIllIlllIlIIIlIlIlII *= 1.1f;
        }
        final IAttributeInstance llllllllllllIIllIlllIlIIIlIlIIll = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        llllllllllllIIllIlllIlIIIlIlIlII *= (float)((llllllllllllIIllIlllIlIIIlIlIIll.getAttributeValue() / this.capabilities.getWalkSpeed() + 1.0) / 2.0);
        if (this.capabilities.getWalkSpeed() == 0.0f || Float.isNaN(llllllllllllIIllIlllIlIIIlIlIlII) || Float.isInfinite(llllllllllllIIllIlllIlIIIlIlIlII)) {
            llllllllllllIIllIlllIlIIIlIlIlII = 1.0f;
        }
        if (this.isHandActive() && this.getActiveItemStack().getItem() == Items.BOW) {
            final int llllllllllllIIllIlllIlIIIlIlIIlI = this.getItemInUseMaxCount();
            float llllllllllllIIllIlllIlIIIlIlIIIl = llllllllllllIIllIlllIlIIIlIlIIlI / 20.0f;
            if (llllllllllllIIllIlllIlIIIlIlIIIl > 1.0f) {
                llllllllllllIIllIlllIlIIIlIlIIIl = 1.0f;
            }
            else {
                llllllllllllIIllIlllIlIIIlIlIIIl *= llllllllllllIIllIlllIlIIIlIlIIIl;
            }
            llllllllllllIIllIlllIlIIIlIlIlII *= 1.0f - llllllllllllIIllIlllIlIIIlIlIIIl * 0.15f;
        }
        return Reflector.ForgeHooksClient_getOffsetFOV.exists() ? Reflector.callFloat(Reflector.ForgeHooksClient_getOffsetFOV, new Object[] { this, llllllllllllIIllIlllIlIIIlIlIlII }) : llllllllllllIIllIlllIlIIIlIlIlII;
    }
    
    public static ThreadDownloadImageData getDownloadImageSkin(final ResourceLocation llllllllllllIIllIlllIlIIIllIlIll, final String llllllllllllIIllIlllIlIIIllIIllI) {
        final TextureManager llllllllllllIIllIlllIlIIIllIlIIl = Minecraft.getMinecraft().getTextureManager();
        ITextureObject llllllllllllIIllIlllIlIIIllIlIII = llllllllllllIIllIlllIlIIIllIlIIl.getTexture(llllllllllllIIllIlllIlIIIllIlIll);
        if (llllllllllllIIllIlllIlIIIllIlIII == null) {
            llllllllllllIIllIlllIlIIIllIlIII = new ThreadDownloadImageData(null, String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", StringUtils.stripControlCodes(llllllllllllIIllIlllIlIIIllIIllI)), DefaultPlayerSkin.getDefaultSkin(EntityPlayer.getOfflineUUID(llllllllllllIIllIlllIlIIIllIIllI)), new ImageBufferDownload());
            llllllllllllIIllIlllIlIIIllIlIIl.loadTexture(llllllllllllIIllIlllIlIIIllIlIll, llllllllllllIIllIlllIlIIIllIlIII);
        }
        return (ThreadDownloadImageData)llllllllllllIIllIlllIlIIIllIlIII;
    }
    
    static {
        TEXTURE_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
    }
    
    @Nullable
    protected NetworkPlayerInfo getPlayerInfo() {
        if (this.playerInfo == null) {
            this.playerInfo = Minecraft.getMinecraft().getConnection().getPlayerInfo(this.getUniqueID());
        }
        return this.playerInfo;
    }
    
    public ResourceLocation getLocationSkin() {
        final NetworkPlayerInfo llllllllllllIIllIlllIlIIlIIIIIIl = this.getPlayerInfo();
        if (llllllllllllIIllIlllIlIIlIIIIIIl == null || (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.skinSpoof.getBoolValue())) {
            return DefaultPlayerSkin.getDefaultSkin(this.getUniqueID());
        }
        return llllllllllllIIllIlllIlIIlIIIIIIl.getLocationSkin();
    }
    
    public static ResourceLocation getLocationSkin(final String llllllllllllIIllIlllIlIIIllIIIlI) {
        return new ResourceLocation("skins/" + StringUtils.stripControlCodes(llllllllllllIIllIlllIlIIIllIIIlI));
    }
    
    public AbstractClientPlayer(final World llllllllllllIIllIlllIlIIlIlIIIIl, final GameProfile llllllllllllIIllIlllIlIIlIIlllIl) {
        super(llllllllllllIIllIlllIlIIlIlIIIIl, llllllllllllIIllIlllIlIIlIIlllIl);
        this.locationOfCape = null;
        this.nameClear = null;
        this.nameClear = llllllllllllIIllIlllIlIIlIIlllIl.getName();
        if (this.nameClear != null && !this.nameClear.isEmpty()) {
            this.nameClear = StringUtils.stripControlCodes(this.nameClear);
        }
        CapeUtils.downloadCape(this);
        PlayerConfigurations.getPlayerConfiguration(this);
    }
    
    @Override
    public boolean isCreative() {
        final NetworkPlayerInfo llllllllllllIIllIlllIlIIlIIlIIll = Minecraft.getMinecraft().getConnection().getPlayerInfo(this.getGameProfile().getId());
        return llllllllllllIIllIlllIlIIlIIlIIll != null && llllllllllllIIllIlllIlIIlIIlIIll.getGameType() == GameType.CREATIVE;
    }
    
    public ResourceLocation getLocationOfCape() {
        return this.locationOfCape;
    }
    
    public boolean hasElytraCape() {
        final ResourceLocation llllllllllllIIllIlllIlIIIIllllII = this.getLocationCape();
        return llllllllllllIIllIlllIlIIIIllllII != null && llllllllllllIIllIlllIlIIIIllllII != this.locationOfCape;
    }
    
    @Override
    public boolean isSpectator() {
        final NetworkPlayerInfo llllllllllllIIllIlllIlIIlIIllIIl = Minecraft.getMinecraft().getConnection().getPlayerInfo(this.getGameProfile().getId());
        return llllllllllllIIllIlllIlIIlIIllIIl != null && llllllllllllIIllIlllIlIIlIIllIIl.getGameType() == GameType.SPECTATOR;
    }
    
    public boolean hasPlayerInfo() {
        return this.getPlayerInfo() != null;
    }
    
    public void setLocationOfCape(final ResourceLocation llllllllllllIIllIlllIlIIIlIIIIII) {
        this.locationOfCape = llllllllllllIIllIlllIlIIIlIIIIII;
    }
    
    public String getNameClear() {
        return this.nameClear;
    }
    
    public boolean hasSkin() {
        final NetworkPlayerInfo llllllllllllIIllIlllIlIIlIIIIlll = this.getPlayerInfo();
        return llllllllllllIIllIlllIlIIlIIIIlll != null && llllllllllllIIllIlllIlIIlIIIIlll.hasLocationSkin();
    }
    
    public boolean isPlayerInfoSet() {
        return this.getPlayerInfo() != null;
    }
    
    @Nullable
    public ResourceLocation getLocationCape() {
        if (!Config.isShowCapes()) {
            return null;
        }
        if (this.locationOfCape != null) {
            return this.locationOfCape;
        }
        final NetworkPlayerInfo llllllllllllIIllIlllIlIIIllllIll = this.getPlayerInfo();
        return (llllllllllllIIllIlllIlIIIllllIll == null) ? null : llllllllllllIIllIlllIlIIIllllIll.getLocationCape();
    }
}
