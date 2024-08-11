package net.dofi.flintknife.block;

import net.dofi.flintknife.FlintKnife;
import net.dofi.flintknife.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block FLINT_BLOCK = registerBlock("flint_block",
            new Block(AbstractBlock.Settings.copy(Blocks.COAL_BLOCK).strength(1.5F, 6.0F).sounds(BlockSoundGroup.DEEPSLATE)));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(FLINT_BLOCK);
    }


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FlintKnife.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(FlintKnife.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FlintKnife.LOGGER.info("Registering ModBlocks for " + FlintKnife.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToIngredientItemGroup);
    }
}
