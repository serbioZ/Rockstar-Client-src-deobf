// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import javax.annotation.Nullable;
import net.minecraft.inventory.EntityEquipmentSlot;

public abstract class Enchantment
{
    private final /* synthetic */ Rarity rarity;
    private final /* synthetic */ EntityEquipmentSlot[] applicableEquipmentTypes;
    @Nullable
    public /* synthetic */ EnumEnchantmentType type;
    protected /* synthetic */ String name;
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Enchantment> REGISTRY;
    
    public final boolean func_191560_c(final Enchantment lllllllllllIllIllllIllIIllllIIII) {
        return this.canApplyTogether(lllllllllllIllIllllIllIIllllIIII) && lllllllllllIllIllllIllIIllllIIII.canApplyTogether(this);
    }
    
    public boolean isTreasureEnchantment() {
        return false;
    }
    
    public boolean canApply(final ItemStack lllllllllllIllIllllIllIIllIlIIlI) {
        return this.type.canEnchantItem(lllllllllllIllIllllIllIIllIlIIlI.getItem());
    }
    
    public Enchantment setName(final String lllllllllllIllIllllIllIIlllIIlII) {
        this.name = lllllllllllIllIllllIllIIlllIIlII;
        return this;
    }
    
    protected boolean canApplyTogether(final Enchantment lllllllllllIllIllllIllIIlllIlIII) {
        return this != lllllllllllIllIllllIllIIlllIlIII;
    }
    
    public int calcModifierDamage(final int lllllllllllIllIllllIllIIlllllIII, final DamageSource lllllllllllIllIllllIllIIllllIlll) {
        return 0;
    }
    
    protected Enchantment(final Rarity lllllllllllIllIllllIllIlIIlIIlII, final EnumEnchantmentType lllllllllllIllIllllIllIlIIlIIIll, final EntityEquipmentSlot[] lllllllllllIllIllllIllIlIIlIIIlI) {
        this.rarity = lllllllllllIllIllllIllIlIIlIIlII;
        this.type = lllllllllllIllIllllIllIlIIlIIIll;
        this.applicableEquipmentTypes = lllllllllllIllIllllIllIlIIlIIIlI;
    }
    
    public boolean func_190936_d() {
        return false;
    }
    
    public List<ItemStack> getEntityEquipment(final EntityLivingBase lllllllllllIllIllllIllIlIIIIllll) {
        final List<ItemStack> lllllllllllIllIllllIllIlIIIlIIll = (List<ItemStack>)Lists.newArrayList();
        final float lllllllllllIllIllllIllIlIIIIlIlI;
        final byte lllllllllllIllIllllIllIlIIIIlIll = (byte)((EntityEquipmentSlot[])(Object)(lllllllllllIllIllllIllIlIIIIlIlI = (float)(Object)this.applicableEquipmentTypes)).length;
        for (long lllllllllllIllIllllIllIlIIIIllII = 0; lllllllllllIllIllllIllIlIIIIllII < lllllllllllIllIllllIllIlIIIIlIll; ++lllllllllllIllIllllIllIlIIIIllII) {
            final EntityEquipmentSlot lllllllllllIllIllllIllIlIIIlIIlI = lllllllllllIllIllllIllIlIIIIlIlI[lllllllllllIllIllllIllIlIIIIllII];
            final ItemStack lllllllllllIllIllllIllIlIIIlIIIl = lllllllllllIllIllllIllIlIIIIllll.getItemStackFromSlot(lllllllllllIllIllllIllIlIIIlIIlI);
            if (!lllllllllllIllIllllIllIlIIIlIIIl.func_190926_b()) {
                lllllllllllIllIllllIllIlIIIlIIll.add(lllllllllllIllIllllIllIlIIIlIIIl);
            }
        }
        return lllllllllllIllIllllIllIlIIIlIIll;
    }
    
    public String getTranslatedName(final int lllllllllllIllIllllIllIIllIlIlll) {
        String lllllllllllIllIllllIllIIllIllIIl = I18n.translateToLocal(this.getName());
        if (this.func_190936_d()) {
            lllllllllllIllIllllIllIIllIllIIl = TextFormatting.RED + lllllllllllIllIllllIllIIllIllIIl;
        }
        return (lllllllllllIllIllllIllIIllIlIlll == 1 && this.getMaxLevel() == 1) ? lllllllllllIllIllllIllIIllIllIIl : (String.valueOf(lllllllllllIllIllllIllIIllIllIIl) + " " + I18n.translateToLocal("enchantment.level." + lllllllllllIllIllllIllIIllIlIlll));
    }
    
    public Rarity getRarity() {
        return this.rarity;
    }
    
    @Nullable
    public static Enchantment getEnchantmentByLocation(final String lllllllllllIllIllllIllIlIIlIlIlI) {
        return Enchantment.REGISTRY.getObject(new ResourceLocation(lllllllllllIllIllllIllIlIIlIlIlI));
    }
    
    @Nullable
    public static Enchantment getEnchantmentByID(final int lllllllllllIllIllllIllIlIIllIIII) {
        return Enchantment.REGISTRY.getObjectById(lllllllllllIllIllllIllIlIIllIIII);
    }
    
    public int getMaxLevel() {
        return 1;
    }
    
    public void onUserHurt(final EntityLivingBase lllllllllllIllIllllIllIIllIIlIlI, final Entity lllllllllllIllIllllIllIIllIIlIIl, final int lllllllllllIllIllllIllIIllIIlIII) {
    }
    
    public int getMaxEnchantability(final int lllllllllllIllIllllIllIIlllllIlI) {
        return this.getMinEnchantability(lllllllllllIllIllllIllIIlllllIlI) + 5;
    }
    
