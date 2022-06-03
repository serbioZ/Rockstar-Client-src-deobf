// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import com.google.common.collect.Maps;
import org.apache.logging.log4j.LogManager;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.Logger;
import java.util.Map;

public class MapGenStructureIO
{
    private static final /* synthetic */ Map<Class<? extends StructureStart>, String> startClassToNameMap;
    private static final /* synthetic */ Map<Class<? extends StructureComponent>, String> componentClassToNameMap;
    private static final /* synthetic */ Map<String, Class<? extends StructureStart>> startNameToClassMap;
    private static final /* synthetic */ Map<String, Class<? extends StructureComponent>> componentNameToClassMap;
    private static final /* synthetic */ Logger LOGGER;
    
    public static String getStructureStartName(final StructureStart lllllllllllIlIlIIIIlIlllllllIIIl) {
        return MapGenStructureIO.startClassToNameMap.get(lllllllllllIlIlIIIIlIlllllllIIIl.getClass());
    }
    
    static void registerStructureComponent(final Class<? extends StructureComponent> lllllllllllIlIlIIIIlIlllllllIlll, final String lllllllllllIlIlIIIIlIlllllllIlII) {
        MapGenStructureIO.componentNameToClassMap.put(lllllllllllIlIlIIIIlIlllllllIlII, lllllllllllIlIlIIIIlIlllllllIlll);
        MapGenStructureIO.componentClassToNameMap.put(lllllllllllIlIlIIIIlIlllllllIlll, lllllllllllIlIlIIIIlIlllllllIlII);
    }
    
    public static StructureComponent getStructureComponent(final NBTTagCompound lllllllllllIlIlIIIIlIlllllIlllII, final World lllllllllllIlIlIIIIlIlllllIlIllI) {
        StructureComponent lllllllllllIlIlIIIIlIlllllIllIlI = null;
        try {
            final Class<? extends StructureComponent> lllllllllllIlIlIIIIlIlllllIllIIl = MapGenStructureIO.componentNameToClassMap.get(lllllllllllIlIlIIIIlIlllllIlllII.getString("id"));
            if (lllllllllllIlIlIIIIlIlllllIllIIl != null) {
                lllllllllllIlIlIIIIlIlllllIllIlI = (StructureComponent)lllllllllllIlIlIIIIlIlllllIllIIl.newInstance();
            }
        }
        catch (Exception lllllllllllIlIlIIIIlIlllllIllIII) {
            MapGenStructureIO.LOGGER.warn("Failed Piece with id {}", (Object)lllllllllllIlIlIIIIlIlllllIlllII.getString("id"));
            lllllllllllIlIlIIIIlIlllllIllIII.printStackTrace();
        }
        if (lllllllllllIlIlIIIIlIlllllIllIlI != null) {
            lllllllllllIlIlIIIIlIlllllIllIlI.readStructureBaseNBT(lllllllllllIlIlIIIIlIlllllIlIllI, lllllllllllIlIlIIIIlIlllllIlllII);
        }
        else {
            MapGenStructureIO.LOGGER.warn("Skipping Piece with id {}", (Object)lllllllllllIlIlIIIIlIlllllIlllII.getString("id"));
        }
        return lllllllllllIlIlIIIIlIlllllIllIlI;
    }
    
    @Nullable
    public static StructureStart getStructureStart(final NBTTagCompound lllllllllllIlIlIIIIlIllllllIlIIl, final World lllllllllllIlIlIIIIlIllllllIIIll) {
        StructureStart lllllllllllIlIlIIIIlIllllllIIlll = null;
        try {
            final Class<? extends StructureStart> lllllllllllIlIlIIIIlIllllllIIllI = MapGenStructureIO.startNameToClassMap.get(lllllllllllIlIlIIIIlIllllllIlIIl.getString("id"));
            if (lllllllllllIlIlIIIIlIllllllIIllI != null) {
                lllllllllllIlIlIIIIlIllllllIIlll = (StructureStart)lllllllllllIlIlIIIIlIllllllIIllI.newInstance();
            }
        }
        catch (Exception lllllllllllIlIlIIIIlIllllllIIlIl) {
            MapGenStructureIO.LOGGER.warn("Failed Start with id {}", (Object)lllllllllllIlIlIIIIlIllllllIlIIl.getString("id"));
            lllllllllllIlIlIIIIlIllllllIIlIl.printStackTrace();
        }
        if (lllllllllllIlIlIIIIlIllllllIIlll != null) {
            lllllllllllIlIlIIIIlIllllllIIlll.readStructureComponentsFromNBT(lllllllllllIlIlIIIIlIllllllIIIll, lllllllllllIlIlIIIIlIllllllIlIIl);
        }
        else {
            MapGenStructureIO.LOGGER.warn("Skipping Structure with id {}", (Object)lllllllllllIlIlIIIIlIllllllIlIIl.getString("id"));
        }
        return lllllllllllIlIlIIIIlIllllllIIlll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        startNameToClassMap = Maps.newHashMap();
        startClassToNameMap = Maps.newHashMap();
        componentNameToClassMap = Maps.newHashMap();
        componentClassToNameMap = Maps.newHashMap();
        registerStructure(StructureMineshaftStart.class, "Mineshaft");
        registerStructure(MapGenVillage.Start.class, "Village");
        registerStructure(MapGenNetherBridge.Start.class, "Fortress");
        registerStructure(MapGenStronghold.Start.class, "Stronghold");
        registerStructure(MapGenScatteredFeature.Start.class, "Temple");
        registerStructure(StructureOceanMonument.StartMonument.class, "Monument");
        registerStructure(MapGenEndCity.Start.class, "EndCity");
        registerStructure(WoodlandMansion.Start.class, "Mansion");
        StructureMineshaftPieces.registerStructurePieces();
        StructureVillagePieces.registerVillagePieces();
        StructureNetherBridgePieces.registerNetherFortressPieces();
        StructureStrongholdPieces.registerStrongholdPieces();
        ComponentScatteredFeaturePieces.registerScatteredFeaturePieces();
        StructureOceanMonumentPieces.registerOceanMonumentPieces();
        StructureEndCityPieces.registerPieces();
        WoodlandMansionPieces.func_191153_a();
    }
    
    private static void registerStructure(final Class<? extends StructureStart> lllllllllllIlIlIIIIlIlllllllllIl, final String lllllllllllIlIlIIIIlIllllllllIlI) {
        MapGenStructureIO.startNameToClassMap.put(lllllllllllIlIlIIIIlIllllllllIlI, lllllllllllIlIlIIIIlIlllllllllIl);
        MapGenStructureIO.startClassToNameMap.put(lllllllllllIlIlIIIIlIlllllllllIl, lllllllllllIlIlIIIIlIllllllllIlI);
    }
    
    public static String getStructureComponentName(final StructureComponent lllllllllllIlIlIIIIlIllllllIlllI) {
        return MapGenStructureIO.componentClassToNameMap.get(lllllllllllIlIlIIIIlIllllllIlllI.getClass());
    }
}
