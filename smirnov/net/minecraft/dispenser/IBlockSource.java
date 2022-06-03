// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.dispenser;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;

public interface IBlockSource extends ILocatableSource
{
    double getY();
    
    double getX();
    
    double getZ();
    
    IBlockState getBlockState();
    
    BlockPos getBlockPos();
    
     <T extends TileEntity> T getBlockTileEntity();
}
