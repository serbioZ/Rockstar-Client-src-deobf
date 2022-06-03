// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import org.apache.logging.log4j.LogManager;
import net.minecraft.command.ICommandManager;
import net.minecraft.world.World;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;
import java.util.List;
import com.google.common.io.Files;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.apache.logging.log4j.Logger;
import net.minecraft.server.MinecraftServer;
import java.util.ArrayDeque;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.FunctionObject;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.util.ITickable;

public class FunctionManager implements ITickable
{
    private final /* synthetic */ Map<ResourceLocation, FunctionObject> field_193070_d;
    private final /* synthetic */ ICommandSender field_193073_g;
    private final /* synthetic */ ArrayDeque<QueuedCommand> field_194020_g;
    private final /* synthetic */ MinecraftServer field_193069_c;
    private /* synthetic */ FunctionObject field_193072_f;
    private static final /* synthetic */ Logger field_193067_a;
    private /* synthetic */ String field_193071_e;
    private final /* synthetic */ File field_193068_b;
    private /* synthetic */ boolean field_194021_h;
    
    private void func_193061_h() {
        if (this.field_193068_b != null) {
            this.field_193068_b.mkdirs();
            for (final File llllllllllllllIIllIIlIIIIIIIIIII : FileUtils.listFiles(this.field_193068_b, new String[] { "mcfunction" }, true)) {
                final String llllllllllllllIIllIIIlllllllllll = FilenameUtils.removeExtension(this.field_193068_b.toURI().relativize(llllllllllllllIIllIIlIIIIIIIIIII.toURI()).toString());
                final String[] llllllllllllllIIllIIIllllllllllI = llllllllllllllIIllIIIlllllllllll.split("/", 2);
                if (llllllllllllllIIllIIIllllllllllI.length == 2) {
                    final ResourceLocation llllllllllllllIIllIIIlllllllllIl = new ResourceLocation(llllllllllllllIIllIIIllllllllllI[0], llllllllllllllIIllIIIllllllllllI[1]);
                    try {
                        this.field_193070_d.put(llllllllllllllIIllIIIlllllllllIl, FunctionObject.func_193527_a(this, Files.readLines(llllllllllllllIIllIIlIIIIIIIIIII, StandardCharsets.UTF_8)));
                    }
                    catch (Throwable llllllllllllllIIllIIIlllllllllII) {
                        FunctionManager.field_193067_a.error("Couldn't read custom function " + llllllllllllllIIllIIIlllllllllIl + " from " + llllllllllllllIIllIIlIIIIIIIIIII, llllllllllllllIIllIIIlllllllllII);
                    }
                }
            }
            if (!this.field_193070_d.isEmpty()) {
                FunctionManager.field_193067_a.info("Loaded " + this.field_193070_d.size() + " custom command functions");
            }
        }
    }
    
    public int func_193065_c() {
        return this.field_193069_c.worldServers[0].getGameRules().getInt("maxCommandChainLength");
    }
    
    public FunctionManager(@Nullable final File llllllllllllllIIllIIlIIIIlIIIIll, final MinecraftServer llllllllllllllIIllIIlIIIIIllllll) {
        this.field_193070_d = (Map<ResourceLocation, FunctionObject>)Maps.newHashMap();
        this.field_193071_e = "-";
        this.field_194020_g = new ArrayDeque<QueuedCommand>();
        this.field_194021_h = false;
        this.field_193073_g = new ICommandSender() {
            @Override
            public MinecraftServer getServer() {
                return FunctionManager.this.field_193069_c;
            }
            
            @Override
            public World getEntityWorld() {
                return FunctionManager.this.field_193069_c.worldServers[0];
            }
            
            @Override
            public String getName() {
                return FunctionManager.this.field_193071_e;
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int lllllllllllIlIIIIllIllllIIIllllI, final String lllllllllllIlIIIIllIllllIIIlllIl) {
                return lllllllllllIlIIIIllIllllIIIllllI <= 2;
            }
        };
        this.field_193068_b = llllllllllllllIIllIIlIIIIlIIIIll;
        this.field_193069_c = llllllllllllllIIllIIlIIIIIllllll;
        this.func_193059_f();
    }
    
    public ICommandManager func_193062_a() {
        return this.field_193069_c.getCommandManager();
    }
    
