// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure.template;

import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;

public class BlockRotationProcessor implements ITemplateProcessor
{
    private final /* synthetic */ Random random;
    private final /* synthetic */ float chance;
    
    @Nullable
    @Override
    public Template.BlockInfo processBlock(final World llllllllllllIIIIIIllIlIlIlIlllll, final BlockPos llllllllllllIIIIIIllIlIlIlIllllI, final Template.BlockInfo llllllllllllIIIIIIllIlIlIlIllIll) {
        return (this.chance < 1.0f && this.random.nextFloat() > this.chance) ? null : llllllllllllIIIIIIllIlIlIlIllIll;
    }
    
    public BlockRotationProcessor(final BlockPos llllllllllllIIIIIIllIlIlIllIIlll, final PlacementSettings llllllllllllIIIIIIllIlIlIllIIllI) {
        this.chance = llllllllllllIIIIIIllIlIlIllIIllI.getIntegrity();
        this.random = llllllllllllIIIIIIllIlIlIllIIllI.getRandom(llllllllllllIIIIIIllIlIlIllIIlll);
    }
}
