package sod.games.pipeline.pipes;

public class CornerPipe extends BasePipe{
	
	public CornerPipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
	}

}
