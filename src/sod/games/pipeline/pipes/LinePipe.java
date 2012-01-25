package sod.games.pipeline.pipes;

public class LinePipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "LinePipe";
	public LinePipe(){
		super();
		connectors.add(new Pair<Direction,Direction>(Direction.West, Direction.East));
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Line;
	}
}
