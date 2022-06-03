// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.DataFixer;
import javax.annotation.Nullable;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class TileEntityFlowerPot extends TileEntity
{
    private /* synthetic */ Item flowerPotItem;
    private /* synthetic */ int flowerPotData;
    
    public void func_190614_a(final ItemStack llllllllllllIllIlIlIIIlIIIIIlIlI) {
        this.flowerPotItem = llllllllllllIllIlIlIIIlIIIIIlIlI.getItem();
        this.flowerPotData = llllllllllllIllIlIlIIIlIIIIIlIlI.getMetadata();
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 5, this.getUpdateTag());
    }
    
    public static void registerFixesFlowerPot(final DataFixer llllllllllllIllIlIlIIIlIIIlIIlIl) {
    }
    
    @Nullable
    public Item getFlowerPotItem() {
        return this.flowerPotItem;
    }
    
    public TileEntityFlowerPot(final Item llllllllllllIllIlIlIIIlIIIlIlIlI, final int llllllllllllIllIlIlIIIlIIIlIIllI) {
        this.flowerPotItem = llllllllllllIllIlIlIIIlIIIlIlIlI;
        this.flowerPotData = llllllllllllIllIlIlIIIlIIIlIIllI;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIllIlIlIIIlIIIIlllIl) {
        super.writeToNBT(llllllllllllIllIlIlIIIlIIIIlllIl);
        final ResourceLocation llllllllllllIllIlIlIIIlIIIIlllll = Item.REGISTRY.getNameForObject(this.flowerPotItem);
        llllllllllllIllIlIlIIIlIIIIlllIl.setString("Item", (llllllllllllIllIlIlIIIlIIIIlllll == null) ? "" : llllllllllllIllIlIlIIIlIIIIlllll.toString());
        llllllllllllIllIlIlIIIlIIIIlllIl.setInteger("Data", this.flowerPotData);
        return llllllllllllIllIlIlIIIlIIIIlllIl;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIllIlIlIIIlIIIIllIII) {
        super.readFromNBT(llllllllllllIllIlIlIIIlIIIIllIII);
        if (llllllllllllIllIlIlIIIlIIIIllIII.hasKey("Item", 8)) {
            this.flowerPotItem = Item.getByNameOrId(llllllllllllIllIlIlIIIlIIIIllIII.getString("Item"));
        }
        else {
            this.flowerPotItem = Item.getItemById(llllllllllllIllIlIlIIIlIIIIllIII.getInteger("Item"));
        }
        this.flowerPotData = llllllllllllIllIlIlIIIlIIIIllIII.getInteger("Data");
    }
    
    public int getFlowerPotData() {
        return this.flowerPotData;
    }
    
    public TileEntityFlowerPot() {
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public ItemStack getFlowerItemStack() {
        return (this.flowerPotItem == null) ? ItemStack.field_190927_a : new ItemStack(this.flowerPotItem, 1, this.flowerPotData);
    }
}
