// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenEndGateway extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllIIlllllIlIlIIIlIIIIl, final Random llllllllllllIIlllllIlIlIIIlIlIIl, final BlockPos llllllllllllIIlllllIlIlIIIlIlIII) {
        for (final BlockPos.MutableBlockPos llllllllllllIIlllllIlIlIIIlIIlll : BlockPos.getAllInBoxMutable(llllllllllllIIlllllIlIlIIIlIlIII.add(-1, -2, -1), llllllllllllIIlllllIlIlIIIlIlIII.add(1, 2, 1))) {
            final boolean llllllllllllIIlllllIlIlIIIlIIllI = llllllllllllIIlllllIlIlIIIlIIlll.getX() == llllllllllllIIlllllIlIlIIIlIlIII.getX();
            final boolean llllllllllllIIlllllIlIlIIIlIIlIl = llllllllllllIIlllllIlIlIIIlIIlll.getY() == llllllllllllIIlllllIlIlIIIlIlIII.getY();
            final boolean llllllllllllIIlllllIlIlIIIlIIlII = llllllllllllIIlllllIlIlIIIlIIlll.getZ() == llllllllllllIIlllllIlIlIIIlIlIII.getZ();
            final boolean llllllllllllIIlllllIlIlIIIlIIIll = Math.abs(llllllllllllIIlllllIlIlIIIlIIlll.getY() - llllllllllllIIlllllIlIlIIIlIlIII.getY()) == 2;
            if (llllllllllllIIlllllIlIlIIIlIIllI && llllllllllllIIlllllIlIlIIIlIIlIl && llllllllllllIIlllllIlIlIIIlIIlII) {
                this.setBlockAndNotifyAdequately(llllllllllllIIlllllIlIlIIIlIIIIl, new BlockPos(llllllllllllIIlllllIlIlIIIlIIlll), Blocks.END_GATEWAY.getDefaultState());
            }
            else if (llllllllllllIIlllllIlIlIIIlIIlIl) {
                this.setBlockAndNotifyAdequately(llllllllllllIIlllllIlIlIIIlIIIIl, llllllllllllIIlllllIlIlIIIlIIlll, Blocks.AIR.getDefaultState());
            }
            else if (llllllllllllIIlllllIlIlIIIlIIIll && llllllllllllIIlllllIlIlIIIlIIllI && llllllllllllIIlllllIlIlIIIlIIlII) {
                this.setBlockAndNotifyAdequately(llllllllllllIIlllllIlIlIIIlIIIIl, llllllllllllIIlllllIlIlIIIlIIlll, Blocks.BEDROCK.getDefaultState());
            }
            else if ((llllllllllllIIlllllIlIlIIIlIIllI || llllllllllllIIlllllIlIlIIIlIIlII) && !llllllllllllIIlllllIlIlIIIlIIIll) {
                this.setBlockAndNotifyAdequately(llllllllllllIIlllllIlIlIIIlIIIIl, llllllllllllIIlllllIlIlIIIlIIlll, Blocks.BEDROCK.getDefaultState());
            }
            else {
                this.setBlockAndNotifyAdequately(llllllllllllIIlllllIlIlIIIlIIIIl, llllllllllllIIlllllIlIlIIIlIIlll, Blocks.AIR.getDefaultState());
            }
        }
        return true;
    }
}
