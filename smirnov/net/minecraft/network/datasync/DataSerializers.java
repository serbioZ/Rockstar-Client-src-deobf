// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.datasync;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IntIdentityHashBiMap;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Rotations;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import java.util.UUID;
import com.google.common.base.Optional;

public class DataSerializers
{
    public static final /* synthetic */ DataSerializer<Float> FLOAT;
    public static final /* synthetic */ DataSerializer<Optional<UUID>> OPTIONAL_UNIQUE_ID;
    public static final /* synthetic */ DataSerializer<BlockPos> BLOCK_POS;
    public static final /* synthetic */ DataSerializer<ItemStack> OPTIONAL_ITEM_STACK;
    public static final /* synthetic */ DataSerializer<Byte> BYTE;
    public static final /* synthetic */ DataSerializer<Boolean> BOOLEAN;
    public static final /* synthetic */ DataSerializer<String> STRING;
    public static final /* synthetic */ DataSerializer<Rotations> ROTATIONS;
    public static final /* synthetic */ DataSerializer<NBTTagCompound> field_192734_n;
    public static final /* synthetic */ DataSerializer<Optional<IBlockState>> OPTIONAL_BLOCK_STATE;
    public static final /* synthetic */ DataSerializer<EnumFacing> FACING;
    public static final /* synthetic */ DataSerializer<Optional<BlockPos>> OPTIONAL_BLOCK_POS;
    public static final /* synthetic */ DataSerializer<ITextComponent> TEXT_COMPONENT;
    public static final /* synthetic */ DataSerializer<Integer> VARINT;
    private static final /* synthetic */ IntIdentityHashBiMap<DataSerializer<?>> REGISTRY;
    
    public static int getSerializerId(final DataSerializer<?> lllllllllllllIIIIlIlIlIllIIllIlI) {
        return DataSerializers.REGISTRY.getId(lllllllllllllIIIIlIlIlIllIIllIlI);
    }
    
