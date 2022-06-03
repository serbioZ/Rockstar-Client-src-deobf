// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.common.collect.Maps;
import com.google.gson.JsonParseException;
import com.google.gson.JsonElement;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import java.lang.reflect.Type;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import java.util.Set;
import com.google.common.collect.Sets;
import java.util.Collection;
import net.minecraft.util.JsonUtils;
import javax.annotation.Nullable;
import java.io.Reader;
import java.io.StringReader;
import com.google.gson.Gson;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Map;
import com.google.common.annotations.VisibleForTesting;

public class ModelBlock
{
    private final /* synthetic */ boolean gui3d;
    @VisibleForTesting
    protected /* synthetic */ ModelBlock parent;
    @VisibleForTesting
    protected final /* synthetic */ Map<String, String> textures;
    private final /* synthetic */ boolean ambientOcclusion;
    private final /* synthetic */ List<BlockPart> elements;
    private final /* synthetic */ List<ItemOverride> overrides;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ ItemCameraTransforms cameraTransforms;
    @VisibleForTesting
    protected /* synthetic */ ResourceLocation parentLocation;
    @VisibleForTesting
    static final /* synthetic */ Gson SERIALIZER;
    public /* synthetic */ String name;
    
    public boolean isResolved() {
        return this.parentLocation == null || (this.parent != null && this.parent.isResolved());
    }
    
    public ModelBlock getRootModel() {
        return this.hasParent() ? this.parent.getRootModel() : this;
    }
    
    public static ModelBlock deserialize(final String llllllllllllIIlllIIIIIlIIIlllIlI) {
        return deserialize(new StringReader(llllllllllllIIlllIIIIIlIIIlllIlI));
    }
    
    @Nullable
    public ResourceLocation getParentLocation() {
        return this.parentLocation;
    }
    
    public boolean isGui3d() {
        return this.gui3d;
    }
    
    public static ModelBlock deserialize(final Reader llllllllllllIIlllIIIIIlIIIlllllI) {
        return JsonUtils.gsonDeserialize(ModelBlock.SERIALIZER, llllllllllllIIlllIIIIIlIIIlllllI, ModelBlock.class, false);
    }
    
