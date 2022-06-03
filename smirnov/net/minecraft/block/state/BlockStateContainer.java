// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state;

import java.util.Iterator;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.util.Mirror;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import java.util.Collections;
import net.minecraft.entity.Entity;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import optifine.BlockModelUtils;
import net.minecraft.block.BlockFlower;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import com.google.common.collect.ImmutableTable;
import optifine.Reflector;
import java.util.Collection;
import net.minecraft.util.MapPopulator;
import net.minecraft.util.math.Cartesian;
import java.util.Map;
import com.google.common.collect.Maps;
import com.google.common.collect.Iterables;
import com.google.common.base.MoreObjects;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import net.minecraftforge.common.property.IUnlistedProperty;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import com.google.common.base.Function;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableList;

public class BlockStateContainer
{
    private final /* synthetic */ ImmutableList<IBlockState> validStates;
    private final /* synthetic */ ImmutableSortedMap<String, IProperty<?>> properties;
    private final /* synthetic */ Block block;
    private static final /* synthetic */ Pattern NAME_PATTERN;
    private static final /* synthetic */ Function<IProperty<?>, String> GET_NAME_FUNC;
    
    static {
        NAME_PATTERN = Pattern.compile("^[a-z0-9_]+$");
        GET_NAME_FUNC = (Function)new Function<IProperty<?>, String>() {
            @Nullable
            public String apply(@Nullable final IProperty<?> llllllllllllllIIllIlIlIIIIIlIIlI) {
                return (llllllllllllllIIllIlIlIIIIIlIIlI == null) ? "<NULL>" : llllllllllllllIIllIlIlIIIIIlIIlI.getName();
            }
        };
    }
    
    public IBlockState getBaseState() {
        return (IBlockState)this.validStates.get(0);
    }
    
    public BlockStateContainer(final Block llllllllllllIlIIlIIlIllIlllIIIlI, final IProperty<?>... llllllllllllIlIIlIIlIllIllIllllI) {
        this(llllllllllllIlIIlIIlIllIlllIIIlI, llllllllllllIlIIlIIlIllIllIllllI, null);
    }
    
    public static <T extends Comparable<T>> String validateProperty(final Block llllllllllllIlIIlIIlIllIlIlIlIII, final IProperty<T> llllllllllllIlIIlIIlIllIlIlIllII) {
        final String llllllllllllIlIIlIIlIllIlIlIlIll = llllllllllllIlIIlIIlIllIlIlIllII.getName();
        if (!BlockStateContainer.NAME_PATTERN.matcher(llllllllllllIlIIlIIlIllIlIlIlIll).matches()) {
            throw new IllegalArgumentException("Block: " + llllllllllllIlIIlIIlIllIlIlIlIII.getClass() + " has invalidly named property: " + llllllllllllIlIIlIIlIllIlIlIlIll);
        }
        for (final T llllllllllllIlIIlIIlIllIlIlIlIlI : llllllllllllIlIIlIIlIllIlIlIllII.getAllowedValues()) {
            final String llllllllllllIlIIlIIlIllIlIlIlIIl = llllllllllllIlIIlIIlIllIlIlIllII.getName(llllllllllllIlIIlIIlIllIlIlIlIlI);
            if (!BlockStateContainer.NAME_PATTERN.matcher(llllllllllllIlIIlIIlIllIlIlIlIIl).matches()) {
                throw new IllegalArgumentException("Block: " + llllllllllllIlIIlIIlIllIlIlIlIII.getClass() + " has property: " + llllllllllllIlIIlIIlIllIlIlIlIll + " with invalidly named value: " + llllllllllllIlIIlIIlIllIlIlIlIIl);
            }
        }
        return llllllllllllIlIIlIIlIllIlIlIlIll;
    }
    
    private List<Iterable<Comparable<?>>> getAllowedValues() {
        final List<Iterable<Comparable<?>>> llllllllllllIlIIlIIlIllIlIIllIIl = (List<Iterable<Comparable<?>>>)Lists.newArrayList();
        final ImmutableCollection<IProperty<?>> llllllllllllIlIIlIIlIllIlIIllIII = (ImmutableCollection<IProperty<?>>)this.properties.values();
        for (final IProperty<?> llllllllllllIlIIlIIlIllIlIIlIllI : llllllllllllIlIIlIIlIllIlIIllIII) {
            llllllllllllIlIIlIIlIllIlIIllIIl.add((Iterable<Comparable<?>>)llllllllllllIlIIlIIlIllIlIIlIllI.getAllowedValues());
        }
        return llllllllllllIlIIlIIlIllIlIIllIIl;
    }
    
