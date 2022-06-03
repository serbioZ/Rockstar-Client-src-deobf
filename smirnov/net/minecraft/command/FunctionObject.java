// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.ArrayDeque;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.advancements.FunctionManager;

public class FunctionObject
{
    private final /* synthetic */ Entry[] field_193530_b;
    
    public FunctionObject(final Entry[] lllllllllllIlllIIlllIlllllllllll) {
        this.field_193530_b = lllllllllllIlllIIlllIlllllllllll;
    }
    
    public Entry[] func_193528_a() {
        return this.field_193530_b;
    }
    
    public static FunctionObject func_193527_a(final FunctionManager lllllllllllIlllIIlllIlllllllIIlI, final List<String> lllllllllllIlllIIlllIlllllllIIIl) {
        final List<Entry> lllllllllllIlllIIlllIlllllllIIII = (List<Entry>)Lists.newArrayListWithCapacity(lllllllllllIlllIIlllIlllllllIIIl.size());
        for (String lllllllllllIlllIIlllIllllllIllll : lllllllllllIlllIIlllIlllllllIIIl) {
            lllllllllllIlllIIlllIllllllIllll = lllllllllllIlllIIlllIllllllIllll.trim();
            if (!lllllllllllIlllIIlllIllllllIllll.startsWith("#") && !lllllllllllIlllIIlllIllllllIllll.isEmpty()) {
                final String[] lllllllllllIlllIIlllIllllllIlllI = lllllllllllIlllIIlllIllllllIllll.split(" ", 2);
                final String lllllllllllIlllIIlllIllllllIllIl = lllllllllllIlllIIlllIllllllIlllI[0];
                if (!lllllllllllIlllIIlllIlllllllIIlI.func_193062_a().getCommands().containsKey(lllllllllllIlllIIlllIllllllIllIl)) {
                    if (lllllllllllIlllIIlllIllllllIllIl.startsWith("//")) {
                        throw new IllegalArgumentException("Unknown or invalid command '" + lllllllllllIlllIIlllIllllllIllIl + "' (if you intended to make a comment, use '#' not '//')");
                    }
                    if (lllllllllllIlllIIlllIllllllIllIl.startsWith("/") && lllllllllllIlllIIlllIllllllIllIl.length() > 1) {
                        throw new IllegalArgumentException("Unknown or invalid command '" + lllllllllllIlllIIlllIllllllIllIl + "' (did you mean '" + lllllllllllIlllIIlllIllllllIllIl.substring(1) + "'? Do not use a preceding forwards slash.)");
                    }
                    throw new IllegalArgumentException("Unknown or invalid command '" + lllllllllllIlllIIlllIllllllIllIl + "'");
                }
                else {
                    lllllllllllIlllIIlllIlllllllIIII.add(new CommandEntry(lllllllllllIlllIIlllIllllllIllll));
                }
            }
        }
        return new FunctionObject(lllllllllllIlllIIlllIlllllllIIII.toArray(new Entry[lllllllllllIlllIIlllIlllllllIIII.size()]));
    }
    
    public static class CacheableFunction
    {
        private /* synthetic */ boolean field_193521_c;
        private /* synthetic */ FunctionObject field_193522_d;
        @Nullable
        private final /* synthetic */ ResourceLocation field_193520_b;
        
        public CacheableFunction() {
            this.field_193520_b = null;
        }
        
        public CacheableFunction(@Nullable final ResourceLocation llllllllllllIlIlIlIIllllIIIIIlII) {
            this.field_193520_b = llllllllllllIlIlIlIIllllIIIIIlII;
        }
        
        static {
            field_193519_a = new CacheableFunction((ResourceLocation)null);
        }
        
        @Nullable
        public FunctionObject func_193518_a(final FunctionManager llllllllllllIlIlIlIIlllIlllllIlI) {
            if (!this.field_193521_c) {
                if (this.field_193520_b != null) {
                    this.field_193522_d = llllllllllllIlIlIlIIlllIlllllIlI.func_193058_a(this.field_193520_b);
                }
                this.field_193521_c = true;
            }
            return this.field_193522_d;
        }
        
        @Override
        public String toString() {
            return String.valueOf(this.field_193520_b);
        }
    }
    
    public static class FunctionEntry implements Entry
    {
        private final /* synthetic */ CacheableFunction field_193524_a;
        
        @Override
        public void func_194145_a(final FunctionManager llllllllllllIlIIIIIllllIIlllIIII, final ICommandSender llllllllllllIlIIIIIllllIIllIIlIl, final ArrayDeque<FunctionManager.QueuedCommand> llllllllllllIlIIIIIllllIIllIIlII, final int llllllllllllIlIIIIIllllIIllIIIll) {
            final FunctionObject llllllllllllIlIIIIIllllIIllIllII = this.field_193524_a.func_193518_a(llllllllllllIlIIIIIllllIIlllIIII);
            if (llllllllllllIlIIIIIllllIIllIllII != null) {
                final Entry[] llllllllllllIlIIIIIllllIIllIlIll = llllllllllllIlIIIIIllllIIllIllII.func_193528_a();
                final int llllllllllllIlIIIIIllllIIllIlIlI = llllllllllllIlIIIIIllllIIllIIIll - llllllllllllIlIIIIIllllIIllIIlII.size();
                final int llllllllllllIlIIIIIllllIIllIlIIl = Math.min(llllllllllllIlIIIIIllllIIllIlIll.length, llllllllllllIlIIIIIllllIIllIlIlI);
                for (int llllllllllllIlIIIIIllllIIllIlIII = llllllllllllIlIIIIIllllIIllIlIIl - 1; llllllllllllIlIIIIIllllIIllIlIII >= 0; --llllllllllllIlIIIIIllllIIllIlIII) {
                    llllllllllllIlIIIIIllllIIllIIlII.addFirst(new FunctionManager.QueuedCommand(llllllllllllIlIIIIIllllIIlllIIII, llllllllllllIlIIIIIllllIIllIIlIl, llllllllllllIlIIIIIllllIIllIlIll[llllllllllllIlIIIIIllllIIllIlIII]));
                }
            }
        }
        
        public FunctionEntry(final FunctionObject llllllllllllIlIIIIIllllIIllllllI) {
            this.field_193524_a = new CacheableFunction(llllllllllllIlIIIIIllllIIllllllI);
        }
        
        @Override
        public String toString() {
            return "/function " + this.field_193524_a;
        }
    }
    
    public interface Entry
    {
        void func_194145_a(final FunctionManager p0, final ICommandSender p1, final ArrayDeque<FunctionManager.QueuedCommand> p2, final int p3);
    }
    
    public static class CommandEntry implements Entry
    {
        private final /* synthetic */ String field_193525_a;
        
        @Override
        public void func_194145_a(final FunctionManager llllllllllllIIIIIIllIIIIIllIIIIl, final ICommandSender llllllllllllIIIIIIllIIIIIllIIIII, final ArrayDeque<FunctionManager.QueuedCommand> llllllllllllIIIIIIllIIIIIlIlllll, final int llllllllllllIIIIIIllIIIIIlIllllI) {
            llllllllllllIIIIIIllIIIIIllIIIIl.func_193062_a().executeCommand(llllllllllllIIIIIIllIIIIIllIIIII, this.field_193525_a);
        }
        
        public CommandEntry(final String llllllllllllIIIIIIllIIIIIllIlIII) {
            this.field_193525_a = llllllllllllIIIIIIllIIIIIllIlIII;
        }
        
        @Override
        public String toString() {
            return "/" + this.field_193525_a;
        }
    }
}
