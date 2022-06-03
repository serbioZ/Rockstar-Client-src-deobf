// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.spectator.categories;

import net.minecraft.client.entity.AbstractClientPlayer;
import java.util.Random;
import net.minecraft.client.resources.DefaultPlayerSkin;
import java.util.Collection;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.gui.spectator.SpectatorMenu;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.client.Minecraft;
import com.google.common.collect.Lists;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.client.gui.spectator.ISpectatorMenuObject;
import net.minecraft.client.gui.spectator.ISpectatorMenuView;

public class TeleportToTeam implements ISpectatorMenuView, ISpectatorMenuObject
{
    private final /* synthetic */ List<ISpectatorMenuObject> items;
    
    @Override
    public ITextComponent getSpectatorName() {
        return new TextComponentTranslation("spectatorMenu.team_teleport", new Object[0]);
    }
    
    public TeleportToTeam() {
        this.items = (List<ISpectatorMenuObject>)Lists.newArrayList();
        final Minecraft lllllllllllIlllIlIllIIIIIIlIlIII = Minecraft.getMinecraft();
        for (final ScorePlayerTeam lllllllllllIlllIlIllIIIIIIlIIlll : lllllllllllIlllIlIllIIIIIIlIlIII.world.getScoreboard().getTeams()) {
            this.items.add(new TeamSelectionObject(lllllllllllIlllIlIllIIIIIIlIIlll));
        }
    }
    
    @Override
    public boolean isEnabled() {
        for (final ISpectatorMenuObject lllllllllllIlllIlIllIIIIIIIlIIII : this.items) {
            if (lllllllllllIlllIlIllIIIIIIIlIIII.isEnabled()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public ITextComponent getPrompt() {
        return new TextComponentTranslation("spectatorMenu.team_teleport.prompt", new Object[0]);
    }
    
    @Override
    public void renderIcon(final float lllllllllllIlllIlIllIIIIIIIlIllI, final int lllllllllllIlllIlIllIIIIIIIlIlIl) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
        Gui.drawModalRectWithCustomSizedTexture(0.0f, 0.0f, 16.0f, 0.0f, 16.0f, 16.0f, 256.0f, 256.0f);
    }
    
    @Override
    public List<ISpectatorMenuObject> getItems() {
        return this.items;
    }
    
    @Override
    public void selectItem(final SpectatorMenu lllllllllllIlllIlIllIIIIIIIllIIl) {
        lllllllllllIlllIlIllIIIIIIIllIIl.selectCategory(this);
    }
    
    class TeamSelectionObject implements ISpectatorMenuObject
    {
        private final /* synthetic */ ScorePlayerTeam team;
        private final /* synthetic */ List<NetworkPlayerInfo> players;
        private final /* synthetic */ ResourceLocation location;
        
        @Override
        public ITextComponent getSpectatorName() {
            return new TextComponentString(this.team.getTeamName());
        }
        
        @Override
        public void renderIcon(final float llllllllllIllllIIllllIIlllllllIl, final int llllllllllIllllIIllllIIlllllllII) {
            int llllllllllIllllIIllllIIllllllIll = -1;
            final String llllllllllIllllIIllllIIllllllIlI = FontRenderer.getFormatFromString(this.team.getColorPrefix());
            if (llllllllllIllllIIllllIIllllllIlI.length() >= 2) {
                Minecraft.getMinecraft();
                llllllllllIllllIIllllIIllllllIll = Minecraft.fontRendererObj.getColorCode(llllllllllIllllIIllllIIllllllIlI.charAt(1));
            }
            if (llllllllllIllllIIllllIIllllllIll >= 0) {
                final float llllllllllIllllIIllllIIllllllIIl = (llllllllllIllllIIllllIIllllllIll >> 16 & 0xFF) / 255.0f;
                final float llllllllllIllllIIllllIIllllllIII = (llllllllllIllllIIllllIIllllllIll >> 8 & 0xFF) / 255.0f;
                final float llllllllllIllllIIllllIIlllllIlll = (llllllllllIllllIIllllIIllllllIll & 0xFF) / 255.0f;
                Gui.drawRect(1.0, 1.0, 15.0, 15.0, MathHelper.rgb(llllllllllIllllIIllllIIllllllIIl * llllllllllIllllIIllllIIlllllllIl, llllllllllIllllIIllllIIllllllIII * llllllllllIllllIIllllIIlllllllIl, llllllllllIllllIIllllIIlllllIlll * llllllllllIllllIIllllIIlllllllIl) | llllllllllIllllIIllllIIlllllllII << 24);
            }
            Minecraft.getMinecraft().getTextureManager().bindTexture(this.location);
            GlStateManager.color(llllllllllIllllIIllllIIlllllllIl, llllllllllIllllIIllllIIlllllllIl, llllllllllIllllIIllllIIlllllllIl, llllllllllIllllIIllllIIlllllllII / 255.0f);
            Gui.drawScaledCustomSizeModalRect(2, 2, 8.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
            Gui.drawScaledCustomSizeModalRect(2, 2, 40.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
        }
        
        @Override
        public void selectItem(final SpectatorMenu llllllllllIllllIIllllIlIIIIIllII) {
            llllllllllIllllIIllllIlIIIIIllII.selectCategory(new TeleportToPlayer(this.players));
        }
        
        public TeamSelectionObject(final ScorePlayerTeam llllllllllIllllIIllllIlIIIIllIIl) {
            this.team = llllllllllIllllIIllllIlIIIIllIIl;
            this.players = (List<NetworkPlayerInfo>)Lists.newArrayList();
            for (final String llllllllllIllllIIllllIlIIIIllIII : llllllllllIllllIIllllIlIIIIllIIl.getMembershipCollection()) {
                final NetworkPlayerInfo llllllllllIllllIIllllIlIIIIlIlll = Minecraft.getMinecraft().getConnection().getPlayerInfo(llllllllllIllllIIllllIlIIIIllIII);
                if (llllllllllIllllIIllllIlIIIIlIlll != null) {
                    this.players.add(llllllllllIllllIIllllIlIIIIlIlll);
                }
            }
            if (this.players.isEmpty()) {
                this.location = DefaultPlayerSkin.getDefaultSkinLegacy();
            }
            else {
                final String llllllllllIllllIIllllIlIIIIlIllI = this.players.get(new Random().nextInt(this.players.size())).getGameProfile().getName();
                this.location = AbstractClientPlayer.getLocationSkin(llllllllllIllllIIllllIlIIIIlIllI);
                AbstractClientPlayer.getDownloadImageSkin(this.location, llllllllllIllllIIllllIlIIIIlIllI);
            }
        }
        
        @Override
        public boolean isEnabled() {
            return !this.players.isEmpty();
        }
    }
}
