// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import net.minecraft.block.material.Material;

public class BlockEmptyDrops extends Block
{
    public BlockEmptyDrops(final Material lllllllllllIIIIIlIIIlllIllIIIlIl) {
        super(lllllllllllIIIIIlIIIlllIllIIIlIl);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIIIIIlIIIlllIllIIIIll) {
        return 0;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIIIIlIIIlllIllIIIIIl, final Random lllllllllllIIIIIlIIIlllIllIIIIII, final int lllllllllllIIIIIlIIIlllIlIllllll) {
        return Items.field_190931_a;
    }
}
