// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class WorldGenerator
{
    private final /* synthetic */ boolean doBlockNotify;
    
    protected void setBlockAndNotifyAdequately(final World llllllllllIlllIllIIIIIIIlIIlIllI, final BlockPos llllllllllIlllIllIIIIIIIlIIlIlIl, final IBlockState llllllllllIlllIllIIIIIIIlIIlIIII) {
        if (this.doBlockNotify) {
            llllllllllIlllIllIIIIIIIlIIlIllI.setBlockState(llllllllllIlllIllIIIIIIIlIIlIlIl, llllllllllIlllIllIIIIIIIlIIlIIII, 3);
        }
        else {
            llllllllllIlllIllIIIIIIIlIIlIllI.setBlockState(llllllllllIlllIllIIIIIIIlIIlIlIl, llllllllllIlllIllIIIIIIIlIIlIIII, 2);
        }
    }
    
    public void setDecorationDefaults() {
    }
    
    public abstract boolean generate(final World p0, final Random p1, final BlockPos p2);
    
    public WorldGenerator(final boolean llllllllllIlllIllIIIIIIIlIIlllll) {
        this.doBlockNotify = llllllllllIlllIllIIIIIIIlIIlllll;
    }
    
    public WorldGenerator() {
        this(false);
    }
}
