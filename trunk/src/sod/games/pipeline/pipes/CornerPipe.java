package sod.games.pipeline.pipes;

public class CornerPipe extends BasePipe{
	static private boolean D = true;
	static private String TAG = "CornerPipe";
	
	public CornerPipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
	}

	@Override
	public PipeType getType() {
		return PipeType.Corner;
	}

}
