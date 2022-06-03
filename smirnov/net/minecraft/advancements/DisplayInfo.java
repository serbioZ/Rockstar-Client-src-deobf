// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import net.minecraft.item.Item;
import java.io.IOException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.JsonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.network.PacketBuffer;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class DisplayInfo
{
    private /* synthetic */ float field_192305_f;
    private /* synthetic */ float field_192304_e;
    private final /* synthetic */ ResourceLocation field_192302_c;
    private final /* synthetic */ FrameType field_192303_d;
    private final /* synthetic */ boolean field_193226_f;
    private final /* synthetic */ ItemStack field_192301_b;
    private final /* synthetic */ ITextComponent field_192300_a;
    private final /* synthetic */ ITextComponent field_193225_b;
    private final /* synthetic */ boolean field_193227_g;
    private final /* synthetic */ boolean field_193228_h;
    
    public DisplayInfo(final ItemStack lllllllllllIlIIllIlIlIIIlIlllllI, final ITextComponent lllllllllllIlIIllIlIlIIIllIIIllI, final ITextComponent lllllllllllIlIIllIlIlIIIlIllllII, @Nullable final ResourceLocation lllllllllllIlIIllIlIlIIIllIIIlII, final FrameType lllllllllllIlIIllIlIlIIIllIIIIll, final boolean lllllllllllIlIIllIlIlIIIlIlllIIl, final boolean lllllllllllIlIIllIlIlIIIlIlllIII, final boolean lllllllllllIlIIllIlIlIIIllIIIIII) {
        this.field_192300_a = lllllllllllIlIIllIlIlIIIllIIIllI;
        this.field_193225_b = lllllllllllIlIIllIlIlIIIlIllllII;
        this.field_192301_b = lllllllllllIlIIllIlIlIIIlIlllllI;
        this.field_192302_c = lllllllllllIlIIllIlIlIIIllIIIlII;
        this.field_192303_d = lllllllllllIlIIllIlIlIIIllIIIIll;
        this.field_193226_f = lllllllllllIlIIllIlIlIIIlIlllIIl;
        this.field_193227_g = lllllllllllIlIIllIlIlIIIlIlllIII;
        this.field_193228_h = lllllllllllIlIIllIlIlIIIllIIIIII;
    }
    
    public boolean func_193223_h() {
        return this.field_193226_f;
    }
    
    public void func_192290_a(final PacketBuffer lllllllllllIlIIllIlIlIIIIllIIlII) {
        lllllllllllIlIIllIlIlIIIIllIIlII.writeTextComponent(this.field_192300_a);
        lllllllllllIlIIllIlIlIIIIllIIlII.writeTextComponent(this.field_193225_b);
        lllllllllllIlIIllIlIlIIIIllIIlII.writeItemStackToBuffer(this.field_192301_b);
        lllllllllllIlIIllIlIlIIIIllIIlII.writeEnumValue(this.field_192303_d);
        int lllllllllllIlIIllIlIlIIIIllIIIll = 0;
        if (this.field_192302_c != null) {
            lllllllllllIlIIllIlIlIIIIllIIIll |= 0x1;
        }
        if (this.field_193226_f) {
            lllllllllllIlIIllIlIlIIIIllIIIll |= 0x2;
        }
        if (this.field_193228_h) {
            lllllllllllIlIIllIlIlIIIIllIIIll |= 0x4;
        }
        lllllllllllIlIIllIlIlIIIIllIIlII.writeInt(lllllllllllIlIIllIlIlIIIIllIIIll);
        if (this.field_192302_c != null) {
            lllllllllllIlIIllIlIlIIIIllIIlII.func_192572_a(this.field_192302_c);
        }
        lllllllllllIlIIllIlIlIIIIllIIlII.writeFloat(this.field_192304_e);
        lllllllllllIlIIllIlIlIIIIllIIlII.writeFloat(this.field_192305_f);
    }
    
    public FrameType func_192291_d() {
        return this.field_192303_d;
    }
    
    public float func_192299_e() {
        return this.field_192304_e;
    }
    
    public static DisplayInfo func_192294_a(final JsonObject lllllllllllIlIIllIlIlIIIIllllIll, final JsonDeserializationContext lllllllllllIlIIllIlIlIIIIllllIlI) {
        final ITextComponent lllllllllllIlIIllIlIlIIIlIIIIIll = JsonUtils.deserializeClass(lllllllllllIlIIllIlIlIIIIllllIll, "title", lllllllllllIlIIllIlIlIIIIllllIlI, (Class<? extends ITextComponent>)ITextComponent.class);
        final ITextComponent lllllllllllIlIIllIlIlIIIlIIIIIlI = JsonUtils.deserializeClass(lllllllllllIlIIllIlIlIIIIllllIll, "description", lllllllllllIlIIllIlIlIIIIllllIlI, (Class<? extends ITextComponent>)ITextComponent.class);
        if (lllllllllllIlIIllIlIlIIIlIIIIIll != null && lllllllllllIlIIllIlIlIIIlIIIIIlI != null) {
            final ItemStack lllllllllllIlIIllIlIlIIIlIIIIIIl = func_193221_a(JsonUtils.getJsonObject(lllllllllllIlIIllIlIlIIIIllllIll, "icon"));
            final ResourceLocation lllllllllllIlIIllIlIlIIIlIIIIIII = lllllllllllIlIIllIlIlIIIIllllIll.has("background") ? new ResourceLocation(JsonUtils.getString(lllllllllllIlIIllIlIlIIIIllllIll, "background")) : null;
            final FrameType lllllllllllIlIIllIlIlIIIIlllllll = lllllllllllIlIIllIlIlIIIIllllIll.has("frame") ? FrameType.func_192308_a(JsonUtils.getString(lllllllllllIlIIllIlIlIIIIllllIll, "frame")) : FrameType.TASK;
            final boolean lllllllllllIlIIllIlIlIIIIllllllI = JsonUtils.getBoolean(lllllllllllIlIIllIlIlIIIIllllIll, "show_toast", true);
            final boolean lllllllllllIlIIllIlIlIIIIlllllIl = JsonUtils.getBoolean(lllllllllllIlIIllIlIlIIIIllllIll, "announce_to_chat", true);
            final boolean lllllllllllIlIIllIlIlIIIIlllllII = JsonUtils.getBoolean(lllllllllllIlIIllIlIlIIIIllllIll, "hidden", false);
            return new DisplayInfo(lllllllllllIlIIllIlIlIIIlIIIIIIl, lllllllllllIlIIllIlIlIIIlIIIIIll, lllllllllllIlIIllIlIlIIIlIIIIIlI, lllllllllllIlIIllIlIlIIIlIIIIIII, lllllllllllIlIIllIlIlIIIIlllllll, lllllllllllIlIIllIlIlIIIIllllllI, lllllllllllIlIIllIlIlIIIIlllllIl, lllllllllllIlIIllIlIlIIIIlllllII);
        }
        throw new JsonSyntaxException("Both title and description must be set");
    }
    
    public ITextComponent func_192297_a() {
        return this.field_192300_a;
    }
    
    public ITextComponent func_193222_b() {
        return this.field_193225_b;
    }
    
    public boolean func_193224_j() {
        return this.field_193228_h;
    }
    
    public float func_192296_f() {
        return this.field_192305_f;
    }
    
    public ItemStack func_192298_b() {
        return this.field_192301_b;
    }
    
    public static DisplayInfo func_192295_b(final PacketBuffer lllllllllllIlIIllIlIlIIIIlIIlIll) throws IOException {
        final ITextComponent lllllllllllIlIIllIlIlIIIIlIlIlII = lllllllllllIlIIllIlIlIIIIlIIlIll.readTextComponent();
        final ITextComponent lllllllllllIlIIllIlIlIIIIlIlIIll = lllllllllllIlIIllIlIlIIIIlIIlIll.readTextComponent();
        final ItemStack lllllllllllIlIIllIlIlIIIIlIlIIlI = lllllllllllIlIIllIlIlIIIIlIIlIll.readItemStackFromBuffer();
        final FrameType lllllllllllIlIIllIlIlIIIIlIlIIIl = lllllllllllIlIIllIlIlIIIIlIIlIll.readEnumValue(FrameType.class);
        final int lllllllllllIlIIllIlIlIIIIlIlIIII = lllllllllllIlIIllIlIlIIIIlIIlIll.readInt();
        final ResourceLocation lllllllllllIlIIllIlIlIIIIlIIllll = ((lllllllllllIlIIllIlIlIIIIlIlIIII & 0x1) != 0x0) ? lllllllllllIlIIllIlIlIIIIlIIlIll.func_192575_l() : null;
        final boolean lllllllllllIlIIllIlIlIIIIlIIlllI = (lllllllllllIlIIllIlIlIIIIlIlIIII & 0x2) != 0x0;
        final boolean lllllllllllIlIIllIlIlIIIIlIIllIl = (lllllllllllIlIIllIlIlIIIIlIlIIII & 0x4) != 0x0;
        final DisplayInfo lllllllllllIlIIllIlIlIIIIlIIllII = new DisplayInfo(lllllllllllIlIIllIlIlIIIIlIlIIlI, lllllllllllIlIIllIlIlIIIIlIlIlII, lllllllllllIlIIllIlIlIIIIlIlIIll, lllllllllllIlIIllIlIlIIIIlIIllll, lllllllllllIlIIllIlIlIIIIlIlIIIl, lllllllllllIlIIllIlIlIIIIlIIlllI, false, lllllllllllIlIIllIlIlIIIIlIIllIl);
        lllllllllllIlIIllIlIlIIIIlIIllII.func_192292_a(lllllllllllIlIIllIlIlIIIIlIIlIll.readFloat(), lllllllllllIlIIllIlIlIIIIlIIlIll.readFloat());
        return lllllllllllIlIIllIlIlIIIIlIIllII;
    }
    
    private static ItemStack func_193221_a(final JsonObject lllllllllllIlIIllIlIlIIIIllIlllI) {
        if (!lllllllllllIlIIllIlIlIIIIllIlllI.has("item")) {
            throw new JsonSyntaxException("Unsupported icon type, currently only items are supported (add 'item' key)");
        }
        final Item lllllllllllIlIIllIlIlIIIIllIllIl = JsonUtils.getItem(lllllllllllIlIIllIlIlIIIIllIlllI, "item");
        final int lllllllllllIlIIllIlIlIIIIllIllII = JsonUtils.getInt(lllllllllllIlIIllIlIlIIIIllIlllI, "data", 0);
        return new ItemStack(lllllllllllIlIIllIlIlIIIIllIllIl, 1, lllllllllllIlIIllIlIlIIIIllIllII);
    }
    
    @Nullable
    public ResourceLocation func_192293_c() {
        return this.field_192302_c;
    }
    
    public void func_192292_a(final float lllllllllllIlIIllIlIlIIIlIlIllll, final float lllllllllllIlIIllIlIlIIIlIllIIIl) {
        this.field_192304_e = lllllllllllIlIIllIlIlIIIlIlIllll;
        this.field_192305_f = lllllllllllIlIIllIlIlIIIlIllIIIl;
    }
    
    public boolean func_193220_i() {
        return this.field_193227_g;
    }
}
