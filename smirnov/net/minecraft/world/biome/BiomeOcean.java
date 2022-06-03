// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

public class BiomeOcean extends Biome
{
    public BiomeOcean(final BiomeProperties llllllllllllIlIIIlIlIIIlllIlllII) {
        super(llllllllllllIlIIIlIlIIIlllIlllII);
        this.spawnableCreatureList.clear();
    }
    
    @Override
    public TempCategory getTempCategory() {
        return TempCategory.OCEAN;
    }
}
