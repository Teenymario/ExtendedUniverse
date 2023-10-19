package teenymario123.extuniverse.objects.blocks;

import net.minecraft.block.*;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.entity.EntityLivingBase;
import teenymario123.extuniverse.util.interfaces.*;
import net.minecraft.block.material.*;
import teenymario123.extuniverse.init.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.relauncher.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import teenymario123.extuniverse.*;

@SuppressWarnings("deprecation")
public class blockBase extends BlockDirectional implements IHasModel {

    public blockBase(String name, Material material) {
        super(material);
        this.fullBlock = false;
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(main.ENGINES_TAB);
        blockInit.BLOCKS.add(this);
        itemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    //Rotations
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }


    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byIndex(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, facing);
    }
    //Rotations

    //Block rendering
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    //Block rendering

    //Model registration
    @Override
    public void registerModels() {
        main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
