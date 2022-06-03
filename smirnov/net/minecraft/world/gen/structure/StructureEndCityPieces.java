// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import java.util.Collection;
import com.google.common.collect.Lists;
import java.util.Random;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Tuple;
import java.util.List;

public class StructureEndCityPieces
{
    private static final /* synthetic */ IGenerator FAT_TOWER_GENERATOR;
    private static final /* synthetic */ IGenerator TOWER_GENERATOR;
    private static final /* synthetic */ IGenerator HOUSE_TOWER_GENERATOR;
    private static final /* synthetic */ List<Tuple<Rotation, BlockPos>> FAT_TOWER_BRIDGES;
    private static final /* synthetic */ List<Tuple<Rotation, BlockPos>> TOWER_BRIDGES;
    private static final /* synthetic */ PlacementSettings OVERWRITE;
    private static final /* synthetic */ IGenerator TOWER_BRIDGE_GENERATOR;
    private static final /* synthetic */ PlacementSettings INSERT;
    
    private static CityTemplate func_189935_b(final List<StructureComponent> lllllllllllIIlllllllIllIllIlIlIl, final CityTemplate lllllllllllIIlllllllIllIllIlIlII) {
        lllllllllllIIlllllllIllIllIlIlIl.add(lllllllllllIIlllllllIllIllIlIlII);
        return lllllllllllIIlllllllIllIllIlIlII;
    }
    
    private static boolean func_191088_b(final TemplateManager lllllllllllIIlllllllIllIlIlllIII, final IGenerator lllllllllllIIlllllllIllIlIllIlll, final int lllllllllllIIlllllllIllIllIIIIlI, final CityTemplate lllllllllllIIlllllllIllIlIllIlIl, final BlockPos lllllllllllIIlllllllIllIlIllIlII, final List<StructureComponent> lllllllllllIIlllllllIllIlIllIIll, final Random lllllllllllIIlllllllIllIlIllIIlI) {
        if (lllllllllllIIlllllllIllIllIIIIlI > 8) {
            return false;
        }
        final List<StructureComponent> lllllllllllIIlllllllIllIlIllllIl = (List<StructureComponent>)Lists.newArrayList();
        if (lllllllllllIIlllllllIllIlIllIlll.func_191086_a(lllllllllllIIlllllllIllIlIlllIII, lllllllllllIIlllllllIllIllIIIIlI, lllllllllllIIlllllllIllIlIllIlIl, lllllllllllIIlllllllIllIlIllIlII, lllllllllllIIlllllllIllIlIllllIl, lllllllllllIIlllllllIllIlIllIIlI)) {
            boolean lllllllllllIIlllllllIllIlIllllII = false;
            final int lllllllllllIIlllllllIllIlIlllIll = lllllllllllIIlllllllIllIlIllIIlI.nextInt();
            for (final StructureComponent lllllllllllIIlllllllIllIlIlllIlI : lllllllllllIIlllllllIllIlIllllIl) {
                lllllllllllIIlllllllIllIlIlllIlI.componentType = lllllllllllIIlllllllIllIlIlllIll;
                final StructureComponent lllllllllllIIlllllllIllIlIlllIIl = StructureComponent.findIntersecting(lllllllllllIIlllllllIllIlIllIIll, lllllllllllIIlllllllIllIlIlllIlI.getBoundingBox());
                if (lllllllllllIIlllllllIllIlIlllIIl != null && lllllllllllIIlllllllIllIlIlllIIl.componentType != lllllllllllIIlllllllIllIlIllIlIl.componentType) {
                    lllllllllllIIlllllllIllIlIllllII = true;
                    break;
                }
            }
            if (!lllllllllllIIlllllllIllIlIllllII) {
                lllllllllllIIlllllllIllIlIllIIll.addAll(lllllllllllIIlllllllIllIlIllllIl);
                return true;
            }
        }
        return false;
    }
    
