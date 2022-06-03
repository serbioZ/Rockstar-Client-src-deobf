// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.player.inventory;

import net.minecraft.world.LockCode;
import com.google.common.collect.Maps;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import java.util.Map;
import net.minecraft.world.ILockableContainer;
import net.minecraft.inventory.InventoryBasic;

public class ContainerLocalMenu extends InventoryBasic implements ILockableContainer
{
    private final /* synthetic */ Map<Integer, Integer> dataValues;
    private final /* synthetic */ String guiID;
    
    @Override
    public String getGuiID() {
        return this.guiID;
    }
    
    @Override
    public int getField(final int lllllllllllIlIIIllIlIIllIIIIlllI) {
        return this.dataValues.containsKey(lllllllllllIlIIIllIlIIllIIIIlllI) ? this.dataValues.get(lllllllllllIlIIIllIlIIllIIIIlllI) : 0;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllIlIIIllIlIIlIllllIlll, final EntityPlayer lllllllllllIlIIIllIlIIlIllllIllI) {
        throw new UnsupportedOperationException();
    }
    
    public ContainerLocalMenu(final String lllllllllllIlIIIllIlIIllIIIllIII, final ITextComponent lllllllllllIlIIIllIlIIllIIIlIIll, final int lllllllllllIlIIIllIlIIllIIIlIllI) {
        super(lllllllllllIlIIIllIlIIllIIIlIIll, lllllllllllIlIIIllIlIIllIIIlIllI);
        this.dataValues = (Map<Integer, Integer>)Maps.newHashMap();
        this.guiID = lllllllllllIlIIIllIlIIllIIIllIII;
    }
    
    @Override
    public void setField(final int lllllllllllIlIIIllIlIIllIIIIIlII, final int lllllllllllIlIIIllIlIIllIIIIIllI) {
        this.dataValues.put(lllllllllllIlIIIllIlIIllIIIIIlII, lllllllllllIlIIIllIlIIllIIIIIllI);
    }
    
    @Override
    public boolean isLocked() {
        return false;
    }
    
    @Override
    public int getFieldCount() {
        return this.dataValues.size();
    }
    
    @Override
    public LockCode getLockCode() {
        return LockCode.EMPTY_CODE;
    }
    
    @Override
    public void setLockCode(final LockCode lllllllllllIlIIIllIlIIlIllllllIl) {
    }
}
