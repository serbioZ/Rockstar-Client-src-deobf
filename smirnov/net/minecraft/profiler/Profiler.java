// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.profiler;

import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Maps;
import java.util.function.Supplier;
import net.minecraft.client.renderer.GlStateManager;
import optifine.Config;
import optifine.Lagometer;
import java.util.Iterator;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Profiler
{
    private static final /* synthetic */ int HASH_DISPLAY;
    private final /* synthetic */ List<Long> timestampList;
    private /* synthetic */ String profilingSection;
    private static final /* synthetic */ int HASH_SCHEDULED_EXECUTABLES;
    public /* synthetic */ boolean profilingEnabled;
    private static final /* synthetic */ int HASH_PRE_RENDER_ERRORS;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ boolean profilerGlobalEnabled;
    private static final /* synthetic */ int HASH_TICK;
    private /* synthetic */ boolean profilerLocalEnabled;
    private final /* synthetic */ List<String> sectionList;
    private final /* synthetic */ Map<String, Long> profilingMap;
    private static final /* synthetic */ int HASH_RENDER;
    
    public List<Result> getProfilingData(String lllllllllllIllIlIlllllIllllIlIlI) {
        if (!this.profilingEnabled) {
            return Collections.emptyList();
        }
        long lllllllllllIllIlIlllllIlllllIlll = this.profilingMap.containsKey("root") ? this.profilingMap.get("root") : 0L;
        final long lllllllllllIllIlIlllllIlllllIllI = this.profilingMap.containsKey(lllllllllllIllIlIlllllIllllIlIlI) ? this.profilingMap.get(lllllllllllIllIlIlllllIllllIlIlI) : -1L;
        final List<Result> lllllllllllIllIlIlllllIlllllIlIl = (List<Result>)Lists.newArrayList();
        if (!((String)lllllllllllIllIlIlllllIllllIlIlI).isEmpty()) {
            lllllllllllIllIlIlllllIllllIlIlI = String.valueOf(lllllllllllIllIlIlllllIllllIlIlI) + ".";
        }
        long lllllllllllIllIlIlllllIlllllIlII = 0L;
        for (final String lllllllllllIllIlIlllllIlllllIIll : this.profilingMap.keySet()) {
            if (lllllllllllIllIlIlllllIlllllIIll.length() > ((String)lllllllllllIllIlIlllllIllllIlIlI).length() && lllllllllllIllIlIlllllIlllllIIll.startsWith((String)lllllllllllIllIlIlllllIllllIlIlI) && lllllllllllIllIlIlllllIlllllIIll.indexOf(".", ((String)lllllllllllIllIlIlllllIllllIlIlI).length() + 1) < 0) {
                lllllllllllIllIlIlllllIlllllIlII += this.profilingMap.get(lllllllllllIllIlIlllllIlllllIIll);
            }
        }
        final float lllllllllllIllIlIlllllIlllllIIlI = (float)lllllllllllIllIlIlllllIlllllIlII;
        if (lllllllllllIllIlIlllllIlllllIlII < lllllllllllIllIlIlllllIlllllIllI) {
            lllllllllllIllIlIlllllIlllllIlII = lllllllllllIllIlIlllllIlllllIllI;
        }
        if (lllllllllllIllIlIlllllIlllllIlll < lllllllllllIllIlIlllllIlllllIlII) {
            lllllllllllIllIlIlllllIlllllIlll = lllllllllllIllIlIlllllIlllllIlII;
        }
        for (final String lllllllllllIllIlIlllllIlllllIIIl : this.profilingMap.keySet()) {
            if (lllllllllllIllIlIlllllIlllllIIIl.length() > ((String)lllllllllllIllIlIlllllIllllIlIlI).length() && lllllllllllIllIlIlllllIlllllIIIl.startsWith((String)lllllllllllIllIlIlllllIllllIlIlI) && lllllllllllIllIlIlllllIlllllIIIl.indexOf(".", ((String)lllllllllllIllIlIlllllIllllIlIlI).length() + 1) < 0) {
                final long lllllllllllIllIlIlllllIlllllIIII = this.profilingMap.get(lllllllllllIllIlIlllllIlllllIIIl);
                final double lllllllllllIllIlIlllllIllllIllll = lllllllllllIllIlIlllllIlllllIIII * 100.0 / lllllllllllIllIlIlllllIlllllIlII;
                final double lllllllllllIllIlIlllllIllllIlllI = lllllllllllIllIlIlllllIlllllIIII * 100.0 / lllllllllllIllIlIlllllIlllllIlll;
                final String lllllllllllIllIlIlllllIllllIllIl = lllllllllllIllIlIlllllIlllllIIIl.substring(((String)lllllllllllIllIlIlllllIllllIlIlI).length());
                lllllllllllIllIlIlllllIlllllIlIl.add(new Result(lllllllllllIllIlIlllllIllllIllIl, lllllllllllIllIlIlllllIllllIllll, lllllllllllIllIlIlllllIllllIlllI));
            }
        }
        for (final String lllllllllllIllIlIlllllIllllIllII : this.profilingMap.keySet()) {
            this.profilingMap.put(lllllllllllIllIlIlllllIllllIllII, this.profilingMap.get(lllllllllllIllIlIlllllIllllIllII) * 950L / 1000L);
        }
        if (lllllllllllIllIlIlllllIlllllIlII > lllllllllllIllIlIlllllIlllllIIlI) {
            lllllllllllIllIlIlllllIlllllIlIl.add(new Result("unspecified", (lllllllllllIllIlIlllllIlllllIlII - lllllllllllIllIlIlllllIlllllIIlI) * 100.0 / lllllllllllIllIlIlllllIlllllIlII, (lllllllllllIllIlIlllllIlllllIlII - lllllllllllIllIlIlllllIlllllIIlI) * 100.0 / lllllllllllIllIlIlllllIlllllIlll));
        }
        Collections.sort(lllllllllllIllIlIlllllIlllllIlIl);
        lllllllllllIllIlIlllllIlllllIlIl.add(0, new Result((String)lllllllllllIllIlIlllllIllllIlIlI, 100.0, lllllllllllIllIlIlllllIlllllIlII * 100.0 / lllllllllllIllIlIlllllIlllllIlll));
        return lllllllllllIllIlIlllllIlllllIlIl;
    }
    
    public void startSection(final String lllllllllllIllIlIllllllIIIIllllI) {
        if (Lagometer.isActive()) {
            final int lllllllllllIllIlIllllllIIIIlllIl = lllllllllllIllIlIllllllIIIIllllI.hashCode();
            if (lllllllllllIllIlIllllllIIIIlllIl == Profiler.HASH_SCHEDULED_EXECUTABLES && lllllllllllIllIlIllllllIIIIllllI.equals("scheduledExecutables")) {
                Lagometer.timerScheduledExecutables.start();
            }
            else if (lllllllllllIllIlIllllllIIIIlllIl == Profiler.HASH_TICK && lllllllllllIllIlIllllllIIIIllllI.equals("tick") && Config.isMinecraftThread()) {
                Lagometer.timerScheduledExecutables.end();
                Lagometer.timerTick.start();
            }
            else if (lllllllllllIllIlIllllllIIIIlllIl == Profiler.HASH_PRE_RENDER_ERRORS && lllllllllllIllIlIllllllIIIIllllI.equals("preRenderErrors")) {
                Lagometer.timerTick.end();
            }
        }
        if (Config.isFastRender()) {
            final int lllllllllllIllIlIllllllIIIIlllII = lllllllllllIllIlIllllllIIIIllllI.hashCode();
            if (lllllllllllIllIlIllllllIIIIlllII == Profiler.HASH_RENDER && lllllllllllIllIlIllllllIIIIllllI.equals("render")) {
                GlStateManager.clearEnabled = false;
            }
            else if (lllllllllllIllIlIllllllIIIIlllII == Profiler.HASH_DISPLAY && lllllllllllIllIlIllllllIIIIllllI.equals("display")) {
                GlStateManager.clearEnabled = true;
            }
        }
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            if (!this.profilingSection.isEmpty()) {
                this.profilingSection = String.valueOf(this.profilingSection) + ".";
            }
            this.profilingSection = String.valueOf(this.profilingSection) + lllllllllllIllIlIllllllIIIIllllI;
            this.sectionList.add(this.profilingSection);
            this.timestampList.add(System.nanoTime());
        }
    }
    
    public void func_194340_a(final Supplier<String> lllllllllllIllIlIllllllIIIIlIIll) {
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            this.startSection(lllllllllllIllIlIllllllIIIIlIIll.get());
        }
    }
    
    public void startSection(final Class<?> lllllllllllIllIlIlllllIlllIIllII) {
        if (this.profilingEnabled) {
            this.startSection(lllllllllllIllIlIlllllIlllIIllII.getSimpleName());
        }
    }
    
    public Profiler() {
        this.sectionList = (List<String>)Lists.newArrayList();
        this.timestampList = (List<Long>)Lists.newArrayList();
        this.profilingSection = "";
        this.profilingMap = (Map<String, Long>)Maps.newHashMap();
        this.profilerGlobalEnabled = true;
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
    }
    
    public void clearProfiling() {
        this.profilingMap.clear();
        this.profilingSection = "";
        this.sectionList.clear();
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
    }
    
    static {
        DISPLAY = "display";
        SCHEDULED_EXECUTABLES = "scheduledExecutables";
        RENDER = "render";
        TICK = "tick";
        PRE_RENDER_ERRORS = "preRenderErrors";
        LOGGER = LogManager.getLogger();
        HASH_SCHEDULED_EXECUTABLES = "scheduledExecutables".hashCode();
        HASH_TICK = "tick".hashCode();
        HASH_PRE_RENDER_ERRORS = "preRenderErrors".hashCode();
        HASH_RENDER = "render".hashCode();
        HASH_DISPLAY = "display".hashCode();
    }
    
    public void endStartSection(final String lllllllllllIllIlIlllllIlllIllIll) {
        if (this.profilerLocalEnabled) {
            this.endSection();
            this.startSection(lllllllllllIllIlIlllllIlllIllIll);
        }
    }
    
    public void endSection() {
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            final long lllllllllllIllIlIllllllIIIIIllIl = System.nanoTime();
            final long lllllllllllIllIlIllllllIIIIIllII = this.timestampList.remove(this.timestampList.size() - 1);
            this.sectionList.remove(this.sectionList.size() - 1);
            final long lllllllllllIllIlIllllllIIIIIlIll = lllllllllllIllIlIllllllIIIIIllIl - lllllllllllIllIlIllllllIIIIIllII;
            if (this.profilingMap.containsKey(this.profilingSection)) {
                this.profilingMap.put(this.profilingSection, this.profilingMap.get(this.profilingSection) + lllllllllllIllIlIllllllIIIIIlIll);
            }
            else {
                this.profilingMap.put(this.profilingSection, lllllllllllIllIlIllllllIIIIIlIll);
            }
            if (lllllllllllIllIlIllllllIIIIIlIll > 100000000L) {
                Profiler.LOGGER.warn("Something's taking too long! '{}' took aprox {} ms", (Object)this.profilingSection, (Object)(lllllllllllIllIlIllllllIIIIIlIll / 1000000.0));
            }
            this.profilingSection = (this.sectionList.isEmpty() ? "" : this.sectionList.get(this.sectionList.size() - 1));
        }
    }
    
    public void func_194339_b(final Supplier<String> lllllllllllIllIlIlllllIlllIlIlIl) {
        if (this.profilerLocalEnabled) {
            this.endSection();
            this.func_194340_a(lllllllllllIllIlIlllllIlllIlIlIl);
        }
    }
    
    public String getNameOfLastSection() {
        return this.sectionList.isEmpty() ? "[UNKNOWN]" : this.sectionList.get(this.sectionList.size() - 1);
    }
    
    public static final class Result implements Comparable<Result>
    {
        public /* synthetic */ String profilerName;
        public /* synthetic */ double totalUsePercentage;
        public /* synthetic */ double usePercentage;
        
        @Override
        public int compareTo(final Result lllllllllllIIlIlllIIlIlIIIIllIlI) {
            if (lllllllllllIIlIlllIIlIlIIIIllIlI.usePercentage < this.usePercentage) {
                return -1;
            }
            return (lllllllllllIIlIlllIIlIlIIIIllIlI.usePercentage > this.usePercentage) ? 1 : lllllllllllIIlIlllIIlIlIIIIllIlI.profilerName.compareTo(this.profilerName);
        }
        
        public Result(final String lllllllllllIIlIlllIIlIlIIIlIIlII, final double lllllllllllIIlIlllIIlIlIIIlIIIll, final double lllllllllllIIlIlllIIlIlIIIIllllI) {
            this.profilerName = lllllllllllIIlIlllIIlIlIIIlIIlII;
            this.usePercentage = lllllllllllIIlIlllIIlIlIIIlIIIll;
            this.totalUsePercentage = lllllllllllIIlIlllIIlIlIIIIllllI;
        }
        
        public int getColor() {
            return (this.profilerName.hashCode() & 0xAAAAAA) + 4473924;
        }
    }
}