    public static void func_191087_a(final TemplateManager lllllllllllIIlllllllIllIllIlllIl, final BlockPos lllllllllllIIlllllllIllIlllIIIlI, final Rotation lllllllllllIIlllllllIllIlllIIIIl, final List<StructureComponent> lllllllllllIIlllllllIllIlllIIIII, final Random lllllllllllIIlllllllIllIllIlllll) {
        StructureEndCityPieces.FAT_TOWER_GENERATOR.init();
        StructureEndCityPieces.HOUSE_TOWER_GENERATOR.init();
        StructureEndCityPieces.TOWER_BRIDGE_GENERATOR.init();
        StructureEndCityPieces.TOWER_GENERATOR.init();
        CityTemplate lllllllllllIIlllllllIllIllIllllI = func_189935_b(lllllllllllIIlllllllIllIlllIIIII, new CityTemplate(lllllllllllIIlllllllIllIllIlllIl, "base_floor", lllllllllllIIlllllllIllIlllIIIlI, lllllllllllIIlllllllIllIlllIIIIl, true));
        lllllllllllIIlllllllIllIllIllllI = func_189935_b(lllllllllllIIlllllllIllIlllIIIII, func_191090_b(lllllllllllIIlllllllIllIllIlllIl, lllllllllllIIlllllllIllIllIllllI, new BlockPos(-1, 0, -1), "second_floor", lllllllllllIIlllllllIllIlllIIIIl, false));
        lllllllllllIIlllllllIllIllIllllI = func_189935_b(lllllllllllIIlllllllIllIlllIIIII, func_191090_b(lllllllllllIIlllllllIllIllIlllIl, lllllllllllIIlllllllIllIllIllllI, new BlockPos(-1, 4, -1), "third_floor", lllllllllllIIlllllllIllIlllIIIIl, false));
        lllllllllllIIlllllllIllIllIllllI = func_189935_b(lllllllllllIIlllllllIllIlllIIIII, func_191090_b(lllllllllllIIlllllllIllIllIlllIl, lllllllllllIIlllllllIllIllIllllI, new BlockPos(-1, 8, -1), "third_roof", lllllllllllIIlllllllIllIlllIIIIl, true));
        func_191088_b(lllllllllllIIlllllllIllIllIlllIl, StructureEndCityPieces.TOWER_GENERATOR, 1, lllllllllllIIlllllllIllIllIllllI, null, lllllllllllIIlllllllIllIlllIIIII, lllllllllllIIlllllllIllIllIlllll);
    }
    
    public static void registerPieces() {
        MapGenStructureIO.registerStructureComponent(CityTemplate.class, "ECP");
    }
    
    private static CityTemplate func_191090_b(final TemplateManager lllllllllllIIlllllllIllIllllIIIl, final CityTemplate lllllllllllIIlllllllIllIlllllIII, final BlockPos lllllllllllIIlllllllIllIlllIllll, final String lllllllllllIIlllllllIllIlllIlllI, final Rotation lllllllllllIIlllllllIllIllllIlIl, final boolean lllllllllllIIlllllllIllIlllIllII) {
        final CityTemplate lllllllllllIIlllllllIllIllllIIll = new CityTemplate(lllllllllllIIlllllllIllIllllIIIl, lllllllllllIIlllllllIllIlllIlllI, lllllllllllIIlllllllIllIlllllIII.templatePosition, lllllllllllIIlllllllIllIllllIlIl, lllllllllllIIlllllllIllIlllIllII);
        final BlockPos lllllllllllIIlllllllIllIllllIIlI = lllllllllllIIlllllllIllIlllllIII.template.calculateConnectedPos(lllllllllllIIlllllllIllIlllllIII.placeSettings, lllllllllllIIlllllllIllIlllIllll, lllllllllllIIlllllllIllIllllIIll.placeSettings, BlockPos.ORIGIN);
        lllllllllllIIlllllllIllIllllIIll.offset(lllllllllllIIlllllllIllIllllIIlI.getX(), lllllllllllIIlllllllIllIllllIIlI.getY(), lllllllllllIIlllllllIllIllllIIlI.getZ());
        return lllllllllllIIlllllllIllIllllIIll;
    }
    
