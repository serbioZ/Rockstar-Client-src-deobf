// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Collections;
import javax.annotation.Nullable;
import net.minecraft.util.Tuple;
import com.google.common.collect.Lists;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockChest;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.Mirror;
import java.util.Random;
import java.util.List;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WoodlandMansionPieces
{
    public static void func_191153_a() {
        MapGenStructureIO.registerStructureComponent(MansionTemplate.class, "WMP");
    }
    
    public static void func_191152_a(final TemplateManager lllllllllllllIllIIIlIIllIIlIlIlI, final BlockPos lllllllllllllIllIIIlIIllIIlIlIIl, final Rotation lllllllllllllIllIIIlIIllIIlIIIIl, final List<MansionTemplate> lllllllllllllIllIIIlIIllIIlIIlll, final Random lllllllllllllIllIIIlIIllIIlIIllI) {
        final Grid lllllllllllllIllIIIlIIllIIlIIlIl = new Grid(lllllllllllllIllIIIlIIllIIlIIllI);
        final Placer lllllllllllllIllIIIlIIllIIlIIlII = new Placer(lllllllllllllIllIIIlIIllIIlIlIlI, lllllllllllllIllIIIlIIllIIlIIllI);
        lllllllllllllIllIIIlIIllIIlIIlII.func_191125_a(lllllllllllllIllIIIlIIllIIlIlIIl, lllllllllllllIllIIIlIIllIIlIIIIl, lllllllllllllIllIIIlIIllIIlIIlll, lllllllllllllIllIIIlIIllIIlIIlIl);
    }
    
    public static class MansionTemplate extends StructureComponentTemplate
    {
        private /* synthetic */ Mirror field_191084_f;
        private /* synthetic */ String field_191082_d;
        private /* synthetic */ Rotation field_191083_e;
        
        public MansionTemplate(final TemplateManager llllllllllllIlIIIllIllIIllllllII, final String llllllllllllIlIIIllIllIlIIIIIIII, final BlockPos llllllllllllIlIIIllIllIIlllllIlI, final Rotation llllllllllllIlIIIllIllIIlllllllI) {
            this(llllllllllllIlIIIllIllIIllllllII, llllllllllllIlIIIllIllIlIIIIIIII, llllllllllllIlIIIllIllIIlllllIlI, llllllllllllIlIIIllIllIIlllllllI, Mirror.NONE);
        }
        
        @Override
        protected void handleDataMarker(final String llllllllllllIlIIIllIllIIlIlllIII, final BlockPos llllllllllllIlIIIllIllIIllIIIIIl, final World llllllllllllIlIIIllIllIIlIllIllI, final Random llllllllllllIlIIIllIllIIlIllIlIl, final StructureBoundingBox llllllllllllIlIIIllIllIIlIlllllI) {
            if (llllllllllllIlIIIllIllIIlIlllIII.startsWith("Chest")) {
                final Rotation llllllllllllIlIIIllIllIIlIllllIl = this.placeSettings.getRotation();
                IBlockState llllllllllllIlIIIllIllIIlIllllII = Blocks.CHEST.getDefaultState();
                if ("ChestWest".equals(llllllllllllIlIIIllIllIIlIlllIII)) {
                    llllllllllllIlIIIllIllIIlIllllII = llllllllllllIlIIIllIllIIlIllllII.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllIlIIIllIllIIlIllllIl.rotate(EnumFacing.WEST));
                }
                else if ("ChestEast".equals(llllllllllllIlIIIllIllIIlIlllIII)) {
                    llllllllllllIlIIIllIllIIlIllllII = llllllllllllIlIIIllIllIIlIllllII.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllIlIIIllIllIIlIllllIl.rotate(EnumFacing.EAST));
                }
                else if ("ChestSouth".equals(llllllllllllIlIIIllIllIIlIlllIII)) {
                    llllllllllllIlIIIllIllIIlIllllII = llllllllllllIlIIIllIllIIlIllllII.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllIlIIIllIllIIlIllllIl.rotate(EnumFacing.SOUTH));
                }
                else if ("ChestNorth".equals(llllllllllllIlIIIllIllIIlIlllIII)) {
                    llllllllllllIlIIIllIllIIlIllllII = llllllllllllIlIIIllIllIIlIllllII.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllIlIIIllIllIIlIllllIl.rotate(EnumFacing.NORTH));
                }
                this.func_191080_a(llllllllllllIlIIIllIllIIlIllIllI, llllllllllllIlIIIllIllIIlIlllllI, llllllllllllIlIIIllIllIIlIllIlIl, llllllllllllIlIIIllIllIIllIIIIIl, LootTableList.field_191192_o, llllllllllllIlIIIllIllIIlIllllII);
            }
            else if ("Mage".equals(llllllllllllIlIIIllIllIIlIlllIII)) {
                final EntityEvoker llllllllllllIlIIIllIllIIlIlllIll = new EntityEvoker(llllllllllllIlIIIllIllIIlIllIllI);
                llllllllllllIlIIIllIllIIlIlllIll.enablePersistence();
                llllllllllllIlIIIllIllIIlIlllIll.moveToBlockPosAndAngles(llllllllllllIlIIIllIllIIllIIIIIl, 0.0f, 0.0f);
                llllllllllllIlIIIllIllIIlIllIllI.spawnEntityInWorld(llllllllllllIlIIIllIllIIlIlllIll);
                llllllllllllIlIIIllIllIIlIllIllI.setBlockState(llllllllllllIlIIIllIllIIllIIIIIl, Blocks.AIR.getDefaultState(), 2);
            }
            else if ("Warrior".equals(llllllllllllIlIIIllIllIIlIlllIII)) {
                final EntityVindicator llllllllllllIlIIIllIllIIlIlllIlI = new EntityVindicator(llllllllllllIlIIIllIllIIlIllIllI);
                llllllllllllIlIIIllIllIIlIlllIlI.enablePersistence();
                llllllllllllIlIIIllIllIIlIlllIlI.moveToBlockPosAndAngles(llllllllllllIlIIIllIllIIllIIIIIl, 0.0f, 0.0f);
                llllllllllllIlIIIllIllIIlIlllIlI.onInitialSpawn(llllllllllllIlIIIllIllIIlIllIllI.getDifficultyForLocation(new BlockPos(llllllllllllIlIIIllIllIIlIlllIlI)), null);
                llllllllllllIlIIIllIllIIlIllIllI.spawnEntityInWorld(llllllllllllIlIIIllIllIIlIlllIlI);
                llllllllllllIlIIIllIllIIlIllIllI.setBlockState(llllllllllllIlIIIllIllIIllIIIIIl, Blocks.AIR.getDefaultState(), 2);
            }
        }
        
        private void func_191081_a(final TemplateManager llllllllllllIlIIIllIllIIlllIIIIl) {
            final Template llllllllllllIlIIIllIllIIlllIIIII = llllllllllllIlIIIllIllIIlllIIIIl.getTemplate(null, new ResourceLocation("mansion/" + this.field_191082_d));
            final PlacementSettings llllllllllllIlIIIllIllIIllIlllll = new PlacementSettings().setIgnoreEntities(true).setRotation(this.field_191083_e).setMirror(this.field_191084_f);
            this.setup(llllllllllllIlIIIllIllIIlllIIIII, this.templatePosition, llllllllllllIlIIIllIllIIllIlllll);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllIlIIIllIllIIllIlIlll) {
            super.writeStructureToNBT(llllllllllllIlIIIllIllIIllIlIlll);
            llllllllllllIlIIIllIllIIllIlIlll.setString("Template", this.field_191082_d);
            llllllllllllIlIIIllIllIIllIlIlll.setString("Rot", this.placeSettings.getRotation().name());
            llllllllllllIlIIIllIllIIllIlIlll.setString("Mi", this.placeSettings.getMirror().name());
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllIlIIIllIllIIllIlIIII, final TemplateManager llllllllllllIlIIIllIllIIllIIllll) {
            super.readStructureFromNBT(llllllllllllIlIIIllIllIIllIlIIII, llllllllllllIlIIIllIllIIllIIllll);
            this.field_191082_d = llllllllllllIlIIIllIllIIllIlIIII.getString("Template");
            this.field_191083_e = Rotation.valueOf(llllllllllllIlIIIllIllIIllIlIIII.getString("Rot"));
            this.field_191084_f = Mirror.valueOf(llllllllllllIlIIIllIllIIllIlIIII.getString("Mi"));
            this.func_191081_a(llllllllllllIlIIIllIllIIllIIllll);
        }
        
        public MansionTemplate() {
        }
        
        public MansionTemplate(final TemplateManager llllllllllllIlIIIllIllIIllllIIIl, final String llllllllllllIlIIIllIllIIllllIIII, final BlockPos llllllllllllIlIIIllIllIIlllIllll, final Rotation llllllllllllIlIIIllIllIIlllIlllI, final Mirror llllllllllllIlIIIllIllIIlllIllIl) {
            super(0);
            this.field_191082_d = llllllllllllIlIIIllIllIIllllIIII;
            this.templatePosition = llllllllllllIlIIIllIllIIlllIllll;
            this.field_191083_e = llllllllllllIlIIIllIllIIlllIlllI;
            this.field_191084_f = llllllllllllIlIIIllIllIIlllIllIl;
            this.func_191081_a(llllllllllllIlIIIllIllIIllllIIIl);
        }
    }
    
    static class Grid
    {
        private final /* synthetic */ Random field_191117_a;
        private final /* synthetic */ SimpleGrid[] field_191120_d;
        private final /* synthetic */ int field_191121_e;
        private final /* synthetic */ SimpleGrid field_191119_c;
        private final /* synthetic */ SimpleGrid field_191118_b;
        private final /* synthetic */ int field_191122_f;
        
        public static boolean func_191109_a(final SimpleGrid lllllllllllIllllIIIlIlIIIIllllII, final int lllllllllllIllllIIIlIlIIIIllllll, final int lllllllllllIllllIIIlIlIIIIlllllI) {
            final int lllllllllllIllllIIIlIlIIIIllllIl = lllllllllllIllllIIIlIlIIIIllllII.func_191145_a(lllllllllllIllllIIIlIlIIIIllllll, lllllllllllIllllIIIlIlIIIIlllllI);
            return lllllllllllIllllIIIlIlIIIIllllIl == 1 || lllllllllllIllllIIIlIlIIIIllllIl == 2 || lllllllllllIllllIIIlIlIIIIllllIl == 3 || lllllllllllIllllIIIlIlIIIIllllIl == 4;
        }
        
        private boolean func_191111_a(final SimpleGrid lllllllllllIllllIIIlIIlllllIIIII) {
            boolean lllllllllllIllllIIIlIIlllllIIlIl = false;
            for (int lllllllllllIllllIIIlIIlllllIIlII = 0; lllllllllllIllllIIIlIIlllllIIlII < lllllllllllIllllIIIlIIlllllIIIII.field_191150_c; ++lllllllllllIllllIIIlIIlllllIIlII) {
                for (int lllllllllllIllllIIIlIIlllllIIIll = 0; lllllllllllIllllIIIlIIlllllIIIll < lllllllllllIllllIIIlIIlllllIIIII.field_191149_b; ++lllllllllllIllllIIIlIIlllllIIIll) {
                    if (lllllllllllIllllIIIlIIlllllIIIII.func_191145_a(lllllllllllIllllIIIlIIlllllIIIll, lllllllllllIllllIIIlIIlllllIIlII) == 0) {
                        int lllllllllllIllllIIIlIIlllllIIIlI = 0;
                        lllllllllllIllllIIIlIIlllllIIIlI += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll + 1, lllllllllllIllllIIIlIIlllllIIlII) ? 1 : 0);
                        lllllllllllIllllIIIlIIlllllIIIlI += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll - 1, lllllllllllIllllIIIlIIlllllIIlII) ? 1 : 0);
                        lllllllllllIllllIIIlIIlllllIIIlI += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll, lllllllllllIllllIIIlIIlllllIIlII + 1) ? 1 : 0);
                        lllllllllllIllllIIIlIIlllllIIIlI += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll, lllllllllllIllllIIIlIIlllllIIlII - 1) ? 1 : 0);
                        if (lllllllllllIllllIIIlIIlllllIIIlI >= 3) {
                            lllllllllllIllllIIIlIIlllllIIIII.func_191144_a(lllllllllllIllllIIIlIIlllllIIIll, lllllllllllIllllIIIlIIlllllIIlII, 2);
                            lllllllllllIllllIIIlIIlllllIIlIl = true;
                        }
                        else if (lllllllllllIllllIIIlIIlllllIIIlI == 2) {
                            int lllllllllllIllllIIIlIIlllllIIIIl = 0;
                            lllllllllllIllllIIIlIIlllllIIIIl += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll + 1, lllllllllllIllllIIIlIIlllllIIlII + 1) ? 1 : 0);
                            lllllllllllIllllIIIlIIlllllIIIIl += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll - 1, lllllllllllIllllIIIlIIlllllIIlII + 1) ? 1 : 0);
                            lllllllllllIllllIIIlIIlllllIIIIl += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll + 1, lllllllllllIllllIIIlIIlllllIIlII - 1) ? 1 : 0);
                            lllllllllllIllllIIIlIIlllllIIIIl += (func_191109_a(lllllllllllIllllIIIlIIlllllIIIII, lllllllllllIllllIIIlIIlllllIIIll - 1, lllllllllllIllllIIIlIIlllllIIlII - 1) ? 1 : 0);
                            if (lllllllllllIllllIIIlIIlllllIIIIl <= 1) {
                                lllllllllllIllllIIIlIIlllllIIIII.func_191144_a(lllllllllllIllllIIIlIIlllllIIIll, lllllllllllIllllIIIlIIlllllIIlII, 2);
                                lllllllllllIllllIIIlIIlllllIIlIl = true;
                            }
                        }
                    }
                }
            }
            return lllllllllllIllllIIIlIIlllllIIlIl;
        }
        
        private void func_191115_b() {
            final List<Tuple<Integer, Integer>> lllllllllllIllllIIIlIIllllIIllII = (List<Tuple<Integer, Integer>>)Lists.newArrayList();
            final SimpleGrid lllllllllllIllllIIIlIIllllIIlIll = this.field_191120_d[1];
            for (int lllllllllllIllllIIIlIIllllIIlIlI = 0; lllllllllllIllllIIIlIIllllIIlIlI < this.field_191119_c.field_191150_c; ++lllllllllllIllllIIIlIIllllIIlIlI) {
                for (int lllllllllllIllllIIIlIIllllIIlIIl = 0; lllllllllllIllllIIIlIIllllIIlIIl < this.field_191119_c.field_191149_b; ++lllllllllllIllllIIIlIIllllIIlIIl) {
                    final int lllllllllllIllllIIIlIIllllIIlIII = lllllllllllIllllIIIlIIllllIIlIll.func_191145_a(lllllllllllIllllIIIlIIllllIIlIIl, lllllllllllIllllIIIlIIllllIIlIlI);
                    final int lllllllllllIllllIIIlIIllllIIIlll = lllllllllllIllllIIIlIIllllIIlIII & 0xF0000;
                    if (lllllllllllIllllIIIlIIllllIIIlll == 131072 && (lllllllllllIllllIIIlIIllllIIlIII & 0x200000) == 0x200000) {
                        lllllllllllIllllIIIlIIllllIIllII.add(new Tuple<Integer, Integer>(lllllllllllIllllIIIlIIllllIIlIIl, lllllllllllIllllIIIlIIllllIIlIlI));
                    }
                }
            }
            if (lllllllllllIllllIIIlIIllllIIllII.isEmpty()) {
                this.field_191119_c.func_191142_a(0, 0, this.field_191119_c.field_191149_b, this.field_191119_c.field_191150_c, 5);
            }
            else {
                final Tuple<Integer, Integer> lllllllllllIllllIIIlIIllllIIIllI = lllllllllllIllllIIIlIIllllIIllII.get(this.field_191117_a.nextInt(lllllllllllIllllIIIlIIllllIIllII.size()));
                final int lllllllllllIllllIIIlIIllllIIIlIl = lllllllllllIllllIIIlIIllllIIlIll.func_191145_a(lllllllllllIllllIIIlIIllllIIIllI.getFirst(), lllllllllllIllllIIIlIIllllIIIllI.getSecond());
                lllllllllllIllllIIIlIIllllIIlIll.func_191144_a(lllllllllllIllllIIIlIIllllIIIllI.getFirst(), lllllllllllIllllIIIlIIllllIIIllI.getSecond(), lllllllllllIllllIIIlIIllllIIIlIl | 0x400000);
                final EnumFacing lllllllllllIllllIIIlIIllllIIIlII = this.func_191113_b(this.field_191118_b, lllllllllllIllllIIIlIIllllIIIllI.getFirst(), lllllllllllIllllIIIlIIllllIIIllI.getSecond(), 1, lllllllllllIllllIIIlIIllllIIIlIl & 0xFFFF);
                final int lllllllllllIllllIIIlIIllllIIIIll = lllllllllllIllllIIIlIIllllIIIllI.getFirst() + lllllllllllIllllIIIlIIllllIIIlII.getFrontOffsetX();
                final int lllllllllllIllllIIIlIIllllIIIIlI = lllllllllllIllllIIIlIIllllIIIllI.getSecond() + lllllllllllIllllIIIlIIllllIIIlII.getFrontOffsetZ();
                for (int lllllllllllIllllIIIlIIllllIIIIIl = 0; lllllllllllIllllIIIlIIllllIIIIIl < this.field_191119_c.field_191150_c; ++lllllllllllIllllIIIlIIllllIIIIIl) {
                    for (int lllllllllllIllllIIIlIIllllIIIIII = 0; lllllllllllIllllIIIlIIllllIIIIII < this.field_191119_c.field_191149_b; ++lllllllllllIllllIIIlIIllllIIIIII) {
                        if (!func_191109_a(this.field_191118_b, lllllllllllIllllIIIlIIllllIIIIII, lllllllllllIllllIIIlIIllllIIIIIl)) {
                            this.field_191119_c.func_191144_a(lllllllllllIllllIIIlIIllllIIIIII, lllllllllllIllllIIIlIIllllIIIIIl, 5);
                        }
                        else if (lllllllllllIllllIIIlIIllllIIIIII == lllllllllllIllllIIIlIIllllIIIllI.getFirst() && lllllllllllIllllIIIlIIllllIIIIIl == lllllllllllIllllIIIlIIllllIIIllI.getSecond()) {
                            this.field_191119_c.func_191144_a(lllllllllllIllllIIIlIIllllIIIIII, lllllllllllIllllIIIlIIllllIIIIIl, 3);
                        }
                        else if (lllllllllllIllllIIIlIIllllIIIIII == lllllllllllIllllIIIlIIllllIIIIll && lllllllllllIllllIIIlIIllllIIIIIl == lllllllllllIllllIIIlIIllllIIIIlI) {
                            this.field_191119_c.func_191144_a(lllllllllllIllllIIIlIIllllIIIIII, lllllllllllIllllIIIlIIllllIIIIIl, 3);
                            this.field_191120_d[2].func_191144_a(lllllllllllIllllIIIlIIllllIIIIII, lllllllllllIllllIIIlIIllllIIIIIl, 8388608);
                        }
                    }
                }
                final List<EnumFacing> lllllllllllIllllIIIlIIlllIllllll = (List<EnumFacing>)Lists.newArrayList();
                final int lllllllllllIllllIIIlIIlllIllIIII;
                final boolean lllllllllllIllllIIIlIIlllIllIIIl = ((EnumFacing[])(Object)(lllllllllllIllllIIIlIIlllIllIIII = (int)(Object)EnumFacing.Plane.HORIZONTAL.facings())).length != 0;
                for (char lllllllllllIllllIIIlIIlllIllIIlI = '\0'; lllllllllllIllllIIIlIIlllIllIIlI < (lllllllllllIllllIIIlIIlllIllIIIl ? 1 : 0); ++lllllllllllIllllIIIlIIlllIllIIlI) {
                    final EnumFacing lllllllllllIllllIIIlIIlllIlllllI = lllllllllllIllllIIIlIIlllIllIIII[lllllllllllIllllIIIlIIlllIllIIlI];
                    if (this.field_191119_c.func_191145_a(lllllllllllIllllIIIlIIllllIIIIll + lllllllllllIllllIIIlIIlllIlllllI.getFrontOffsetX(), lllllllllllIllllIIIlIIllllIIIIlI + lllllllllllIllllIIIlIIlllIlllllI.getFrontOffsetZ()) == 0) {
                        lllllllllllIllllIIIlIIlllIllllll.add(lllllllllllIllllIIIlIIlllIlllllI);
                    }
                }
                if (lllllllllllIllllIIIlIIlllIllllll.isEmpty()) {
                    this.field_191119_c.func_191142_a(0, 0, this.field_191119_c.field_191149_b, this.field_191119_c.field_191150_c, 5);
                    lllllllllllIllllIIIlIIllllIIlIll.func_191144_a(lllllllllllIllllIIIlIIllllIIIllI.getFirst(), lllllllllllIllllIIIlIIllllIIIllI.getSecond(), lllllllllllIllllIIIlIIllllIIIlIl);
                }
                else {
                    final EnumFacing lllllllllllIllllIIIlIIlllIllllIl = lllllllllllIllllIIIlIIlllIllllll.get(this.field_191117_a.nextInt(lllllllllllIllllIIIlIIlllIllllll.size()));
                    this.func_191110_a(this.field_191119_c, lllllllllllIllllIIIlIIllllIIIIll + lllllllllllIllllIIIlIIlllIllllIl.getFrontOffsetX(), lllllllllllIllllIIIlIIllllIIIIlI + lllllllllllIllllIIIlIIlllIllllIl.getFrontOffsetZ(), lllllllllllIllllIIIlIIlllIllllIl, 4);
                    while (this.func_191111_a(this.field_191119_c)) {}
                }
            }
        }
        
        @Nullable
        public EnumFacing func_191113_b(final SimpleGrid lllllllllllIllllIIIlIlIIIIIlllIl, final int lllllllllllIllllIIIlIlIIIIIlllII, final int lllllllllllIllllIIIlIlIIIIIlIlII, final int lllllllllllIllllIIIlIlIIIIIlIIll, final int lllllllllllIllllIIIlIlIIIIIllIIl) {
            final int lllllllllllIllllIIIlIlIIIIIIlllI;
            final char lllllllllllIllllIIIlIlIIIIIIllll = (char)((EnumFacing[])(Object)(lllllllllllIllllIIIlIlIIIIIIlllI = (int)(Object)EnumFacing.Plane.HORIZONTAL.facings())).length;
            for (boolean lllllllllllIllllIIIlIlIIIIIlIIII = false; (lllllllllllIllllIIIlIlIIIIIlIIII ? 1 : 0) < lllllllllllIllllIIIlIlIIIIIIllll; ++lllllllllllIllllIIIlIlIIIIIlIIII) {
                final EnumFacing lllllllllllIllllIIIlIlIIIIIllIII = lllllllllllIllllIIIlIlIIIIIIlllI[lllllllllllIllllIIIlIlIIIIIlIIII];
                if (this.func_191114_a(lllllllllllIllllIIIlIlIIIIIlllIl, lllllllllllIllllIIIlIlIIIIIlllII + lllllllllllIllllIIIlIlIIIIIllIII.getFrontOffsetX(), lllllllllllIllllIIIlIlIIIIIlIlII + lllllllllllIllllIIIlIlIIIIIllIII.getFrontOffsetZ(), lllllllllllIllllIIIlIlIIIIIlIIll, lllllllllllIllllIIIlIlIIIIIllIIl)) {
                    return lllllllllllIllllIIIlIlIIIIIllIII;
                }
            }
            return null;
        }
        
        public Grid(final Random lllllllllllIllllIIIlIlIIIlIIlIIl) {
            this.field_191117_a = lllllllllllIllllIIIlIlIIIlIIlIIl;
            final int lllllllllllIllllIIIlIlIIIlIIlIII = 11;
            this.field_191121_e = 7;
            this.field_191122_f = 4;
            this.field_191118_b = new SimpleGrid(11, 11, 5);
            this.field_191118_b.func_191142_a(this.field_191121_e, this.field_191122_f, this.field_191121_e + 1, this.field_191122_f + 1, 3);
            this.field_191118_b.func_191142_a(this.field_191121_e - 1, this.field_191122_f, this.field_191121_e - 1, this.field_191122_f + 1, 2);
            this.field_191118_b.func_191142_a(this.field_191121_e + 2, this.field_191122_f - 2, this.field_191121_e + 3, this.field_191122_f + 3, 5);
            this.field_191118_b.func_191142_a(this.field_191121_e + 1, this.field_191122_f - 2, this.field_191121_e + 1, this.field_191122_f - 1, 1);
            this.field_191118_b.func_191142_a(this.field_191121_e + 1, this.field_191122_f + 2, this.field_191121_e + 1, this.field_191122_f + 3, 1);
            this.field_191118_b.func_191144_a(this.field_191121_e - 1, this.field_191122_f - 1, 1);
            this.field_191118_b.func_191144_a(this.field_191121_e - 1, this.field_191122_f + 2, 1);
            this.field_191118_b.func_191142_a(0, 0, 11, 1, 5);
            this.field_191118_b.func_191142_a(0, 9, 11, 11, 5);
            this.func_191110_a(this.field_191118_b, this.field_191121_e, this.field_191122_f - 2, EnumFacing.WEST, 6);
            this.func_191110_a(this.field_191118_b, this.field_191121_e, this.field_191122_f + 3, EnumFacing.WEST, 6);
            this.func_191110_a(this.field_191118_b, this.field_191121_e - 2, this.field_191122_f - 1, EnumFacing.WEST, 3);
            this.func_191110_a(this.field_191118_b, this.field_191121_e - 2, this.field_191122_f + 2, EnumFacing.WEST, 3);
            while (this.func_191111_a(this.field_191118_b)) {}
            this.field_191120_d = new SimpleGrid[3];
            this.field_191120_d[0] = new SimpleGrid(11, 11, 5);
            this.field_191120_d[1] = new SimpleGrid(11, 11, 5);
            this.field_191120_d[2] = new SimpleGrid(11, 11, 5);
            this.func_191116_a(this.field_191118_b, this.field_191120_d[0]);
            this.func_191116_a(this.field_191118_b, this.field_191120_d[1]);
            this.field_191120_d[0].func_191142_a(this.field_191121_e + 1, this.field_191122_f, this.field_191121_e + 1, this.field_191122_f + 1, 8388608);
            this.field_191120_d[1].func_191142_a(this.field_191121_e + 1, this.field_191122_f, this.field_191121_e + 1, this.field_191122_f + 1, 8388608);
            this.field_191119_c = new SimpleGrid(this.field_191118_b.field_191149_b, this.field_191118_b.field_191150_c, 5);
            this.func_191115_b();
            this.func_191116_a(this.field_191119_c, this.field_191120_d[2]);
        }
        
        public boolean func_191114_a(final SimpleGrid lllllllllllIllllIIIlIlIIIIllIIlI, final int lllllllllllIllllIIIlIlIIIIllIIIl, final int lllllllllllIllllIIIlIlIIIIlIlIll, final int lllllllllllIllllIIIlIlIIIIlIlIlI, final int lllllllllllIllllIIIlIlIIIIlIlIIl) {
            return (this.field_191120_d[lllllllllllIllllIIIlIlIIIIlIlIlI].func_191145_a(lllllllllllIllllIIIlIlIIIIllIIIl, lllllllllllIllllIIIlIlIIIIlIlIll) & 0xFFFF) == lllllllllllIllllIIIlIlIIIIlIlIIl;
        }
        
        private void func_191110_a(final SimpleGrid lllllllllllIllllIIIlIIllllllIllI, final int lllllllllllIllllIIIlIlIIIIIIIIIl, final int lllllllllllIllllIIIlIlIIIIIIIIII, final EnumFacing lllllllllllIllllIIIlIIllllllIIll, final int lllllllllllIllllIIIlIIllllllIIlI) {
            if (lllllllllllIllllIIIlIIllllllIIlI > 0) {
                lllllllllllIllllIIIlIIllllllIllI.func_191144_a(lllllllllllIllllIIIlIlIIIIIIIIIl, lllllllllllIllllIIIlIlIIIIIIIIII, 1);
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetX(), lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetZ(), 0, 1);
                for (int lllllllllllIllllIIIlIIllllllllIl = 0; lllllllllllIllllIIIlIIllllllllIl < 8; ++lllllllllllIllllIIIlIIllllllllIl) {
                    final EnumFacing lllllllllllIllllIIIlIIllllllllII = EnumFacing.getHorizontal(this.field_191117_a.nextInt(4));
                    if (lllllllllllIllllIIIlIIllllllllII != lllllllllllIllllIIIlIIllllllIIll.getOpposite() && (lllllllllllIllllIIIlIIllllllllII != EnumFacing.EAST || !this.field_191117_a.nextBoolean())) {
                        final int lllllllllllIllllIIIlIIlllllllIll = lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetX();
                        final int lllllllllllIllllIIIlIIlllllllIlI = lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetZ();
                        if (lllllllllllIllllIIIlIIllllllIllI.func_191145_a(lllllllllllIllllIIIlIIlllllllIll + lllllllllllIllllIIIlIIllllllllII.getFrontOffsetX(), lllllllllllIllllIIIlIIlllllllIlI + lllllllllllIllllIIIlIIllllllllII.getFrontOffsetZ()) == 0 && lllllllllllIllllIIIlIIllllllIllI.func_191145_a(lllllllllllIllllIIIlIIlllllllIll + lllllllllllIllllIIIlIIllllllllII.getFrontOffsetX() * 2, lllllllllllIllllIIIlIIlllllllIlI + lllllllllllIllllIIIlIIllllllllII.getFrontOffsetZ() * 2) == 0) {
                            this.func_191110_a(lllllllllllIllllIIIlIIllllllIllI, lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetX() + lllllllllllIllllIIIlIIllllllllII.getFrontOffsetX(), lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetZ() + lllllllllllIllllIIIlIIllllllllII.getFrontOffsetZ(), lllllllllllIllllIIIlIIllllllllII, lllllllllllIllllIIIlIIllllllIIlI - 1);
                            break;
                        }
                    }
                }
                final EnumFacing lllllllllllIllllIIIlIIlllllllIIl = lllllllllllIllllIIIlIIllllllIIll.rotateY();
                final EnumFacing lllllllllllIllllIIIlIIlllllllIII = lllllllllllIllllIIIlIIllllllIIll.rotateYCCW();
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIlllllllIIl.getFrontOffsetX(), lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIlllllllIIl.getFrontOffsetZ(), 0, 2);
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIlllllllIII.getFrontOffsetX(), lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIlllllllIII.getFrontOffsetZ(), 0, 2);
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetX() + lllllllllllIllllIIIlIIlllllllIIl.getFrontOffsetX(), lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetZ() + lllllllllllIllllIIIlIIlllllllIIl.getFrontOffsetZ(), 0, 2);
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetX() + lllllllllllIllllIIIlIIlllllllIII.getFrontOffsetX(), lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetZ() + lllllllllllIllllIIIlIIlllllllIII.getFrontOffsetZ(), 0, 2);
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetX() * 2, lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIllllllIIll.getFrontOffsetZ() * 2, 0, 2);
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIlllllllIIl.getFrontOffsetX() * 2, lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIlllllllIIl.getFrontOffsetZ() * 2, 0, 2);
                lllllllllllIllllIIIlIIllllllIllI.func_191141_a(lllllllllllIllllIIIlIlIIIIIIIIIl + lllllllllllIllllIIIlIIlllllllIII.getFrontOffsetX() * 2, lllllllllllIllllIIIlIlIIIIIIIIII + lllllllllllIllllIIIlIIlllllllIII.getFrontOffsetZ() * 2, 0, 2);
            }
        }
        
        private void func_191116_a(final SimpleGrid lllllllllllIllllIIIlIIlllIIllIll, final SimpleGrid lllllllllllIllllIIIlIIlllIIIIllI) {
            final List<Tuple<Integer, Integer>> lllllllllllIllllIIIlIIlllIIllIIl = (List<Tuple<Integer, Integer>>)Lists.newArrayList();
            for (int lllllllllllIllllIIIlIIlllIIllIII = 0; lllllllllllIllllIIIlIIlllIIllIII < lllllllllllIllllIIIlIIlllIIllIll.field_191150_c; ++lllllllllllIllllIIIlIIlllIIllIII) {
                for (int lllllllllllIllllIIIlIIlllIIlIlll = 0; lllllllllllIllllIIIlIIlllIIlIlll < lllllllllllIllllIIIlIIlllIIllIll.field_191149_b; ++lllllllllllIllllIIIlIIlllIIlIlll) {
                    if (lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlll, lllllllllllIllllIIIlIIlllIIllIII) == 2) {
                        lllllllllllIllllIIIlIIlllIIllIIl.add(new Tuple<Integer, Integer>(lllllllllllIllllIIIlIIlllIIlIlll, lllllllllllIllllIIIlIIlllIIllIII));
                    }
                }
            }
            Collections.shuffle(lllllllllllIllllIIIlIIlllIIllIIl, this.field_191117_a);
            int lllllllllllIllllIIIlIIlllIIlIllI = 10;
            for (final Tuple<Integer, Integer> lllllllllllIllllIIIlIIlllIIlIlIl : lllllllllllIllllIIIlIIlllIIllIIl) {
                final int lllllllllllIllllIIIlIIlllIIlIlII = lllllllllllIllllIIIlIIlllIIlIlIl.getFirst();
                final int lllllllllllIllllIIIlIIlllIIlIIll = lllllllllllIllllIIIlIIlllIIlIlIl.getSecond();
                if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll) == 0) {
                    int lllllllllllIllllIIIlIIlllIIlIIlI = lllllllllllIllllIIIlIIlllIIlIlII;
                    int lllllllllllIllllIIIlIIlllIIlIIIl = lllllllllllIllllIIIlIIlllIIlIlII;
                    int lllllllllllIllllIIIlIIlllIIlIIII = lllllllllllIllllIIIlIIlllIIlIIll;
                    int lllllllllllIllllIIIlIIlllIIIllll = lllllllllllIllllIIIlIIlllIIlIIll;
                    int lllllllllllIllllIIIlIIlllIIIlllI = 65536;
                    if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII + 1, lllllllllllIllllIIIlIIlllIIlIIll) == 0 && lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 0 && lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII + 1, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 0 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII + 1, lllllllllllIllllIIIlIIlllIIlIIll) == 2 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 2 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII + 1, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 2) {
                        lllllllllllIllllIIIlIIlllIIlIIIl = lllllllllllIllllIIIlIIlllIIlIlII + 1;
                        lllllllllllIllllIIIlIIlllIIIllll = lllllllllllIllllIIIlIIlllIIlIIll + 1;
                        lllllllllllIllllIIIlIIlllIIIlllI = 262144;
                    }
                    else if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll) == 0 && lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 0 && lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 0 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll) == 2 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 2 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 2) {
                        lllllllllllIllllIIIlIIlllIIlIIlI = lllllllllllIllllIIIlIIlllIIlIlII - 1;
                        lllllllllllIllllIIIlIIlllIIIllll = lllllllllllIllllIIIlIIlllIIlIIll + 1;
                        lllllllllllIllllIIIlIIlllIIIlllI = 262144;
                    }
                    else if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll) == 0 && lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll - 1) == 0 && lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll - 1) == 0 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll) == 2 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll - 1) == 2 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll - 1) == 2) {
                        lllllllllllIllllIIIlIIlllIIlIIlI = lllllllllllIllllIIIlIIlllIIlIlII - 1;
                        lllllllllllIllllIIIlIIlllIIlIIII = lllllllllllIllllIIIlIIlllIIlIIll - 1;
                        lllllllllllIllllIIIlIIlllIIIlllI = 262144;
                    }
                    else if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII + 1, lllllllllllIllllIIIlIIlllIIlIIll) == 0 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII + 1, lllllllllllIllllIIIlIIlllIIlIIll) == 2) {
                        lllllllllllIllllIIIlIIlllIIlIIIl = lllllllllllIllllIIIlIIlllIIlIlII + 1;
                        lllllllllllIllllIIIlIIlllIIIlllI = 131072;
                    }
                    else if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 0 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll + 1) == 2) {
                        lllllllllllIllllIIIlIIlllIIIllll = lllllllllllIllllIIIlIIlllIIlIIll + 1;
                        lllllllllllIllllIIIlIIlllIIIlllI = 131072;
                    }
                    else if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll) == 0 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII - 1, lllllllllllIllllIIIlIIlllIIlIIll) == 2) {
                        lllllllllllIllllIIIlIIlllIIlIIlI = lllllllllllIllllIIIlIIlllIIlIlII - 1;
                        lllllllllllIllllIIIlIIlllIIIlllI = 131072;
                    }
                    else if (lllllllllllIllllIIIlIIlllIIIIllI.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll - 1) == 0 && lllllllllllIllllIIIlIIlllIIllIll.func_191145_a(lllllllllllIllllIIIlIIlllIIlIlII, lllllllllllIllllIIIlIIlllIIlIIll - 1) == 2) {
                        lllllllllllIllllIIIlIIlllIIlIIII = lllllllllllIllllIIIlIIlllIIlIIll - 1;
                        lllllllllllIllllIIIlIIlllIIIlllI = 131072;
                    }
                    int lllllllllllIllllIIIlIIlllIIIllIl = this.field_191117_a.nextBoolean() ? lllllllllllIllllIIIlIIlllIIlIIlI : lllllllllllIllllIIIlIIlllIIlIIIl;
                    int lllllllllllIllllIIIlIIlllIIIllII = this.field_191117_a.nextBoolean() ? lllllllllllIllllIIIlIIlllIIlIIII : lllllllllllIllllIIIlIIlllIIIllll;
                    int lllllllllllIllllIIIlIIlllIIIlIll = 2097152;
                    if (!lllllllllllIllllIIIlIIlllIIllIll.func_191147_b(lllllllllllIllllIIIlIIlllIIIllIl, lllllllllllIllllIIIlIIlllIIIllII, 1)) {
                        lllllllllllIllllIIIlIIlllIIIllIl = ((lllllllllllIllllIIIlIIlllIIIllIl == lllllllllllIllllIIIlIIlllIIlIIlI) ? lllllllllllIllllIIIlIIlllIIlIIIl : lllllllllllIllllIIIlIIlllIIlIIlI);
                        lllllllllllIllllIIIlIIlllIIIllII = ((lllllllllllIllllIIIlIIlllIIIllII == lllllllllllIllllIIIlIIlllIIlIIII) ? lllllllllllIllllIIIlIIlllIIIllll : lllllllllllIllllIIIlIIlllIIlIIII);
                        if (!lllllllllllIllllIIIlIIlllIIllIll.func_191147_b(lllllllllllIllllIIIlIIlllIIIllIl, lllllllllllIllllIIIlIIlllIIIllII, 1)) {
                            lllllllllllIllllIIIlIIlllIIIllII = ((lllllllllllIllllIIIlIIlllIIIllII == lllllllllllIllllIIIlIIlllIIlIIII) ? lllllllllllIllllIIIlIIlllIIIllll : lllllllllllIllllIIIlIIlllIIlIIII);
                            if (!lllllllllllIllllIIIlIIlllIIllIll.func_191147_b(lllllllllllIllllIIIlIIlllIIIllIl, lllllllllllIllllIIIlIIlllIIIllII, 1)) {
                                lllllllllllIllllIIIlIIlllIIIllIl = ((lllllllllllIllllIIIlIIlllIIIllIl == lllllllllllIllllIIIlIIlllIIlIIlI) ? lllllllllllIllllIIIlIIlllIIlIIIl : lllllllllllIllllIIIlIIlllIIlIIlI);
                                lllllllllllIllllIIIlIIlllIIIllII = ((lllllllllllIllllIIIlIIlllIIIllII == lllllllllllIllllIIIlIIlllIIlIIII) ? lllllllllllIllllIIIlIIlllIIIllll : lllllllllllIllllIIIlIIlllIIlIIII);
                                if (!lllllllllllIllllIIIlIIlllIIllIll.func_191147_b(lllllllllllIllllIIIlIIlllIIIllIl, lllllllllllIllllIIIlIIlllIIIllII, 1)) {
                                    lllllllllllIllllIIIlIIlllIIIlIll = 0;
                                    lllllllllllIllllIIIlIIlllIIIllIl = lllllllllllIllllIIIlIIlllIIlIIlI;
                                    lllllllllllIllllIIIlIIlllIIIllII = lllllllllllIllllIIIlIIlllIIlIIII;
                                }
                            }
                        }
                    }
                    for (int lllllllllllIllllIIIlIIlllIIIlIlI = lllllllllllIllllIIIlIIlllIIlIIII; lllllllllllIllllIIIlIIlllIIIlIlI <= lllllllllllIllllIIIlIIlllIIIllll; ++lllllllllllIllllIIIlIIlllIIIlIlI) {
                        for (int lllllllllllIllllIIIlIIlllIIIlIIl = lllllllllllIllllIIIlIIlllIIlIIlI; lllllllllllIllllIIIlIIlllIIIlIIl <= lllllllllllIllllIIIlIIlllIIlIIIl; ++lllllllllllIllllIIIlIIlllIIIlIIl) {
                            if (lllllllllllIllllIIIlIIlllIIIlIIl == lllllllllllIllllIIIlIIlllIIIllIl && lllllllllllIllllIIIlIIlllIIIlIlI == lllllllllllIllllIIIlIIlllIIIllII) {
                                lllllllllllIllllIIIlIIlllIIIIllI.func_191144_a(lllllllllllIllllIIIlIIlllIIIlIIl, lllllllllllIllllIIIlIIlllIIIlIlI, 0x100000 | lllllllllllIllllIIIlIIlllIIIlIll | lllllllllllIllllIIIlIIlllIIIlllI | lllllllllllIllllIIIlIIlllIIlIllI);
                            }
                            else {
                                lllllllllllIllllIIIlIIlllIIIIllI.func_191144_a(lllllllllllIllllIIIlIIlllIIIlIIl, lllllllllllIllllIIIlIIlllIIIlIlI, lllllllllllIllllIIIlIIlllIIIlllI | lllllllllllIllllIIIlIIlllIIlIllI);
                            }
                        }
                    }
                    ++lllllllllllIllllIIIlIIlllIIlIllI;
                }
            }
        }
    }
    
    static class SimpleGrid
    {
        private final /* synthetic */ int field_191151_d;
        private final /* synthetic */ int field_191149_b;
        private final /* synthetic */ int[][] field_191148_a;
        private final /* synthetic */ int field_191150_c;
        
        public SimpleGrid(final int llllllllllIlllllIlIlIllIlllllIll, final int llllllllllIlllllIlIlIllIllllIllI, final int llllllllllIlllllIlIlIllIllllIlIl) {
            this.field_191149_b = llllllllllIlllllIlIlIllIlllllIll;
            this.field_191150_c = llllllllllIlllllIlIlIllIllllIllI;
            this.field_191151_d = llllllllllIlllllIlIlIllIllllIlIl;
            this.field_191148_a = new int[llllllllllIlllllIlIlIllIlllllIll][llllllllllIlllllIlIlIllIllllIllI];
        }
        
        public int func_191145_a(final int llllllllllIlllllIlIlIllIllIIllII, final int llllllllllIlllllIlIlIllIllIIlIII) {
            return (llllllllllIlllllIlIlIllIllIIllII >= 0 && llllllllllIlllllIlIlIllIllIIllII < this.field_191149_b && llllllllllIlllllIlIlIllIllIIlIII >= 0 && llllllllllIlllllIlIlIllIllIIlIII < this.field_191150_c) ? this.field_191148_a[llllllllllIlllllIlIlIllIllIIllII][llllllllllIlllllIlIlIllIllIIlIII] : this.field_191151_d;
        }
        
        public void func_191141_a(final int llllllllllIlllllIlIlIllIlIllllII, final int llllllllllIlllllIlIlIllIllIIIIII, final int llllllllllIlllllIlIlIllIlIllllll, final int llllllllllIlllllIlIlIllIlIlllIIl) {
            if (this.func_191145_a(llllllllllIlllllIlIlIllIlIllllII, llllllllllIlllllIlIlIllIllIIIIII) == llllllllllIlllllIlIlIllIlIllllll) {
                this.func_191144_a(llllllllllIlllllIlIlIllIlIllllII, llllllllllIlllllIlIlIllIllIIIIII, llllllllllIlllllIlIlIllIlIlllIIl);
            }
        }
        
        public void func_191142_a(final int llllllllllIlllllIlIlIllIllIlllll, final int llllllllllIlllllIlIlIllIllIlIllI, final int llllllllllIlllllIlIlIllIllIlIlIl, final int llllllllllIlllllIlIlIllIllIlllII, final int llllllllllIlllllIlIlIllIllIlIIll) {
            for (int llllllllllIlllllIlIlIllIllIllIlI = llllllllllIlllllIlIlIllIllIlIllI; llllllllllIlllllIlIlIllIllIllIlI <= llllllllllIlllllIlIlIllIllIlllII; ++llllllllllIlllllIlIlIllIllIllIlI) {
                for (int llllllllllIlllllIlIlIllIllIllIIl = llllllllllIlllllIlIlIllIllIlllll; llllllllllIlllllIlIlIllIllIllIIl <= llllllllllIlllllIlIlIllIllIlIlIl; ++llllllllllIlllllIlIlIllIllIllIIl) {
                    this.func_191144_a(llllllllllIlllllIlIlIllIllIllIIl, llllllllllIlllllIlIlIllIllIllIlI, llllllllllIlllllIlIlIllIllIlIIll);
                }
            }
        }
        
        public boolean func_191147_b(final int llllllllllIlllllIlIlIllIlIllIIll, final int llllllllllIlllllIlIlIllIlIllIIlI, final int llllllllllIlllllIlIlIllIlIllIIIl) {
            return this.func_191145_a(llllllllllIlllllIlIlIllIlIllIIll - 1, llllllllllIlllllIlIlIllIlIllIIlI) == llllllllllIlllllIlIlIllIlIllIIIl || this.func_191145_a(llllllllllIlllllIlIlIllIlIllIIll + 1, llllllllllIlllllIlIlIllIlIllIIlI) == llllllllllIlllllIlIlIllIlIllIIIl || this.func_191145_a(llllllllllIlllllIlIlIllIlIllIIll, llllllllllIlllllIlIlIllIlIllIIlI + 1) == llllllllllIlllllIlIlIllIlIllIIIl || this.func_191145_a(llllllllllIlllllIlIlIllIlIllIIll, llllllllllIlllllIlIlIllIlIllIIlI - 1) == llllllllllIlllllIlIlIllIlIllIIIl;
        }
        
        public void func_191144_a(final int llllllllllIlllllIlIlIllIlllIllll, final int llllllllllIlllllIlIlIllIlllIlIlI, final int llllllllllIlllllIlIlIllIlllIlIIl) {
            if (llllllllllIlllllIlIlIllIlllIllll >= 0 && llllllllllIlllllIlIlIllIlllIllll < this.field_191149_b && llllllllllIlllllIlIlIllIlllIlIlI >= 0 && llllllllllIlllllIlIlIllIlllIlIlI < this.field_191150_c) {
                this.field_191148_a[llllllllllIlllllIlIlIllIlllIllll][llllllllllIlllllIlIlIllIlllIlIlI] = llllllllllIlllllIlIlIllIlllIlIIl;
            }
        }
    }
    
    static class SecondFloor extends RoomCollection
    {
        @Override
        public String func_191103_e(final Random lllllllllllIlIIIIIlllIlllIllIlII) {
            return "2x2_s1";
        }
        
        @Override
        public String func_191101_d(final Random lllllllllllIlIIIIIlllIlllIllIlll) {
            return "2x2_b" + (lllllllllllIlIIIIIlllIlllIllIlll.nextInt(5) + 1);
        }
        
        @Override
        public String func_191098_b(final Random lllllllllllIlIIIIIlllIllllIIIIIl, final boolean lllllllllllIlIIIIIlllIlllIlllllI) {
            return lllllllllllIlIIIIIlllIlllIlllllI ? "1x2_d_stairs" : ("1x2_d" + (lllllllllllIlIIIIIlllIllllIIIIIl.nextInt(5) + 1));
        }
        
        @Override
        public String func_191100_a(final Random lllllllllllIlIIIIIlllIllllIIlIII, final boolean lllllllllllIlIIIIIlllIllllIIIlIl) {
            return lllllllllllIlIIIIIlllIllllIIIlIl ? "1x2_c_stairs" : ("1x2_c" + (lllllllllllIlIIIIIlllIllllIIlIII.nextInt(4) + 1));
        }
        
        @Override
        public String func_191099_b(final Random lllllllllllIlIIIIIlllIllllIIllIl) {
            return "1x1_as" + (lllllllllllIlIIIIIlllIllllIIllIl.nextInt(4) + 1);
        }
        
        @Override
        public String func_191102_c(final Random lllllllllllIlIIIIIlllIlllIlllIll) {
            return "1x2_se" + (lllllllllllIlIIIIIlllIlllIlllIll.nextInt(1) + 1);
        }
        
        @Override
        public String func_191104_a(final Random lllllllllllIlIIIIIlllIllllIlIIII) {
            return "1x1_b" + (lllllllllllIlIIIIIlllIllllIlIIII.nextInt(4) + 1);
        }
        
        private SecondFloor() {
            super(null);
        }
    }
    
    abstract static class RoomCollection
    {
        public abstract String func_191100_a(final Random p0, final boolean p1);
        
        private RoomCollection() {
        }
        
        public abstract String func_191101_d(final Random p0);
        
        public abstract String func_191099_b(final Random p0);
        
        public abstract String func_191103_e(final Random p0);
        
        public abstract String func_191104_a(final Random p0);
        
        public abstract String func_191098_b(final Random p0, final boolean p1);
        
        public abstract String func_191102_c(final Random p0);
    }
    
    static class PlacementData
    {
        public /* synthetic */ String field_191140_c;
        public /* synthetic */ Rotation field_191138_a;
        public /* synthetic */ BlockPos field_191139_b;
        
        private PlacementData() {
        }
    }
    
    static class Placer
    {
        private /* synthetic */ int field_191137_d;
        private /* synthetic */ int field_191136_c;
        private final /* synthetic */ TemplateManager field_191134_a;
        private final /* synthetic */ Random field_191135_b;
        
        private void func_191123_a(final List<MansionTemplate> lllllllllllllllllllIIIIIIlIlIlII, final BlockPos lllllllllllllllllllIIIIIIlIlIIll, final Rotation lllllllllllllllllllIIIIIIlIlIIlI, final SimpleGrid lllllllllllllllllllIIIIIIlIlIIIl, @Nullable final SimpleGrid lllllllllllllllllllIIIIIIIlIlIlI) {
            for (int lllllllllllllllllllIIIIIIlIIllll = 0; lllllllllllllllllllIIIIIIlIIllll < lllllllllllllllllllIIIIIIlIlIIIl.field_191150_c; ++lllllllllllllllllllIIIIIIlIIllll) {
                for (int lllllllllllllllllllIIIIIIlIIlllI = 0; lllllllllllllllllllIIIIIIlIIlllI < lllllllllllllllllllIIIIIIlIlIIIl.field_191149_b; ++lllllllllllllllllllIIIIIIlIIlllI) {
                    BlockPos lllllllllllllllllllIIIIIIlIIllIl = lllllllllllllllllllIIIIIIlIlIIll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 8 + (lllllllllllllllllllIIIIIIlIIllll - this.field_191137_d) * 8);
                    lllllllllllllllllllIIIIIIlIIllIl = lllllllllllllllllllIIIIIIlIIllIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), (lllllllllllllllllllIIIIIIlIIlllI - this.field_191136_c) * 8);
                    final boolean lllllllllllllllllllIIIIIIlIIllII = lllllllllllllllllllIIIIIIIlIlIlI != null && Grid.func_191109_a(lllllllllllllllllllIIIIIIIlIlIlI, lllllllllllllllllllIIIIIIlIIlllI, lllllllllllllllllllIIIIIIlIIllll);
                    if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIlllI, lllllllllllllllllllIIIIIIlIIllll) && !lllllllllllllllllllIIIIIIlIIllII) {
                        lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof", lllllllllllllllllllIIIIIIlIIllIl.up(3), lllllllllllllllllllIIIIIIlIlIIlI));
                        if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIlllI + 1, lllllllllllllllllllIIIIIIlIIllll)) {
                            final BlockPos lllllllllllllllllllIIIIIIlIIlIll = lllllllllllllllllllIIIIIIlIIllIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 6);
                            lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_front", lllllllllllllllllllIIIIIIlIIlIll, lllllllllllllllllllIIIIIIlIlIIlI));
                        }
                        if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIlllI - 1, lllllllllllllllllllIIIIIIlIIllll)) {
                            BlockPos lllllllllllllllllllIIIIIIlIIlIlI = lllllllllllllllllllIIIIIIlIIllIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 0);
                            lllllllllllllllllllIIIIIIlIIlIlI = lllllllllllllllllllIIIIIIlIIlIlI.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 7);
                            lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_front", lllllllllllllllllllIIIIIIlIIlIlI, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_180)));
                        }
                        if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIlllI, lllllllllllllllllllIIIIIIlIIllll - 1)) {
                            final BlockPos lllllllllllllllllllIIIIIIlIIlIIl = lllllllllllllllllllIIIIIIlIIllIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.WEST), 1);
                            lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_front", lllllllllllllllllllIIIIIIlIIlIIl, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.COUNTERCLOCKWISE_90)));
                        }
                        if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIlllI, lllllllllllllllllllIIIIIIlIIllll + 1)) {
                            BlockPos lllllllllllllllllllIIIIIIlIIlIII = lllllllllllllllllllIIIIIIlIIllIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 6);
                            lllllllllllllllllllIIIIIIlIIlIII = lllllllllllllllllllIIIIIIlIIlIII.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 6);
                            lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_front", lllllllllllllllllllIIIIIIlIIlIII, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_90)));
                        }
                    }
                }
            }
            if (lllllllllllllllllllIIIIIIIlIlIlI != null) {
                for (int lllllllllllllllllllIIIIIIlIIIlll = 0; lllllllllllllllllllIIIIIIlIIIlll < lllllllllllllllllllIIIIIIlIlIIIl.field_191150_c; ++lllllllllllllllllllIIIIIIlIIIlll) {
                    for (int lllllllllllllllllllIIIIIIlIIIllI = 0; lllllllllllllllllllIIIIIIlIIIllI < lllllllllllllllllllIIIIIIlIlIIIl.field_191149_b; ++lllllllllllllllllllIIIIIIlIIIllI) {
                        BlockPos lllllllllllllllllllIIIIIIlIIIlIl = lllllllllllllllllllIIIIIIlIlIIll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 8 + (lllllllllllllllllllIIIIIIlIIIlll - this.field_191137_d) * 8);
                        lllllllllllllllllllIIIIIIlIIIlIl = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), (lllllllllllllllllllIIIIIIlIIIllI - this.field_191136_c) * 8);
                        final boolean lllllllllllllllllllIIIIIIlIIIlII = Grid.func_191109_a(lllllllllllllllllllIIIIIIIlIlIlI, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll);
                        if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll) && lllllllllllllllllllIIIIIIlIIIlII) {
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI + 1, lllllllllllllllllllIIIIIIlIIIlll)) {
                                final BlockPos lllllllllllllllllllIIIIIIlIIIIll = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 7);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall", lllllllllllllllllllIIIIIIlIIIIll, lllllllllllllllllllIIIIIIlIlIIlI));
                            }
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI - 1, lllllllllllllllllllIIIIIIlIIIlll)) {
                                BlockPos lllllllllllllllllllIIIIIIlIIIIlI = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.WEST), 1);
                                lllllllllllllllllllIIIIIIlIIIIlI = lllllllllllllllllllIIIIIIlIIIIlI.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 6);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall", lllllllllllllllllllIIIIIIlIIIIlI, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_180)));
                            }
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll - 1)) {
                                BlockPos lllllllllllllllllllIIIIIIlIIIIIl = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.WEST), 0);
                                lllllllllllllllllllIIIIIIlIIIIIl = lllllllllllllllllllIIIIIIlIIIIIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.NORTH), 1);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall", lllllllllllllllllllIIIIIIlIIIIIl, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.COUNTERCLOCKWISE_90)));
                            }
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll + 1)) {
                                BlockPos lllllllllllllllllllIIIIIIlIIIIII = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 6);
                                lllllllllllllllllllIIIIIIlIIIIII = lllllllllllllllllllIIIIIIlIIIIII.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 7);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall", lllllllllllllllllllIIIIIIlIIIIII, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_90)));
                            }
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI + 1, lllllllllllllllllllIIIIIIlIIIlll)) {
                                if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll - 1)) {
                                    BlockPos lllllllllllllllllllIIIIIIIllllll = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 7);
                                    lllllllllllllllllllIIIIIIIllllll = lllllllllllllllllllIIIIIIIllllll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.NORTH), 2);
                                    lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", lllllllllllllllllllIIIIIIIllllll, lllllllllllllllllllIIIIIIlIlIIlI));
                                }
                                if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll + 1)) {
                                    BlockPos lllllllllllllllllllIIIIIIIlllllI = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 8);
                                    lllllllllllllllllllIIIIIIIlllllI = lllllllllllllllllllIIIIIIIlllllI.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 7);
                                    lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", lllllllllllllllllllIIIIIIIlllllI, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_90)));
                                }
                            }
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI - 1, lllllllllllllllllllIIIIIIlIIIlll)) {
                                if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll - 1)) {
                                    BlockPos lllllllllllllllllllIIIIIIIllllIl = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.WEST), 2);
                                    lllllllllllllllllllIIIIIIIllllIl = lllllllllllllllllllIIIIIIIllllIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.NORTH), 1);
                                    lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", lllllllllllllllllllIIIIIIIllllIl, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.COUNTERCLOCKWISE_90)));
                                }
                                if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIlIIIllI, lllllllllllllllllllIIIIIIlIIIlll + 1)) {
                                    BlockPos lllllllllllllllllllIIIIIIIllllII = lllllllllllllllllllIIIIIIlIIIlIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.WEST), 1);
                                    lllllllllllllllllllIIIIIIIllllII = lllllllllllllllllllIIIIIIIllllII.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 8);
                                    lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", lllllllllllllllllllIIIIIIIllllII, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_180)));
                                }
                            }
                        }
                    }
                }
            }
            for (int lllllllllllllllllllIIIIIIIlllIll = 0; lllllllllllllllllllIIIIIIIlllIll < lllllllllllllllllllIIIIIIlIlIIIl.field_191150_c; ++lllllllllllllllllllIIIIIIIlllIll) {
                for (int lllllllllllllllllllIIIIIIIlllIlI = 0; lllllllllllllllllllIIIIIIIlllIlI < lllllllllllllllllllIIIIIIlIlIIIl.field_191149_b; ++lllllllllllllllllllIIIIIIIlllIlI) {
                    BlockPos lllllllllllllllllllIIIIIIIlllIIl = lllllllllllllllllllIIIIIIlIlIIll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 8 + (lllllllllllllllllllIIIIIIIlllIll - this.field_191137_d) * 8);
                    lllllllllllllllllllIIIIIIIlllIIl = lllllllllllllllllllIIIIIIIlllIIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), (lllllllllllllllllllIIIIIIIlllIlI - this.field_191136_c) * 8);
                    final boolean lllllllllllllllllllIIIIIIIlllIII = lllllllllllllllllllIIIIIIIlIlIlI != null && Grid.func_191109_a(lllllllllllllllllllIIIIIIIlIlIlI, lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIlllIll);
                    if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIlllIll) && !lllllllllllllllllllIIIIIIIlllIII) {
                        if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI + 1, lllllllllllllllllllIIIIIIIlllIll)) {
                            final BlockPos lllllllllllllllllllIIIIIIIllIlll = lllllllllllllllllllIIIIIIIlllIIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 6);
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIlllIll + 1)) {
                                final BlockPos lllllllllllllllllllIIIIIIIllIllI = lllllllllllllllllllIIIIIIIllIlll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 6);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_corner", lllllllllllllllllllIIIIIIIllIllI, lllllllllllllllllllIIIIIIlIlIIlI));
                            }
                            else if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI + 1, lllllllllllllllllllIIIIIIIlllIll + 1)) {
                                final BlockPos lllllllllllllllllllIIIIIIIllIlIl = lllllllllllllllllllIIIIIIIllIlll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 5);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", lllllllllllllllllllIIIIIIIllIlIl, lllllllllllllllllllIIIIIIlIlIIlI));
                            }
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIlllIll - 1)) {
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_corner", lllllllllllllllllllIIIIIIIllIlll, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.COUNTERCLOCKWISE_90)));
                            }
                            else if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI + 1, lllllllllllllllllllIIIIIIIlllIll - 1)) {
                                BlockPos lllllllllllllllllllIIIIIIIllIlII = lllllllllllllllllllIIIIIIIlllIIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 9);
                                lllllllllllllllllllIIIIIIIllIlII = lllllllllllllllllllIIIIIIIllIlII.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.NORTH), 2);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", lllllllllllllllllllIIIIIIIllIlII, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_90)));
                            }
                        }
                        if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI - 1, lllllllllllllllllllIIIIIIIlllIll)) {
                            BlockPos lllllllllllllllllllIIIIIIIllIIll = lllllllllllllllllllIIIIIIIlllIIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.EAST), 0);
                            lllllllllllllllllllIIIIIIIllIIll = lllllllllllllllllllIIIIIIIllIIll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 0);
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIlllIll + 1)) {
                                final BlockPos lllllllllllllllllllIIIIIIIllIIlI = lllllllllllllllllllIIIIIIIllIIll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 6);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_corner", lllllllllllllllllllIIIIIIIllIIlI, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_90)));
                            }
                            else if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI - 1, lllllllllllllllllllIIIIIIIlllIll + 1)) {
                                BlockPos lllllllllllllllllllIIIIIIIllIIIl = lllllllllllllllllllIIIIIIIllIIll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 8);
                                lllllllllllllllllllIIIIIIIllIIIl = lllllllllllllllllllIIIIIIIllIIIl.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.WEST), 3);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", lllllllllllllllllllIIIIIIIllIIIl, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.COUNTERCLOCKWISE_90)));
                            }
                            if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIlllIll - 1)) {
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_corner", lllllllllllllllllllIIIIIIIllIIll, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_180)));
                            }
                            else if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlIlIIIl, lllllllllllllllllllIIIIIIIlllIlI - 1, lllllllllllllllllllIIIIIIIlllIll - 1)) {
                                final BlockPos lllllllllllllllllllIIIIIIIllIIII = lllllllllllllllllllIIIIIIIllIIll.offset(lllllllllllllllllllIIIIIIlIlIIlI.rotate(EnumFacing.SOUTH), 1);
                                lllllllllllllllllllIIIIIIlIlIlII.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", lllllllllllllllllllIIIIIIIllIIII, lllllllllllllllllllIIIIIIlIlIIlI.add(Rotation.CLOCKWISE_180)));
                            }
                        }
                    }
                }
            }
        }
        
        private void func_191129_a(final List<MansionTemplate> llllllllllllllllllIllllllllIlIll, final BlockPos llllllllllllllllllIlllllllllIlII, final Rotation llllllllllllllllllIlllllllllIIll, final EnumFacing llllllllllllllllllIlllllllllIIlI, final RoomCollection llllllllllllllllllIlllllllllIIIl) {
            Rotation llllllllllllllllllIlllllllllIIII = Rotation.NONE;
            String llllllllllllllllllIllllllllIllll = llllllllllllllllllIlllllllllIIIl.func_191104_a(this.field_191135_b);
            if (llllllllllllllllllIlllllllllIIlI != EnumFacing.EAST) {
                if (llllllllllllllllllIlllllllllIIlI == EnumFacing.NORTH) {
                    llllllllllllllllllIlllllllllIIII = llllllllllllllllllIlllllllllIIII.add(Rotation.COUNTERCLOCKWISE_90);
                }
                else if (llllllllllllllllllIlllllllllIIlI == EnumFacing.WEST) {
                    llllllllllllllllllIlllllllllIIII = llllllllllllllllllIlllllllllIIII.add(Rotation.CLOCKWISE_180);
                }
                else if (llllllllllllllllllIlllllllllIIlI == EnumFacing.SOUTH) {
                    llllllllllllllllllIlllllllllIIII = llllllllllllllllllIlllllllllIIII.add(Rotation.CLOCKWISE_90);
                }
                else {
                    llllllllllllllllllIllllllllIllll = llllllllllllllllllIlllllllllIIIl.func_191099_b(this.field_191135_b);
                }
            }
            BlockPos llllllllllllllllllIllllllllIlllI = Template.func_191157_a(new BlockPos(1, 0, 0), Mirror.NONE, llllllllllllllllllIlllllllllIIII, 7, 7);
            llllllllllllllllllIlllllllllIIII = llllllllllllllllllIlllllllllIIII.add(llllllllllllllllllIlllllllllIIll);
            llllllllllllllllllIllllllllIlllI = llllllllllllllllllIllllllllIlllI.func_190942_a(llllllllllllllllllIlllllllllIIll);
            final BlockPos llllllllllllllllllIllllllllIllIl = llllllllllllllllllIlllllllllIlII.add(llllllllllllllllllIllllllllIlllI.getX(), 0, llllllllllllllllllIllllllllIlllI.getZ());
            llllllllllllllllllIllllllllIlIll.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllllIllll, llllllllllllllllllIllllllllIllIl, llllllllllllllllllIlllllllllIIII));
        }
        
        private void func_191124_c(final List<MansionTemplate> lllllllllllllllllllIIIIIIIIIlIlI, final PlacementData lllllllllllllllllllIIIIIIIIIIllI) {
            lllllllllllllllllllIIIIIIIIIIllI.field_191139_b = lllllllllllllllllllIIIIIIIIIIllI.field_191139_b.offset(lllllllllllllllllllIIIIIIIIIIllI.field_191138_a.rotate(EnumFacing.SOUTH), -1);
            lllllllllllllllllllIIIIIIIIIlIlI.add(new MansionTemplate(this.field_191134_a, "wall_corner", lllllllllllllllllllIIIIIIIIIIllI.field_191139_b, lllllllllllllllllllIIIIIIIIIIllI.field_191138_a));
            lllllllllllllllllllIIIIIIIIIIllI.field_191139_b = lllllllllllllllllllIIIIIIIIIIllI.field_191139_b.offset(lllllllllllllllllllIIIIIIIIIIllI.field_191138_a.rotate(EnumFacing.SOUTH), -7);
            lllllllllllllllllllIIIIIIIIIIllI.field_191139_b = lllllllllllllllllllIIIIIIIIIIllI.field_191139_b.offset(lllllllllllllllllllIIIIIIIIIIllI.field_191138_a.rotate(EnumFacing.WEST), -6);
            lllllllllllllllllllIIIIIIIIIIllI.field_191138_a = lllllllllllllllllllIIIIIIIIIIllI.field_191138_a.add(Rotation.CLOCKWISE_90);
        }
        
        private void func_191130_a(final List<MansionTemplate> lllllllllllllllllllIIIIIIllllIII, final PlacementData lllllllllllllllllllIIIIIIlllIlll, final SimpleGrid lllllllllllllllllllIIIIIIlllIllI, EnumFacing lllllllllllllllllllIIIIIIllIlIIl, final int lllllllllllllllllllIIIIIIllIlIII, final int lllllllllllllllllllIIIIIIlllIIll, final int lllllllllllllllllllIIIIIIlllIIlI, final int lllllllllllllllllllIIIIIIlllIIIl) {
            int lllllllllllllllllllIIIIIIlllIIII = lllllllllllllllllllIIIIIIllIlIII;
            int lllllllllllllllllllIIIIIIllIllll = lllllllllllllllllllIIIIIIlllIIll;
            final EnumFacing lllllllllllllllllllIIIIIIllIlllI = lllllllllllllllllllIIIIIIllIlIIl;
            do {
                if (!Grid.func_191109_a(lllllllllllllllllllIIIIIIlllIllI, lllllllllllllllllllIIIIIIlllIIII + lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetX(), lllllllllllllllllllIIIIIIllIllll + lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetZ())) {
                    this.func_191124_c(lllllllllllllllllllIIIIIIllllIII, lllllllllllllllllllIIIIIIlllIlll);
                    lllllllllllllllllllIIIIIIllIlIIl = lllllllllllllllllllIIIIIIllIlIIl.rotateY();
                    if (lllllllllllllllllllIIIIIIlllIIII == lllllllllllllllllllIIIIIIlllIIlI && lllllllllllllllllllIIIIIIllIllll == lllllllllllllllllllIIIIIIlllIIIl && lllllllllllllllllllIIIIIIllIlllI == lllllllllllllllllllIIIIIIllIlIIl) {
                        continue;
                    }
                    this.func_191131_b(lllllllllllllllllllIIIIIIllllIII, lllllllllllllllllllIIIIIIlllIlll);
                }
                else if (Grid.func_191109_a(lllllllllllllllllllIIIIIIlllIllI, lllllllllllllllllllIIIIIIlllIIII + lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetX(), lllllllllllllllllllIIIIIIllIllll + lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetZ()) && Grid.func_191109_a(lllllllllllllllllllIIIIIIlllIllI, lllllllllllllllllllIIIIIIlllIIII + lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetX() + lllllllllllllllllllIIIIIIllIlIIl.rotateYCCW().getFrontOffsetX(), lllllllllllllllllllIIIIIIllIllll + lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetZ() + lllllllllllllllllllIIIIIIllIlIIl.rotateYCCW().getFrontOffsetZ())) {
                    this.func_191126_d(lllllllllllllllllllIIIIIIllllIII, lllllllllllllllllllIIIIIIlllIlll);
                    lllllllllllllllllllIIIIIIlllIIII += lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetX();
                    lllllllllllllllllllIIIIIIllIllll += lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetZ();
                    lllllllllllllllllllIIIIIIllIlIIl = lllllllllllllllllllIIIIIIllIlIIl.rotateYCCW();
                }
                else {
                    lllllllllllllllllllIIIIIIlllIIII += lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetX();
                    lllllllllllllllllllIIIIIIllIllll += lllllllllllllllllllIIIIIIllIlIIl.getFrontOffsetZ();
                    if (lllllllllllllllllllIIIIIIlllIIII == lllllllllllllllllllIIIIIIlllIIlI && lllllllllllllllllllIIIIIIllIllll == lllllllllllllllllllIIIIIIlllIIIl && lllllllllllllllllllIIIIIIllIlllI == lllllllllllllllllllIIIIIIllIlIIl) {
                        continue;
                    }
                    this.func_191131_b(lllllllllllllllllllIIIIIIllllIII, lllllllllllllllllllIIIIIIlllIlll);
                }
            } while (lllllllllllllllllllIIIIIIlllIIII != lllllllllllllllllllIIIIIIlllIIlI || lllllllllllllllllllIIIIIIllIllll != lllllllllllllllllllIIIIIIlllIIIl || lllllllllllllllllllIIIIIIllIlllI != lllllllllllllllllllIIIIIIllIlIIl);
        }
        
        private void func_191133_a(final List<MansionTemplate> lllllllllllllllllllIIIIIIIIllIlI, final PlacementData lllllllllllllllllllIIIIIIIIllIIl) {
            final EnumFacing lllllllllllllllllllIIIIIIIIlllII = lllllllllllllllllllIIIIIIIIllIIl.field_191138_a.rotate(EnumFacing.WEST);
            lllllllllllllllllllIIIIIIIIllIlI.add(new MansionTemplate(this.field_191134_a, "entrance", lllllllllllllllllllIIIIIIIIllIIl.field_191139_b.offset(lllllllllllllllllllIIIIIIIIlllII, 9), lllllllllllllllllllIIIIIIIIllIIl.field_191138_a));
            lllllllllllllllllllIIIIIIIIllIIl.field_191139_b = lllllllllllllllllllIIIIIIIIllIIl.field_191139_b.offset(lllllllllllllllllllIIIIIIIIllIIl.field_191138_a.rotate(EnumFacing.SOUTH), 16);
        }
        
        private void func_191131_b(final List<MansionTemplate> lllllllllllllllllllIIIIIIIIlIIll, final PlacementData lllllllllllllllllllIIIIIIIIIllll) {
            lllllllllllllllllllIIIIIIIIlIIll.add(new MansionTemplate(this.field_191134_a, lllllllllllllllllllIIIIIIIIIllll.field_191140_c, lllllllllllllllllllIIIIIIIIIllll.field_191139_b.offset(lllllllllllllllllllIIIIIIIIIllll.field_191138_a.rotate(EnumFacing.EAST), 7), lllllllllllllllllllIIIIIIIIIllll.field_191138_a));
            lllllllllllllllllllIIIIIIIIIllll.field_191139_b = lllllllllllllllllllIIIIIIIIIllll.field_191139_b.offset(lllllllllllllllllllIIIIIIIIIllll.field_191138_a.rotate(EnumFacing.SOUTH), 8);
        }
        
        private void func_191127_a(final List<MansionTemplate> llllllllllllllllllIllllllIlIllIl, final BlockPos llllllllllllllllllIllllllIlIllII, final Rotation llllllllllllllllllIllllllIIlllll, final EnumFacing llllllllllllllllllIllllllIlIlIlI, final EnumFacing llllllllllllllllllIllllllIIlllIl, final RoomCollection llllllllllllllllllIllllllIIlllII) {
            int llllllllllllllllllIllllllIlIIlll = 0;
            int llllllllllllllllllIllllllIlIIllI = 0;
            Rotation llllllllllllllllllIllllllIlIIlIl = llllllllllllllllllIllllllIIlllll;
            Mirror llllllllllllllllllIllllllIlIIlII = Mirror.NONE;
            if (llllllllllllllllllIllllllIIlllIl == EnumFacing.EAST && llllllllllllllllllIllllllIlIlIlI == EnumFacing.SOUTH) {
                llllllllllllllllllIllllllIlIIlll = -7;
            }
            else if (llllllllllllllllllIllllllIIlllIl == EnumFacing.EAST && llllllllllllllllllIllllllIlIlIlI == EnumFacing.NORTH) {
                llllllllllllllllllIllllllIlIIlll = -7;
                llllllllllllllllllIllllllIlIIllI = 6;
                llllllllllllllllllIllllllIlIIlII = Mirror.LEFT_RIGHT;
            }
            else if (llllllllllllllllllIllllllIIlllIl == EnumFacing.NORTH && llllllllllllllllllIllllllIlIlIlI == EnumFacing.EAST) {
                llllllllllllllllllIllllllIlIIlll = 1;
                llllllllllllllllllIllllllIlIIllI = 14;
                llllllllllllllllllIllllllIlIIlIl = llllllllllllllllllIllllllIIlllll.add(Rotation.COUNTERCLOCKWISE_90);
            }
            else if (llllllllllllllllllIllllllIIlllIl == EnumFacing.NORTH && llllllllllllllllllIllllllIlIlIlI == EnumFacing.WEST) {
                llllllllllllllllllIllllllIlIIlll = 7;
                llllllllllllllllllIllllllIlIIllI = 14;
                llllllllllllllllllIllllllIlIIlIl = llllllllllllllllllIllllllIIlllll.add(Rotation.COUNTERCLOCKWISE_90);
                llllllllllllllllllIllllllIlIIlII = Mirror.LEFT_RIGHT;
            }
            else if (llllllllllllllllllIllllllIIlllIl == EnumFacing.SOUTH && llllllllllllllllllIllllllIlIlIlI == EnumFacing.WEST) {
                llllllllllllllllllIllllllIlIIlll = 7;
                llllllllllllllllllIllllllIlIIllI = -8;
                llllllllllllllllllIllllllIlIIlIl = llllllllllllllllllIllllllIIlllll.add(Rotation.CLOCKWISE_90);
            }
            else if (llllllllllllllllllIllllllIIlllIl == EnumFacing.SOUTH && llllllllllllllllllIllllllIlIlIlI == EnumFacing.EAST) {
                llllllllllllllllllIllllllIlIIlll = 1;
                llllllllllllllllllIllllllIlIIllI = -8;
                llllllllllllllllllIllllllIlIIlIl = llllllllllllllllllIllllllIIlllll.add(Rotation.CLOCKWISE_90);
                llllllllllllllllllIllllllIlIIlII = Mirror.LEFT_RIGHT;
            }
            else if (llllllllllllllllllIllllllIIlllIl == EnumFacing.WEST && llllllllllllllllllIllllllIlIlIlI == EnumFacing.NORTH) {
                llllllllllllllllllIllllllIlIIlll = 15;
                llllllllllllllllllIllllllIlIIllI = 6;
                llllllllllllllllllIllllllIlIIlIl = llllllllllllllllllIllllllIIlllll.add(Rotation.CLOCKWISE_180);
            }
            else if (llllllllllllllllllIllllllIIlllIl == EnumFacing.WEST && llllllllllllllllllIllllllIlIlIlI == EnumFacing.SOUTH) {
                llllllllllllllllllIllllllIlIIlll = 15;
                llllllllllllllllllIllllllIlIIlII = Mirror.FRONT_BACK;
            }
            BlockPos llllllllllllllllllIllllllIlIIIll = llllllllllllllllllIllllllIlIllII.offset(llllllllllllllllllIllllllIIlllll.rotate(EnumFacing.EAST), llllllllllllllllllIllllllIlIIlll);
            llllllllllllllllllIllllllIlIIIll = llllllllllllllllllIllllllIlIIIll.offset(llllllllllllllllllIllllllIIlllll.rotate(EnumFacing.SOUTH), llllllllllllllllllIllllllIlIIllI);
            llllllllllllllllllIllllllIlIllIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIIlllII.func_191101_d(this.field_191135_b), llllllllllllllllllIllllllIlIIIll, llllllllllllllllllIllllllIlIIlIl, llllllllllllllllllIllllllIlIIlII));
        }
        
        public void func_191125_a(final BlockPos lllllllllllllllllllIIIIIlIlIIlIl, final Rotation lllllllllllllllllllIIIIIllIIllll, final List<MansionTemplate> lllllllllllllllllllIIIIIlIlIIIll, final Grid lllllllllllllllllllIIIIIlIlIIIlI) {
            final PlacementData lllllllllllllllllllIIIIIllIIllII = new PlacementData(null);
            lllllllllllllllllllIIIIIllIIllII.field_191139_b = lllllllllllllllllllIIIIIlIlIIlIl;
            lllllllllllllllllllIIIIIllIIllII.field_191138_a = lllllllllllllllllllIIIIIllIIllll;
            lllllllllllllllllllIIIIIllIIllII.field_191140_c = "wall_flat";
            final PlacementData lllllllllllllllllllIIIIIllIIlIll = new PlacementData(null);
            this.func_191133_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIllIIllII);
            lllllllllllllllllllIIIIIllIIlIll.field_191139_b = lllllllllllllllllllIIIIIllIIllII.field_191139_b.up(8);
            lllllllllllllllllllIIIIIllIIlIll.field_191138_a = lllllllllllllllllllIIIIIllIIllII.field_191138_a;
            lllllllllllllllllllIIIIIllIIlIll.field_191140_c = "wall_window";
            if (!lllllllllllllllllllIIIIIlIlIIIll.isEmpty()) {}
            final SimpleGrid lllllllllllllllllllIIIIIllIIlIlI = lllllllllllllllllllIIIIIlIlIIIlI.field_191118_b;
            final SimpleGrid lllllllllllllllllllIIIIIllIIlIIl = lllllllllllllllllllIIIIIlIlIIIlI.field_191119_c;
            this.field_191136_c = lllllllllllllllllllIIIIIlIlIIIlI.field_191121_e + 1;
            this.field_191137_d = lllllllllllllllllllIIIIIlIlIIIlI.field_191122_f + 1;
            final int lllllllllllllllllllIIIIIllIIlIII = lllllllllllllllllllIIIIIlIlIIIlI.field_191121_e + 1;
            final int lllllllllllllllllllIIIIIllIIIlll = lllllllllllllllllllIIIIIlIlIIIlI.field_191122_f;
            this.func_191130_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIllIIllII, lllllllllllllllllllIIIIIllIIlIlI, EnumFacing.SOUTH, this.field_191136_c, this.field_191137_d, lllllllllllllllllllIIIIIllIIlIII, lllllllllllllllllllIIIIIllIIIlll);
            this.func_191130_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIllIIlIll, lllllllllllllllllllIIIIIllIIlIlI, EnumFacing.SOUTH, this.field_191136_c, this.field_191137_d, lllllllllllllllllllIIIIIllIIlIII, lllllllllllllllllllIIIIIllIIIlll);
            final PlacementData lllllllllllllllllllIIIIIllIIIllI = new PlacementData(null);
            lllllllllllllllllllIIIIIllIIIllI.field_191139_b = lllllllllllllllllllIIIIIllIIllII.field_191139_b.up(19);
            lllllllllllllllllllIIIIIllIIIllI.field_191138_a = lllllllllllllllllllIIIIIllIIllII.field_191138_a;
            lllllllllllllllllllIIIIIllIIIllI.field_191140_c = "wall_window";
            boolean lllllllllllllllllllIIIIIllIIIlIl = false;
            for (int lllllllllllllllllllIIIIIllIIIlII = 0; lllllllllllllllllllIIIIIllIIIlII < lllllllllllllllllllIIIIIllIIlIIl.field_191150_c && !lllllllllllllllllllIIIIIllIIIlIl; ++lllllllllllllllllllIIIIIllIIIlII) {
                for (int lllllllllllllllllllIIIIIllIIIIll = lllllllllllllllllllIIIIIllIIlIIl.field_191149_b - 1; lllllllllllllllllllIIIIIllIIIIll >= 0 && !lllllllllllllllllllIIIIIllIIIlIl; --lllllllllllllllllllIIIIIllIIIIll) {
                    if (Grid.func_191109_a(lllllllllllllllllllIIIIIllIIlIIl, lllllllllllllllllllIIIIIllIIIIll, lllllllllllllllllllIIIIIllIIIlII)) {
                        lllllllllllllllllllIIIIIllIIIllI.field_191139_b = lllllllllllllllllllIIIIIllIIIllI.field_191139_b.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.SOUTH), 8 + (lllllllllllllllllllIIIIIllIIIlII - this.field_191137_d) * 8);
                        lllllllllllllllllllIIIIIllIIIllI.field_191139_b = lllllllllllllllllllIIIIIllIIIllI.field_191139_b.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), (lllllllllllllllllllIIIIIllIIIIll - this.field_191136_c) * 8);
                        this.func_191131_b(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIllIIIllI);
                        this.func_191130_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIllIIIllI, lllllllllllllllllllIIIIIllIIlIIl, EnumFacing.SOUTH, lllllllllllllllllllIIIIIllIIIIll, lllllllllllllllllllIIIIIllIIIlII, lllllllllllllllllllIIIIIllIIIIll, lllllllllllllllllllIIIIIllIIIlII);
                        lllllllllllllllllllIIIIIllIIIlIl = true;
                    }
                }
            }
            this.func_191123_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIlIlIIlIl.up(16), lllllllllllllllllllIIIIIllIIllll, lllllllllllllllllllIIIIIllIIlIlI, lllllllllllllllllllIIIIIllIIlIIl);
            this.func_191123_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIlIlIIlIl.up(27), lllllllllllllllllllIIIIIllIIllll, lllllllllllllllllllIIIIIllIIlIIl, null);
            if (!lllllllllllllllllllIIIIIlIlIIIll.isEmpty()) {}
            final RoomCollection[] lllllllllllllllllllIIIIIllIIIIlI = { new FirstFloor(null), new SecondFloor(null), new ThirdFloor(null) };
            for (int lllllllllllllllllllIIIIIllIIIIIl = 0; lllllllllllllllllllIIIIIllIIIIIl < 3; ++lllllllllllllllllllIIIIIllIIIIIl) {
                final BlockPos lllllllllllllllllllIIIIIllIIIIII = lllllllllllllllllllIIIIIlIlIIlIl.up(8 * lllllllllllllllllllIIIIIllIIIIIl + ((lllllllllllllllllllIIIIIllIIIIIl == 2) ? 3 : 0));
                final SimpleGrid lllllllllllllllllllIIIIIlIllllll = lllllllllllllllllllIIIIIlIlIIIlI.field_191120_d[lllllllllllllllllllIIIIIllIIIIIl];
                final SimpleGrid lllllllllllllllllllIIIIIlIlllllI = (lllllllllllllllllllIIIIIllIIIIIl == 2) ? lllllllllllllllllllIIIIIllIIlIIl : lllllllllllllllllllIIIIIllIIlIlI;
                final String lllllllllllllllllllIIIIIlIllllIl = (lllllllllllllllllllIIIIIllIIIIIl == 0) ? "carpet_south" : "carpet_south_2";
                final String lllllllllllllllllllIIIIIlIllllII = (lllllllllllllllllllIIIIIllIIIIIl == 0) ? "carpet_west" : "carpet_west_2";
                for (int lllllllllllllllllllIIIIIlIlllIll = 0; lllllllllllllllllllIIIIIlIlllIll < lllllllllllllllllllIIIIIlIlllllI.field_191150_c; ++lllllllllllllllllllIIIIIlIlllIll) {
                    for (int lllllllllllllllllllIIIIIlIlllIlI = 0; lllllllllllllllllllIIIIIlIlllIlI < lllllllllllllllllllIIIIIlIlllllI.field_191149_b; ++lllllllllllllllllllIIIIIlIlllIlI) {
                        if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI, lllllllllllllllllllIIIIIlIlllIll) == 1) {
                            BlockPos lllllllllllllllllllIIIIIlIlllIIl = lllllllllllllllllllIIIIIllIIIIII.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.SOUTH), 8 + (lllllllllllllllllllIIIIIlIlllIll - this.field_191137_d) * 8);
                            lllllllllllllllllllIIIIIlIlllIIl = lllllllllllllllllllIIIIIlIlllIIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), (lllllllllllllllllllIIIIIlIlllIlI - this.field_191136_c) * 8);
                            lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, "corridor_floor", lllllllllllllllllllIIIIIlIlllIIl, lllllllllllllllllllIIIIIllIIllll));
                            if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI, lllllllllllllllllllIIIIIlIlllIll - 1) == 1 || (lllllllllllllllllllIIIIIlIllllll.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI, lllllllllllllllllllIIIIIlIlllIll - 1) & 0x800000) == 0x800000) {
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, "carpet_north", lllllllllllllllllllIIIIIlIlllIIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), 1).up(), lllllllllllllllllllIIIIIllIIllll));
                            }
                            if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI + 1, lllllllllllllllllllIIIIIlIlllIll) == 1 || (lllllllllllllllllllIIIIIlIllllll.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI + 1, lllllllllllllllllllIIIIIlIlllIll) & 0x800000) == 0x800000) {
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, "carpet_east", lllllllllllllllllllIIIIIlIlllIIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.SOUTH), 1).offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), 5).up(), lllllllllllllllllllIIIIIllIIllll));
                            }
                            if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI, lllllllllllllllllllIIIIIlIlllIll + 1) == 1 || (lllllllllllllllllllIIIIIlIllllll.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI, lllllllllllllllllllIIIIIlIlllIll + 1) & 0x800000) == 0x800000) {
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, lllllllllllllllllllIIIIIlIllllIl, lllllllllllllllllllIIIIIlIlllIIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.SOUTH), 5).offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.WEST), 1), lllllllllllllllllllIIIIIllIIllll));
                            }
                            if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI - 1, lllllllllllllllllllIIIIIlIlllIll) == 1 || (lllllllllllllllllllIIIIIlIllllll.func_191145_a(lllllllllllllllllllIIIIIlIlllIlI - 1, lllllllllllllllllllIIIIIlIlllIll) & 0x800000) == 0x800000) {
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, lllllllllllllllllllIIIIIlIllllII, lllllllllllllllllllIIIIIlIlllIIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.WEST), 1).offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.NORTH), 1), lllllllllllllllllllIIIIIllIIllll));
                            }
                        }
                    }
                }
                final String lllllllllllllllllllIIIIIlIlllIII = (lllllllllllllllllllIIIIIllIIIIIl == 0) ? "indoors_wall" : "indoors_wall_2";
                final String lllllllllllllllllllIIIIIlIllIlll = (lllllllllllllllllllIIIIIllIIIIIl == 0) ? "indoors_door" : "indoors_door_2";
                final List<EnumFacing> lllllllllllllllllllIIIIIlIllIllI = (List<EnumFacing>)Lists.newArrayList();
                for (int lllllllllllllllllllIIIIIlIllIlIl = 0; lllllllllllllllllllIIIIIlIllIlIl < lllllllllllllllllllIIIIIlIlllllI.field_191150_c; ++lllllllllllllllllllIIIIIlIllIlIl) {
                    for (int lllllllllllllllllllIIIIIlIllIlII = 0; lllllllllllllllllllIIIIIlIllIlII < lllllllllllllllllllIIIIIlIlllllI.field_191149_b; ++lllllllllllllllllllIIIIIlIllIlII) {
                        boolean lllllllllllllllllllIIIIIlIllIIll = lllllllllllllllllllIIIIIllIIIIIl == 2 && lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIlIl) == 3;
                        if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIlIl) == 2 || lllllllllllllllllllIIIIIlIllIIll) {
                            final int lllllllllllllllllllIIIIIlIllIIlI = lllllllllllllllllllIIIIIlIllllll.func_191145_a(lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIlIl);
                            final int lllllllllllllllllllIIIIIlIllIIIl = lllllllllllllllllllIIIIIlIllIIlI & 0xF0000;
                            final int lllllllllllllllllllIIIIIlIllIIII = lllllllllllllllllllIIIIIlIllIIlI & 0xFFFF;
                            lllllllllllllllllllIIIIIlIllIIll = (lllllllllllllllllllIIIIIlIllIIll && (lllllllllllllllllllIIIIIlIllIIlI & 0x800000) == 0x800000);
                            lllllllllllllllllllIIIIIlIllIllI.clear();
                            if ((lllllllllllllllllllIIIIIlIllIIlI & 0x200000) == 0x200000) {
                                final EnumFacing[] facings;
                                final int length = (facings = EnumFacing.Plane.HORIZONTAL.facings()).length;
                                for (short lllllllllllllllllllIIIIIlIIIlIII = 0; lllllllllllllllllllIIIIIlIIIlIII < length; ++lllllllllllllllllllIIIIIlIIIlIII) {
                                    final EnumFacing lllllllllllllllllllIIIIIlIlIllll = facings[lllllllllllllllllllIIIIIlIIIlIII];
                                    if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIllIlII + lllllllllllllllllllIIIIIlIlIllll.getFrontOffsetX(), lllllllllllllllllllIIIIIlIllIlIl + lllllllllllllllllllIIIIIlIlIllll.getFrontOffsetZ()) == 1) {
                                        lllllllllllllllllllIIIIIlIllIllI.add(lllllllllllllllllllIIIIIlIlIllll);
                                    }
                                }
                            }
                            EnumFacing lllllllllllllllllllIIIIIlIlIlllI = null;
                            if (!lllllllllllllllllllIIIIIlIllIllI.isEmpty()) {
                                lllllllllllllllllllIIIIIlIlIlllI = lllllllllllllllllllIIIIIlIllIllI.get(this.field_191135_b.nextInt(lllllllllllllllllllIIIIIlIllIllI.size()));
                            }
                            else if ((lllllllllllllllllllIIIIIlIllIIlI & 0x100000) == 0x100000) {
                                lllllllllllllllllllIIIIIlIlIlllI = EnumFacing.UP;
                            }
                            BlockPos lllllllllllllllllllIIIIIlIlIllIl = lllllllllllllllllllIIIIIllIIIIII.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.SOUTH), 8 + (lllllllllllllllllllIIIIIlIllIlIl - this.field_191137_d) * 8);
                            lllllllllllllllllllIIIIIlIlIllIl = lllllllllllllllllllIIIIIlIlIllIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), -1 + (lllllllllllllllllllIIIIIlIllIlII - this.field_191136_c) * 8);
                            if (Grid.func_191109_a(lllllllllllllllllllIIIIIlIlllllI, lllllllllllllllllllIIIIIlIllIlII - 1, lllllllllllllllllllIIIIIlIllIlIl) && !lllllllllllllllllllIIIIIlIlIIIlI.func_191114_a(lllllllllllllllllllIIIIIlIlllllI, lllllllllllllllllllIIIIIlIllIlII - 1, lllllllllllllllllllIIIIIlIllIlIl, lllllllllllllllllllIIIIIllIIIIIl, lllllllllllllllllllIIIIIlIllIIII)) {
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, (lllllllllllllllllllIIIIIlIlIlllI == EnumFacing.WEST) ? lllllllllllllllllllIIIIIlIllIlll : lllllllllllllllllllIIIIIlIlllIII, lllllllllllllllllllIIIIIlIlIllIl, lllllllllllllllllllIIIIIllIIllll));
                            }
                            if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIllIlII + 1, lllllllllllllllllllIIIIIlIllIlIl) == 1 && !lllllllllllllllllllIIIIIlIllIIll) {
                                final BlockPos lllllllllllllllllllIIIIIlIlIllII = lllllllllllllllllllIIIIIlIlIllIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), 8);
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, (lllllllllllllllllllIIIIIlIlIlllI == EnumFacing.EAST) ? lllllllllllllllllllIIIIIlIllIlll : lllllllllllllllllllIIIIIlIlllIII, lllllllllllllllllllIIIIIlIlIllII, lllllllllllllllllllIIIIIllIIllll));
                            }
                            if (Grid.func_191109_a(lllllllllllllllllllIIIIIlIlllllI, lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIlIl + 1) && !lllllllllllllllllllIIIIIlIlIIIlI.func_191114_a(lllllllllllllllllllIIIIIlIlllllI, lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIlIl + 1, lllllllllllllllllllIIIIIllIIIIIl, lllllllllllllllllllIIIIIlIllIIII)) {
                                BlockPos lllllllllllllllllllIIIIIlIlIlIll = lllllllllllllllllllIIIIIlIlIllIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.SOUTH), 7);
                                lllllllllllllllllllIIIIIlIlIlIll = lllllllllllllllllllIIIIIlIlIlIll.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), 7);
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, (lllllllllllllllllllIIIIIlIlIlllI == EnumFacing.SOUTH) ? lllllllllllllllllllIIIIIlIllIlll : lllllllllllllllllllIIIIIlIlllIII, lllllllllllllllllllIIIIIlIlIlIll, lllllllllllllllllllIIIIIllIIllll.add(Rotation.CLOCKWISE_90)));
                            }
                            if (lllllllllllllllllllIIIIIlIlllllI.func_191145_a(lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIlIl - 1) == 1 && !lllllllllllllllllllIIIIIlIllIIll) {
                                BlockPos lllllllllllllllllllIIIIIlIlIlIlI = lllllllllllllllllllIIIIIlIlIllIl.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.NORTH), 1);
                                lllllllllllllllllllIIIIIlIlIlIlI = lllllllllllllllllllIIIIIlIlIlIlI.offset(lllllllllllllllllllIIIIIllIIllll.rotate(EnumFacing.EAST), 7);
                                lllllllllllllllllllIIIIIlIlIIIll.add(new MansionTemplate(this.field_191134_a, (lllllllllllllllllllIIIIIlIlIlllI == EnumFacing.NORTH) ? lllllllllllllllllllIIIIIlIllIlll : lllllllllllllllllllIIIIIlIlllIII, lllllllllllllllllllIIIIIlIlIlIlI, lllllllllllllllllllIIIIIllIIllll.add(Rotation.CLOCKWISE_90)));
                            }
                            if (lllllllllllllllllllIIIIIlIllIIIl == 65536) {
                                this.func_191129_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIlIlIllIl, lllllllllllllllllllIIIIIllIIllll, lllllllllllllllllllIIIIIlIlIlllI, lllllllllllllllllllIIIIIllIIIIlI[lllllllllllllllllllIIIIIllIIIIIl]);
                            }
                            else if (lllllllllllllllllllIIIIIlIllIIIl == 131072 && lllllllllllllllllllIIIIIlIlIlllI != null) {
                                final EnumFacing lllllllllllllllllllIIIIIlIlIlIIl = lllllllllllllllllllIIIIIlIlIIIlI.func_191113_b(lllllllllllllllllllIIIIIlIlllllI, lllllllllllllllllllIIIIIlIllIlII, lllllllllllllllllllIIIIIlIllIlIl, lllllllllllllllllllIIIIIllIIIIIl, lllllllllllllllllllIIIIIlIllIIII);
                                final boolean lllllllllllllllllllIIIIIlIlIlIII = (lllllllllllllllllllIIIIIlIllIIlI & 0x400000) == 0x400000;
                                this.func_191132_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIlIlIllIl, lllllllllllllllllllIIIIIllIIllll, lllllllllllllllllllIIIIIlIlIlIIl, lllllllllllllllllllIIIIIlIlIlllI, lllllllllllllllllllIIIIIllIIIIlI[lllllllllllllllllllIIIIIllIIIIIl], lllllllllllllllllllIIIIIlIlIlIII);
                            }
                            else if (lllllllllllllllllllIIIIIlIllIIIl == 262144 && lllllllllllllllllllIIIIIlIlIlllI != null && lllllllllllllllllllIIIIIlIlIlllI != EnumFacing.UP) {
                                EnumFacing lllllllllllllllllllIIIIIlIlIIlll = lllllllllllllllllllIIIIIlIlIlllI.rotateY();
                                if (!lllllllllllllllllllIIIIIlIlIIIlI.func_191114_a(lllllllllllllllllllIIIIIlIlllllI, lllllllllllllllllllIIIIIlIllIlII + lllllllllllllllllllIIIIIlIlIIlll.getFrontOffsetX(), lllllllllllllllllllIIIIIlIllIlIl + lllllllllllllllllllIIIIIlIlIIlll.getFrontOffsetZ(), lllllllllllllllllllIIIIIllIIIIIl, lllllllllllllllllllIIIIIlIllIIII)) {
                                    lllllllllllllllllllIIIIIlIlIIlll = lllllllllllllllllllIIIIIlIlIIlll.getOpposite();
                                }
                                this.func_191127_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIlIlIllIl, lllllllllllllllllllIIIIIllIIllll, lllllllllllllllllllIIIIIlIlIIlll, lllllllllllllllllllIIIIIlIlIlllI, lllllllllllllllllllIIIIIllIIIIlI[lllllllllllllllllllIIIIIllIIIIIl]);
                            }
                            else if (lllllllllllllllllllIIIIIlIllIIIl == 262144 && lllllllllllllllllllIIIIIlIlIlllI == EnumFacing.UP) {
                                this.func_191128_a(lllllllllllllllllllIIIIIlIlIIIll, lllllllllllllllllllIIIIIlIlIllIl, lllllllllllllllllllIIIIIllIIllll, lllllllllllllllllllIIIIIllIIIIlI[lllllllllllllllllllIIIIIllIIIIIl]);
                            }
                        }
                    }
                }
            }
        }
        
        public Placer(final TemplateManager lllllllllllllllllllIIIIIllllIlII, final Random lllllllllllllllllllIIIIIllllIIll) {
            this.field_191134_a = lllllllllllllllllllIIIIIllllIlII;
            this.field_191135_b = lllllllllllllllllllIIIIIllllIIll;
        }
        
        private void func_191126_d(final List<MansionTemplate> lllllllllllllllllllIIIIIIIIIIIll, final PlacementData lllllllllllllllllllIIIIIIIIIIIIl) {
            lllllllllllllllllllIIIIIIIIIIIIl.field_191139_b = lllllllllllllllllllIIIIIIIIIIIIl.field_191139_b.offset(lllllllllllllllllllIIIIIIIIIIIIl.field_191138_a.rotate(EnumFacing.SOUTH), 6);
            lllllllllllllllllllIIIIIIIIIIIIl.field_191139_b = lllllllllllllllllllIIIIIIIIIIIIl.field_191139_b.offset(lllllllllllllllllllIIIIIIIIIIIIl.field_191138_a.rotate(EnumFacing.EAST), 8);
            lllllllllllllllllllIIIIIIIIIIIIl.field_191138_a = lllllllllllllllllllIIIIIIIIIIIIl.field_191138_a.add(Rotation.COUNTERCLOCKWISE_90);
        }
        
        private void func_191132_a(final List<MansionTemplate> llllllllllllllllllIlllllllIllIII, final BlockPos llllllllllllllllllIlllllllIlIlll, final Rotation llllllllllllllllllIlllllllIlIllI, final EnumFacing llllllllllllllllllIllllllIllllll, final EnumFacing llllllllllllllllllIllllllIlllllI, final RoomCollection llllllllllllllllllIllllllIllllIl, final boolean llllllllllllllllllIllllllIllllII) {
            if (llllllllllllllllllIllllllIlllllI == EnumFacing.EAST && llllllllllllllllllIllllllIllllll == EnumFacing.SOUTH) {
                final BlockPos llllllllllllllllllIlllllllIlIIIl = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIlIIIl, llllllllllllllllllIlllllllIlIllI));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.EAST && llllllllllllllllllIllllllIllllll == EnumFacing.NORTH) {
                BlockPos llllllllllllllllllIlllllllIlIIII = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIlllllllIlIIII = llllllllllllllllllIlllllllIlIIII.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIlIIII, llllllllllllllllllIlllllllIlIllI, Mirror.LEFT_RIGHT));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.WEST && llllllllllllllllllIllllllIllllll == EnumFacing.NORTH) {
                BlockPos llllllllllllllllllIlllllllIIllll = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIlllllllIIllll = llllllllllllllllllIlllllllIIllll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIllll, llllllllllllllllllIlllllllIlIllI.add(Rotation.CLOCKWISE_180)));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.WEST && llllllllllllllllllIllllllIllllll == EnumFacing.SOUTH) {
                final BlockPos llllllllllllllllllIlllllllIIlllI = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIlllI, llllllllllllllllllIlllllllIlIllI, Mirror.FRONT_BACK));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.SOUTH && llllllllllllllllllIllllllIllllll == EnumFacing.EAST) {
                final BlockPos llllllllllllllllllIlllllllIIllIl = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIllIl, llllllllllllllllllIlllllllIlIllI.add(Rotation.CLOCKWISE_90), Mirror.LEFT_RIGHT));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.SOUTH && llllllllllllllllllIllllllIllllll == EnumFacing.WEST) {
                final BlockPos llllllllllllllllllIlllllllIIllII = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIllII, llllllllllllllllllIlllllllIlIllI.add(Rotation.CLOCKWISE_90)));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.NORTH && llllllllllllllllllIllllllIllllll == EnumFacing.WEST) {
                BlockPos llllllllllllllllllIlllllllIIlIll = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIlllllllIIlIll = llllllllllllllllllIlllllllIIlIll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIlIll, llllllllllllllllllIlllllllIlIllI.add(Rotation.CLOCKWISE_90), Mirror.FRONT_BACK));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.NORTH && llllllllllllllllllIllllllIllllll == EnumFacing.EAST) {
                BlockPos llllllllllllllllllIlllllllIIlIlI = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIlllllllIIlIlI = llllllllllllllllllIlllllllIIlIlI.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191100_a(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIlIlI, llllllllllllllllllIlllllllIlIllI.add(Rotation.COUNTERCLOCKWISE_90)));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.SOUTH && llllllllllllllllllIllllllIllllll == EnumFacing.NORTH) {
                BlockPos llllllllllllllllllIlllllllIIlIIl = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIlllllllIIlIIl = llllllllllllllllllIlllllllIIlIIl.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.NORTH), 8);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191098_b(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIlIIl, llllllllllllllllllIlllllllIlIllI));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.NORTH && llllllllllllllllllIllllllIllllll == EnumFacing.SOUTH) {
                BlockPos llllllllllllllllllIlllllllIIlIII = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIlllllllIIlIII = llllllllllllllllllIlllllllIIlIII.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.SOUTH), 14);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191098_b(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIlIII, llllllllllllllllllIlllllllIlIllI.add(Rotation.CLOCKWISE_180)));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.WEST && llllllllllllllllllIllllllIllllll == EnumFacing.EAST) {
                final BlockPos llllllllllllllllllIlllllllIIIlll = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 15);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191098_b(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIIlll, llllllllllllllllllIlllllllIlIllI.add(Rotation.CLOCKWISE_90)));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.EAST && llllllllllllllllllIllllllIllllll == EnumFacing.WEST) {
                BlockPos llllllllllllllllllIlllllllIIIllI = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.WEST), 7);
                llllllllllllllllllIlllllllIIIllI = llllllllllllllllllIlllllllIIIllI.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191098_b(this.field_191135_b, llllllllllllllllllIllllllIllllII), llllllllllllllllllIlllllllIIIllI, llllllllllllllllllIlllllllIlIllI.add(Rotation.COUNTERCLOCKWISE_90)));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.UP && llllllllllllllllllIllllllIllllll == EnumFacing.EAST) {
                final BlockPos llllllllllllllllllIlllllllIIIlIl = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 15);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191102_c(this.field_191135_b), llllllllllllllllllIlllllllIIIlIl, llllllllllllllllllIlllllllIlIllI.add(Rotation.CLOCKWISE_90)));
            }
            else if (llllllllllllllllllIllllllIlllllI == EnumFacing.UP && llllllllllllllllllIllllllIllllll == EnumFacing.SOUTH) {
                BlockPos llllllllllllllllllIlllllllIIIlII = llllllllllllllllllIlllllllIlIlll.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIlllllllIIIlII = llllllllllllllllllIlllllllIIIlII.offset(llllllllllllllllllIlllllllIlIllI.rotate(EnumFacing.NORTH), 0);
                llllllllllllllllllIlllllllIllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIllllIl.func_191102_c(this.field_191135_b), llllllllllllllllllIlllllllIIIlII, llllllllllllllllllIlllllllIlIllI));
            }
        }
        
        private void func_191128_a(final List<MansionTemplate> llllllllllllllllllIllllllIIIlIIl, final BlockPos llllllllllllllllllIllllllIIIlIII, final Rotation llllllllllllllllllIllllllIIIIlll, final RoomCollection llllllllllllllllllIllllllIIIIllI) {
            final BlockPos llllllllllllllllllIllllllIIIlIll = llllllllllllllllllIllllllIIIlIII.offset(llllllllllllllllllIllllllIIIIlll.rotate(EnumFacing.EAST), 1);
            llllllllllllllllllIllllllIIIlIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIllllllIIIIllI.func_191103_e(this.field_191135_b), llllllllllllllllllIllllllIIIlIll, llllllllllllllllllIllllllIIIIlll, Mirror.NONE));
        }
    }
    
    static class ThirdFloor extends SecondFloor
    {
        private ThirdFloor() {
            super(null, null);
        }
    }
    
    static class FirstFloor extends RoomCollection
    {
        @Override
        public String func_191100_a(final Random llllllllllllIIIllIIIIlIIIIIIllII, final boolean llllllllllllIIIllIIIIlIIIIIIlIll) {
            return "1x2_a" + (llllllllllllIIIllIIIIlIIIIIIllII.nextInt(9) + 1);
        }
        
        @Override
        public String func_191104_a(final Random llllllllllllIIIllIIIIlIIIIIlIlII) {
            return "1x1_a" + (llllllllllllIIIllIIIIlIIIIIlIlII.nextInt(5) + 1);
        }
        
        @Override
        public String func_191101_d(final Random llllllllllllIIIllIIIIIlllllllllI) {
            return "2x2_a" + (llllllllllllIIIllIIIIIlllllllllI.nextInt(4) + 1);
        }
        
        @Override
        public String func_191103_e(final Random llllllllllllIIIllIIIIIlllllllIll) {
            return "2x2_s1";
        }
        
        private FirstFloor() {
            super(null);
        }
        
        @Override
        public String func_191099_b(final Random llllllllllllIIIllIIIIlIIIIIIllll) {
            return "1x1_as" + (llllllllllllIIIllIIIIlIIIIIIllll.nextInt(4) + 1);
        }
        
        @Override
        public String func_191098_b(final Random llllllllllllIIIllIIIIlIIIIIIIlIl, final boolean llllllllllllIIIllIIIIlIIIIIIIllI) {
            return "1x2_b" + (llllllllllllIIIllIIIIlIIIIIIIlIl.nextInt(5) + 1);
        }
        
        @Override
        public String func_191102_c(final Random llllllllllllIIIllIIIIlIIIIIIIIlI) {
            return "1x2_s" + (llllllllllllIIIllIIIIlIIIIIIIIlI.nextInt(2) + 1);
        }
    }
}
