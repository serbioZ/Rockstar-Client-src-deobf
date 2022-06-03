// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

import org.apache.logging.log4j.LogManager;
import it.unimi.dsi.fastutil.Swapper;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntComparator;
import java.util.Set;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.Collections;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import java.util.List;
import it.unimi.dsi.fastutil.ints.IntList;
import org.apache.logging.log4j.Logger;

public class SuffixArray<T>
{
    private static final /* synthetic */ Logger field_194064_d;
    private static final /* synthetic */ boolean field_194063_c;
    private final /* synthetic */ IntList field_194066_f;
    private /* synthetic */ IntList field_194068_h;
    private /* synthetic */ int field_194069_i;
    private static final /* synthetic */ boolean field_194062_b;
    private /* synthetic */ IntList field_194067_g;
    protected final /* synthetic */ List<T> field_194061_a;
    private final /* synthetic */ IntList field_194065_e;
    
    private int func_194056_a(final String llllllllllllllIllIIIIIIllIlIlIIl, final int llllllllllllllIllIIIIIIllIlIlIII) {
        final int llllllllllllllIllIIIIIIllIlIIlll = this.field_194066_f.getInt(this.field_194067_g.getInt(llllllllllllllIllIIIIIIllIlIlIII));
        final int llllllllllllllIllIIIIIIllIlIIllI = this.field_194068_h.getInt(llllllllllllllIllIIIIIIllIlIlIII);
        for (int llllllllllllllIllIIIIIIllIlIIlIl = 0; llllllllllllllIllIIIIIIllIlIIlIl < llllllllllllllIllIIIIIIllIlIlIIl.length(); ++llllllllllllllIllIIIIIIllIlIIlIl) {
            final int llllllllllllllIllIIIIIIllIlIIlII = this.field_194065_e.getInt(llllllllllllllIllIIIIIIllIlIIlll + llllllllllllllIllIIIIIIllIlIIllI + llllllllllllllIllIIIIIIllIlIIlIl);
            if (llllllllllllllIllIIIIIIllIlIIlII == -1) {
                return 1;
            }
            final char llllllllllllllIllIIIIIIllIlIIIll = llllllllllllllIllIIIIIIllIlIlIIl.charAt(llllllllllllllIllIIIIIIllIlIIlIl);
            final char llllllllllllllIllIIIIIIllIlIIIlI = (char)llllllllllllllIllIIIIIIllIlIIlII;
            if (llllllllllllllIllIIIIIIllIlIIIll < llllllllllllllIllIIIIIIllIlIIIlI) {
                return -1;
            }
            if (llllllllllllllIllIIIIIIllIlIIIll > llllllllllllllIllIIIIIIllIlIIIlI) {
                return 1;
            }
        }
        return 0;
    }
    