    static {
        OVERWRITE = new PlacementSettings().setIgnoreEntities(true);
        INSERT = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
        HOUSE_TOWER_GENERATOR = new IGenerator() {
            @Override
            public boolean func_191086_a(final TemplateManager lllllllllllllIIIIIIIIIllllIlllIl, final int lllllllllllllIIIIIIIIIllllIlllII, final CityTemplate lllllllllllllIIIIIIIIIllllIlIIlI, final BlockPos lllllllllllllIIIIIIIIIllllIllIlI, final List<StructureComponent> lllllllllllllIIIIIIIIIllllIlIIII, final Random lllllllllllllIIIIIIIIIllllIllIII) {
                if (lllllllllllllIIIIIIIIIllllIlllII > 8) {
                    return false;
                }
                final Rotation lllllllllllllIIIIIIIIIllllIlIlll = lllllllllllllIIIIIIIIIllllIlIIlI.placeSettings.getRotation();
                CityTemplate lllllllllllllIIIIIIIIIllllIlIllI = func_189935_b(lllllllllllllIIIIIIIIIllllIlIIII, func_191090_b(lllllllllllllIIIIIIIIIllllIlllIl, lllllllllllllIIIIIIIIIllllIlIIlI, lllllllllllllIIIIIIIIIllllIllIlI, "base_floor", lllllllllllllIIIIIIIIIllllIlIlll, true));
                final int lllllllllllllIIIIIIIIIllllIlIlIl = lllllllllllllIIIIIIIIIllllIllIII.nextInt(3);
                if (lllllllllllllIIIIIIIIIllllIlIlIl == 0) {
                    func_189935_b(lllllllllllllIIIIIIIIIllllIlIIII, func_191090_b(lllllllllllllIIIIIIIIIllllIlllIl, lllllllllllllIIIIIIIIIllllIlIllI, new BlockPos(-1, 4, -1), "base_roof", lllllllllllllIIIIIIIIIllllIlIlll, true));
                }
                else if (lllllllllllllIIIIIIIIIllllIlIlIl == 1) {
                    lllllllllllllIIIIIIIIIllllIlIllI = func_189935_b(lllllllllllllIIIIIIIIIllllIlIIII, func_191090_b(lllllllllllllIIIIIIIIIllllIlllIl, lllllllllllllIIIIIIIIIllllIlIllI, new BlockPos(-1, 0, -1), "second_floor_2", lllllllllllllIIIIIIIIIllllIlIlll, false));
                    lllllllllllllIIIIIIIIIllllIlIllI = func_189935_b(lllllllllllllIIIIIIIIIllllIlIIII, func_191090_b(lllllllllllllIIIIIIIIIllllIlllIl, lllllllllllllIIIIIIIIIllllIlIllI, new BlockPos(-1, 8, -1), "second_roof", lllllllllllllIIIIIIIIIllllIlIlll, false));
                    func_191088_b(lllllllllllllIIIIIIIIIllllIlllIl, StructureEndCityPieces.TOWER_GENERATOR, lllllllllllllIIIIIIIIIllllIlllII + 1, lllllllllllllIIIIIIIIIllllIlIllI, null, lllllllllllllIIIIIIIIIllllIlIIII, lllllllllllllIIIIIIIIIllllIllIII);
                }
                else if (lllllllllllllIIIIIIIIIllllIlIlIl == 2) {
                    lllllllllllllIIIIIIIIIllllIlIllI = func_189935_b(lllllllllllllIIIIIIIIIllllIlIIII, func_191090_b(lllllllllllllIIIIIIIIIllllIlllIl, lllllllllllllIIIIIIIIIllllIlIllI, new BlockPos(-1, 0, -1), "second_floor_2", lllllllllllllIIIIIIIIIllllIlIlll, false));
                    lllllllllllllIIIIIIIIIllllIlIllI = func_189935_b(lllllllllllllIIIIIIIIIllllIlIIII, func_191090_b(lllllllllllllIIIIIIIIIllllIlllIl, lllllllllllllIIIIIIIIIllllIlIllI, new BlockPos(-1, 4, -1), "third_floor_c", lllllllllllllIIIIIIIIIllllIlIlll, false));
                    lllllllllllllIIIIIIIIIllllIlIllI = func_189935_b(lllllllllllllIIIIIIIIIllllIlIIII, func_191090_b(lllllllllllllIIIIIIIIIllllIlllIl, lllllllllllllIIIIIIIIIllllIlIllI, new BlockPos(-1, 8, -1), "third_roof", lllllllllllllIIIIIIIIIllllIlIlll, true));
                    func_191088_b(lllllllllllllIIIIIIIIIllllIlllIl, StructureEndCityPieces.TOWER_GENERATOR, lllllllllllllIIIIIIIIIllllIlllII + 1, lllllllllllllIIIIIIIIIllllIlIllI, null, lllllllllllllIIIIIIIIIllllIlIIII, lllllllllllllIIIIIIIIIllllIllIII);
                }
                return true;
            }
            
            @Override
            public void init() {
            }
        };
        TOWER_BRIDGES = Lists.newArrayList((Object[])new Tuple[] { new Tuple((A)Rotation.NONE, (B)new BlockPos(1, -1, 0)), new Tuple((A)Rotation.CLOCKWISE_90, (B)new BlockPos(6, -1, 1)), new Tuple((A)Rotation.COUNTERCLOCKWISE_90, (B)new BlockPos(0, -1, 5)), new Tuple((A)Rotation.CLOCKWISE_180, (B)new BlockPos(5, -1, 6)) });
        TOWER_GENERATOR = new IGenerator() {
            @Override
            public boolean func_191086_a(final TemplateManager lllllllllllllllIllIllIlllllllllI, final int lllllllllllllllIllIllIllllllllIl, final CityTemplate lllllllllllllllIllIllIllllllllII, final BlockPos lllllllllllllllIllIlllIIIIIIlIII, final List<StructureComponent> lllllllllllllllIllIlllIIIIIIIlll, final Random lllllllllllllllIllIlllIIIIIIIllI) {
                final Rotation lllllllllllllllIllIlllIIIIIIIlIl = lllllllllllllllIllIllIllllllllII.placeSettings.getRotation();
                CityTemplate lllllllllllllllIllIlllIIIIIIIlII = func_189935_b(lllllllllllllllIllIlllIIIIIIIlll, func_191090_b(lllllllllllllllIllIllIlllllllllI, lllllllllllllllIllIllIllllllllII, new BlockPos(3 + lllllllllllllllIllIlllIIIIIIIllI.nextInt(2), -3, 3 + lllllllllllllllIllIlllIIIIIIIllI.nextInt(2)), "tower_base", lllllllllllllllIllIlllIIIIIIIlIl, true));
                lllllllllllllllIllIlllIIIIIIIlII = func_189935_b(lllllllllllllllIllIlllIIIIIIIlll, func_191090_b(lllllllllllllllIllIllIlllllllllI, lllllllllllllllIllIlllIIIIIIIlII, new BlockPos(0, 7, 0), "tower_piece", lllllllllllllllIllIlllIIIIIIIlIl, true));
                CityTemplate lllllllllllllllIllIlllIIIIIIIIll = (lllllllllllllllIllIlllIIIIIIIllI.nextInt(3) == 0) ? lllllllllllllllIllIlllIIIIIIIlII : null;
                for (int lllllllllllllllIllIlllIIIIIIIIlI = 1 + lllllllllllllllIllIlllIIIIIIIllI.nextInt(3), lllllllllllllllIllIlllIIIIIIIIIl = 0; lllllllllllllllIllIlllIIIIIIIIIl < lllllllllllllllIllIlllIIIIIIIIlI; ++lllllllllllllllIllIlllIIIIIIIIIl) {
                    lllllllllllllllIllIlllIIIIIIIlII = func_189935_b(lllllllllllllllIllIlllIIIIIIIlll, func_191090_b(lllllllllllllllIllIllIlllllllllI, lllllllllllllllIllIlllIIIIIIIlII, new BlockPos(0, 4, 0), "tower_piece", lllllllllllllllIllIlllIIIIIIIlIl, true));
                    if (lllllllllllllllIllIlllIIIIIIIIIl < lllllllllllllllIllIlllIIIIIIIIlI - 1 && lllllllllllllllIllIlllIIIIIIIllI.nextBoolean()) {
                        lllllllllllllllIllIlllIIIIIIIIll = lllllllllllllllIllIlllIIIIIIIlII;
                    }
                }
                if (lllllllllllllllIllIlllIIIIIIIIll != null) {
                    for (final Tuple<Rotation, BlockPos> lllllllllllllllIllIlllIIIIIIIIII : StructureEndCityPieces.TOWER_BRIDGES) {
                        if (lllllllllllllllIllIlllIIIIIIIllI.nextBoolean()) {
                            final CityTemplate lllllllllllllllIllIllIllllllllll = func_189935_b(lllllllllllllllIllIlllIIIIIIIlll, func_191090_b(lllllllllllllllIllIllIlllllllllI, lllllllllllllllIllIlllIIIIIIIIll, lllllllllllllllIllIlllIIIIIIIIII.getSecond(), "bridge_end", lllllllllllllllIllIlllIIIIIIIlIl.add(lllllllllllllllIllIlllIIIIIIIIII.getFirst()), true));
                            func_191088_b(lllllllllllllllIllIllIlllllllllI, StructureEndCityPieces.TOWER_BRIDGE_GENERATOR, lllllllllllllllIllIllIllllllllIl + 1, lllllllllllllllIllIllIllllllllll, null, lllllllllllllllIllIlllIIIIIIIlll, lllllllllllllllIllIlllIIIIIIIllI);
                        }
                    }
                    func_189935_b(lllllllllllllllIllIlllIIIIIIIlll, func_191090_b(lllllllllllllllIllIllIlllllllllI, lllllllllllllllIllIlllIIIIIIIlII, new BlockPos(-1, 4, -1), "tower_top", lllllllllllllllIllIlllIIIIIIIlIl, true));
                }
                else {
                    if (lllllllllllllllIllIllIllllllllIl != 7) {
                        return func_191088_b(lllllllllllllllIllIllIlllllllllI, StructureEndCityPieces.FAT_TOWER_GENERATOR, lllllllllllllllIllIllIllllllllIl + 1, lllllllllllllllIllIlllIIIIIIIlII, null, lllllllllllllllIllIlllIIIIIIIlll, lllllllllllllllIllIlllIIIIIIIllI);
                    }
                    func_189935_b(lllllllllllllllIllIlllIIIIIIIlll, func_191090_b(lllllllllllllllIllIllIlllllllllI, lllllllllllllllIllIlllIIIIIIIlII, new BlockPos(-1, 4, -1), "tower_top", lllllllllllllllIllIlllIIIIIIIlIl, true));
                }
                return true;
            }
            
            @Override
            public void init() {
            }
        };
        TOWER_BRIDGE_GENERATOR = new IGenerator() {
            public /* synthetic */ boolean shipCreated;
            
            @Override
            public void init() {
                this.shipCreated = false;
            }
            
            @Override
            public boolean func_191086_a(final TemplateManager lIlIIIIIlIIl, final int lIlIIIIIlIII, final CityTemplate lIlIIIIIIlll, final BlockPos lIlIIIIlIIlI, final List<StructureComponent> lIlIIIIIIllI, final Random lIlIIIIlIIII) {
                final Rotation lIlIIIIIllll = lIlIIIIIIlll.placeSettings.getRotation();
                final int lIlIIIIIlllI = lIlIIIIlIIII.nextInt(4) + 1;
                CityTemplate lIlIIIIIllIl = func_189935_b(lIlIIIIIIllI, func_191090_b(lIlIIIIIlIIl, lIlIIIIIIlll, new BlockPos(0, 0, -4), "bridge_piece", lIlIIIIIllll, true));
                lIlIIIIIllIl.componentType = -1;
                int lIlIIIIIllII = 0;
                for (int lIlIIIIIlIll = 0; lIlIIIIIlIll < lIlIIIIIlllI; ++lIlIIIIIlIll) {
                    if (lIlIIIIlIIII.nextBoolean()) {
                        lIlIIIIIllIl = func_189935_b(lIlIIIIIIllI, func_191090_b(lIlIIIIIlIIl, lIlIIIIIllIl, new BlockPos(0, lIlIIIIIllII, -4), "bridge_piece", lIlIIIIIllll, true));
                        lIlIIIIIllII = 0;
                    }
                    else {
                        if (lIlIIIIlIIII.nextBoolean()) {
                            lIlIIIIIllIl = func_189935_b(lIlIIIIIIllI, func_191090_b(lIlIIIIIlIIl, lIlIIIIIllIl, new BlockPos(0, lIlIIIIIllII, -4), "bridge_steep_stairs", lIlIIIIIllll, true));
                        }
                        else {
                            lIlIIIIIllIl = func_189935_b(lIlIIIIIIllI, func_191090_b(lIlIIIIIlIIl, lIlIIIIIllIl, new BlockPos(0, lIlIIIIIllII, -8), "bridge_gentle_stairs", lIlIIIIIllll, true));
                        }
                        lIlIIIIIllII = 4;
                    }
                }
                if (!this.shipCreated && lIlIIIIlIIII.nextInt(10 - lIlIIIIIlIII) == 0) {
                    func_189935_b(lIlIIIIIIllI, func_191090_b(lIlIIIIIlIIl, lIlIIIIIllIl, new BlockPos(-8 + lIlIIIIlIIII.nextInt(8), lIlIIIIIllII, -70 + lIlIIIIlIIII.nextInt(10)), "ship", lIlIIIIIllll, true));
                    this.shipCreated = true;
                }
                else if (!func_191088_b(lIlIIIIIlIIl, StructureEndCityPieces.HOUSE_TOWER_GENERATOR, lIlIIIIIlIII + 1, lIlIIIIIllIl, new BlockPos(-3, lIlIIIIIllII + 1, -11), lIlIIIIIIllI, lIlIIIIlIIII)) {
                    return false;
                }
                lIlIIIIIllIl = func_189935_b(lIlIIIIIIllI, func_191090_b(lIlIIIIIlIIl, lIlIIIIIllIl, new BlockPos(4, lIlIIIIIllII, 0), "bridge_end", lIlIIIIIllll.add(Rotation.CLOCKWISE_180), true));
                lIlIIIIIllIl.componentType = -1;
                return true;
            }
        };
        FAT_TOWER_BRIDGES = Lists.newArrayList((Object[])new Tuple[] { new Tuple((A)Rotation.NONE, (B)new BlockPos(4, -1, 0)), new Tuple((A)Rotation.CLOCKWISE_90, (B)new BlockPos(12, -1, 4)), new Tuple((A)Rotation.COUNTERCLOCKWISE_90, (B)new BlockPos(0, -1, 8)), new Tuple((A)Rotation.CLOCKWISE_180, (B)new BlockPos(8, -1, 12)) });
        FAT_TOWER_GENERATOR = new IGenerator() {
            @Override
            public boolean func_191086_a(final TemplateManager lllllllllllllllIllIIIIlIlIIIIlll, final int lllllllllllllllIllIIIIlIIllllIll, final CityTemplate lllllllllllllllIllIIIIlIlIIIIlIl, final BlockPos lllllllllllllllIllIIIIlIlIIIIlII, final List<StructureComponent> lllllllllllllllIllIIIIlIlIIIIIll, final Random lllllllllllllllIllIIIIlIlIIIIIlI) {
                final Rotation lllllllllllllllIllIIIIlIlIIIIIIl = lllllllllllllllIllIIIIlIlIIIIlIl.placeSettings.getRotation();
                CityTemplate lllllllllllllllIllIIIIlIlIIIIIII = func_189935_b(lllllllllllllllIllIIIIlIlIIIIIll, func_191090_b(lllllllllllllllIllIIIIlIlIIIIlll, lllllllllllllllIllIIIIlIlIIIIlIl, new BlockPos(-3, 4, -3), "fat_tower_base", lllllllllllllllIllIIIIlIlIIIIIIl, true));
                lllllllllllllllIllIIIIlIlIIIIIII = func_189935_b(lllllllllllllllIllIIIIlIlIIIIIll, func_191090_b(lllllllllllllllIllIIIIlIlIIIIlll, lllllllllllllllIllIIIIlIlIIIIIII, new BlockPos(0, 4, 0), "fat_tower_middle", lllllllllllllllIllIIIIlIlIIIIIIl, true));
                for (int lllllllllllllllIllIIIIlIIlllllll = 0; lllllllllllllllIllIIIIlIIlllllll < 2 && lllllllllllllllIllIIIIlIlIIIIIlI.nextInt(3) != 0; ++lllllllllllllllIllIIIIlIIlllllll) {
                    lllllllllllllllIllIIIIlIlIIIIIII = func_189935_b(lllllllllllllllIllIIIIlIlIIIIIll, func_191090_b(lllllllllllllllIllIIIIlIlIIIIlll, lllllllllllllllIllIIIIlIlIIIIIII, new BlockPos(0, 8, 0), "fat_tower_middle", lllllllllllllllIllIIIIlIlIIIIIIl, true));
                    for (final Tuple<Rotation, BlockPos> lllllllllllllllIllIIIIlIIllllllI : StructureEndCityPieces.FAT_TOWER_BRIDGES) {
                        if (lllllllllllllllIllIIIIlIlIIIIIlI.nextBoolean()) {
                            final CityTemplate lllllllllllllllIllIIIIlIIlllllIl = func_189935_b(lllllllllllllllIllIIIIlIlIIIIIll, func_191090_b(lllllllllllllllIllIIIIlIlIIIIlll, lllllllllllllllIllIIIIlIlIIIIIII, lllllllllllllllIllIIIIlIIllllllI.getSecond(), "bridge_end", lllllllllllllllIllIIIIlIlIIIIIIl.add(lllllllllllllllIllIIIIlIIllllllI.getFirst()), true));
                            func_191088_b(lllllllllllllllIllIIIIlIlIIIIlll, StructureEndCityPieces.TOWER_BRIDGE_GENERATOR, lllllllllllllllIllIIIIlIIllllIll + 1, lllllllllllllllIllIIIIlIIlllllIl, null, lllllllllllllllIllIIIIlIlIIIIIll, lllllllllllllllIllIIIIlIlIIIIIlI);
                        }
                    }
                }
                func_189935_b(lllllllllllllllIllIIIIlIlIIIIIll, func_191090_b(lllllllllllllllIllIIIIlIlIIIIlll, lllllllllllllllIllIIIIlIlIIIIIII, new BlockPos(-2, 8, -2), "fat_tower_top", lllllllllllllllIllIIIIlIlIIIIIIl, true));
                return true;
            }
            
            @Override
            public void init() {
            }
        };
    }
    
