// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;

public class BlockPartFace
{
    public final /* synthetic */ int tintIndex;
    public final /* synthetic */ EnumFacing cullFace;
    public final /* synthetic */ String texture;
    public final /* synthetic */ BlockFaceUV blockFaceUV;
    
    static {
        FACING_DEFAULT = null;
    }
    
    public BlockPartFace(@Nullable final EnumFacing llllllllllllIIIlllIIlllIlIIIIllI, final int llllllllllllIIIlllIIlllIlIIIIIII, final String llllllllllllIIIlllIIlllIlIIIIlII, final BlockFaceUV llllllllllllIIIlllIIlllIIllllllI) {
        this.cullFace = llllllllllllIIIlllIIlllIlIIIIllI;
        this.tintIndex = llllllllllllIIIlllIIlllIlIIIIIII;
        this.texture = llllllllllllIIIlllIIlllIlIIIIlII;
        this.blockFaceUV = llllllllllllIIIlllIIlllIIllllllI;
    }
    
    static class Deserializer implements JsonDeserializer<BlockPartFace>
    {
        protected int parseTintIndex(final JsonObject llllllllllllllIIllIIIllIlIlIIlIl) {
            return JsonUtils.getInt(llllllllllllllIIllIIIllIlIlIIlIl, "tintindex", -1);
        }
        
        private String parseTexture(final JsonObject llllllllllllllIIllIIIllIlIlIIIIl) {
            return JsonUtils.getString(llllllllllllllIIllIIIllIlIlIIIIl, "texture");
        }
        
        public BlockPartFace deserialize(final JsonElement llllllllllllllIIllIIIllIlIlllIII, final Type llllllllllllllIIllIIIllIlIllIlll, final JsonDeserializationContext llllllllllllllIIllIIIllIlIlIlllI) throws JsonParseException {
            final JsonObject llllllllllllllIIllIIIllIlIllIlIl = llllllllllllllIIllIIIllIlIlllIII.getAsJsonObject();
            final EnumFacing llllllllllllllIIllIIIllIlIllIlII = this.parseCullFace(llllllllllllllIIllIIIllIlIllIlIl);
            final int llllllllllllllIIllIIIllIlIllIIll = this.parseTintIndex(llllllllllllllIIllIIIllIlIllIlIl);
            final String llllllllllllllIIllIIIllIlIllIIlI = this.parseTexture(llllllllllllllIIllIIIllIlIllIlIl);
            final BlockFaceUV llllllllllllllIIllIIIllIlIllIIIl = (BlockFaceUV)llllllllllllllIIllIIIllIlIlIlllI.deserialize((JsonElement)llllllllllllllIIllIIIllIlIllIlIl, (Type)BlockFaceUV.class);
            return new BlockPartFace(llllllllllllllIIllIIIllIlIllIlII, llllllllllllllIIllIIIllIlIllIIll, llllllllllllllIIllIIIllIlIllIIlI, llllllllllllllIIllIIIllIlIllIIIl);
        }
        
        @Nullable
        private EnumFacing parseCullFace(final JsonObject llllllllllllllIIllIIIllIlIIllIll) {
            final String llllllllllllllIIllIIIllIlIIlllII = JsonUtils.getString(llllllllllllllIIllIIIllIlIIllIll, "cullface", "");
            return EnumFacing.byName(llllllllllllllIIllIIIllIlIIlllII);
        }
    }
}
