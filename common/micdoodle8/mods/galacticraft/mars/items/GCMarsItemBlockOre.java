package micdoodle8.mods.galacticraft.mars.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class GCMarsItemBlockOre extends ItemBlock
{
    public GCMarsItemBlockOre(int i)
    {
        super(i);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "";

        switch (itemstack.getItemDamage())
        {
        case 0:
        {
            name = "desh";
            break;
        }
        case 1:
        {
            name = "quandrium";
            break;
        }
        case 2:
        {
            name = "aluminummars";
            break;
        }
        case 3:
        {
            name = "coppermars";
            break;
        }
        case 4:
        {
            name = "titaniummars";
            break;
        }
        default:
            name = "null";
        }
        return this.getUnlocalizedName() + "." + name;
    }
}
