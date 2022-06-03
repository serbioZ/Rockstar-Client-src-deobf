// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.Explosion;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.block.properties.IProperty;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;

public class BlockTNT extends Block
{
    public static final /* synthetic */ PropertyBool EXPLODE;
    
    public void explode(final World llllllllllllIlIllIllIlIlIIIIllII, final BlockPos llllllllllllIlIllIllIlIlIIIIlIll, final IBlockState llllllllllllIlIllIllIlIlIIIIlIlI, final EntityLivingBase llllllllllllIlIllIllIlIlIIIIIlII) {
        if (!llllllllllllIlIllIllIlIlIIIIllII.isRemote && llllllllllllIlIllIllIlIlIIIIlIlI.getValue((IProperty<Boolean>)BlockTNT.EXPLODE)) {
            final EntityTNTPrimed llllllllllllIlIllIllIlIlIIIIlIII = new EntityTNTPrimed(llllllllllllIlIllIllIlIlIIIIllII, llllllllllllIlIllIllIlIlIIIIlIll.getX() + 0.5f, llllllllllllIlIllIllIlIlIIIIlIll.getY(), llllllllllllIlIllIllIlIlIIIIlIll.getZ() + 0.5f, llllllllllllIlIllIllIlIlIIIIIlII);
            llllllllllllIlIllIllIlIlIIIIllII.spawnEntityInWorld(llllllllllllIlIllIllIlIlIIIIlIII);
            llllllllllllIlIllIllIlIlIIIIllII.playSound(null, llllllllllllIlIllIllIlIlIIIIlIII.posX, llllllllllllIlIllIllIlIlIIIIlIII.posY, llllllllllllIlIllIllIlIlIIIIlIII.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIllIllIlIIllIIIlll) {
        return ((boolean)llllllllllllIlIllIllIlIIllIIIlll.getValue((IProperty<Boolean>)BlockTNT.EXPLODE)) ? 1 : 0;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIlIllIllIlIlIlIIIIII, final BlockPos llllllllllllIlIllIllIlIlIIlllIll, final IBlockState llllllllllllIlIllIllIlIlIIlllllI) {
        super.onBlockAdded(llllllllllllIlIllIllIlIlIlIIIIII, llllllllllllIlIllIllIlIlIIlllIll, llllllllllllIlIllIllIlIlIIlllllI);
        if (llllllllllllIlIllIllIlIlIlIIIIII.isBlockPowered(llllllllllllIlIllIllIlIlIIlllIll)) {
            this.onBlockDestroyedByPlayer(llllllllllllIlIllIllIlIlIlIIIIII, llllllllllllIlIllIllIlIlIIlllIll, llllllllllllIlIllIllIlIlIIlllllI.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
            llllllllllllIlIllIllIlIlIlIIIIII.setBlockToAir(llllllllllllIlIllIllIlIlIIlllIll);
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIlIllIllIlIlIIlIlllI, final World llllllllllllIlIllIllIlIlIIlIllIl, final BlockPos llllllllllllIlIllIllIlIlIIllIIlI, final Block llllllllllllIlIllIllIlIlIIllIIIl, final BlockPos llllllllllllIlIllIllIlIlIIllIIII) {
        if (llllllllllllIlIllIllIlIlIIlIllIl.isBlockPowered(llllllllllllIlIllIllIlIlIIllIIlI)) {
            this.onBlockDestroyedByPlayer(llllllllllllIlIllIllIlIlIIlIllIl, llllllllllllIlIllIllIlIlIIllIIlI, llllllllllllIlIllIllIlIlIIlIlllI.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
            llllllllllllIlIllIllIlIlIIlIllIl.setBlockToAir(llllllllllllIlIllIllIlIlIIllIIlI);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTNT.EXPLODE });
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World llllllllllllIlIllIllIlIlIIIllIIl, final BlockPos llllllllllllIlIllIllIlIlIIIlIlII, final IBlockState llllllllllllIlIllIllIlIlIIIlIIll) {
        this.explode(llllllllllllIlIllIllIlIlIIIllIIl, llllllllllllIlIllIllIlIlIIIlIlII, llllllllllllIlIllIllIlIlIIIlIIll, null);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllIlIllIllIlIIllIllIll, final BlockPos llllllllllllIlIllIllIlIIllIllIlI, final IBlockState llllllllllllIlIllIllIlIIllIllIIl, final Entity llllllllllllIlIllIllIlIIllIllIII) {
        if (!llllllllllllIlIllIllIlIIllIllIll.isRemote && llllllllllllIlIllIllIlIIllIllIII instanceof EntityArrow) {
            final EntityArrow llllllllllllIlIllIllIlIIllIlIlll = (EntityArrow)llllllllllllIlIllIllIlIIllIllIII;
            if (llllllllllllIlIllIllIlIIllIlIlll.isBurning()) {
                this.explode(llllllllllllIlIllIllIlIIllIllIll, llllllllllllIlIllIllIlIIllIllIlI, llllllllllllIlIllIllIlIIllIllIll.getBlockState(llllllllllllIlIllIllIlIIllIllIlI).withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true), (llllllllllllIlIllIllIlIIllIlIlll.shootingEntity instanceof EntityLivingBase) ? ((EntityLivingBase)llllllllllllIlIllIllIlIIllIlIlll.shootingEntity) : null);
                llllllllllllIlIllIllIlIIllIllIll.setBlockToAir(llllllllllllIlIllIllIlIIllIllIlI);
            }
        }
    }
    
    @Override
    public void onBlockDestroyedByExplosion(final World llllllllllllIlIllIllIlIlIIlIIllI, final BlockPos llllllllllllIlIllIllIlIlIIlIIIIl, final Explosion llllllllllllIlIllIllIlIlIIlIIlII) {
        if (!llllllllllllIlIllIllIlIlIIlIIllI.isRemote) {
            final EntityTNTPrimed llllllllllllIlIllIllIlIlIIlIIIll = new EntityTNTPrimed(llllllllllllIlIllIllIlIlIIlIIllI, llllllllllllIlIllIllIlIlIIlIIIIl.getX() + 0.5f, llllllllllllIlIllIllIlIlIIlIIIIl.getY(), llllllllllllIlIllIllIlIlIIlIIIIl.getZ() + 0.5f, llllllllllllIlIllIllIlIlIIlIIlII.getExplosivePlacedBy());
            llllllllllllIlIllIllIlIlIIlIIIll.setFuse((short)(llllllllllllIlIllIllIlIlIIlIIllI.rand.nextInt(llllllllllllIlIllIllIlIlIIlIIIll.getFuse() / 4) + llllllllllllIlIllIllIlIlIIlIIIll.getFuse() / 8));
            llllllllllllIlIllIllIlIlIIlIIllI.spawnEntityInWorld(llllllllllllIlIllIllIlIlIIlIIIll);
        }
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIlIllIllIlIIlllIlIll, final BlockPos llllllllllllIlIllIllIlIIllllIlIl, final IBlockState llllllllllllIlIllIllIlIIlllIlIIl, final EntityPlayer llllllllllllIlIllIllIlIIlllIlIII, final EnumHand llllllllllllIlIllIllIlIIlllIIlll, final EnumFacing llllllllllllIlIllIllIlIIllllIIIl, final float llllllllllllIlIllIllIlIIlllIIlIl, final float llllllllllllIlIllIllIlIIlllIllll, final float llllllllllllIlIllIllIlIIlllIIIll) {
        final ItemStack llllllllllllIlIllIllIlIIlllIllIl = llllllllllllIlIllIllIlIIlllIlIII.getHeldItem(llllllllllllIlIllIllIlIIlllIIlll);
        if (!llllllllllllIlIllIllIlIIlllIllIl.func_190926_b() && (llllllllllllIlIllIllIlIIlllIllIl.getItem() == Items.FLINT_AND_STEEL || llllllllllllIlIllIllIlIIlllIllIl.getItem() == Items.FIRE_CHARGE)) {
            this.explode(llllllllllllIlIllIllIlIIlllIlIll, llllllllllllIlIllIllIlIIllllIlIl, llllllllllllIlIllIllIlIIlllIlIIl.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true), llllllllllllIlIllIllIlIIlllIlIII);
            llllllllllllIlIllIllIlIIlllIlIll.setBlockState(llllllllllllIlIllIllIlIIllllIlIl, Blocks.AIR.getDefaultState(), 11);
            if (llllllllllllIlIllIllIlIIlllIllIl.getItem() == Items.FLINT_AND_STEEL) {
                llllllllllllIlIllIllIlIIlllIllIl.damageItem(1, llllllllllllIlIllIllIlIIlllIlIII);
            }
            else if (!llllllllllllIlIllIllIlIIlllIlIII.capabilities.isCreativeMode) {
                llllllllllllIlIllIllIlIIlllIllIl.func_190918_g(1);
            }
            return true;
        }
        return super.onBlockActivated(llllllllllllIlIllIllIlIIlllIlIll, llllllllllllIlIllIllIlIIllllIlIl, llllllllllllIlIllIllIlIIlllIlIIl, llllllllllllIlIllIllIlIIlllIlIII, llllllllllllIlIllIllIlIIlllIIlll, llllllllllllIlIllIllIlIIllllIIIl, llllllllllllIlIllIllIlIIlllIIlIl, llllllllllllIlIllIllIlIIlllIllll, llllllllllllIlIllIllIlIIlllIIIll);
    }
    
    public BlockTNT() {
        super(Material.TNT);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIllIllIlIIllIIlIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, (llllllllllllIlIllIllIlIIllIIlIlI & 0x1) > 0);
    }
    
    static {
        EXPLODE = PropertyBool.create("explode");
    }
    
    @Override
    public boolean canDropFromExplosion(final Explosion llllllllllllIlIllIllIlIIllIlIIII) {
        return false;
    }
}