    public int func_194019_a(final FunctionObject llllllllllllllIIllIIlIIIIIIllllI, final ICommandSender llllllllllllllIIllIIlIIIIIIlllIl) {
        final int llllllllllllllIIllIIlIIIIIIlllII = this.func_193065_c();
        if (this.field_194021_h) {
            if (this.field_194020_g.size() < llllllllllllllIIllIIlIIIIIIlllII) {
                this.field_194020_g.addFirst(new QueuedCommand(this, llllllllllllllIIllIIlIIIIIIlllIl, new FunctionObject.FunctionEntry(llllllllllllllIIllIIlIIIIIIllllI)));
            }
            return 0;
        }
        Label_0186: {
            try {
                this.field_194021_h = true;
                int llllllllllllllIIllIIlIIIIIIllIII = 0;
                final FunctionObject.Entry[] llllllllllllllIIllIIlIIIIIIlIlll = llllllllllllllIIllIIlIIIIIIllllI.func_193528_a();
                for (int llllllllllllllIIllIIlIIIIIIlIllI = llllllllllllllIIllIIlIIIIIIlIlll.length - 1; llllllllllllllIIllIIlIIIIIIlIllI >= 0; --llllllllllllllIIllIIlIIIIIIlIllI) {
                    this.field_194020_g.push(new QueuedCommand(this, llllllllllllllIIllIIlIIIIIIlllIl, llllllllllllllIIllIIlIIIIIIlIlll[llllllllllllllIIllIIlIIIIIIlIllI]));
                }
                while (!this.field_194020_g.isEmpty()) {
                    this.field_194020_g.removeFirst().func_194222_a(this.field_194020_g, llllllllllllllIIllIIlIIIIIIlllII);
                    if (++llllllllllllllIIllIIlIIIIIIllIII >= llllllllllllllIIllIIlIIIIIIlllII) {
                        final int llllllllllllllIIllIIlIIIIIIllIlI = llllllllllllllIIllIIlIIIIIIllIII;
                        break Label_0186;
                    }
                }
                final Exception llllllllllllllIIllIIlIIIIIIIllII;
                final int llllllllllllllIIllIIlIIIIIIllIll = (int)(llllllllllllllIIllIIlIIIIIIIllII = (Exception)llllllllllllllIIllIIlIIIIIIllIII);
                return (int)llllllllllllllIIllIIlIIIIIIIllII;
            }
            finally {
                this.field_194020_g.clear();
                this.field_194021_h = false;
            }
        }
        this.field_194020_g.clear();
        this.field_194021_h = false;
        final int llllllllllllllIIllIIlIIIIIIllIIl;
        return llllllllllllllIIllIIlIIIIIIllIIl;
    }
    
    @Override
    public void update() {
        final String llllllllllllllIIllIIlIIIIIlIllII = this.field_193069_c.worldServers[0].getGameRules().getString("gameLoopFunction");
        if (!llllllllllllllIIllIIlIIIIIlIllII.equals(this.field_193071_e)) {
            this.field_193071_e = llllllllllllllIIllIIlIIIIIlIllII;
            this.field_193072_f = this.func_193058_a(new ResourceLocation(llllllllllllllIIllIIlIIIIIlIllII));
        }
        if (this.field_193072_f != null) {
            this.func_194019_a(this.field_193072_f, this.field_193073_g);
        }
    }
    
    public Map<ResourceLocation, FunctionObject> func_193066_d() {
        return this.field_193070_d;
    }
    
    public void func_193059_f() {
        this.field_193070_d.clear();
        this.field_193072_f = null;
        this.field_193071_e = "-";
        this.func_193061_h();
    }
    
    static {
        field_193067_a = LogManager.getLogger();
    }
    
    @Nullable
    public FunctionObject func_193058_a(final ResourceLocation llllllllllllllIIllIIlIIIIIlllIIl) {
        return this.field_193070_d.get(llllllllllllllIIllIIlIIIIIlllIIl);
    }
    
    public static class QueuedCommand
    {
        private final /* synthetic */ ICommandSender field_194224_b;
        private final /* synthetic */ FunctionObject.Entry field_194225_c;
        private final /* synthetic */ FunctionManager field_194223_a;
        
        @Override
        public String toString() {
            return this.field_194225_c.toString();
        }
        
        public void func_194222_a(final ArrayDeque<QueuedCommand> lllllllllllIIlIIIllllllIllIllIlI, final int lllllllllllIIlIIIllllllIllIlllII) {
            this.field_194225_c.func_194145_a(this.field_194223_a, this.field_194224_b, lllllllllllIIlIIIllllllIllIllIlI, lllllllllllIIlIIIllllllIllIlllII);
        }
        
        public QueuedCommand(final ICommandSender lllllllllllIIlIIIllllllIlllIIIll, final FunctionObject.Entry lllllllllllIIlIIIllllllIlllIIllI) {
            this.field_194224_b = lllllllllllIIlIIIllllllIlllIIIll;
            this.field_194225_c = lllllllllllIIlIIIllllllIlllIIllI;
        }
    }
}
