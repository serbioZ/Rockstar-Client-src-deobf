// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonElement;
import net.minecraft.network.PacketBuffer;
import java.text.ParseException;
import com.google.gson.JsonSyntaxException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CriterionProgress
{
    private static final /* synthetic */ SimpleDateFormat field_192155_a;
    private /* synthetic */ Date field_192157_c;
    private final /* synthetic */ AdvancementProgress field_192156_b;
    
    public void func_192153_b() {
        this.field_192157_c = new Date();
    }
    
    public static CriterionProgress func_192152_a(final AdvancementProgress lllllllllllIIIIlIIlllllllIIllIIl, final String lllllllllllIIIIlIIlllllllIIlIlII) {
        final CriterionProgress lllllllllllIIIIlIIlllllllIIlIlll = new CriterionProgress(lllllllllllIIIIlIIlllllllIIllIIl);
        try {
            lllllllllllIIIIlIIlllllllIIlIlll.field_192157_c = CriterionProgress.field_192155_a.parse(lllllllllllIIIIlIIlllllllIIlIlII);
            return lllllllllllIIIIlIIlllllllIIlIlll;
        }
        catch (ParseException lllllllllllIIIIlIIlllllllIIlIllI) {
            throw new JsonSyntaxException("Invalid datetime: " + lllllllllllIIIIlIIlllllllIIlIlII, (Throwable)lllllllllllIIIIlIIlllllllIIlIllI);
        }
    }
    
    public void func_192154_c() {
        this.field_192157_c = null;
    }
    
    public static CriterionProgress func_192149_a(final PacketBuffer lllllllllllIIIIlIIlllllllIlIIIll, final AdvancementProgress lllllllllllIIIIlIIlllllllIlIIIlI) {
        final CriterionProgress lllllllllllIIIIlIIlllllllIlIIIIl = new CriterionProgress(lllllllllllIIIIlIIlllllllIlIIIlI);
        if (lllllllllllIIIIlIIlllllllIlIIIll.readBoolean()) {
            lllllllllllIIIIlIIlllllllIlIIIIl.field_192157_c = lllllllllllIIIIlIIlllllllIlIIIll.func_192573_m();
        }
        return lllllllllllIIIIlIIlllllllIlIIIIl;
    }
    
    static {
        field_192155_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }
    
    public boolean func_192151_a() {
        return this.field_192157_c != null;
    }
    
    public void func_192150_a(final PacketBuffer lllllllllllIIIIlIIlllllllIlIllII) {
        lllllllllllIIIIlIIlllllllIlIllII.writeBoolean(this.field_192157_c != null);
        if (this.field_192157_c != null) {
            lllllllllllIIIIlIIlllllllIlIllII.func_192574_a(this.field_192157_c);
        }
    }
    
    @Override
    public String toString() {
        return "CriterionProgress{obtained=" + ((this.field_192157_c == null) ? "false" : this.field_192157_c) + '}';
    }
    
    public Date func_193140_d() {
        return this.field_192157_c;
    }
    
    public CriterionProgress(final AdvancementProgress lllllllllllIIIIlIIlllllllIllllll) {
        this.field_192156_b = lllllllllllIIIIlIIlllllllIllllll;
    }
    
    public JsonElement func_192148_e() {
        return (JsonElement)((this.field_192157_c != null) ? new JsonPrimitive(CriterionProgress.field_192155_a.format(this.field_192157_c)) : JsonNull.INSTANCE);
    }
}
