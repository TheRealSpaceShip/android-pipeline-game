package sod.games.pipeline.pipes;

public class CornerPipe extends BasePipe{
	
	public CornerPipe(int[] position_){
		super(position_);
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
	}

	@Override
	public PipeType getType() {
		return PipeType.Corner;
	}

}