    public static void checkModelHierarchy(final Map<ResourceLocation, ModelBlock> llllllllllllIIlllIIIIIIllIlIllll) {
        for (final ModelBlock llllllllllllIIlllIIIIIIllIllIIlI : llllllllllllIIlllIIIIIIllIlIllll.values()) {
            try {
                for (ModelBlock llllllllllllIIlllIIIIIIllIllIIIl = llllllllllllIIlllIIIIIIllIllIIlI.parent, llllllllllllIIlllIIIIIIllIllIIII = llllllllllllIIlllIIIIIIllIllIIIl.parent; llllllllllllIIlllIIIIIIllIllIIIl != llllllllllllIIlllIIIIIIllIllIIII; llllllllllllIIlllIIIIIIllIllIIIl = llllllllllllIIlllIIIIIIllIllIIIl.parent, llllllllllllIIlllIIIIIIllIllIIII = llllllllllllIIlllIIIIIIllIllIIII.parent.parent) {}
                throw new LoopException();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public ItemCameraTransforms getAllTransforms() {
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIllll = this.getTransform(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND);
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIlllI = this.getTransform(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIllIl = this.getTransform(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND);
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIllII = this.getTransform(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND);
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIlIll = this.getTransform(ItemCameraTransforms.TransformType.HEAD);
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIlIlI = this.getTransform(ItemCameraTransforms.TransformType.GUI);
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIlIIl = this.getTransform(ItemCameraTransforms.TransformType.GROUND);
        final ItemTransformVec3f llllllllllllIIlllIIIIIIlllIIlIII = this.getTransform(ItemCameraTransforms.TransformType.FIXED);
        return new ItemCameraTransforms(llllllllllllIIlllIIIIIIlllIIllll, llllllllllllIIlllIIIIIIlllIIlllI, llllllllllllIIlllIIIIIIlllIIllIl, llllllllllllIIlllIIIIIIlllIIllII, llllllllllllIIlllIIIIIIlllIIlIll, llllllllllllIIlllIIIIIIlllIIlIlI, llllllllllllIIlllIIIIIIlllIIlIIl, llllllllllllIIlllIIIIIIlllIIlIII);
    }
    
    private boolean startsWithHash(final String llllllllllllIIlllIIIIIIllllIIIIl) {
        return llllllllllllIIlllIIIIIIllllIIIIl.charAt(0) == '#';
    }
    
    public boolean isTexturePresent(final String llllllllllllIIlllIIIIIIlllllIllI) {
        return !"missingno".equals(this.resolveTextureName(llllllllllllIIlllIIIIIIlllllIllI));
    }
    
    public boolean isAmbientOcclusion() {
        return this.hasParent() ? this.parent.isAmbientOcclusion() : this.ambientOcclusion;
    }
    
    private ItemTransformVec3f getTransform(final ItemCameraTransforms.TransformType llllllllllllIIlllIIIIIIllIlllIll) {
        return (this.parent != null && !this.cameraTransforms.hasCustomTransform(llllllllllllIIlllIIIIIIllIlllIll)) ? this.parent.getTransform(llllllllllllIIlllIIIIIIllIlllIll) : this.cameraTransforms.getTransform(llllllllllllIIlllIIIIIIllIlllIll);
    }
    
    private boolean hasParent() {
        return this.parent != null;
    }
    
    public Collection<ResourceLocation> getOverrideLocations() {
        final Set<ResourceLocation> llllllllllllIIlllIIIIIlIIIIIIlll = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ItemOverride llllllllllllIIlllIIIIIlIIIIIIllI : this.overrides) {
            llllllllllllIIlllIIIIIlIIIIIIlll.add(llllllllllllIIlllIIIIIlIIIIIIllI.getLocation());
        }
        return llllllllllllIIlllIIIIIlIIIIIIlll;
    }
    
    public ItemOverrideList createOverrides() {
        return this.overrides.isEmpty() ? ItemOverrideList.NONE : new ItemOverrideList(this.overrides);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        SERIALIZER = new GsonBuilder().registerTypeAdapter((Type)ModelBlock.class, (Object)new Deserializer()).registerTypeAdapter((Type)BlockPart.class, (Object)new BlockPart.Deserializer()).registerTypeAdapter((Type)BlockPartFace.class, (Object)new BlockPartFace.Deserializer()).registerTypeAdapter((Type)BlockFaceUV.class, (Object)new BlockFaceUV.Deserializer()).registerTypeAdapter((Type)ItemTransformVec3f.class, (Object)new ItemTransformVec3f.Deserializer()).registerTypeAdapter((Type)ItemCameraTransforms.class, (Object)new ItemCameraTransforms.Deserializer()).registerTypeAdapter((Type)ItemOverride.class, (Object)new ItemOverride.Deserializer()).create();
    }
    
    protected List<ItemOverride> getOverrides() {
        return this.overrides;
    }
    
    private String resolveTextureName(final String llllllllllllIIlllIIIIIIllllIlIlI, final Bookkeep llllllllllllIIlllIIIIIIllllIlIIl) {
        if (!this.startsWithHash(llllllllllllIIlllIIIIIIllllIlIlI)) {
            return llllllllllllIIlllIIIIIIllllIlIlI;
        }
        if (this == llllllllllllIIlllIIIIIIllllIlIIl.modelExt) {
            ModelBlock.LOGGER.warn("Unable to resolve texture due to upward reference: {} in {}", (Object)llllllllllllIIlllIIIIIIllllIlIlI, (Object)this.name);
            return "missingno";
        }
        String llllllllllllIIlllIIIIIIllllIlIII = this.textures.get(llllllllllllIIlllIIIIIIllllIlIlI.substring(1));
        if (llllllllllllIIlllIIIIIIllllIlIII == null && this.hasParent()) {
            llllllllllllIIlllIIIIIIllllIlIII = this.parent.resolveTextureName(llllllllllllIIlllIIIIIIllllIlIlI, llllllllllllIIlllIIIIIIllllIlIIl);
        }
        llllllllllllIIlllIIIIIIllllIlIIl.modelExt = this;
        if (llllllllllllIIlllIIIIIIllllIlIII != null && this.startsWithHash(llllllllllllIIlllIIIIIIllllIlIII)) {
            llllllllllllIIlllIIIIIIllllIlIII = llllllllllllIIlllIIIIIIllllIlIIl.model.resolveTextureName(llllllllllllIIlllIIIIIIllllIlIII, llllllllllllIIlllIIIIIIllllIlIIl);
        }
        return (llllllllllllIIlllIIIIIIllllIlIII != null && !this.startsWithHash(llllllllllllIIlllIIIIIIllllIlIII)) ? llllllllllllIIlllIIIIIIllllIlIII : "missingno";
    }
    
    public String resolveTextureName(String llllllllllllIIlllIIIIIIlllllIIII) {
        if (!this.startsWithHash((String)llllllllllllIIlllIIIIIIlllllIIII)) {
            llllllllllllIIlllIIIIIIlllllIIII = String.valueOf('#') + (String)llllllllllllIIlllIIIIIIlllllIIII;
        }
        return this.resolveTextureName((String)llllllllllllIIlllIIIIIIlllllIIII, new Bookkeep(this, null));
    }
    
    public List<BlockPart> getElements() {
        return (this.elements.isEmpty() && this.hasParent()) ? this.parent.getElements() : this.elements;
    }
    
    public ModelBlock(@Nullable final ResourceLocation llllllllllllIIlllIIIIIlIIIlIlIII, final List<BlockPart> llllllllllllIIlllIIIIIlIIIlIllll, final Map<String, String> llllllllllllIIlllIIIIIlIIIlIlllI, final boolean llllllllllllIIlllIIIIIlIIIlIIlIl, final boolean llllllllllllIIlllIIIIIlIIIlIIlII, final ItemCameraTransforms llllllllllllIIlllIIIIIlIIIlIIIll, final List<ItemOverride> llllllllllllIIlllIIIIIlIIIlIlIlI) {
        this.name = "";
        this.elements = llllllllllllIIlllIIIIIlIIIlIllll;
        this.ambientOcclusion = llllllllllllIIlllIIIIIlIIIlIIlIl;
        this.gui3d = llllllllllllIIlllIIIIIlIIIlIIlII;
        this.textures = llllllllllllIIlllIIIIIlIIIlIlllI;
        this.parentLocation = llllllllllllIIlllIIIIIlIIIlIlIII;
        this.cameraTransforms = llllllllllllIIlllIIIIIlIIIlIIIll;
        this.overrides = llllllllllllIIlllIIIIIlIIIlIlIlI;
    }
    
    public void getParentFromMap(final Map<ResourceLocation, ModelBlock> llllllllllllIIlllIIIIIlIIIIIllIl) {
        if (this.parentLocation != null) {
            this.parent = llllllllllllIIlllIIIIIlIIIIIllIl.get(this.parentLocation);
        }
    }
    
    static final class Bookkeep
    {
        public /* synthetic */ ModelBlock modelExt;
        public final /* synthetic */ ModelBlock model;
        
        private Bookkeep() {
        }
    }
    
    public static class Deserializer implements JsonDeserializer<ModelBlock>
    {
        protected List<ItemOverride> getItemOverrides(final JsonDeserializationContext lllllllllllIIIllllIlllllIllllIll, final JsonObject lllllllllllIIIllllIlllllIllllllI) {
            final List<ItemOverride> lllllllllllIIIllllIlllllIlllllIl = (List<ItemOverride>)Lists.newArrayList();
            if (lllllllllllIIIllllIlllllIllllllI.has("overrides")) {
                for (final JsonElement lllllllllllIIIllllIlllllIlllllII : JsonUtils.getJsonArray(lllllllllllIIIllllIlllllIllllllI, "overrides")) {
                    lllllllllllIIIllllIlllllIlllllIl.add((ItemOverride)lllllllllllIIIllllIlllllIllllIll.deserialize(lllllllllllIIIllllIlllllIlllllII, (Type)ItemOverride.class));
                }
            }
            return lllllllllllIIIllllIlllllIlllllIl;
        }
        
        public ModelBlock deserialize(final JsonElement lllllllllllIIIllllIllllllIIIllll, final Type lllllllllllIIIllllIllllllIIllIll, final JsonDeserializationContext lllllllllllIIIllllIllllllIIIlllI) throws JsonParseException {
            final JsonObject lllllllllllIIIllllIllllllIIllIIl = lllllllllllIIIllllIllllllIIIllll.getAsJsonObject();
            final List<BlockPart> lllllllllllIIIllllIllllllIIllIII = this.getModelElements(lllllllllllIIIllllIllllllIIIlllI, lllllllllllIIIllllIllllllIIllIIl);
            final String lllllllllllIIIllllIllllllIIlIlll = this.getParent(lllllllllllIIIllllIllllllIIllIIl);
            final Map<String, String> lllllllllllIIIllllIllllllIIlIllI = this.getTextures(lllllllllllIIIllllIllllllIIllIIl);
            final boolean lllllllllllIIIllllIllllllIIlIlIl = this.getAmbientOcclusionEnabled(lllllllllllIIIllllIllllllIIllIIl);
            ItemCameraTransforms lllllllllllIIIllllIllllllIIlIlII = ItemCameraTransforms.DEFAULT;
            if (lllllllllllIIIllllIllllllIIllIIl.has("display")) {
                final JsonObject lllllllllllIIIllllIllllllIIlIIll = JsonUtils.getJsonObject(lllllllllllIIIllllIllllllIIllIIl, "display");
                lllllllllllIIIllllIllllllIIlIlII = (ItemCameraTransforms)lllllllllllIIIllllIllllllIIIlllI.deserialize((JsonElement)lllllllllllIIIllllIllllllIIlIIll, (Type)ItemCameraTransforms.class);
            }
            final List<ItemOverride> lllllllllllIIIllllIllllllIIlIIlI = this.getItemOverrides(lllllllllllIIIllllIllllllIIIlllI, lllllllllllIIIllllIllllllIIllIIl);
            final ResourceLocation lllllllllllIIIllllIllllllIIlIIIl = lllllllllllIIIllllIllllllIIlIlll.isEmpty() ? null : new ResourceLocation(lllllllllllIIIllllIllllllIIlIlll);
            return new ModelBlock(lllllllllllIIIllllIllllllIIlIIIl, lllllllllllIIIllllIllllllIIllIII, lllllllllllIIIllllIllllllIIlIllI, lllllllllllIIIllllIllllllIIlIlIl, true, lllllllllllIIIllllIllllllIIlIlII, lllllllllllIIIllllIllllllIIlIIlI);
        }
        
        protected boolean getAmbientOcclusionEnabled(final JsonObject lllllllllllIIIllllIlllllIllIIIIl) {
            return JsonUtils.getBoolean(lllllllllllIIIllllIlllllIllIIIIl, "ambientocclusion", true);
        }
        
        protected List<BlockPart> getModelElements(final JsonDeserializationContext lllllllllllIIIllllIlllllIlIlIlIl, final JsonObject lllllllllllIIIllllIlllllIlIlIlII) {
            final List<BlockPart> lllllllllllIIIllllIlllllIlIlIlll = (List<BlockPart>)Lists.newArrayList();
            if (lllllllllllIIIllllIlllllIlIlIlII.has("elements")) {
                for (final JsonElement lllllllllllIIIllllIlllllIlIlIllI : JsonUtils.getJsonArray(lllllllllllIIIllllIlllllIlIlIlII, "elements")) {
                    lllllllllllIIIllllIlllllIlIlIlll.add((BlockPart)lllllllllllIIIllllIlllllIlIlIlIl.deserialize(lllllllllllIIIllllIlllllIlIlIllI, (Type)BlockPart.class));
                }
            }
            return lllllllllllIIIllllIlllllIlIlIlll;
        }
        
        private String getParent(final JsonObject lllllllllllIIIllllIlllllIllIIlII) {
            return JsonUtils.getString(lllllllllllIIIllllIlllllIllIIlII, "parent", "");
        }
        
        private Map<String, String> getTextures(final JsonObject lllllllllllIIIllllIlllllIllIllII) {
            final Map<String, String> lllllllllllIIIllllIlllllIllIllll = (Map<String, String>)Maps.newHashMap();
            if (lllllllllllIIIllllIlllllIllIllII.has("textures")) {
                final JsonObject lllllllllllIIIllllIlllllIllIlllI = lllllllllllIIIllllIlllllIllIllII.getAsJsonObject("textures");
                for (final Map.Entry<String, JsonElement> lllllllllllIIIllllIlllllIllIllIl : lllllllllllIIIllllIlllllIllIlllI.entrySet()) {
                    lllllllllllIIIllllIlllllIllIllll.put(lllllllllllIIIllllIlllllIllIllIl.getKey(), lllllllllllIIIllllIlllllIllIllIl.getValue().getAsString());
                }
            }
            return lllllllllllIIIllllIlllllIllIllll;
        }
    }
    
    public static class LoopException extends RuntimeException
    {
    }
}
