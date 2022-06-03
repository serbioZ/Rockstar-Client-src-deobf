// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;

public class BiomeForestMutated extends BiomeForest
{
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIlllIIIlIlIIIIlll) {
        return llllllllllllllIIlllIIIlIlIIIIlll.nextBoolean() ? BiomeForest.SUPER_BIRCH_TREE : BiomeForest.BIRCH_TREE;
    }
    
    public BiomeForestMutated(final BiomeProperties llllllllllllllIIlllIIIlIlIIIllII) {
        super(Type.BIRCH, llllllllllllllIIlllIIIlIlIIIllII);
    }
}
