package sod.games.pipeline.pipes;

public class DoubleCornerPipe extends BasePipe {
	public DoubleCornerPipe(int[] position_){
		super(position_);
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
		connectors.add(new Pair<Side,Side>(Side.West, Side.South));
	}
	@Override
	public PipeType getType() {
		return PipeType.DoubleCorner;
	}
}
