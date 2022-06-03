// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.crash;

import com.google.common.collect.Lists;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import java.util.List;

public class CrashReportCategory
{
    private final /* synthetic */ String name;
    private /* synthetic */ StackTraceElement[] stackTrace;
    private final /* synthetic */ List<Entry> children;
    private final /* synthetic */ CrashReport crashReport;
    
    public static void addBlockInfo(final CrashReportCategory llIIlIIIlIllIII, final BlockPos llIIlIIIlIlllII, final Block llIIlIIIlIllIll, final int llIIlIIIlIlIlIl) {
        final int llIIlIIIlIllIIl = Block.getIdFromBlock(llIIlIIIlIllIll);
        llIIlIIIlIllIII.setDetail("Block type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                try {
                    return String.format("ID #%d (%s // %s)", llIIlIIIlIllIIl, llIIlIIIlIllIll.getUnlocalizedName(), llIIlIIIlIllIll.getClass().getCanonicalName());
                }
                catch (Throwable lllllllllllIIIlIllIIIIIIIllIlIIl) {
                    return "ID #" + llIIlIIIlIllIIl;
                }
            }
        });
        llIIlIIIlIllIII.setDetail("Block data value", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                if (llIIlIIIlIlIlIl < 0) {
                    return "Unknown? (Got " + llIIlIIIlIlIlIl + ")";
                }
                final String lllllllllllIlllIlIIllIllIIlllllI = String.format("%4s", Integer.toBinaryString(llIIlIIIlIlIlIl)).replace(" ", "0");
                return String.format("%1$d / 0x%1$X / 0b%2$s", llIIlIIIlIlIlIl, lllllllllllIlllIlIIllIllIIlllllI);
            }
        });
        llIIlIIIlIllIII.setDetail("Block location", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return CrashReportCategory.getCoordinateInfo(llIIlIIIlIlllII);
            }
        });
    }
    
    public void addCrashSection(final String llIIlIIlIlIIIIl, final Object llIIlIIlIIlllIl) {
        this.children.add(new Entry(llIIlIIlIlIIIIl, llIIlIIlIIlllIl));
    }
    
    public void appendToStringBuilder(final StringBuilder llIIlIIIllIlllI) {
        llIIlIIIllIlllI.append("-- ").append(this.name).append(" --\n");
        llIIlIIIllIlllI.append("Details:");
        for (final Entry llIIlIIIllIllIl : this.children) {
            llIIlIIIllIlllI.append("\n\t");
            llIIlIIIllIlllI.append(llIIlIIIllIllIl.getKey());
            llIIlIIIllIlllI.append(": ");
            llIIlIIIllIlllI.append(llIIlIIIllIllIl.getValue());
        }
        if (this.stackTrace != null && this.stackTrace.length > 0) {
            llIIlIIIllIlllI.append("\nStacktrace:");
            final float llIIlIIIllIIllI;
            final short llIIlIIIllIIlll = (short)((StackTraceElement[])(Object)(llIIlIIIllIIllI = (float)(Object)this.stackTrace)).length;
            for (double llIIlIIIllIlIII = 0; llIIlIIIllIlIII < llIIlIIIllIIlll; ++llIIlIIIllIlIII) {
                final StackTraceElement llIIlIIIllIllII = llIIlIIIllIIllI[llIIlIIIllIlIII];
                llIIlIIIllIlllI.append("\n\tat ");
                llIIlIIIllIlllI.append(llIIlIIIllIllII);
            }
        }
    }
    
    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }
    
    public static String getCoordinateInfo(final BlockPos llIIlIIlllIlIIl) {
        return getCoordinateInfo(llIIlIIlllIlIIl.getX(), llIIlIIlllIlIIl.getY(), llIIlIIlllIlIIl.getZ());
    }
    
    public void setDetail(final String llIIlIIlIlIlIII, final ICrashReportDetail<String> llIIlIIlIlIlIll) {
        try {
            this.addCrashSection(llIIlIIlIlIlIII, llIIlIIlIlIlIll.call());
        }
        catch (Throwable llIIlIIlIlIlIlI) {
            this.addCrashSectionThrowable(llIIlIIlIlIlIII, llIIlIIlIlIlIlI);
        }
    }
    
    public void addCrashSectionThrowable(final String llIIlIIlIIllIII, final Throwable llIIlIIlIIlIlll) {
        this.addCrashSection(llIIlIIlIIllIII, llIIlIIlIIlIlll);
    }
    
    public static void addBlockInfo(final CrashReportCategory llIIlIIIlIIllIl, final BlockPos llIIlIIIlIIllII, final IBlockState llIIlIIIlIIlllI) {
        llIIlIIIlIIllIl.setDetail("Block", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return llIIlIIIlIIlllI.toString();
            }
        });
        llIIlIIIlIIllIl.setDetail("Block location", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return CrashReportCategory.getCoordinateInfo(llIIlIIIlIIllII);
            }
        });
    }
    
    public static String getCoordinateInfo(final int llIIlIIlIllllll, final int llIIlIIlIlllllI, final int llIIlIIllIlIlll) {
        final StringBuilder llIIlIIllIlIllI = new StringBuilder();
        try {
            llIIlIIllIlIllI.append(String.format("World: (%d,%d,%d)", llIIlIIlIllllll, llIIlIIlIlllllI, llIIlIIllIlIlll));
        }
        catch (Throwable llIIlIIllIlIlIl) {
            llIIlIIllIlIllI.append("(Error finding world loc)");
        }
        llIIlIIllIlIllI.append(", ");
        try {
            final int llIIlIIllIlIlII = llIIlIIlIllllll >> 4;
            final int llIIlIIllIlIIll = llIIlIIllIlIlll >> 4;
            final int llIIlIIllIlIIlI = llIIlIIlIllllll & 0xF;
            final int llIIlIIllIlIIIl = llIIlIIlIlllllI >> 4;
            final int llIIlIIllIlIIII = llIIlIIllIlIlll & 0xF;
            final int llIIlIIllIIllll = llIIlIIllIlIlII << 4;
            final int llIIlIIllIIlllI = llIIlIIllIlIIll << 4;
            final int llIIlIIllIIllIl = (llIIlIIllIlIlII + 1 << 4) - 1;
            final int llIIlIIllIIllII = (llIIlIIllIlIIll + 1 << 4) - 1;
            llIIlIIllIlIllI.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", llIIlIIllIlIIlI, llIIlIIllIlIIIl, llIIlIIllIlIIII, llIIlIIllIlIlII, llIIlIIllIlIIll, llIIlIIllIIllll, llIIlIIllIIlllI, llIIlIIllIIllIl, llIIlIIllIIllII));
        }
        catch (Throwable llIIlIIllIIlIll) {
            llIIlIIllIlIllI.append("(Error finding chunk loc)");
        }
        llIIlIIllIlIllI.append(", ");
        try {
            final int llIIlIIllIIlIlI = llIIlIIlIllllll >> 9;
            final int llIIlIIllIIlIIl = llIIlIIllIlIlll >> 9;
            final int llIIlIIllIIlIII = llIIlIIllIIlIlI << 5;
            final int llIIlIIllIIIlll = llIIlIIllIIlIIl << 5;
            final int llIIlIIllIIIllI = (llIIlIIllIIlIlI + 1 << 5) - 1;
            final int llIIlIIllIIIlIl = (llIIlIIllIIlIIl + 1 << 5) - 1;
            final int llIIlIIllIIIlII = llIIlIIllIIlIlI << 9;
            final int llIIlIIllIIIIll = llIIlIIllIIlIIl << 9;
            final int llIIlIIllIIIIlI = (llIIlIIllIIlIlI + 1 << 9) - 1;
            final int llIIlIIllIIIIIl = (llIIlIIllIIlIIl + 1 << 9) - 1;
            llIIlIIllIlIllI.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", llIIlIIllIIlIlI, llIIlIIllIIlIIl, llIIlIIllIIlIII, llIIlIIllIIIlll, llIIlIIllIIIllI, llIIlIIllIIIlIl, llIIlIIllIIIlII, llIIlIIllIIIIll, llIIlIIllIIIIlI, llIIlIIllIIIIIl));
        }
        catch (Throwable llIIlIIllIIIIII) {
            llIIlIIllIlIllI.append("(Error finding world loc)");
        }
        return llIIlIIllIlIllI.toString();
    }
    
    public CrashReportCategory(final CrashReport llIIlIIlllllIII, final String llIIlIIllllIlll) {
        this.children = (List<Entry>)Lists.newArrayList();
        this.stackTrace = new StackTraceElement[0];
        this.crashReport = llIIlIIlllllIII;
        this.name = llIIlIIllllIlll;
    }
    
    public void trimStackTraceEntriesFromBottom(final int llIIlIIIllllIlI) {
        final StackTraceElement[] llIIlIIIllllIIl = new StackTraceElement[this.stackTrace.length - llIIlIIIllllIlI];
        System.arraycopy(this.stackTrace, 0, llIIlIIIllllIIl, 0, llIIlIIIllllIIl.length);
        this.stackTrace = llIIlIIIllllIIl;
    }
    
    public boolean firstTwoElementsOfStackTraceMatch(final StackTraceElement llIIlIIlIIIIIIl, final StackTraceElement llIIlIIlIIIIIII) {
        if (this.stackTrace.length == 0 || llIIlIIlIIIIIIl == null) {
            return false;
        }
        final StackTraceElement llIIlIIlIIIIIll = this.stackTrace[0];
        if (llIIlIIlIIIIIll.isNativeMethod() != llIIlIIlIIIIIIl.isNativeMethod() || !llIIlIIlIIIIIll.getClassName().equals(llIIlIIlIIIIIIl.getClassName()) || !llIIlIIlIIIIIll.getFileName().equals(llIIlIIlIIIIIIl.getFileName()) || !llIIlIIlIIIIIll.getMethodName().equals(llIIlIIlIIIIIIl.getMethodName())) {
            return false;
        }
        if (llIIlIIlIIIIIII != null != this.stackTrace.length > 1) {
            return false;
        }
        if (llIIlIIlIIIIIII != null && !this.stackTrace[1].equals(llIIlIIlIIIIIII)) {
            return false;
        }
        this.stackTrace[0] = llIIlIIlIIIIIIl;
        return true;
    }
    
    public int getPrunedStackTrace(final int llIIlIIlIIIllll) {
        final StackTraceElement[] llIIlIIlIIIlllI = Thread.currentThread().getStackTrace();
        if (llIIlIIlIIIlllI.length <= 0) {
            return 0;
        }
        this.stackTrace = new StackTraceElement[llIIlIIlIIIlllI.length - 3 - llIIlIIlIIIllll];
        System.arraycopy(llIIlIIlIIIlllI, 3 + llIIlIIlIIIllll, this.stackTrace, 0, this.stackTrace.length);
        return this.stackTrace.length;
    }
    
    public static String getCoordinateInfo(final double llIIlIIlllIllIl, final double llIIlIIlllIllll, final double llIIlIIlllIlIll) {
        return String.format("%.2f,%.2f,%.2f - %s", llIIlIIlllIllIl, llIIlIIlllIllll, llIIlIIlllIlIll, getCoordinateInfo(new BlockPos(llIIlIIlllIllIl, llIIlIIlllIllll, llIIlIIlllIlIll)));
    }
    
    static class Entry
    {
        private final /* synthetic */ String key;
        private final /* synthetic */ String value;
        
        public Entry(final String lllllllllllIIIlIIlIIlllIIIIIlIII, final Object lllllllllllIIIlIIlIIlllIIIIIIlll) {
            this.key = lllllllllllIIIlIIlIIlllIIIIIlIII;
            if (lllllllllllIIIlIIlIIlllIIIIIIlll == null) {
                this.value = "~~NULL~~";
            }
            else if (lllllllllllIIIlIIlIIlllIIIIIIlll instanceof Throwable) {
                final Throwable lllllllllllIIIlIIlIIlllIIIIIlIlI = (Throwable)lllllllllllIIIlIIlIIlllIIIIIIlll;
                this.value = "~~ERROR~~ " + lllllllllllIIIlIIlIIlllIIIIIlIlI.getClass().getSimpleName() + ": " + lllllllllllIIIlIIlIIlllIIIIIlIlI.getMessage();
            }
            else {
                this.value = lllllllllllIIIlIIlIIlllIIIIIIlll.toString();
            }
        }
        
        public String getValue() {
            return this.value;
        }
        
        public String getKey() {
            return this.key;
        }
    }
}
