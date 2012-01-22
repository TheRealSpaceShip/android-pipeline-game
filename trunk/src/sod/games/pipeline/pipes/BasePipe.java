package sod.games.pipeline.pipes;

import java.util.ArrayList;

abstract class BasePipe implements Pipe {
	protected ArrayList<Pair<Side, Side>> connectors;

	protected BasePipe(){
		connectors = new ArrayList<Pair<Side, Side>>();
	}
	
	@Override
	public ArrayList<Pair<Side, Side>> getConnectors() {
		
		return connectors;
	}

	@Override
	public void rotate() {
		for (Pair<Side, Side> connector : connectors){
			connector.setFirst(cwRotate(connector.getFirst()));
			connector.setSecond(cwRotate(connector.getSecond()));
		}
	}
	
	private Side cwRotate(Side side){
		switch(side){
		case North:
			return Side.East;
		case East:
			return Side.South;
		case South:
			return Side.West;
		case West:
			return Side.North;
		}
		return null;
	}
	
	
	
}
