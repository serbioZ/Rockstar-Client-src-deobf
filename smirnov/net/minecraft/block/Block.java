// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumHand;
import ru.rockstar.client.features.Feature;
import ru.rockstar.Main;
import ru.rockstar.client.features.impl.player.NoInteract;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Set;
import java.util.Iterator;
import com.google.common.collect.Sets;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.init.Items;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Rotation;
import net.minecraft.world.Explosion;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Mirror;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.item.ItemStack;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;

public class Block
{
    public static final /* synthetic */ RegistryNamespacedDefaultedByKey<ResourceLocation, Block> REGISTRY;
    protected /* synthetic */ boolean enableStats;
    protected /* synthetic */ SoundType blockSoundType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected /* synthetic */ boolean useNeighborBrightness;
    @Nullable
    public static final /* synthetic */ AxisAlignedBB NULL_AABB;
    protected final /* synthetic */ Material blockMaterial;
    private static final /* synthetic */ ResourceLocation AIR_ID;
    public /* synthetic */ float blockParticleGravity;
    protected /* synthetic */ float blockHardness;
    private /* synthetic */ String unlocalizedName;
    protected /* synthetic */ int lightValue;
    protected /* synthetic */ boolean fullBlock;
    protected /* synthetic */ float blockResistance;
    private /* synthetic */ CreativeTabs displayOnCreativeTab;
    public /* synthetic */ float slipperiness;
    public static final /* synthetic */ ObjectIntIdentityMap<IBlockState> BLOCK_STATE_IDS;
    private /* synthetic */ IBlockState defaultBlockState;
    protected /* synthetic */ int lightOpacity;
    protected /* synthetic */ boolean isBlockContainer;
    protected /* synthetic */ boolean translucent;
    public static final /* synthetic */ AxisAlignedBB FULL_BLOCK_AABB;
    protected final /* synthetic */ MapColor blockMapColor;
    protected /* synthetic */ boolean needsRandomTick;
    protected final /* synthetic */ BlockStateContainer blockState;
    
    public void updateTick(final World llIllIllIlIIIl, final BlockPos llIllIllIlIIII, final IBlockState llIllIllIIllll, final Random llIllIllIIlllI) {
    }
    
    @Deprecated
    public boolean hasComparatorInputOverride(final IBlockState llIlIlIIlllllI) {
        return false;
    }
    
    public void func_190948_a(final ItemStack llIlIlIIIlIlII, @Nullable final World llIlIlIIIlIIll, final List<String> llIlIlIIIlIIlI, final ITooltipFlag llIlIlIIIlIIIl) {
    }
    
    @Deprecated
    public int getStrongPower(final IBlockState llIlIlllIlIllI, final IBlockAccess llIlIlllIlIlIl, final BlockPos llIlIlllIlIlII, final EnumFacing llIlIlllIlIIll) {
        return 0;
    }
    
    @Deprecated
    public IBlockState withMirror(final IBlockState llIllllIlIllII, final Mirror llIllllIlIllIl) {
        return llIllllIlIllII;
    }
    
