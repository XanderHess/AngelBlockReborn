package eu.xandr.angelblockreborn;

import eu.xandr.angelblockreborn.block.AngelBlockBlock;
import eu.xandr.angelblockreborn.item.AngelBlockItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(AngelBlockReborn.MODID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(AngelBlockReborn.MODID);

    public static final DeferredBlock<Block> ANGEL_BLOCK_BLOCK = BLOCKS.register("angel_block",
            () -> new AngelBlockBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("angelblockreborn:angel_block")))
                    .mapColor(MapColor.DEEPSLATE)
                    .sound(SoundType.AMETHYST)
                    .instabreak()
                    .explosionResistance(0))
    );

    public static final DeferredItem<Item> ANGEL_BLOCK_ITEM = ITEMS.register("angel_block",
            () -> new AngelBlockItem(ANGEL_BLOCK_BLOCK.get(), new Item.Properties().setId(ResourceKey.create(
                    Registries.ITEM, ResourceLocation.parse("angelblockreborn:angel_block")
            ))));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
