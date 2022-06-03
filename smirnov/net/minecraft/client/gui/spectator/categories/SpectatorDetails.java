// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.spectator.categories;

import com.google.common.base.MoreObjects;
import net.minecraft.client.gui.spectator.SpectatorMenu;
import net.minecraft.client.gui.spectator.ISpectatorMenuView;
import net.minecraft.client.gui.spectator.ISpectatorMenuObject;
import java.util.List;

public class SpectatorDetails
{
    private final /* synthetic */ List<ISpectatorMenuObject> items;
    private final /* synthetic */ int selectedSlot;
    private final /* synthetic */ ISpectatorMenuView category;
    
    public ISpectatorMenuObject getObject(final int lllllllllllIlllIIIIllIllIlllIIll) {
        return (ISpectatorMenuObject)((lllllllllllIlllIIIIllIllIlllIIll >= 0 && lllllllllllIlllIIIIllIllIlllIIll < this.items.size()) ? MoreObjects.firstNonNull((Object)this.items.get(lllllllllllIlllIIIIllIllIlllIIll), (Object)SpectatorMenu.EMPTY_SLOT) : SpectatorMenu.EMPTY_SLOT);
    }
    
    public int getSelectedSlot() {
        return this.selectedSlot;
    }
    
    public SpectatorDetails(final ISpectatorMenuView lllllllllllIlllIIIIllIllIlllllll, final List<ISpectatorMenuObject> lllllllllllIlllIIIIllIllIllllIlI, final int lllllllllllIlllIIIIllIllIlllllIl) {
        this.category = lllllllllllIlllIIIIllIllIlllllll;
        this.items = lllllllllllIlllIIIIllIllIllllIlI;
        this.selectedSlot = lllllllllllIlllIIIIllIllIlllllIl;
    }
}
