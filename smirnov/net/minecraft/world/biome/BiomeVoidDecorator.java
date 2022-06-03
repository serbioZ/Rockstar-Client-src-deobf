// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class BiomeVoidDecorator extends BiomeDecorator
{
    @Override
    public void decorate(final World llllllllllllIIIlIllIIIllllIIIIll, final Random llllllllllllIIIlIllIIIllllIIIIlI, final Biome llllllllllllIIIlIllIIIllllIIIIIl, final BlockPos llllllllllllIIIlIllIIIllllIIIIII) {
        final BlockPos llllllllllllIIIlIllIIIlllIllllll = llllllllllllIIIlIllIIIllllIIIIll.getSpawnPoint();
        final int llllllllllllIIIlIllIIIlllIlllllI = 16;
        final double llllllllllllIIIlIllIIIlllIllllIl = llllllllllllIIIlIllIIIlllIllllll.distanceSq(llllllllllllIIIlIllIIIllllIIIIII.add(8, llllllllllllIIIlIllIIIlllIllllll.getY(), 8));
        if (llllllllllllIIIlIllIIIlllIllllIl <= 1024.0) {
            final BlockPos llllllllllllIIIlIllIIIlllIllllII = new BlockPos(llllllllllllIIIlIllIIIlllIllllll.getX() - 16, llllllllllllIIIlIllIIIlllIllllll.getY() - 1, llllllllllllIIIlIllIIIlllIllllll.getZ() - 16);
            final BlockPos llllllllllllIIIlIllIIIlllIlllIll = new BlockPos(llllllllllllIIIlIllIIIlllIllllll.getX() + 16, llllllllllllIIIlIllIIIlllIllllll.getY() - 1, llllllllllllIIIlIllIIIlllIllllll.getZ() + 16);
            final BlockPos.MutableBlockPos llllllllllllIIIlIllIIIlllIlllIlI = new BlockPos.MutableBlockPos(llllllllllllIIIlIllIIIlllIllllII);
            for (int llllllllllllIIIlIllIIIlllIlllIIl = llllllllllllIIIlIllIIIllllIIIIII.getZ(); llllllllllllIIIlIllIIIlllIlllIIl < llllllllllllIIIlIllIIIllllIIIIII.getZ() + 16; ++llllllllllllIIIlIllIIIlllIlllIIl) {
                for (int llllllllllllIIIlIllIIIlllIlllIII = llllllllllllIIIlIllIIIllllIIIIII.getX(); llllllllllllIIIlIllIIIlllIlllIII < llllllllllllIIIlIllIIIllllIIIIII.getX() + 16; ++llllllllllllIIIlIllIIIlllIlllIII) {
                    if (llllllllllllIIIlIllIIIlllIlllIIl >= llllllllllllIIIlIllIIIlllIllllII.getZ() && llllllllllllIIIlIllIIIlllIlllIIl <= llllllllllllIIIlIllIIIlllIlllIll.getZ() && llllllllllllIIIlIllIIIlllIlllIII >= llllllllllllIIIlIllIIIlllIllllII.getX() && llllllllllllIIIlIllIIIlllIlllIII <= llllllllllllIIIlIllIIIlllIlllIll.getX()) {
                        llllllllllllIIIlIllIIIlllIlllIlI.setPos(llllllllllllIIIlIllIIIlllIlllIII, llllllllllllIIIlIllIIIlllIlllIlI.getY(), llllllllllllIIIlIllIIIlllIlllIIl);
                        if (llllllllllllIIIlIllIIIlllIllllll.getX() == llllllllllllIIIlIllIIIlllIlllIII && llllllllllllIIIlIllIIIlllIllllll.getZ() == llllllllllllIIIlIllIIIlllIlllIIl) {
                            llllllllllllIIIlIllIIIllllIIIIll.setBlockState(llllllllllllIIIlIllIIIlllIlllIlI, Blocks.COBBLESTONE.getDefaultState(), 2);
                        }
                        else {
                            llllllllllllIIIlIllIIIllllIIIIll.setBlockState(llllllllllllIIIlIllIIIlllIlllIlI, Blocks.STONE.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
    }
}
