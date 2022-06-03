// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Map;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.template.Template;

public abstract class StructureComponentTemplate extends StructureComponent
{
    protected /* synthetic */ Template template;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    protected /* synthetic */ BlockPos templatePosition;
    private static final /* synthetic */ PlacementSettings DEFAULT_PLACE_SETTINGS;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    protected /* synthetic */ PlacementSettings placeSettings;
    
    protected void setup(final Template llllllllllllllllIIIIllIllIlllIlI, final BlockPos llllllllllllllllIIIIllIllIllIlIl, final PlacementSettings llllllllllllllllIIIIllIllIlllIII) {
        this.template = llllllllllllllllIIIIllIllIlllIlI;
        this.setCoordBaseMode(EnumFacing.NORTH);
        this.templatePosition = llllllllllllllllIIIIllIllIllIlIl;
        this.placeSettings = llllllllllllllllIIIIllIllIlllIII;
        this.setBoundingBoxFromTemplate();
    }
    
    @Override
    protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIIIIllIllIllIIII) {
        llllllllllllllllIIIIllIllIllIIII.setInteger("TPX", this.templatePosition.getX());
        llllllllllllllllIIIIllIllIllIIII.setInteger("TPY", this.templatePosition.getY());
        llllllllllllllllIIIIllIllIllIIII.setInteger("TPZ", this.templatePosition.getZ());
    }
    
    private void setBoundingBoxFromTemplate() {
        final Rotation llllllllllllllllIIIIllIllIIIlIII = this.placeSettings.getRotation();
        final BlockPos llllllllllllllllIIIIllIllIIIIlll = this.template.transformedSize(llllllllllllllllIIIIllIllIIIlIII);
        final Mirror llllllllllllllllIIIIllIllIIIIllI = this.placeSettings.getMirror();
        this.boundingBox = new StructureBoundingBox(0, 0, 0, llllllllllllllllIIIIllIllIIIIlll.getX(), llllllllllllllllIIIIllIllIIIIlll.getY() - 1, llllllllllllllllIIIIllIllIIIIlll.getZ());
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllllIIIIllIllIIIlIII.ordinal()]) {
            case 2: {
                this.boundingBox.offset(-llllllllllllllllIIIIllIllIIIIlll.getX(), 0, 0);
                break;
            }
            case 4: {
                this.boundingBox.offset(0, 0, -llllllllllllllllIIIIllIllIIIIlll.getZ());
                break;
            }
            case 3: {
                this.boundingBox.offset(-llllllllllllllllIIIIllIllIIIIlll.getX(), 0, -llllllllllllllllIIIIllIllIIIIlll.getZ());
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllllIIIIllIllIIIIllI.ordinal()]) {
            case 3: {
                BlockPos llllllllllllllllIIIIllIllIIIIlIl = BlockPos.ORIGIN;
                if (llllllllllllllllIIIIllIllIIIlIII != Rotation.CLOCKWISE_90 && llllllllllllllllIIIIllIllIIIlIII != Rotation.COUNTERCLOCKWISE_90) {
                    if (llllllllllllllllIIIIllIllIIIlIII == Rotation.CLOCKWISE_180) {
                        llllllllllllllllIIIIllIllIIIIlIl = llllllllllllllllIIIIllIllIIIIlIl.offset(EnumFacing.EAST, llllllllllllllllIIIIllIllIIIIlll.getX());
                    }
                    else {
                        llllllllllllllllIIIIllIllIIIIlIl = llllllllllllllllIIIIllIllIIIIlIl.offset(EnumFacing.WEST, llllllllllllllllIIIIllIllIIIIlll.getX());
                    }
                }
                else {
                    llllllllllllllllIIIIllIllIIIIlIl = llllllllllllllllIIIIllIllIIIIlIl.offset(llllllllllllllllIIIIllIllIIIlIII.rotate(EnumFacing.WEST), llllllllllllllllIIIIllIllIIIIlll.getZ());
                }
                this.boundingBox.offset(llllllllllllllllIIIIllIllIIIIlIl.getX(), 0, llllllllllllllllIIIIllIllIIIIlIl.getZ());
                break;
            }
            case 2: {
                BlockPos llllllllllllllllIIIIllIllIIIIlII = BlockPos.ORIGIN;
                if (llllllllllllllllIIIIllIllIIIlIII != Rotation.CLOCKWISE_90 && llllllllllllllllIIIIllIllIIIlIII != Rotation.COUNTERCLOCKWISE_90) {
                    if (llllllllllllllllIIIIllIllIIIlIII == Rotation.CLOCKWISE_180) {
                        llllllllllllllllIIIIllIllIIIIlII = llllllllllllllllIIIIllIllIIIIlII.offset(EnumFacing.SOUTH, llllllllllllllllIIIIllIllIIIIlll.getZ());
                    }
                    else {
                        llllllllllllllllIIIIllIllIIIIlII = llllllllllllllllIIIIllIllIIIIlII.offset(EnumFacing.NORTH, llllllllllllllllIIIIllIllIIIIlll.getZ());
                    }
                }
                else {
                    llllllllllllllllIIIIllIllIIIIlII = llllllllllllllllIIIIllIllIIIIlII.offset(llllllllllllllllIIIIllIllIIIlIII.rotate(EnumFacing.NORTH), llllllllllllllllIIIIllIllIIIIlll.getX());
                }
                this.boundingBox.offset(llllllllllllllllIIIIllIllIIIIlII.getX(), 0, llllllllllllllllIIIIllIllIIIIlII.getZ());
                break;
            }
        }
        this.boundingBox.offset(this.templatePosition.getX(), this.templatePosition.getY(), this.templatePosition.getZ());
    }
    
    static {
        DEFAULT_PLACE_SETTINGS = new PlacementSettings();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final byte llllllllllllllllIIIIllIlIlllIIII = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllllIIIIllIlIlllIIII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIIllIlIlllIIII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIIllIlIlllIIII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIIIIllIlIlllIIII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllllIIIIllIlIlllIIII;
    }
    
    @Override
    public void offset(final int llllllllllllllllIIIIllIlIllllIII, final int llllllllllllllllIIIIllIlIlllIIll, final int llllllllllllllllIIIIllIlIlllIIlI) {
        super.offset(llllllllllllllllIIIIllIlIllllIII, llllllllllllllllIIIIllIlIlllIIll, llllllllllllllllIIIIllIlIlllIIlI);
        this.templatePosition = this.templatePosition.add(llllllllllllllllIIIIllIlIllllIII, llllllllllllllllIIIIllIlIlllIIll, llllllllllllllllIIIIllIlIlllIIlI);
    }
    
    public StructureComponentTemplate(final int llllllllllllllllIIIIllIlllIIIIlI) {
        super(llllllllllllllllIIIIllIlllIIIIlI);
        this.placeSettings = StructureComponentTemplate.DEFAULT_PLACE_SETTINGS.setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final float llllllllllllllllIIIIllIlIllIlllI = (Object)new int[Mirror.values().length];
        try {
            llllllllllllllllIIIIllIlIllIlllI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIIllIlIllIlllI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIIllIlIllIlllI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllllllIIIIllIlIllIlllI;
    }
    
    public StructureComponentTemplate() {
        this.placeSettings = StructureComponentTemplate.DEFAULT_PLACE_SETTINGS.setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }
    
    @Override
    protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIIIIllIllIlIIlll, final TemplateManager llllllllllllllllIIIIllIllIlIlIIl) {
        this.templatePosition = new BlockPos(llllllllllllllllIIIIllIllIlIIlll.getInteger("TPX"), llllllllllllllllIIIIllIllIlIIlll.getInteger("TPY"), llllllllllllllllIIIIllIllIlIIlll.getInteger("TPZ"));
    }
    
    @Override
    public boolean addComponentParts(final World llllllllllllllllIIIIllIllIIlllIl, final Random llllllllllllllllIIIIllIllIIlllII, final StructureBoundingBox llllllllllllllllIIIIllIllIIlIlII) {
        this.placeSettings.setBoundingBox(llllllllllllllllIIIIllIllIIlIlII);
        this.template.addBlocksToWorld(llllllllllllllllIIIIllIllIIlllIl, this.templatePosition, this.placeSettings, 18);
        final Map<BlockPos, String> llllllllllllllllIIIIllIllIIllIlI = this.template.getDataBlocks(this.templatePosition, this.placeSettings);
        for (final Map.Entry<BlockPos, String> llllllllllllllllIIIIllIllIIllIIl : llllllllllllllllIIIIllIllIIllIlI.entrySet()) {
            final String llllllllllllllllIIIIllIllIIllIII = llllllllllllllllIIIIllIllIIllIIl.getValue();
            this.handleDataMarker(llllllllllllllllIIIIllIllIIllIII, llllllllllllllllIIIIllIllIIllIIl.getKey(), llllllllllllllllIIIIllIllIIlllIl, llllllllllllllllIIIIllIllIIlllII, llllllllllllllllIIIIllIllIIlIlII);
        }
        return true;
    }
    
    protected abstract void handleDataMarker(final String p0, final BlockPos p1, final World p2, final Random p3, final StructureBoundingBox p4);
}
