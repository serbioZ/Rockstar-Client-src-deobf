// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.world.IInteractionObject;
import net.minecraft.util.ITickable;

public class TileEntityEnchantmentTable extends TileEntity implements ITickable, IInteractionObject
{
    public /* synthetic */ float bookSpreadPrev;
    public /* synthetic */ float pageFlipPrev;
    public /* synthetic */ float bookRotation;
    public /* synthetic */ float flipT;
    public /* synthetic */ float bookRotationPrev;
    public /* synthetic */ float pageFlip;
    public /* synthetic */ int tickCount;
    public /* synthetic */ float bookSpread;
    public /* synthetic */ float tRot;
    private static final /* synthetic */ Random rand;
    public /* synthetic */ float flipA;
    private /* synthetic */ String customName;
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllIllllllllIIIllIllIllll) {
        super.writeToNBT(llllllllllIllllllllIIIllIllIllll);
        if (this.hasCustomName()) {
            llllllllllIllllllllIIIllIllIllll.setString("CustomName", this.customName);
        }
        return llllllllllIllllllllIIIllIllIllll;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllIllllllllIIIllIlIIIIII, final EntityPlayer llllllllllIllllllllIIIllIIllllll) {
        return new ContainerEnchantment(llllllllllIllllllllIIIllIlIIIIII, this.world, this.pos);
    }
    
    static {
        rand = new Random();
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.enchant";
    }
    
    public void setCustomName(final String llllllllllIllllllllIIIllIlIIlIIl) {
        this.customName = llllllllllIllllllllIIIllIlIIlIIl;
    }
    
    @Override
    public void update() {
        this.bookSpreadPrev = this.bookSpread;
        this.bookRotationPrev = this.bookRotation;
        final EntityPlayer llllllllllIllllllllIIIllIlIlllll = this.world.getClosestPlayer(this.pos.getX() + 0.5f, this.pos.getY() + 0.5f, this.pos.getZ() + 0.5f, 3.0, false);
        if (llllllllllIllllllllIIIllIlIlllll != null) {
            final double llllllllllIllllllllIIIllIlIllllI = llllllllllIllllllllIIIllIlIlllll.posX - (this.pos.getX() + 0.5f);
            final double llllllllllIllllllllIIIllIlIlllIl = llllllllllIllllllllIIIllIlIlllll.posZ - (this.pos.getZ() + 0.5f);
            this.tRot = (float)MathHelper.atan2(llllllllllIllllllllIIIllIlIlllIl, llllllllllIllllllllIIIllIlIllllI);
            this.bookSpread += 0.1f;
            if (this.bookSpread < 0.5f || TileEntityEnchantmentTable.rand.nextInt(40) == 0) {
                final float llllllllllIllllllllIIIllIlIlllII = this.flipT;
                do {
                    this.flipT += TileEntityEnchantmentTable.rand.nextInt(4) - TileEntityEnchantmentTable.rand.nextInt(4);
                } while (llllllllllIllllllllIIIllIlIlllII == this.flipT);
            }
        }
        else {
            this.tRot += 0.02f;
            this.bookSpread -= 0.1f;
        }
        while (this.bookRotation >= 3.1415927f) {
            this.bookRotation -= 6.2831855f;
        }
        while (this.bookRotation < -3.1415927f) {
            this.bookRotation += 6.2831855f;
        }
        while (this.tRot >= 3.1415927f) {
            this.tRot -= 6.2831855f;
        }
        while (this.tRot < -3.1415927f) {
            this.tRot += 6.2831855f;
        }
        float llllllllllIllllllllIIIllIlIllIll;
        for (llllllllllIllllllllIIIllIlIllIll = this.tRot - this.bookRotation; llllllllllIllllllllIIIllIlIllIll >= 3.1415927f; llllllllllIllllllllIIIllIlIllIll -= 6.2831855f) {}
        while (llllllllllIllllllllIIIllIlIllIll < -3.1415927f) {
            llllllllllIllllllllIIIllIlIllIll += 6.2831855f;
        }
        this.bookRotation += llllllllllIllllllllIIIllIlIllIll * 0.4f;
        this.bookSpread = MathHelper.clamp(this.bookSpread, 0.0f, 1.0f);
        ++this.tickCount;
        this.pageFlipPrev = this.pageFlip;
        float llllllllllIllllllllIIIllIlIllIlI = (this.flipT - this.pageFlip) * 0.4f;
        final float llllllllllIllllllllIIIllIlIllIIl = 0.2f;
        llllllllllIllllllllIIIllIlIllIlI = MathHelper.clamp(llllllllllIllllllllIIIllIlIllIlI, -0.2f, 0.2f);
        this.flipA += (llllllllllIllllllllIIIllIlIllIlI - this.flipA) * 0.9f;
        this.pageFlip += this.flipA;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllIllllllllIIIllIllIlIIl) {
        super.readFromNBT(llllllllllIllllllllIIIllIllIlIIl);
        if (llllllllllIllllllllIIIllIllIlIIl.hasKey("CustomName", 8)) {
            this.customName = llllllllllIllllllllIIIllIllIlIIl.getString("CustomName");
        }
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:enchanting_table";
    }
}