    public static class CityTemplate extends StructureComponentTemplate
    {
        private /* synthetic */ boolean overwrite;
        private /* synthetic */ String pieceName;
        private /* synthetic */ Rotation rotation;
        
        public CityTemplate() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIIIIIIlllllIlIlIIlIl) {
            super.writeStructureToNBT(lllllllllllIIIIIIIlllllIlIlIIlIl);
            lllllllllllIIIIIIIlllllIlIlIIlIl.setString("Template", this.pieceName);
            lllllllllllIIIIIIIlllllIlIlIIlIl.setString("Rot", this.rotation.name());
            lllllllllllIIIIIIIlllllIlIlIIlIl.setBoolean("OW", this.overwrite);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIIIIIIlllllIlIIlllIl, final TemplateManager lllllllllllIIIIIIIlllllIlIIlllII) {
            super.readStructureFromNBT(lllllllllllIIIIIIIlllllIlIIlllIl, lllllllllllIIIIIIIlllllIlIIlllII);
            this.pieceName = lllllllllllIIIIIIIlllllIlIIlllIl.getString("Template");
            this.rotation = Rotation.valueOf(lllllllllllIIIIIIIlllllIlIIlllIl.getString("Rot"));
            this.overwrite = lllllllllllIIIIIIIlllllIlIIlllIl.getBoolean("OW");
            this.func_191085_a(lllllllllllIIIIIIIlllllIlIIlllII);
        }
        
