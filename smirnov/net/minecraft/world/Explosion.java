// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.block.state.IBlockState;
import java.util.Set;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import java.util.Collection;
import net.minecraft.block.material.Material;
import com.google.common.collect.Sets;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import java.util.Random;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Map;
import net.minecraft.entity.Entity;

public class Explosion
{
    private final /* synthetic */ double explosionY;
    private final /* synthetic */ double explosionZ;
    private final /* synthetic */ Entity exploder;
    private final /* synthetic */ Map<EntityPlayer, Vec3d> playerKnockbackMap;
    private final /* synthetic */ boolean isSmoking;
    private final /* synthetic */ boolean isFlaming;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ Random explosionRNG;
    private final /* synthetic */ double explosionX;
    private final /* synthetic */ List<BlockPos> affectedBlockPositions;
    private final /* synthetic */ float explosionSize;
    
    public void doExplosionA() {
        final Set<BlockPos> llllllllllIlllIIIlIIIllllIIIlIll = (Set<BlockPos>)Sets.newHashSet();
        final int llllllllllIlllIIIlIIIllllIIIlIlI = 16;
        for (int llllllllllIlllIIIlIIIllllIIIlIIl = 0; llllllllllIlllIIIlIIIllllIIIlIIl < 16; ++llllllllllIlllIIIlIIIllllIIIlIIl) {
            for (int llllllllllIlllIIIlIIIllllIIIlIII = 0; llllllllllIlllIIIlIIIllllIIIlIII < 16; ++llllllllllIlllIIIlIIIllllIIIlIII) {
                for (int llllllllllIlllIIIlIIIllllIIIIlll = 0; llllllllllIlllIIIlIIIllllIIIIlll < 16; ++llllllllllIlllIIIlIIIllllIIIIlll) {
                    if (llllllllllIlllIIIlIIIllllIIIlIIl == 0 || llllllllllIlllIIIlIIIllllIIIlIIl == 15 || llllllllllIlllIIIlIIIllllIIIlIII == 0 || llllllllllIlllIIIlIIIllllIIIlIII == 15 || llllllllllIlllIIIlIIIllllIIIIlll == 0 || llllllllllIlllIIIlIIIllllIIIIlll == 15) {
                        double llllllllllIlllIIIlIIIllllIIIIllI = llllllllllIlllIIIlIIIllllIIIlIIl / 15.0f * 2.0f - 1.0f;
                        double llllllllllIlllIIIlIIIllllIIIIlIl = llllllllllIlllIIIlIIIllllIIIlIII / 15.0f * 2.0f - 1.0f;
                        double llllllllllIlllIIIlIIIllllIIIIlII = llllllllllIlllIIIlIIIllllIIIIlll / 15.0f * 2.0f - 1.0f;
                        final double llllllllllIlllIIIlIIIllllIIIIIll = Math.sqrt(llllllllllIlllIIIlIIIllllIIIIllI * llllllllllIlllIIIlIIIllllIIIIllI + llllllllllIlllIIIlIIIllllIIIIlIl * llllllllllIlllIIIlIIIllllIIIIlIl + llllllllllIlllIIIlIIIllllIIIIlII * llllllllllIlllIIIlIIIllllIIIIlII);
                        llllllllllIlllIIIlIIIllllIIIIllI /= llllllllllIlllIIIlIIIllllIIIIIll;
                        llllllllllIlllIIIlIIIllllIIIIlIl /= llllllllllIlllIIIlIIIllllIIIIIll;
                        llllllllllIlllIIIlIIIllllIIIIlII /= llllllllllIlllIIIlIIIllllIIIIIll;
                        float llllllllllIlllIIIlIIIllllIIIIIlI = this.explosionSize * (0.7f + this.worldObj.rand.nextFloat() * 0.6f);
                        double llllllllllIlllIIIlIIIllllIIIIIIl = this.explosionX;
                        double llllllllllIlllIIIlIIIllllIIIIIII = this.explosionY;
                        double llllllllllIlllIIIlIIIlllIlllllll = this.explosionZ;
                        final float llllllllllIlllIIIlIIIlllIllllllI = 0.3f;
                        while (llllllllllIlllIIIlIIIllllIIIIIlI > 0.0f) {
                            final BlockPos llllllllllIlllIIIlIIIlllIlllllIl = new BlockPos(llllllllllIlllIIIlIIIllllIIIIIIl, llllllllllIlllIIIlIIIllllIIIIIII, llllllllllIlllIIIlIIIlllIlllllll);
                            final IBlockState llllllllllIlllIIIlIIIlllIlllllII = this.worldObj.getBlockState(llllllllllIlllIIIlIIIlllIlllllIl);
                            if (llllllllllIlllIIIlIIIlllIlllllII.getMaterial() != Material.AIR) {
                                final float llllllllllIlllIIIlIIIlllIllllIll = (this.exploder != null) ? this.exploder.getExplosionResistance(this, this.worldObj, llllllllllIlllIIIlIIIlllIlllllIl, llllllllllIlllIIIlIIIlllIlllllII) : llllllllllIlllIIIlIIIlllIlllllII.getBlock().getExplosionResistance(null);
                                llllllllllIlllIIIlIIIllllIIIIIlI -= (llllllllllIlllIIIlIIIlllIllllIll + 0.3f) * 0.3f;
                            }
                            if (llllllllllIlllIIIlIIIllllIIIIIlI > 0.0f && (this.exploder == null || this.exploder.verifyExplosion(this, this.worldObj, llllllllllIlllIIIlIIIlllIlllllIl, llllllllllIlllIIIlIIIlllIlllllII, llllllllllIlllIIIlIIIllllIIIIIlI))) {
                                llllllllllIlllIIIlIIIllllIIIlIll.add(llllllllllIlllIIIlIIIlllIlllllIl);
                            }
                            llllllllllIlllIIIlIIIllllIIIIIIl += llllllllllIlllIIIlIIIllllIIIIllI * 0.30000001192092896;
                            llllllllllIlllIIIlIIIllllIIIIIII += llllllllllIlllIIIlIIIllllIIIIlIl * 0.30000001192092896;
                            llllllllllIlllIIIlIIIlllIlllllll += llllllllllIlllIIIlIIIllllIIIIlII * 0.30000001192092896;
                            llllllllllIlllIIIlIIIllllIIIIIlI -= 0.22500001f;
                        }
                    }
                }
            }
        }
        this.affectedBlockPositions.addAll(llllllllllIlllIIIlIIIllllIIIlIll);
        final float llllllllllIlllIIIlIIIlllIllllIlI = this.explosionSize * 2.0f;
        final int llllllllllIlllIIIlIIIlllIllllIIl = MathHelper.floor(this.explosionX - llllllllllIlllIIIlIIIlllIllllIlI - 1.0);
        final int llllllllllIlllIIIlIIIlllIllllIII = MathHelper.floor(this.explosionX + llllllllllIlllIIIlIIIlllIllllIlI + 1.0);
        final int llllllllllIlllIIIlIIIlllIlllIlll = MathHelper.floor(this.explosionY - llllllllllIlllIIIlIIIlllIllllIlI - 1.0);
        final int llllllllllIlllIIIlIIIlllIlllIllI = MathHelper.floor(this.explosionY + llllllllllIlllIIIlIIIlllIllllIlI + 1.0);
        final int llllllllllIlllIIIlIIIlllIlllIlIl = MathHelper.floor(this.explosionZ - llllllllllIlllIIIlIIIlllIllllIlI - 1.0);
        final int llllllllllIlllIIIlIIIlllIlllIlII = MathHelper.floor(this.explosionZ + llllllllllIlllIIIlIIIlllIllllIlI + 1.0);
        final List<Entity> llllllllllIlllIIIlIIIlllIlllIIll = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.exploder, new AxisAlignedBB(llllllllllIlllIIIlIIIlllIllllIIl, llllllllllIlllIIIlIIIlllIlllIlll, llllllllllIlllIIIlIIIlllIlllIlIl, llllllllllIlllIIIlIIIlllIllllIII, llllllllllIlllIIIlIIIlllIlllIllI, llllllllllIlllIIIlIIIlllIlllIlII));
        final Vec3d llllllllllIlllIIIlIIIlllIlllIIlI = new Vec3d(this.explosionX, this.explosionY, this.explosionZ);
        for (int llllllllllIlllIIIlIIIlllIlllIIIl = 0; llllllllllIlllIIIlIIIlllIlllIIIl < llllllllllIlllIIIlIIIlllIlllIIll.size(); ++llllllllllIlllIIIlIIIlllIlllIIIl) {
            final Entity llllllllllIlllIIIlIIIlllIlllIIII = llllllllllIlllIIIlIIIlllIlllIIll.get(llllllllllIlllIIIlIIIlllIlllIIIl);
            if (!llllllllllIlllIIIlIIIlllIlllIIII.isImmuneToExplosions()) {
                final double llllllllllIlllIIIlIIIlllIllIllll = llllllllllIlllIIIlIIIlllIlllIIII.getDistance(this.explosionX, this.explosionY, this.explosionZ) / llllllllllIlllIIIlIIIlllIllllIlI;
                if (llllllllllIlllIIIlIIIlllIllIllll <= 1.0) {
                    double llllllllllIlllIIIlIIIlllIllIlllI = llllllllllIlllIIIlIIIlllIlllIIII.posX - this.explosionX;
                    double llllllllllIlllIIIlIIIlllIllIllIl = llllllllllIlllIIIlIIIlllIlllIIII.posY + llllllllllIlllIIIlIIIlllIlllIIII.getEyeHeight() - this.explosionY;
                    double llllllllllIlllIIIlIIIlllIllIllII = llllllllllIlllIIIlIIIlllIlllIIII.posZ - this.explosionZ;
                    final double llllllllllIlllIIIlIIIlllIllIlIll = MathHelper.sqrt(llllllllllIlllIIIlIIIlllIllIlllI * llllllllllIlllIIIlIIIlllIllIlllI + llllllllllIlllIIIlIIIlllIllIllIl * llllllllllIlllIIIlIIIlllIllIllIl + llllllllllIlllIIIlIIIlllIllIllII * llllllllllIlllIIIlIIIlllIllIllII);
                    if (llllllllllIlllIIIlIIIlllIllIlIll != 0.0) {
                        llllllllllIlllIIIlIIIlllIllIlllI /= llllllllllIlllIIIlIIIlllIllIlIll;
                        llllllllllIlllIIIlIIIlllIllIllIl /= llllllllllIlllIIIlIIIlllIllIlIll;
                        llllllllllIlllIIIlIIIlllIllIllII /= llllllllllIlllIIIlIIIlllIllIlIll;
                        final double llllllllllIlllIIIlIIIlllIllIlIlI = this.worldObj.getBlockDensity(llllllllllIlllIIIlIIIlllIlllIIlI, llllllllllIlllIIIlIIIlllIlllIIII.getEntityBoundingBox());
                        final double llllllllllIlllIIIlIIIlllIllIlIIl = (1.0 - llllllllllIlllIIIlIIIlllIllIllll) * llllllllllIlllIIIlIIIlllIllIlIlI;
                        llllllllllIlllIIIlIIIlllIlllIIII.attackEntityFrom(DamageSource.causeExplosionDamage(this), (float)(int)((llllllllllIlllIIIlIIIlllIllIlIIl * llllllllllIlllIIIlIIIlllIllIlIIl + llllllllllIlllIIIlIIIlllIllIlIIl) / 2.0 * 7.0 * llllllllllIlllIIIlIIIlllIllllIlI + 1.0));
                        double llllllllllIlllIIIlIIIlllIllIlIII = llllllllllIlllIIIlIIIlllIllIlIIl;
                        if (llllllllllIlllIIIlIIIlllIlllIIII instanceof EntityLivingBase) {
                            llllllllllIlllIIIlIIIlllIllIlIII = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase)llllllllllIlllIIIlIIIlllIlllIIII, llllllllllIlllIIIlIIIlllIllIlIIl);
                        }
                        final Entity entity = llllllllllIlllIIIlIIIlllIlllIIII;
                        entity.motionX += llllllllllIlllIIIlIIIlllIllIlllI * llllllllllIlllIIIlIIIlllIllIlIII;
                        final Entity entity2 = llllllllllIlllIIIlIIIlllIlllIIII;
                        entity2.motionY += llllllllllIlllIIIlIIIlllIllIllIl * llllllllllIlllIIIlIIIlllIllIlIII;
                        final Entity entity3 = llllllllllIlllIIIlIIIlllIlllIIII;
                        entity3.motionZ += llllllllllIlllIIIlIIIlllIllIllII * llllllllllIlllIIIlIIIlllIllIlIII;
                        if (llllllllllIlllIIIlIIIlllIlllIIII instanceof EntityPlayer) {
                            final EntityPlayer llllllllllIlllIIIlIIIlllIllIIlll = (EntityPlayer)llllllllllIlllIIIlIIIlllIlllIIII;
                            if (!llllllllllIlllIIIlIIIlllIllIIlll.isSpectator() && (!llllllllllIlllIIIlIIIlllIllIIlll.isCreative() || !llllllllllIlllIIIlIIIlllIllIIlll.capabilities.isFlying)) {
                                this.playerKnockbackMap.put(llllllllllIlllIIIlIIIlllIllIIlll, new Vec3d(llllllllllIlllIIIlIIIlllIllIlllI * llllllllllIlllIIIlIIIlllIllIlIIl, llllllllllIlllIIIlIIIlllIllIllIl * llllllllllIlllIIIlIIIlllIllIlIIl, llllllllllIlllIIIlIIIlllIllIllII * llllllllllIlllIIIlIIIlllIllIlIIl));
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Nullable
    public EntityLivingBase getExplosivePlacedBy() {
        if (this.exploder == null) {
            return null;
        }
        if (this.exploder instanceof EntityTNTPrimed) {
            return ((EntityTNTPrimed)this.exploder).getTntPlacedBy();
        }
        return (this.exploder instanceof EntityLivingBase) ? ((EntityLivingBase)this.exploder) : null;
    }
    
    public Explosion(final World llllllllllIlllIIIlIIIllllIllIIII, final Entity llllllllllIlllIIIlIIIllllIlIllll, final double llllllllllIlllIIIlIIIllllIllIlll, final double llllllllllIlllIIIlIIIllllIlIllIl, final double llllllllllIlllIIIlIIIllllIlIllII, final float llllllllllIlllIIIlIIIllllIllIlII, final boolean llllllllllIlllIIIlIIIllllIlIlIlI, final boolean llllllllllIlllIIIlIIIllllIlIlIIl) {
        this.explosionRNG = new Random();
        this.affectedBlockPositions = (List<BlockPos>)Lists.newArrayList();
        this.playerKnockbackMap = (Map<EntityPlayer, Vec3d>)Maps.newHashMap();
        this.worldObj = llllllllllIlllIIIlIIIllllIllIIII;
        this.exploder = llllllllllIlllIIIlIIIllllIlIllll;
        this.explosionSize = llllllllllIlllIIIlIIIllllIllIlII;
        this.explosionX = llllllllllIlllIIIlIIIllllIllIlll;
        this.explosionY = llllllllllIlllIIIlIIIllllIlIllIl;
        this.explosionZ = llllllllllIlllIIIlIIIllllIlIllII;
        this.isFlaming = llllllllllIlllIIIlIIIllllIlIlIlI;
        this.isSmoking = llllllllllIlllIIIlIIIllllIlIlIIl;
    }
    
    public Explosion(final World llllllllllIlllIIIlIIIllllllIlIII, final Entity llllllllllIlllIIIlIIIllllllIIlll, final double llllllllllIlllIIIlIIIllllllIlllI, final double llllllllllIlllIIIlIIIllllllIIlIl, final double llllllllllIlllIIIlIIIllllllIIlII, final float llllllllllIlllIIIlIIIllllllIIIll, final List<BlockPos> llllllllllIlllIIIlIIIllllllIIIlI) {
        this(llllllllllIlllIIIlIIIllllllIlIII, llllllllllIlllIIIlIIIllllllIIlll, llllllllllIlllIIIlIIIllllllIlllI, llllllllllIlllIIIlIIIllllllIIlIl, llllllllllIlllIIIlIIIllllllIIlII, llllllllllIlllIIIlIIIllllllIIIll, false, true, llllllllllIlllIIIlIIIllllllIIIlI);
    }
    
    public void clearAffectedBlockPositions() {
        this.affectedBlockPositions.clear();
    }
    
    public void doExplosionB(final boolean llllllllllIlllIIIlIIIlllIIlIllIl) {
        this.worldObj.playSound(null, this.explosionX, this.explosionY, this.explosionZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
        if (this.explosionSize >= 2.0f && this.isSmoking) {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.explosionX, this.explosionY, this.explosionZ, 1.0, 0.0, 0.0, new int[0]);
        }
        else {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.explosionX, this.explosionY, this.explosionZ, 1.0, 0.0, 0.0, new int[0]);
        }
        if (this.isSmoking) {
            for (final BlockPos llllllllllIlllIIIlIIIlllIIlllIlI : this.affectedBlockPositions) {
                final IBlockState llllllllllIlllIIIlIIIlllIIlllIIl = this.worldObj.getBlockState(llllllllllIlllIIIlIIIlllIIlllIlI);
                final Block llllllllllIlllIIIlIIIlllIIlllIII = llllllllllIlllIIIlIIIlllIIlllIIl.getBlock();
                if (llllllllllIlllIIIlIIIlllIIlIllIl) {
                    final double llllllllllIlllIIIlIIIlllIIllIlll = llllllllllIlllIIIlIIIlllIIlllIlI.getX() + this.worldObj.rand.nextFloat();
                    final double llllllllllIlllIIIlIIIlllIIllIllI = llllllllllIlllIIIlIIIlllIIlllIlI.getY() + this.worldObj.rand.nextFloat();
                    final double llllllllllIlllIIIlIIIlllIIllIlIl = llllllllllIlllIIIlIIIlllIIlllIlI.getZ() + this.worldObj.rand.nextFloat();
                    double llllllllllIlllIIIlIIIlllIIllIlII = llllllllllIlllIIIlIIIlllIIllIlll - this.explosionX;
                    double llllllllllIlllIIIlIIIlllIIllIIll = llllllllllIlllIIIlIIIlllIIllIllI - this.explosionY;
                    double llllllllllIlllIIIlIIIlllIIllIIlI = llllllllllIlllIIIlIIIlllIIllIlIl - this.explosionZ;
                    final double llllllllllIlllIIIlIIIlllIIllIIIl = MathHelper.sqrt(llllllllllIlllIIIlIIIlllIIllIlII * llllllllllIlllIIIlIIIlllIIllIlII + llllllllllIlllIIIlIIIlllIIllIIll * llllllllllIlllIIIlIIIlllIIllIIll + llllllllllIlllIIIlIIIlllIIllIIlI * llllllllllIlllIIIlIIIlllIIllIIlI);
                    llllllllllIlllIIIlIIIlllIIllIlII /= llllllllllIlllIIIlIIIlllIIllIIIl;
                    llllllllllIlllIIIlIIIlllIIllIIll /= llllllllllIlllIIIlIIIlllIIllIIIl;
                    llllllllllIlllIIIlIIIlllIIllIIlI /= llllllllllIlllIIIlIIIlllIIllIIIl;
                    double llllllllllIlllIIIlIIIlllIIllIIII = 0.5 / (llllllllllIlllIIIlIIIlllIIllIIIl / this.explosionSize + 0.1);
                    llllllllllIlllIIIlIIIlllIIllIIII *= this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3f;
                    llllllllllIlllIIIlIIIlllIIllIlII *= llllllllllIlllIIIlIIIlllIIllIIII;
                    llllllllllIlllIIIlIIIlllIIllIIll *= llllllllllIlllIIIlIIIlllIIllIIII;
                    llllllllllIlllIIIlIIIlllIIllIIlI *= llllllllllIlllIIIlIIIlllIIllIIII;
                    this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (llllllllllIlllIIIlIIIlllIIllIlll + this.explosionX) / 2.0, (llllllllllIlllIIIlIIIlllIIllIllI + this.explosionY) / 2.0, (llllllllllIlllIIIlIIIlllIIllIlIl + this.explosionZ) / 2.0, llllllllllIlllIIIlIIIlllIIllIlII, llllllllllIlllIIIlIIIlllIIllIIll, llllllllllIlllIIIlIIIlllIIllIIlI, new int[0]);
                    this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllIlllIIIlIIIlllIIllIlll, llllllllllIlllIIIlIIIlllIIllIllI, llllllllllIlllIIIlIIIlllIIllIlIl, llllllllllIlllIIIlIIIlllIIllIlII, llllllllllIlllIIIlIIIlllIIllIIll, llllllllllIlllIIIlIIIlllIIllIIlI, new int[0]);
                }
                if (llllllllllIlllIIIlIIIlllIIlllIIl.getMaterial() != Material.AIR) {
                    if (llllllllllIlllIIIlIIIlllIIlllIII.canDropFromExplosion(this)) {
                        llllllllllIlllIIIlIIIlllIIlllIII.dropBlockAsItemWithChance(this.worldObj, llllllllllIlllIIIlIIIlllIIlllIlI, this.worldObj.getBlockState(llllllllllIlllIIIlIIIlllIIlllIlI), 1.0f / this.explosionSize, 0);
                    }
                    this.worldObj.setBlockState(llllllllllIlllIIIlIIIlllIIlllIlI, Blocks.AIR.getDefaultState(), 3);
                    llllllllllIlllIIIlIIIlllIIlllIII.onBlockDestroyedByExplosion(this.worldObj, llllllllllIlllIIIlIIIlllIIlllIlI, this);
                }
            }
        }
        if (this.isFlaming) {
            for (final BlockPos llllllllllIlllIIIlIIIlllIIlIllll : this.affectedBlockPositions) {
                if (this.worldObj.getBlockState(llllllllllIlllIIIlIIIlllIIlIllll).getMaterial() == Material.AIR && this.worldObj.getBlockState(llllllllllIlllIIIlIIIlllIIlIllll.down()).isFullBlock() && this.explosionRNG.nextInt(3) == 0) {
                    this.worldObj.setBlockState(llllllllllIlllIIIlIIIlllIIlIllll, Blocks.FIRE.getDefaultState());
                }
            }
        }
    }
    
    public List<BlockPos> getAffectedBlockPositions() {
        return this.affectedBlockPositions;
    }
    
    public Map<EntityPlayer, Vec3d> getPlayerKnockbackMap() {
        return this.playerKnockbackMap;
    }
    
    public Explosion(final World llllllllllIlllIIIlIIIlllllIIllII, final Entity llllllllllIlllIIIlIIIlllllIlIlIl, final double llllllllllIlllIIIlIIIlllllIIlIlI, final double llllllllllIlllIIIlIIIlllllIIlIIl, final double llllllllllIlllIIIlIIIlllllIIlIII, final float llllllllllIlllIIIlIIIlllllIlIIIl, final boolean llllllllllIlllIIIlIIIlllllIlIIII, final boolean llllllllllIlllIIIlIIIlllllIIIlIl, final List<BlockPos> llllllllllIlllIIIlIIIlllllIIlllI) {
        this(llllllllllIlllIIIlIIIlllllIIllII, llllllllllIlllIIIlIIIlllllIlIlIl, llllllllllIlllIIIlIIIlllllIIlIlI, llllllllllIlllIIIlIIIlllllIIlIIl, llllllllllIlllIIIlIIIlllllIIlIII, llllllllllIlllIIIlIIIlllllIlIIIl, llllllllllIlllIIIlIIIlllllIlIIII, llllllllllIlllIIIlIIIlllllIIIlIl);
        this.affectedBlockPositions.addAll(llllllllllIlllIIIlIIIlllllIIlllI);
    }
}
