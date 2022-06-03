// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.util.math.MathHelper;
import javax.annotation.concurrent.Immutable;

@Immutable
public class DifficultyInstance
{
    private final /* synthetic */ EnumDifficulty worldDifficulty;
    private final /* synthetic */ float additionalDifficulty;
    
    public float getAdditionalDifficulty() {
        return this.additionalDifficulty;
    }
    
    public float getClampedAdditionalDifficulty() {
        if (this.additionalDifficulty < 2.0f) {
            return 0.0f;
        }
        return (this.additionalDifficulty > 4.0f) ? 1.0f : ((this.additionalDifficulty - 2.0f) / 2.0f);
    }
    
    public boolean func_193845_a(final float lllllllllllIIlIIllIIIlIlllIIIIll) {
        return this.additionalDifficulty > lllllllllllIIlIIllIIIlIlllIIIIll;
    }
    
    private float calculateAdditionalDifficulty(final EnumDifficulty lllllllllllIIlIIllIIIlIllIllIllI, final long lllllllllllIIlIIllIIIlIllIllIlIl, final long lllllllllllIIlIIllIIIlIllIlIllII, final float lllllllllllIIlIIllIIIlIllIllIIll) {
        if (lllllllllllIIlIIllIIIlIllIllIllI == EnumDifficulty.PEACEFUL) {
            return 0.0f;
        }
        final boolean lllllllllllIIlIIllIIIlIllIllIIlI = lllllllllllIIlIIllIIIlIllIllIllI == EnumDifficulty.HARD;
        float lllllllllllIIlIIllIIIlIllIllIIIl = 0.75f;
        final float lllllllllllIIlIIllIIIlIllIllIIII = MathHelper.clamp((lllllllllllIIlIIllIIIlIllIllIlIl - 72000.0f) / 1440000.0f, 0.0f, 1.0f) * 0.25f;
        lllllllllllIIlIIllIIIlIllIllIIIl += lllllllllllIIlIIllIIIlIllIllIIII;
        float lllllllllllIIlIIllIIIlIllIlIllll = 0.0f;
        lllllllllllIIlIIllIIIlIllIlIllll += MathHelper.clamp(lllllllllllIIlIIllIIIlIllIlIllII / 3600000.0f, 0.0f, 1.0f) * (lllllllllllIIlIIllIIIlIllIllIIlI ? 1.0f : 0.75f);
        lllllllllllIIlIIllIIIlIllIlIllll += MathHelper.clamp(lllllllllllIIlIIllIIIlIllIllIIll * 0.25f, 0.0f, lllllllllllIIlIIllIIIlIllIllIIII);
        if (lllllllllllIIlIIllIIIlIllIllIllI == EnumDifficulty.EASY) {
            lllllllllllIIlIIllIIIlIllIlIllll *= 0.5f;
        }
        lllllllllllIIlIIllIIIlIllIllIIIl += lllllllllllIIlIIllIIIlIllIlIllll;
        return lllllllllllIIlIIllIIIlIllIllIllI.getDifficultyId() * lllllllllllIIlIIllIIIlIllIllIIIl;
    }
    
    public DifficultyInstance(final EnumDifficulty lllllllllllIIlIIllIIIlIlllIIllll, final long lllllllllllIIlIIllIIIlIlllIIlllI, final long lllllllllllIIlIIllIIIlIlllIlIIlI, final float lllllllllllIIlIIllIIIlIlllIlIIIl) {
        this.worldDifficulty = lllllllllllIIlIIllIIIlIlllIIllll;
        this.additionalDifficulty = this.calculateAdditionalDifficulty(lllllllllllIIlIIllIIIlIlllIIllll, lllllllllllIIlIIllIIIlIlllIIlllI, lllllllllllIIlIIllIIIlIlllIlIIlI, lllllllllllIIlIIllIIIlIlllIlIIIl);
    }
}
