// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;

public interface ICriterionTrigger<T extends ICriterionInstance>
{
    ResourceLocation func_192163_a();
    
    void func_192165_a(final PlayerAdvancements p0, final Listener<T> p1);
    
    void func_192164_b(final PlayerAdvancements p0, final Listener<T> p1);
    
    void func_192167_a(final PlayerAdvancements p0);
    
    T func_192166_a(final JsonObject p0, final JsonDeserializationContext p1);
    
    public static class Listener<T extends ICriterionInstance>
    {
        private final /* synthetic */ T field_192160_a;
        private final /* synthetic */ Advancement field_192161_b;
        private final /* synthetic */ String field_192162_c;
        
        public T func_192158_a() {
            return this.field_192160_a;
        }
        
        public Listener(final T llllllllllllIllllIIIIIllIIIllIll, final Advancement llllllllllllIllllIIIIIllIIIllIlI, final String llllllllllllIllllIIIIIllIIIllIIl) {
            this.field_192160_a = llllllllllllIllllIIIIIllIIIllIll;
            this.field_192161_b = llllllllllllIllllIIIIIllIIIllIlI;
            this.field_192162_c = llllllllllllIllllIIIIIllIIIllIIl;
        }
        
        public void func_192159_a(final PlayerAdvancements llllllllllllIllllIIIIIllIIIlIIlI) {
            llllllllllllIllllIIIIIllIIIlIIlI.func_192750_a(this.field_192161_b, this.field_192162_c);
        }
        
        @Override
        public int hashCode() {
            int llllllllllllIllllIIIIIllIIIIIIll = this.field_192160_a.hashCode();
            llllllllllllIllllIIIIIllIIIIIIll = 31 * llllllllllllIllllIIIIIllIIIIIIll + this.field_192161_b.hashCode();
            llllllllllllIllllIIIIIllIIIIIIll = 31 * llllllllllllIllllIIIIIllIIIIIIll + this.field_192162_c.hashCode();
            return llllllllllllIllllIIIIIllIIIIIIll;
        }
        
        @Override
        public boolean equals(final Object llllllllllllIllllIIIIIllIIIIlIll) {
            if (this == llllllllllllIllllIIIIIllIIIIlIll) {
                return true;
            }
            if (llllllllllllIllllIIIIIllIIIIlIll != null && this.getClass() == llllllllllllIllllIIIIIllIIIIlIll.getClass()) {
                final Listener<?> llllllllllllIllllIIIIIllIIIIlIlI = (Listener<?>)llllllllllllIllllIIIIIllIIIIlIll;
                return this.field_192160_a.equals(llllllllllllIllllIIIIIllIIIIlIlI.field_192160_a) && this.field_192161_b.equals(llllllllllllIllllIIIIIllIIIIlIlI.field_192161_b) && this.field_192162_c.equals(llllllllllllIllllIIIIIllIIIIlIlI.field_192162_c);
            }
            return false;
        }
    }
}
