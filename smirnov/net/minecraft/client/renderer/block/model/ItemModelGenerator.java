// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import java.util.Iterator;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.texture.TextureMap;
import java.util.Map;
import java.util.Collection;
import org.lwjgl.util.vector.Vector3f;
import com.google.common.collect.Lists;
import net.minecraft.util.EnumFacing;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import java.util.List;

public class ItemModelGenerator
{
    public static final /* synthetic */ List<String> LAYERS;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing;
    
    private List<BlockPart> getBlockParts(final int lllllllllllIlIIIIIlIlIIlIllIIIlI, final String lllllllllllIlIIIIIlIlIIlIllIIIIl, final TextureAtlasSprite lllllllllllIlIIIIIlIlIIlIllIIllI) {
        final Map<EnumFacing, BlockPartFace> lllllllllllIlIIIIIlIlIIlIllIIlIl = (Map<EnumFacing, BlockPartFace>)Maps.newHashMap();
        lllllllllllIlIIIIIlIlIIlIllIIlIl.put(EnumFacing.SOUTH, new BlockPartFace(null, lllllllllllIlIIIIIlIlIIlIllIIIlI, lllllllllllIlIIIIIlIlIIlIllIIIIl, new BlockFaceUV(new float[] { 0.0f, 0.0f, 16.0f, 16.0f }, 0)));
        lllllllllllIlIIIIIlIlIIlIllIIlIl.put(EnumFacing.NORTH, new BlockPartFace(null, lllllllllllIlIIIIIlIlIIlIllIIIlI, lllllllllllIlIIIIIlIlIIlIllIIIIl, new BlockFaceUV(new float[] { 16.0f, 0.0f, 0.0f, 16.0f }, 0)));
        final List<BlockPart> lllllllllllIlIIIIIlIlIIlIllIIlII = (List<BlockPart>)Lists.newArrayList();
        lllllllllllIlIIIIIlIlIIlIllIIlII.add(new BlockPart(new Vector3f(0.0f, 0.0f, 7.5f), new Vector3f(16.0f, 16.0f, 8.5f), lllllllllllIlIIIIIlIlIIlIllIIlIl, null, true));
        lllllllllllIlIIIIIlIlIIlIllIIlII.addAll(this.getBlockParts(lllllllllllIlIIIIIlIlIIlIllIIllI, lllllllllllIlIIIIIlIlIIlIllIIIIl, lllllllllllIlIIIIIlIlIIlIllIIIlI));
        return lllllllllllIlIIIIIlIlIIlIllIIlII;
    }
    
    static {
        LAYERS = Lists.newArrayList((Object[])new String[] { "layer0", "layer1", "layer2", "layer3", "layer4" });
    }
    