    public static int getEnchantmentID(final Enchantment lllllllllllIllIllllIllIlIIlIlllI) {
        return Enchantment.REGISTRY.getIDForObject(lllllllllllIllIllllIllIlIIlIlllI);
    }
    
    static {
        REGISTRY = new RegistryNamespaced<ResourceLocation, Enchantment>();
    }
    
    public int getMinEnchantability(final int lllllllllllIllIllllIllIlIIIIIIII) {
        return 1 + lllllllllllIllIllllIllIlIIIIIIII * 10;
    }
    
    public int getMinLevel() {
        return 1;
    }
    
    public static void registerEnchantments() {
        final EntityEquipmentSlot[] lllllllllllIllIllllIllIIllIIIlII = { EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET };
        Enchantment.REGISTRY.register(0, new ResourceLocation("protection"), new EnchantmentProtection(Rarity.COMMON, EnchantmentProtection.Type.ALL, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(1, new ResourceLocation("fire_protection"), new EnchantmentProtection(Rarity.UNCOMMON, EnchantmentProtection.Type.FIRE, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(2, new ResourceLocation("feather_falling"), new EnchantmentProtection(Rarity.UNCOMMON, EnchantmentProtection.Type.FALL, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(3, new ResourceLocation("blast_protection"), new EnchantmentProtection(Rarity.RARE, EnchantmentProtection.Type.EXPLOSION, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(4, new ResourceLocation("projectile_protection"), new EnchantmentProtection(Rarity.UNCOMMON, EnchantmentProtection.Type.PROJECTILE, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(5, new ResourceLocation("respiration"), new EnchantmentOxygen(Rarity.RARE, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(6, new ResourceLocation("aqua_affinity"), new EnchantmentWaterWorker(Rarity.RARE, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(7, new ResourceLocation("thorns"), new EnchantmentThorns(Rarity.VERY_RARE, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(8, new ResourceLocation("depth_strider"), new EnchantmentWaterWalker(Rarity.RARE, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(9, new ResourceLocation("frost_walker"), new EnchantmentFrostWalker(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.FEET }));
        Enchantment.REGISTRY.register(10, new ResourceLocation("binding_curse"), new EnchantmentBindingCurse(Rarity.VERY_RARE, lllllllllllIllIllllIllIIllIIIlII));
        Enchantment.REGISTRY.register(16, new ResourceLocation("sharpness"), new EnchantmentDamage(Rarity.COMMON, 0, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(17, new ResourceLocation("smite"), new EnchantmentDamage(Rarity.UNCOMMON, 1, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(18, new ResourceLocation("bane_of_arthropods"), new EnchantmentDamage(Rarity.UNCOMMON, 2, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(19, new ResourceLocation("knockback"), new EnchantmentKnockback(Rarity.UNCOMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(20, new ResourceLocation("fire_aspect"), new EnchantmentFireAspect(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(21, new ResourceLocation("looting"), new EnchantmentLootBonus(Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(22, new ResourceLocation("sweeping"), new EnchantmentSweepingEdge(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(32, new ResourceLocation("efficiency"), new EnchantmentDigging(Rarity.COMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(33, new ResourceLocation("silk_touch"), new EnchantmentUntouching(Rarity.VERY_RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(34, new ResourceLocation("unbreaking"), new EnchantmentDurability(Rarity.UNCOMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(35, new ResourceLocation("fortune"), new EnchantmentLootBonus(Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(48, new ResourceLocation("power"), new EnchantmentArrowDamage(Rarity.COMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(49, new ResourceLocation("punch"), new EnchantmentArrowKnockback(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(50, new ResourceLocation("flame"), new EnchantmentArrowFire(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(51, new ResourceLocation("infinity"), new EnchantmentArrowInfinite(Rarity.VERY_RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(61, new ResourceLocation("luck_of_the_sea"), new EnchantmentLootBonus(Rarity.RARE, EnumEnchantmentType.FISHING_ROD, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(62, new ResourceLocation("lure"), new EnchantmentFishingSpeed(Rarity.RARE, EnumEnchantmentType.FISHING_ROD, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(70, new ResourceLocation("mending"), new EnchantmentMending(Rarity.RARE, EntityEquipmentSlot.values()));
        Enchantment.REGISTRY.register(71, new ResourceLocation("vanishing_curse"), new EnchantmentVanishingCurse(Rarity.VERY_RARE, EntityEquipmentSlot.values()));
    }
    
    public float calcDamageByCreature(final int lllllllllllIllIllllIllIIllllIlIl, final EnumCreatureAttribute lllllllllllIllIllllIllIIllllIlII) {
        return 0.0f;
    }
    
    public String getName() {
        return "enchantment." + this.name;
    }
    
    public void onEntityDamaged(final EntityLivingBase lllllllllllIllIllllIllIIllIIlllI, final Entity lllllllllllIllIllllIllIIllIIllIl, final int lllllllllllIllIllllIllIIllIIllII) {
    }
    
    public enum Rarity
    {
        private final /* synthetic */ int weight;
        
        RARE("RARE", 2, 2), 
        UNCOMMON("UNCOMMON", 1, 5), 
        COMMON("COMMON", 0, 10), 
        VERY_RARE("VERY_RARE", 3, 1);
        
        private Rarity(final String llllllllllllIlIIIlIlllIIllllIlll, final int llllllllllllIlIIIlIlllIIllllIllI, final int llllllllllllIlIIIlIlllIIllllIlIl) {
            this.weight = llllllllllllIlIIIlIlllIIllllIlIl;
        }
        
        public int getWeight() {
            return this.weight;
        }
    }
}
