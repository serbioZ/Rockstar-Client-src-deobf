// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import java.util.Iterator;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockTorch;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3i;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

public class WorldGenEndPodium extends WorldGenerator
{
    public static final /* synthetic */ BlockPos END_PODIUM_LOCATION;
    private final /* synthetic */ boolean activePortal;
    
    static {
        END_PODIUM_LOCATION = BlockPos.ORIGIN;
        END_PODIUM_CHUNK_POS = new BlockPos(WorldGenEndPodium.END_PODIUM_LOCATION.getX() - 4 & 0xFFFFFFF0, 0, WorldGenEndPodium.END_PODIUM_LOCATION.getZ() - 4 & 0xFFFFFFF0);
    }
    
    @Override
    public boolean generate(final World lllllllllllIlIlIIllIIlIIIlllllIl, final Random lllllllllllIlIlIIllIIlIIIlllllII, final BlockPos lllllllllllIlIlIIllIIlIIIllllIll) {
        for (final BlockPos.MutableBlockPos lllllllllllIlIlIIllIIlIIIllllIlI : BlockPos.getAllInBoxMutable(new BlockPos(lllllllllllIlIlIIllIIlIIIllllIll.getX() - 4, lllllllllllIlIlIIllIIlIIIllllIll.getY() - 1, lllllllllllIlIlIIllIIlIIIllllIll.getZ() - 4), new BlockPos(lllllllllllIlIlIIllIIlIIIllllIll.getX() + 4, lllllllllllIlIlIIllIIlIIIllllIll.getY() + 32, lllllllllllIlIlIIllIIlIIIllllIll.getZ() + 4))) {
            final double lllllllllllIlIlIIllIIlIIIllllIIl = lllllllllllIlIlIIllIIlIIIllllIlI.getDistance(lllllllllllIlIlIIllIIlIIIllllIll.getX(), lllllllllllIlIlIIllIIlIIIllllIlI.getY(), lllllllllllIlIlIIllIIlIIIllllIll.getZ());
            if (lllllllllllIlIlIIllIIlIIIllllIIl <= 3.5) {
                if (lllllllllllIlIlIIllIIlIIIllllIlI.getY() < lllllllllllIlIlIIllIIlIIIllllIll.getY()) {
                    if (lllllllllllIlIlIIllIIlIIIllllIIl <= 2.5) {
                        this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, lllllllllllIlIlIIllIIlIIIllllIlI, Blocks.BEDROCK.getDefaultState());
                    }
                    else {
                        if (lllllllllllIlIlIIllIIlIIIllllIlI.getY() >= lllllllllllIlIlIIllIIlIIIllllIll.getY()) {
                            continue;
                        }
                        this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, lllllllllllIlIlIIllIIlIIIllllIlI, Blocks.END_STONE.getDefaultState());
                    }
                }
                else if (lllllllllllIlIlIIllIIlIIIllllIlI.getY() > lllllllllllIlIlIIllIIlIIIllllIll.getY()) {
                    this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, lllllllllllIlIlIIllIIlIIIllllIlI, Blocks.AIR.getDefaultState());
                }
                else if (lllllllllllIlIlIIllIIlIIIllllIIl > 2.5) {
                    this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, lllllllllllIlIlIIllIIlIIIllllIlI, Blocks.BEDROCK.getDefaultState());
                }
                else if (this.activePortal) {
                    this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, new BlockPos(lllllllllllIlIlIIllIIlIIIllllIlI), Blocks.END_PORTAL.getDefaultState());
                }
                else {
                    this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, new BlockPos(lllllllllllIlIlIIllIIlIIIllllIlI), Blocks.AIR.getDefaultState());
                }
            }
        }
        for (int lllllllllllIlIlIIllIIlIIIllllIII = 0; lllllllllllIlIlIIllIIlIIIllllIII < 4; ++lllllllllllIlIlIIllIIlIIIllllIII) {
            this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, lllllllllllIlIlIIllIIlIIIllllIll.up(lllllllllllIlIlIIllIIlIIIllllIII), Blocks.BEDROCK.getDefaultState());
        }
        final BlockPos lllllllllllIlIlIIllIIlIIIlllIlll = lllllllllllIlIlIIllIIlIIIllllIll.up(2);
        for (final EnumFacing lllllllllllIlIlIIllIIlIIIlllIllI : EnumFacing.Plane.HORIZONTAL) {
            this.setBlockAndNotifyAdequately(lllllllllllIlIlIIllIIlIIIlllllIl, lllllllllllIlIlIIllIIlIIIlllIlll.offset(lllllllllllIlIlIIllIIlIIIlllIllI), Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, lllllllllllIlIlIIllIIlIIIlllIllI));
        }
        return true;
    }
    
    public WorldGenEndPodium(final boolean lllllllllllIlIlIIllIIlIIlIIIIlll) {
        this.activePortal = lllllllllllIlIlIIllIIlIIlIIIIlll;
    }
}
