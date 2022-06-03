// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class SlotFurnaceOutput extends Slot
{
    private final /* synthetic */ EntityPlayer thePlayer;
    private /* synthetic */ int removeCount;
    
    public SlotFurnaceOutput(final EntityPlayer llllllllllIlllIIIlIIIllIlllIlIll, final IInventory llllllllllIlllIIIlIIIllIlllIIlII, final int llllllllllIlllIIIlIIIllIlllIIIll, final int llllllllllIlllIIIlIIIllIlllIlIII, final int llllllllllIlllIIIlIIIllIlllIIIIl) {
        super(llllllllllIlllIIIlIIIllIlllIIlII, llllllllllIlllIIIlIIIllIlllIIIll, llllllllllIlllIIIlIIIllIlllIlIII, llllllllllIlllIIIlIIIllIlllIIIIl);
        this.thePlayer = llllllllllIlllIIIlIIIllIlllIlIll;
    }
    
    @Override
    public ItemStack func_190901_a(final EntityPlayer llllllllllIlllIIIlIIIllIllIlIIIl, final ItemStack llllllllllIlllIIIlIIIllIllIlIIll) {
        this.onCrafting(llllllllllIlllIIIlIIIllIllIlIIll);
        super.func_190901_a(llllllllllIlllIIIlIIIllIllIlIIIl, llllllllllIlllIIIlIIIllIllIlIIll);
        return llllllllllIlllIIIlIIIllIllIlIIll;
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllIlllIIIlIIIllIlIlllIlI) {
        llllllllllIlllIIIlIIIllIlIlllIlI.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);
        if (!this.thePlayer.world.isRemote) {
            int llllllllllIlllIIIlIIIllIlIllllll = this.removeCount;
            final float llllllllllIlllIIIlIIIllIlIlllllI = FurnaceRecipes.instance().getSmeltingExperience(llllllllllIlllIIIlIIIllIlIlllIlI);
            if (llllllllllIlllIIIlIIIllIlIlllllI == 0.0f) {
                llllllllllIlllIIIlIIIllIlIllllll = 0;
            }
            else if (llllllllllIlllIIIlIIIllIlIlllllI < 1.0f) {
                int llllllllllIlllIIIlIIIllIlIllllIl = MathHelper.floor(llllllllllIlllIIIlIIIllIlIllllll * llllllllllIlllIIIlIIIllIlIlllllI);
                if (llllllllllIlllIIIlIIIllIlIllllIl < MathHelper.ceil(llllllllllIlllIIIlIIIllIlIllllll * llllllllllIlllIIIlIIIllIlIlllllI) && Math.random() < llllllllllIlllIIIlIIIllIlIllllll * llllllllllIlllIIIlIIIllIlIlllllI - llllllllllIlllIIIlIIIllIlIllllIl) {
                    ++llllllllllIlllIIIlIIIllIlIllllIl;
                }
                llllllllllIlllIIIlIIIllIlIllllll = llllllllllIlllIIIlIIIllIlIllllIl;
            }
            while (llllllllllIlllIIIlIIIllIlIllllll > 0) {
                final int llllllllllIlllIIIlIIIllIlIllllII = EntityXPOrb.getXPSplit(llllllllllIlllIIIlIIIllIlIllllll);
                llllllllllIlllIIIlIIIllIlIllllll -= llllllllllIlllIIIlIIIllIlIllllII;
                this.thePlayer.world.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.world, this.thePlayer.posX, this.thePlayer.posY + 0.5, this.thePlayer.posZ + 0.5, llllllllllIlllIIIlIIIllIlIllllII));
            }
        }
        this.removeCount = 0;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllIlllIIIlIIIllIllIllIIl) {
        if (this.getHasStack()) {
            this.removeCount += Math.min(llllllllllIlllIIIlIIIllIllIllIIl, this.getStack().func_190916_E());
        }
        return super.decrStackSize(llllllllllIlllIIIlIIIllIllIllIIl);
    }
    
    @Override
    public boolean isItemValid(final ItemStack llllllllllIlllIIIlIIIllIllIlllll) {
        return false;
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllIlllIIIlIIIllIllIIlIII, final int llllllllllIlllIIIlIIIllIllIIIlll) {
        this.removeCount += llllllllllIlllIIIlIIIllIllIIIlll;
        this.onCrafting(llllllllllIlllIIIlIIIllIllIIlIII);
    }
}
