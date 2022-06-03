// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyEnum;

public class BlockSapling extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> TYPE;
    protected static final /* synthetic */ AxisAlignedBB SAPLING_AABB;
    public static final /* synthetic */ PropertyInteger STAGE;
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(this.getUnlocalizedName()) + "." + BlockPlanks.EnumType.OAK.getUnlocalizedName() + ".name");
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSapling.TYPE, BlockSapling.STAGE });
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIlIIlllllIIlllIIIl) {
        return lllllllllllllIIlIIlllllIIlllIIIl.getValue(BlockSapling.TYPE).getMetadata();
    }
    
    public boolean isTypeAt(final World lllllllllllllIIlIIlllllIIlllllIl, final BlockPos lllllllllllllIIlIIlllllIIlllIlll, final BlockPlanks.EnumType lllllllllllllIIlIIlllllIIllllIll) {
        final IBlockState lllllllllllllIIlIIlllllIIllllIlI = lllllllllllllIIlIIlllllIIlllllIl.getBlockState(lllllllllllllIIlIIlllllIIlllIlll);
        return lllllllllllllIIlIIlllllIIllllIlI.getBlock() == this && lllllllllllllIIlIIlllllIIllllIlI.getValue(BlockSapling.TYPE) == lllllllllllllIIlIIlllllIIllllIll;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockSapling.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final float lllllllllllllIIlIIlllllIIIllIlII = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            lllllllllllllIIlIIlllllIIIllIlII[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIIlllllIIIllIlII[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIIlllllIIIllIlII[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIIlllllIIIllIlII[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlIIlllllIIIllIlII[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIlIIlllllIIIllIlII[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockSapling.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)lllllllllllllIIlIIlllllIIIllIlII;
    }
    
    @Override
    public boolean canGrow(final World lllllllllllllIIlIIlllllIIlIlllll, final BlockPos lllllllllllllIIlIIlllllIIlIllllI, final IBlockState lllllllllllllIIlIIlllllIIlIlllIl, final boolean lllllllllllllIIlIIlllllIIlIlllII) {
        return true;
    }
    
    public void generateTree(final World lllllllllllllIIlIIlllllIlIIlllll, final BlockPos lllllllllllllIIlIIlllllIlIlIlIlI, final IBlockState lllllllllllllIIlIIlllllIlIIlllIl, final Random lllllllllllllIIlIIlllllIlIlIlIII) {
        WorldGenerator lllllllllllllIIlIIlllllIlIlIIlll = (lllllllllllllIIlIIlllllIlIlIlIII.nextInt(10) == 0) ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int lllllllllllllIIlIIlllllIlIlIIllI = 0;
        int lllllllllllllIIlIIlllllIlIlIIlIl = 0;
        boolean lllllllllllllIIlIIlllllIlIlIIlII = false;
        switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[lllllllllllllIIlIIlllllIlIIlllIl.getValue(BlockSapling.TYPE).ordinal()]) {
            case 2: {
            Label_0163:
                for (lllllllllllllIIlIIlllllIlIlIIllI = 0; lllllllllllllIIlIIlllllIlIlIIllI >= -1; --lllllllllllllIIlIIlllllIlIlIIllI) {
                    for (lllllllllllllIIlIIlllllIlIlIIlIl = 0; lllllllllllllIIlIIlllllIlIlIIlIl >= -1; --lllllllllllllIIlIIlllllIlIlIIlIl) {
                        if (this.isTwoByTwoOfType(lllllllllllllIIlIIlllllIlIIlllll, lllllllllllllIIlIIlllllIlIlIlIlI, lllllllllllllIIlIIlllllIlIlIIllI, lllllllllllllIIlIIlllllIlIlIIlIl, BlockPlanks.EnumType.SPRUCE)) {
                            lllllllllllllIIlIIlllllIlIlIIlll = new WorldGenMegaPineTree(false, lllllllllllllIIlIIlllllIlIlIlIII.nextBoolean());
                            lllllllllllllIIlIIlllllIlIlIIlII = true;
                            break Label_0163;
                        }
                    }
                }
                if (!lllllllllllllIIlIIlllllIlIlIIlII) {
                    lllllllllllllIIlIIlllllIlIlIIllI = 0;
                    lllllllllllllIIlIIlllllIlIlIIlIl = 0;
                    lllllllllllllIIlIIlllllIlIlIIlll = new WorldGenTaiga2(true);
                    break;
                }
                break;
            }
            case 3: {
                lllllllllllllIIlIIlllllIlIlIIlll = new WorldGenBirchTree(true, false);
                break;
            }
            case 4: {
                final IBlockState lllllllllllllIIlIIlllllIlIlIIIll = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
                final IBlockState lllllllllllllIIlIIlllllIlIlIIIlI = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
            Label_0321:
                for (lllllllllllllIIlIIlllllIlIlIIllI = 0; lllllllllllllIIlIIlllllIlIlIIllI >= -1; --lllllllllllllIIlIIlllllIlIlIIllI) {
                    for (lllllllllllllIIlIIlllllIlIlIIlIl = 0; lllllllllllllIIlIIlllllIlIlIIlIl >= -1; --lllllllllllllIIlIIlllllIlIlIIlIl) {
                        if (this.isTwoByTwoOfType(lllllllllllllIIlIIlllllIlIIlllll, lllllllllllllIIlIIlllllIlIlIlIlI, lllllllllllllIIlIIlllllIlIlIIllI, lllllllllllllIIlIIlllllIlIlIIlIl, BlockPlanks.EnumType.JUNGLE)) {
                            lllllllllllllIIlIIlllllIlIlIIlll = new WorldGenMegaJungle(true, 10, 20, lllllllllllllIIlIIlllllIlIlIIIll, lllllllllllllIIlIIlllllIlIlIIIlI);
                            lllllllllllllIIlIIlllllIlIlIIlII = true;
                            break Label_0321;
                        }
                    }
                }
                if (!lllllllllllllIIlIIlllllIlIlIIlII) {
                    lllllllllllllIIlIIlllllIlIlIIllI = 0;
                    lllllllllllllIIlIIlllllIlIlIIlIl = 0;
                    lllllllllllllIIlIIlllllIlIlIIlll = new WorldGenTrees(true, 4 + lllllllllllllIIlIIlllllIlIlIlIII.nextInt(7), lllllllllllllIIlIIlllllIlIlIIIll, lllllllllllllIIlIIlllllIlIlIIIlI, false);
                    break;
                }
                break;
            }
            case 5: {
                lllllllllllllIIlIIlllllIlIlIIlll = new WorldGenSavannaTree(true);
                break;
            }
            case 6: {
            Label_0434:
                for (lllllllllllllIIlIIlllllIlIlIIllI = 0; lllllllllllllIIlIIlllllIlIlIIllI >= -1; --lllllllllllllIIlIIlllllIlIlIIllI) {
                    for (lllllllllllllIIlIIlllllIlIlIIlIl = 0; lllllllllllllIIlIIlllllIlIlIIlIl >= -1; --lllllllllllllIIlIIlllllIlIlIIlIl) {
                        if (this.isTwoByTwoOfType(lllllllllllllIIlIIlllllIlIIlllll, lllllllllllllIIlIIlllllIlIlIlIlI, lllllllllllllIIlIIlllllIlIlIIllI, lllllllllllllIIlIIlllllIlIlIIlIl, BlockPlanks.EnumType.DARK_OAK)) {
                            lllllllllllllIIlIIlllllIlIlIIlll = new WorldGenCanopyTree(true);
                            lllllllllllllIIlIIlllllIlIlIIlII = true;
                            break Label_0434;
                        }
                    }
                }
                if (!lllllllllllllIIlIIlllllIlIlIIlII) {
                    return;
                }
                break;
            }
        }
        final IBlockState lllllllllllllIIlIIlllllIlIlIIIIl = Blocks.AIR.getDefaultState();
        if (lllllllllllllIIlIIlllllIlIlIIlII) {
            lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI, 0, lllllllllllllIIlIIlllllIlIlIIlIl), lllllllllllllIIlIIlllllIlIlIIIIl, 4);
            lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI + 1, 0, lllllllllllllIIlIIlllllIlIlIIlIl), lllllllllllllIIlIIlllllIlIlIIIIl, 4);
            lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI, 0, lllllllllllllIIlIIlllllIlIlIIlIl + 1), lllllllllllllIIlIIlllllIlIlIIIIl, 4);
            lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI + 1, 0, lllllllllllllIIlIIlllllIlIlIIlIl + 1), lllllllllllllIIlIIlllllIlIlIIIIl, 4);
        }
        else {
            lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI, lllllllllllllIIlIIlllllIlIlIIIIl, 4);
        }
        if (!lllllllllllllIIlIIlllllIlIlIIlll.generate(lllllllllllllIIlIIlllllIlIIlllll, lllllllllllllIIlIIlllllIlIlIlIII, lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI, 0, lllllllllllllIIlIIlllllIlIlIIlIl))) {
            if (lllllllllllllIIlIIlllllIlIlIIlII) {
                lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI, 0, lllllllllllllIIlIIlllllIlIlIIlIl), lllllllllllllIIlIIlllllIlIIlllIl, 4);
                lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI + 1, 0, lllllllllllllIIlIIlllllIlIlIIlIl), lllllllllllllIIlIIlllllIlIIlllIl, 4);
                lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI, 0, lllllllllllllIIlIIlllllIlIlIIlIl + 1), lllllllllllllIIlIIlllllIlIIlllIl, 4);
                lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI.add(lllllllllllllIIlIIlllllIlIlIIllI + 1, 0, lllllllllllllIIlIIlllllIlIlIIlIl + 1), lllllllllllllIIlIIlllllIlIIlllIl, 4);
            }
            else {
                lllllllllllllIIlIIlllllIlIIlllll.setBlockState(lllllllllllllIIlIIlllllIlIlIlIlI, lllllllllllllIIlIIlllllIlIIlllIl, 4);
            }
        }
    }
    
    protected BlockSapling() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockSapling.STAGE, 0));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public void grow(final World lllllllllllllIIlIIlllllIIlIIlllI, final Random lllllllllllllIIlIIlllllIIlIIlIII, final BlockPos lllllllllllllIIlIIlllllIIlIIllII, final IBlockState lllllllllllllIIlIIlllllIIlIIlIll) {
        this.grow(lllllllllllllIIlIIlllllIIlIIlllI, lllllllllllllIIlIIlllllIIlIIllII, lllllllllllllIIlIIlllllIIlIIlIll, lllllllllllllIIlIIlllllIIlIIlIII);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIlIIlllllIllIllIll, final IBlockAccess lllllllllllllIIlIIlllllIllIllIlI, final BlockPos lllllllllllllIIlIIlllllIllIllIIl) {
        return BlockSapling.SAPLING_AABB;
    }
    
    @Override
    public void updateTick(final World lllllllllllllIIlIIlllllIllIIlIlI, final BlockPos lllllllllllllIIlIIlllllIllIIlIIl, final IBlockState lllllllllllllIIlIIlllllIllIIlIII, final Random lllllllllllllIIlIIlllllIllIIllII) {
        if (!lllllllllllllIIlIIlllllIllIIlIlI.isRemote) {
            super.updateTick(lllllllllllllIIlIIlllllIllIIlIlI, lllllllllllllIIlIIlllllIllIIlIIl, lllllllllllllIIlIIlllllIllIIlIII, lllllllllllllIIlIIlllllIllIIllII);
            if (lllllllllllllIIlIIlllllIllIIlIlI.getLightFromNeighbors(lllllllllllllIIlIIlllllIllIIlIIl.up()) >= 9 && lllllllllllllIIlIIlllllIllIIllII.nextInt(7) == 0) {
                this.grow(lllllllllllllIIlIIlllllIllIIlIlI, lllllllllllllIIlIIlllllIllIIlIIl, lllllllllllllIIlIIlllllIllIIlIII, lllllllllllllIIlIIlllllIllIIllII);
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIlIIlllllIIlIIIIlI) {
        return this.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.byMetadata(lllllllllllllIIlIIlllllIIlIIIIlI & 0x7)).withProperty((IProperty<Comparable>)BlockSapling.STAGE, (lllllllllllllIIlIIlllllIIlIIIIlI & 0x8) >> 3);
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllIIlIIlllllIIlIlIlIl, final Random lllllllllllllIIlIIlllllIIlIllIII, final BlockPos lllllllllllllIIlIIlllllIIlIlIlll, final IBlockState lllllllllllllIIlIIlllllIIlIlIllI) {
        return lllllllllllllIIlIIlllllIIlIlIlIl.rand.nextFloat() < 0.45;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIlIIlllllIIIlllIlI) {
        int lllllllllllllIIlIIlllllIIIlllIll = 0;
        lllllllllllllIIlIIlllllIIIlllIll |= lllllllllllllIIlIIlllllIIIlllIlI.getValue(BlockSapling.TYPE).getMetadata();
        lllllllllllllIIlIIlllllIIIlllIll |= lllllllllllllIIlIIlllllIIIlllIlI.getValue((IProperty<Integer>)BlockSapling.STAGE) << 3;
        return lllllllllllllIIlIIlllllIIIlllIll;
    }
    
    public void grow(final World lllllllllllllIIlIIlllllIlIlllIll, final BlockPos lllllllllllllIIlIIlllllIlIllllll, final IBlockState lllllllllllllIIlIIlllllIlIlllIIl, final Random lllllllllllllIIlIIlllllIlIllllIl) {
        if (lllllllllllllIIlIIlllllIlIlllIIl.getValue((IProperty<Integer>)BlockSapling.STAGE) == 0) {
            lllllllllllllIIlIIlllllIlIlllIll.setBlockState(lllllllllllllIIlIIlllllIlIllllll, lllllllllllllIIlIIlllllIlIlllIIl.cycleProperty((IProperty<Comparable>)BlockSapling.STAGE), 4);
        }
        else {
            this.generateTree(lllllllllllllIIlIIlllllIlIlllIll, lllllllllllllIIlIIlllllIlIllllll, lllllllllllllIIlIIlllllIlIlllIIl, lllllllllllllIIlIIlllllIlIllllIl);
        }
    }
    
    static {
        TYPE = PropertyEnum.create("type", BlockPlanks.EnumType.class);
        STAGE = PropertyInteger.create("stage", 0, 1);
        SAPLING_AABB = new AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421);
    }
    
    private boolean isTwoByTwoOfType(final World lllllllllllllIIlIIlllllIlIIIlllI, final BlockPos lllllllllllllIIlIIlllllIlIIIIlll, final int lllllllllllllIIlIIlllllIlIIIIllI, final int lllllllllllllIIlIIlllllIlIIIlIll, final BlockPlanks.EnumType lllllllllllllIIlIIlllllIlIIIIlII) {
        return this.isTypeAt(lllllllllllllIIlIIlllllIlIIIlllI, lllllllllllllIIlIIlllllIlIIIIlll.add(lllllllllllllIIlIIlllllIlIIIIllI, 0, lllllllllllllIIlIIlllllIlIIIlIll), lllllllllllllIIlIIlllllIlIIIIlII) && this.isTypeAt(lllllllllllllIIlIIlllllIlIIIlllI, lllllllllllllIIlIIlllllIlIIIIlll.add(lllllllllllllIIlIIlllllIlIIIIllI + 1, 0, lllllllllllllIIlIIlllllIlIIIlIll), lllllllllllllIIlIIlllllIlIIIIlII) && this.isTypeAt(lllllllllllllIIlIIlllllIlIIIlllI, lllllllllllllIIlIIlllllIlIIIIlll.add(lllllllllllllIIlIIlllllIlIIIIllI, 0, lllllllllllllIIlIIlllllIlIIIlIll + 1), lllllllllllllIIlIIlllllIlIIIIlII) && this.isTypeAt(lllllllllllllIIlIIlllllIlIIIlllI, lllllllllllllIIlIIlllllIlIIIIlll.add(lllllllllllllIIlIIlllllIlIIIIllI + 1, 0, lllllllllllllIIlIIlllllIlIIIlIll + 1), lllllllllllllIIlIIlllllIlIIIIlII);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIlIIlllllIIllIlIIl, final NonNullList<ItemStack> lllllllllllllIIlIIlllllIIllIIlIl) {
        final short lllllllllllllIIlIIlllllIIllIIIIl;
        final String lllllllllllllIIlIIlllllIIllIIIlI = (String)((BlockPlanks.EnumType[])(Object)(lllllllllllllIIlIIlllllIIllIIIIl = (short)(Object)BlockPlanks.EnumType.values())).length;
        for (char lllllllllllllIIlIIlllllIIllIIIll = '\0'; lllllllllllllIIlIIlllllIIllIIIll < lllllllllllllIIlIIlllllIIllIIIlI; ++lllllllllllllIIlIIlllllIIllIIIll) {
            final BlockPlanks.EnumType lllllllllllllIIlIIlllllIIllIIlll = lllllllllllllIIlIIlllllIIllIIIIl[lllllllllllllIIlIIlllllIIllIIIll];
            lllllllllllllIIlIIlllllIIllIIlIl.add(new ItemStack(this, 1, lllllllllllllIIlIIlllllIIllIIlll.getMetadata()));
        }
    }
}
