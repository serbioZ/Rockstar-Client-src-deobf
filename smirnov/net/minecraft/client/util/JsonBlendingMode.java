// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

import java.util.Locale;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonObject;
import net.minecraft.client.renderer.GlStateManager;

public class JsonBlendingMode
{
    private final /* synthetic */ boolean opaque;
    private static /* synthetic */ JsonBlendingMode lastApplied;
    private final /* synthetic */ int srcAlphaFactor;
    private final /* synthetic */ int destColorFactor;
    private final /* synthetic */ int srcColorFactor;
    private final /* synthetic */ boolean separateBlend;
    private final /* synthetic */ int destAlphaFactor;
    private final /* synthetic */ int blendFunction;
    
    public boolean isOpaque() {
        return this.opaque;
    }
    
    public void apply() {
        if (!this.equals(JsonBlendingMode.lastApplied)) {
            if (JsonBlendingMode.lastApplied == null || this.opaque != JsonBlendingMode.lastApplied.isOpaque()) {
                JsonBlendingMode.lastApplied = this;
                if (this.opaque) {
                    GlStateManager.disableBlend();
                    return;
                }
                GlStateManager.enableBlend();
            }
            GlStateManager.glBlendEquation(this.blendFunction);
            if (this.separateBlend) {
                GlStateManager.tryBlendFuncSeparate(this.srcColorFactor, this.destColorFactor, this.srcAlphaFactor, this.destAlphaFactor);
            }
            else {
                GlStateManager.blendFunc(this.srcColorFactor, this.destColorFactor);
            }
        }
    }
    
    public JsonBlendingMode(final int lllllllllllIlIllIIIlIIlIllIlIIII, final int lllllllllllIlIllIIIlIIlIllIIllll, final int lllllllllllIlIllIIIlIIlIllIlIIlI) {
        this(false, false, lllllllllllIlIllIIIlIIlIllIlIIII, lllllllllllIlIllIIIlIIlIllIIllll, lllllllllllIlIllIIIlIIlIllIlIIII, lllllllllllIlIllIIIlIIlIllIIllll, lllllllllllIlIllIIIlIIlIllIlIIlI);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllIlIllIIIlIIlIlIlIllII = this.srcColorFactor;
        lllllllllllIlIllIIIlIIlIlIlIllII = 31 * lllllllllllIlIllIIIlIIlIlIlIllII + this.srcAlphaFactor;
        lllllllllllIlIllIIIlIIlIlIlIllII = 31 * lllllllllllIlIllIIIlIIlIlIlIllII + this.destColorFactor;
        lllllllllllIlIllIIIlIIlIlIlIllII = 31 * lllllllllllIlIllIIIlIIlIlIlIllII + this.destAlphaFactor;
        lllllllllllIlIllIIIlIIlIlIlIllII = 31 * lllllllllllIlIllIIIlIIlIlIlIllII + this.blendFunction;
        lllllllllllIlIllIIIlIIlIlIlIllII = 31 * lllllllllllIlIllIIIlIIlIlIlIllII + (this.separateBlend ? 1 : 0);
        lllllllllllIlIllIIIlIIlIlIlIllII = 31 * lllllllllllIlIllIIIlIIlIlIlIllII + (this.opaque ? 1 : 0);
        return lllllllllllIlIllIIIlIIlIlIlIllII;
    }
    
    private JsonBlendingMode(final boolean lllllllllllIlIllIIIlIIlIlllIlIll, final boolean lllllllllllIlIllIIIlIIlIlllIIIlI, final int lllllllllllIlIllIIIlIIlIlllIlIIl, final int lllllllllllIlIllIIIlIIlIlllIlIII, final int lllllllllllIlIllIIIlIIlIllIlllll, final int lllllllllllIlIllIIIlIIlIllIllllI, final int lllllllllllIlIllIIIlIIlIlllIIlIl) {
        this.separateBlend = lllllllllllIlIllIIIlIIlIlllIlIll;
        this.srcColorFactor = lllllllllllIlIllIIIlIIlIlllIlIIl;
        this.destColorFactor = lllllllllllIlIllIIIlIIlIlllIlIII;
        this.srcAlphaFactor = lllllllllllIlIllIIIlIIlIllIlllll;
        this.destAlphaFactor = lllllllllllIlIllIIIlIIlIllIllllI;
        this.opaque = lllllllllllIlIllIIIlIIlIlllIIIlI;
        this.blendFunction = lllllllllllIlIllIIIlIIlIlllIIlIl;
    }
    
