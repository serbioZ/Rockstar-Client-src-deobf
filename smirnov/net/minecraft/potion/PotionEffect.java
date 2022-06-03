// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import net.minecraft.entity.EntityLivingBase;
import com.google.common.collect.ComparisonChain;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PotionEffect implements Comparable<PotionEffect>
{
    public /* synthetic */ int amplifier;
    public /* synthetic */ boolean isAmbient;
    public /* synthetic */ boolean isPotionDurationMax;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Potion potion;
    public /* synthetic */ int duration;
    public /* synthetic */ boolean showParticles;
    public /* synthetic */ boolean isSplashPotion;
    
    public String getEffectName() {
        return this.potion.getName();
    }
    
    public void setPotionDurationMax(final boolean llllllllllllIIIlIlIIlIlIlIlIlIlI) {
        this.isPotionDurationMax = llllllllllllIIIlIlIIlIlIlIlIlIlI;
    }
    
    public PotionEffect(final Potion llllllllllllIIIlIlIIlIllIIlIIllI, final int llllllllllllIIIlIlIIlIllIIlIIlIl, final int llllllllllllIIIlIlIIlIllIIlIIIII) {
        this(llllllllllllIIIlIlIIlIllIIlIIllI, llllllllllllIIIlIlIIlIllIIlIIlIl, llllllllllllIIIlIlIIlIllIIlIIIII, false, true);
    }
    
    public PotionEffect(final Potion llllllllllllIIIlIlIIlIllIIllIlIl) {
        this(llllllllllllIIIlIlIIlIllIIllIlIl, 0, 0);
    }
    
    public boolean getIsPotionDurationMax() {
        return this.isPotionDurationMax;
    }
    
    public PotionEffect(final Potion llllllllllllIIIlIlIIlIllIIlIllIl, final int llllllllllllIIIlIlIIlIllIIlIllII) {
        this(llllllllllllIIIlIlIIlIllIIlIllIl, llllllllllllIIIlIlIIlIllIIlIllII, 0);
    }
    
    public boolean getIsAmbient() {
        return this.isAmbient;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public boolean doesShowParticles() {
        return this.showParticles;
    }
    
    public Potion getPotion() {
        return this.potion;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllIIIlIlIIlIlIllIIllIl = this.potion.hashCode();
        llllllllllllIIIlIlIIlIlIllIIllIl = 31 * llllllllllllIIIlIlIIlIlIllIIllIl + this.duration;
        llllllllllllIIIlIlIIlIlIllIIllIl = 31 * llllllllllllIIIlIlIIlIlIllIIllIl + this.amplifier;
        llllllllllllIIIlIlIIlIlIllIIllIl = 31 * llllllllllllIIIlIlIIlIlIllIIllIl + (this.isSplashPotion ? 1 : 0);
        llllllllllllIIIlIlIIlIlIllIIllIl = 31 * llllllllllllIIIlIlIIlIlIllIIllIl + (this.isAmbient ? 1 : 0);
        return llllllllllllIIIlIlIIlIlIllIIllIl;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    @Override
    public boolean equals(final Object llllllllllllIIIlIlIIlIlIllIlIIlI) {
        if (this == llllllllllllIIIlIlIIlIlIllIlIIlI) {
            return true;
        }
        if (!(llllllllllllIIIlIlIIlIlIllIlIIlI instanceof PotionEffect)) {
            return false;
        }
        final PotionEffect llllllllllllIIIlIlIIlIlIllIlIlII = (PotionEffect)llllllllllllIIIlIlIIlIlIllIlIIlI;
        return this.duration == llllllllllllIIIlIlIIlIlIllIlIlII.duration && this.amplifier == llllllllllllIIIlIlIIlIlIllIlIlII.amplifier && this.isSplashPotion == llllllllllllIIIlIlIIlIlIllIlIlII.isSplashPotion && this.isAmbient == llllllllllllIIIlIlIIlIlIllIlIlII.isAmbient && this.potion.equals(llllllllllllIIIlIlIIlIlIllIlIlII.potion);
    }
    
    public static PotionEffect readCustomPotionEffectFromNBT(final NBTTagCompound llllllllllllIIIlIlIIlIlIlIllllIl) {
        final int llllllllllllIIIlIlIIlIlIlIllllII = llllllllllllIIIlIlIIlIlIlIllllIl.getByte("Id");
        final Potion llllllllllllIIIlIlIIlIlIlIlllIll = Potion.getPotionById(llllllllllllIIIlIlIIlIlIlIllllII);
        if (llllllllllllIIIlIlIIlIlIlIlllIll == null) {
            return null;
        }
        final int llllllllllllIIIlIlIIlIlIlIlllIlI = llllllllllllIIIlIlIIlIlIlIllllIl.getByte("Amplifier");
        final int llllllllllllIIIlIlIIlIlIlIlllIIl = llllllllllllIIIlIlIIlIlIlIllllIl.getInteger("Duration");
        final boolean llllllllllllIIIlIlIIlIlIlIlllIII = llllllllllllIIIlIlIIlIlIlIllllIl.getBoolean("Ambient");
        boolean llllllllllllIIIlIlIIlIlIlIllIlll = true;
        if (llllllllllllIIIlIlIIlIlIlIllllIl.hasKey("ShowParticles", 1)) {
            llllllllllllIIIlIlIIlIlIlIllIlll = llllllllllllIIIlIlIIlIlIlIllllIl.getBoolean("ShowParticles");
        }
        return new PotionEffect(llllllllllllIIIlIlIIlIlIlIlllIll, llllllllllllIIIlIlIIlIlIlIlllIIl, (llllllllllllIIIlIlIIlIlIlIlllIlI < 0) ? 0 : llllllllllllIIIlIlIIlIlIlIlllIlI, llllllllllllIIIlIlIIlIlIlIlllIII, llllllllllllIIIlIlIIlIlIlIllIlll);
    }
    
    @Override
    public String toString() {
        String llllllllllllIIIlIlIIlIlIllIlllII = null;
        if (this.amplifier > 0) {
            final String llllllllllllIIIlIlIIlIlIllIlllIl = String.valueOf(this.getEffectName()) + " x " + (this.amplifier + 1) + ", Duration: " + this.duration;
        }
        else {
            llllllllllllIIIlIlIIlIlIllIlllII = String.valueOf(this.getEffectName()) + ", Duration: " + this.duration;
        }
        if (this.isSplashPotion) {
            llllllllllllIIIlIlIIlIlIllIlllII = String.valueOf(llllllllllllIIIlIlIIlIlIllIlllII) + ", Splash: true";
        }
        if (!this.showParticles) {
            llllllllllllIIIlIlIIlIlIllIlllII = String.valueOf(llllllllllllIIIlIlIIlIlIllIlllII) + ", Particles: false";
        }
        return llllllllllllIIIlIlIIlIlIllIlllII;
    }
    
    public NBTTagCompound writeCustomPotionEffectToNBT(final NBTTagCompound llllllllllllIIIlIlIIlIlIllIIIlIl) {
        llllllllllllIIIlIlIIlIlIllIIIlIl.setByte("Id", (byte)Potion.getIdFromPotion(this.getPotion()));
        llllllllllllIIIlIlIIlIlIllIIIlIl.setByte("Amplifier", (byte)this.getAmplifier());
        llllllllllllIIIlIlIIlIlIllIIIlIl.setInteger("Duration", this.getDuration());
        llllllllllllIIIlIlIIlIlIllIIIlIl.setBoolean("Ambient", this.getIsAmbient());
        llllllllllllIIIlIlIIlIlIllIIIlIl.setBoolean("ShowParticles", this.doesShowParticles());
        return llllllllllllIIIlIlIIlIlIllIIIlIl;
    }
    
    @Override
    public int compareTo(final PotionEffect llllllllllllIIIlIlIIlIlIlIIlllll) {
        final int llllllllllllIIIlIlIIlIlIlIlIIIIl = 32147;
        return ((this.getDuration() <= 32147 || llllllllllllIIIlIlIIlIlIlIIlllll.getDuration() <= 32147) && (!this.getIsAmbient() || !llllllllllllIIIlIlIIlIlIlIIlllll.getIsAmbient())) ? ComparisonChain.start().compare(Boolean.valueOf(this.getIsAmbient()), Boolean.valueOf(llllllllllllIIIlIlIIlIlIlIIlllll.getIsAmbient())).compare(this.getDuration(), llllllllllllIIIlIlIIlIlIlIIlllll.getDuration()).compare(this.getPotion().getLiquidColor(), llllllllllllIIIlIlIIlIlIlIIlllll.getPotion().getLiquidColor()).result() : ComparisonChain.start().compare(Boolean.valueOf(this.getIsAmbient()), Boolean.valueOf(llllllllllllIIIlIlIIlIlIlIIlllll.getIsAmbient())).compare(this.getPotion().getLiquidColor(), llllllllllllIIIlIlIIlIlIlIIlllll.getPotion().getLiquidColor()).result();
    }
    
    public void performEffect(final EntityLivingBase llllllllllllIIIlIlIIlIlIlllIIlII) {
        if (this.duration > 0) {
            this.potion.performEffect(llllllllllllIIIlIlIIlIlIlllIIlII, this.amplifier);
        }
    }
    
    public PotionEffect(final Potion llllllllllllIIIlIlIIlIllIIIlIIlI, final int llllllllllllIIIlIlIIlIllIIIlIlll, final int llllllllllllIIIlIlIIlIllIIIlIIII, final boolean llllllllllllIIIlIlIIlIllIIIlIlIl, final boolean llllllllllllIIIlIlIIlIllIIIIlllI) {
        this.potion = llllllllllllIIIlIlIIlIllIIIlIIlI;
        this.duration = llllllllllllIIIlIlIIlIllIIIlIlll;
        this.amplifier = llllllllllllIIIlIlIIlIllIIIlIIII;
        this.isAmbient = llllllllllllIIIlIlIIlIllIIIlIlIl;
        this.showParticles = llllllllllllIIIlIlIIlIllIIIIlllI;
    }
    
    public boolean onUpdate(final EntityLivingBase llllllllllllIIIlIlIIlIlIlllIllIl) {
        if (this.duration > 0) {
            if (this.potion.isReady(this.duration, this.amplifier)) {
                this.performEffect(llllllllllllIIIlIlIIlIlIlllIllIl);
            }
            this.deincrementDuration();
        }
        return this.duration > 0;
    }
    
    public int getAmplifier() {
        return this.amplifier;
    }
    
    public PotionEffect(final PotionEffect llllllllllllIIIlIlIIlIllIIIIlIII) {
        this.potion = llllllllllllIIIlIlIIlIllIIIIlIII.potion;
        this.duration = llllllllllllIIIlIlIIlIllIIIIlIII.duration;
        this.amplifier = llllllllllllIIIlIlIIlIllIIIIlIII.amplifier;
        this.isAmbient = llllllllllllIIIlIlIIlIllIIIIlIII.isAmbient;
        this.showParticles = llllllllllllIIIlIlIIlIllIIIIlIII.showParticles;
    }
    
    public void combine(final PotionEffect llllllllllllIIIlIlIIlIllIIIIIlII) {
        if (this.potion != llllllllllllIIIlIlIIlIllIIIIIlII.potion) {
            PotionEffect.LOGGER.warn("This method should only be called for matching effects!");
        }
        if (llllllllllllIIIlIlIIlIllIIIIIlII.amplifier > this.amplifier) {
            this.amplifier = llllllllllllIIIlIlIIlIllIIIIIlII.amplifier;
            this.duration = llllllllllllIIIlIlIIlIllIIIIIlII.duration;
        }
        else if (llllllllllllIIIlIlIIlIllIIIIIlII.amplifier == this.amplifier && this.duration < llllllllllllIIIlIlIIlIllIIIIIlII.duration) {
            this.duration = llllllllllllIIIlIlIIlIllIIIIIlII.duration;
        }
        else if (!llllllllllllIIIlIlIIlIllIIIIIlII.isAmbient && this.isAmbient) {
            this.isAmbient = llllllllllllIIIlIlIIlIllIIIIIlII.isAmbient;
        }
        this.showParticles = llllllllllllIIIlIlIIlIllIIIIIlII.showParticles;
    }
    
    private int deincrementDuration() {
        final int duration = this.duration - 1;
        this.duration = duration;
        return duration;
    }
}
