// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;
import javax.annotation.Nullable;

public class BlockFaceUV
{
    public /* synthetic */ float[] uvs;
    public final /* synthetic */ int rotation;
    
    public float getVertexU(final int lllllllllllIIlIIIIlIllIlIIlIIllI) {
        if (this.uvs == null) {
            throw new NullPointerException("uvs");
        }
        final int lllllllllllIIlIIIIlIllIlIIlIlIII = this.getVertexRotated(lllllllllllIIlIIIIlIllIlIIlIIllI);
        return (lllllllllllIIlIIIIlIllIlIIlIlIII != 0 && lllllllllllIIlIIIIlIllIlIIlIlIII != 1) ? this.uvs[2] : this.uvs[0];
    }
    
    public int getVertexRotatedRev(final int lllllllllllIIlIIIIlIllIlIIIlIIlI) {
        return (lllllllllllIIlIIIIlIllIlIIIlIIlI + (4 - this.rotation / 90)) % 4;
    }
    
    public float getVertexV(final int lllllllllllIIlIIIIlIllIlIIIlllIl) {
        if (this.uvs == null) {
            throw new NullPointerException("uvs");
        }
        final int lllllllllllIIlIIIIlIllIlIIIlllll = this.getVertexRotated(lllllllllllIIlIIIIlIllIlIIIlllIl);
        return (lllllllllllIIlIIIIlIllIlIIIlllll != 0 && lllllllllllIIlIIIIlIllIlIIIlllll != 3) ? this.uvs[3] : this.uvs[1];
    }
    
    private int getVertexRotated(final int lllllllllllIIlIIIIlIllIlIIIlIllI) {
        return (lllllllllllIIlIIIIlIllIlIIIlIllI + this.rotation / 90) % 4;
    }
    
    public void setUvs(final float[] lllllllllllIIlIIIIlIllIlIIIIlIlI) {
        if (this.uvs == null) {
            this.uvs = lllllllllllIIlIIIIlIllIlIIIIlIlI;
        }
    }
    
    public BlockFaceUV(@Nullable final float[] lllllllllllIIlIIIIlIllIlIIllIIlI, final int lllllllllllIIlIIIIlIllIlIIllIIIl) {
        this.uvs = lllllllllllIIlIIIIlIllIlIIllIIlI;
        this.rotation = lllllllllllIIlIIIIlIllIlIIllIIIl;
    }
    
    static class Deserializer implements JsonDeserializer<BlockFaceUV>
    {
        protected int parseRotation(final JsonObject llllllllllllllllIIlllllllIIlIlII) {
            final int llllllllllllllllIIlllllllIIlIIll = JsonUtils.getInt(llllllllllllllllIIlllllllIIlIlII, "rotation", 0);
            if (llllllllllllllllIIlllllllIIlIIll >= 0 && llllllllllllllllIIlllllllIIlIIll % 90 == 0 && llllllllllllllllIIlllllllIIlIIll / 90 <= 3) {
                return llllllllllllllllIIlllllllIIlIIll;
            }
            throw new JsonParseException("Invalid rotation " + llllllllllllllllIIlllllllIIlIIll + " found, only 0/90/180/270 allowed");
        }
        
        public BlockFaceUV deserialize(final JsonElement llllllllllllllllIIlllllllIlIIIlI, final Type llllllllllllllllIIlllllllIlIIIIl, final JsonDeserializationContext llllllllllllllllIIlllllllIlIIIII) throws JsonParseException {
            final JsonObject llllllllllllllllIIlllllllIIlllll = llllllllllllllllIIlllllllIlIIIlI.getAsJsonObject();
            final float[] llllllllllllllllIIlllllllIIllllI = this.parseUV(llllllllllllllllIIlllllllIIlllll);
            final int llllllllllllllllIIlllllllIIlllIl = this.parseRotation(llllllllllllllllIIlllllllIIlllll);
            return new BlockFaceUV(llllllllllllllllIIlllllllIIllllI, llllllllllllllllIIlllllllIIlllIl);
        }
        
        @Nullable
        private float[] parseUV(final JsonObject llllllllllllllllIIlllllllIIIIlll) {
            if (!llllllllllllllllIIlllllllIIIIlll.has("uv")) {
                return null;
            }
            final JsonArray llllllllllllllllIIlllllllIIIlIlI = JsonUtils.getJsonArray(llllllllllllllllIIlllllllIIIIlll, "uv");
            if (llllllllllllllllIIlllllllIIIlIlI.size() != 4) {
                throw new JsonParseException("Expected 4 uv values, found: " + llllllllllllllllIIlllllllIIIlIlI.size());
            }
            final float[] llllllllllllllllIIlllllllIIIlIIl = new float[4];
            for (int llllllllllllllllIIlllllllIIIlIII = 0; llllllllllllllllIIlllllllIIIlIII < llllllllllllllllIIlllllllIIIlIIl.length; ++llllllllllllllllIIlllllllIIIlIII) {
                llllllllllllllllIIlllllllIIIlIIl[llllllllllllllllIIlllllllIIIlIII] = JsonUtils.getFloat(llllllllllllllllIIlllllllIIIlIlI.get(llllllllllllllllIIlllllllIIIlIII), "uv[" + llllllllllllllllIIlllllllIIIlIII + "]");
            }
            return llllllllllllllllIIlllllllIIIlIIl;
        }
    }
}