    public JsonBlendingMode(final int lllllllllllIlIllIIIlIIlIllIIIllI, final int lllllllllllIlIllIIIlIIlIlIllllll, final int lllllllllllIlIllIIIlIIlIllIIIlII, final int lllllllllllIlIllIIIlIIlIlIllllIl, final int lllllllllllIlIllIIIlIIlIlIllllII) {
        this(true, false, lllllllllllIlIllIIIlIIlIllIIIllI, lllllllllllIlIllIIIlIIlIlIllllll, lllllllllllIlIllIIIlIIlIllIIIlII, lllllllllllIlIllIIIlIIlIlIllllIl, lllllllllllIlIllIIIlIIlIlIllllII);
    }
    
    public static JsonBlendingMode parseBlendNode(final JsonObject lllllllllllIlIllIIIlIIlIlIIllllI) {
        if (lllllllllllIlIllIIIlIIlIlIIllllI == null) {
            return new JsonBlendingMode();
        }
        int lllllllllllIlIllIIIlIIlIlIIlllIl = 32774;
        int lllllllllllIlIllIIIlIIlIlIIlllII = 1;
        int lllllllllllIlIllIIIlIIlIlIIllIll = 0;
        int lllllllllllIlIllIIIlIIlIlIIllIlI = 1;
        int lllllllllllIlIllIIIlIIlIlIIllIIl = 0;
        boolean lllllllllllIlIllIIIlIIlIlIIllIII = true;
        boolean lllllllllllIlIllIIIlIIlIlIIlIlll = false;
        if (JsonUtils.isString(lllllllllllIlIllIIIlIIlIlIIllllI, "func")) {
            lllllllllllIlIllIIIlIIlIlIIlllIl = stringToBlendFunction(lllllllllllIlIllIIIlIIlIlIIllllI.get("func").getAsString());
            if (lllllllllllIlIllIIIlIIlIlIIlllIl != 32774) {
                lllllllllllIlIllIIIlIIlIlIIllIII = false;
            }
        }
        if (JsonUtils.isString(lllllllllllIlIllIIIlIIlIlIIllllI, "srcrgb")) {
            lllllllllllIlIllIIIlIIlIlIIlllII = stringToBlendFactor(lllllllllllIlIllIIIlIIlIlIIllllI.get("srcrgb").getAsString());
            if (lllllllllllIlIllIIIlIIlIlIIlllII != 1) {
                lllllllllllIlIllIIIlIIlIlIIllIII = false;
            }
        }
        if (JsonUtils.isString(lllllllllllIlIllIIIlIIlIlIIllllI, "dstrgb")) {
            lllllllllllIlIllIIIlIIlIlIIllIll = stringToBlendFactor(lllllllllllIlIllIIIlIIlIlIIllllI.get("dstrgb").getAsString());
            if (lllllllllllIlIllIIIlIIlIlIIllIll != 0) {
                lllllllllllIlIllIIIlIIlIlIIllIII = false;
            }
        }
        if (JsonUtils.isString(lllllllllllIlIllIIIlIIlIlIIllllI, "srcalpha")) {
            lllllllllllIlIllIIIlIIlIlIIllIlI = stringToBlendFactor(lllllllllllIlIllIIIlIIlIlIIllllI.get("srcalpha").getAsString());
            if (lllllllllllIlIllIIIlIIlIlIIllIlI != 1) {
                lllllllllllIlIllIIIlIIlIlIIllIII = false;
            }
            lllllllllllIlIllIIIlIIlIlIIlIlll = true;
        }
        if (JsonUtils.isString(lllllllllllIlIllIIIlIIlIlIIllllI, "dstalpha")) {
            lllllllllllIlIllIIIlIIlIlIIllIIl = stringToBlendFactor(lllllllllllIlIllIIIlIIlIlIIllllI.get("dstalpha").getAsString());
            if (lllllllllllIlIllIIIlIIlIlIIllIIl != 0) {
                lllllllllllIlIllIIIlIIlIlIIllIII = false;
            }
            lllllllllllIlIllIIIlIIlIlIIlIlll = true;
        }
        if (lllllllllllIlIllIIIlIIlIlIIllIII) {
            return new JsonBlendingMode();
        }
        return lllllllllllIlIllIIIlIIlIlIIlIlll ? new JsonBlendingMode(lllllllllllIlIllIIIlIIlIlIIlllII, lllllllllllIlIllIIIlIIlIlIIllIll, lllllllllllIlIllIIIlIIlIlIIllIlI, lllllllllllIlIllIIIlIIlIlIIllIIl, lllllllllllIlIllIIIlIIlIlIIlllIl) : new JsonBlendingMode(lllllllllllIlIllIIIlIIlIlIIlllII, lllllllllllIlIllIIIlIIlIlIIllIll, lllllllllllIlIllIIIlIIlIlIIlllIl);
    }
    
