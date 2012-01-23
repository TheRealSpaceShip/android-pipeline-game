package sod.games.pipeline.pipes;

public class DoubleCornerPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "DoubleCornerPipe";
	public DoubleCornerPipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
		connectors.add(new Pair<Side,Side>(Side.West, Side.South));
	}
	@Override
	public PipeType getType() {
		return PipeType.DoubleCorner;
	}
}
