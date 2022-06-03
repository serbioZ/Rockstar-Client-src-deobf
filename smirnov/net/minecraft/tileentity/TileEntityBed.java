// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.block.BlockBed;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.EnumDyeColor;

public class TileEntityBed extends TileEntity
{
    private /* synthetic */ EnumDyeColor field_193053_a;
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIlIIIIlIIIllIlIII) {
        super.writeToNBT(llllllllllllllIIlIIIIlIIIllIlIII);
        llllllllllllllIIlIIIIlIIIllIlIII.setInteger("color", this.field_193053_a.getMetadata());
        return llllllllllllllIIlIIIIlIIIllIlIII;
    }
    
    public ItemStack func_193049_f() {
        return new ItemStack(Items.BED, 1, this.field_193053_a.getMetadata());
    }
    
    public void func_193052_a(final EnumDyeColor llllllllllllllIIlIIIIlIIIlIllIll) {
        this.field_193053_a = llllllllllllllIIlIIIIlIIIlIllIll;
        this.markDirty();
    }
    
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 11, this.getUpdateTag());
    }
    
    public boolean func_193050_e() {
        return BlockBed.func_193385_b(this.getBlockMetadata());
    }
    
    public EnumDyeColor func_193048_a() {
        return this.field_193053_a;
    }
    
    public void func_193051_a(final ItemStack llllllllllllllIIlIIIIlIIIlllIllI) {
        this.func_193052_a(EnumDyeColor.byMetadata(llllllllllllllIIlIIIIlIIIlllIllI.getMetadata()));
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIlIIIIlIIIlllIIII) {
        super.readFromNBT(llllllllllllllIIlIIIIlIIIlllIIII);
        if (llllllllllllllIIlIIIIlIIIlllIIII.hasKey("color")) {
            this.field_193053_a = EnumDyeColor.byMetadata(llllllllllllllIIlIIIIlIIIlllIIII.getInteger("color"));
        }
    }
    
    public TileEntityBed() {
        this.field_193053_a = EnumDyeColor.RED;
    }
}