    private static int stringToBlendFactor(final String lllllllllllIlIllIIIlIIlIlIIIIlII) {
        String lllllllllllIlIllIIIlIIlIlIIIIlIl = lllllllllllIlIllIIIlIIlIlIIIIlII.trim().toLowerCase(Locale.ROOT);
        lllllllllllIlIllIIIlIIlIlIIIIlIl = lllllllllllIlIllIIIlIIlIlIIIIlIl.replaceAll("_", "");
        lllllllllllIlIllIIIlIIlIlIIIIlIl = lllllllllllIlIllIIIlIIlIlIIIIlIl.replaceAll("one", "1");
        lllllllllllIlIllIIIlIIlIlIIIIlIl = lllllllllllIlIllIIIlIIlIlIIIIlIl.replaceAll("zero", "0");
        lllllllllllIlIllIIIlIIlIlIIIIlIl = lllllllllllIlIllIIIlIIlIlIIIIlIl.replaceAll("minus", "-");
        if ("0".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 0;
        }
        if ("1".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 1;
        }
        if ("srccolor".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 768;
        }
        if ("1-srccolor".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 769;
        }
        if ("dstcolor".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 774;
        }
        if ("1-dstcolor".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 775;
        }
        if ("srcalpha".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 770;
        }
        if ("1-srcalpha".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 771;
        }
        if ("dstalpha".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl)) {
            return 772;
        }
        return "1-dstalpha".equals(lllllllllllIlIllIIIlIIlIlIIIIlIl) ? 773 : -1;
    }
    
    private static int stringToBlendFunction(final String lllllllllllIlIllIIIlIIlIlIIIlIlI) {
        final String lllllllllllIlIllIIIlIIlIlIIIlIll = lllllllllllIlIllIIIlIIlIlIIIlIlI.trim().toLowerCase(Locale.ROOT);
        if ("add".equals(lllllllllllIlIllIIIlIIlIlIIIlIll)) {
            return 32774;
        }
        if ("subtract".equals(lllllllllllIlIllIIIlIIlIlIIIlIll)) {
            return 32778;
        }
        if ("reversesubtract".equals(lllllllllllIlIllIIIlIIlIlIIIlIll)) {
            return 32779;
        }
        if ("reverse_subtract".equals(lllllllllllIlIllIIIlIIlIlIIIlIll)) {
            return 32779;
        }
        if ("min".equals(lllllllllllIlIllIIIlIIlIlIIIlIll)) {
            return 32775;
        }
        return "max".equals(lllllllllllIlIllIIIlIIlIlIIIlIll) ? 32776 : 32774;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIlIllIIIlIIlIlIllIlII) {
        if (this == lllllllllllIlIllIIIlIIlIlIllIlII) {
            return true;
        }
        if (!(lllllllllllIlIllIIIlIIlIlIllIlII instanceof JsonBlendingMode)) {
            return false;
        }
        final JsonBlendingMode lllllllllllIlIllIIIlIIlIlIllIIll = (JsonBlendingMode)lllllllllllIlIllIIIlIIlIlIllIlII;
        return this.blendFunction == lllllllllllIlIllIIIlIIlIlIllIIll.blendFunction && this.destAlphaFactor == lllllllllllIlIllIIIlIIlIlIllIIll.destAlphaFactor && this.destColorFactor == lllllllllllIlIllIIIlIIlIlIllIIll.destColorFactor && this.opaque == lllllllllllIlIllIIIlIIlIlIllIIll.opaque && this.separateBlend == lllllllllllIlIllIIIlIIlIlIllIIll.separateBlend && this.srcAlphaFactor == lllllllllllIlIllIIIlIIlIlIllIIll.srcAlphaFactor && this.srcColorFactor == lllllllllllIlIllIIIlIIlIlIllIIll.srcColorFactor;
    }
    
    public JsonBlendingMode() {
        this(false, true, 1, 0, 1, 0, 32774);
    }
}
