// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

public class BiomeVoid extends Biome
{
    @Override
    public boolean ignorePlayerSpawnSuitability() {
        return true;
    }
    
    public BiomeVoid(final BiomeProperties llllllllllIlllllIIIlIIlIlIIIIIIl) {
        super(llllllllllIlllllIIIlIIlIlIIIIIIl);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.theBiomeDecorator = new BiomeVoidDecorator();
    }
}
