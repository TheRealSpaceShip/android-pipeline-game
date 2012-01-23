package sod.games.pipeline.pipes;

public class CrossPipe extends BasePipe {
	public CrossPipe()
	{
		super();
		connectors.add(new Pair<Side,Side>(Side.North, Side.South));
		connectors.add(new Pair<Side,Side>(Side.West, Side.East));
	}
}
