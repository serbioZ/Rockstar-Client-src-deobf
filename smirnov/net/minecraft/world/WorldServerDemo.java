// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.profiler.Profiler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.server.MinecraftServer;

public class WorldServerDemo extends WorldServer
{
    public static final /* synthetic */ WorldSettings DEMO_WORLD_SETTINGS;
    private static final /* synthetic */ long DEMO_WORLD_SEED;
    
    public WorldServerDemo(final MinecraftServer lllllllllllllIlIIllIlIIIIIIIllll, final ISaveHandler lllllllllllllIlIIllIlIIIIIIlIlII, final WorldInfo lllllllllllllIlIIllIlIIIIIIIllIl, final int lllllllllllllIlIIllIlIIIIIIIllII, final Profiler lllllllllllllIlIIllIlIIIIIIIlIll) {
        super(lllllllllllllIlIIllIlIIIIIIIllll, lllllllllllllIlIIllIlIIIIIIlIlII, lllllllllllllIlIIllIlIIIIIIIllIl, lllllllllllllIlIIllIlIIIIIIIllII, lllllllllllllIlIIllIlIIIIIIIlIll);
        this.worldInfo.populateFromWorldSettings(WorldServerDemo.DEMO_WORLD_SETTINGS);
    }
    
    static {
        DEMO_WORLD_SEED = "North Carolina".hashCode();
        DEMO_WORLD_SETTINGS = new WorldSettings(WorldServerDemo.DEMO_WORLD_SEED, GameType.SURVIVAL, true, false, WorldType.DEFAULT).enableBonusChest();
    }
}
