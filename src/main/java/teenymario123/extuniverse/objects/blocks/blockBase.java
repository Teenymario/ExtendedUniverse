package teenymario123.extuniverse.objects.blocks;

import net.minecraft.block.*;
import teenymario123.extuniverse.util.interfaces.*;
import net.minecraft.block.material.*;
import teenymario123.extuniverse.init.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.relauncher.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import teenymario123.extuniverse.*;

public class blockBase extends Block implements IHasModel {

    public blockBase(String name, Material material) {
        super(material);
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(main.ENGINES_TAB);
        blockInit.BLOCKS.add(this);
        itemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }
    
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }
    
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @Override
    public void registerModels() {
        main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
