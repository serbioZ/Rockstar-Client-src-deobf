// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;

public class WorldGenFlowers extends WorldGenerator
{
    private /* synthetic */ IBlockState state;
    private /* synthetic */ BlockFlower flower;
    
    public WorldGenFlowers(final BlockFlower llllllllllIlllllIIIlIlllIllIlIll, final BlockFlower.EnumFlowerType llllllllllIlllllIIIlIlllIllIllIl) {
        this.setGeneratedBlock(llllllllllIlllllIIIlIlllIllIlIll, llllllllllIlllllIIIlIlllIllIllIl);
    }
    
    @Override
    public boolean generate(final World llllllllllIlllllIIIlIlllIlIlIIll, final Random llllllllllIlllllIIIlIlllIlIlIIlI, final BlockPos llllllllllIlllllIIIlIlllIlIlIlll) {
        for (int llllllllllIlllllIIIlIlllIlIlIllI = 0; llllllllllIlllllIIIlIlllIlIlIllI < 64; ++llllllllllIlllllIIIlIlllIlIlIllI) {
            final BlockPos llllllllllIlllllIIIlIlllIlIlIlIl = llllllllllIlllllIIIlIlllIlIlIlll.add(llllllllllIlllllIIIlIlllIlIlIIlI.nextInt(8) - llllllllllIlllllIIIlIlllIlIlIIlI.nextInt(8), llllllllllIlllllIIIlIlllIlIlIIlI.nextInt(4) - llllllllllIlllllIIIlIlllIlIlIIlI.nextInt(4), llllllllllIlllllIIIlIlllIlIlIIlI.nextInt(8) - llllllllllIlllllIIIlIlllIlIlIIlI.nextInt(8));
            if (llllllllllIlllllIIIlIlllIlIlIIll.isAirBlock(llllllllllIlllllIIIlIlllIlIlIlIl) && (!llllllllllIlllllIIIlIlllIlIlIIll.provider.getHasNoSky() || llllllllllIlllllIIIlIlllIlIlIlIl.getY() < 255) && this.flower.canBlockStay(llllllllllIlllllIIIlIlllIlIlIIll, llllllllllIlllllIIIlIlllIlIlIlIl, this.state)) {
                llllllllllIlllllIIIlIlllIlIlIIll.setBlockState(llllllllllIlllllIIIlIlllIlIlIlIl, this.state, 2);
            }
        }
        return true;
    }
    
    public void setGeneratedBlock(final BlockFlower llllllllllIlllllIIIlIlllIllIIIlI, final BlockFlower.EnumFlowerType llllllllllIlllllIIIlIlllIllIIlII) {
        this.flower = llllllllllIlllllIIIlIlllIllIIIlI;
        this.state = llllllllllIlllllIIIlIlllIllIIIlI.getDefaultState().withProperty(llllllllllIlllllIIIlIlllIllIIIlI.getTypeProperty(), llllllllllIlllllIIIlIlllIllIIlII);
    }
}
