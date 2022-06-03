// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMesa;
import net.minecraft.util.math.MathHelper;
import java.util.Map;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MapGenMineshaft extends MapGenStructure
{
    private /* synthetic */ double chance;
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllllIllIllIIlIIIIIlllIl, final BlockPos lllllllllllllIllIllIIlIIIIIlllII, final boolean lllllllllllllIllIllIIlIIIIlIlIIl) {
        final int lllllllllllllIllIllIIlIIIIlIlIII = 1000;
        final int lllllllllllllIllIllIIlIIIIlIIlll = lllllllllllllIllIllIIlIIIIIlllII.getX() >> 4;
        final int lllllllllllllIllIllIIlIIIIlIIllI = lllllllllllllIllIllIIlIIIIIlllII.getZ() >> 4;
        for (int lllllllllllllIllIllIIlIIIIlIIlIl = 0; lllllllllllllIllIllIIlIIIIlIIlIl <= 1000; ++lllllllllllllIllIllIIlIIIIlIIlIl) {
            for (int lllllllllllllIllIllIIlIIIIlIIlII = -lllllllllllllIllIllIIlIIIIlIIlIl; lllllllllllllIllIllIIlIIIIlIIlII <= lllllllllllllIllIllIIlIIIIlIIlIl; ++lllllllllllllIllIllIIlIIIIlIIlII) {
                final boolean lllllllllllllIllIllIIlIIIIlIIIll = lllllllllllllIllIllIIlIIIIlIIlII == -lllllllllllllIllIllIIlIIIIlIIlIl || lllllllllllllIllIllIIlIIIIlIIlII == lllllllllllllIllIllIIlIIIIlIIlIl;
                for (int lllllllllllllIllIllIIlIIIIlIIIlI = -lllllllllllllIllIllIIlIIIIlIIlIl; lllllllllllllIllIllIIlIIIIlIIIlI <= lllllllllllllIllIllIIlIIIIlIIlIl; ++lllllllllllllIllIllIIlIIIIlIIIlI) {
                    final boolean lllllllllllllIllIllIIlIIIIlIIIIl = lllllllllllllIllIllIIlIIIIlIIIlI == -lllllllllllllIllIllIIlIIIIlIIlIl || lllllllllllllIllIllIIlIIIIlIIIlI == lllllllllllllIllIllIIlIIIIlIIlIl;
                    if (lllllllllllllIllIllIIlIIIIlIIIll || lllllllllllllIllIllIIlIIIIlIIIIl) {
                        final int lllllllllllllIllIllIIlIIIIlIIIII = lllllllllllllIllIllIIlIIIIlIIlll + lllllllllllllIllIllIIlIIIIlIIlII;
                        final int lllllllllllllIllIllIIlIIIIIlllll = lllllllllllllIllIllIIlIIIIlIIllI + lllllllllllllIllIllIIlIIIIlIIIlI;
                        this.rand.setSeed((long)(lllllllllllllIllIllIIlIIIIlIIIII ^ lllllllllllllIllIllIIlIIIIIlllll) ^ lllllllllllllIllIllIIlIIIIIlllIl.getSeed());
                        this.rand.nextInt();
                        if (this.canSpawnStructureAtCoords(lllllllllllllIllIllIIlIIIIlIIIII, lllllllllllllIllIllIIlIIIIIlllll) && (!lllllllllllllIllIllIIlIIIIlIlIIl || !lllllllllllllIllIllIIlIIIIIlllIl.func_190526_b(lllllllllllllIllIllIIlIIIIlIIIII, lllllllllllllIllIllIIlIIIIIlllll))) {
                            return new BlockPos((lllllllllllllIllIllIIlIIIIlIIIII << 4) + 8, 64, (lllllllllllllIllIllIIlIIIIIlllll << 4) + 8);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public MapGenMineshaft() {
        this.chance = 0.004;
    }
    
    public MapGenMineshaft(final Map<String, String> lllllllllllllIllIllIIlIIIlIIIllI) {
        this.chance = 0.004;
        for (final Map.Entry<String, String> lllllllllllllIllIllIIlIIIlIIlIII : lllllllllllllIllIllIIlIIIlIIIllI.entrySet()) {
            if (lllllllllllllIllIllIIlIIIlIIlIII.getKey().equals("chance")) {
                this.chance = MathHelper.getDouble(lllllllllllllIllIllIIlIIIlIIlIII.getValue(), this.chance);
            }
        }
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllllIllIllIIlIIIIIIIlIl, final int lllllllllllllIllIllIIlIIIIIIIlII) {
        final Biome lllllllllllllIllIllIIlIIIIIIlIII = this.worldObj.getBiome(new BlockPos((lllllllllllllIllIllIIlIIIIIIIlIl << 4) + 8, 64, (lllllllllllllIllIllIIlIIIIIIIlII << 4) + 8));
        final Type lllllllllllllIllIllIIlIIIIIIIlll = (lllllllllllllIllIllIIlIIIIIIlIII instanceof BiomeMesa) ? Type.MESA : Type.NORMAL;
        return new StructureMineshaftStart(this.worldObj, this.rand, lllllllllllllIllIllIIlIIIIIIIlIl, lllllllllllllIllIllIIlIIIIIIIlII, lllllllllllllIllIllIIlIIIIIIIlll);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int lllllllllllllIllIllIIlIIIIllllll, final int lllllllllllllIllIllIIlIIIIlllllI) {
        return this.rand.nextDouble() < this.chance && this.rand.nextInt(80) < Math.max(Math.abs(lllllllllllllIllIllIIlIIIIllllll), Math.abs(lllllllllllllIllIllIIlIIIIlllllI));
    }
    
    @Override
    public String getStructureName() {
        return "Mineshaft";
    }
    
    public enum Type
    {
        MESA("MESA", 1), 
        NORMAL("NORMAL", 0);
        
        private Type(final String llllllllllIllllIIlIIIIIIlIIlIllI, final int llllllllllIllllIIlIIIIIIlIIlIlIl) {
        }
        
        public static Type byId(final int llllllllllIllllIIlIIIIIIlIIlIIll) {
            return (llllllllllIllllIIlIIIIIIlIIlIIll >= 0 && llllllllllIllllIIlIIIIIIlIIlIIll < values().length) ? values()[llllllllllIllllIIlIIIIIIlIIlIIll] : Type.NORMAL;
        }
    }
}
