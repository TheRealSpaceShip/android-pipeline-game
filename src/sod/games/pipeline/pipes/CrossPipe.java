package sod.games.pipeline.pipes;

public class CrossPipe extends BasePipe {
	public CrossPipe(int[] position_){
		super(position_);
		connectors.add(new Pair<Side,Side>(Side.North, Side.South));
		connectors.add(new Pair<Side,Side>(Side.West, Side.East));
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Cross;
	}
}
