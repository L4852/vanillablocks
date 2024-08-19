package com.github.l4852.vanillablocks.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class FlushWallBlock extends Block {
    public static final DirectionProperty FACING = DirectionProperty.of("facing");

    public FlushWallBlock(Settings settings) {
        super(Settings.copy(Blocks.STONE).nonOpaque().requiresTool());
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);

        switch (direction) {
            case NORTH -> {
                return VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.5);
            }
            case SOUTH -> {
                return VoxelShapes.cuboid(0, 0, 0.5, 1, 1, 1);
            }
            case EAST -> {
                return VoxelShapes.cuboid(0.5, 0, 0, 1, 1, 1);
            }
            case WEST -> {
                return VoxelShapes.cuboid(0, 0, 0, 0.5, 1, 1);
            }
            default -> {
                return VoxelShapes.empty();
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
