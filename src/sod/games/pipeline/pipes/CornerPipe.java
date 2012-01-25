package sod.games.pipeline.pipes;

public class CornerPipe extends BasePipe{
	static private boolean D = true;
	static private String TAG = "CornerPipe";
	
	public CornerPipe(){
		super();
		connectors.add(new Direction[]{Direction.North, Direction.East});
	}

	@Override
	public PipeType getType() {
		return PipeType.Corner;
	}

}
