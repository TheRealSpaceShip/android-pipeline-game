package sod.games.pipeline.pipes;

public class CrossPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "CornerPipe";
	public CrossPipe(){
		super();
		connectors.add(new Pair<Direction,Direction>(Direction.North, Direction.South));
		connectors.add(new Pair<Direction,Direction>(Direction.West, Direction.East));
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Cross;
	}
}
