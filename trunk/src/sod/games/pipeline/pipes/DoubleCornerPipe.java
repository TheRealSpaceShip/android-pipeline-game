package sod.games.pipeline.pipes;

public class DoubleCornerPipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "DoubleCornerPipe";
	public DoubleCornerPipe(){
		super();
		connectors.add(new Direction[]{Direction.North, Direction.East});
		connectors.add(new Direction[]{Direction.West, Direction.South});
	}
	@Override
	public PipeType getType() {
		return PipeType.DoubleCorner;
	}
}
