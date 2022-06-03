// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.player.EntityPlayer;

public class FoodStats
{
    private /* synthetic */ int foodTimer;
    private /* synthetic */ int prevFoodLevel;
    private /* synthetic */ int foodLevel;
    private /* synthetic */ float foodExhaustionLevel;
    private /* synthetic */ float foodSaturationLevel;
    
    public void addStats(final int lllllllllllllllIIIlIllIIlIlllIIl, final float lllllllllllllllIIIlIllIIlIlllIII) {
        this.foodLevel = Math.min(lllllllllllllllIIIlIllIIlIlllIIl + this.foodLevel, 20);
        this.foodSaturationLevel = Math.min(this.foodSaturationLevel + lllllllllllllllIIIlIllIIlIlllIIl * lllllllllllllllIIIlIllIIlIlllIII * 2.0f, (float)this.foodLevel);
    }
    
    public void onUpdate(final EntityPlayer lllllllllllllllIIIlIllIIlIlIIIll) {
        final EnumDifficulty lllllllllllllllIIIlIllIIlIlIIlll = lllllllllllllllIIIlIllIIlIlIIIll.world.getDifficulty();
        this.prevFoodLevel = this.foodLevel;
        if (this.foodExhaustionLevel > 4.0f) {
            this.foodExhaustionLevel -= 4.0f;
            if (this.foodSaturationLevel > 0.0f) {
                this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0f, 0.0f);
            }
            else if (lllllllllllllllIIIlIllIIlIlIIlll != EnumDifficulty.PEACEFUL) {
                this.foodLevel = Math.max(this.foodLevel - 1, 0);
            }
        }
        final boolean lllllllllllllllIIIlIllIIlIlIIllI = lllllllllllllllIIIlIllIIlIlIIIll.world.getGameRules().getBoolean("naturalRegeneration");
        if (lllllllllllllllIIIlIllIIlIlIIllI && this.foodSaturationLevel > 0.0f && lllllllllllllllIIIlIllIIlIlIIIll.shouldHeal() && this.foodLevel >= 20) {
            ++this.foodTimer;
            if (this.foodTimer >= 10) {
                final float lllllllllllllllIIIlIllIIlIlIIlIl = Math.min(this.foodSaturationLevel, 6.0f);
                lllllllllllllllIIIlIllIIlIlIIIll.heal(lllllllllllllllIIIlIllIIlIlIIlIl / 6.0f);
                this.addExhaustion(lllllllllllllllIIIlIllIIlIlIIlIl);
                this.foodTimer = 0;
            }
        }
        else if (lllllllllllllllIIIlIllIIlIlIIllI && this.foodLevel >= 18 && lllllllllllllllIIIlIllIIlIlIIIll.shouldHeal()) {
            ++this.foodTimer;
            if (this.foodTimer >= 80) {
                lllllllllllllllIIIlIllIIlIlIIIll.heal(1.0f);
                this.addExhaustion(6.0f);
                this.foodTimer = 0;
            }
        }
        else if (this.foodLevel <= 0) {
            ++this.foodTimer;
            if (this.foodTimer >= 80) {
                if (lllllllllllllllIIIlIllIIlIlIIIll.getHealth() > 10.0f || lllllllllllllllIIIlIllIIlIlIIlll == EnumDifficulty.HARD || (lllllllllllllllIIIlIllIIlIlIIIll.getHealth() > 1.0f && lllllllllllllllIIIlIllIIlIlIIlll == EnumDifficulty.NORMAL)) {
                    lllllllllllllllIIIlIllIIlIlIIIll.attackEntityFrom(DamageSource.starve, 1.0f);
                }
                this.foodTimer = 0;
            }
        }
        else {
            this.foodTimer = 0;
        }
    }
    
    public FoodStats() {
        this.foodLevel = 20;
        this.foodSaturationLevel = 5.0f;
        this.prevFoodLevel = 20;
    }
    
    public void setFoodSaturationLevel(final float lllllllllllllllIIIlIllIIIllllIll) {
        this.foodSaturationLevel = lllllllllllllllIIIlIllIIIllllIll;
    }
    
    public void setFoodLevel(final int lllllllllllllllIIIlIllIIlIIIIIIl) {
        this.foodLevel = lllllllllllllllIIIlIllIIlIIIIIIl;
    }
    
    public boolean needFood() {
        return this.foodLevel < 20;
    }
    
    public float getSaturationLevel() {
        return this.foodSaturationLevel;
    }
    
    public void writeNBT(final NBTTagCompound lllllllllllllllIIIlIllIIlIIlIllI) {
        lllllllllllllllIIIlIllIIlIIlIllI.setInteger("foodLevel", this.foodLevel);
        lllllllllllllllIIIlIllIIlIIlIllI.setInteger("foodTickTimer", this.foodTimer);
        lllllllllllllllIIIlIllIIlIIlIllI.setFloat("foodSaturationLevel", this.foodSaturationLevel);
        lllllllllllllllIIIlIllIIlIIlIllI.setFloat("foodExhaustionLevel", this.foodExhaustionLevel);
    }
    
    public void readNBT(final NBTTagCompound lllllllllllllllIIIlIllIIlIIlllII) {
        if (lllllllllllllllIIIlIllIIlIIlllII.hasKey("foodLevel", 99)) {
            this.foodLevel = lllllllllllllllIIIlIllIIlIIlllII.getInteger("foodLevel");
            this.foodTimer = lllllllllllllllIIIlIllIIlIIlllII.getInteger("foodTickTimer");
            this.foodSaturationLevel = lllllllllllllllIIIlIllIIlIIlllII.getFloat("foodSaturationLevel");
            this.foodExhaustionLevel = lllllllllllllllIIIlIllIIlIIlllII.getFloat("foodExhaustionLevel");
        }
    }
    
    public void addStats(final ItemFood lllllllllllllllIIIlIllIIlIllIIII, final ItemStack lllllllllllllllIIIlIllIIlIllIIlI) {
        this.addStats(lllllllllllllllIIIlIllIIlIllIIII.getHealAmount(lllllllllllllllIIIlIllIIlIllIIlI), lllllllllllllllIIIlIllIIlIllIIII.getSaturationModifier(lllllllllllllllIIIlIllIIlIllIIlI));
    }
    
    public int getFoodLevel() {
        return this.foodLevel;
    }
    
    public void addExhaustion(final float lllllllllllllllIIIlIllIIlIIIlIlI) {
        this.foodExhaustionLevel = Math.min(this.foodExhaustionLevel + lllllllllllllllIIIlIllIIlIIIlIlI, 40.0f);
    }
}
