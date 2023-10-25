package teenymario123.extuniverse.objects.blocks;

import net.minecraft.block.*;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import teenymario123.extuniverse.objects.tileEntity.basicEngineTE;
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

import java.util.Random;

import static net.minecraft.block.BlockHopper.ENABLED;
import static teenymario123.extuniverse.util.statics.THROTTLE;

@SuppressWarnings("deprecation")
public class blockBase extends BlockDirectional implements IHasModel, ITileEntityProvider {

    public blockBase(String name, Material material) {
        super(material);
        this.fullBlock = false;
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(FACING, EnumFacing.NORTH)
                .withProperty(ENABLED, false)
                .withProperty(THROTTLE, 0));
        setRegistryName(name);
        setTranslationKey(name);
        this.setTickRandomly(true);
        setCreativeTab(main.ENGINES_TAB);
        blockInit.BLOCKS.add(this);
        itemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    //Rotations
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
                .withProperty(FACING, EnumFacing.byIndex(meta & 7))
                .withProperty(ENABLED, (meta & 8) != 0)
                .withProperty(THROTTLE, (meta >> 3) & 15);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex() + (state.getValue(ENABLED) ? 8 : 0) + (state.getValue(THROTTLE) << 3);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, ENABLED, THROTTLE);
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

    //Engine activation
    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos p_189540_5_) {
        world.setBlockState(pos, state.withProperty(ENABLED, world.isBlockPowered(pos)), 3);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if(stateIn.getValue(ENABLED)) {
            EnumFacing enumfacing = stateIn.getValue(FACING);
            String dir = enumfacing.getName();
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.0D;
            double d2 = (double) pos.getZ() + 0.5D;

            switch (dir) {
                case "up":
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, -1.0D, 0.0D);
                    break;
                case "down":
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 1.0D, d2, 0.0D, 1.0D, 0.0D);
                    break;
                case "east":
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + 0.5D, d1 + 0.5D, d2, 1.0D, 0.0D, 0.0D);
                    break;
                case "west":
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - 0.5D, d1 + 0.5D, d2, -1.0D, 0.0D, 0.0D);
                    break;
                case "north":
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.5D, d2 - 0.5D, 0.0D, 0.0D, -1.0D);
                    break;
                default:
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.5D, d2 + 0.5D, 0.0D, 0.0D, 1.0D);
                    break;
            }
        }
    }
    //Engine activation

    //Tile entity
    private basicEngineTE getTE(World worldIn, BlockPos pos) {
        return (basicEngineTE) worldIn.getTileEntity(pos);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new basicEngineTE();
    }
    //Tile entity

    //Model registration
    @Override
    public void registerModels() {
        main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
