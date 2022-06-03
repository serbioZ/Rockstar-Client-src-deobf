// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.crash;

import java.util.Date;
import java.text.SimpleDateFormat;
import optifine.CrashReporter;
import org.apache.commons.lang3.ArrayUtils;
import com.google.common.collect.Lists;
import net.minecraft.util.ReportedException;
import optifine.Reflector;
import net.minecraft.world.gen.layer.IntCache;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ManagementFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.IOUtils;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.File;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class CrashReport
{
    private final /* synthetic */ List<CrashReportCategory> crashReportSections;
    private /* synthetic */ StackTraceElement[] stacktrace;
    private final /* synthetic */ String description;
    private /* synthetic */ File crashReportFile;
    private final /* synthetic */ Throwable cause;
    private /* synthetic */ boolean firstCategoryInCrashReport;
    private /* synthetic */ boolean reported;
    private final /* synthetic */ CrashReportCategory theReportCategory;
    
    public String getCauseStackTraceOrString() {
        StringWriter lllllllllllIllIIlIIlIIllllIIlIIl = null;
        PrintWriter lllllllllllIllIIlIIlIIllllIIlIII = null;
        Throwable lllllllllllIllIIlIIlIIllllIIIlll = this.cause;
        if (lllllllllllIllIIlIIlIIllllIIIlll.getMessage() == null) {
            if (lllllllllllIllIIlIIlIIllllIIIlll instanceof NullPointerException) {
                lllllllllllIllIIlIIlIIllllIIIlll = new NullPointerException(this.description);
            }
            else if (lllllllllllIllIIlIIlIIllllIIIlll instanceof StackOverflowError) {
                lllllllllllIllIIlIIlIIllllIIIlll = new StackOverflowError(this.description);
            }
            else if (lllllllllllIllIIlIIlIIllllIIIlll instanceof OutOfMemoryError) {
                lllllllllllIllIIlIIlIIllllIIIlll = new OutOfMemoryError(this.description);
            }
            lllllllllllIllIIlIIlIIllllIIIlll.setStackTrace(this.cause.getStackTrace());
        }
        String lllllllllllIllIIlIIlIIllllIIIllI = lllllllllllIllIIlIIlIIllllIIIlll.toString();
        try {
            lllllllllllIllIIlIIlIIllllIIlIIl = new StringWriter();
            lllllllllllIllIIlIIlIIllllIIlIII = new PrintWriter(lllllllllllIllIIlIIlIIllllIIlIIl);
            lllllllllllIllIIlIIlIIllllIIIlll.printStackTrace(lllllllllllIllIIlIIlIIllllIIlIII);
            lllllllllllIllIIlIIlIIllllIIIllI = lllllllllllIllIIlIIlIIllllIIlIIl.toString();
        }
        finally {
            IOUtils.closeQuietly((Writer)lllllllllllIllIIlIIlIIllllIIlIIl);
            IOUtils.closeQuietly((Writer)lllllllllllIllIIlIIlIIllllIIlIII);
        }
        IOUtils.closeQuietly((Writer)lllllllllllIllIIlIIlIIllllIIlIIl);
        IOUtils.closeQuietly((Writer)lllllllllllIllIIlIIlIIllllIIlIII);
        return lllllllllllIllIIlIIlIIllllIIIllI;
    }
    
    private static String getWittyComment() {
        final String[] lllllllllllIllIIlIIlIIllIlllIIlI = { "Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };
        try {
            return lllllllllllIllIIlIIlIIllIlllIIlI[(int)(System.nanoTime() % lllllllllllIllIIlIIlIIllIlllIIlI.length)];
        }
        catch (Throwable lllllllllllIllIIlIIlIIllIlllIIIl) {
            return "Witty comment unavailable :(";
        }
    }
    
    public boolean saveToFile(final File lllllllllllIllIIlIIlIIlllIlIlIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/crash/CrashReport.crashReportFile:Ljava/io/File;
        //     4: ifnull          9
        //     7: iconst_0       
        //     8: ireturn        
        //     9: aload_1         /* lllllllllllIllIIlIIlIIlllIlIIIlI */
        //    10: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //    13: ifnull          24
        //    16: aload_1         /* lllllllllllIllIIlIIlIIlllIlIIIlI */
        //    17: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //    20: invokevirtual   java/io/File.mkdirs:()Z
        //    23: pop            
        //    24: aconst_null    
        //    25: astore_2        /* lllllllllllIllIIlIIlIIlllIlIlIIl */
        //    26: new             Ljava/io/OutputStreamWriter;
        //    29: dup            
        //    30: new             Ljava/io/FileOutputStream;
        //    33: dup            
        //    34: aload_1         /* lllllllllllIllIIlIIlIIlllIlIIIlI */
        //    35: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    38: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    41: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
        //    44: astore_2        /* lllllllllllIllIIlIIlIIlllIlIlIIl */
        //    45: aload_2         /* lllllllllllIllIIlIIlIIlllIlIlIIl */
        //    46: aload_0         /* lllllllllllIllIIlIIlIIlllIlIIIll */
        //    47: invokevirtual   net/minecraft/crash/CrashReport.getCompleteReport:()Ljava/lang/String;
        //    50: invokevirtual   java/io/Writer.write:(Ljava/lang/String;)V
        //    53: aload_0         /* lllllllllllIllIIlIIlIIlllIlIIIll */
        //    54: aload_1         /* lllllllllllIllIIlIIlIIlllIlIIIlI */
        //    55: putfield        net/minecraft/crash/CrashReport.crashReportFile:Ljava/io/File;
        //    58: iconst_1       
        //    59: istore          lllllllllllIllIIlIIlIIlllIlIIllI
        //    61: iload           lllllllllllIllIIlIIlIIlllIlIIllI
        //    63: istore          lllllllllllIllIIlIIlIIlllIlIIlIl
        //    65: iload           lllllllllllIllIIlIIlIIlllIlIIlIl
        //    67: istore          lllllllllllIllIIlIIlIIlllIIlllII
        //    69: aload_2         /* lllllllllllIllIIlIIlIIlllIlIlIIl */
        //    70: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Writer;)V
        //    73: iload           lllllllllllIllIIlIIlIIlllIIlllII
        //    75: ireturn        
        //    76: astore          lllllllllllIllIIlIIlIIlllIlIIlII
        //    78: getstatic       net/minecraft/crash/CrashReport.LOGGER:Lorg/apache/logging/log4j/Logger;
        //    81: ldc             "Could not save crash report to {}"
        //    83: aload_1         /* lllllllllllIllIIlIIlIIlllIlIIIlI */
        //    84: aload           lllllllllllIllIIlIIlIIlllIlIIlII
        //    86: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    91: iconst_0       
        //    92: istore_3        /* lllllllllllIllIIlIIlIIlllIlIlIII */
        //    93: aload_2         /* lllllllllllIllIIlIIlIIlllIlIlIIl */
        //    94: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Writer;)V
        //    97: goto            109
        //   100: astore          lllllllllllIllIIlIIlIIlllIIlllIl
        //   102: aload_2         /* lllllllllllIllIIlIIlIIlllIlIlIIl */
        //   103: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Writer;)V
        //   106: aload           lllllllllllIllIIlIIlIIlllIIlllIl
        //   108: athrow         
        //   109: iload_3         /* lllllllllllIllIIlIIlIIlllIlIIlll */
        //   110: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  26     69     76     100    Ljava/lang/Throwable;
        //  26     69     100    109    Any
        //  76     93     100    109    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private void populateEnvironment() {
        this.theReportCategory.setDetail("Minecraft Version", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return "1.12.2";
            }
        });
        this.theReportCategory.setDetail("Operating System", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(System.getProperty("os.name")) + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
            }
        });
        this.theReportCategory.setDetail("Java Version", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(System.getProperty("java.version")) + ", " + System.getProperty("java.vendor");
            }
        });
        this.theReportCategory.setDetail("Java VM Version", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(System.getProperty("java.vm.name")) + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
            }
        });
        this.theReportCategory.setDetail("Memory", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                final Runtime lllllllllllIlllIIIIIllIIIllIIlII = Runtime.getRuntime();
                final long lllllllllllIlllIIIIIllIIIllIIIll = lllllllllllIlllIIIIIllIIIllIIlII.maxMemory();
                final long lllllllllllIlllIIIIIllIIIllIIIlI = lllllllllllIlllIIIIIllIIIllIIlII.totalMemory();
                final long lllllllllllIlllIIIIIllIIIllIIIIl = lllllllllllIlllIIIIIllIIIllIIlII.freeMemory();
                final long lllllllllllIlllIIIIIllIIIllIIIII = lllllllllllIlllIIIIIllIIIllIIIll / 1024L / 1024L;
                final long lllllllllllIlllIIIIIllIIIlIlllll = lllllllllllIlllIIIIIllIIIllIIIlI / 1024L / 1024L;
                final long lllllllllllIlllIIIIIllIIIlIllllI = lllllllllllIlllIIIIIllIIIllIIIIl / 1024L / 1024L;
                return String.valueOf(lllllllllllIlllIIIIIllIIIllIIIIl) + " bytes (" + lllllllllllIlllIIIIIllIIIlIllllI + " MB) / " + lllllllllllIlllIIIIIllIIIllIIIlI + " bytes (" + lllllllllllIlllIIIIIllIIIlIlllll + " MB) up to " + lllllllllllIlllIIIIIllIIIllIIIll + " bytes (" + lllllllllllIlllIIIIIllIIIllIIIII + " MB)";
            }
        });
        this.theReportCategory.setDetail("JVM Flags", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                final RuntimeMXBean lllllllllllIllIIIIIlIlllllllIIII = ManagementFactory.getRuntimeMXBean();
                final List<String> lllllllllllIllIIIIIlIllllllIllll = lllllllllllIllIIIIIlIlllllllIIII.getInputArguments();
                int lllllllllllIllIIIIIlIllllllIlllI = 0;
                final StringBuilder lllllllllllIllIIIIIlIllllllIllIl = new StringBuilder();
                for (final String lllllllllllIllIIIIIlIllllllIllII : lllllllllllIllIIIIIlIllllllIllll) {
                    if (lllllllllllIllIIIIIlIllllllIllII.startsWith("-X")) {
                        if (lllllllllllIllIIIIIlIllllllIlllI++ > 0) {
                            lllllllllllIllIIIIIlIllllllIllIl.append(" ");
                        }
                        lllllllllllIllIIIIIlIllllllIllIl.append(lllllllllllIllIIIIIlIllllllIllII);
                    }
                }
                return String.format("%d total; %s", lllllllllllIllIIIIIlIllllllIlllI, lllllllllllIllIIIIIlIllllllIllIl.toString());
            }
        });
        this.theReportCategory.setDetail("IntCache", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return IntCache.getCacheSizes();
            }
        });
        if (Reflector.FMLCommonHandler_enhanceCrashReport.exists()) {
            final Object lllllllllllIllIIlIIlIIlllllIlIIl = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            Reflector.callString(lllllllllllIllIIlIIlIIlllllIlIIl, Reflector.FMLCommonHandler_enhanceCrashReport, new Object[] { this, this.theReportCategory });
        }
    }
    
    public CrashReportCategory getCategory() {
        return this.theReportCategory;
    }
    
    public static CrashReport makeCrashReport(final Throwable lllllllllllIllIIlIIlIIllIllIlIll, final String lllllllllllIllIIlIIlIIllIllIIllI) {
        CrashReport lllllllllllIllIIlIIlIIllIllIlIII = null;
        if (lllllllllllIllIIlIIlIIllIllIlIll instanceof ReportedException) {
            final CrashReport lllllllllllIllIIlIIlIIllIllIlIIl = ((ReportedException)lllllllllllIllIIlIIlIIllIllIlIll).getCrashReport();
        }
        else {
            lllllllllllIllIIlIIlIIllIllIlIII = new CrashReport(lllllllllllIllIIlIIlIIllIllIIllI, lllllllllllIllIIlIIlIIllIllIlIll);
        }
        return lllllllllllIllIIlIIlIIllIllIlIII;
    }
    
    public File getFile() {
        return this.crashReportFile;
    }
    
    public CrashReport(final String lllllllllllIllIIlIIlIIlllllIlllI, final Throwable lllllllllllIllIIlIIlIIllllllIIII) {
        this.theReportCategory = new CrashReportCategory(this, "System Details");
        this.crashReportSections = (List<CrashReportCategory>)Lists.newArrayList();
        this.firstCategoryInCrashReport = true;
        this.stacktrace = new StackTraceElement[0];
        this.reported = false;
        this.description = lllllllllllIllIIlIIlIIlllllIlllI;
        this.cause = lllllllllllIllIIlIIlIIllllllIIII;
        this.populateEnvironment();
    }
    
    public CrashReportCategory makeCategoryDepth(final String lllllllllllIllIIlIIlIIllIlllllIl, final int lllllllllllIllIIlIIlIIlllIIIIllI) {
        final CrashReportCategory lllllllllllIllIIlIIlIIlllIIIIlIl = new CrashReportCategory(this, lllllllllllIllIIlIIlIIllIlllllIl);
        if (this.firstCategoryInCrashReport) {
            final int lllllllllllIllIIlIIlIIlllIIIIlII = lllllllllllIllIIlIIlIIlllIIIIlIl.getPrunedStackTrace(lllllllllllIllIIlIIlIIlllIIIIllI);
            final StackTraceElement[] lllllllllllIllIIlIIlIIlllIIIIIll = this.cause.getStackTrace();
            StackTraceElement lllllllllllIllIIlIIlIIlllIIIIIlI = null;
            StackTraceElement lllllllllllIllIIlIIlIIlllIIIIIIl = null;
            final int lllllllllllIllIIlIIlIIlllIIIIIII = lllllllllllIllIIlIIlIIlllIIIIIll.length - lllllllllllIllIIlIIlIIlllIIIIlII;
            if (lllllllllllIllIIlIIlIIlllIIIIIII < 0) {
                System.out.println("Negative index in crash report handler (" + lllllllllllIllIIlIIlIIlllIIIIIll.length + "/" + lllllllllllIllIIlIIlIIlllIIIIlII + ")");
            }
            if (lllllllllllIllIIlIIlIIlllIIIIIll != null && lllllllllllIllIIlIIlIIlllIIIIIII >= 0 && lllllllllllIllIIlIIlIIlllIIIIIII < lllllllllllIllIIlIIlIIlllIIIIIll.length) {
                lllllllllllIllIIlIIlIIlllIIIIIlI = lllllllllllIllIIlIIlIIlllIIIIIll[lllllllllllIllIIlIIlIIlllIIIIIII];
                if (lllllllllllIllIIlIIlIIlllIIIIIll.length + 1 - lllllllllllIllIIlIIlIIlllIIIIlII < lllllllllllIllIIlIIlIIlllIIIIIll.length) {
                    lllllllllllIllIIlIIlIIlllIIIIIIl = lllllllllllIllIIlIIlIIlllIIIIIll[lllllllllllIllIIlIIlIIlllIIIIIll.length + 1 - lllllllllllIllIIlIIlIIlllIIIIlII];
                }
            }
            this.firstCategoryInCrashReport = lllllllllllIllIIlIIlIIlllIIIIlIl.firstTwoElementsOfStackTraceMatch(lllllllllllIllIIlIIlIIlllIIIIIlI, lllllllllllIllIIlIIlIIlllIIIIIIl);
            if (lllllllllllIllIIlIIlIIlllIIIIlII > 0 && !this.crashReportSections.isEmpty()) {
                final CrashReportCategory lllllllllllIllIIlIIlIIllIlllllll = this.crashReportSections.get(this.crashReportSections.size() - 1);
                lllllllllllIllIIlIIlIIllIlllllll.trimStackTraceEntriesFromBottom(lllllllllllIllIIlIIlIIlllIIIIlII);
            }
            else if (lllllllllllIllIIlIIlIIlllIIIIIll != null && lllllllllllIllIIlIIlIIlllIIIIIll.length >= lllllllllllIllIIlIIlIIlllIIIIlII && lllllllllllIllIIlIIlIIlllIIIIIII >= 0 && lllllllllllIllIIlIIlIIlllIIIIIII < lllllllllllIllIIlIIlIIlllIIIIIll.length) {
                this.stacktrace = new StackTraceElement[lllllllllllIllIIlIIlIIlllIIIIIII];
                System.arraycopy(lllllllllllIllIIlIIlIIlllIIIIIll, 0, this.stacktrace, 0, this.stacktrace.length);
            }
            else {
                this.firstCategoryInCrashReport = false;
            }
        }
        this.crashReportSections.add(lllllllllllIllIIlIIlIIlllIIIIlIl);
        return lllllllllllIllIIlIIlIIlllIIIIlIl;
    }
    
    public void getSectionsInStringBuilder(final StringBuilder lllllllllllIllIIlIIlIIllllIlIlIl) {
        if ((this.stacktrace == null || this.stacktrace.length <= 0) && !this.crashReportSections.isEmpty()) {
            this.stacktrace = (StackTraceElement[])ArrayUtils.subarray((Object[])this.crashReportSections.get(0).getStackTrace(), 0, 1);
        }
        if (this.stacktrace != null && this.stacktrace.length > 0) {
            lllllllllllIllIIlIIlIIllllIlIlIl.append("-- Head --\n");
            lllllllllllIllIIlIIlIIllllIlIlIl.append("Thread: ").append(Thread.currentThread().getName()).append("\n");
            lllllllllllIllIIlIIlIIllllIlIlIl.append("Stacktrace:\n");
            final short lllllllllllIllIIlIIlIIllllIlIIIl;
            final Exception lllllllllllIllIIlIIlIIllllIlIIlI = (Exception)((StackTraceElement[])(Object)(lllllllllllIllIIlIIlIIllllIlIIIl = (short)(Object)this.stacktrace)).length;
            for (byte lllllllllllIllIIlIIlIIllllIlIIll = 0; lllllllllllIllIIlIIlIIllllIlIIll < lllllllllllIllIIlIIlIIllllIlIIlI; ++lllllllllllIllIIlIIlIIllllIlIIll) {
                final StackTraceElement lllllllllllIllIIlIIlIIllllIllIII = lllllllllllIllIIlIIlIIllllIlIIIl[lllllllllllIllIIlIIlIIllllIlIIll];
                lllllllllllIllIIlIIlIIllllIlIlIl.append("\t").append("at ").append(lllllllllllIllIIlIIlIIllllIllIII);
                lllllllllllIllIIlIIlIIllllIlIlIl.append("\n");
            }
            lllllllllllIllIIlIIlIIllllIlIlIl.append("\n");
        }
        for (final CrashReportCategory lllllllllllIllIIlIIlIIllllIlIlll : this.crashReportSections) {
            lllllllllllIllIIlIIlIIllllIlIlll.appendToStringBuilder(lllllllllllIllIIlIIlIIllllIlIlIl);
            lllllllllllIllIIlIIlIIllllIlIlIl.append("\n\n");
        }
        this.theReportCategory.appendToStringBuilder(lllllllllllIllIIlIIlIIllllIlIlIl);
    }
    
    public String getCompleteReport() {
        if (!this.reported) {
            this.reported = true;
            CrashReporter.onCrashReport(this, this.theReportCategory);
        }
        final StringBuilder lllllllllllIllIIlIIlIIlllIlllIll = new StringBuilder();
        lllllllllllIllIIlIIlIIlllIlllIll.append("---- Minecraft Crash Report ----\n");
        Reflector.call(Reflector.BlamingTransformer_onCrash, new Object[] { lllllllllllIllIIlIIlIIlllIlllIll });
        Reflector.call(Reflector.CoreModManager_onCrash, new Object[] { lllllllllllIllIIlIIlIIlllIlllIll });
        lllllllllllIllIIlIIlIIlllIlllIll.append("// ");
        lllllllllllIllIIlIIlIIlllIlllIll.append(getWittyComment());
        lllllllllllIllIIlIIlIIlllIlllIll.append("\n\n");
        lllllllllllIllIIlIIlIIlllIlllIll.append("Time: ");
        lllllllllllIllIIlIIlIIlllIlllIll.append(new SimpleDateFormat().format(new Date()));
        lllllllllllIllIIlIIlIIlllIlllIll.append("\n");
        lllllllllllIllIIlIIlIIlllIlllIll.append("Description: ");
        lllllllllllIllIIlIIlIIlllIlllIll.append(this.description);
        lllllllllllIllIIlIIlIIlllIlllIll.append("\n\n");
        lllllllllllIllIIlIIlIIlllIlllIll.append(this.getCauseStackTraceOrString());
        lllllllllllIllIIlIIlIIlllIlllIll.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");
        for (int lllllllllllIllIIlIIlIIlllIlllIlI = 0; lllllllllllIllIIlIIlIIlllIlllIlI < 87; ++lllllllllllIllIIlIIlIIlllIlllIlI) {
            lllllllllllIllIIlIIlIIlllIlllIll.append("-");
        }
        lllllllllllIllIIlIIlIIlllIlllIll.append("\n\n");
        this.getSectionsInStringBuilder(lllllllllllIllIIlIIlIIlllIlllIll);
        return lllllllllllIllIIlIIlIIlllIlllIll.toString();
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public Throwable getCrashCause() {
        return this.cause;
    }
    
    public CrashReportCategory makeCategory(final String lllllllllllIllIIlIIlIIlllIIlIlIl) {
        return this.makeCategoryDepth(lllllllllllIllIIlIIlIIlllIIlIlIl, 1);
    }
}
