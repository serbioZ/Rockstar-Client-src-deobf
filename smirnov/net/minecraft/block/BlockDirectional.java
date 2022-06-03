// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;

public abstract class BlockDirectional extends Block
{
    static {
        FACING = PropertyDirection.create("facing");
    }
    
    protected BlockDirectional(final Material lllllllllllllIIIlllIlIIIllIlllIl) {
        super(lllllllllllllIIIlllIlIIIllIlllIl);
    }
}
