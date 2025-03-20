package eu.xandr.angelblockreborn.item;

import eu.xandr.angelblockreborn.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class AngelBlockItem extends BlockItem {
    public AngelBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public @NotNull InteractionResult use(Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            double x = pPlayer.getX() + pPlayer.getLookAngle().x * 4.5;
            double y = pPlayer.getEyeY() + pPlayer.getLookAngle().y * 4.5;
            double z = pPlayer.getZ() + pPlayer.getLookAngle().z * 4.5;
            BlockPos pos = new BlockPos((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));

            if (pLevel.isInWorldBounds(pos) && pLevel.getBlockState(pos).canBeReplaced()) {
                pLevel.setBlock(pos, BlockRegistry.ANGEL_BLOCK_BLOCK.get().defaultBlockState(), 3);
                if (!pPlayer.isCreative()) {
                    if (pUsedHand == InteractionHand.MAIN_HAND) {
                        pPlayer.getInventory().removeFromSelected(false);
                    } else {
                        pPlayer.getInventory().removeItem(Inventory.SLOT_OFFHAND, 1);
                    }
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}