// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityNote extends TileEntity
{
    public /* synthetic */ byte note;
    public /* synthetic */ boolean previousRedstoneState;
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIlIIlllIIIllIIllIIlIl) {
        super.writeToNBT(lllllllllllIlIIlllIIIllIIllIIlIl);
        lllllllllllIlIIlllIIIllIIllIIlIl.setByte("note", this.note);
        lllllllllllIlIIlllIIIllIIllIIlIl.setBoolean("powered", this.previousRedstoneState);
        return lllllllllllIlIIlllIIIllIIllIIlIl;
    }
    
    public void triggerNote(final World lllllllllllIlIIlllIIIllIIlIIlIlI, final BlockPos lllllllllllIlIIlllIIIllIIlIIlIIl) {
        if (lllllllllllIlIIlllIIIllIIlIIlIlI.getBlockState(lllllllllllIlIIlllIIIllIIlIIlIIl.up()).getMaterial() == Material.AIR) {
            final IBlockState lllllllllllIlIIlllIIIllIIlIIllll = lllllllllllIlIIlllIIIllIIlIIlIlI.getBlockState(lllllllllllIlIIlllIIIllIIlIIlIIl.down());
            final Material lllllllllllIlIIlllIIIllIIlIIlllI = lllllllllllIlIIlllIIIllIIlIIllll.getMaterial();
            int lllllllllllIlIIlllIIIllIIlIIllIl = 0;
            if (lllllllllllIlIIlllIIIllIIlIIlllI == Material.ROCK) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 1;
            }
            if (lllllllllllIlIIlllIIIllIIlIIlllI == Material.SAND) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 2;
            }
            if (lllllllllllIlIIlllIIIllIIlIIlllI == Material.GLASS) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 3;
            }
            if (lllllllllllIlIIlllIIIllIIlIIlllI == Material.WOOD) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 4;
            }
            final Block lllllllllllIlIIlllIIIllIIlIIllII = lllllllllllIlIIlllIIIllIIlIIllll.getBlock();
            if (lllllllllllIlIIlllIIIllIIlIIllII == Blocks.CLAY) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 5;
            }
            if (lllllllllllIlIIlllIIIllIIlIIllII == Blocks.GOLD_BLOCK) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 6;
            }
            if (lllllllllllIlIIlllIIIllIIlIIllII == Blocks.WOOL) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 7;
            }
            if (lllllllllllIlIIlllIIIllIIlIIllII == Blocks.PACKED_ICE) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 8;
            }
            if (lllllllllllIlIIlllIIIllIIlIIllII == Blocks.BONE_BLOCK) {
                lllllllllllIlIIlllIIIllIIlIIllIl = 9;
            }
            lllllllllllIlIIlllIIIllIIlIIlIlI.addBlockEvent(lllllllllllIlIIlllIIIllIIlIIlIIl, Blocks.NOTEBLOCK, lllllllllllIlIIlllIIIllIIlIIllIl, this.note);
        }
    }
    
    public void changePitch() {
        this.note = (byte)((this.note + 1) % 25);
        this.markDirty();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIlIIlllIIIllIIlIlllll) {
        super.readFromNBT(lllllllllllIlIIlllIIIllIIlIlllll);
        this.note = lllllllllllIlIIlllIIIllIIlIlllll.getByte("note");
        this.note = (byte)MathHelper.clamp(this.note, 0, 24);
        this.previousRedstoneState = lllllllllllIlIIlllIIIllIIlIlllll.getBoolean("powered");
    }
}
