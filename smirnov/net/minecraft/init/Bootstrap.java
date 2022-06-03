// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.init;

import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemArmor;
import java.util.UUID;
import com.mojang.authlib.GameProfile;
import net.minecraft.util.StringUtils;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.block.BlockSkull;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.item.ItemDye;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.BlockTNT;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemBucket;
import net.minecraft.entity.item.EntityBoat;
import java.util.Random;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IPosition;
import net.minecraft.world.World;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.block.BlockDispenser;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.LoggingPrintStream;
import java.io.OutputStream;
import net.minecraft.server.DebugLoggingPrintStream;
import net.minecraft.world.storage.loot.LootTableList;
import java.io.File;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.stats.StatList;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityList;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.item.Item;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.potion.Potion;
import net.minecraft.block.BlockFire;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import org.apache.logging.log4j.Logger;
import java.io.PrintStream;

public class Bootstrap
{
    public static /* synthetic */ boolean field_194219_b;
    public static final /* synthetic */ PrintStream SYSOUT;
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ boolean alreadyRegistered;
    
    public static boolean isRegistered() {
        return Bootstrap.alreadyRegistered;
    }
    
    public static void register() {
        if (!Bootstrap.alreadyRegistered) {
            Bootstrap.alreadyRegistered = true;
            redirectOutputToLog();
            SoundEvent.registerSounds();
            Block.registerBlocks();
            BlockFire.init();
            Potion.registerPotions();
            Enchantment.registerEnchantments();
            Item.registerItems();
            PotionType.registerPotionTypes();
            PotionHelper.init();
            EntityList.init();
            Biome.registerBiomes();
            registerDispenserBehaviors();
            if (!CraftingManager.func_193377_a()) {
                Bootstrap.field_194219_b = true;
                Bootstrap.LOGGER.error("Errors with built-in recipes!");
            }
            StatList.init();
            if (Bootstrap.LOGGER.isDebugEnabled()) {
                if (new AdvancementManager(null).func_193767_b()) {
                    Bootstrap.field_194219_b = true;
                    Bootstrap.LOGGER.error("Errors with built-in advancements!");
                }
                if (!LootTableList.func_193579_b()) {
                    Bootstrap.field_194219_b = true;
                    Bootstrap.LOGGER.error("Errors with built-in loot tables");
                }
            }
        }
    }
    
    private static void redirectOutputToLog() {
        if (Bootstrap.LOGGER.isDebugEnabled()) {
            System.setErr(new DebugLoggingPrintStream("STDERR", System.err));
            System.setOut(new DebugLoggingPrintStream("STDOUT", Bootstrap.SYSOUT));
        }
        else {
            System.setErr(new LoggingPrintStream("STDERR", System.err));
            System.setOut(new LoggingPrintStream("STDOUT", Bootstrap.SYSOUT));
        }
    }
    
    static {
        SYSOUT = System.out;
        LOGGER = LogManager.getLogger();
    }
    
