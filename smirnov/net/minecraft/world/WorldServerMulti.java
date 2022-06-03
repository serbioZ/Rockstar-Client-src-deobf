// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.storage.DerivedWorldInfo;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.server.MinecraftServer;

public class WorldServerMulti extends WorldServer
{
    private final /* synthetic */ WorldServer delegate;
    
    public WorldServerMulti(final MinecraftServer lllllllllllIIllIllIIllIIIIllIlII, final ISaveHandler lllllllllllIIllIllIIllIIIIllIIll, final int lllllllllllIIllIllIIllIIIIllIIlI, final WorldServer lllllllllllIIllIllIIllIIIIllIIIl, final Profiler lllllllllllIIllIllIIllIIIIllIIII) {
        super(lllllllllllIIllIllIIllIIIIllIlII, lllllllllllIIllIllIIllIIIIllIIll, new DerivedWorldInfo(lllllllllllIIllIllIIllIIIIllIIIl.getWorldInfo()), lllllllllllIIllIllIIllIIIIllIIlI, lllllllllllIIllIllIIllIIIIllIIII);
        this.delegate = lllllllllllIIllIllIIllIIIIllIIIl;
        lllllllllllIIllIllIIllIIIIllIIIl.getWorldBorder().addListener(new IBorderListener() {
            @Override
            public void onWarningTimeChanged(final WorldBorder lllllllllllIIlIlIllIIIIIIIlIIIlI, final int lllllllllllIIlIlIllIIIIIIIIlllll) {
                WorldServerMulti.this.getWorldBorder().setWarningTime(lllllllllllIIlIlIllIIIIIIIIlllll);
            }
            
            @Override
            public void onSizeChanged(final WorldBorder lllllllllllIIlIlIllIIIIIIlIIIIII, final double lllllllllllIIlIlIllIIIIIIIllllIl) {
                WorldServerMulti.this.getWorldBorder().setTransition(lllllllllllIIlIlIllIIIIIIIllllIl);
            }
            
            @Override
            public void onDamageAmountChanged(final WorldBorder lllllllllllIIlIlIllIIIIIIIIlIlII, final double lllllllllllIIlIlIllIIIIIIIIlIIll) {
                WorldServerMulti.this.getWorldBorder().setDamageAmount(lllllllllllIIlIlIllIIIIIIIIlIIll);
            }
            
            @Override
            public void onCenterChanged(final WorldBorder lllllllllllIIlIlIllIIIIIIIlIlIll, final double lllllllllllIIlIlIllIIIIIIIlIIlll, final double lllllllllllIIlIlIllIIIIIIIlIlIIl) {
                WorldServerMulti.this.getWorldBorder().setCenter(lllllllllllIIlIlIllIIIIIIIlIIlll, lllllllllllIIlIlIllIIIIIIIlIlIIl);
            }
            
            @Override
            public void onWarningDistanceChanged(final WorldBorder lllllllllllIIlIlIllIIIIIIIIllIll, final int lllllllllllIIlIlIllIIIIIIIIllIlI) {
                WorldServerMulti.this.getWorldBorder().setWarningDistance(lllllllllllIIlIlIllIIIIIIIIllIlI);
            }
            
            @Override
            public void onTransitionStarted(final WorldBorder lllllllllllIIlIlIllIIIIIIIllIlll, final double lllllllllllIIlIlIllIIIIIIIllIllI, final double lllllllllllIIlIlIllIIIIIIIllIlIl, final long lllllllllllIIlIlIllIIIIIIIllIIII) {
                WorldServerMulti.this.getWorldBorder().setTransition(lllllllllllIIlIlIllIIIIIIIllIllI, lllllllllllIIlIlIllIIIIIIIllIlIl, lllllllllllIIlIlIllIIIIIIIllIIII);
            }
            
            @Override
            public void onDamageBufferChanged(final WorldBorder lllllllllllIIlIlIllIIIIIIIIIllIl, final double lllllllllllIIlIlIllIIIIIIIIIllII) {
                WorldServerMulti.this.getWorldBorder().setDamageBuffer(lllllllllllIIlIlIllIIIIIIIIIllII);
            }
        });
    }
    
    @Override
    public World init() {
        this.mapStorage = this.delegate.getMapStorage();
        this.worldScoreboard = this.delegate.getScoreboard();
        this.lootTable = this.delegate.getLootTableManager();
        this.field_191951_C = this.delegate.func_191952_z();
        final String lllllllllllIIllIllIIllIIIIlIIlII = VillageCollection.fileNameForProvider(this.provider);
        final VillageCollection lllllllllllIIllIllIIllIIIIlIIIll = (VillageCollection)this.mapStorage.getOrLoadData(VillageCollection.class, lllllllllllIIllIllIIllIIIIlIIlII);
        if (lllllllllllIIllIllIIllIIIIlIIIll == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(lllllllllllIIllIllIIllIIIIlIIlII, this.villageCollectionObj);
        }
        else {
            this.villageCollectionObj = lllllllllllIIllIllIIllIIIIlIIIll;
            this.villageCollectionObj.setWorldsForAll(this);
        }
        return this;
    }
    
    public void saveAdditionalData() {
        this.provider.onWorldSave();
    }
    
    @Override
    protected void saveLevel() throws MinecraftException {
    }
}