    @Nullable
    public ModelBlock makeItemModel(final TextureMap lllllllllllIlIIIIIlIlIIllIIIIIII, final ModelBlock lllllllllllIlIIIIIlIlIIlIlllIllI) {
        final Map<String, String> lllllllllllIlIIIIIlIlIIlIllllllI = (Map<String, String>)Maps.newHashMap();
        final List<BlockPart> lllllllllllIlIIIIIlIlIIlIlllllIl = (List<BlockPart>)Lists.newArrayList();
        for (int lllllllllllIlIIIIIlIlIIlIlllllII = 0; lllllllllllIlIIIIIlIlIIlIlllllII < ItemModelGenerator.LAYERS.size(); ++lllllllllllIlIIIIIlIlIIlIlllllII) {
            final String lllllllllllIlIIIIIlIlIIlIllllIll = ItemModelGenerator.LAYERS.get(lllllllllllIlIIIIIlIlIIlIlllllII);
            if (!lllllllllllIlIIIIIlIlIIlIlllIllI.isTexturePresent(lllllllllllIlIIIIIlIlIIlIllllIll)) {
                break;
            }
            final String lllllllllllIlIIIIIlIlIIlIllllIlI = lllllllllllIlIIIIIlIlIIlIlllIllI.resolveTextureName(lllllllllllIlIIIIIlIlIIlIllllIll);
            lllllllllllIlIIIIIlIlIIlIllllllI.put(lllllllllllIlIIIIIlIlIIlIllllIll, lllllllllllIlIIIIIlIlIIlIllllIlI);
            final TextureAtlasSprite lllllllllllIlIIIIIlIlIIlIllllIIl = lllllllllllIlIIIIIlIlIIllIIIIIII.getAtlasSprite(new ResourceLocation(lllllllllllIlIIIIIlIlIIlIllllIlI).toString());
            lllllllllllIlIIIIIlIlIIlIlllllIl.addAll(this.getBlockParts(lllllllllllIlIIIIIlIlIIlIlllllII, lllllllllllIlIIIIIlIlIIlIllllIll, lllllllllllIlIIIIIlIlIIlIllllIIl));
        }
        if (lllllllllllIlIIIIIlIlIIlIlllllIl.isEmpty()) {
            return null;
        }
        lllllllllllIlIIIIIlIlIIlIllllllI.put("particle", lllllllllllIlIIIIIlIlIIlIlllIllI.isTexturePresent("particle") ? lllllllllllIlIIIIIlIlIIlIlllIllI.resolveTextureName("particle") : lllllllllllIlIIIIIlIlIIlIllllllI.get("layer0"));
        return new ModelBlock(null, lllllllllllIlIIIIIlIlIIlIlllllIl, lllllllllllIlIIIIIlIlIIlIllllllI, false, false, lllllllllllIlIIIIIlIlIIlIlllIllI.getAllTransforms(), lllllllllllIlIIIIIlIlIIlIlllIllI.getOverrides());
    }
    
    private void createOrExpandSpan(final List<Span> lllllllllllIlIIIIIlIlIIIllIIlIll, final SpanFacing lllllllllllIlIIIIIlIlIIIllIIlIlI, final int lllllllllllIlIIIIIlIlIIIllIIlIIl, final int lllllllllllIlIIIIIlIlIIIllIIlIII) {
        Span lllllllllllIlIIIIIlIlIIIllIIIlll = null;
        for (final Span lllllllllllIlIIIIIlIlIIIllIIIllI : lllllllllllIlIIIIIlIlIIIllIIlIll) {
            if (lllllllllllIlIIIIIlIlIIIllIIIllI.getFacing() == lllllllllllIlIIIIIlIlIIIllIIlIlI) {
                final int lllllllllllIlIIIIIlIlIIIllIIIlIl = lllllllllllIlIIIIIlIlIIIllIIlIlI.isHorizontal() ? lllllllllllIlIIIIIlIlIIIllIIlIII : lllllllllllIlIIIIIlIlIIIllIIlIIl;
                if (lllllllllllIlIIIIIlIlIIIllIIIllI.getAnchor() == lllllllllllIlIIIIIlIlIIIllIIIlIl) {
                    lllllllllllIlIIIIIlIlIIIllIIIlll = lllllllllllIlIIIIIlIlIIIllIIIllI;
                    break;
                }
                continue;
            }
        }
        final int lllllllllllIlIIIIIlIlIIIllIIIlII = lllllllllllIlIIIIIlIlIIIllIIlIlI.isHorizontal() ? lllllllllllIlIIIIIlIlIIIllIIlIII : lllllllllllIlIIIIIlIlIIIllIIlIIl;
        final int lllllllllllIlIIIIIlIlIIIllIIIIll = lllllllllllIlIIIIIlIlIIIllIIlIlI.isHorizontal() ? lllllllllllIlIIIIIlIlIIIllIIlIIl : lllllllllllIlIIIIIlIlIIIllIIlIII;
        if (lllllllllllIlIIIIIlIlIIIllIIIlll == null) {
            lllllllllllIlIIIIIlIlIIIllIIlIll.add(new Span(lllllllllllIlIIIIIlIlIIIllIIlIlI, lllllllllllIlIIIIIlIlIIIllIIIIll, lllllllllllIlIIIIIlIlIIIllIIIlII));
        }
        else {
            lllllllllllIlIIIIIlIlIIIllIIIlll.expand(lllllllllllIlIIIIIlIlIIIllIIIIll);
        }
    }
    
