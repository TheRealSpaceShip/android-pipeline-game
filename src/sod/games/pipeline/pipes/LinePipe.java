package sod.games.pipeline.pipes;

public class LinePipe extends BasePipe {
	public LinePipe(int[] position_){
		super(position_);
		connectors.add(new Pair<Side,Side>(Side.West, Side.East));
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Line;
	}
}