        @Override
        protected void handleDataMarker(final String lllllllllllIIIIIIIlllllIlIIlIIlI, final BlockPos lllllllllllIIIIIIIlllllIlIIIIlll, final World lllllllllllIIIIIIIlllllIlIIIIllI, final Random lllllllllllIIIIIIIlllllIlIIIIlIl, final StructureBoundingBox lllllllllllIIIIIIIlllllIlIIIlllI) {
            if (lllllllllllIIIIIIIlllllIlIIlIIlI.startsWith("Chest")) {
                final BlockPos lllllllllllIIIIIIIlllllIlIIIllIl = lllllllllllIIIIIIIlllllIlIIIIlll.down();
                if (lllllllllllIIIIIIIlllllIlIIIlllI.isVecInside(lllllllllllIIIIIIIlllllIlIIIllIl)) {
                    final TileEntity lllllllllllIIIIIIIlllllIlIIIllII = lllllllllllIIIIIIIlllllIlIIIIllI.getTileEntity(lllllllllllIIIIIIIlllllIlIIIllIl);
                    if (lllllllllllIIIIIIIlllllIlIIIllII instanceof TileEntityChest) {
                        ((TileEntityChest)lllllllllllIIIIIIIlllllIlIIIllII).setLootTable(LootTableList.CHESTS_END_CITY_TREASURE, lllllllllllIIIIIIIlllllIlIIIIlIl.nextLong());
                    }
                }
            }
            else if (lllllllllllIIIIIIIlllllIlIIlIIlI.startsWith("Sentry")) {
                final EntityShulker lllllllllllIIIIIIIlllllIlIIIlIll = new EntityShulker(lllllllllllIIIIIIIlllllIlIIIIllI);
                lllllllllllIIIIIIIlllllIlIIIlIll.setPosition(lllllllllllIIIIIIIlllllIlIIIIlll.getX() + 0.5, lllllllllllIIIIIIIlllllIlIIIIlll.getY() + 0.5, lllllllllllIIIIIIIlllllIlIIIIlll.getZ() + 0.5);
                lllllllllllIIIIIIIlllllIlIIIlIll.setAttachmentPos(lllllllllllIIIIIIIlllllIlIIIIlll);
                lllllllllllIIIIIIIlllllIlIIIIllI.spawnEntityInWorld(lllllllllllIIIIIIIlllllIlIIIlIll);
            }
            else if (lllllllllllIIIIIIIlllllIlIIlIIlI.startsWith("Elytra")) {
                final EntityItemFrame lllllllllllIIIIIIIlllllIlIIIlIlI = new EntityItemFrame(lllllllllllIIIIIIIlllllIlIIIIllI, lllllllllllIIIIIIIlllllIlIIIIlll, this.rotation.rotate(EnumFacing.SOUTH));
                lllllllllllIIIIIIIlllllIlIIIlIlI.setDisplayedItem(new ItemStack(Items.ELYTRA));
                lllllllllllIIIIIIIlllllIlIIIIllI.spawnEntityInWorld(lllllllllllIIIIIIIlllllIlIIIlIlI);
            }
        }
        
