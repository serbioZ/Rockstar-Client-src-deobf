// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import net.minecraft.util.text.TextFormatting;
import com.google.common.collect.Maps;
import java.util.Map;

public interface IScoreCriteria
{
    String getName();
    
    boolean isReadOnly();
    
    EnumRenderType getRenderType();
    
    public enum EnumRenderType
    {
        HEARTS("HEARTS", 1, "hearts"), 
        INTEGER("INTEGER", 0, "integer");
        
        private static final /* synthetic */ Map<String, EnumRenderType> BY_NAME;
        private final /* synthetic */ String renderType;
        
        static {
            BY_NAME = Maps.newHashMap();
            final boolean llllllllllllIlllIIIIlIlIllIllllI;
            final float llllllllllllIlllIIIIlIlIllIlllll = ((EnumRenderType[])(Object)(llllllllllllIlllIIIIlIlIllIllllI = (boolean)(Object)values())).length;
            for (short llllllllllllIlllIIIIlIlIlllIIIII = 0; llllllllllllIlllIIIIlIlIlllIIIII < llllllllllllIlllIIIIlIlIllIlllll; ++llllllllllllIlllIIIIlIlIlllIIIII) {
                final EnumRenderType llllllllllllIlllIIIIlIlIlllIIIlI = llllllllllllIlllIIIIlIlIllIllllI[llllllllllllIlllIIIIlIlIlllIIIII];
                EnumRenderType.BY_NAME.put(llllllllllllIlllIIIIlIlIlllIIIlI.getRenderType(), llllllllllllIlllIIIIlIlIlllIIIlI);
            }
        }
        
        public String getRenderType() {
            return this.renderType;
        }
        
        public static EnumRenderType getByName(final String llllllllllllIlllIIIIlIlIllIIlllI) {
            final EnumRenderType llllllllllllIlllIIIIlIlIllIIllIl = EnumRenderType.BY_NAME.get(llllllllllllIlllIIIIlIlIllIIlllI);
            return (llllllllllllIlllIIIIlIlIllIIllIl == null) ? EnumRenderType.INTEGER : llllllllllllIlllIIIIlIlIllIIllIl;
        }
        
        private EnumRenderType(final String llllllllllllIlllIIIIlIlIllIlIllI, final int llllllllllllIlllIIIIlIlIllIlIlIl, final String llllllllllllIlllIIIIlIlIllIllIII) {
            this.renderType = llllllllllllIlllIIIIlIlIllIllIII;
        }
    }
}
