// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state.pattern;

import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;

public class BlockMaterialMatcher implements Predicate<IBlockState>
{
    private final /* synthetic */ Material material;
    
    public boolean apply(@Nullable final IBlockState lIllIIllIIIIIII) {
        return lIllIIllIIIIIII != null && lIllIIllIIIIIII.getMaterial() == this.material;
    }
    
    public static BlockMaterialMatcher forMaterial(final Material lIllIIllIIIIllI) {
        return new BlockMaterialMatcher(lIllIIllIIIIllI);
    }
    
    private BlockMaterialMatcher(final Material lIllIIllIIIlIIl) {
        this.material = lIllIIllIIIlIIl;
    }
}