    public List<T> func_194055_a(final String llllllllllllllIllIIIIIIlIllllIIl) {
        final int llllllllllllllIllIIIIIIllIIIlIII = this.field_194067_g.size();
        int llllllllllllllIllIIIIIIllIIIIlll = 0;
        int llllllllllllllIllIIIIIIllIIIIllI = llllllllllllllIllIIIIIIllIIIlIII;
        while (llllllllllllllIllIIIIIIllIIIIlll < llllllllllllllIllIIIIIIllIIIIllI) {
            final int llllllllllllllIllIIIIIIllIIIIlIl = llllllllllllllIllIIIIIIllIIIIlll + (llllllllllllllIllIIIIIIllIIIIllI - llllllllllllllIllIIIIIIllIIIIlll) / 2;
            final int llllllllllllllIllIIIIIIllIIIIlII = this.func_194056_a(llllllllllllllIllIIIIIIlIllllIIl, llllllllllllllIllIIIIIIllIIIIlIl);
            if (SuffixArray.field_194062_b) {
                SuffixArray.field_194064_d.debug("comparing lower \"{}\" with {} \"{}\": {}", (Object)llllllllllllllIllIIIIIIlIllllIIl, (Object)llllllllllllllIllIIIIIIllIIIIlIl, (Object)this.func_194059_a(llllllllllllllIllIIIIIIllIIIIlIl), (Object)llllllllllllllIllIIIIIIllIIIIlII);
            }
            if (llllllllllllllIllIIIIIIllIIIIlII > 0) {
                llllllllllllllIllIIIIIIllIIIIlll = llllllllllllllIllIIIIIIllIIIIlIl + 1;
            }
            else {
                llllllllllllllIllIIIIIIllIIIIllI = llllllllllllllIllIIIIIIllIIIIlIl;
            }
        }
        if (llllllllllllllIllIIIIIIllIIIIlll >= 0 && llllllllllllllIllIIIIIIllIIIIlll < llllllllllllllIllIIIIIIllIIIlIII) {
            final int llllllllllllllIllIIIIIIllIIIIIll = llllllllllllllIllIIIIIIllIIIIlll;
            llllllllllllllIllIIIIIIllIIIIllI = llllllllllllllIllIIIIIIllIIIlIII;
            while (llllllllllllllIllIIIIIIllIIIIlll < llllllllllllllIllIIIIIIllIIIIllI) {
                final int llllllllllllllIllIIIIIIllIIIIIlI = llllllllllllllIllIIIIIIllIIIIlll + (llllllllllllllIllIIIIIIllIIIIllI - llllllllllllllIllIIIIIIllIIIIlll) / 2;
                final int llllllllllllllIllIIIIIIllIIIIIIl = this.func_194056_a(llllllllllllllIllIIIIIIlIllllIIl, llllllllllllllIllIIIIIIllIIIIIlI);
                if (SuffixArray.field_194062_b) {
                    SuffixArray.field_194064_d.debug("comparing upper \"{}\" with {} \"{}\": {}", (Object)llllllllllllllIllIIIIIIlIllllIIl, (Object)llllllllllllllIllIIIIIIllIIIIIlI, (Object)this.func_194059_a(llllllllllllllIllIIIIIIllIIIIIlI), (Object)llllllllllllllIllIIIIIIllIIIIIIl);
                }
                if (llllllllllllllIllIIIIIIllIIIIIIl >= 0) {
                    llllllllllllllIllIIIIIIllIIIIlll = llllllllllllllIllIIIIIIllIIIIIlI + 1;
                }
                else {
                    llllllllllllllIllIIIIIIllIIIIllI = llllllllllllllIllIIIIIIllIIIIIlI;
                }
            }
            final int llllllllllllllIllIIIIIIllIIIIIII = llllllllllllllIllIIIIIIllIIIIlll;
            final IntSet llllllllllllllIllIIIIIIlIlllllll = (IntSet)new IntOpenHashSet();
            for (int llllllllllllllIllIIIIIIlIllllllI = llllllllllllllIllIIIIIIllIIIIIll; llllllllllllllIllIIIIIIlIllllllI < llllllllllllllIllIIIIIIllIIIIIII; ++llllllllllllllIllIIIIIIlIllllllI) {
                llllllllllllllIllIIIIIIlIlllllll.add(this.field_194067_g.getInt(llllllllllllllIllIIIIIIlIllllllI));
            }
            final int[] llllllllllllllIllIIIIIIlIlllllIl = llllllllllllllIllIIIIIIlIlllllll.toIntArray();
            Arrays.sort(llllllllllllllIllIIIIIIlIlllllIl);
            final Set<T> llllllllllllllIllIIIIIIlIlllllII = (Set<T>)Sets.newLinkedHashSet();
            final float llllllllllllllIllIIIIIIlIllIllIl;
            final String llllllllllllllIllIIIIIIlIllIlllI = (String)((int[])(Object)(llllllllllllllIllIIIIIIlIllIllIl = (float)(Object)llllllllllllllIllIIIIIIlIlllllIl)).length;
            for (long llllllllllllllIllIIIIIIlIllIllll = 0; llllllllllllllIllIIIIIIlIllIllll < llllllllllllllIllIIIIIIlIllIlllI; ++llllllllllllllIllIIIIIIlIllIllll) {
                final int llllllllllllllIllIIIIIIlIllllIll = llllllllllllllIllIIIIIIlIllIllIl[llllllllllllllIllIIIIIIlIllIllll];
                llllllllllllllIllIIIIIIlIlllllII.add(this.field_194061_a.get(llllllllllllllIllIIIIIIlIllllIll));
            }
            return (List<T>)Lists.newArrayList((Iterable)llllllllllllllIllIIIIIIlIlllllII);
        }
        return Collections.emptyList();
    }
    
