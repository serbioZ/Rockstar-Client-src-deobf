// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.network;

import com.google.common.base.MoreObjects;
import net.minecraft.scoreboard.ScorePlayerTeam;
import javax.annotation.Nullable;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import com.google.common.collect.Maps;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.world.GameType;
import net.minecraft.util.ResourceLocation;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import java.util.Map;
import net.minecraft.util.text.ITextComponent;
import com.mojang.authlib.GameProfile;

public class NetworkPlayerInfo
{
    private /* synthetic */ long lastHealthTime;
    private /* synthetic */ int lastHealth;
    private /* synthetic */ String skinType;
    private final /* synthetic */ GameProfile gameProfile;
    private /* synthetic */ ITextComponent displayName;
    /* synthetic */ Map<MinecraftProfileTexture.Type, ResourceLocation> playerTextures;
    private /* synthetic */ GameType gameType;
    private /* synthetic */ int displayHealth;
    private /* synthetic */ boolean playerTexturesLoaded;
    private /* synthetic */ long healthBlinkTime;
    private /* synthetic */ long renderVisibilityId;
    private /* synthetic */ int responseTime;
    
    public String getSkinType() {
        return (this.skinType == null) ? DefaultPlayerSkin.getSkinType(this.gameProfile.getId()) : this.skinType;
    }
    
    protected void setResponseTime(final int lllllllllllIlIIllllIIIIlIlllIlll) {
        this.responseTime = lllllllllllIlIIllllIIIIlIlllIlll;
    }
    
    public NetworkPlayerInfo(final GameProfile lllllllllllIlIIllllIIIIllIIlIlII) {
        this.playerTextures = (Map<MinecraftProfileTexture.Type, ResourceLocation>)Maps.newEnumMap((Class)MinecraftProfileTexture.Type.class);
        this.gameProfile = lllllllllllIlIIllllIIIIllIIlIlII;
    }
    
    public NetworkPlayerInfo(final SPacketPlayerListItem.AddPlayerData lllllllllllIlIIllllIIIIllIIIlllI) {
        this.playerTextures = (Map<MinecraftProfileTexture.Type, ResourceLocation>)Maps.newEnumMap((Class)MinecraftProfileTexture.Type.class);
        this.gameProfile = lllllllllllIlIIllllIIIIllIIIlllI.getProfile();
        this.gameType = lllllllllllIlIIllllIIIIllIIIlllI.getGameMode();
        this.responseTime = lllllllllllIlIIllllIIIIllIIIlllI.getPing();
        this.displayName = lllllllllllIlIIllllIIIIllIIIlllI.getDisplayName();
    }
    
    public void setRenderVisibilityId(final long lllllllllllIlIIllllIIIIlIIlIlIlI) {
        this.renderVisibilityId = lllllllllllIlIIllllIIIIlIIlIlIlI;
    }
    
    public boolean hasLocationSkin() {
        return this.getLocationSkin() != null;
    }
    
    public int getResponseTime() {
        return this.responseTime;
    }
    
    public long getLastHealthTime() {
        return this.lastHealthTime;
    }
    
    public GameProfile getGameProfile() {
        return this.gameProfile;
    }
    
    public long getHealthBlinkTime() {
        return this.healthBlinkTime;
    }
    
    public void setDisplayHealth(final int lllllllllllIlIIllllIIIIlIlIIIlll) {
        this.displayHealth = lllllllllllIlIIllllIIIIlIlIIIlll;
    }
    
    public void setHealthBlinkTime(final long lllllllllllIlIIllllIIIIlIIllIIll) {
        this.healthBlinkTime = lllllllllllIlIIllllIIIIlIIllIIll;
    }
    
    public void setLastHealthTime(final long lllllllllllIlIIllllIIIIlIIlllllI) {
        this.lastHealthTime = lllllllllllIlIIllllIIIIlIIlllllI;
    }
    
