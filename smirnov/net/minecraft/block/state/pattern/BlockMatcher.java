// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state.pattern;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;

public class BlockMatcher implements Predicate<IBlockState>
{
    private final /* synthetic */ Block block;
    
    private BlockMatcher(final Block lllllllllllIIIIllIlIlllIlIlIIlIl) {
        this.block = lllllllllllIIIIllIlIlllIlIlIIlIl;
    }
    
    public static BlockMatcher forBlock(final Block lllllllllllIIIIllIlIlllIlIlIIIIl) {
        return new BlockMatcher(lllllllllllIIIIllIlIlllIlIlIIIIl);
    }
    
    public boolean apply(@Nullable final IBlockState lllllllllllIIIIllIlIlllIlIIllIlI) {
        return lllllllllllIIIIllIlIlllIlIIllIlI != null && lllllllllllIIIIllIlIlllIlIIllIlI.getBlock() == this.block;
    }
}