    private void func_194060_b() {
        for (int llllllllllllllIllIIIIIIlllIIlIll = 0; llllllllllllllIllIIIIIIlllIIlIll < this.field_194067_g.size(); ++llllllllllllllIllIIIIIIlllIIlIll) {
            SuffixArray.field_194064_d.debug("{} {}", (Object)llllllllllllllIllIIIIIIlllIIlIll, (Object)this.func_194059_a(llllllllllllllIllIIIIIIlllIIlIll));
        }
        SuffixArray.field_194064_d.debug("");
    }
    
    public void func_194058_a() {
        final int llllllllllllllIllIIIIIIllllIlIll = this.field_194065_e.size();
        final int[] llllllllllllllIllIIIIIIllllIlIlI = new int[llllllllllllllIllIIIIIIllllIlIll];
        final int[] llllllllllllllIllIIIIIIllllIlIIl = new int[llllllllllllllIllIIIIIIllllIlIll];
        final int[] llllllllllllllIllIIIIIIllllIlIII = new int[llllllllllllllIllIIIIIIllllIlIll];
        final int[] llllllllllllllIllIIIIIIllllIIlll = new int[llllllllllllllIllIIIIIIllllIlIll];
        final IntComparator llllllllllllllIllIIIIIIllllIIllI = (IntComparator)new IntComparator() {
            public int compare(final int lllllllllllllIIIllllIIIIllIIllIl, final int lllllllllllllIIIllllIIIIllIIllII) {
                return (llllllllllllllIllIIIIIIllllIlIIl[lllllllllllllIIIllllIIIIllIIllIl] == llllllllllllllIllIIIIIIllllIlIIl[lllllllllllllIIIllllIIIIllIIllII]) ? Integer.compare(llllllllllllllIllIIIIIIllllIlIII[lllllllllllllIIIllllIIIIllIIllIl], llllllllllllllIllIIIIIIllllIlIII[lllllllllllllIIIllllIIIIllIIllII]) : Integer.compare(llllllllllllllIllIIIIIIllllIlIIl[lllllllllllllIIIllllIIIIllIIllIl], llllllllllllllIllIIIIIIllllIlIIl[lllllllllllllIIIllllIIIIllIIllII]);
            }
            
            public int compare(final Integer lllllllllllllIIIllllIIIIllIIIlII, final Integer lllllllllllllIIIllllIIIIllIIIIll) {
                return this.compare((int)lllllllllllllIIIllllIIIIllIIIlII, (int)lllllllllllllIIIllllIIIIllIIIIll);
            }
        };
        final Swapper llllllllllllllIllIIIIIIllllIIlIl = (llllllllllllllIllIIIIIIlIllIIIII, llllllllllllllIllIIIIIIlIllIIlIl) -> {
            if (llllllllllllllIllIIIIIIlIllIIIII != llllllllllllllIllIIIIIIlIllIIlIl) {
                int llllllllllllllIllIIIIIIlIllIIlII = llllllllllllllIllIIIIIIllllIlIIl[llllllllllllllIllIIIIIIlIllIIIII];
                llllllllllllllIllIIIIIIllllIlIIl[llllllllllllllIllIIIIIIlIllIIIII] = llllllllllllllIllIIIIIIllllIlIIl[llllllllllllllIllIIIIIIlIllIIlIl];
                llllllllllllllIllIIIIIIllllIlIIl[llllllllllllllIllIIIIIIlIllIIlIl] = llllllllllllllIllIIIIIIlIllIIlII;
                llllllllllllllIllIIIIIIlIllIIlII = llllllllllllllIllIIIIIIllllIlIII[llllllllllllllIllIIIIIIlIllIIIII];
                llllllllllllllIllIIIIIIllllIlIII[llllllllllllllIllIIIIIIlIllIIIII] = llllllllllllllIllIIIIIIllllIlIII[llllllllllllllIllIIIIIIlIllIIlIl];
                llllllllllllllIllIIIIIIllllIlIII[llllllllllllllIllIIIIIIlIllIIlIl] = llllllllllllllIllIIIIIIlIllIIlII;
                llllllllllllllIllIIIIIIlIllIIlII = llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIlIllIIIII];
                llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIlIllIIIII] = llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIlIllIIlIl];
                llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIlIllIIlIl] = llllllllllllllIllIIIIIIlIllIIlII;
            }
        };
        for (int llllllllllllllIllIIIIIIllllIIlII = 0; llllllllllllllIllIIIIIIllllIIlII < llllllllllllllIllIIIIIIllllIlIll; ++llllllllllllllIllIIIIIIllllIIlII) {
            llllllllllllllIllIIIIIIllllIlIlI[llllllllllllllIllIIIIIIllllIIlII] = this.field_194065_e.getInt(llllllllllllllIllIIIIIIllllIIlII);
        }
        for (int llllllllllllllIllIIIIIIllllIIIll = 1, llllllllllllllIllIIIIIIllllIIIlI = Math.min(llllllllllllllIllIIIIIIllllIlIll, this.field_194069_i); llllllllllllllIllIIIIIIllllIIIll * 2 < llllllllllllllIllIIIIIIllllIIIlI; llllllllllllllIllIIIIIIllllIIIll *= 2) {
            for (int llllllllllllllIllIIIIIIllllIIIIl = 0; llllllllllllllIllIIIIIIllllIIIIl < llllllllllllllIllIIIIIIllllIlIll; llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIllllIIIIl] = llllllllllllllIllIIIIIIllllIIIIl++) {
                llllllllllllllIllIIIIIIllllIlIIl[llllllllllllllIllIIIIIIllllIIIIl] = llllllllllllllIllIIIIIIllllIlIlI[llllllllllllllIllIIIIIIllllIIIIl];
                llllllllllllllIllIIIIIIllllIlIII[llllllllllllllIllIIIIIIllllIIIIl] = ((llllllllllllllIllIIIIIIllllIIIIl + llllllllllllllIllIIIIIIllllIIIll < llllllllllllllIllIIIIIIllllIlIll) ? llllllllllllllIllIIIIIIllllIlIlI[llllllllllllllIllIIIIIIllllIIIIl + llllllllllllllIllIIIIIIllllIIIll] : -2);
            }
            it.unimi.dsi.fastutil.Arrays.quickSort(0, llllllllllllllIllIIIIIIllllIlIll, llllllllllllllIllIIIIIIllllIIllI, llllllllllllllIllIIIIIIllllIIlIl);
            for (int llllllllllllllIllIIIIIIllllIIIII = 0; llllllllllllllIllIIIIIIllllIIIII < llllllllllllllIllIIIIIIllllIlIll; ++llllllllllllllIllIIIIIIllllIIIII) {
                if (llllllllllllllIllIIIIIIllllIIIII > 0 && llllllllllllllIllIIIIIIllllIlIIl[llllllllllllllIllIIIIIIllllIIIII] == llllllllllllllIllIIIIIIllllIlIIl[llllllllllllllIllIIIIIIllllIIIII - 1] && llllllllllllllIllIIIIIIllllIlIII[llllllllllllllIllIIIIIIllllIIIII] == llllllllllllllIllIIIIIIllllIlIII[llllllllllllllIllIIIIIIllllIIIII - 1]) {
                    llllllllllllllIllIIIIIIllllIlIlI[llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIllllIIIII]] = llllllllllllllIllIIIIIIllllIlIlI[llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIllllIIIII - 1]];
                }
                else {
                    llllllllllllllIllIIIIIIllllIlIlI[llllllllllllllIllIIIIIIllllIIlll[llllllllllllllIllIIIIIIllllIIIII]] = llllllllllllllIllIIIIIIllllIIIII;
                }
            }
        }
        final IntList llllllllllllllIllIIIIIIlllIlllll = this.field_194067_g;
        final IntList llllllllllllllIllIIIIIIlllIllllI = this.field_194068_h;
        this.field_194067_g = (IntList)new IntArrayList(llllllllllllllIllIIIIIIlllIlllll.size());
        this.field_194068_h = (IntList)new IntArrayList(llllllllllllllIllIIIIIIlllIllllI.size());
        for (final int llllllllllllllIllIIIIIIlllIlllII : llllllllllllllIllIIIIIIllllIIlll) {
            this.field_194067_g.add(llllllllllllllIllIIIIIIlllIlllll.getInt(llllllllllllllIllIIIIIIlllIlllII));
            this.field_194068_h.add(llllllllllllllIllIIIIIIlllIllllI.getInt(llllllllllllllIllIIIIIIlllIlllII));
        }
        if (SuffixArray.field_194063_c) {
            this.func_194060_b();
        }
    }
    
    private String func_194059_a(final int llllllllllllllIllIIIIIIllIlllIIl) {
        final int llllllllllllllIllIIIIIIllIllllll = this.field_194068_h.getInt(llllllllllllllIllIIIIIIllIlllIIl);
        final int llllllllllllllIllIIIIIIllIlllllI = this.field_194066_f.getInt(this.field_194067_g.getInt(llllllllllllllIllIIIIIIllIlllIIl));
        final StringBuilder llllllllllllllIllIIIIIIllIllllIl = new StringBuilder();
        for (int llllllllllllllIllIIIIIIllIllllII = 0; llllllllllllllIllIIIIIIllIlllllI + llllllllllllllIllIIIIIIllIllllII < this.field_194065_e.size(); ++llllllllllllllIllIIIIIIllIllllII) {
            if (llllllllllllllIllIIIIIIllIllllII == llllllllllllllIllIIIIIIllIllllll) {
                llllllllllllllIllIIIIIIllIllllIl.append('^');
            }
            final int llllllllllllllIllIIIIIIllIlllIll = (int)this.field_194065_e.get(llllllllllllllIllIIIIIIllIlllllI + llllllllllllllIllIIIIIIllIllllII);
            if (llllllllllllllIllIIIIIIllIlllIll == -1) {
                break;
            }
            llllllllllllllIllIIIIIIllIllllIl.append((char)llllllllllllllIllIIIIIIllIlllIll);
        }
        return llllllllllllllIllIIIIIIllIllllIl.toString();
    }
    
    public SuffixArray() {
        this.field_194061_a = (List<T>)Lists.newArrayList();
        this.field_194065_e = (IntList)new IntArrayList();
        this.field_194066_f = (IntList)new IntArrayList();
        this.field_194067_g = (IntList)new IntArrayList();
        this.field_194068_h = (IntList)new IntArrayList();
    }
    
    public void func_194057_a(final T llllllllllllllIllIIIIIlIIIIIIIlI, final String llllllllllllllIllIIIIIlIIIIIIIIl) {
        this.field_194069_i = Math.max(this.field_194069_i, llllllllllllllIllIIIIIlIIIIIIIIl.length());
        final int llllllllllllllIllIIIIIlIIIIIIIII = this.field_194061_a.size();
        this.field_194061_a.add(llllllllllllllIllIIIIIlIIIIIIIlI);
        this.field_194066_f.add(this.field_194065_e.size());
        for (int llllllllllllllIllIIIIIIlllllllll = 0; llllllllllllllIllIIIIIIlllllllll < llllllllllllllIllIIIIIlIIIIIIIIl.length(); ++llllllllllllllIllIIIIIIlllllllll) {
            this.field_194067_g.add(llllllllllllllIllIIIIIlIIIIIIIII);
            this.field_194068_h.add(llllllllllllllIllIIIIIIlllllllll);
            this.field_194065_e.add((int)llllllllllllllIllIIIIIlIIIIIIIIl.charAt(llllllllllllllIllIIIIIIlllllllll));
        }
        this.field_194067_g.add(llllllllllllllIllIIIIIlIIIIIIIII);
        this.field_194068_h.add(llllllllllllllIllIIIIIlIIIIIIIIl.length());
        this.field_194065_e.add(-1);
    }
    
    static {
        field_194062_b = Boolean.parseBoolean(System.getProperty("SuffixArray.printComparisons", "false"));
        field_194063_c = Boolean.parseBoolean(System.getProperty("SuffixArray.printArray", "false"));
        field_194064_d = LogManager.getLogger();
    }
}