    protected void loadPlayerTextures() {
        final Exception lllllllllllIlIIllllIIIIlIllIIIII = (Exception)this;
        synchronized (this) {
            if (!this.playerTexturesLoaded) {
                this.playerTexturesLoaded = true;
                Minecraft.getMinecraft().getSkinManager().loadProfileTextures(this.gameProfile, new SkinManager.SkinAvailableCallback() {
                    static /* synthetic */ int[] $SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type() {
                        final int[] $switch_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type = NetworkPlayerInfo$1.$SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type;
                        if ($switch_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type != null) {
                            return $switch_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type;
                        }
                        final char lllllllllllIlllIIIIlllllIIIIIIll = (Object)new int[MinecraftProfileTexture.Type.values().length];
                        try {
                            lllllllllllIlllIIIIlllllIIIIIIll[MinecraftProfileTexture.Type.CAPE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError noSuchFieldError) {}
                        try {
                            lllllllllllIlllIIIIlllllIIIIIIll[MinecraftProfileTexture.Type.ELYTRA.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError noSuchFieldError2) {}
                        try {
                            lllllllllllIlllIIIIlllllIIIIIIll[MinecraftProfileTexture.Type.SKIN.ordinal()] = true;
                        }
                        catch (NoSuchFieldError noSuchFieldError3) {}
                        return NetworkPlayerInfo$1.$SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type = (int[])(Object)lllllllllllIlllIIIIlllllIIIIIIll;
                    }
                    
                    @Override
                    public void skinAvailable(final MinecraftProfileTexture.Type lllllllllllIlllIIIIlllllIIIIIlll, final ResourceLocation lllllllllllIlllIIIIlllllIIIIlIlI, final MinecraftProfileTexture lllllllllllIlllIIIIlllllIIIIIlIl) {
                        switch ($SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type()[lllllllllllIlllIIIIlllllIIIIIlll.ordinal()]) {
                            case 1: {
                                NetworkPlayerInfo.this.playerTextures.put(MinecraftProfileTexture.Type.SKIN, lllllllllllIlllIIIIlllllIIIIlIlI);
                                NetworkPlayerInfo.access$0(NetworkPlayerInfo.this, lllllllllllIlllIIIIlllllIIIIIlIl.getMetadata("model"));
                                if (NetworkPlayerInfo.this.skinType == null) {
                                    NetworkPlayerInfo.access$0(NetworkPlayerInfo.this, "default");
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                NetworkPlayerInfo.this.playerTextures.put(MinecraftProfileTexture.Type.CAPE, lllllllllllIlllIIIIlllllIIIIlIlI);
                                break;
                            }
                            case 3: {
                                NetworkPlayerInfo.this.playerTextures.put(MinecraftProfileTexture.Type.ELYTRA, lllllllllllIlllIIIIlllllIIIIlIlI);
                                break;
                            }
                        }
                    }
                }, true);
            }
        }
    }
    
    protected void setGameType(final GameType lllllllllllIlIIllllIIIIllIIIIIlI) {
        this.gameType = lllllllllllIlIIllllIIIIllIIIIIlI;
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
    
    public int getLastHealth() {
        return this.lastHealth;
    }
    
    public long getRenderVisibilityId() {
        return this.renderVisibilityId;
    }
    
    @Nullable
    public ResourceLocation getLocationElytra() {
        this.loadPlayerTextures();
        return this.playerTextures.get(MinecraftProfileTexture.Type.ELYTRA);
    }
    
    @Nullable
    public ScorePlayerTeam getPlayerTeam() {
        return Minecraft.getMinecraft().world.getScoreboard().getPlayersTeam(this.getGameProfile().getName());
    }
    
    public int getDisplayHealth() {
        return this.displayHealth;
    }
    
    public void setDisplayName(@Nullable final ITextComponent lllllllllllIlIIllllIIIIlIlIllIlI) {
        this.displayName = lllllllllllIlIIllllIIIIlIlIllIlI;
    }
    
    static /* synthetic */ void access$0(final NetworkPlayerInfo lllllllllllIlIIllllIIIIlIIlIIlll, final String lllllllllllIlIIllllIIIIlIIlIIllI) {
        lllllllllllIlIIllllIIIIlIIlIIlll.skinType = lllllllllllIlIIllllIIIIlIIlIIllI;
    }
    
    public ResourceLocation getLocationSkin() {
        this.loadPlayerTextures();
        return (ResourceLocation)MoreObjects.firstNonNull((Object)this.playerTextures.get(MinecraftProfileTexture.Type.SKIN), (Object)DefaultPlayerSkin.getDefaultSkin(this.gameProfile.getId()));
    }
    
    @Nullable
    public ITextComponent getDisplayName() {
        return this.displayName;
    }
    
    @Nullable
    public ResourceLocation getLocationCape() {
        this.loadPlayerTextures();
        return this.playerTextures.get(MinecraftProfileTexture.Type.CAPE);
    }
    
    public void setLastHealth(final int lllllllllllIlIIllllIIIIlIlIIlllI) {
        this.lastHealth = lllllllllllIlIIllllIIIIlIlIIlllI;
    }
}