    public void harvestBlock(final World llIlIlllIIlIlI, final EntityPlayer llIlIlllIIIIII, final BlockPos llIlIllIllllll, final IBlockState llIlIllIlllllI, @Nullable final TileEntity llIlIlllIIIllI, final ItemStack llIlIllIllllIl) {
        llIlIlllIIIIII.addStat(StatList.getBlockStats(this));
        llIlIlllIIIIII.addExhaustion(0.005f);
        if (this.canSilkHarvest() && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, llIlIllIllllIl) > 0) {
            final ItemStack llIlIlllIIIlII = this.getSilkTouchDrop(llIlIllIlllllI);
            spawnAsEntity(llIlIlllIIlIlI, llIlIllIllllll, llIlIlllIIIlII);
        }
        else {
            final int llIlIlllIIIIll = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, llIlIllIllllIl);
            this.dropBlockAsItem(llIlIlllIIlIlI, llIlIllIllllll, llIlIllIlllllI, llIlIlllIIIIll);
        }
    }
    
    protected Block disableStats() {
        this.enableStats = false;
        return this;
    }
    
    public void onBlockDestroyedByExplosion(final World llIllIIIIllllI, final BlockPos llIllIIIIlllIl, final Explosion llIllIIIIlllII) {
    }
    
    @Deprecated
    public boolean isFullyOpaque(final IBlockState llIllllllIIlIl) {
        return llIllllllIIlIl.getMaterial().isOpaque() && llIllllllIIlIl.isFullCube();
    }
    
    public boolean canPlaceBlockAt(final World llIllIIIIIllIl, final BlockPos llIllIIIIIlIlI) {
        return llIllIIIIIllIl.getBlockState(llIllIIIIIlIlI).getBlock().blockMaterial.isReplaceable();
    }
    
    @Deprecated
    public IBlockState withRotation(final IBlockState llIllllIllIIll, final Rotation llIllllIllIIlI) {
        return llIllllIllIIll;
    }
    
    protected Block setHardness(final float llIlllIllIIIIl) {
        this.blockHardness = llIlllIllIIIIl;
        if (this.blockResistance < llIlllIllIIIIl * 5.0f) {
            this.blockResistance = llIlllIllIIIIl * 5.0f;
        }
        return this;
    }
    
    public CreativeTabs getCreativeTabToDisplayOn() {
        return this.displayOnCreativeTab;
    }
    
    @Deprecated
    public float getAmbientOcclusionLightValue(final IBlockState llIlIlIlllllIl) {
        return llIlIlIlllllIl.isBlockNormalCube() ? 0.2f : 1.0f;
    }
    
    public void breakBlock(final World llIllIlIllIlll, final BlockPos llIllIlIllIllI, final IBlockState llIllIlIllIlIl) {
    }
    
    @Deprecated
    @Nullable
    public RayTraceResult collisionRayTrace(final IBlockState llIllIIIlllIlI, final World llIllIIIlllIIl, final BlockPos llIllIIIlllIII, final Vec3d llIllIIIllllIl, final Vec3d llIllIIIllIllI) {
        return this.rayTrace(llIllIIIlllIII, llIllIIIllllIl, llIllIIIllIllI, llIllIIIlllIlI.getBoundingBox(llIllIIIlllIIl, llIllIIIlllIII));
    }
    
    @Deprecated
    public IBlockState getActualState(final IBlockState llIllllIlllIIl, final IBlockAccess llIllllIlllIII, final BlockPos llIllllIllIlll) {
        return llIllllIlllIIl;
    }
    
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.NONE;
    }
    
    private static void registerBlock(final int llIlIIllIIIIlI, final ResourceLocation llIlIIllIIIIIl, final Block llIlIIllIIIIII) {
        Block.REGISTRY.register(llIlIIllIIIIlI, llIlIIllIIIIIl, llIlIIllIIIIII);
    }
    
    @Deprecated
    public boolean isFullCube(final IBlockState llIlllIlllIIIl) {
        return true;
    }
    
    public boolean isAssociatedBlock(final Block llIlIlIlIIIllI) {
        return this == llIlIlIlIIIllI;
    }
    
    public static Block getBlockFromItem(@Nullable final Item llIlllllllIIlI) {
        return (llIlllllllIIlI instanceof ItemBlock) ? ((ItemBlock)llIlllllllIIlI).getBlock() : Blocks.AIR;
    }
    
    @Deprecated
    public float getPlayerRelativeBlockHardness(final IBlockState llIllIlIlIIIIl, final EntityPlayer llIllIlIlIIlIl, final World llIllIlIIlllll, final BlockPos llIllIlIlIIIll) {
        final float llIllIlIlIIIlI = llIllIlIlIIIIl.getBlockHardness(llIllIlIIlllll, llIllIlIlIIIll);
        if (llIllIlIlIIIlI < 0.0f) {
            return 0.0f;
        }
        return llIllIlIlIIlIl.canHarvestBlock(llIllIlIlIIIIl) ? (llIllIlIlIIlIl.getDigSpeed(llIllIlIlIIIIl) / llIllIlIlIIIlI / 30.0f) : (llIllIlIlIIlIl.getDigSpeed(llIllIlIlIIIIl) / llIllIlIlIIIlI / 100.0f);
    }
    
    public Item getItemDropped(final IBlockState llIllIlIllIIII, final Random llIllIlIlIllll, final int llIllIlIlIlllI) {
        return Item.getItemFromBlock(this);
    }
    
    public final void dropBlockAsItem(final World llIllIlIIlIIIl, final BlockPos llIllIlIIlIlIl, final IBlockState llIllIlIIIllll, final int llIllIlIIIlllI) {
        this.dropBlockAsItemWithChance(llIllIlIIlIIIl, llIllIlIIlIlIl, llIllIlIIIllll, 1.0f, llIllIlIIIlllI);
    }
    
    protected Block setResistance(final float llIllllIIIIlll) {
        this.blockResistance = llIllllIIIIlll * 3.0f;
        return this;
    }
    
    @Deprecated
    public EnumPushReaction getMobilityFlag(final IBlockState llIlIllIIIIIlI) {
        return this.blockMaterial.getMobilityFlag();
    }
    
    protected Block(final Material llIllllIIlllll) {
        this(llIllllIIlllll, llIllllIIlllll.getMaterialMapColor());
    }
    
    public boolean getTickRandomly() {
        return this.needsRandomTick;
    }
    
    public boolean canDropFromExplosion(final Explosion llIlIlIlIIllII) {
        return true;
    }
    
    @Deprecated
    public boolean isOpaqueCube(final IBlockState llIllIlllIllIl) {
        return true;
    }
    
    @Deprecated
    public boolean shouldSideBeRendered(final IBlockState llIlllIIllIIlI, final IBlockAccess llIlllIIllIIIl, final BlockPos llIlllIIlIlIll, final EnumFacing llIlllIIlIllll) {
        final AxisAlignedBB llIlllIIlIlllI = llIlllIIllIIlI.getBoundingBox(llIlllIIllIIIl, llIlllIIlIlIll);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llIlllIIlIllll.ordinal()]) {
            case 1: {
                if (llIlllIIlIlllI.minY > 0.0) {
                    return true;
                }
                break;
            }
            case 2: {
                if (llIlllIIlIlllI.maxY < 1.0) {
                    return true;
                }
                break;
            }
            case 3: {
                if (llIlllIIlIlllI.minZ > 0.0) {
                    return true;
                }
                break;
            }
            case 4: {
                if (llIlllIIlIlllI.maxZ < 1.0) {
                    return true;
                }
                break;
            }
            case 5: {
                if (llIlllIIlIlllI.minX > 0.0) {
                    return true;
                }
                break;
            }
            case 6: {
                if (llIlllIIlIlllI.maxX < 1.0) {
                    return true;
                }
                break;
            }
        }
        return !llIlllIIllIIIl.getBlockState(llIlllIIlIlIll.offset(llIlllIIlIllll)).isOpaqueCube();
    }
    
    public boolean isReplaceable(final IBlockAccess llIlllIllIIllI, final BlockPos llIlllIllIIlIl) {
        return false;
    }
    
    protected void dropXpOnBlockBreak(final World llIllIIlIlIIIl, final BlockPos llIllIIlIlIIII, int llIllIIlIIllll) {
        if (!llIllIIlIlIIIl.isRemote && llIllIIlIlIIIl.getGameRules().getBoolean("doTileDrops")) {
            while (llIllIIlIIllll > 0) {
                final int llIllIIlIlIIlI = EntityXPOrb.getXPSplit(llIllIIlIIllll);
                llIllIIlIIllll -= llIllIIlIlIIlI;
                llIllIIlIlIIIl.spawnEntityInWorld(new EntityXPOrb(llIllIIlIlIIIl, llIllIIlIlIIII.getX() + 0.5, llIllIIlIlIIII.getY() + 0.5, llIllIIlIlIIII.getZ() + 0.5, llIllIIlIlIIlI));
            }
        }
    }
    
    @Deprecated
    public float getBlockHardness(final IBlockState llIlllIlIllIIl, final World llIlllIlIllIII, final BlockPos llIlllIlIlIlll) {
        return this.blockHardness;
    }
    
    protected Block setTickRandomly(final boolean llIlllIlIlIIlI) {
        this.needsRandomTick = llIlllIlIlIIlI;
        return this;
    }
    
    public void onEntityWalk(final World llIlIllllllllI, final BlockPos llIlIlllllllIl, final Entity llIlIlllllllII) {
    }
    
    protected static boolean func_193384_b(final Block llIllllIIIIIll) {
        return llIllllIIIIIll instanceof BlockShulkerBox || llIllllIIIIIll instanceof BlockLeaves || llIllllIIIIIll instanceof BlockTrapDoor || llIllllIIIIIll == Blocks.BEACON || llIllllIIIIIll == Blocks.CAULDRON || llIllllIIIIIll == Blocks.GLASS || llIllllIIIIIll == Blocks.GLOWSTONE || llIllllIIIIIll == Blocks.ICE || llIllllIIIIIll == Blocks.SEA_LANTERN || llIllllIIIIIll == Blocks.STAINED_GLASS;
    }
    
    @Deprecated
    public boolean eventReceived(final IBlockState llIlIllIIIllll, final World llIlIllIIIlllI, final BlockPos llIlIllIIIllIl, final int llIlIllIIIllII, final int llIlIllIIIlIll) {
        return false;
    }
    
    protected Block setLightLevel(final float llIllllIIIlIll) {
        this.lightValue = (int)(15.0f * llIllllIIIlIll);
        return this;
    }
    
    protected Block setBlockUnbreakable() {
        this.setHardness(-1.0f);
        return this;
    }
    
    public boolean getEnableStats() {
        return this.enableStats;
    }
    
    protected ItemStack getSilkTouchDrop(final IBlockState llIlIllIllIIll) {
        final Item llIlIllIllIIlI = Item.getItemFromBlock(this);
        int llIlIllIllIIIl = 0;
        if (llIlIllIllIIlI.getHasSubtypes()) {
            llIlIllIllIIIl = this.getMetaFromState(llIlIllIllIIll);
        }
        return new ItemStack(llIlIllIllIIlI, 1, llIlIllIllIIIl);
    }
    
    @Deprecated
    public boolean causesSuffocation(final IBlockState llIlllIlllIlII) {
        return this.blockMaterial.blocksMovement() && this.getDefaultState().isFullCube();
    }
    
    public String getUnlocalizedName() {
        return "tile." + this.unlocalizedName;
    }
    
    protected static void addCollisionBoxToList(final BlockPos llIllIllllllIl, final AxisAlignedBB llIlllIIIIIIIl, final List<AxisAlignedBB> llIllIlllllIll, @Nullable final AxisAlignedBB llIllIllllllll) {
        if (llIllIllllllll != Block.NULL_AABB) {
            final AxisAlignedBB llIllIlllllllI = llIllIllllllll.offset(llIllIllllllIl);
            if (llIlllIIIIIIIl.intersectsWith(llIllIlllllllI)) {
                llIllIlllllIll.add(llIllIlllllllI);
            }
        }
    }
    
    public Block setUnlocalizedName(final String llIlIllIIllIIl) {
        this.unlocalizedName = llIlIllIIllIIl;
        return this;
    }
    
    @Deprecated
    public boolean canProvidePower(final IBlockState llIlIlllIlllIl) {
        return false;
    }
    
    @Deprecated
    public int getLightOpacity(final IBlockState llIlllllIllIll) {
        return this.lightOpacity;
    }
    
    @Override
    public String toString() {
        return "Block{" + Block.REGISTRY.getNameForObject(this) + "}";
    }
    
    public int quantityDroppedWithBonus(final int llIlIllIlIlIIl, final Random llIlIllIlIlIII) {
        return this.quantityDropped(llIlIllIlIlIII);
    }
    
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(this.getUnlocalizedName()) + ".name");
    }
    
    public void onBlockPlacedBy(final World llIlIllIlIIlII, final BlockPos llIlIllIlIIIll, final IBlockState llIlIllIlIIIlI, final EntityLivingBase llIlIllIlIIIIl, final ItemStack llIlIllIlIIIII) {
    }
    
    public void onBlockClicked(final World llIlIllllIllIl, final BlockPos llIlIllllIllII, final EntityPlayer llIlIllllIlIll) {
    }
    
    @Nullable
    protected RayTraceResult rayTrace(final BlockPos llIllIIIlIIllI, final Vec3d llIllIIIlIllII, final Vec3d llIllIIIlIlIll, final AxisAlignedBB llIllIIIlIIIll) {
        final Vec3d llIllIIIlIlIIl = llIllIIIlIllII.subtract(llIllIIIlIIllI.getX(), llIllIIIlIIllI.getY(), llIllIIIlIIllI.getZ());
        final Vec3d llIllIIIlIlIII = llIllIIIlIlIll.subtract(llIllIIIlIIllI.getX(), llIllIIIlIIllI.getY(), llIllIIIlIIllI.getZ());
        final RayTraceResult llIllIIIlIIlll = llIllIIIlIIIll.calculateIntercept(llIllIIIlIlIIl, llIllIIIlIlIII);
        return (llIllIIIlIIlll == null) ? null : new RayTraceResult(llIllIIIlIIlll.hitVec.addVector(llIllIIIlIIllI.getX(), llIllIIIlIIllI.getY(), llIllIIIlIIllI.getZ()), llIllIIIlIIlll.sideHit, llIllIIIlIIllI);
    }
    
    public void randomDisplayTick(final IBlockState llIllIllIIllII, final World llIllIllIIlIll, final BlockPos llIllIllIIlIlI, final Random llIllIllIIlIIl) {
    }
    
    @Deprecated
    public boolean isTranslucent(final IBlockState llIlllllIlIlll) {
        return this.translucent;
    }
    
    public boolean canPlaceBlockOnSide(final World llIllIIIIlIllI, final BlockPos llIllIIIIlIIIl, final EnumFacing llIllIIIIlIlII) {
        return this.canPlaceBlockAt(llIllIIIIlIllI, llIllIIIIlIIIl);
    }
    
    @Nullable
    public static Block getBlockFromName(final String llIllllllIlllI) {
        final ResourceLocation llIllllllIllIl = new ResourceLocation(llIllllllIlllI);
        if (Block.REGISTRY.containsKey(llIllllllIllIl)) {
            return Block.REGISTRY.getObject(llIllllllIllIl);
        }
        try {
            return Block.REGISTRY.getObjectById(Integer.parseInt(llIllllllIlllI));
        }
        catch (NumberFormatException llIllllllIllII) {
            return null;
        }
    }
    
    @Deprecated
    public boolean isNormalCube(final IBlockState llIlllIlllIlll) {
        return llIlllIlllIlll.getMaterial().isOpaque() && llIlllIlllIlll.isFullCube() && !llIlllIlllIlll.canProvidePower();
    }
    
    protected Block setSoundType(final SoundType llIllllIIlIlll) {
        this.blockSoundType = llIllllIIlIlll;
        return this;
    }
    
    public static Block getBlockById(final int llIlllllllllll) {
        return Block.REGISTRY.getObjectById(llIlllllllllll);
    }
    
    @Deprecated
    public int getWeakPower(final IBlockState llIlIllllIIIlI, final IBlockAccess llIlIllllIIIIl, final BlockPos llIlIllllIIIII, final EnumFacing llIlIlllIlllll) {
        return 0;
    }
    
    protected boolean canSilkHarvest() {
        return this.getDefaultState().isFullCube() && !this.isBlockContainer;
    }
    
    public void onBlockDestroyedByPlayer(final World llIllIllIIIlll, final BlockPos llIllIllIIIllI, final IBlockState llIllIllIIIlIl) {
    }
    
    public static int getIdFromBlock(final Block lllIIIIIIIlIII) {
        return Block.REGISTRY.getIDForObject(lllIIIIIIIlIII);
    }
    
    public Block setCreativeTab(final CreativeTabs llIlIlIlIllIIl) {
        this.displayOnCreativeTab = llIlIlIlIllIIl;
        return this;
    }
    
    public static IBlockState getStateById(final int llIlllllllIlll) {
        final int llIllllllllIIl = llIlllllllIlll & 0xFFF;
        final int llIllllllllIII = llIlllllllIlll >> 12 & 0xF;
        return getBlockById(llIllllllllIIl).getStateFromMeta(llIllllllllIII);
    }
    
    protected Block setLightOpacity(final int llIllllIIlIIIl) {
        this.lightOpacity = llIllllIIlIIIl;
        return this;
    }
    
    public Block(final Material llIllllIlIIlII, final MapColor llIllllIlIIIll) {
        this.enableStats = true;
        this.blockSoundType = SoundType.STONE;
        this.blockParticleGravity = 1.0f;
        this.slipperiness = 0.6f;
        this.blockMaterial = llIllllIlIIlII;
        this.blockMapColor = llIllllIlIIIll;
        this.blockState = this.createBlockState();
        this.setDefaultState(this.blockState.getBaseState());
        this.fullBlock = this.getDefaultState().isOpaqueCube();
        this.lightOpacity = (this.fullBlock ? 255 : 0);
        this.translucent = !llIllllIlIIlII.blocksLight();
    }
    
    protected static boolean func_193382_c(final Block llIlllIlllllll) {
        return func_193384_b(llIlllIlllllll) || llIlllIlllllll == Blocks.PISTON || llIlllIlllllll == Blocks.STICKY_PISTON || llIlllIlllllll == Blocks.PISTON_HEAD;
    }
    
    public void dropBlockAsItemWithChance(final World llIllIIllllIlI, final BlockPos llIllIIllllIIl, final IBlockState llIllIIllllIII, final float llIllIIlllIlll, final int llIllIIlllIllI) {
        if (!llIllIIllllIlI.isRemote) {
            for (int llIllIIllllllI = this.quantityDroppedWithBonus(llIllIIlllIllI, llIllIIllllIlI.rand), llIllIIlllllIl = 0; llIllIIlllllIl < llIllIIllllllI; ++llIllIIlllllIl) {
                if (llIllIIllllIlI.rand.nextFloat() <= llIllIIlllIlll) {
                    final Item llIllIIlllllII = this.getItemDropped(llIllIIllllIII, llIllIIllllIlI.rand, llIllIIlllIllI);
                    if (llIllIIlllllII != Items.field_190931_a) {
                        spawnAsEntity(llIllIIllllIlI, llIllIIllllIIl, new ItemStack(llIllIIlllllII, 1, this.damageDropped(llIllIIllllIII)));
                    }
                }
            }
        }
    }
    
    public void onEntityCollidedWithBlock(final World llIlIlllIllIll, final BlockPos llIlIlllIllIlI, final IBlockState llIlIlllIllIIl, final Entity llIlIlllIllIII) {
    }
    
    public boolean requiresUpdates() {
        return true;
    }
    
    @Deprecated
    public int getLightValue(final IBlockState llIlllllIlIIll) {
        return this.lightValue;
    }
    
    @Deprecated
    public void neighborChanged(final IBlockState llIllIllIIIIll, final World llIllIllIIIIlI, final BlockPos llIllIllIIIIIl, final Block llIllIllIIIIII, final BlockPos llIllIlIllllll) {
    }
    
    public Vec3d modifyAcceleration(final World llIlIllllIlIII, final BlockPos llIlIllllIIlll, final Entity llIlIllllIIllI, final Vec3d llIlIllllIIlII) {
        return llIlIllllIIlII;
    }
    
    public void fillWithRain(final World llIlIlIlIlIIII, final BlockPos llIlIlIlIIllll) {
    }
    
    @Deprecated
    public MapColor getMapColor(final IBlockState llIlllllIIIlll, final IBlockAccess llIlllllIIIllI, final BlockPos llIlllllIIIlIl) {
        return this.blockMapColor;
    }
    
    @Deprecated
    public boolean canEntitySpawn(final IBlockState llIlllllIlllll, final Entity llIlllllIllllI) {
        return true;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess llIlllIIlIIlll, final IBlockState llIlllIIlIIllI, final BlockPos llIlllIIlIIlIl, final EnumFacing llIlllIIlIIlII) {
        return BlockFaceShape.SOLID;
    }
    
    public void onLanded(final World llIlIlIlllIIIl, final Entity llIlIlIlllIIII) {
        llIlIlIlllIIII.motionY = 0.0;
    }
    
    @Deprecated
    public Material getMaterial(final IBlockState llIlllllIIlIll) {
        return this.blockMaterial;
    }
    
    public final IBlockState getDefaultState() {
        return this.defaultBlockState;
    }
    
    @Deprecated
    public boolean isFullBlock(final IBlockState llIllllllIIIlI) {
        return this.fullBlock;
    }
    
    private static void registerBlock(final int llIlIIlIllIllI, final String llIlIIlIllIlIl, final Block llIlIIlIllIlll) {
        registerBlock(llIlIIlIllIllI, new ResourceLocation(llIlIIlIllIlIl), llIlIIlIllIlll);
    }
    
    @Deprecated
    public int getComparatorInputOverride(final IBlockState llIlIlIIllllII, final World llIlIlIIlllIll, final BlockPos llIlIlIIlllIlI) {
        return 0;
    }
    
    public int tickRate(final World llIllIlIllllIl) {
        return 10;
    }
    
    @Deprecated
    public void addCollisionBoxToList(final IBlockState llIlllIIIIllII, final World llIlllIIIIlIll, final BlockPos llIlllIIIlIIIl, final AxisAlignedBB llIlllIIIIlIIl, final List<AxisAlignedBB> llIlllIIIIlIII, @Nullable final Entity llIlllIIIIlllI, final boolean llIlllIIIIllIl) {
        addCollisionBoxToList(llIlllIIIlIIIl, llIlllIIIIlIIl, llIlllIIIIlIII, llIlllIIIIllII.getCollisionBoundingBox(llIlllIIIIlIll, llIlllIIIlIIIl));
    }
    
    public static void registerBlocks() {
        registerBlock(0, Block.AIR_ID, new BlockAir().setUnlocalizedName("air"));
        registerBlock(1, "stone", new BlockStone().setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stone"));
        registerBlock(2, "grass", new BlockGrass().setHardness(0.6f).setSoundType(SoundType.PLANT).setUnlocalizedName("grass"));
        registerBlock(3, "dirt", new BlockDirt().setHardness(0.5f).setSoundType(SoundType.GROUND).setUnlocalizedName("dirt"));
        final Block llIlIIlllllIIl = new Block(Material.ROCK).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stonebrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        registerBlock(4, "cobblestone", llIlIIlllllIIl);
        final Block llIlIIlllllIII = new BlockPlanks().setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("wood");
        registerBlock(5, "planks", llIlIIlllllIII);
        registerBlock(6, "sapling", new BlockSapling().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("sapling"));
        registerBlock(7, "bedrock", new BlockEmptyDrops(Material.ROCK).setBlockUnbreakable().setResistance(6000000.0f).setSoundType(SoundType.STONE).setUnlocalizedName("bedrock").disableStats().setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(8, "flowing_water", new BlockDynamicLiquid(Material.WATER).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats());
        registerBlock(9, "water", new BlockStaticLiquid(Material.WATER).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats());
        registerBlock(10, "flowing_lava", new BlockDynamicLiquid(Material.LAVA).setHardness(100.0f).setLightLevel(1.0f).setUnlocalizedName("lava").disableStats());
        registerBlock(11, "lava", new BlockStaticLiquid(Material.LAVA).setHardness(100.0f).setLightLevel(1.0f).setUnlocalizedName("lava").disableStats());
        registerBlock(12, "sand", new BlockSand().setHardness(0.5f).setSoundType(SoundType.SAND).setUnlocalizedName("sand"));
        registerBlock(13, "gravel", new BlockGravel().setHardness(0.6f).setSoundType(SoundType.GROUND).setUnlocalizedName("gravel"));
        registerBlock(14, "gold_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreGold"));
        registerBlock(15, "iron_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreIron"));
        registerBlock(16, "coal_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreCoal"));
        registerBlock(17, "log", new BlockOldLog().setUnlocalizedName("log"));
        registerBlock(18, "leaves", new BlockOldLeaf().setUnlocalizedName("leaves"));
        registerBlock(19, "sponge", new BlockSponge().setHardness(0.6f).setSoundType(SoundType.PLANT).setUnlocalizedName("sponge"));
        registerBlock(20, "glass", new BlockGlass(Material.GLASS, false).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("glass"));
        registerBlock(21, "lapis_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreLapis"));
        registerBlock(22, "lapis_block", new Block(Material.IRON, MapColor.LAPIS).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("blockLapis").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(23, "dispenser", new BlockDispenser().setHardness(3.5f).setSoundType(SoundType.STONE).setUnlocalizedName("dispenser"));
        final Block llIlIIllllIlll = new BlockSandStone().setSoundType(SoundType.STONE).setHardness(0.8f).setUnlocalizedName("sandStone");
        registerBlock(24, "sandstone", llIlIIllllIlll);
        registerBlock(25, "noteblock", new BlockNote().setSoundType(SoundType.WOOD).setHardness(0.8f).setUnlocalizedName("musicBlock"));
        registerBlock(26, "bed", new BlockBed().setSoundType(SoundType.WOOD).setHardness(0.2f).setUnlocalizedName("bed").disableStats());
        registerBlock(27, "golden_rail", new BlockRailPowered().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("goldenRail"));
        registerBlock(28, "detector_rail", new BlockRailDetector().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("detectorRail"));
        registerBlock(29, "sticky_piston", new BlockPistonBase(true).setUnlocalizedName("pistonStickyBase"));
        registerBlock(30, "web", new BlockWeb().setLightOpacity(1).setHardness(4.0f).setUnlocalizedName("web"));
        registerBlock(31, "tallgrass", new BlockTallGrass().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("tallgrass"));
        registerBlock(32, "deadbush", new BlockDeadBush().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("deadbush"));
        registerBlock(33, "piston", new BlockPistonBase(false).setUnlocalizedName("pistonBase"));
        registerBlock(34, "piston_head", new BlockPistonExtension().setUnlocalizedName("pistonBase"));
        registerBlock(35, "wool", new BlockColored(Material.CLOTH).setHardness(0.8f).setSoundType(SoundType.CLOTH).setUnlocalizedName("cloth"));
        registerBlock(36, "piston_extension", new BlockPistonMoving());
        registerBlock(37, "yellow_flower", new BlockYellowFlower().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("flower1"));
        registerBlock(38, "red_flower", new BlockRedFlower().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("flower2"));
        final Block llIlIIllllIllI = new BlockMushroom().setHardness(0.0f).setSoundType(SoundType.PLANT).setLightLevel(0.125f).setUnlocalizedName("mushroom");
        registerBlock(39, "brown_mushroom", llIlIIllllIllI);
        final Block llIlIIllllIlIl = new BlockMushroom().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("mushroom");
        registerBlock(40, "red_mushroom", llIlIIllllIlIl);
        registerBlock(41, "gold_block", new Block(Material.IRON, MapColor.GOLD).setHardness(3.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockGold").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(42, "iron_block", new Block(Material.IRON, MapColor.IRON).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockIron").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(43, "double_stone_slab", new BlockDoubleStoneSlab().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab"));
        registerBlock(44, "stone_slab", new BlockHalfStoneSlab().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab"));
        final Block llIlIIllllIlII = new Block(Material.ROCK, MapColor.RED).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        registerBlock(45, "brick_block", llIlIIllllIlII);
        registerBlock(46, "tnt", new BlockTNT().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("tnt"));
        registerBlock(47, "bookshelf", new BlockBookshelf().setHardness(1.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("bookshelf"));
        registerBlock(48, "mossy_cobblestone", new Block(Material.ROCK).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneMoss").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(49, "obsidian", new BlockObsidian().setHardness(50.0f).setResistance(2000.0f).setSoundType(SoundType.STONE).setUnlocalizedName("obsidian"));
        registerBlock(50, "torch", new BlockTorch().setHardness(0.0f).setLightLevel(0.9375f).setSoundType(SoundType.WOOD).setUnlocalizedName("torch"));
        registerBlock(51, "fire", new BlockFire().setHardness(0.0f).setLightLevel(1.0f).setSoundType(SoundType.CLOTH).setUnlocalizedName("fire").disableStats());
        registerBlock(52, "mob_spawner", new BlockMobSpawner().setHardness(5.0f).setSoundType(SoundType.METAL).setUnlocalizedName("mobSpawner").disableStats());
        registerBlock(53, "oak_stairs", new BlockStairs(llIlIIlllllIII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK)).setUnlocalizedName("stairsWood"));
        registerBlock(54, "chest", new BlockChest(BlockChest.Type.BASIC).setHardness(2.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("chest"));
        registerBlock(55, "redstone_wire", new BlockRedstoneWire().setHardness(0.0f).setSoundType(SoundType.STONE).setUnlocalizedName("redstoneDust").disableStats());
        registerBlock(56, "diamond_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreDiamond"));
        registerBlock(57, "diamond_block", new Block(Material.IRON, MapColor.DIAMOND).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockDiamond").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(58, "crafting_table", new BlockWorkbench().setHardness(2.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("workbench"));
        registerBlock(59, "wheat", new BlockCrops().setUnlocalizedName("crops"));
        final Block llIlIIllllIIll = new BlockFarmland().setHardness(0.6f).setSoundType(SoundType.GROUND).setUnlocalizedName("farmland");
        registerBlock(60, "farmland", llIlIIllllIIll);
        registerBlock(61, "furnace", new BlockFurnace(false).setHardness(3.5f).setSoundType(SoundType.STONE).setUnlocalizedName("furnace").setCreativeTab(CreativeTabs.DECORATIONS));
        registerBlock(62, "lit_furnace", new BlockFurnace(true).setHardness(3.5f).setSoundType(SoundType.STONE).setLightLevel(0.875f).setUnlocalizedName("furnace"));
        registerBlock(63, "standing_sign", new BlockStandingSign().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("sign").disableStats());
        registerBlock(64, "wooden_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorOak").disableStats());
        registerBlock(65, "ladder", new BlockLadder().setHardness(0.4f).setSoundType(SoundType.LADDER).setUnlocalizedName("ladder"));
        registerBlock(66, "rail", new BlockRail().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("rail"));
        registerBlock(67, "stone_stairs", new BlockStairs(llIlIIlllllIIl.getDefaultState()).setUnlocalizedName("stairsStone"));
        registerBlock(68, "wall_sign", new BlockWallSign().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("sign").disableStats());
        registerBlock(69, "lever", new BlockLever().setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("lever"));
        registerBlock(70, "stone_pressure_plate", new BlockPressurePlate(Material.ROCK, BlockPressurePlate.Sensitivity.MOBS).setHardness(0.5f).setSoundType(SoundType.STONE).setUnlocalizedName("pressurePlateStone"));
        registerBlock(71, "iron_door", new BlockDoor(Material.IRON).setHardness(5.0f).setSoundType(SoundType.METAL).setUnlocalizedName("doorIron").disableStats());
        registerBlock(72, "wooden_pressure_plate", new BlockPressurePlate(Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING).setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("pressurePlateWood"));
        registerBlock(73, "redstone_ore", new BlockRedstoneOre(false).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(74, "lit_redstone_ore", new BlockRedstoneOre(true).setLightLevel(0.625f).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreRedstone"));
        registerBlock(75, "unlit_redstone_torch", new BlockRedstoneTorch(false).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("notGate"));
        registerBlock(76, "redstone_torch", new BlockRedstoneTorch(true).setHardness(0.0f).setLightLevel(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("notGate").setCreativeTab(CreativeTabs.REDSTONE));
        registerBlock(77, "stone_button", new BlockButtonStone().setHardness(0.5f).setSoundType(SoundType.STONE).setUnlocalizedName("button"));
        registerBlock(78, "snow_layer", new BlockSnow().setHardness(0.1f).setSoundType(SoundType.SNOW).setUnlocalizedName("snow").setLightOpacity(0));
        registerBlock(79, "ice", new BlockIce().setHardness(0.5f).setLightOpacity(3).setSoundType(SoundType.GLASS).setUnlocalizedName("ice"));
        registerBlock(80, "snow", new BlockSnowBlock().setHardness(0.2f).setSoundType(SoundType.SNOW).setUnlocalizedName("snow"));
        registerBlock(81, "cactus", new BlockCactus().setHardness(0.4f).setSoundType(SoundType.CLOTH).setUnlocalizedName("cactus"));
        registerBlock(82, "clay", new BlockClay().setHardness(0.6f).setSoundType(SoundType.GROUND).setUnlocalizedName("clay"));
        registerBlock(83, "reeds", new BlockReed().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("reeds").disableStats());
        registerBlock(84, "jukebox", new BlockJukebox().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("jukebox"));
        registerBlock(85, "fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.OAK.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("fence"));
        final Block llIlIIllllIIlI = new BlockPumpkin().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("pumpkin");
        registerBlock(86, "pumpkin", llIlIIllllIIlI);
        registerBlock(87, "netherrack", new BlockNetherrack().setHardness(0.4f).setSoundType(SoundType.STONE).setUnlocalizedName("hellrock"));
        registerBlock(88, "soul_sand", new BlockSoulSand().setHardness(0.5f).setSoundType(SoundType.SAND).setUnlocalizedName("hellsand"));
        registerBlock(89, "glowstone", new BlockGlowstone(Material.GLASS).setHardness(0.3f).setSoundType(SoundType.GLASS).setLightLevel(1.0f).setUnlocalizedName("lightgem"));
        registerBlock(90, "portal", new BlockPortal().setHardness(-1.0f).setSoundType(SoundType.GLASS).setLightLevel(0.75f).setUnlocalizedName("portal"));
        registerBlock(91, "lit_pumpkin", new BlockPumpkin().setHardness(1.0f).setSoundType(SoundType.WOOD).setLightLevel(1.0f).setUnlocalizedName("litpumpkin"));
        registerBlock(92, "cake", new BlockCake().setHardness(0.5f).setSoundType(SoundType.CLOTH).setUnlocalizedName("cake").disableStats());
        registerBlock(93, "unpowered_repeater", new BlockRedstoneRepeater(false).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("diode").disableStats());
        registerBlock(94, "powered_repeater", new BlockRedstoneRepeater(true).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("diode").disableStats());
        registerBlock(95, "stained_glass", new BlockStainedGlass(Material.GLASS).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("stainedGlass"));
        registerBlock(96, "trapdoor", new BlockTrapDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("trapdoor").disableStats());
        registerBlock(97, "monster_egg", new BlockSilverfish().setHardness(0.75f).setUnlocalizedName("monsterStoneEgg"));
        final Block llIlIIllllIIIl = new BlockStoneBrick().setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stonebricksmooth");
        registerBlock(98, "stonebrick", llIlIIllllIIIl);
        registerBlock(99, "brown_mushroom_block", new BlockHugeMushroom(Material.WOOD, MapColor.DIRT, llIlIIllllIllI).setHardness(0.2f).setSoundType(SoundType.WOOD).setUnlocalizedName("mushroom"));
        registerBlock(100, "red_mushroom_block", new BlockHugeMushroom(Material.WOOD, MapColor.RED, llIlIIllllIlIl).setHardness(0.2f).setSoundType(SoundType.WOOD).setUnlocalizedName("mushroom"));
        registerBlock(101, "iron_bars", new BlockPane(Material.IRON, true).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("fenceIron"));
        registerBlock(102, "glass_pane", new BlockPane(Material.GLASS, false).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("thinGlass"));
        final Block llIlIIllllIIII = new BlockMelon().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("melon");
        registerBlock(103, "melon_block", llIlIIllllIIII);
        registerBlock(104, "pumpkin_stem", new BlockStem(llIlIIllllIIlI).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("pumpkinStem"));
        registerBlock(105, "melon_stem", new BlockStem(llIlIIllllIIII).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("pumpkinStem"));
        registerBlock(106, "vine", new BlockVine().setHardness(0.2f).setSoundType(SoundType.PLANT).setUnlocalizedName("vine"));
        registerBlock(107, "fence_gate", new BlockFenceGate(BlockPlanks.EnumType.OAK).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("fenceGate"));
        registerBlock(108, "brick_stairs", new BlockStairs(llIlIIllllIlII.getDefaultState()).setUnlocalizedName("stairsBrick"));
        registerBlock(109, "stone_brick_stairs", new BlockStairs(llIlIIllllIIIl.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.DEFAULT)).setUnlocalizedName("stairsStoneBrickSmooth"));
        registerBlock(110, "mycelium", new BlockMycelium().setHardness(0.6f).setSoundType(SoundType.PLANT).setUnlocalizedName("mycel"));
        registerBlock(111, "waterlily", new BlockLilyPad().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("waterlily"));
        final Block llIlIIlllIllll = new BlockNetherBrick().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("netherBrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        registerBlock(112, "nether_brick", llIlIIlllIllll);
        registerBlock(113, "nether_brick_fence", new BlockFence(Material.ROCK, MapColor.NETHERRACK).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("netherFence"));
        registerBlock(114, "nether_brick_stairs", new BlockStairs(llIlIIlllIllll.getDefaultState()).setUnlocalizedName("stairsNetherBrick"));
        registerBlock(115, "nether_wart", new BlockNetherWart().setUnlocalizedName("netherStalk"));
        registerBlock(116, "enchanting_table", new BlockEnchantmentTable().setHardness(5.0f).setResistance(2000.0f).setUnlocalizedName("enchantmentTable"));
        registerBlock(117, "brewing_stand", new BlockBrewingStand().setHardness(0.5f).setLightLevel(0.125f).setUnlocalizedName("brewingStand"));
        registerBlock(118, "cauldron", new BlockCauldron().setHardness(2.0f).setUnlocalizedName("cauldron"));
        registerBlock(119, "end_portal", new BlockEndPortal(Material.PORTAL).setHardness(-1.0f).setResistance(6000000.0f));
        registerBlock(120, "end_portal_frame", new BlockEndPortalFrame().setSoundType(SoundType.GLASS).setLightLevel(0.125f).setHardness(-1.0f).setUnlocalizedName("endPortalFrame").setResistance(6000000.0f).setCreativeTab(CreativeTabs.DECORATIONS));
        registerBlock(121, "end_stone", new Block(Material.ROCK, MapColor.SAND).setHardness(3.0f).setResistance(15.0f).setSoundType(SoundType.STONE).setUnlocalizedName("whiteStone").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(122, "dragon_egg", new BlockDragonEgg().setHardness(3.0f).setResistance(15.0f).setSoundType(SoundType.STONE).setLightLevel(0.125f).setUnlocalizedName("dragonEgg"));
        registerBlock(123, "redstone_lamp", new BlockRedstoneLight(false).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("redstoneLight").setCreativeTab(CreativeTabs.REDSTONE));
        registerBlock(124, "lit_redstone_lamp", new BlockRedstoneLight(true).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("redstoneLight"));
        registerBlock(125, "double_wooden_slab", new BlockDoubleWoodSlab().setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("woodSlab"));
        registerBlock(126, "wooden_slab", new BlockHalfWoodSlab().setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("woodSlab"));
        registerBlock(127, "cocoa", new BlockCocoa().setHardness(0.2f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("cocoa"));
        registerBlock(128, "sandstone_stairs", new BlockStairs(llIlIIllllIlll.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH)).setUnlocalizedName("stairsSandStone"));
        registerBlock(129, "emerald_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreEmerald"));
        registerBlock(130, "ender_chest", new BlockEnderChest().setHardness(22.5f).setResistance(1000.0f).setSoundType(SoundType.STONE).setUnlocalizedName("enderChest").setLightLevel(0.5f));
        registerBlock(131, "tripwire_hook", new BlockTripWireHook().setUnlocalizedName("tripWireSource"));
        registerBlock(132, "tripwire", new BlockTripWire().setUnlocalizedName("tripWire"));
        registerBlock(133, "emerald_block", new Block(Material.IRON, MapColor.EMERALD).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockEmerald").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(134, "spruce_stairs", new BlockStairs(llIlIIlllllIII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE)).setUnlocalizedName("stairsWoodSpruce"));
        registerBlock(135, "birch_stairs", new BlockStairs(llIlIIlllllIII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH)).setUnlocalizedName("stairsWoodBirch"));
        registerBlock(136, "jungle_stairs", new BlockStairs(llIlIIlllllIII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE)).setUnlocalizedName("stairsWoodJungle"));
        registerBlock(137, "command_block", new BlockCommandBlock(MapColor.BROWN).setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("commandBlock"));
        registerBlock(138, "beacon", new BlockBeacon().setUnlocalizedName("beacon").setLightLevel(1.0f));
        registerBlock(139, "cobblestone_wall", new BlockWall(llIlIIlllllIIl).setUnlocalizedName("cobbleWall"));
        registerBlock(140, "flower_pot", new BlockFlowerPot().setHardness(0.0f).setSoundType(SoundType.STONE).setUnlocalizedName("flowerPot"));
        registerBlock(141, "carrots", new BlockCarrot().setUnlocalizedName("carrots"));
        registerBlock(142, "potatoes", new BlockPotato().setUnlocalizedName("potatoes"));
        registerBlock(143, "wooden_button", new BlockButtonWood().setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("button"));
        registerBlock(144, "skull", new BlockSkull().setHardness(1.0f).setSoundType(SoundType.STONE).setUnlocalizedName("skull"));
        registerBlock(145, "anvil", new BlockAnvil().setHardness(5.0f).setSoundType(SoundType.ANVIL).setResistance(2000.0f).setUnlocalizedName("anvil"));
        registerBlock(146, "trapped_chest", new BlockChest(BlockChest.Type.TRAP).setHardness(2.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("chestTrap"));
        registerBlock(147, "light_weighted_pressure_plate", new BlockPressurePlateWeighted(Material.IRON, 15, MapColor.GOLD).setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("weightedPlate_light"));
        registerBlock(148, "heavy_weighted_pressure_plate", new BlockPressurePlateWeighted(Material.IRON, 150).setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("weightedPlate_heavy"));
        registerBlock(149, "unpowered_comparator", new BlockRedstoneComparator(false).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("comparator").disableStats());
        registerBlock(150, "powered_comparator", new BlockRedstoneComparator(true).setHardness(0.0f).setLightLevel(0.625f).setSoundType(SoundType.WOOD).setUnlocalizedName("comparator").disableStats());
        registerBlock(151, "daylight_detector", new BlockDaylightDetector(false));
        registerBlock(152, "redstone_block", new BlockCompressedPowered(Material.IRON, MapColor.TNT).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockRedstone").setCreativeTab(CreativeTabs.REDSTONE));
        registerBlock(153, "quartz_ore", new BlockOre(MapColor.NETHERRACK).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("netherquartz"));
        registerBlock(154, "hopper", new BlockHopper().setHardness(3.0f).setResistance(8.0f).setSoundType(SoundType.METAL).setUnlocalizedName("hopper"));
        final Block llIlIIlllIlllI = new BlockQuartz().setSoundType(SoundType.STONE).setHardness(0.8f).setUnlocalizedName("quartzBlock");
        registerBlock(155, "quartz_block", llIlIIlllIlllI);
        registerBlock(156, "quartz_stairs", new BlockStairs(llIlIIlllIlllI.getDefaultState().withProperty(BlockQuartz.VARIANT, BlockQuartz.EnumType.DEFAULT)).setUnlocalizedName("stairsQuartz"));
        registerBlock(157, "activator_rail", new BlockRailPowered().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("activatorRail"));
        registerBlock(158, "dropper", new BlockDropper().setHardness(3.5f).setSoundType(SoundType.STONE).setUnlocalizedName("dropper"));
        registerBlock(159, "stained_hardened_clay", new BlockStainedHardenedClay().setHardness(1.25f).setResistance(7.0f).setSoundType(SoundType.STONE).setUnlocalizedName("clayHardenedStained"));
        registerBlock(160, "stained_glass_pane", new BlockStainedGlassPane().setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("thinStainedGlass"));
        registerBlock(161, "leaves2", new BlockNewLeaf().setUnlocalizedName("leaves"));
        registerBlock(162, "log2", new BlockNewLog().setUnlocalizedName("log"));
        registerBlock(163, "acacia_stairs", new BlockStairs(llIlIIlllllIII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA)).setUnlocalizedName("stairsWoodAcacia"));
        registerBlock(164, "dark_oak_stairs", new BlockStairs(llIlIIlllllIII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK)).setUnlocalizedName("stairsWoodDarkOak"));
        registerBlock(165, "slime", new BlockSlime().setUnlocalizedName("slime").setSoundType(SoundType.SLIME));
        registerBlock(166, "barrier", new BlockBarrier().setUnlocalizedName("barrier"));
        registerBlock(167, "iron_trapdoor", new BlockTrapDoor(Material.IRON).setHardness(5.0f).setSoundType(SoundType.METAL).setUnlocalizedName("ironTrapdoor").disableStats());
        registerBlock(168, "prismarine", new BlockPrismarine().setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("prismarine"));
        registerBlock(169, "sea_lantern", new BlockSeaLantern(Material.GLASS).setHardness(0.3f).setSoundType(SoundType.GLASS).setLightLevel(1.0f).setUnlocalizedName("seaLantern"));
        registerBlock(170, "hay_block", new BlockHay().setHardness(0.5f).setSoundType(SoundType.PLANT).setUnlocalizedName("hayBlock").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(171, "carpet", new BlockCarpet().setHardness(0.1f).setSoundType(SoundType.CLOTH).setUnlocalizedName("woolCarpet").setLightOpacity(0));
        registerBlock(172, "hardened_clay", new BlockHardenedClay().setHardness(1.25f).setResistance(7.0f).setSoundType(SoundType.STONE).setUnlocalizedName("clayHardened"));
        registerBlock(173, "coal_block", new Block(Material.ROCK, MapColor.BLACK).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("blockCoal").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(174, "packed_ice", new BlockPackedIce().setHardness(0.5f).setSoundType(SoundType.GLASS).setUnlocalizedName("icePacked"));
        registerBlock(175, "double_plant", new BlockDoublePlant());
        registerBlock(176, "standing_banner", new BlockBanner.BlockBannerStanding().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("banner").disableStats());
        registerBlock(177, "wall_banner", new BlockBanner.BlockBannerHanging().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("banner").disableStats());
        registerBlock(178, "daylight_detector_inverted", new BlockDaylightDetector(true));
        final Block llIlIIlllIllIl = new BlockRedSandstone().setSoundType(SoundType.STONE).setHardness(0.8f).setUnlocalizedName("redSandStone");
        registerBlock(179, "red_sandstone", llIlIIlllIllIl);
        registerBlock(180, "red_sandstone_stairs", new BlockStairs(llIlIIlllIllIl.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH)).setUnlocalizedName("stairsRedSandStone"));
        registerBlock(181, "double_stone_slab2", new BlockDoubleStoneSlabNew().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab2"));
        registerBlock(182, "stone_slab2", new BlockHalfStoneSlabNew().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab2"));
        registerBlock(183, "spruce_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.SPRUCE).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("spruceFenceGate"));
        registerBlock(184, "birch_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.BIRCH).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("birchFenceGate"));
        registerBlock(185, "jungle_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.JUNGLE).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("jungleFenceGate"));
        registerBlock(186, "dark_oak_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.DARK_OAK).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("darkOakFenceGate"));
        registerBlock(187, "acacia_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.ACACIA).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("acaciaFenceGate"));
        registerBlock(188, "spruce_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.SPRUCE.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("spruceFence"));
        registerBlock(189, "birch_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.BIRCH.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("birchFence"));
        registerBlock(190, "jungle_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.JUNGLE.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("jungleFence"));
        registerBlock(191, "dark_oak_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.DARK_OAK.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("darkOakFence"));
        registerBlock(192, "acacia_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.ACACIA.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("acaciaFence"));
        registerBlock(193, "spruce_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorSpruce").disableStats());
        registerBlock(194, "birch_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorBirch").disableStats());
        registerBlock(195, "jungle_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorJungle").disableStats());
        registerBlock(196, "acacia_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorAcacia").disableStats());
        registerBlock(197, "dark_oak_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorDarkOak").disableStats());
        registerBlock(198, "end_rod", new BlockEndRod().setHardness(0.0f).setLightLevel(0.9375f).setSoundType(SoundType.WOOD).setUnlocalizedName("endRod"));
        registerBlock(199, "chorus_plant", new BlockChorusPlant().setHardness(0.4f).setSoundType(SoundType.WOOD).setUnlocalizedName("chorusPlant"));
        registerBlock(200, "chorus_flower", new BlockChorusFlower().setHardness(0.4f).setSoundType(SoundType.WOOD).setUnlocalizedName("chorusFlower"));
        final Block llIlIIlllIllII = new Block(Material.ROCK, MapColor.MAGENTA).setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setUnlocalizedName("purpurBlock");
        registerBlock(201, "purpur_block", llIlIIlllIllII);
        registerBlock(202, "purpur_pillar", new BlockRotatedPillar(Material.ROCK, MapColor.MAGENTA).setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setUnlocalizedName("purpurPillar"));
        registerBlock(203, "purpur_stairs", new BlockStairs(llIlIIlllIllII.getDefaultState()).setUnlocalizedName("stairsPurpur"));
        registerBlock(204, "purpur_double_slab", new BlockPurpurSlab.Double().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("purpurSlab"));
        registerBlock(205, "purpur_slab", new BlockPurpurSlab.Half().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("purpurSlab"));
        registerBlock(206, "end_bricks", new Block(Material.ROCK, MapColor.SAND).setSoundType(SoundType.STONE).setHardness(0.8f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setUnlocalizedName("endBricks"));
        registerBlock(207, "beetroots", new BlockBeetroot().setUnlocalizedName("beetroots"));
        final Block llIlIIlllIlIll = new BlockGrassPath().setHardness(0.65f).setSoundType(SoundType.PLANT).setUnlocalizedName("grassPath").disableStats();
        registerBlock(208, "grass_path", llIlIIlllIlIll);
        registerBlock(209, "end_gateway", new BlockEndGateway(Material.PORTAL).setHardness(-1.0f).setResistance(6000000.0f));
        registerBlock(210, "repeating_command_block", new BlockCommandBlock(MapColor.PURPLE).setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("repeatingCommandBlock"));
        registerBlock(211, "chain_command_block", new BlockCommandBlock(MapColor.GREEN).setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("chainCommandBlock"));
        registerBlock(212, "frosted_ice", new BlockFrostedIce().setHardness(0.5f).setLightOpacity(3).setSoundType(SoundType.GLASS).setUnlocalizedName("frostedIce"));
        registerBlock(213, "magma", new BlockMagma().setHardness(0.5f).setSoundType(SoundType.STONE).setUnlocalizedName("magma"));
        registerBlock(214, "nether_wart_block", new Block(Material.GRASS, MapColor.RED).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("netherWartBlock"));
        registerBlock(215, "red_nether_brick", new BlockNetherBrick().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("redNetherBrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(216, "bone_block", new BlockBone().setUnlocalizedName("boneBlock"));
        registerBlock(217, "structure_void", new BlockStructureVoid().setUnlocalizedName("structureVoid"));
        registerBlock(218, "observer", new BlockObserver().setHardness(3.0f).setUnlocalizedName("observer"));
        registerBlock(219, "white_shulker_box", new BlockShulkerBox(EnumDyeColor.WHITE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxWhite"));
        registerBlock(220, "orange_shulker_box", new BlockShulkerBox(EnumDyeColor.ORANGE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxOrange"));
        registerBlock(221, "magenta_shulker_box", new BlockShulkerBox(EnumDyeColor.MAGENTA).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxMagenta"));
        registerBlock(222, "light_blue_shulker_box", new BlockShulkerBox(EnumDyeColor.LIGHT_BLUE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxLightBlue"));
        registerBlock(223, "yellow_shulker_box", new BlockShulkerBox(EnumDyeColor.YELLOW).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxYellow"));
        registerBlock(224, "lime_shulker_box", new BlockShulkerBox(EnumDyeColor.LIME).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxLime"));
        registerBlock(225, "pink_shulker_box", new BlockShulkerBox(EnumDyeColor.PINK).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxPink"));
        registerBlock(226, "gray_shulker_box", new BlockShulkerBox(EnumDyeColor.GRAY).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxGray"));
        registerBlock(227, "silver_shulker_box", new BlockShulkerBox(EnumDyeColor.SILVER).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxSilver"));
        registerBlock(228, "cyan_shulker_box", new BlockShulkerBox(EnumDyeColor.CYAN).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxCyan"));
        registerBlock(229, "purple_shulker_box", new BlockShulkerBox(EnumDyeColor.PURPLE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxPurple"));
        registerBlock(230, "blue_shulker_box", new BlockShulkerBox(EnumDyeColor.BLUE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxBlue"));
        registerBlock(231, "brown_shulker_box", new BlockShulkerBox(EnumDyeColor.BROWN).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxBrown"));
        registerBlock(232, "green_shulker_box", new BlockShulkerBox(EnumDyeColor.GREEN).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxGreen"));
        registerBlock(233, "red_shulker_box", new BlockShulkerBox(EnumDyeColor.RED).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxRed"));
        registerBlock(234, "black_shulker_box", new BlockShulkerBox(EnumDyeColor.BLACK).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxBlack"));
        registerBlock(235, "white_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.WHITE));
        registerBlock(236, "orange_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.ORANGE));
        registerBlock(237, "magenta_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.MAGENTA));
        registerBlock(238, "light_blue_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.LIGHT_BLUE));
        registerBlock(239, "yellow_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.YELLOW));
        registerBlock(240, "lime_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.LIME));
        registerBlock(241, "pink_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.PINK));
        registerBlock(242, "gray_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.GRAY));
        registerBlock(243, "silver_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.SILVER));
        registerBlock(244, "cyan_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.CYAN));
        registerBlock(245, "purple_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.PURPLE));
        registerBlock(246, "blue_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.BLUE));
        registerBlock(247, "brown_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.BROWN));
        registerBlock(248, "green_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.GREEN));
        registerBlock(249, "red_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.RED));
        registerBlock(250, "black_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.BLACK));
        registerBlock(251, "concrete", new BlockColored(Material.ROCK).setHardness(1.8f).setSoundType(SoundType.STONE).setUnlocalizedName("concrete"));
        registerBlock(252, "concrete_powder", new BlockConcretePowder().setHardness(0.5f).setSoundType(SoundType.SAND).setUnlocalizedName("concretePowder"));
        registerBlock(255, "structure_block", new BlockStructure().setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("structureBlock"));
        Block.REGISTRY.validateKey();
        for (final Block llIlIIlllIlIlI : Block.REGISTRY) {
            if (llIlIIlllIlIlI.blockMaterial == Material.AIR) {
                llIlIIlllIlIlI.useNeighborBrightness = false;
            }
            else {
                boolean llIlIIlllIlIIl = false;
                final boolean llIlIIlllIlIII = llIlIIlllIlIlI instanceof BlockStairs;
                final boolean llIlIIlllIIlll = llIlIIlllIlIlI instanceof BlockSlab;
                final boolean llIlIIlllIIllI = llIlIIlllIlIlI == llIlIIllllIIll || llIlIIlllIlIlI == llIlIIlllIlIll;
                final boolean llIlIIlllIIlIl = llIlIIlllIlIlI.translucent;
                final boolean llIlIIlllIIlII = llIlIIlllIlIlI.lightOpacity == 0;
                if (llIlIIlllIlIII || llIlIIlllIIlll || llIlIIlllIIllI || llIlIIlllIIlIl || llIlIIlllIIlII) {
                    llIlIIlllIlIIl = true;
                }
                llIlIIlllIlIlI.useNeighborBrightness = llIlIIlllIlIIl;
            }
        }
        final Set<Block> llIlIIlllIIIll = (Set<Block>)Sets.newHashSet((Object[])new Block[] { Block.REGISTRY.getObject(new ResourceLocation("tripwire")) });
        for (final Block llIlIIlllIIIlI : Block.REGISTRY) {
            if (llIlIIlllIIIll.contains(llIlIIlllIIIlI)) {
                for (int llIlIIlllIIIIl = 0; llIlIIlllIIIIl < 15; ++llIlIIlllIIIIl) {
                    final int llIlIIlllIIIII = Block.REGISTRY.getIDForObject(llIlIIlllIIIlI) << 4 | llIlIIlllIIIIl;
                    Block.BLOCK_STATE_IDS.put(llIlIIlllIIIlI.getStateFromMeta(llIlIIlllIIIIl), llIlIIlllIIIII);
                }
            }
            else {
                for (final IBlockState llIlIIllIllllI : llIlIIlllIIIlI.getBlockState().getValidStates()) {
                    final int llIlIIllIlllIl = Block.REGISTRY.getIDForObject(llIlIIlllIIIlI) << 4 | llIlIIlllIIIlI.getMetaFromState(llIlIIllIllllI);
                    Block.BLOCK_STATE_IDS.put(llIlIIllIllllI, llIlIIllIlllIl);
                }
            }
        }
    }
    
    public void onBlockHarvested(final World llIlIlIlIlIlIl, final BlockPos llIlIlIlIlIlII, final IBlockState llIlIlIlIlIIll, final EntityPlayer llIlIlIlIlIIlI) {
    }
    
    public int quantityDropped(final Random llIllIlIllIIll) {
        return 1;
    }
    
    @Deprecated
    public boolean func_190946_v(final IBlockState llIlllIllIllll) {
        return false;
    }
    
    public boolean hasTileEntity() {
        return this.isBlockContainer;
    }
    
    public static int getStateId(final IBlockState lllIIIIIIIIlII) {
        final Block lllIIIIIIIIIll = lllIIIIIIIIlII.getBlock();
        return getIdFromBlock(lllIIIIIIIIIll) + (lllIIIIIIIIIll.getMetaFromState(lllIIIIIIIIlII) << 12);
    }
    
    public void onBlockAdded(final World llIllIlIlllIll, final BlockPos llIllIlIlllIlI, final IBlockState llIllIlIlllIIl) {
    }
    
    public static boolean isEqualTo(final Block llIlIlIlIIIIIl, final Block llIlIlIlIIIIII) {
        return llIlIlIlIIIIIl != null && llIlIlIlIIIIII != null && (llIlIlIlIIIIIl == llIlIlIlIIIIII || llIlIlIlIIIIIl.isAssociatedBlock(llIlIlIlIIIIII));
    }
    
    public int damageDropped(final IBlockState llIllIIlIIllII) {
        return 0;
    }
    
    @Deprecated
    public AxisAlignedBB getSelectedBoundingBox(final IBlockState llIlllIIIlllII, final World llIlllIIIllllI, final BlockPos llIlllIIIllIlI) {
        return llIlllIIIlllII.getBoundingBox(llIlllIIIllllI, llIlllIIIllIlI).offset(llIlllIIIllIlI);
    }
    
    public BlockStateContainer getBlockState() {
        return this.blockState;
    }
    
    @Deprecated
    public IBlockState getStateFromMeta(final int llIlllllIIIIIl) {
        return this.getDefaultState();
    }
    
    public boolean isCollidable() {
        return true;
    }
    
    static {
        AIR_ID = new ResourceLocation("air");
        REGISTRY = new RegistryNamespacedDefaultedByKey<ResourceLocation, Block>(Block.AIR_ID);
        BLOCK_STATE_IDS = new ObjectIntIdentityMap<IBlockState>();
        FULL_BLOCK_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        NULL_AABB = null;
    }
    
    protected final void setDefaultState(final IBlockState llIlIlIIlIlllI) {
        this.defaultBlockState = llIlIlIIlIlllI;
    }
    
    @Deprecated
    public boolean isBlockNormalCube(final IBlockState llIlllIlllllII) {
        return llIlllIlllllII.getMaterial().blocksMovement() && llIlllIlllllII.isFullCube();
    }
    
    public SoundType getSoundType() {
        return this.blockSoundType;
    }
    
    public int getMetaFromState(final IBlockState llIllllIllllIl) {
        if (llIllllIllllIl.getPropertyNames().isEmpty()) {
            return 0;
        }
        throw new IllegalArgumentException("Don't know how to convert " + llIllllIllllIl + " back into data...");
    }
    
    public void onFallenUpon(final World llIlIlIllllIIl, final BlockPos llIlIlIllllIII, final Entity llIlIlIlllIlIl, final float llIlIlIlllIllI) {
        llIlIlIlllIlIl.fall(llIlIlIlllIllI, 1.0f);
    }
    
    @Deprecated
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llIllIllllIIIl, final IBlockAccess llIllIllllIIll, final BlockPos llIllIlllIllll) {
        return llIllIllllIIIl.getBoundingBox(llIllIllllIIll, llIllIlllIllll);
    }
    
    public float getExplosionResistance(final Entity llIllIIlIIlIIl) {
        return this.blockResistance / 5.0f;
    }
    
    public boolean canCollideCheck(final IBlockState llIllIlllIIlII, final boolean llIllIlllIIlll) {
        final Block llIllIlllIIllI = llIllIlllIIlII.getBlock();
        return (((!NoInteract.craftTable.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 58) && (!NoInteract.standing.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 63) && (!NoInteract.door.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 193) && !(NoInteract.door.getBoolValue() & getIdFromBlock(llIllIlllIIllI) == 194) && !(NoInteract.door.getBoolValue() & getIdFromBlock(llIllIlllIIllI) == 195) && (!NoInteract.door.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 196) && (!NoInteract.door.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 197) && (!NoInteract.hopper.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 154) && (!NoInteract.furnace.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 61) && (!NoInteract.dispenser.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 23) && (!NoInteract.anvil.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 145) && (!NoInteract.woodenslab.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 158) && (!NoInteract.lever.getBoolValue() || getIdFromBlock(llIllIlllIIllI) != 69)) || !Main.featureDirector.getFeatureByClass(NoInteract.class).isToggled()) && this.isCollidable();
    }
    
    public ItemStack getItem(final World llIlIlIllIlIll, final BlockPos llIlIlIllIlIlI, final IBlockState llIlIlIllIIlll) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(llIlIlIllIIlll));
    }
    
    @Deprecated
    public AxisAlignedBB getBoundingBox(final IBlockState llIlllIlIIlIII, final IBlockAccess llIlllIlIIIlll, final BlockPos llIlllIlIIIllI) {
        return Block.FULL_BLOCK_AABB;
    }
    
    public void randomTick(final World llIllIllIlIllI, final BlockPos llIllIllIllIlI, final IBlockState llIllIllIllIIl, final Random llIllIllIlIIll) {
        this.updateTick(llIllIllIlIllI, llIllIllIllIlI, llIllIllIllIIl, llIllIllIlIIll);
    }
    
    @Deprecated
    public int getPackedLightmapCoords(IBlockState llIlllIIllllII, final IBlockAccess llIlllIIlllIll, BlockPos llIlllIIlllIlI) {
        final int llIlllIIllllIl = llIlllIIlllIll.getCombinedLight(llIlllIIlllIlI, llIlllIIllllII.getLightValue());
        if (llIlllIIllllIl == 0 && llIlllIIllllII.getBlock() instanceof BlockSlab) {
            llIlllIIlllIlI = llIlllIIlllIlI.down();
            llIlllIIllllII = llIlllIIlllIll.getBlockState(llIlllIIlllIlI);
            return llIlllIIlllIll.getCombinedLight(llIlllIIlllIlI, llIlllIIllllII.getLightValue());
        }
        return llIlllIIllllIl;
    }
    
    public boolean onBlockActivated(final World llIllIIIIIlIII, final BlockPos llIllIIIIIIlll, final IBlockState llIllIIIIIIllI, final EntityPlayer llIllIIIIIIlIl, final EnumHand llIllIIIIIIlII, final EnumFacing llIllIIIIIIIll, final float llIllIIIIIIIlI, final float llIllIIIIIIIIl, final float llIllIIIIIIIII) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Block.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final Exception llIlIIlIllIIlI = (Object)new int[EnumFacing.values().length];
        try {
            llIlIIlIllIIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llIlIIlIllIIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llIlIIlIllIIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llIlIIlIllIIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llIlIIlIllIIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llIlIIlIllIIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return Block.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llIlIIlIllIIlI;
    }
    
    @Deprecated
    public EnumBlockRenderType getRenderType(final IBlockState llIlllIllIlIII) {
        return EnumBlockRenderType.MODEL;
    }
    
    public void getSubBlocks(final CreativeTabs llIlIlIllIIIll, final NonNullList<ItemStack> llIlIlIllIIIII) {
        llIlIlIllIIIII.add(new ItemStack(this));
    }
    
    public static void spawnAsEntity(final World llIllIIllIIIlI, final BlockPos llIllIIllIlIIl, final ItemStack llIllIIllIIIII) {
        if (!llIllIIllIIIlI.isRemote && !llIllIIllIIIII.func_190926_b() && llIllIIllIIIlI.getGameRules().getBoolean("doTileDrops")) {
            final float llIllIIllIIlll = 0.5f;
            final double llIllIIllIIllI = llIllIIllIIIlI.rand.nextFloat() * 0.5f + 0.25;
            final double llIllIIllIIlIl = llIllIIllIIIlI.rand.nextFloat() * 0.5f + 0.25;
            final double llIllIIllIIlII = llIllIIllIIIlI.rand.nextFloat() * 0.5f + 0.25;
            final EntityItem llIllIIllIIIll = new EntityItem(llIllIIllIIIlI, llIllIIllIlIIl.getX() + llIllIIllIIllI, llIllIIllIlIIl.getY() + llIllIIllIIlIl, llIllIIllIlIIl.getZ() + llIllIIllIIlII, llIllIIllIIIII);
            llIllIIllIIIll.setDefaultPickupDelay();
            llIllIIllIIIlI.spawnEntityInWorld(llIllIIllIIIll);
        }
    }
    
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }
    
    @Deprecated
    public boolean getUseNeighborBrightness(final IBlockState llIlllllIIllll) {
        return this.useNeighborBrightness;
    }
    
    public IBlockState onBlockPlaced(final World llIlIllllllIII, final BlockPos llIlIlllllIlll, final EnumFacing llIlIlllllIllI, final float llIlIlllllIlIl, final float llIlIlllllIlII, final float llIlIlllllIIll, final int llIlIlllllIIlI, final EntityLivingBase llIlIlllllIIIl) {
        return this.getStateFromMeta(llIlIlllllIIlI);
    }
    
    public boolean isPassable(final IBlockAccess llIlllIllIllII, final BlockPos llIlllIllIlIll) {
        return !this.blockMaterial.blocksMovement();
    }
    
    public boolean canSpawnInBlock() {
        return !this.blockMaterial.isSolid() && !this.blockMaterial.isLiquid();
    }
    
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[0]);
    }
    
    @Deprecated
    public Vec3d func_190949_e(final IBlockState llIlIlIIlIIlII, final IBlockAccess llIlIlIIlIIIll, final BlockPos llIlIlIIIllllI) {
        final EnumOffsetType llIlIlIIlIIIIl = this.getOffsetType();
        if (llIlIlIIlIIIIl == EnumOffsetType.NONE) {
            return Vec3d.ZERO;
        }
        final long llIlIlIIlIIIII = MathHelper.getCoordinateRandom(llIlIlIIIllllI.getX(), 0, llIlIlIIIllllI.getZ());
        return new Vec3d(((llIlIlIIlIIIII >> 16 & 0xFL) / 15.0f - 0.5) * 0.5, (llIlIlIIlIIIIl == EnumOffsetType.XYZ) ? (((llIlIlIIlIIIII >> 20 & 0xFL) / 15.0f - 1.0) * 0.2) : 0.0, ((llIlIlIIlIIIII >> 24 & 0xFL) / 15.0f - 0.5) * 0.5);
    }
    
    public enum EnumOffsetType
    {
        XZ("XZ", 1), 
        NONE("NONE", 0), 
        XYZ("XYZ", 2);
        
        private EnumOffsetType(final String lllllllllllIIIIIIIIlIIIIlIlllIlI, final int lllllllllllIIIIIIIIlIIIIlIlllIIl) {
        }
    }
}
