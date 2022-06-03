// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.vertex;

import optifine.Reflector;
import shadersmod.client.SVertexFormat;
import optifine.Config;

public class DefaultVertexFormats
{
    public static final /* synthetic */ VertexFormatElement COLOR_4UB;
    public static final /* synthetic */ VertexFormatElement NORMAL_3B;
    public static final /* synthetic */ VertexFormat POSITION_TEX_NORMAL;
    public static final /* synthetic */ VertexFormat POSITION_NORMAL;
    private static final /* synthetic */ VertexFormat ITEM_VANILLA;
    public static final /* synthetic */ VertexFormat POSITION_TEX_LMAP_COLOR;
    public static final /* synthetic */ VertexFormatElement TEX_2S;
    public static final /* synthetic */ VertexFormat POSITION_TEX;
    public static final /* synthetic */ VertexFormat PARTICLE_POSITION_TEX_COLOR_LMAP;
    public static /* synthetic */ VertexFormat BLOCK;
    public static final /* synthetic */ VertexFormat POSITION;
    public static final /* synthetic */ VertexFormatElement PADDING_1B;
    public static final /* synthetic */ VertexFormat POSITION_COLOR;
    public static final /* synthetic */ VertexFormat OLDMODEL_POSITION_TEX_NORMAL;
    public static final /* synthetic */ VertexFormat POSITION_TEX_COLOR;
    public static final /* synthetic */ VertexFormatElement TEX_2F;
    public static final /* synthetic */ VertexFormat POSITION_TEX_COLOR_NORMAL;
    private static final /* synthetic */ VertexFormat BLOCK_VANILLA;
    public static final /* synthetic */ VertexFormatElement POSITION_3F;
    public static /* synthetic */ VertexFormat ITEM;
    
    public static void updateVertexFormats() {
        if (Config.isShaders()) {
            DefaultVertexFormats.BLOCK = SVertexFormat.makeDefVertexFormatBlock();
            DefaultVertexFormats.ITEM = SVertexFormat.makeDefVertexFormatItem();
        }
        else {
            DefaultVertexFormats.BLOCK = DefaultVertexFormats.BLOCK_VANILLA;
            DefaultVertexFormats.ITEM = DefaultVertexFormats.ITEM_VANILLA;
        }
        if (Reflector.Attributes_DEFAULT_BAKED_FORMAT.exists()) {
            final VertexFormat llllllllllllIlIIIIIIIIIllllIIIIl = DefaultVertexFormats.ITEM;
            final VertexFormat llllllllllllIlIIIIIIIIIllllIIIII = (VertexFormat)Reflector.getFieldValue(Reflector.Attributes_DEFAULT_BAKED_FORMAT);
            llllllllllllIlIIIIIIIIIllllIIIII.clear();
            for (int llllllllllllIlIIIIIIIIIlllIlllll = 0; llllllllllllIlIIIIIIIIIlllIlllll < llllllllllllIlIIIIIIIIIllllIIIIl.getElementCount(); ++llllllllllllIlIIIIIIIIIlllIlllll) {
                llllllllllllIlIIIIIIIIIllllIIIII.addElement(llllllllllllIlIIIIIIIIIllllIIIIl.getElement(llllllllllllIlIIIIIIIIIlllIlllll));
            }
        }
    }
    
    static {
        DefaultVertexFormats.BLOCK = new VertexFormat();
        DefaultVertexFormats.ITEM = new VertexFormat();
        BLOCK_VANILLA = DefaultVertexFormats.BLOCK;
        ITEM_VANILLA = DefaultVertexFormats.ITEM;
        OLDMODEL_POSITION_TEX_NORMAL = new VertexFormat();
        PARTICLE_POSITION_TEX_COLOR_LMAP = new VertexFormat();
        POSITION = new VertexFormat();
        POSITION_COLOR = new VertexFormat();
        POSITION_TEX = new VertexFormat();
        POSITION_NORMAL = new VertexFormat();
        POSITION_TEX_COLOR = new VertexFormat();
        POSITION_TEX_NORMAL = new VertexFormat();
        POSITION_TEX_LMAP_COLOR = new VertexFormat();
        POSITION_TEX_COLOR_NORMAL = new VertexFormat();
        POSITION_3F = new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3);
        COLOR_4UB = new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.COLOR, 4);
        TEX_2F = new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2);
        TEX_2S = new VertexFormatElement(1, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.UV, 2);
        NORMAL_3B = new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3);
        PADDING_1B = new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1);
        DefaultVertexFormats.BLOCK.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.BLOCK.addElement(DefaultVertexFormats.COLOR_4UB);
        DefaultVertexFormats.BLOCK.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.BLOCK.addElement(DefaultVertexFormats.TEX_2S);
        DefaultVertexFormats.ITEM.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.ITEM.addElement(DefaultVertexFormats.COLOR_4UB);
        DefaultVertexFormats.ITEM.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.ITEM.addElement(DefaultVertexFormats.NORMAL_3B);
        DefaultVertexFormats.ITEM.addElement(DefaultVertexFormats.PADDING_1B);
        DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.NORMAL_3B);
        DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.PADDING_1B);
        DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(DefaultVertexFormats.COLOR_4UB);
        DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(DefaultVertexFormats.TEX_2S);
        DefaultVertexFormats.POSITION.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_COLOR.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_COLOR.addElement(DefaultVertexFormats.COLOR_4UB);
        DefaultVertexFormats.POSITION_TEX.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_TEX.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.POSITION_NORMAL.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_NORMAL.addElement(DefaultVertexFormats.NORMAL_3B);
        DefaultVertexFormats.POSITION_NORMAL.addElement(DefaultVertexFormats.PADDING_1B);
        DefaultVertexFormats.POSITION_TEX_COLOR.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_TEX_COLOR.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.POSITION_TEX_COLOR.addElement(DefaultVertexFormats.COLOR_4UB);
        DefaultVertexFormats.POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.NORMAL_3B);
        DefaultVertexFormats.POSITION_TEX_NORMAL.addElement(DefaultVertexFormats.PADDING_1B);
        DefaultVertexFormats.POSITION_TEX_LMAP_COLOR.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_TEX_LMAP_COLOR.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.POSITION_TEX_LMAP_COLOR.addElement(DefaultVertexFormats.TEX_2S);
        DefaultVertexFormats.POSITION_TEX_LMAP_COLOR.addElement(DefaultVertexFormats.COLOR_4UB);
        DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL.addElement(DefaultVertexFormats.POSITION_3F);
        DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL.addElement(DefaultVertexFormats.TEX_2F);
        DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL.addElement(DefaultVertexFormats.COLOR_4UB);
        DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL.addElement(DefaultVertexFormats.NORMAL_3B);
        DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL.addElement(DefaultVertexFormats.PADDING_1B);
    }
}