    private List<BlockPart> getBlockParts(final TextureAtlasSprite lllllllllllIlIIIIIlIlIIlIIlIlIIl, final String lllllllllllIlIIIIIlIlIIlIlIIIIIl, final int lllllllllllIlIIIIIlIlIIlIlIIIIII) {
        final float lllllllllllIlIIIIIlIlIIlIIllllll = (float)lllllllllllIlIIIIIlIlIIlIIlIlIIl.getIconWidth();
        final float lllllllllllIlIIIIIlIlIIlIIlllllI = (float)lllllllllllIlIIIIIlIlIIlIIlIlIIl.getIconHeight();
        final List<BlockPart> lllllllllllIlIIIIIlIlIIlIIllllIl = (List<BlockPart>)Lists.newArrayList();
        for (final Span lllllllllllIlIIIIIlIlIIlIIllllII : this.getSpans(lllllllllllIlIIIIIlIlIIlIIlIlIIl)) {
            float lllllllllllIlIIIIIlIlIIlIIlllIll = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIlllIlI = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIlllIIl = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIlllIII = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIllIlll = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIllIllI = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIllIlIl = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIllIlII = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIllIIll = 0.0f;
            float lllllllllllIlIIIIIlIlIIlIIllIIlI = 0.0f;
            final float lllllllllllIlIIIIIlIlIIlIIllIIIl = (float)lllllllllllIlIIIIIlIlIIlIIllllII.getMin();
            final float lllllllllllIlIIIIIlIlIIlIIllIIII = (float)lllllllllllIlIIIIIlIlIIlIIllllII.getMax();
            final float lllllllllllIlIIIIIlIlIIlIIlIllll = (float)lllllllllllIlIIIIIlIlIIlIIllllII.getAnchor();
            final SpanFacing lllllllllllIlIIIIIlIlIIlIIlIlllI = lllllllllllIlIIIIIlIlIIlIIllllII.getFacing();
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing()[lllllllllllIlIIIIIlIlIIlIIlIlllI.ordinal()]) {
                case 1: {
                    lllllllllllIlIIIIIlIlIIlIIllIlll = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIlllIll = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIllIllI = (lllllllllllIlIIIIIlIlIIlIIlllIIl = lllllllllllIlIIIIIlIlIIlIIllIIII + 1.0f);
                    lllllllllllIlIIIIIlIlIIlIIllIlIl = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIlllIlI = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIllIlII = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIlllIII = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIllIIll = 16.0f / lllllllllllIlIIIIIlIlIIlIIllllll;
                    lllllllllllIlIIIIIlIlIIlIIllIIlI = 16.0f / (lllllllllllIlIIIIIlIlIIlIIlllllI - 1.0f);
                    break;
                }
                case 2: {
                    lllllllllllIlIIIIIlIlIIlIIllIlII = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIllIlIl = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIllIlll = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIlllIll = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIllIllI = (lllllllllllIlIIIIIlIlIIlIIlllIIl = lllllllllllIlIIIIIlIlIIlIIllIIII + 1.0f);
                    lllllllllllIlIIIIIlIlIIlIIlllIlI = lllllllllllIlIIIIIlIlIIlIIlIllll + 1.0f;
                    lllllllllllIlIIIIIlIlIIlIIlllIII = lllllllllllIlIIIIIlIlIIlIIlIllll + 1.0f;
                    lllllllllllIlIIIIIlIlIIlIIllIIll = 16.0f / lllllllllllIlIIIIIlIlIIlIIllllll;
                    lllllllllllIlIIIIIlIlIIlIIllIIlI = 16.0f / (lllllllllllIlIIIIIlIlIIlIIlllllI - 1.0f);
                    break;
                }
                case 3: {
                    lllllllllllIlIIIIIlIlIIlIIllIlll = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIlllIll = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIllIllI = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIlllIIl = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIllIlII = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIlllIlI = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIllIlIl = (lllllllllllIlIIIIIlIlIIlIIlllIII = lllllllllllIlIIIIIlIlIIlIIllIIII + 1.0f);
                    lllllllllllIlIIIIIlIlIIlIIllIIll = 16.0f / (lllllllllllIlIIIIIlIlIIlIIllllll - 1.0f);
                    lllllllllllIlIIIIIlIlIIlIIllIIlI = 16.0f / lllllllllllIlIIIIIlIlIIlIIlllllI;
                    break;
                }
                case 4: {
                    lllllllllllIlIIIIIlIlIIlIIllIllI = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIllIlll = lllllllllllIlIIIIIlIlIIlIIlIllll;
                    lllllllllllIlIIIIIlIlIIlIIlllIll = lllllllllllIlIIIIIlIlIIlIIlIllll + 1.0f;
                    lllllllllllIlIIIIIlIlIIlIIlllIIl = lllllllllllIlIIIIIlIlIIlIIlIllll + 1.0f;
                    lllllllllllIlIIIIIlIlIIlIIllIlII = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIlllIlI = lllllllllllIlIIIIIlIlIIlIIllIIIl;
                    lllllllllllIlIIIIIlIlIIlIIllIlIl = (lllllllllllIlIIIIIlIlIIlIIlllIII = lllllllllllIlIIIIIlIlIIlIIllIIII + 1.0f);
                    lllllllllllIlIIIIIlIlIIlIIllIIll = 16.0f / (lllllllllllIlIIIIIlIlIIlIIllllll - 1.0f);
                    lllllllllllIlIIIIIlIlIIlIIllIIlI = 16.0f / lllllllllllIlIIIIIlIlIIlIIlllllI;
                    break;
                }
            }
            final float lllllllllllIlIIIIIlIlIIlIIlIllIl = 16.0f / lllllllllllIlIIIIIlIlIIlIIllllll;
            final float lllllllllllIlIIIIIlIlIIlIIlIllII = 16.0f / lllllllllllIlIIIIIlIlIIlIIlllllI;
            lllllllllllIlIIIIIlIlIIlIIlllIll *= lllllllllllIlIIIIIlIlIIlIIlIllIl;
            lllllllllllIlIIIIIlIlIIlIIlllIIl *= lllllllllllIlIIIIIlIlIIlIIlIllIl;
            lllllllllllIlIIIIIlIlIIlIIlllIlI *= lllllllllllIlIIIIIlIlIIlIIlIllII;
            lllllllllllIlIIIIIlIlIIlIIlllIII *= lllllllllllIlIIIIIlIlIIlIIlIllII;
            lllllllllllIlIIIIIlIlIIlIIlllIlI = 16.0f - lllllllllllIlIIIIIlIlIIlIIlllIlI;
            lllllllllllIlIIIIIlIlIIlIIlllIII = 16.0f - lllllllllllIlIIIIIlIlIIlIIlllIII;
            lllllllllllIlIIIIIlIlIIlIIllIlll *= lllllllllllIlIIIIIlIlIIlIIllIIll;
            lllllllllllIlIIIIIlIlIIlIIllIllI *= lllllllllllIlIIIIIlIlIIlIIllIIll;
            lllllllllllIlIIIIIlIlIIlIIllIlIl *= lllllllllllIlIIIIIlIlIIlIIllIIlI;
            lllllllllllIlIIIIIlIlIIlIIllIlII *= lllllllllllIlIIIIIlIlIIlIIllIIlI;
            final Map<EnumFacing, BlockPartFace> lllllllllllIlIIIIIlIlIIlIIlIlIll = (Map<EnumFacing, BlockPartFace>)Maps.newHashMap();
            lllllllllllIlIIIIIlIlIIlIIlIlIll.put(lllllllllllIlIIIIIlIlIIlIIlIlllI.getFacing(), new BlockPartFace(null, lllllllllllIlIIIIIlIlIIlIlIIIIII, lllllllllllIlIIIIIlIlIIlIlIIIIIl, new BlockFaceUV(new float[] { lllllllllllIlIIIIIlIlIIlIIllIlll, lllllllllllIlIIIIIlIlIIlIIllIlIl, lllllllllllIlIIIIIlIlIIlIIllIllI, lllllllllllIlIIIIIlIlIIlIIllIlII }, 0)));
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing()[lllllllllllIlIIIIIlIlIIlIIlIlllI.ordinal()]) {
                default: {
                    continue;
                }
                case 1: {
                    lllllllllllIlIIIIIlIlIIlIIllllIl.add(new BlockPart(new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIll, lllllllllllIlIIIIIlIlIIlIIlllIlI, 7.5f), new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIIl, lllllllllllIlIIIIIlIlIIlIIlllIlI, 8.5f), lllllllllllIlIIIIIlIlIIlIIlIlIll, null, true));
                    continue;
                }
                case 2: {
                    lllllllllllIlIIIIIlIlIIlIIllllIl.add(new BlockPart(new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIll, lllllllllllIlIIIIIlIlIIlIIlllIII, 7.5f), new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIIl, lllllllllllIlIIIIIlIlIIlIIlllIII, 8.5f), lllllllllllIlIIIIIlIlIIlIIlIlIll, null, true));
                    continue;
                }
                case 3: {
                    lllllllllllIlIIIIIlIlIIlIIllllIl.add(new BlockPart(new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIll, lllllllllllIlIIIIIlIlIIlIIlllIlI, 7.5f), new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIll, lllllllllllIlIIIIIlIlIIlIIlllIII, 8.5f), lllllllllllIlIIIIIlIlIIlIIlIlIll, null, true));
                    continue;
                }
                case 4: {
                    lllllllllllIlIIIIIlIlIIlIIllllIl.add(new BlockPart(new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIIl, lllllllllllIlIIIIIlIlIIlIIlllIlI, 7.5f), new Vector3f(lllllllllllIlIIIIIlIlIIlIIlllIIl, lllllllllllIlIIIIIlIlIIlIIlllIII, 8.5f), lllllllllllIlIIIIIlIlIIlIIlIlIll, null, true));
                    continue;
                }
            }
        }
        return lllllllllllIlIIIIIlIlIIlIIllllIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing = ItemModelGenerator.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing;
        if ($switch_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing != null) {
            return $switch_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing;
        }
        final char lllllllllllIlIIIIIlIlIIIlIlIlIIl = (Object)new int[SpanFacing.values().length];
        try {
            lllllllllllIlIIIIIlIlIIIlIlIlIIl[SpanFacing.DOWN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIIIIlIlIIIlIlIlIIl[SpanFacing.LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIIIIlIlIIIlIlIlIIl[SpanFacing.RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIIIIlIlIIIlIlIlIIl[SpanFacing.UP.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return ItemModelGenerator.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing = (int[])(Object)lllllllllllIlIIIIIlIlIIIlIlIlIIl;
    }
    
    private List<Span> getSpans(final TextureAtlasSprite lllllllllllIlIIIIIlIlIIIlllllIll) {
        final int lllllllllllIlIIIIIlIlIIlIIIIIlII = lllllllllllIlIIIIIlIlIIIlllllIll.getIconWidth();
        final int lllllllllllIlIIIIIlIlIIlIIIIIIll = lllllllllllIlIIIIIlIlIIIlllllIll.getIconHeight();
        final List<Span> lllllllllllIlIIIIIlIlIIlIIIIIIlI = (List<Span>)Lists.newArrayList();
        for (int lllllllllllIlIIIIIlIlIIlIIIIIIIl = 0; lllllllllllIlIIIIIlIlIIlIIIIIIIl < lllllllllllIlIIIIIlIlIIIlllllIll.getFrameCount(); ++lllllllllllIlIIIIIlIlIIlIIIIIIIl) {
            final int[] lllllllllllIlIIIIIlIlIIlIIIIIIII = lllllllllllIlIIIIIlIlIIIlllllIll.getFrameTextureData(lllllllllllIlIIIIIlIlIIlIIIIIIIl)[0];
            for (int lllllllllllIlIIIIIlIlIIIllllllll = 0; lllllllllllIlIIIIIlIlIIIllllllll < lllllllllllIlIIIIIlIlIIlIIIIIIll; ++lllllllllllIlIIIIIlIlIIIllllllll) {
                for (int lllllllllllIlIIIIIlIlIIIlllllllI = 0; lllllllllllIlIIIIIlIlIIIlllllllI < lllllllllllIlIIIIIlIlIIlIIIIIlII; ++lllllllllllIlIIIIIlIlIIIlllllllI) {
                    final boolean lllllllllllIlIIIIIlIlIIIllllllIl = !this.isTransparent(lllllllllllIlIIIIIlIlIIlIIIIIIII, lllllllllllIlIIIIIlIlIIIlllllllI, lllllllllllIlIIIIIlIlIIIllllllll, lllllllllllIlIIIIIlIlIIlIIIIIlII, lllllllllllIlIIIIIlIlIIlIIIIIIll);
                    this.checkTransition(SpanFacing.UP, lllllllllllIlIIIIIlIlIIlIIIIIIlI, lllllllllllIlIIIIIlIlIIlIIIIIIII, lllllllllllIlIIIIIlIlIIIlllllllI, lllllllllllIlIIIIIlIlIIIllllllll, lllllllllllIlIIIIIlIlIIlIIIIIlII, lllllllllllIlIIIIIlIlIIlIIIIIIll, lllllllllllIlIIIIIlIlIIIllllllIl);
                    this.checkTransition(SpanFacing.DOWN, lllllllllllIlIIIIIlIlIIlIIIIIIlI, lllllllllllIlIIIIIlIlIIlIIIIIIII, lllllllllllIlIIIIIlIlIIIlllllllI, lllllllllllIlIIIIIlIlIIIllllllll, lllllllllllIlIIIIIlIlIIlIIIIIlII, lllllllllllIlIIIIIlIlIIlIIIIIIll, lllllllllllIlIIIIIlIlIIIllllllIl);
                    this.checkTransition(SpanFacing.LEFT, lllllllllllIlIIIIIlIlIIlIIIIIIlI, lllllllllllIlIIIIIlIlIIlIIIIIIII, lllllllllllIlIIIIIlIlIIIlllllllI, lllllllllllIlIIIIIlIlIIIllllllll, lllllllllllIlIIIIIlIlIIlIIIIIlII, lllllllllllIlIIIIIlIlIIlIIIIIIll, lllllllllllIlIIIIIlIlIIIllllllIl);
                    this.checkTransition(SpanFacing.RIGHT, lllllllllllIlIIIIIlIlIIlIIIIIIlI, lllllllllllIlIIIIIlIlIIlIIIIIIII, lllllllllllIlIIIIIlIlIIIlllllllI, lllllllllllIlIIIIIlIlIIIllllllll, lllllllllllIlIIIIIlIlIIlIIIIIlII, lllllllllllIlIIIIIlIlIIlIIIIIIll, lllllllllllIlIIIIIlIlIIIllllllIl);
                }
            }
        }
        return lllllllllllIlIIIIIlIlIIlIIIIIIlI;
    }
    
    private void checkTransition(final SpanFacing lllllllllllIlIIIIIlIlIIIllIlllIl, final List<Span> lllllllllllIlIIIIIlIlIIIlllIIllI, final int[] lllllllllllIlIIIIIlIlIIIllIllIll, final int lllllllllllIlIIIIIlIlIIIlllIIlII, final int lllllllllllIlIIIIIlIlIIIllIllIIl, final int lllllllllllIlIIIIIlIlIIIlllIIIlI, final int lllllllllllIlIIIIIlIlIIIllIlIlll, final boolean lllllllllllIlIIIIIlIlIIIllIlIllI) {
        final boolean lllllllllllIlIIIIIlIlIIIllIlllll = this.isTransparent(lllllllllllIlIIIIIlIlIIIllIllIll, lllllllllllIlIIIIIlIlIIIlllIIlII + lllllllllllIlIIIIIlIlIIIllIlllIl.getXOffset(), lllllllllllIlIIIIIlIlIIIllIllIIl + lllllllllllIlIIIIIlIlIIIllIlllIl.getYOffset(), lllllllllllIlIIIIIlIlIIIlllIIIlI, lllllllllllIlIIIIIlIlIIIllIlIlll) && lllllllllllIlIIIIIlIlIIIllIlIllI;
        if (lllllllllllIlIIIIIlIlIIIllIlllll) {
            this.createOrExpandSpan(lllllllllllIlIIIIIlIlIIIlllIIllI, lllllllllllIlIIIIIlIlIIIllIlllIl, lllllllllllIlIIIIIlIlIIIlllIIlII, lllllllllllIlIIIIIlIlIIIllIllIIl);
        }
    }
    
    private boolean isTransparent(final int[] lllllllllllIlIIIIIlIlIIIlIllIlII, final int lllllllllllIlIIIIIlIlIIIlIlIlllI, final int lllllllllllIlIIIIIlIlIIIlIlIllIl, final int lllllllllllIlIIIIIlIlIIIlIllIIIl, final int lllllllllllIlIIIIIlIlIIIlIlIlIll) {
        return lllllllllllIlIIIIIlIlIIIlIlIlllI < 0 || lllllllllllIlIIIIIlIlIIIlIlIllIl < 0 || lllllllllllIlIIIIIlIlIIIlIlIlllI >= lllllllllllIlIIIIIlIlIIIlIllIIIl || lllllllllllIlIIIIIlIlIIIlIlIllIl >= lllllllllllIlIIIIIlIlIIIlIlIlIll || (lllllllllllIlIIIIIlIlIIIlIllIlII[lllllllllllIlIIIIIlIlIIIlIlIllIl * lllllllllllIlIIIIIlIlIIIlIllIIIl + lllllllllllIlIIIIIlIlIIIlIlIlllI] >> 24 & 0xFF) == 0x0;
    }
    
    enum SpanFacing
    {
        private final /* synthetic */ int xOffset;
        
        DOWN("DOWN", 1, EnumFacing.DOWN, 0, 1), 
        LEFT("LEFT", 2, EnumFacing.EAST, -1, 0);
        
        private final /* synthetic */ int yOffset;
        private final /* synthetic */ EnumFacing facing;
        
        UP("UP", 0, EnumFacing.UP, 0, -1), 
        RIGHT("RIGHT", 3, EnumFacing.WEST, 1, 0);
        
        public EnumFacing getFacing() {
            return this.facing;
        }
        
        public int getXOffset() {
            return this.xOffset;
        }
        
        private SpanFacing(final String llllllllllIlllllIlllllIIlIllllIl, final int llllllllllIlllllIlllllIIlIllllII, final EnumFacing llllllllllIlllllIlllllIIllIIIIIl, final int llllllllllIlllllIlllllIIllIIIIII, final int llllllllllIlllllIlllllIIlIlllIIl) {
            this.facing = llllllllllIlllllIlllllIIllIIIIIl;
            this.xOffset = llllllllllIlllllIlllllIIllIIIIII;
            this.yOffset = llllllllllIlllllIlllllIIlIlllIIl;
        }
        
        public int getYOffset() {
            return this.yOffset;
        }
        
        private boolean isHorizontal() {
            return this == SpanFacing.DOWN || this == SpanFacing.UP;
        }
    }
    
    static class Span
    {
        private final /* synthetic */ SpanFacing spanFacing;
        private /* synthetic */ int max;
        private /* synthetic */ int min;
        private final /* synthetic */ int anchor;
        
        public int getMin() {
            return this.min;
        }
        
        public int getAnchor() {
            return this.anchor;
        }
        
        public int getMax() {
            return this.max;
        }
        
        public SpanFacing getFacing() {
            return this.spanFacing;
        }
        
        public void expand(final int lllllllllllIllIllllllIlIllIIIlIl) {
            if (lllllllllllIllIllllllIlIllIIIlIl < this.min) {
                this.min = lllllllllllIllIllllllIlIllIIIlIl;
            }
            else if (lllllllllllIllIllllllIlIllIIIlIl > this.max) {
                this.max = lllllllllllIllIllllllIlIllIIIlIl;
            }
        }
        
        public Span(final SpanFacing lllllllllllIllIllllllIlIllIIlIll, final int lllllllllllIllIllllllIlIllIIlIlI, final int lllllllllllIllIllllllIlIllIIlIIl) {
            this.spanFacing = lllllllllllIllIllllllIlIllIIlIll;
            this.min = lllllllllllIllIllllllIlIllIIlIlI;
            this.max = lllllllllllIllIllllllIlIllIIlIlI;
            this.anchor = lllllllllllIllIllllllIlIllIIlIIl;
        }
    }
}
