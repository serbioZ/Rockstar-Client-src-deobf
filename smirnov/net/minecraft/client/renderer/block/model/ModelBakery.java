// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.block.model.multipart.Multipart;
import net.minecraft.client.renderer.block.model.multipart.Selector;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import com.google.common.collect.Iterables;
import com.google.common.base.Predicate;
import net.minecraft.client.renderer.block.statemap.BlockStateMapper;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import java.io.Reader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import net.minecraft.client.resources.IResource;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.model.ITransformation;
import java.util.Deque;
import com.google.common.collect.Queues;
import optifine.StrUtils;
import optifine.TextureUtils;
import net.minecraft.util.registry.IRegistry;
import optifine.CustomItems;
import java.util.Iterator;
import net.minecraft.block.Block;
import java.util.Comparator;
import java.io.IOException;
import java.util.Collections;
import com.google.common.collect.Lists;
import net.minecraft.util.EnumFacing;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Sets;
import javax.annotation.Nullable;
import optifine.Reflector;
import net.minecraft.client.renderer.texture.ITextureMapPopulator;
import org.apache.logging.log4j.Logger;
import java.util.Set;
import net.minecraftforge.registries.IRegistryDelegate;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.util.registry.RegistrySimple;
import com.google.common.base.Joiner;
import net.minecraft.client.renderer.BlockModelShapes;
import java.util.Collection;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.client.resources.IResourceManager;

public class ModelBakery
{
    private final /* synthetic */ IResourceManager resourceManager;
    private final /* synthetic */ Map<ResourceLocation, ModelBlock> models;
    private final /* synthetic */ Map<ModelBlockDefinition, Collection<ModelResourceLocation>> multipartVariantMap;
    private final /* synthetic */ Map<ResourceLocation, ModelBlockDefinition> blockDefinitions;
    private final /* synthetic */ Map<ModelResourceLocation, VariantList> variants;
    private final /* synthetic */ BlockModelShapes blockModelShapes;
    private static final /* synthetic */ ModelBlock MODEL_GENERATED;
    private final /* synthetic */ FaceBakery faceBakery;
    private static final /* synthetic */ String MISSING_MODEL_MESH;
    private static final /* synthetic */ Joiner JOINER;
    private static final /* synthetic */ String EMPTY_MODEL_RAW;
    private static final /* synthetic */ Map<String, String> BUILT_IN_MODELS;
    private final /* synthetic */ RegistrySimple<ModelResourceLocation, IBakedModel> bakedRegistry;
    private final /* synthetic */ Map<Item, List<String>> variantNames;
    private final /* synthetic */ Map<String, ResourceLocation> itemLocations;
    private static final /* synthetic */ ModelBlock MODEL_ENTITY;
    private final /* synthetic */ Map<ResourceLocation, TextureAtlasSprite> sprites;
    private final /* synthetic */ TextureMap textureMap;
    private static /* synthetic */ Map<IRegistryDelegate<Item>, Set<String>> customVariantNames;
    private static final /* synthetic */ Set<ResourceLocation> LOCATIONS_BUILTIN_TEXTURES;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ ItemModelGenerator itemModelGenerator;
    protected static final /* synthetic */ ModelResourceLocation MODEL_MISSING;
    
    private void loadSprites() {
        final Set<ResourceLocation> lllllllllllllIIlIlIIIlIIIIIIIIlI = this.getVariantsTextureLocations();
        lllllllllllllIIlIlIIIlIIIIIIIIlI.addAll(this.getItemsTextureLocations());
        lllllllllllllIIlIlIIIlIIIIIIIIlI.remove(TextureMap.LOCATION_MISSING_TEXTURE);
        final ITextureMapPopulator lllllllllllllIIlIlIIIlIIIIIIIIIl = new ITextureMapPopulator() {
            @Override
            public void registerSprites(final TextureMap llllllllllllIlIlIIIlIlIIllIIllII) {
                for (final ResourceLocation llllllllllllIlIlIIIlIlIIllIIlIll : lllllllllllllIIlIlIIIlIIIIIIIIlI) {
                    final TextureAtlasSprite llllllllllllIlIlIIIlIlIIllIIlIlI = llllllllllllIlIlIIIlIlIIllIIllII.registerSprite(llllllllllllIlIlIIIlIlIIllIIlIll);
                    ModelBakery.this.sprites.put(llllllllllllIlIlIIIlIlIIllIIlIll, llllllllllllIlIlIIIlIlIIllIIlIlI);
                }
            }
        };
        this.textureMap.loadSprites(this.resourceManager, lllllllllllllIIlIlIIIlIIIIIIIIIl);
        this.sprites.put(new ResourceLocation("missingno"), this.textureMap.getMissingSprite());
    }
    
    private ResourceLocation getItemLocation(final String lllllllllllllIIlIlIIIlIlIIlllIll) {
        ResourceLocation lllllllllllllIIlIlIIIlIlIIllllII = new ResourceLocation(lllllllllllllIIlIlIIIlIlIIlllIll);
        if (Reflector.ForgeHooksClient.exists()) {
            lllllllllllllIIlIlIIIlIlIIllllII = new ResourceLocation(lllllllllllllIIlIlIIIlIlIIlllIll.replaceAll("#.*", ""));
        }
        return new ResourceLocation(lllllllllllllIIlIlIIIlIlIIllllII.getResourceDomain(), "item/" + lllllllllllllIIlIlIIIlIlIIllllII.getResourcePath());
    }
    
    private void bakeItemModels() {
        for (final Map.Entry<String, ResourceLocation> lllllllllllllIIlIlIIIlIIllllIllI : this.itemLocations.entrySet()) {
            final ResourceLocation lllllllllllllIIlIlIIIlIIllllIlIl = lllllllllllllIIlIlIIIlIIllllIllI.getValue();
            ModelResourceLocation lllllllllllllIIlIlIIIlIIllllIlII = new ModelResourceLocation(lllllllllllllIIlIlIIIlIIllllIllI.getKey(), "inventory");
            if (Reflector.ForgeHooksClient.exists()) {
                lllllllllllllIIlIlIIIlIIllllIlII = (ModelResourceLocation)Reflector.call(Reflector.ModelLoader_getInventoryVariant, new Object[] { lllllllllllllIIlIlIIIlIIllllIllI.getKey() });
            }
            final ModelBlock lllllllllllllIIlIlIIIlIIllllIIll = this.models.get(lllllllllllllIIlIlIIIlIIllllIlIl);
            if (lllllllllllllIIlIlIIIlIIllllIIll != null && lllllllllllllIIlIlIIIlIIllllIIll.isResolved()) {
                if (lllllllllllllIIlIlIIIlIIllllIIll.getElements().isEmpty()) {
                    ModelBakery.LOGGER.warn("Missing elements for: {}", (Object)lllllllllllllIIlIlIIIlIIllllIlIl);
                }
                else if (this.isCustomRenderer(lllllllllllllIIlIlIIIlIIllllIIll)) {
                    this.bakedRegistry.putObject(lllllllllllllIIlIlIIIlIIllllIlII, new BuiltInModel(lllllllllllllIIlIlIIIlIIllllIIll.getAllTransforms(), lllllllllllllIIlIlIIIlIIllllIIll.createOverrides()));
                }
                else {
                    final IBakedModel lllllllllllllIIlIlIIIlIIllllIIlI = this.bakeModel(lllllllllllllIIlIlIIIlIIllllIIll, ModelRotation.X0_Y0, false);
                    if (lllllllllllllIIlIlIIIlIIllllIIlI == null) {
                        continue;
                    }
                    this.bakedRegistry.putObject(lllllllllllllIIlIlIIIlIIllllIlII, lllllllllllllIIlIlIIIlIIllllIIlI);
                }
            }
            else {
                ModelBakery.LOGGER.warn("Missing model for: {}", (Object)lllllllllllllIIlIlIIIlIIllllIlIl);
            }
        }
    }
    
    @Nullable
    private IBakedModel createRandomModelForVariantList(final VariantList lllllllllllllIIlIlIIIlIlIIIIIllI, final String lllllllllllllIIlIlIIIlIlIIIIIlIl) {
        if (lllllllllllllIIlIlIIIlIlIIIIIllI.getVariantList().isEmpty()) {
            return null;
        }
        final WeightedBakedModel.Builder lllllllllllllIIlIlIIIlIlIIIIllIl = new WeightedBakedModel.Builder();
        int lllllllllllllIIlIlIIIlIlIIIIllII = 0;
        for (final Variant lllllllllllllIIlIlIIIlIlIIIIlIll : lllllllllllllIIlIlIIIlIlIIIIIllI.getVariantList()) {
            final ModelBlock lllllllllllllIIlIlIIIlIlIIIIlIlI = this.models.get(lllllllllllllIIlIlIIIlIlIIIIlIll.getModelLocation());
            if (lllllllllllllIIlIlIIIlIlIIIIlIlI != null && lllllllllllllIIlIlIIIlIlIIIIlIlI.isResolved()) {
                if (lllllllllllllIIlIlIIIlIlIIIIlIlI.getElements().isEmpty()) {
                    ModelBakery.LOGGER.warn("Missing elements for: {}", (Object)lllllllllllllIIlIlIIIlIlIIIIIlIl);
                }
                else {
                    final IBakedModel lllllllllllllIIlIlIIIlIlIIIIlIIl = this.bakeModel(lllllllllllllIIlIlIIIlIlIIIIlIlI, lllllllllllllIIlIlIIIlIlIIIIlIll.getRotation(), lllllllllllllIIlIlIIIlIlIIIIlIll.isUvLock());
                    if (lllllllllllllIIlIlIIIlIlIIIIlIIl == null) {
                        continue;
                    }
                    ++lllllllllllllIIlIlIIIlIlIIIIllII;
                    lllllllllllllIIlIlIIIlIlIIIIllIl.add(lllllllllllllIIlIlIIIlIlIIIIlIIl, lllllllllllllIIlIlIIIlIlIIIIlIll.getWeight());
                }
            }
            else {
                ModelBakery.LOGGER.warn("Missing model for: {}", (Object)lllllllllllllIIlIlIIIlIlIIIIIlIl);
            }
        }
        IBakedModel lllllllllllllIIlIlIIIlIlIIIIlIII = null;
        if (lllllllllllllIIlIlIIIlIlIIIIllII == 0) {
            ModelBakery.LOGGER.warn("No weighted models for: {}", (Object)lllllllllllllIIlIlIIIlIlIIIIIlIl);
        }
        else if (lllllllllllllIIlIlIIIlIlIIIIllII == 1) {
            lllllllllllllIIlIlIIIlIlIIIIlIII = lllllllllllllIIlIlIIIlIlIIIIllIl.first();
        }
        else {
            lllllllllllllIIlIlIIIlIlIIIIlIII = lllllllllllllIIlIlIIIlIlIIIIllIl.build();
        }
        return lllllllllllllIIlIlIIIlIlIIIIlIII;
    }
    
