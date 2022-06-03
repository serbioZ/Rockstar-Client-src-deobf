// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Pattern;

public class JsonToNBT
{
    private static final /* synthetic */ Pattern field_193621_g;
    private static final /* synthetic */ Pattern field_193620_f;
    private final /* synthetic */ String field_193622_h;
    private static final /* synthetic */ Pattern field_193618_d;
    private static final /* synthetic */ Pattern field_193615_a;
    private static final /* synthetic */ Pattern field_193616_b;
    private static final /* synthetic */ Pattern field_193619_e;
    private static final /* synthetic */ Pattern field_193617_c;
    private /* synthetic */ int field_193623_i;
    
    private char func_193594_o() {
        return this.field_193622_h.charAt(this.field_193623_i++);
    }
    
    private char func_193597_b(final int lllllllllllIIllIIlIlllllIIIllIll) {
        return this.field_193622_h.charAt(this.field_193623_i + lllllllllllIIllIIlIlllllIIIllIll);
    }
    
    private NBTException func_193602_b(final String lllllllllllIIllIIlIllllllIIlIlll) {
        return new NBTException(lllllllllllIIllIIlIllllllIIlIlll, this.field_193622_h, this.field_193623_i);
    }
    
    static {
        field_193615_a = Pattern.compile("[-+]?(?:[0-9]+[.]|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?", 2);
        field_193616_b = Pattern.compile("[-+]?(?:[0-9]+[.]?|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?d", 2);
        field_193617_c = Pattern.compile("[-+]?(?:[0-9]+[.]?|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?f", 2);
        field_193618_d = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)b", 2);
        field_193619_e = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)l", 2);
        field_193620_f = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)s", 2);
        field_193621_g = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)");
    }
    
    private void func_193607_l() {
        while (this.func_193612_g() && Character.isWhitespace(this.func_193598_n())) {
            ++this.field_193623_i;
        }
    }
    
    private NBTBase func_193606_k() throws NBTException {
        this.func_193604_b('[');
        final char lllllllllllIIllIIlIlllllIlIlIIIl = this.func_193594_o();
        this.func_193594_o();
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected value");
        }
        if (lllllllllllIIllIIlIlllllIlIlIIIl == 'B') {
            return new NBTTagByteArray(this.func_193603_a((byte)7, (byte)1));
        }
        if (lllllllllllIIllIIlIlllllIlIlIIIl == 'L') {
            return new NBTTagLongArray(this.func_193603_a((byte)12, (byte)4));
        }
        if (lllllllllllIIllIIlIlllllIlIlIIIl == 'I') {
            return new NBTTagIntArray(this.func_193603_a((byte)11, (byte)3));
        }
        throw this.func_193602_b("Invalid array type '" + lllllllllllIIllIIlIlllllIlIlIIIl + "' found");
    }
    
    private <T extends Number> List<T> func_193603_a(final byte lllllllllllIIllIIlIlllllIlIIIlll, final byte lllllllllllIIllIIlIlllllIlIIIllI) throws NBTException {
        final List<T> lllllllllllIIllIIlIlllllIlIIIlIl = (List<T>)Lists.newArrayList();
        while (this.func_193598_n() != ']') {
            final NBTBase lllllllllllIIllIIlIlllllIlIIIlII = this.func_193610_d();
            final int lllllllllllIIllIIlIlllllIlIIIIll = lllllllllllIIllIIlIlllllIlIIIlII.getId();
            if (lllllllllllIIllIIlIlllllIlIIIIll != lllllllllllIIllIIlIlllllIlIIIllI) {
                throw this.func_193602_b("Unable to insert " + NBTBase.func_193581_j(lllllllllllIIllIIlIlllllIlIIIIll) + " into " + NBTBase.func_193581_j(lllllllllllIIllIIlIlllllIlIIIlll));
            }
            if (lllllllllllIIllIIlIlllllIlIIIllI == 1) {
                lllllllllllIIllIIlIlllllIlIIIlIl.add((T)((NBTPrimitive)lllllllllllIIllIIlIlllllIlIIIlII).getByte());
            }
            else if (lllllllllllIIllIIlIlllllIlIIIllI == 4) {
                lllllllllllIIllIIlIlllllIlIIIlIl.add((T)((NBTPrimitive)lllllllllllIIllIIlIlllllIlIIIlII).getLong());
            }
            else {
                lllllllllllIIllIIlIlllllIlIIIlIl.add((T)((NBTPrimitive)lllllllllllIIllIIlIlllllIlIIIlII).getInt());
            }
            if (!this.func_193613_m()) {
                break;
            }
            if (!this.func_193612_g()) {
                throw this.func_193602_b("Expected value");
            }
        }
        this.func_193604_b(']');
        return lllllllllllIIllIIlIlllllIlIIIlIl;
    }
    
    protected NBTBase func_193611_c() throws NBTException {
        this.func_193607_l();
        if (this.func_193598_n() == '\"') {
            return new NBTTagString(this.func_193595_h());
        }
        final String lllllllllllIIllIIlIllllllIIlIIll = this.func_193614_i();
        if (lllllllllllIIllIIlIllllllIIlIIll.isEmpty()) {
            throw this.func_193602_b("Expected value");
        }
        return this.func_193596_c(lllllllllllIIllIIlIllllllIIlIIll);
    }
    
    @VisibleForTesting
    NBTTagCompound func_193609_a() throws NBTException {
        final NBTTagCompound lllllllllllIIllIIlIllllllIlIlIII = this.func_193593_f();
        this.func_193607_l();
        if (this.func_193612_g()) {
            ++this.field_193623_i;
            throw this.func_193602_b("Trailing data found");
        }
        return lllllllllllIIllIIlIllllllIlIlIII;
    }
    
    private void func_193604_b(final char lllllllllllIIllIIlIlllllIIllIIlI) throws NBTException {
        this.func_193607_l();
        final boolean lllllllllllIIllIIlIlllllIIllIIIl = this.func_193612_g();
        if (lllllllllllIIllIIlIlllllIIllIIIl && this.func_193598_n() == lllllllllllIIllIIlIlllllIIllIIlI) {
            ++this.field_193623_i;
            return;
        }
        throw new NBTException("Expected '" + lllllllllllIIllIIlIlllllIIllIIlI + "' but got '" + (lllllllllllIIllIIlIlllllIIllIIIl ? Character.valueOf(this.func_193598_n()) : "<EOF>") + "'", this.field_193622_h, this.field_193623_i + 1);
    }
    
    protected boolean func_193599_a(final char lllllllllllIIllIIlIlllllIIlIlIll) {
        return (lllllllllllIIllIIlIlllllIIlIlIll >= '0' && lllllllllllIIllIIlIlllllIIlIlIll <= '9') || (lllllllllllIIllIIlIlllllIIlIlIll >= 'A' && lllllllllllIIllIIlIlllllIIlIlIll <= 'Z') || (lllllllllllIIllIIlIlllllIIlIlIll >= 'a' && lllllllllllIIllIIlIlllllIIlIlIll <= 'z') || lllllllllllIIllIIlIlllllIIlIlIll == '_' || lllllllllllIIllIIlIlllllIIlIlIll == '-' || lllllllllllIIllIIlIlllllIIlIlIll == '.' || lllllllllllIIllIIlIlllllIIlIlIll == '+';
    }
    
    private String func_193595_h() throws NBTException {
        final int lllllllllllIIllIIlIllllllIIIIlII = ++this.field_193623_i;
        StringBuilder lllllllllllIIllIIlIllllllIIIIIll = null;
        boolean lllllllllllIIllIIlIllllllIIIIIlI = false;
        while (this.func_193612_g()) {
            final char lllllllllllIIllIIlIllllllIIIIIIl = this.func_193594_o();
            if (lllllllllllIIllIIlIllllllIIIIIlI) {
                if (lllllllllllIIllIIlIllllllIIIIIIl != '\\' && lllllllllllIIllIIlIllllllIIIIIIl != '\"') {
                    throw this.func_193602_b("Invalid escape of '" + lllllllllllIIllIIlIllllllIIIIIIl + "'");
                }
                lllllllllllIIllIIlIllllllIIIIIlI = false;
            }
            else if (lllllllllllIIllIIlIllllllIIIIIIl == '\\') {
                lllllllllllIIllIIlIllllllIIIIIlI = true;
                if (lllllllllllIIllIIlIllllllIIIIIll == null) {
                    lllllllllllIIllIIlIllllllIIIIIll = new StringBuilder(this.field_193622_h.substring(lllllllllllIIllIIlIllllllIIIIlII, this.field_193623_i - 1));
                    continue;
                }
                continue;
            }
            else if (lllllllllllIIllIIlIllllllIIIIIIl == '\"') {
                return (lllllllllllIIllIIlIllllllIIIIIll == null) ? this.field_193622_h.substring(lllllllllllIIllIIlIllllllIIIIlII, this.field_193623_i - 1) : lllllllllllIIllIIlIllllllIIIIIll.toString();
            }
            if (lllllllllllIIllIIlIllllllIIIIIll != null) {
                lllllllllllIIllIIlIllllllIIIIIll.append(lllllllllllIIllIIlIllllllIIIIIIl);
            }
        }
        throw this.func_193602_b("Missing termination quote");
    }
    
    public static NBTTagCompound getTagFromJson(final String lllllllllllIIllIIlIllllllIlIllIl) throws NBTException {
        return new JsonToNBT(lllllllllllIIllIIlIllllllIlIllIl).func_193609_a();
    }
    
    private NBTBase func_193596_c(final String lllllllllllIIllIIlIllllllIIIllIl) {
        try {
            if (JsonToNBT.field_193617_c.matcher(lllllllllllIIllIIlIllllllIIIllIl).matches()) {
                return new NBTTagFloat(Float.parseFloat(lllllllllllIIllIIlIllllllIIIllIl.substring(0, lllllllllllIIllIIlIllllllIIIllIl.length() - 1)));
            }
            if (JsonToNBT.field_193618_d.matcher(lllllllllllIIllIIlIllllllIIIllIl).matches()) {
                return new NBTTagByte(Byte.parseByte(lllllllllllIIllIIlIllllllIIIllIl.substring(0, lllllllllllIIllIIlIllllllIIIllIl.length() - 1)));
            }
            if (JsonToNBT.field_193619_e.matcher(lllllllllllIIllIIlIllllllIIIllIl).matches()) {
                return new NBTTagLong(Long.parseLong(lllllllllllIIllIIlIllllllIIIllIl.substring(0, lllllllllllIIllIIlIllllllIIIllIl.length() - 1)));
            }
            if (JsonToNBT.field_193620_f.matcher(lllllllllllIIllIIlIllllllIIIllIl).matches()) {
                return new NBTTagShort(Short.parseShort(lllllllllllIIllIIlIllllllIIIllIl.substring(0, lllllllllllIIllIIlIllllllIIIllIl.length() - 1)));
            }
            if (JsonToNBT.field_193621_g.matcher(lllllllllllIIllIIlIllllllIIIllIl).matches()) {
                return new NBTTagInt(Integer.parseInt(lllllllllllIIllIIlIllllllIIIllIl));
            }
            if (JsonToNBT.field_193616_b.matcher(lllllllllllIIllIIlIllllllIIIllIl).matches()) {
                return new NBTTagDouble(Double.parseDouble(lllllllllllIIllIIlIllllllIIIllIl.substring(0, lllllllllllIIllIIlIllllllIIIllIl.length() - 1)));
            }
            if (JsonToNBT.field_193615_a.matcher(lllllllllllIIllIIlIllllllIIIllIl).matches()) {
                return new NBTTagDouble(Double.parseDouble(lllllllllllIIllIIlIllllllIIIllIl));
            }
            if ("true".equalsIgnoreCase(lllllllllllIIllIIlIllllllIIIllIl)) {
                return new NBTTagByte((byte)1);
            }
            if ("false".equalsIgnoreCase(lllllllllllIIllIIlIllllllIIIllIl)) {
                return new NBTTagByte((byte)0);
            }
        }
        catch (NumberFormatException ex) {}
        return new NBTTagString(lllllllllllIIllIIlIllllllIIIllIl);
    }
    
    private String func_193614_i() {
        final int lllllllllllIIllIIlIlllllIllllIII = this.field_193623_i;
        while (this.func_193612_g() && this.func_193599_a(this.func_193598_n())) {
            ++this.field_193623_i;
        }
        return this.field_193622_h.substring(lllllllllllIIllIIlIlllllIllllIII, this.field_193623_i);
    }
    
    protected NBTTagCompound func_193593_f() throws NBTException {
        this.func_193604_b('{');
        final NBTTagCompound lllllllllllIIllIIlIlllllIllIlIII = new NBTTagCompound();
        this.func_193607_l();
        while (this.func_193612_g() && this.func_193598_n() != '}') {
            final String lllllllllllIIllIIlIlllllIllIIlll = this.func_193601_b();
            if (lllllllllllIIllIIlIlllllIllIIlll.isEmpty()) {
                throw this.func_193602_b("Expected non-empty key");
            }
            this.func_193604_b(':');
            lllllllllllIIllIIlIlllllIllIlIII.setTag(lllllllllllIIllIIlIlllllIllIIlll, this.func_193610_d());
            if (!this.func_193613_m()) {
                break;
            }
            if (!this.func_193612_g()) {
                throw this.func_193602_b("Expected key");
            }
        }
        this.func_193604_b('}');
        return lllllllllllIIllIIlIlllllIllIlIII;
    }
    
    private char func_193598_n() {
        return this.func_193597_b(0);
    }
    
    private NBTBase func_193600_j() throws NBTException {
        this.func_193604_b('[');
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected value");
        }
        final NBTTagList lllllllllllIIllIIlIlllllIlIlllIl = new NBTTagList();
        int lllllllllllIIllIIlIlllllIlIlllII = -1;
        while (this.func_193598_n() != ']') {
            final NBTBase lllllllllllIIllIIlIlllllIlIllIll = this.func_193610_d();
            final int lllllllllllIIllIIlIlllllIlIllIlI = lllllllllllIIllIIlIlllllIlIllIll.getId();
            if (lllllllllllIIllIIlIlllllIlIlllII < 0) {
                lllllllllllIIllIIlIlllllIlIlllII = lllllllllllIIllIIlIlllllIlIllIlI;
            }
            else if (lllllllllllIIllIIlIlllllIlIllIlI != lllllllllllIIllIIlIlllllIlIlllII) {
                throw this.func_193602_b("Unable to insert " + NBTBase.func_193581_j(lllllllllllIIllIIlIlllllIlIllIlI) + " into ListTag of type " + NBTBase.func_193581_j(lllllllllllIIllIIlIlllllIlIlllII));
            }
            lllllllllllIIllIIlIlllllIlIlllIl.appendTag(lllllllllllIIllIIlIlllllIlIllIll);
            if (!this.func_193613_m()) {
                break;
            }
            if (!this.func_193612_g()) {
                throw this.func_193602_b("Expected value");
            }
        }
        this.func_193604_b(']');
        return lllllllllllIIllIIlIlllllIlIlllIl;
    }
    
    private boolean func_193608_a(final int lllllllllllIIllIIlIlllllIIlIIllI) {
        return this.field_193623_i + lllllllllllIIllIIlIlllllIIlIIllI < this.field_193622_h.length();
    }
    
    private boolean func_193613_m() {
        this.func_193607_l();
        if (this.func_193612_g() && this.func_193598_n() == ',') {
            ++this.field_193623_i;
            this.func_193607_l();
            return true;
        }
        return false;
    }
    
    @VisibleForTesting
    JsonToNBT(final String lllllllllllIIllIIlIllllllIlIIIlI) {
        this.field_193622_h = lllllllllllIIllIIlIllllllIlIIIlI;
    }
    
    protected String func_193601_b() throws NBTException {
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected key");
        }
        return (this.func_193598_n() == '\"') ? this.func_193595_h() : this.func_193614_i();
    }
    
    protected NBTBase func_193605_e() throws NBTException {
        return (this.func_193608_a(2) && this.func_193597_b(1) != '\"' && this.func_193597_b(2) == ';') ? this.func_193606_k() : this.func_193600_j();
    }
    
    protected NBTBase func_193610_d() throws NBTException {
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected value");
        }
        final char lllllllllllIIllIIlIlllllIlllIIlI = this.func_193598_n();
        if (lllllllllllIIllIIlIlllllIlllIIlI == '{') {
            return this.func_193593_f();
        }
        return (lllllllllllIIllIIlIlllllIlllIIlI == '[') ? this.func_193605_e() : this.func_193611_c();
    }
    
    boolean func_193612_g() {
        return this.func_193608_a(0);
    }
}
