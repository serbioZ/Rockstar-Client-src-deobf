// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import javax.annotation.Nullable;

public class BiomeProviderSingle extends BiomeProvider
{
    private final /* synthetic */ Biome biome;
    
    @Override
    public Biome[] getBiomes(@Nullable Biome[] llllllllllllIlIllIIIlllIIIIIllll, final int llllllllllllIlIllIIIlllIIIIlIlII, final int llllllllllllIlIllIIIlllIIIIlIIll, final int llllllllllllIlIllIIIlllIIIIlIIlI, final int llllllllllllIlIllIIIlllIIIIlIIIl) {
        if (llllllllllllIlIllIIIlllIIIIIllll == null || llllllllllllIlIllIIIlllIIIIIllll.length < llllllllllllIlIllIIIlllIIIIlIIlI * llllllllllllIlIllIIIlllIIIIlIIIl) {
            llllllllllllIlIllIIIlllIIIIIllll = new Biome[llllllllllllIlIllIIIlllIIIIlIIlI * llllllllllllIlIllIIIlllIIIIlIIIl];
        }
        Arrays.fill(llllllllllllIlIllIIIlllIIIIIllll, 0, llllllllllllIlIllIIIlllIIIIlIIlI * llllllllllllIlIllIIIlllIIIIlIIIl, this.biome);
        return llllllllllllIlIllIIIlllIIIIIllll;
    }
    
    public BiomeProviderSingle(final Biome llllllllllllIlIllIIIlllIIIlIllIl) {
        this.biome = llllllllllllIlIllIIIlllIIIlIllIl;
    }
    
    @Override
    public Biome func_190943_d() {
        return this.biome;
    }
    
    @Override
    public boolean func_190944_c() {
        return true;
    }
    
    @Nullable
    @Override
    public BlockPos findBiomePosition(final int llllllllllllIlIllIIIllIlllllIIlI, final int llllllllllllIlIllIIIllIlllllIIIl, final int llllllllllllIlIllIIIllIllllIlIlI, final List<Biome> llllllllllllIlIllIIIllIllllIlIIl, final Random llllllllllllIlIllIIIllIllllIlIII) {
        return llllllllllllIlIllIIIllIllllIlIIl.contains(this.biome) ? new BlockPos(llllllllllllIlIllIIIllIlllllIIlI - llllllllllllIlIllIIIllIllllIlIlI + llllllllllllIlIllIIIllIllllIlIII.nextInt(llllllllllllIlIllIIIllIllllIlIlI * 2 + 1), 0, llllllllllllIlIllIIIllIlllllIIIl - llllllllllllIlIllIIIllIllllIlIlI + llllllllllllIlIllIIIllIllllIlIII.nextInt(llllllllllllIlIllIIIllIllllIlIlI * 2 + 1)) : null;
    }
    
    @Override
    public Biome getBiome(final BlockPos llllllllllllIlIllIIIlllIIIlIlIlI) {
        return this.biome;
    }
    
    @Override
    public Biome[] getBiomes(@Nullable final Biome[] llllllllllllIlIllIIIllIllllllllI, final int llllllllllllIlIllIIIlllIIIIIIlII, final int llllllllllllIlIllIIIllIlllllllII, final int llllllllllllIlIllIIIlllIIIIIIIlI, final int llllllllllllIlIllIIIlllIIIIIIIIl, final boolean llllllllllllIlIllIIIlllIIIIIIIII) {
        return this.getBiomes(llllllllllllIlIllIIIllIllllllllI, llllllllllllIlIllIIIlllIIIIIIlII, llllllllllllIlIllIIIllIlllllllII, llllllllllllIlIllIIIlllIIIIIIIlI, llllllllllllIlIllIIIlllIIIIIIIIl);
    }
    
    @Override
    public Biome[] getBiomesForGeneration(Biome[] llllllllllllIlIllIIIlllIIIIlllIl, final int llllllllllllIlIllIIIlllIIIlIIIlI, final int llllllllllllIlIllIIIlllIIIlIIIIl, final int llllllllllllIlIllIIIlllIIIIlllII, final int llllllllllllIlIllIIIlllIIIIllIll) {
        if (llllllllllllIlIllIIIlllIIIIlllIl == null || llllllllllllIlIllIIIlllIIIIlllIl.length < llllllllllllIlIllIIIlllIIIIlllII * llllllllllllIlIllIIIlllIIIIllIll) {
            llllllllllllIlIllIIIlllIIIIlllIl = new Biome[llllllllllllIlIllIIIlllIIIIlllII * llllllllllllIlIllIIIlllIIIIllIll];
        }
        Arrays.fill(llllllllllllIlIllIIIlllIIIIlllIl, 0, llllllllllllIlIllIIIlllIIIIlllII * llllllllllllIlIllIIIlllIIIIllIll, this.biome);
        return llllllllllllIlIllIIIlllIIIIlllIl;
    }
    
    @Override
    public boolean areBiomesViable(final int llllllllllllIlIllIIIllIllllIIlII, final int llllllllllllIlIllIIIllIllllIIIll, final int llllllllllllIlIllIIIllIllllIIIlI, final List<Biome> llllllllllllIlIllIIIllIllllIIIIl) {
        return llllllllllllIlIllIIIllIllllIIIIl.contains(this.biome);
    }
}