        public CityTemplate(final TemplateManager lllllllllllIIIIIIIlllllIlIlllIll, final String lllllllllllIIIIIIIlllllIllIIIIII, final BlockPos lllllllllllIIIIIIIlllllIlIlllIIl, final Rotation lllllllllllIIIIIIIlllllIlIlllllI, final boolean lllllllllllIIIIIIIlllllIlIllIlll) {
            super(0);
            this.pieceName = lllllllllllIIIIIIIlllllIllIIIIII;
            this.templatePosition = lllllllllllIIIIIIIlllllIlIlllIIl;
            this.rotation = lllllllllllIIIIIIIlllllIlIlllllI;
            this.overwrite = lllllllllllIIIIIIIlllllIlIllIlll;
            this.func_191085_a(lllllllllllIIIIIIIlllllIlIlllIll);
        }
        
        private void func_191085_a(final TemplateManager lllllllllllIIIIIIIlllllIlIllIIIl) {
            final Template lllllllllllIIIIIIIlllllIlIllIIII = lllllllllllIIIIIIIlllllIlIllIIIl.getTemplate(null, new ResourceLocation("endcity/" + this.pieceName));
            final PlacementSettings lllllllllllIIIIIIIlllllIlIlIllll = (this.overwrite ? StructureEndCityPieces.OVERWRITE : StructureEndCityPieces.INSERT).copy().setRotation(this.rotation);
            this.setup(lllllllllllIIIIIIIlllllIlIllIIII, this.templatePosition, lllllllllllIIIIIIIlllllIlIlIllll);
        }
    }
    
    interface IGenerator
    {
        boolean func_191086_a(final TemplateManager p0, final int p1, final CityTemplate p2, final BlockPos p3, final List<StructureComponent> p4, final Random p5);
        
        void init();
    }
}