    protected StateImplementation createState(final Block llllllllllllIlIIlIIlIllIllIlIlll, final ImmutableMap<IProperty<?>, Comparable<?>> llllllllllllIlIIlIIlIllIllIlIllI, @Nullable final ImmutableMap<IUnlistedProperty<?>, Optional<?>> llllllllllllIlIIlIIlIllIllIllIII) {
        return new StateImplementation(llllllllllllIlIIlIIlIllIllIlIlll, llllllllllllIlIIlIIlIllIllIlIllI, (StateImplementation)null);
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    @Nullable
    public IProperty<?> getProperty(final String llllllllllllIlIIlIIlIllIIlllllll) {
        return (IProperty<?>)this.properties.get((Object)llllllllllllIlIIlIIlIllIIlllllll);
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("block", (Object)Block.REGISTRY.getNameForObject(this.block)).add("properties", (Object)Iterables.transform((Iterable)this.properties.values(), (Function)BlockStateContainer.GET_NAME_FUNC)).toString();
    }
    
    protected BlockStateContainer(final Block llllllllllllIlIIlIIlIllIlIllllIl, final IProperty<?>[] llllllllllllIlIIlIIlIllIllIIlIII, final ImmutableMap<IUnlistedProperty<?>, Optional<?>> llllllllllllIlIIlIIlIllIlIlllIll) {
        this.block = llllllllllllIlIIlIIlIllIlIllllIl;
        final Map<String, IProperty<?>> llllllllllllIlIIlIIlIllIllIIIllI = (Map<String, IProperty<?>>)Maps.newHashMap();
        float llllllllllllIlIIlIIlIllIlIllIllI = (Object)llllllllllllIlIIlIIlIllIllIIlIII;
        final String llllllllllllIlIIlIIlIllIlIllIlll = (String)llllllllllllIlIIlIIlIllIllIIlIII.length;
        for (long llllllllllllIlIIlIIlIllIlIlllIII = 0; llllllllllllIlIIlIIlIllIlIlllIII < llllllllllllIlIIlIIlIllIlIllIlll; ++llllllllllllIlIIlIIlIllIlIlllIII) {
            final IProperty<?> llllllllllllIlIIlIIlIllIllIIIlIl = llllllllllllIlIIlIIlIllIlIllIllI[llllllllllllIlIIlIIlIllIlIlllIII];
            validateProperty(llllllllllllIlIIlIIlIllIlIllllIl, llllllllllllIlIIlIIlIllIllIIIlIl);
            llllllllllllIlIIlIIlIllIllIIIllI.put(llllllllllllIlIIlIIlIllIllIIIlIl.getName(), llllllllllllIlIIlIIlIllIllIIIlIl);
        }
        this.properties = (ImmutableSortedMap<String, IProperty<?>>)ImmutableSortedMap.copyOf((Map)llllllllllllIlIIlIIlIllIllIIIllI);
        final Map<Map<IProperty<?>, Comparable<?>>, StateImplementation> llllllllllllIlIIlIIlIllIllIIIlII = (Map<Map<IProperty<?>, Comparable<?>>, StateImplementation>)Maps.newLinkedHashMap();
        final List<StateImplementation> llllllllllllIlIIlIIlIllIllIIIIll = (List<StateImplementation>)Lists.newArrayList();
        llllllllllllIlIIlIIlIllIlIllIllI = (float)Cartesian.cartesianProduct((Iterable<? extends Iterable<?>>)this.getAllowedValues()).iterator();
        while (((Iterator)llllllllllllIlIIlIIlIllIlIllIllI).hasNext()) {
            final List<Comparable<?>> llllllllllllIlIIlIIlIllIllIIIIlI = ((Iterator<List<Comparable<?>>>)llllllllllllIlIIlIIlIllIlIllIllI).next();
            final Map<IProperty<?>, Comparable<?>> llllllllllllIlIIlIIlIllIllIIIIIl = MapPopulator.createMap((Iterable<IProperty<?>>)this.properties.values(), llllllllllllIlIIlIIlIllIllIIIIlI);
            final StateImplementation llllllllllllIlIIlIIlIllIllIIIIII = this.createState(llllllllllllIlIIlIIlIllIlIllllIl, (ImmutableMap<IProperty<?>, Comparable<?>>)ImmutableMap.copyOf((Map)llllllllllllIlIIlIIlIllIllIIIIIl), llllllllllllIlIIlIIlIllIlIlllIll);
            llllllllllllIlIIlIIlIllIllIIIlII.put(llllllllllllIlIIlIIlIllIllIIIIIl, llllllllllllIlIIlIIlIllIllIIIIII);
            llllllllllllIlIIlIIlIllIllIIIIll.add(llllllllllllIlIIlIIlIllIllIIIIII);
        }
        llllllllllllIlIIlIIlIllIlIllIllI = (float)llllllllllllIlIIlIIlIllIllIIIIll.iterator();
        while (((Iterator)llllllllllllIlIIlIIlIllIlIllIllI).hasNext()) {
            final StateImplementation llllllllllllIlIIlIIlIllIlIllllll = ((Iterator<StateImplementation>)llllllllllllIlIIlIIlIllIlIllIllI).next();
            llllllllllllIlIIlIIlIllIlIllllll.buildPropertyValueTable(llllllllllllIlIIlIIlIllIllIIIlII);
        }
        this.validStates = (ImmutableList<IBlockState>)ImmutableList.copyOf((Collection)llllllllllllIlIIlIIlIllIllIIIIll);
    }
    
    public Collection<IProperty<?>> getProperties() {
        return (Collection<IProperty<?>>)this.properties.values();
    }
    
    public ImmutableList<IBlockState> getValidStates() {
        return this.validStates;
    }
    
    public static class Builder
    {
        private final /* synthetic */ List<IProperty<?>> listed;
        private final /* synthetic */ List<IUnlistedProperty<?>> unlisted;
        private final /* synthetic */ Block block;
        
        public Builder add(final IProperty<?>... lllllllllllIlIlIlIlllIlllllllIlI) {
            final int lllllllllllIlIlIlIlllIllllllIIll = (Object)lllllllllllIlIlIlIlllIlllllllIlI;
            final boolean lllllllllllIlIlIlIlllIllllllIlII = lllllllllllIlIlIlIlllIlllllllIlI.length != 0;
            for (double lllllllllllIlIlIlIlllIllllllIlIl = 0; lllllllllllIlIlIlIlllIllllllIlIl < (lllllllllllIlIlIlIlllIllllllIlII ? 1 : 0); ++lllllllllllIlIlIlIlllIllllllIlIl) {
                final IProperty<?> lllllllllllIlIlIlIlllIlllllllIIl = lllllllllllIlIlIlIlllIllllllIIll[lllllllllllIlIlIlIlllIllllllIlIl];
                this.listed.add(lllllllllllIlIlIlIlllIlllllllIIl);
            }
            return this;
        }
        
        public BlockStateContainer build() {
            IProperty[] lllllllllllIlIlIlIlllIllllIlllll = new IProperty[this.listed.size()];
            lllllllllllIlIlIlIlllIllllIlllll = this.listed.toArray(lllllllllllIlIlIlIlllIllllIlllll);
            if (this.unlisted.size() == 0) {
                return new BlockStateContainer(this.block, (IProperty<?>[])lllllllllllIlIlIlIlllIllllIlllll);
            }
            IUnlistedProperty[] lllllllllllIlIlIlIlllIllllIllllI = new IUnlistedProperty[this.unlisted.size()];
            lllllllllllIlIlIlIlllIllllIllllI = this.unlisted.toArray(lllllllllllIlIlIlIlllIllllIllllI);
            return (BlockStateContainer)Reflector.newInstance(Reflector.ExtendedBlockState_Constructor, new Object[] { this.block, lllllllllllIlIlIlIlllIllllIlllll, lllllllllllIlIlIlIlllIllllIllllI });
        }
        
        public Builder add(final IUnlistedProperty<?>... lllllllllllIlIlIlIlllIlllllIlIll) {
            final char lllllllllllIlIlIlIlllIlllllIIlII = (Object)lllllllllllIlIlIlIlllIlllllIlIll;
            final char lllllllllllIlIlIlIlllIlllllIIlIl = (char)lllllllllllIlIlIlIlllIlllllIlIll.length;
            for (double lllllllllllIlIlIlIlllIlllllIIllI = 0; lllllllllllIlIlIlIlllIlllllIIllI < lllllllllllIlIlIlIlllIlllllIIlIl; ++lllllllllllIlIlIlIlllIlllllIIllI) {
                final IUnlistedProperty<?> lllllllllllIlIlIlIlllIlllllIlIlI = lllllllllllIlIlIlIlllIlllllIIlII[lllllllllllIlIlIlIlllIlllllIIllI];
                this.unlisted.add(lllllllllllIlIlIlIlllIlllllIlIlI);
            }
            return this;
        }
        
        public Builder(final Block lllllllllllIlIlIlIllllIIIIIIIIlI) {
            this.listed = (List<IProperty<?>>)Lists.newArrayList();
            this.unlisted = (List<IUnlistedProperty<?>>)Lists.newArrayList();
            this.block = lllllllllllIlIlIlIllllIIIIIIIIlI;
        }
    }
    
    static class StateImplementation extends BlockStateBase
    {
        private final /* synthetic */ Block block;
        private final /* synthetic */ ImmutableMap<IProperty<?>, Comparable<?>> properties;
        private /* synthetic */ ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> propertyValueTable;
        
        @Override
        public AxisAlignedBB getBoundingBox(final IBlockAccess llllllllllllllIIIIIlllIIlIlIllIl, final BlockPos llllllllllllllIIIIIlllIIlIlIllII) {
            final Block.EnumOffsetType llllllllllllllIIIIIlllIIlIllIIII = this.block.getOffsetType();
            if (llllllllllllllIIIIIlllIIlIllIIII != Block.EnumOffsetType.NONE && !(this.block instanceof BlockFlower)) {
                AxisAlignedBB llllllllllllllIIIIIlllIIlIlIllll = this.block.getBoundingBox(this, llllllllllllllIIIIIlllIIlIlIllIl, llllllllllllllIIIIIlllIIlIlIllII);
                llllllllllllllIIIIIlllIIlIlIllll = BlockModelUtils.getOffsetBoundingBox(llllllllllllllIIIIIlllIIlIlIllll, llllllllllllllIIIIIlllIIlIllIIII, llllllllllllllIIIIIlllIIlIlIllII);
                return llllllllllllllIIIIIlllIIlIlIllll;
            }
            return this.block.getBoundingBox(this, llllllllllllllIIIIIlllIIlIlIllIl, llllllllllllllIIIIIlllIIlIlIllII);
        }
        
        @Override
        public Material getMaterial() {
            return this.block.getMaterial(this);
        }
        
        @Override
        public ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> getPropertyValueTable() {
            return this.propertyValueTable;
        }
        
        @Override
        public boolean isFullCube() {
            return this.block.isFullCube(this);
        }
        
        public boolean isSideSolid(final IBlockAccess llllllllllllllIIIIIlllIIIlIIllll, final BlockPos llllllllllllllIIIIIlllIIIlIlIIlI, final EnumFacing llllllllllllllIIIIIlllIIIlIIllIl) {
            return Reflector.callBoolean((Object)this.block, Reflector.ForgeBlock_isSideSolid, new Object[] { this, llllllllllllllIIIIIlllIIIlIIllll, llllllllllllllIIIIIlllIIIlIlIIlI, llllllllllllllIIIIIlllIIIlIIllIl });
        }
        
        @Override
        public boolean isFullBlock() {
            return this.block.isFullBlock(this);
        }
        
        @Override
        public boolean onBlockEventReceived(final World llllllllllllllIIIIIlllIIlIIIlIII, final BlockPos llllllllllllllIIIIIlllIIlIIIIlll, final int llllllllllllllIIIIIlllIIlIIIIllI, final int llllllllllllllIIIIIlllIIlIIIIlIl) {
            return this.block.eventReceived(this, llllllllllllllIIIIIlllIIlIIIlIII, llllllllllllllIIIIIlllIIlIIIIlll, llllllllllllllIIIIIlllIIlIIIIllI, llllllllllllllIIIIIlllIIlIIIIlIl);
        }
        
        private StateImplementation(final Block llllllllllllllIIIIIlllIlllIlllII, final ImmutableMap<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlllIlllIllIII) {
            this.block = llllllllllllllIIIIIlllIlllIlllII;
            this.properties = llllllllllllllIIIIIlllIlllIllIII;
        }
        
        @Override
        public boolean shouldSideBeRendered(final IBlockAccess llllllllllllllIIIIIlllIIlllIIIII, final BlockPos llllllllllllllIIIIIlllIIllIllIll, final EnumFacing llllllllllllllIIIIIlllIIllIllllI) {
            return this.block.shouldSideBeRendered(this, llllllllllllllIIIIIlllIIlllIIIII, llllllllllllllIIIIIlllIIllIllIll, llllllllllllllIIIIIlllIIllIllllI);
        }
        
        @Override
        public boolean isFullyOpaque() {
            return this.block.isFullyOpaque(this);
        }
        
        @Override
        public int getStrongPower(final IBlockAccess llllllllllllllIIIIIlllIIllllllIl, final BlockPos llllllllllllllIIIIIlllIIllllllII, final EnumFacing llllllllllllllIIIIIlllIIlllllIll) {
            return this.block.getStrongPower(this, llllllllllllllIIIIIlllIIllllllIl, llllllllllllllIIIIIlllIIllllllII, llllllllllllllIIIIIlllIIlllllIll);
        }
        
        @Override
        public boolean isTranslucent() {
            return this.block.isTranslucent(this);
        }
        
        @Override
        public int getWeakPower(final IBlockAccess llllllllllllllIIIIIlllIlIIlIlIlI, final BlockPos llllllllllllllIIIIIlllIlIIlIlIIl, final EnumFacing llllllllllllllIIIIIlllIlIIlIlIII) {
            return this.block.getWeakPower(this, llllllllllllllIIIIIlllIlIIlIlIlI, llllllllllllllIIIIIlllIlIIlIlIIl, llllllllllllllIIIIIlllIlIIlIlIII);
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIIIIIlllIllIlIIlIl) {
            return this == llllllllllllllIIIIIlllIllIlIIlIl;
        }
        
        @Override
        public int getLightValue() {
            return this.block.getLightValue(this);
        }
        
        public boolean doesSideBlockRendering(final IBlockAccess llllllllllllllIIIIIlllIIIlIIIIll, final BlockPos llllllllllllllIIIIIlllIIIlIIIllI, final EnumFacing llllllllllllllIIIIIlllIIIlIIIlIl) {
            return Reflector.callBoolean((Object)this.block, Reflector.ForgeBlock_doesSideBlockRendering, new Object[] { this, llllllllllllllIIIIIlllIIIlIIIIll, llllllllllllllIIIIIlllIIIlIIIllI, llllllllllllllIIIIIlllIIIlIIIlIl });
        }
        
        @Override
        public int hashCode() {
            return this.properties.hashCode();
        }
        
        @Override
        public boolean hasComparatorInputOverride() {
            return this.block.hasComparatorInputOverride(this);
        }
        
        @Override
        public boolean isOpaqueCube() {
            return this.block.isOpaqueCube(this);
        }
        
        @Override
        public <T extends Comparable<T>> T getValue(final IProperty<T> llllllllllllllIIIIIlllIlllIIIIIl) {
            final Comparable<?> llllllllllllllIIIIIlllIlllIIIIll = (Comparable<?>)this.properties.get((Object)llllllllllllllIIIIIlllIlllIIIIIl);
            if (llllllllllllllIIIIIlllIlllIIIIll == null) {
                throw new IllegalArgumentException("Cannot get property " + llllllllllllllIIIIIlllIlllIIIIIl + " as it does not exist in " + this.block.getBlockState());
            }
            return llllllllllllllIIIIIlllIlllIIIIIl.getValueClass().cast(llllllllllllllIIIIIlllIlllIIIIll);
        }
        
        private Map<IProperty<?>, Comparable<?>> getPropertiesWithValue(final IProperty<?> llllllllllllllIIIIIlllIllIIIIIIl, final Comparable<?> llllllllllllllIIIIIlllIllIIIIIII) {
            final Map<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlllIllIIIIIll = (Map<IProperty<?>, Comparable<?>>)Maps.newHashMap((Map)this.properties);
            llllllllllllllIIIIIlllIllIIIIIll.put(llllllllllllllIIIIIlllIllIIIIIIl, llllllllllllllIIIIIlllIllIIIIIII);
            return llllllllllllllIIIIIlllIllIIIIIll;
        }
        
        @Override
        public boolean func_191058_s() {
            return this.block.causesSuffocation(this);
        }
        
        @Override
        public IBlockState withRotation(final Rotation llllllllllllllIIIIIlllIlIlIllIII) {
            return this.block.withRotation(this, llllllllllllllIIIIIlllIlIlIllIII);
        }
        
        @Override
        public float getBlockHardness(final World llllllllllllllIIIIIlllIlIIIlIlII, final BlockPos llllllllllllllIIIIIlllIlIIIlIllI) {
            return this.block.getBlockHardness(this, llllllllllllllIIIIIlllIlIIIlIlII, llllllllllllllIIIIIlllIlIIIlIllI);
        }
        
        @Override
        public IBlockState getActualState(final IBlockAccess llllllllllllllIIIIIlllIIllllIIII, final BlockPos llllllllllllllIIIIIlllIIlllIllll) {
            return this.block.getActualState(this, llllllllllllllIIIIIlllIIllllIIII, llllllllllllllIIIIIlllIIlllIllll);
        }
        
        @Override
        public int getComparatorInputOverride(final World llllllllllllllIIIIIlllIlIIIlllIl, final BlockPos llllllllllllllIIIIIlllIlIIIlllII) {
            return this.block.getComparatorInputOverride(this, llllllllllllllIIIIIlllIlIIIlllIl, llllllllllllllIIIIIlllIlIIIlllII);
        }
        
        public int getLightValue(final IBlockAccess llllllllllllllIIIIIlllIIIlIlllIl, final BlockPos llllllllllllllIIIIIlllIIIlIllIIl) {
            return Reflector.callInt((Object)this.block, Reflector.ForgeBlock_getLightValue, new Object[] { this, llllllllllllllIIIIIlllIIIlIlllIl, llllllllllllllIIIIIlllIIIlIllIIl });
        }
        
        @Override
        public RayTraceResult collisionRayTrace(final World llllllllllllllIIIIIlllIIlIlIIIll, final BlockPos llllllllllllllIIIIIlllIIlIIlllIl, final Vec3d llllllllllllllIIIIIlllIIlIIlllII, final Vec3d llllllllllllllIIIIIlllIIlIIllIll) {
            return this.block.collisionRayTrace(this, llllllllllllllIIIIIlllIIlIlIIIll, llllllllllllllIIIIIlllIIlIIlllIl, llllllllllllllIIIIIlllIIlIIlllII, llllllllllllllIIIIIlllIIlIIllIll);
        }
        
        @Nullable
        @Override
        public AxisAlignedBB getCollisionBoundingBox(final IBlockAccess llllllllllllllIIIIIlllIIllIIllll, final BlockPos llllllllllllllIIIIIlllIIllIIlllI) {
            return this.block.getCollisionBoundingBox(this, llllllllllllllIIIIIlllIIllIIllll, llllllllllllllIIIIIlllIIllIIlllI);
        }
        
        public void buildPropertyValueTable(final Map<Map<IProperty<?>, Comparable<?>>, StateImplementation> llllllllllllllIIIIIlllIllIIllIII) {
            if (this.propertyValueTable != null) {
                throw new IllegalStateException();
            }
            final Table<IProperty<?>, Comparable<?>, IBlockState> llllllllllllllIIIIIlllIllIIlIlll = (Table<IProperty<?>, Comparable<?>, IBlockState>)HashBasedTable.create();
            for (final Map.Entry<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlllIllIIlIlIl : this.properties.entrySet()) {
                final IProperty<?> llllllllllllllIIIIIlllIllIIlIlII = llllllllllllllIIIIIlllIllIIlIlIl.getKey();
                for (final Comparable<?> llllllllllllllIIIIIlllIllIIlIIll : llllllllllllllIIIIIlllIllIIlIlII.getAllowedValues()) {
                    if (llllllllllllllIIIIIlllIllIIlIIll != llllllllllllllIIIIIlllIllIIlIlIl.getValue()) {
                        llllllllllllllIIIIIlllIllIIlIlll.put((Object)llllllllllllllIIIIIlllIllIIlIlII, (Object)llllllllllllllIIIIIlllIllIIlIIll, (Object)llllllllllllllIIIIIlllIllIIllIII.get(this.getPropertiesWithValue(llllllllllllllIIIIIlllIllIIlIlII, llllllllllllllIIIIIlllIllIIlIIll)));
                    }
                }
            }
            this.propertyValueTable = (ImmutableTable<IProperty<?>, Comparable<?>, IBlockState>)ImmutableTable.copyOf((Table)llllllllllllllIIIIIlllIllIIlIlll);
        }
        
        @Override
        public boolean canEntitySpawn(final Entity llllllllllllllIIIIIlllIlIlllIIll) {
            return this.block.canEntitySpawn(this, llllllllllllllIIIIIlllIlIlllIIll);
        }
        
        @Override
        public int getPackedLightmapCoords(final IBlockAccess llllllllllllllIIIIIlllIlIlIIIlII, final BlockPos llllllllllllllIIIIIlllIlIlIIIIII) {
            return this.block.getPackedLightmapCoords(this, llllllllllllllIIIIIlllIlIlIIIlII, llllllllllllllIIIIIlllIlIlIIIIII);
        }
        
        @Override
        public boolean func_191057_i() {
            return this.block.func_190946_v(this);
        }
        
        @Override
        public void neighborChanged(final World llllllllllllllIIIIIlllIIIllllIIl, final BlockPos llllllllllllllIIIIIlllIIIlllIIll, final Block llllllllllllllIIIIIlllIIIlllIlll, final BlockPos llllllllllllllIIIIIlllIIIlllIIIl) {
            this.block.neighborChanged(this, llllllllllllllIIIIIlllIIIllllIIl, llllllllllllllIIIIIlllIIIlllIIll, llllllllllllllIIIIIlllIIIlllIlll, llllllllllllllIIIIIlllIIIlllIIIl);
        }
        
        public int getLightOpacity(final IBlockAccess llllllllllllllIIIIIlllIIIllIIllI, final BlockPos llllllllllllllIIIIIlllIIIllIIIlI) {
            return Reflector.callInt((Object)this.block, Reflector.ForgeBlock_getLightOpacity, new Object[] { this, llllllllllllllIIIIIlllIIIllIIllI, llllllllllllllIIIIIlllIIIllIIIlI });
        }
        
        @Override
        public boolean canProvidePower() {
            return this.block.canProvidePower(this);
        }
        
        @Override
        public boolean isNormalCube() {
            return this.block.isNormalCube(this);
        }
        
        @Override
        public Collection<IProperty<?>> getPropertyNames() {
            return Collections.unmodifiableCollection((Collection<? extends IProperty<?>>)this.properties.keySet());
        }
        
        @Override
        public EnumBlockRenderType getRenderType() {
            return this.block.getRenderType(this);
        }
        
        @Override
        public BlockFaceShape func_193401_d(final IBlockAccess llllllllllllllIIIIIlllIIIIlllIll, final BlockPos llllllllllllllIIIIIlllIIIIlllIlI, final EnumFacing llllllllllllllIIIIIlllIIIIllIlIl) {
            return this.block.func_193383_a(llllllllllllllIIIIIlllIIIIlllIll, this, llllllllllllllIIIIIlllIIIIlllIlI, llllllllllllllIIIIIlllIIIIllIlIl);
        }
        
        @Override
        public Block getBlock() {
            return this.block;
        }
        
        @Override
        public ImmutableMap<IProperty<?>, Comparable<?>> getProperties() {
            return this.properties;
        }
        
        protected StateImplementation(final Block llllllllllllllIIIIIlllIlllIIlllI, final ImmutableMap<IProperty<?>, Comparable<?>> llllllllllllllIIIIIlllIlllIIllIl, final ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> llllllllllllllIIIIIlllIlllIIllII) {
            this.block = llllllllllllllIIIIIlllIlllIIlllI;
            this.properties = llllllllllllllIIIIIlllIlllIIllIl;
            this.propertyValueTable = llllllllllllllIIIIIlllIlllIIllII;
        }
        
        @Override
        public AxisAlignedBB getSelectedBoundingBox(final World llllllllllllllIIIIIlllIIlllIIlll, final BlockPos llllllllllllllIIIIIlllIIlllIIllI) {
            return this.block.getSelectedBoundingBox(this, llllllllllllllIIIIIlllIIlllIIlll, llllllllllllllIIIIIlllIIlllIIllI);
        }
        
        @Override
        public float getAmbientOcclusionLightValue() {
            return this.block.getAmbientOcclusionLightValue(this);
        }
        
        @Override
        public boolean useNeighborBrightness() {
            return this.block.getUseNeighborBrightness(this);
        }
        
        @Override
        public <T extends Comparable<T>, V extends T> IBlockState withProperty(final IProperty<T> llllllllllllllIIIIIlllIllIllIlII, final V llllllllllllllIIIIIlllIllIlllIII) {
            final Comparable<?> llllllllllllllIIIIIlllIllIllIlll = (Comparable<?>)this.properties.get((Object)llllllllllllllIIIIIlllIllIllIlII);
            if (llllllllllllllIIIIIlllIllIllIlll == null) {
                throw new IllegalArgumentException("Cannot set property " + llllllllllllllIIIIIlllIllIllIlII + " as it does not exist in " + this.block.getBlockState());
            }
            if (llllllllllllllIIIIIlllIllIllIlll == llllllllllllllIIIIIlllIllIlllIII) {
                return this;
            }
            final IBlockState llllllllllllllIIIIIlllIllIllIllI = (IBlockState)this.propertyValueTable.get((Object)llllllllllllllIIIIIlllIllIllIlII, (Object)llllllllllllllIIIIIlllIllIlllIII);
            if (llllllllllllllIIIIIlllIllIllIllI == null) {
                throw new IllegalArgumentException("Cannot set property " + llllllllllllllIIIIIlllIllIllIlII + " to " + llllllllllllllIIIIIlllIllIlllIII + " on block " + Block.REGISTRY.getNameForObject(this.block) + ", it is not an allowed value");
            }
            return llllllllllllllIIIIIlllIllIllIllI;
        }
        
        @Override
        public float getPlayerRelativeBlockHardness(final EntityPlayer llllllllllllllIIIIIlllIlIIIIlIIl, final World llllllllllllllIIIIIlllIlIIIIllII, final BlockPos llllllllllllllIIIIIlllIlIIIIIlll) {
            return this.block.getPlayerRelativeBlockHardness(this, llllllllllllllIIIIIlllIlIIIIlIIl, llllllllllllllIIIIIlllIlIIIIllII, llllllllllllllIIIIIlllIlIIIIIlll);
        }
        
        @Override
        public IBlockState withMirror(final Mirror llllllllllllllIIIIIlllIlIlIlIlII) {
            return this.block.withMirror(this, llllllllllllllIIIIIlllIlIlIlIlII);
        }
        
        @Override
        public void addCollisionBoxToList(final World llllllllllllllIIIIIlllIIllIIIlIl, final BlockPos llllllllllllllIIIIIlllIIllIIIlII, final AxisAlignedBB llllllllllllllIIIIIlllIIlIllllII, final List<AxisAlignedBB> llllllllllllllIIIIIlllIIllIIIIlI, @Nullable final Entity llllllllllllllIIIIIlllIIllIIIIIl, final boolean llllllllllllllIIIIIlllIIllIIIIII) {
            this.block.addCollisionBoxToList(this, llllllllllllllIIIIIlllIIllIIIlIl, llllllllllllllIIIIIlllIIllIIIlII, llllllllllllllIIIIIlllIIlIllllII, llllllllllllllIIIIIlllIIllIIIIlI, llllllllllllllIIIIIlllIIllIIIIIl, llllllllllllllIIIIIlllIIllIIIIII);
        }
        
        @Override
        public Vec3d func_191059_e(final IBlockAccess llllllllllllllIIIIIlllIIlIIlIIll, final BlockPos llllllllllllllIIIIIlllIIlIIlIIlI) {
            return this.block.func_190949_e(this, llllllllllllllIIIIIlllIIlIIlIIll, llllllllllllllIIIIIlllIIlIIlIIlI);
        }
        
        @Override
        public int getLightOpacity() {
            return this.block.getLightOpacity(this);
        }
        
        @Override
        public EnumPushReaction getMobilityFlag() {
            return this.block.getMobilityFlag(this);
        }
        
        @Override
        public boolean isBlockNormalCube() {
            return this.block.isBlockNormalCube(this);
        }
        
        @Override
        public MapColor getMapColor(final IBlockAccess llllllllllllllIIIIIlllIlIllIIIlI, final BlockPos llllllllllllllIIIIIlllIlIllIIIIl) {
            return this.block.getMapColor(this, llllllllllllllIIIIIlllIlIllIIIlI, llllllllllllllIIIIIlllIlIllIIIIl);
        }
    }
}
