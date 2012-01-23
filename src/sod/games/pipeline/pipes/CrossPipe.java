package sod.games.pipeline.pipes;

public class CrossPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "CornerPipe";
	public CrossPipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.South));
		connectors.add(new Pair<Side,Side>(Side.West, Side.East));
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Cross;
	}
}
