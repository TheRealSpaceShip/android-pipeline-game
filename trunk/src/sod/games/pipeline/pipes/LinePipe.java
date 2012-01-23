package sod.games.pipeline.pipes;

public class LinePipe extends BasePipe {
	public LinePipe(){
		super();
		connectors.add(new Pair<Side,Side>(Side.West, Side.East));
	}
	
}