    static {
        LOCATIONS_BUILTIN_TEXTURES = Sets.newHashSet((Object[])new ResourceLocation[] { new ResourceLocation("blocks/water_flow"), new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/lava_flow"), new ResourceLocation("blocks/lava_still"), new ResourceLocation("blocks/water_overlay"), new ResourceLocation("blocks/destroy_stage_0"), new ResourceLocation("blocks/destroy_stage_1"), new ResourceLocation("blocks/destroy_stage_2"), new ResourceLocation("blocks/destroy_stage_3"), new ResourceLocation("blocks/destroy_stage_4"), new ResourceLocation("blocks/destroy_stage_5"), new ResourceLocation("blocks/destroy_stage_6"), new ResourceLocation("blocks/destroy_stage_7"), new ResourceLocation("blocks/destroy_stage_8"), new ResourceLocation("blocks/destroy_stage_9"), new ResourceLocation("items/empty_armor_slot_helmet"), new ResourceLocation("items/empty_armor_slot_chestplate"), new ResourceLocation("items/empty_armor_slot_leggings"), new ResourceLocation("items/empty_armor_slot_boots"), new ResourceLocation("items/empty_armor_slot_shield"), new ResourceLocation("blocks/shulker_top_white"), new ResourceLocation("blocks/shulker_top_orange"), new ResourceLocation("blocks/shulker_top_magenta"), new ResourceLocation("blocks/shulker_top_light_blue"), new ResourceLocation("blocks/shulker_top_yellow"), new ResourceLocation("blocks/shulker_top_lime"), new ResourceLocation("blocks/shulker_top_pink"), new ResourceLocation("blocks/shulker_top_gray"), new ResourceLocation("blocks/shulker_top_silver"), new ResourceLocation("blocks/shulker_top_cyan"), new ResourceLocation("blocks/shulker_top_purple"), new ResourceLocation("blocks/shulker_top_blue"), new ResourceLocation("blocks/shulker_top_brown"), new ResourceLocation("blocks/shulker_top_green"), new ResourceLocation("blocks/shulker_top_red"), new ResourceLocation("blocks/shulker_top_black") });
        LOGGER = LogManager.getLogger();
        MODEL_MISSING = new ModelResourceLocation("builtin/missing", "missing");
        MISSING_MODEL_MESH = "{    'textures': {       'particle': 'missingno',       'missingno': 'missingno'    },    'elements': [         {  'from': [ 0, 0, 0 ],            'to': [ 16, 16, 16 ],            'faces': {                'down':  { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'down',  'texture': '#missingno' },                'up':    { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'up',    'texture': '#missingno' },                'north': { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'north', 'texture': '#missingno' },                'south': { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'south', 'texture': '#missingno' },                'west':  { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'west',  'texture': '#missingno' },                'east':  { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'east',  'texture': '#missingno' }            }        }    ]}".replaceAll("'", "\"");
        BUILT_IN_MODELS = Maps.newHashMap();
        JOINER = Joiner.on(" -> ");
        EMPTY_MODEL_RAW = "{    'elements': [        {   'from': [0, 0, 0],            'to': [16, 16, 16],            'faces': {                'down': {'uv': [0, 0, 16, 16], 'texture': '' }            }        }    ]}".replaceAll("'", "\"");
        MODEL_GENERATED = ModelBlock.deserialize(ModelBakery.EMPTY_MODEL_RAW);
        MODEL_ENTITY = ModelBlock.deserialize(ModelBakery.EMPTY_MODEL_RAW);
        ModelBakery.customVariantNames = (Map<IRegistryDelegate<Item>, Set<String>>)Maps.newHashMap();
        ModelBakery.BUILT_IN_MODELS.put("missing", ModelBakery.MISSING_MODEL_MESH);
        ModelBakery.MODEL_GENERATED.name = "generation marker";
        ModelBakery.MODEL_ENTITY.name = "block entity marker";
    }
    
    private BakedQuad makeBakedQuad(final BlockPart lllllllllllllIIlIlIIIlIIIlllllII, final BlockPartFace lllllllllllllIIlIlIIIlIIIlllIlII, final TextureAtlasSprite lllllllllllllIIlIlIIIlIIIlllIIll, final EnumFacing lllllllllllllIIlIlIIIlIIIlllIIlI, final ModelRotation lllllllllllllIIlIlIIIlIIIllllIII, final boolean lllllllllllllIIlIlIIIlIIIlllIlll) {
        return Reflector.ForgeHooksClient.exists() ? this.makeBakedQuad(lllllllllllllIIlIlIIIlIIIlllllII, lllllllllllllIIlIlIIIlIIIlllIlII, lllllllllllllIIlIlIIIlIIIlllIIll, lllllllllllllIIlIlIIIlIIIlllIIlI, lllllllllllllIIlIlIIIlIIIllllIII, lllllllllllllIIlIlIIIlIIIlllIlll) : this.faceBakery.makeBakedQuad(lllllllllllllIIlIlIIIlIIIlllllII.positionFrom, lllllllllllllIIlIlIIIlIIIlllllII.positionTo, lllllllllllllIIlIlIIIlIIIlllIlII, lllllllllllllIIlIlIIIlIIIlllIIll, lllllllllllllIIlIlIIIlIIIlllIIlI, lllllllllllllIIlIlIIIlIIIllllIII, lllllllllllllIIlIlIIIlIIIlllllII.partRotation, lllllllllllllIIlIlIIIlIIIlllIlll, lllllllllllllIIlIlIIIlIIIlllllII.shade);
    }
    
    private void loadVariantList(final ModelResourceLocation lllllllllllllIIlIlIIIlIllIllIIll, final VariantList lllllllllllllIIlIlIIIlIllIlIllII) {
        for (final Variant lllllllllllllIIlIlIIIlIllIllIIIl : lllllllllllllIIlIlIIIlIllIlIllII.getVariantList()) {
            final ResourceLocation lllllllllllllIIlIlIIIlIllIllIIII = lllllllllllllIIlIlIIIlIllIllIIIl.getModelLocation();
            if (this.models.get(lllllllllllllIIlIlIIIlIllIllIIII) == null) {
                try {
                    this.models.put(lllllllllllllIIlIlIIIlIllIllIIII, this.loadModel(lllllllllllllIIlIlIIIlIllIllIIII));
                }
                catch (Exception lllllllllllllIIlIlIIIlIllIlIllll) {
                    ModelBakery.LOGGER.warn("Unable to load block model: '{}' for variant: '{}': {} ", (Object)lllllllllllllIIlIlIIIlIllIllIIII, (Object)lllllllllllllIIlIlIIIlIllIllIIll, (Object)lllllllllllllIIlIlIIIlIllIlIllll);
                }
            }
        }
    }
    
    public static void fixModelLocations(final ModelBlock lllllllllllllIIlIlIIIIlllIllIIIl, final String lllllllllllllIIlIlIIIIlllIllIIII) {
        final ResourceLocation lllllllllllllIIlIlIIIIlllIlIllll = fixModelLocation(lllllllllllllIIlIlIIIIlllIllIIIl.parentLocation, lllllllllllllIIlIlIIIIlllIllIIII);
        if (lllllllllllllIIlIlIIIIlllIlIllll != lllllllllllllIIlIlIIIIlllIllIIIl.parentLocation) {
            lllllllllllllIIlIlIIIIlllIllIIIl.parentLocation = lllllllllllllIIlIlIIIIlllIlIllll;
        }
        if (lllllllllllllIIlIlIIIIlllIllIIIl.textures != null) {
            for (final Map.Entry<String, String> lllllllllllllIIlIlIIIIlllIlIlllI : lllllllllllllIIlIlIIIIlllIllIIIl.textures.entrySet()) {
                final String lllllllllllllIIlIlIIIIlllIlIllIl = lllllllllllllIIlIlIIIIlllIlIlllI.getValue();
                final String lllllllllllllIIlIlIIIIlllIlIllII = fixResourcePath(lllllllllllllIIlIlIIIIlllIlIllIl, lllllllllllllIIlIlIIIIlllIllIIII);
                if (lllllllllllllIIlIlIIIIlllIlIllII != lllllllllllllIIlIlIIIIlllIlIllIl) {
                    lllllllllllllIIlIlIIIIlllIlIlllI.setValue(lllllllllllllIIlIlIIIIlllIlIllII);
                }
            }
        }
    }
    
    private boolean hasItemModel(@Nullable final ModelBlock lllllllllllllIIlIlIIIIllllIlllll) {
        return lllllllllllllIIlIlIIIIllllIlllll != null && lllllllllllllIIlIlIIIIllllIlllll.getRootModel() == ModelBakery.MODEL_GENERATED;
    }
    
    public ModelBlock getModelBlock(final ResourceLocation lllllllllllllIIlIlIIIIlllIlllIlI) {
        final ModelBlock lllllllllllllIIlIlIIIIlllIllllII = this.models.get(lllllllllllllIIlIlIIIIlllIlllIlI);
        return lllllllllllllIIlIlIIIIlllIllllII;
    }
    
    private List<ResourceLocation> getParentPath(final ResourceLocation lllllllllllllIIlIlIIIlIIIIlIlIll) {
        final List<ResourceLocation> lllllllllllllIIlIlIIIlIIIIlIlllI = (List<ResourceLocation>)Lists.newArrayList((Object[])new ResourceLocation[] { lllllllllllllIIlIlIIIlIIIIlIlIll });
        ResourceLocation lllllllllllllIIlIlIIIlIIIIlIllIl = lllllllllllllIIlIlIIIlIIIIlIlIll;
        while ((lllllllllllllIIlIlIIIlIIIIlIllIl = this.getParentLocation(lllllllllllllIIlIlIIIlIIIIlIllIl)) != null) {
            lllllllllllllIIlIlIIIlIIIIlIlllI.add(0, lllllllllllllIIlIlIIIlIIIIlIllIl);
        }
        return lllllllllllllIIlIlIIIlIIIIlIlllI;
    }
    
    private Set<ResourceLocation> getTextureLocations(final ModelBlock lllllllllllllIIlIlIIIlIIIIIIllIl) {
        final Set<ResourceLocation> lllllllllllllIIlIlIIIlIIIIIlIIIl = (Set<ResourceLocation>)Sets.newHashSet();
        for (final BlockPart lllllllllllllIIlIlIIIlIIIIIlIIII : lllllllllllllIIlIlIIIlIIIIIIllIl.getElements()) {
            for (final BlockPartFace lllllllllllllIIlIlIIIlIIIIIIllll : lllllllllllllIIlIlIIIlIIIIIlIIII.mapFaces.values()) {
                final ResourceLocation lllllllllllllIIlIlIIIlIIIIIIlllI = new ResourceLocation(lllllllllllllIIlIlIIIlIIIIIIllIl.resolveTextureName(lllllllllllllIIlIlIIIlIIIIIIllll.texture));
                lllllllllllllIIlIlIIIlIIIIIlIIIl.add(lllllllllllllIIlIlIIIlIIIIIIlllI);
            }
        }
        lllllllllllllIIlIlIIIlIIIIIlIIIl.add(new ResourceLocation(lllllllllllllIIlIlIIIlIIIIIIllIl.resolveTextureName("particle")));
        return lllllllllllllIIlIlIIIlIIIIIlIIIl;
    }
    
    private ResourceLocation getModelLocation(ResourceLocation lllllllllllllIIlIlIIIlIlIllllllI) {
        final String lllllllllllllIIlIlIIIlIlIlllllll = ((ResourceLocation)lllllllllllllIIlIlIIIlIlIllllllI).getResourcePath();
        if (!lllllllllllllIIlIlIIIlIlIlllllll.startsWith("mcpatcher") && !lllllllllllllIIlIlIIIlIlIlllllll.startsWith("optifine")) {
            return new ResourceLocation(((ResourceLocation)lllllllllllllIIlIlIIIlIlIllllllI).getResourceDomain(), "models/" + ((ResourceLocation)lllllllllllllIIlIlIIIlIlIllllllI).getResourcePath() + ".json");
        }
        if (!lllllllllllllIIlIlIIIlIlIlllllll.endsWith(".json")) {
            lllllllllllllIIlIlIIIlIlIllllllI = new ResourceLocation(((ResourceLocation)lllllllllllllIIlIlIIIlIlIllllllI).getResourceDomain(), String.valueOf(lllllllllllllIIlIlIIIlIlIlllllll) + ".json");
        }
        return (ResourceLocation)lllllllllllllIIlIlIIIlIlIllllllI;
    }
    
    private boolean isCustomRenderer(@Nullable final ModelBlock lllllllllllllIIlIlIIIIllllIllIII) {
        if (lllllllllllllIIlIlIIIIllllIllIII == null) {
            return false;
        }
        final ModelBlock lllllllllllllIIlIlIIIIllllIllIIl = lllllllllllllIIlIlIIIIllllIllIII.getRootModel();
        return lllllllllllllIIlIlIIIIllllIllIIl == ModelBakery.MODEL_ENTITY;
    }
    
    private List<String> getVariantNames(final Item lllllllllllllIIlIlIIIlIlIlIIIIlI) {
        List<String> lllllllllllllIIlIlIIIlIlIlIIIlII = this.variantNames.get(lllllllllllllIIlIlIIIlIlIlIIIIlI);
        if (lllllllllllllIIlIlIIIlIlIlIIIlII == null) {
            lllllllllllllIIlIlIIIlIlIlIIIlII = Collections.singletonList(Item.REGISTRY.getNameForObject(lllllllllllllIIlIlIIIlIlIlIIIIlI).toString());
        }
        return lllllllllllllIIlIlIIIlIlIlIIIlII;
    }
    
    private Set<ResourceLocation> getItemsTextureLocations() {
        final Set<ResourceLocation> lllllllllllllIIlIlIIIIllllllIIlI = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ResourceLocation lllllllllllllIIlIlIIIIllllllIIIl : this.itemLocations.values()) {
            final ModelBlock lllllllllllllIIlIlIIIIllllllIIII = this.models.get(lllllllllllllIIlIlIIIIllllllIIIl);
            if (lllllllllllllIIlIlIIIIllllllIIII != null) {
                lllllllllllllIIlIlIIIIllllllIIlI.add(new ResourceLocation(lllllllllllllIIlIlIIIIllllllIIII.resolveTextureName("particle")));
                if (this.hasItemModel(lllllllllllllIIlIlIIIIllllllIIII)) {
                    for (final String lllllllllllllIIlIlIIIIlllllIllll : ItemModelGenerator.LAYERS) {
                        lllllllllllllIIlIlIIIIllllllIIlI.add(new ResourceLocation(lllllllllllllIIlIlIIIIllllllIIII.resolveTextureName(lllllllllllllIIlIlIIIIlllllIllll)));
                    }
                }
                else {
                    if (this.isCustomRenderer(lllllllllllllIIlIlIIIIllllllIIII)) {
                        continue;
                    }
                    for (final BlockPart lllllllllllllIIlIlIIIIlllllIlllI : lllllllllllllIIlIlIIIIllllllIIII.getElements()) {
                        for (final BlockPartFace lllllllllllllIIlIlIIIIlllllIllIl : lllllllllllllIIlIlIIIIlllllIlllI.mapFaces.values()) {
                            final ResourceLocation lllllllllllllIIlIlIIIIlllllIllII = new ResourceLocation(lllllllllllllIIlIlIIIIllllllIIII.resolveTextureName(lllllllllllllIIlIlIIIIlllllIllIl.texture));
                            lllllllllllllIIlIlIIIIllllllIIlI.add(lllllllllllllIIlIlIIIIlllllIllII);
                        }
                    }
                }
            }
        }
        return lllllllllllllIIlIlIIIIllllllIIlI;
    }
    
    private ModelBlock loadModel(final ResourceLocation lllllllllllllIIlIlIIIlIllIIllIll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* lllllllllllllIIlIlIIIlIllIIIllII */
        //     2: aconst_null    
        //     3: astore_3        /* lllllllllllllIIlIlIIIlIllIIIlIll */
        //     4: aload_1         /* lllllllllllllIIlIlIIIlIllIIIllIl */
        //     5: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     8: astore          lllllllllllllIIlIlIIIlIllIIlIllI
        //    10: ldc_w           "builtin/generated"
        //    13: aload           lllllllllllllIIlIlIIIlIllIIlIllI
        //    15: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    18: ifeq            41
        //    21: getstatic       net/minecraft/client/renderer/block/model/ModelBakery.MODEL_GENERATED:Lnet/minecraft/client/renderer/block/model/ModelBlock;
        //    24: astore          lllllllllllllIIlIlIIIlIllIIlIlIl
        //    26: aload           lllllllllllllIIlIlIIIlIllIIlIlIl
        //    28: astore          lllllllllllllIIlIlIIIlIllIIIIlII
        //    30: aload_2         /* lllllllllllllIIlIlIIIlIllIIllIlI */
        //    31: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //    34: aload_3         /* lllllllllllllIIlIlIIIlIllIIllIIl */
        //    35: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    38: aload           lllllllllllllIIlIlIIIlIllIIIIlII
        //    40: areturn        
        //    41: ldc_w           "builtin/entity"
        //    44: aload           lllllllllllllIIlIlIIIlIllIIlIllI
        //    46: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    49: ifne            205
        //    52: aload           lllllllllllllIIlIlIIIlIllIIlIllI
        //    54: ldc_w           "builtin/"
        //    57: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    60: ifeq            121
        //    63: aload           lllllllllllllIIlIlIIIlIllIIlIllI
        //    65: ldc_w           "builtin/"
        //    68: invokevirtual   java/lang/String.length:()I
        //    71: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //    74: astore          lllllllllllllIIlIlIIIlIllIIlIlII
        //    76: getstatic       net/minecraft/client/renderer/block/model/ModelBakery.BUILT_IN_MODELS:Ljava/util/Map;
        //    79: aload           lllllllllllllIIlIlIIIlIllIIlIlII
        //    81: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    86: checkcast       Ljava/lang/String;
        //    89: astore          lllllllllllllIIlIlIIIlIllIIlIIll
        //    91: aload           lllllllllllllIIlIlIIIlIllIIlIIll
        //    93: ifnonnull       108
        //    96: new             Ljava/io/FileNotFoundException;
        //    99: dup            
        //   100: aload_1         /* lllllllllllllIIlIlIIIlIllIIIllIl */
        //   101: invokevirtual   net/minecraft/util/ResourceLocation.toString:()Ljava/lang/String;
        //   104: invokespecial   java/io/FileNotFoundException.<init>:(Ljava/lang/String;)V
        //   107: athrow         
        //   108: new             Ljava/io/StringReader;
        //   111: dup            
        //   112: aload           lllllllllllllIIlIlIIIlIllIIlIIll
        //   114: invokespecial   java/io/StringReader.<init>:(Ljava/lang/String;)V
        //   117: astore_2        /* lllllllllllllIIlIlIIIlIllIIllIlI */
        //   118: goto            155
        //   121: aload_0         /* lllllllllllllIIlIlIIIlIllIIlllII */
        //   122: aload_1         /* lllllllllllllIIlIlIIIlIllIIIllIl */
        //   123: invokespecial   net/minecraft/client/renderer/block/model/ModelBakery.getModelLocation:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/util/ResourceLocation;
        //   126: astore_1        /* lllllllllllllIIlIlIIIlIllIIIllIl */
        //   127: aload_0         /* lllllllllllllIIlIlIIIlIllIIlllII */
        //   128: getfield        net/minecraft/client/renderer/block/model/ModelBakery.resourceManager:Lnet/minecraft/client/resources/IResourceManager;
        //   131: aload_1         /* lllllllllllllIIlIlIIIlIllIIIllIl */
        //   132: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   137: astore_3        /* lllllllllllllIIlIlIIIlIllIIllIIl */
        //   138: new             Ljava/io/InputStreamReader;
        //   141: dup            
        //   142: aload_3         /* lllllllllllllIIlIlIIIlIllIIllIIl */
        //   143: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   148: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   151: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   154: astore_2        /* lllllllllllllIIlIlIIIlIllIIllIlI */
        //   155: aload_2         /* lllllllllllllIIlIlIIIlIllIIllIlI */
        //   156: invokestatic    net/minecraft/client/renderer/block/model/ModelBlock.deserialize:(Ljava/io/Reader;)Lnet/minecraft/client/renderer/block/model/ModelBlock;
        //   159: astore          lllllllllllllIIlIlIIIlIllIIlIIlI
        //   161: aload           lllllllllllllIIlIlIIIlIllIIlIIlI
        //   163: aload_1         /* lllllllllllllIIlIlIIIlIllIIIllIl */
        //   164: invokevirtual   net/minecraft/util/ResourceLocation.toString:()Ljava/lang/String;
        //   167: putfield        net/minecraft/client/renderer/block/model/ModelBlock.name:Ljava/lang/String;
        //   170: aload_1         /* lllllllllllllIIlIlIIIlIllIIIllIl */
        //   171: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //   174: invokestatic    optifine/TextureUtils.getBasePath:(Ljava/lang/String;)Ljava/lang/String;
        //   177: astore          lllllllllllllIIlIlIIIlIllIIlIIIl
        //   179: aload           lllllllllllllIIlIlIIIlIllIIlIIlI
        //   181: aload           lllllllllllllIIlIlIIIlIllIIlIIIl
        //   183: invokestatic    net/minecraft/client/renderer/block/model/ModelBakery.fixModelLocations:(Lnet/minecraft/client/renderer/block/model/ModelBlock;Ljava/lang/String;)V
        //   186: aload           lllllllllllllIIlIlIIIlIllIIlIIlI
        //   188: astore          lllllllllllllIIlIlIIIlIllIIlIIII
        //   190: aload           lllllllllllllIIlIlIIIlIllIIlIIII
        //   192: astore          lllllllllllllIIlIlIIIlIllIIIIlII
        //   194: aload_2         /* lllllllllllllIIlIlIIIlIllIIllIlI */
        //   195: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   198: aload_3         /* lllllllllllllIIlIlIIIlIllIIllIIl */
        //   199: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   202: aload           lllllllllllllIIlIlIIIlIllIIIIlII
        //   204: areturn        
        //   205: getstatic       net/minecraft/client/renderer/block/model/ModelBakery.MODEL_ENTITY:Lnet/minecraft/client/renderer/block/model/ModelBlock;
        //   208: astore          lllllllllllllIIlIlIIIlIllIIIllll
        //   210: aload           lllllllllllllIIlIlIIIlIllIIIllll
        //   212: astore          lllllllllllllIIlIlIIIlIllIIllIII
        //   214: goto            230
        //   217: astore          lllllllllllllIIlIlIIIlIllIIIIlIl
        //   219: aload_2         /* lllllllllllllIIlIlIIIlIllIIllIlI */
        //   220: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   223: aload_3         /* lllllllllllllIIlIlIIIlIllIIllIIl */
        //   224: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   227: aload           lllllllllllllIIlIlIIIlIllIIIIlIl
        //   229: athrow         
        //   230: aload_2         /* lllllllllllllIIlIlIIIlIllIIllIlI */
        //   231: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   234: aload_3         /* lllllllllllllIIlIlIIIlIllIIllIIl */
        //   235: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   238: aload           lllllllllllllIIlIlIIIlIllIIlIlll
        //   240: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  4      30     217    230    Any
        //  41     194    217    230    Any
        //  205    217    217    230    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void loadModelsCheck() {
        this.loadModels();
        for (final ModelBlock lllllllllllllIIlIlIIIlIIIlIlIllI : this.models.values()) {
            lllllllllllllIIlIlIIIlIIIlIlIllI.getParentFromMap(this.models);
        }
        ModelBlock.checkModelHierarchy(this.models);
    }
    
    public static void registerItemVariants(final Item lllllllllllllIIlIlIIIIlllIIIIIlI, final ResourceLocation... lllllllllllllIIlIlIIIIllIlllllIl) {
        final IRegistryDelegate lllllllllllllIIlIlIIIIlllIIIIIII = (IRegistryDelegate)Reflector.getFieldValue((Object)lllllllllllllIIlIlIIIIlllIIIIIlI, Reflector.ForgeItem_delegate);
        if (!ModelBakery.customVariantNames.containsKey(lllllllllllllIIlIlIIIIlllIIIIIII)) {
            ModelBakery.customVariantNames.put(lllllllllllllIIlIlIIIIlllIIIIIII, Sets.newHashSet());
        }
        final byte lllllllllllllIIlIlIIIIllIllllIII = (Object)lllllllllllllIIlIlIIIIllIlllllIl;
        final int lllllllllllllIIlIlIIIIllIllllIIl = lllllllllllllIIlIlIIIIllIlllllIl.length;
        for (short lllllllllllllIIlIlIIIIllIllllIlI = 0; lllllllllllllIIlIlIIIIllIllllIlI < lllllllllllllIIlIlIIIIllIllllIIl; ++lllllllllllllIIlIlIIIIllIllllIlI) {
            final ResourceLocation lllllllllllllIIlIlIIIIllIlllllll = lllllllllllllIIlIlIIIIllIllllIII[lllllllllllllIIlIlIIIIllIllllIlI];
            ModelBakery.customVariantNames.get(lllllllllllllIIlIlIIIIlllIIIIIII).add(lllllllllllllIIlIlIIIIllIlllllll.toString());
        }
    }
    
    public static ResourceLocation fixModelLocation(ResourceLocation lllllllllllllIIlIlIIIIlllIIlllII, final String lllllllllllllIIlIlIIIIlllIIllIll) {
        if (lllllllllllllIIlIlIIIIlllIIlllII == null || lllllllllllllIIlIlIIIIlllIIllIll == null) {
            return lllllllllllllIIlIlIIIIlllIIlllII;
        }
        if (!lllllllllllllIIlIlIIIIlllIIlllII.getResourceDomain().equals("minecraft")) {
            return lllllllllllllIIlIlIIIIlllIIlllII;
        }
        final String lllllllllllllIIlIlIIIIlllIIllllI = lllllllllllllIIlIlIIIIlllIIlllII.getResourcePath();
        final String lllllllllllllIIlIlIIIIlllIIlllIl = fixResourcePath(lllllllllllllIIlIlIIIIlllIIllllI, lllllllllllllIIlIlIIIIlllIIllIll);
        if (lllllllllllllIIlIlIIIIlllIIlllIl != lllllllllllllIIlIlIIIIlllIIllllI) {
            lllllllllllllIIlIlIIIIlllIIlllII = new ResourceLocation(lllllllllllllIIlIlIIIIlllIIlllII.getResourceDomain(), lllllllllllllIIlIlIIIIlllIIlllIl);
        }
        return lllllllllllllIIlIlIIIIlllIIlllII;
    }
    
    @Nullable
    public IBakedModel bakeModel(final ModelBlock lllllllllllllIIlIlIIIlIIlIlllllI, final ModelRotation lllllllllllllIIlIlIIIlIIlIllllIl, final boolean lllllllllllllIIlIlIIIlIIlIllIIlI) {
        final TextureAtlasSprite lllllllllllllIIlIlIIIlIIlIlllIll = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIIIlIIlIlllllI.resolveTextureName("particle")));
        final SimpleBakedModel.Builder lllllllllllllIIlIlIIIlIIlIlllIlI = new SimpleBakedModel.Builder(lllllllllllllIIlIlIIIlIIlIlllllI, lllllllllllllIIlIlIIIlIIlIlllllI.createOverrides()).setTexture(lllllllllllllIIlIlIIIlIIlIlllIll);
        if (lllllllllllllIIlIlIIIlIIlIlllllI.getElements().isEmpty()) {
            return null;
        }
        for (final BlockPart lllllllllllllIIlIlIIIlIIlIlllIIl : lllllllllllllIIlIlIIIlIIlIlllllI.getElements()) {
            for (final EnumFacing lllllllllllllIIlIlIIIlIIlIlllIII : lllllllllllllIIlIlIIIlIIlIlllIIl.mapFaces.keySet()) {
                final BlockPartFace lllllllllllllIIlIlIIIlIIlIllIlll = lllllllllllllIIlIlIIIlIIlIlllIIl.mapFaces.get(lllllllllllllIIlIlIIIlIIlIlllIII);
                final TextureAtlasSprite lllllllllllllIIlIlIIIlIIlIllIllI = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIIIlIIlIlllllI.resolveTextureName(lllllllllllllIIlIlIIIlIIlIllIlll.texture)));
                if (lllllllllllllIIlIlIIIlIIlIllIlll.cullFace == null) {
                    lllllllllllllIIlIlIIIlIIlIlllIlI.addGeneralQuad(this.makeBakedQuad(lllllllllllllIIlIlIIIlIIlIlllIIl, lllllllllllllIIlIlIIIlIIlIllIlll, lllllllllllllIIlIlIIIlIIlIllIllI, lllllllllllllIIlIlIIIlIIlIlllIII, lllllllllllllIIlIlIIIlIIlIllllIl, lllllllllllllIIlIlIIIlIIlIllIIlI));
                }
                else {
                    lllllllllllllIIlIlIIIlIIlIlllIlI.addFaceQuad(lllllllllllllIIlIlIIIlIIlIllllIl.rotateFace(lllllllllllllIIlIlIIIlIIlIllIlll.cullFace), this.makeBakedQuad(lllllllllllllIIlIlIIIlIIlIlllIIl, lllllllllllllIIlIlIIIlIIlIllIlll, lllllllllllllIIlIlIIIlIIlIllIllI, lllllllllllllIIlIlIIIlIIlIlllIII, lllllllllllllIIlIlIIIlIIlIllllIl, lllllllllllllIIlIlIIIlIIlIllIIlI));
                }
            }
        }
        return lllllllllllllIIlIlIIIlIIlIlllIlI.makeBakedModel();
    }
    
    private Set<ResourceLocation> getVariantsTextureLocations() {
        final Set<ResourceLocation> lllllllllllllIIlIlIIIlIIllIlllll = (Set<ResourceLocation>)Sets.newHashSet();
        final List<ModelResourceLocation> lllllllllllllIIlIlIIIlIIllIllllI = (List<ModelResourceLocation>)Lists.newArrayList((Iterable)this.variants.keySet());
        Collections.sort(lllllllllllllIIlIlIIIlIIllIllllI, new Comparator<ModelResourceLocation>() {
            @Override
            public int compare(final ModelResourceLocation lllllllllllIIIIIIlIllIllllIlllII, final ModelResourceLocation lllllllllllIIIIIIlIllIllllIlllIl) {
                return lllllllllllIIIIIIlIllIllllIlllII.toString().compareTo(lllllllllllIIIIIIlIllIllllIlllIl.toString());
            }
        });
        for (final ModelResourceLocation lllllllllllllIIlIlIIIlIIllIlllIl : lllllllllllllIIlIlIIIlIIllIllllI) {
            final VariantList lllllllllllllIIlIlIIIlIIllIlllII = this.variants.get(lllllllllllllIIlIlIIIlIIllIlllIl);
            for (final Variant lllllllllllllIIlIlIIIlIIllIllIll : lllllllllllllIIlIlIIIlIIllIlllII.getVariantList()) {
                final ModelBlock lllllllllllllIIlIlIIIlIIllIllIlI = this.models.get(lllllllllllllIIlIlIIIlIIllIllIll.getModelLocation());
                if (lllllllllllllIIlIlIIIlIIllIllIlI == null) {
                    ModelBakery.LOGGER.warn("Missing model for: {}", (Object)lllllllllllllIIlIlIIIlIIllIlllIl);
                }
                else {
                    lllllllllllllIIlIlIIIlIIllIlllll.addAll(this.getTextureLocations(lllllllllllllIIlIlIIIlIIllIllIlI));
                }
            }
        }
        for (final ModelBlockDefinition lllllllllllllIIlIlIIIlIIllIllIIl : this.multipartVariantMap.keySet()) {
            for (final VariantList lllllllllllllIIlIlIIIlIIllIllIII : lllllllllllllIIlIlIIIlIIllIllIIl.getMultipartData().getVariants()) {
                for (final Variant lllllllllllllIIlIlIIIlIIllIlIlll : lllllllllllllIIlIlIIIlIIllIllIII.getVariantList()) {
                    final ModelBlock lllllllllllllIIlIlIIIlIIllIlIllI = this.models.get(lllllllllllllIIlIlIIIlIIllIlIlll.getModelLocation());
                    if (lllllllllllllIIlIlIIIlIIllIlIllI == null) {
                        ModelBakery.LOGGER.warn("Missing model for: {}", (Object)Block.REGISTRY.getNameForObject(lllllllllllllIIlIlIIIlIIllIllIIl.getMultipartData().getStateContainer().getBlock()));
                    }
                    else {
                        lllllllllllllIIlIlIIIlIIllIlllll.addAll(this.getTextureLocations(lllllllllllllIIlIlIIIlIIllIlIllI));
                    }
                }
            }
        }
        lllllllllllllIIlIlIIIlIIllIlllll.addAll(ModelBakery.LOCATIONS_BUILTIN_TEXTURES);
        return lllllllllllllIIlIlIIIlIIllIlllll;
    }
    
    private ModelBlockDefinition getModelBlockDefinition(final ResourceLocation lllllllllllllIIlIlIIIllIIIIIIIII) {
        final ResourceLocation lllllllllllllIIlIlIIIllIIIIIIIll = this.getBlockstateLocation(lllllllllllllIIlIlIIIllIIIIIIIII);
        ModelBlockDefinition lllllllllllllIIlIlIIIllIIIIIIIlI = this.blockDefinitions.get(lllllllllllllIIlIlIIIllIIIIIIIll);
        if (lllllllllllllIIlIlIIIllIIIIIIIlI == null) {
            lllllllllllllIIlIlIIIllIIIIIIIlI = this.loadMultipartMBD(lllllllllllllIIlIlIIIllIIIIIIIII, lllllllllllllIIlIlIIIllIIIIIIIll);
            this.blockDefinitions.put(lllllllllllllIIlIlIIIllIIIIIIIll, lllllllllllllIIlIlIIIllIIIIIIIlI);
        }
        return lllllllllllllIIlIlIIIllIIIIIIIlI;
    }
    
    private void loadVariantItemModels() {
        this.variants.put(ModelBakery.MODEL_MISSING, new VariantList(Lists.newArrayList((Object[])new Variant[] { new Variant(new ResourceLocation(ModelBakery.MODEL_MISSING.getResourcePath()), ModelRotation.X0_Y0, false, 1) })));
        this.func_191401_d();
        this.loadVariantModels();
        this.loadMultipartVariantModels();
        this.loadItemModels();
        CustomItems.update();
        CustomItems.loadModels(this);
    }
    
    public IRegistry<ModelResourceLocation, IBakedModel> setupModelRegistry() {
        this.loadBlocks();
        this.loadVariantItemModels();
        this.loadModelsCheck();
        this.loadSprites();
        this.makeItemModels();
        this.bakeBlockModels();
        this.bakeItemModels();
        return this.bakedRegistry;
    }
    
    private static String fixResourcePath(String lllllllllllllIIlIlIIIIlllIIlIlII, final String lllllllllllllIIlIlIIIIlllIIlIIll) {
        lllllllllllllIIlIlIIIIlllIIlIlII = TextureUtils.fixResourcePath(lllllllllllllIIlIlIIIIlllIIlIlII, lllllllllllllIIlIlIIIIlllIIlIIll);
        lllllllllllllIIlIlIIIIlllIIlIlII = StrUtils.removeSuffix(lllllllllllllIIlIlIIIIlllIIlIlII, ".json");
        lllllllllllllIIlIlIIIIlllIIlIlII = StrUtils.removeSuffix(lllllllllllllIIlIlIIIIlllIIlIlII, ".png");
        return lllllllllllllIIlIlIIIIlllIIlIlII;
    }
    
    private ModelBlock makeItemModel(final ModelBlock lllllllllllllIIlIlIIIIllllIIIlII) {
        return this.itemModelGenerator.makeItemModel(this.textureMap, lllllllllllllIIlIlIIIIllllIIIlII);
    }
    
    private void loadMultipartVariantModels() {
        for (final Map.Entry<ModelBlockDefinition, Collection<ModelResourceLocation>> lllllllllllllIIlIlIIIlIlllIIIlII : this.multipartVariantMap.entrySet()) {
            final ModelResourceLocation lllllllllllllIIlIlIIIlIlllIIIIll = lllllllllllllIIlIlIIIlIlllIIIlII.getValue().iterator().next();
            for (final VariantList lllllllllllllIIlIlIIIlIlllIIIIlI : lllllllllllllIIlIlIIIlIlllIIIlII.getKey().getMultipartVariants()) {
                this.loadVariantList(lllllllllllllIIlIlIIIlIlllIIIIll, lllllllllllllIIlIlIIIlIlllIIIIlI);
            }
        }
    }
    
    private void loadModels() {
        final Deque<ResourceLocation> lllllllllllllIIlIlIIIlIIIlIIllII = (Deque<ResourceLocation>)Queues.newArrayDeque();
        final Set<ResourceLocation> lllllllllllllIIlIlIIIlIIIlIIlIll = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ResourceLocation lllllllllllllIIlIlIIIlIIIlIIlIlI : this.models.keySet()) {
            lllllllllllllIIlIlIIIlIIIlIIlIll.add(lllllllllllllIIlIlIIIlIIIlIIlIlI);
            this.addModelParentLocation(lllllllllllllIIlIlIIIlIIIlIIllII, lllllllllllllIIlIlIIIlIIIlIIlIll, this.models.get(lllllllllllllIIlIlIIIlIIIlIIlIlI));
        }
        while (!lllllllllllllIIlIlIIIlIIIlIIllII.isEmpty()) {
            final ResourceLocation lllllllllllllIIlIlIIIlIIIlIIlIIl = lllllllllllllIIlIlIIIlIIIlIIllII.pop();
            try {
                if (this.models.get(lllllllllllllIIlIlIIIlIIIlIIlIIl) != null) {
                    continue;
                }
                final ModelBlock lllllllllllllIIlIlIIIlIIIlIIlIII = this.loadModel(lllllllllllllIIlIlIIIlIIIlIIlIIl);
                this.models.put(lllllllllllllIIlIlIIIlIIIlIIlIIl, lllllllllllllIIlIlIIIlIIIlIIlIII);
                this.addModelParentLocation(lllllllllllllIIlIlIIIlIIIlIIllII, lllllllllllllIIlIlIIIlIIIlIIlIll, lllllllllllllIIlIlIIIlIIIlIIlIII);
            }
            catch (Exception lllllllllllllIIlIlIIIlIIIlIIIlll) {
                ModelBakery.LOGGER.warn("In parent chain: {}; unable to load model: '{}'", (Object)ModelBakery.JOINER.join((Iterable)this.getParentPath(lllllllllllllIIlIlIIIlIIIlIIlIIl)), (Object)lllllllllllllIIlIlIIIlIIIlIIlIIl);
            }
            lllllllllllllIIlIlIIIlIIIlIIlIll.add(lllllllllllllIIlIlIIIlIIIlIIlIIl);
        }
    }
    
    protected IBakedModel bakeModel(final ModelBlock lllllllllllllIIlIlIIIlIIlIIllIll, final ITransformation lllllllllllllIIlIlIIIlIIlIIIllll, final boolean lllllllllllllIIlIlIIIlIIlIIllIIl) {
        final TextureAtlasSprite lllllllllllllIIlIlIIIlIIlIIllIII = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIIIlIIlIIllIll.resolveTextureName("particle")));
        final SimpleBakedModel.Builder lllllllllllllIIlIlIIIlIIlIIlIlll = new SimpleBakedModel.Builder(lllllllllllllIIlIlIIIlIIlIIllIll, lllllllllllllIIlIlIIIlIIlIIllIll.createOverrides()).setTexture(lllllllllllllIIlIlIIIlIIlIIllIII);
        if (lllllllllllllIIlIlIIIlIIlIIllIll.getElements().isEmpty()) {
            return null;
        }
        for (final BlockPart lllllllllllllIIlIlIIIlIIlIIlIllI : lllllllllllllIIlIlIIIlIIlIIllIll.getElements()) {
            for (final EnumFacing lllllllllllllIIlIlIIIlIIlIIlIlIl : lllllllllllllIIlIlIIIlIIlIIlIllI.mapFaces.keySet()) {
                final BlockPartFace lllllllllllllIIlIlIIIlIIlIIlIlII = lllllllllllllIIlIlIIIlIIlIIlIllI.mapFaces.get(lllllllllllllIIlIlIIIlIIlIIlIlIl);
                final TextureAtlasSprite lllllllllllllIIlIlIIIlIIlIIlIIll = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIIIlIIlIIllIll.resolveTextureName(lllllllllllllIIlIlIIIlIIlIIlIlII.texture)));
                boolean lllllllllllllIIlIlIIIlIIlIIlIIlI = true;
                if (Reflector.ForgeHooksClient.exists()) {
                    lllllllllllllIIlIlIIIlIIlIIlIIlI = TRSRTransformation.isInteger(lllllllllllllIIlIlIIIlIIlIIIllll.getMatrix());
                }
                if (lllllllllllllIIlIlIIIlIIlIIlIlII.cullFace != null && lllllllllllllIIlIlIIIlIIlIIlIIlI) {
                    lllllllllllllIIlIlIIIlIIlIIlIlll.addFaceQuad(lllllllllllllIIlIlIIIlIIlIIIllll.rotate(lllllllllllllIIlIlIIIlIIlIIlIlII.cullFace), this.makeBakedQuad(lllllllllllllIIlIlIIIlIIlIIlIllI, lllllllllllllIIlIlIIIlIIlIIlIlII, lllllllllllllIIlIlIIIlIIlIIlIIll, lllllllllllllIIlIlIIIlIIlIIlIlIl, lllllllllllllIIlIlIIIlIIlIIIllll, lllllllllllllIIlIlIIIlIIlIIllIIl));
                }
                else {
                    lllllllllllllIIlIlIIIlIIlIIlIlll.addGeneralQuad(this.makeBakedQuad(lllllllllllllIIlIlIIIlIIlIIlIllI, lllllllllllllIIlIlIIIlIIlIIlIlII, lllllllllllllIIlIlIIIlIIlIIlIIll, lllllllllllllIIlIlIIIlIIlIIlIlIl, lllllllllllllIIlIlIIIlIIlIIIllll, lllllllllllllIIlIlIIIlIIlIIllIIl));
                }
            }
        }
        return lllllllllllllIIlIlIIIlIIlIIlIlll.makeBakedModel();
    }
    
    protected void registerMultipartVariant(final ModelBlockDefinition lllllllllllllIIlIlIIIIlllIIIlllI, final Collection<ModelResourceLocation> lllllllllllllIIlIlIIIIlllIIIllIl) {
        this.multipartVariantMap.put(lllllllllllllIIlIlIIIIlllIIIlllI, lllllllllllllIIlIlIIIIlllIIIllIl);
    }
    
    private void func_191401_d() {
        final ResourceLocation lllllllllllllIIlIlIIIllIIIIllIlI = new ResourceLocation("item_frame");
        final ModelBlockDefinition lllllllllllllIIlIlIIIllIIIIllIIl = this.getModelBlockDefinition(lllllllllllllIIlIlIIIllIIIIllIlI);
        this.registerVariant(lllllllllllllIIlIlIIIllIIIIllIIl, new ModelResourceLocation(lllllllllllllIIlIlIIIllIIIIllIlI, "normal"));
        this.registerVariant(lllllllllllllIIlIlIIIllIIIIllIIl, new ModelResourceLocation(lllllllllllllIIlIlIIIllIIIIllIlI, "map"));
    }
    
    private ModelBlockDefinition loadModelBlockDefinition(final ResourceLocation lllllllllllllIIlIlIIIlIlllIlllIl, final IResource lllllllllllllIIlIlIIIlIllllIIIll) {
        InputStream lllllllllllllIIlIlIIIlIllllIIIlI = null;
        try {
            lllllllllllllIIlIlIIIlIllllIIIlI = lllllllllllllIIlIlIIIlIllllIIIll.getInputStream();
            if (Reflector.ForgeModelBlockDefinition_parseFromReader2.exists()) {
                final ModelBlockDefinition lllllllllllllIIlIlIIIlIllllIIIIl = (ModelBlockDefinition)Reflector.call(Reflector.ForgeModelBlockDefinition_parseFromReader2, new Object[] { new InputStreamReader(lllllllllllllIIlIlIIIlIllllIIIlI, StandardCharsets.UTF_8), lllllllllllllIIlIlIIIlIlllIlllIl });
            }
            else {
                final ModelBlockDefinition lllllllllllllIIlIlIIIlIllllIIIII = ModelBlockDefinition.parseFromReader(new InputStreamReader(lllllllllllllIIlIlIIIlIllllIIIlI, StandardCharsets.UTF_8));
            }
        }
        catch (Exception lllllllllllllIIlIlIIIlIlllIllllI) {
            throw new RuntimeException("Encountered an exception when loading model definition of '" + lllllllllllllIIlIlIIIlIlllIlllIl + "' from: '" + lllllllllllllIIlIlIIIlIllllIIIll.getResourceLocation() + "' in resourcepack: '" + lllllllllllllIIlIlIIIlIllllIIIll.getResourcePackName() + "'", lllllllllllllIIlIlIIIlIlllIllllI);
        }
        finally {
            IOUtils.closeQuietly(lllllllllllllIIlIlIIIlIllllIIIlI);
        }
        IOUtils.closeQuietly(lllllllllllllIIlIlIIIlIllllIIIlI);
        final ModelBlockDefinition lllllllllllllIIlIlIIIlIlllIlllll;
        return lllllllllllllIIlIlIIIlIlllIlllll;
    }
    
    private void registerVariant(final ModelBlockDefinition lllllllllllllIIlIlIIIllIIIIIllII, final ModelResourceLocation lllllllllllllIIlIlIIIllIIIIIllll) {
        try {
            this.variants.put(lllllllllllllIIlIlIIIllIIIIIllll, lllllllllllllIIlIlIIIllIIIIIllII.getVariant(lllllllllllllIIlIlIIIllIIIIIllll.getVariant()));
        }
        catch (RuntimeException lllllllllllllIIlIlIIIllIIIIIlllI) {
            if (!lllllllllllllIIlIlIIIllIIIIIllII.hasMultipartData()) {
                ModelBakery.LOGGER.warn("Unable to load variant: {} from {}", (Object)lllllllllllllIIlIlIIIllIIIIIllll.getVariant(), (Object)lllllllllllllIIlIlIIIllIIIIIllll);
            }
        }
    }
    
    public void loadItemModel(final String lllllllllllllIIlIlIIIlIlIlIlIlIl, final ResourceLocation lllllllllllllIIlIlIIIlIlIlIllIlI, final ResourceLocation lllllllllllllIIlIlIIIlIlIlIllIIl) {
        this.itemLocations.put(lllllllllllllIIlIlIIIlIlIlIlIlIl, lllllllllllllIIlIlIIIlIlIlIllIlI);
        if (this.models.get(lllllllllllllIIlIlIIIlIlIlIllIlI) == null) {
            try {
                final ModelBlock lllllllllllllIIlIlIIIlIlIlIllIII = this.loadModel(lllllllllllllIIlIlIIIlIlIlIllIlI);
                this.models.put(lllllllllllllIIlIlIIIlIlIlIllIlI, lllllllllllllIIlIlIIIlIlIlIllIII);
            }
            catch (Exception lllllllllllllIIlIlIIIlIlIlIlIlll) {
                ModelBakery.LOGGER.warn("Unable to load item model: '{}' for item: '{}'", (Object)lllllllllllllIIlIlIIIlIlIlIllIlI, (Object)lllllllllllllIIlIlIIIlIlIlIllIIl);
                ModelBakery.LOGGER.warn(String.valueOf(lllllllllllllIIlIlIIIlIlIlIlIlll.getClass().getName()) + ": " + lllllllllllllIIlIlIIIlIlIlIlIlll.getMessage());
            }
        }
    }
    
    protected BakedQuad makeBakedQuad(final BlockPart lllllllllllllIIlIlIIIlIIIllIIIII, final BlockPartFace lllllllllllllIIlIlIIIlIIIlIlllll, final TextureAtlasSprite lllllllllllllIIlIlIIIlIIIlIllllI, final EnumFacing lllllllllllllIIlIlIIIlIIIlIlllIl, final ITransformation lllllllllllllIIlIlIIIlIIIlIlllII, final boolean lllllllllllllIIlIlIIIlIIIlIllIll) {
        return this.faceBakery.makeBakedQuad(lllllllllllllIIlIlIIIlIIIllIIIII.positionFrom, lllllllllllllIIlIlIIIlIIIllIIIII.positionTo, lllllllllllllIIlIlIIIlIIIlIlllll, lllllllllllllIIlIlIIIlIIIlIllllI, lllllllllllllIIlIlIIIlIIIlIlllIl, lllllllllllllIIlIlIIIlIIIlIlllII, lllllllllllllIIlIlIIIlIIIllIIIII.partRotation, lllllllllllllIIlIlIIIlIIIlIllIll, lllllllllllllIIlIlIIIlIIIllIIIII.shade);
    }
    
    private ModelBlockDefinition loadMultipartMBD(final ResourceLocation lllllllllllllIIlIlIIIlIlllllIIII, final ResourceLocation lllllllllllllIIlIlIIIlIllllIllll) {
        final List<ModelBlockDefinition> lllllllllllllIIlIlIIIlIlllllIlII = (List<ModelBlockDefinition>)Lists.newArrayList();
        try {
            for (final IResource lllllllllllllIIlIlIIIlIlllllIIll : this.resourceManager.getAllResources(lllllllllllllIIlIlIIIlIllllIllll)) {
                lllllllllllllIIlIlIIIlIlllllIlII.add(this.loadModelBlockDefinition(lllllllllllllIIlIlIIIlIlllllIIII, lllllllllllllIIlIlIIIlIlllllIIll));
            }
        }
        catch (IOException lllllllllllllIIlIlIIIlIlllllIIlI) {
            throw new RuntimeException("Encountered an exception when loading model definition of model " + lllllllllllllIIlIlIIIlIllllIllll, lllllllllllllIIlIlIIIlIlllllIIlI);
        }
        return new ModelBlockDefinition(lllllllllllllIIlIlIIIlIlllllIlII);
    }
    
    private void addModelParentLocation(final Deque<ResourceLocation> lllllllllllllIIlIlIIIlIIIIllllII, final Set<ResourceLocation> lllllllllllllIIlIlIIIlIIIIllIlll, final ModelBlock lllllllllllllIIlIlIIIlIIIIlllIlI) {
        final ResourceLocation lllllllllllllIIlIlIIIlIIIIlllIIl = lllllllllllllIIlIlIIIlIIIIlllIlI.getParentLocation();
        if (lllllllllllllIIlIlIIIlIIIIlllIIl != null && !lllllllllllllIIlIlIIIlIIIIllIlll.contains(lllllllllllllIIlIlIIIlIIIIlllIIl)) {
            lllllllllllllIIlIlIIIlIIIIllllII.add(lllllllllllllIIlIlIIIlIIIIlllIIl);
        }
    }
    
    protected void loadBlock(final BlockStateMapper lllllllllllllIIlIlIIIllIIIlIlIlI, final Block lllllllllllllIIlIlIIIllIIIllIlII, final ResourceLocation lllllllllllllIIlIlIIIllIIIllIIll) {
        final ModelBlockDefinition lllllllllllllIIlIlIIIllIIIllIIlI = this.getModelBlockDefinition(lllllllllllllIIlIlIIIllIIIllIIll);
        final Map<IBlockState, ModelResourceLocation> lllllllllllllIIlIlIIIllIIIllIIIl = lllllllllllllIIlIlIIIllIIIlIlIlI.getVariants(lllllllllllllIIlIlIIIllIIIllIlII);
        if (lllllllllllllIIlIlIIIllIIIllIIlI.hasMultipartData()) {
            final Collection<ModelResourceLocation> lllllllllllllIIlIlIIIllIIIllIIII = (Collection<ModelResourceLocation>)Sets.newHashSet((Iterable)lllllllllllllIIlIlIIIllIIIllIIIl.values());
            lllllllllllllIIlIlIIIllIIIllIIlI.getMultipartData().setStateContainer(lllllllllllllIIlIlIIIllIIIllIlII.getBlockState());
            Collection<ModelResourceLocation> lllllllllllllIIlIlIIIllIIIlIllll = this.multipartVariantMap.get(lllllllllllllIIlIlIIIllIIIllIIlI);
            if (lllllllllllllIIlIlIIIllIIIlIllll == null) {
                lllllllllllllIIlIlIIIllIIIlIllll = (Collection<ModelResourceLocation>)Lists.newArrayList();
            }
            lllllllllllllIIlIlIIIllIIIlIllll.addAll(Lists.newArrayList(Iterables.filter((Iterable)lllllllllllllIIlIlIIIllIIIllIIII, (Predicate)new Predicate<ModelResourceLocation>() {
                public boolean apply(@Nullable final ModelResourceLocation llllllllllllIlIlIIllIIlIIlIIlllI) {
                    return lllllllllllllIIlIlIIIllIIIllIIll.equals(llllllllllllIlIlIIllIIlIIlIIlllI);
                }
            })));
            this.registerMultipartVariant(lllllllllllllIIlIlIIIllIIIllIIlI, lllllllllllllIIlIlIIIllIIIlIllll);
        }
        for (final Map.Entry<IBlockState, ModelResourceLocation> lllllllllllllIIlIlIIIllIIIlIlllI : lllllllllllllIIlIlIIIllIIIllIIIl.entrySet()) {
            final ModelResourceLocation lllllllllllllIIlIlIIIllIIIlIllIl = lllllllllllllIIlIlIIIllIIIlIlllI.getValue();
            if (lllllllllllllIIlIlIIIllIIIllIIll.equals(lllllllllllllIIlIlIIIllIIIlIllIl)) {
                try {
                    if (Reflector.ForgeItem_delegate.exists()) {
                        this.registerVariant(lllllllllllllIIlIlIIIllIIIllIIlI, lllllllllllllIIlIlIIIllIIIlIllIl);
                    }
                    else {
                        this.variants.put(lllllllllllllIIlIlIIIllIIIlIllIl, lllllllllllllIIlIlIIIllIIIllIIlI.getVariant(lllllllllllllIIlIlIIIllIIIlIllIl.getVariant()));
                    }
                }
                catch (RuntimeException lllllllllllllIIlIlIIIllIIIlIllII) {
                    if (lllllllllllllIIlIlIIIllIIIllIIlI.hasMultipartData()) {
                        continue;
                    }
                    ModelBakery.LOGGER.warn("Unable to load variant: " + lllllllllllllIIlIlIIIllIIIlIllIl.getVariant() + " from " + lllllllllllllIIlIlIIIllIIIlIllIl, (Throwable)lllllllllllllIIlIlIIIllIIIlIllII);
                }
            }
        }
    }
    
    private void registerVariantNames() {
        this.variantNames.clear();
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONE), Lists.newArrayList((Object[])new String[] { "stone", "granite", "granite_smooth", "diorite", "diorite_smooth", "andesite", "andesite_smooth" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.DIRT), Lists.newArrayList((Object[])new String[] { "dirt", "coarse_dirt", "podzol" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.PLANKS), Lists.newArrayList((Object[])new String[] { "oak_planks", "spruce_planks", "birch_planks", "jungle_planks", "acacia_planks", "dark_oak_planks" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SAPLING), Lists.newArrayList((Object[])new String[] { "oak_sapling", "spruce_sapling", "birch_sapling", "jungle_sapling", "acacia_sapling", "dark_oak_sapling" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SAND), Lists.newArrayList((Object[])new String[] { "sand", "red_sand" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LOG), Lists.newArrayList((Object[])new String[] { "oak_log", "spruce_log", "birch_log", "jungle_log" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LEAVES), Lists.newArrayList((Object[])new String[] { "oak_leaves", "spruce_leaves", "birch_leaves", "jungle_leaves" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SPONGE), Lists.newArrayList((Object[])new String[] { "sponge", "sponge_wet" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SANDSTONE), Lists.newArrayList((Object[])new String[] { "sandstone", "chiseled_sandstone", "smooth_sandstone" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.RED_SANDSTONE), Lists.newArrayList((Object[])new String[] { "red_sandstone", "chiseled_red_sandstone", "smooth_red_sandstone" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.TALLGRASS), Lists.newArrayList((Object[])new String[] { "dead_bush", "tall_grass", "fern" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.DEADBUSH), Lists.newArrayList((Object[])new String[] { "dead_bush" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.WOOL), Lists.newArrayList((Object[])new String[] { "black_wool", "red_wool", "green_wool", "brown_wool", "blue_wool", "purple_wool", "cyan_wool", "silver_wool", "gray_wool", "pink_wool", "lime_wool", "yellow_wool", "light_blue_wool", "magenta_wool", "orange_wool", "white_wool" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), Lists.newArrayList((Object[])new String[] { "dandelion" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.RED_FLOWER), Lists.newArrayList((Object[])new String[] { "poppy", "blue_orchid", "allium", "houstonia", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONE_SLAB), Lists.newArrayList((Object[])new String[] { "stone_slab", "sandstone_slab", "cobblestone_slab", "brick_slab", "stone_brick_slab", "nether_brick_slab", "quartz_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONE_SLAB2), Lists.newArrayList((Object[])new String[] { "red_sandstone_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STAINED_GLASS), Lists.newArrayList((Object[])new String[] { "black_stained_glass", "red_stained_glass", "green_stained_glass", "brown_stained_glass", "blue_stained_glass", "purple_stained_glass", "cyan_stained_glass", "silver_stained_glass", "gray_stained_glass", "pink_stained_glass", "lime_stained_glass", "yellow_stained_glass", "light_blue_stained_glass", "magenta_stained_glass", "orange_stained_glass", "white_stained_glass" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.MONSTER_EGG), Lists.newArrayList((Object[])new String[] { "stone_monster_egg", "cobblestone_monster_egg", "stone_brick_monster_egg", "mossy_brick_monster_egg", "cracked_brick_monster_egg", "chiseled_brick_monster_egg" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONEBRICK), Lists.newArrayList((Object[])new String[] { "stonebrick", "mossy_stonebrick", "cracked_stonebrick", "chiseled_stonebrick" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.WOODEN_SLAB), Lists.newArrayList((Object[])new String[] { "oak_slab", "spruce_slab", "birch_slab", "jungle_slab", "acacia_slab", "dark_oak_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.COBBLESTONE_WALL), Lists.newArrayList((Object[])new String[] { "cobblestone_wall", "mossy_cobblestone_wall" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.ANVIL), Lists.newArrayList((Object[])new String[] { "anvil_intact", "anvil_slightly_damaged", "anvil_very_damaged" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK), Lists.newArrayList((Object[])new String[] { "quartz_block", "chiseled_quartz_block", "quartz_column" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STAINED_HARDENED_CLAY), Lists.newArrayList((Object[])new String[] { "black_stained_hardened_clay", "red_stained_hardened_clay", "green_stained_hardened_clay", "brown_stained_hardened_clay", "blue_stained_hardened_clay", "purple_stained_hardened_clay", "cyan_stained_hardened_clay", "silver_stained_hardened_clay", "gray_stained_hardened_clay", "pink_stained_hardened_clay", "lime_stained_hardened_clay", "yellow_stained_hardened_clay", "light_blue_stained_hardened_clay", "magenta_stained_hardened_clay", "orange_stained_hardened_clay", "white_stained_hardened_clay" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STAINED_GLASS_PANE), Lists.newArrayList((Object[])new String[] { "black_stained_glass_pane", "red_stained_glass_pane", "green_stained_glass_pane", "brown_stained_glass_pane", "blue_stained_glass_pane", "purple_stained_glass_pane", "cyan_stained_glass_pane", "silver_stained_glass_pane", "gray_stained_glass_pane", "pink_stained_glass_pane", "lime_stained_glass_pane", "yellow_stained_glass_pane", "light_blue_stained_glass_pane", "magenta_stained_glass_pane", "orange_stained_glass_pane", "white_stained_glass_pane" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LEAVES2), Lists.newArrayList((Object[])new String[] { "acacia_leaves", "dark_oak_leaves" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LOG2), Lists.newArrayList((Object[])new String[] { "acacia_log", "dark_oak_log" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.PRISMARINE), Lists.newArrayList((Object[])new String[] { "prismarine", "prismarine_bricks", "dark_prismarine" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.CARPET), Lists.newArrayList((Object[])new String[] { "black_carpet", "red_carpet", "green_carpet", "brown_carpet", "blue_carpet", "purple_carpet", "cyan_carpet", "silver_carpet", "gray_carpet", "pink_carpet", "lime_carpet", "yellow_carpet", "light_blue_carpet", "magenta_carpet", "orange_carpet", "white_carpet" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), Lists.newArrayList((Object[])new String[] { "sunflower", "syringa", "double_grass", "double_fern", "double_rose", "paeonia" }));
        this.variantNames.put(Items.COAL, Lists.newArrayList((Object[])new String[] { "coal", "charcoal" }));
        this.variantNames.put(Items.FISH, Lists.newArrayList((Object[])new String[] { "cod", "salmon", "clownfish", "pufferfish" }));
        this.variantNames.put(Items.COOKED_FISH, Lists.newArrayList((Object[])new String[] { "cooked_cod", "cooked_salmon" }));
        this.variantNames.put(Items.DYE, Lists.newArrayList((Object[])new String[] { "dye_black", "dye_red", "dye_green", "dye_brown", "dye_blue", "dye_purple", "dye_cyan", "dye_silver", "dye_gray", "dye_pink", "dye_lime", "dye_yellow", "dye_light_blue", "dye_magenta", "dye_orange", "dye_white" }));
        this.variantNames.put(Items.POTIONITEM, Lists.newArrayList((Object[])new String[] { "bottle_drinkable" }));
        this.variantNames.put(Items.SKULL, Lists.newArrayList((Object[])new String[] { "skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper", "skull_dragon" }));
        this.variantNames.put(Items.SPLASH_POTION, Lists.newArrayList((Object[])new String[] { "bottle_splash" }));
        this.variantNames.put(Items.LINGERING_POTION, Lists.newArrayList((Object[])new String[] { "bottle_lingering" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.field_192443_dR), Lists.newArrayList((Object[])new String[] { "black_concrete", "red_concrete", "green_concrete", "brown_concrete", "blue_concrete", "purple_concrete", "cyan_concrete", "silver_concrete", "gray_concrete", "pink_concrete", "lime_concrete", "yellow_concrete", "light_blue_concrete", "magenta_concrete", "orange_concrete", "white_concrete" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.field_192444_dS), Lists.newArrayList((Object[])new String[] { "black_concrete_powder", "red_concrete_powder", "green_concrete_powder", "brown_concrete_powder", "blue_concrete_powder", "purple_concrete_powder", "cyan_concrete_powder", "silver_concrete_powder", "gray_concrete_powder", "pink_concrete_powder", "lime_concrete_powder", "yellow_concrete_powder", "light_blue_concrete_powder", "magenta_concrete_powder", "orange_concrete_powder", "white_concrete_powder" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.AIR), Collections.emptyList());
        this.variantNames.put(Item.getItemFromBlock(Blocks.OAK_FENCE_GATE), Lists.newArrayList((Object[])new String[] { "oak_fence_gate" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.OAK_FENCE), Lists.newArrayList((Object[])new String[] { "oak_fence" }));
        this.variantNames.put(Items.OAK_DOOR, Lists.newArrayList((Object[])new String[] { "oak_door" }));
        this.variantNames.put(Items.BOAT, Lists.newArrayList((Object[])new String[] { "oak_boat" }));
        this.variantNames.put(Items.TOTEM_OF_UNDYING, Lists.newArrayList((Object[])new String[] { "totem" }));
        for (final Map.Entry<IRegistryDelegate<Item>, Set<String>> lllllllllllllIIlIlIIIlIlIlIIllIl : ModelBakery.customVariantNames.entrySet()) {
            this.variantNames.put(lllllllllllllIIlIlIIIlIlIlIIllIl.getKey().get(), Lists.newArrayList((Iterator)lllllllllllllIIlIlIIIlIlIlIIllIl.getValue().iterator()));
        }
    }
    
    private ResourceLocation getBlockstateLocation(final ResourceLocation lllllllllllllIIlIlIIIlIlllIlIlIl) {
        return new ResourceLocation(lllllllllllllIIlIlIIIlIlllIlIlIl.getResourceDomain(), "blockstates/" + lllllllllllllIIlIlIIIlIlllIlIlIl.getResourcePath() + ".json");
    }
    
    public ModelBakery(final IResourceManager lllllllllllllIIlIlIIIllIIlIlllIl, final TextureMap lllllllllllllIIlIlIIIllIIlIllIII, final BlockModelShapes lllllllllllllIIlIlIIIllIIlIlIlll) {
        this.sprites = (Map<ResourceLocation, TextureAtlasSprite>)Maps.newHashMap();
        this.models = (Map<ResourceLocation, ModelBlock>)Maps.newLinkedHashMap();
        this.variants = (Map<ModelResourceLocation, VariantList>)Maps.newLinkedHashMap();
        this.multipartVariantMap = (Map<ModelBlockDefinition, Collection<ModelResourceLocation>>)Maps.newLinkedHashMap();
        this.faceBakery = new FaceBakery();
        this.itemModelGenerator = new ItemModelGenerator();
        this.bakedRegistry = new RegistrySimple<ModelResourceLocation, IBakedModel>();
        this.itemLocations = (Map<String, ResourceLocation>)Maps.newLinkedHashMap();
        this.blockDefinitions = (Map<ResourceLocation, ModelBlockDefinition>)Maps.newHashMap();
        this.variantNames = (Map<Item, List<String>>)Maps.newIdentityHashMap();
        this.resourceManager = lllllllllllllIIlIlIIIllIIlIlllIl;
        this.textureMap = lllllllllllllIIlIlIIIllIIlIllIII;
        this.blockModelShapes = lllllllllllllIIlIlIIIllIIlIlIlll;
    }
    
    @Nullable
    private ResourceLocation getParentLocation(final ResourceLocation lllllllllllllIIlIlIIIlIIIIlIIIlI) {
        for (final Map.Entry<ResourceLocation, ModelBlock> lllllllllllllIIlIlIIIlIIIIlIIIIl : this.models.entrySet()) {
            final ModelBlock lllllllllllllIIlIlIIIlIIIIlIIIII = lllllllllllllIIlIlIIIlIIIIlIIIIl.getValue();
            if (lllllllllllllIIlIlIIIlIIIIlIIIII != null && lllllllllllllIIlIlIIIlIIIIlIIIlI.equals(lllllllllllllIIlIlIIIlIIIIlIIIII.getParentLocation())) {
                return lllllllllllllIIlIlIIIlIIIIlIIIIl.getKey();
            }
        }
        return null;
    }
    
    private void loadBlocks() {
        final BlockStateMapper lllllllllllllIIlIlIIIllIIlIIlIll = this.blockModelShapes.getBlockStateMapper();
        for (final Block lllllllllllllIIlIlIIIllIIlIIlIlI : Block.REGISTRY) {
            for (final ResourceLocation lllllllllllllIIlIlIIIllIIlIIlIIl : lllllllllllllIIlIlIIIllIIlIIlIll.getBlockstateLocations(lllllllllllllIIlIlIIIllIIlIIlIlI)) {
                try {
                    this.loadBlock(lllllllllllllIIlIlIIIllIIlIIlIll, lllllllllllllIIlIlIIIllIIlIIlIlI, lllllllllllllIIlIlIIIllIIlIIlIIl);
                }
                catch (Exception lllllllllllllIIlIlIIIllIIlIIlIII) {
                    ModelBakery.LOGGER.warn("Unable to load definition " + lllllllllllllIIlIlIIIllIIlIIlIIl, (Throwable)lllllllllllllIIlIlIIIllIIlIIlIII);
                }
            }
        }
    }
    
    private void makeItemModels() {
        for (final ResourceLocation lllllllllllllIIlIlIIIIllllIlIIII : this.itemLocations.values()) {
            final ModelBlock lllllllllllllIIlIlIIIIllllIIllll = this.models.get(lllllllllllllIIlIlIIIIllllIlIIII);
            if (this.hasItemModel(lllllllllllllIIlIlIIIIllllIIllll)) {
                final ModelBlock lllllllllllllIIlIlIIIIllllIIlllI = this.makeItemModel(lllllllllllllIIlIlIIIIllllIIllll);
                if (lllllllllllllIIlIlIIIIllllIIlllI != null) {
                    lllllllllllllIIlIlIIIIllllIIlllI.name = lllllllllllllIIlIlIIIIllllIlIIII.toString();
                }
                this.models.put(lllllllllllllIIlIlIIIIllllIlIIII, lllllllllllllIIlIlIIIIllllIIlllI);
            }
            else {
                if (!this.isCustomRenderer(lllllllllllllIIlIlIIIIllllIIllll)) {
                    continue;
                }
                this.models.put(lllllllllllllIIlIlIIIIllllIlIIII, lllllllllllllIIlIlIIIIllllIIllll);
            }
        }
        for (final TextureAtlasSprite lllllllllllllIIlIlIIIIllllIIllIl : this.sprites.values()) {
            if (!lllllllllllllIIlIlIIIIllllIIllIl.hasAnimationMetadata()) {
                lllllllllllllIIlIlIIIIllllIIllIl.clearFramesTextureData();
            }
        }
    }
    
    private void loadItemModels() {
        this.registerVariantNames();
        for (final Item lllllllllllllIIlIlIIIlIlIlllIIIl : Item.REGISTRY) {
            for (final String lllllllllllllIIlIlIIIlIlIlllIIII : this.getVariantNames(lllllllllllllIIlIlIIIlIlIlllIIIl)) {
                final ResourceLocation lllllllllllllIIlIlIIIlIlIllIllll = this.getItemLocation(lllllllllllllIIlIlIIIlIlIlllIIII);
                final ResourceLocation lllllllllllllIIlIlIIIlIlIllIlllI = Item.REGISTRY.getNameForObject(lllllllllllllIIlIlIIIlIlIlllIIIl);
                this.loadItemModel(lllllllllllllIIlIlIIIlIlIlllIIII, lllllllllllllIIlIlIIIlIlIllIllll, lllllllllllllIIlIlIIIlIlIllIlllI);
                if (lllllllllllllIIlIlIIIlIlIlllIIIl.hasCustomProperties()) {
                    final ModelBlock lllllllllllllIIlIlIIIlIlIllIllIl = this.models.get(lllllllllllllIIlIlIIIlIlIllIllll);
                    if (lllllllllllllIIlIlIIIlIlIllIllIl == null) {
                        continue;
                    }
                    for (final ResourceLocation lllllllllllllIIlIlIIIlIlIllIllII : lllllllllllllIIlIlIIIlIlIllIllIl.getOverrideLocations()) {
                        this.loadItemModel(lllllllllllllIIlIlIIIlIlIllIllII.toString(), lllllllllllllIIlIlIIIlIlIllIllII, lllllllllllllIIlIlIIIlIlIllIlllI);
                    }
                }
            }
        }
    }
    
    private void bakeBlockModels() {
        for (final ModelResourceLocation lllllllllllllIIlIlIIIlIlIIlIlllI : this.variants.keySet()) {
            final IBakedModel lllllllllllllIIlIlIIIlIlIIlIllIl = this.createRandomModelForVariantList(this.variants.get(lllllllllllllIIlIlIIIlIlIIlIlllI), lllllllllllllIIlIlIIIlIlIIlIlllI.toString());
            if (lllllllllllllIIlIlIIIlIlIIlIllIl != null) {
                this.bakedRegistry.putObject(lllllllllllllIIlIlIIIlIlIIlIlllI, lllllllllllllIIlIlIIIlIlIIlIllIl);
            }
        }
        for (final Map.Entry<ModelBlockDefinition, Collection<ModelResourceLocation>> lllllllllllllIIlIlIIIlIlIIlIllII : this.multipartVariantMap.entrySet()) {
            final ModelBlockDefinition lllllllllllllIIlIlIIIlIlIIlIlIll = lllllllllllllIIlIlIIIlIlIIlIllII.getKey();
            final Multipart lllllllllllllIIlIlIIIlIlIIlIlIlI = lllllllllllllIIlIlIIIlIlIIlIlIll.getMultipartData();
            final String lllllllllllllIIlIlIIIlIlIIlIlIIl = Block.REGISTRY.getNameForObject(lllllllllllllIIlIlIIIlIlIIlIlIlI.getStateContainer().getBlock()).toString();
            final MultipartBakedModel.Builder lllllllllllllIIlIlIIIlIlIIlIlIII = new MultipartBakedModel.Builder();
            for (final Selector lllllllllllllIIlIlIIIlIlIIlIIlll : lllllllllllllIIlIlIIIlIlIIlIlIlI.getSelectors()) {
                final IBakedModel lllllllllllllIIlIlIIIlIlIIlIIllI = this.createRandomModelForVariantList(lllllllllllllIIlIlIIIlIlIIlIIlll.getVariantList(), "selector of " + lllllllllllllIIlIlIIIlIlIIlIlIIl);
                if (lllllllllllllIIlIlIIIlIlIIlIIllI != null) {
                    lllllllllllllIIlIlIIIlIlIIlIlIII.putModel(lllllllllllllIIlIlIIIlIlIIlIIlll.getPredicate(lllllllllllllIIlIlIIIlIlIIlIlIlI.getStateContainer()), lllllllllllllIIlIlIIIlIlIIlIIllI);
                }
            }
            final IBakedModel lllllllllllllIIlIlIIIlIlIIlIIlIl = lllllllllllllIIlIlIIIlIlIIlIlIII.makeMultipartModel();
            for (final ModelResourceLocation lllllllllllllIIlIlIIIlIlIIlIIlII : lllllllllllllIIlIlIIIlIlIIlIllII.getValue()) {
                if (!lllllllllllllIIlIlIIIlIlIIlIlIll.hasVariant(lllllllllllllIIlIlIIIlIlIIlIIlII.getVariant())) {
                    this.bakedRegistry.putObject(lllllllllllllIIlIlIIIlIlIIlIIlII, lllllllllllllIIlIlIIIlIlIIlIIlIl);
                }
            }
        }
    }
    
    private void loadVariantModels() {
        for (final Map.Entry<ModelResourceLocation, VariantList> lllllllllllllIIlIlIIIlIlllIIllll : this.variants.entrySet()) {
            this.loadVariantList(lllllllllllllIIlIlIIIlIlllIIllll.getKey(), lllllllllllllIIlIlIIIlIlllIIllll.getValue());
        }
    }
}
