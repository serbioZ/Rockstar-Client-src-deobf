// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class WorldGenFossils extends WorldGenerator
{
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_01_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_03_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_02;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_03_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_02_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_01;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_02_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_04;
    private static final /* synthetic */ ResourceLocation[] FOSSILS;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_03;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_04_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_01;
    private static final /* synthetic */ ResourceLocation[] FOSSILS_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_04;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_03;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_04_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_01_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_02;
    
    static {
        STRUCTURE_SPINE_01 = new ResourceLocation("fossils/fossil_spine_01");
        STRUCTURE_SPINE_02 = new ResourceLocation("fossils/fossil_spine_02");
        STRUCTURE_SPINE_03 = new ResourceLocation("fossils/fossil_spine_03");
        STRUCTURE_SPINE_04 = new ResourceLocation("fossils/fossil_spine_04");
        STRUCTURE_SPINE_01_COAL = new ResourceLocation("fossils/fossil_spine_01_coal");
        STRUCTURE_SPINE_02_COAL = new ResourceLocation("fossils/fossil_spine_02_coal");
        STRUCTURE_SPINE_03_COAL = new ResourceLocation("fossils/fossil_spine_03_coal");
        STRUCTURE_SPINE_04_COAL = new ResourceLocation("fossils/fossil_spine_04_coal");
        STRUCTURE_SKULL_01 = new ResourceLocation("fossils/fossil_skull_01");
        STRUCTURE_SKULL_02 = new ResourceLocation("fossils/fossil_skull_02");
        STRUCTURE_SKULL_03 = new ResourceLocation("fossils/fossil_skull_03");
        STRUCTURE_SKULL_04 = new ResourceLocation("fossils/fossil_skull_04");
        STRUCTURE_SKULL_01_COAL = new ResourceLocation("fossils/fossil_skull_01_coal");
        STRUCTURE_SKULL_02_COAL = new ResourceLocation("fossils/fossil_skull_02_coal");
        STRUCTURE_SKULL_03_COAL = new ResourceLocation("fossils/fossil_skull_03_coal");
        STRUCTURE_SKULL_04_COAL = new ResourceLocation("fossils/fossil_skull_04_coal");
        FOSSILS = new ResourceLocation[] { WorldGenFossils.STRUCTURE_SPINE_01, WorldGenFossils.STRUCTURE_SPINE_02, WorldGenFossils.STRUCTURE_SPINE_03, WorldGenFossils.STRUCTURE_SPINE_04, WorldGenFossils.STRUCTURE_SKULL_01, WorldGenFossils.STRUCTURE_SKULL_02, WorldGenFossils.STRUCTURE_SKULL_03, WorldGenFossils.STRUCTURE_SKULL_04 };
        FOSSILS_COAL = new ResourceLocation[] { WorldGenFossils.STRUCTURE_SPINE_01_COAL, WorldGenFossils.STRUCTURE_SPINE_02_COAL, WorldGenFossils.STRUCTURE_SPINE_03_COAL, WorldGenFossils.STRUCTURE_SPINE_04_COAL, WorldGenFossils.STRUCTURE_SKULL_01_COAL, WorldGenFossils.STRUCTURE_SKULL_02_COAL, WorldGenFossils.STRUCTURE_SKULL_03_COAL, WorldGenFossils.STRUCTURE_SKULL_04_COAL };
    }
    
    @Override
    public boolean generate(final World lllllllllllIIlIlIIIllIlIlIIIlIll, final Random lllllllllllIIlIlIIIllIlIlIlIIIII, final BlockPos lllllllllllIIlIlIIIllIlIlIIlllll) {
        final Random lllllllllllIIlIlIIIllIlIlIIllllI = lllllllllllIIlIlIIIllIlIlIIIlIll.getChunkFromBlockCoords(lllllllllllIIlIlIIIllIlIlIIlllll).getRandomWithSeed(987234911L);
        final MinecraftServer lllllllllllIIlIlIIIllIlIlIIlllIl = lllllllllllIIlIlIIIllIlIlIIIlIll.getMinecraftServer();
        final Rotation[] lllllllllllIIlIlIIIllIlIlIIlllII = Rotation.values();
        final Rotation lllllllllllIIlIlIIIllIlIlIIllIll = lllllllllllIIlIlIIIllIlIlIIlllII[lllllllllllIIlIlIIIllIlIlIIllllI.nextInt(lllllllllllIIlIlIIIllIlIlIIlllII.length)];
        final int lllllllllllIIlIlIIIllIlIlIIllIlI = lllllllllllIIlIlIIIllIlIlIIllllI.nextInt(WorldGenFossils.FOSSILS.length);
        final TemplateManager lllllllllllIIlIlIIIllIlIlIIllIIl = lllllllllllIIlIlIIIllIlIlIIIlIll.getSaveHandler().getStructureTemplateManager();
        final Template lllllllllllIIlIlIIIllIlIlIIllIII = lllllllllllIIlIlIIIllIlIlIIllIIl.getTemplate(lllllllllllIIlIlIIIllIlIlIIlllIl, WorldGenFossils.FOSSILS[lllllllllllIIlIlIIIllIlIlIIllIlI]);
        final Template lllllllllllIIlIlIIIllIlIlIIlIlll = lllllllllllIIlIlIIIllIlIlIIllIIl.getTemplate(lllllllllllIIlIlIIIllIlIlIIlllIl, WorldGenFossils.FOSSILS_COAL[lllllllllllIIlIlIIIllIlIlIIllIlI]);
        final ChunkPos lllllllllllIIlIlIIIllIlIlIIlIllI = new ChunkPos(lllllllllllIIlIlIIIllIlIlIIlllll);
        final StructureBoundingBox lllllllllllIIlIlIIIllIlIlIIlIlIl = new StructureBoundingBox(lllllllllllIIlIlIIIllIlIlIIlIllI.getXStart(), 0, lllllllllllIIlIlIIIllIlIlIIlIllI.getZStart(), lllllllllllIIlIlIIIllIlIlIIlIllI.getXEnd(), 256, lllllllllllIIlIlIIIllIlIlIIlIllI.getZEnd());
        final PlacementSettings lllllllllllIIlIlIIIllIlIlIIlIlII = new PlacementSettings().setRotation(lllllllllllIIlIlIIIllIlIlIIllIll).setBoundingBox(lllllllllllIIlIlIIIllIlIlIIlIlIl).setRandom(lllllllllllIIlIlIIIllIlIlIIllllI);
        final BlockPos lllllllllllIIlIlIIIllIlIlIIlIIll = lllllllllllIIlIlIIIllIlIlIIllIII.transformedSize(lllllllllllIIlIlIIIllIlIlIIllIll);
        final int lllllllllllIIlIlIIIllIlIlIIlIIlI = lllllllllllIIlIlIIIllIlIlIIllllI.nextInt(16 - lllllllllllIIlIlIIIllIlIlIIlIIll.getX());
        final int lllllllllllIIlIlIIIllIlIlIIlIIIl = lllllllllllIIlIlIIIllIlIlIIllllI.nextInt(16 - lllllllllllIIlIlIIIllIlIlIIlIIll.getZ());
        int lllllllllllIIlIlIIIllIlIlIIlIIII = 256;
        for (int lllllllllllIIlIlIIIllIlIlIIIllll = 0; lllllllllllIIlIlIIIllIlIlIIIllll < lllllllllllIIlIlIIIllIlIlIIlIIll.getX(); ++lllllllllllIIlIlIIIllIlIlIIIllll) {
            for (int lllllllllllIIlIlIIIllIlIlIIIlllI = 0; lllllllllllIIlIlIIIllIlIlIIIlllI < lllllllllllIIlIlIIIllIlIlIIlIIll.getX(); ++lllllllllllIIlIlIIIllIlIlIIIlllI) {
                lllllllllllIIlIlIIIllIlIlIIlIIII = Math.min(lllllllllllIIlIlIIIllIlIlIIlIIII, lllllllllllIIlIlIIIllIlIlIIIlIll.getHeight(lllllllllllIIlIlIIIllIlIlIIlllll.getX() + lllllllllllIIlIlIIIllIlIlIIIllll + lllllllllllIIlIlIIIllIlIlIIlIIlI, lllllllllllIIlIlIIIllIlIlIIlllll.getZ() + lllllllllllIIlIlIIIllIlIlIIIlllI + lllllllllllIIlIlIIIllIlIlIIlIIIl));
            }
        }
        final int lllllllllllIIlIlIIIllIlIlIIIllIl = Math.max(lllllllllllIIlIlIIIllIlIlIIlIIII - 15 - lllllllllllIIlIlIIIllIlIlIIllllI.nextInt(10), 10);
        final BlockPos lllllllllllIIlIlIIIllIlIlIIIllII = lllllllllllIIlIlIIIllIlIlIIllIII.getZeroPositionWithTransform(lllllllllllIIlIlIIIllIlIlIIlllll.add(lllllllllllIIlIlIIIllIlIlIIlIIlI, lllllllllllIIlIlIIIllIlIlIIIllIl, lllllllllllIIlIlIIIllIlIlIIlIIIl), Mirror.NONE, lllllllllllIIlIlIIIllIlIlIIllIll);
        lllllllllllIIlIlIIIllIlIlIIlIlII.setIntegrity(0.9f);
        lllllllllllIIlIlIIIllIlIlIIllIII.addBlocksToWorld(lllllllllllIIlIlIIIllIlIlIIIlIll, lllllllllllIIlIlIIIllIlIlIIIllII, lllllllllllIIlIlIIIllIlIlIIlIlII, 20);
        lllllllllllIIlIlIIIllIlIlIIlIlII.setIntegrity(0.1f);
        lllllllllllIIlIlIIIllIlIlIIlIlll.addBlocksToWorld(lllllllllllIIlIlIIIllIlIlIIIlIll, lllllllllllIIlIlIIIllIlIlIIIllII, lllllllllllIIlIlIIIllIlIlIIlIlII, 20);
        return true;
    }
}