    static {
        REGISTRY = new IntIdentityHashBiMap<DataSerializer<?>>(16);
        BYTE = new DataSerializer<Byte>() {
            @Override
            public Byte read(final PacketBuffer lllllllllllllIlllIllIlllIlllIIll) throws IOException {
                return lllllllllllllIlllIllIlllIlllIIll.readByte();
            }
            
            @Override
            public Byte func_192717_a(final Byte lllllllllllllIlllIllIlllIllIlIlI) {
                return lllllllllllllIlllIllIlllIllIlIlI;
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllIlllIllIlllIllllIII, final Byte lllllllllllllIlllIllIlllIlllIlll) {
                lllllllllllllIlllIllIlllIllllIII.writeByte(lllllllllllllIlllIllIlllIlllIlll);
            }
            
            @Override
            public DataParameter<Byte> createKey(final int lllllllllllllIlllIllIlllIllIllll) {
                return new DataParameter<Byte>(lllllllllllllIlllIllIlllIllIllll, this);
            }
        };
        VARINT = new DataSerializer<Integer>() {
            @Override
            public void write(final PacketBuffer llllllllllllllIIllIlllllIIIIlIIl, final Integer llllllllllllllIIllIlllllIIIIlIII) {
                llllllllllllllIIllIlllllIIIIlIIl.writeVarIntToBuffer(llllllllllllllIIllIlllllIIIIlIII);
            }
            
            @Override
            public DataParameter<Integer> createKey(final int llllllllllllllIIllIllllIllllllII) {
                return new DataParameter<Integer>(llllllllllllllIIllIllllIllllllII, this);
            }
            
            @Override
            public Integer read(final PacketBuffer llllllllllllllIIllIlllllIIIIIIlI) throws IOException {
                return llllllllllllllIIllIlllllIIIIIIlI.readVarIntFromBuffer();
            }
            
            @Override
            public Integer func_192717_a(final Integer llllllllllllllIIllIllllIlllllIII) {
                return llllllllllllllIIllIllllIlllllIII;
            }
        };
        FLOAT = new DataSerializer<Float>() {
            @Override
            public Float read(final PacketBuffer llllllllllllllIlllIllllIllIIlIIl) throws IOException {
                return llllllllllllllIlllIllllIllIIlIIl.readFloat();
            }
            
            @Override
            public void write(final PacketBuffer llllllllllllllIlllIllllIllIIlllI, final Float llllllllllllllIlllIllllIllIIllll) {
                llllllllllllllIlllIllllIllIIlllI.writeFloat(llllllllllllllIlllIllllIllIIllll);
            }
            
            @Override
            public DataParameter<Float> createKey(final int llllllllllllllIlllIllllIllIIIIll) {
                return new DataParameter<Float>(llllllllllllllIlllIllllIllIIIIll, this);
            }
            
            @Override
            public Float func_192717_a(final Float llllllllllllllIlllIllllIllIIIIII) {
                return llllllllllllllIlllIllllIllIIIIII;
            }
        };
        STRING = new DataSerializer<String>() {
            @Override
            public String read(final PacketBuffer lllllllllllIlllIllIlIIlIIlIIIIIl) throws IOException {
                return lllllllllllIlllIllIlIIlIIlIIIIIl.readStringFromBuffer(32767);
            }
            
            @Override
            public String func_192717_a(final String lllllllllllIlllIllIlIIlIIIllIllI) {
                return lllllllllllIlllIllIlIIlIIIllIllI;
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllIlllIllIlIIlIIlIIIlll, final String lllllllllllIlllIllIlIIlIIlIIIlII) {
                lllllllllllIlllIllIlIIlIIlIIIlll.writeString(lllllllllllIlllIllIlIIlIIlIIIlII);
            }
            
            @Override
            public DataParameter<String> createKey(final int lllllllllllIlllIllIlIIlIIIlllIlI) {
                return new DataParameter<String>(lllllllllllIlllIllIlIIlIIIlllIlI, this);
            }
        };
        TEXT_COMPONENT = new DataSerializer<ITextComponent>() {
            @Override
            public DataParameter<ITextComponent> createKey(final int lllllllllllllllIlIIIlllIllIIIlII) {
                return new DataParameter<ITextComponent>(lllllllllllllllIlIIIlllIllIIIlII, this);
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllllIlIIIlllIllIIllIl, final ITextComponent lllllllllllllllIlIIIlllIllIIlllI) {
                lllllllllllllllIlIIIlllIllIIllIl.writeTextComponent(lllllllllllllllIlIIIlllIllIIlllI);
            }
            
            @Override
            public ITextComponent func_192717_a(final ITextComponent lllllllllllllllIlIIIlllIlIllllll) {
                return lllllllllllllllIlIIIlllIlIllllll.createCopy();
            }
            
            @Override
            public ITextComponent read(final PacketBuffer lllllllllllllllIlIIIlllIllIIlIII) throws IOException {
                return lllllllllllllllIlIIIlllIllIIlIII.readTextComponent();
            }
        };
        OPTIONAL_ITEM_STACK = new DataSerializer<ItemStack>() {
            @Override
            public ItemStack read(final PacketBuffer lIlllIIlIllIlII) throws IOException {
                return lIlllIIlIllIlII.readItemStackFromBuffer();
            }
            
            @Override
            public ItemStack func_192717_a(final ItemStack lIlllIIlIlIlIll) {
                return lIlllIIlIlIlIll.copy();
            }
            
            @Override
            public void write(final PacketBuffer lIlllIIlIlllIIl, final ItemStack lIlllIIlIlllIlI) {
                lIlllIIlIlllIIl.writeItemStackToBuffer(lIlllIIlIlllIlI);
            }
            
            @Override
            public DataParameter<ItemStack> createKey(final int lIlllIIlIlIlllI) {
                return new DataParameter<ItemStack>(lIlllIIlIlIlllI, this);
            }
        };
        OPTIONAL_BLOCK_STATE = new DataSerializer<Optional<IBlockState>>() {
            @Override
            public void write(final PacketBuffer llllllllllllllllIIllIIIlllIIllII, final Optional<IBlockState> llllllllllllllllIIllIIIlllIIlIll) {
                if (llllllllllllllllIIllIIIlllIIlIll.isPresent()) {
                    llllllllllllllllIIllIIIlllIIllII.writeVarIntToBuffer(Block.getStateId((IBlockState)llllllllllllllllIIllIIIlllIIlIll.get()));
                }
                else {
                    llllllllllllllllIIllIIIlllIIllII.writeVarIntToBuffer(0);
                }
            }
            
            @Override
            public Optional<IBlockState> read(final PacketBuffer llllllllllllllllIIllIIIlllIIIlIl) throws IOException {
                final int llllllllllllllllIIllIIIlllIIIllI = llllllllllllllllIIllIIIlllIIIlIl.readVarIntFromBuffer();
                return (Optional<IBlockState>)((llllllllllllllllIIllIIIlllIIIllI == 0) ? Optional.absent() : Optional.of((Object)Block.getStateById(llllllllllllllllIIllIIIlllIIIllI)));
            }
            
            @Override
            public DataParameter<Optional<IBlockState>> createKey(final int llllllllllllllllIIllIIIlllIIIIII) {
                return new DataParameter<Optional<IBlockState>>(llllllllllllllllIIllIIIlllIIIIII, this);
            }
            
            @Override
            public Optional<IBlockState> func_192717_a(final Optional<IBlockState> llllllllllllllllIIllIIIllIlllIlI) {
                return llllllllllllllllIIllIIIllIlllIlI;
            }
        };
        BOOLEAN = new DataSerializer<Boolean>() {
            @Override
            public DataParameter<Boolean> createKey(final int lllllllllllllIIlIlIIlIIlIIllllII) {
                return new DataParameter<Boolean>(lllllllllllllIIlIlIIlIIlIIllllII, this);
            }
            
            @Override
            public Boolean func_192717_a(final Boolean lllllllllllllIIlIlIIlIIlIIlllIIl) {
                return lllllllllllllIIlIlIIlIIlIIlllIIl;
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllIIlIlIIlIIlIlIIlIIl, final Boolean lllllllllllllIIlIlIIlIIlIlIIlIII) {
                lllllllllllllIIlIlIIlIIlIlIIlIIl.writeBoolean(lllllllllllllIIlIlIIlIIlIlIIlIII);
            }
            
            @Override
            public Boolean read(final PacketBuffer lllllllllllllIIlIlIIlIIlIlIIIIll) throws IOException {
                return lllllllllllllIIlIlIIlIIlIlIIIIll.readBoolean();
            }
        };
        ROTATIONS = new DataSerializer<Rotations>() {
            @Override
            public Rotations read(final PacketBuffer lllllllllllllIlIIIlIIlIIlllIllIl) throws IOException {
                return new Rotations(lllllllllllllIlIIIlIIlIIlllIllIl.readFloat(), lllllllllllllIlIIIlIIlIIlllIllIl.readFloat(), lllllllllllllIlIIIlIIlIIlllIllIl.readFloat());
            }
            
            @Override
            public Rotations func_192717_a(final Rotations lllllllllllllIlIIIlIIlIIlllIIIlI) {
                return lllllllllllllIlIIIlIIlIIlllIIIlI;
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllIlIIIlIIlIIllllIIIl, final Rotations lllllllllllllIlIIIlIIlIIllllIIlI) {
                lllllllllllllIlIIIlIIlIIllllIIIl.writeFloat(lllllllllllllIlIIIlIIlIIllllIIlI.getX());
                lllllllllllllIlIIIlIIlIIllllIIIl.writeFloat(lllllllllllllIlIIIlIIlIIllllIIlI.getY());
                lllllllllllllIlIIIlIIlIIllllIIIl.writeFloat(lllllllllllllIlIIIlIIlIIllllIIlI.getZ());
            }
            
            @Override
            public DataParameter<Rotations> createKey(final int lllllllllllllIlIIIlIIlIIlllIIllI) {
                return new DataParameter<Rotations>(lllllllllllllIlIIIlIIlIIlllIIllI, this);
            }
        };
        BLOCK_POS = new DataSerializer<BlockPos>() {
            @Override
            public DataParameter<BlockPos> createKey(final int llllllllllllIlllIIIIIlIllIIIlIII) {
                return new DataParameter<BlockPos>(llllllllllllIlllIIIIIlIllIIIlIII, this);
            }
            
            @Override
            public BlockPos read(final PacketBuffer llllllllllllIlllIIIIIlIllIIIllIl) throws IOException {
                return llllllllllllIlllIIIIIlIllIIIllIl.readBlockPos();
            }
            
            @Override
            public BlockPos func_192717_a(final BlockPos llllllllllllIlllIIIIIlIllIIIIIll) {
                return llllllllllllIlllIIIIIlIllIIIIIll;
            }
            
            @Override
            public void write(final PacketBuffer llllllllllllIlllIIIIIlIllIIlIIll, final BlockPos llllllllllllIlllIIIIIlIllIIlIIlI) {
                llllllllllllIlllIIIIIlIllIIlIIll.writeBlockPos(llllllllllllIlllIIIIIlIllIIlIIlI);
            }
        };
        OPTIONAL_BLOCK_POS = new DataSerializer<Optional<BlockPos>>() {
            @Override
            public void write(final PacketBuffer lllllllllllIIIllIIllIIIIlIlllIlI, final Optional<BlockPos> lllllllllllIIIllIIllIIIIlIlllIll) {
                lllllllllllIIIllIIllIIIIlIlllIlI.writeBoolean(lllllllllllIIIllIIllIIIIlIlllIll.isPresent());
                if (lllllllllllIIIllIIllIIIIlIlllIll.isPresent()) {
                    lllllllllllIIIllIIllIIIIlIlllIlI.writeBlockPos((BlockPos)lllllllllllIIIllIIllIIIIlIlllIll.get());
                }
            }
            
            @Override
            public DataParameter<Optional<BlockPos>> createKey(final int lllllllllllIIIllIIllIIIIlIllIIIl) {
                return new DataParameter<Optional<BlockPos>>(lllllllllllIIIllIIllIIIIlIllIIIl, this);
            }
            
            @Override
            public Optional<BlockPos> read(final PacketBuffer lllllllllllIIIllIIllIIIIlIllIllI) throws IOException {
                return (Optional<BlockPos>)(lllllllllllIIIllIIllIIIIlIllIllI.readBoolean() ? Optional.of((Object)lllllllllllIIIllIIllIIIIlIllIllI.readBlockPos()) : Optional.absent());
            }
            
            @Override
            public Optional<BlockPos> func_192717_a(final Optional<BlockPos> lllllllllllIIIllIIllIIIIlIlIlIll) {
                return lllllllllllIIIllIIllIIIIlIlIlIll;
            }
        };
        FACING = new DataSerializer<EnumFacing>() {
            @Override
            public EnumFacing read(final PacketBuffer lllllllllllIlllIlIllllIllIIIIlII) throws IOException {
                return lllllllllllIlllIlIllllIllIIIIlII.readEnumValue(EnumFacing.class);
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllIlllIlIllllIllIIIlIlI, final EnumFacing lllllllllllIlllIlIllllIllIIIIlll) {
                lllllllllllIlllIlIllllIllIIIlIlI.writeEnumValue(lllllllllllIlllIlIllllIllIIIIlll);
            }
            
            @Override
            public DataParameter<EnumFacing> createKey(final int lllllllllllIlllIlIllllIlIlllllIl) {
                return new DataParameter<EnumFacing>(lllllllllllIlllIlIllllIlIlllllIl, this);
            }
            
            @Override
            public EnumFacing func_192717_a(final EnumFacing lllllllllllIlllIlIllllIlIllllIIl) {
                return lllllllllllIlllIlIllllIlIllllIIl;
            }
        };
        OPTIONAL_UNIQUE_ID = new DataSerializer<Optional<UUID>>() {
            @Override
            public Optional<UUID> read(final PacketBuffer llllllllllIllllIIIIIlIllIllllIII) throws IOException {
                return (Optional<UUID>)(llllllllllIllllIIIIIlIllIllllIII.readBoolean() ? Optional.of((Object)llllllllllIllllIIIIIlIllIllllIII.readUuid()) : Optional.absent());
            }
            
            @Override
            public void write(final PacketBuffer llllllllllIllllIIIIIlIllIlllllII, final Optional<UUID> llllllllllIllllIIIIIlIllIlllllIl) {
                llllllllllIllllIIIIIlIllIlllllII.writeBoolean(llllllllllIllllIIIIIlIllIlllllIl.isPresent());
                if (llllllllllIllllIIIIIlIllIlllllIl.isPresent()) {
                    llllllllllIllllIIIIIlIllIlllllII.writeUuid((UUID)llllllllllIllllIIIIIlIllIlllllIl.get());
                }
            }
            
            @Override
            public DataParameter<Optional<UUID>> createKey(final int llllllllllIllllIIIIIlIllIlllIIIl) {
                return new DataParameter<Optional<UUID>>(llllllllllIllllIIIIIlIllIlllIIIl, this);
            }
            
            @Override
            public Optional<UUID> func_192717_a(final Optional<UUID> llllllllllIllllIIIIIlIllIllIllIl) {
                return llllllllllIllllIIIIIlIllIllIllIl;
            }
        };
        field_192734_n = new DataSerializer<NBTTagCompound>() {
            @Override
            public DataParameter<NBTTagCompound> createKey(final int llllllllllllIIllllllIIIlIlIlIllI) {
                return new DataParameter<NBTTagCompound>(llllllllllllIIllllllIIIlIlIlIllI, this);
            }
            
            @Override
            public void write(final PacketBuffer llllllllllllIIllllllIIIlIllIIIIl, final NBTTagCompound llllllllllllIIllllllIIIlIllIIIII) {
                llllllllllllIIllllllIIIlIllIIIIl.writeNBTTagCompoundToBuffer(llllllllllllIIllllllIIIlIllIIIII);
            }
            
            @Override
            public NBTTagCompound read(final PacketBuffer llllllllllllIIllllllIIIlIlIllIll) throws IOException {
                return llllllllllllIIllllllIIIlIlIllIll.readNBTTagCompoundFromBuffer();
            }
            
            @Override
            public NBTTagCompound func_192717_a(final NBTTagCompound llllllllllllIIllllllIIIlIlIlIIII) {
                return llllllllllllIIllllllIIIlIlIlIIII.copy();
            }
        };
        registerSerializer(DataSerializers.BYTE);
        registerSerializer(DataSerializers.VARINT);
        registerSerializer(DataSerializers.FLOAT);
        registerSerializer(DataSerializers.STRING);
        registerSerializer(DataSerializers.TEXT_COMPONENT);
        registerSerializer(DataSerializers.OPTIONAL_ITEM_STACK);
        registerSerializer(DataSerializers.BOOLEAN);
        registerSerializer(DataSerializers.ROTATIONS);
        registerSerializer(DataSerializers.BLOCK_POS);
        registerSerializer(DataSerializers.OPTIONAL_BLOCK_POS);
        registerSerializer(DataSerializers.FACING);
        registerSerializer(DataSerializers.OPTIONAL_UNIQUE_ID);
        registerSerializer(DataSerializers.OPTIONAL_BLOCK_STATE);
        registerSerializer(DataSerializers.field_192734_n);
    }
    
    @Nullable
    public static DataSerializer<?> getSerializer(final int lllllllllllllIIIIlIlIlIllIIlllII) {
        return DataSerializers.REGISTRY.get(lllllllllllllIIIIlIlIlIllIIlllII);
    }
    
    public static void registerSerializer(final DataSerializer<?> lllllllllllllIIIIlIlIlIllIlIIIII) {
        DataSerializers.REGISTRY.add(lllllllllllllIIIIlIlIlIllIlIIIII);
    }
}
