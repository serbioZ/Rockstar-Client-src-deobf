// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import net.minecraft.util.math.MathHelper;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import java.util.Locale;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import java.util.Map;
import org.lwjgl.util.vector.Vector3f;

public class BlockPart
{
    public final /* synthetic */ Vector3f positionFrom;
    public final /* synthetic */ Map<EnumFacing, BlockPartFace> mapFaces;
    public final /* synthetic */ BlockPartRotation partRotation;
    public final /* synthetic */ Vector3f positionTo;
    public final /* synthetic */ boolean shade;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockPart.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final byte lllllllllllIlIIllIlllllIIIlIlIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlIIllIlllllIIIlIlIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIllIlllllIIIlIlIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIllIlllllIIIlIlIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIllIlllllIIIlIlIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIIllIlllllIIIlIlIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlIIllIlllllIIIlIlIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockPart.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlIIllIlllllIIIlIlIII;
    }
    
    private float[] getFaceUvs(final EnumFacing lllllllllllIlIIllIlllllIIIlIllII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIIllIlllllIIIlIllII.ordinal()]) {
            case 1: {
                return new float[] { this.positionFrom.x, 16.0f - this.positionTo.z, this.positionTo.x, 16.0f - this.positionFrom.z };
            }
            case 2: {
                return new float[] { this.positionFrom.x, this.positionFrom.z, this.positionTo.x, this.positionTo.z };
            }
            default: {
                return new float[] { 16.0f - this.positionTo.x, 16.0f - this.positionTo.y, 16.0f - this.positionFrom.x, 16.0f - this.positionFrom.y };
            }
            case 4: {
                return new float[] { this.positionFrom.x, 16.0f - this.positionTo.y, this.positionTo.x, 16.0f - this.positionFrom.y };
            }
            case 5: {
                return new float[] { this.positionFrom.z, 16.0f - this.positionTo.y, this.positionTo.z, 16.0f - this.positionFrom.y };
            }
            case 6: {
                return new float[] { 16.0f - this.positionTo.z, 16.0f - this.positionTo.y, 16.0f - this.positionFrom.z, 16.0f - this.positionFrom.y };
            }
        }
    }
    
    public BlockPart(final Vector3f lllllllllllIlIIllIlllllIIlIIIlIl, final Vector3f lllllllllllIlIIllIlllllIIlIIIlII, final Map<EnumFacing, BlockPartFace> lllllllllllIlIIllIlllllIIlIIIIll, @Nullable final BlockPartRotation lllllllllllIlIIllIlllllIIIllllII, final boolean lllllllllllIlIIllIlllllIIlIIIIIl) {
        this.positionFrom = lllllllllllIlIIllIlllllIIlIIIlIl;
        this.positionTo = lllllllllllIlIIllIlllllIIlIIIlII;
        this.mapFaces = lllllllllllIlIIllIlllllIIlIIIIll;
        this.partRotation = lllllllllllIlIIllIlllllIIIllllII;
        this.shade = lllllllllllIlIIllIlllllIIlIIIIIl;
        this.setDefaultUvs();
    }
    
    private void setDefaultUvs() {
        for (final Map.Entry<EnumFacing, BlockPartFace> lllllllllllIlIIllIlllllIIIllIlIl : this.mapFaces.entrySet()) {
            final float[] lllllllllllIlIIllIlllllIIIllIlII = this.getFaceUvs(lllllllllllIlIIllIlllllIIIllIlIl.getKey());
            lllllllllllIlIIllIlllllIIIllIlIl.getValue().blockFaceUV.setUvs(lllllllllllIlIIllIlllllIIIllIlII);
        }
    }
    
    static class Deserializer implements JsonDeserializer<BlockPart>
    {
        private Vector3f parsePositionTo(final JsonObject llllllllllllllIlIIlIIlIlIIIlIIIl) {
            final Vector3f llllllllllllllIlIIlIIlIlIIIlIIll = this.parsePosition(llllllllllllllIlIIlIIlIlIIIlIIIl, "to");
            if (llllllllllllllIlIIlIIlIlIIIlIIll.x >= -16.0f && llllllllllllllIlIIlIIlIlIIIlIIll.y >= -16.0f && llllllllllllllIlIIlIIlIlIIIlIIll.z >= -16.0f && llllllllllllllIlIIlIIlIlIIIlIIll.x <= 32.0f && llllllllllllllIlIIlIIlIlIIIlIIll.y <= 32.0f && llllllllllllllIlIIlIIlIlIIIlIIll.z <= 32.0f) {
                return llllllllllllllIlIIlIIlIlIIIlIIll;
            }
            throw new JsonParseException("'to' specifier exceeds the allowed boundaries: " + llllllllllllllIlIIlIIlIlIIIlIIll);
        }
        
        private Vector3f parsePositionFrom(final JsonObject llllllllllllllIlIIlIIlIlIIIIlIII) {
            final Vector3f llllllllllllllIlIIlIIlIlIIIIlIlI = this.parsePosition(llllllllllllllIlIIlIIlIlIIIIlIII, "from");
            if (llllllllllllllIlIIlIIlIlIIIIlIlI.x >= -16.0f && llllllllllllllIlIIlIIlIlIIIIlIlI.y >= -16.0f && llllllllllllllIlIIlIIlIlIIIIlIlI.z >= -16.0f && llllllllllllllIlIIlIIlIlIIIIlIlI.x <= 32.0f && llllllllllllllIlIIlIIlIlIIIIlIlI.y <= 32.0f && llllllllllllllIlIIlIIlIlIIIIlIlI.z <= 32.0f) {
                return llllllllllllllIlIIlIIlIlIIIIlIlI;
            }
            throw new JsonParseException("'from' specifier exceeds the allowed boundaries: " + llllllllllllllIlIIlIIlIlIIIIlIlI);
        }
        
        private EnumFacing parseEnumFacing(final String llllllllllllllIlIIlIIlIlIIIllIlI) {
            final EnumFacing llllllllllllllIlIIlIIlIlIIIllIll = EnumFacing.byName(llllllllllllllIlIIlIIlIlIIIllIlI);
            if (llllllllllllllIlIIlIIlIlIIIllIll == null) {
                throw new JsonParseException("Unknown facing: " + llllllllllllllIlIIlIIlIlIIIllIlI);
            }
            return llllllllllllllIlIIlIIlIlIIIllIll;
        }
        
        private EnumFacing.Axis parseAxis(final JsonObject llllllllllllllIlIIlIIlIlIlIIIlIl) {
            final String llllllllllllllIlIIlIIlIlIlIIIlll = JsonUtils.getString(llllllllllllllIlIIlIIlIlIlIIIlIl, "axis");
            final EnumFacing.Axis llllllllllllllIlIIlIIlIlIlIIIllI = EnumFacing.Axis.byName(llllllllllllllIlIIlIIlIlIlIIIlll.toLowerCase(Locale.ROOT));
            if (llllllllllllllIlIIlIIlIlIlIIIllI == null) {
                throw new JsonParseException("Invalid rotation axis: " + llllllllllllllIlIIlIIlIlIlIIIlll);
            }
            return llllllllllllllIlIIlIIlIlIlIIIllI;
        }
        
        public BlockPart deserialize(final JsonElement llllllllllllllIlIIlIIlIlIlllIIll, final Type llllllllllllllIlIIlIIlIlIlllllII, final JsonDeserializationContext llllllllllllllIlIIlIIlIlIlllIIlI) throws JsonParseException {
            final JsonObject llllllllllllllIlIIlIIlIlIllllIlI = llllllllllllllIlIIlIIlIlIlllIIll.getAsJsonObject();
            final Vector3f llllllllllllllIlIIlIIlIlIllllIIl = this.parsePositionFrom(llllllllllllllIlIIlIIlIlIllllIlI);
            final Vector3f llllllllllllllIlIIlIIlIlIllllIII = this.parsePositionTo(llllllllllllllIlIIlIIlIlIllllIlI);
            final BlockPartRotation llllllllllllllIlIIlIIlIlIlllIlll = this.parseRotation(llllllllllllllIlIIlIIlIlIllllIlI);
            final Map<EnumFacing, BlockPartFace> llllllllllllllIlIIlIIlIlIlllIllI = this.parseFacesCheck(llllllllllllllIlIIlIIlIlIlllIIlI, llllllllllllllIlIIlIIlIlIllllIlI);
            if (llllllllllllllIlIIlIIlIlIllllIlI.has("shade") && !JsonUtils.isBoolean(llllllllllllllIlIIlIIlIlIllllIlI, "shade")) {
                throw new JsonParseException("Expected shade to be a Boolean");
            }
            final boolean llllllllllllllIlIIlIIlIlIlllIlIl = JsonUtils.getBoolean(llllllllllllllIlIIlIIlIlIllllIlI, "shade", true);
            return new BlockPart(llllllllllllllIlIIlIIlIlIllllIIl, llllllllllllllIlIIlIIlIlIllllIII, llllllllllllllIlIIlIIlIlIlllIllI, llllllllllllllIlIIlIIlIlIlllIlll, llllllllllllllIlIIlIIlIlIlllIlIl);
        }
        
        private float parseAngle(final JsonObject llllllllllllllIlIIlIIlIlIlIlIIII) {
            final float llllllllllllllIlIIlIIlIlIlIIllll = JsonUtils.getFloat(llllllllllllllIlIIlIIlIlIlIlIIII, "angle");
            if (llllllllllllllIlIIlIIlIlIlIIllll != 0.0f && MathHelper.abs(llllllllllllllIlIIlIIlIlIlIIllll) != 22.5f && MathHelper.abs(llllllllllllllIlIIlIIlIlIlIIllll) != 45.0f) {
                throw new JsonParseException("Invalid rotation " + llllllllllllllIlIIlIIlIlIlIIllll + " found, only -45/-22.5/0/22.5/45 allowed");
            }
            return llllllllllllllIlIIlIIlIlIlIIllll;
        }
        
        @Nullable
        private BlockPartRotation parseRotation(final JsonObject llllllllllllllIlIIlIIlIlIllIIIlI) {
            BlockPartRotation llllllllllllllIlIIlIIlIlIllIIIIl = null;
            if (llllllllllllllIlIIlIIlIlIllIIIlI.has("rotation")) {
                final JsonObject llllllllllllllIlIIlIIlIlIllIIIII = JsonUtils.getJsonObject(llllllllllllllIlIIlIIlIlIllIIIlI, "rotation");
                final Vector3f llllllllllllllIlIIlIIlIlIlIlllll = this.parsePosition(llllllllllllllIlIIlIIlIlIllIIIII, "origin");
                llllllllllllllIlIIlIIlIlIlIlllll.scale(0.0625f);
                final EnumFacing.Axis llllllllllllllIlIIlIIlIlIlIllllI = this.parseAxis(llllllllllllllIlIIlIIlIlIllIIIII);
                final float llllllllllllllIlIIlIIlIlIlIlllIl = this.parseAngle(llllllllllllllIlIIlIIlIlIllIIIII);
                final boolean llllllllllllllIlIIlIIlIlIlIlllII = JsonUtils.getBoolean(llllllllllllllIlIIlIIlIlIllIIIII, "rescale", false);
                llllllllllllllIlIIlIIlIlIllIIIIl = new BlockPartRotation(llllllllllllllIlIIlIIlIlIlIlllll, llllllllllllllIlIIlIIlIlIlIllllI, llllllllllllllIlIIlIIlIlIlIlllIl, llllllllllllllIlIIlIIlIlIlIlllII);
            }
            return llllllllllllllIlIIlIIlIlIllIIIIl;
        }
        
        private Vector3f parsePosition(final JsonObject llllllllllllllIlIIlIIlIlIIIIIIII, final String llllllllllllllIlIIlIIlIIlllllIlI) {
            final JsonArray llllllllllllllIlIIlIIlIIlllllllI = JsonUtils.getJsonArray(llllllllllllllIlIIlIIlIlIIIIIIII, llllllllllllllIlIIlIIlIIlllllIlI);
            if (llllllllllllllIlIIlIIlIIlllllllI.size() != 3) {
                throw new JsonParseException("Expected 3 " + llllllllllllllIlIIlIIlIIlllllIlI + " values, found: " + llllllllllllllIlIIlIIlIIlllllllI.size());
            }
            final float[] llllllllllllllIlIIlIIlIIllllllIl = new float[3];
            for (int llllllllllllllIlIIlIIlIIllllllII = 0; llllllllllllllIlIIlIIlIIllllllII < llllllllllllllIlIIlIIlIIllllllIl.length; ++llllllllllllllIlIIlIIlIIllllllII) {
                llllllllllllllIlIIlIIlIIllllllIl[llllllllllllllIlIIlIIlIIllllllII] = JsonUtils.getFloat(llllllllllllllIlIIlIIlIIlllllllI.get(llllllllllllllIlIIlIIlIIllllllII), String.valueOf(llllllllllllllIlIIlIIlIIlllllIlI) + "[" + llllllllllllllIlIIlIIlIIllllllII + "]");
            }
            return new Vector3f(llllllllllllllIlIIlIIlIIllllllIl[0], llllllllllllllIlIIlIIlIIllllllIl[1], llllllllllllllIlIIlIIlIIllllllIl[2]);
        }
        
        private Map<EnumFacing, BlockPartFace> parseFacesCheck(final JsonDeserializationContext llllllllllllllIlIIlIIlIlIIlllIIl, final JsonObject llllllllllllllIlIIlIIlIlIIllllII) {
            final Map<EnumFacing, BlockPartFace> llllllllllllllIlIIlIIlIlIIlllIll = this.parseFaces(llllllllllllllIlIIlIIlIlIIlllIIl, llllllllllllllIlIIlIIlIlIIllllII);
            if (llllllllllllllIlIIlIIlIlIIlllIll.isEmpty()) {
                throw new JsonParseException("Expected between 1 and 6 unique faces, got 0");
            }
            return llllllllllllllIlIIlIIlIlIIlllIll;
        }
        
        private Map<EnumFacing, BlockPartFace> parseFaces(final JsonDeserializationContext llllllllllllllIlIIlIIlIlIIlIIllI, final JsonObject llllllllllllllIlIIlIIlIlIIlIIlIl) {
            final Map<EnumFacing, BlockPartFace> llllllllllllllIlIIlIIlIlIIlIlIll = (Map<EnumFacing, BlockPartFace>)Maps.newEnumMap((Class)EnumFacing.class);
            final JsonObject llllllllllllllIlIIlIIlIlIIlIlIlI = JsonUtils.getJsonObject(llllllllllllllIlIIlIIlIlIIlIIlIl, "faces");
            for (final Map.Entry<String, JsonElement> llllllllllllllIlIIlIIlIlIIlIlIIl : llllllllllllllIlIIlIIlIlIIlIlIlI.entrySet()) {
                final EnumFacing llllllllllllllIlIIlIIlIlIIlIlIII = this.parseEnumFacing(llllllllllllllIlIIlIIlIlIIlIlIIl.getKey());
                llllllllllllllIlIIlIIlIlIIlIlIll.put(llllllllllllllIlIIlIIlIlIIlIlIII, (BlockPartFace)llllllllllllllIlIIlIIlIlIIlIIllI.deserialize((JsonElement)llllllllllllllIlIIlIIlIlIIlIlIIl.getValue(), (Type)BlockPartFace.class));
            }
            return llllllllllllllIlIIlIIlIlIIlIlIll;
        }
    }
}
