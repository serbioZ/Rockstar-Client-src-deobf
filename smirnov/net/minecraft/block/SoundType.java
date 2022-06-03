// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class SoundType
{
    private final /* synthetic */ SoundEvent placeSound;
    private final /* synthetic */ SoundEvent hitSound;
    private final /* synthetic */ SoundEvent stepSound;
    public final /* synthetic */ float pitch;
    private final /* synthetic */ SoundEvent fallSound;
    private final /* synthetic */ SoundEvent breakSound;
    public final /* synthetic */ float volume;
    
    public SoundEvent getStepSound() {
        return this.stepSound;
    }
    
    public float getVolume() {
        return this.volume;
    }
    
    public SoundEvent getBreakSound() {
        return this.breakSound;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public SoundEvent getHitSound() {
        return this.hitSound;
    }
    
    public SoundEvent getFallSound() {
        return this.fallSound;
    }
    
    public SoundEvent getPlaceSound() {
        return this.placeSound;
    }
    
    public SoundType(final float lllllllllllllIIIIlllllIIlllIIlll, final float lllllllllllllIIIIlllllIIlllIIllI, final SoundEvent lllllllllllllIIIIlllllIIlllIIlIl, final SoundEvent lllllllllllllIIIIlllllIIllIlllII, final SoundEvent lllllllllllllIIIIlllllIIllIllIll, final SoundEvent lllllllllllllIIIIlllllIIllIllIlI, final SoundEvent lllllllllllllIIIIlllllIIllIllIIl) {
        this.volume = lllllllllllllIIIIlllllIIlllIIlll;
        this.pitch = lllllllllllllIIIIlllllIIlllIIllI;
        this.breakSound = lllllllllllllIIIIlllllIIlllIIlIl;
        this.stepSound = lllllllllllllIIIIlllllIIllIlllII;
        this.placeSound = lllllllllllllIIIIlllllIIllIllIll;
        this.hitSound = lllllllllllllIIIIlllllIIllIllIlI;
        this.fallSound = lllllllllllllIIIIlllllIIllIllIIl;
    }
    
    static {
        WOOD = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_WOOD_BREAK, SoundEvents.BLOCK_WOOD_STEP, SoundEvents.BLOCK_WOOD_PLACE, SoundEvents.BLOCK_WOOD_HIT, SoundEvents.BLOCK_WOOD_FALL);
        GROUND = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_GRAVEL_BREAK, SoundEvents.BLOCK_GRAVEL_STEP, SoundEvents.BLOCK_GRAVEL_PLACE, SoundEvents.BLOCK_GRAVEL_HIT, SoundEvents.BLOCK_GRAVEL_FALL);
        PLANT = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_GRASS_BREAK, SoundEvents.BLOCK_GRASS_STEP, SoundEvents.BLOCK_GRASS_PLACE, SoundEvents.BLOCK_GRASS_HIT, SoundEvents.BLOCK_GRASS_FALL);
        STONE = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_STONE_BREAK, SoundEvents.BLOCK_STONE_STEP, SoundEvents.BLOCK_STONE_PLACE, SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_STONE_FALL);
        METAL = new SoundType(1.0f, 1.5f, SoundEvents.BLOCK_METAL_BREAK, SoundEvents.BLOCK_METAL_STEP, SoundEvents.BLOCK_METAL_PLACE, SoundEvents.BLOCK_METAL_HIT, SoundEvents.BLOCK_METAL_FALL);
        GLASS = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_GLASS_BREAK, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL);
        CLOTH = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_CLOTH_BREAK, SoundEvents.BLOCK_CLOTH_STEP, SoundEvents.BLOCK_CLOTH_PLACE, SoundEvents.BLOCK_CLOTH_HIT, SoundEvents.BLOCK_CLOTH_FALL);
        SAND = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_SAND_BREAK, SoundEvents.BLOCK_SAND_STEP, SoundEvents.BLOCK_SAND_PLACE, SoundEvents.BLOCK_SAND_HIT, SoundEvents.BLOCK_SAND_FALL);
        SNOW = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_SNOW_BREAK, SoundEvents.BLOCK_SNOW_STEP, SoundEvents.BLOCK_SNOW_PLACE, SoundEvents.BLOCK_SNOW_HIT, SoundEvents.BLOCK_SNOW_FALL);
        LADDER = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_LADDER_BREAK, SoundEvents.BLOCK_LADDER_STEP, SoundEvents.BLOCK_LADDER_PLACE, SoundEvents.BLOCK_LADDER_HIT, SoundEvents.BLOCK_LADDER_FALL);
        ANVIL = new SoundType(0.3f, 1.0f, SoundEvents.BLOCK_ANVIL_BREAK, SoundEvents.BLOCK_ANVIL_STEP, SoundEvents.BLOCK_ANVIL_PLACE, SoundEvents.BLOCK_ANVIL_HIT, SoundEvents.BLOCK_ANVIL_FALL);
        SLIME = new SoundType(1.0f, 1.0f, SoundEvents.BLOCK_SLIME_BREAK, SoundEvents.BLOCK_SLIME_STEP, SoundEvents.BLOCK_SLIME_PLACE, SoundEvents.BLOCK_SLIME_HIT, SoundEvents.BLOCK_SLIME_FALL);
    }
}
