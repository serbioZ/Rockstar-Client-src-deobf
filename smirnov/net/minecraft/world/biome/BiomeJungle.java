// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenMelon;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.block.state.IBlockState;

public class BiomeJungle extends Biome
{
    private static final /* synthetic */ IBlockState JUNGLE_LEAF;
    private final /* synthetic */ boolean isEdge;
    private static final /* synthetic */ IBlockState OAK_LEAF;
    private static final /* synthetic */ IBlockState JUNGLE_LOG;
    
    public BiomeJungle(final boolean llllllllllllIIlllIIIlllllIllIIll, final BiomeProperties llllllllllllIIlllIIIlllllIllIIlI) {
        super(llllllllllllIIlllIIIlllllIllIIlI);
        this.isEdge = llllllllllllIIlllIIIlllllIllIIll;
        if (llllllllllllIIlllIIIlllllIllIIll) {
            this.theBiomeDecorator.treesPerChunk = 2;
        }
        else {
            this.theBiomeDecorator.treesPerChunk = 50;
        }
        this.theBiomeDecorator.grassPerChunk = 25;
        this.theBiomeDecorator.flowersPerChunk = 4;
        if (!llllllllllllIIlllIIIlllllIllIIll) {
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        }
        this.spawnableCreatureList.add(new SpawnListEntry(EntityParrot.class, 40, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
    }
    
    @Override
    public void decorate(final World llllllllllllIIlllIIIlllllIIlIIII, final Random llllllllllllIIlllIIIlllllIIllIlI, final BlockPos llllllllllllIIlllIIIlllllIIIlllI) {
        super.decorate(llllllllllllIIlllIIIlllllIIlIIII, llllllllllllIIlllIIIlllllIIllIlI, llllllllllllIIlllIIIlllllIIIlllI);
        final int llllllllllllIIlllIIIlllllIIllIII = llllllllllllIIlllIIIlllllIIllIlI.nextInt(16) + 8;
        final int llllllllllllIIlllIIIlllllIIlIlll = llllllllllllIIlllIIIlllllIIllIlI.nextInt(16) + 8;
        int llllllllllllIIlllIIIlllllIIlIllI = llllllllllllIIlllIIIlllllIIllIlI.nextInt(llllllllllllIIlllIIIlllllIIlIIII.getHeight(llllllllllllIIlllIIIlllllIIIlllI.add(llllllllllllIIlllIIIlllllIIllIII, 0, llllllllllllIIlllIIIlllllIIlIlll)).getY() * 2);
        new WorldGenMelon().generate(llllllllllllIIlllIIIlllllIIlIIII, llllllllllllIIlllIIIlllllIIllIlI, llllllllllllIIlllIIIlllllIIIlllI.add(llllllllllllIIlllIIIlllllIIllIII, llllllllllllIIlllIIIlllllIIlIllI, llllllllllllIIlllIIIlllllIIlIlll));
        final WorldGenVines llllllllllllIIlllIIIlllllIIlIlIl = new WorldGenVines();
        for (int llllllllllllIIlllIIIlllllIIlIlII = 0; llllllllllllIIlllIIIlllllIIlIlII < 50; ++llllllllllllIIlllIIIlllllIIlIlII) {
            llllllllllllIIlllIIIlllllIIlIllI = llllllllllllIIlllIIIlllllIIllIlI.nextInt(16) + 8;
            final int llllllllllllIIlllIIIlllllIIlIIll = 128;
            final int llllllllllllIIlllIIIlllllIIlIIlI = llllllllllllIIlllIIIlllllIIllIlI.nextInt(16) + 8;
            llllllllllllIIlllIIIlllllIIlIlIl.generate(llllllllllllIIlllIIIlllllIIlIIII, llllllllllllIIlllIIIlllllIIllIlI, llllllllllllIIlllIIIlllllIIIlllI.add(llllllllllllIIlllIIIlllllIIlIllI, 128, llllllllllllIIlllIIIlllllIIlIIlI));
        }
    }
    
    @Override
    public WorldGenerator getRandomWorldGenForGrass(final Random llllllllllllIIlllIIIlllllIlIlIIl) {
        return (llllllllllllIIlllIIIlllllIlIlIIl.nextInt(4) == 0) ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    static {
        JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
        JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
        OAK_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllIIlllIIIlllllIlIllII) {
        if (llllllllllllIIlllIIIlllllIlIllII.nextInt(10) == 0) {
            return BiomeJungle.BIG_TREE_FEATURE;
        }
        if (llllllllllllIIlllIIIlllllIlIllII.nextInt(2) == 0) {
            return new WorldGenShrub(BiomeJungle.JUNGLE_LOG, BiomeJungle.OAK_LEAF);
        }
        return (!this.isEdge && llllllllllllIIlllIIIlllllIlIllII.nextInt(3) == 0) ? new WorldGenMegaJungle(false, 10, 20, BiomeJungle.JUNGLE_LOG, BiomeJungle.JUNGLE_LEAF) : new WorldGenTrees(false, 4 + llllllllllllIIlllIIIlllllIlIllII.nextInt(7), BiomeJungle.JUNGLE_LOG, BiomeJungle.JUNGLE_LEAF, true);
    }
}
