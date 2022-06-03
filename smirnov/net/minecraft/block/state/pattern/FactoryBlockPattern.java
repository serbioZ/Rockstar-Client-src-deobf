// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state.pattern;

import java.lang.reflect.Array;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import net.minecraft.block.state.BlockWorldState;
import com.google.common.base.Predicate;
import java.util.Map;
import java.util.List;
import com.google.common.base.Joiner;

public class FactoryBlockPattern
{
    private static final /* synthetic */ Joiner COMMA_JOIN;
    private /* synthetic */ int rowWidth;
    private /* synthetic */ int aisleHeight;
    private final /* synthetic */ List<String[]> depth;
    private final /* synthetic */ Map<Character, Predicate<BlockWorldState>> symbolMap;
    
    public BlockPattern build() {
        return new BlockPattern(this.makePredicateArray());
    }
    
    static {
        COMMA_JOIN = Joiner.on(",");
    }
    
    public FactoryBlockPattern aisle(final String... lllllllllllllIIlllllIllIllIIIllI) {
        if (ArrayUtils.isEmpty((Object[])lllllllllllllIIlllllIllIllIIIllI) || StringUtils.isEmpty((CharSequence)lllllllllllllIIlllllIllIllIIIllI[0])) {
            throw new IllegalArgumentException("Empty pattern for aisle");
        }
        if (this.depth.isEmpty()) {
            this.aisleHeight = lllllllllllllIIlllllIllIllIIIllI.length;
            this.rowWidth = lllllllllllllIIlllllIllIllIIIllI[0].length();
        }
        if (lllllllllllllIIlllllIllIllIIIllI.length != this.aisleHeight) {
            throw new IllegalArgumentException("Expected aisle with height of " + this.aisleHeight + ", but was given one with a height of " + lllllllllllllIIlllllIllIllIIIllI.length + ")");
        }
        final String lllllllllllllIIlllllIllIlIlllllI = (Object)lllllllllllllIIlllllIllIllIIIllI;
        for (String lllllllllllllIIlllllIllIlIllllll = (String)lllllllllllllIIlllllIllIllIIIllI.length, lllllllllllllIIlllllIllIllIIIIII = (String)0; lllllllllllllIIlllllIllIllIIIIII < lllllllllllllIIlllllIllIlIllllll; ++lllllllllllllIIlllllIllIllIIIIII) {
            final String lllllllllllllIIlllllIllIllIIIlIl = lllllllllllllIIlllllIllIlIlllllI[lllllllllllllIIlllllIllIllIIIIII];
            if (lllllllllllllIIlllllIllIllIIIlIl.length() != this.rowWidth) {
                throw new IllegalArgumentException("Not all rows in the given aisle are the correct width (expected " + this.rowWidth + ", found one with " + lllllllllllllIIlllllIllIllIIIlIl.length() + ")");
            }
            final char lllllllllllllIIlllllIllIlIlllIlI;
            final byte lllllllllllllIIlllllIllIlIlllIll = (byte)((char[])(Object)(lllllllllllllIIlllllIllIlIlllIlI = (char)(Object)lllllllllllllIIlllllIllIllIIIlIl.toCharArray())).length;
            for (boolean lllllllllllllIIlllllIllIlIllllII = false; (lllllllllllllIIlllllIllIlIllllII ? 1 : 0) < lllllllllllllIIlllllIllIlIlllIll; ++lllllllllllllIIlllllIllIlIllllII) {
                final char lllllllllllllIIlllllIllIllIIIlII = lllllllllllllIIlllllIllIlIlllIlI[lllllllllllllIIlllllIllIlIllllII];
                if (!this.symbolMap.containsKey(lllllllllllllIIlllllIllIllIIIlII)) {
                    this.symbolMap.put(lllllllllllllIIlllllIllIllIIIlII, null);
                }
            }
        }
        this.depth.add(lllllllllllllIIlllllIllIllIIIllI);
        return this;
    }
    
    public static FactoryBlockPattern start() {
        return new FactoryBlockPattern();
    }
    
    private void checkMissingPredicates() {
        final List<Character> lllllllllllllIIlllllIllIlIIllIIl = (List<Character>)Lists.newArrayList();
        for (final Map.Entry<Character, Predicate<BlockWorldState>> lllllllllllllIIlllllIllIlIIllIII : this.symbolMap.entrySet()) {
            if (lllllllllllllIIlllllIllIlIIllIII.getValue() == null) {
                lllllllllllllIIlllllIllIlIIllIIl.add(lllllllllllllIIlllllIllIlIIllIII.getKey());
            }
        }
        if (!lllllllllllllIIlllllIllIlIIllIIl.isEmpty()) {
            throw new IllegalStateException("Predicates for character(s) " + FactoryBlockPattern.COMMA_JOIN.join((Iterable)lllllllllllllIIlllllIllIlIIllIIl) + " are missing");
        }
    }
    
    private FactoryBlockPattern() {
        this.depth = (List<String[]>)Lists.newArrayList();
        this.symbolMap = (Map<Character, Predicate<BlockWorldState>>)Maps.newHashMap();
        this.symbolMap.put(' ', (Predicate<BlockWorldState>)Predicates.alwaysTrue());
    }
    
    private Predicate<BlockWorldState>[][][] makePredicateArray() {
        this.checkMissingPredicates();
        final Predicate[][][] lllllllllllllIIlllllIllIlIlIIlll = (Predicate[][][])Array.newInstance(Predicate.class, this.depth.size(), this.aisleHeight, this.rowWidth);
        for (int lllllllllllllIIlllllIllIlIlIIllI = 0; lllllllllllllIIlllllIllIlIlIIllI < this.depth.size(); ++lllllllllllllIIlllllIllIlIlIIllI) {
            for (int lllllllllllllIIlllllIllIlIlIIlIl = 0; lllllllllllllIIlllllIllIlIlIIlIl < this.aisleHeight; ++lllllllllllllIIlllllIllIlIlIIlIl) {
                for (int lllllllllllllIIlllllIllIlIlIIlII = 0; lllllllllllllIIlllllIllIlIlIIlII < this.rowWidth; ++lllllllllllllIIlllllIllIlIlIIlII) {
                    lllllllllllllIIlllllIllIlIlIIlll[lllllllllllllIIlllllIllIlIlIIllI][lllllllllllllIIlllllIllIlIlIIlIl][lllllllllllllIIlllllIllIlIlIIlII] = this.symbolMap.get(this.depth.get(lllllllllllllIIlllllIllIlIlIIllI)[lllllllllllllIIlllllIllIlIlIIlIl].charAt(lllllllllllllIIlllllIllIlIlIIlII));
                }
            }
        }
        return (Predicate<BlockWorldState>[][][])lllllllllllllIIlllllIllIlIlIIlll;
    }
    
    public FactoryBlockPattern where(final char lllllllllllllIIlllllIllIlIllIlIl, final Predicate<BlockWorldState> lllllllllllllIIlllllIllIlIllIIIl) {
        this.symbolMap.put(lllllllllllllIIlllllIllIlIllIlIl, lllllllllllllIIlllllIllIlIllIIIl);
        return this;
    }
}
