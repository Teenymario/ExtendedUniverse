package teenymario123.extuniverse.objects.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import teenymario123.extuniverse.init.*;

public class engines extends CreativeTabs {
    public engines() {
        super("engines");
        this.hasSearchBar();
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(itemInit.ENGINE_PLATE);
    }
}
