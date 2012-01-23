package sod.games.pipeline.pipes;

public class DoubleCornerPipe extends BasePipe {
	public DoubleCornerPipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.East));
		connectors.add(new Pair<Side,Side>(Side.West, Side.South));
	}

}
