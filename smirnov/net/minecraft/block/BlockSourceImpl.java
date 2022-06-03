// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.dispenser.IBlockSource;

public class BlockSourceImpl implements IBlockSource
{
    private final /* synthetic */ BlockPos pos;
    private final /* synthetic */ World worldObj;
    
    @Override
    public World getWorld() {
        return this.worldObj;
    }
    
    @Override
    public BlockPos getBlockPos() {
        return this.pos;
    }
    
    @Override
    public double getZ() {
        return this.pos.getZ() + 0.5;
    }
    
    @Override
    public IBlockState getBlockState() {
        return this.worldObj.getBlockState(this.pos);
    }
    
    public BlockSourceImpl(final World lllllllllllllIlIlllIlIllllIllIll, final BlockPos lllllllllllllIlIlllIlIllllIlllIl) {
        this.worldObj = lllllllllllllIlIlllIlIllllIllIll;
        this.pos = lllllllllllllIlIlllIlIllllIlllIl;
    }
    
    @Override
    public double getX() {
        return this.pos.getX() + 0.5;
    }
    
    @Override
    public <T extends TileEntity> T getBlockTileEntity() {
        return (T)this.worldObj.getTileEntity(this.pos);
    }
    
    @Override
    public double getY() {
        return this.pos.getY() + 0.5;
    }
}
