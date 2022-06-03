// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Enchantments;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;

public class EnchantmentFrostWalker extends Enchantment
{
    @Override
    public int getMinEnchantability(final int llllllllllllIIIlIlIlllllllIlIllI) {
        return llllllllllllIIIlIlIlllllllIlIllI * 10;
    }
    
    public static void freezeNearby(final EntityLivingBase llllllllllllIIIlIlIllllllIlllIIl, final World llllllllllllIIIlIlIlllllllIIIIIl, final BlockPos llllllllllllIIIlIlIlllllllIIIIII, final int llllllllllllIIIlIlIllllllIllIllI) {
        if (llllllllllllIIIlIlIllllllIlllIIl.onGround) {
            final float llllllllllllIIIlIlIllllllIlllllI = (float)Math.min(16, 2 + llllllllllllIIIlIlIllllllIllIllI);
            final BlockPos.MutableBlockPos llllllllllllIIIlIlIllllllIllllIl = new BlockPos.MutableBlockPos(0, 0, 0);
            for (final BlockPos.MutableBlockPos llllllllllllIIIlIlIllllllIllllII : BlockPos.getAllInBoxMutable(llllllllllllIIIlIlIlllllllIIIIII.add(-llllllllllllIIIlIlIllllllIlllllI, -1.0, -llllllllllllIIIlIlIllllllIlllllI), llllllllllllIIIlIlIlllllllIIIIII.add(llllllllllllIIIlIlIllllllIlllllI, -1.0, llllllllllllIIIlIlIllllllIlllllI))) {
                if (llllllllllllIIIlIlIllllllIllllII.distanceSqToCenter(llllllllllllIIIlIlIllllllIlllIIl.posX, llllllllllllIIIlIlIllllllIlllIIl.posY, llllllllllllIIIlIlIllllllIlllIIl.posZ) <= llllllllllllIIIlIlIllllllIlllllI * llllllllllllIIIlIlIllllllIlllllI) {
                    llllllllllllIIIlIlIllllllIllllIl.setPos(llllllllllllIIIlIlIllllllIllllII.getX(), llllllllllllIIIlIlIllllllIllllII.getY() + 1, llllllllllllIIIlIlIllllllIllllII.getZ());
                    final IBlockState llllllllllllIIIlIlIllllllIlllIll = llllllllllllIIIlIlIlllllllIIIIIl.getBlockState(llllllllllllIIIlIlIllllllIllllIl);
                    if (llllllllllllIIIlIlIllllllIlllIll.getMaterial() != Material.AIR) {
                        continue;
                    }
                    final IBlockState llllllllllllIIIlIlIllllllIlllIlI = llllllllllllIIIlIlIlllllllIIIIIl.getBlockState(llllllllllllIIIlIlIllllllIllllII);
                    if (llllllllllllIIIlIlIllllllIlllIlI.getMaterial() != Material.WATER || llllllllllllIIIlIlIllllllIlllIlI.getValue((IProperty<Integer>)BlockLiquid.LEVEL) != 0 || !llllllllllllIIIlIlIlllllllIIIIIl.func_190527_a(Blocks.FROSTED_ICE, llllllllllllIIIlIlIllllllIllllII, false, EnumFacing.DOWN, null)) {
                        continue;
                    }
                    llllllllllllIIIlIlIlllllllIIIIIl.setBlockState(llllllllllllIIIlIlIllllllIllllII, Blocks.FROSTED_ICE.getDefaultState());
                    llllllllllllIIIlIlIlllllllIIIIIl.scheduleUpdate(llllllllllllIIIlIlIllllllIllllII.toImmutable(), Blocks.FROSTED_ICE, MathHelper.getInt(llllllllllllIIIlIlIllllllIlllIIl.getRNG(), 60, 120));
                }
            }
        }
    }
    
    public boolean canApplyTogether(final Enchantment llllllllllllIIIlIlIllllllIlIlIlI) {
        return super.canApplyTogether(llllllllllllIIIlIlIllllllIlIlIlI) && llllllllllllIIIlIlIllllllIlIlIlI != Enchantments.DEPTH_STRIDER;
    }
    
    public EnchantmentFrostWalker(final Rarity llllllllllllIIIlIlIlllllllIlllIl, final EntityEquipmentSlot... llllllllllllIIIlIlIlllllllIllIIl) {
        super(llllllllllllIIIlIlIlllllllIlllIl, EnumEnchantmentType.ARMOR_FEET, llllllllllllIIIlIlIlllllllIllIIl);
        this.setName("frostWalker");
    }
    
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIIIlIlIlllllllIIllll) {
        return this.getMinEnchantability(llllllllllllIIIlIlIlllllllIIllll) + 15;
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
}
