// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.player.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class LocalBlockIntercommunication implements IInteractionObject
{
    private final /* synthetic */ String guiID;
    private final /* synthetic */ ITextComponent displayName;
    
    @Override
    public String getGuiID() {
        return this.guiID;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.displayName;
    }
    
    @Override
    public boolean hasCustomName() {
        return true;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllIIIIIlllIIIllIllIlllI, final EntityPlayer lllllllllllIIIIIlllIIIllIllIllIl) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String getName() {
        return this.displayName.getUnformattedText();
    }
    
    public LocalBlockIntercommunication(final String lllllllllllIIIIIlllIIIllIlllIIIl, final ITextComponent lllllllllllIIIIIlllIIIllIlllIIll) {
        this.guiID = lllllllllllIIIIIlllIIIllIlllIIIl;
        this.displayName = lllllllllllIIIIIlllIIIllIlllIIll;
    }
}
