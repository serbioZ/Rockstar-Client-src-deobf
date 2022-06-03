// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.settings;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import net.minecraft.client.Minecraft;

public class CreativeSettings
{
    protected /* synthetic */ Minecraft field_192565_a;
    private final /* synthetic */ File field_192567_c;
    private final /* synthetic */ HotbarSnapshot[] field_192568_d;
    private static final /* synthetic */ Logger field_192566_b;
    
    static {
        field_192566_b = LogManager.getLogger();
    }
    
    public HotbarSnapshot func_192563_a(final int lllllllllllIlIllIIlIIlIllIllIIII) {
        return this.field_192568_d[lllllllllllIlIllIIlIIlIllIllIIII];
    }
    
    public void func_192564_b() {
        try {
            final NBTTagCompound lllllllllllIlIllIIlIIlIllIlllIll = new NBTTagCompound();
            for (int lllllllllllIlIllIIlIIlIllIlllIlI = 0; lllllllllllIlIllIIlIIlIllIlllIlI < 9; ++lllllllllllIlIllIIlIIlIllIlllIlI) {
                lllllllllllIlIllIIlIIlIllIlllIll.setTag(String.valueOf(lllllllllllIlIllIIlIIlIllIlllIlI), this.field_192568_d[lllllllllllIlIllIIlIIlIllIlllIlI].func_192834_a());
            }
            CompressedStreamTools.write(lllllllllllIlIllIIlIIlIllIlllIll, this.field_192567_c);
        }
        catch (Exception lllllllllllIlIllIIlIIlIllIlllIIl) {
            CreativeSettings.field_192566_b.error("Failed to save creative mode options", (Throwable)lllllllllllIlIllIIlIIlIllIlllIIl);
        }
    }
    
    public CreativeSettings(final Minecraft lllllllllllIlIllIIlIIlIlllIlIIII, final File lllllllllllIlIllIIlIIlIlllIIlIll) {
        this.field_192568_d = new HotbarSnapshot[9];
        this.field_192565_a = lllllllllllIlIllIIlIIlIlllIlIIII;
        this.field_192567_c = new File(lllllllllllIlIllIIlIIlIlllIIlIll, "hotbar.nbt");
        for (int lllllllllllIlIllIIlIIlIlllIIlllI = 0; lllllllllllIlIllIIlIIlIlllIIlllI < 9; ++lllllllllllIlIllIIlIIlIlllIIlllI) {
            this.field_192568_d[lllllllllllIlIllIIlIIlIlllIIlllI] = new HotbarSnapshot();
        }
        this.func_192562_a();
    }
    
    public void func_192562_a() {
        try {
            final NBTTagCompound lllllllllllIlIllIIlIIlIlllIIIlIl = CompressedStreamTools.read(this.field_192567_c);
            if (lllllllllllIlIllIIlIIlIlllIIIlIl == null) {
                return;
            }
            for (int lllllllllllIlIllIIlIIlIlllIIIlII = 0; lllllllllllIlIllIIlIIlIlllIIIlII < 9; ++lllllllllllIlIllIIlIIlIlllIIIlII) {
                this.field_192568_d[lllllllllllIlIllIIlIIlIlllIIIlII].func_192833_a(lllllllllllIlIllIIlIIlIlllIIIlIl.getTagList(String.valueOf(lllllllllllIlIllIIlIIlIlllIIIlII), 10));
            }
        }
        catch (Exception lllllllllllIlIllIIlIIlIlllIIIIll) {
            CreativeSettings.field_192566_b.error("Failed to load creative mode options", (Throwable)lllllllllllIlIllIIlIIlIlllIIIIll);
        }
    }
}
