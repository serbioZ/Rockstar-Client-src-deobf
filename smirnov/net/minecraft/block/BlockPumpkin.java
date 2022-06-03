// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.Mirror;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import javax.annotation.Nullable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import java.util.Iterator;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;

public class BlockPumpkin extends BlockHorizontal
{
    private static final /* synthetic */ Predicate<IBlockState> IS_PUMPKIN;
    private /* synthetic */ BlockPattern golemPattern;
    private /* synthetic */ BlockPattern snowmanPattern;
    private /* synthetic */ BlockPattern snowmanBasePattern;
    private /* synthetic */ BlockPattern golemBasePattern;
    
    protected BlockPattern getGolemPattern() {
        if (this.golemPattern == null) {
            this.golemPattern = FactoryBlockPattern.start().aisle("~^~", "###", "~#~").where('^', BlockWorldState.hasState(BlockPumpkin.IS_PUMPKIN)).where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.IRON_BLOCK))).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.golemPattern;
    }
    
    private void trySpawnGolem(final World lllllllllllIIlIIIIIlIIIIlIlIlllI, final BlockPos lllllllllllIIlIIIIIlIIIIllIIIIlI) {
        BlockPattern.PatternHelper lllllllllllIIlIIIIIlIIIIllIIIIIl = this.getSnowmanPattern().match(lllllllllllIIlIIIIIlIIIIlIlIlllI, lllllllllllIIlIIIIIlIIIIllIIIIlI);
        if (lllllllllllIIlIIIIIlIIIIllIIIIIl != null) {
            for (int lllllllllllIIlIIIIIlIIIIllIIIIII = 0; lllllllllllIIlIIIIIlIIIIllIIIIII < this.getSnowmanPattern().getThumbLength(); ++lllllllllllIIlIIIIIlIIIIllIIIIII) {
                final BlockWorldState lllllllllllIIlIIIIIlIIIIlIllllll = lllllllllllIIlIIIIIlIIIIllIIIIIl.translateOffset(0, lllllllllllIIlIIIIIlIIIIllIIIIII, 0);
                lllllllllllIIlIIIIIlIIIIlIlIlllI.setBlockState(lllllllllllIIlIIIIIlIIIIlIllllll.getPos(), Blocks.AIR.getDefaultState(), 2);
            }
            final EntitySnowman lllllllllllIIlIIIIIlIIIIlIlllllI = new EntitySnowman(lllllllllllIIlIIIIIlIIIIlIlIlllI);
            final BlockPos lllllllllllIIlIIIIIlIIIIlIllllIl = lllllllllllIIlIIIIIlIIIIllIIIIIl.translateOffset(0, 2, 0).getPos();
            lllllllllllIIlIIIIIlIIIIlIlllllI.setLocationAndAngles(lllllllllllIIlIIIIIlIIIIlIllllIl.getX() + 0.5, lllllllllllIIlIIIIIlIIIIlIllllIl.getY() + 0.05, lllllllllllIIlIIIIIlIIIIlIllllIl.getZ() + 0.5, 0.0f, 0.0f);
            lllllllllllIIlIIIIIlIIIIlIlIlllI.spawnEntityInWorld(lllllllllllIIlIIIIIlIIIIlIlllllI);
            for (final EntityPlayerMP lllllllllllIIlIIIIIlIIIIlIllllII : lllllllllllIIlIIIIIlIIIIlIlIlllI.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, lllllllllllIIlIIIIIlIIIIlIlllllI.getEntityBoundingBox().expandXyz(5.0))) {
                CriteriaTriggers.field_192133_m.func_192229_a(lllllllllllIIlIIIIIlIIIIlIllllII, lllllllllllIIlIIIIIlIIIIlIlllllI);
            }
            for (int lllllllllllIIlIIIIIlIIIIlIlllIll = 0; lllllllllllIIlIIIIIlIIIIlIlllIll < 120; ++lllllllllllIIlIIIIIlIIIIlIlllIll) {
                lllllllllllIIlIIIIIlIIIIlIlIlllI.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, lllllllllllIIlIIIIIlIIIIlIllllIl.getX() + lllllllllllIIlIIIIIlIIIIlIlIlllI.rand.nextDouble(), lllllllllllIIlIIIIIlIIIIlIllllIl.getY() + lllllllllllIIlIIIIIlIIIIlIlIlllI.rand.nextDouble() * 2.5, lllllllllllIIlIIIIIlIIIIlIllllIl.getZ() + lllllllllllIIlIIIIIlIIIIlIlIlllI.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
            }
            for (int lllllllllllIIlIIIIIlIIIIlIlllIlI = 0; lllllllllllIIlIIIIIlIIIIlIlllIlI < this.getSnowmanPattern().getThumbLength(); ++lllllllllllIIlIIIIIlIIIIlIlllIlI) {
                final BlockWorldState lllllllllllIIlIIIIIlIIIIlIlllIIl = lllllllllllIIlIIIIIlIIIIllIIIIIl.translateOffset(0, lllllllllllIIlIIIIIlIIIIlIlllIlI, 0);
                lllllllllllIIlIIIIIlIIIIlIlIlllI.notifyNeighborsRespectDebug(lllllllllllIIlIIIIIlIIIIlIlllIIl.getPos(), Blocks.AIR, false);
            }
        }
        else {
            lllllllllllIIlIIIIIlIIIIllIIIIIl = this.getGolemPattern().match(lllllllllllIIlIIIIIlIIIIlIlIlllI, lllllllllllIIlIIIIIlIIIIllIIIIlI);
            if (lllllllllllIIlIIIIIlIIIIllIIIIIl != null) {
                for (int lllllllllllIIlIIIIIlIIIIlIlllIII = 0; lllllllllllIIlIIIIIlIIIIlIlllIII < this.getGolemPattern().getPalmLength(); ++lllllllllllIIlIIIIIlIIIIlIlllIII) {
                    for (int lllllllllllIIlIIIIIlIIIIlIllIlll = 0; lllllllllllIIlIIIIIlIIIIlIllIlll < this.getGolemPattern().getThumbLength(); ++lllllllllllIIlIIIIIlIIIIlIllIlll) {
                        lllllllllllIIlIIIIIlIIIIlIlIlllI.setBlockState(lllllllllllIIlIIIIIlIIIIllIIIIIl.translateOffset(lllllllllllIIlIIIIIlIIIIlIlllIII, lllllllllllIIlIIIIIlIIIIlIllIlll, 0).getPos(), Blocks.AIR.getDefaultState(), 2);
                    }
                }
                final BlockPos lllllllllllIIlIIIIIlIIIIlIllIllI = lllllllllllIIlIIIIIlIIIIllIIIIIl.translateOffset(1, 2, 0).getPos();
                final EntityIronGolem lllllllllllIIlIIIIIlIIIIlIllIlIl = new EntityIronGolem(lllllllllllIIlIIIIIlIIIIlIlIlllI);
                lllllllllllIIlIIIIIlIIIIlIllIlIl.setPlayerCreated(true);
                lllllllllllIIlIIIIIlIIIIlIllIlIl.setLocationAndAngles(lllllllllllIIlIIIIIlIIIIlIllIllI.getX() + 0.5, lllllllllllIIlIIIIIlIIIIlIllIllI.getY() + 0.05, lllllllllllIIlIIIIIlIIIIlIllIllI.getZ() + 0.5, 0.0f, 0.0f);
                lllllllllllIIlIIIIIlIIIIlIlIlllI.spawnEntityInWorld(lllllllllllIIlIIIIIlIIIIlIllIlIl);
                for (final EntityPlayerMP lllllllllllIIlIIIIIlIIIIlIllIlII : lllllllllllIIlIIIIIlIIIIlIlIlllI.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, lllllllllllIIlIIIIIlIIIIlIllIlIl.getEntityBoundingBox().expandXyz(5.0))) {
                    CriteriaTriggers.field_192133_m.func_192229_a(lllllllllllIIlIIIIIlIIIIlIllIlII, lllllllllllIIlIIIIIlIIIIlIllIlIl);
                }
                for (int lllllllllllIIlIIIIIlIIIIlIllIIll = 0; lllllllllllIIlIIIIIlIIIIlIllIIll < 120; ++lllllllllllIIlIIIIIlIIIIlIllIIll) {
                    lllllllllllIIlIIIIIlIIIIlIlIlllI.spawnParticle(EnumParticleTypes.SNOWBALL, lllllllllllIIlIIIIIlIIIIlIllIllI.getX() + lllllllllllIIlIIIIIlIIIIlIlIlllI.rand.nextDouble(), lllllllllllIIlIIIIIlIIIIlIllIllI.getY() + lllllllllllIIlIIIIIlIIIIlIlIlllI.rand.nextDouble() * 3.9, lllllllllllIIlIIIIIlIIIIlIllIllI.getZ() + lllllllllllIIlIIIIIlIIIIlIlIlllI.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
                }
                for (int lllllllllllIIlIIIIIlIIIIlIllIIlI = 0; lllllllllllIIlIIIIIlIIIIlIllIIlI < this.getGolemPattern().getPalmLength(); ++lllllllllllIIlIIIIIlIIIIlIllIIlI) {
                    for (int lllllllllllIIlIIIIIlIIIIlIllIIIl = 0; lllllllllllIIlIIIIIlIIIIlIllIIIl < this.getGolemPattern().getThumbLength(); ++lllllllllllIIlIIIIIlIIIIlIllIIIl) {
                        final BlockWorldState lllllllllllIIlIIIIIlIIIIlIllIIII = lllllllllllIIlIIIIIlIIIIllIIIIIl.translateOffset(lllllllllllIIlIIIIIlIIIIlIllIIlI, lllllllllllIIlIIIIIlIIIIlIllIIIl, 0);
                        lllllllllllIIlIIIIIlIIIIlIlIlllI.notifyNeighborsRespectDebug(lllllllllllIIlIIIIIlIIIIlIllIIII.getPos(), Blocks.AIR, false);
                    }
                }
            }
        }
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIIlIIIIIlIIIIllIlllIl, final BlockPos lllllllllllIIlIIIIIlIIIIllIlllII, final IBlockState lllllllllllIIlIIIIIlIIIIllIllIll) {
        super.onBlockAdded(lllllllllllIIlIIIIIlIIIIllIlllIl, lllllllllllIIlIIIIIlIIIIllIlllII, lllllllllllIIlIIIIIlIIIIllIllIll);
        this.trySpawnGolem(lllllllllllIIlIIIIIlIIIIllIlllIl, lllllllllllIIlIIIIIlIIIIllIlllII);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIlIIIIIlIIIIlIIlllII, final Rotation lllllllllllIIlIIIIIlIIIIlIIllIIl) {
        return lllllllllllIIlIIIIIlIIIIlIIlllII.withProperty((IProperty<Comparable>)BlockPumpkin.FACING, lllllllllllIIlIIIIIlIIIIlIIllIIl.rotate(lllllllllllIIlIIIIIlIIIIlIIlllII.getValue((IProperty<EnumFacing>)BlockPumpkin.FACING)));
    }
    
    static {
        IS_PUMPKIN = (Predicate)new Predicate<IBlockState>() {
            public boolean apply(@Nullable final IBlockState lllllllllllIllllIIllIllllIIlIlIl) {
                return lllllllllllIllllIIllIllllIIlIlIl != null && (lllllllllllIllllIIllIllllIIlIlIl.getBlock() == Blocks.PUMPKIN || lllllllllllIllllIIllIllllIIlIlIl.getBlock() == Blocks.LIT_PUMPKIN);
            }
        };
    }
    
    public boolean canDispenserPlace(final World lllllllllllIIlIIIIIlIIIIllIlIIlI, final BlockPos lllllllllllIIlIIIIIlIIIIllIlIIIl) {
        return this.getSnowmanBasePattern().match(lllllllllllIIlIIIIIlIIIIllIlIIlI, lllllllllllIIlIIIIIlIIIIllIlIIIl) != null || this.getGolemBasePattern().match(lllllllllllIIlIIIIIlIIIIllIlIIlI, lllllllllllIIlIIIIIlIIIIllIlIIIl) != null;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlIIIIIlIIIIIlllllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, EnumFacing.getHorizontal(lllllllllllIIlIIIIIlIIIIIlllllll));
    }
    
    protected BlockPumpkin() {
        super(Material.GOURD, MapColor.ADOBE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, EnumFacing.NORTH));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPumpkin.FACING });
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIIlIIIIIlIIIIlIlIIIll, final BlockPos lllllllllllIIlIIIIIlIIIIlIlIIIlI) {
        return lllllllllllIIlIIIIIlIIIIlIlIIIll.getBlockState(lllllllllllIIlIIIIIlIIIIlIlIIIlI).getBlock().blockMaterial.isReplaceable() && lllllllllllIIlIIIIIlIIIIlIlIIIll.getBlockState(lllllllllllIIlIIIIIlIIIIlIlIIIlI.down()).isFullyOpaque();
    }
    
    protected BlockPattern getGolemBasePattern() {
        if (this.golemBasePattern == null) {
            this.golemBasePattern = FactoryBlockPattern.start().aisle("~ ~", "###", "~#~").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.IRON_BLOCK))).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.golemBasePattern;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlIIIIIlIIIIIlllllII) {
        return lllllllllllIIlIIIIIlIIIIIlllllII.getValue((IProperty<EnumFacing>)BlockPumpkin.FACING).getHorizontalIndex();
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIIlIIIIIlIIIIlIIIlllI, final BlockPos lllllllllllIIlIIIIIlIIIIlIIIllIl, final EnumFacing lllllllllllIIlIIIIIlIIIIlIIIllII, final float lllllllllllIIlIIIIIlIIIIlIIIlIll, final float lllllllllllIIlIIIIIlIIIIlIIIlIlI, final float lllllllllllIIlIIIIIlIIIIlIIIlIIl, final int lllllllllllIIlIIIIIlIIIIlIIIlIII, final EntityLivingBase lllllllllllIIlIIIIIlIIIIlIIIIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, lllllllllllIIlIIIIIlIIIIlIIIIlIl.getHorizontalFacing().getOpposite());
    }
    
    protected BlockPattern getSnowmanBasePattern() {
        if (this.snowmanBasePattern == null) {
            this.snowmanBasePattern = FactoryBlockPattern.start().aisle(" ", "#", "#").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SNOW))).build();
        }
        return this.snowmanBasePattern;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIlIIIIIlIIIIlIIlIlIl, final Mirror lllllllllllIIlIIIIIlIIIIlIIlIIlI) {
        return lllllllllllIIlIIIIIlIIIIlIIlIlIl.withRotation(lllllllllllIIlIIIIIlIIIIlIIlIIlI.toRotation(lllllllllllIIlIIIIIlIIIIlIIlIlIl.getValue((IProperty<EnumFacing>)BlockPumpkin.FACING)));
    }
    
    protected BlockPattern getSnowmanPattern() {
        if (this.snowmanPattern == null) {
            this.snowmanPattern = FactoryBlockPattern.start().aisle("^", "#", "#").where('^', BlockWorldState.hasState(BlockPumpkin.IS_PUMPKIN)).where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SNOW))).build();
        }
        return this.snowmanPattern;
    }
}
