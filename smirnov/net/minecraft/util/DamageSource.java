// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.Explosion;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;

public class DamageSource
{
    private /* synthetic */ boolean difficultyScaled;
    private /* synthetic */ boolean fireDamage;
    public /* synthetic */ String damageType;
    private /* synthetic */ boolean projectile;
    private /* synthetic */ boolean magicDamage;
    private /* synthetic */ boolean isDamageAllowedInCreativeMode;
    private /* synthetic */ boolean explosion;
    private /* synthetic */ boolean isUnblockable;
    private /* synthetic */ float hungerDamage;
    private /* synthetic */ boolean damageIsAbsolute;
    
    public boolean isFireDamage() {
        return this.fireDamage;
    }
    
    protected DamageSource setDamageIsAbsolute() {
        this.damageIsAbsolute = true;
        this.hungerDamage = 0.0f;
        return this;
    }
    
    @Nullable
    public Entity getSourceOfDamage() {
        return this.getEntity();
    }
    
    public static DamageSource causeMobDamage(final EntityLivingBase llllllllllllllllIllIIlIIIllIIlIl) {
        return new EntityDamageSource("mob", llllllllllllllllIllIIlIIIllIIlIl);
    }
    
    protected DamageSource setFireDamage() {
        this.fireDamage = true;
        return this;
    }
    
    public float getHungerDamage() {
        return this.hungerDamage;
    }
    
    public String getDamageType() {
        return this.damageType;
    }
    
    public static DamageSource causeExplosionDamage(@Nullable final EntityLivingBase llllllllllllllllIllIIlIIIIlllIll) {
        return (llllllllllllllllIllIIlIIIIlllIll != null) ? new EntityDamageSource("explosion.player", llllllllllllllllIllIIlIIIIlllIll).setDifficultyScaled().setExplosion() : new DamageSource("explosion").setDifficultyScaled().setExplosion();
    }
    
    public static DamageSource causeFireballDamage(final EntityFireball llllllllllllllllIllIIlIIIlIlIIll, @Nullable final Entity llllllllllllllllIllIIlIIIlIlIIII) {
        return (llllllllllllllllIllIIlIIIlIlIIII == null) ? new EntityDamageSourceIndirect("onFire", llllllllllllllllIllIIlIIIlIlIIll, llllllllllllllllIllIIlIIIlIlIIll).setFireDamage().setProjectile() : new EntityDamageSourceIndirect("fireball", llllllllllllllllIllIIlIIIlIlIIll, llllllllllllllllIllIIlIIIlIlIIII).setFireDamage().setProjectile();
    }
    
    public DamageSource setExplosion() {
        this.explosion = true;
        return this;
    }
    
    public static DamageSource causeIndirectDamage(final Entity llllllllllllllllIllIIlIIIllIIIII, final EntityLivingBase llllllllllllllllIllIIlIIIlIlllll) {
        return new EntityDamageSourceIndirect("mob", llllllllllllllllIllIIlIIIllIIIII, llllllllllllllllIllIIlIIIlIlllll);
    }
    
    public static DamageSource causeExplosionDamage(@Nullable final Explosion llllllllllllllllIllIIlIIIIllllll) {
        return (llllllllllllllllIllIIlIIIIllllll != null && llllllllllllllllIllIIlIIIIllllll.getExplosivePlacedBy() != null) ? new EntityDamageSource("explosion.player", llllllllllllllllIllIIlIIIIllllll.getExplosivePlacedBy()).setDifficultyScaled().setExplosion() : new DamageSource("explosion").setDifficultyScaled().setExplosion();
    }
    
    protected DamageSource setDamageBypassesArmor() {
        this.isUnblockable = true;
        this.hungerDamage = 0.0f;
        return this;
    }
    
    public DamageSource setProjectile() {
        this.projectile = true;
        return this;
    }
    
    public static DamageSource causeIndirectMagicDamage(final Entity llllllllllllllllIllIIlIIIlIIIlIl, @Nullable final Entity llllllllllllllllIllIIlIIIlIIIllI) {
        return new EntityDamageSourceIndirect("indirectMagic", llllllllllllllllIllIIlIIIlIIIlIl, llllllllllllllllIllIIlIIIlIIIllI).setDamageBypassesArmor().setMagicDamage();
    }
    
    public boolean isProjectile() {
        return this.projectile;
    }
    
    public DamageSource setMagicDamage() {
        this.magicDamage = true;
        return this;
    }
    
    public static DamageSource causeThrownDamage(final Entity llllllllllllllllIllIIlIIIlIIllIl, @Nullable final Entity llllllllllllllllIllIIlIIIlIIllII) {
        return new EntityDamageSourceIndirect("thrown", llllllllllllllllIllIIlIIIlIIllIl, llllllllllllllllIllIIlIIIlIIllII).setProjectile();
    }
    
    public boolean isUnblockable() {
        return this.isUnblockable;
    }
    
