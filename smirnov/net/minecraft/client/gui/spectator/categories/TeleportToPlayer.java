// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.spectator.categories;

import com.google.common.collect.ComparisonChain;
import java.util.Comparator;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.client.gui.spectator.PlayerMenuObject;
import net.minecraft.world.GameType;
import com.google.common.collect.Lists;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.ITextComponent;
import java.util.Collection;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.spectator.SpectatorMenu;
import net.minecraft.client.network.NetworkPlayerInfo;
import com.google.common.collect.Ordering;
import java.util.List;
import net.minecraft.client.gui.spectator.ISpectatorMenuView;
import net.minecraft.client.gui.spectator.ISpectatorMenuObject;

public class TeleportToPlayer implements ISpectatorMenuObject, ISpectatorMenuView
{
    private final /* synthetic */ List<ISpectatorMenuObject> items;
    private static final /* synthetic */ Ordering<NetworkPlayerInfo> PROFILE_ORDER;
    
    @Override
    public void selectItem(final SpectatorMenu llllllllllllIlllIIIIlIIIlIIIIllI) {
        llllllllllllIlllIIIIlIIIlIIIIllI.selectCategory(this);
    }
    
    public TeleportToPlayer() {
        this(TeleportToPlayer.PROFILE_ORDER.sortedCopy((Iterable)Minecraft.getMinecraft().getConnection().getPlayerInfoMap()));
    }
    
    @Override
    public List<ISpectatorMenuObject> getItems() {
        return this.items;
    }
    
    @Override
    public ITextComponent getPrompt() {
        return new TextComponentTranslation("spectatorMenu.teleport.prompt", new Object[0]);
    }
    
    @Override
    public boolean isEnabled() {
        return !this.items.isEmpty();
    }
    
    public TeleportToPlayer(final Collection<NetworkPlayerInfo> llllllllllllIlllIIIIlIIIlIIlIlIl) {
        this.items = (List<ISpectatorMenuObject>)Lists.newArrayList();
        for (final NetworkPlayerInfo llllllllllllIlllIIIIlIIIlIIlIlII : TeleportToPlayer.PROFILE_ORDER.sortedCopy((Iterable)llllllllllllIlllIIIIlIIIlIIlIlIl)) {
            if (llllllllllllIlllIIIIlIIIlIIlIlII.getGameType() != GameType.SPECTATOR) {
                this.items.add(new PlayerMenuObject(llllllllllllIlllIIIIlIIIlIIlIlII.getGameProfile()));
            }
        }
    }
    
    @Override
    public void renderIcon(final float llllllllllllIlllIIIIlIIIlIIIIIll, final int llllllllllllIlllIIIIlIIIlIIIIIlI) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
        Gui.drawModalRectWithCustomSizedTexture(0.0f, 0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 256.0f, 256.0f);
    }
    
    @Override
    public ITextComponent getSpectatorName() {
        return new TextComponentTranslation("spectatorMenu.teleport", new Object[0]);
    }
    
    static {
        PROFILE_ORDER = Ordering.from((Comparator)new Comparator<NetworkPlayerInfo>() {
            @Override
            public int compare(final NetworkPlayerInfo lllllllllllllIllIIllIlIIIIIIIllI, final NetworkPlayerInfo lllllllllllllIllIIllIlIIIIIIIlll) {
                return ComparisonChain.start().compare((Comparable)lllllllllllllIllIIllIlIIIIIIIllI.getGameProfile().getId(), (Comparable)lllllllllllllIllIIllIlIIIIIIIlll.getGameProfile().getId()).result();
            }
        });
    }
}
