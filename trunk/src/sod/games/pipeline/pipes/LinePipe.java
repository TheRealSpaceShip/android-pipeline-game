package sod.games.pipeline.pipes;

import sod.games.pipeline.Direction;

public class LinePipe extends BasePipe {
	static private boolean D = true;
	static private String TAG = "LinePipe";
	public LinePipe(){
		super();
		connectors.add(new Direction[]{Direction.North, Direction.South});
	}
	
	@Override
	public PipeType getType() {
		return PipeType.Line;
	}
}