    protected DamageSource(final String llllllllllllllllIllIIlIIIIIlllIl) {
        this.hungerDamage = 0.1f;
        this.damageType = llllllllllllllllIllIIlIIIIIlllIl;
    }
    
    public DamageSource setDifficultyScaled() {
        this.difficultyScaled = true;
        return this;
    }
    
    public boolean isDamageAbsolute() {
        return this.damageIsAbsolute;
    }
    
    public boolean isExplosion() {
        return this.explosion;
    }
    
    static {
        inFire = new DamageSource("inFire").setFireDamage();
        lightningBolt = new DamageSource("lightningBolt");
        onFire = new DamageSource("onFire").setDamageBypassesArmor().setFireDamage();
        lava = new DamageSource("lava").setFireDamage();
        hotFloor = new DamageSource("hotFloor").setFireDamage();
        inWall = new DamageSource("inWall").setDamageBypassesArmor();
        field_191291_g = new DamageSource("cramming").setDamageBypassesArmor();
        drown = new DamageSource("drown").setDamageBypassesArmor();
        starve = new DamageSource("starve").setDamageBypassesArmor().setDamageIsAbsolute();
        cactus = new DamageSource("cactus");
        fall = new DamageSource("fall").setDamageBypassesArmor();
        flyIntoWall = new DamageSource("flyIntoWall").setDamageBypassesArmor();
        outOfWorld = new DamageSource("outOfWorld").setDamageBypassesArmor().setDamageAllowedInCreativeMode();
        generic = new DamageSource("generic").setDamageBypassesArmor();
        magic = new DamageSource("magic").setDamageBypassesArmor().setMagicDamage();
        wither = new DamageSource("wither").setDamageBypassesArmor();
        anvil = new DamageSource("anvil");
        fallingBlock = new DamageSource("fallingBlock");
        dragonBreath = new DamageSource("dragonBreath").setDamageBypassesArmor();
        field_191552_t = new DamageSource("fireworks").setExplosion();
    }
    
    public static DamageSource causeArrowDamage(final EntityArrow llllllllllllllllIllIIlIIIlIlIlll, @Nullable final Entity llllllllllllllllIllIIlIIIlIllIII) {
        return new EntityDamageSourceIndirect("arrow", llllllllllllllllIllIIlIIIlIlIlll, llllllllllllllllIllIIlIIIlIllIII).setProjectile();
    }
    
    public boolean isDifficultyScaled() {
        return this.difficultyScaled;
    }
    
    protected DamageSource setDamageAllowedInCreativeMode() {
        this.isDamageAllowedInCreativeMode = true;
        return this;
    }
    
    @Nullable
    public Vec3d getDamageLocation() {
        return null;
    }
    
    @Nullable
    public Entity getEntity() {
        return null;
    }
    
    public boolean canHarmInCreative() {
        return this.isDamageAllowedInCreativeMode;
    }
    
    public static DamageSource causePlayerDamage(final EntityPlayer llllllllllllllllIllIIlIIIlIlllII) {
        return new EntityDamageSource("player", llllllllllllllllIllIIlIIIlIlllII);
    }
    
    public boolean isCreativePlayer() {
        final Entity llllllllllllllllIllIIIlllllIlIII = this.getEntity();
        return llllllllllllllllIllIIIlllllIlIII instanceof EntityPlayer && ((EntityPlayer)llllllllllllllllIllIIIlllllIlIII).capabilities.isCreativeMode;
    }
    
    public boolean isMagicDamage() {
        return this.magicDamage;
    }
    
    public ITextComponent getDeathMessage(final EntityLivingBase llllllllllllllllIllIIlIIIIIIIIIl) {
        final EntityLivingBase llllllllllllllllIllIIlIIIIIIIlIl = llllllllllllllllIllIIlIIIIIIIIIl.getAttackingEntity();
        final String llllllllllllllllIllIIlIIIIIIIlII = "death.attack." + this.damageType;
        final String llllllllllllllllIllIIlIIIIIIIIll = String.valueOf(llllllllllllllllIllIIlIIIIIIIlII) + ".player";
        return (llllllllllllllllIllIIlIIIIIIIlIl != null && I18n.canTranslate(llllllllllllllllIllIIlIIIIIIIIll)) ? new TextComponentTranslation(llllllllllllllllIllIIlIIIIIIIIll, new Object[] { llllllllllllllllIllIIlIIIIIIIIIl.getDisplayName(), llllllllllllllllIllIIlIIIIIIIlIl.getDisplayName() }) : new TextComponentTranslation(llllllllllllllllIllIIlIIIIIIIlII, new Object[] { llllllllllllllllIllIIlIIIIIIIIIl.getDisplayName() });
    }
    
    public static DamageSource causeThornsDamage(final Entity llllllllllllllllIllIIlIIIlIIIIlI) {
        return new EntityDamageSource("thorns", llllllllllllllllIllIIlIIIlIIIIlI).setIsThornsDamage().setMagicDamage();
    }
}
