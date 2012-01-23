package sod.games.pipeline.pipes;

public class LinePipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "LinePipe";
	public LinePipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.West, Side.East));
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Line;
	}
}