    static void registerDispenserBehaviors() {
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.ARROW, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllllllIIIIIIIllIIlIIlIll, final IPosition llllllllllllllIIIIIIIllIIlIIIllI, final ItemStack llllllllllllllIIIIIIIllIIlIIlIIl) {
                final EntityTippedArrow llllllllllllllIIIIIIIllIIlIIlIII = new EntityTippedArrow(llllllllllllllIIIIIIIllIIlIIlIll, llllllllllllllIIIIIIIllIIlIIIllI.getX(), llllllllllllllIIIIIIIllIIlIIIllI.getY(), llllllllllllllIIIIIIIllIIlIIIllI.getZ());
                llllllllllllllIIIIIIIllIIlIIlIII.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
                return llllllllllllllIIIIIIIllIIlIIlIII;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.TIPPED_ARROW, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllllIIIIlIIIlIlllIlIlIIl, final IPosition llllllllllllIIIIlIIIlIlllIlIlIII, final ItemStack llllllllllllIIIIlIIIlIlllIlIlIll) {
                final EntityTippedArrow llllllllllllIIIIlIIIlIlllIlIlIlI = new EntityTippedArrow(llllllllllllIIIIlIIIlIlllIlIlIIl, llllllllllllIIIIlIIIlIlllIlIlIII.getX(), llllllllllllIIIIlIIIlIlllIlIlIII.getY(), llllllllllllIIIIlIIIlIlllIlIlIII.getZ());
                llllllllllllIIIIlIIIlIlllIlIlIlI.setPotionEffect(llllllllllllIIIIlIIIlIlllIlIlIll);
                llllllllllllIIIIlIIIlIlllIlIlIlI.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
                return llllllllllllIIIIlIIIlIlllIlIlIlI;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPECTRAL_ARROW, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllIlllIIIlIIlIlllIlIIlIl, final IPosition llllllllllIlllIIIlIIlIlllIlIIlII, final ItemStack llllllllllIlllIIIlIIlIlllIlIIIll) {
                final EntityArrow llllllllllIlllIIIlIIlIlllIlIIIlI = new EntitySpectralArrow(llllllllllIlllIIIlIIlIlllIlIIlIl, llllllllllIlllIIIlIIlIlllIlIIlII.getX(), llllllllllIlllIIIlIIlIlllIlIIlII.getY(), llllllllllIlllIIIlIIlIlllIlIIlII.getZ());
                llllllllllIlllIIIlIIlIlllIlIIIlI.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
                return llllllllllIlllIIIlIIlIlllIlIIIlI;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.EGG, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllllIIIIlIIlIlllllIllIlI, final IPosition llllllllllllIIIIlIIlIlllllIlIllI, final ItemStack llllllllllllIIIIlIIlIlllllIllIII) {
                return new EntityEgg(llllllllllllIIIIlIIlIlllllIllIlI, llllllllllllIIIIlIIlIlllllIlIllI.getX(), llllllllllllIIIIlIIlIlllllIlIllI.getY(), llllllllllllIIIIlIIlIlllllIlIllI.getZ());
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SNOWBALL, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllIIIIIIllIIlllIIlIIIll, final IPosition lllllllllllIIIIIIllIIlllIIIlllll, final ItemStack lllllllllllIIIIIIllIIlllIIlIIIIl) {
                return new EntitySnowball(lllllllllllIIIIIIllIIlllIIlIIIll, lllllllllllIIIIIIllIIlllIIIlllll.getX(), lllllllllllIIIIIIllIIlllIIIlllll.getY(), lllllllllllIIIIIIllIIlllIIIlllll.getZ());
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.EXPERIENCE_BOTTLE, new BehaviorProjectileDispense() {
            @Override
            protected float getProjectileVelocity() {
                return super.getProjectileVelocity() * 1.25f;
            }
            
            @Override
            protected IProjectile getProjectileEntity(final World llllllllllllIlIlIIlIIlllIlIIlIIl, final IPosition llllllllllllIlIlIIlIIlllIlIIlIII, final ItemStack llllllllllllIlIlIIlIIlllIlIIlIlI) {
                return new EntityExpBottle(llllllllllllIlIlIIlIIlllIlIIlIIl, llllllllllllIlIlIIlIIlllIlIIlIII.getX(), llllllllllllIlIlIIlIIlllIlIIlIII.getY(), llllllllllllIlIlIIlIIlllIlIIlIII.getZ());
            }
            
            @Override
            protected float getProjectileInaccuracy() {
                return super.getProjectileInaccuracy() * 0.5f;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPLASH_POTION, new IBehaviorDispenseItem() {
            @Override
            public ItemStack dispense(final IBlockSource llllllllllllIlllllIIlIlIIIIlllll, final ItemStack llllllllllllIlllllIIlIlIIIlIIIIl) {
                return new BehaviorProjectileDispense() {
                    @Override
                    protected IProjectile getProjectileEntity(final World lllllllllllIIIIllIllllIlllIlIlll, final IPosition lllllllllllIIIIllIllllIlllIlIllI, final ItemStack lllllllllllIIIIllIllllIlllIlIlIl) {
                        return new EntityPotion(lllllllllllIIIIllIllllIlllIlIlll, lllllllllllIIIIllIllllIlllIlIllI.getX(), lllllllllllIIIIllIllllIlllIlIllI.getY(), lllllllllllIIIIllIllllIlllIlIllI.getZ(), llllllllllllIlllllIIlIlIIIlIIIIl.copy());
                    }
                    
                    @Override
                    protected float getProjectileVelocity() {
                        return super.getProjectileVelocity() * 1.25f;
                    }
                    
                    @Override
                    protected float getProjectileInaccuracy() {
                        return super.getProjectileInaccuracy() * 0.5f;
                    }
                }.dispense(llllllllllllIlllllIIlIlIIIIlllll, llllllllllllIlllllIIlIlIIIlIIIIl);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.LINGERING_POTION, new IBehaviorDispenseItem() {
            @Override
            public ItemStack dispense(final IBlockSource lllllllllllIIIllIIIIIIIllllIllII, final ItemStack lllllllllllIIIllIIIIIIIllllIlIII) {
                return new BehaviorProjectileDispense() {
                    @Override
                    protected float getProjectileInaccuracy() {
                        return super.getProjectileInaccuracy() * 0.5f;
                    }
                    
                    @Override
                    protected float getProjectileVelocity() {
                        return super.getProjectileVelocity() * 1.25f;
                    }
                    
                    @Override
                    protected IProjectile getProjectileEntity(final World lllllllllllIlIlllIlllIlllIllllll, final IPosition lllllllllllIlIlllIlllIlllIlllllI, final ItemStack lllllllllllIlIlllIlllIllllIIIIIl) {
                        return new EntityPotion(lllllllllllIlIlllIlllIlllIllllll, lllllllllllIlIlllIlllIlllIlllllI.getX(), lllllllllllIlIlllIlllIlllIlllllI.getY(), lllllllllllIlIlllIlllIlllIlllllI.getZ(), lllllllllllIIIllIIIIIIIllllIlIII.copy());
                    }
                }.dispense(lllllllllllIIIllIIIIIIIllllIllII, lllllllllllIIIllIIIIIIIllllIlIII);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPAWN_EGG, new BehaviorDefaultDispenseItem() {
            public ItemStack dispenseStack(final IBlockSource llllllllllllIIllllIllIlllllllIlI, final ItemStack llllllllllllIIllllIllIlllllllIIl) {
                final EnumFacing llllllllllllIIllllIllIllllllllll = llllllllllllIIllllIllIlllllllIlI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final double llllllllllllIIllllIllIlllllllllI = llllllllllllIIllllIllIlllllllIlI.getX() + llllllllllllIIllllIllIllllllllll.getFrontOffsetX();
                final double llllllllllllIIllllIllIllllllllIl = llllllllllllIIllllIllIlllllllIlI.getBlockPos().getY() + llllllllllllIIllllIllIllllllllll.getFrontOffsetY() + 0.2f;
                final double llllllllllllIIllllIllIllllllllII = llllllllllllIIllllIllIlllllllIlI.getZ() + llllllllllllIIllllIllIllllllllll.getFrontOffsetZ();
                final Entity llllllllllllIIllllIllIlllllllIll = ItemMonsterPlacer.spawnCreature(llllllllllllIIllllIllIlllllllIlI.getWorld(), ItemMonsterPlacer.func_190908_h(llllllllllllIIllllIllIlllllllIIl), llllllllllllIIllllIllIlllllllllI, llllllllllllIIllllIllIllllllllIl, llllllllllllIIllllIllIllllllllII);
                if (llllllllllllIIllllIllIlllllllIll instanceof EntityLivingBase && llllllllllllIIllllIllIlllllllIIl.hasDisplayName()) {
                    llllllllllllIIllllIllIlllllllIll.setCustomNameTag(llllllllllllIIllllIllIlllllllIIl.getDisplayName());
                }
                ItemMonsterPlacer.applyItemEntityDataToEntity(llllllllllllIIllllIllIlllllllIlI.getWorld(), null, llllllllllllIIllllIllIlllllllIIl, llllllllllllIIllllIllIlllllllIll);
                llllllllllllIIllllIllIlllllllIIl.func_190918_g(1);
                return llllllllllllIIllllIllIlllllllIIl;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FIREWORKS, new BehaviorDefaultDispenseItem() {
            public ItemStack dispenseStack(final IBlockSource lllllllllllIlllllllllIIIIlIllllI, final ItemStack lllllllllllIlllllllllIIIIlIlIllI) {
                final EnumFacing lllllllllllIlllllllllIIIIlIlllII = lllllllllllIlllllllllIIIIlIllllI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final double lllllllllllIlllllllllIIIIlIllIll = lllllllllllIlllllllllIIIIlIllllI.getX() + lllllllllllIlllllllllIIIIlIlllII.getFrontOffsetX();
                final double lllllllllllIlllllllllIIIIlIllIlI = lllllllllllIlllllllllIIIIlIllllI.getBlockPos().getY() + 0.2f;
                final double lllllllllllIlllllllllIIIIlIllIIl = lllllllllllIlllllllllIIIIlIllllI.getZ() + lllllllllllIlllllllllIIIIlIlllII.getFrontOffsetZ();
                final EntityFireworkRocket lllllllllllIlllllllllIIIIlIllIII = new EntityFireworkRocket(lllllllllllIlllllllllIIIIlIllllI.getWorld(), lllllllllllIlllllllllIIIIlIllIll, lllllllllllIlllllllllIIIIlIllIlI, lllllllllllIlllllllllIIIIlIllIIl, lllllllllllIlllllllllIIIIlIlIllI);
                lllllllllllIlllllllllIIIIlIllllI.getWorld().spawnEntityInWorld(lllllllllllIlllllllllIIIIlIllIII);
                lllllllllllIlllllllllIIIIlIlIllI.func_190918_g(1);
                return lllllllllllIlllllllllIIIIlIlIllI;
            }
            
            @Override
            protected void playDispenseSound(final IBlockSource lllllllllllIlllllllllIIIIlIIlllI) {
                lllllllllllIlllllllllIIIIlIIlllI.getWorld().playEvent(1004, lllllllllllIlllllllllIIIIlIIlllI.getBlockPos(), 0);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FIRE_CHARGE, new BehaviorDefaultDispenseItem() {
            @Override
            protected void playDispenseSound(final IBlockSource llllllllllllllIIlIIIlIllIIlIllIl) {
                llllllllllllllIIlIIIlIllIIlIllIl.getWorld().playEvent(1018, llllllllllllllIIlIIIlIllIIlIllIl.getBlockPos(), 0);
            }
            
            public ItemStack dispenseStack(final IBlockSource llllllllllllllIIlIIIlIllIIlllIll, final ItemStack llllllllllllllIIlIIIlIllIIlllIIl) {
                final EnumFacing llllllllllllllIIlIIIlIllIlIIIlIl = llllllllllllllIIlIIIlIllIIlllIll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final IPosition llllllllllllllIIlIIIlIllIlIIIlII = BlockDispenser.getDispensePosition(llllllllllllllIIlIIIlIllIIlllIll);
                final double llllllllllllllIIlIIIlIllIlIIIIll = llllllllllllllIIlIIIlIllIlIIIlII.getX() + llllllllllllllIIlIIIlIllIlIIIlIl.getFrontOffsetX() * 0.3f;
                final double llllllllllllllIIlIIIlIllIlIIIIlI = llllllllllllllIIlIIIlIllIlIIIlII.getY() + llllllllllllllIIlIIIlIllIlIIIlIl.getFrontOffsetY() * 0.3f;
                final double llllllllllllllIIlIIIlIllIlIIIIIl = llllllllllllllIIlIIIlIllIlIIIlII.getZ() + llllllllllllllIIlIIIlIllIlIIIlIl.getFrontOffsetZ() * 0.3f;
                final World llllllllllllllIIlIIIlIllIlIIIIII = llllllllllllllIIlIIIlIllIIlllIll.getWorld();
                final Random llllllllllllllIIlIIIlIllIIllllll = llllllllllllllIIlIIIlIllIlIIIIII.rand;
                final double llllllllllllllIIlIIIlIllIIlllllI = llllllllllllllIIlIIIlIllIIllllll.nextGaussian() * 0.05 + llllllllllllllIIlIIIlIllIlIIIlIl.getFrontOffsetX();
                final double llllllllllllllIIlIIIlIllIIllllIl = llllllllllllllIIlIIIlIllIIllllll.nextGaussian() * 0.05 + llllllllllllllIIlIIIlIllIlIIIlIl.getFrontOffsetY();
                final double llllllllllllllIIlIIIlIllIIllllII = llllllllllllllIIlIIIlIllIIllllll.nextGaussian() * 0.05 + llllllllllllllIIlIIIlIllIlIIIlIl.getFrontOffsetZ();
                llllllllllllllIIlIIIlIllIlIIIIII.spawnEntityInWorld(new EntitySmallFireball(llllllllllllllIIlIIIlIllIlIIIIII, llllllllllllllIIlIIIlIllIlIIIIll, llllllllllllllIIlIIIlIllIlIIIIlI, llllllllllllllIIlIIIlIllIlIIIIIl, llllllllllllllIIlIIIlIllIIlllllI, llllllllllllllIIlIIIlIllIIllllIl, llllllllllllllIIlIIIlIllIIllllII));
                llllllllllllllIIlIIIlIllIIlllIIl.func_190918_g(1);
                return llllllllllllllIIlIIIlIllIIlllIIl;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.BOAT, new BehaviorDispenseBoat(EntityBoat.Type.OAK));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPRUCE_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.SPRUCE));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.BIRCH_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.BIRCH));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.JUNGLE_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.JUNGLE));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.DARK_OAK_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.DARK_OAK));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.ACACIA_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.ACACIA));
        final IBehaviorDispenseItem llllllllllllllllllIlIlIlIIIIIllI = new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem dispenseBehavior = new BehaviorDefaultDispenseItem();
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllIllllllIIlIIllIlIll, final ItemStack lllllllllllllIllllllIIlIIllIlIlI) {
                final ItemBucket lllllllllllllIllllllIIlIIllIlllI = (ItemBucket)lllllllllllllIllllllIIlIIllIlIlI.getItem();
                final BlockPos lllllllllllllIllllllIIlIIllIllIl = lllllllllllllIllllllIIlIIllIlIll.getBlockPos().offset(lllllllllllllIllllllIIlIIllIlIll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                return lllllllllllllIllllllIIlIIllIlllI.tryPlaceContainedLiquid(null, lllllllllllllIllllllIIlIIllIlIll.getWorld(), lllllllllllllIllllllIIlIIllIllIl) ? new ItemStack(Items.BUCKET) : this.dispenseBehavior.dispense(lllllllllllllIllllllIIlIIllIlIll, lllllllllllllIllllllIIlIIllIlIlI);
            }
        };
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.LAVA_BUCKET, llllllllllllllllllIlIlIlIIIIIllI);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.WATER_BUCKET, llllllllllllllllllIlIlIlIIIIIllI);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.BUCKET, new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem dispenseBehavior = new BehaviorDefaultDispenseItem();
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllIIIIIlIlIlIllllllIl, final ItemStack lllllllllllllIIIIIlIlIlIllllllII) {
                final World lllllllllllllIIIIIlIlIlIlllllIll = lllllllllllllIIIIIlIlIlIllllllIl.getWorld();
                final BlockPos lllllllllllllIIIIIlIlIlIlllllIlI = lllllllllllllIIIIIlIlIlIllllllIl.getBlockPos().offset(lllllllllllllIIIIIlIlIlIllllllIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                final IBlockState lllllllllllllIIIIIlIlIlIlllllIIl = lllllllllllllIIIIIlIlIlIlllllIll.getBlockState(lllllllllllllIIIIIlIlIlIlllllIlI);
                final Block lllllllllllllIIIIIlIlIlIlllllIII = lllllllllllllIIIIIlIlIlIlllllIIl.getBlock();
                final Material lllllllllllllIIIIIlIlIlIllllIlll = lllllllllllllIIIIIlIlIlIlllllIIl.getMaterial();
                Item lllllllllllllIIIIIlIlIlIllllIlIl = null;
                if (Material.WATER.equals(lllllllllllllIIIIIlIlIlIllllIlll) && lllllllllllllIIIIIlIlIlIlllllIII instanceof BlockLiquid && lllllllllllllIIIIIlIlIlIlllllIIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) {
                    final Item lllllllllllllIIIIIlIlIlIllllIllI = Items.WATER_BUCKET;
                }
                else {
                    if (!Material.LAVA.equals(lllllllllllllIIIIIlIlIlIllllIlll) || !(lllllllllllllIIIIIlIlIlIlllllIII instanceof BlockLiquid) || lllllllllllllIIIIIlIlIlIlllllIIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL) != 0) {
                        return super.dispenseStack(lllllllllllllIIIIIlIlIlIllllllIl, lllllllllllllIIIIIlIlIlIllllllII);
                    }
                    lllllllllllllIIIIIlIlIlIllllIlIl = Items.LAVA_BUCKET;
                }
                lllllllllllllIIIIIlIlIlIlllllIll.setBlockToAir(lllllllllllllIIIIIlIlIlIlllllIlI);
                lllllllllllllIIIIIlIlIlIllllllII.func_190918_g(1);
                if (lllllllllllllIIIIIlIlIlIllllllII.func_190926_b()) {
                    return new ItemStack(lllllllllllllIIIIIlIlIlIllllIlIl);
                }
                if (lllllllllllllIIIIIlIlIlIllllllIl.getBlockTileEntity().addItemStack(new ItemStack(lllllllllllllIIIIIlIlIlIllllIlIl)) < 0) {
                    this.dispenseBehavior.dispense(lllllllllllllIIIIIlIlIlIllllllIl, new ItemStack(lllllllllllllIIIIIlIlIlIllllIlIl));
                }
                return lllllllllllllIIIIIlIlIlIllllllII;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FLINT_AND_STEEL, new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllllIIlIIlIlIIIIllIIllI, final ItemStack lllllllllllllIIlIIlIlIIIIllIlIlI) {
                final World lllllllllllllIIlIIlIlIIIIllIlIIl = lllllllllllllIIlIIlIlIIIIllIIllI.getWorld();
                this.field_190911_b = true;
                final BlockPos lllllllllllllIIlIIlIlIIIIllIlIII = lllllllllllllIIlIIlIlIIIIllIIllI.getBlockPos().offset(lllllllllllllIIlIIlIlIIIIllIIllI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                if (lllllllllllllIIlIIlIlIIIIllIlIIl.isAirBlock(lllllllllllllIIlIIlIlIIIIllIlIII)) {
                    lllllllllllllIIlIIlIlIIIIllIlIIl.setBlockState(lllllllllllllIIlIIlIlIIIIllIlIII, Blocks.FIRE.getDefaultState());
                    if (lllllllllllllIIlIIlIlIIIIllIlIlI.attemptDamageItem(1, lllllllllllllIIlIIlIlIIIIllIlIIl.rand, null)) {
                        lllllllllllllIIlIIlIlIIIIllIlIlI.func_190920_e(0);
                    }
                }
                else if (lllllllllllllIIlIIlIlIIIIllIlIIl.getBlockState(lllllllllllllIIlIIlIlIIIIllIlIII).getBlock() == Blocks.TNT) {
                    Blocks.TNT.onBlockDestroyedByPlayer(lllllllllllllIIlIIlIlIIIIllIlIIl, lllllllllllllIIlIIlIlIIIIllIlIII, Blocks.TNT.getDefaultState().withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
                    lllllllllllllIIlIIlIlIIIIllIlIIl.setBlockToAir(lllllllllllllIIlIIlIlIIIIllIlIII);
                }
                else {
                    this.field_190911_b = false;
                }
                return lllllllllllllIIlIIlIlIIIIllIlIlI;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.DYE, new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource llllllllllllIlIIlIlIIlllIIIIIIlI, final ItemStack llllllllllllIlIIlIlIIlllIIIIIIIl) {
                this.field_190911_b = true;
                if (EnumDyeColor.WHITE == EnumDyeColor.byDyeDamage(llllllllllllIlIIlIlIIlllIIIIIIIl.getMetadata())) {
                    final World llllllllllllIlIIlIlIIlllIIIIIlIl = llllllllllllIlIIlIlIIlllIIIIIIlI.getWorld();
                    final BlockPos llllllllllllIlIIlIlIIlllIIIIIlII = llllllllllllIlIIlIlIIlllIIIIIIlI.getBlockPos().offset(llllllllllllIlIIlIlIIlllIIIIIIlI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                    if (ItemDye.applyBonemeal(llllllllllllIlIIlIlIIlllIIIIIIIl, llllllllllllIlIIlIlIIlllIIIIIlIl, llllllllllllIlIIlIlIIlllIIIIIlII)) {
                        if (!llllllllllllIlIIlIlIIlllIIIIIlIl.isRemote) {
                            llllllllllllIlIIlIlIIlllIIIIIlIl.playEvent(2005, llllllllllllIlIIlIlIIlllIIIIIlII, 0);
                        }
                    }
                    else {
                        this.field_190911_b = false;
                    }
                    return llllllllllllIlIIlIlIIlllIIIIIIIl;
                }
                return super.dispenseStack(llllllllllllIlIIlIlIIlllIIIIIIlI, llllllllllllIlIIlIlIIlllIIIIIIIl);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(Blocks.TNT), new BehaviorDefaultDispenseItem() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllIIIllIlllIllllIllIllI, final ItemStack lllllllllllIIIllIlllIllllIlllIlI) {
                final World lllllllllllIIIllIlllIllllIlllIIl = lllllllllllIIIllIlllIllllIllIllI.getWorld();
                final BlockPos lllllllllllIIIllIlllIllllIlllIII = lllllllllllIIIllIlllIllllIllIllI.getBlockPos().offset(lllllllllllIIIllIlllIllllIllIllI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                final EntityTNTPrimed lllllllllllIIIllIlllIllllIllIlll = new EntityTNTPrimed(lllllllllllIIIllIlllIllllIlllIIl, lllllllllllIIIllIlllIllllIlllIII.getX() + 0.5, lllllllllllIIIllIlllIllllIlllIII.getY(), lllllllllllIIIllIlllIllllIlllIII.getZ() + 0.5, null);
                lllllllllllIIIllIlllIllllIlllIIl.spawnEntityInWorld(lllllllllllIIIllIlllIllllIllIlll);
                lllllllllllIIIllIlllIllllIlllIIl.playSound(null, lllllllllllIIIllIlllIllllIllIlll.posX, lllllllllllIIIllIlllIllllIllIlll.posY, lllllllllllIIIllIlllIllllIllIlll.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
                lllllllllllIIIllIlllIllllIlllIlI.func_190918_g(1);
                return lllllllllllIIIllIlllIllllIlllIlI;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SKULL, new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource llllllllllllIlllIIllllIIllIlIIll, final ItemStack llllllllllllIlllIIllllIIllIIIlll) {
                final World llllllllllllIlllIIllllIIllIlIIIl = llllllllllllIlllIIllllIIllIlIIll.getWorld();
                final EnumFacing llllllllllllIlllIIllllIIllIlIIII = llllllllllllIlllIIllllIIllIlIIll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final BlockPos llllllllllllIlllIIllllIIllIIllll = llllllllllllIlllIIllllIIllIlIIll.getBlockPos().offset(llllllllllllIlllIIllllIIllIlIIII);
                final BlockSkull llllllllllllIlllIIllllIIllIIlllI = Blocks.SKULL;
                this.field_190911_b = true;
                if (llllllllllllIlllIIllllIIllIlIIIl.isAirBlock(llllllllllllIlllIIllllIIllIIllll) && llllllllllllIlllIIllllIIllIIlllI.canDispenserPlace(llllllllllllIlllIIllllIIllIlIIIl, llllllllllllIlllIIllllIIllIIllll, llllllllllllIlllIIllllIIllIIIlll)) {
                    if (!llllllllllllIlllIIllllIIllIlIIIl.isRemote) {
                        llllllllllllIlllIIllllIIllIlIIIl.setBlockState(llllllllllllIlllIIllllIIllIIllll, llllllllllllIlllIIllllIIllIIlllI.getDefaultState().withProperty((IProperty<Comparable>)BlockSkull.FACING, EnumFacing.UP), 3);
                        final TileEntity llllllllllllIlllIIllllIIllIIllIl = llllllllllllIlllIIllllIIllIlIIIl.getTileEntity(llllllllllllIlllIIllllIIllIIllll);
                        if (llllllllllllIlllIIllllIIllIIllIl instanceof TileEntitySkull) {
                            if (llllllllllllIlllIIllllIIllIIIlll.getMetadata() == 3) {
                                GameProfile llllllllllllIlllIIllllIIllIIllII = null;
                                if (llllllllllllIlllIIllllIIllIIIlll.hasTagCompound()) {
                                    final NBTTagCompound llllllllllllIlllIIllllIIllIIlIll = llllllllllllIlllIIllllIIllIIIlll.getTagCompound();
                                    if (llllllllllllIlllIIllllIIllIIlIll.hasKey("SkullOwner", 10)) {
                                        llllllllllllIlllIIllllIIllIIllII = NBTUtil.readGameProfileFromNBT(llllllllllllIlllIIllllIIllIIlIll.getCompoundTag("SkullOwner"));
                                    }
                                    else if (llllllllllllIlllIIllllIIllIIlIll.hasKey("SkullOwner", 8)) {
                                        final String llllllllllllIlllIIllllIIllIIlIlI = llllllllllllIlllIIllllIIllIIlIll.getString("SkullOwner");
                                        if (!StringUtils.isNullOrEmpty(llllllllllllIlllIIllllIIllIIlIlI)) {
                                            llllllllllllIlllIIllllIIllIIllII = new GameProfile((UUID)null, llllllllllllIlllIIllllIIllIIlIlI);
                                        }
                                    }
                                }
                                ((TileEntitySkull)llllllllllllIlllIIllllIIllIIllIl).setPlayerProfile(llllllllllllIlllIIllllIIllIIllII);
                            }
                            else {
                                ((TileEntitySkull)llllllllllllIlllIIllllIIllIIllIl).setType(llllllllllllIlllIIllllIIllIIIlll.getMetadata());
                            }
                            ((TileEntitySkull)llllllllllllIlllIIllllIIllIIllIl).setSkullRotation(llllllllllllIlllIIllllIIllIlIIII.getOpposite().getHorizontalIndex() * 4);
                            Blocks.SKULL.checkWitherSpawn(llllllllllllIlllIIllllIIllIlIIIl, llllllllllllIlllIIllllIIllIIllll, (TileEntitySkull)llllllllllllIlllIIllllIIllIIllIl);
                        }
                        llllllllllllIlllIIllllIIllIIIlll.func_190918_g(1);
                    }
                }
                else if (ItemArmor.dispenseArmor(llllllllllllIlllIIllllIIllIlIIll, llllllllllllIlllIIllllIIllIIIlll).func_190926_b()) {
                    this.field_190911_b = false;
                }
                return llllllllllllIlllIIllllIIllIIIlll;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(Blocks.PUMPKIN), new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllIIIlllIlIIlIIIIlllIlI, final ItemStack lllllllllllIIIlllIlIIlIIIIlllIIl) {
                final World lllllllllllIIIlllIlIIlIIIIllllll = lllllllllllIIIlllIlIIlIIIIlllIlI.getWorld();
                final BlockPos lllllllllllIIIlllIlIIlIIIIlllllI = lllllllllllIIIlllIlIIlIIIIlllIlI.getBlockPos().offset(lllllllllllIIIlllIlIIlIIIIlllIlI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                final BlockPumpkin lllllllllllIIIlllIlIIlIIIIllllIl = (BlockPumpkin)Blocks.PUMPKIN;
                this.field_190911_b = true;
                if (lllllllllllIIIlllIlIIlIIIIllllll.isAirBlock(lllllllllllIIIlllIlIIlIIIIlllllI) && lllllllllllIIIlllIlIIlIIIIllllIl.canDispenserPlace(lllllllllllIIIlllIlIIlIIIIllllll, lllllllllllIIIlllIlIIlIIIIlllllI)) {
                    if (!lllllllllllIIIlllIlIIlIIIIllllll.isRemote) {
                        lllllllllllIIIlllIlIIlIIIIllllll.setBlockState(lllllllllllIIIlllIlIIlIIIIlllllI, lllllllllllIIIlllIlIIlIIIIllllIl.getDefaultState(), 3);
                    }
                    lllllllllllIIIlllIlIIlIIIIlllIIl.func_190918_g(1);
                }
                else {
                    final ItemStack lllllllllllIIIlllIlIIlIIIIllllII = ItemArmor.dispenseArmor(lllllllllllIIIlllIlIIlIIIIlllIlI, lllllllllllIIIlllIlIIlIIIIlllIIl);
                    if (lllllllllllIIIlllIlIIlIIIIllllII.func_190926_b()) {
                        this.field_190911_b = false;
                    }
                }
                return lllllllllllIIIlllIlIIlIIIIlllIIl;
            }
        });
        int llllllllllllllllllIlIlIlIIIIIIII;
        for (Exception llllllllllllllllllIlIlIlIIIIIIIl = (Exception)((EnumDyeColor[])(Object)(llllllllllllllllllIlIlIlIIIIIIII = (int)(Object)EnumDyeColor.values())).length, llllllllllllllllllIlIlIlIIIIIIlI = (Exception)0; llllllllllllllllllIlIlIlIIIIIIlI < llllllllllllllllllIlIlIlIIIIIIIl; ++llllllllllllllllllIlIlIlIIIIIIlI) {
            final EnumDyeColor llllllllllllllllllIlIlIlIIIIIlIl = llllllllllllllllllIlIlIlIIIIIIII[llllllllllllllllllIlIlIlIIIIIIlI];
            BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(BlockShulkerBox.func_190952_a(llllllllllllllllllIlIlIlIIIIIlIl)), new BehaviorDispenseShulkerBox(null));
        }
    }
    
    public static void printToSYSOUT(final String llllllllllllllllllIlIlIIllllllIl) {
        Bootstrap.SYSOUT.println(llllllllllllllllllIlIlIIllllllIl);
    }
    
    static class BehaviorDispenseShulkerBox extends BehaviorDispenseOptional
    {
        private BehaviorDispenseShulkerBox() {
        }
        
        @Override
        protected ItemStack dispenseStack(final IBlockSource llllllllllllIlIIlIIIIlllllIlIlIl, final ItemStack llllllllllllIlIIlIIIIlllllIlIlII) {
            final Block llllllllllllIlIIlIIIIlllllIlIIll = Block.getBlockFromItem(llllllllllllIlIIlIIIIlllllIlIlII.getItem());
            final World llllllllllllIlIIlIIIIlllllIlIIlI = llllllllllllIlIIlIIIIlllllIlIlIl.getWorld();
            final EnumFacing llllllllllllIlIIlIIIIlllllIlIIIl = llllllllllllIlIIlIIIIlllllIlIlIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
            final BlockPos llllllllllllIlIIlIIIIlllllIlIIII = llllllllllllIlIIlIIIIlllllIlIlIl.getBlockPos().offset(llllllllllllIlIIlIIIIlllllIlIIIl);
            this.field_190911_b = llllllllllllIlIIlIIIIlllllIlIIlI.func_190527_a(llllllllllllIlIIlIIIIlllllIlIIll, llllllllllllIlIIlIIIIlllllIlIIII, false, EnumFacing.DOWN, null);
            if (this.field_190911_b) {
                final EnumFacing llllllllllllIlIIlIIIIlllllIIllll = llllllllllllIlIIlIIIIlllllIlIIlI.isAirBlock(llllllllllllIlIIlIIIIlllllIlIIII.down()) ? llllllllllllIlIIlIIIIlllllIlIIIl : EnumFacing.UP;
                final IBlockState llllllllllllIlIIlIIIIlllllIIlllI = llllllllllllIlIIlIIIIlllllIlIIll.getDefaultState().withProperty(BlockShulkerBox.field_190957_a, llllllllllllIlIIlIIIIlllllIIllll);
                llllllllllllIlIIlIIIIlllllIlIIlI.setBlockState(llllllllllllIlIIlIIIIlllllIlIIII, llllllllllllIlIIlIIIIlllllIIlllI);
                final TileEntity llllllllllllIlIIlIIIIlllllIIllIl = llllllllllllIlIIlIIIIlllllIlIIlI.getTileEntity(llllllllllllIlIIlIIIIlllllIlIIII);
                final ItemStack llllllllllllIlIIlIIIIlllllIIllII = llllllllllllIlIIlIIIIlllllIlIlII.splitStack(1);
                if (llllllllllllIlIIlIIIIlllllIIllII.hasTagCompound()) {
                    ((TileEntityShulkerBox)llllllllllllIlIIlIIIIlllllIIllIl).func_190586_e(llllllllllllIlIIlIIIIlllllIIllII.getTagCompound().getCompoundTag("BlockEntityTag"));
                }
                if (llllllllllllIlIIlIIIIlllllIIllII.hasDisplayName()) {
                    ((TileEntityShulkerBox)llllllllllllIlIIlIIIIlllllIIllIl).func_190575_a(llllllllllllIlIIlIIIIlllllIIllII.getDisplayName());
                }
                llllllllllllIlIIlIIIIlllllIlIIlI.updateComparatorOutputLevel(llllllllllllIlIIlIIIIlllllIlIIII, llllllllllllIlIIlIIIIlllllIIlllI.getBlock());
            }
            return llllllllllllIlIIlIIIIlllllIlIlII;
        }
    }
    
    public abstract static class BehaviorDispenseOptional extends BehaviorDefaultDispenseItem
    {
        protected /* synthetic */ boolean field_190911_b;
        
        @Override
        protected void playDispenseSound(final IBlockSource llllllllllllIllllIIlIlIlllIIlIII) {
            llllllllllllIllllIIlIlIlllIIlIII.getWorld().playEvent(this.field_190911_b ? 1000 : 1001, llllllllllllIllllIIlIlIlllIIlIII.getBlockPos(), 0);
        }
        
        public BehaviorDispenseOptional() {
            this.field_190911_b = true;
        }
    }
    
    public static class BehaviorDispenseBoat extends BehaviorDefaultDispenseItem
    {
        private final /* synthetic */ EntityBoat.Type boatType;
        private final /* synthetic */ BehaviorDefaultDispenseItem dispenseBehavior;
        
        public BehaviorDispenseBoat(final EntityBoat.Type llllllllllIllllIlllIIIIlIIllIlIl) {
            this.dispenseBehavior = new BehaviorDefaultDispenseItem();
            this.boatType = llllllllllIllllIlllIIIIlIIllIlIl;
        }
        
        @Override
        protected void playDispenseSound(final IBlockSource llllllllllIllllIlllIIIIlIIIIllIl) {
            llllllllllIllllIlllIIIIlIIIIllIl.getWorld().playEvent(1000, llllllllllIllllIlllIIIIlIIIIllIl.getBlockPos(), 0);
        }
        
        public ItemStack dispenseStack(final IBlockSource llllllllllIllllIlllIIIIlIIlIIlll, final ItemStack llllllllllIllllIlllIIIIlIIIllIIl) {
            final EnumFacing llllllllllIllllIlllIIIIlIIlIIlIl = llllllllllIllllIlllIIIIlIIlIIlll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
            final World llllllllllIllllIlllIIIIlIIlIIlII = llllllllllIllllIlllIIIIlIIlIIlll.getWorld();
            final double llllllllllIllllIlllIIIIlIIlIIIll = llllllllllIllllIlllIIIIlIIlIIlll.getX() + llllllllllIllllIlllIIIIlIIlIIlIl.getFrontOffsetX() * 1.125f;
            final double llllllllllIllllIlllIIIIlIIlIIIlI = llllllllllIllllIlllIIIIlIIlIIlll.getY() + llllllllllIllllIlllIIIIlIIlIIlIl.getFrontOffsetY() * 1.125f;
            final double llllllllllIllllIlllIIIIlIIlIIIIl = llllllllllIllllIlllIIIIlIIlIIlll.getZ() + llllllllllIllllIlllIIIIlIIlIIlIl.getFrontOffsetZ() * 1.125f;
            final BlockPos llllllllllIllllIlllIIIIlIIlIIIII = llllllllllIllllIlllIIIIlIIlIIlll.getBlockPos().offset(llllllllllIllllIlllIIIIlIIlIIlIl);
            final Material llllllllllIllllIlllIIIIlIIIlllll = llllllllllIllllIlllIIIIlIIlIIlII.getBlockState(llllllllllIllllIlllIIIIlIIlIIIII).getMaterial();
            double llllllllllIllllIlllIIIIlIIIlllIl = 0.0;
            if (Material.WATER.equals(llllllllllIllllIlllIIIIlIIIlllll)) {
                final double llllllllllIllllIlllIIIIlIIIllllI = 1.0;
            }
            else {
                if (!Material.AIR.equals(llllllllllIllllIlllIIIIlIIIlllll) || !Material.WATER.equals(llllllllllIllllIlllIIIIlIIlIIlII.getBlockState(llllllllllIllllIlllIIIIlIIlIIIII.down()).getMaterial())) {
                    return this.dispenseBehavior.dispense(llllllllllIllllIlllIIIIlIIlIIlll, llllllllllIllllIlllIIIIlIIIllIIl);
                }
                llllllllllIllllIlllIIIIlIIIlllIl = 0.0;
            }
            final EntityBoat llllllllllIllllIlllIIIIlIIIlllII = new EntityBoat(llllllllllIllllIlllIIIIlIIlIIlII, llllllllllIllllIlllIIIIlIIlIIIll, llllllllllIllllIlllIIIIlIIlIIIlI + llllllllllIllllIlllIIIIlIIIlllIl, llllllllllIllllIlllIIIIlIIlIIIIl);
            llllllllllIllllIlllIIIIlIIIlllII.setBoatType(this.boatType);
            llllllllllIllllIlllIIIIlIIIlllII.rotationYaw = llllllllllIllllIlllIIIIlIIlIIlIl.getHorizontalAngle();
            llllllllllIllllIlllIIIIlIIlIIlII.spawnEntityInWorld(llllllllllIllllIlllIIIIlIIIlllII);
            llllllllllIllllIlllIIIIlIIIllIIl.func_190918_g(1);
            return llllllllllIllllIlllIIIIlIIIllIIl;
        }
    }
}
