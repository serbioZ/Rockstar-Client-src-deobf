// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.util.Rotation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumDyeColor;

public class BlockGlazedTerracotta extends BlockHorizontal
{
    public BlockGlazedTerracotta(final EnumDyeColor lIIllllllIllIIl) {
        super(Material.ROCK, MapColor.func_193558_a(lIIllllllIllIIl));
        this.setHardness(1.4f);
        this.setSoundType(SoundType.STONE);
        final String lIIllllllIllIII = lIIllllllIllIIl.getUnlocalizedName();
        if (lIIllllllIllIII.length() > 1) {
            final String lIIllllllIlIlll = String.valueOf(lIIllllllIllIII.substring(0, 1).toUpperCase()) + lIIllllllIllIII.substring(1, lIIllllllIllIII.length());
            this.setUnlocalizedName("glazedTerracotta" + lIIllllllIlIlll);
        }
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockGlazedTerracotta.FACING });
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lIIllllllIIIIll, final Mirror lIIllllllIIIlII) {
        return lIIllllllIIIIll.withRotation(lIIllllllIIIlII.toRotation(lIIllllllIIIIll.getValue((IProperty<EnumFacing>)BlockGlazedTerracotta.FACING)));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lIIlllllIlllllI, final BlockPos lIIlllllIllllIl, final EnumFacing lIIlllllIllllII, final float lIIlllllIlllIll, final float lIIlllllIlllIlI, final float lIIlllllIlllIIl, final int lIIlllllIlllIII, final EntityLivingBase lIIlllllIllIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockGlazedTerracotta.FACING, lIIlllllIllIlIl.getHorizontalFacing().getOpposite());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIlllllIlIlIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockGlazedTerracotta.FACING, EnumFacing.getHorizontal(lIIlllllIlIlIlI));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIlllllIlIllll) {
        int lIIlllllIllIIII = 0;
        lIIlllllIllIIII |= lIIlllllIlIllll.getValue((IProperty<EnumFacing>)BlockGlazedTerracotta.FACING).getHorizontalIndex();
        return lIIlllllIllIIII;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lIIllllllIIlIlI, final Rotation lIIllllllIIlIll) {
        return lIIllllllIIlIlI.withProperty((IProperty<Comparable>)BlockGlazedTerracotta.FACING, lIIllllllIIlIll.rotate(lIIllllllIIlIlI.getValue((IProperty<EnumFacing>)BlockGlazedTerracotta.FACING)));
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lIIlllllIlIIllI) {
        return EnumPushReaction.PUSH_ONLY;
    }
}
